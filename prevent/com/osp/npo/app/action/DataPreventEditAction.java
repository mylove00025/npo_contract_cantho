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
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
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
import com.osp.npo.core.prevent.DataPreventList;
import com.osp.npo.core.prevent.PropertyPreventInfo;
import com.osp.npo.core.synchronize.SynchronizeInfo;
import com.osp.npo.service.CommonService;
import com.osp.npo.service.PreventService;
import com.osp.npo.service.SynchronizeService;

/**
 *
 * DataPreventEditAction class
 *
 * @author GiangVT
 * @version $Revision: 29790 $
 */
public class DataPreventEditAction extends BaseMDAction {

    private static final String SUCCESS_PATH = "success";
    private static final String FAILURE_PATH = "failure";
    private static final String NOT_PERMISSION = "unpermission";
    private static final String LAND_TYPE = "01";
    private static final String CAR_TYPE = "02";
    private static final String OTHER_TYPE = "99";
    private static final String UPLOAD_FOLDER_KEY = "system_prevent_data_folder";
    private static final String PREVENT_FILE_NAME_PREFIX = "PRV_";
    private static final String NO_LOGIN = "nologin";
    private static final String PREVENT_FILE_PARAM = "prevent";
//    private static final String ORDER_FIELD_PROVINCE = "order_number";
//    private static final String ORDER_FIELD_DISTRICT = "order_number";

    /**
     * Action view
     *
     * @author GiangVT
     * @param mapping
     *            the mapping
     * @param form
     *            the form
     * @param request
     *            of action
     * @param response
     *            of action
     * @return success path
     * @throws ServletException
     *             exception
     * @throws SQLException
     *             exception
     * @throws Exception
     *             common
     */
    @SuppressWarnings("unchecked")
    public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        createTitle(Constants.SCREEN_PRV003);
        MessageUtil messageUtil = new MessageUtil();

        Long preventid = Long.parseLong(request.getParameter("id"));
        PreventService preventService = new PreventService(getConnection());
        preventService.setIdFilter(preventid);
        DataPreventList dataPreventList = preventService.queryAllDataPrevent(false);
        if (dataPreventList.size() != 1) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_prevent_data"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        DataPreventInfo dataPreventInfo = dataPreventList.get(0);
        if (dataPreventInfo.getDeleteFlg() != null && dataPreventInfo.getDeleteFlg()) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_data_already_deleted", "item_prevent_data"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        CommonService commonService = new CommonService(getConnection());

        request.getSession().removeAttribute(DataPreventViewHelper.SESSION_KEY);

        DataPreventViewHelper dataPreventViewHelper = new DataPreventViewHelper();

        dataPreventViewHelper.setId(preventid);
        dataPreventViewHelper.setPropertyId(dataPreventInfo.getPropertyId());

