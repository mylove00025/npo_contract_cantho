package com.osp.npo.app.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.context.PreventDetailContext;
import com.osp.npo.app.form.DataPreventForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.DataPreventViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.FileUtil;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.prevent.DataPreventHistoryInfo;
import com.osp.npo.core.prevent.DataPreventInfo;
import com.osp.npo.core.prevent.PropertyPreventInfo;
import com.osp.npo.core.synchronize.SynchronizeInfo;
import com.osp.npo.service.CommonService;
import com.osp.npo.service.PreventService;
import com.osp.npo.service.SynchronizeService;

/**
 *
 * Action for register new data prevent
 *
 * @author GiangVT
 * @version $Revision: 29790 $
 */
public class DataPreventRegistAction extends BaseMDAction {

    private static final String SUCCESS_PATH = "success";
    private static final String FAILURE_PATH = "failure";
    private static final String LAND_TYPE = "01";
    private static final String CAR_TYPE = "02";
    private static final String OTHER_TYPE = "99";
    private static final String UPLOAD_FOLDER_KEY = "system_prevent_data_folder";
    private static final String PREVENT_FILE_NAME_PREFIX = "PRV_";
    private static final String NO_LOGIN = "nologin";

    /**
     * Action view
     *
     * @author GiangVT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return success path
     * @throws ServletException
     * @throws SQLException
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        createTitle(Constants.SCREEN_PRV002);
//        BasicDataService basicDataService = new BasicDataService(getConnection());
        CommonService commonService = new CommonService(getConnection());

        request.getSession().removeAttribute(DataPreventViewHelper.SESSION_KEY);
        DataPreventViewHelper dataPreventViewHelper = new DataPreventViewHelper();
        dataPreventViewHelper.setLstProperty(commonService.queryAllProperty().getList());

        dataPreventViewHelper.setPreventDocDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, RelateDateTime.getTimeNow()));
        dataPreventViewHelper.setPreventDocReceiveDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, RelateDateTime.getTimeNow()));
        dataPreventViewHelper.setPreventInputDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, RelateDateTime.getTimeNow()));
        dataPreventViewHelper.setFilePreventExisted(Boolean.FALSE);
        dataPreventViewHelper.setFileReleaseExisted(Boolean.FALSE);
        dataPreventViewHelper.setOriginKind("01");
        dataPreventViewHelper.setReleaseFlg(Boolean.FALSE);
        //dataPreventViewHelper.setDistrictList(basicDataService.queryAllDistrict(false).getList());

        request.getSession().setAttribute(DataPreventViewHelper.SESSION_KEY, dataPreventViewHelper);
        return mapping.findForward(SUCCESS_PATH);
    }

    /**
     * Do register action
     *
     * @author GiangVT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return success path
     * @throws ServletException
     * @throws SQLException
     * @throws Exception
     */
    public ActionForward regist(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {

        DataPreventViewHelper dataPreventViewHelper = (DataPreventViewHelper) request.getSession().getAttribute(DataPreventViewHelper.SESSION_KEY);
        if (dataPreventViewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }

        createTitle(Constants.SCREEN_PRV002);

        MessageUtil messageUtil = new MessageUtil();

        DataPreventForm dataPreventForm = (DataPreventForm) form;
        // save error data to view helper
        dataPreventViewHelper.reset(dataPreventForm);

        DataPreventInfo dataPreventInfo = new DataPreventInfo();
        PropertyPreventInfo propertyPreventInfo = new PropertyPreventInfo();

        createEntryUserInfo(dataPreventInfo);
        createUpdateUserInfo(dataPreventInfo);

        PreventService preventService = new PreventService(getConnection());

        String type = dataPreventForm.getPropertyType();
        propertyPreventInfo.setType(type);

        propertyPreventInfo.setOwnerInfo(dataPreventForm.getOwnerInfo());
        propertyPreventInfo.setOtherInfo(dataPreventForm.getOtherInfo());

        if (dataPreventForm.getIsSimpleInsert()) {
            propertyPreventInfo.setPropertyInfo(dataPreventForm.getPropertyInfo());
        } else {
            String info = "";
            if (LAND_TYPE.equals(type)) {
                propertyPreventInfo.setLandAddress(dataPreventForm.getLandAddress());
                propertyPreventInfo.setLandCertificate(dataPreventForm.getLandCertificate());
                propertyPreventInfo.setLandIssuePlace(dataPreventForm.getLandIssuePlace());
                if (!EditString.isNull(dataPreventForm.getLandIssueDate())) {
                    propertyPreventInfo.setLandIssueDate(RelateDateTime.toTimestamp(false, dataPreventForm.getLandIssueDate()));

                }
                propertyPreventInfo.setLandMapNumber(dataPreventForm.getLandMapNumber());
                propertyPreventInfo.setLandNumber(dataPreventForm.getLandNumber());
                propertyPreventInfo.setLandArea(dataPreventForm.getLandArea());
                propertyPreventInfo.setLandPrivateArea(dataPreventForm.getLandPrivateArea());
                propertyPreventInfo.setLandPublicArea(dataPreventForm.getLandPublicArea());
                propertyPreventInfo.setLandUsePurpose(dataPreventForm.getLandUsePurpose());
                propertyPreventInfo.setLandUsePeriod(dataPreventForm.getLandUsePeriod());
                propertyPreventInfo.setLandUseOrigin(dataPreventForm.getLandUseOrigin());
                propertyPreventInfo.setLandAssociateProperty(dataPreventForm.getLandAssociateProperty());
                propertyPreventInfo.setLandDistrict(dataPreventForm.getLandDistrict());
                propertyPreventInfo.setLandStreet(dataPreventForm.getLandStreet());

                if (!EditString.isNull(dataPreventForm.getLandAddress())) {
                    info += SystemMessageProperties.getSystemProperty("item_address") + Constants.COLON + Constants.SPACE + dataPreventForm.getLandAddress();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getLandCertificate())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_code") + Constants.COLON + Constants.SPACE + dataPreventForm.getLandCertificate();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getLandIssuePlace())) {
                    info += SystemMessageProperties.getSystemProperty("item_issue_place") + Constants.COLON + Constants.SPACE + dataPreventForm.getLandIssuePlace();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getLandIssueDate())) {
                    info += SystemMessageProperties.getSystemProperty("item_given_date") + Constants.COLON + Constants.SPACE + dataPreventForm.getLandIssueDate();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getLandNumber())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_number") + Constants.COLON + Constants.SPACE + dataPreventForm.getLandNumber();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getLandMapNumber())) {
                    info += SystemMessageProperties.getSystemProperty("item_map_number") + Constants.COLON + Constants.SPACE + dataPreventForm.getLandMapNumber();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getLandArea())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_area") + Constants.COLON + Constants.SPACE + dataPreventForm.getLandArea();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getLandPrivateArea())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_private_area") + Constants.COLON + Constants.SPACE + dataPreventForm.getLandPrivateArea();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getLandPublicArea())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_public_area") + Constants.COLON + Constants.SPACE + dataPreventForm.getLandPublicArea();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getLandUsePurpose())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_use_purpose") + Constants.COLON + Constants.SPACE + dataPreventForm.getLandUsePurpose();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getLandUsePeriod())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_use_period") + Constants.COLON + Constants.SPACE + dataPreventForm.getLandUsePeriod();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getLandUseOrigin())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_use_origin") + Constants.COLON + Constants.SPACE + dataPreventForm.getLandUseOrigin();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getLandAssociateProperty())) {
                    info += SystemMessageProperties.getSystemProperty("item_land_associate_property") + Constants.COLON + Constants.SPACE + dataPreventForm.getLandAssociateProperty();
                    //info += Constants.SEMI_COLON + Constants.SPACE;
                }
            } else if (CAR_TYPE.equals(type)) {
                propertyPreventInfo.setCarLicenseNumber(dataPreventForm.getCarLicenseNumber());
                propertyPreventInfo.setCarRegistNumber(dataPreventForm.getCarRegistNumber());
                propertyPreventInfo.setCarIssuePlace(dataPreventForm.getCarIssuePlace());
                if (!EditString.isNull(dataPreventForm.getCarIssueDate())) {
                    propertyPreventInfo.setCarIssueDate(RelateDateTime.toTimestamp(false, dataPreventForm.getCarIssueDate()));
                }
                propertyPreventInfo.setCarFrameNumber(dataPreventForm.getCarFrameNumber());
                propertyPreventInfo.setCarMachineNumber(dataPreventForm.getCarMachineNumber());

                if (!EditString.isNull(dataPreventForm.getCarLicenseNumber())) {
                    info += SystemMessageProperties.getSystemProperty("item_vehicle_code") + Constants.COLON + Constants.SPACE + dataPreventForm.getCarLicenseNumber();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getCarRegistNumber())) {
                    info += SystemMessageProperties.getSystemProperty("item_regist_number") + Constants.COLON + Constants.SPACE + dataPreventForm.getCarRegistNumber();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getCarIssuePlace())) {
                    info += SystemMessageProperties.getSystemProperty("item_issue_place") + Constants.COLON + Constants.SPACE + dataPreventForm.getCarIssuePlace();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getCarIssueDate())) {
                    info += SystemMessageProperties.getSystemProperty("item_given_date") + Constants.COLON + Constants.SPACE + dataPreventForm.getCarIssueDate();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getCarFrameNumber())) {
                    info += SystemMessageProperties.getSystemProperty("item_frame_number") + Constants.COLON + Constants.SPACE + dataPreventForm.getCarFrameNumber();
                    info += Constants.SEMI_COLON + Constants.SPACE;
                }
                if (!EditString.isNull(dataPreventForm.getCarMachineNumber())) {
                    info += SystemMessageProperties.getSystemProperty("item_machine_number") + Constants.COLON + Constants.SPACE + dataPreventForm.getCarMachineNumber();
                    //info += Constants.SEMI_COLON + Constants.SPACE;
                }
            } else if (OTHER_TYPE.equals(type)) {
                info = dataPreventForm.getPropertyInfo();
            } else {
                ActionErrors errors = new ActionErrors();
                errors.add(messageUtil.createActionMessages("propertyInfo", request, "err_not_input_data", "item_property_info"));
                this.addErrors(request, errors);
                return mapping.findForward(FAILURE_PATH);
            }
            propertyPreventInfo.setPropertyInfo(info);
            if (EditString.isNull(info) && EditString.isNull(propertyPreventInfo.getOwnerInfo()) && EditString.isNull(propertyPreventInfo.getOtherInfo()) ) {
                ActionErrors errors = new ActionErrors();
                errors.add(messageUtil.createActionMessages("propertyInfoAll", request, "err_not_input_data", "item_property_info"));
                this.addErrors(request, errors);
                return mapping.findForward(FAILURE_PATH);
            }
        }
        preventService.entryPropertyPrevent(propertyPreventInfo);

        dataPreventInfo.setOriginKind(dataPreventForm.getOriginKind());
        dataPreventInfo.setPropertyId(propertyPreventInfo.getId());

        dataPreventInfo.setPreventInBookNumber(dataPreventForm.getPreventInBookNumber());

        CommonContext context = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);

        dataPreventInfo.setPreventRegistAgency(context.getSystemOfficeName());
        dataPreventInfo.setPreventPersonInfo(dataPreventForm.getPreventPersonInfo());
        dataPreventInfo.setPreventDocNumber(dataPreventForm.getPreventDocNumber());

        if (!EditString.isNull(dataPreventForm.getPreventDocDate())) {
            dataPreventInfo.setPreventDocDate(RelateDateTime.toTimestamp(false, dataPreventForm.getPreventDocDate()));
        }
        if (!EditString.isNull(dataPreventForm.getPreventDocReceiveDate())) {
            dataPreventInfo.setPreventDocReceiveDate(RelateDateTime.toTimestamp(false, dataPreventForm.getPreventDocReceiveDate()));
        }
        if (!EditString.isNull(dataPreventForm.getPreventInputDate())) {
            dataPreventInfo.setPreventInputDate(RelateDateTime.toTimestamp(false, dataPreventForm.getPreventInputDate()));
        }

        dataPreventInfo.setPreventDocSummary(dataPreventForm.getPreventDocSummary());
        dataPreventInfo.setPreventNote(dataPreventForm.getPreventNote());

        if (dataPreventForm.getFormFilePrevent() != null && (!EditString.isNull(dataPreventForm.getFormFilePrevent().getFileName()))) {
            String localName = EditString.convertUnicodeToASCII(dataPreventForm.getFormFilePrevent().getFileName());
            if (!EditString.isNull(localName)) {
                String path = "";

                File file = FileUtil.createNewFile(SystemProperties.getProperty(UPLOAD_FOLDER_KEY), PREVENT_FILE_NAME_PREFIX);
                try {
                    FileOutputStream outputStream = null;
                    outputStream = new FileOutputStream(file);
                    outputStream.write(dataPreventForm.getFormFilePrevent().getFileData());
                    path = file.getAbsolutePath();

                    dataPreventInfo.setPreventFileName(localName);
                    dataPreventInfo.setPreventFilePath(path);
                } catch (IOException e) {
                    ActionErrors errors = new ActionErrors();
                    errors.add(messageUtil.createActionMessages("preventNote", "err_cannot_upload_file"));
                    this.addErrors(request, errors);
                    return mapping.findForward(FAILURE_PATH);
                }
            }
        }
        dataPreventInfo.setReleaseFlg(Boolean.FALSE);
        dataPreventInfo.setDeleteFlg(Boolean.FALSE);
        createEntryUserInfo(dataPreventInfo);
        
        //For lucence search
        dataPreventInfo.setPropertyInfo(propertyPreventInfo.getPropertyInfo());
        dataPreventInfo.setType(propertyPreventInfo.getType());
        dataPreventInfo.setOwnerInfo(propertyPreventInfo.getOwnerInfo());
        dataPreventInfo.setOtherInfo(propertyPreventInfo.getOtherInfo());
        
        preventService.entryDataPrevent(dataPreventInfo);
        
        // set synchronize id to data prevent info
        dataPreventInfo.setSynchronizeId(context.getSystemOfficeAuthorityID() + Constants.UNIT_SEPARATOR + dataPreventInfo.getId());
        preventService.modifyDataPrevent(dataPreventInfo);

        DataPreventHistoryInfo historyInfo = new DataPreventHistoryInfo();
        historyInfo.setPreventId(dataPreventInfo.getId());
        historyInfo.setClientInfo(getClientInfo(request));
        historyInfo.setExecuteDateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        historyInfo.setExecuteContent(SystemMessageProperties.getSystemProperty(Constants.PREVENT_ENTRY_KEY));
        createEntryUserInfo(historyInfo);
        historyInfo.setExecutePerson(historyInfo.getUpdateUserName());
        preventService.entryDataPreventHistory(historyInfo);

        SynchronizeInfo synchronizeInfo = new SynchronizeInfo();
        synchronizeInfo.setType(Constants.SYNCHRONIZE_TYPE_PREVENT);
        synchronizeInfo.setAction(Constants.SYNCHRONIZE_ACTION_REGIST);
        synchronizeInfo.setDataId(context.getSystemOfficeAuthorityID() + Constants.UNIT_SEPARATOR + dataPreventInfo.getId());
        synchronizeInfo.setAuthenticationId(context.getSystemOfficeAuthorityID());
        synchronizeInfo.setEntryDateTime(RelateDateTime.getTimeNow());
        SynchronizeService synService = new SynchronizeService(getConnection());
        synService.entrySynchronize(synchronizeInfo);
        

        getConnection().commit();
        ActionMessages messages = new ActionMessages();
        messages.add(messageUtil.createActionMessages("", request, "msg_regist_success", "item_prevent_data"));
        this.addMessages(request, messages);

        PreventDetailContext detailContext = new PreventDetailContext();
        detailContext.setFromRegist(Boolean.TRUE);
        detailContext.setPreventId(dataPreventInfo.getId());
        request.getSession().setAttribute(PreventDetailContext.SESSION_KEY, detailContext);

        return mapping.findForward(SUCCESS_PATH);
    }
}