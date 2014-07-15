package com.osp.npo.app.engine;

import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.congdongjava.CsvReader;
import com.osp.npo.core.AbstractWsInfo;
import com.osp.npo.core.preventws.TransactionPropertyWsInfo;
import com.osp.npo.core.preventws.TransactionPropertyWsList;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;
import com.osp.npo.service.PreventWsService;

/**
 * Synchronize transaction data by batch
 * 
 * @author HaiNT
 * @version $Revision: 29785 $
 */
public class TransactionBatchSynchronize {

	public static final Integer ACTION_ADD = 1;
	public static final Integer ACTION_EDIT = 2;
	//public static final Integer ACTION_DELETE = 3;
	public static final Integer ACTION_FIRST_SYNCHRONIZE = 5;
	
	private static final String ENGINE = "engine";
	private static final String CHAR_NULL = "\\N";
	private static final Character CHAR_DELIMITER = ',';
	private static final String CHARSET = "UTF-8";
	private static final String DATE_FORMAT = "yy-MM-dd HH:mm:ss";

	//private static final String COLUMN_TPID = "tpid";
	private static final String COLUMN_SYSCHRONIZE_ID = "synchronize_id";
	private static final String COLUMN_TYPE = "type";
	private static final String COLUMN_PROPERTY_INFO = "property_info";
	private static final String COLUMN_TRANSACTION_CONTENT = "transaction_content";
	private static final String COLUMN_NOTARY_DATE = "notary_date";
	private static final String COLUMN_NOTARY_OFFICE_NAME = "notary_office_name";
	private static final String COLUMN_CONTRACT_ID = "contract_id";
	private static final String COLUMN_CONTRACT_NUMBER = "contract_number";
	private static final String COLUMN_CONTRACT_NAME = "contract_name";
	private static final String COLUMN_CONTRACT_VALUE = "contract_value";
	private static final String COLUMN_RELATION_OBJECT = "relation_object";
	private static final String COLUMN_NOTARY_PERSON = "notary_person";
	private static final String COLUMN_NOTARY_PLACE = "notary_place";
	private static final String COLUMN_NOTARY_FEE = "notary_fee";
	private static final String COLUMN_NOTE = "note";
	private static final String COLUMN_CANCEL_STATUS = "cancel_status";
	private static final String COLUMN_CANCEL_DESCRIPTTON = "cancel_description";
	private static final String COLUMN_LAND_STREET = "land_street";
	private static final String COLUMN_LAND_DISTRICT = "land_district";
	private static final String COLUMN_CONTRACT_PERIOD = "contract_period";
	private static final String COLUMN_MORTAGE_CANCEL_FLAG = "mortage_cancel_flag";
	private static final String COLUMN_MORTAGE_CANCEL_DATE = "mortage_cancel_date";
	private static final String COLUMN_MORTAGE_CANCEL_NOTE = "mortage_cancel_note";
	private static final String COLUMN_CONTRACT_KIND = "contract_kind";

	
	 /** Logger */
    public static NpoLogger logger = (NpoLogger) NpoLogger
    	.getLogger(TransactionBatchSynchronize.class.getName());
    
