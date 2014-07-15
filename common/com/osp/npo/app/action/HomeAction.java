package com.osp.npo.app.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.HomeViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.core.announcement.AnnouncementInfo;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.contract.ContractKindTreeNode;
import com.osp.npo.core.contract.ContractKindTreeNode.DivStyle;
import com.osp.npo.core.contract.ContractStatisticalInfo;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.service.AnnouncementService;
import com.osp.npo.service.ContractKindService;
import com.osp.npo.service.ContractService;

/**
 *
 * Home view
 *
 * @author GiangVT
 * @version $Revision: 20523 $
 */
public class HomeAction extends BaseMDAction {
    public static final String SUCCESS_PATH = "success";
    private static final String NO_LOGIN = "nologin";  
    private static final String FAILURE_PATH = "failure";
    public static final String CONTRACT_TEMPLATE_ID = "template_id";
    public static final String DOWNLOAD_FAILURE = "downloadFailure";
    public final int COUNT_MESSAGE = 5;

    public ActionForward view(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        createTitle(Constants.SCREEN_COM003);

        request.getSession().removeAttribute(HomeViewHelper.SESSION_KEY);
        HomeViewHelper view = new HomeViewHelper();

        ContractService contractService = new ContractService(getConnection());

        // and get all statistic
        @SuppressWarnings("unchecked")
        List<ContractStatisticalInfo> lstContractStatisticalInfo = contractService.queryAllContractStatistical(false).getList();
        @SuppressWarnings("unchecked")
        List<ContractStatisticalInfo> lstContractStatisticalForDrafterInfo = contractService.queryAllContractStatisticalForDrafter(false).getList();
        
        AnnouncementService annService =    new AnnouncementService(getConnection());
        
        AnnouncementInfo annInfo = annService.queryPopupAnnouncement();
        
        if (annInfo != null) {
        	view.setIsShowPopup("true");
        	view.setAnnouncementInfo(annInfo);
        }        
               
		@SuppressWarnings("unchecked")
		List<AnnouncementInfo> lstAnnouncementInfo = annService.queryLatestAnnouncement(this.COUNT_MESSAGE).getList();
		
			
        view.setLstAnnouncementInfo(lstAnnouncementInfo);
        
        @SuppressWarnings("unchecked")
		List<ContractKindInfo> lstContractKindInfo = contractService.queryAllContractKind(false).getList();
        view.setLstContractKind(lstContractKindInfo);
        
        // set to context
        view.setLstContractStatisticalInfo(lstContractStatisticalInfo);
        view.setLstContractStatisticalForDrafterInfo(lstContractStatisticalForDrafterInfo);
        Long countTotalInDay = 0l;
        Long countTotalInWeek = 0l;
        Long countTotalInMonth = 0l;
        Long countTotalInYear = 0l;
        Long countTotalAllTime = 0l;

        for (int i = 0; i < lstContractStatisticalInfo.size(); i++) {
            ContractStatisticalInfo info = lstContractStatisticalInfo.get(i);
            countTotalInDay += info.getCountInDay();
            countTotalInWeek += info.getCountInWeek();
            countTotalInMonth += info.getCountInMonth();
            countTotalInYear += info.getCountInYear();
            countTotalAllTime += info.getCountTotal();
        }
        view.setCountTotalInDay(countTotalInDay);
        view.setCountTotalInWeek(countTotalInWeek);
        view.setCountTotalInMonth(countTotalInMonth);
        view.setCountTotalInYear(countTotalInYear);
        view.setCountTotalAllTime(countTotalAllTime);
        
        // get root contract kind
        ContractKindService contractKindService = new ContractKindService(getConnection());
        List<ContractKindTreeNode> lstTmpContractKindTreeNode = contractKindService.getContractKindTree(false, null);
        List<ContractKindTreeNode> lstContractKindTreeNode = new ArrayList<ContractKindTreeNode>();

        // parse tree with div style
        if (lstTmpContractKindTreeNode.size() > 0) {
            lstContractKindTreeNode.add(lstTmpContractKindTreeNode.get(0));
            // if tree has more than 1 node
            for (int i = 1; i < lstTmpContractKindTreeNode.size(); i++) {
                if (lstTmpContractKindTreeNode.get(i).getLevel() < lstTmpContractKindTreeNode.get(i - 1).getLevel()) {
                    // up level, div style is close style
                    int distanceLevel = lstTmpContractKindTreeNode.get(i - 1).getLevel() - lstTmpContractKindTreeNode.get(i).getLevel();
                    for (int k = 0; k < distanceLevel; k++) {
                        ContractKindTreeNode tmpNode = new ContractKindTreeNode();
                        tmpNode.setDivStyle(DivStyle.DIV_CLOSE.getValue());
                        lstContractKindTreeNode.add(tmpNode);
                    }
                    // using level -1 to catch node hasn't child
                    lstTmpContractKindTreeNode.get(i - 1).setLevel(-1);
                } else if (lstTmpContractKindTreeNode.get(i).getLevel() > lstTmpContractKindTreeNode.get(i - 1).getLevel()) {
                    // down level, level distance must be 1, so div style is open style
                    ContractKindTreeNode tmpNode = new ContractKindTreeNode();
                    tmpNode.setDivStyle(DivStyle.DIV_OPEN.getValue());
                    tmpNode.setId(lstTmpContractKindTreeNode.get(i - 1).getId());
                    lstContractKindTreeNode.add(tmpNode);
                } else {
                    // using level -1 to catch node hasn't child
                    lstTmpContractKindTreeNode.get(i - 1).setLevel(-1);
                }
                // add this node
                ContractKindTreeNode treeNode = lstTmpContractKindTreeNode.get(i);
                treeNode.setDivStyle(DivStyle.NODE.getValue());
                lstContractKindTreeNode.add(treeNode);
            }
            // check level for last child
            int level = lstTmpContractKindTreeNode.get(lstTmpContractKindTreeNode.size() - 1).getLevel();
            lstContractKindTreeNode.get(lstContractKindTreeNode.size() - 1).setLevel(-1);
            for (int i = 0; i < level; i++) {
                ContractKindTreeNode tmpNode = new ContractKindTreeNode();
                tmpNode.setDivStyle(DivStyle.DIV_CLOSE.getValue());
                lstContractKindTreeNode.add(tmpNode);
            }
        }

        view.setLstContractKindTreeNode(lstContractKindTreeNode);

        request.getSession().setAttribute(HomeViewHelper.SESSION_KEY, view);
        return mapping.findForward(SUCCESS_PATH);
    }

