/**
 * 
 */
package com.osp.npo.app.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
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
import org.apache.struts.action.ActionMessages;

import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractViewHelper;
import com.osp.npo.app.viewhelper.TemporaryContractViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.basicData.BankInfo;
import com.osp.npo.core.common.SystemConfigInfo;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.core.contract.LostNumberInfo;
import com.osp.npo.core.temporaryContract.TemporaryContractInfo;
import com.osp.npo.core.user.UserInfo;
import com.osp.npo.service.BasicDataService;
import com.osp.npo.service.CommonService;
import com.osp.npo.service.ContractKindService;
import com.osp.npo.service.LostNumberService;
import com.osp.npo.service.TemporaryContractService;
import com.osp.npo.service.UserService;

/**
 * <P>Temporary Contract Detail Action</P>
 * @author TruongND
 * @version $Revision: 26196 $
 */
public class TemporaryContractDetailAction extends BaseMDAction {
    private static final String SUCCESS = "success";
    public static final String FAILURE_PATH = "failure";
    public static final String FAILURE_PREVENT_PATH = "failureprevent";
    public static final String NO_LOGIN = "nologin";    
    private static final String CONTRACT_ID = "id";
    public static final String UPLOAD_FOLDER_KEY = "system_contract_folder";
    public static final String CONTRACT_FILE_NAME_PREFIX = "CNTR_";
    
	private static final String LAND_TYPE = "01";
    private static final String VEHICLE_TYPE = "02";
    private static final Long TOTAL_NUMBER = (long) 0;


    
    
