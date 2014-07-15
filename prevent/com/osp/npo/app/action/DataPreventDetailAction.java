/**
 *
 */
package com.osp.npo.app.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.context.PreventDetailContext;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.DataPreventViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.core.prevent.DataPreventHistoryList;
import com.osp.npo.core.prevent.DataPreventInfo;
import com.osp.npo.core.prevent.DataPreventList;
import com.osp.npo.service.PreventService;

/**
 * Data prevent detail
 *
 * @author Giangvt
 * @version $Revision: 29790 $
 */
public class DataPreventDetailAction extends BaseMDAction {

    public static final String SUCCESS_PATH = "success";
    public static final String FAILURE_PATH = "failure";
    public static final String LAND_TYPE = "01";
    public static final String CAR_TYPE = "02";
    public static final String OTHER_TYPE = "99";
    private static final String PREVENT_FILE_PARAM = "prevent";
    public static final String NO_LOGIN = "nologin";
    private static final String ORDER_FIELD_EXECUTE_ACTION = "execute_date_time";

    @SuppressWarnings("unchecked")
    public ActionForward view(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        createTitle(Constants.SCREEN_PRV004);
        MessageUtil messageUtil = new MessageUtil();
        request.getSession().removeAttribute(DataPreventViewHelper.SESSION_KEY);
        DataPreventViewHelper dataPreventViewHelper = new DataPreventViewHelper();
        

//        PreventListViewHelper preventListViewHelper = (PreventListViewHelper)request.getSession().getAttribute(PreventListViewHelper.SESSION_KEY);
//        if (preventListViewHelper == null) {
//            return mapping.findForward(NO_LOGIN);
//        } else {
//            preventListViewHelper.setDisplayPreventList(Boolean.TRUE);
//        }

        String parameterId = request.getParameter("id");
        Long preventid = null;
        if (EditString.isNull(parameterId)) {
            PreventDetailContext context = (PreventDetailContext)request.getSession().getAttribute(PreventDetailContext.SESSION_KEY);
            preventid = context.getPreventId();
            dataPreventViewHelper.setFromRegistScreen(context.getFromRegist());
        } else {
            preventid = Long.parseLong(request.getParameter("id"));
            dataPreventViewHelper.setFromRegistScreen(Boolean.FALSE);
        }

        PreventService preventService = new PreventService(getConnection());
        preventService.setIdFilter(preventid);
        preventService.addOrderFieldDataPreventHistory(new OrderField(ORDER_FIELD_EXECUTE_ACTION, OrderType.DESC));

        DataPreventHistoryList dataPreventHistoryList = preventService.queryAllDataPreventHistory(false);
        dataPreventViewHelper.setLstHistoryInfo(dataPreventHistoryList.getList());
        DataPreventList dataPreventList = preventService.queryAllDataPrevent(false);
        if (dataPreventList.size() != 1) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_prevent_data"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        DataPreventInfo dataPreventInfo = dataPreventList.get(0);

        if (dataPreventInfo.getDeleteFlg()) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_data_prevent_already_deleted", "item_prevent_data"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        CommonContext context = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);
        String synId = "" + context.getSystemOfficeAuthorityID() + Constants.UNIT_SEPARATOR + dataPreventInfo.getId();
        if (!synId.equals(dataPreventInfo.getSynchronizeId())) {
            dataPreventViewHelper.setIsNotaryOfficeData(Boolean.FALSE);
        } else {
            dataPreventViewHelper.setIsNotaryOfficeData(Boolean.TRUE);
        }

        dataPreventViewHelper.setId(preventid);
        dataPreventViewHelper.setPropertyId(dataPreventInfo.getPropertyId());

        dataPreventViewHelper.setId(preventid);
        dataPreventViewHelper.setPropertyId(dataPreventInfo.getPropertyId());
        
        dataPreventViewHelper.setLandStreet(dataPreventInfo.getLandStreet());
        dataPreventViewHelper.setLandDistrict(dataPreventInfo.getLandDistrict());

        String type = dataPreventInfo.getType();
        dataPreventViewHelper.setPropertyType(type);

        if (!(LAND_TYPE.equals(type) || CAR_TYPE.equals(type) || OTHER_TYPE.equals(type))) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_invalid_data", "item_prevent_data"));
            this.addErrors(request, errors);
            return mapping.findForward(SUCCESS_PATH);
        }

