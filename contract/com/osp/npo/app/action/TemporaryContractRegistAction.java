package com.osp.npo.app.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import com.osp.npo.app.form.TemporaryContractForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractViewHelper;
import com.osp.npo.app.viewhelper.TemporaryContractViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.FileUtil;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.common.SystemConfigInfo;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.contract.ContractNumberInfo;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.core.contract.LostNumberInfo;
import com.osp.npo.core.contract.PropertyInfo;
import com.osp.npo.core.contract.PropertyList;
import com.osp.npo.core.temporaryContract.ContractCommentInfo;
import com.osp.npo.core.temporaryContract.TemporaryContractInfo;
import com.osp.npo.service.BasicDataService;
import com.osp.npo.service.CommonService;
import com.osp.npo.service.ContractKindService;
import com.osp.npo.service.ContractNumberService;
import com.osp.npo.service.ContractService;
import com.osp.npo.service.LostNumberService;
import com.osp.npo.service.TemporaryContractService;
import com.osp.npo.service.UserService;

/**
 * <P>
 * Temporary Contract Regist Action
 * </P>
 * 
 * @author TruongND
 * @version $Revision: 22549 $
 */
@SuppressWarnings("unchecked")
public class TemporaryContractRegistAction extends BaseMDAction {

	private static final String SUCCESS = "success";
	private static final String FAILURE_PATH = "failure";
	public static final String FAILURE_PATH2 = "deleted";
	public static final String GENERATE_FAILURE = "generatefail";
	private static final String NO_LOGIN = "nologin";
	private static final String NOTARY_ROLE = "02";
	private static final String DRAFTER_ROLE = "03";
	private static final Long BANK_NONE_SELECTED = 0L;
	private static final String ORDER_FIELD_USER = "first_name";
	private static final String ORDER_FIELD_BANK = "order_number";
	
	private static final String CREATE_COPY_ID = "tcid";

	private static final String NPO_USER = "npo_user";
	private static final String USER_ID = "id";
	private static final String UPLOAD_FOLDER_KEY = "system_contract_folder";
	private static final String CONTRACT_FILE_NAME_PREFIX = "CNTR_";
	private static final String CONTRACT_NUMBER_DEFAULT = "/";
	private static final String DISPLAY = "1";


    private static final String LAND_TYPE = "01";
    private static final String VEHICLE_TYPE = "02";
    private static final String OTHER_TYPE = "99";
    
	private static final String DOT = "\\.";
    private static final Long TOTAL_NUMBER = (long) 0;

