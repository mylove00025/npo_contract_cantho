package com.osp.npo.app.action;

import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.lucene.index.IndexWriter;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.form.SystemConfigForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.plugin.InitSystemPlugin;
import com.osp.npo.common.global.Constants;
import com.osp.npo.core.common.SystemConfigInfo;
import com.osp.npo.core.contract.ContractList;
import com.osp.npo.core.prevent.DataPreventList;
import com.osp.npo.core.prevent.TransactionPropertyList;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.service.CommonService;
import com.osp.npo.service.ContractNumberService;
import com.osp.npo.service.ContractService;
import com.osp.npo.service.LuceneContractService;
import com.osp.npo.service.LuceneIndexService;
import com.osp.npo.service.LucenePreventService;
import com.osp.npo.service.LuceneTransactionPropertyService;
import com.osp.npo.service.PreventService;
import com.osp.npo.service.SynchronizeService;
import com.osp.npo.ws.NpoWS;
import com.osp.npo.ws.NpoWSServiceLocator;
import com.osp.npo.ws.WebserviceInfo;

public class SystemConfigAction extends BaseMDAction {

	private static final String SUCCESS = "success";

    /**
     * <P>Action for first view</P>
     *
     * @author KienLT
     * @author GiangVT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward view(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        createTitle(Constants.SCREEN_ADM018);
        SystemConfigForm sysForm = (SystemConfigForm)form;
        CommonService commonService = new CommonService(getConnection());

        SystemConfigInfo info;
        info = commonService.querySystemConfigByKey("notary_office_name", false);
        if (info != null) {
            sysForm.setNotaryOfficeName(info.getConfigValue());
        } else {
            sysForm.setNotaryOfficeName("");
        }

        info = commonService.querySystemConfigByKey("notary_office_address", false);
        if (info != null) {
            sysForm.setNotaryOfficeAddress(info.getConfigValue());
        } else {
            sysForm.setNotaryOfficeAddress("");
        }

        info = commonService.querySystemConfigByKey("record_per_page", false);
        if (info != null) {
            sysForm.setRecordPerPage(info.getConfigValue());
        } else {
            sysForm.setRecordPerPage("");
        }

        info = commonService.querySystemConfigByKey("synchronize_webservice_url", false);
        if (info != null) {
            sysForm.setSynchronizeWebserviceUrl(info.getConfigValue());
        } else {
            sysForm.setSynchronizeWebserviceUrl("");
        }

        info = commonService.querySystemConfigByKey("synchronize_period", false);
        if (info != null) {
            sysForm.setSynchronizePeriod(info.getConfigValue());
        } else {
            sysForm.setSynchronizePeriod("");
        }

        info = commonService.querySystemConfigByKey("synchronize_record", false);
        if (info != null) {
            sysForm.setSynchronizeRecord(info.getConfigValue());
        } else {
            sysForm.setSynchronizeRecord("");
        }

        info = commonService.querySystemConfigByKey("synchronize_account", false);
        if (info != null) {
            sysForm.setSynchronizeAccount(info.getConfigValue());
        } else {
            sysForm.setSynchronizeAccount("");
        }

        info = commonService.querySystemConfigByKey("synchronize_password", false);
        if (info != null) {
            sysForm.setSynchronizePassword(info.getConfigValue());
        } else {
            sysForm.setSynchronizePassword("");
        }

        return mapping.findForward(SUCCESS);
    }

    /**
     * <P>Action for first view</P>
     *
     * @author KienLT
     * @author GiangVT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        SystemConfigForm sysForm = (SystemConfigForm)form;
        CommonService commonService = new CommonService(getConnection());

        SystemConfigInfo info;
        CommonContext context = (CommonContext)request.getSession().getAttribute(CommonContext.SESSION_KEY);

        info = commonService.querySystemConfigByKey("notary_office_name", false);
        if (info != null) {
            info.setConfigValue(sysForm.getNotaryOfficeName());
            commonService.modifySystemConfig(info);
        } else {
            info = new SystemConfigInfo();
            info.setConfigKey("notary_office_name");
            info.setConfigValue(sysForm.getNotaryOfficeName());
            commonService.entrySystemConfig(info);
        }

        info = commonService.querySystemConfigByKey("notary_office_address", false);
        if (info != null) {
            info.setConfigValue(sysForm.getNotaryOfficeAddress());
            commonService.modifySystemConfig(info);
        } else {
            info = new SystemConfigInfo();
            info.setConfigKey("notary_office_address");
            info.setConfigValue(sysForm.getNotaryOfficeAddress());
            commonService.entrySystemConfig(info);
        }

        info = commonService.querySystemConfigByKey("record_per_page", false);
        if (info != null) {
            info.setConfigValue(sysForm.getRecordPerPage());
            commonService.modifySystemConfig(info);
        } else {
            info = new SystemConfigInfo();
            info.setConfigKey("record_per_page");
            info.setConfigValue(sysForm.getRecordPerPage());
            commonService.modifySystemConfig(info);
        }

        info = commonService.querySystemConfigByKey("synchronize_webservice_url", false);
        if (info != null) {
            info.setConfigValue(sysForm.getSynchronizeWebserviceUrl());
            commonService.modifySystemConfig(info);
        } else {
            info = new SystemConfigInfo();
            info.setConfigKey("synchronize_webservice_url");
            info.setConfigValue(sysForm.getSynchronizeWebserviceUrl());
            commonService.entrySystemConfig(info);
        }

        info = commonService.querySystemConfigByKey("synchronize_period", false);
        if (info != null) {
            info.setConfigValue(sysForm.getSynchronizePeriod());
            commonService.modifySystemConfig(info);
        } else {
            info = new SystemConfigInfo();
            info.setConfigKey("synchronize_period");
            info.setConfigValue(sysForm.getSynchronizePeriod());
            commonService.entrySystemConfig(info);
        }

        info = commonService.querySystemConfigByKey("synchronize_record", false);
        if (info != null) {
            info.setConfigValue(sysForm.getSynchronizeRecord());
            commonService.modifySystemConfig(info);
        } else {
            info = new SystemConfigInfo();
            info.setConfigKey("synchronize_record");
            info.setConfigValue(sysForm.getSynchronizeRecord());
            commonService.entrySystemConfig(info);
        }

        info = commonService.querySystemConfigByKey("synchronize_account", false);
        if (info != null) {
            info.setConfigValue(sysForm.getSynchronizeAccount());
            commonService.modifySystemConfig(info);
        } else {
            info = new SystemConfigInfo();
            info.setConfigKey("synchronize_account");
            info.setConfigValue(sysForm.getSynchronizeAccount());
            commonService.entrySystemConfig(info);
        }

        info = commonService.querySystemConfigByKey("synchronize_password", false);
        if (info != null) {
            info.setConfigValue(sysForm.getSynchronizePassword());
            commonService.modifySystemConfig(info);
        } else {
            info = new SystemConfigInfo();
            info.setConfigKey("synchronize_password");
            info.setConfigValue(sysForm.getSynchronizePassword());
            commonService.entrySystemConfig(info);
        }

        getConnection().commit();
        request.getSession().setAttribute(CommonContext.SESSION_KEY, context);
        ActionMessages messages = new ActionMessages();
        messages.add((new MessageUtil()).createActionMessages("msg_system_config_success"));
        this.addMessages(request, messages);
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action for synchronize all data</P>
     *
     * @author HungPT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward synchronizeAll(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
        
        CommonService commonService = new CommonService(getConnection());
        
        SynchronizeService synchronizeService = new SynchronizeService(getConnection());
        synchronizeService.removeAllSynchronize();
        synchronizeService.entryAllSyncPreventData(InitSystemPlugin.getAuthenticationId());
        synchronizeService.entryAllSyncTransProperty(InitSystemPlugin.getAuthenticationId());
        
        getConnection().commit();
        
        //Call web service synchronize database
        NpoWSServiceLocator service = new NpoWSServiceLocator();
        String synchronizeUrl = commonService.querySystemConfigByKey("synchronize_webservice_url", Boolean.FALSE).getConfigValue();
        NpoWS port = service.getNpoWSPort(new URL(synchronizeUrl));
        
        WebserviceInfo webserviceInfo = new WebserviceInfo();
        webserviceInfo.setAuthenticationId(InitSystemPlugin.getAuthenticationId());
        webserviceInfo.setAuthenticationCode(InitSystemPlugin.getAuthenticationCode());
        webserviceInfo.setAccount(commonService.querySystemConfigByKey("synchronize_account", Boolean.FALSE).getConfigValue());
        webserviceInfo.setPassword(commonService.querySystemConfigByKey("synchronize_password", Boolean.FALSE).getConfigValue());
        
        Boolean result = Boolean.FALSE;
        
        try {
            if (port != null) {
                result = port.synchronizeFirstTime(webserviceInfo);
            }
        } catch (IOException e) {
            NpoLogMessage logMessage = new NpoLogMessage();
            logMessage.setMsgId("WEB9001");
            logger.logging(logMessage, e);
        }
        
        if (result) {
            ActionMessages messages = new ActionMessages();
            messages.add((new MessageUtil()).createActionMessages("msg_synchronize_all_success"));
            this.addMessages(request, messages);
        } else {
            ActionErrors errors = new ActionErrors();
            errors.add((new MessageUtil()).createActionMessages("msg_synchronize_all_fail"));
            this.addErrors(request, errors);
        }
        
        return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action for create index</P>
     *
     * @author HungPT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward createIndex(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
    	
    	//For contract
    	LuceneContractService lcService = new LuceneContractService();
    	lcService.createIndexFile();
    	
    	IndexWriter contractWriter = lcService.openWriter();
    	
    	ContractService contractService = new ContractService(getConnection());
    	ContractList contractlist = contractService.queryAllContract(false);
    	if (contractlist.size() > 0) {
    		for (int i = 0; i < contractlist.size(); i++) {
    			lcService.entryContractDocument(contractWriter, contractlist.get(i));
    		}
    	}
    	
    	contractWriter.optimize();
    	contractWriter.close();
    	
    	
    	//For data prevent
    	LucenePreventService lpService = new LucenePreventService();
    	lpService.createIndexFile();
    	
    	IndexWriter preventWriter = lpService.openWriter();
    	
    	PreventService preventService = new PreventService(getConnection());
    	DataPreventList dplist = preventService.queryAllDataPrevent(false);
    	if (dplist.size() > 0) {
    		for (int i = 0; i < dplist.size(); i++) {
    			if (!dplist.get(i).getDeleteFlg()) {
    				lpService.entryDataPreventDocument(preventWriter, dplist.get(i));
    			}
    		}
    	}
    	
    	preventWriter.optimize();
    	preventWriter.close();
    	
    	//For transaction property
    	LuceneTransactionPropertyService ltpService = new LuceneTransactionPropertyService();
    	ltpService.createIndexFile();
    	
    	IndexWriter tpWriter = ltpService.openWriter();
    	int totalcount = preventService.countTotalTransactionProperty();
    	TransactionPropertyList tplist = preventService.queryTransactionProperty(false,1,totalcount+1);
    	if (tplist.size() > 0) {
    		for (int i = 0; i < tplist.size(); i++) {
    			ltpService.entryTransactionPropertyDocument(tpWriter, tplist.get(i));
    			
    		}
    	}
    	
    	tpWriter.optimize();
    	tpWriter.close();
    	
    	ActionMessages messages = new ActionMessages();
        messages.add((new MessageUtil()).createActionMessages("msg_create_index_success"));
        this.addMessages(request, messages);
        
    	return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action for create index</P>
     *
     * @author HungPT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward createIndex2(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
    	
    	LuceneIndexService liService = new LuceneIndexService(getConnection());
    	liService.removeAllLuceneIndex();
    	
    	//For contract
    	LuceneContractService lcService = new LuceneContractService();
    	lcService.createIndexFile();
    	
    	//For data prevent
    	LucenePreventService lpService = new LucenePreventService();
    	lpService.createIndexFile();
    	
    	//For transaction property
    	LuceneTransactionPropertyService ltpService = new LuceneTransactionPropertyService();
    	ltpService.createIndexFile();
    	
    	liService.entryLuceneIndexFromContract();
    	liService.entryLuceneIndexFromPreventData();
    	liService.entryLuceneIndexFromTransaction();
    	
    	getConnection().commit();
    	
    	ActionMessages messages = new ActionMessages();
        messages.add((new MessageUtil()).createActionMessages("msg_create_index_success"));
        this.addMessages(request, messages);
        
    	return mapping.findForward(SUCCESS);
    }
    
    /**
     * <P>Action for reset number</P>
     *
     * @author HungNM
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward resetNumber(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
    	
    	ContractNumberService contractNumberService = new ContractNumberService(getConnection());
    	contractNumberService.resetNumber();
    	
    	getConnection().commit();
    	
    	ActionMessages messages = new ActionMessages();
        messages.add((new MessageUtil()).createActionMessages("msg_reset_number_success"));
        this.addMessages(request, messages);
        
    	return mapping.findForward(SUCCESS);
    }
}
