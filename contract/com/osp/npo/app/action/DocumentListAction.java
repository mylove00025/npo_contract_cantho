package com.osp.npo.app.action;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.osp.npo.app.context.DocumentContext;
import com.osp.npo.app.context.DocumentListContext;
import com.osp.npo.app.form.DocumentListForm;
import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.DocumentListViewHelper;
import com.osp.npo.app.viewhelper.DocumentViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.FileUtil;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.document.DocumentInfo;
import com.osp.npo.core.document.DocumentList;
import com.osp.npo.service.DocumentService;

/**
 * List of contract kind page
 * 
 * @author TruongND
 * @version $Revision: 25298 $
 */
public class DocumentListAction extends BaseMDAction {
	public static final String SUCCESS_PATH = "success";
	private static final String FAILURE_PATH = "failure";
	private static final String ORDER_FIELD = "type";
	private static final String ORDER_NAME = "name";
	private static final String UPLOAD_DOCUMENT_FOLDER_KEY = "system_document_folder";
	private static final String DOCUMENT_FILE_NAME_PREFIX = "DC_";
	private static final String DOCUMENT_PATH = "item_document_path";

	/**
	 * 
	 * view action
	 * 
	 * @author TruongND
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException
	 * @throws IOException
	 */
	public ActionForward view(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		createTitle(Constants.SCREEN_CNTR033);
		HttpSession session = request.getSession();

		// delete sesion
		if (session.getAttribute(DocumentListViewHelper.SESSION_KEY) != null) {
			session.removeAttribute(DocumentListViewHelper.SESSION_KEY);
		}
		if (session.getAttribute(DocumentListContext.SESSION_KEY) != null) {
			session.removeAttribute(DocumentListContext.SESSION_KEY);
		}

		DocumentListViewHelper view = new DocumentListViewHelper();
		DocumentListContext context = new DocumentListContext();
		context.reset();
		context.setPreviousId(0L);

		setDocumentList(view, context, null);
		view.setIsSearch(false);

		request.getSession().setAttribute(DocumentListContext.SESSION_KEY,
				context);
		request.getSession().setAttribute(DocumentListViewHelper.SESSION_KEY,
				view);

		return mapping.findForward(SUCCESS_PATH);
	}

	@SuppressWarnings("unchecked")
	private void setDocumentList(DocumentListViewHelper documentListViewHelper,
			DocumentListContext documentListContext, String direction)
			throws SQLException, IOException {

		DocumentService service = new DocumentService(getConnection());
		setSearchFilter(documentListContext, service);

		documentListViewHelper.setDocumentList(null);
		documentListViewHelper.setMakeNewFolder(false);
		documentListViewHelper.setPreviousId(documentListContext.getPreviousId());
		documentListViewHelper.setNameHistoryFilter(null);
		documentListViewHelper.setDocumentNameFilter(null);

		String path = getFolderPath(documentListContext.getPreviousId());
		String path1 = EditString.getDispPath(path, 100);
		String path2 = EditString.getDispPath(path, 50);

		documentListViewHelper.setFolderPath(path);
		documentListViewHelper.setFolderPathDisp1(path1);
		documentListViewHelper.setFolderPathDisp2(path2);

		Integer totalCount = service.countTotalDocumentByFilter();
		documentListViewHelper.setTotalCount(totalCount);

		if (totalCount != 0) {
			service.addOrderFieldName(new OrderField(ORDER_FIELD));
			service.addOrderFieldName(new OrderField(ORDER_NAME));
			DocumentList documentList = service.queryAllDocument(false);
			documentListViewHelper.setDocumentList(documentList.getList());
		}

	}

