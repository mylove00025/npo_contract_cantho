package com.osp.npo.app.engine;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.rpc.ServiceException;

import com.osp.npo.app.plugin.InitSystemPlugin;
import com.osp.npo.common.util.DBConnection;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.FileUtil;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.AbstractWsInfo;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.announcementws.AnnouncementWsInfo;
import com.osp.npo.core.announcementws.AnnouncementWsList;
import com.osp.npo.core.common.SystemConfigInfo;
import com.osp.npo.core.preventws.DataPreventHistoryWsInfo;
import com.osp.npo.core.preventws.DataPreventWsInfo;
import com.osp.npo.core.preventws.DataPreventWsList;
import com.osp.npo.core.preventws.PropertyPreventWsInfo;
import com.osp.npo.core.preventws.PropertyPreventWsList;
import com.osp.npo.core.preventws.TransactionPropertyWsInfo;
import com.osp.npo.core.preventws.TransactionPropertyWsList;
import com.osp.npo.core.synchronizews.SynchronizeWsInfo;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;
import com.osp.npo.service.AnnouncementWsService;
import com.osp.npo.service.CommonService;
import com.osp.npo.service.PreventWsService;
import com.osp.npo.service.SynchronizeWsService;
import com.osp.npo.ws.ContentInfo;
import com.osp.npo.ws.NpoWS;
import com.osp.npo.ws.NpoWSServiceLocator;
import com.osp.npo.ws.WebserviceInfo;

/**
 * Expired prevent data update engine
 * 
 * @author HaiNT
 * @version $Revision: 17945 $
 */
public class SynchronizeDBEngine {
    
	static private SynchronizeDBEngine _instance;
	
	private boolean isRunning = false;
	
    //Port of web service
    private static final Byte DATA_PREVENT = 1;
    private static final Byte TRANSACTION_PROPERTY = 2;
    private static final Byte ANNOUNCEMENT = 3;
    
    private static final Byte ACTION_ADD = 1;
    private static final Byte ACTION_EDIT = 2;
    private static final Byte ACTION_DELETE = 3;
    private static final Byte ACTION_RELEASE = 4;
    private static final Byte FIRST_SYNCHRONIZE = 5;
    
    private static final Byte STATUS_SYNCHRONIZE = 0;
    //private static final Byte STATUS_ERROR = 1;
    
    private static final String PREVENT_UPLOAD_FOLDER_KEY = "system_prevent_data_folder";
    private static final String ANNOUNCEMENT_UPLOAD_FOLDER_KEY = "system_announcement_folder";
    private static final String PREVENT_FILE_NAME_PREFIX = "PRV_";
    private static final String ANNOUNCEMENT_FILE_NAME_PREFIX = "ANNT_";
    
    private static final String ORDER_FIELD = "entry_date_time";
    
    private static final String ENGINE = "engine";
    
    //default record per synchronize
    private String synchronizeUrl;
    private Integer synchronizeRecord = 100;
	
	/** Connection */
    private Connection connection = null;


    /** DB Connection */
    private DBConnection dbConnection = null;
    
    //Npo Service
    private NpoWSServiceLocator service;
    
    /** Logger */
    public static NpoLogger logger = (NpoLogger) NpoLogger
    	.getLogger(SynchronizeDBEngine.class.getName());
    
    
    /**
	 * The constructor could be made private to prevent others from
	 * instantiating this class. But this would also make it impossible to
	 * create instances of Singleton subclasses.
	 */
	protected SynchronizeDBEngine() {
		// ...
	}
	
	/**
	 * @return The unique instance of this class.
	 */
	static public SynchronizeDBEngine instance() {
		if (null == _instance) {
			_instance = new SynchronizeDBEngine();
		}
		return _instance;
	}
    
