package com.osp.npo.app.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.context.PreventContext;
import com.osp.npo.app.form.PreventListForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.PreventListViewHelper;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.common.util.EditString;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.core.prevent.DataPreventList;
import com.osp.npo.core.prevent.TransactionPropertyList;
import com.osp.npo.service.CommonService;
import com.osp.npo.service.LucenePreventService;
import com.osp.npo.service.LuceneTransactionPropertyService;
import com.osp.npo.service.PreventService;

/**
 * <P>Action for Prevent List</P>
 * 
 * @author HungPT 
 * @version $Revision: 29790 $
 */
@SuppressWarnings("unchecked")
public class PreventListAction extends BaseMDAction {
   
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final String NO_LOGIN = "nologin";
    private static final String PRV001 = "PRV001";
    private static final String PROPERTY_TYPE_ALL = "00";
    private static final String RELEASE = "02";
    private static final String NOT_RELEASE = "01";
    private static final String ORGIN_KIND_ALL = "00";
    private static final Integer FIRST_PAGE = 1;
    private static final String ORDER_FIELD_NOTARY_DATE = "notary_date";
    private static final String ORDER_FIELD_PREVENT_DATE = "prevent_doc_receive_date";
    private static final String ORDER_FIELD_UPDATE_DATE_TIME = "update_date_time";
    
    private String keyHightLight = "";
    private List<String> subKeyList;
    
