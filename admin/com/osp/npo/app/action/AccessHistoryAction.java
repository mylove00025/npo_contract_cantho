/**
 *
 */
package com.osp.npo.app.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.context.AccessHistoryContext;
import com.osp.npo.app.form.AccessHistoryForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.AccessHistoryViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.core.accessHistory.AccessHistoryList;
import com.osp.npo.core.user.UserList;
import com.osp.npo.service.AccessHistoryService;
import com.osp.npo.service.UserService;

/**
 * @author TruongND
 * @version $Revision: 24842 $
 * 
 */

public class AccessHistoryAction extends BaseMDAction {
	private static final String SUCCESS = "success";
	private static final Integer FIRST_PAGE = 1;
	private static final String ACCESS_DATE_IN_DAY = "01";
	private static final String ACCESS_DATE_IN_WEEK = "02";
	private static final String ACCESS_DATE_IN_MONTH = "03";
	private static final String ACCESS_DATE_IN_YEAR = "04";
	private static final String ACCESS_DATE_IN_RANGE = "05";
	private static final String ORDER_FIELD_ACCESS_YEAR = "nah.execute_date_time";
	private static final String ORDER_ACCOUNT = "account";
	
	/**
	 * <P>
	 * Action for first view
	 * </P>
	 * 
	 * @author Truongnd
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		createTitle(Constants.SCREEN_ADM024);

		HttpSession session = request.getSession();

		// delete session
		if (session.getAttribute(AccessHistoryViewHelper.SESSION_KEY) != null) {
			session.removeAttribute(AccessHistoryViewHelper.SESSION_KEY);
		}

		if (session.getAttribute(AccessHistoryContext.SESSION_KEY) != null) {
			session.removeAttribute(AccessHistoryContext.SESSION_KEY);
		}

		AccessHistoryContext accContext = new AccessHistoryContext();
		session.setAttribute(AccessHistoryContext.SESSION_KEY, accContext);
		AccessHistoryViewHelper accessHistoryViewHelper = new AccessHistoryViewHelper();

		// default search
		accessHistoryViewHelper.setAccessTypeFilter((byte) 2);
		saveDataAccesstList(accessHistoryViewHelper, accContext, null);

		session.setAttribute(AccessHistoryViewHelper.SESSION_KEY,
				accessHistoryViewHelper);

		return mapping.findForward(SUCCESS);
	}

	/**
	 * <P>
	 * Save Contract Data to View Helper
	 * </P>
	 * 
	 * @author SonHD
	 * @param preventListViewHelper
	 * @param context
	 * @param direction
	 */
	@SuppressWarnings("unchecked")
	private void saveDataAccesstList(
			AccessHistoryViewHelper accessHistoryViewHelper,
			AccessHistoryContext context, String direction)
			throws SQLException, IOException {

		AccessHistoryService accessHistoryService = new AccessHistoryService(
				getConnection());

		// set search filter
		setSearchFilter(context, accessHistoryService);

		// user list
		UserService userService = new UserService(getConnection());
		userService.addOrderFieldUser(new OrderField(ORDER_ACCOUNT));
		UserList userList = userService.queryAllUser(false);
		accessHistoryViewHelper.setUserList(userList.getList());

		accessHistoryViewHelper.setAccList(null);

		Integer totalCount = accessHistoryService
				.countTotalAccessHistoryByFilter();
		accessHistoryViewHelper.setTotalCount(totalCount);

		if (totalCount != 0) {
			Integer totalPage = pageCalculation(totalCount, getLineMax());
			accessHistoryViewHelper.setTotalPage(totalPage);
			accessHistoryViewHelper.setPage(pageTransition(direction,
					accessHistoryViewHelper.getPage(), totalPage));
			
			accessHistoryService.addAccessOrderField(new OrderField(ORDER_FIELD_ACCESS_YEAR, OrderType.DESC));
	            
			AccessHistoryList accessHistoryList = accessHistoryService
					.queryAccessHistory(false,
							accessHistoryViewHelper.getPage(), getLineMax());

			accessHistoryViewHelper.setAccList(accessHistoryList.getList());
			if (accessHistoryViewHelper.getAccessTypeFilter() == null) {
				accessHistoryViewHelper.setAccessTypeFilter((byte) 2);
			}

		}
	}