	/**
	 * <P>
	 * Action for first view
	 * </P>
	 * 
	 * @author TruongND
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

		createTitle(Constants.SCREEN_CNTR029);

		HttpSession session = request.getSession();

		// delete session
		if (session.getAttribute(TemporaryContractViewHelper.SESSION_KEY) != null) {
			session.removeAttribute(TemporaryContractViewHelper.SESSION_KEY);
		}

		TemporaryContractViewHelper temporaryContractViewHelper = new TemporaryContractViewHelper();

		loadDefault(temporaryContractViewHelper);

//		temporaryContractViewHelper.setReceivedDate(RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()));
		temporaryContractViewHelper.setContractNumber(CONTRACT_NUMBER_DEFAULT + Calendar.getInstance().get(Calendar.YEAR));
		
		session.setAttribute(TemporaryContractViewHelper.SESSION_KEY,
				temporaryContractViewHelper);

		return mapping.findForward(SUCCESS);
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

        createTitle(Constants.SCREEN_CNTR029);

        TemporaryContractViewHelper temporaryContractViewHelper = new TemporaryContractViewHelper();

        loadDefault(temporaryContractViewHelper);

        String forward = loadCopyInfo(mapping, request, temporaryContractViewHelper, request.getParameter(CREATE_COPY_ID));

        request.getSession().setAttribute(TemporaryContractViewHelper.SESSION_KEY, temporaryContractViewHelper);

        return mapping.findForward(forward);

    }

	/**
	 * <P>
	 * Action for regist
	 * </P>
	 * 
	 * @author TruongND
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward regist(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CommonContext commonContext = (CommonContext) request.getSession()
				.getAttribute(CommonContext.SESSION_KEY);

		TemporaryContractViewHelper temporaryContractViewHelper = (TemporaryContractViewHelper) request
				.getSession().getAttribute(
						TemporaryContractViewHelper.SESSION_KEY);
		if (temporaryContractViewHelper == null) {
			return mapping.findForward(NO_LOGIN);
		}

		MessageUtil messageUtil = new MessageUtil();

		TemporaryContractForm temporaryContractForm = (TemporaryContractForm) form;

		temporaryContractViewHelper.reset(temporaryContractForm);

		UserService userService = new UserService(getConnection());
		TemporaryContractService temporaryContractService = new TemporaryContractService(
				getConnection());

		if (DISPLAY.equals(commonContext.getContractDrafter())
				&& userService.isExistInDB(NPO_USER, new Object[][] {
						{ USER_ID, temporaryContractForm.getDrafterId() },
						{ "active_flg", false } })) {
			ActionErrors errors = new ActionErrors();
			errors.add(messageUtil.createActionMessages("", request,
					"err_user_inactive", "item_selected_drafter"));
			this.addErrors(request, errors);
			return mapping.findForward(SUCCESS);
		}

		// Set contract info
		TemporaryContractInfo temporaryContractInfo = new TemporaryContractInfo();

		temporaryContractInfo.setTcid(temporaryContractForm.getContractId());
		temporaryContractInfo.setContractTemplateId(temporaryContractForm
				.getContractTemplateId());
		temporaryContractInfo.setContractNumber(temporaryContractForm
				.getContractNumber());
		if (!EditString.isNull(temporaryContractForm.getContractValue())) {
			temporaryContractInfo.setContractValue(temporaryContractForm
					.getContractValue().replaceAll(DOT, ""));
		}
		temporaryContractInfo.setRelationObjectA(temporaryContractForm
				.getRelationObjectA());
		temporaryContractInfo.setRelationObjectB(temporaryContractForm
				.getRelationObjectB());
		temporaryContractInfo.setRelationObjectC(temporaryContractForm
				.getRelationObjectC());

		temporaryContractInfo.setNotaryId(temporaryContractForm.getNotaryId());
		if (DISPLAY.equals(commonContext.getContractDrafter())) {
			temporaryContractInfo.setDrafterId(temporaryContractForm
					.getDrafterId());
		} else {
			temporaryContractInfo.setDrafterId(null);
		}

		temporaryContractInfo.setReceivedDate(RelateDateTime
				.toTimestamp(temporaryContractForm.getReceivedDate()));
		temporaryContractInfo.setNotaryDate(RelateDateTime
				.toTimestamp(temporaryContractForm.getNotaryDate()));
		if (!EditString.isNull(temporaryContractForm.getCostTt91())) {
			temporaryContractInfo.setCostTt91(temporaryContractForm
					.getCostTt91().replaceAll(DOT, ""));
		}
		if (!EditString.isNull(temporaryContractForm.getCostDraft())) {
			temporaryContractInfo.setCostDraft(temporaryContractForm
					.getCostDraft().replaceAll(DOT, ""));
		}
		if (!EditString.isNull(temporaryContractForm.getCostNotaryOutsite())) {
			temporaryContractInfo.setCostNotaryOutsite(temporaryContractForm
					.getCostNotaryOutsite().replaceAll(DOT, ""));
		}
		if (!EditString.isNull(temporaryContractForm.getCostOtherDetermine())) {
			temporaryContractInfo.setCostOtherDetermine(temporaryContractForm
					.getCostOtherDetermine().replaceAll(DOT, ""));
		}
		if (!EditString.isNull(temporaryContractForm.getCostTotal())) {
			temporaryContractInfo.setCostTotal(temporaryContractForm
					.getCostTotal().replaceAll(DOT, ""));
		}

		if (temporaryContractForm.getNotaryPlaceFlag() == null
				|| temporaryContractForm.getNotaryPlaceFlag()) {
			temporaryContractInfo.setNotaryPlaceFlag(Boolean.TRUE);
		} else {
			temporaryContractInfo.setNotaryPlaceFlag(Boolean.FALSE);
			temporaryContractInfo.setNotaryPlace(temporaryContractForm
					.getNotaryPlace());
		}

		temporaryContractInfo.setSummary(temporaryContractForm
				.getContractSummary());
		if (!BANK_NONE_SELECTED.equals(temporaryContractForm.getBankId())) {
			temporaryContractInfo.setBankId(temporaryContractForm.getBankId());
		}
		if (!EditString.isNull(temporaryContractForm.getBankServiceFee())) {
			temporaryContractInfo.setBankServiceFee(temporaryContractForm
					.getBankServiceFee().replaceAll(DOT, ""));
		}

		temporaryContractInfo.setCrediterName(temporaryContractForm
				.getCrediterName());
		temporaryContractInfo.setOriginalStorePlace(temporaryContractForm
				.getOriginalStorePlace());
		temporaryContractInfo.setNote(temporaryContractForm.getContractNote());

		temporaryContractInfo.setUserRequireContract(temporaryContractForm
				.getUserRequireContract());
		temporaryContractInfo.setNumberCopyOfContract(temporaryContractForm
				.getNumberCopyOfContract());
		temporaryContractInfo.setNumberOfPage(temporaryContractForm
				.getNumberOfPage());
		temporaryContractInfo.setPropertyType(temporaryContractForm
				.getPropertyType());
		
		 if (temporaryContractForm.getIsDetailPropertyEntry()) {
	            if (LAND_TYPE.equals(temporaryContractForm.getPropertyType())) {
	                temporaryContractInfo.setLandAddress(temporaryContractForm.getLandAddress());
	                temporaryContractInfo.setLandArea(temporaryContractForm.getLandArea());
	                temporaryContractInfo.setLandCertificate(temporaryContractForm.getLandCertificate());
	                temporaryContractInfo.setLandIssueDate(RelateDateTime.toTimestamp(false, temporaryContractForm.getLandIssueDate()));
	                temporaryContractInfo.setLandIssuePlace(temporaryContractForm.getLandIssuePlace());
	                temporaryContractInfo.setLandMapNumber(temporaryContractForm.getLandMapNumber());
	                temporaryContractInfo.setLandNumber(temporaryContractForm.getLandNumber());
	                temporaryContractInfo.setLandPrivateArea(temporaryContractForm.getLandPrivateArea());
	                temporaryContractInfo.setLandPublicArea(temporaryContractForm.getLandPublicArea());
	                temporaryContractInfo.setLandUseOrigin(temporaryContractForm.getLandUseOrigin());
	                temporaryContractInfo.setLandUsePeriod(temporaryContractForm.getLandUsePeriod());
	                temporaryContractInfo.setLandUsePurpose(temporaryContractForm.getLandUsePurpose());
	                temporaryContractInfo.setLandAssociateProperty(temporaryContractForm.getLandAssociateProperty());
	                
	                String info = "";                
	                if (!EditString.isNull(temporaryContractForm.getLandAddress())) {
	                    info += SystemMessageProperties.getSystemProperty("item_address") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getLandAddress();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }                
	                if (!EditString.isNull(temporaryContractForm.getLandCertificate())) {
	                    info += SystemMessageProperties.getSystemProperty("item_land_code") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getLandCertificate();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getLandIssuePlace())) {
	                    info += SystemMessageProperties.getSystemProperty("item_issue_place") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getLandIssuePlace();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getLandIssueDate())) {
	                    info += SystemMessageProperties.getSystemProperty("item_given_date") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getLandIssueDate();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getLandNumber())) {
	                    info += SystemMessageProperties.getSystemProperty("item_land_number") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getLandNumber();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getLandMapNumber())) {
	                    info += SystemMessageProperties.getSystemProperty("item_map_number") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getLandMapNumber();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getLandArea())) {
	                    info += SystemMessageProperties.getSystemProperty("item_land_area") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getLandArea();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getLandPrivateArea())) {
	                    info += SystemMessageProperties.getSystemProperty("item_land_private_area") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getLandPrivateArea();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getLandPublicArea())) {
	                    info += SystemMessageProperties.getSystemProperty("item_land_public_area") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getLandPublicArea();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getLandUsePurpose())) {
	                    info += SystemMessageProperties.getSystemProperty("item_land_use_purpose") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getLandUsePurpose();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getLandUsePeriod())) {
	                    info += SystemMessageProperties.getSystemProperty("item_land_use_period") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getLandUsePeriod();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getLandUseOrigin())) {
	                    info += SystemMessageProperties.getSystemProperty("item_land_use_origin") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getLandUseOrigin();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getLandAssociateProperty())) {
	                    info += SystemMessageProperties.getSystemProperty("item_land_associate_property") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getLandAssociateProperty();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                
	                if (!EditString.isNull(temporaryContractForm.getOwnerInfo())) {
	                    info += SystemMessageProperties.getSystemProperty("item_owner") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getOwnerInfo();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                
	                if (!EditString.isNull(temporaryContractForm.getOtherInfo())) {
	                    info += SystemMessageProperties.getSystemProperty("item_other_info") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getOtherInfo();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                
	                temporaryContractInfo.setPropertyInfo(info);
	                
	            } else if (VEHICLE_TYPE.equals(temporaryContractForm.getPropertyType())) {
	                temporaryContractInfo.setCarFrameNumber(temporaryContractForm.getCarFrameNumber());
	                temporaryContractInfo.setCarIssueDate(RelateDateTime.toTimestamp(false, temporaryContractForm.getCarIssueDate()));
	                temporaryContractInfo.setCarIssuePlace(temporaryContractForm.getCarIssuePlace());
	                temporaryContractInfo.setCarLicenseNumber(temporaryContractForm.getCarLicenseNumber());
	                temporaryContractInfo.setCarMachineNumber(temporaryContractForm.getCarMachineNumber());
	                temporaryContractInfo.setCarRegistNumber(temporaryContractForm.getCarRegistNumber());
	                
	                String info = "";
	                if (!EditString.isNull(temporaryContractForm.getCarLicenseNumber())) {
	                    info += SystemMessageProperties.getSystemProperty("item_vehicle_code") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getCarLicenseNumber();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getCarRegistNumber())) {
	                    info += SystemMessageProperties.getSystemProperty("item_regist_number") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getCarRegistNumber();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getCarIssuePlace())) { 
	                    info += SystemMessageProperties.getSystemProperty("item_issue_place") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getCarIssuePlace();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getCarIssueDate())) {
	                    info += SystemMessageProperties.getSystemProperty("item_given_date") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getCarIssueDate();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getCarFrameNumber())) {
	                    info += SystemMessageProperties.getSystemProperty("item_frame_number") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getCarFrameNumber();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                if (!EditString.isNull(temporaryContractForm.getCarMachineNumber())) {
	                    info += SystemMessageProperties.getSystemProperty("item_machine_number") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getCarMachineNumber();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                
	                if (!EditString.isNull(temporaryContractForm.getOwnerInfo())) {
	                    info += SystemMessageProperties.getSystemProperty("item_owner") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getOwnerInfo();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                
	                if (!EditString.isNull(temporaryContractForm.getOtherInfo())) {
	                    info += SystemMessageProperties.getSystemProperty("item_other_info") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getOtherInfo();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                
	                temporaryContractInfo.setPropertyInfo(info);
	                
	            } else if (OTHER_TYPE.equals(temporaryContractForm.getPropertyType())) {
	            	String info = "";
	                info += temporaryContractForm.getPropertyInfo();
	                
	                if (!EditString.isNull(temporaryContractForm.getOwnerInfo())) {
	                    info += SystemMessageProperties.getSystemProperty("item_owner") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getOwnerInfo();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                
	                if (!EditString.isNull(temporaryContractForm.getOtherInfo())) {
	                    info += SystemMessageProperties.getSystemProperty("item_other_info") + Constants.COLON + Constants.SPACE
	                            + temporaryContractForm.getOtherInfo();
	                    info += Constants.SEMI_COLON + Constants.SPACE;
	                }
	                
	                temporaryContractInfo.setPropertyInfo(info);
	            }
	            
	            temporaryContractInfo.setOwnerInfo(temporaryContractForm.getOwnerInfo());
	            temporaryContractInfo.setOtherInfo(temporaryContractForm.getOtherInfo());
	            
	        } else {
	        	temporaryContractInfo.setPropertyInfo(temporaryContractForm
				.getPropertyInfo());
	        }
		temporaryContractInfo.setType((byte) 0);
		createEntryUserInfo(temporaryContractInfo);

		try {
			String localName = EditString
					.convertUnicodeToASCII(temporaryContractForm.getFormFile()
							.getFileName());
			String path = "";

			if (!EditString.isNull(localName)) {
				File file = FileUtil.createNewFile(
						SystemProperties.getProperty(UPLOAD_FOLDER_KEY),
						CONTRACT_FILE_NAME_PREFIX);
				FileOutputStream outputStream = null;
				outputStream = new FileOutputStream(file);
				outputStream.write(temporaryContractForm.getFormFile()
						.getFileData());
				path = file.getAbsolutePath();
			}

			temporaryContractViewHelper.setFileName(localName);
			temporaryContractViewHelper.setFilePath(path);

			temporaryContractInfo.setFileName(localName);
			temporaryContractInfo.setFilePath(path);

			// entry temporaryContractInfo to database
			temporaryContractService
					.entryTemporaryContract(temporaryContractInfo);

			temporaryContractViewHelper.setContractId(temporaryContractInfo
					.getTcid());

		} catch (IOException e) {
			ActionErrors errors = new ActionErrors();
			errors.add(messageUtil.createActionMessages("",
					"err_cannot_upload_file"));
			this.addErrors(request, errors);
			return mapping.findForward(FAILURE_PATH);
		}
		//Tang so hop dong
		
		 String check = EditString.getNumber(temporaryContractInfo.getContractNumber());
	        if (check!=null) {
	        	Long checkNumber = Long.parseLong(check);
				CommonService commonService = new CommonService(getConnection());
				ContractNumberService contractNumberService = new ContractNumberService(
						getConnection());
				
				ContractNumberInfo contractNumberInfo;
				
				SystemConfigInfo systemConfigInfo = commonService
				.querySystemConfigByKey("number_formula", false);
				String numberFormula = systemConfigInfo.getConfigValue();
				if (numberFormula.contains("#NUM#")) {
					contractNumberInfo = contractNumberService
					.queryContractNumberByContractKindId(TOTAL_NUMBER);
				} else {
					ContractTemplateInfo contractTemplateInfo = temporaryContractService
					.queryContractTemplateById(temporaryContractInfo.getContractTemplateId(), false);
					contractNumberInfo = contractNumberService
					.queryContractNumberByContractKindId(contractTemplateInfo.getKindId());
				}
					
					if (contractNumberInfo.getContractNumber()>checkNumber) {
						LostNumberService lostNumberService = new LostNumberService(getConnection());
						LostNumberInfo lostNumberInfo = new LostNumberInfo();
						lostNumberInfo.setKindId(contractNumberInfo.getKindId());
						lostNumberInfo.setLostContractNumber(checkNumber);
						lostNumberInfo.setYear(Calendar.getInstance().get(Calendar.YEAR));
						lostNumberInfo = lostNumberService.queryLostNumber(lostNumberInfo);
						if (lostNumberInfo==null) {
						} else {
							lostNumberService.removeLostNumber(lostNumberInfo);
						}
					} else if (contractNumberInfo.getContractNumber()<checkNumber) {
						LostNumberService lostNumberService = new LostNumberService(getConnection());
						for (int i = contractNumberInfo.getContractNumber().intValue(); i < checkNumber; i++) {
							LostNumberInfo lostNumberInfo = new LostNumberInfo();
							lostNumberInfo.setKindId(contractNumberInfo.getKindId());
							lostNumberInfo.setLostContractNumber((long)i);
							lostNumberInfo.setYear(Calendar.getInstance().get(Calendar.YEAR));
							lostNumberService.entryLostNumber(lostNumberInfo);
							
						} 
					contractNumberInfo.setContractNumber(checkNumber+1);
					contractNumberService.modifyContractNumber(contractNumberInfo);	
					} else {
						contractNumberInfo.setContractNumber(contractNumberInfo.getContractNumber()+1);
						contractNumberService.modifyContractNumber(contractNumberInfo);	
					}
				
	        }
		
		//Dang ky comment
		if (!EditString.isNull(temporaryContractForm.getContractComment())) {
			ContractCommentInfo contractCommentInfo = new ContractCommentInfo();
	
			contractCommentInfo.setCcid(temporaryContractForm.getCcid());
			contractCommentInfo.setComment(temporaryContractForm.getContractComment());
			createEntryUserInfo(contractCommentInfo);
			contractCommentInfo.setTcid(temporaryContractInfo.getTcid());
			temporaryContractService.entryContractComment(contractCommentInfo);
		}		
		getConnection().commit();

		ActionMessages messages = new ActionMessages();
		messages.add(messageUtil.createActionMessages("", request,
				"msg_regist_success", "item_contract"));
		this.addMessages(request, messages);
		return mapping.findForward(SUCCESS);
	}

	/**
	 * <P>
	 * Action back
	 * </P>
	 * 
	 * @author TruongND
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		TemporaryContractViewHelper temporaryContractViewHelper = (TemporaryContractViewHelper) request
				.getSession().getAttribute(
						TemporaryContractViewHelper.SESSION_KEY);
		if (temporaryContractViewHelper == null) {
			return mapping.findForward(NO_LOGIN);
		}

		return mapping.findForward(SUCCESS);
	}

	/**
	 * <P>
	 * Action add property
	 * </P>
	 * 
	 * @author TruongND
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward addProperty(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		TemporaryContractViewHelper temporaryContractViewHelper = (TemporaryContractViewHelper) request
				.getSession().getAttribute(
						TemporaryContractViewHelper.SESSION_KEY);
		if (temporaryContractViewHelper == null) {
			return mapping.findForward(NO_LOGIN);
		}

		TemporaryContractForm temporaryCcontractForm = (TemporaryContractForm) form;

		temporaryContractViewHelper.reset(temporaryCcontractForm);

		return mapping.findForward(SUCCESS);
	}

	/**
	 * Load default list and value for first view
	 * 
	 * @param temporaryContractViewHelper
	 * @throws Exception
	 */
	private void loadDefault(
			TemporaryContractViewHelper temporaryContractViewHelper)
			throws Exception {
		BasicDataService basicDataService = new BasicDataService(
				getConnection());
		UserService userService = new UserService(getConnection());
		ContractService contractService = new ContractService(
				getConnection());
		CommonService commonService = new CommonService(getConnection());
		ContractKindService contractKindService = new ContractKindService(
				getConnection());

		// Set value for first view
		basicDataService.addOrderFieldBank(new OrderField(ORDER_FIELD_BANK));
		temporaryContractViewHelper.setBankList(basicDataService.queryAllBank(
				false).getList());

		userService.setActiveFlgFilter(Boolean.TRUE);
		userService.setHiddenFlgFilter(Boolean.FALSE);
		userService.setRoleFilter(new String[] { DRAFTER_ROLE });
		userService.addOrderFieldUser(new OrderField(ORDER_FIELD_USER));
		temporaryContractViewHelper.setDrafterList(userService.queryAllUser(
				false).getList());
		userService.setRoleFilter(new String[] { NOTARY_ROLE });
		temporaryContractViewHelper.setNotaryList(userService.queryAllUser(
				false).getList());
		
		temporaryContractViewHelper
				.setContractTemplateList(contractService
						.queryAllContractTemplate(false).getList());

		temporaryContractViewHelper.setPropertyTypeList(commonService
				.queryAllProperty().getList());

		temporaryContractViewHelper.setContractKindTree(contractKindService
				.getContractKindTree(false, null));

		temporaryContractViewHelper.setFromRegistScreen(Boolean.TRUE);
		temporaryContractViewHelper.setNotaryPlaceFlag(Boolean.TRUE);
	}
	
