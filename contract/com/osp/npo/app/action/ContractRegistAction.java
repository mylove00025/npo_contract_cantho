package com.osp.npo.app.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.form.ContractForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractViewHelper;
import com.osp.npo.app.viewhelper.TemporaryContractViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.FileUtil;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.appendix.ContractAppendixInfo;
import com.osp.npo.core.appendix.ContractAppendixList;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.contract.ContractPropertyInfo;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.core.contract.ContractTemplateList;
import com.osp.npo.core.contract.PropertyInfo;
import com.osp.npo.core.contract.PropertyList;
import com.osp.npo.core.contractHistory.ContractHistoryInfo;
import com.osp.npo.core.customer.CustomerInfo;
import com.osp.npo.core.customer.CustomerList;
import com.osp.npo.core.prevent.TransactionPropertyInfo;
import com.osp.npo.core.prevent.TransactionPropertyList;
import com.osp.npo.core.synchronize.SynchronizeInfo;
import com.osp.npo.core.temporaryContract.TemporaryContractInfo;
import com.osp.npo.core.user.UserList;
import com.osp.npo.service.AppendixService;
import com.osp.npo.service.BasicDataService;
import com.osp.npo.service.CommonService;
import com.osp.npo.service.ContractHistoryService;
import com.osp.npo.service.ContractKindService;
import com.osp.npo.service.ContractService;
import com.osp.npo.service.CustomerService;
import com.osp.npo.service.PreventService;
import com.osp.npo.service.SynchronizeService;
import com.osp.npo.service.TemporaryContractService;
import com.osp.npo.service.UserService;

/**
 * <P>Contract Regist Action</P>
 *
 * @author HungPT
 * @version $Revision: 29789 $
 */
@SuppressWarnings("unchecked")
public class ContractRegistAction extends BaseMDAction {

    private static final String SUCCESS = "success";
    private static final String FAILURE_PATH = "failure";
    public static final String FAILURE_PATH2 = "deleted";
    public static final String GENERATE_FAILURE = "generatefail";
    private static final String NO_LOGIN = "nologin";
    private static final String NOTARY_ROLE = "02";
    private static final String DRAFTER_ROLE = "03";
    private static final Long BANK_NONE_SELECTED = 0L;
    private static final String ORDER_FIELD_CONTRACT_TEMPLATE = "name";
    private static final String ORDER_FIELD_USER = "first_name";
    private static final String ORDER_FIELD_BANK = "order_number";

    private static final String NPO_CONTRACT_TEMPLATE = "npo_contract_template";
    private static final String NPO_USER = "npo_user";
    private static final String NPO_BANK = "npo_bank";
    private static final String CONTRACT_TEMPLATE_ID = "id";
	private static final String CREATE_COPY_ID = "id";
    private static final String USER_ID = "id";
    private static final String BANK_ID = "id";
    private static final String CANCELLATION_CONTRACT_ID = "contractid";
    private static final String CREATE_APPENDIX_ID = "contractid";

    private static final String UPLOAD_FOLDER_KEY = "system_contract_folder";
    private static final String CONTRACT_FILE_NAME_PREFIX = "CNTR_";

    private static final String LAND_TYPE = "01";
    private static final String VEHICLE_TYPE = "02";
    private static final String OTHER_TYPE = "99";
    private static final String DISPLAY = "1";
    private static final long FREQUENCY = 1;

    //private static final String ORDER_FIELD_PROVINCE = "order_number";
    //private static final String ORDER_FIELD_DISTRICT = "order_number";

    private static final String CONTRACT_NUMBER_DEFAULT = "/";
    private static final String DOT = "\\.";
    
    private static final Byte TEMPORARY_TYPE_SIGNED = 1;
    

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

        createTitle(Constants.SCREEN_CNTR003);

        HttpSession session = request.getSession();