        dataPreventViewHelper.setOriginKind(dataPreventInfo.getOriginKind());

        // prevent
        dataPreventViewHelper.setPreventPersonInfo(dataPreventInfo.getPreventPersonInfo());
        dataPreventViewHelper.setPreventInBookNumber(dataPreventInfo.getPreventInBookNumber());
        dataPreventViewHelper.setPreventRegistAgency(dataPreventInfo.getPreventRegistAgency());
        dataPreventViewHelper.setPreventDocNumber(dataPreventInfo.getPreventDocNumber());
        dataPreventViewHelper.setPreventDocDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getPreventDocDate()));
        dataPreventViewHelper.setPreventDocReceiveDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getPreventDocReceiveDate()));
        dataPreventViewHelper.setPreventInputDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getPreventInputDate()));
        dataPreventViewHelper.setPreventDocSummary(dataPreventInfo.getPreventDocSummary());
        dataPreventViewHelper.setPreventNote(dataPreventInfo.getPreventNote());

        if (EditString.isNull(dataPreventInfo.getPreventFileName()) || EditString.isNull(dataPreventInfo.getPreventFilePath())) {
            dataPreventViewHelper.setPreventFilePath("--");
            dataPreventViewHelper.setPreventFileName(SystemMessageProperties.getSystemProperty("msg_file_not_exist"));
            dataPreventViewHelper.setFilePreventExisted(Boolean.FALSE);
        } else {
            dataPreventViewHelper.setPreventFileName(dataPreventInfo.getPreventFileName());
            dataPreventViewHelper.setPreventFilePath(dataPreventInfo.getPreventFilePath());
            dataPreventViewHelper.setFilePreventExisted(Boolean.TRUE);
        }

        // release
        dataPreventViewHelper.setReleaseFlg(dataPreventInfo.getReleaseFlg());

        dataPreventViewHelper.setReleasePersonInfo(dataPreventInfo.getReleasePersonInfo());
        dataPreventViewHelper.setReleaseInBookNumber(dataPreventInfo.getReleaseInBookNumber());
        dataPreventViewHelper.setReleaseRegistAgency(dataPreventInfo.getReleaseRegistAgency());
        dataPreventViewHelper.setReleaseDocNumber(dataPreventInfo.getReleaseDocNumber());
        dataPreventViewHelper.setReleaseDocDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getReleaseDocDate()));
        dataPreventViewHelper.setReleaseDocReceiveDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getReleaseDocReceiveDate()));
        dataPreventViewHelper.setReleaseInputDate(RelateDateTime.toDayMonthYear(dataPreventInfo.getReleaseInputDate()));
        dataPreventViewHelper.setReleaseDocSummary(dataPreventInfo.getReleaseDocSummary());
        dataPreventViewHelper.setReleaseNote(dataPreventInfo.getReleaseNote());

        if (EditString.isNull(dataPreventInfo.getReleaseFileName()) || EditString.isNull(dataPreventInfo.getReleaseFilePath())) {
            dataPreventViewHelper.setReleaseFilePath("--");
            dataPreventViewHelper.setReleaseFileName(SystemMessageProperties.getSystemProperty("msg_file_not_exist"));
            dataPreventViewHelper.setFileReleaseExisted(Boolean.FALSE);
        } else {
            dataPreventViewHelper.setReleaseFileName(dataPreventInfo.getReleaseFileName());
            dataPreventViewHelper.setReleaseFilePath(dataPreventInfo.getReleaseFilePath());
            dataPreventViewHelper.setFileReleaseExisted(Boolean.TRUE);
        }
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
        dataPreventViewHelper.setPropertyInfo(info);

        request.getSession().setAttribute(DataPreventViewHelper.SESSION_KEY, dataPreventViewHelper);
        return mapping.findForward(SUCCESS_PATH);
    }

    public ActionForward download(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        DataPreventViewHelper helper = (DataPreventViewHelper)request.getSession().getAttribute(DataPreventViewHelper.SESSION_KEY);
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
}