	/**
     * Load copy
     *
     * @param temporaryContractViewHelper
     * @throws Exception
     */
    private String loadCopyInfo(ActionMapping mapping, HttpServletRequest request,
            TemporaryContractViewHelper temporaryContractViewHelper, String tcid) throws Exception  {

        TemporaryContractService temporaryContractService = new TemporaryContractService(getConnection());
        MessageUtil messageUtil = new MessageUtil();

        TemporaryContractInfo temporaryContractInfo = null;
        if (EditString.isNumber(tcid)) {
            temporaryContractViewHelper.setTcid(Long.parseLong(tcid));
            temporaryContractService.setContractIdFilter(temporaryContractViewHelper.getTcid());
            temporaryContractInfo = temporaryContractService.queryTemporaryContractByTcid(Long.parseLong(tcid), false);
        }

        if (temporaryContractInfo == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_temporary_contract"));
            this.addErrors(request, errors);
            return FAILURE_PATH;
        }

       
        temporaryContractViewHelper.setContractNumber(CONTRACT_NUMBER_DEFAULT + Calendar.getInstance().get(Calendar.YEAR));
        temporaryContractViewHelper.setContractSummary(temporaryContractInfo.getSummary());
        temporaryContractViewHelper.setNotaryDate(RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()));
        temporaryContractViewHelper.setReceivedDate(RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()));
        
        temporaryContractViewHelper.setNotaryPlaceFlag(Boolean.TRUE);

        temporaryContractViewHelper.setBankId(temporaryContractInfo.getBankId());
        temporaryContractViewHelper.setBankName(temporaryContractInfo.getBankName());
        temporaryContractViewHelper.setBankServiceFee(temporaryContractInfo.getBankServiceFee());
        temporaryContractViewHelper.setCrediterName(temporaryContractInfo.getCrediterName());

        temporaryContractViewHelper.setRelationObjectA(temporaryContractInfo.getRelationObjectA());
        temporaryContractViewHelper.setRelationObjectB(temporaryContractInfo.getRelationObjectB());
        temporaryContractViewHelper.setRelationObjectC(temporaryContractInfo.getRelationObjectC());
        
        temporaryContractViewHelper.setPropertyType(temporaryContractInfo.getPropertyType());
        temporaryContractViewHelper.setPropertyInfo(temporaryContractInfo.getPropertyInfo());

       
        

        return SUCCESS;
    }

}