    /**
     * <P>Action for first view</P>
     * 
     * @author HungPT 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward view(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        createTitle(PRV001);
        
        HttpSession session = request.getSession();
        
        //delete session
        if (session.getAttribute(PreventListViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(PreventListViewHelper.SESSION_KEY);
        }        
        if (session.getAttribute(PreventContext.SESSION_KEY) != null) {
            session.removeAttribute(PreventContext.SESSION_KEY);
        }
        
        PreventContext preventContext = new PreventContext();
        session.setAttribute(PreventContext.SESSION_KEY, preventContext);
         
        CommonService commonService = new CommonService(getConnection());
        
        PreventListViewHelper preventListViewHelper = new PreventListViewHelper();        
        
        //Set default value for first view
        preventListViewHelper.setPropertyList(commonService.queryAllProperty().getList());
        //preventListViewHelper.setType(PROPERTY_TYPE_LAND);
        //preventListViewHelper.setTypeKeySearch(PROPERTY_TYPE_LAND);
        
        saveDataPreventList(preventListViewHelper, preventContext, null, session);
        saveTransactionPropertyList(preventListViewHelper, preventContext, null, session);
        
        if (preventListViewHelper.getTotalCount() == 0 && preventListViewHelper.getTotalCountProperty() != 0) {
            preventListViewHelper.setDisplayPreventList(Boolean.FALSE);
        }
        
//        BasicDataService basicDataService = new BasicDataService(getConnection());
//        preventListViewHelper.setDistrictList(basicDataService.queryAllDistrict(false).getList());
        
        //luu thoi gian tim kiem phuc vu cho viec in trang ******
    	preventListViewHelper.setSearchTime(new java.util.Date());
    	
        session.setAttribute(PreventListViewHelper.SESSION_KEY, preventListViewHelper);
        
        return mapping.findForward(SUCCESS);
    }  
    
    /**
     * <P>Action for first view</P>
     * 
     * @author HungPT 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward view2(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	 createTitle(PRV001);
    	return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action when click search button</P>
     * 
     * @author HungPT 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward search(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        PreventListForm preventListForm = (PreventListForm)form;
        
        HttpSession session = request.getSession();        
        PreventListViewHelper preventListViewHelper = (PreventListViewHelper)session.getAttribute(PreventListViewHelper.SESSION_KEY);        
        PreventContext preventContext = (PreventContext)session.getAttribute(PreventContext.SESSION_KEY);
        
        if (preventListViewHelper == null || preventContext == null) {
        	return mapping.findForward(NO_LOGIN);
        }
        
        preventListViewHelper.reset(preventListForm);
        preventContext.clear();
        
        CommonContext commonCntx = (CommonContext) session.getAttribute(CommonContext.SESSION_KEY);
		String officeCode = commonCntx.getSystemOfficeAuthorityID();
    
        if (preventListForm.getIsAdvanceSearch()) {
        	boolean check = false;
        	String keySearchForType = "";
        	if (!EditString.isNull(preventListForm.getType())) {
        		keySearchForType = EditString.convertUnicodeToASCII(preventListForm.getType());
        		keySearchForType = EditString.parseKeyForSearch(keySearchForType).trim();
        		if (!"".equals(keySearchForType))            		
        									check = true;
        	}
        	String keySearchForDistrict = ""; 
        	String keySearchForStreet = "";

        	String keySearchForProperty = "";
        	if (!EditString.isNull(preventListForm.getPropertyInfo())) {
        		keySearchForProperty = EditString.convertUnicodeToASCII(preventListForm.getPropertyInfo());
        		keySearchForProperty = EditString.parseKeyForSearch(keySearchForProperty).trim();
        		if (!"".equals(keySearchForProperty))
        									check = true;
        	}
        	String keySearchForOwner = "";
        	if (!EditString.isNull(preventListForm.getOwnerInfo())) {
        		keySearchForOwner = EditString.convertUnicodeToASCII(preventListForm.getOwnerInfo());
        		keySearchForOwner = EditString.parseKeyForSearch(keySearchForOwner).trim();
        		if (!"".equals(keySearchForOwner))
        									check = true;
        	}

            if (!check) {
            	saveDataPreventList(preventListViewHelper, preventContext, null, session);
                saveTransactionPropertyList(preventListViewHelper, preventContext, null, session);
                
                preventListViewHelper.setLuceneSearch(false);
            } else {
				List<String> keySearchList = Arrays.asList(keySearchForType,
						keySearchForDistrict, keySearchForStreet,
						keySearchForProperty, keySearchForOwner);            	
            	
            	preventListViewHelper.setPage(FIRST_PAGE);
				preventListViewHelper.setPageProperty(FIRST_PAGE);
				LucenePreventService lucenePreventService = new LucenePreventService();
				lucenePreventService.searchDataPrevent2(preventListViewHelper, officeCode,
						keySearchList, getLineMax(), FIRST_PAGE);
				LuceneTransactionPropertyService luceneTransactionPropertyService = new LuceneTransactionPropertyService();
				luceneTransactionPropertyService.searchTransactionProperty2(
						preventListViewHelper, officeCode, keySearchList, getLineMax(), FIRST_PAGE);
				preventListViewHelper.setTotalPage(pageCalculation(
						preventListViewHelper.getTotalCount(), getLineMax()));
				preventListViewHelper.setTotalPageProperty(pageCalculation(
						preventListViewHelper.getTotalCountProperty(),
						getLineMax()));
				preventListViewHelper.setIsHidePanelSearch(false);
				preventListViewHelper.setIsAdvanceSearch(true);
				
				preventListViewHelper.setSearchList(keySearchList);
            }

        } else {
        	String keySearch ="";
            if (!EditString.isNull(preventListForm.getKeySearch())) {
            	   preventContext.setKeySearch(preventListForm.getKeySearch());
                   keySearch = EditString.convertUnicodeToASCII(preventListForm.getKeySearch());
            }    
            keySearch = EditString.parseKeyForSearch(keySearch);
        	subKeyList = EditString.parseKeySearch(keySearch);
            if ("".equals(keySearch)||subKeyList.size()==0) {
            	saveDataPreventList(preventListViewHelper, preventContext, null, session);
                saveTransactionPropertyList(preventListViewHelper, preventContext, null, session);
                
                preventListViewHelper.setLuceneSearch(false);
            } else {
                   
			

				getSubKeyForHightLight(subKeyList);
				preventListViewHelper.setPage(FIRST_PAGE);
				preventListViewHelper.setPageProperty(FIRST_PAGE);
				LucenePreventService lucenePreventService = new LucenePreventService();
				lucenePreventService.searchDataPrevent(preventListViewHelper, officeCode,
						subKeyList, getLineMax(), FIRST_PAGE);
				LuceneTransactionPropertyService luceneTransactionPropertyService = new LuceneTransactionPropertyService();
				luceneTransactionPropertyService.searchTransactionProperty(
						preventListViewHelper, officeCode, subKeyList, getLineMax(), FIRST_PAGE);
				preventListViewHelper.setSubkeyList(subKeyList);
				preventListViewHelper.setTotalPage(pageCalculation(
						preventListViewHelper.getTotalCount(), getLineMax()));
				preventListViewHelper.setTotalPageProperty(pageCalculation(
						preventListViewHelper.getTotalCountProperty(),
						getLineMax()));
				preventListViewHelper.setIsHidePanelSearch(true);
				preventListViewHelper.setIsAdvanceSearch(false);

				preventContext.setIsAdvanceSearch(preventListForm
						.getIsAdvanceSearch());
				preventContext.setIsHidePanelSearch(preventListForm
						.getIsHidePanelSearch());
				preventContext.setDisplayPreventList(preventListForm.getDisplayPreventList());
				preventListViewHelper.setDisplayPreventList(preventListForm.getDisplayPreventList());
            }
            
        	preventListViewHelper.setSortType(preventListForm.getSortType()); 
            //luu thoi gian tim kiem phuc vu cho viec in trang ******
            preventListViewHelper.setSearchTime(new java.util.Date());
      
        }
        
        preventListViewHelper.setDisplayPreventList(preventListForm.getDisplayPreventList());
        if (preventListViewHelper.getTotalCount() == 0 && preventListViewHelper.getTotalCountProperty() == 0) {
            MessageUtil mu = new MessageUtil();
            saveMessages(request,
                    mu.createActionMessages("", request, "msg_data_not_exist", "item_data_prevent_transaction_property"));
        }
        
        return mapping.findForward(SUCCESS);
    }
    
	/**
     * <P>Action when paging prevent list</P>
     * 
     * @author HungPT 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward paging(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        PreventListForm preventListForm = (PreventListForm)form;
        MessageUtil messageUtil = new MessageUtil();
        
        HttpSession session = request.getSession();
        PreventListViewHelper preventListViewHelper = (PreventListViewHelper)session.getAttribute(PreventListViewHelper.SESSION_KEY);
        PreventContext preventContext = (PreventContext)session.getAttribute(PreventContext.SESSION_KEY);
        
        if (preventListViewHelper == null || preventContext == null) {
        	return mapping.findForward(NO_LOGIN);
        }
        
        preventContext.setDisplayPreventList(true);
        String page = request.getParameter("page");
        Integer pageNumber = null;
        if (EditString.isNumber(page)) pageNumber = Integer.parseInt(page);
        
        if (page !=null && !page.trim().equals(String.valueOf(preventListViewHelper.getPage()))) {
	        if (pageNumber!=null && pageNumber>0 && pageNumber<=preventListViewHelper.getTotalPage()) {
	        	preventListViewHelper.setPage(pageNumber-1);
	        	preventListForm.setDirection("next");
	        	preventContext.setDisplayPreventList(true);
	        } else {
	        	ActionErrors errors = new ActionErrors();
	            errors.add(messageUtil.createActionMessages("", request, "err_not_regular", "item_page"));
	            this.addErrors(request, errors);
	        	return mapping.findForward(FAILURE);
	        }
        }
        
        if (!preventListViewHelper.isLuceneSearch()){
	        if (preventListViewHelper != null && preventContext != null) {
	            saveDataPreventList(preventListViewHelper, preventContext, preventListForm.getDirection(), session);
	            preventListViewHelper.setIsAdvanceSearch(preventListForm.getIsAdvanceSearch());
	            preventListViewHelper.setIsHidePanelSearch(preventListForm.getIsHidePanelSearch());
	            preventListViewHelper.setDisplayPreventList(preventListForm.getDisplayPreventList());
	        }
        } else { 
        	CommonContext commonCntx = (CommonContext) session.getAttribute(CommonContext.SESSION_KEY);
    		String officeCode = commonCntx.getSystemOfficeAuthorityID();
    		
    		Integer totalPage = preventListViewHelper.getTotalPage();
    		preventListViewHelper.setPage(pageTransition(preventListForm.getDirection(), preventListViewHelper.getPage(), totalPage));
    		LucenePreventService lucenePreventService = new LucenePreventService();
        	if (!preventListViewHelper.getIsAdvanceSearch()) {
        		lucenePreventService.searchDataPrevent(preventListViewHelper, officeCode,
        				preventListViewHelper.getSubkeyList(), getLineMax(), preventListViewHelper.getPage());
        	} else {
        		lucenePreventService.searchDataPrevent2(preventListViewHelper, officeCode,
        				preventListViewHelper.getSearchList(), getLineMax(), preventListViewHelper.getPage());
	          
        	}
        	preventListViewHelper.setDisplayPreventList(preventListForm.getDisplayPreventList());
        }
        request.getSession().setAttribute(PreventListViewHelper.SESSION_KEY, preventListViewHelper);
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action when paging property list</P>
     * 
     * @author HungPT 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward pagingProperty(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        PreventListForm preventListForm = (PreventListForm)form;
        MessageUtil messageUtil = new MessageUtil();

        HttpSession session = request.getSession();
        PreventListViewHelper preventListViewHelper = (PreventListViewHelper)session.getAttribute(PreventListViewHelper.SESSION_KEY);
        PreventContext preventContext = (PreventContext)session.getAttribute(PreventContext.SESSION_KEY);
        
        if (preventListViewHelper == null || preventContext == null) {
        	return mapping.findForward(NO_LOGIN);
        }
        
        preventContext.setDisplayPreventList(false);
        String page = request.getParameter("pageProperty");
        Integer pageNumber = null;
        if (EditString.isNumber(page)) pageNumber = Integer.parseInt(page);
        if (page !=null) {
        	if (!page.trim().equals(String.valueOf(preventListViewHelper.getPageProperty()))) {
		        if (pageNumber!=null && pageNumber>0 && pageNumber<=preventListViewHelper.getTotalPageProperty()) {
		        	preventListViewHelper.setPageProperty(pageNumber-1);
		        	preventListForm.setDirection("next");
		        	preventContext.setDisplayPreventList(true);
		        } else {
		        	
		        	ActionErrors errors = new ActionErrors();
		            errors.add(messageUtil.createActionMessages("", request, "err_not_regular", "item_page"));
		            this.addErrors(request, errors);
		        	return mapping.findForward(FAILURE);
		        }
	        } 
        } else {
	        	preventListForm.setDirection(null);
	    }
        if (!preventListViewHelper.isLuceneSearch()) {
	        if (preventListViewHelper != null && preventContext != null) {
	            saveTransactionPropertyList(preventListViewHelper, preventContext, preventListForm.getDirection(), session);
	            preventListViewHelper.setIsAdvanceSearch(preventListForm.getIsAdvanceSearch());
	            preventListViewHelper.setIsHidePanelSearch(preventListForm.getIsHidePanelSearch());
	            preventListViewHelper.setDisplayPreventList(preventListForm.getDisplayPreventList());
	        }
        } else {
        	CommonContext commonCntx = (CommonContext) session.getAttribute(CommonContext.SESSION_KEY);
    		String officeCode = commonCntx.getSystemOfficeAuthorityID();
    		
        	Integer totalPage = preventListViewHelper.getTotalPageProperty();
        	preventListViewHelper.setPageProperty(pageTransition(preventListForm.getDirection(), preventListViewHelper.getPageProperty(), totalPage));
        	LuceneTransactionPropertyService luceneTransactionPropertyService = new LuceneTransactionPropertyService();
        	if (!preventListViewHelper.getIsAdvanceSearch()) { 
	        	 luceneTransactionPropertyService.searchTransactionProperty(preventListViewHelper, officeCode,
	        			 preventListViewHelper.getSubkeyList(), getLineMax(), preventListViewHelper.getPageProperty());
        	} else {
        		 luceneTransactionPropertyService.searchTransactionProperty2(preventListViewHelper, officeCode,
        				 preventListViewHelper.getSearchList(), getLineMax(), preventListViewHelper.getPageProperty());
	        	
        	}
        	preventListViewHelper.setSortType(preventListForm.getSortType());
        	preventListViewHelper.setDisplayPreventList(preventListForm.getDisplayPreventList());
        }
        request.getSession().setAttribute(PreventListViewHelper.SESSION_KEY, preventListViewHelper);
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action back</P>
     * 
     * @author HungPT 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward back(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
		createTitle(PRV001);

        HttpSession session = request.getSession();
        PreventListViewHelper preventListViewHelper = (PreventListViewHelper)session.getAttribute(PreventListViewHelper.SESSION_KEY);
        PreventContext preventContext = (PreventContext)session.getAttribute(PreventContext.SESSION_KEY);
        
        if (preventListViewHelper != null && preventContext != null) {
        	if (!preventListViewHelper.isLuceneSearch()){
	            setViewHelper(preventListViewHelper, preventContext);           
	            saveDataPreventList(preventListViewHelper, preventContext, null, session);
        	} else {
        		CommonContext commonCntx = (CommonContext) session.getAttribute(CommonContext.SESSION_KEY);
        		String officeCode = commonCntx.getSystemOfficeAuthorityID();
        		
        		preventListViewHelper.setDisplayPreventList(preventContext.getDisplayPreventList());
        		LucenePreventService lucenePreventService = new LucenePreventService();
        		if (!preventListViewHelper.getIsAdvanceSearch()) {
	                 lucenePreventService.searchDataPrevent(preventListViewHelper, officeCode,
	                		 preventListViewHelper.getSubkeyList(), getLineMax(), preventListViewHelper.getPage());    
	                 preventListViewHelper.setTotalPage(pageCalculation(preventListViewHelper.getTotalCount(), getLineMax()));
        		} else {
        			 lucenePreventService.searchDataPrevent2(preventListViewHelper, officeCode,
        					 preventListViewHelper.getSearchList(), getLineMax(), preventListViewHelper.getPage());    
	                 preventListViewHelper.setTotalPage(pageCalculation(preventListViewHelper.getTotalCount(), getLineMax()));
        		}
        		
        		
        	}
        } else {
            view(mapping, form, request, response);
        }
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Save Data Prevent to View Helper</P>
     * 
     * @author HungPT 
     * @param preventListViewHelper
     * @param context
     * @param direction
     */
    private void saveDataPreventList(PreventListViewHelper preventListViewHelper, PreventContext context, String direction, HttpSession session)
    	throws SQLException, IOException {
    	
    	PreventService preventService = new PreventService(getConnection());    	
        
    	if (preventListViewHelper.getOfficeCode() != null) {
    		CommonContext commonCntx = (CommonContext) session.getAttribute(CommonContext.SESSION_KEY);
    		context.setOfficeCode(commonCntx.getSystemOfficeAuthorityID() + "_");
    	}
    	
    	//set search filter
        setSearchFilter(context, preventService);
        
        preventListViewHelper.setDataPreventList(null);
        
        preventService.setDeleteFlgFilter(Boolean.FALSE);
    	int totalCount = preventService.countTotalDataPreventByFilter();
        preventListViewHelper.setTotalCount(totalCount);
        
        if (totalCount != 0) {        	          
            int totalPage = pageCalculation(totalCount, getLineMax());
            preventListViewHelper.setTotalPage(totalPage);
            preventListViewHelper.setPage(pageTransition(direction, preventListViewHelper.getPage(), totalPage));
            if (EditString.isNull(preventListViewHelper.getKeySearch())) {
                preventService.addOrderFieldDataPrevent(new OrderField(ORDER_FIELD_PREVENT_DATE, OrderType.DESC));
                preventService.addOrderFieldDataPrevent(new OrderField(ORDER_FIELD_UPDATE_DATE_TIME, OrderType.DESC));
            }
            DataPreventList dataPreventList = preventService.queryDataPrevent(false, preventListViewHelper.getPage(), getLineMax());
            preventListViewHelper.setDataPreventList(dataPreventList.getList());            
        }
    }
    
