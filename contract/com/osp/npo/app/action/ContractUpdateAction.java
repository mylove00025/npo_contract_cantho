package com.osp.npo.app.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.osp.npo.common.global.Constants;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.FileUtil;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.contract.ContractList;
import com.osp.npo.core.contract.ContractPropertyInfo;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.core.contract.PropertyInfo;
import com.osp.npo.core.contract.PropertyList;
import com.osp.npo.core.contractHistory.ContractHistoryInfo;
import com.osp.npo.core.customer.CustomerInfo;
import com.osp.npo.core.customer.CustomerList;
import com.osp.npo.core.prevent.TransactionPropertyInfo;
import com.osp.npo.core.prevent.TransactionPropertyList;
import com.osp.npo.core.synchronize.SynchronizeInfo;
import com.osp.npo.core.user.UserList;
import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.form.ContractForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractViewHelper;
import com.osp.npo.service.BasicDataService;
import com.osp.npo.service.CommonService;
import com.osp.npo.service.ContractHistoryService;
import com.osp.npo.service.ContractKindService;
import com.osp.npo.service.ContractService;
import com.osp.npo.service.CustomerService;
import com.osp.npo.service.PreventService;
import com.osp.npo.service.SynchronizeService;
import com.osp.npo.service.UserService;

/**
 * <P>Contract Update Action</P>
 *
 * @author HungPT
 * @version $Revision: 29789 $
 */
@SuppressWarnings("unchecked")
public class ContractUpdateAction extends BaseMDAction {

    private static final String SUCCESS = "success";
    public static final String FAILURE_PATH = "failure";
    public static final String FAILURE_PATH2 = "deleted";
    public static final String NO_LOGIN = "nologin";
    private static final String NOTARY_ROLE = "02";
    private static final String DRAFTER_ROLE = "03";
    private static final Long BANK_NONE_SELECTED = 0L;
    private static final String ORDER_FIELD_CONTRACT_TEMPLATE = "name";
    private static final String ORDER_FIELD_USER = "first_name";
    private static final String ORDER_FIELD_BANK = "order_number";

    private static final String NPO_CONTRACT_TEMPLATE = "npo_contract_template";
    private static final String NPO_USER = "npo_user";
    private static final String NPO_BANK = "npo_bank";
    private static final String CONTRACT_ID = "id";
    private static final String CONTRACT_TEMPLATE_ID = "id";
    private static final String USER_ID = "id";
    private static final String BANK_ID = "id";

    public static final String UPLOAD_FOLDER_KEY = "system_contract_folder";
    public static final String CONTRACT_FILE_NAME_PREFIX = "CNTR_";

    private static final String LAND_TYPE = "01";
    private static final String VEHICLE_TYPE = "02";
    private static final String OTHER_TYPE = "99";
    private static final String DISPLAY = "1";
    private static final long FREQUENCY = 1;
    
    private static final Integer MAX_LENGTH_FILE = 15;

    //private static final String ORDER_FIELD_PROVINCE = "order_number";
    //private static final String ORDER_FIELD_DISTRICT = "order_number";

    private static final String DOT = "\\.";
    

    



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

        createTitle(Constants.SCREEN_CNTR004);
        MessageUtil messageUtil = new MessageUtil();
        HttpSession session = request.getSession();

        ContractViewHelper contractViewHelper = (ContractViewHelper)request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
        if (contractViewHelper == null) {
            contractViewHelper = new ContractViewHelper();
        }

        BasicDataService basicDataService = new BasicDataService(getConnection());
        UserService userService = new UserService(getConnection());
        CommonService commonService = new CommonService(getConnection());
        ContractService contractService = new ContractService(getConnection());
        ContractKindService contractKindService = new ContractKindService(getConnection());

        //Set default value for first view
        String contractId = request.getParameter(CONTRACT_ID);
        ContractInfo contractInfo = null;
        if (EditString.isNumber(contractId)) {
            contractViewHelper.setContractId(Long.parseLong(contractId));
            contractService.setContractIdFilter(contractViewHelper.getContractId());
            contractInfo = contractService.queryContractById(false);
        }