	public ActionForward documentContent(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {

		createTitle(Constants.SCREEN_CNTR033);
		MessageUtil messageUtil = new MessageUtil();
		
		DocumentListViewHelper view = getDocumentListViewHelper(request);
		DocumentListContext context = getDocumentListContext(request);
		context.reset();
		DocumentListForm docForm = (DocumentListForm)form;
		Long documentId = docForm.getDocumentId();
		
		//kiem tra thu muc da bi xoa
	    DocumentService docService = new DocumentService(getConnection());
	    docService.setDocumentIdFilter(documentId);
	    int totalCount = docService.countTotalDocumentByFilter();
	    if(totalCount <= 0){
	    	
	    	//kiem tra thu muc cha da bi xoa
	      if(docForm.getPreviousId() != 0 && docForm.getPreviousId() != -1){
	    	docService.setDocumentIdFilter(docForm.getPreviousId());
	    	int count = docService.countTotalDocumentByFilter();
	    	
	    	if(count <= 0){
	    		ActionErrors acErrors = new ActionErrors();
				acErrors.add(messageUtil.createActionMessages("",
						"err_folder_had_del"));
				this.addErrors(request, acErrors);
				
				context.setPreviousId(0L);
				setDocumentList(view, context, null);
				view.setIsSearch(false);
				return mapping.findForward(FAILURE_PATH);
	    	}
	      }
	      
	    	ActionErrors acErrors = new ActionErrors();
			acErrors.add(messageUtil.createActionMessages("",
					"err_document_had_del"));
			this.addErrors(request, acErrors);
			
			setHistoryContext(context, docForm);
			setDocumentList(view, context, null);
			view.setDocumentNameFilter(docForm.getNameHistoryFilter());
			view.setNameHistoryFilter(docForm.getNameHistoryFilter());
			view.setIsSearch(docForm.getIsSearch());
			
			if (view.getDocumentList() != null) {
					for (int i = 0; i < view.getDocumentList().size(); i++) {

						String folderPath = getFolderPath(view.getDocumentList()
								.get(i).getPreviousId());
						String folderPathDisp = EditString.getDisp(folderPath, 50);
						view.getDocumentList().get(i).setFolderPath(folderPath);
						view.getDocumentList().get(i)
								.setFolderPathDisp(folderPathDisp);

				 }
			   } 
		
			
			return mapping.findForward(FAILURE_PATH);
	    	
	    }
		context.setPreviousId(documentId);

		setDocumentList(view, context, null);
		view.setIsSearch(false);

		return mapping.findForward(SUCCESS_PATH);
	}

	public ActionForward upFolder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		createTitle(Constants.SCREEN_CNTR033);

		MessageUtil messageUtil =  new MessageUtil();

		DocumentListViewHelper view = getDocumentListViewHelper(request);
		DocumentListContext context = getDocumentListContext(request);
		DocumentListForm docListForm = (DocumentListForm)form;
		context.reset();
		setHistoryContext(context, docListForm);

		//kiem tra thu muc da bi xoa
	   if (context.getPreviousId() != 0 && context.getPreviousId() != -1){
			DocumentService docService = new DocumentService(getConnection());
		    docService.setDocumentIdFilter(context.getPreviousId());
		    int totalCount = docService.countTotalDocumentByFilter();
		    if(totalCount <= 0){
		    	ActionErrors actionErrors = new ActionErrors();
				actionErrors.add(messageUtil.createActionMessages("",
						"err_folder_had_del"));
				this.addErrors(request, actionErrors);
				
	            context.reset();
	            context.setPreviousId(0L);
				setDocumentList(view, context, null);
				view.setIsSearch(false);
				return mapping.findForward(FAILURE_PATH);
		    }
	   	}
		if (context.getPreviousId() == null || context.getPreviousId() == 0 || context.getPreviousId() == -1) {
			context.reset();
			context.setPreviousId(0L);
		} else {
			DocumentService documentService = new DocumentService(
					getConnection());
			documentService.setDocumentIdFilter(context.getPreviousId());
			DocumentList documentList = documentService.queryAllDocument(false);
			DocumentInfo documentInfo = documentList.get(0);
			context.setPreviousId(documentInfo.getPreviousId());
		}
		setDocumentList(view, context, null);
		view.setIsSearch(false);

		return mapping.findForward(SUCCESS_PATH);
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
	public ActionForward downloadDocument(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws ServletException,
			SQLException, Exception {

		MessageUtil messageUtil = new MessageUtil();
		DocumentListForm documentForm = (DocumentListForm) form;
		DocumentListContext docContext = getDocumentListContext(request);
		DocumentListViewHelper view = getDocumentListViewHelper(request);
		docContext.reset();
		setHistoryContext(docContext, documentForm);
		Long documentId = documentForm.getDocumentId();

		DocumentService service = new DocumentService(getConnection());
		service.setDocumentIdFilter(documentId);
		DocumentList documentList = service.queryAllDocument(false);

		if (documentList != null && documentList.size() > 0) {
			DocumentInfo info = documentList.get(0);
			if (info != null && info.getFilePath() != null) {
				
			 try{
				File file = new File(info.getFilePath());

				if (file != null && file.exists() && file.canRead()
						&& file.isFile() && file.length() < Integer.MAX_VALUE) {
					
						response.setContentType("application/octet-stream");
						response.setHeader("Content-Disposition",
								"attachment; filename=\"" + info.getDocFileName()
										+ "\"");
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
					ActionErrors errors = new ActionErrors();
					errors.add(messageUtil.createActionMessages("",
							"err_file_not_found"));
					this.addErrors(request, errors);
					
					setDocumentList(view, docContext, null);
					view.setDocumentNameFilter(documentForm.getNameHistoryFilter());
					view.setNameHistoryFilter(documentForm.getNameHistoryFilter());
					view.setIsSearch(documentForm.getIsSearch());
					
					if (view.getDocumentList() != null) {
						for (int i = 0; i < view.getDocumentList().size(); i++) {

							String folderPath = getFolderPath(view.getDocumentList()
									.get(i).getPreviousId());
							String folderPathDisp = EditString.getDisp(folderPath, 50);
							view.getDocumentList().get(i).setFolderPath(folderPath);
							view.getDocumentList().get(i)
									.setFolderPathDisp(folderPathDisp);

					 }
				   } 
				}
				
			   }catch(Exception e){
					ActionErrors errors = new ActionErrors();
					errors.add(messageUtil.createActionMessages("",
							"err_file_not_download"));
					this.addErrors(request, errors);
					
					setDocumentList(view, docContext, null);
					view.setDocumentNameFilter(documentForm.getNameHistoryFilter());
					view.setNameHistoryFilter(documentForm.getNameHistoryFilter());
					view.setIsSearch(documentForm.getIsSearch());
					
					if (view.getDocumentList() != null) {
						for (int i = 0; i < view.getDocumentList().size(); i++) {

							String folderPath = getFolderPath(view.getDocumentList()
									.get(i).getPreviousId());
							String folderPathDisp = EditString.getDisp(folderPath, 50);
							view.getDocumentList().get(i).setFolderPath(folderPath);
							view.getDocumentList().get(i)
									.setFolderPathDisp(folderPathDisp);

					 }
				   } 
				}
				
			} else {
				ActionErrors errors = new ActionErrors();
				errors.add(messageUtil.createActionMessages("",
						"err_file_not_found"));
				this.addErrors(request, errors);
				
				setDocumentList(view, docContext, null);
				view.setDocumentNameFilter(documentForm.getNameHistoryFilter());
				view.setNameHistoryFilter(documentForm.getNameHistoryFilter());
				view.setIsSearch(documentForm.getIsSearch());
				
				if (view.getDocumentList() != null) {
					for (int i = 0; i < view.getDocumentList().size(); i++) {

						String folderPath = getFolderPath(view.getDocumentList()
								.get(i).getPreviousId());
						String folderPathDisp = EditString.getDisp(folderPath, 50);
						view.getDocumentList().get(i).setFolderPath(folderPath);
						view.getDocumentList().get(i)
								.setFolderPathDisp(folderPathDisp);

				 }
			   } 
			}
	    // file da bi xoa
		} else {
			
			//thu muc cha bi xoa
			if(documentForm.getPreviousId() != 0 && documentForm.getPreviousId() != -1){
				service.setDocumentIdFilter(documentForm.getPreviousId());
				int count = service.countTotalDocumentByFilter();
				if(count <= 0){
					ActionErrors acErrors = new ActionErrors();
					acErrors.add(messageUtil.createActionMessages("",
							"err_folder_had_del"));
					this.addErrors(request, acErrors);
					
					docContext.setPreviousId(0L);
					setDocumentList(view, docContext, null);
					view.setIsSearch(false);
					return mapping.findForward(FAILURE_PATH);
		    	}
			}
	    	
	    	ActionErrors acErrors = new ActionErrors();
			acErrors.add(messageUtil.createActionMessages("",
					"err_document_had_del"));
			this.addErrors(request, acErrors);
			
			setDocumentList(view, docContext, null);
			view.setDocumentNameFilter(documentForm.getNameHistoryFilter());
			view.setNameHistoryFilter(documentForm.getNameHistoryFilter());
			view.setIsSearch(documentForm.getIsSearch());
			
			if (view.getDocumentList() != null) {
				for (int i = 0; i < view.getDocumentList().size(); i++) {

					String folderPath = getFolderPath(view.getDocumentList()
							.get(i).getPreviousId());
					String folderPathDisp = EditString.getDisp(folderPath, 50);
					view.getDocumentList().get(i).setFolderPath(folderPath);
					view.getDocumentList().get(i)
							.setFolderPathDisp(folderPathDisp);

			 }
		   } 
	
			
			return mapping.findForward(FAILURE_PATH);
			
		}

		return mapping.findForward(SUCCESS_PATH);
	}

	public ActionForward uploadDocumentView(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws SQLException, IOException {

		createTitle(Constants.SCREEN_CNTR035);
		MessageUtil messageUtil = new MessageUtil();
		
		DocumentViewHelper docViewHelper = getDocumentViewHelper(request);
		DocumentListForm docListForm = (DocumentListForm)form;
		docViewHelper.setPreviousId(docListForm.getPreviousId());
		docViewHelper.setDocumentName(null);
		
		//kiem tra thu muc da bi xoa
		if (docListForm.getPreviousId() != 0){
			DocumentService docService = new DocumentService(getConnection());
		    docService.setDocumentIdFilter(docListForm.getPreviousId());
		    int totalCount = docService.countTotalDocumentByFilter();
		    if(totalCount <= 0){
		    	ActionErrors actionErrors = new ActionErrors();
				actionErrors.add(messageUtil.createActionMessages("",
						"err_folder_had_del"));
				this.addErrors(request, actionErrors);
				
				DocumentListViewHelper docHelper = getDocumentListViewHelper(request);
				DocumentListContext docContext = getDocumentListContext(request);
				docContext.reset();
				docContext.setPreviousId(0L);
				setDocumentList(docHelper, docContext, null);
				docHelper.setIsSearch(false);
				return mapping.findForward(FAILURE_PATH);
		    }
		}
		return mapping.findForward(SUCCESS_PATH);

	}

	public ActionForward uploadDocument(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		createTitle(Constants.SCREEN_CNTR035);
		DocumentViewHelper view = getDocumentViewHelper(request);
		DocumentListContext docContext = getDocumentListContext(request);
		DocumentListViewHelper docListViewHelper = getDocumentListViewHelper(request);
		DocumentListForm docListForm = (DocumentListForm)form;
		docContext.reset();
		setHistoryContext(docContext, docListForm);
		
		MessageUtil messageUtil = new MessageUtil();

		DocumentInfo documentInfo = new DocumentInfo();
		DocumentService documentService = new DocumentService(getConnection());

		// kiem tra ten khong null
		if (EditString.isNull(docListForm.getDocumentName())||docListForm.getDocumentName().length() == 0) {
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add(messageUtil.createActionMessages("",
					"err_no_document_name"));
			this.addErrors(request, actionErrors);

			return mapping.findForward(FAILURE_PATH);
		}
		
		if (EditString.isNull(docListForm.getDocumentName().trim())) {
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add(messageUtil.createActionMessages("",
					"err_no_document_name"));
			this.addErrors(request, actionErrors);

			return mapping.findForward(FAILURE_PATH);
		}

	    //  Kiem tra ky tu dbiet
		String documentName = docListForm.getDocumentName().trim();
		if(documentName.contains("/") || documentName.contains("\\") || documentName.contains("|") || 
				documentName.contains(":") || documentName.contains("*") || documentName.contains("?") 
				|| documentName.contains("\"") || documentName.contains("<") || documentName.contains(">")){
			
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add(messageUtil.createActionMessages("",
					"err_char_folder_name"));
			this.addErrors(request, actionErrors);

			return mapping.findForward(FAILURE_PATH);
			
		}
		
		// Kiem tra trung ten
		DocumentService docService = new DocumentService(getConnection());
		docService.setNameCheckFilter(documentName, FilterKind.FULL);
		docService.setPreviousIdFilter(docContext.getPreviousId());
		DocumentList docList = docService.queryAllDocument(false);
		if (docList != null && docList.size() > 0) {
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add(messageUtil.createActionMessages("",
					"err_duplicate_folder_name"));
			this.addErrors(request, actionErrors);

			return mapping.findForward(FAILURE_PATH);
		}
		
		//kiem tra thu muc da bi xoa
		if (docListForm.getPreviousId() != 0){
			DocumentService docService1 = new DocumentService(getConnection());
		    docService1.setDocumentIdFilter(docListForm.getPreviousId());
		    int totalCount = docService1.countTotalDocumentByFilter();
		    if(totalCount <= 0){
		    	ActionErrors actionErrors = new ActionErrors();
				actionErrors.add(messageUtil.createActionMessages("",
						"err_folder_had_del"));
				this.addErrors(request, actionErrors);
				
				DocumentListViewHelper docHelper = getDocumentListViewHelper(request);
				DocumentListContext docContext1 = getDocumentListContext(request);
				docContext1.reset();
				docContext1.setPreviousId(0L);
				setDocumentList(docHelper, docContext1, null);
				docHelper.setIsSearch(false);
				return mapping.findForward(FAILURE_PATH);
		    }
		}
		documentInfo.setName(documentName);
		documentInfo.setType(1L);
		documentInfo.setPreviousId(docContext.getPreviousId());
		createEntryUserInfo(documentInfo);

		try {
			String localName = EditString.convertUnicodeToASCII(docListForm
					.getFormFile().getFileName());
			String path = "";

			/*
			 * String realname = ""; if (!localName.isEmpty()) { Integer dot =
			 * localName.lastIndexOf(EXTENSION_SEPARATOR); String fileExtension
			 * = ""; if (dot > 0) { fileExtension = localName.substring(dot +
			 * 1); }
			 * 
			 * realname = CONTRACT_FILE_NAME_PREFIX +
			 * RelateDateTime.formatDate(RelateDateTime.YYYYMMDDHHMISS,
			 * contractInfo.getEntryDateTime()) + EXTENSION_SEPARATOR +
			 * fileExtension; path =
			 * SystemProperties.getProperty(UPLOAD_FOLDER_KEY) + SLASH +
			 * realname;
			 * 
			 * FileOutputStream outputStream = null; outputStream = new
			 * FileOutputStream(new File(path));
			 * outputStream.write(contractForm.getFormFile().getFileData()); }
			 */
			if (!EditString.isNull(localName)) {
				
				//gioi han do dai file toi 30M
				int fileLength = docListForm.getFormFile().getFileData().length;
				if(fileLength > 31457280){
					
					ActionErrors acErrors = new ActionErrors();
					acErrors.add(messageUtil.createActionMessages("",
							"err_max_length_file"));
					this.addErrors(request, acErrors);
					
					view.setDocumentName(docListForm.getDocumentName());
					
					return mapping.findForward(FAILURE_PATH);
					
				}
				
				File file = FileUtil.createNewFile(SystemProperties
						.getProperty(UPLOAD_DOCUMENT_FOLDER_KEY),
						DOCUMENT_FILE_NAME_PREFIX);
				FileOutputStream outputStream = null;
				outputStream = new FileOutputStream(file);
				outputStream.write(docListForm.getFormFile().getFileData());
				path = file.getAbsolutePath();
			} else {
				ActionErrors errors = new ActionErrors();
				errors.add(messageUtil.createActionMessages("",
						"err_no_attack_file"));
				this.addErrors(request, errors);
				
				return mapping.findForward(FAILURE_PATH);
			}

			documentInfo.setDocFileName(localName);
			documentInfo.setFilePath(path);

		} catch (IOException e) {
			ActionErrors errors = new ActionErrors();
			errors.add(messageUtil.createActionMessages("",
					"err_cannot_upload_file"));
			this.addErrors(request, errors);
			
			return mapping.findForward(FAILURE_PATH);
		}

		documentService.entryDocument(documentInfo);
		getConnection().commit();
		
		setDocumentList(docListViewHelper, docContext, null);
		docListViewHelper.setIsSearch(false);
		
		ActionMessages messages = new ActionMessages();
	    messages.add(messageUtil.createActionMessages("","msg_up_file_success"));
	    this.addMessages(request, messages);
	        
		return mapping.findForward(SUCCESS_PATH);

	}

	public ActionForward makeNewFolder(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		createTitle(Constants.SCREEN_CNTR033);
		MessageUtil messageUtil = new MessageUtil();
		DocumentListContext docContext = getDocumentListContext(request);
		DocumentListViewHelper view = getDocumentListViewHelper(request);
		DocumentListForm documentForm = (DocumentListForm) form;
		docContext.reset();
		setHistoryContext(docContext, documentForm);
		DocumentInfo documentInfo = new DocumentInfo();

		// kiem tra ten khong null
		if (EditString.isNull(documentForm.getDocumentName())||documentForm.getDocumentName().length() == 0) {
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add(messageUtil.createActionMessages("",
					"err_no_folder_name"));
			this.addErrors(request, actionErrors);

			setDocumentList(view, docContext, null);
			view.setIsSearch(false);
			view.setMakeNewFolder(true);

			return mapping.findForward(FAILURE_PATH);
		}
		
		if (EditString.isNull(documentForm.getDocumentName().trim())) {
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add(messageUtil.createActionMessages("",
					"err_no_folder_name"));
			this.addErrors(request, actionErrors);

			setDocumentList(view, docContext, null);
			view.setIsSearch(false);
			view.setMakeNewFolder(true);

			return mapping.findForward(FAILURE_PATH);
		}


		//  Kiem tra ky tu dbiet
		String documentName = documentForm.getDocumentName().trim();
		if(documentName.contains("/") || documentName.contains("\\") || documentName.contains("|") || 
				documentName.contains(":") || documentName.contains("*") || documentName.contains("?") 
				|| documentName.contains("\"") || documentName.contains("<") || documentName.contains(">")){
			
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add(messageUtil.createActionMessages("",
					"err_char_folder_name"));
			this.addErrors(request, actionErrors);

			setDocumentList(view, docContext, null);
			view.setIsSearch(false);
			view.setMakeNewFolder(true);

			return mapping.findForward(FAILURE_PATH);
			
		}
		
		// Kiem tra trung ten
		DocumentService documentService = new DocumentService(getConnection());
		documentService.setNameCheckFilter(documentName, FilterKind.FULL);
		documentService.setPreviousIdFilter(docContext.getPreviousId());
		DocumentList docList = documentService.queryAllDocument(false);
		if (docList != null && docList.size() > 0) {
			ActionErrors actionErrors = new ActionErrors();
			actionErrors.add(messageUtil.createActionMessages("",
					"err_duplicate_folder_name"));
			this.addErrors(request, actionErrors);

			setDocumentList(view, docContext, null);
			view.setIsSearch(false);
			view.setMakeNewFolder(true);

			return mapping.findForward(FAILURE_PATH);
		}
		
		//kiem tra thu muc da bi xoa
		if (docContext.getPreviousId() != 0){
			DocumentService docService = new DocumentService(getConnection());
		    docService.setDocumentIdFilter(docContext.getPreviousId());
		    int totalCount = docService.countTotalDocumentByFilter();
		    if(totalCount <= 0){
		    	ActionErrors actionErrors = new ActionErrors();
				actionErrors.add(messageUtil.createActionMessages("",
						"err_folder_had_del"));
				this.addErrors(request, actionErrors);
				
				docContext.reset();
				docContext.setPreviousId(0L);
				setDocumentList(view, docContext, null);
				view.setIsSearch(false);
				return mapping.findForward(FAILURE_PATH);
		    }
		}
		
		documentInfo.setName(documentForm.getDocumentName().trim());
		documentInfo.setType(0L);
		documentInfo.setPreviousId(docContext.getPreviousId());
		createEntryUserInfo(documentInfo);

		documentService.entryDocument(documentInfo);
		getConnection().commit();

		setDocumentList(view, docContext, null);
		view.setIsSearch(false);

		ActionMessages messages = new ActionMessages();
	    messages.add(messageUtil.createActionMessages("","msg_make_folder_success"));
	    this.addMessages(request, messages);
	    
		return mapping.findForward(SUCCESS_PATH);

	}

	public ActionForward delDocument(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		createTitle(Constants.SCREEN_CNTR033);
		MessageUtil messageUtil = new MessageUtil();
		DocumentListForm docForm = (DocumentListForm) form;
		DocumentListContext context = getDocumentListContext(request);
		DocumentListViewHelper view = getDocumentListViewHelper(request);
		DocumentService docService = new DocumentService(getConnection());
		context.reset();
		setHistoryContext(context, docForm);
		Long documentId = docForm.getDocumentId();
		
		//kiem tra thu muc da bi xoa
	    docService.setDocumentIdFilter(documentId);
	    int totalCount = docService.countTotalDocumentByFilter();
	    if(totalCount <= 0){
	    	
	    	//kiem tra thu muc cha da bi xoa
	      if(docForm.getPreviousId() != 0 && docForm.getPreviousId() != -1){
	    	docService.setDocumentIdFilter(docForm.getPreviousId());
	    	int count = docService.countTotalDocumentByFilter();
	    	
	    	if(count <= 0){
	    		ActionErrors acErrors = new ActionErrors();
				acErrors.add(messageUtil.createActionMessages("",
						"err_folder_had_del"));
				this.addErrors(request, acErrors);
				
				context.setPreviousId(0L);
				setDocumentList(view, context, null);
				view.setIsSearch(false);
				
				return mapping.findForward(FAILURE_PATH);
	    	}
	      }
	    	ActionErrors acErrors = new ActionErrors();
			acErrors.add(messageUtil.createActionMessages("",
					"err_document_had_del"));
			this.addErrors(request, acErrors);
			
			context.setPreviousId(docForm.getPreviousId());
			setDocumentList(view, context, null);
			view.setDocumentNameFilter(docForm.getNameHistoryFilter());
			view.setNameHistoryFilter(docForm.getNameHistoryFilter());
			view.setIsSearch(docForm.getIsSearch());
			

			if (view.getDocumentList() != null) {
				for (int i = 0; i < view.getDocumentList().size(); i++) {

					String folderPath = getFolderPath(view.getDocumentList()
							.get(i).getPreviousId());
					String folderPathDisp = EditString.getDisp(folderPath, 50);
					view.getDocumentList().get(i).setFolderPath(folderPath);
					view.getDocumentList().get(i)
							.setFolderPathDisp(folderPathDisp);

			 }
		   } 
	
			
			return mapping.findForward(FAILURE_PATH);
	    	
	    }

		docService.setDocumentIdFilter(documentId);
		DocumentList documentList1 = docService.queryAllDocument(false);

		// xoa thu muc goc
		if (documentList1 != null && documentList1.size() > 0) {
			DocumentInfo documentInfo = documentList1.get(0);
			if (documentInfo.getType() == 1) {
				if (documentInfo.getDocFileName() != null
						&& !documentInfo.getDocFileName().equals("")) {
					File oldFile = new File(documentInfo.getFilePath());
					oldFile.delete();
				}
			}
			docService.removeDocument(documentInfo.getId());
		}

		// lay list cac thu muc con
		DocumentService documentService2 = new DocumentService(getConnection());
		documentService2.setPreviousIdFilter(documentId);

		List<DocumentList> documentList2 = new ArrayList<DocumentList>();
		DocumentList dList = documentService2.queryAllDocument(false);
		documentList2.add(dList);
		List<DocumentList> documentList = new ArrayList<DocumentList>();
		documentList.add(dList);

		while (documentList2 != null && documentList2.size() > 0) {

			List<DocumentList> documentList4 = new ArrayList<DocumentList>();
			for (int i = 0; i < documentList2.size(); i++) {
				DocumentList docList = documentList2.get(i);
				for (int j = 0; j < docList.size(); j++) {
					DocumentInfo docInfo = docList.get(j);
					DocumentService docService1 = new DocumentService(
							getConnection());
					docService1.setPreviousIdFilter(docInfo.getId());
					DocumentList documentList3 = docService1
							.queryAllDocument(false);
					documentList.add(documentList3);
					documentList4.add(documentList3);
				}
			}
			documentList2 = documentList4;
		}

		// xoa cac thu muc con
		for (int i = 0; i < documentList.size(); i++) {
			DocumentList docList = documentList.get(i);
			for (int j = 0; j < docList.size(); j++) {
				DocumentInfo docInfo = docList.get(j);
				DocumentService docService1 = new DocumentService(
						getConnection());
				if (docInfo.getType() == 1) {
					if (docInfo.getDocFileName() != null
							&& !docInfo.getDocFileName().equals("")) {
						File oldFile = new File(docInfo.getFilePath());
						oldFile.delete();
					}
				}
				docService1.removeDocument(docInfo.getId());
			}
		}

		getConnection().commit();

		setDocumentList(view, context, null);
		view.setIsSearch(docForm.getIsSearch());
		view.setNameHistoryFilter(docForm.getNameHistoryFilter());
		view.setDocumentNameFilter(docForm.getNameHistoryFilter());

		if (view.getDocumentList() != null) {
			for (int i = 0; i < view.getDocumentList().size(); i++) {

				String folderPath = getFolderPath(view.getDocumentList().get(i)
						.getPreviousId());
				String folderPathDisp = EditString.getDisp(folderPath, 50);
				view.getDocumentList().get(i).setFolderPath(folderPath);
				view.getDocumentList().get(i).setFolderPathDisp(folderPathDisp);

			}
		}
		

		ActionMessages messages = new ActionMessages();
	    messages.add(messageUtil.createActionMessages("","msg_del_document_success"));
	    this.addMessages(request, messages);
	    
		return mapping.findForward(SUCCESS_PATH);

	}

	public ActionForward editDocument(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		createTitle(Constants.SCREEN_CNTR034);
		DocumentListForm docListForm = (DocumentListForm)form;
	    Long documentId = docListForm.getDocumentId();
		MessageUtil messageUtil = new MessageUtil();
		HttpSession session = request.getSession();

		// delete sesion
		if (session.getAttribute(DocumentViewHelper.SESSION_KEY) != null) {
			session.removeAttribute(DocumentViewHelper.SESSION_KEY);
		}
		if (session.getAttribute(DocumentContext.SESSION_KEY) != null) {
			session.removeAttribute(DocumentContext.SESSION_KEY);
		}

		DocumentService documentService = new DocumentService(getConnection());
		DocumentViewHelper docViewHelper = new DocumentViewHelper();
		DocumentContext docContext = new DocumentContext();

		documentService.setDocumentIdFilter(documentId);
		DocumentList documentList = documentService.queryAllDocument(false);

		if (documentList != null && documentList.size() > 0) {
			DocumentInfo docInfo = documentList.get(0);
			docViewHelper.setPreviousId(docListForm.getPreviousId());
			docViewHelper.setDocumentName(docInfo.getName());
			docViewHelper.setId(docInfo.getId());
			docViewHelper.setDocumentNameFilter(docListForm.getNameHistoryFilter());
			docViewHelper.setNameHistoryFilter(docListForm.getNameHistoryFilter());
			docViewHelper.setIsSearch(docListForm.getIsSearch());
			docContext.setDocumentId(docInfo.getId());

	   //tai lieu da bi xoa
		} else {
			
			//kiem tra thu muc cha bi xoa
			DocumentListViewHelper view = getDocumentListViewHelper(request);
			DocumentListContext documentListContext = getDocumentListContext(request);
			documentListContext.reset();
			setHistoryContext(documentListContext, docListForm);
			
			if (docListForm.getPreviousId() != 0 && docListForm.getPreviousId() != -1){
				DocumentService docService = new DocumentService(getConnection());
				docService.setDocumentIdFilter(docListForm.getPreviousId());
				int count = docService.countTotalDocumentByFilter();
				if(count <= 0){
					ActionErrors acErrors = new ActionErrors();
					acErrors.add(messageUtil.createActionMessages("",
							"err_folder_had_del"));
					this.addErrors(request, acErrors);
					
					documentListContext.setPreviousId(0L);
					setDocumentList(view, documentListContext, null);
					view.setIsSearch(false);

					if (view.getDocumentList() != null) {
						for (int i = 0; i < view.getDocumentList().size(); i++) {

							String folderPath = getFolderPath(view.getDocumentList()
									.get(i).getPreviousId());
							String folderPathDisp = EditString.getDisp(folderPath, 50);
							view.getDocumentList().get(i).setFolderPath(folderPath);
							view.getDocumentList().get(i)
									.setFolderPathDisp(folderPathDisp);

					 }
				   } 
			
					return mapping.findForward(FAILURE_PATH);
				 }
			   }
				
				ActionErrors acErrors = new ActionErrors();
				acErrors.add(messageUtil.createActionMessages("",
						"err_document_had_del"));
				this.addErrors(request, acErrors);
				
				setDocumentList(view, documentListContext, null);
				view.setIsSearch(docListForm.getIsSearch());
				view.setDocumentNameFilter(docListForm.getNameHistoryFilter());
				view.setNameHistoryFilter(docListForm.getNameHistoryFilter());

				if (view.getDocumentList() != null) {
					for (int i = 0; i < view.getDocumentList().size(); i++) {

						String folderPath = getFolderPath(view.getDocumentList()
								.get(i).getPreviousId());
						String folderPathDisp = EditString.getDisp(folderPath, 50);
						view.getDocumentList().get(i).setFolderPath(folderPath);
						view.getDocumentList().get(i)
								.setFolderPathDisp(folderPathDisp);

				 }
			   } 
		
				return mapping.findForward(FAILURE_PATH);
			}
			
		request.getSession().setAttribute(DocumentContext.SESSION_KEY,
				docContext);
		request.getSession().setAttribute(DocumentViewHelper.SESSION_KEY,
				docViewHelper);

		return mapping.findForward(SUCCESS_PATH);

	}

	public ActionForward saveEditDocument(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		createTitle(Constants.SCREEN_CNTR033);
		MessageUtil messageUtil = new MessageUtil();
		DocumentListForm docForm = (DocumentListForm) form;
		DocumentListViewHelper view = getDocumentListViewHelper(request);
        DocumentListContext documentListContext = getDocumentListContext(request);
        documentListContext.reset();
        setHistoryContext(documentListContext, docForm);

		DocumentContext docContext = (DocumentContext) request.getSession()
				.getAttribute(DocumentContext.SESSION_KEY);

		DocumentService documentService = new DocumentService(getConnection());
		documentService.setDocumentIdFilter(docContext.getDocumentId());
		DocumentList documentList = documentService.queryAllDocument(false);

		
		if (documentList != null && documentList.size() > 0) {
			DocumentInfo docInfo = documentList.get(0);
			//kiem tra ten null
			if(docForm.getDocumentName() == null || docForm.getDocumentName().length() == 0 ){
				ActionErrors acErrors = new ActionErrors();
				acErrors.add(messageUtil.createActionMessages("",
						"err_name_document_null"));
				this.addErrors(request, acErrors);
				
				return mapping.findForward(FAILURE_PATH);
			}
			if (EditString.isNull(docForm.getDocumentName().trim())){
				ActionErrors acErrors = new ActionErrors();
				acErrors.add(messageUtil.createActionMessages("",
						"err_name_document_null"));
				this.addErrors(request, acErrors);
				return mapping.findForward(FAILURE_PATH);
			}
			
		    //  Kiem tra ky tu dbiet
			String documentName = docForm.getDocumentName().trim();
			if(documentName.contains("/") || documentName.contains("\\") || documentName.contains("|") || 
					documentName.contains(":") || documentName.contains("*") || documentName.contains("?") 
					|| documentName.contains("\"") || documentName.contains("<") || documentName.contains(">")){
				
				ActionErrors actionErrors = new ActionErrors();
				actionErrors.add(messageUtil.createActionMessages("",
						"err_char_folder_name"));
				this.addErrors(request, actionErrors);

				return mapping.findForward(FAILURE_PATH);
				
			}
			
			// Kiem tra trung ten
			DocumentService docService = new DocumentService(getConnection());
			docService.setNameCheckFilter(documentName, FilterKind.FULL);
			docService.setPreviousIdFilter(docInfo.getPreviousId());
			DocumentList docList = docService.queryAllDocument(false);
			if (docList != null && docList.size() > 0) {
				DocumentInfo docInfo2 = docList.get(0);
				if(docInfo2.getId().compareTo(docInfo.getId()) != 0){
					ActionErrors actionErrors = new ActionErrors();
					actionErrors.add(messageUtil.createActionMessages("",
							"err_duplicate_folder_name"));
					this.addErrors(request, actionErrors);

					return mapping.findForward(FAILURE_PATH);
				}
			}
			
				docInfo.setName(documentName);
				createUpdateUserInfo(docInfo);
				documentService.modifyDocument(docInfo);
				

		} else {
			
			//kiem tra thu muc cha bi xoa
			documentListContext.reset();
			setHistoryContext(documentListContext, docForm);
			
			if (docForm.getPreviousId() != 0 && docForm.getPreviousId() != -1){
				DocumentService docService = new DocumentService(getConnection());
				docService.setDocumentIdFilter(docForm.getPreviousId());
				int count = docService.countTotalDocumentByFilter();
				if(count <= 0){
					ActionErrors acErrors = new ActionErrors();
					acErrors.add(messageUtil.createActionMessages("",
							"err_folder_had_del"));
					this.addErrors(request, acErrors);
					
					documentListContext.setPreviousId(0L);
					setDocumentList(view, documentListContext, null);
					view.setIsSearch(false);

					if (view.getDocumentList() != null) {
						for (int i = 0; i < view.getDocumentList().size(); i++) {

							String folderPath = getFolderPath(view.getDocumentList()
									.get(i).getPreviousId());
							String folderPathDisp = EditString.getDisp(folderPath, 50);
							view.getDocumentList().get(i).setFolderPath(folderPath);
							view.getDocumentList().get(i)
									.setFolderPathDisp(folderPathDisp);

					 }
				   } 
			
					return mapping.findForward(FAILURE_PATH);
				 }
			   }
				
				ActionErrors acErrors = new ActionErrors();
				acErrors.add(messageUtil.createActionMessages("",
						"err_folder_had_del"));
				this.addErrors(request, acErrors);
				
				setDocumentList(view, documentListContext, null);
				view.setDocumentNameFilter(docForm.getNameHistoryFilter());
				view.setNameHistoryFilter(docForm.getNameHistoryFilter());
				view.setIsSearch(docForm.getIsSearch());

				if (view.getDocumentList() != null) {
					for (int i = 0; i < view.getDocumentList().size(); i++) {

						String folderPath = getFolderPath(view.getDocumentList()
								.get(i).getPreviousId());
						String folderPathDisp = EditString.getDisp(folderPath, 50);
						view.getDocumentList().get(i).setFolderPath(folderPath);
						view.getDocumentList().get(i)
								.setFolderPathDisp(folderPathDisp);

				 }
			    } 
		
			  return mapping.findForward(FAILURE_PATH);
				
		   }

		getConnection().commit();

		setDocumentList(view, documentListContext, null);
		view.setDocumentNameFilter(docForm.getNameHistoryFilter());
		view.setNameHistoryFilter(docForm.getNameHistoryFilter());
		view.setIsSearch(docForm.getIsSearch());

		if (view.getDocumentList() != null) {
			for (int i = 0; i < view.getDocumentList().size(); i++) {

				String folderPath = getFolderPath(view.getDocumentList().get(i)
						.getPreviousId());
				String folderPathDisp = EditString.getDisp(folderPath, 50);
				view.getDocumentList().get(i).setFolderPath(folderPath);
				view.getDocumentList().get(i).setFolderPathDisp(folderPathDisp);

			}
		}

		ActionMessages messages = new ActionMessages();
	    messages.add(messageUtil.createActionMessages("","msg_edit_document_success"));
	    this.addMessages(request, messages);
	    
		return mapping.findForward(SUCCESS_PATH);

	}

	public DocumentListContext getDocumentListContext(HttpServletRequest request) {
		HttpSession session = request.getSession();
		DocumentListContext context = (DocumentListContext) session
				.getAttribute(DocumentListContext.SESSION_KEY);

		if (context == null) {
			context = new DocumentListContext();
			session.setAttribute(DocumentListContext.SESSION_KEY, context);
		}

		return context;

	}
	
	public DocumentContext getDocumentContext(HttpServletRequest request) {
		HttpSession session = request.getSession();
		DocumentContext context = (DocumentContext) session
				.getAttribute(DocumentContext.SESSION_KEY);

		if (context == null) {
			context = new DocumentContext();
			session.setAttribute(DocumentContext.SESSION_KEY, context);
		}

		return context;

	}
	
	public DocumentViewHelper getDocumentViewHelper(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		DocumentViewHelper viewHelper = (DocumentViewHelper) session
				.getAttribute(DocumentViewHelper.SESSION_KEY);

		if (viewHelper == null) {
			viewHelper = new DocumentViewHelper();
			session.setAttribute(DocumentViewHelper.SESSION_KEY, viewHelper);
		}

		return viewHelper;

	}
	
	public DocumentListViewHelper getDocumentListViewHelper(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		DocumentListViewHelper viewHelper = (DocumentListViewHelper) session
				.getAttribute(DocumentListViewHelper.SESSION_KEY);

		if (viewHelper == null) {
			viewHelper = new DocumentListViewHelper();
			session.setAttribute(DocumentViewHelper.SESSION_KEY, viewHelper);
		}

		return viewHelper;

	}

	private void setSearchFilter(DocumentListContext documentListContext,
			DocumentService documentService) {
		if (documentListContext.getDocumentNameFilter() != null
				&& documentListContext.getDocumentNameFilter().length() > 0) {
			documentService.setNameFilter(
					documentListContext.getDocumentNameFilter(),
					FilterKind.MIDDLE);
		}
		if (documentListContext.getPreviousId() != null && documentListContext.getPreviousId() != -1 ) {
			documentService.setPreviousIdFilter(documentListContext
					.getPreviousId());
		}

	}

	public ActionForward back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		createTitle(Constants.SCREEN_CNTR033);
		MessageUtil messageUtil = new MessageUtil();
		DocumentListViewHelper view = getDocumentListViewHelper(request);
		DocumentListContext context = getDocumentListContext(request);
		DocumentListForm docForm = (DocumentListForm)form;
		context.reset();
		setHistoryContext(context, docForm);
		
		//kiem tra thu muc cha bi xoa
		if (docForm.getPreviousId() != 0 && docForm.getPreviousId() != -1){
			DocumentService docService = new DocumentService(getConnection());
			docService.setDocumentIdFilter(docForm.getPreviousId());
			int count = docService.countTotalDocumentByFilter();
			if(count <= 0){
				ActionErrors acErrors = new ActionErrors();
				acErrors.add(messageUtil.createActionMessages("",
						"err_folder_had_del"));
				this.addErrors(request, acErrors);
				
				context.setPreviousId(0L);
				setDocumentList(view, context, null);
				view.setIsSearch(false);
				if (view.getDocumentList() != null) {
					for (int i = 0; i < view.getDocumentList().size(); i++) {

						String folderPath = getFolderPath(view.getDocumentList()
								.get(i).getPreviousId());
						String folderPathDisp = EditString.getDisp(folderPath, 50);
						view.getDocumentList().get(i).setFolderPath(folderPath);
						view.getDocumentList().get(i)
								.setFolderPathDisp(folderPathDisp);

				 }
			   } 
		
				return mapping.findForward(FAILURE_PATH);
			 }
		   }
			
	
		if (context.getPreviousId() == null
				&& context.getDocumentNameFilter() == null) {
			context.reset();
			context.setPreviousId(0L);
		}

		setDocumentList(view, context, null);
		view.setIsSearch(docForm.getIsSearch());
		view.setNameHistoryFilter(docForm.getNameHistoryFilter());
		view.setDocumentNameFilter(docForm.getNameHistoryFilter());

		if (view.getDocumentList() != null) {
			for (int i = 0; i < view.getDocumentList().size(); i++) {

				String folderPath = getFolderPath(view.getDocumentList().get(i)
						.getPreviousId());
				String folderPathDisp = EditString.getDisp(folderPath, 50);
				view.getDocumentList().get(i).setFolderPath(folderPath);
				view.getDocumentList().get(i).setFolderPathDisp(folderPathDisp);

			}
		}
		return mapping.findForward(SUCCESS_PATH);
	}

	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		DocumentListContext context = getDocumentListContext(request);

		DocumentListForm docForm = (DocumentListForm) form;
		context.reset();

		setContext(context, docForm);
		context.setPreviousId(null);

		DocumentListViewHelper viewHelper = (DocumentListViewHelper) request
				.getSession().getAttribute(DocumentListViewHelper.SESSION_KEY);
		setDocumentList(viewHelper, context, null);
		viewHelper.setIsSearch(true);
		viewHelper.setPreviousId(-1L);
		viewHelper.setDocumentNameFilter(docForm.getDocumentNameFilter().trim());
		viewHelper.setNameHistoryFilter(docForm.getDocumentNameFilter().trim());

		if (viewHelper.getDocumentList() != null) {
			for (int i = 0; i < viewHelper.getDocumentList().size(); i++) {

				String folderPath = getFolderPath(viewHelper.getDocumentList()
						.get(i).getPreviousId());
				String folderPathDisp = EditString.getDisp(folderPath, 50);
				viewHelper.getDocumentList().get(i).setFolderPath(folderPath);
				viewHelper.getDocumentList().get(i)
						.setFolderPathDisp(folderPathDisp);

			}
		}

		if (viewHelper.getTotalCount() == 0) {
			MessageUtil mu = new MessageUtil();
			saveMessages(request, mu.createActionMessages("", request,
					"msg_data_not_exist", "item_document_name"));
		}
        
		return mapping.findForward(SUCCESS_PATH);
	}

	private void setContext(DocumentListContext context,
			DocumentListForm docForm) {
		if(docForm.getDocumentNameFilter() != null && docForm.getDocumentNameFilter().length() > 0 ){
			context.setDocumentNameFilter(docForm.getDocumentNameFilter().trim());
		}
		context.setPreviousId(docForm.getPreviousId());
	}
	
	private void setHistoryContext(DocumentListContext context,
			DocumentListForm docForm) {
		if(docForm.getNameHistoryFilter() != null && docForm.getNameHistoryFilter().length() > 0 ){
			context.setDocumentNameFilter(docForm.getNameHistoryFilter().trim());
		}
		context.setPreviousId(docForm.getPreviousId());
	}

	private String getFolderPath(Long previousId) throws SQLException,
			IOException {

		if (previousId == null)
			return null;
		String folderPath = "";
		DocumentService docService = new DocumentService(getConnection());
		DocumentInfo docInfo;
		while (previousId != 0) {
			docService.setDocumentIdFilter(previousId);
			DocumentList docList = docService.queryAllDocument(false);
			if (docList != null && docList.size() > 0) {
				docInfo = docList.get(0);
				folderPath = docInfo.getName() + Constants.PATH + folderPath;
				previousId = docInfo.getPreviousId();
			} else {
				return null;
			}
		}

		folderPath = SystemMessageProperties.getSystemProperty(DOCUMENT_PATH)
				+ Constants.PATH + folderPath;
		folderPath = folderPath.substring(0, folderPath.length() - 1);
		return folderPath;
	}

}