	/**
	 * <P>
	 * Set search filter
	 * </P>
	 * 
	 * @author SonHD
	 * @param context
	 * @param accessHistoryService
	 */
	private void setSearchFilter(AccessHistoryContext context,
			AccessHistoryService accessHistoryService) {

		if (context.getUserIdFilter() != null && context.getUserIdFilter() != 0L) {
			accessHistoryService.setUserIdFilter(context.getUserIdFilter());
		}

		if (context.getAccessTypeFilter() != null) {
			accessHistoryService.setAccessTypeFilter(context.getAccessTypeFilter());
		}

		if (ACCESS_DATE_IN_DAY.equals(context.getAccessDateFilter())) {
			Date date = Calendar.getInstance().getTime();
			accessHistoryService.setAccessDateFromFilter(RelateDateTime
					.toTimestamp(Boolean.TRUE,
							RelateDateTime.toDayMonthYear(date)));
			accessHistoryService.setAccessDateToFilter(RelateDateTime
					.toTimestamp(Boolean.FALSE,
							RelateDateTime.toDayMonthYear(date)));
		}

		if (ACCESS_DATE_IN_WEEK.equals(context.getAccessDateFilter())) {
			Date date = Calendar.getInstance().getTime();
			String fromDate = RelateDateTime.getDateByFirstDayOfWeek(date);
			String toDate = RelateDateTime.getDateByLastDayOfWeek(date);
			accessHistoryService.setAccessDateFromFilter(RelateDateTime
					.toTimestamp(Boolean.TRUE, fromDate));
			accessHistoryService.setAccessDateToFilter(RelateDateTime
					.toTimestamp(Boolean.FALSE, toDate));
			context.setAccessDateFromFilter(fromDate);
			context.setAccessDateToFilter(toDate);
		}

		if (ACCESS_DATE_IN_MONTH.equals(context.getAccessDateFilter())) {
			Date date = Calendar.getInstance().getTime();
			String fromDate = RelateDateTime.getDateByFirstDayOfMonth(date);
			String toDate = RelateDateTime.getDateByLastDayOfMonth(date);
			accessHistoryService.setAccessDateFromFilter(RelateDateTime
					.toTimestamp(Boolean.TRUE, fromDate));
			accessHistoryService.setAccessDateToFilter(RelateDateTime
					.toTimestamp(Boolean.FALSE, toDate));
			context.setAccessDateFromFilter(fromDate);
			context.setAccessDateToFilter(toDate);
		}

		if (ACCESS_DATE_IN_YEAR.equals(context.getAccessDateFilter())) {
			Date date = Calendar.getInstance().getTime();
			String fromDate = RelateDateTime.getDateByFirstDayOfYear(date);
			String toDate = RelateDateTime.getDateByLastDayOfYear(date);
			accessHistoryService.setAccessDateFromFilter(RelateDateTime
					.toTimestamp(Boolean.TRUE, fromDate));
			accessHistoryService.setAccessDateToFilter(RelateDateTime
					.toTimestamp(Boolean.FALSE, toDate));
			context.setAccessDateFromFilter(fromDate);
			context.setAccessDateToFilter(toDate);
		}

		if (ACCESS_DATE_IN_RANGE.equals(context.getAccessDateFilter())) {
			accessHistoryService.setAccessDateFromFilter(RelateDateTime
					.toTimestamp(Boolean.TRUE,
							context.getAccessDateFromFilter()));
			accessHistoryService
					.setAccessDateToFilter(RelateDateTime.toTimestamp(
							Boolean.FALSE, context.getAccessDateToFilter()));
		}
	}

	/**
	 * <P>
	 * Action when click search button
	 * </P>
	 * 
	 * @author SonHD
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		AccessHistoryForm accessHistoryForm = (AccessHistoryForm) form;

		HttpSession session = request.getSession();
		AccessHistoryViewHelper accessHistoryViewHelper = (AccessHistoryViewHelper) session
				.getAttribute(AccessHistoryViewHelper.SESSION_KEY);
		AccessHistoryContext accContext = (AccessHistoryContext) session
				.getAttribute(AccessHistoryContext.SESSION_KEY);

		if (accessHistoryViewHelper != null && accContext != null) {
			accessHistoryViewHelper.reset(accessHistoryForm);
			accContext.clear();
			setContext(accContext, accessHistoryForm);
			accessHistoryViewHelper.setPage(FIRST_PAGE);
			saveDataAccesstList(accessHistoryViewHelper, accContext, null);
		}
		if (accessHistoryViewHelper.getTotalCount() == 0) {
			MessageUtil mu = new MessageUtil();
			saveMessages(request, mu.createActionMessages("", request,
					"msg_data_not_exist", "item_access_history"));
		}

		return mapping.findForward(SUCCESS);
	}

	/**
	 * <P>
	 * Action when paging
	 * </P>
	 * 
	 * @author SonHD
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward paging(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		AccessHistoryForm accessHistoryForm = (AccessHistoryForm) form;

		HttpSession session = request.getSession();
		AccessHistoryViewHelper accessHistoryViewHelper = (AccessHistoryViewHelper) session
				.getAttribute(AccessHistoryViewHelper.SESSION_KEY);
		AccessHistoryContext accContext = (AccessHistoryContext) session
				.getAttribute(AccessHistoryContext.SESSION_KEY);

		if (accessHistoryViewHelper != null && accContext != null) {
			saveDataAccesstList(accessHistoryViewHelper, accContext,
					accessHistoryForm.getDirection());
		}

		return mapping.findForward(SUCCESS);
	}


	/**
	 * <P>
	 * Set data for contract context
	 * </P>
	 * 
	 * @author SonHD
	 * @param context
	 * @param form
	 */
	private void setContext(AccessHistoryContext context, AccessHistoryForm form) {
		context.setUserIdFilter(form.getUserIdFilter());
		context.setAccessDateFilter(form.getExecuteDateTimeFilter());
		context.setAccessTypeFilter(form.getAccessTypeFilter());
		if (ACCESS_DATE_IN_RANGE.equals(form.getExecuteDateTimeFilter())) {
			context.setAccessDateFromFilter(form.getAccessDateFromFilter());
			context.setAccessDateToFilter(form.getAccessDateToFilter());
		}
	}
}