        if (contractInfo == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        contractViewHelper.setContractId(contractInfo.getId());
        contractViewHelper.setContractKindId(contractInfo.getContractKindId());
        contractViewHelper.setContractKindName(contractInfo.getContractKindName());
        contractViewHelper.setContractTemplateId(contractInfo.getContractTemplateId());
        contractViewHelper.setContractTemplateName(contractInfo.getContractTemplateName());
        contractViewHelper.setContractNumber(contractInfo.getContractNumber());
        contractViewHelper.setContractValue(contractInfo.getContractValue());
        contractViewHelper.setNotaryId(contractInfo.getNotaryId());
        contractViewHelper.setNotaryFamilyName(contractInfo.getNotaryFamilyName());
        contractViewHelper.setNotaryFirstName(contractInfo.getNotaryFirstName());
        contractViewHelper.setDrafterId(contractInfo.getDrafterId());
        contractViewHelper.setDrafterFamilyName(contractInfo.getDrafterFamilyName());
        contractViewHelper.setDrafterFirstName(contractInfo.getDrafterFirstName());
        contractViewHelper.setContractNote(contractInfo.getNote());
        contractViewHelper.setContractSummary(contractInfo.getContractSummary());

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
        } else {
            contractViewHelper.setFileExisted(Boolean.TRUE);
        }
        contractViewHelper.setOriginalStorePlace(contractInfo.getOriginalStorePlace());
        contractViewHelper.setErrorStatus(contractInfo.getErrorStatus());
        contractViewHelper.setErrorDescription(contractInfo.getErrorDescription());
        contractViewHelper.setErrorUserFamilyName(contractInfo.getErrorUserFamilyName());
        contractViewHelper.setErrorUserFirstName(contractInfo.getErrorUserFirstName());
        contractViewHelper.setAdditionStatus(contractInfo.getAdditionStatus());
        contractViewHelper.setAdditionDescription(contractInfo.getAdditionDescription());
        contractViewHelper.setUserRequireContract(contractInfo.getUserRequireContract());
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

        if (contractInfo.getDrafterId() != null && contractInfo.getDrafterId().equals(contractInfo.getErrorUserId())) {
            contractViewHelper.setErrorAgent(DRAFTER_ROLE);
        }

        if (contractInfo.getNotaryId().equals(contractInfo.getErrorUserId())) {
            contractViewHelper.setErrorAgent(NOTARY_ROLE);
        }

        contractViewHelper.setRelationObjectA(contractInfo.getRelationObjectA());
        contractViewHelper.setRelationObjectB(contractInfo.getRelationObjectB());
        contractViewHelper.setRelationObjectC(contractInfo.getRelationObjectC());
        contractViewHelper.setContractPeriod(contractInfo.getContractPeriod());
        contractViewHelper.setMortageCancelFlag(contractInfo.getMortageCancelFlag());
        contractViewHelper.setMortageCancelDate(contractInfo.getMortageCancelDate());
        contractViewHelper.setMortageCancelNote(contractInfo.getMortageCancelNote());  
        
