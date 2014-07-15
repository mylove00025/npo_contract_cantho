/**
 * 
 */
package com.osp.npo.app.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.context.BankListContext;
import com.osp.npo.app.context.PropertyListContext;
import com.osp.npo.app.form.ContractForm;
import com.osp.npo.app.form.PropertyListForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractViewHelper;
import com.osp.npo.app.viewhelper.PropertyListViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.basicData.ProvinceInfo;
import com.osp.npo.core.contract.ContractPropertyList;
import com.osp.npo.core.contract.PropertyInfo;
import com.osp.npo.core.contract.PropertyList;
import com.osp.npo.service.BasicDataService;
import com.osp.npo.service.CommonService;
import com.osp.npo.service.ContractService;

/**
 * @author Admin
 *
 */
public class PropertyListAction extends BaseMDAction{
	private static final String SUCCESS = "success";
    private static final String NO_LOGIN = "nologin";   
    private static final Integer FIRST_PAGE = 1;
    private static final String ORDER_FIELD_PROVINCE = "order_number";
    private static final String ORDER_FIELD_DISTRICT = "order_number";
    
    private static final String LAND_TYPE = "01";
    private static final String VEHICLE_CAR_TYPE = "02";
    private static final String VEHICLE_MOTOR_TYPE = "03";
    private static final String OTHER_TYPE = "99";    
    private static final String REGIST = "regist";
    private static final String UPDATE = "update";
    