    @SuppressWarnings("unchecked")
    public ActionForward view(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
    	
        createTitle(Constants.SCREEN_CNTR031);
        
        MessageUtil messageUtil = new MessageUtil();
        HttpSession session = request.getSession();
        TemporaryContractViewHelper temporaryContractViewHelper = null;        
        TemporaryContractService temporaryContractService = new TemporaryContractService(getConnection());
        
        if (request.getParameter(CONTRACT_ID) != null) {
            temporaryContractViewHelper = new TemporaryContractViewHelper();
            temporaryContractViewHelper.setFromContractList(Boolean.TRUE);
        } else {
            temporaryContractViewHelper = (TemporaryContractViewHelper) request.getSession().getAttribute(TemporaryContractViewHelper.SESSION_KEY);
            if (temporaryContractViewHelper == null) {
                temporaryContractViewHelper = new TemporaryContractViewHelper();
            }
            temporaryContractViewHelper.setFromContractList(Boolean.FALSE);
        }

        
        Long contractId = 0L;
        //Copy data from database to view helper
        if (request.getParameter(CONTRACT_ID) != null) {
            contractId = Long.parseLong(request.getParameter(CONTRACT_ID));
        } else {
            contractId = temporaryContractViewHelper.getContractId();
        }
        
        TemporaryContractInfo temporaryContractInfo = temporaryContractService.queryTemporaryContractByTcid(contractId,false);  

        if (temporaryContractInfo == null) {
        	TemporaryContractViewHelper temporaryContractViewHelper1 = (TemporaryContractViewHelper) request.getSession().getAttribute(TemporaryContractViewHelper.SESSION_KEY);
        	temporaryContractViewHelper1.setIsExist(Boolean.TRUE);
//        	session.setAttribute(TemporaryContractViewHelper.SESSION_KEY, temporaryContractViewHelper);
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }
        
        temporaryContractViewHelper.setContractId(temporaryContractInfo.getTcid());

        ContractTemplateInfo contractTemplateInfo = temporaryContractService
        	.queryContractTemplateById(temporaryContractInfo.getContractTemplateId(), false);
        
        if (contractTemplateInfo != null) {
        	temporaryContractViewHelper.setContractTemplateName(contractTemplateInfo.getName());
        	temporaryContractViewHelper.setContractTemplateId(contractTemplateInfo.getId());
        	
        	ContractKindService contractKindService = new ContractKindService(getConnection());
            ContractKindInfo contractKindInfo = contractKindService.queryContractKindInfoById(contractTemplateInfo.getKindId(), false);
            
            if (contractKindInfo != null) {
            	temporaryContractViewHelper.setContractKindName(contractKindInfo.getName());
            	temporaryContractViewHelper.setContractKindId(contractKindInfo.getId());
            }
        }
        
        temporaryContractViewHelper.setContractNumber(temporaryContractInfo.getContractNumber());
        temporaryContractViewHelper.setContractValue(temporaryContractInfo.getContractValue());   
        
        UserService userService = new UserService(getConnection());
        
        //Lay ho ten cong chung vien
        if (temporaryContractInfo.getNotaryId() != null) {
        	temporaryContractViewHelper.setNotaryId(temporaryContractInfo.getNotaryId());
        	
        	UserInfo notaryUser = userService.queryUserByUsid(temporaryContractInfo.getNotaryId(), false);
        	if (notaryUser != null) {
        		temporaryContractViewHelper.setNotaryName(notaryUser.getFullName());
        	}
        }
        
        //Lay ho ten chuyen vien soan thao
        if (temporaryContractInfo.getDrafterId() != null) {
        	temporaryContractViewHelper.setDrafterId(temporaryContractInfo.getDrafterId());
        	
        	UserInfo drafterUser = userService.queryUserByUsid(temporaryContractInfo.getDrafterId(), false);
        	if (drafterUser != null) {
        		temporaryContractViewHelper.setDrafterName(drafterUser.getFullName());
        	}
        }
        
        temporaryContractViewHelper.setContractNote(temporaryContractInfo.getNote());

        temporaryContractViewHelper.setContractSummary(temporaryContractInfo.getSummary());
        
        if (temporaryContractInfo.getReceivedDate() != null) {
            temporaryContractViewHelper.setReceivedDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY,temporaryContractInfo.getReceivedDate()));
        }
        if (temporaryContractInfo.getNotaryDate() != null) {
            temporaryContractViewHelper.setNotaryDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY,temporaryContractInfo.getNotaryDate()));
        }
        
        temporaryContractViewHelper.setCostTt91(temporaryContractInfo.getCostTt91());
        temporaryContractViewHelper.setCostDraft(temporaryContractInfo.getCostDraft());
        temporaryContractViewHelper.setCostNotaryOutsite(temporaryContractInfo.getCostNotaryOutsite());
        temporaryContractViewHelper.setCostOtherDetermine(temporaryContractInfo.getCostOtherDetermine());
        temporaryContractViewHelper.setCostTotal(temporaryContractInfo.getCostTotal());
        temporaryContractViewHelper.setNotaryPlaceFlag(temporaryContractInfo.getNotaryPlaceFlag());
        temporaryContractViewHelper.setNotaryPlace(temporaryContractInfo.getNotaryPlace());
        
        BasicDataService bdService = new BasicDataService(getConnection());
        if (temporaryContractInfo.getBankId() != null) {
        	BankInfo bankInfo = bdService.queryBankById(temporaryContractInfo.getBankId(), false);
        	
        	if (bankInfo != null) {
        		temporaryContractViewHelper.setBankName(bankInfo.getName());
        		temporaryContractViewHelper.setBankId(bankInfo.getId());
        	}
        }
        
        temporaryContractViewHelper.setBankServiceFee(temporaryContractInfo.getBankServiceFee());
        temporaryContractViewHelper.setCrediterName(temporaryContractInfo.getCrediterName());
        
        //Thong tin tai san