    @SuppressWarnings("unchecked")
    public ActionForward downloadTemplate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
        String html = "1";
        Long contractTemplateId = Long.parseLong(request.getParameter(CONTRACT_TEMPLATE_ID));
        ContractService service = new ContractService(getConnection());
        service.setContractTemplateId(contractTemplateId);
        List<ContractTemplateInfo> lstInfo = service.queryContractTemplate(false, -1, -1).getList();
        if (lstInfo.size() == 1) {
            ContractTemplateInfo info = lstInfo.get(0);
            if (info.getFilePath() != null) {
                File file = new File(info.getFilePath());

                if (file.exists() && file.canRead() && file.isFile() && file.length() < Integer.MAX_VALUE) {
                    response.setContentType("application/octet-stream");
                    response.setHeader("Content-Disposition", "attachment; filename=\"" + info.getFileName() + "\"");
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
                } else {
                    // return 1 if can
                    response.setContentType("text/html; charset=utf-8");
                    PrintWriter out = response.getWriter();
                    out.println(html);
                    out.flush();
                }
            } else {
                // return 2 if can
                response.setContentType("text/html; charset=utf-8");
                PrintWriter out = response.getWriter();
                out.println(html);
                out.flush();
            }
        } else {
            // return 3 if can
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.println(html);
            out.flush();
        }
        return null;
    }
    
    public ActionForward downloadAnnouncementFile(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, Exception {
    	HomeViewHelper helper = (HomeViewHelper)request.getSession().getAttribute(HomeViewHelper.SESSION_KEY);
    	if (helper == null) {
            return mapping.findForward(NO_LOGIN);
        }
        File file = new File(helper.getAnnouncementInfo().getAttachFilePath());

        if (file.exists() && file.canRead() && file.isFile() && file.length() < Integer.MAX_VALUE) {
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition",
                    "attachment; filename=\"" + helper.getAnnouncementInfo().getAttachFileName() + "\"");
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
