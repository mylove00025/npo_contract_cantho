package com.osp.npo.app.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.form.ContractTemplateRegistForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractTemplateRegistViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.FileUtil;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.contract.ContractKindTreeNode;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.service.ContractKindService;
import com.osp.npo.service.ContractService;

/**
 * <P>Contract Template List Action</P>
 *
 * @author KienLT
 * @version $Revision: 27048 $
 */
public class ContractTemplateRegistAction extends BaseMDAction {
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    public static final String UPLOAD_FOLDER_KEY = "system_template_contract_folder";
    public static final String CONTRACT_FILE_NAME_PREFIX = "CNTR_";
    
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
        
        createTitle(Constants.SCREEN_ADM011);       
        
        HttpSession session = request.getSession();
        //delete session
        if (session.getAttribute(ContractTemplateRegistViewHelper.SESSION_KEY) != null) {
            session.removeAttribute(ContractTemplateRegistViewHelper.SESSION_KEY);
        }        
        
        ContractTemplateRegistViewHelper view = new ContractTemplateRegistViewHelper();
        
        //Set default value for first view
        ContractKindService contractKindService = new ContractKindService(getConnection());
        List<ContractKindTreeNode> list = contractKindService.getContractKindTree(false, null);        
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setName(getSpaces(list.get(i).getLevel()) + list.get(i).getName());
        }
        
        view.setContractKindTreeNodeList(list);
        view.setRelateObjectNumber(2);
        
        session.setAttribute(ContractTemplateRegistViewHelper.SESSION_KEY, view);
           
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

        MessageUtil messageUtil = new MessageUtil();
        ContractTemplateRegistForm f = (ContractTemplateRegistForm) form;
        
        ContractService service = new ContractService(getConnection());
        //Save info
        ContractTemplateRegistViewHelper view = (ContractTemplateRegistViewHelper)
        request.getSession().getAttribute(ContractTemplateRegistViewHelper.SESSION_KEY);
        view.reset(f);        
        ContractTemplateInfo info = new ContractTemplateInfo();
        try {            
            info.setName(f.getContractTemplateName());            
            info.setKindId(f.getContractKindId());
            info.setDescription(f.getContractTemplateDescription());
            info.setActiveFlg(true);
            info.setCode(f.getContractTemplateCode());
            info.setRelateObjectNumber(f.getRelateObjectNumber());
            if (f.getRelateObjectATitle()!=null && !"".equals(f.getRelateObjectATitle()) && !f.getRelateObjectATitle().equals(SystemMessageProperties.getSystemProperty("item_relation_object"))){
            		info.setRelateObjectATitle(f.getRelateObjectATitle());
            } else info.setRelateObjectATitle(SystemMessageProperties.getSystemProperty("item_relation_objectA"));
            if (f.getRelateObjectBTitle()!=null && !"".equals(f.getRelateObjectBTitle()) && !f.getRelateObjectBTitle().equals(SystemMessageProperties.getSystemProperty("item_relation_object"))){
        		info.setRelateObjectBTitle(f.getRelateObjectBTitle());
            } else info.setRelateObjectBTitle(SystemMessageProperties.getSystemProperty("item_relation_objectB"));
            if (f.getRelateObjectCTitle()!=null && !"".equals(f.getRelateObjectCTitle()) && !f.getRelateObjectCTitle().equals(SystemMessageProperties.getSystemProperty("item_relation_object"))){
        		info.setRelateObjectCTitle(f.getRelateObjectCTitle());
            } else info.setRelateObjectCTitle(SystemMessageProperties.getSystemProperty("item_relation_objectC"));
            
            info.setMortageCancelFunc(f.getMortageCancelFunc());
            info.setPeriodFlag(f.getPeriodFlag());
            createEntryUserInfo(info);
        
            service.entryContractTemplate(info);
        } catch (Exception ioe) {
          //Message Failure
            ActionErrors errors = new ActionErrors();
            errors.add(messageUtil.createActionMessages("", request, "err_not_exist", "item_contract_kind"));
            this.addErrors(request, errors);
            return mapping.findForward(FAILURE);
        }
        if(f.getFormFile()!=null && (!EditString.isNull(f.getFormFile().getFileName()))) {
            try {
                String filePath = null;
                File file = FileUtil.createNewFile(SystemProperties.getProperty(UPLOAD_FOLDER_KEY), CONTRACT_FILE_NAME_PREFIX);
                String localName = f.getFormFile().getFileName();
                FileOutputStream outputStream = null;
                outputStream = new FileOutputStream(file);
                outputStream.write(f.getFormFile().getFileData());
                filePath = file.getAbsolutePath();
                info.setFileName(EditString.convertUnicodeToASCII(localName));
                info.setFilePath(filePath);
                service.modifyContractTemplate(info);
            } catch (IOException ioe) {
                //Message Failure
                ActionErrors errors = new ActionErrors();
                errors.add(messageUtil.createActionMessages("", "err_cannot_upload_file"));
                this.addErrors(request, errors);
                return mapping.findForward(FAILURE);
            }
        }
        getConnection().commit();
        
        //Message Success
        ActionMessages messages = new ActionMessages();
        messages.add(messageUtil.createActionMessages("", request, "msg_regist_success", "item_contract_template"));
        this.addMessages(request, messages);
        
        //reset form
        view.setContractTemplateName("");
        view.setContractTemplateCode("");
        view.setRelateObjectNumber(2);
        view.setContractTemplateDescription("");
        
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
