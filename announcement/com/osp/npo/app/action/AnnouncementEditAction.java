package com.osp.npo.app.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
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

import com.osp.npo.app.form.AnnouncementForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.AnnouncementViewHelper;

import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.FileUtil;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.announcement.AnnouncementInfo;
import com.osp.npo.service.AnnouncementService;

/**
 * <P>
 * Bank Regist Action
 * </P>
 * 
 * @author PhuongNT
 * @version $Revision: 27055 $
 */
public class AnnouncementEditAction extends BaseMDAction {

    private static final String SUCCESS = "success";
    private static final String NO_LOGIN = "nologin";
    private static final String FAILURE_PATH = "failure";
    private static final String ANN_ID = "id";
    public final int COUNT_MESSAGE = 10;
    public static final String UPLOAD_FOLDER_KEY = "system_announcement_folder";
    public static final String ANNOUN_FILE_NAME_PREFIX = "ANNT_";
    public static final Byte IMPORTANCE_LOW = 1;
    public static final Byte IMPORTANCE_HIGH = 2;
    public static final Byte TYPE_ANNOUNCEMENT = 0;
    public static final String POPUP_DIS_DAY = "5";

    /**
     * Action View Detail
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward viewdetail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        createTitle(Constants.SCREEN_ANNT004);

        HttpSession session = request.getSession();
        if (session.getAttribute(AnnouncementViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(AnnouncementViewHelper.SESSION_KEY);
        }

        MessageUtil messageUtil = new MessageUtil();

        AnnouncementViewHelper viewHelper = new AnnouncementViewHelper();

        Long aid = Long.parseLong(request.getParameter(ANN_ID));

        AnnouncementService service = new AnnouncementService(getConnection());

        AnnouncementInfo info = service.queryAnnouncementById(false, aid);

        if (info == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_announcement_name"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        viewHelper.setAid(info.getAid());
        viewHelper.setTitle(info.getTitle());
        viewHelper.setContent(info.getContent());
        viewHelper.setKind(info.getKind().toString());
        viewHelper.setSenderInfo(info.getSenderInfo());
        viewHelper.setSendDateTime(info.getSendDateTime());
        
        if (info.getImportanceType() != null) {
            viewHelper.setImportanceType(info.getImportanceType().toString());
        }
        viewHelper.setAttachFilePath(info.getAttachFilePath());
        viewHelper.setAttachFileName(info.getAttachFileName());

        AnnouncementService annService = new AnnouncementService(getConnection());
        annService.setIdCurentFilter(info.getAid());

        @SuppressWarnings("unchecked")
        List<AnnouncementInfo> lstAnnouncementInfo = annService.queryLateAnnouncement(this.COUNT_MESSAGE).getList();
        viewHelper.setLstAnnouncementInfo(lstAnnouncementInfo);

        session.setAttribute(AnnouncementViewHelper.SESSION_KEY, viewHelper);

        return mapping.findForward(SUCCESS);
    }

    /**
     * <P>
     * Action for first view
     * </P>
     * 
     * @author PhuongNT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        createTitle(Constants.SCREEN_ANNT003);

        HttpSession session = request.getSession();
        if (session.getAttribute(AnnouncementViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(AnnouncementViewHelper.SESSION_KEY);
        }
        MessageUtil messageUtil = new MessageUtil();
        AnnouncementViewHelper viewHelper = new AnnouncementViewHelper();
        Long aid = Long.parseLong(request.getParameter(ANN_ID));
        AnnouncementService service = new AnnouncementService(getConnection());

        AnnouncementInfo info = service.queryAnnouncementById(false, aid);

        if (info == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_announcement_name"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        viewHelper.setAid(info.getAid());
        viewHelper.setTitle(info.getTitle());
        viewHelper.setContent(info.getContent());
        if (info.getImportanceType() != null) {
            viewHelper.setImportanceType(info.getImportanceType().toString());
        }

        if (info.getPopupDisplayFlg()) {
            viewHelper.setPopupDisplayFlg("true");
        }
        if (info.getPopupDisplayDay() != null) {
            viewHelper.setPopupDisplayDay(info.getPopupDisplayDay().toString());
        }

        viewHelper.setAttachFilePath(info.getAttachFilePath());
        viewHelper.setAttachFileName(info.getAttachFileName());

        session.setAttribute(AnnouncementViewHelper.SESSION_KEY, viewHelper);

        return mapping.findForward(SUCCESS);
    }

    /***
     * Action download file Author : PhuongNT
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
    public ActionForward download(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        AnnouncementViewHelper helper = (AnnouncementViewHelper) request.getSession().getAttribute(AnnouncementViewHelper.SESSION_KEY);
        if (helper == null) {
            return mapping.findForward(NO_LOGIN);
        }
        File file = new File(helper.getAttachFilePath());

        if (file.exists() && file.canRead() && file.isFile() && file.length() < Integer.MAX_VALUE) {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + helper.getAttachFileName() + "\"");
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
     * @author PhuongNT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward update(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        AnnouncementViewHelper viewHelper = (AnnouncementViewHelper) request.getSession().getAttribute(AnnouncementViewHelper.SESSION_KEY);
        if (viewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }

        AnnouncementForm annForm = (AnnouncementForm) form;

        MessageUtil messageUtil = new MessageUtil();

        AnnouncementService service = new AnnouncementService(getConnection());

        AnnouncementInfo info = service.queryAnnouncementById(false, viewHelper.getAid());

        viewHelper.reset(annForm);

        if (info == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_announcement_name"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        info.setKind(TYPE_ANNOUNCEMENT);
        info.setTitle(annForm.getTitle());
        info.setContent(annForm.getContent());
        if (info.getSendDateTime() == null) {
            info.setSendDateTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        }
        if ("2".equals(annForm.getImportanceType())) {
            info.setImportanceType(IMPORTANCE_HIGH);
        } else {
            info.setImportanceType(IMPORTANCE_LOW);
        }
        if ("true".equals(annForm.getPopupDisplayFlg())) {
            info.setPopupDisplayFlg(Boolean.TRUE);
        } else {
            info.setPopupDisplayFlg(Boolean.FALSE);
        }
        if (("").equals(annForm.getPopupDisplayDay())) {
            info.setPopupDisplayFlg(Boolean.FALSE);
            info.setPopupDisplayDay(Long.valueOf("0"));
        } else {
            info.setPopupDisplayDay(Long.valueOf(annForm.getPopupDisplayDay()));
        }

        createEntryUserInfo(info);

        service.modifyAnnouncement(info);
        try {
            if (annForm.getFormFile() != null) {
                if (info.getAttachFileName() != null && !info.getAttachFileName().equals("")) {
                    File oldFile = new File(info.getAttachFilePath(), info.getAttachFileName());
                    oldFile.delete();
                }
                String filePath = null;
                File file = FileUtil.createNewFile(SystemProperties.getProperty(UPLOAD_FOLDER_KEY), ANNOUN_FILE_NAME_PREFIX);
                String localName = annForm.getFormFile().getFileName();
                FileOutputStream outputStream = null;
                outputStream = new FileOutputStream(file);
                outputStream.write(annForm.getFormFile().getFileData());
                filePath = file.getAbsolutePath();
                info.setAttachFileName(EditString.convertUnicodeToASCII(localName));
                info.setAttachFilePath(filePath);
                service.modifyAnnouncement(info);
            } else {
                if (viewHelper.getAttachFileName() == null && info.getAttachFileName() != null && !info.getAttachFileName().equals("")) {
                    if (info.getAttachFileName() != null && !info.getAttachFileName().equals("")) {
                        File oldFile = new File(info.getAttachFilePath(), info.getAttachFileName());
                        oldFile.delete();
                    }
                }
            }
        } catch (IOException ioe) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", "err_cannot_upload_file"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        getConnection().commit();
        service = new AnnouncementService(getConnection());
        info = service.queryAnnouncementById(false, viewHelper.getAid());

        if (info == null) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_announcement_name"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }

        viewHelper.setAid(info.getAid());
        viewHelper.setTitle(info.getTitle());
        viewHelper.setContent(info.getContent());
        if (info.getImportanceType() != null) {
            viewHelper.setImportanceType(info.getImportanceType().toString());
        }

        if (info.getPopupDisplayFlg()) {
            viewHelper.setPopupDisplayFlg("true");
        } else {
            viewHelper.setPopupDisplayFlg("false");
        }

        if (info.getPopupDisplayDay() != null) {
            viewHelper.setPopupDisplayDay(info.getPopupDisplayDay().toString());
        } else {
            viewHelper.setPopupDisplayDay(null);
        }

        viewHelper.setAttachFilePath(info.getAttachFilePath());
        viewHelper.setAttachFileName(info.getAttachFileName());
        HttpSession session = request.getSession();
        session.setAttribute(AnnouncementViewHelper.SESSION_KEY, viewHelper);

        ActionMessages messages = new ActionMessages();
        messages.add(messageUtil.createActionMessages("", request, "msg_update_success", "item_announcement_name"));
        this.addMessages(request, messages);

        return mapping.findForward(SUCCESS);
    }

    /**
     * @author PhuongNT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward remove(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        AnnouncementViewHelper helper = (AnnouncementViewHelper) request.getSession().getAttribute(AnnouncementViewHelper.SESSION_KEY);
        if (helper == null) {
            return mapping.findForward(NO_LOGIN);
        }
        try {
            Long aid = helper.getAid();
            AnnouncementService announcementService = new AnnouncementService(getConnection());
            AnnouncementInfo announcementInfo = announcementService.queryAnnouncementById(false, aid);
            if (announcementInfo == null) {
                ActionErrors errors = new ActionErrors();
                errors.add(new MessageUtil().createActionMessages("", request, "err_not_exist", "item_announcement_name"));
                this.addErrors(request, errors);
                return mapping.findForward(FAILURE_PATH);
            } else {
                if (announcementInfo.getAttachFileName() != null && announcementInfo.getAttachFilePath() != null) {
                    File file = new File(announcementInfo.getAttachFilePath());
                    file.delete();
                }
                announcementService.removeAnnouncement(aid);
                getConnection().commit();

                ActionMessages messages = new ActionMessages();
                messages.add(new MessageUtil().createActionMessages("", request, "msg_delete_success", "item_announcement_name"));
                this.addMessages(request, messages);
                return mapping.findForward(SUCCESS);
            }
        } catch (Exception e) {
            ActionErrors errors = new ActionErrors();
            errors.add(new MessageUtil().createActionMessages("", request, "err_not_exist", "item_announcement_name"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE_PATH);
        }
    }

    public ActionForward removefile(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AnnouncementViewHelper viewHelper = (AnnouncementViewHelper) request.getSession().getAttribute(AnnouncementViewHelper.SESSION_KEY);
        if (viewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }
        viewHelper.setAttachFileName(null);
        AnnouncementForm annForm = (AnnouncementForm) form;

        viewHelper.reset(annForm);
        HttpSession session = request.getSession();
        session.setAttribute(AnnouncementViewHelper.SESSION_KEY, viewHelper);

        return mapping.findForward(SUCCESS);
    }

}