        contractService.setContractIdPropertyFilter(contractInfo.getId());
        PropertyList propertyList = contractService.queryAllPropertyByContract(false);
        contractViewHelper.setPropertyList(propertyList.getList());
        if (propertyList.size() > 0) {
            PropertyInfo propertyInfo = propertyList.get(0);
            contractViewHelper.setType(propertyInfo.getType());
            contractViewHelper.setPropertyInfo(propertyInfo.getPropertyInfo());
            if (LAND_TYPE.equals(propertyInfo.getType())) {
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

        basicDataService.addOrderFieldBank(new OrderField(ORDER_FIELD_BANK));
        contractViewHelper.setBankList(basicDataService.queryAllBank(false).getList());

        //userService.setActiveFlgFilter(Boolean.TRUE);
        userService.setHiddenFlgFilter(Boolean.FALSE);
        userService.setRoleFilter(new String[] { DRAFTER_ROLE });
        userService.addOrderFieldUser(new OrderField(ORDER_FIELD_USER));
        contractViewHelper.setDrafterList(userService.queryAllUser(false).getList());
        userService.setRoleFilter(new String[] {NOTARY_ROLE });
        contractViewHelper.setNotaryList(userService.queryAllUser(false).getList());

        //contractService.setContractTemplateActiveFlgFilter(Boolean.TRUE);
        contractService.addOrderFieldContractTemplate(new OrderField(ORDER_FIELD_CONTRACT_TEMPLATE));
        contractViewHelper.setContractTemplateList(contractService.queryAllContractTemplate(false).getList());

        contractViewHelper.setPropertyTypeList(commonService.queryAllProperty().getList());
        //contractViewHelper.setDistrictList(basicDataService.queryAllDistrict(false).getList());
        contractViewHelper.setContractKindTree(contractKindService.getContractKindTree(false, null));

        contractViewHelper.setFromRegistScreen(Boolean.FALSE);

        session.setAttribute(ContractViewHelper.SESSION_KEY, contractViewHelper);

        return mapping.findForward(SUCCESS);
    }

    /**
     * <P>Action for update</P>
     *
     * @author HungPT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        CommonContext commonContext = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);
        if (commonContext == null) {
            return mapping.findForward(NO_LOGIN);
        }
        
        ContractViewHelper contractViewHelper = (ContractViewHelper)request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
        if (contractViewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }

        MessageUtil messageUtil = new MessageUtil();

        ContractForm contractForm = (ContractForm)form;

        contractViewHelper.reset(contractForm);

        UserService userService = new UserService(getConnection());
        ContractService contractService = new ContractService(getConnection());

        contractService.setContractIdFilter(contractViewHelper.getContractId());
        ContractInfo contractInfo = contractService.queryContractById(false);
        if (contractInfo == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH2);
        }

        //Check existance of data
        if (!contractService.isExistContractTemplateInDB(NPO_CONTRACT_TEMPLATE,
                                                            new Object[][] {{CONTRACT_TEMPLATE_ID, contractForm.getContractTemplateId()}})) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_data_already_deleted", "item_contract_template_name"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        /*if (!userService.isExistInDB(NPO_USER, new Object[][] {{USER_ID, contractForm.getNotaryId()}})) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_data_already_deleted", "item_notary"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        if (userService.isExistInDB(NPO_USER, new Object[][] {{USER_ID, contractForm.getNotaryId()}, {"active_flg", false}})) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_user_inactive", "item_selected_notary"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        if (DISPLAY.equals(commonContext.getContractDrafter()) &&
        		contractForm.getDrafterId() != null && !contractForm.getDrafterId().equals(0L) &&
        		!userService.isExistInDB(NPO_USER, new Object[][] {{USER_ID, contractForm.getDrafterId()}})) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_data_already_deleted", "item_drafter_report"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        if (userService.isExistInDB(NPO_USER, new Object[][] {{USER_ID, contractForm.getDrafterId()}, {"active_flg", false}})) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_user_inactive", "item_selected_drafter"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        if (contractForm.getBankId() != 0 && !userService.isExistInDB(NPO_BANK, new Object[][] {{BANK_ID, contractForm.getBankId()}})) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_data_already_deleted", "item_bank_name"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }*/

        if (!contractForm.getContractNumber().equalsIgnoreCase((contractInfo.getContractNumber()))
                && contractService.isExistContractNumber(contractForm.getContractNumber())) {
                ActionErrors errors = new ActionErrors();
                errors.add(messageUtil.createActionMessages("", request, "err_data_already_exist", "item_contract"));
                this.addErrors(request, errors);
                return mapping.findForward(FAILURE_PATH);
        }

        //Set contract info
        contractInfo.setContractTemplateId(contractForm.getContractTemplateId());
        if (!contractForm.getContractNumber().equalsIgnoreCase((contractInfo.getContractNumber()))) {
	       
	        if (contractInfo.getCancelStatus()) {
	        	contractService.setContractIdFilter(contractInfo.getCancelRelationContractId());
	        	ContractInfo contractInfo2 = contractService.queryContractById(true);
	        	contractInfo2.setContractSummary(contractInfo2.getContractSummary().replace(SystemMessageProperties.getSystemProperty("item_cancellation_summary") + Constants.SPACE
	                    + contractInfo.getContractNumber(), SystemMessageProperties.getSystemProperty("item_cancellation_summary") + Constants.SPACE
	                    + contractForm.getContractNumber()));
 	        	contractService.modifyContract(contractInfo2);
	        }
	        contractService.setContractIdFilter(contractInfo.getId());
	        ContractList contractList = contractService.queryAppendixContract(true);
	        if (contractList!=null) 
	        	for (int i = 0; i < contractList.size(); i++) {
	        		ContractInfo appendixContract = contractList.get(i);
					appendixContract.setContractSummary(appendixContract.getContractSummary().replace(SystemMessageProperties.getSystemProperty("item_appendix_summary") + Constants.SPACE
			                + contractInfo.getContractNumber(), SystemMessageProperties.getSystemProperty("item_appendix_summary") + Constants.SPACE
	                    + contractForm.getContractNumber()));
					contractService.modifyContract(appendixContract);
				}
	        
	        contractInfo.setContractNumber(contractForm.getContractNumber());
	        ContractInfo contractInfo3 = contractService.queryContractByCancellationId(contractInfo.getId(), true);
	        if (contractInfo3!=null && contractInfo3.getCancelStatus()) {
	        	contractInfo3.setCancelDescription(SystemMessageProperties.getSystemProperty("item_cancellation_description")
	                    + Constants.SPACE + contractInfo.getContractNumber());
	        	contractService.modifyContract(contractInfo3);
	        }
	        
	      
	        
	       
        }
        if (!EditString.isNull(contractForm.getContractValue())) {
            contractInfo.setContractValue(contractForm.getContractValue().replaceAll(DOT, ""));
        } else {
            contractInfo.setContractValue(null);
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
        } else {
            contractInfo.setCostTt91(null);
        }

        if (!EditString.isNull(contractForm.getCostDraft())) {
            contractInfo.setCostDraft(contractForm.getCostDraft().replaceAll(DOT, ""));
        } else {
            contractInfo.setCostDraft(null);
        }

        if (!EditString.isNull(contractForm.getCostNotaryOutsite())) {
            contractInfo.setCostNotaryOutsite(contractForm.getCostNotaryOutsite().replaceAll(DOT, ""));
        } else {
            contractInfo.setCostNotaryOutsite(null);
        }

        if (!EditString.isNull(contractForm.getCostOtherDetermine())) {
            contractInfo.setCostOtherDetermine(contractForm.getCostOtherDetermine().replaceAll(DOT, ""));
        } else {
            contractInfo.setCostOtherDetermine(null);
        }

        if (!EditString.isNull(contractForm.getCostTotal())) {
            contractInfo.setCostTotal(contractForm.getCostTotal().replaceAll(DOT, ""));
        } else {
            contractInfo.setCostTotal(null);
        }

        if (contractForm.getNotaryPlaceFlag() == null || contractForm.getNotaryPlaceFlag()) {
            contractInfo.setNotaryPlaceFlag(Boolean.TRUE);
            contractInfo.setNotaryPlace("");
        } else {
            contractInfo.setNotaryPlaceFlag(Boolean.FALSE);
            contractInfo.setNotaryPlace(contractForm.getNotaryPlace());
        }
        contractInfo.setContractSummary(contractForm.getContractSummary());
        if (!BANK_NONE_SELECTED.equals(contractForm.getBankId())) {
            contractInfo.setBankId(contractForm.getBankId());
        } else {
            contractInfo.setBankId(null);
        }

        if (!EditString.isNull(contractForm.getBankServiceFee())) {
            contractInfo.setBankServiceFee(contractForm.getBankServiceFee().replaceAll(DOT, ""));
        } else {
            contractInfo.setBankServiceFee(null);
        }

        contractInfo.setCrediterName(contractForm.getCrediterName());
        contractInfo.setOriginalStorePlace(contractForm.getOriginalStorePlace());
        contractInfo.setNote(contractForm.getContractNote());
        if (contractForm.getErrorStatus() != null) {
            contractInfo.setErrorStatus(contractForm.getErrorStatus());
            contractInfo.setErrorDescription(contractForm.getErrorDescription());
            if (NOTARY_ROLE.equals(contractForm.getErrorAgent())) {
                contractInfo.setErrorUserId(contractForm.getNotaryId());
            } else if (DRAFTER_ROLE.equals(contractForm.getErrorAgent())) {
                contractInfo.setErrorUserId(contractForm.getDrafterId());
            } else {
                contractInfo.setErrorUserId(null);
            }
        } else {
            contractInfo.setErrorStatus(Boolean.FALSE);
        }

        if (contractForm.getAdditionStatus() != null) {
            contractInfo.setAdditionStatus(contractForm.getAdditionStatus());
            contractInfo.setAdditionDescription(contractForm.getAdditionDescription());
        } else {
            contractInfo.setAdditionStatus(Boolean.FALSE);
        }

        contractInfo.setUserRequireContract(contractForm.getUserRequireContract());
        contractInfo.setNumberCopyOfContract(contractForm.getNumberCopyOfContract());
        contractInfo.setNumberOfPage(contractForm.getNumberOfPage());

        createUpdateUserInfo(contractInfo);

        /*if (!contractForm.getFileExisted()) {
            try {
                String localName = EditString.convertUnicodeToASCII(contractForm.getFormFile().getFileName());
                String path = "";

                String realname = "";
                if (!localName.isEmpty()) {
                    int dot = localName.lastIndexOf(EXTENSION_SEPARATOR);
                    String fileExtension = "";
                    if (dot > 0) {
                        fileExtension = localName.substring(dot + 1);
                    }

                    if (contractInfo.getEntryDateTime() != null) {
                        realname = CONTRACT_FILE_NAME_PREFIX + RelateDateTime.formatDate(RelateDateTime.YYYYMMDDHHMISS, contractInfo.getEntryDateTime())
                                        + EXTENSION_SEPARATOR + fileExtension;
                    }
                    path = SystemProperties.getProperty(UPLOAD_FOLDER_KEY) + SLASH + realname;

                    FileOutputStream outputStream = null;
                    outputStream = new FileOutputStream(new File(path));
                    outputStream.write(contractForm.getFormFile().getFileData());
                } else if (!EditString.isNull(contractInfo.getFilePath())) {
                    File file = new File(contractViewHelper.getFilePath());
                    if (file.exists()) {
                        file.delete();
                    }
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

                if (EditString.isNull(localName) || EditString.isNull(path)) {
                    contractViewHelper.setFileExisted(Boolean.FALSE);
                } else {
                    contractViewHelper.setFileExisted(Boolean.TRUE);
                }

            } catch (IOException e) {
                ActionErrors errors = new ActionErrors();
                errors.add(messageUtil.createActionMessages("", "err_cannot_upload_file"));
                this.addErrors(request, errors);
                return mapping.findForward(FAILURE_PATH);
            }
        }*/
        
        contractInfo.setContractPeriod(contractForm.getContractPeriod());
        if (contractForm.getMortageCancelFlag()!=null) {
        	contractInfo.setMortageCancelFlag(contractForm.getMortageCancelFlag());
        	contractInfo.setMortageCancelDate(contractForm.getMortageCancelDate());
        	contractInfo.setMortageCancelNote(contractForm.getMortageCancelNote());
        } else {
        	contractInfo.setMortageCancelFlag(false);
        }

       
        
        //update contractInfo to database
        contractService.modifyContract(contractInfo);
        
        PropertyInfo propertyInfo = null;
        if (contractViewHelper.getPropertyList().size() > 0) {
            propertyInfo = contractViewHelper.getPropertyList().get(0);
        } else {
            propertyInfo = new PropertyInfo();
        }
        propertyInfo.setType(contractForm.getType());
        propertyInfo.setOwnerInfo(contractForm.getOwnerInfo());
        propertyInfo.setOtherInfo(contractForm.getOtherInfo());
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
                propertyInfo.setLandDistrict("");
                propertyInfo.setLandStreet("");
                
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
                propertyInfo.setLandDistrict("");
                propertyInfo.setLandStreet("");
            }
            