        //delete session
        if (session.getAttribute(ContractViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(ContractViewHelper.SESSION_KEY);
        }

        ContractViewHelper contractViewHelper = new ContractViewHelper();

        loadDefault(contractViewHelper);

        contractViewHelper.setPropertyList(new ArrayList<PropertyInfo>());

        contractViewHelper.setContractNumber(CONTRACT_NUMBER_DEFAULT + Calendar.getInstance().get(Calendar.YEAR));
//        contractViewHelper.setNotaryDate(RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()));
//        contractViewHelper.setReceivedDate(RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()));
        contractViewHelper.setNotaryPlaceFlag(Boolean.TRUE);

        session.setAttribute(ContractViewHelper.SESSION_KEY, contractViewHelper);

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
    public ActionForward viewFromTempo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        createTitle(Constants.SCREEN_CNTR003);

        ContractViewHelper contractViewHelper = (ContractViewHelper)request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
        if (contractViewHelper == null) {
            contractViewHelper = new ContractViewHelper();
        }

        loadDefault(contractViewHelper);

        //String forward = loadContractInfo(mapping, request, contractViewHelper, request.getParameter(TEMPORARY_ID));
        
        contractViewHelper.setFromTemporaryContract(Boolean.TRUE);

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
    public ActionForward viewForCancellation(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        createTitle(Constants.SCREEN_CNTR003);

        ContractViewHelper contractViewHelper = new ContractViewHelper();

        loadDefault(contractViewHelper);

        String forward = loadCancellationContractInfo(mapping, request, contractViewHelper, request.getParameter(CANCELLATION_CONTRACT_ID));

        request.getSession().setAttribute(ContractViewHelper.SESSION_KEY, contractViewHelper);

        return mapping.findForward(forward);

    }
    
    /**
     * <P>Action for first view</P>
     *
     * @author HungNM
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward viewForCreateAppendix(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        createTitle(Constants.SCREEN_CNTR003);

        ContractViewHelper contractViewHelper = new ContractViewHelper();

        loadDefault(contractViewHelper);

        String forward = loadAppendixInfo(mapping, request, contractViewHelper, request.getParameter(CREATE_APPENDIX_ID));

        request.getSession().setAttribute(ContractViewHelper.SESSION_KEY, contractViewHelper);

        return mapping.findForward(forward);

    }
    
    /**
     * <P>Action for first view</P>
     *
     * @author HungNM
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward viewForCreateCopy(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        createTitle(Constants.SCREEN_CNTR003);

        ContractViewHelper contractViewHelper = new ContractViewHelper();

        loadDefault(contractViewHelper);

        String forward = loadCopyInfo(mapping, request, contractViewHelper, request.getParameter(CREATE_COPY_ID));

        request.getSession().setAttribute(ContractViewHelper.SESSION_KEY, contractViewHelper);

        return mapping.findForward(forward);

    }

    /**
     * <P>Action for regist</P>
     *
     * @author HungPT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward regist(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	

        CommonContext commonContext = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);
        
        ContractViewHelper contractViewHelper = (ContractViewHelper)request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
        if (contractViewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }

        MessageUtil messageUtil = new MessageUtil();

        ContractForm contractForm = (ContractForm)form;

        contractViewHelper.reset(contractForm);

        UserService userService = new UserService(getConnection());
        ContractService contractService = new ContractService(getConnection());
        
     

        //Check existance of data
        if (!contractService.isExistContractTemplateInDB(NPO_CONTRACT_TEMPLATE,
                                                            new Object[][] {{CONTRACT_TEMPLATE_ID, contractForm.getContractTemplateId()}})) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_data_already_deleted", "item_contract_template_name"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

//        if (!userService.isExistInDB(NPO_USER, new Object[][] {{USER_ID, contractForm.getNotaryId()}})) {
//            ActionErrors errors = new ActionErrors();
//            errors.add(messageUtil.createActionMessages("", request, "err_data_already_deleted", "item_notary"));
//            this.addErrors(request, errors);
//            return mapping.findForward(FAILURE_PATH);
//        }
//
//        if (userService.isExistInDB(NPO_USER, new Object[][] {{USER_ID, contractForm.getNotaryId()}, {"active_flg", false}})) {
//            ActionErrors errors = new ActionErrors();
//            errors.add(messageUtil.createActionMessages("", request, "err_user_inactive", "item_selected_notary"));
//            this.addErrors(request, errors);
//            return mapping.findForward(SUCCESS);
//        }

//        if (DISPLAY.equals(commonContext.getContractDrafter())
//                && !userService.isExistInDB(NPO_USER, new Object[][] {{USER_ID, contractForm.getDrafterId()}})) {
//            ActionErrors errors = new ActionErrors();
//            errors.add(messageUtil.createActionMessages("", request, "err_data_already_deleted", "item_drafter_report"));
//            this.addErrors(request, errors);
//            return mapping.findForward(FAILURE_PATH);
//        }

//        if (DISPLAY.equals(commonContext.getContractDrafter())
//                && userService.isExistInDB(NPO_USER, new Object[][] {{USER_ID, contractForm.getDrafterId()}, {"active_flg", false}})) {
//            ActionErrors errors = new ActionErrors();
//            errors.add(messageUtil.createActionMessages("", request, "err_user_inactive", "item_selected_drafter"));
//            this.addErrors(request, errors);
//            return mapping.findForward(SUCCESS);
//        }
//
//        if (contractForm.getBankId() != 0 && !userService.isExistInDB(NPO_BANK, new Object[][] {{BANK_ID, contractForm.getBankId()}})) {
//            ActionErrors errors = new ActionErrors();
//            errors.add(messageUtil.createActionMessages("", request, "err_data_already_deleted", "item_bank_name"));
//            this.addErrors(request, errors);
//            return mapping.findForward(FAILURE_PATH);
//        }

        if (contractService.isExistContractNumber(contractForm.getContractNumber())) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_data_already_exist", "item_contract"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        //Set contract info
        ContractInfo contractInfo = new ContractInfo();
        contractInfo.setId(contractForm.getContractId());
        contractInfo.setContractTemplateId(contractForm.getContractTemplateId());
        contractInfo.setContractNumber(contractForm.getContractNumber());
        if (!EditString.isNull(contractForm.getContractValue())) {
            contractInfo.setContractValue(contractForm.getContractValue().replaceAll(DOT, ""));
        }
        contractInfo.setRelationObjectA(contractForm.getRelationObjectA());
        contractInfo.setRelationObjectB(contractForm.getRelationObjectB());
        contractInfo.setRelationObjectC(contractForm.getRelationObjectC());
        contractInfo.setNotaryId(commonContext.getUserInfo().getId());
        if (DISPLAY.equals(commonContext.getContractDrafter())) {
            contractInfo.setDrafterId(contractForm.getDrafterId());
        } else {
            contractInfo.setDrafterId(null);
        }
        
        contractInfo.setReceivedDate(RelateDateTime.toTimestamp(contractForm.getReceivedDate()));
        contractInfo.setNotaryDate(RelateDateTime.toTimestamp(contractForm.getNotaryDate()));
        if (!EditString.isNull(contractForm.getCostTt91())) {
            contractInfo.setCostTt91(contractForm.getCostTt91().replaceAll(DOT, ""));
        }
        if (!EditString.isNull(contractForm.getCostDraft())) {
            contractInfo.setCostDraft(contractForm.getCostDraft().replaceAll(DOT, ""));
        }
        if (!EditString.isNull(contractForm.getCostNotaryOutsite())) {
            contractInfo.setCostNotaryOutsite(contractForm.getCostNotaryOutsite().replaceAll(DOT, ""));
        }
        if (!EditString.isNull(contractForm.getCostOtherDetermine())) {
            contractInfo.setCostOtherDetermine(contractForm.getCostOtherDetermine().replaceAll(DOT, ""));
        }
        if (!EditString.isNull(contractForm.getCostTotal())) {
            contractInfo.setCostTotal(contractForm.getCostTotal().replaceAll(DOT, ""));
        }

        if (contractForm.getNotaryPlaceFlag() == null || contractForm.getNotaryPlaceFlag()) {
            contractInfo.setNotaryPlaceFlag(Boolean.TRUE);
        } else {
            contractInfo.setNotaryPlaceFlag(Boolean.FALSE);
            contractInfo.setNotaryPlace(contractForm.getNotaryPlace());
        }

        contractInfo.setContractSummary(contractForm.getContractSummary());
        if (!BANK_NONE_SELECTED.equals(contractForm.getBankId())) {
            contractInfo.setBankId(contractForm.getBankId());
        }
        if (!EditString.isNull(contractForm.getBankServiceFee())) {
            contractInfo.setBankServiceFee(contractForm.getBankServiceFee().replaceAll(DOT, ""));
        }

        contractInfo.setCrediterName(contractForm.getCrediterName());
        contractInfo.setOriginalStorePlace(contractForm.getOriginalStorePlace());
        contractInfo.setNote(contractForm.getContractNote());
        contractInfo.setErrorStatus(false);
        if (contractForm.getAdditionStatus() != null) {
            contractInfo.setAdditionStatus(contractForm.getAdditionStatus());
            contractInfo.setAdditionDescription(contractForm.getAdditionDescription());
        } else {
            contractInfo.setAdditionStatus(Boolean.FALSE);
        }

        contractInfo.setUserRequireContract(contractForm.getUserRequireContract());
        contractInfo.setNumberCopyOfContract(contractForm.getNumberCopyOfContract());
        contractInfo.setNumberOfPage(contractForm.getNumberOfPage());

        createEntryUserInfo(contractInfo);
        /*if (!contractForm.getFileExisted()) {
	        try {
	            String localName = EditString.convertUnicodeToASCII(contractForm.getFormFile().getFileName());
	            String path = "";
	
	            String realname = "";
	            if (!localName.isEmpty()) {
	                Integer dot = localName.lastIndexOf(EXTENSION_SEPARATOR);
	                String fileExtension = "";
	                if (dot > 0) {
	                    fileExtension = localName.substring(dot + 1);
	                }
	
	                realname = CONTRACT_FILE_NAME_PREFIX + RelateDateTime.formatDate(RelateDateTime.YYYYMMDDHHMISS, contractInfo.getEntryDateTime())
	                                + EXTENSION_SEPARATOR + fileExtension;
	                path = SystemProperties.getProperty(UPLOAD_FOLDER_KEY) + SLASH + realname;
	
	                FileOutputStream outputStream = null;
	                outputStream = new FileOutputStream(new File(path));
	                outputStream.write(contractForm.getFormFile().getFileData());
	            }
	            if (!EditString.isNull(localName)) {
	                File file = FileUtil.createNewFile(SystemProperties.getProperty(UPLOAD_FOLDER_KEY), CONTRACT_FILE_NAME_PREFIX);
	                FileOutputStream outputStream = null;
	                outputStream = new FileOutputStream(file);
	                outputStream.write(contractForm.getFormFile().getFileData());
	                path = file.getAbsolutePath();
	            }
	
	            contractViewHelper.setFileName(localName);
	            contractViewHelper.setFilePath(path);
	
	            contractInfo.setFileName(localName);
	            contractInfo.setFilePath(path);
	
	        } catch (IOException e) {
	            ActionErrors errors = new ActionErrors();
	            errors.add(messageUtil.createActionMessages("", "err_cannot_upload_file"));
	            this.addErrors(request, errors);
	            return mapping.findForward(FAILURE_PATH);
	        }
        }
        else{
        	contractInfo.setFileName(contractViewHelper.getFileName());
        	contractInfo.setFilePath(contractViewHelper.getFilePath());
        }*/
        
        contractInfo.setContractPeriod(contractForm.getContractPeriod());
        
        
        //entry contractInfo to database
        contractService.entryContract(contractInfo);
        

        contractViewHelper.setContractId(contractInfo.getId());
        PreventService preventService = new PreventService(getConnection());
        //For cancellation contract
        if (contractViewHelper.getCancellationContractId() != null) {
            contractService.setContractIdFilter(contractViewHelper.getCancellationContractId());
            ContractInfo cancellationcontractInfo = contractService.queryContractById(false);

            if (cancellationcontractInfo == null) {
                ActionErrors errors = new ActionErrors();
                errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract"));
                this.addErrors(request, errors);
                return mapping.findForward(FAILURE_PATH2);
            }
            
            cancellationcontractInfo.setCancelStatus(Boolean.TRUE);
            cancellationcontractInfo.setCancelRelationContractId(contractViewHelper.getContractId());
            cancellationcontractInfo.setCancelDescription(SystemMessageProperties.getSystemProperty("item_cancellation_description")
                    + Constants.SPACE + contractInfo.getContractNumber());
            AppendixService appendixService = new AppendixService(getConnection());
            ContractAppendixList contractAppendixList = appendixService.queryContractAppendix(cancellationcontractInfo.getId());
            if (contractAppendixList!=null) {
            	ContractAppendixInfo contractAppendixInfo = new ContractAppendixInfo();
            	ContractInfo contractInfo2 = new ContractInfo();
            	for (int i = 0; i < contractAppendixList.size(); i++) {
					contractAppendixInfo = contractAppendixList.get(i);
					contractService.setContractIdFilter(contractAppendixInfo.getAppendixCid());
					contractInfo2 = contractService.queryContractById(true);
					if (!contractInfo2.getCancelStatus()) {
					contractInfo2.setCancelStatus(true);
					contractInfo2.setCancelDescription(SystemMessageProperties.getSystemProperty("item_cancellation_description")
                    + Constants.SPACE + contractInfo.getContractNumber());
					contractService.modifyContract(contractInfo2);
					}
				}
            }
            
            createUpdateUserInfo(cancellationcontractInfo);
            contractService.modifyContract(cancellationcontractInfo);
            
            preventService.setContractIdFilter(cancellationcontractInfo.getId());
            TransactionPropertyList transactionPropertyList = preventService.queryAllTransactionProperty(true);
            if (transactionPropertyList!=null) {
            	TransactionPropertyInfo transactionPropertyInfo = transactionPropertyList.get(0);
            	transactionPropertyInfo.setCancelStatus(cancellationcontractInfo.getCancelStatus());
            	transactionPropertyInfo.setCancelDescription(cancellationcontractInfo.getCancelDescription());
            	preventService.modifyTransactionProperty(transactionPropertyInfo);
            	SynchronizeInfo synchronizeInfo = new SynchronizeInfo();
                synchronizeInfo.setType(Constants.SYNCHRONIZE_TYPE_TRANSACTION);
                synchronizeInfo.setAction(Constants.SYNCHRONIZE_ACTION_EDIT);
                synchronizeInfo.setDataId(transactionPropertyInfo.getSynchronizeId());
                synchronizeInfo.setAuthenticationId(commonContext.getSystemOfficeAuthorityID());
                synchronizeInfo.setEntryDateTime(RelateDateTime.getTimeNow());
                SynchronizeService synService = new SynchronizeService(getConnection());
                synService.entrySynchronize(synchronizeInfo);
            }
            
            
            //
            ContractHistoryInfo contractHistoryInfo = new ContractHistoryInfo();
            contractHistoryInfo.setContractId(cancellationcontractInfo.getId());
            String contractContent=contractService.entryHistory(cancellationcontractInfo);
            
            contractHistoryInfo.setContractNumber(cancellationcontractInfo.getContractNumber());
            contractHistoryInfo.setContractContent(contractContent);
            contractHistoryInfo.setClientInfo(getClientInfo(request));
            createEntryUserInfo(contractHistoryInfo);
            contractHistoryInfo.setExecutePerson(contractHistoryInfo.getEntryUserName());       
            contractHistoryInfo.setExecuteDateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));     
            contractHistoryInfo.setExecuteContent(SystemMessageProperties.getSystemProperty("CANCELLATION"));
            ContractHistoryService contractHistoryService = new ContractHistoryService(getConnection());
            contractHistoryService.entryContractHistory(contractHistoryInfo);
            //
        }
        
        //For appendix contract
        if (contractViewHelper.getAppendixId() != null) {
            contractService.setContractIdFilter(contractViewHelper.getCancellationContractId());
            ContractInfo appendixContractInfo = contractService.queryContractById(false);

            if (appendixContractInfo == null) {
                ActionErrors errors = new ActionErrors();
                errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract"));
                this.addErrors(request, errors);
                return mapping.findForward(FAILURE_PATH2);
            }
            AppendixService appendixService = new AppendixService(getConnection());
            ContractAppendixInfo contractAppendixInfo = new ContractAppendixInfo();
            contractAppendixInfo.setAppendixCid(contractInfo.getId());
            contractAppendixInfo.setMainCid(contractViewHelper.getAppendixId());
            appendixService.entryContractAppendix(contractAppendixInfo);
            
            
        }
      
        PropertyInfo propertyInfo = new PropertyInfo();
        propertyInfo.setType(contractForm.getType());
        if (contractForm.getIsDetailPropertyEntry()) {
            if (LAND_TYPE.equals(contractForm.getType())) {
                propertyInfo.setLandAddress(contractForm.getLandAddress());
                propertyInfo.setLandArea(contractForm.getLandArea());
                propertyInfo.setLandCertificate(contractForm.getLandCertificate());
                propertyInfo.setLandIssueDate(RelateDateTime.toTimestamp(false, contractForm.getLandIssueDate()));
                propertyInfo.setLandIssuePlace(contractForm.getLandIssuePlace());
                propertyInfo.setLandMapNumber(contractForm.getLandMapNumber());
                propertyInfo.setLandNumber(contractForm.getLandNumber());
                propertyInfo.setLandPrivateArea(contractForm.getLandPrivateArea());
                propertyInfo.setLandPublicArea(contractForm.getLandPublicArea());
                propertyInfo.setLandUseOrigin(contractForm.getLandUseOrigin());
                propertyInfo.setLandUsePeriod(contractForm.getLandUsePeriod());
                propertyInfo.setLandUsePurpose(contractForm.getLandUsePurpose());
                propertyInfo.setLandAssociateProperty(contractForm.getLandAssociateProperty());
                propertyInfo.setLandDistrict(contractForm.getLandDistrict());
                propertyInfo.setLandStreet(contractForm.getLandStreet());
                
                String info = "";                
                if (!EditString.isNull(contractForm.getLandAddress())) {
                    info += SystemMessageProperties.getSystemProperty("item_address") + Constants.COLON + Constants.SPACE
                            + contractForm.getLandAddress();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }                
                if (!EditString.isNull(contractForm.getLandCertificate())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_code") + Constants.COLON + Constants.SPACE
                            + contractForm.getLandCertificate();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getLandIssuePlace())) {
                    info += SystemMessageProperties.getSystemProperty("item_issue_place") + Constants.COLON + Constants.SPACE
                            + contractForm.getLandIssuePlace();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getLandIssueDate())) {
                    info += SystemMessageProperties.getSystemProperty("item_given_date") + Constants.COLON + Constants.SPACE
                            + contractForm.getLandIssueDate();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getLandNumber())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_number") + Constants.COLON + Constants.SPACE
                            + contractForm.getLandNumber();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getLandMapNumber())) {
                    info += SystemMessageProperties.getSystemProperty("item_map_number") + Constants.COLON + Constants.SPACE
                            + contractForm.getLandMapNumber();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getLandArea())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_area") + Constants.COLON + Constants.SPACE
                            + contractForm.getLandArea();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getLandPrivateArea())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_private_area") + Constants.COLON + Constants.SPACE
                            + contractForm.getLandPrivateArea();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getLandPublicArea())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_public_area") + Constants.COLON + Constants.SPACE
                            + contractForm.getLandPublicArea();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getLandUsePurpose())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_use_purpose") + Constants.COLON + Constants.SPACE
                            + contractForm.getLandUsePurpose();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getLandUsePeriod())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_use_period") + Constants.COLON + Constants.SPACE
                            + contractForm.getLandUsePeriod();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getLandUseOrigin())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_use_origin") + Constants.COLON + Constants.SPACE
                            + contractForm.getLandUseOrigin();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getLandAssociateProperty())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_associate_property") + Constants.COLON + Constants.SPACE
                            + contractForm.getLandAssociateProperty();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                
                if (!EditString.isNull(contractForm.getOwnerInfo())) {
                    info += SystemMessageProperties.getSystemProperty("item_owner") + Constants.COLON + Constants.SPACE
                            + contractForm.getOwnerInfo();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                
                if (!EditString.isNull(contractForm.getOtherInfo())) {
                    info += SystemMessageProperties.getSystemProperty("item_other_info") + Constants.COLON + Constants.SPACE
                            + contractForm.getOtherInfo();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                
                propertyInfo.setPropertyInfo(info);
                
            } else if (VEHICLE_TYPE.equals(contractForm.getType())) {
                propertyInfo.setCarFrameNumber(contractForm.getCarFrameNumber());
                propertyInfo.setCarIssueDate(RelateDateTime.toTimestamp(false, contractForm.getCarIssueDate()));
                propertyInfo.setCarIssuePlace(contractForm.getCarIssuePlace());
                propertyInfo.setCarLicenseNumber(contractForm.getCarLicenseNumber());
                propertyInfo.setCarMachineNumber(contractForm.getCarMachineNumber());
                propertyInfo.setCarRegistNumber(contractForm.getCarRegistNumber());
                
                String info = "";
                if (!EditString.isNull(contractForm.getCarLicenseNumber())) {
                    info += SystemMessageProperties.getSystemProperty("item_vehicle_code") + Constants.COLON + Constants.SPACE
                            + contractForm.getCarLicenseNumber();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getCarRegistNumber())) {
                    info += SystemMessageProperties.getSystemProperty("item_regist_number") + Constants.COLON + Constants.SPACE
                            + contractForm.getCarRegistNumber();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getCarIssuePlace())) { 
                    info += SystemMessageProperties.getSystemProperty("item_issue_place") + Constants.COLON + Constants.SPACE
                            + contractForm.getCarIssuePlace();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getCarIssueDate())) {
                    info += SystemMessageProperties.getSystemProperty("item_given_date") + Constants.COLON + Constants.SPACE
                            + contractForm.getCarIssueDate();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getCarFrameNumber())) {
                    info += SystemMessageProperties.getSystemProperty("item_frame_number") + Constants.COLON + Constants.SPACE
                            + contractForm.getCarFrameNumber();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(contractForm.getCarMachineNumber())) {
                    info += SystemMessageProperties.getSystemProperty("item_machine_number") + Constants.COLON + Constants.SPACE
                            + contractForm.getCarMachineNumber();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                
                if (!EditString.isNull(contractForm.getOwnerInfo())) {
                    info += SystemMessageProperties.getSystemProperty("item_owner") + Constants.COLON + Constants.SPACE
                            + contractForm.getOwnerInfo();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                
                if (!EditString.isNull(contractForm.getOtherInfo())) {
                    info += SystemMessageProperties.getSystemProperty("item_other_info") + Constants.COLON + Constants.SPACE
                            + contractForm.getOtherInfo();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                
                propertyInfo.setPropertyInfo(info);
                
            } else if (OTHER_TYPE.equals(contractForm.getType())) {
            	
            	String info = "";
                info += contractForm.getPropertyInfo();
                
                if (!EditString.isNull(contractForm.getOwnerInfo())) {
                    info += SystemMessageProperties.getSystemProperty("item_owner") + Constants.COLON + Constants.SPACE
                            + contractForm.getOwnerInfo();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                
                if (!EditString.isNull(contractForm.getOtherInfo())) {
                    info += SystemMessageProperties.getSystemProperty("item_other_info") + Constants.COLON + Constants.SPACE
                            + contractForm.getOtherInfo();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                
                propertyInfo.setPropertyInfo(info);

            }
            
            propertyInfo.setOwnerInfo(contractForm.getOwnerInfo());
            propertyInfo.setOtherInfo(contractForm.getOtherInfo());
            
            
            
        } else {
        	if (LAND_TYPE.equals(contractForm.getType())) {
        		propertyInfo.setLandDistrict(contractForm.getLandDistrict());
                propertyInfo.setLandStreet(contractForm.getLandStreet());
        	}
            propertyInfo.setPropertyInfo(contractForm.getPropertyInfo());
        }
        
        if (!EditString.isNull(propertyInfo.getPropertyInfo())) {
            createEntryUserInfo(propertyInfo);
            contractService.entryProperty(propertyInfo);
            
            ContractPropertyInfo contractPropertyInfo = new ContractPropertyInfo();
            contractPropertyInfo.setContractId(contractInfo.getId());
            contractPropertyInfo.setPropertyId(propertyInfo.getId());
            createEntryUserInfo(contractPropertyInfo);
            
            contractService.entryContractProperty(contractPropertyInfo);
            
        }
        
        //entry transaction property
        TransactionPropertyInfo transactionPropertyInfo = new TransactionPropertyInfo();
        
        transactionPropertyInfo.setType(propertyInfo.getType());
        
        String info = propertyInfo.getPropertyInfo();
//        if (!EditString.isNull(propertyInfo.getOwnerInfo())) {
//            info += Constants.ENTER + SystemMessageProperties.getSystemProperty("item_owner")
//                + Constants.COLON + Constants.SPACE + propertyInfo.getOwnerInfo();
//        }
//        if (!EditString.isNull(propertyInfo.getOtherInfo())) {
//            info += Constants.ENTER + SystemMessageProperties.getSystemProperty("item_other_info")
//                + Constants.COLON + Constants.SPACE + propertyInfo.getOtherInfo();
//        }
        transactionPropertyInfo.setPropertyInfo(info);
        
        contractService.setNpoContractTemplateIdFilter(contractInfo.getContractTemplateId());
        ContractTemplateList contractTemplateList = contractService.queryAllContractTemplate(Boolean.FALSE);
        transactionPropertyInfo.setContractName(contractTemplateList.get(0).getName());
        transactionPropertyInfo.setTransactionContent(contractInfo.getContractSummary());
        transactionPropertyInfo.setNotaryDate(contractInfo.getNotaryDate());
	    //HungPT changed code for Can Tho, 21/05/2014
	    //transactionPropertyInfo.setNotaryOfficeName(commonContext.getSystemConfigValue("notary_office_name"));
	    transactionPropertyInfo.setNotaryOfficeName(commonContext.getUserInfo().getFullName());
	    //End changing
        transactionPropertyInfo.setContractId(contractInfo.getId());
        transactionPropertyInfo.setContractNumber(contractInfo.getContractNumber());
        transactionPropertyInfo.setContractValue(contractInfo.getContractValue());
        
        transactionPropertyInfo.setDistrict(propertyInfo.getLandDistrict());
        transactionPropertyInfo.setStreet(propertyInfo.getLandStreet());
        transactionPropertyInfo.setMortageCancelFlag(contractInfo.getMortageCancelFlag());
        transactionPropertyInfo.setMortageCancelDate(contractInfo.getMortageCancelDate());
        transactionPropertyInfo.setMortageCancelNote(contractInfo.getMortageCancelNote());
        transactionPropertyInfo.setContractPeriod(contractInfo.getContractPeriod());
        ContractTemplateInfo contractTemplateInfo = contractService.queryContractTemplateInfoById(contractInfo.getContractTemplateId(), false);
        if (contractTemplateInfo!=null) {
        	
        	//Khong chia se noi dung hop dong
        	if (ContractTemplateInfo.SYNC_OPTION_NOT_CONTENT.equals(contractTemplateInfo.getSyncOption())) {
        		transactionPropertyInfo.setTransactionContent("");
        	}
        	
        	ContractKindInfo contractKindInfo = contractService.queryContractKindTT08ById(contractTemplateInfo.getKindIdTT08(),false);
        	if (contractKindInfo!=null)
        		transactionPropertyInfo.setContractKind(contractKindInfo.getName());
        }
        String relation = "";
        if (!EditString.isNull(contractInfo.getRelationObjectA())) {
        	if (contractTemplateInfo.getRelateObjectATitle()==null||contractTemplateInfo.getRelateObjectATitle().equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
        		contractTemplateInfo.setRelateObjectATitle(SystemMessageProperties.getSystemProperty("item_relation_objectA"));
            relation += contractTemplateInfo.getRelateObjectATitle()
                + Constants.COLON + Constants.SPACE + contractInfo.getRelationObjectA();
        }        
        if (!EditString.isNull(contractInfo.getRelationObjectB())) {
        	if (contractTemplateInfo.getRelateObjectBTitle()==null||contractTemplateInfo.getRelateObjectBTitle().equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
        		contractTemplateInfo.setRelateObjectBTitle(SystemMessageProperties.getSystemProperty("item_relation_objectB"));
            relation += Constants.ENTER + contractTemplateInfo.getRelateObjectBTitle()
                + Constants.COLON + Constants.SPACE + contractInfo.getRelationObjectB();
        }
        if (!EditString.isNull(contractInfo.getRelationObjectC())) {
        	if (contractTemplateInfo.getRelateObjectCTitle()==null||contractTemplateInfo.getRelateObjectCTitle().equals(SystemMessageProperties.getSystemProperty("item_relation_object")))
        		contractTemplateInfo.setRelateObjectCTitle(SystemMessageProperties.getSystemProperty("item_relation_objectC"));
            relation += Constants.ENTER + contractTemplateInfo.getRelateObjectCTitle()
                + Constants.COLON + Constants.SPACE + contractInfo.getRelationObjectC();
        }
        transactionPropertyInfo.setRelationObject(relation);
        
        /*userService.setUsidFilter(contractInfo.getNotaryId());
        UserList userList = userService.queryAllUser(Boolean.FALSE);
        if (userList.size() > 0) {
            transactionPropertyInfo.setNotaryPerson(userList.get(0).getFullName());
        }*/
        transactionPropertyInfo.setNotaryPerson(contractInfo.getCrediterName());
        transactionPropertyInfo.setNotaryPlace(commonContext.getSystemOfficeName());
        transactionPropertyInfo.setNotaryFee(contractInfo.getCostTotal());
        transactionPropertyInfo.setNote(contractInfo.getNote());
        transactionPropertyInfo.setCancelStatus(contractInfo.getCancelStatus());
        transactionPropertyInfo.setCancelDescription(contractInfo.getCancelDescription());
       
        
        createEntryUserInfo(transactionPropertyInfo);
        
       
        preventService.entryTransactionProperty(transactionPropertyInfo);
        
        //Set synchronize id to transaction property info
        transactionPropertyInfo.setSynchronizeId(commonContext.getSystemOfficeAuthorityID()
                + Constants.UNIT_SEPARATOR + transactionPropertyInfo.getTpid());
        preventService.modifyTransactionProperty(transactionPropertyInfo);
        
        //entry synchronize
        SynchronizeInfo synchronizeInfo = new SynchronizeInfo();
        synchronizeInfo.setType(Constants.SYNCHRONIZE_TYPE_TRANSACTION);
        synchronizeInfo.setAction(Constants.SYNCHRONIZE_ACTION_REGIST);
        synchronizeInfo.setDataId(transactionPropertyInfo.getSynchronizeId());
        synchronizeInfo.setAuthenticationId(commonContext.getSystemOfficeAuthorityID());
        synchronizeInfo.setEntryDateTime(RelateDateTime.getTimeNow());
        SynchronizeService synService = new SynchronizeService(getConnection());
        synService.entrySynchronize(synchronizeInfo);
        
      //entry customer
        checkCustomer(contractForm.getRelationObjectA());
        checkCustomer(contractForm.getRelationObjectB());
        checkCustomer(contractForm.getRelationObjectC());
        
        
        
        //Add many property
        /*ContractPropertyInfo contractPropertyInfo;
        PropertyInfo propertyInfo = new PropertyInfo();
        for (PropertyInfo info : contractViewHelper.getPropertyList()) {
            contractPropertyInfo = new ContractPropertyInfo();
            contractPropertyInfo.setContractId(contractInfo.getId());

            if (info.getId() == null) {
                contractService.entryProperty(info);
                contractPropertyInfo.setPropertyId(info.getId());
            } else {
                contractService.setPropertyIdFilter(info.getId());
                List<PropertyInfo> propertyList = contractService.queryProperties(Boolean.FALSE).getList();
                if (propertyList.size() > 0) {
                    propertyInfo = propertyList.get(0);
                    propertyInfo.setTitle(info.getTitle());
                    propertyInfo.setCode(info.getCode());
                    propertyInfo.setProvince(info.getProvince());
                    propertyInfo.setDistrict(info.getDistrict());
                    propertyInfo.setGivenDate(info.getGivenDate());

                    propertyInfo.setMapNumber(info.getMapNumber());
                    propertyInfo.setLandNumber(info.getLandNumber());
                    propertyInfo.setLandAddress(info.getLandAddress());

                    propertyInfo.setFrameNumber(info.getFrameNumber());
                    propertyInfo.setMachineNumber(info.getMachineNumber());
                    propertyInfo.setOwnerName(info.getOwnerName());

                    propertyInfo.setOtherInfo(info.getOtherInfo());

                    propertyInfo.setOwnerName(info.getOwnerName());
                    propertyInfo.setOwnerIdCard(info.getOwnerIdCard());
                    propertyInfo.setOwnerAddress(info.getOwnerAddress());

                    contractService.modifyProperty(propertyInfo);
                    contractPropertyInfo.setPropertyId(propertyInfo.getId());
                } else {
                    contractService.entryProperty(info);
                    contractPropertyInfo.setPropertyId(info.getId());
                }
            }

            contractService.entryContractProperty(contractPropertyInfo);
        }*/
        
        // Contract History
        ContractHistoryInfo contractHistoryInfo = new ContractHistoryInfo();
        contractService.setContractIdFilter(contractInfo.getId());
        contractInfo = contractService.queryContractById(false);
        contractHistoryInfo.setContractId(contractInfo.getId());
        String contractContent=contractService.entryHistory(contractInfo);
        
       
        contractHistoryInfo.setContractNumber(contractInfo.getContractNumber());
        contractHistoryInfo.setContractContent(contractContent);
        contractHistoryInfo.setClientInfo(getClientInfo(request));
        createEntryUserInfo(contractHistoryInfo);
        contractHistoryInfo.setExecutePerson(contractHistoryInfo.getEntryUserName());       
        contractHistoryInfo.setExecuteDateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));     
        contractHistoryInfo.setExecuteContent(SystemMessageProperties.getSystemProperty("PREVENT_ENTRY"));
        ContractHistoryService contractHistoryService = new ContractHistoryService(getConnection());
        contractHistoryService.entryContractHistory(contractHistoryInfo);
        //
        
        //Neu chuyen tu hop dong cho ky thi se cap nhat lai trang thai
        if (contractViewHelper.getFromTemporaryContract()) {
        	TemporaryContractService tempoService = new TemporaryContractService(getConnection());
        	
        	TemporaryContractViewHelper tcViewhelper = (TemporaryContractViewHelper) contractViewHelper;
        	TemporaryContractInfo tcInfo = tempoService.queryTemporaryContractByTcid(tcViewhelper.getTcid(), false);
        	tcInfo.setType(TEMPORARY_TYPE_SIGNED);
        	tempoService.modifyTemporaryContract(tcInfo);
        } 
		//
        
        getConnection().commit();

        ActionMessages messages = new ActionMessages();
        messages.add(messageUtil.createActionMessages("", request, "msg_regist_success", "item_contract"));
        this.addMessages(request, messages);
        return mapping.findForward(SUCCESS);
    }
    
    
	private void checkCustomer(String relationObject) throws Exception {
    	if ("".equals(relationObject.trim())==false){
    	CustomerService customerService = new CustomerService(getConnection());
    	CustomerInfo customerInfo = new CustomerInfo();
    	customerService.setCustomerFilter(relationObject, FilterKind.FULL);
    	CustomerList customerList = new CustomerList();
    	customerList = customerService.queryAllCustomer(false);
    	if (customerList.size()!=0)
    	{	
    		
    		customerInfo = customerList.get(0);
    		customerInfo.setFrequency(customerInfo.getFrequency()+1);
    		customerService.modifyCustomer(customerInfo);
    	} else {
    		customerInfo.setCustomerInfo(relationObject);
    		customerInfo.setFrequency(FREQUENCY);
    		customerService.entryCustomer(customerInfo);
    	}
    	}
    	
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

        ContractViewHelper contractViewHelper = (ContractViewHelper)request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
        if (contractViewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }

        return mapping.findForward(SUCCESS);
    }

    /**
     * <P>Action add property</P>
     *
     * @author HungPT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward addProperty(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        ContractViewHelper contractViewHelper = (ContractViewHelper)request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
        if (contractViewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }

        ContractForm contractForm = (ContractForm)form;

        contractViewHelper.reset(contractForm);

        return mapping.findForward(SUCCESS);
    }

    
    /**
     * Load default list and value for first view
     *
     * @param contractViewHelper
     * @throws Exception
     */
    private void loadDefault(ContractViewHelper contractViewHelper) throws Exception {
        BasicDataService basicDataService = new BasicDataService(getConnection());
        UserService userService = new UserService(getConnection());
        ContractService contractService = new ContractService(getConnection());
        CommonService commonService = new CommonService(getConnection());
        ContractKindService contractKindService = new ContractKindService(getConnection());

        //Set value for first view
        basicDataService.addOrderFieldBank(new OrderField(ORDER_FIELD_BANK));
        contractViewHelper.setBankList(basicDataService.queryAllBank(false).getList());

        userService.setActiveFlgFilter(Boolean.TRUE);
        userService.setHiddenFlgFilter(Boolean.FALSE);
        userService.setRoleFilter(new String[] { DRAFTER_ROLE });
        userService.addOrderFieldUser(new OrderField(ORDER_FIELD_USER));
        contractViewHelper.setDrafterList(userService.queryAllUser(false).getList());
        userService.setRoleFilter(new String[] {NOTARY_ROLE });
        contractViewHelper.setNotaryList(userService.queryAllUser(false).getList());

        contractService.setContractTemplateActiveFlgFilter(Boolean.TRUE);
        contractService.addOrderFieldContractTemplate(new OrderField(ORDER_FIELD_CONTRACT_TEMPLATE));
        contractViewHelper.setContractTemplateList(contractService.queryAllContractTemplate(false).getList());
        
        contractViewHelper.setPropertyTypeList(commonService.queryAllProperty().getList());
        //contractViewHelper.setDistrictList(basicDataService.queryAllDistrict(false).getList());
        
        contractViewHelper.setContractKindTree(contractKindService.getContractKindTree(false, null));

        contractViewHelper.setFromRegistScreen(Boolean.TRUE);
        
    }

    /**
     * Load cancellation contract
     *
     * @param contractViewHelper
     * @throws Exception
     */
    private String loadCancellationContractInfo(ActionMapping mapping, HttpServletRequest request,
            ContractViewHelper contractViewHelper, String contractId) throws Exception  {

        ContractService contractService = new ContractService(getConnection());
        MessageUtil messageUtil = new MessageUtil();

        ContractInfo contractInfo = null;
        if (EditString.isNumber(contractId)) {
            contractViewHelper.setCancellationContractId(Long.parseLong(contractId));
            contractService.setContractIdFilter(contractViewHelper.getCancellationContractId());
            contractInfo = contractService.queryContractById(false);
        }

        if (contractInfo == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract"));
            this.addErrors(request, errors);
            return FAILURE_PATH;
        }

        contractViewHelper.setContractId(contractInfo.getId());
        contractViewHelper.setContractNumber(CONTRACT_NUMBER_DEFAULT + Calendar.getInstance().get(Calendar.YEAR));
        contractViewHelper.setContractSummary(SystemMessageProperties.getSystemProperty("item_cancellation_summary") + Constants.SPACE
                + contractInfo.getContractNumber());
//        contractViewHelper.setNotaryDate(RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()));
//        contractViewHelper.setReceivedDate(RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()));
        
        contractViewHelper.setNotaryPlaceFlag(Boolean.TRUE);

        contractViewHelper.setBankId(contractInfo.getBankId());
        contractViewHelper.setBankName(contractInfo.getBankName());
        contractViewHelper.setBankServiceFee(contractInfo.getBankServiceFee());
        contractViewHelper.setCrediterName(contractInfo.getCrediterName());

        contractViewHelper.setRelationObjectA(contractInfo.getRelationObjectA());
        contractViewHelper.setRelationObjectB(contractInfo.getRelationObjectB());
        contractViewHelper.setRelationObjectC(contractInfo.getRelationObjectC());

        contractService.setContractIdPropertyFilter(contractInfo.getId());
        PropertyList propertyList = contractService.queryAllPropertyByContract(false);
        contractViewHelper.setPropertyList(propertyList.getList());
        if (propertyList.size() > 0) {
            PropertyInfo propertyInfo = propertyList.get(0);
            contractViewHelper.setType(propertyInfo.getType());
            contractViewHelper.setPropertyInfo(propertyInfo.getPropertyInfo());
            if (LAND_TYPE.equals(propertyInfo.getType())) {
            	contractViewHelper.setLandDistrict(propertyInfo.getLandDistrict());
            	contractViewHelper.setLandStreet(propertyInfo.getLandStreet());
                contractViewHelper.setLandAddress(propertyInfo.getLandAddress());
                contractViewHelper.setLandArea(propertyInfo.getLandArea());
                contractViewHelper.setLandCertificate(propertyInfo.getLandCertificate());
                if (propertyInfo.getLandIssueDate() != null) {
                    contractViewHelper.setLandIssueDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, propertyInfo.getLandIssueDate()));
                } else {
                    contractViewHelper.setLandIssueDate(null);
                }
                
                contractViewHelper.setLandIssuePlace(propertyInfo.getLandIssuePlace());
                contractViewHelper.setLandMapNumber(propertyInfo.getLandMapNumber());
                contractViewHelper.setLandNumber(propertyInfo.getLandNumber());
                contractViewHelper.setLandPrivateArea(propertyInfo.getLandPrivateArea());
                contractViewHelper.setLandPublicArea(propertyInfo.getLandPublicArea());
                contractViewHelper.setLandUseOrigin(propertyInfo.getLandUseOrigin());
                contractViewHelper.setLandUsePeriod(propertyInfo.getLandUsePeriod());
                contractViewHelper.setLandUsePurpose(propertyInfo.getLandUsePurpose());
                contractViewHelper.setLandAssociateProperty(propertyInfo.getLandAssociateProperty());
                contractViewHelper.setLandDistrict(propertyInfo.getLandDistrict());
                contractViewHelper.setLandStreet(propertyInfo.getLandStreet());
                
            } else if (VEHICLE_TYPE.equals(propertyInfo.getType())) {
                contractViewHelper.setCarFrameNumber(propertyInfo.getCarFrameNumber());
                if (propertyInfo.getCarIssueDate() != null) {
                    contractViewHelper.setCarIssueDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, propertyInfo.getCarIssueDate()));
                } else {
                    contractViewHelper.setCarIssueDate(null);
                }                
                contractViewHelper.setCarIssuePlace(propertyInfo.getCarIssuePlace());
                contractViewHelper.setCarLicenseNumber(propertyInfo.getCarLicenseNumber());
                contractViewHelper.setCarMachineNumber(propertyInfo.getCarMachineNumber());
                contractViewHelper.setCarRegistNumber(propertyInfo.getCarRegistNumber());
                
            }
            
            contractViewHelper.setOwnerInfo(propertyInfo.getOwnerInfo());
            contractViewHelper.setOtherInfo(propertyInfo.getOtherInfo());
            
        }

        return SUCCESS;
    }
    
    /**
     * Load appendix
     *
     * @param contractViewHelper
     * @throws Exception
     */
    private String loadAppendixInfo(ActionMapping mapping, HttpServletRequest request,
            ContractViewHelper contractViewHelper, String contractId) throws Exception  {

        ContractService contractService = new ContractService(getConnection());
        MessageUtil messageUtil = new MessageUtil();

        ContractInfo contractInfo = null;
        if (EditString.isNumber(contractId)) {
            contractViewHelper.setAppendixId(Long.parseLong(contractId));
            contractService.setContractIdFilter(contractViewHelper.getAppendixId());
            contractInfo = contractService.queryContractById(false);
        }

        if (contractInfo == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract"));
            this.addErrors(request, errors);
            return FAILURE_PATH;
        }

        contractViewHelper.setContractId(contractInfo.getId());
        contractViewHelper.setContractNumber(CONTRACT_NUMBER_DEFAULT + Calendar.getInstance().get(Calendar.YEAR));
        contractViewHelper.setContractSummary(SystemMessageProperties.getSystemProperty("item_appendix_summary") + Constants.SPACE
                + contractInfo.getContractNumber());
//        contractViewHelper.setNotaryDate(RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()));
//        contractViewHelper.setReceivedDate(RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()));
        
        contractViewHelper.setNotaryPlaceFlag(Boolean.TRUE);

        contractViewHelper.setBankId(contractInfo.getBankId());
        contractViewHelper.setBankName(contractInfo.getBankName());
        contractViewHelper.setBankServiceFee(contractInfo.getBankServiceFee());
        contractViewHelper.setCrediterName(contractInfo.getCrediterName());

        contractViewHelper.setRelationObjectA(contractInfo.getRelationObjectA());
        contractViewHelper.setRelationObjectB(contractInfo.getRelationObjectB());
        contractViewHelper.setRelationObjectC(contractInfo.getRelationObjectC());

        contractService.setContractIdPropertyFilter(contractInfo.getId());
        PropertyList propertyList = contractService.queryAllPropertyByContract(false);
        contractViewHelper.setPropertyList(propertyList.getList());
        if (propertyList.size() > 0) {
            PropertyInfo propertyInfo = propertyList.get(0);
            contractViewHelper.setType(propertyInfo.getType());
            contractViewHelper.setPropertyInfo(propertyInfo.getPropertyInfo());
            if (LAND_TYPE.equals(propertyInfo.getType())) {
            	contractViewHelper.setLandDistrict(propertyInfo.getLandDistrict());
            	contractViewHelper.setLandStreet(propertyInfo.getLandStreet());
                contractViewHelper.setLandAddress(propertyInfo.getLandAddress());
                contractViewHelper.setLandArea(propertyInfo.getLandArea());
                contractViewHelper.setLandCertificate(propertyInfo.getLandCertificate());
                if (propertyInfo.getLandIssueDate() != null) {
                    contractViewHelper.setLandIssueDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, propertyInfo.getLandIssueDate()));
                } else {
                    contractViewHelper.setLandIssueDate(null);
                }
                
                contractViewHelper.setLandIssuePlace(propertyInfo.getLandIssuePlace());
                contractViewHelper.setLandMapNumber(propertyInfo.getLandMapNumber());
                contractViewHelper.setLandNumber(propertyInfo.getLandNumber());
                contractViewHelper.setLandPrivateArea(propertyInfo.getLandPrivateArea());
                contractViewHelper.setLandPublicArea(propertyInfo.getLandPublicArea());
                contractViewHelper.setLandUseOrigin(propertyInfo.getLandUseOrigin());
                contractViewHelper.setLandUsePeriod(propertyInfo.getLandUsePeriod());
                contractViewHelper.setLandUsePurpose(propertyInfo.getLandUsePurpose());
                contractViewHelper.setLandAssociateProperty(propertyInfo.getLandAssociateProperty());
                contractViewHelper.setLandDistrict(propertyInfo.getLandDistrict());
                contractViewHelper.setLandStreet(propertyInfo.getLandStreet());
                
            } else if (VEHICLE_TYPE.equals(propertyInfo.getType())) {
                contractViewHelper.setCarFrameNumber(propertyInfo.getCarFrameNumber());
                if (propertyInfo.getCarIssueDate() != null) {
                    contractViewHelper.setCarIssueDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, propertyInfo.getCarIssueDate()));
                } else {
                    contractViewHelper.setCarIssueDate(null);
                }                
                contractViewHelper.setCarIssuePlace(propertyInfo.getCarIssuePlace());
                contractViewHelper.setCarLicenseNumber(propertyInfo.getCarLicenseNumber());
                contractViewHelper.setCarMachineNumber(propertyInfo.getCarMachineNumber());
                contractViewHelper.setCarRegistNumber(propertyInfo.getCarRegistNumber());
                
            }
            
            contractViewHelper.setOwnerInfo(propertyInfo.getOwnerInfo());
            contractViewHelper.setOtherInfo(propertyInfo.getOtherInfo());
            
            
            
        }

        return SUCCESS;
    }
    
    /**
     * Load copy
     *
     * @param temporaryContractViewHelper
     * @throws Exception
     */
    private String loadCopyInfo(ActionMapping mapping, HttpServletRequest request,
            ContractViewHelper contractViewHelper, String id) throws Exception  {

        ContractService contractService = new ContractService(getConnection());
        MessageUtil messageUtil = new MessageUtil();

        ContractInfo contractInfo = null;
        if (EditString.isNumber(id)) {
        	contractViewHelper.setContractId(Long.parseLong(id));
            contractService.setContractIdFilter(contractViewHelper.getContractId());
            contractInfo = contractService.queryContractById(false);
        }

        if (contractInfo == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract"));
            this.addErrors(request, errors);
            return FAILURE_PATH;
        }

       
        contractViewHelper.setContractNumber(CONTRACT_NUMBER_DEFAULT + Calendar.getInstance().get(Calendar.YEAR));
        contractViewHelper.setContractSummary(contractInfo.getContractSummary());
        
        contractViewHelper.setNotaryPlaceFlag(Boolean.TRUE);

        contractViewHelper.setBankId(contractInfo.getBankId());
        contractViewHelper.setBankName(contractInfo.getBankName());
        contractViewHelper.setBankServiceFee(contractInfo.getBankServiceFee());
        contractViewHelper.setCrediterName(contractInfo.getCrediterName());

        contractViewHelper.setRelationObjectA(contractInfo.getRelationObjectA());
        contractViewHelper.setRelationObjectB(contractInfo.getRelationObjectB());
        contractViewHelper.setRelationObjectC(contractInfo.getRelationObjectC());
        
        contractService.setContractIdPropertyFilter(contractInfo.getId());
        PropertyList propertyList = contractService.queryAllPropertyByContract(false);
        contractViewHelper.setPropertyList(propertyList.getList());
	        if (propertyList.size() > 0) {
	            PropertyInfo propertyInfo = propertyList.get(0);
	            contractViewHelper.setType(propertyInfo.getType());
	            contractViewHelper.setPropertyInfo(propertyInfo.getPropertyInfo());
	            if (LAND_TYPE.equals(propertyInfo.getType())) {
	            	contractViewHelper.setLandDistrict(propertyInfo.getLandDistrict());
	            	contractViewHelper.setLandStreet(propertyInfo.getLandStreet());
	                contractViewHelper.setLandAddress(propertyInfo.getLandAddress());
	                contractViewHelper.setLandArea(propertyInfo.getLandArea());
	                contractViewHelper.setLandCertificate(propertyInfo.getLandCertificate());
	                if (propertyInfo.getLandIssueDate() != null) {
	                    contractViewHelper.setLandIssueDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, propertyInfo.getLandIssueDate()));
	                } else {
	                    contractViewHelper.setLandIssueDate(null);
	                }
	                
	                contractViewHelper.setLandIssuePlace(propertyInfo.getLandIssuePlace());
	                contractViewHelper.setLandMapNumber(propertyInfo.getLandMapNumber());
	                contractViewHelper.setLandNumber(propertyInfo.getLandNumber());
	                contractViewHelper.setLandPrivateArea(propertyInfo.getLandPrivateArea());
	                contractViewHelper.setLandPublicArea(propertyInfo.getLandPublicArea());
	                contractViewHelper.setLandUseOrigin(propertyInfo.getLandUseOrigin());
	                contractViewHelper.setLandUsePeriod(propertyInfo.getLandUsePeriod());
	                contractViewHelper.setLandUsePurpose(propertyInfo.getLandUsePurpose());
	                contractViewHelper.setLandAssociateProperty(propertyInfo.getLandAssociateProperty());
	                contractViewHelper.setLandDistrict(propertyInfo.getLandDistrict());
	                contractViewHelper.setLandStreet(propertyInfo.getLandStreet());
	                
	            } else if (VEHICLE_TYPE.equals(propertyInfo.getType())) {
	                contractViewHelper.setCarFrameNumber(propertyInfo.getCarFrameNumber());
	                if (propertyInfo.getCarIssueDate() != null) {
	                    contractViewHelper.setCarIssueDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, propertyInfo.getCarIssueDate()));
	                } else {
	                    contractViewHelper.setCarIssueDate(null);
	                }                
	                contractViewHelper.setCarIssuePlace(propertyInfo.getCarIssuePlace());
	                contractViewHelper.setCarLicenseNumber(propertyInfo.getCarLicenseNumber());
	                contractViewHelper.setCarMachineNumber(propertyInfo.getCarMachineNumber());
	                contractViewHelper.setCarRegistNumber(propertyInfo.getCarRegistNumber());
	                
	            }
	            
	            contractViewHelper.setOwnerInfo(propertyInfo.getOwnerInfo());
	            contractViewHelper.setOtherInfo(propertyInfo.getOtherInfo());
	            	        
	    }
	    return SUCCESS;
    }


}