    @SuppressWarnings("unchecked")
	public ActionForward view(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	createTitle(Constants.SCREEN_CNTR023);
    	HttpSession session = request.getSession();
        
        //delete session
        if (session.getAttribute(PropertyListViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(PropertyListViewHelper.SESSION_KEY);
        }
        
        ContractViewHelper contractViewHelper = (ContractViewHelper)request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
        if(contractViewHelper == null){
        	return mapping.findForward(NO_LOGIN);
        }
        
        PropertyListViewHelper viewHelper = new PropertyListViewHelper();
        
        PropertyListContext context = new PropertyListContext();
        context.reset();
        context.setPropertyList(contractViewHelper.getPropertyList());
        List<Long> checkList = new ArrayList<Long>();
        if (context.getPropertyList() != null 
        		&& context.getPropertyList().size() > 0) {
        	for (PropertyInfo info : context.getPropertyList() ) {
				if( info.getId() != null && !checkList.contains(info.getId()) ) {
					checkList.add(info.getId());
				}
			}
        	context.setChkID(checkList);
        } else 
        	context.setChkID(null);
        
        setViewHelper(viewHelper, context,null);
        
        if (context.getChkID() !=null 
    			&& context.getChkID().size()>0) {
	    	 String[] checkedId  = new String[context.getChkID().size()];
	    	 for (int i = 0; i < context.getChkID().size(); i++)  {
	             checkedId[i] = context.getChkID().get(i).toString();
	         }
	    	 viewHelper.setChkID(checkedId);
    	} else {
    		viewHelper.setChkID(null);
    	}        
                
        CommonService commonService = new CommonService(getConnection());
        viewHelper.setPropertyTypeList(commonService.queryAllProperty().getList());
        
        BasicDataService basicDataService = new BasicDataService(getConnection()); 
        basicDataService.addOrderFieldProvince(new OrderField(ORDER_FIELD_PROVINCE));
        List<ProvinceInfo> provinceList = basicDataService.queryAllProvince(false).getList();        
        viewHelper.setProvinceList(provinceList);
        if (provinceList != null && provinceList.size() > 0) {
        	basicDataService.setProvinceIdFilter(provinceList.get(0).getId());
        }
        basicDataService.addOrderFieldProvince(new OrderField(ORDER_FIELD_DISTRICT));
        viewHelper.setDistrictList(basicDataService.queryAllDistrict(false).getList());        
        
        viewHelper.setPropertyList(contractViewHelper.getPropertyList());
        
        if(contractViewHelper.getFromRegistScreen().equals(Boolean.TRUE)){
        	viewHelper.setIsRegist(Boolean.TRUE);
		} else {
			viewHelper.setIsRegist(Boolean.FALSE);
		}
        
        request.getSession().setAttribute(PropertyListContext.SESSION_KEY, context);
	    request.getSession().setAttribute(PropertyListViewHelper.SESSION_KEY, viewHelper);
	    
    	return mapping.findForward(SUCCESS);
    }
    
    /**
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward search(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	PropertyListContext context = getListContext(request);
    	
    	PropertyListForm propertyForm = (PropertyListForm)form;
    	
    	context.reset();
    	setContext(context,propertyForm);
    	PropertyListViewHelper viewHelper = (PropertyListViewHelper)request.getSession().getAttribute(PropertyListViewHelper.SESSION_KEY);
    	viewHelper.reset(propertyForm);
    	viewHelper.setPage(FIRST_PAGE);
    	setViewHelper(viewHelper, context, null);
    	
    	if(viewHelper.getTotalCount()==0){
    		MessageUtil mu = new MessageUtil();
            saveMessages(request, mu.createActionMessages("", request, "msg_data_not_exist", "item_property"));
    	}
    	
    	return mapping.findForward(SUCCESS);
    }
    
    /**
	 * 
	 * 
	 * @param request
	 * @return
	 */
	private PropertyListContext getListContext(HttpServletRequest request) {
		HttpSession session = request.getSession();
		PropertyListContext context = (PropertyListContext) session.getAttribute(PropertyListContext.SESSION_KEY);
		
		 if (context == null) {
	            context = new PropertyListContext();
	            session.setAttribute(PropertyListContext.SESSION_KEY,context);
		 }
		 
		return context;
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
    public ActionForward paging(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	PropertyListContext context = getListContext(request);
    	
    	PropertyListForm propertyForm = (PropertyListForm)form;
    	
    	context.reset();
    	setContext(context,propertyForm);
    	PropertyListViewHelper viewHelper = (PropertyListViewHelper)request.getSession().getAttribute(PropertyListViewHelper.SESSION_KEY);
    	
    	if (context.getChkID() !=null 
    			&& context.getChkID().size()>0) {
	    	 String[] checkedId  = new String[context.getChkID().size()];
	    	 for (int i = 0; i < context.getChkID().size(); i++)  {
	             checkedId[i] = context.getChkID().get(i).toString();
	         }
	    	 viewHelper.setChkID(checkedId);
    	}
    	
    	viewHelper.reset(propertyForm);
    	
    	setViewHelper(viewHelper, context, propertyForm.getDirection());
    	return mapping.findForward(SUCCESS);
    }
  
    /**
     * 
     * @param viewHelper
     * @param context
     * @param direction
     * @throws SQLException
     * @throws IOException
     */
	private void setViewHelper(PropertyListViewHelper viewHelper,PropertyListContext context, String direction)
	throws SQLException, IOException{
		
//    	viewHelper.setTypeProperty(context.getTypeProperty());
//    	viewHelper.setPropertyTitle(context.getTitleProperty());    	
//    	ContractService service = new ContractService(getConnection());
//    	setSearchFilter(context, service);
//    	viewHelper.setList(null);
//    	int totalCount = service.countTotalAllPropertyByFilter();
//    	viewHelper.setTotalCount(totalCount);
//    	if(totalCount>0){
//    		int totalPage = pageCalculation(totalCount, getLineMax());
//    		viewHelper.setTotalPage(totalPage);
//    		viewHelper.setPage(pageTransition(direction, viewHelper.getPage(), totalPage));
//    		PropertyList list = service.queryAllPropertyByFilter(false,viewHelper.getPage(), getLineMax());
//    		viewHelper.setList(list.getList());
//    	}
    }
	
    /**
     * 
     * @param context
     * @param form
     * @throws Exception
     */
	private void setContext(PropertyListContext context, PropertyListForm form)
	throws Exception {
//    	context.setKeySearch(form.getKeySearch());
//    	    	
//    	List<Long> addPropertyList = new ArrayList <Long>();
//    	if(context.getChkID()!=null 
//    			&& context.getChkID().size()>0){
//    		addPropertyList = context.getChkID();
//    	}    	
//    	List<PropertyInfo> propertyList = new ArrayList<PropertyInfo>();
//		if(context.getPropertyList() != null && context.getPropertyList().size()>0)
//			 propertyList = context.getPropertyList();    	
//    	if(form.getChkID()!=null
//    			&& form.getChkID().length>0){    		 
//    		 for (int i = 0; i < form.getChkID().length; i++) {
//    			 addPropertyList.add(Long.valueOf(form.getChkID()[i]));
//    			 if (propertyList !=null 
//    					 && propertyList.size()>0) {
//    				Boolean flg = Boolean.FALSE;
//	    			for (PropertyInfo item : propertyList ) {	
//	    				if(item.getId() !=null ){
//		    				if(item.getId().equals(Long.valueOf(form.getChkID()[i]))){
//		    					flg = Boolean.TRUE;
//		    					break;
//		    				}
//	    				}
//	    			}    
//    				if (flg == Boolean.FALSE) {
//    					ContractService service = new ContractService(getConnection());
//		    			service.setPropertyIdFilter(Long.valueOf(form.getChkID()[i]));
//		    			PropertyList list = service.queryProperty(false);
//		    			if(list !=null && list.size()>0){
//		    				PropertyInfo info = list.get(0);		
//		    				propertyList.add(info);
//		    			}
//    				}
//    			 } else {
//    				ContractService service = new ContractService(getConnection());
//	    			service.setPropertyIdFilter(Long.valueOf(form.getChkID()[i]));
//	    			PropertyList list = service.queryProperty(false);
//	    			if(list !=null && list.size()>0) {
//	    				PropertyInfo info = list.get(0);   				
//	    				propertyList.add(info);	    				
//	    			}
//    			 }
//             }
//             context.setChkID(addPropertyList);
//             context.setPropertyList(propertyList);             
//    	}
    }
	
	/**
	 *  Set filter 
	 * @param context
	 * @param service
	 */
	private void setSearchFilter(PropertyListContext context,ContractService service){
		
//		if(context.getKeySearch()!=null && !context.getKeySearch().equals("00")) {
//			service.setKeySearchFilter(context.getKeySearch());
//		}		
	}
	
    public ActionForward savePropertyList(ActionMapping mapping, ActionForm formpro, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
//    	PropertyListContext context = getListContext(request);    	    	
//    	PropertyListForm form = (PropertyListForm)formpro;    	
//    	PropertyListViewHelper viewHelper = (PropertyListViewHelper)request.getSession().getAttribute(PropertyListViewHelper.SESSION_KEY);
//    	List<Long> addPropertyList = new ArrayList <Long>();
//    	if(context.getChkID()!=null 
//    			&& context.getChkID().size()>0){
//    		addPropertyList = context.getChkID();
//    	}    	
//    	List<PropertyInfo> propertyList = new ArrayList<PropertyInfo>();
//		 if(context.getPropertyList() != null && context.getPropertyList().size()>0)
//			 propertyList = context.getPropertyList();    	
//    	if(form.getChkID()!=null
//    			&& form.getChkID().length>0){    		 
//    		 for (int i = 0; i < form.getChkID().length; i++) {
//    			 addPropertyList.add(Long.valueOf(form.getChkID()[i]));
//    			 if (propertyList !=null 
//    					 && propertyList.size()>0) {
//    				Boolean flg = Boolean.FALSE;
//	    			for (PropertyInfo item : propertyList ) {	
//	    				if(item.getId() !=null ){
//		    				if(item.getId().equals(Long.valueOf(form.getChkID()[i]))){
//		    					flg = Boolean.TRUE;
//		    					break;
//		    				}
//	    				}
//	    			}    
//    				if (flg == Boolean.FALSE) {
//    					ContractService service = new ContractService(getConnection());
//		    			service.setPropertyIdFilter(Long.valueOf(form.getChkID()[i]));
//		    			PropertyList list = service.queryProperty(false);
//		    			if(list !=null && list.size()>0){
//		    				PropertyInfo info = list.get(0);		
//		    				propertyList.add(info);
//		    			}
//    				}
//    			 } else {
//    				ContractService service = new ContractService(getConnection());
//	    			service.setPropertyIdFilter(Long.valueOf(form.getChkID()[i]));
//	    			PropertyList list = service.queryProperty(false);
//	    			if(list !=null && list.size()>0) {
//	    				PropertyInfo info = list.get(0);   				
//	    				propertyList.add(info);	    				
//	    			}
//    			 }
//             }
//             context.setChkID(addPropertyList);
//             context.setPropertyList(propertyList);             
//    	}
//    	viewHelper.setPropertyList(context.getPropertyList());
//    	ContractViewHelper contractViewHelper = (ContractViewHelper)request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
//        if (contractViewHelper !=null) {
//        	contractViewHelper.setPropertyList(viewHelper.getPropertyList());
//        }
//    	
//    	if (context.getChkID() !=null 
//    			&& context.getChkID().size()>0) {
//	    	 String[] checkedId  = new String[context.getChkID().size()];
//	    	 for (int i = 0; i < context.getChkID().size(); i++)  {
//	             checkedId[i] = context.getChkID().get(i).toString();
//	         }
//	    	 viewHelper.setChkID(checkedId);
//    	}
//    	
//    	viewHelper.reset(form);
//    	
//    	request.getSession().setAttribute(PropertyListContext.SESSION_KEY, context);
// 	    request.getSession().setAttribute(PropertyListViewHelper.SESSION_KEY, viewHelper);
    	return mapping.findForward(SUCCESS);
    }
    
    

    public ActionForward removePropertyList(ActionMapping mapping, ActionForm formpro, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {  
    	
    	PropertyListContext context = getListContext(request);  
    	PropertyListViewHelper viewHelper = (PropertyListViewHelper)request.getSession().getAttribute(PropertyListViewHelper.SESSION_KEY);    	
    	List<Long> addPropertyList = new ArrayList <Long>();    	
    	
    	if (context.getChkID()!=null 
    			&& context.getChkID().size()>0) {
    		addPropertyList = context.getChkID();
    	}
    	
    	List<PropertyInfo> propertyList = new ArrayList<PropertyInfo>();
		if (context.getPropertyList() != null && context.getPropertyList().size()>0) {
			 propertyList = context.getPropertyList();  
		} else
			return null;
		
		String index = request.getParameter("index");    	
		propertyList.remove(Integer.parseInt(index));		
    	context.setPropertyList(propertyList);
    	for (int i = 0; i < addPropertyList.size() ; i++) {
    		Boolean flg = Boolean.FALSE;
    		if (propertyList !=null && propertyList.size()>0) {
				for (PropertyInfo item : propertyList) {
		    		if (item.getId() !=null &&  item.getId().equals(addPropertyList.get(i))) {
		    			flg = Boolean.TRUE;
		    		}        			
		    	}
    		}    		
    		if (flg == Boolean.FALSE) {
    			addPropertyList.remove(i);
    		}
		}
    	
    	context.setChkID(addPropertyList);
    	viewHelper.setPropertyList(propertyList);
    	ContractViewHelper contractViewHelper = (ContractViewHelper)request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
        if (contractViewHelper != null ) {
        	contractViewHelper.setPropertyList(viewHelper.getPropertyList());
        }
        PropertyListForm form = (PropertyListForm)formpro;
        
    	if (context.getChkID() !=null 
    			&& context.getChkID().size()>0) {
	    	 String[] checkedId  = new String[context.getChkID().size()];
	    	 for (int i = 0; i < context.getChkID().size(); i++)  {
	             checkedId[i] = context.getChkID().get(i).toString();
	         }
	    	 viewHelper.setChkID(checkedId);
    	} else {
    		viewHelper.setChkID(null);
    		context.setChkID(null);
    		form.setChkID(null);
    		
    	}
    	
    	request.getSession().setAttribute(PropertyListContext.SESSION_KEY, context);
 	    request.getSession().setAttribute(PropertyListViewHelper.SESSION_KEY, viewHelper);
    	return mapping.findForward(SUCCESS);
    }
    
    public ActionForward addProperty(ActionMapping mapping, ActionForm formpro, HttpServletRequest request, HttpServletResponse response)
    throws Exception {		
		
//		PropertyListContext context = getListContext(request);
//    	
//    	PropertyListForm form = (PropertyListForm)formpro;
//    	
//    	form.validate(mapping, request);
//    	
//    	PropertyListViewHelper viewHelper = (PropertyListViewHelper)request.getSession().getAttribute(PropertyListViewHelper.SESSION_KEY);    	
//		   
//    	if (viewHelper == null) {
//		    return mapping.findForward(NO_LOGIN);
//		}
//    	viewHelper.reset(form);    		
//		
//		List<PropertyInfo> propertyList = viewHelper.getPropertyList();
//		PropertyInfo propertyInfo = new PropertyInfo();
//		
//	    propertyInfo.setType(form.getTypeProperty());     
//	    propertyInfo.setTitle(form.getPropertyTitle());
//	    if (LAND_TYPE.equals(form.getTypeProperty())) {
//	        propertyInfo.setProvince(form.getProvinceLand());
//	        propertyInfo.setDistrict(form.getDistrict());
//	        propertyInfo.setCode(form.getPropertyCodeLand());
//	        propertyInfo.setMapNumber(form.getMapNumber());
//	        propertyInfo.setLandNumber(form.getLandNumber());
//	        propertyInfo.setLandAddress(form.getLandAddress());
//	        propertyInfo.setOwnerName(form.getOwnerName());
//	        propertyInfo.setOwnerIdCard(form.getOwnerIdCard());	  
//	        propertyInfo.setOwnerAddress(form.getOwnerAddress());
//	        propertyInfo.setGivenDate(RelateDateTime.toTimestamp(false, form.getGivenDateLand()));
//	        
//	    } else if (VEHICLE_CAR_TYPE.equals(form.getTypeProperty())
//	            || VEHICLE_MOTOR_TYPE.equals(form.getTypeProperty())) {
//	        propertyInfo.setCode(form.getPropertyCodeVehicle());
//	        propertyInfo.setProvince(form.getProvinceVehicle());
//	        propertyInfo.setGivenDate(RelateDateTime.toTimestamp(false, form.getGivenDateVehicle()));
//	        propertyInfo.setFrameNumber(form.getFrameNumber());
//	        propertyInfo.setMachineNumber(form.getMachineNumber());
//	        propertyInfo.setOwnerName(form.getOwnerName());
//	        propertyInfo.setOwnerIdCard(form.getOwnerIdCard());
//	        propertyInfo.setOwnerAddress(form.getOwnerAddress());
//	        
//	        
//	    } else if (OTHER_TYPE.equals(form.getTypeProperty())) {
//	        propertyInfo.setCode(form.getPropertyCodeOther());
//	        propertyInfo.setOtherInfo(form.getPropertyOtherInfo());
//	        propertyInfo.setOwnerName(form.getOwnerName());
//	        propertyInfo.setOwnerIdCard(form.getOwnerIdCard());
//	        propertyInfo.setOwnerAddress(form.getOwnerAddress());
//	    }
//	    
//	    viewHelper.setPropertyTitle(null);
//	    	    
//	    // Dat dai
//	    viewHelper.setProvinceLand(null);           
//        viewHelper.setPropertyCodeLand(null);        
//        viewHelper.setLandNumber(null);
//        viewHelper.setLandAddress(null);
//        viewHelper.setProvinceName(null);
//        viewHelper.setGivenDateLand(null);
//        viewHelper.setDistrict(null);
//        viewHelper.setMapNumber(null);
//        
//        // Xe oto, xe may
//        viewHelper.setGivenDateVehicle(null);
//        viewHelper.setFrameNumber(null);
//        viewHelper.setMachineNumber(null);
//        viewHelper.setPropertyCodeVehicle(null);
//        
//        // Tai san khac
//        viewHelper.setPropertyCodeOther(null);
//        viewHelper.setPropertyOtherInfo(null);  
//        
//        // Chu so huu
//        viewHelper.setOwnerName(null);
//        viewHelper.setOwnerIdCard(null);
//        viewHelper.setOwnerAddress(null);
//	    
//	    propertyList.add(propertyInfo);
//	    
//	    context.setPropertyList(propertyList);	    
//	    viewHelper.setPropertyList(propertyList);
//		
//		return mapping.findForward(SUCCESS);
//	}
//    
//    public ActionForward back(ActionMapping mapping, ActionForm formpro, HttpServletRequest request, HttpServletResponse response)
//    throws Exception {
//    	
//    	PropertyListViewHelper viewHelper = (PropertyListViewHelper)request.getSession().getAttribute(PropertyListViewHelper.SESSION_KEY);    	
//    	ContractViewHelper contractViewHelper = (ContractViewHelper)request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
//    	if (viewHelper == null || contractViewHelper == null) {
//		    return mapping.findForward(NO_LOGIN);
//		}
//    	
//    	
//    	contractViewHelper.setPropertyList(viewHelper.getPropertyList());
//		if(contractViewHelper.getFromRegistScreen().equals(Boolean.TRUE)){
//			return mapping.findForward(REGIST);
//		} else {
//			return mapping.findForward(UPDATE);
//		}
    	
    	return mapping.findForward(SUCCESS);
    }
    
    public ActionForward editProperty(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
    throws Exception {
			
//			PropertyListForm contractForm = (PropertyListForm)form;
//			       
//			ContractViewHelper contractViewHelper = (ContractViewHelper)request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
//			if (contractViewHelper == null) {
//			    return mapping.findForward(NO_LOGIN);
//			}
//			
//			//contractViewHelper.reset(contractForm);
//			String index = contractForm.getIndexSelected();
//			int id = -1;
//			if (EditString.isNumber(index)) {
//				id = Integer.parseInt(index);
//			}
//			
//			List<PropertyInfo> propertyList = contractViewHelper.getPropertyList();
//			propertyList.get(id).setType(contractForm.getPropertyTypePopup());
//			propertyList.get(id).setTitle(contractForm.getTitlePopup());
//			if (LAND_TYPE.equals(contractForm.getPropertyTypePopup())) {
//			    propertyList.get(id).setProvince(contractForm.getProvinceLandPopup());
//			    propertyList.get(id).setDistrict(contractForm.getDistrictPopup());
//			    propertyList.get(id).setCode(contractForm.getPropertyCodeLandPopup());
//			    propertyList.get(id).setGivenDate(RelateDateTime.toTimestamp(false, contractForm.getGivenDateLandPopup()));
//			    propertyList.get(id).setMapNumber(contractForm.getMapNumberPopup());
//			    propertyList.get(id).setLandNumber(contractForm.getLandNumberPopup());
//			    propertyList.get(id).setLandAddress(contractForm.getLandAddressPopup());
//			    propertyList.get(id).setOwnerName(contractForm.getOwnerNamePopup());
//			    propertyList.get(id).setOwnerIdCard(contractForm.getOwnerIdCardPopup());
//			    propertyList.get(id).setOwnerAddress(contractForm.getOwnerAddressPopup());
//			   
//			} else if (VEHICLE_CAR_TYPE.equals(contractForm.getPropertyTypePopup())
//			        || VEHICLE_MOTOR_TYPE.equals(contractForm.getPropertyTypePopup())) {
//			    propertyList.get(id).setCode(contractForm.getPropertyCodeVehiclePopup());
//			    propertyList.get(id).setProvince(contractForm.getProvinceVehiclePopup());
//			    propertyList.get(id).setGivenDate(RelateDateTime.toTimestamp(false, contractForm.getGivenDateVehiclePopup()));
//			    propertyList.get(id).setFrameNumber(contractForm.getFrameNumberPopup());
//			    propertyList.get(id).setMachineNumber(contractForm.getMachineNumberPopup());
//			    propertyList.get(id).setOwnerName(contractForm.getOwnerNamePopup());
//			    propertyList.get(id).setOwnerIdCard(contractForm.getOwnerIdCardPopup());
//			    propertyList.get(id).setOwnerAddress(contractForm.getOwnerAddressPopup());
//			    
//			} else if (OTHER_TYPE.equals(contractForm.getPropertyTypePopup())) {
//			    propertyList.get(id).setCode(contractForm.getPropertyCodeOtherPopup());
//			    propertyList.get(id).setOtherInfo(contractForm.getPropertyOtherInfoPopup());
//			    propertyList.get(id).setOwnerName(contractForm.getOwnerNamePopup());
//			    propertyList.get(id).setOwnerIdCard(contractForm.getOwnerIdCardPopup());
//			    propertyList.get(id).setOwnerAddress(contractForm.getOwnerAddressPopup());
//			}
//			
//			PropertyListViewHelper viewHelper = (PropertyListViewHelper)request.getSession().getAttribute(PropertyListViewHelper.SESSION_KEY);
//			viewHelper.setPropertyList(propertyList);
//			viewHelper.setIsShowAdd(contractForm.getIsShowAdd());
			
			return mapping.findForward(SUCCESS);
			}
}