        String type = dataPreventInfo.getType();
        dataPreventViewHelper.setPropertyType(type);
        dataPreventViewHelper.setLstProperty(commonService.queryAllProperty().getList());
        if (!(LAND_TYPE.equals(type) || CAR_TYPE.equals(type) || OTHER_TYPE.equals(type))) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_invalid_data", "item_prevent_data"));
            this.addErrors(request, errors);
            return mapping.findForward(SUCCESS_PATH);
        }

        CommonContext context = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);
        String synId = "" + context.getSystemOfficeAuthorityID() + Constants.UNIT_SEPARATOR + dataPreventInfo.getId();
        if (!synId.equals(dataPreventInfo.getSynchronizeId())) {
            ActionErrors errors = new ActionErrors();
            errors.add("", new ActionMessage("err_access_deny"));
            this.addErrors(request, errors);
            return mapping.findForward(NOT_PERMISSION);
        }

        dataPreventViewHelper.setLandAddress(dataPreventInfo.getLandAddress());
        dataPreventViewHelper.setLandCertificate(dataPreventInfo.getLandCertificate());
        dataPreventViewHelper.setLandIssuePlace(dataPreventInfo.getLandIssuePlace());
        dataPreventViewHelper.setLandIssueDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getLandIssueDate()));
        dataPreventViewHelper.setLandMapNumber(dataPreventInfo.getLandMapNumber());
        dataPreventViewHelper.setLandNumber(dataPreventInfo.getLandNumber());
        dataPreventViewHelper.setLandArea(dataPreventInfo.getLandArea());
        dataPreventViewHelper.setLandPrivateArea(dataPreventInfo.getLandPrivateArea());
        dataPreventViewHelper.setLandPublicArea(dataPreventInfo.getLandPublicArea());
        dataPreventViewHelper.setLandUsePurpose(dataPreventInfo.getLandUsePurpose());
        dataPreventViewHelper.setLandUsePeriod(dataPreventInfo.getLandUsePeriod());
        dataPreventViewHelper.setLandUseOrigin(dataPreventInfo.getLandUseOrigin());
        dataPreventViewHelper.setLandAssociateProperty(dataPreventInfo.getLandAssociateProperty());
        dataPreventViewHelper.setCarLicenseNumber(dataPreventInfo.getCarLicenseNumber());
        dataPreventViewHelper.setCarRegistNumber(dataPreventInfo.getCarRegistNumber());
        dataPreventViewHelper.setCarIssuePlace(dataPreventInfo.getCarIssuePlace());
        dataPreventViewHelper.setCarIssueDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getCarIssueDate()));
        dataPreventViewHelper.setCarFrameNumber(dataPreventInfo.getCarFrameNumber());
        dataPreventViewHelper.setCarMachineNumber(dataPreventInfo.getCarMachineNumber());

        dataPreventViewHelper.setOriginKind(dataPreventInfo.getOriginKind());
        dataPreventViewHelper.setOwnerInfo(dataPreventInfo.getOwnerInfo());
        dataPreventViewHelper.setOtherInfo(dataPreventInfo.getOtherInfo());
        dataPreventViewHelper.setLandDistrict(dataPreventInfo.getLandDistrict());
        dataPreventViewHelper.setLandStreet(dataPreventInfo.getLandStreet());

        if (!OTHER_TYPE.equals(type)) {
            dataPreventViewHelper.setPropertyInfo("");
        } else {
            dataPreventViewHelper.setPropertyInfo(dataPreventInfo.getPropertyInfo());
        }

        // prevent
        dataPreventViewHelper.setPreventInBookNumber(dataPreventInfo.getPreventInBookNumber());
        dataPreventViewHelper.setPreventRegistAgency(dataPreventInfo.getPreventRegistAgency());
        dataPreventViewHelper.setPreventPersonInfo(dataPreventInfo.getPreventPersonInfo());
        dataPreventViewHelper.setPreventDocNumber(dataPreventInfo.getPreventDocNumber());
        dataPreventViewHelper.setPreventDocDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getPreventDocDate()));
        dataPreventViewHelper.setPreventDocReceiveDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getPreventDocReceiveDate()));
        dataPreventViewHelper.setPreventInputDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getPreventInputDate()));
        dataPreventViewHelper.setPreventDocSummary(dataPreventInfo.getPreventDocSummary());
        dataPreventViewHelper.setPreventNote(dataPreventInfo.getPreventNote());

        if (EditString.isNull(dataPreventInfo.getPreventFileName()) || EditString.isNull(dataPreventInfo.getPreventFilePath())) {
            dataPreventViewHelper.setFilePreventExisted(Boolean.FALSE);
        } else {
            dataPreventViewHelper.setPreventFileName(dataPreventInfo.getPreventFileName());
            dataPreventViewHelper.setPreventFilePath(dataPreventInfo.getPreventFilePath());
            dataPreventViewHelper.setFilePreventExisted(Boolean.TRUE);
        }

        // release
        dataPreventViewHelper.setReleaseFlg(dataPreventInfo.getReleaseFlg());

        if (dataPreventViewHelper.getReleaseFlg()) {

            dataPreventViewHelper.setReleaseInBookNumber(dataPreventInfo.getReleaseInBookNumber());
            dataPreventViewHelper.setReleaseRegistAgency(dataPreventInfo.getReleaseRegistAgency());
            dataPreventViewHelper.setReleasePersonInfo(dataPreventInfo.getReleasePersonInfo());
            dataPreventViewHelper.setReleaseDocNumber(dataPreventInfo.getReleaseDocNumber());
            dataPreventViewHelper.setReleaseDocDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getReleaseDocDate()));
            dataPreventViewHelper.setReleaseDocReceiveDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getReleaseDocReceiveDate()));
            dataPreventViewHelper.setReleaseInputDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getReleaseInputDate()));
            dataPreventViewHelper.setReleaseDocSummary(dataPreventInfo.getReleaseDocSummary());
            dataPreventViewHelper.setReleaseNote(dataPreventInfo.getReleaseNote());

            if (EditString.isNull(dataPreventInfo.getReleaseFileName()) || EditString.isNull(dataPreventInfo.getReleaseFilePath())) {
                dataPreventViewHelper.setFileReleaseExisted(Boolean.FALSE);
            } else {
                dataPreventViewHelper.setReleaseFileName(dataPreventInfo.getReleaseFileName());
                dataPreventViewHelper.setReleaseFilePath(dataPreventInfo.getReleaseFilePath());
                dataPreventViewHelper.setFileReleaseExisted(Boolean.TRUE);
            }
        }
        dataPreventViewHelper.setIsSimpleInsert(Boolean.TRUE);
        //dataPreventViewHelper.setDistrictList(basicDataService.queryAllDistrict(false).getList());

        request.getSession().setAttribute(DataPreventViewHelper.SESSION_KEY, dataPreventViewHelper);
        return mapping.findForward(SUCCESS_PATH);
    }

    @SuppressWarnings("unchecked")
    public ActionForward viewRelease(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        createTitle(Constants.SCREEN_PRV003);
        MessageUtil messageUtil = new MessageUtil();

        Long preventid = Long.parseLong(request.getParameter("id"));
        PreventService preventService = new PreventService(getConnection());
        preventService.setIdFilter(preventid);
        DataPreventList dataPreventList = preventService.queryAllDataPrevent(false);
        if (dataPreventList.size() != 1) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_prevent_data"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        DataPreventInfo dataPreventInfo = dataPreventList.get(0);

        CommonContext context = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);
        String synId = "" + context.getSystemOfficeAuthorityID() + Constants.UNIT_SEPARATOR + dataPreventInfo.getId();
        if (!synId.equals(dataPreventInfo.getSynchronizeId())) {
            ActionErrors errors = new ActionErrors();
            errors.add("", new ActionMessage("err_access_deny"));
            this.addErrors(request, errors);
            return mapping.findForward(NOT_PERMISSION);
        }

        CommonService commonService = new CommonService(getConnection());

        request.getSession().removeAttribute(DataPreventViewHelper.SESSION_KEY);
        request.getSession().removeAttribute(PreventDetailContext.SESSION_KEY);

        DataPreventViewHelper dataPreventViewHelper = new DataPreventViewHelper();

        dataPreventViewHelper.setId(preventid);
        dataPreventViewHelper.setPropertyId(dataPreventInfo.getPropertyId());

        PreventDetailContext preventDetailContext = new PreventDetailContext();
        String type = dataPreventInfo.getType();
        preventDetailContext.setPropertyType(type);
        preventDetailContext.setLstProperty(commonService.queryAllProperty().getList());
        if (!(LAND_TYPE.equals(type) || CAR_TYPE.equals(type) || OTHER_TYPE.equals(type))) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_invalid_data", "item_prevent_data"));
            this.addErrors(request, errors);
            return mapping.findForward(SUCCESS_PATH);
        }
        if (dataPreventInfo.getReleaseFlg()) {
            return mapping.findForward(SUCCESS_PATH);
        }

        preventDetailContext.setLandAddress(dataPreventInfo.getLandAddress());
        preventDetailContext.setLandCertificate(dataPreventInfo.getLandCertificate());
        preventDetailContext.setLandIssuePlace(dataPreventInfo.getLandIssuePlace());
        preventDetailContext.setLandIssueDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getLandIssueDate()));
        preventDetailContext.setLandMapNumber(dataPreventInfo.getLandMapNumber());
        preventDetailContext.setLandNumber(dataPreventInfo.getLandNumber());
        preventDetailContext.setLandArea(dataPreventInfo.getLandArea());
        preventDetailContext.setLandPrivateArea(dataPreventInfo.getLandPrivateArea());
        preventDetailContext.setLandPublicArea(dataPreventInfo.getLandPublicArea());
        preventDetailContext.setLandUsePurpose(dataPreventInfo.getLandUsePurpose());
        preventDetailContext.setLandUsePeriod(dataPreventInfo.getLandUsePeriod());
        preventDetailContext.setLandUseOrigin(dataPreventInfo.getLandUseOrigin());
        preventDetailContext.setLandAssociateProperty(dataPreventInfo.getLandAssociateProperty());
        preventDetailContext.setCarLicenseNumber(dataPreventInfo.getCarLicenseNumber());
        preventDetailContext.setCarRegistNumber(dataPreventInfo.getCarRegistNumber());
        preventDetailContext.setCarIssuePlace(dataPreventInfo.getCarIssuePlace());
        preventDetailContext.setCarIssueDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getCarIssueDate()));
        preventDetailContext.setCarFrameNumber(dataPreventInfo.getCarFrameNumber());
        preventDetailContext.setCarMachineNumber(dataPreventInfo.getCarMachineNumber());

        preventDetailContext.setOriginKind(dataPreventInfo.getOriginKind());
        preventDetailContext.setOwnerInfo(dataPreventInfo.getOwnerInfo());
        preventDetailContext.setOtherInfo(dataPreventInfo.getOtherInfo());
        String info = dataPreventInfo.getPropertyInfo();
        if (!EditString.isNull(dataPreventInfo.getOwnerInfo())) {
            if (!EditString.isNull(info)) {
                info += Constants.SEMI_COLON + Constants.SPACE;
            }
            info += SystemMessageProperties.getSystemProperty("item_owner")+ Constants.COLON + Constants.SPACE + dataPreventInfo.getOwnerInfo();
            info += Constants.SEMI_COLON + Constants.SPACE;
        }
        if (!EditString.isNull(dataPreventInfo.getOtherInfo())) {
            info += SystemMessageProperties.getSystemProperty("item_other_info")+ Constants.COLON + Constants.SPACE + dataPreventInfo.getOtherInfo();
            info += Constants.SEMI_COLON;
        }
        preventDetailContext.setPropertyInfo(info);
        preventDetailContext.setLandDistrict(dataPreventInfo.getLandDistrict());
        preventDetailContext.setLandStreet(dataPreventInfo.getLandStreet());

        // prevent
        preventDetailContext.setPreventInBookNumber(dataPreventInfo.getPreventInBookNumber());
        preventDetailContext.setPreventRegistAgency(dataPreventInfo.getPreventRegistAgency());
        preventDetailContext.setPreventPersonInfo(dataPreventInfo.getPreventPersonInfo());
        preventDetailContext.setPreventDocNumber(dataPreventInfo.getPreventDocNumber());
        preventDetailContext.setPreventDocDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getPreventDocDate()));
        preventDetailContext.setPreventDocReceiveDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getPreventDocReceiveDate()));
        preventDetailContext.setPreventInputDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getPreventInputDate()));
        preventDetailContext.setPreventDocSummary(dataPreventInfo.getPreventDocSummary());
        preventDetailContext.setPreventNote(dataPreventInfo.getPreventNote());

        if (EditString.isNull(dataPreventInfo.getPreventFileName()) || EditString.isNull(dataPreventInfo.getPreventFilePath())) {
            preventDetailContext.setFilePreventExisted(Boolean.FALSE);
        } else {
            preventDetailContext.setPreventFileName(dataPreventInfo.getPreventFileName());
            preventDetailContext.setPreventFilePath(dataPreventInfo.getPreventFilePath());
            preventDetailContext.setFilePreventExisted(Boolean.TRUE);
        }

        request.getSession().setAttribute(PreventDetailContext.SESSION_KEY, preventDetailContext);

        // release
        dataPreventViewHelper.setReleaseFlg(Boolean.FALSE);

        dataPreventViewHelper.setReleasePersonInfo(dataPreventInfo.getPreventPersonInfo());
        dataPreventViewHelper.setReleaseDocDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, RelateDateTime.getTimeNow()));
        dataPreventViewHelper.setReleaseDocReceiveDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, RelateDateTime.getTimeNow()));
        dataPreventViewHelper.setReleaseInputDate(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, RelateDateTime.getTimeNow()));

        dataPreventViewHelper.setIsSimpleInsert(Boolean.TRUE);

        request.getSession().setAttribute(DataPreventViewHelper.SESSION_KEY, dataPreventViewHelper);
        return mapping.findForward(SUCCESS_PATH);
    }

    /**
     * Do register action
     *
     * @author GiangVT
     * @param mapping
     *            the mapping
     * @param form
     *            the form
     * @param request
     *            of action
     * @param response
     *            of action
     * @return success path
     * @throws ServletException
     *             exception
     * @throws SQLException
     *             exception
     * @throws Exception
     *             common
     */
    public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {

        DataPreventViewHelper dataPreventViewHelper = (DataPreventViewHelper) request.getSession().getAttribute(DataPreventViewHelper.SESSION_KEY);
        if (dataPreventViewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }

        createTitle(Constants.SCREEN_PRV003);

        MessageUtil messageUtil = new MessageUtil();

        DataPreventForm dataPreventForm = (DataPreventForm) form;
        // save error data to view helper
        dataPreventViewHelper.reset(dataPreventForm);

        // get edit prevent info
        Long preventid = dataPreventViewHelper.getId();
        PreventService preventService = new PreventService(getConnection());
        preventService.setIdFilter(preventid);
        DataPreventList dataPreventList = preventService.queryAllDataPrevent(false);
        if (dataPreventList.size() != 1) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_prevent_data"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        DataPreventInfo dataPreventInfo = dataPreventList.get(0);

        CommonContext context = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);
        String synId = "" + context.getSystemOfficeAuthorityID() + Constants.UNIT_SEPARATOR + dataPreventInfo.getId();
        if (!synId.equals(dataPreventInfo.getSynchronizeId())) {
            ActionErrors errors = new ActionErrors();
            errors.add("", new ActionMessage("err_access_deny"));
            this.addErrors(request, errors);
            return mapping.findForward(NOT_PERMISSION);
        }

        PropertyPreventInfo propertyPreventInfo = new PropertyPreventInfo();
        propertyPreventInfo.setId(dataPreventViewHelper.getPropertyId());

        createUpdateUserInfo(dataPreventInfo);

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
                propertyPreventInfo.setLandDistrict("");
                propertyPreventInfo.setLandStreet("");

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
                propertyPreventInfo.setLandDistrict("");
                propertyPreventInfo.setLandStreet("");
            } else {
                dataPreventViewHelper.reset(dataPreventForm);
                ActionErrors errors = new ActionErrors();
                errors.add(messageUtil.createActionMessages("propertyInfo", request, "err_not_input_data", "item_type"));
                this.addErrors(request, errors);
                return mapping.findForward(FAILURE_PATH);
            }
            propertyPreventInfo.setPropertyInfo(info);
            if (EditString.isNull(info) && EditString.isNull(propertyPreventInfo.getOwnerInfo()) && EditString.isNull(propertyPreventInfo.getOtherInfo())) {
                dataPreventViewHelper.reset(dataPreventForm);
                ActionErrors errors = new ActionErrors();
                errors.add(messageUtil.createActionMessages("propertyInfoAll", request, "err_not_input_data", "item_property_info"));
                this.addErrors(request, errors);
                return mapping.findForward(FAILURE_PATH);
            }
        }
        preventService.modifyPropertyPrevent(propertyPreventInfo);

        dataPreventInfo.setOriginKind(dataPreventForm.getOriginKind());
        dataPreventInfo.setPropertyId(propertyPreventInfo.getId());

        dataPreventInfo.setPreventInBookNumber(dataPreventForm.getPreventInBookNumber());