    /**
     * <P>Save Property List to View Helper</P>
     * 
     * @author HungPT 
     * @param preventListViewHelper
     * @param context
     * @param direction
     */    
    private void saveTransactionPropertyList(PreventListViewHelper preventListViewHelper, PreventContext context, String direction, 
    		HttpSession session) throws SQLException, IOException {
    
        PreventService preventService = new PreventService(getConnection());        
        
        if (preventListViewHelper.getOfficeCode() != null) {
    		CommonContext commonCntx = (CommonContext) session.getAttribute(CommonContext.SESSION_KEY);
    		context.setOfficeCode(commonCntx.getSystemOfficeAuthorityID() + "_");
    	}
        
        //set search filter
        setTransactionPropertyFilter(context, preventService);
        
        preventListViewHelper.setTransactionPropertyList(null);
              
        int totalCount = preventService.countTotalTransactionProperty();
        
//        if (preventListViewHelper.getOfficeCode() != null) {
//        	totalCount = preventService.countTotalTransactionProperty();
//        } else {
//        	CountService cntSrv = new CountService(getConnection());
//        	CountInfo cntInfo = cntSrv.queryCountById(CountInfo.ID_TRANSACTION);
//        	if (cntInfo != null) {
//        		totalCount = cntInfo.getCountValue().intValue();
//        	}
//        }
        
        preventListViewHelper.setTotalCountProperty(totalCount);
        
        if (totalCount != 0) {                    
            int totalPage = pageCalculation(totalCount, getLineMax());
            preventListViewHelper.setTotalPageProperty(totalPage);
            preventListViewHelper.setPageProperty(pageTransition(direction, preventListViewHelper.getPageProperty(), totalPage));
            preventService.addOrderFieldTransactionProperty(new OrderField(ORDER_FIELD_NOTARY_DATE, OrderType.DESC));
            TransactionPropertyList transactionPropertyList = preventService.queryTransactionProperty(false, preventListViewHelper.getPageProperty(), getLineMax());
            preventListViewHelper.setTransactionPropertyList(transactionPropertyList.getList());            
        }
    }
    