	/**
	 * Nhap du lieu tu file vao DB
	 * @param conn
	 * Ket noi DB
	 * @param inputStream File dau vao dang CSV
	 * @param processType Loai xu ly (1: Insert; 2: Update; 5: Insert if not exist, Update if existed)
	 * @return Danh sach synchronize_id da xu ly thanh cong
	 */
	public static List<String> process(Connection conn, InputStream inputStream,
			int processType) {

		List<String> synchronizeIdList = new ArrayList<String>();
		NpoLogMessage logMessage = new NpoLogMessage();
		try {
			PreventWsService preventService = new PreventWsService(conn);
			Charset UTF8 = Charset.forName(CHARSET);
			CsvReader docfile = new CsvReader(inputStream, CHAR_DELIMITER, UTF8);
			// Bat dau doc file CSV
			docfile.readHeaders();
			// Duyet qua tung ROW - Dong du lieu
			while (docfile.readRecord()) {
				try {
					TransactionPropertyWsInfo tranInfo = new TransactionPropertyWsInfo();
					
					//tranInfo.setTpid(Long.parseLong(docfile.get(COLUMN_TPID)));
					
					tranInfo.setSynchronizeId(docfile
							.get(COLUMN_SYSCHRONIZE_ID));
					if (docfile.get(COLUMN_TYPE).equals(CHAR_NULL)) {
						tranInfo.setType("");
					} else {
						tranInfo.setType(docfile.get(COLUMN_TYPE));
					}
					if (docfile.get(COLUMN_PROPERTY_INFO).equals(CHAR_NULL)) {
						tranInfo.setPropertyInfo("");
					} else {
						tranInfo.setPropertyInfo(docfile
								.get(COLUMN_PROPERTY_INFO));
					}
					if (docfile.get(COLUMN_TRANSACTION_CONTENT).equals(
							CHAR_NULL)) {
						tranInfo.setTransactionContent("");
					} else {
						tranInfo.setTransactionContent(docfile
								.get(COLUMN_TRANSACTION_CONTENT));
					}
					tranInfo.setNotaryDate(convertStringToCalendar(docfile
							.get(COLUMN_NOTARY_DATE)));
					tranInfo.setNotaryOfficeName(docfile
							.get(COLUMN_NOTARY_OFFICE_NAME));
					try {
						tranInfo.setContractId(Long.parseLong(docfile
								.get(COLUMN_CONTRACT_ID)));
					} catch (NumberFormatException e) {
						tranInfo.setContractId(null);
					}
					tranInfo.setContractNumber(docfile.get(COLUMN_CONTRACT_NUMBER));
					tranInfo.setContractName(docfile.get(COLUMN_CONTRACT_NAME));
					if (docfile.get(COLUMN_CONTRACT_VALUE).equals(CHAR_NULL)) {
						tranInfo.setContractValue("");
					} else {
						tranInfo.setContractValue(docfile.get(COLUMN_CONTRACT_VALUE));
					}
					if (docfile.get(COLUMN_RELATION_OBJECT).equals(CHAR_NULL)) {
						tranInfo.setRelationObject("");
					} else {
						tranInfo.setRelationObject(docfile.get(COLUMN_RELATION_OBJECT));
					}

					tranInfo.setNotaryPerson(docfile.get(COLUMN_NOTARY_PERSON));
					tranInfo.setNotaryPlace(docfile.get(COLUMN_NOTARY_PLACE));
					if (docfile.get(COLUMN_NOTARY_FEE).equals(CHAR_NULL)) {
						tranInfo.setNotaryFee(null);
					} else {
						tranInfo.setNotaryFee(docfile.get(COLUMN_NOTARY_FEE));
					}
					if (docfile.get(COLUMN_NOTE).equals(CHAR_NULL)) {
						tranInfo.setNote(null);
					} else {
						tranInfo.setNote(docfile.get(COLUMN_NOTE));
					}
					if("1".equals(docfile.get(COLUMN_CANCEL_STATUS))) {
						tranInfo.setCancelStatus(true);
					}else {
						if("0".equals(docfile.get(COLUMN_CANCEL_STATUS))){
							tranInfo.setCancelStatus(false);
						}else {
							tranInfo.setCancelStatus(null);
						}
					}
					if (docfile.get(COLUMN_CANCEL_DESCRIPTTON)
							.equals(CHAR_NULL)) {
						tranInfo.setCancelDescription(null);
					} else {
						tranInfo.setCancelDescription(docfile
								.get(COLUMN_CANCEL_DESCRIPTTON));
					}
					
					if (docfile.get(COLUMN_LAND_STREET).equals(CHAR_NULL)) {
						tranInfo.setLandStreet(null);
					} else {
						tranInfo.setLandStreet(docfile.get(COLUMN_LAND_STREET));
					}
					if (docfile.get(COLUMN_LAND_DISTRICT).equals(CHAR_NULL)) {
						tranInfo.setLandDistrict(null);
					} else {
						tranInfo.setLandDistrict(docfile
								.get(COLUMN_LAND_DISTRICT));
					}

					// thieu land_province,land_full_of_area *****
					if (docfile.get(COLUMN_CONTRACT_PERIOD).equals(CHAR_NULL)) {
						tranInfo.setContractPeriod(null);
					} else {
						tranInfo.setContractPeriod(docfile
								.get(COLUMN_CONTRACT_PERIOD));
					}
					if("1".equals(docfile.get(COLUMN_MORTAGE_CANCEL_FLAG))) {
						tranInfo.setMortageCancelFlag(true);
					}else {
						if("0".equals(docfile.get(COLUMN_MORTAGE_CANCEL_FLAG))){
							tranInfo.setMortageCancelFlag(false);
						}else {
							tranInfo.setMortageCancelFlag(null);
						}
					}
					if (docfile.get(COLUMN_MORTAGE_CANCEL_DATE).equals(
							CHAR_NULL)) {
						tranInfo.setMortageCancelDate(null);
					} else {
						tranInfo.setMortageCancelDate(docfile
								.get(COLUMN_MORTAGE_CANCEL_DATE));
					}
					if (docfile.get(COLUMN_MORTAGE_CANCEL_NOTE).equals(
							CHAR_NULL)) {
						tranInfo.setMortageCancelNote(null);
					} else {
						tranInfo.setMortageCancelNote(docfile
								.get(COLUMN_MORTAGE_CANCEL_NOTE));
					}
					if (docfile.get(COLUMN_CONTRACT_KIND).equals(CHAR_NULL)) {
						tranInfo.setContractKind(null);
					} else {
						tranInfo.setContractKind(docfile
								.get(COLUMN_CONTRACT_KIND));
					}
					
					
					// check action
					if (tranInfo != null && ACTION_ADD.equals(processType)) {

						createEntryUserInfo(tranInfo);
						preventService.entryTransactionProperty(tranInfo);
					}
					if (tranInfo != null && ACTION_EDIT.equals(processType)) {
						preventService.setPropertySynchronizeIdFilter(tranInfo
								.getSynchronizeId());
						TransactionPropertyWsList transactionPropertyList = preventService
								.queryAllTransactionProperty(Boolean.FALSE);
						if (transactionPropertyList.size() > 0) {
							tranInfo.setTpid(transactionPropertyList.get(0)
									.getTpid());

							createUpdateUserInfo(tranInfo);
							preventService.modifyTransactionProperty(tranInfo);
						}
					}
					
					if (ACTION_FIRST_SYNCHRONIZE.equals(processType)) {
						preventService.setPropertySynchronizeIdFilter(tranInfo
								.getSynchronizeId());
						TransactionPropertyWsList transactionPropertyList = preventService
								.queryAllTransactionProperty(Boolean.FALSE);
						if (transactionPropertyList.size() > 0) {
							tranInfo.setTpid(transactionPropertyList.get(0)
									.getTpid());
							createUpdateUserInfo(tranInfo);
							preventService.modifyTransactionProperty(tranInfo);
						} else {
							createEntryUserInfo(tranInfo);
							preventService.entryTransactionProperty(tranInfo);
						}
					}
					conn.commit();
					if (tranInfo != null) {
						synchronizeIdList.add(tranInfo.getSynchronizeId());
					}
				} catch (Exception ex) {
					conn.rollback();
					/** Write log */
                    logger.logging(logMessage, ex);
				}
			}
		} catch (Exception exception) {
			Logger.getLogger(TransactionBatchSynchronize.class.getName()).log(
					Level.SEVERE, null, exception);
			logger.logging(logMessage, exception);
		}

		return synchronizeIdList;
	}

	public static Calendar convertStringToCalendar(String s)
			throws java.text.ParseException {
		SimpleDateFormat df = new SimpleDateFormat(DATE_FORMAT);
		Calendar cal = Calendar.getInstance();
		Date d1 = df.parse(s);
		cal.setTime(d1);
		return cal;
	}

	/**
	 * Create entry user information
	 * 
	 * @param info
	 */
	private static void createEntryUserInfo(AbstractWsInfo info) {
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
	private static void createUpdateUserInfo(AbstractWsInfo info) {
		/* Update user */
		info.setUpdateUserName(ENGINE);
		info.setUpdateDateTime(Calendar.getInstance());
	}

}