//        CommonContext context = (CommonContext) request.getSession().getAttribute(CommonContext.SESSION_KEY);

        // prevent
        dataPreventInfo.setPreventRegistAgency(context.getSystemOfficeName());
        dataPreventInfo.setPreventPersonInfo(dataPreventForm.getPreventPersonInfo());
        dataPreventInfo.setPreventDocNumber(dataPreventForm.getPreventDocNumber());

        dataPreventInfo.setPreventDocDate(RelateDateTime.toTimestamp(false, dataPreventForm.getPreventDocDate()));

        dataPreventInfo.setPreventDocReceiveDate(RelateDateTime.toTimestamp(false, dataPreventForm.getPreventDocReceiveDate()));

        dataPreventInfo.setPreventInputDate(RelateDateTime.toTimestamp(false, dataPreventForm.getPreventInputDate()));

        dataPreventInfo.setPreventDocSummary(dataPreventForm.getPreventDocSummary());
        dataPreventInfo.setPreventNote(dataPreventForm.getPreventNote());

        // release
        dataPreventInfo.setReleaseInBookNumber(dataPreventForm.getReleaseInBookNumber());
        // dataPreventInfo.setReleaseRegistAgency(context.getSystemOfficeName());
        dataPreventInfo.setReleasePersonInfo(dataPreventForm.getReleasePersonInfo());
        dataPreventInfo.setReleaseDocNumber(dataPreventForm.getReleaseDocNumber());

        dataPreventInfo.setReleaseDocDate(RelateDateTime.toTimestamp(false, dataPreventForm.getReleaseDocDate()));
        dataPreventInfo.setReleaseDocReceiveDate(RelateDateTime.toTimestamp(false, dataPreventForm.getReleaseDocReceiveDate()));
        dataPreventInfo.setReleaseInputDate(RelateDateTime.toTimestamp(false, dataPreventForm.getReleaseInputDate()));

        dataPreventInfo.setReleaseDocSummary(dataPreventForm.getReleaseDocSummary());
        dataPreventInfo.setReleaseNote(dataPreventForm.getReleaseNote());

        // change file prevent
        if (!dataPreventForm.getFilePreventExisted()) {
            if (dataPreventForm.getFormFilePrevent() != null && (!EditString.isNull(dataPreventForm.getFormFilePrevent().getFileName()))) {
                String localName = EditString.convertUnicodeToASCII(dataPreventForm.getFormFilePrevent().getFileName());
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
                    errors.add(messageUtil.createActionMessages("", "err_cannot_upload_file"));
                    this.addErrors(request, errors);
                    return mapping.findForward(FAILURE_PATH);
                }
            } else {
                // remove file
                dataPreventInfo.setPreventFileName("");
                dataPreventInfo.setPreventFilePath("");
            }
        } else {
            dataPreventInfo.setPreventFileName(dataPreventViewHelper.getPreventFileName());
            dataPreventInfo.setPreventFilePath(dataPreventViewHelper.getPreventFilePath());
        }

        // change file release
        if (!dataPreventForm.getFileReleaseExisted()) {
            if (dataPreventForm.getFormFileRelease() != null && (!EditString.isNull(dataPreventForm.getFormFileRelease().getFileName()))) {
                String localName = EditString.convertUnicodeToASCII(dataPreventForm.getFormFileRelease().getFileName());
                String path = "";

                File file = FileUtil.createNewFile(SystemProperties.getProperty(UPLOAD_FOLDER_KEY), PREVENT_FILE_NAME_PREFIX);
                try {
                    FileOutputStream outputStream = null;
                    outputStream = new FileOutputStream(file);
                    outputStream.write(dataPreventForm.getFormFileRelease().getFileData());
                    path = file.getAbsolutePath();

                    dataPreventInfo.setReleaseFileName(localName);
                    dataPreventInfo.setReleaseFilePath(path);
                } catch (IOException e) {
                    ActionErrors errors = new ActionErrors();
                    errors.add(messageUtil.createActionMessages("", "err_cannot_upload_file"));
                    this.addErrors(request, errors);
                    return mapping.findForward(FAILURE_PATH);
                }
            } else {
                // remove file
                dataPreventInfo.setReleaseFileName("");
                dataPreventInfo.setReleaseFilePath("");
            }
        } else {
            dataPreventInfo.setReleaseFileName(dataPreventViewHelper.getReleaseFileName());
            dataPreventInfo.setReleaseFilePath(dataPreventViewHelper.getReleaseFilePath());
        }

        // if user remove file but not input file
        if (EditString.isNull(dataPreventInfo.getReleaseFileName()) || EditString.isNull(dataPreventInfo.getReleaseFilePath())) {
            dataPreventViewHelper.setFileReleaseExisted(Boolean.FALSE);
        } else {
            dataPreventViewHelper.setFileReleaseExisted(Boolean.TRUE);
        }

        createUpdateUserInfo(dataPreventInfo);
        
        //For lucence search
        dataPreventInfo.setPropertyInfo(propertyPreventInfo.getPropertyInfo());
        dataPreventInfo.setType(propertyPreventInfo.getType());
        dataPreventInfo.setOwnerInfo(propertyPreventInfo.getOwnerInfo());
        dataPreventInfo.setOtherInfo(propertyPreventInfo.getOtherInfo());
        
        preventService.modifyDataPrevent(dataPreventInfo);

        DataPreventHistoryInfo historyInfo = new DataPreventHistoryInfo();
        historyInfo.setPreventId(dataPreventInfo.getId());
        historyInfo.setClientInfo(getClientInfo(request));
        historyInfo.setExecuteDateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        historyInfo.setExecuteContent(SystemMessageProperties.getSystemProperty(Constants.PREVENT_UPDATE_KEY));
        createUpdateUserInfo(historyInfo);
        createEntryUserInfo(historyInfo);
        historyInfo.setExecutePerson(historyInfo.getUpdateUserName());
        preventService.entryDataPreventHistory(historyInfo);

        SynchronizeInfo synchronizeInfo = new SynchronizeInfo();
        synchronizeInfo.setType(Constants.SYNCHRONIZE_TYPE_PREVENT);
        synchronizeInfo.setAction(Constants.SYNCHRONIZE_ACTION_EDIT);
        synchronizeInfo.setDataId(context.getSystemOfficeAuthorityID() + Constants.UNIT_SEPARATOR + dataPreventInfo.getId());
        synchronizeInfo.setAuthenticationId(context.getSystemOfficeAuthorityID());
        synchronizeInfo.setEntryDateTime(RelateDateTime.getTimeNow());
        SynchronizeService synService = new SynchronizeService(getConnection());
        synService.entrySynchronize(synchronizeInfo);

        //
        
        getConnection().commit();

        // set context to detail view
        PreventDetailContext detailContext = new PreventDetailContext();
        detailContext.setFromRegist(Boolean.FALSE);
        detailContext.setPreventId(dataPreventInfo.getId());
        request.getSession().setAttribute(PreventDetailContext.SESSION_KEY, detailContext);

        ActionMessages messages = new ActionMessages();
        messages.add(messageUtil.createActionMessages("", request, "msg_update_success", "item_prevent_data"));
        this.addMessages(request, messages);
        return mapping.findForward(SUCCESS_PATH);
    }

    /**
     *
     * delete data prevent record
     *
     * @author GiangVT
     * @param mapping
     *            the mapping
     * @param form
     *            the form
     * @param request
     *            of action
     * @param response
     *            of action
     * @return success path
     * @throws ServletException
     *             exception
     * @throws SQLException
     *             exception
     * @throws Exception
     *             common
     */
    public ActionForward remove(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        // remove data prevent
        DataPreventViewHelper helper = (DataPreventViewHelper) request.getSession().getAttribute(DataPreventViewHelper.SESSION_KEY);
        if (helper == null) {
            return mapping.findForward(NO_LOGIN);
        }
        
        CommonContext context = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);
        if (!context.isPreventDataDelete()) {
        	ActionErrors errors = new ActionErrors();
            errors.add("", new ActionMessage("err_access_deny"));
            this.addErrors(request, errors);
            return mapping.findForward(NOT_PERMISSION);
        }

        Long preventid = helper.getId();
        PreventService preventService = new PreventService(getConnection());
        preventService.setIdFilter(preventid);
        DataPreventList dataPreventList = preventService.queryAllDataPrevent(false);
        if (dataPreventList.size() != 1) {
            ActionErrors errors = new ActionErrors();
            errors.add((new MessageUtil()).createActionMessages("", request, "err_not_exist", "item_prevent_data"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        DataPreventInfo info = dataPreventList.get(0);

        String synId = "" + context.getSystemOfficeAuthorityID() + Constants.UNIT_SEPARATOR + info.getId();
        if (!synId.equals(info.getSynchronizeId())) {
            ActionErrors errors = new ActionErrors();
            errors.add("", new ActionMessage("err_access_deny"));
            this.addErrors(request, errors);
            return mapping.findForward(NOT_PERMISSION);
        }

        info.setDeleteFlg(Boolean.TRUE);
        createUpdateUserInfo(info);
        preventService.modifyDataPrevent(info);

        DataPreventHistoryInfo historyInfo = new DataPreventHistoryInfo();
        historyInfo.setPreventId(preventid);
        historyInfo.setClientInfo(getClientInfo(request));
        historyInfo.setExecuteDateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        historyInfo.setExecuteContent(SystemMessageProperties.getSystemProperty(Constants.PREVENT_DELETE_KEY));
        createUpdateUserInfo(historyInfo);
        createEntryUserInfo(historyInfo);
        historyInfo.setExecutePerson(historyInfo.getUpdateUserName());
        preventService.entryDataPreventHistory(historyInfo);

        SynchronizeInfo synchronizeInfo = new SynchronizeInfo();
        synchronizeInfo.setType(Constants.SYNCHRONIZE_TYPE_PREVENT);
        synchronizeInfo.setAction(Constants.SYNCHRONIZE_ACTION_DELETE);

//        CommonContext context = (CommonContext) request.getSession().getAttribute(CommonContext.SESSION_KEY);
        synchronizeInfo.setDataId(context.getSystemOfficeAuthorityID() + Constants.UNIT_SEPARATOR + info.getId());
        synchronizeInfo.setAuthenticationId(context.getSystemOfficeAuthorityID());

        synchronizeInfo.setEntryDateTime(RelateDateTime.getTimeNow());
        SynchronizeService synService = new SynchronizeService(getConnection());
        synService.entrySynchronize(synchronizeInfo);
        

        getConnection().commit();

        ActionMessages messages = new ActionMessages();
        messages.add(new MessageUtil().createActionMessages("", request, "msg_delete_success", "item_prevent_data"));
        this.addMessages(request, messages);
        return mapping.findForward(SUCCESS_PATH);
    }

    /**
     *
     * release data prevent record
     *
     * @author GiangVT
     * @param mapping
     *            the mapping
     * @param form
     *            the form
     * @param request
     *            of action
     * @param response
     *            of action
     * @return success path
     * @throws ServletException
     *             exception
     * @throws SQLException
     *             exception
     * @throws Exception
     *             common
     */
    public ActionForward releasedone(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        // remove data prevent
        DataPreventViewHelper helper = (DataPreventViewHelper) request.getSession().getAttribute(DataPreventViewHelper.SESSION_KEY);
        if (helper == null) {
            return mapping.findForward(NO_LOGIN);
        }

        Long preventid = helper.getId();
        PreventService preventService = new PreventService(getConnection());
        preventService.setIdFilter(preventid);
        DataPreventList dataPreventList = preventService.queryAllDataPrevent(false);
        if (dataPreventList.size() != 1) {
            ActionErrors errors = new ActionErrors();
            errors.add((new MessageUtil()).createActionMessages("", request, "err_not_exist", "item_prevent_data"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        DataPreventInfo info = dataPreventList.get(0);

        CommonContext context = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);
        String synId = "" + context.getSystemOfficeAuthorityID() + Constants.UNIT_SEPARATOR + info.getId();
        if (!synId.equals(info.getSynchronizeId())) {
            ActionErrors errors = new ActionErrors();
            errors.add("", new ActionMessage("err_access_deny"));
            this.addErrors(request, errors);
            return mapping.findForward(NOT_PERMISSION);
        }

        DataPreventForm dataPreventForm = (DataPreventForm) form;
        // save error data to view helper
        helper.reset(dataPreventForm);

//        CommonContext context = (CommonContext) request.getSession().getAttribute(CommonContext.SESSION_KEY);

        info.setReleaseFlg(Boolean.TRUE);
        info.setReleaseRegistAgency(context.getSystemOfficeName());

        // release
        info.setReleaseInBookNumber(dataPreventForm.getReleaseInBookNumber());
        info.setReleasePersonInfo(dataPreventForm.getReleasePersonInfo());
        info.setReleaseDocNumber(dataPreventForm.getReleaseDocNumber());

        if (!EditString.isNull(dataPreventForm.getReleaseDocDate())) {
            info.setReleaseDocDate(RelateDateTime.toTimestamp(false, dataPreventForm.getReleaseDocDate()));
        }
        if (!EditString.isNull(dataPreventForm.getReleaseDocReceiveDate())) {
            info.setReleaseDocReceiveDate(RelateDateTime.toTimestamp(false, dataPreventForm.getReleaseDocReceiveDate()));
        }
        if (!EditString.isNull(dataPreventForm.getReleaseInputDate())) {
            info.setReleaseInputDate(RelateDateTime.toTimestamp(false, dataPreventForm.getReleaseInputDate()));
        }

        info.setReleaseDocSummary(dataPreventForm.getReleaseDocSummary());
        info.setReleaseNote(dataPreventForm.getReleaseNote());

        // change file release
        if (!dataPreventForm.getFileReleaseExisted()) {
            if (dataPreventForm.getFormFileRelease() != null && (!EditString.isNull(dataPreventForm.getFormFileRelease().getFileName()))) {
                String localName = EditString.convertUnicodeToASCII(dataPreventForm.getFormFileRelease().getFileName());
                String path = "";

                File file = FileUtil.createNewFile(SystemProperties.getProperty(UPLOAD_FOLDER_KEY), PREVENT_FILE_NAME_PREFIX);
                try {
                    FileOutputStream outputStream = null;
                    outputStream = new FileOutputStream(file);
                    outputStream.write(dataPreventForm.getFormFileRelease().getFileData());
                    path = file.getAbsolutePath();

                    info.setReleaseFileName(localName);
                    info.setReleaseFilePath(path);
                } catch (IOException e) {
                    ActionErrors errors = new ActionErrors();
                    errors.add((new MessageUtil()).createActionMessages("", "err_cannot_upload_file"));
                    this.addErrors(request, errors);
                    return mapping.findForward(FAILURE_PATH);
                }
            } else {
                // remove file
                info.setReleaseFileName("");
                info.setReleaseFilePath("");
            }
        } else {
            info.setReleaseFileName(helper.getReleaseFileName());
            info.setReleaseFilePath(helper.getReleaseFilePath());
        }

        // if user remove file but not input file
        if (EditString.isNull(info.getReleaseFileName()) || EditString.isNull(info.getReleaseFilePath())) {
            helper.setFileReleaseExisted(Boolean.FALSE);
        } else {
            helper.setFileReleaseExisted(Boolean.TRUE);
        }

        createUpdateUserInfo(info);
        preventService.modifyDataPrevent(info);

        DataPreventHistoryInfo historyInfo = new DataPreventHistoryInfo();
        historyInfo.setPreventId(preventid);
        historyInfo.setClientInfo(getClientInfo(request));
        historyInfo.setExecuteDateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        historyInfo.setExecuteContent(SystemMessageProperties.getSystemProperty(Constants.PREVENT_RELEASE_KEY));
        createUpdateUserInfo(historyInfo);
        createEntryUserInfo(historyInfo);
        historyInfo.setExecutePerson(historyInfo.getUpdateUserName());
        preventService.entryDataPreventHistory(historyInfo);

        SynchronizeInfo synchronizeInfo = new SynchronizeInfo();
        synchronizeInfo.setType(Constants.SYNCHRONIZE_TYPE_PREVENT);
        synchronizeInfo.setAction(Constants.SYNCHRONIZE_ACTION_RELEASE);
        synchronizeInfo.setDataId(context.getSystemOfficeAuthorityID() + Constants.UNIT_SEPARATOR + info.getId());
        synchronizeInfo.setAuthenticationId(context.getSystemOfficeAuthorityID());
        synchronizeInfo.setEntryDateTime(RelateDateTime.getTimeNow());
        SynchronizeService synService = new SynchronizeService(getConnection());
        synService.entrySynchronize(synchronizeInfo);
        
        //

        getConnection().commit();

        ActionMessages messages = new ActionMessages();
        messages.add(new MessageUtil().createActionMessages("", request, "msg_release_success", "item_prevent_data"));
        this.addMessages(request, messages);
        return mapping.findForward(SUCCESS_PATH);
    }

    public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        DataPreventViewHelper helper = (DataPreventViewHelper) request.getSession().getAttribute(DataPreventViewHelper.SESSION_KEY);
        if (helper == null) {
            return mapping.findForward(NO_LOGIN);
        }

        String fileKind = request.getParameter("file");
        File file;
        String fileName;
        if (PREVENT_FILE_PARAM.equals(fileKind)) {
            file = new File(helper.getPreventFilePath());
            fileName = helper.getPreventFileName();
        } else {
            file = new File(helper.getReleaseFilePath());
            fileName = helper.getReleaseFileName();
        }

        if (file.exists() && file.canRead() && file.isFile() && file.length() < Integer.MAX_VALUE) {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
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
}