package com.osp.npo.app.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.context.ContractTemplateEditContext;
import com.osp.npo.app.form.ContractTemplateEditForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractTemplateEditViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.FileUtil;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.contract.ContractKindTreeNode;
import com.osp.npo.core.contract.ContractList;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.core.contract.ContractTemplateList;
import com.osp.npo.service.ContractKindService;
import com.osp.npo.service.ContractService;

/**
 * <P>Contract Template List Action</P>
 *
 * @author KienLT
 * @version $Revision: 27048 $
 */
public class ContractTemplateEditAction extends BaseMDAction {
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    private static final String CONTRACT_FILE_NAME_PREFIX = "CNTR_";

    public static final String UPLOAD_FOLDER_KEY = "system_template_contract_folder";
    
    /**
     * <P>Action for first view</P>
     * 
     * @author KienLT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */    
    public ActionForward view(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        createTitle(Constants.SCREEN_ADM012);       
        
        
        HttpSession session = request.getSession();
        //delete session
        if (session.getAttribute(ContractTemplateEditViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(ContractTemplateEditViewHelper.SESSION_KEY);
        }        
        
        ContractTemplateEditContext context = (ContractTemplateEditContext)
            session.getAttribute(ContractTemplateEditContext.SESSION_KEY);
                
        ContractTemplateEditViewHelper view = new ContractTemplateEditViewHelper();        
        
        //Set default value for first view
        Long contractTemplateId = context.getId();
        ContractService service = new ContractService(getConnection());
        service.setContractTemplateId(contractTemplateId);
        ContractTemplateList contractTemplateList = service.queryAllContractTemplate(false);
        if (contractTemplateList.size() == 0) {
            ActionErrors errors = new ActionErrors();
            errors.add(new MessageUtil().createActionMessages("", request, "err_not_exist", "item_contract_template"));
            saveErrors(request, errors);
            return mapping.findForward(FAILURE);
        }        
        ContractTemplateInfo contractTemplateInfo = contractTemplateList.get(0);
        
        ContractKindService contractKindService = new ContractKindService(getConnection());
        List<ContractKindTreeNode> list = contractKindService.getContractKindTree(false, null);        
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setName(getSpaces(list.get(i).getLevel()) + list.get(i).getName());
        }
        
        view.setContractTemplateName(contractTemplateInfo.getName());
        view.setContractKindTreeNodeList(list);        
        view.setContractTemplateDescription(contractTemplateInfo.getDescription());        
        view.setFileName(contractTemplateInfo.getFileName());        
        view.setActiveFlg(contractTemplateInfo.getActiveFlg());        
        view.setUpdateUserName(contractTemplateInfo.getUpdateUserName());
        view.setUpdateDateTime(contractTemplateInfo.getUpdateDateTime());
        view.setContractKindId(contractTemplateInfo.getKindId());
        view.setContractTemplateCode(contractTemplateInfo.getCode());
        view.setRelateObjectNumber(contractTemplateInfo.getRelateObjectNumber());
        view.setRelateObjectATitle(contractTemplateInfo.getRelateObjectATitle());
        view.setRelateObjectBTitle(contractTemplateInfo.getRelateObjectBTitle());
        view.setRelateObjectCTitle(contractTemplateInfo.getRelateObjectCTitle());
        view.setMortageCancelFunc(contractTemplateInfo.getMortageCancelFunc());
        view.setPeriodFlag(contractTemplateInfo.getPeriodFlag());
        
        session.setAttribute(ContractTemplateEditViewHelper.SESSION_KEY, view);
           
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Save Action</P>
     *     
     * @author KienLT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward save(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        HttpSession session = request.getSession();
        
        MessageUtil messageUtil = new MessageUtil();
        ContractTemplateEditForm f = (ContractTemplateEditForm) form;        
        ContractService service = new ContractService(getConnection());
        ContractTemplateEditContext context = (ContractTemplateEditContext)
            session.getAttribute(ContractTemplateEditContext.SESSION_KEY);
        
        if(f.getContractKindId()==0) {
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("contractKind", request, "err_not_input_data", "item_contract_kind"));
            saveErrors(request, errors);
            return mapping.findForward(FAILURE);
        }        
        
        Long contractTemplateId = context.getId();
        service.setContractTemplateId(contractTemplateId);
        ContractTemplateList contractTemplateList = service.queryAllContractTemplate(false);
        if (contractTemplateList.size() == 0) {
            ActionErrors errors = new ActionErrors();
            errors.add(new MessageUtil().createActionMessages("", request, "err_not_exist", "item_contract_template"));
            saveErrors(request, errors);
            return mapping.findForward(FAILURE);
        }        
        ContractTemplateInfo contractTemplateInfo = contractTemplateList.get(0);
        
        // Save info
        contractTemplateInfo.setName(f.getContractTemplateName());
        contractTemplateInfo.setKindId(f.getContractKindId());
        contractTemplateInfo.setDescription(f.getContractTemplateDescription());               
        contractTemplateInfo.setActiveFlg(f.getActiveFlg());
        contractTemplateInfo.setCode(f.getContractTemplateCode());
        contractTemplateInfo.setRelateObjectNumber(f.getRelateObjectNumber());
        if (f.getRelateObjectATitle()!=null && !"".equals(f.getRelateObjectATitle()) && !f.getRelateObjectATitle().equals(SystemMessageProperties.getSystemProperty("item_relation_object"))){
        	contractTemplateInfo.setRelateObjectATitle(f.getRelateObjectATitle());
        } else contractTemplateInfo.setRelateObjectATitle(SystemMessageProperties.getSystemProperty("item_relation_objectA"));
        if (f.getRelateObjectBTitle()!=null && !"".equals(f.getRelateObjectBTitle()) && !f.getRelateObjectBTitle().equals(SystemMessageProperties.getSystemProperty("item_relation_object"))){
        	contractTemplateInfo.setRelateObjectBTitle(f.getRelateObjectBTitle());
        } else contractTemplateInfo.setRelateObjectBTitle(SystemMessageProperties.getSystemProperty("item_relation_objectB"));
        if (f.getRelateObjectCTitle()!=null && !"".equals(f.getRelateObjectCTitle()) && !f.getRelateObjectCTitle().equals(SystemMessageProperties.getSystemProperty("item_relation_object"))){
        	contractTemplateInfo.setRelateObjectCTitle(f.getRelateObjectCTitle());
        } else contractTemplateInfo.setRelateObjectCTitle(SystemMessageProperties.getSystemProperty("item_relation_objectC"));
    
        if (f.getMortageCancelFunc()!=null)
        	contractTemplateInfo.setMortageCancelFunc(f.getMortageCancelFunc());
        else contractTemplateInfo.setMortageCancelFunc(Boolean.FALSE);
        if (f.getPeriodFlag()!=null)
        contractTemplateInfo.setPeriodFlag(f.getPeriodFlag());
        else contractTemplateInfo.setPeriodFlag(Boolean.FALSE);
        createUpdateUserInfo(contractTemplateInfo);
        ContractTemplateEditViewHelper view = (ContractTemplateEditViewHelper)request.getSession()
        	.getAttribute(ContractTemplateEditViewHelper.SESSION_KEY);
        view.reset(f);               
        try {
            //Upload file
            if (f.getFormFile() != null) {
                // Del old file 
                if (contractTemplateInfo.getFileName() != null && !contractTemplateInfo.getFileName().equals("")) {
                    File oldFile = new File(contractTemplateInfo.getFilePath(), contractTemplateInfo.getFileName());
                    oldFile.delete();
                }
                String filePath = null;
                File file = FileUtil.createNewFile(SystemProperties.getProperty(UPLOAD_FOLDER_KEY), CONTRACT_FILE_NAME_PREFIX);
                String localName = f.getFormFile().getFileName();
                FileOutputStream outputStream = null;
                outputStream = new FileOutputStream(file);
                outputStream.write(f.getFormFile().getFileData());
                filePath = file.getAbsolutePath();               
                contractTemplateInfo.setFileName(EditString.convertUnicodeToASCII(localName));
                contractTemplateInfo.setFilePath(filePath);
                view.setFileName(localName);                
            }
        } catch (IOException ioe) {
            //Message Failure
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", "err_cannot_upload_file"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE);
        }       
        try {  
            service.modifyContractTemplate(contractTemplateInfo);
        } catch (Exception ioe) {
            //Message Failure
              ActionErrors errors = new ActionErrors();
              errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract_kind"));
              this.addErrors(request, errors);
              return mapping.findForward(FAILURE);
          }
        getConnection().commit();
        view.setUpdateUserName(contractTemplateInfo.getUpdateUserName());
        view.setUpdateDateTime(contractTemplateInfo.getUpdateDateTime());
        
        //Message Success
        ActionMessages messages = new ActionMessages();
        messages.add(messageUtil.createActionMessages("", request, "msg_update_success", "item_contract_template"));
        this.addMessages(request, messages);
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * Del Action
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward del(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        MessageUtil messageUtil = new MessageUtil();
        ContractTemplateEditContext context = (ContractTemplateEditContext)
            request.getSession().getAttribute(ContractTemplateEditContext.SESSION_KEY);
        
        ContractService service = new ContractService(getConnection());
        service.setContractTemplateId(context.getId());
        ContractTemplateList contractTemplateList = service.queryAllContractTemplate(false);
        if (contractTemplateList.size() <= 0) {
            // Can not del
            //Message Failure
            ActionErrors error = new ActionErrors();
            error.add(messageUtil.createActionMessages("", request, "msg_delete_success", "item_contract_template"));
            this.addMessages(request, error);
            return mapping.findForward(FAILURE);
        }
        service.setContractTemplateIdFilter(context.getId());
        ContractList contractList = service.queryAllContract(false);
        if(contractList.size()>0)
        {
            ActionErrors error = new ActionErrors();
            error.add(messageUtil.createActionMessages("", "ADM012_exist_relation_contract"));
            this.addErrors(request, error);
            return mapping.findForward(FAILURE);
        }
        ContractTemplateInfo contractTemplateInfo = contractTemplateList.get(0);
        
        if (contractTemplateInfo != null && contractTemplateInfo.getFileName() != null) {
            File oldFile = new File(contractTemplateInfo.getFilePath() , contractTemplateInfo.getFileName());
            oldFile.delete();
        }
        
        service.removeContractTemplate(context.getId());
        getConnection().commit();
        
        //Message Success
        ActionMessages messages = new ActionMessages();
        messages.add(messageUtil.createActionMessages("", request, "msg_delete_success", "item_contract_template"));
        this.addMessages(request, messages);
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * Remove File Action
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward removeFile(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        ContractTemplateEditViewHelper view = (ContractTemplateEditViewHelper)
            request.getSession().getAttribute(ContractTemplateEditViewHelper.SESSION_KEY);
        
        view.setFileName(null);
        
        request.getSession().setAttribute(ContractTemplateEditViewHelper.SESSION_KEY, view);
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * Download Action
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward download(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, Exception {
        
        ContractTemplateEditContext context = (ContractTemplateEditContext)
            request.getSession().getAttribute(ContractTemplateEditContext.SESSION_KEY);
        
        Long id = context.getId();
        
        ContractService service = new ContractService(getConnection());   
        service.setContractTemplateId(id);
        ContractTemplateList contractTemplateList = service.queryContractTemplate(false, 0, 1);        
        
        if (contractTemplateList != null && contractTemplateList.size() > 0) {
            ContractTemplateInfo info = contractTemplateList.get(0);
            if (info != null && info.getFilePath() != null) {
                File file = new File(info.getFilePath());
    
                if (file != null && file.exists() && file.canRead() && file.isFile() && file.length() < Integer.MAX_VALUE) {
                    response.setContentType("application/octet-stream");
                    response.setHeader("Content-Disposition",
                            "attachment; filename=\"" + info.getFileName() + "\"");
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
                } 
            } else {
                ActionErrors errors = new ActionErrors();
                MessageUtil messageUtil = new MessageUtil();
                errors.add(messageUtil.createActionMessages("", "err_file_not_found"));
                this.addErrors(request, errors);
            }            
        } else {
            ActionErrors errors = new ActionErrors();
            MessageUtil messageUtil = new MessageUtil();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract_template"));
            this.addErrors(request, errors);
        }
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * Get space
     * 
     * @param i
     * @return
     */
    private String getSpaces(int num) {
        String spaces = ".";
        for (int i = 0; i < num; i++) {
            spaces += "  ";
        }
        return spaces;
    }
}