    /**
     * <P>Set data from contract context to contract view helper</P>
     * 
     * @author HungPT 
     * @param viewHelper
     * @param context
     */
    private void setViewHelper(PreventListViewHelper viewHelper, PreventContext context) {
        
        viewHelper.setCarFrameNumber(context.getCarFrameNumber());
        viewHelper.setCarLicenseNumber(context.getCarLicenseNumber());
        viewHelper.setCarMachineNumber(context.getCarMachineNumber());
        viewHelper.setCarRegistNumber(context.getCarRegistNumber());
        viewHelper.setLandAddress(context.getLandAddress());
        viewHelper.setLandCertificate(context.getLandCertificate());
        viewHelper.setLandMapNumber(context.getLandMapNumber());
        viewHelper.setLandNumber(context.getLandNumber());
        viewHelper.setPropertyInfo(context.getPropertyInfo());
        viewHelper.setType(context.getType());
        viewHelper.setOriginKind(context.getOriginKind());
        viewHelper.setReleaseFlg(context.getReleaseFlg());
        viewHelper.setTypeKeySearch(context.getTypeKeySearch());
        viewHelper.setKeySearch(context.getKeySearch());
        viewHelper.setIsAdvanceSearch(context.getIsAdvanceSearch());
        viewHelper.setIsHidePanelSearch(context.getIsHidePanelSearch());
        viewHelper.setDisplayPreventList(context.getDisplayPreventList());
    }
    