            propertyInfo.setOwnerInfo(contractForm.getOwnerInfo());
            propertyInfo.setOtherInfo(contractForm.getOtherInfo());
                
        } else {
        	if (LAND_TYPE.equals(contractForm.getType())) {
        		 propertyInfo.setLandDistrict(contractForm.getLandDistrict());
                 propertyInfo.setLandStreet(contractForm.getLandStreet());
        	 } else {
        		 propertyInfo.setLandDistrict("");
                 propertyInfo.setLandStreet("");
        	 }
            propertyInfo.setPropertyInfo(contractForm.getPropertyInfo());
        }
        
        if (!EditString.isNull(propertyInfo.getPropertyInfo())) {
            
            if (propertyInfo.getId() != null) {
                
                createUpdateUserInfo(propertyInfo);
                contractService.modifyProperty(propertyInfo);
                
            } else {
                
                createEntryUserInfo(propertyInfo);
                contractService.entryProperty(propertyInfo);
                
                ContractPropertyInfo contractPropertyInfo = new ContractPropertyInfo();
                contractPropertyInfo.setContractId(contractInfo.getId());
                contractPropertyInfo.setPropertyId(propertyInfo.getId());
                createEntryUserInfo(contractPropertyInfo);
                contractService.entryContractProperty(contractPropertyInfo);
                
            }
        } else {
            if (propertyInfo.getId() != null) {
                contractService.removeProperty(propertyInfo.getId());
            }
        }
        
        PreventService preventService = new PreventService(getConnection());
        preventService.setContractIdFilter(contractInfo.getId());
        TransactionPropertyList transactionPropertyList = preventService.queryAllTransactionProperty(Boolean.FALSE);
        TransactionPropertyInfo transactionPropertyInfo = null;
        
        if (transactionPropertyList.size() > 0) {
            
            transactionPropertyInfo = transactionPropertyList.get(0);
            
           
            if (!EditString.isNull(propertyInfo.getPropertyInfo())) {
            	 transactionPropertyInfo.setType(propertyInfo.getType());
            	 transactionPropertyInfo.setDistrict(propertyInfo.getLandDistrict());
                 transactionPropertyInfo.setStreet(propertyInfo.getLandStreet());
            } else  {
            	transactionPropertyInfo.setType("00");
            	 transactionPropertyInfo.setDistrict("");
                 transactionPropertyInfo.setStreet("");
            }
            String info = propertyInfo.getPropertyInfo();
//            if (!EditString.isNull(propertyInfo.getOwnerInfo())) {
//                info += Constants.ENTER + SystemMessageProperties.getSystemProperty("item_owner")
//                    + Constants.COLON + Constants.SPACE + propertyInfo.getOwnerInfo();
//            }
//            if (!EditString.isNull(propertyInfo.getOtherInfo())) {
//                info += Constants.ENTER + SystemMessageProperties.getSystemProperty("item_other_info")
//                    + Constants.COLON + Constants.SPACE + propertyInfo.getOtherInfo();
//            }
            transactionPropertyInfo.setPropertyInfo(info);            
            transactionPropertyInfo.setContractName(contractInfo.getContractTemplateName());
            transactionPropertyInfo.setTransactionContent(contractInfo.getContractSummary());
            transactionPropertyInfo.setNotaryDate(contractInfo.getNotaryDate());
            //HungPT changed code for Can Tho, 21/05/2014
    	    //transactionPropertyInfo.setNotaryOfficeName(commonContext.getSystemConfigValue("notary_office_name"));
    	    transactionPropertyInfo.setNotaryOfficeName(commonContext.getUserInfo().getFullName());
    	    //End changing
            transactionPropertyInfo.setContractId(contractInfo.getId());
            transactionPropertyInfo.setContractNumber(contractInfo.getContractNumber());
            transactionPropertyInfo.setContractValue(contractInfo.getContractValue());
            
          
           
           
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
            
            createUpdateUserInfo(transactionPropertyInfo);
            preventService.modifyTransactionProperty(transactionPropertyInfo);
            
        }
        
        //entry synchronize
        SynchronizeInfo synchronizeInfo = new SynchronizeInfo();
        synchronizeInfo.setType(Constants.SYNCHRONIZE_TYPE_TRANSACTION);
        synchronizeInfo.setAction(Constants.SYNCHRONIZE_ACTION_EDIT);
        synchronizeInfo.setDataId(transactionPropertyInfo.getSynchronizeId());
        synchronizeInfo.setAuthenticationId(commonContext.getSystemOfficeAuthorityID());
        synchronizeInfo.setEntryDateTime(RelateDateTime.getTimeNow());
        SynchronizeService synService = new SynchronizeService(getConnection());
        synService.entrySynchronize(synchronizeInfo);
        
        //entry customer
        checkCustomer(contractForm.getRelationObjectA());
        checkCustomer(contractForm.getRelationObjectB());
        checkCustomer(contractForm.getRelationObjectC());
        
        // Contract History
        ContractHistoryInfo contractHistoryInfo = new ContractHistoryInfo();
        contractService.setContractIdFilter(contractInfo.getId());
        contractInfo = contractService.queryContractById(false);
        contractInfo.setPropertyInfo(propertyInfo.getPropertyInfo());
        contractInfo.setPropertyType(propertyInfo.getType());
        contractHistoryInfo.setContractId(contractInfo.getId());
        String contractContent=contractService.entryHistory(contractInfo);
        
        contractHistoryInfo.setContractNumber(contractInfo.getContractNumber());
        contractHistoryInfo.setContractContent(contractContent);
        contractHistoryInfo.setClientInfo(getClientInfo(request));
        createUpdateUserInfo(contractHistoryInfo);
        contractHistoryInfo.setExecutePerson(contractHistoryInfo.getUpdateUserName());   
        contractHistoryInfo.setExecuteDateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        contractHistoryInfo.setExecuteContent(SystemMessageProperties.getSystemProperty("PREVENT_UPDATE"));
        ContractHistoryService contractHistoryService = new ContractHistoryService(getConnection());
        contractHistoryService.entryContractHistory(contractHistoryInfo);
        //
        
        getConnection().commit();
        ActionMessages messages = new ActionMessages();
        messages.add(messageUtil.createActionMessages("", request, "msg_update_success", "item_contract"));
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
     * <P>Action download file</P>
     *
     * @author HungPT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward download(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        ContractViewHelper helper = (ContractViewHelper)request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
        if (helper == null) {
            return mapping.findForward(NO_LOGIN);
        }
        File file = new File(helper.getFilePath());

        if (file.exists() && file.canRead() && file.isFile() && file.length() < Integer.MAX_VALUE) {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition",
                    "attachment; filename=\"" + helper.getFileName() + "\"");
            response.setHeader("Pragma", "public");
            response.setHeader("Cache-Control", "max-age=0");
            ServletOutputStream out = response.getOutputStream();
            FileInputStream fstream = new FileInputStream(file);
            DataInputStream in = new DataInputStream(fstream);
            long length = file.length();
            byte[] b = new byte[(int)length];
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
     * @author HungPT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return success
     * @throws ServletException
     * @throws SQLException
     * @throws Exception
     */
    public ActionForward remove(ActionMapping mapping, ActionForm form,
           HttpServletRequest request, HttpServletResponse response)
           throws ServletException, SQLException, Exception {

        ContractViewHelper helper = (ContractViewHelper)request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
        if (helper == null) {
            return mapping.findForward(NO_LOGIN);
        }
        
        CommonContext commonContext = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);
        if (commonContext == null) {
            return mapping.findForward(NO_LOGIN);
        }
        
        if (!commonContext.isContractDelete()) {
        	ActionErrors errors = new ActionErrors();
            errors.add("", new ActionMessage("err_access_deny"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }
        
        ContractService contractService = new ContractService(getConnection());
        contractService.setContractIdPropertyFilter(helper.getContractId());
        PropertyList propertyList = contractService.queryAllPropertyByContract(Boolean.FALSE);

        // Contract History
        ContractHistoryInfo contractHistoryInfo = new ContractHistoryInfo();
        contractService.setContractIdFilter(helper.getContractId());
        ContractInfo contractInfo = contractService.queryContractById(false);
        contractHistoryInfo.setContractId(contractInfo.getId());
        String contractContent=contractService.entryHistory(contractInfo);
        
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
        
        getConnection().commit();

        ActionMessages messages = new ActionMessages();
        messages.add(new MessageUtil().createActionMessages("", request, "msg_delete_success", "item_contract"));
        this.addMessages(request, messages);
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

}
