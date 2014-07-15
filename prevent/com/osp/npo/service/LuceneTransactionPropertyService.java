package com.osp.npo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopFieldDocs;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.TextFragment;
import org.apache.lucene.search.highlight.TokenSources;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;

import com.osp.npo.app.viewhelper.PreventListViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.LuceneCustomAnalyzer;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.prevent.TransactionPropertyInfo;
import com.osp.npo.core.prevent.TransactionPropertyList;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;

public class LuceneTransactionPropertyService {
	private IndexWriter writer = null;
	
	private final String LUCENE_TRANSACTION_PROPERTY_DIRECTORY = "index_transaction_folder";
	private final String SEPARATOR = "OSP";

	/** Logger */
    public static NpoLogger logger = (NpoLogger) NpoLogger
    	.getLogger(LucenePreventService.class.getName());
	
	
	/**
	 * 
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	private void initialize() throws CorruptIndexException,
			LockObtainFailedException, IOException {

		File file = new File(SystemProperties.getProperty(LUCENE_TRANSACTION_PROPERTY_DIRECTORY));
		writer = new IndexWriter(FSDirectory.open(file),
				new LuceneCustomAnalyzer(), false,
				IndexWriter.MaxFieldLength.UNLIMITED);
	}
	
	/**
	 * Open Index Writer
	 * @return
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public IndexWriter openWriter() throws CorruptIndexException, LockObtainFailedException, IOException {
		File file = new File(SystemProperties.getProperty(LUCENE_TRANSACTION_PROPERTY_DIRECTORY));
		
		if (!file.exists()) {
			return null;
		}
		
		IndexWriter writer = new IndexWriter(FSDirectory.open(file),
				new LuceneCustomAnalyzer(), false,
				IndexWriter.MaxFieldLength.UNLIMITED);
		
		return writer;
	}
	/**
	 * Create index file 
	 * 
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void createIndexFile() throws CorruptIndexException,
			LockObtainFailedException, IOException {

		File file = new File(SystemProperties.getProperty(LUCENE_TRANSACTION_PROPERTY_DIRECTORY));
		
		if (!file.exists()) {
			file.mkdirs();
        }
		
		IndexWriter createWriter = new IndexWriter(FSDirectory.open(file),
				new LuceneCustomAnalyzer(), true,
				IndexWriter.MaxFieldLength.UNLIMITED);
		
		createWriter.close();
	}

	/**
	 * 
	 * @param transactionPropertyInfo
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void entryTransactionPropertyDocument(TransactionPropertyInfo transactionPropertyInfo)
			throws CorruptIndexException, LockObtainFailedException,
			IOException {
		
		NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB9001");
        
		try {
			initialize();
			this.entryTransactionPropertyDocument(writer, transactionPropertyInfo);
		} catch (Exception exception) {
			/** Write log */
			logger.logging(logMessage, exception);
		} finally {
			if (writer != null) {
				writer.optimize();
				writer.close();
			}
		}
	}
	
	/**
	 * 
	 * @param transactionPropertyInfo
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void entryTransactionPropertyDocument(IndexWriter indexWriter, TransactionPropertyInfo transactionPropertyInfo)
			throws CorruptIndexException, LockObtainFailedException,
			IOException {

		String fulltext = transactionPropertyInfo.getContractNumber() + " "
		+ transactionPropertyInfo.getTransactionContentLucene() + " "
		+ transactionPropertyInfo.getCancelDescription() + " "
		+ transactionPropertyInfo.getMortageCancelNote() + " "
		+ transactionPropertyInfo.getRelationObjectDisp() + " ";
		
		fulltext += EditString.parseKeyForSearch(fulltext);
		
		String cancelDescription = "";
		if (transactionPropertyInfo.getCancelDescription() != null) {
			cancelDescription = transactionPropertyInfo.getCancelDescription();
		}
		
		String mortageCancelNote = "";
		if (transactionPropertyInfo.getMortageCancelNote() != null) {
			mortageCancelNote = transactionPropertyInfo.getMortageCancelNote();
		}
		
		String mortageCancelDate = "";
		if (transactionPropertyInfo.getMortageCancelDate() != null) {
			mortageCancelDate = transactionPropertyInfo.getMortageCancelDate();
		}
		
		String mortageCancelFlag = "";
		if (transactionPropertyInfo.getMortageCancelFlag() != null) {
			mortageCancelFlag = transactionPropertyInfo.getMortageCancelFlag().toString();
		}
		
		String contractPeriod = "";
		if (transactionPropertyInfo.getContractPeriod() != null) {
			contractPeriod = transactionPropertyInfo.getContractPeriod();
		}
		
		String transactionContent = "";
		if (transactionPropertyInfo.getTransactionContentLucene() != null) {
			transactionContent = transactionPropertyInfo.getTransactionContentLucene();
		}
		
		String propertyInfo = "";
		if (transactionPropertyInfo.getPropertyInfoDisp()!=null) {
			propertyInfo = transactionPropertyInfo.getPropertyInfoDisp() + " ";
		}
		
		propertyInfo += EditString.parseKeyForSearch(propertyInfo);
		
		String contractNumber = "";
		if (transactionPropertyInfo.getContractNumber() != null) {
			contractNumber = transactionPropertyInfo.getContractNumber();
		}
		
		String contractName = "";
		if (transactionPropertyInfo.getContractName() != null) {
			contractName = transactionPropertyInfo.getContractName();
		}
		
		String notaryDate = "";
		if (transactionPropertyInfo.getNotaryDate() != null) {
			notaryDate = transactionPropertyInfo.getNotaryDate().toString();
		}
		
		String orderDate = "";
		if (transactionPropertyInfo.getNotaryDate() !=null) {
			String regex = "-";
			String timeSpilit[] = notaryDate.substring(0, 10).split(regex);
			for (int i = 0; i<=timeSpilit.length - 1; i++) {
				orderDate += timeSpilit[i];
			}
		}
		
		String notaryPerson = "";
		if (transactionPropertyInfo.getNotaryPerson() != null) {
			notaryPerson = transactionPropertyInfo.getNotaryPerson();
		}
		
		String officeName = "";
		if (transactionPropertyInfo.getNotaryOfficeName() != null) {
			officeName = transactionPropertyInfo.getNotaryOfficeName();
		}
		String relationObject ="";
		if (transactionPropertyInfo.getRelationObjectDisp()!=null) {
			relationObject = transactionPropertyInfo.getRelationObjectDisp()+ " ";
		}
		relationObject += EditString.parseKeyForSearch(relationObject);

		String relationObjectAdvance ="";
		if (transactionPropertyInfo.getRelationObjectDisp()!=null) {
			relationObjectAdvance = transactionPropertyInfo.getRelationObjectDisp();
		}
		
		Long id = transactionPropertyInfo.getTpid();
		
		String contractId = "";
		if (transactionPropertyInfo.getContractId() != null) {
			contractId = transactionPropertyInfo.getContractId().toString();
		}
		
		String propertyType = "";
		if (transactionPropertyInfo.getType() != null) {
			propertyType = transactionPropertyInfo.getType();
		}
		
		String district = "";
		if (transactionPropertyInfo.getDistrict()!=null) {
			district = transactionPropertyInfo.getDistrict();
		}
		
		String street = "";
		if (transactionPropertyInfo.getStreet()!=null) {
			street = transactionPropertyInfo.getStreet();
		}
		
		String officeCode = getOfficeCode(transactionPropertyInfo.getSynchronizeId());
		
		Document document = new Document();
		Field fulltextField = new Field("fulltext", fulltext, Field.Store.NO,
				Field.Index.ANALYZED);
		
		Field idField = new Field("id", SEPARATOR + id.toString() + SEPARATOR, Field.Store.YES,
				Field.Index.NOT_ANALYZED);
		Field officeCodeField = new Field("officeCode", officeCode, Field.Store.NO,
				Field.Index.ANALYZED);
		Field contractIdField = new Field("contractId",contractId, Field.Store.YES,
				Field.Index.NOT_ANALYZED);
		Field transactionContentField = new Field("transactionContent", transactionContent,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field contractNumberField = new Field("contractNumber", contractNumber,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field contractNameField = new Field("contractName",
				contractName, Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field notaryDateField = new Field("notaryDate", notaryDate,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field notaryPersonField = new Field("notaryPerson", notaryPerson,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field officeNameField = new Field("officeName", officeName,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field relationObjectField = new Field("relationObject", relationObject,
				Field.Store.YES, Field.Index.ANALYZED);
		Field relationObjectAdvanceField = new Field("relationObjectAdvance", relationObjectAdvance,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field propertyTypeField = new Field("propertyType", propertyType,
				Field.Store.NO, Field.Index.ANALYZED);
		Field districtField = new Field("district", district,
				Field.Store.NO, Field.Index.ANALYZED);
		Field streetField = new Field("street", street,
				Field.Store.NO, Field.Index.ANALYZED);
		Field propertyInfoField = new Field("propertyInfo", propertyInfo,
				Field.Store.NO, Field.Index.ANALYZED);
		Field cancelDescriptionField = new Field("cancelDescription", cancelDescription,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field mortageCancelNoteField = new Field("mortageCancelNote", mortageCancelNote,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field mortageCancelDateField = new Field("mortageCancelDate", mortageCancelDate,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field mortageCancelFlagField = new Field("mortageCancelFlag", mortageCancelFlag,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field contractPeriodField = new Field("contractPeriod", contractPeriod,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field orderDateField = new Field("orderDate", orderDate,
				Field.Store.YES, Field.Index.NOT_ANALYZED);		
		
		
		
		
		document.add(fulltextField);
		document.add(transactionContentField);
		document.add(idField);
		document.add(officeCodeField);
		document.add(contractIdField);
		document.add(contractNumberField);
		document.add(contractNameField);
		document.add(notaryPersonField);
		document.add(notaryDateField);
		document.add(officeNameField);
		document.add(relationObjectField);
		document.add(relationObjectAdvanceField);
		document.add(propertyTypeField);
		document.add(streetField);
		document.add(districtField);
		document.add(propertyInfoField);
		document.add(cancelDescriptionField);
		document.add(contractPeriodField);
		document.add(mortageCancelDateField);
		document.add(mortageCancelFlagField);
		document.add(mortageCancelNoteField);
		document.add(orderDateField);

			
		
		indexWriter.addDocument(document);
		

	}
	
	
	/**
	 * 
	 * @param transactionPropertyInfo
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void updateTransactionPropertyDocument(IndexWriter indexWriter, TransactionPropertyInfo transactionPropertyInfo)
			throws CorruptIndexException, LockObtainFailedException,
			IOException {

		String fulltext = transactionPropertyInfo.getContractNumber() + " "
		+ transactionPropertyInfo.getTransactionContentLucene() + " "
		+ transactionPropertyInfo.getCancelDescription() + " "
		+ transactionPropertyInfo.getMortageCancelNote() + " "
		+ transactionPropertyInfo.getRelationObjectDisp() + " ";
		
		fulltext += EditString.parseKeyForSearch(fulltext);
		
		String cancelDescription = "";
		if (transactionPropertyInfo.getCancelDescription() != null) {
			cancelDescription = transactionPropertyInfo.getCancelDescription();
		}
		
		String mortageCancelNote = "";
		if (transactionPropertyInfo.getMortageCancelNote() != null) {
			mortageCancelNote = transactionPropertyInfo.getMortageCancelNote();
		}
		
		String mortageCancelDate = "";
		if (transactionPropertyInfo.getMortageCancelDate() != null) {
			mortageCancelDate = transactionPropertyInfo.getMortageCancelDate();
		}
		
		String mortageCancelFlag = "";
		if (transactionPropertyInfo.getMortageCancelFlag() != null) {
			mortageCancelFlag = transactionPropertyInfo.getMortageCancelFlag().toString();
		}
		
		String contractPeriod = "";
		if (transactionPropertyInfo.getContractPeriod() != null) {
			contractPeriod = transactionPropertyInfo.getContractPeriod();
		}
		
		String transactionContent = "";
		if (transactionPropertyInfo.getTransactionContentLucene() != null) {
			transactionContent = transactionPropertyInfo.getTransactionContentLucene();
		}
		
		String propertyInfo = "";
		if (transactionPropertyInfo.getPropertyInfoDisp()!=null) {
			propertyInfo = transactionPropertyInfo.getPropertyInfoDisp() + " ";
		}
		
		propertyInfo += EditString.parseKeyForSearch(propertyInfo);
		
		String contractNumber = "";
		if (transactionPropertyInfo.getContractNumber() != null) {
			contractNumber = transactionPropertyInfo.getContractNumber();
		}
		
		String contractName = "";
		if (transactionPropertyInfo.getContractName() != null) {
			contractName = transactionPropertyInfo.getContractName();
		}
		
		String notaryDate = "";
		if (transactionPropertyInfo.getNotaryDate() != null) {
			notaryDate = transactionPropertyInfo.getNotaryDate().toString();
		}
		
		String orderDate = "";
		if (transactionPropertyInfo.getNotaryDate() !=null) {
			String regex = "-";
			 String timeSpilit[] = notaryDate.split(regex);
			 for (int i = 0; i<=timeSpilit.length - 1; i++) {
				orderDate += timeSpilit[i];
			}
		}
		
		String notaryPerson = "";
		if (transactionPropertyInfo.getNotaryPerson() != null) {
			notaryPerson = transactionPropertyInfo.getNotaryPerson();
		}
		
		String officeName = "";
		if (transactionPropertyInfo.getNotaryOfficeName() != null) {
			officeName = transactionPropertyInfo.getNotaryOfficeName();
		}
		String relationObject ="";
		if (transactionPropertyInfo.getRelationObjectDisp()!=null) {
			relationObject = transactionPropertyInfo.getRelationObjectDisp()+ " ";
		}
		relationObject += EditString.parseKeyForSearch(relationObject);

		String relationObjectAdvance ="";
		if (transactionPropertyInfo.getRelationObjectDisp()!=null) {
			relationObjectAdvance = transactionPropertyInfo.getRelationObjectDisp();
		}
		
		Long id = transactionPropertyInfo.getTpid();
		
		String contractId = "";
		if (transactionPropertyInfo.getContractId() != null) {
			contractId = transactionPropertyInfo.getContractId().toString();
		}
		
		String propertyType = "";
		if (transactionPropertyInfo.getType() != null) {
			propertyType = transactionPropertyInfo.getType();
		}
		
		String district = "";
		if (transactionPropertyInfo.getDistrict()!=null) {
			district = transactionPropertyInfo.getDistrict();
		}
		
		String street = "";
		if (transactionPropertyInfo.getStreet()!=null) {
			street = transactionPropertyInfo.getStreet();
		}
		
		String officeCode = getOfficeCode(transactionPropertyInfo.getSynchronizeId());
		
		Document document = new Document();
		Field fulltextField = new Field("fulltext", fulltext, Field.Store.NO,
				Field.Index.ANALYZED);
		
		Field idField = new Field("id", SEPARATOR + id.toString() + SEPARATOR, Field.Store.YES,
				Field.Index.NOT_ANALYZED);
		Field officeCodeField = new Field("officeCode", officeCode, Field.Store.NO,
				Field.Index.ANALYZED);
		Field contractIdField = new Field("contractId",contractId, Field.Store.YES,
				Field.Index.NOT_ANALYZED);
		Field transactionContentField = new Field("transactionContent", transactionContent,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field contractNumberField = new Field("contractNumber", contractNumber,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field contractNameField = new Field("contractName",
				contractName, Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field notaryDateField = new Field("notaryDate", notaryDate,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field notaryPersonField = new Field("notaryPerson", notaryPerson,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field officeNameField = new Field("officeName", officeName,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field relationObjectField = new Field("relationObject", relationObject,
				Field.Store.YES, Field.Index.ANALYZED);
		Field relationObjectAdvanceField = new Field("relationObjectAdvance", relationObjectAdvance,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field propertyTypeField = new Field("propertyType", propertyType,
				Field.Store.NO, Field.Index.ANALYZED);
		Field districtField = new Field("district", district,
				Field.Store.NO, Field.Index.ANALYZED);
		Field streetField = new Field("street", street,
				Field.Store.NO, Field.Index.ANALYZED);
		Field propertyInfoField = new Field("propertyInfo", propertyInfo,
				Field.Store.NO, Field.Index.ANALYZED);
		Field cancelDescriptionField = new Field("cancelDescription", cancelDescription,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field mortageCancelNoteField = new Field("mortageCancelNote", mortageCancelNote,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field mortageCancelDateField = new Field("mortageCancelDate", mortageCancelDate,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field mortageCancelFlagField = new Field("mortageCancelFlag", mortageCancelFlag,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field contractPeriodField = new Field("contractPeriod", contractPeriod,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field orderDateField = new Field("orderDate", orderDate,
				Field.Store.YES, Field.Index.NOT_ANALYZED);		
		
		
		
		
		document.add(fulltextField);
		document.add(transactionContentField);
		document.add(idField);
		document.add(officeCodeField);
		document.add(contractIdField);
		document.add(contractNumberField);
		document.add(contractNameField);
		document.add(notaryPersonField);
		document.add(notaryDateField);
		document.add(officeNameField);
		document.add(relationObjectField);
		document.add(relationObjectAdvanceField);
		document.add(propertyTypeField);
		document.add(streetField);
		document.add(districtField);
		document.add(propertyInfoField);
		document.add(cancelDescriptionField);
		document.add(contractPeriodField);
		document.add(mortageCancelDateField);
		document.add(mortageCancelFlagField);
		document.add(mortageCancelNoteField);
		document.add(orderDateField);



		Term transactionPropertyId = new Term("id", SEPARATOR + transactionPropertyInfo.getTpid().toString() + SEPARATOR);
		
		indexWriter.updateDocument(transactionPropertyId, document, new LuceneCustomAnalyzer());
	}

	/**
	 * 
	 * @param transactionPropertyInfo
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void updateTransactionPropertyDocument(TransactionPropertyInfo transactionPropertyInfo)
			throws CorruptIndexException, LockObtainFailedException,
			IOException {
		
		NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB9001");
        
		try {
			initialize();
			this.updateTransactionPropertyDocument(writer, transactionPropertyInfo);
		} catch (Exception exception) {
			/** Write log */
			logger.logging(logMessage, exception);
		} finally {
			if (writer != null) {
				writer.optimize();
				writer.close();
			}
		}
	}
	
	
	/**
	 * 
	 * @param id
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void removeTransactionPropertyDocument(IndexWriter indexWriter, String transactionPropertyId) throws CorruptIndexException,
			LockObtainFailedException, IOException {
		
		Term id = new Term("id", SEPARATOR + transactionPropertyId + SEPARATOR);
		indexWriter.deleteDocuments(id);
	}
	
	/**
	 * 
	 * @param id
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void removeTransactionPropertyDocument(String transactionPropertyId) throws CorruptIndexException,
			LockObtainFailedException, IOException {
		NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB9001");
        
		try {
			initialize();
			this.removeTransactionPropertyDocument(writer, transactionPropertyId);
		} catch (Exception exception) {
			/** Write log */
			logger.logging(logMessage, exception);
		} finally {
			if (writer != null) {
				writer.optimize();
				writer.close();
			}
		}
	}


	/**
	 * 
	 * @param contractListViewHelper
	 * @param subKeyList
	 * @param lineNumber
	 * @param pageNumber
	 * @throws InvalidTokenOffsetsException 
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	public void searchTransactionProperty(PreventListViewHelper preventListViewHelper, String officeCode,
			List<String> subKeyList, int lineNumber, int pageNumber) throws IOException, InvalidTokenOffsetsException, ParseException {

		IndexReader reader = null;
		IndexSearcher searcher = null;
		TopScoreDocCollector collector = null;
		ScoreDoc[] hits = null;

		QueryParser queryParser = new QueryParser(Version.LUCENE_30,
				"fulltext", new LuceneCustomAnalyzer());
		File file = new File(SystemProperties.getProperty(LUCENE_TRANSACTION_PROPERTY_DIRECTORY));
		reader = IndexReader.open(FSDirectory.open(file), true);
		searcher = new IndexSearcher(reader);
		collector = TopScoreDocCollector.create(100000, true);
		Query query = null;
		BooleanQuery booleanQuery = new BooleanQuery();
		
		//Tim kiem theo office code
		if (preventListViewHelper.getOfficeCode() != null && !"".equals(preventListViewHelper.getOfficeCode())) {
			booleanQuery.add(getQuery(officeCode, "officeCode"),BooleanClause.Occur.MUST );
		}
		
		String queryString = "";
		queryParser.setAllowLeadingWildcard(true);

		for (int i = 1; i < subKeyList.size(); i++) {

			if (!Constants.PLUS.equals(subKeyList.get(i))&& !Constants.SPACE.equals((subKeyList.get(i)))) {
				String subkey = subKeyList.get(i);
				if (subkey.charAt(0) != '"') {
					subkey = EditString.parseKeyForSearch(subkey);
					List<String> subKey = EditString.parseKeySearch(subkey);
					if (subKey.size()>2){
						subkey="";
						for (int j = 1; j < subKey.size(); j++) if (!Constants.PLUS.equals(subKey.get(j))&& !Constants.SPACE.equals((subKey.get(j)))) {
								if (j<subKey.size()-1){
								subkey +=subKey.get(j)+ " AND ";		
							} else subkey +=subKey.get(j);
						}
					}
				}
//					while (subkey!=null && !"".equals(subkey) && !Character.isLetterOrDigit(subkey.charAt(subkey.length()-1))&& subkey.charAt(0)!= '"') {
//						if (subkey.length() >=2) {
//							subkey = subkey.substring(0, subkey.length() - 1);
//							} else subkey = "";
//					}
				if (subkey!=null && !"".equals(subkey)) {
					if (subkey.charAt(0) != '"') {
						queryString +=  subkey;
					} else
						queryString += subkey ;
					if (i!= subKeyList.size() - 1) queryString += " AND ";
				}
			} 	
		}
		query = queryParser.parse(queryString);
		booleanQuery.add(query,BooleanClause.Occur.MUST);

		
//		subKeyList.remove(subKeyList.size() - 1);

		SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter(
				"<b style = \"background:yellow;\">", "</b>");
		Highlighter highlighter = new Highlighter(htmlFormatter,
				new QueryScorer(booleanQuery));

		TransactionPropertyInfo transactionPropertyInfo;
		preventListViewHelper
				.setTransactionPropertyList(new TransactionPropertyList().getList());
		TopFieldDocs topFieldDocs;
		topFieldDocs = searcher.search(booleanQuery, null, 10000,new Sort(
				new SortField("orderDate", SortField.STRING,true)));
	//	searcher.search(booleanQuery, collector);
		preventListViewHelper.setTotalCountProperty(topFieldDocs.totalHits);
		collector.topDocs().scoreDocs = topFieldDocs.scoreDocs;
		
	//	preventListViewHelper.setTotalCountProperty(collector.getTotalHits());
		
	//	hits = collector.topDocs((pageNumber - 1) * lineNumber, lineNumber).scoreDocs;
		hits = collector.topDocs().scoreDocs;
		if (preventListViewHelper.getTotalCountProperty() > 0) {
			String transactionPropertyId="";
			String transactionContent;
			String transactionContentDisp;
			String relationObjectDisp;
			String relationObject;
//				String relationDisp = "";
			int start = (pageNumber - 1) * lineNumber;
			int end = pageNumber * lineNumber;
			if (end > hits.length) end = hits.length;
			for (int i = start; i < end; i++) {
				int scoreId = hits[i].doc;
				Document document = searcher.doc(scoreId);
				transactionPropertyInfo = new TransactionPropertyInfo();
				preventListViewHelper.setLuceneSearch(true);
				transactionPropertyId = document.getField("id")
				.stringValue();
				transactionPropertyId = transactionPropertyId.replaceAll(SEPARATOR, "");
				
				transactionPropertyInfo.setTpid(Long.parseLong(transactionPropertyId));
				if (!"".equals(document.getField("contractId").stringValue()))
				transactionPropertyInfo.setContractId(Long.parseLong(document.getField("contractId").stringValue()));
				transactionPropertyInfo.setContractNumber(document.getField(
						"contractNumber").stringValue());
				transactionPropertyInfo.setContractName(document.getField(
						"contractName").stringValue());
				transactionPropertyInfo.setNotaryDate(RelateDateTime.toTimestamp2((document.getField("notaryDate").stringValue())));
				transactionPropertyInfo.setNotaryPerson(document.getField("notaryPerson").stringValue());
				transactionPropertyInfo.setNotaryOfficeName(document.getField("officeName").stringValue());
				transactionPropertyInfo.setMortageCancelFlag(document.getField(
				"mortageCancelFlag").stringValue().equals("true"));
				transactionPropertyInfo.setMortageCancelDate(document.getField("mortageCancelDate").stringValue());
				transactionPropertyInfo.setContractPeriod(document.getField("contractPeriod").stringValue());
				transactionPropertyInfo.setCancelDescription(document.getField("cancelDescription").stringValue());
				
				
				transactionPropertyInfo.setMortageCancelNote(document.getField("mortageCancelNote").stringValue());
				
				
				
				TokenStream tokenStream = TokenSources.getAnyTokenStream(
						searcher.getIndexReader(), scoreId, "transactionContent",
						new LuceneCustomAnalyzer());
				
				transactionContent = document.getField("transactionContent").stringValue();
				transactionContentDisp = EditString.getDisp(transactionContent,Constants.LENGTH_OUTPUT_LIMIT);
				relationObject = document.getField("relationObjectAdvance").stringValue();
				relationObjectDisp = EditString.getDisp(relationObject, Constants.LENGTH_OUTPUT_LIMIT);
				while (transactionContentDisp.length()<transactionContent.length()){
					transactionContentDisp+=" ";
				}
				while (relationObjectDisp.length()<relationObject.length()){
					relationObjectDisp+=" ";
				}
				
				if (!subKeyList.get(1).equals("*")){
					
					
					
					
					TextFragment[] frag = highlighter.getBestTextFragments(
							tokenStream, transactionContentDisp, true, 10);	
					
					
					if (frag.length!=0){
						transactionContentDisp="";
						for (int j = 0; j < frag.length; j++) {
							if ((frag[j] != null)) {
								transactionContentDisp += frag[j].toString();
							}
						}			
					}
					
					String transactionContentTest = transactionContentDisp.replaceAll("<b style = \"background:yellow;\">   </b> ","").trim();
					if ("".equals(transactionContentTest)) transactionContentDisp = EditString.getDisp(transactionContent, Constants.LENGTH_OUTPUT_LIMIT);
					
					TokenStream tokenStream1 = TokenSources.getAnyTokenStream(
							searcher.getIndexReader(), scoreId, "transactionContent",
							new LuceneCustomAnalyzer());
					frag = highlighter.getBestTextFragments(
							tokenStream1, document.getField("transactionContent")
									.stringValue(), true, 10);	
					if (frag.length!=0) {
						transactionContent = "";
						for (int j = 0; j < frag.length; j++) {
							if ((frag[j] != null)) {
								transactionContent += frag[j].toString();
							}
						}			
					}
					
					TokenStream tokenStream2 = TokenSources.getAnyTokenStream(
							searcher.getIndexReader(), scoreId, "relationObjectAdvance",
							new LuceneCustomAnalyzer());
					TextFragment[] frag2 = highlighter.getBestTextFragments(
							tokenStream2, relationObjectDisp, true, 10);	
					
					
					if (frag2.length!=0){
						relationObjectDisp="";
						for (int j = 0; j < frag2.length; j++) {
							if ((frag2[j] != null)) {
								relationObjectDisp += frag2[j].toString();
							}
						}			
					}
					String relationObjectTest = relationObjectDisp.replaceAll("<b style = \"background:yellow;\">   </b> ","").trim();
					if ("".equals(relationObjectTest)) relationObjectDisp = EditString.getDisp(relationObject, Constants.LENGTH_OUTPUT_LIMIT);
					
					TokenStream tokenStream3 = TokenSources.getAnyTokenStream(
							searcher.getIndexReader(), scoreId, "relationObjectAdvance",
							new LuceneCustomAnalyzer());
					frag2 = highlighter.getBestTextFragments(
							tokenStream3, document.getField("relationObjectAdvance")
									.stringValue(), true, 10);	
					if (frag2.length!=0) {
						relationObject = "";
						for (int j = 0; j < frag2.length; j++) {
							if ((frag2[j] != null)) {
								relationObject += frag2[j].toString();
							}
						}			
					}
					
						
						
				
				}
				transactionPropertyInfo.setLuceneRelationObjectDisp(relationObjectDisp);
				transactionPropertyInfo.setLuceneRelationObject(relationObject);
				transactionPropertyInfo.setLuceneTransactionContent(transactionContent);
				transactionPropertyInfo.setLuceneTransactionContentDisp(transactionContentDisp);
				preventListViewHelper.getTransactionPropertyList().add(transactionPropertyInfo);

			}
		}
		
		if (reader != null) {
			reader.close();
		}
		if (searcher != null) {
			searcher.close();
		}
		
	}
	
	/**
	 * 
	 * @param contractListViewHelper
	 * @param subKeyList
	 * @param lineNumber
	 * @param pageNumber
	 * @throws InvalidTokenOffsetsException 
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	public void searchTransactionProperty2(PreventListViewHelper preventListViewHelper, String officeCode,
			List<String> keySearchList, int lineNumber, int pageNumber) throws IOException, InvalidTokenOffsetsException, ParseException {

		IndexReader reader = null;
		IndexSearcher searcher = null;
		TopScoreDocCollector collector = null;
		ScoreDoc[] hits = null;

		
		File file = new File(SystemProperties.getProperty(LUCENE_TRANSACTION_PROPERTY_DIRECTORY));
		reader = IndexReader.open(FSDirectory.open(file), true);
		searcher = new IndexSearcher(reader);
		collector = TopScoreDocCollector.create(100000, true);
	


		List<String> subKeyList = null;
		BooleanQuery booleanQuery = new BooleanQuery();
		
		//Tim kiem theo office code
		if (preventListViewHelper.getOfficeCode() != null && !"".equals(preventListViewHelper.getOfficeCode())) {
			booleanQuery.add(getQuery(officeCode, "officeCode"),BooleanClause.Occur.MUST );
		}
		
		if (keySearchList.get(0)!= null && !"".equals(keySearchList.get(0).trim())) {
			subKeyList = EditString.parseKeySearch(keySearchList.get(0));
			if (subKeyList.size()!=0)
			booleanQuery.add(getQuery(subKeyList, "propertyType"),BooleanClause.Occur.MUST );
		}
		if (keySearchList.get(1)!= null && !"".equals(keySearchList.get(1).trim())) {
			subKeyList = EditString.parseKeySearch(keySearchList.get(1));
			if (subKeyList.size()!=0)
			booleanQuery.add(getQuery(subKeyList, "district"),BooleanClause.Occur.MUST );
		}
		if (keySearchList.get(2)!= null && !"".equals(keySearchList.get(2).trim())) {
			subKeyList = EditString.parseKeySearch(keySearchList.get(2));
			if (subKeyList.size()!=0)
			booleanQuery.add(getQuery(subKeyList, "street"),BooleanClause.Occur.MUST );
		}
		if (keySearchList.get(3)!= null && !"".equals(keySearchList.get(3).trim())) {
			subKeyList = EditString.parseKeySearch(keySearchList.get(3));
			if (subKeyList.size()!=0)
			booleanQuery.add(getQuery(subKeyList, "propertyInfo"),BooleanClause.Occur.MUST );
		}
		if (keySearchList.get(4)!= null && !"".equals(keySearchList.get(4).trim())) {
			subKeyList = EditString.parseKeySearch(keySearchList.get(4));
			if (subKeyList.size()!=0)
			booleanQuery.add(getQuery(subKeyList, "relationObject"),BooleanClause.Occur.MUST );
		}

		
//		subKeyList.remove(subKeyList.size() - 1);

		SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter(
				"<b style = \"background:yellow;\">", "</b>");
		Highlighter highlighter = new Highlighter(htmlFormatter,
				new QueryScorer(booleanQuery));

		TransactionPropertyInfo transactionPropertyInfo;
		preventListViewHelper
				.setTransactionPropertyList(new TransactionPropertyList().getList());
		
		TopFieldDocs topFieldDocs;
		topFieldDocs = searcher.search(booleanQuery, null, 10000,new Sort(
				new SortField("orderDate", SortField.STRING, true)));
	//	searcher.search(booleanQuery, collector);
		preventListViewHelper.setTotalCountProperty(topFieldDocs.totalHits);
		collector.topDocs().scoreDocs = topFieldDocs.scoreDocs;
		
	//	preventListViewHelper.setTotalCountProperty(collector.getTotalHits());

	//	hits = collector.topDocs((pageNumber - 1) * lineNumber, lineNumber).scoreDocs;
		hits = collector.topDocs().scoreDocs;
		if (preventListViewHelper.getTotalCountProperty() > 0) {
			String transactionPropertyId="";
			String transactionContent;
			String transactionContentDisp;
			String relationObjectDisp;
			String relationObject;
			int start = (pageNumber - 1) * lineNumber;
			int end = pageNumber * lineNumber;
			if (end > hits.length) end = hits.length;
			for (int i = start; i < end; i++) {
				
				int scoreId = hits[i].doc;
				Document document = searcher.doc(scoreId);
				transactionPropertyInfo = new TransactionPropertyInfo();
				preventListViewHelper.setLuceneSearch(true);
				transactionPropertyId = document.getField("id")
				.stringValue();
				transactionPropertyId = transactionPropertyId.replaceAll(SEPARATOR, "");
				
				transactionPropertyInfo.setTpid(Long.parseLong(transactionPropertyId));
				if (!"".equals(document.getField("contractId").stringValue()))
				transactionPropertyInfo.setContractId(Long.parseLong(document.getField("contractId").stringValue()));
				transactionPropertyInfo.setContractNumber(document.getField(
						"contractNumber").stringValue());
				transactionPropertyInfo.setContractName(document.getField(
						"contractName").stringValue());
				transactionPropertyInfo.setNotaryDate(RelateDateTime.toTimestamp2((document.getField("notaryDate").stringValue())));
				transactionPropertyInfo.setNotaryPerson(document.getField("notaryPerson").stringValue());
				transactionPropertyInfo.setNotaryOfficeName(document.getField("officeName").stringValue());
				transactionPropertyInfo.setMortageCancelFlag(document.getField(
				"mortageCancelFlag").stringValue().equals("true"));
				transactionPropertyInfo.setMortageCancelDate(document.getField("mortageCancelDate").stringValue());
				transactionPropertyInfo.setContractPeriod(document.getField("contractPeriod").stringValue());
				transactionPropertyInfo.setCancelDescription(document.getField("cancelDescription").stringValue());
				
				
				transactionPropertyInfo.setMortageCancelNote(document.getField("mortageCancelNote").stringValue());
				
				
				
				TokenStream tokenStream = TokenSources.getAnyTokenStream(
						searcher.getIndexReader(), scoreId, "transactionContent",
						new LuceneCustomAnalyzer());
				
				transactionContent = document.getField("transactionContent").stringValue();
				transactionContentDisp = EditString.getDisp(transactionContent,Constants.LENGTH_OUTPUT_LIMIT);
				relationObject = document.getField("relationObjectAdvance").stringValue();
				relationObjectDisp = EditString.getDisp(relationObject, Constants.LENGTH_OUTPUT_LIMIT);
				while (transactionContentDisp.length()<transactionContent.length()){
					transactionContentDisp+=" ";
				}
				
				while (relationObjectDisp.length()<relationObject.length()){
					relationObjectDisp+=" ";
				}
				
				if (!subKeyList.get(1).equals("*")){
					
				
					
					
					TextFragment[] frag = highlighter.getBestTextFragments(
							tokenStream, transactionContentDisp, true, 10);	
					
					
					if (frag.length!=0){
						transactionContentDisp="";
						for (int j = 0; j < frag.length; j++) {
							if ((frag[j] != null)) {
								transactionContentDisp += frag[j].toString();
							}
						}			
					}
					
					
					TokenStream tokenStream1 = TokenSources.getAnyTokenStream(
							searcher.getIndexReader(), scoreId, "transactionContent",
							new LuceneCustomAnalyzer());
					frag = highlighter.getBestTextFragments(
							tokenStream1, document.getField("transactionContent")
									.stringValue(), true, 10);	
					if (frag.length!=0) {
						transactionContent = "";
						for (int j = 0; j < frag.length; j++) {
							if ((frag[j] != null)) {
								transactionContent += frag[j].toString();
							}
						}			
					}
					

					TokenStream tokenStream2 = TokenSources.getAnyTokenStream(
							searcher.getIndexReader(), scoreId, "relationObjectAdvance",
							new LuceneCustomAnalyzer());
					TextFragment[] frag2 = highlighter.getBestTextFragments(
							tokenStream2, relationObjectDisp, true, 10);	
					
					
					if (frag2.length!=0){
						relationObjectDisp="";
						for (int j = 0; j < frag2.length; j++) {
							if ((frag2[j] != null)) {
								relationObjectDisp += frag2[j].toString();
							}
						}			
					}
					
					
					TokenStream tokenStream3 = TokenSources.getAnyTokenStream(
							searcher.getIndexReader(), scoreId, "relationObjectAdvance",
							new LuceneCustomAnalyzer());
					frag2 = highlighter.getBestTextFragments(
							tokenStream3, document.getField("relationObjectAdvance")
									.stringValue(), true, 10);	
					if (frag2.length!=0) {
						relationObject = "";
						for (int j = 0; j < frag2.length; j++) {
							if ((frag2[j] != null)) {
								relationObject += frag2[j].toString();
							}
						}			
					}
				
				}
				
				transactionPropertyInfo.setLuceneRelationObjectDisp(relationObjectDisp);
				transactionPropertyInfo.setLuceneRelationObject(relationObject);
				transactionPropertyInfo.setLuceneTransactionContent(transactionContent);
				transactionPropertyInfo.setLuceneTransactionContentDisp(transactionContentDisp);
				preventListViewHelper.getTransactionPropertyList().add(transactionPropertyInfo);

			}
		}
		
		if (reader != null) {
			reader.close();
		}
		if (searcher != null) {
			searcher.close();
		}
	}
	/**
	 * 
	 * @param subKeyList
	 * @param searchField
	 * @throws ParseException 
	 */
	private Query getQuery(List<String> subKeyList, String searchField) throws ParseException {
		
		
		QueryParser queryParser = new QueryParser(Version.LUCENE_30,
				searchField, new LuceneCustomAnalyzer());
		
		String queryString = "";
		Query query = null;
		queryParser.setAllowLeadingWildcard(true);

		
		for (int i = 1; i < subKeyList.size(); i++) {

			if (!Constants.PLUS.equals(subKeyList.get(i))&& !Constants.SPACE.equals((subKeyList.get(i)))) {
				String subkey = subKeyList.get(i);
				if (subkey.charAt(0) != '"') {
					subkey = EditString.parseKeyForSearch(subkey);
					List<String> subKey = EditString.parseKeySearch(subkey);
					if (subKey.size()>2){
						subkey="";
						for (int j = 1; j < subKey.size(); j++) if (!Constants.PLUS.equals(subKey.get(j))&& !Constants.SPACE.equals((subKey.get(j)))) {
								if (j<subKey.size()-1){
								subkey +=subKey.get(j)+ " AND ";		
							} else subkey +=subKey.get(j);
						}
					}
				}
//					while (subkey!=null && !"".equals(subkey) &&!Character.isLetterOrDigit(subkey.charAt(subkey.length()-1))&& subkey.charAt(0)!= '"') {
//						if (subkey.length() >=2) {
//							subkey = subkey.substring(0, subkey.length() - 1);
//							} else subkey = "";
//					}
				if (subkey!=null && !"".equals(subkey)) {
					if (subkey.charAt(0) != '"') {
						queryString +=  subkey;
					} else
						queryString += subkey ;
					if (i!= subKeyList.size() - 1) queryString += " AND ";
				}
			} 	
		}
		
		query = queryParser.parse(queryString);
		
		return query;
		
	}

	/**
	 * 
	 * @param queryString
	 * @param searchField
	 * @throws ParseException 
	 */
	private Query getQuery(String queryString, String searchField) throws ParseException {
		
		if (EditString.isNull(queryString)) {
			return null;
		}
		
		QueryParser queryParser = new QueryParser(Version.LUCENE_30,
				searchField, new LuceneCustomAnalyzer());
		
		Query query = null;
		queryParser.setAllowLeadingWildcard(true);

		query = queryParser.parse(queryString);
		
		return query;
		
	}
	
	/**
	 * Get office code from synchronize id
	 * @param synchronizeId
	 * @return
	 */
	private String getOfficeCode(String synchronizeId) {
		if (synchronizeId != null && synchronizeId.contains("_")) {
			return synchronizeId.substring(0, synchronizeId.indexOf("_"));
			//return synchronizeId.split("_")[0];
		}
		
		return "";
	}

}
