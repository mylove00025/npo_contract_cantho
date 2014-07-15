/**
 * 
 */
package com.osp.npo.app.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.context.PreventContext;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractAppendixListViewHelper;
import com.osp.npo.app.viewhelper.ContractViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.contract.ContractList;
import com.osp.npo.core.contract.ContractPropertyInfo;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.core.contract.PropertyInfo;
import com.osp.npo.core.contract.PropertyList;
import com.osp.npo.core.contractHistory.ContractHistoryInfo;
import com.osp.npo.core.prevent.TransactionPropertyList;
import com.osp.npo.core.synchronize.SynchronizeInfo;
import com.osp.npo.service.BasicDataService;
import com.osp.npo.service.ContractHistoryService;
import com.osp.npo.service.ContractService;
import com.osp.npo.service.PreventService;
import com.osp.npo.service.SynchronizeService;
import com.osp.npo.service.UserService;

/**
 * @author SonHD
 * @version $Revision: 29789 $
 */
public class ContractDetailAction extends BaseMDAction {
    private static final String SUCCESS = "success";
    private static final String SUCCESSCONTRACT = "successcontract";
    private static final String SUCCESSPREVENT = "successprevent";
    public static final String FAILURE_PATH = "failure";
    public static final String FAILURE_PREVENT_PATH = "failureprevent";
    public static final String NO_LOGIN = "nologin";
    private static final String DEFAULT_ROLE = "00";
    private static final String NOTARY_ROLE = "02";
    private static final String DRAFTER_ROLE = "03";
    private static final String ORDER_FIELD_CONTRACT_TEMPLATE = "name";
    private static final String ORDER_FIELD_USER = "first_name";
    private static final String ORDER_FIELD_BANK = "order_number";
    private static final String CONTRACT_ID = "id";
    private static final String ID_FROM_PREVENT = "cid";
    public static final String UPLOAD_FOLDER_KEY = "system_contract_folder";
    public static final String CONTRACT_FILE_NAME_PREFIX = "CNTR_";
    private static final String HAS_NONE_PROPERTY = "0";
    private static final String HAS_ONE_PROPERTY = "1";
    private static final Integer MAX_LENGTH_FILE = 50;
   
    
    @SuppressWarnings({ "unchecked" })
    public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        createTitle(Constants.SCREEN_CNTR018);
        MessageUtil messageUtil = new MessageUtil();
        HttpSession session = request.getSession();
        ContractViewHelper contractViewHelper;
        if (request.getParameter(CONTRACT_ID) != null) {
            contractViewHelper = new ContractViewHelper();
            contractViewHelper.setFromContractList(Boolean.TRUE);
        } else if (request.getParameter(ID_FROM_PREVENT) != null) {
            contractViewHelper = new ContractViewHelper();
            contractViewHelper.setFromContractList(Boolean.FALSE);
            PreventContext preventContext = (PreventContext)session.getAttribute(PreventContext.SESSION_KEY);
            preventContext.setDisplayPreventList(false);
        } else {
            contractViewHelper = (ContractViewHelper) request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
            if (contractViewHelper == null) {
                contractViewHelper = new ContractViewHelper();
            }
            contractViewHelper.setFromContractList(Boolean.TRUE);
        }

        BasicDataService basicDataService = new BasicDataService(getConnection());
        UserService userService = new UserService(getConnection());
        ContractService contractService = new ContractService(getConnection());

        // Set default value for first view
        basicDataService.addOrderFieldBank(new OrderField(ORDER_FIELD_BANK));
        contractViewHelper.setBankList(basicDataService.queryAllBank(false).getList());

        userService.setActiveFlgFilter(Boolean.TRUE);
        userService.setHiddenFlgFilter(Boolean.FALSE);
        userService.setRoleFilter(new String[]{DRAFTER_ROLE});
        userService.addOrderFieldUser(new OrderField(ORDER_FIELD_USER));
        contractViewHelper.setDrafterList(userService.queryAllUser(false).getList());
        userService.setRoleFilter(new String[]{NOTARY_ROLE});
        contractViewHelper.setNotaryList(userService.queryAllUser(false).getList());