//        temporaryContractViewHelper.setPropertyType(temporaryContractInfo.getPropertyType());
//        temporaryContractViewHelper.setPropertyInfo(temporaryContractInfo.getPropertyInfo());
        
        if (temporaryContractInfo.getPropertyInfo()!=null || !"".equals(temporaryContractInfo.getPropertyInfo())) {
            
            temporaryContractViewHelper.setPropertyType(temporaryContractInfo.getPropertyType());
            temporaryContractViewHelper.setPropertyInfo(temporaryContractInfo.getPropertyInfo());
            if (LAND_TYPE.equals(temporaryContractInfo.getPropertyType())) {
                temporaryContractViewHelper.setLandAddress(temporaryContractInfo.getLandAddress());
                temporaryContractViewHelper.setLandArea(temporaryContractInfo.getLandArea());
                temporaryContractViewHelper.setLandCertificate(temporaryContractInfo.getLandCertificate());
                if (temporaryContractInfo.getLandIssueDate() != null) {
                    temporaryContractViewHelper.setLandIssueDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, temporaryContractInfo.getLandIssueDate()));
                } else {
                    temporaryContractViewHelper.setLandIssueDate(null);
                }
                
                temporaryContractViewHelper.setLandIssuePlace(temporaryContractInfo.getLandIssuePlace());
                temporaryContractViewHelper.setLandMapNumber(temporaryContractInfo.getLandMapNumber());
                temporaryContractViewHelper.setLandNumber(temporaryContractInfo.getLandNumber());
                temporaryContractViewHelper.setLandPrivateArea(temporaryContractInfo.getLandPrivateArea());
                temporaryContractViewHelper.setLandPublicArea(temporaryContractInfo.getLandPublicArea());
                temporaryContractViewHelper.setLandUseOrigin(temporaryContractInfo.getLandUseOrigin());
                temporaryContractViewHelper.setLandUsePeriod(temporaryContractInfo.getLandUsePeriod());
                temporaryContractViewHelper.setLandUsePurpose(temporaryContractInfo.getLandUsePurpose());
                temporaryContractViewHelper.setLandAssociateProperty(temporaryContractInfo.getLandAssociateProperty());
                
            } else if (VEHICLE_TYPE.equals(temporaryContractInfo.getPropertyType())) {
                temporaryContractViewHelper.setCarFrameNumber(temporaryContractInfo.getCarFrameNumber());
                if (temporaryContractInfo.getCarIssueDate() != null) {
                    temporaryContractViewHelper.setCarIssueDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, temporaryContractInfo.getCarIssueDate()));
                } else {
                    temporaryContractViewHelper.setCarIssueDate(null);
                }                
                temporaryContractViewHelper.setCarIssuePlace(temporaryContractInfo.getCarIssuePlace());
                temporaryContractViewHelper.setCarLicenseNumber(temporaryContractInfo.getCarLicenseNumber());
                temporaryContractViewHelper.setCarMachineNumber(temporaryContractInfo.getCarMachineNumber());
                temporaryContractViewHelper.setCarRegistNumber(temporaryContractInfo.getCarRegistNumber());
                
            }
            
            temporaryContractViewHelper.setOwnerInfo(temporaryContractInfo.getOwnerInfo());
            temporaryContractViewHelper.setOtherInfo(temporaryContractInfo.getOtherInfo());
            
        }
        
        temporaryContractViewHelper.setContractCommentList(temporaryContractService.queryContractCommentByTcid(contractId, false, -1, -1).getList());
        
        if (EditString.isNull(temporaryContractInfo.getFileName()) || EditString.isNull(temporaryContractInfo.getFilePath())) {
            temporaryContractViewHelper.setFileExisted(Boolean.FALSE);
            temporaryContractViewHelper.setFilePath("--");
            temporaryContractViewHelper.setFileNameDisp(SystemMessageProperties.getSystemProperty("msg_file_not_exist"));
        } else {
            temporaryContractViewHelper.setFileExisted(Boolean.TRUE);
            temporaryContractViewHelper.setFilePath(temporaryContractInfo.getFilePath());
            temporaryContractViewHelper.setFileName(temporaryContractInfo.getFileName());
            temporaryContractViewHelper.setFileNameDisp(EditString.getFileNameDisp(temporaryContractInfo.getFileName(), 15));
        }
        temporaryContractViewHelper.setOriginalStorePlace(temporaryContractInfo.getOriginalStorePlace());
        temporaryContractViewHelper.setUserRequireContract(temporaryContractInfo.getUserRequireContract());
        temporaryContractViewHelper.setNumberCopyOfContract(temporaryContractInfo.getNumberCopyOfContract());
        temporaryContractViewHelper.setNumberOfPage(temporaryContractInfo.getNumberOfPage());
        
        temporaryContractViewHelper.setRelationObjectA(temporaryContractInfo.getRelationObjectA());
        temporaryContractViewHelper.setRelationObjectB(temporaryContractInfo.getRelationObjectB());
        temporaryContractViewHelper.setRelationObjectC(temporaryContractInfo.getRelationObjectC());
        if(!EditString.isNull(temporaryContractInfo.getRelationObjectC()))
        	temporaryContractViewHelper.setRelateObjectNumber(3);
        
        temporaryContractViewHelper.setEntryUserName(temporaryContractInfo.getEntryUserName());
		if (temporaryContractInfo.getEntryDateTime() != null) {
			temporaryContractViewHelper.setEntryDateTime(RelateDateTime
					.formatDate(RelateDateTime.DDMMYYYY,
							temporaryContractInfo.getEntryDateTime()));
		}
		temporaryContractViewHelper.setUpdateUserName(temporaryContractInfo
				.getUpdateUserName());
		if (temporaryContractInfo.getUpdateDateTime() != null) {
			temporaryContractViewHelper.setUpdateDateTime(RelateDateTime
					.formatDate(RelateDateTime.DDMMYYYY,
							temporaryContractInfo.getUpdateDateTime()));
		}
        
        session.setAttribute(TemporaryContractViewHelper.SESSION_KEY, temporaryContractViewHelper);

        return mapping.findForward(SUCCESS);
    }
    
    /**
     * Xoa hop dong
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws SQLException
     * @throws Exception
     */
    public ActionForward remove(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
    	
		TemporaryContractViewHelper viewhelper = (TemporaryContractViewHelper) request
				.getSession().getAttribute(
						TemporaryContractViewHelper.SESSION_KEY);
    	
		if (viewhelper == null) {
            return mapping.findForward(NO_LOGIN);
        }
		MessageUtil messageUtil = new MessageUtil();
		TemporaryContractService temporaryContractService = new TemporaryContractService(getConnection());
		TemporaryContractInfo temporaryContractInfo = temporaryContractService.queryTemporaryContractByTcid(viewhelper.getContractId(),false);  

        if (temporaryContractInfo == null) {
//        	TemporaryContractViewHelper temporaryContractViewHelper1 = (TemporaryContractViewHelper) request.getSession().getAttribute(TemporaryContractViewHelper.SESSION_KEY);
//        	temporaryContractViewHelper1.setIsExist(Boolean.TRUE);
//        	session.setAttribute(TemporaryContractViewHelper.SESSION_KEY, temporaryContractViewHelper);
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }
		
		TemporaryContractService service = new TemporaryContractService(getConnection());
		service.removeTemporaryContract(viewhelper.getContractId());
		
		   
        // add lost number
        String check = EditString.getNumber(temporaryContractInfo.getContractNumber());
        if (check!=null) {
			CommonService commonService = new CommonService(getConnection());
			LostNumberService lostNumberService = new LostNumberService(getConnection());
        	Long checkNumber = Long.parseLong(check);
        	LostNumberInfo lostNumberInfo = new LostNumberInfo();
			lostNumberInfo.setYear(Calendar.getInstance().get(Calendar.YEAR));
			SystemConfigInfo systemConfigInfo = commonService
			.querySystemConfigByKey("number_formula", false);
			String numberFormula = systemConfigInfo.getConfigValue();
			if (numberFormula.contains("#NUM#")) {
				lostNumberInfo.setKindId(TOTAL_NUMBER);
			} else lostNumberInfo.setKindId(temporaryContractInfo.getContractKindId());
			
			lostNumberInfo.setLostContractNumber(checkNumber);
			lostNumberService.entryLostNumber(lostNumberInfo);
        }
		
		getConnection().commit();
		
		ActionMessages messages = new ActionMessages();
        messages.add(new MessageUtil().createActionMessages("", request, "msg_delete_success", "item_contract"));
        this.addMessages(request, messages);
		
    	return mapping.findForward(SUCCESS);
    }
    
    /**
     * Download file 
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws SQLException
     * @throws Exception
     */
    public ActionForward download(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        TemporaryContractViewHelper helper = (TemporaryContractViewHelper)request.getSession().getAttribute(TemporaryContractViewHelper.SESSION_KEY);
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
     * Chuyen ky chinh thuc 
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws SQLException
     * @throws Exception
     */
    public ActionForward toSign(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
    	
		TemporaryContractViewHelper tempViewhelper = (TemporaryContractViewHelper) request
				.getSession().getAttribute(
						TemporaryContractViewHelper.SESSION_KEY);

		tempViewhelper.setType(tempViewhelper.getPropertyType());
		tempViewhelper.setTcid(tempViewhelper.getContractId());
		
		request.getSession().setAttribute(ContractViewHelper.SESSION_KEY, tempViewhelper);
    	
    	return mapping.findForward(SUCCESS);
    }
}
