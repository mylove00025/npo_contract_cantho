/**
 * 
 */
package com.osp.npo.app.action;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.osp.npo.app.context.AnnouncementContext;
import com.osp.npo.app.form.AnnouncementListForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.AnnouncementListViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.core.announcement.AnnouncementInfo;
import com.osp.npo.core.announcement.AnnouncementList;
import com.osp.npo.service.AnnouncementService;

/**
 * @author PhuongNT
 * @author SonHD
 * @version $Revision: 21537 $
 */
public class AnnouncementListAction extends BaseMDAction {
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final Integer FIRST_PAGE = 1;
    private static final String NO_LOGIN = "nologin";
    private static final String ORDER_FIELD_ANNOUNCEMENT = "send_date_time";
    private static final Byte ANNOUNCEMENT_TYPE = 0;

    public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        createTitle(Constants.SCREEN_ANNT001);

        HttpSession session = request.getSession();

        // delete session
        if (session.getAttribute(AnnouncementListViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(AnnouncementListViewHelper.SESSION_KEY);
        }
        if (session.getAttribute(AnnouncementContext.SESSION_KEY) != null) {
            session.removeAttribute(AnnouncementContext.SESSION_KEY);
        }
        AnnouncementListViewHelper announcementListViewHelper = new AnnouncementListViewHelper();
        AnnouncementContext announcementContext = new AnnouncementContext();
        saveDataList(announcementListViewHelper, announcementContext, null);

        session.setAttribute(AnnouncementListViewHelper.SESSION_KEY, announcementListViewHelper);
        session.setAttribute(AnnouncementContext.SESSION_KEY, announcementContext);
        return mapping.findForward(SUCCESS);
    }

    @SuppressWarnings("unchecked")
    private void saveDataList(AnnouncementListViewHelper announcementListViewHelper, AnnouncementContext context, String direction)
            throws SQLException, IOException {

        AnnouncementService announcementService = new AnnouncementService(getConnection());

        // set search filter
        setSearchFilter(context, announcementService);

        announcementListViewHelper.setAnnouncementList(null);

        Integer totalCount = announcementService.countTotalAnnouncement();
        announcementListViewHelper.setTotalCount(totalCount);

        if (totalCount != 0) {
            Integer totalPage = pageCalculation(totalCount, getLineMax());
            announcementListViewHelper.setTotalPage(totalPage);
            announcementListViewHelper.setPage(pageTransition(direction, announcementListViewHelper.getPage(), totalPage));
            announcementService.addOrderFieldAnnouncement(new OrderField(ORDER_FIELD_ANNOUNCEMENT, OrderType.DESC));
            AnnouncementList announcementList = announcementService.queryAnnouncement(false, announcementListViewHelper.getPage(), getLineMax());
            announcementListViewHelper.setAnnouncementList(announcementList.getList());
        }
    }

    private void setSearchFilter(AnnouncementContext context, AnnouncementService service) {
    	service.setKindFilter(ANNOUNCEMENT_TYPE);
        if (context.getAnnouncementTitleFilter() != null && context.getAnnouncementTitleFilter().trim().length() > 0) {
            service.setTitleFilter(context.getAnnouncementTitleFilter().trim(), FilterKind.MIDDLE);
        }
    }

    public ActionForward search(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        AnnouncementListForm announcementListForm = (AnnouncementListForm) form;

        HttpSession session = request.getSession();
        AnnouncementListViewHelper announcementListViewHelper = (AnnouncementListViewHelper) session
                .getAttribute(AnnouncementListViewHelper.SESSION_KEY);
        AnnouncementContext announcementContext = (AnnouncementContext) session.getAttribute(AnnouncementContext.SESSION_KEY);
        
        if (announcementListViewHelper != null && announcementListViewHelper != null) {
            announcementListViewHelper.reset(announcementListForm);
            announcementListViewHelper.setChkID(announcementListForm.getChkID());
            announcementContext.clear();                       
            setContext(announcementContext, announcementListForm, announcementListViewHelper);
            announcementContext.setAnnouncementTitleFilter(announcementListForm.getAnnouncementTitleFilter());
            announcementListViewHelper.setPage(FIRST_PAGE);
            saveDataList(announcementListViewHelper, announcementContext, null);
        }
        if (announcementListViewHelper.getTotalCount() == 0) {
            MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_announcement_name"));
        }
        return mapping.findForward(SUCCESS);
    }