        contractService.addOrderFieldContractTemplate(new OrderField(ORDER_FIELD_CONTRACT_TEMPLATE));
        contractViewHelper.setContractTemplateList(contractService.queryAllContractTemplate(false).getList());
        Long contractId = (long) 0;
        // Copy data from database to view helper
        if (request.getParameter(CONTRACT_ID) != null) {
            contractId = Long.parseLong(request.getParameter(CONTRACT_ID));
        } else {
            contractId = contractViewHelper.getContractId();
        }
        if (request.getParameter(ID_FROM_PREVENT) != null) {
            contractId = Long.parseLong(request.getParameter(ID_FROM_PREVENT));
        }
        contractService.setContractIdFilter(contractId);
        ContractInfo contractInfo = contractService.queryContractById(false);
        if (contractInfo == null) {
            if (request.getParameter(ID_FROM_PREVENT) != null) {
                ActionErrors errors = new ActionErrors();
                errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract"));
                this.addErrors(request, errors);
                return mapping.findForward(FAILURE_PREVENT_PATH);
            } else {
                ActionErrors errors = new ActionErrors();
                errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract"));
                this.addErrors(request, errors);
                return mapping.findForward(FAILURE_PATH);
            }
        }

        contractViewHelper.setContractId(contractInfo.getId());
        contractViewHelper.setContractKindId(contractInfo.getContractKindId());
        contractViewHelper.setContractKindName(contractInfo.getContractKindName());
        contractViewHelper.setContractTemplateId(contractInfo.getContractTemplateId());
        contractViewHelper.setContractTemplateName(contractInfo.getContractTemplateName());
        contractViewHelper.setContractTemplateCode(contractInfo.getContractTemplateCode());
        if (contractInfo.getRelateObjectATitle()!=null && !SystemMessageProperties.getSystemProperty("item_relation_object").equals(contractInfo.getRelateObjectATitle()))
        	contractViewHelper.setRelateObjectATitle(contractInfo.getRelateObjectATitle());
        	else contractViewHelper.setRelateObjectATitle(SystemMessageProperties.getSystemProperty("item_relation_objectA"));
        if (contractInfo.getRelateObjectBTitle()!=null && !SystemMessageProperties.getSystemProperty("item_relation_object").equals(contractInfo.getRelateObjectBTitle()))
        	contractViewHelper.setRelateObjectBTitle(contractInfo.getRelateObjectBTitle());
        	else contractViewHelper.setRelateObjectBTitle(SystemMessageProperties.getSystemProperty("item_relation_objectB"));
        if (contractInfo.getRelateObjectCTitle()!=null && !SystemMessageProperties.getSystemProperty("item_relation_object").equals(contractInfo.getRelateObjectCTitle()))
        	contractViewHelper.setRelateObjectCTitle(contractInfo.getRelateObjectCTitle());
        	else contractViewHelper.setRelateObjectCTitle(SystemMessageProperties.getSystemProperty("item_relation_objectC"));
        contractViewHelper.setRelateObjectNumber(contractInfo.getRelateObjectNumber());
        contractViewHelper.setContractNumber(contractInfo.getContractNumber());
        contractViewHelper.setContractValue(contractInfo.getContractValue());
        contractViewHelper.setNotaryId(contractInfo.getNotaryId());
        contractViewHelper.setNotaryFamilyName(contractInfo.getNotaryFamilyName());
        contractViewHelper.setNotaryFirstName(contractInfo.getNotaryFirstName());
        contractViewHelper.setDrafterId(contractInfo.getDrafterId());
        contractViewHelper.setDrafterFamilyName(contractInfo.getDrafterFamilyName());
        contractViewHelper.setDrafterFirstName(contractInfo.getDrafterFirstName());
        contractViewHelper.setContractNote(EditString.replaceChangeLine(contractInfo.getNote()));
        contractViewHelper.setContractSummary(contractInfo.getContractSummary());
        if (contractViewHelper.getContractSummary() != null) {
            contractViewHelper.setContractSummary(contractViewHelper.getContractSummary().replace("\n", "<br/>"));
        }
        if (contractInfo.getReceivedDate() != null) {
            contractViewHelper.setReceivedDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, contractInfo.getReceivedDate()));
        }
        if (contractInfo.getNotaryDate() != null) {
            contractViewHelper.setNotaryDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, contractInfo.getNotaryDate()));
        }
        contractViewHelper.setCostTt91(contractInfo.getCostTt91());
        contractViewHelper.setCostDraft(contractInfo.getCostDraft());
        contractViewHelper.setCostNotaryOutsite(contractInfo.getCostNotaryOutsite());
        contractViewHelper.setCostOtherDetermine(contractInfo.getCostOtherDetermine());
        contractViewHelper.setCostTotal(contractInfo.getCostTotal());
        contractViewHelper.setNotaryPlaceFlag(contractInfo.getNotaryPlaceFlag());
        contractViewHelper.setNotaryPlace(contractInfo.getNotaryPlace());
        contractViewHelper.setBankId(contractInfo.getBankId());
        contractViewHelper.setBankName(contractInfo.getBankName());
        contractViewHelper.setBankServiceFee(contractInfo.getBankServiceFee());
        contractViewHelper.setCrediterName(contractInfo.getCrediterName());
        contractViewHelper.setFileName(contractInfo.getFileName());
        contractViewHelper.setFilePath(contractInfo.getFilePath());
        
        if (EditString.isNull(contractInfo.getFileName()) || EditString.isNull(contractInfo.getFilePath())) {
            contractViewHelper.setFileExisted(Boolean.FALSE);
            contractViewHelper.setFileNameDisp(null);
        } else {
            contractViewHelper.setFileExisted(Boolean.TRUE);
        }
        contractViewHelper.setOriginalStorePlace(contractInfo.getOriginalStorePlace());
        contractViewHelper.setErrorStatus(contractInfo.getErrorStatus());
        contractViewHelper.setErrorDescription(contractInfo.getErrorDescription());
        contractViewHelper.setErrorUserFamilyName(contractInfo.getErrorUserFamilyName());
        contractViewHelper.setErrorUserFirstName(contractInfo.getErrorUserFirstName());
        contractViewHelper.setUserRequireContract(contractInfo.getUserRequireContract());
        contractViewHelper.setAdditionStatus(contractInfo.getAdditionStatus());
        contractViewHelper.setAdditionDescription(contractInfo.getAdditionDescription());
        contractViewHelper.setCancellationStatus(contractInfo.getCancelStatus());
        contractViewHelper.setCancellationDescription(contractInfo.getCancelDescription());
        contractViewHelper.setCancellationRelationContractId(contractInfo.getCancelRelationContractId());
        if ((contractInfo.getAdditionStatus() == Boolean.TRUE) || (contractInfo.getCancelStatus() == Boolean.TRUE)
                || (contractInfo.getErrorStatus() == Boolean.TRUE)) {
            contractViewHelper.setContractStatus(Boolean.TRUE);
        } else {
            contractViewHelper.setContractStatus(Boolean.FALSE);
        }
        contractViewHelper.setNumberCopyOfContract(contractInfo.getNumberCopyOfContract());
        contractViewHelper.setNumberOfPage(contractInfo.getNumberOfPage());
        if (EditString.isNull(contractInfo.getFileName()) || EditString.isNull(contractInfo.getFilePath())) {
            contractViewHelper.setFilePath("--");
            contractViewHelper.setFileName(SystemMessageProperties.getSystemProperty("msg_file_not_exist"));
        } else {
            contractViewHelper.setFilePath(contractInfo.getFilePath());
            contractViewHelper.setFileName(contractInfo.getFileName());
            contractViewHelper.setFileNameDisp(EditString.getFileNameDisp(contractInfo.getFileName(), MAX_LENGTH_FILE));
        }
        if ((contractInfo.getDrafterId() != null) && (contractInfo.getDrafterId().equals(contractInfo.getErrorUserId()))) {
            contractViewHelper.setErrorAgent(DRAFTER_ROLE);
        }

        if (contractInfo.getNotaryId().equals(contractInfo.getErrorUserId())) {
            contractViewHelper.setErrorAgent(NOTARY_ROLE);
        }

        if (EditString.isNull(contractViewHelper.getErrorAgent())) {
            contractViewHelper.setErrorAgent(DEFAULT_ROLE);
        }

        contractViewHelper.setEntryUserName(contractInfo.getEntryUserName());
        if (contractInfo.getEntryDateTime() != null) {
            contractViewHelper.setEntryDateTime(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, contractInfo.getEntryDateTime()));
        }
        contractViewHelper.setUpdateUserName(contractInfo.getUpdateUserName());
        if (contractInfo.getUpdateDateTime() != null) {
            contractViewHelper.setUpdateDateTime(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, contractInfo.getUpdateDateTime()));
        }
        
        contractViewHelper.setRelationObjectA(contractInfo.getRelationObjectADisp());
        contractViewHelper.setRelationObjectB(contractInfo.getRelationObjectBDisp());
        contractViewHelper.setRelationObjectC(contractInfo.getRelationObjectCDisp());

        //DistrictInfo districtInfo =new DistrictInfo();
        List<PropertyInfo> propertyList = new ArrayList<PropertyInfo>();
        contractService.setContractPropertyIdFilter(contractId);
        List<ContractPropertyInfo> contractPropertyList = contractService.queryAllContractProperty(false).getList();
        if (contractPropertyList.size() < 1) {
            contractViewHelper.setNumberProperty(HAS_NONE_PROPERTY);
            contractViewHelper.setLandStreet("");
            contractViewHelper.setLandDistrict("");
        } else {
            contractViewHelper.setNumberProperty(HAS_ONE_PROPERTY);
            contractService.setPropertyIdFilter(contractPropertyList.get(0).getPropertyId());
            PropertyInfo propertyInfo = contractService.queryAllProperty(false).get(0);
            contractViewHelper.setType(propertyInfo.getType());
            contractViewHelper.setPropertyInfo(propertyInfo.getPropertyInfo());
            contractViewHelper.setOwnerInfo(propertyInfo.getOwnerInfo());
            contractViewHelper.setOtherInfo(propertyInfo.getOtherInfo());
            contractViewHelper.setLandDistrict(propertyInfo.getLandDistrict());  
            contractViewHelper.setLandStreet(propertyInfo.getLandStreet());
          
        }
        
        ContractTemplateInfo contractTemplateInfo = contractService.queryContractTemplateInfoById(contractInfo.getContractTemplateId(), false);
        if (contractTemplateInfo.getPeriodFlag()) {
	        contractViewHelper.setContractPeriodFlag(Boolean.TRUE);	
	        contractViewHelper.setContractPeriod(contractInfo.getContractPeriod());
        } else  contractViewHelper.setContractPeriodFlag(Boolean.FALSE);	
        if (contractTemplateInfo.getMortageCancelFunc() || contractInfo.getMortageCancelFlag()) {
        	contractViewHelper.setMortageCancelDisplayFlag(Boolean.TRUE);
        	contractViewHelper.setMortageCancelFlag(contractInfo.getMortageCancelFlag());
        	contractViewHelper.setMortageCancelDate(contractInfo.getMortageCancelDate());
        	contractViewHelper.setMortageCancelNote(contractInfo.getMortageCancelNote());
        } else contractViewHelper.setMortageCancelDisplayFlag(Boolean.FALSE);
        
   
       
        
        
          
        ContractAppendixListViewHelper appendixListViewHelper = new ContractAppendixListViewHelper();
        
        ContractList contractList = contractService.queryAppendixContract(false);
        
        appendixListViewHelper.setContractList(contractList.getList());
        

        contractViewHelper.setPropertyList(propertyList);
        session.setAttribute(ContractViewHelper.SESSION_KEY, contractViewHelper);
        session.setAttribute(ContractAppendixListViewHelper.SESSION_KEY, appendixListViewHelper);
        return mapping.findForward(SUCCESS);
    }

    public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        ContractViewHelper helper = (ContractViewHelper) request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
        if (helper == null) {
            return mapping.findForward(NO_LOGIN);
        }
        File file = new File(helper.getFilePath());

        if (file.exists() && file.canRead() && file.isFile() && file.length() < Integer.MAX_VALUE) {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + helper.getFileName() + "\"");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "max-age=0");
            ServletOutputStream out = response.getOutputStream();
            FileInputStream fstream = new FileInputStream(file);
            DataInputStream in = new DataInputStream(fstream);
            long length = file.length();
            byte[] b = new byte[(int) length];
            in.read(b);
            out.write(b);
            out.flush();
            out.close();
            in.close();
            return null;
        } else {
            ActionErrors errors = new ActionErrors();
            MessageUtil messageUtil = new MessageUtil();
            errors.add(messageUtil.createActionMessages("", "err_file_not_found"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }
    }

    /**
     * 
     * Delete contract record
     * 
     * @author SonHD
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return success
     * @throws ServletException
     * @throws SQLException
     * @throws Exception
     */
    public ActionForward remove(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {

        ContractViewHelper helper = (ContractViewHelper)request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
        if (helper == null) {
            return mapping.findForward(NO_LOGIN);
        }
        
        CommonContext commonContext = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);
        if (commonContext == null) {
            return mapping.findForward(NO_LOGIN);
        }
        MessageUtil messageUtil = new MessageUtil();
		ContractService contractService = new ContractService(getConnection());
		contractService.setContractIdFilter(helper.getContractId());
        ContractInfo contractInfo1 = contractService.queryContractById(false);  

        if (contractInfo1 == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }
        
//        if (!commonContext.isContractDelete()) {
//        	ActionErrors errors = new ActionErrors();
//            errors.add("", new ActionMessage("err_access_deny"));
//            this.addErrors(request, errors);
//            return mapping.findForward(FAILURE_PATH);
//        }
        
//        ContractService contractService = new ContractService(getConnection());
        contractService.setContractIdPropertyFilter(helper.getContractId());
        PropertyList propertyList = contractService.queryAllPropertyByContract(Boolean.FALSE);
      
        // Contract History
        ContractHistoryInfo contractHistoryInfo = new ContractHistoryInfo();
        contractService.setContractIdFilter(helper.getContractId());
        ContractInfo contractInfo = contractService.queryContractById(false);
        contractHistoryInfo.setContractId(contractInfo.getId());
        String contractContent= contractService.entryHistory(contractInfo);
       
        contractHistoryInfo.setContractNumber(contractInfo.getContractNumber());
        contractHistoryInfo.setContractContent(contractContent);
        contractHistoryInfo.setClientInfo(getClientInfo(request));
        createEntryUserInfo(contractHistoryInfo);
        contractHistoryInfo.setExecutePerson(contractHistoryInfo.getEntryUserName());   
        contractHistoryInfo.setExecuteDateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        contractHistoryInfo.setExecuteContent(SystemMessageProperties.getSystemProperty("PREVENT_DELETE"));
        ContractHistoryService contractHistoryService = new ContractHistoryService(getConnection());
        contractHistoryService.entryContractHistory(contractHistoryInfo);
        //
        
        // remove file
        File file = new File(helper.getFilePath());
        file.delete();

        //remove property
        if (propertyList.size() > 0) {
            contractService.removeProperty(propertyList.get(0).getId());
        }
        
        //remove transaction property
        PreventService preventService = new PreventService(getConnection());
        preventService.setContractIdFilter(helper.getContractId());
        TransactionPropertyList transactionPropertyList = preventService.queryAllTransactionProperty(Boolean.FALSE);
        if (transactionPropertyList.size() > 0) {
            preventService.removeTransactionProperty(transactionPropertyList.get(0).getTpid());
            
            //entry synchronize
            SynchronizeInfo synchronizeInfo = new SynchronizeInfo();
            synchronizeInfo.setType(Constants.SYNCHRONIZE_TYPE_TRANSACTION);
            synchronizeInfo.setAction(Constants.SYNCHRONIZE_ACTION_DELETE);
            synchronizeInfo.setDataId(transactionPropertyList.get(0).getSynchronizeId());
            synchronizeInfo.setAuthenticationId(commonContext.getSystemOfficeAuthorityID());
            synchronizeInfo.setEntryDateTime(RelateDateTime.getTimeNow());
            SynchronizeService synService = new SynchronizeService(getConnection());
            synService.entrySynchronize(synchronizeInfo);
            
        }
        
        contractService.removeContract(helper.getContractId());
        
//        // add lost number
//        String check = EditString.getNumber(contractInfo.getContractNumber());
//        if (check!=null) {
//			CommonService commonService = new CommonService(getConnection());
//			LostNumberService lostNumberService = new LostNumberService(getConnection());
//        	Long checkNumber = Long.parseLong(check);
//        	LostNumberInfo lostNumberInfo = new LostNumberInfo();
//			lostNumberInfo.setYear(Calendar.getInstance().get(Calendar.YEAR));
//			SystemConfigInfo systemConfigInfo = commonService
//			.querySystemConfigByKey("number_formula", false);
//			String numberFormula = systemConfigInfo.getConfigValue();
//			if (numberFormula.contains("#NUM#")) {
//				lostNumberInfo.setKindId(TOTAL_NUMBER);
//			} else lostNumberInfo.setKindId(contractInfo.getContractKindId());
//			
//			lostNumberInfo.setLostContractNumber(checkNumber);
//			lostNumberService.entryLostNumber(lostNumberInfo);
//        }

        //
             
        
        
        getConnection().commit();

        ActionMessages messages = new ActionMessages();
        messages.add(new MessageUtil().createActionMessages("", request, "msg_delete_success", "item_contract"));
        this.addMessages(request, messages);
        if (helper.getFromContractList()) {
            return mapping.findForward(SUCCESSCONTRACT);
        } else {
            return mapping.findForward(SUCCESSPREVENT);
        }
    }
}