    /**
     * <P>Set data for prevent context</P>
     * 
     * @author HungPT 
     * @param context
     * @param form
     */
//    private void setContext(PreventContext context, PreventListForm form) {
//        context.setCarFrameNumber(form.getCarFrameNumber());
//        context.setCarLicenseNumber(form.getCarLicenseNumber());
//        context.setCarMachineNumber(form.getCarMachineNumber());
//        context.setCarRegistNumber(form.getCarRegistNumber());
//        context.setLandAddress(form.getLandAddress());
//        context.setLandCertificate(form.getLandCertificate());
//        context.setLandMapNumber(form.getLandMapNumber());
//        context.setLandNumber(form.getLandNumber());
//        context.setPropertyInfo(form.getPropertyInfo());
//        context.setType(form.getType());
//        context.setOriginKind(form.getOriginKind());
//        context.setReleaseFlg(form.getReleaseFlg());
//        //context.setTypeKeySearch(form.getTypeKeySearch());
//        //context.setKeySearch(form.getKeySearch());
//        context.setIsAdvanceSearch(form.getIsAdvanceSearch());
//        context.setIsHidePanelSearch(form.getIsHidePanelSearch());
//        context.setDisplayPreventList(form.getDisplayPreventList());
//    }
    
    /**
     * <P>Set search filter</P>
     * 
     * @author HungPT 
     * @param context
     * @param service
     */
    private void setSearchFilter(PreventContext context, PreventService service) {
        
        if (!EditString.isNull(context.getCarFrameNumber())) {
            service.setCarFrameNumberFilter(context.getCarFrameNumber(), FilterKind.MIDDLE);
        }
        
        if (!EditString.isNull(context.getCarLicenseNumber())) {
            service.setCarLicenseNumberFilter(context.getCarLicenseNumber(), FilterKind.MIDDLE);
        }
        
        if (!EditString.isNull(context.getCarMachineNumber())) {
            service.setCarMachineNumberFilter(context.getCarMachineNumber(), FilterKind.MIDDLE);
        }
        
        if (!EditString.isNull(context.getCarRegistNumber())) {
            service.setCarRegistNumberFilter(context.getCarRegistNumber(), FilterKind.MIDDLE);
        }
        
        if (!EditString.isNull(context.getLandAddress())) {
            service.setLandAddressFilter(context.getLandAddress(), FilterKind.MIDDLE);
        }
        
        if (!EditString.isNull(context.getLandCertificate())) {
            service.setLandCertificateFilter(context.getLandCertificate(), FilterKind.MIDDLE);
        }
        
        if (!EditString.isNull(context.getLandMapNumber())) {
            service.setLandMapNumberFilter(context.getLandMapNumber(), FilterKind.MIDDLE);
        }
        
        if (!EditString.isNull(context.getLandNumber())) {
            service.setLandNumberFilter(context.getLandNumber(), FilterKind.MIDDLE);
        }
        
        if (!EditString.isNull(context.getPropertyInfo())) {
            service.setPropertyInfoFilter(context.getPropertyInfo(), FilterKind.MIDDLE);
        }
        
        if (context.getIsAdvanceSearch() && !EditString.isNull(context.getType()) && !PROPERTY_TYPE_ALL.equals(context.getType())) {
            service.setTypeFilter(context.getType());
        }
        
        if (!EditString.isNull(context.getOriginKind()) && !ORGIN_KIND_ALL.equals(context.getOriginKind())) {
            service.setOriginKindFilter(context.getOriginKind());
        }
        
        if (RELEASE.equals(context.getReleaseFlg())) {
            service.setReleaseFlgFilter(Boolean.TRUE);
        }
        
        if (NOT_RELEASE.equals(context.getReleaseFlg())) {
            service.setReleaseFlgFilter(Boolean.FALSE);
        }
        
        if (!context.getIsAdvanceSearch() && !EditString.isNull(context.getTypeKeySearch()) 
                && !PROPERTY_TYPE_ALL.equals(context.getTypeKeySearch())) {
            service.setTypeFilter(context.getTypeKeySearch());
        }
        
        if (!EditString.isNull(context.getKeySearch())) {
            service.setSubKeys(subKeyList);
            if (subKeyList.size() > 0) {
                service.setKeySearchFilter(context.getKeySearch());
            } else {
                service.setKeySearchFilter(null);
            }
        }
        
        if (!EditString.isNull(context.getOfficeCode())) {
        	service.setOfficeCodeFilter(context.getOfficeCode());
        }
    }
    