    public ActionForward paging(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        AnnouncementListForm announcementListForm = (AnnouncementListForm) form;
        HttpSession session = request.getSession();
        AnnouncementListViewHelper announcementListViewHelper = (AnnouncementListViewHelper) session
                .getAttribute(AnnouncementListViewHelper.SESSION_KEY);
        AnnouncementContext announcementContext = (AnnouncementContext) session.getAttribute(AnnouncementContext.SESSION_KEY);
        
        setContext(announcementContext, announcementListForm, announcementListViewHelper);
        if (announcementContext.getChkID() != null && announcementContext.getChkID().length > 0) {
            String[] checkedId = new String[announcementContext.getChkID().length];
            for (int i = 0; i < announcementContext.getChkID().length; i++) {
                checkedId[i] = announcementContext.getChkID()[i];
            }
            announcementListViewHelper.setChkID(checkedId);
        } else {
        	announcementListViewHelper.setChkID(null);
        }
        
        if (announcementListViewHelper != null && announcementContext != null) {
            saveDataList(announcementListViewHelper, announcementContext, announcementListForm.getDirection());
        }

        return mapping.findForward(SUCCESS);
    }

    public ActionForward back(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        AnnouncementListViewHelper announcementListViewHelper = (AnnouncementListViewHelper) session
                .getAttribute(AnnouncementListViewHelper.SESSION_KEY);
        AnnouncementContext announcementContext = (AnnouncementContext) session.getAttribute(AnnouncementContext.SESSION_KEY);
        if (announcementListViewHelper != null && announcementContext != null) {
            setViewHelper(announcementListViewHelper, announcementContext);
            saveDataList(announcementListViewHelper, announcementContext, null);
        } else {
            view(mapping, form, request, response);
        }
        return mapping.findForward(SUCCESS);
    }

    private void setContext(AnnouncementContext context, AnnouncementListForm form, AnnouncementListViewHelper viewHelper) throws SQLException, IOException {
        
        List<String> announcementList = new ArrayList<String>();
        if (context.getChkID() != null && context.getChkID().length > 0) {
            for (String item : context.getChkID()) {
                announcementList.add(item);
            }
        }
        
        if (viewHelper.getAnnouncementList()!= null && 
        		viewHelper.getAnnouncementList().size() > 0) {
        	for (AnnouncementInfo info : viewHelper.getAnnouncementList()) {
        		if (announcementList.contains(info.getAid().toString())) {
        			announcementList.remove(info.getAid().toString());
        		}
			}
        }
        
        if (form.getChkID() != null && form.getChkID().length > 0) {
            for (int i = 0; i < form.getChkID().length; i++) {
                if(!announcementList.contains(form.getChkID()[i].toString())) {
                    announcementList.add(form.getChkID()[i].toString());
                }
            }
        }
        
        context.setChkID(announcementList.toArray(new String[announcementList.size()]));
    }

    private void setViewHelper(AnnouncementListViewHelper viewHelper, AnnouncementContext context) {
        viewHelper.setAnnouncementTitleFilter(context.getAnnouncementTitleFilter());
        viewHelper.setChkID(context.getChkID());
    }

    public ActionForward remove(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {

        AnnouncementListViewHelper helper = (AnnouncementListViewHelper) request.getSession().getAttribute(AnnouncementListViewHelper.SESSION_KEY);
        AnnouncementContext context = (AnnouncementContext) request.getSession().getAttribute(AnnouncementContext.SESSION_KEY);
        if (helper == null) {
            return mapping.findForward(NO_LOGIN);
        }
        try {
            AnnouncementService announcementService = new AnnouncementService(getConnection());
            AnnouncementListForm announcementListForm = (AnnouncementListForm) form;
            if (context != null) {
                setContext(context, announcementListForm, helper);
                setViewHelper(helper, context);
            } else {
                helper.reset(announcementListForm);
            }
            if (helper.getChkID() == null || helper.getChkID().length <= 0) {
                ActionErrors error = new ActionErrors();
                error.add(new MessageUtil().createActionMessages("", "ANNT001_not_selected_announcement"));
                this.addErrors(request, error);
                return mapping.findForward(SUCCESS);
            } else {
                for (String strAnnouncementId : helper.getChkID()) {
                    Long announcementId = Long.parseLong(strAnnouncementId);
                    AnnouncementInfo announcementInfo = announcementService.queryAnnouncementById(false, announcementId);
                    if (announcementInfo.getAttachFileName() != null && announcementInfo.getAttachFilePath() != null) {
                        File file = new File(announcementInfo.getAttachFilePath());
                        file.delete();
                    }
                    announcementService.removeAnnouncement(announcementId);
                }
                
                getConnection().commit();
                helper.setChkID(null);
                context.setChkID(null);
                ActionMessages messages = new ActionMessages();
                messages.add(new MessageUtil().createActionMessages("", request, "msg_delete_success", "item_announcement_name"));
                this.addMessages(request, messages);
                return mapping.findForward(SUCCESS);
            }
        }catch (Exception e) {
            ActionErrors errors = new ActionErrors();
            errors.add(new MessageUtil().createActionMessages("", request, "err_not_exist", "item_announcement_name"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE);
        }
    }
}