    @SuppressWarnings("unchecked")
    public void synchronizeData() {
    	
    	if (isRunning) {
			return;
		}
    	
    	NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB9001");
        
        try {
        	isRunning = true;
        	
        	WebserviceInfo clientInfo = new WebserviceInfo();
        	
            /** Connect to DB */
            this.dbConnection = new DBConnection("jdbc/datasource");
            this.connection = dbConnection.openConnection();
            
            CommonService commonService = new CommonService(connection);
            SynchronizeWsService synchronizeService = new SynchronizeWsService(connection);
            PreventWsService preventService = new PreventWsService(connection);
            AnnouncementWsService announcementService = new AnnouncementWsService(connection);
            
            synchronizeUrl = commonService.querySystemConfigByKey("synchronize_webservice_url", Boolean.FALSE).getConfigValue();
            if (!EditString.isNull(synchronizeUrl)) {
            	
	            //get client data for synchronize
	            List<ContentInfo> contentList = new ArrayList<ContentInfo>();
	            
	            synchronizeService.addOrderField(new OrderField(ORDER_FIELD));
	            synchronizeService.setAuthenticationIdFilter(InitSystemPlugin.getAuthenticationId());
	            
	            String record = "";
	            SystemConfigInfo systemConfigInfo = commonService.querySystemConfigByKey("synchronize_record", Boolean.FALSE);
	            if (systemConfigInfo != null) {
	                record = systemConfigInfo.getConfigValue();
	            }
	            
	            List<SynchronizeWsInfo> synchronizeList = new ArrayList<SynchronizeWsInfo>();
	            if (!EditString.isNull(record) && EditString.isNumber(record)) {
	                synchronizeRecord = Integer.parseInt(record);
	                synchronizeList = synchronizeService.querySynchronize(Boolean.FALSE, 1, synchronizeRecord).getList();
	            }
	            
	            for (SynchronizeWsInfo synchronizeInfo : synchronizeList) {
	                
	                try {
	                    File clientAttackFile = null;
	                    File clientReleaseFile = null;
	                    
	                    ContentInfo contentInfo = new ContentInfo();
	                    contentInfo.setSynchronizeWsInfo(synchronizeInfo);
	                    
	                    boolean dataNotExist = false;
	                    
	                    if (DATA_PREVENT.equals(synchronizeInfo.getType())) {
	                        preventService.setPreventSynchronizeIdFilter(synchronizeInfo.getDataId());
	                        DataPreventWsList dataPreventList = preventService.queryAllDataPreventWS(Boolean.FALSE);
	                        if (dataPreventList.size() > 0) {
	                            DataPreventWsInfo dataPreventWsInfo = dataPreventList.get(0);                        
	                            if (dataPreventList.get(0).getPropertyId() != null) {
	                                preventService.setPropertyPreventIdFilter(dataPreventWsInfo.getPropertyId());
	                                PropertyPreventWsList propertyPreventList = preventService.queryAllPropertyPreventWS(Boolean.FALSE);
	                                if (propertyPreventList.size() > 0) {                                
	                                    contentInfo.setPropertyPreventWsInfo(propertyPreventList.get(0));
	                                    dataPreventWsInfo.setPropertyId(null);
	                                    contentInfo.setDataPreventWsInfo(dataPreventWsInfo);
	                                    contentList.add(contentInfo);
	                                    if (!EditString.isNull(dataPreventWsInfo.getPreventFileName()) && dataPreventWsInfo.getPreventFilePath() != null) {
	                                        try {
	                                            clientAttackFile = new File(dataPreventWsInfo.getPreventFilePath());
	                                        } catch (Exception exception) {
	                                            logger.logging(logMessage, exception);
	                                        }
	                                    }
	                                    if (!EditString.isNull(dataPreventWsInfo.getReleaseFileName()) && dataPreventWsInfo.getReleaseFilePath() != null) {
	                                        try {
	                                            clientReleaseFile = new File(dataPreventWsInfo.getReleaseFilePath());
	                                        } catch (Exception exception) {
	                                            logger.logging(logMessage, exception);
	                                        }
	                                    }
	                                }
	                            }
	                        } else {
	                        	dataNotExist = true;
	                        }
	                        
	                    }
	                    
	                    if (TRANSACTION_PROPERTY.equals(synchronizeInfo.getType())) {
	                        if (!ACTION_DELETE.equals(synchronizeInfo.getAction())) {
	                            preventService.setPropertySynchronizeIdFilter(synchronizeInfo.getDataId());
	                            TransactionPropertyWsList transactionPropertyList = preventService.queryAllTransactionPropertyWS(Boolean.FALSE);
	                            if (transactionPropertyList.size() > 0) {
	                                contentInfo.setTransactionPropertyWsInfo(transactionPropertyList.get(0));
	                                contentList.add(contentInfo);
	                            } else {
	                            	dataNotExist = true;
	                            }
	                        } else {
	                        	contentList.add(contentInfo);
	                        }
	                    }
	                    
//	                    if (ANNOUNCEMENT.equals(synchronizeInfo.getType())) {
//	                        if (!ACTION_DELETE.equals(synchronizeInfo.getAction())) {
//	                            announcementService.setSynchronizeIdFilter(synchronizeInfo.getDataId());
//	                            AnnouncementWsList announcementList = announcementService.queryAllAnnouncementWS(Boolean.FALSE);
//	                            if (announcementList.size() > 0) {
//	                                contentInfo.setAnnouncementWsInfo(announcementList.get(0));
//	                                if (!EditString.isNull(announcementList.get(0).getAttachFileName())
//	                                        && announcementList.get(0).getAttachFilePath() != null) {
//	                                    try {
//	                                        clientAttackFile = new File(announcementList.get(0).getAttachFilePath());
//	                                    } catch (Exception exception) {
//	                                        logger.logging(logMessage, exception);
//	                                    }
//	                                }
//	                            }
//	                        }
//	                        contentList.add(contentInfo);
//	                    }
	                    
	                    int len;
	                    int size = 1024;
	                    if (clientAttackFile != null && clientAttackFile.exists() && clientAttackFile.canRead()) {
	                        InputStream in1 = new FileInputStream(clientAttackFile);
	                        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
	                        byte[] buf1 = new byte[size];
	                        while ((len = in1.read(buf1, 0, size)) != -1) {
	                            out1.write(buf1, 0, len);
	                        }
	                        contentInfo.setFileAttachment(out1.toByteArray());
	    
	                    }
	                    if (clientReleaseFile != null && clientReleaseFile.exists() && clientReleaseFile.canRead()) {
	                        InputStream in2 = new FileInputStream(clientReleaseFile);
	                        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
	                        byte[] buf2 = new byte[size];
	                        while ((len = in2.read(buf2, 0, size)) != -1) {
	                            out2.write(buf2, 0, len);
	                        }
	                        contentInfo.setReleaseFile(out2.toByteArray());
	    
	                    }
	                    
	                    if (dataNotExist) {
	                    	//Xoa ban ghi khong ton tai
	                    	synchronizeService.removeSynchByDataId(synchronizeInfo.getDataId());
	                    } else {
		                    //update status npo_synchronize when client call service
		                    synchronizeInfo.setStatus(STATUS_SYNCHRONIZE);
		                    synchronizeService.modifySynchronize(synchronizeInfo);
	                    }
	                    connection.commit();
	                } catch (SQLException sqlError) {
	                    /** Write log */
	                    logger.logging(logMessage, sqlError);
	
	                } catch (Exception exception) {
	                    /** Write log */
	                    logger.logging(logMessage, exception);
	                } finally {
	
	                    try {
	                        if (connection != null) {
	                            /** Rollback connection */
	                            connection.rollback();
	                        }
	                    } catch (Exception ex) {
	                        logger.logging(logMessage, ex);
	                    }
	                }
	            }
	            
	            clientInfo.setContentInfoList(contentList.toArray(new ContentInfo[contentList.size()]));
	            clientInfo.setAuthenticationId(InitSystemPlugin.getAuthenticationId());
	            clientInfo.setAuthenticationCode(InitSystemPlugin.getAuthenticationCode());
	            
	            systemConfigInfo = commonService.querySystemConfigByKey("synchronize_account", Boolean.FALSE);
	            if (systemConfigInfo != null) {
	                clientInfo.setAccount(systemConfigInfo.getConfigValue());
	            }
	            
	            systemConfigInfo = commonService.querySystemConfigByKey("synchronize_password", Boolean.FALSE);
	            if (systemConfigInfo != null) {
	                clientInfo.setPassword(systemConfigInfo.getConfigValue());
	            }
	            
	            //Call web service synchronize database
	            service = new NpoWSServiceLocator();
	            NpoWS port = null;
	            
	            try {
	            	port = service.getNpoWSPort(new URL(synchronizeUrl));
	            } catch (ServiceException ex) {
	            	
	            	String error = "Error: " + ex.getMessage();
	            	if (error.length() > 100) {
	            		error = error.substring(0, 100);
	            	}
	            	
	            	//Cap nhat ket noi that bai
	                SystemConfigInfo scInfo = commonService.querySystemConfigByKey("synchronize_connection_status", Boolean.FALSE);
	                if (scInfo == null) {
	                	scInfo = new SystemConfigInfo();
	                	scInfo.setConfigKey("synchronize_connection_status");
	                	scInfo.setConfigValue(error);
	                	scInfo.setEntryDateTime(RelateDateTime.getTimeNow());
	                	scInfo.setEntryUserName(ENGINE);
	                	scInfo.setUpdateDateTime(RelateDateTime.getTimeNow());
	                	scInfo.setUpdateUserName(ENGINE);
	                	
	                	commonService.entrySystemConfig(scInfo);
	                } else {
	                	scInfo.setConfigValue(error);
	                	scInfo.setUpdateDateTime(RelateDateTime.getTimeNow());
	                	scInfo.setUpdateUserName(ENGINE);
	                	
	                	commonService.modifySystemConfig(scInfo);
	                }
	                
	                connection.commit();
	                
	            	/** Write log */
	                logger.logging(logMessage, ex);
	            }
	            
	            if (port != null) {
	                
	                WebserviceInfo serverInfo = port.synchronizeDB(clientInfo);
	                List<String> dataIdList = new ArrayList<String>();
	                
	                //remove record in synchronize table which synchronize successfully
	                if (serverInfo.getDataIdList() != null && serverInfo.getDataIdList().length > 0) {
	//                    for (int i = 0; i < serverInfo.getDataIdList().length; i++) {
	//                        synchronizeService.removeSynchronize(serverInfo.getDataIdList()[i]);
	//                        connection.commit();
	//                    }
	                	
	                	//Toi uu code (HaiNT 2011.03.18)
	                	synchronizeService.removeSynchronize(serverInfo.getDataIdList());
	                	connection.commit();
	                }
	                
	                //change status record in synchronize table to error if synchronize error
	//                synchronizeService.setAuthenticationIdFilter(null);
	//                synchronizeService.setStatusFilter(STATUS_SYNCHRONIZE);
	//                List<SynchronizeWsInfo> list = synchronizeService.queryAllSynchronize(Boolean.FALSE).getList();
	//                for (SynchronizeWsInfo info : list) {
	//                    info.setStatus(STATUS_ERROR);
	//                    synchronizeService.modifySynchronize(info);
	//                    connection.commit();
	//                }
	                
	                //Toi uu code (HaiNT 2011.03.18)
	                if (synchronizeService.changeErrorStatus() > 0) {
	                	connection.commit();
	                }
	                
	                boolean isClientProcess = false;
	                
	                //Dong bo qua file
	                if (serverInfo.getTpAddNewFile() != null) {
	                	InputStream tpAddNewFile = new ByteArrayInputStream(serverInfo.getTpAddNewFile());
	                	dataIdList.addAll(TransactionBatchSynchronize.process(connection, tpAddNewFile, 
	                			TransactionBatchSynchronize.ACTION_ADD));
	                	isClientProcess = true;
	                }
	                
					if (serverInfo.getTpFirstSynFile() != null) {
						InputStream tpFirstSynFile = new ByteArrayInputStream(serverInfo.getTpFirstSynFile());
	                	dataIdList.addAll(TransactionBatchSynchronize.process(connection, tpFirstSynFile, 
	                			TransactionBatchSynchronize.ACTION_ADD));
	                	isClientProcess = true;
					}
					
					if (serverInfo.getTpUpdateFile() != null) {
						InputStream tpUpdateFile = new ByteArrayInputStream(serverInfo.getTpUpdateFile());
	                	dataIdList.addAll(TransactionBatchSynchronize.process(connection, tpUpdateFile, 
	                			TransactionBatchSynchronize.ACTION_ADD));
	                	isClientProcess = true;
					}
	                
	                //synchronize data which server response
	                if (serverInfo.getContentInfoList() != null) {
	                	isClientProcess = true;
	                	
	                    for (ContentInfo contentInfo : serverInfo.getContentInfoList()) {
	                        
	                        try {
	                            File serverAttackFile = null;
	                            File serverReleaseFile = null;
	                            
	                            //synchronize data prevent
	                            if (contentInfo.getDataPreventWsInfo() != null && contentInfo.getPropertyPreventWsInfo() != null
	                                    && DATA_PREVENT.equals(contentInfo.getSynchronizeWsInfo().getType()) ) {
	                                
	                                if (contentInfo.getFileAttachment() != null) {
	                                    serverAttackFile = FileUtil.createNewFile(
	                                            SystemProperties.getProperty(PREVENT_UPLOAD_FOLDER_KEY), PREVENT_FILE_NAME_PREFIX);
	                                    try {
	                                        FileOutputStream outputStream = new FileOutputStream(serverAttackFile);
	                                        outputStream.write(contentInfo.getFileAttachment());
	                                        outputStream.close();
	                                        
	                                    } catch (IOException exception) {
	                                        logger.logging(logMessage, exception);
	                                    }
	                                }
	                                
	                                if (contentInfo.getReleaseFile() != null) {
	                                    serverReleaseFile = FileUtil.createNewFile(
	                                            SystemProperties.getProperty(PREVENT_UPLOAD_FOLDER_KEY), PREVENT_FILE_NAME_PREFIX);
	                                    try {
	                                        FileOutputStream outputStream = new FileOutputStream(serverReleaseFile);
	                                        outputStream.write(contentInfo.getReleaseFile());
	                                        outputStream.close();
	                                        
	                                    } catch (IOException exception) {
	                                        logger.logging(logMessage, exception);
	                                    }
	                                }
	                                
	                                DataPreventHistoryWsInfo dataPreventHistoryWsInfo = contentInfo.getDataPreventHistoryWsInfo();
	                              
	                                if (dataPreventHistoryWsInfo != null && ACTION_ADD.equals(contentInfo.getSynchronizeWsInfo().getAction())) {
	                                    PropertyPreventWsInfo propertyPreventInfo = contentInfo.getPropertyPreventWsInfo();
	                                    if (propertyPreventInfo != null) {
	                                        preventService.entryPropertyPrevent(propertyPreventInfo);
	                                    }
	                                  
	                                    DataPreventWsInfo dataPreventInfo = contentInfo.getDataPreventWsInfo();
	                                    dataPreventInfo.setPropertyId(propertyPreventInfo.getId());
	                                    if (!EditString.isNull(dataPreventInfo.getPreventFileName()) && serverAttackFile != null) {
	                                        dataPreventInfo.setPreventFilePath(serverAttackFile.getAbsolutePath());
	                                    }
	                                    if (!EditString.isNull(dataPreventInfo.getReleaseFileName()) && serverReleaseFile != null) {
	                                        dataPreventInfo.setReleaseFilePath(serverReleaseFile.getAbsolutePath());
	                                    }
	                                    
	                                    createEntryUserInfo(dataPreventInfo);
	                                    
	                                    //For lucence search
	                                    dataPreventInfo.setPropertyInfo(propertyPreventInfo.getPropertyInfo());
	                                    dataPreventInfo.setType(propertyPreventInfo.getType());
	                                    dataPreventInfo.setOwnerInfo(propertyPreventInfo.getOwnerInfo());
	                                    dataPreventInfo.setOtherInfo(propertyPreventInfo.getOtherInfo());
	                                    
	                                    preventService.entryDataPrevent(dataPreventInfo);
	                                  
	                                    dataPreventHistoryWsInfo.setPreventId(dataPreventInfo.getId());
	                                  
	                                    preventService.entryDataPreventHistoryWs(dataPreventHistoryWsInfo);
	                                    
	                                }
	                                if (dataPreventHistoryWsInfo != null && ACTION_EDIT.equals(contentInfo.getSynchronizeWsInfo().getAction())) {
	                                    preventService.setPreventSynchronizeIdFilter(contentInfo.getDataPreventWsInfo().getSynchronizeId());
	                                    DataPreventWsList dataPreventList = preventService.queryAllDataPrevent(Boolean.FALSE);
	                                    if (dataPreventList.size() > 0) {
	                                        DataPreventWsInfo dataPreventWsInfo = contentInfo.getDataPreventWsInfo();
	                                        dataPreventWsInfo.setId(dataPreventList.get(0).getId());
	                                        if (!EditString.isNull(dataPreventWsInfo.getPreventFileName()) && serverAttackFile != null) {
	                                            dataPreventWsInfo.setPreventFilePath(serverAttackFile.getAbsolutePath());
	                                        }
	                                        if (!EditString.isNull(dataPreventWsInfo.getReleaseFileName()) && serverReleaseFile != null) {
	                                            dataPreventWsInfo.setReleaseFilePath(serverReleaseFile.getAbsolutePath());
	                                        }
	                                        
	                                        PropertyPreventWsInfo propertyPreventWsInfo = contentInfo.getPropertyPreventWsInfo();
	                                        propertyPreventWsInfo.setId(dataPreventList.get(0).getPropertyId());
	                                        preventService.modifyPropertyPrevent(propertyPreventWsInfo);
	                                        
	                                        createUpdateUserInfo(dataPreventWsInfo);
	                                        
	                                        //For lucence search
	                                        dataPreventWsInfo.setPropertyInfo(propertyPreventWsInfo.getPropertyInfo());
	                                        dataPreventWsInfo.setType(propertyPreventWsInfo.getType());
	                                        dataPreventWsInfo.setOwnerInfo(propertyPreventWsInfo.getOwnerInfo());
	                                        dataPreventWsInfo.setOtherInfo(propertyPreventWsInfo.getOtherInfo());
	                                        
	                                        preventService.modifyDataPrevent(dataPreventWsInfo);
	                                        
	                                        dataPreventHistoryWsInfo.setPreventId(dataPreventList.get(0).getId());
	                                      
	                                        preventService.entryDataPreventHistoryWs(dataPreventHistoryWsInfo);
	                                    }
	                                }
	                                if (dataPreventHistoryWsInfo != null && ACTION_DELETE.equals(contentInfo.getSynchronizeWsInfo().getAction())) {
	                                    preventService.setPreventSynchronizeIdFilter(contentInfo.getDataPreventWsInfo().getSynchronizeId());
	                                    DataPreventWsList dataPreventList = preventService.queryAllDataPrevent(Boolean.FALSE);
	                                    if (dataPreventList.size() > 0) {
	                                        DataPreventWsInfo dataPreventWsInfo = contentInfo.getDataPreventWsInfo();
	                                        dataPreventWsInfo.setId(dataPreventList.get(0).getId());
	                                        if (!EditString.isNull(dataPreventWsInfo.getPreventFileName()) && serverAttackFile != null) {
	                                            dataPreventWsInfo.setPreventFilePath(serverAttackFile.getAbsolutePath());
	                                        }
	                                        if (!EditString.isNull(dataPreventWsInfo.getReleaseFileName()) && serverReleaseFile != null) {
	                                            dataPreventWsInfo.setReleaseFilePath(serverReleaseFile.getAbsolutePath());
	                                        }
	                                        
	                                        PropertyPreventWsInfo propertyPreventWsInfo = contentInfo.getPropertyPreventWsInfo();
	                                        propertyPreventWsInfo.setId(dataPreventList.get(0).getPropertyId());
	                                        preventService.modifyPropertyPrevent(propertyPreventWsInfo);
	                                        
	                                        createUpdateUserInfo(dataPreventWsInfo);
	                                        //For lucence search
	                                        dataPreventWsInfo.setPropertyInfo(propertyPreventWsInfo.getPropertyInfo());
	                                        dataPreventWsInfo.setType(propertyPreventWsInfo.getType());
	                                        dataPreventWsInfo.setOwnerInfo(propertyPreventWsInfo.getOwnerInfo());
	                                        dataPreventWsInfo.setOtherInfo(propertyPreventWsInfo.getOtherInfo());
	                                        
	                                        preventService.modifyDataPrevent(dataPreventWsInfo);
	                                        
	                                        dataPreventHistoryWsInfo.setPreventId(dataPreventList.get(0).getId());
	                                        preventService.entryDataPreventHistoryWs(dataPreventHistoryWsInfo);
	                                    }
	                                }
	                                if (dataPreventHistoryWsInfo != null && ACTION_RELEASE.equals(contentInfo.getSynchronizeWsInfo().getAction())) {
	                                    preventService.setPreventSynchronizeIdFilter(contentInfo.getDataPreventWsInfo().getSynchronizeId());
	                                    DataPreventWsList dataPreventList = preventService.queryAllDataPrevent(Boolean.FALSE);
	                                    if (dataPreventList.size() > 0) {
	                                        DataPreventWsInfo dataPreventWsInfo = contentInfo.getDataPreventWsInfo();
	                                        dataPreventWsInfo.setId(dataPreventList.get(0).getId());
	                                        if (!EditString.isNull(dataPreventWsInfo.getPreventFileName()) && serverAttackFile != null) {
	                                            dataPreventWsInfo.setPreventFilePath(serverAttackFile.getAbsolutePath());
	                                        }
	                                        if (!EditString.isNull(dataPreventWsInfo.getReleaseFileName()) && serverReleaseFile != null) {
	                                            dataPreventWsInfo.setReleaseFilePath(serverReleaseFile.getAbsolutePath());
	                                        }
	                                        
	                                        PropertyPreventWsInfo propertyPreventWsInfo = contentInfo.getPropertyPreventWsInfo();
	                                        propertyPreventWsInfo.setId(dataPreventList.get(0).getPropertyId());
	                                        preventService.modifyPropertyPrevent(propertyPreventWsInfo);
	                                        
	                                        createUpdateUserInfo(dataPreventWsInfo);
	                                        //For lucence search
	                                        dataPreventWsInfo.setPropertyInfo(propertyPreventWsInfo.getPropertyInfo());
	                                        dataPreventWsInfo.setType(propertyPreventWsInfo.getType());
	                                        dataPreventWsInfo.setOwnerInfo(propertyPreventWsInfo.getOwnerInfo());
	                                        dataPreventWsInfo.setOtherInfo(propertyPreventWsInfo.getOtherInfo());
	                                        
	                                        preventService.modifyDataPrevent(dataPreventWsInfo);
	                                        
	                                        dataPreventHistoryWsInfo.setPreventId(dataPreventList.get(0).getId());
	                                      
	                                        preventService.entryDataPreventHistoryWs(dataPreventHistoryWsInfo);
	                                    }
	                                }
	                                if (FIRST_SYNCHRONIZE.equals(contentInfo.getSynchronizeWsInfo().getAction())) {
	                                    preventService.setPreventSynchronizeIdFilter(contentInfo.getDataPreventWsInfo().getSynchronizeId());
	                                    DataPreventWsList dataPreventList = preventService.queryAllDataPrevent(Boolean.FALSE);
	                                    if (dataPreventList.size() > 0) {
	                                        DataPreventWsInfo dataPreventWsInfo = contentInfo.getDataPreventWsInfo();
	                                        dataPreventWsInfo.setId(dataPreventList.get(0).getId());
	                                        if (!EditString.isNull(dataPreventWsInfo.getPreventFileName()) && serverAttackFile != null) {
	                                            dataPreventWsInfo.setPreventFilePath(serverAttackFile.getAbsolutePath());
	                                        }
	                                        if (!EditString.isNull(dataPreventWsInfo.getReleaseFileName()) && serverReleaseFile != null) {
	                                            dataPreventWsInfo.setReleaseFilePath(serverReleaseFile.getAbsolutePath());
	                                        }
	                                        
	                                        PropertyPreventWsInfo propertyPreventWsInfo = contentInfo.getPropertyPreventWsInfo();
	                                        propertyPreventWsInfo.setId(dataPreventList.get(0).getPropertyId());
	                                        preventService.modifyPropertyPrevent(propertyPreventWsInfo);
	                                        
	                                        createUpdateUserInfo(dataPreventWsInfo);
	                                        //For lucence search
	                                        dataPreventWsInfo.setPropertyInfo(propertyPreventWsInfo.getPropertyInfo());
	                                        dataPreventWsInfo.setType(propertyPreventWsInfo.getType());
	                                        dataPreventWsInfo.setOwnerInfo(propertyPreventWsInfo.getOwnerInfo());
	                                        dataPreventWsInfo.setOtherInfo(propertyPreventWsInfo.getOtherInfo());
	                                        
	                                        preventService.modifyDataPrevent(dataPreventWsInfo);
	                                        
	                                        dataPreventHistoryWsInfo = new DataPreventHistoryWsInfo();
	                                        dataPreventHistoryWsInfo.setPreventId(dataPreventList.get(0).getId());
	                                        dataPreventHistoryWsInfo.setEntryDateTime(Calendar.getInstance());
	                                        dataPreventHistoryWsInfo.setExecuteContent(
	                                                SystemMessageProperties.getSystemProperty("item_synchronize_from_server"));
	                                      
	                                        preventService.entryDataPreventHistoryWs(dataPreventHistoryWsInfo);
	                                        
	                                    } else {
	                                        PropertyPreventWsInfo propertyPreventInfo = contentInfo.getPropertyPreventWsInfo();
	                                        if (propertyPreventInfo != null) {
	                                            preventService.entryPropertyPrevent(propertyPreventInfo);
	                                        }
	                                      
	                                        DataPreventWsInfo dataPreventInfo = contentInfo.getDataPreventWsInfo();
	                                        dataPreventInfo.setPropertyId(propertyPreventInfo.getId());
	                                        if (!EditString.isNull(dataPreventInfo.getPreventFileName()) && serverAttackFile != null) {
	                                            dataPreventInfo.setPreventFilePath(serverAttackFile.getAbsolutePath());
	                                        }
	                                        if (!EditString.isNull(dataPreventInfo.getReleaseFileName()) && serverReleaseFile != null) {
	                                            dataPreventInfo.setReleaseFilePath(serverReleaseFile.getAbsolutePath());
	                                        }
	                                        
	                                        createEntryUserInfo(dataPreventInfo);
	                                        //For lucence search
	                                        dataPreventInfo.setPropertyInfo(propertyPreventInfo.getPropertyInfo());
	                                        dataPreventInfo.setType(propertyPreventInfo.getType());
	                                        dataPreventInfo.setOwnerInfo(propertyPreventInfo.getOwnerInfo());
	                                        dataPreventInfo.setOtherInfo(propertyPreventInfo.getOtherInfo());
	                                        
	                                        preventService.entryDataPrevent(dataPreventInfo);
	                                      
	                                        dataPreventHistoryWsInfo.setPreventId(dataPreventInfo.getId());
	                                      
	                                        preventService.entryDataPreventHistoryWs(dataPreventHistoryWsInfo);
	                                    }
	                                }
	                            }
	                          
	                            //synchronize transaction property
	                            if (TRANSACTION_PROPERTY.equals(contentInfo.getSynchronizeWsInfo().getType()) ) {
	                              
	                                if (contentInfo.getTransactionPropertyWsInfo() != null 
	                                        && ACTION_ADD.equals(contentInfo.getSynchronizeWsInfo().getAction())) {
	                                	
	                                	createEntryUserInfo(contentInfo.getTransactionPropertyWsInfo());
	                                    preventService.entryTransactionProperty(contentInfo.getTransactionPropertyWsInfo());
	                                }
	                                if (contentInfo.getTransactionPropertyWsInfo() != null 
	                                        && ACTION_EDIT.equals(contentInfo.getSynchronizeWsInfo().getAction())) {
	                                    preventService.setPropertySynchronizeIdFilter(contentInfo.getTransactionPropertyWsInfo().getSynchronizeId());
	                                    TransactionPropertyWsList transactionPropertyList = preventService.queryAllTransactionProperty(Boolean.FALSE);
	                                    if (transactionPropertyList.size() > 0) {
	                                        TransactionPropertyWsInfo transactionPropertyInfo = contentInfo.getTransactionPropertyWsInfo();
	                                        transactionPropertyInfo.setTpid(transactionPropertyList.get(0).getTpid());
	                                        
	                                        createUpdateUserInfo(contentInfo.getTransactionPropertyWsInfo());
	                                        preventService.modifyTransactionProperty(transactionPropertyInfo);
	                                    }
	                                }
	                                if (ACTION_DELETE.equals(contentInfo.getSynchronizeWsInfo().getAction())) {
	                                    preventService.setPropertySynchronizeIdFilter(contentInfo.getSynchronizeWsInfo().getDataId());
	                                    TransactionPropertyWsList transactionPropertyList = preventService.queryAllTransactionProperty(Boolean.FALSE);
	                                    if (transactionPropertyList.size() > 0) {
	                                        preventService.removeTransactionProperty(transactionPropertyList.get(0).getTpid());
	                                    }
	                                }
	                                if (FIRST_SYNCHRONIZE.equals(contentInfo.getSynchronizeWsInfo().getAction())) {
	                                    preventService.setPropertySynchronizeIdFilter(contentInfo.getTransactionPropertyWsInfo().getSynchronizeId());
	                                    TransactionPropertyWsList transactionPropertyList = preventService.queryAllTransactionProperty(Boolean.FALSE);
	                                    if (transactionPropertyList.size() > 0) {
	                                        TransactionPropertyWsInfo transactionPropertyInfo = contentInfo.getTransactionPropertyWsInfo();
	                                        transactionPropertyInfo.setTpid(transactionPropertyList.get(0).getTpid());
	                                        
	                                        createUpdateUserInfo(contentInfo.getTransactionPropertyWsInfo());
	                                        preventService.modifyTransactionProperty(transactionPropertyInfo);
	                                    } else {
	                                    	createEntryUserInfo(contentInfo.getTransactionPropertyWsInfo());
	                                        preventService.entryTransactionProperty(contentInfo.getTransactionPropertyWsInfo());
	                                    }
	                                }
	                            }
	                          
	                            //synchronize announcement
	                            if (ANNOUNCEMENT.equals(contentInfo.getSynchronizeWsInfo().getType()) ) {
	                                
	                                if (contentInfo.getFileAttachment() != null) {
	                                    serverAttackFile = FileUtil.createNewFile(
	                                            SystemProperties.getProperty(ANNOUNCEMENT_UPLOAD_FOLDER_KEY), ANNOUNCEMENT_FILE_NAME_PREFIX);
	                                    try {
	                                        FileOutputStream outputStream = new FileOutputStream(serverAttackFile);
	                                        outputStream.write(contentInfo.getFileAttachment());
	                                        outputStream.close();
	                                        
	                                    } catch (IOException exception) {
	                                        logger.logging(logMessage, exception);
	                                    }
	                                }
	                                
	                                if (contentInfo.getAnnouncementWsInfo() != null && ACTION_ADD.equals(contentInfo.getSynchronizeWsInfo().getAction())) {
	                                    AnnouncementWsInfo announcementWsInfo = contentInfo.getAnnouncementWsInfo();
	                                    if (!EditString.isNull(announcementWsInfo.getAttachFileName()) && serverAttackFile != null) {
	                                        announcementWsInfo.setAttachFilePath(serverAttackFile.getAbsolutePath());
	                                    }
	                                    createEntryUserInfo(announcementWsInfo);
	                                    announcementService.entryAnnouncement(announcementWsInfo);
	                                }
	                                if (contentInfo.getAnnouncementWsInfo() != null && ACTION_EDIT.equals(contentInfo.getSynchronizeWsInfo().getAction())) {
	                                    announcementService.setSynchronizeIdFilter(contentInfo.getAnnouncementWsInfo().getSynchronizeId());
	                                    AnnouncementWsList announcementList = announcementService.queryAllAnnouncement(Boolean.FALSE);
	                                    if (announcementList.size() > 0) {
	                                        AnnouncementWsInfo announcementWsInfo = contentInfo.getAnnouncementWsInfo();
	                                        announcementWsInfo.setAid(announcementList.get(0).getAid());
	                                        if (!EditString.isNull(announcementWsInfo.getAttachFileName()) && serverAttackFile != null) {
	                                            announcementWsInfo.setAttachFilePath(serverAttackFile.getAbsolutePath());
	                                        }
	                                        
	                                        createUpdateUserInfo(announcementWsInfo);
	                                        announcementService.modifyAnnouncement(announcementWsInfo);
	                                    }
	                                }
	                                if (ACTION_DELETE.equals(contentInfo.getSynchronizeWsInfo().getAction())) {
	                                    announcementService.setSynchronizeIdFilter(contentInfo.getSynchronizeWsInfo().getDataId());
	                                    AnnouncementWsList announcementList = announcementService.queryAllAnnouncement(Boolean.FALSE);
	                                    if (announcementList.size() > 0) {
	                                        AnnouncementWsInfo announcementWsInfo = announcementList.get(0);
	                                        if (!EditString.isNull(announcementWsInfo.getAttachFileName())
	                                                && !EditString.isNull(announcementWsInfo.getAttachFilePath())) {
	                                            File removeFile = new File(announcementWsInfo.getAttachFilePath());
	                                            removeFile.delete();
	                                        }
	                                        announcementService.removeAnnouncement(announcementList.get(0).getAid());
	                                    }
	                                }
	                                if (FIRST_SYNCHRONIZE.equals(contentInfo.getSynchronizeWsInfo().getAction())) {
	                                    announcementService.setSynchronizeIdFilter(contentInfo.getAnnouncementWsInfo().getSynchronizeId());
	                                    AnnouncementWsList announcementList = announcementService.queryAllAnnouncement(Boolean.FALSE);
	                                    if (announcementList.size() > 0) {
	                                        AnnouncementWsInfo announcementWsInfo = contentInfo.getAnnouncementWsInfo();
	                                        announcementWsInfo.setAid(announcementList.get(0).getAid());
	                                        if (!EditString.isNull(announcementWsInfo.getAttachFileName()) && serverAttackFile != null) {
	                                            announcementWsInfo.setAttachFilePath(serverAttackFile.getAbsolutePath());
	                                        }
	                                        
	                                        createUpdateUserInfo(announcementWsInfo);
	                                        announcementService.modifyAnnouncement(announcementWsInfo);
	                                    } else {
	                                        AnnouncementWsInfo announcementWsInfo = contentInfo.getAnnouncementWsInfo();
	                                        if (!EditString.isNull(announcementWsInfo.getAttachFileName()) && serverAttackFile != null) {
	                                            announcementWsInfo.setAttachFilePath(serverAttackFile.getAbsolutePath());
	                                        }
	                                        
	                                        createEntryUserInfo(announcementWsInfo);
	                                        announcementService.entryAnnouncement(announcementWsInfo);
	                                    }
	                                }
	                            }
	                            
	                            connection.commit();
	                            dataIdList.add(contentInfo.getSynchronizeWsInfo().getDataId());
	                        } catch (SQLException sqlError) {
	                            /** Write log */
	                            logger.logging(logMessage, sqlError);
	                            continue;
	
	                        } catch (Exception exception) {
	                            /** Write log */
	                            logger.logging(logMessage, exception);
	                            continue;
	                        } finally {
	
	                            try {
	                                if (connection != null) {
	                                    /** Rollback connection */
	                                    connection.rollback();
	                                }
	                            } catch (Exception ex) {
	                                logger.logging(logMessage, ex);
	                            }
	                        }
	                    }
	                    
	                }
	                
	                if (isClientProcess) {
	                	//Call service update status in npo_synchronize for server
	                    WebserviceInfo info = new WebserviceInfo();
	                    info.setDataIdList(dataIdList.toArray(new String[dataIdList.size()]));
	                    info.setAuthenticationId(InitSystemPlugin.getAuthenticationId());
	                    info.setAuthenticationCode(InitSystemPlugin.getAuthenticationCode());
	                    info.setAccount(commonService.querySystemConfigByKey("synchronize_account", Boolean.FALSE).getConfigValue());
	                    info.setPassword(commonService.querySystemConfigByKey("synchronize_password", Boolean.FALSE).getConfigValue());
	                    port.synchronize(info);
	                }
	                
	                //Cap nhat ket noi thanh cong
	                SystemConfigInfo scInfo = commonService.querySystemConfigByKey("synchronize_connection_status", Boolean.FALSE);
	                if (scInfo == null) {
	                	scInfo = new SystemConfigInfo();
	                	scInfo.setConfigKey("synchronize_connection_status");
	                	scInfo.setConfigValue("success");
	                	scInfo.setEntryDateTime(RelateDateTime.getTimeNow());
	                	scInfo.setEntryUserName(ENGINE);
	                	scInfo.setUpdateDateTime(RelateDateTime.getTimeNow());
	                	scInfo.setUpdateUserName(ENGINE);
	                	
	                	commonService.entrySystemConfig(scInfo);
	                } else {
	                	scInfo.setConfigValue("success");
	                	scInfo.setUpdateDateTime(RelateDateTime.getTimeNow());
	                	scInfo.setUpdateUserName(ENGINE);
	                	
	                	commonService.modifySystemConfig(scInfo);
	                }
	                
	                connection.commit();
	            } else{
	            	//Cap nhat ket noi that bai
	                SystemConfigInfo scInfo = commonService.querySystemConfigByKey("synchronize_connection_status", Boolean.FALSE);
	                if (scInfo == null) {
	                	scInfo = new SystemConfigInfo();
	                	scInfo.setConfigKey("synchronize_connection_status");
	                	scInfo.setConfigValue("error");
	                	scInfo.setEntryDateTime(RelateDateTime.getTimeNow());
	                	scInfo.setEntryUserName(ENGINE);
	                	scInfo.setUpdateDateTime(RelateDateTime.getTimeNow());
	                	scInfo.setUpdateUserName(ENGINE);
	                	
	                	commonService.entrySystemConfig(scInfo);
	                } else {
	                	scInfo.setConfigValue("error");
	                	scInfo.setUpdateDateTime(RelateDateTime.getTimeNow());
	                	scInfo.setUpdateUserName(ENGINE);
	                	
	                	commonService.modifySystemConfig(scInfo);
	                }
	                
	                connection.commit();
	            }
            }
        } catch (IOException e) {
            logger.logging(logMessage, e);
            
        } catch (SQLException sqlError) {
            /** Write log */
            logger.logging(logMessage, sqlError);

        } catch (Exception exception) {
        	/** Write log */
            logger.logging(logMessage, exception);

        } finally {

            try {
                if (connection != null && !connection.isClosed() && !connection.getAutoCommit()) {
                    /** Rollback connection */
                    connection.rollback();
                }
            } catch (Exception ex) {
                logger.logging(logMessage, ex);
            } finally {
                try {
                    if (connection != null) {
                        /** Close connection */
                        connection.close();
                    }
                } catch (Exception ex) {
                    //Nothing
                }
            }
            
            isRunning = false;
        }
    }
    
    /**
     * Create entry user information
     * 
     * @param info
     */
    private void createEntryUserInfo(AbstractWsInfo info) {
    	/* Entry user */
    	info.setEntryUserName(ENGINE);
    	info.setEntryDateTime(Calendar.getInstance());
    	
    	/* Update user */
    	info.setUpdateUserName(ENGINE);
    	info.setUpdateDateTime(Calendar.getInstance());
    }
    
    /**
     * Create update user information
     * 
     * @param info
     */
    private void createUpdateUserInfo(AbstractWsInfo info) {
    	/* Update user */
    	info.setUpdateUserName(ENGINE);
    	info.setUpdateDateTime(Calendar.getInstance());
    }
}