    /**
     * <P>Set search filter for property searching</P>
     * 
     * @author HungPT 
     * @param context
     * @param service
     */
    private void setTransactionPropertyFilter(PreventContext context, PreventService service) {
        
        if (!EditString.isNull(context.getTypeKeySearch()) && !PROPERTY_TYPE_ALL.equals(context.getTypeKeySearch())) {
            service.setTypeTransactionFilter(context.getTypeKeySearch());
        }
        
        if (!EditString.isNull(context.getKeySearch())) {
            service.setSubKeysTransaction(subKeyList);
            if (subKeyList.size() > 0) {
                service.setKeySearchTransactionFilter(context.getKeySearch());
            } else {
                service.setKeySearchTransactionFilter(null);
            }
        }
        
        if (!EditString.isNull(context.getOfficeCode())) {
        	service.setOfficeCodeFilter(context.getOfficeCode());
        }
    }
    
    
    private void getSubKeyForHightLight(List<String> subkeys) {
        String subkey = "";
        for (int i = 1; i < subkeys.size(); i += 2) {
            subkey = subkeys.get(i);
            subkey = subkey.trim();
            if (subkey.charAt(0) == '"') {
                subkey = subkey.substring(1, subkey.length() - 1);
            }
            if (subkey.charAt(subkey.length() - 1) == '"') {
                subkey = subkey.substring(0, subkey.length() - 2);
            }
            if (i != subkeys.size() - 1) {
                this.keyHightLight += subkey + "|";
            } else {
                this.keyHightLight += subkey;
            }            
        }
    }
    
    /**
     * <P>Action help</P>
     * 
     * @author HungNM
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward help(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
		createTitle(PRV001);
        return mapping.findForward(SUCCESS);
    }
 
   /**
     * <P>Action back</P>
     * 
     * @author TruongND
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    
    public ActionForward printPreview(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
         HttpSession session = request.getSession();        
         PreventListViewHelper preventListViewHelper = (PreventListViewHelper)session.getAttribute(PreventListViewHelper.SESSION_KEY);        
         PreventContext preventContext = (PreventContext)session.getAttribute(PreventContext.SESSION_KEY);
         
         if (preventListViewHelper != null && preventContext != null) {
             return mapping.findForward(SUCCESS);
         } else {
        	 return mapping.findForward("nologin");
		 }
         
    }  
}