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

import com.osp.npo.app.viewhelper.ContractListViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.LuceneCustomAnalyzer;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemProperties;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.contract.ContractList;
import com.osp.npo.core.prevent.TransactionPropertyInfo;
import com.osp.npo.core.prevent.TransactionPropertyList;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;


public class LuceneContractService {
	
	private IndexWriter writer = null;
	
	private final String LUCENE_CONTRACT_DIRECTORY = "index_contract_folder";
	private final String SEPARATOR = "OSP";

	/** Logger */
    public static NpoLogger logger = (NpoLogger) NpoLogger
    	.getLogger(LuceneContractService.class.getName());
    
	/**
	 * 
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	private void initialize() throws CorruptIndexException,
			LockObtainFailedException, IOException {

		File file = new File(SystemProperties.getProperty(LUCENE_CONTRACT_DIRECTORY));
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
		File file = new File(SystemProperties.getProperty(LUCENE_CONTRACT_DIRECTORY));
		
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

		File file = new File(SystemProperties.getProperty(LUCENE_CONTRACT_DIRECTORY));
		
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
	 * @param contractInfo
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void entryContractDocument(IndexWriter indexWriter, ContractInfo contractInfo)
			throws CorruptIndexException, LockObtainFailedException,
			IOException {

		String fulltext = contractInfo.getContractNumber() + " "
				+ contractInfo.getContractTemplateName() + " "
				+ contractInfo.getRelationInfoLucene() + " "
				+ contractInfo.getContractSummaryLucene() + " "
				+ contractInfo.getNote() + " "
				+ contractInfo.getNotaryPlace() + " "
				+ contractInfo.getCrediterName() + " "
				+ contractInfo.getUserRequireContract() + " "
				+ contractInfo.getOriginalStorePlace() + " "
				+ contractInfo.getContractKindName() + " "
				+ contractInfo.getErrorDescription() + " "
				+ contractInfo.getAdditionDescription() + " "
				+ contractInfo.getCancelDescription() + " "
				+ contractInfo.getMortageCancelNote() + " "
				+ SEPARATOR + " entryUserId " + contractInfo.getEntryUserId() + " " + SEPARATOR + " ";
		
		fulltext += EditString.parseKeyForSearch(fulltext);
		
		String mortageCancelNote = "";
		if (contractInfo.getMortageCancelNote() != null) {
			mortageCancelNote = contractInfo.getMortageCancelNote();
		}
		
		String cancelDescription = "";
		if (contractInfo.getCancelDescription() != null) {
			cancelDescription = contractInfo.getCancelDescription();
		}
		
		String mortageCancelDate = "";
		if (contractInfo.getMortageCancelDate() != null) {
			mortageCancelDate = contractInfo.getMortageCancelDate();
		}
		
		String mortageCancelFlag = "";
		if (contractInfo.getMortageCancelFlag() != null) {
			mortageCancelFlag = contractInfo.getMortageCancelFlag().toString();
		}
		
		String contractPeriod = "";
		if (contractInfo.getContractPeriod() != null) {
			contractPeriod = contractInfo.getContractPeriod();
		}
		
		String relationObject = "";
		if (contractInfo.getRelationInfoLucene() != null) {
			relationObject = contractInfo.getRelationInfoLucene();
		}
		
		String contractSummary = "";
		if (contractInfo.getContractSummaryLucene() != null) {
			contractSummary = contractInfo.getContractSummaryLucene();
		}
		
		String contractNumber = "";
		if (contractInfo.getContractNumber() != null) {
			contractNumber = contractInfo.getContractNumber();
		}
		
		String contractTemplate = "";
		if (contractInfo.getContractTemplateName() != null) {
			contractTemplate = contractInfo.getContractTemplateName();
		}
		
		String notaryDate = "";
		if (contractInfo.getNotaryDate() != null) {
			notaryDate = contractInfo.getNotaryDate().toString();
		}
		
		String notaryPerson = "";
		
//		if (contractInfo.getNotaryFamilyName() != null) {
//			notaryPerson = contractInfo.getNotaryFamilyName();
//		}
//		if (contractInfo.getNotaryFirstName() != null) {
//			notaryPerson += " " + contractInfo.getNotaryFirstName();
//		}
		
		if (contractInfo.getCrediterName() != null)
		{
			notaryPerson = contractInfo.getCrediterName();
		}
		
		String cancelStatus = "";
		if (contractInfo.getCancelStatus() != null) {
			cancelStatus = contractInfo.getCancelStatus().toString();
		}
		
		String additionStatus = "";
		if (contractInfo.getAdditionStatus() != null) {
			additionStatus = contractInfo.getAdditionStatus().toString();
		}
		
		String errorStatus = "";
		if (contractInfo.getErrorStatus() != null) {
			errorStatus = contractInfo.getErrorStatus().toString();
		}
		
		Long id = contractInfo.getId();
		Document document = new Document();
		Field fulltextField = new Field("fulltext", fulltext, Field.Store.NO,
				Field.Index.ANALYZED);

		Field idField = new Field("id", SEPARATOR + id.toString() + SEPARATOR, Field.Store.YES,
				Field.Index.NOT_ANALYZED);
		Field relationField = new Field("relation", relationObject,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field summaryField = new Field("contractSummary", contractSummary,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field contractNumberField = new Field("contractNumber", contractNumber,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field contractTemplateField = new Field("contractTemplate",
				contractTemplate, Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field notaryDateField = new Field("notaryDate", notaryDate,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field notaryPersonField = new Field("notaryPerson", notaryPerson,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field cancelStatusField = new Field("cancelStatus", cancelStatus,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field additionStatusField = new Field("additionStatus", additionStatus,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field errorStatusField = new Field("errorStatus", errorStatus,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
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


		document.add(fulltextField);
		document.add(idField);
		document.add(relationField);
		document.add(summaryField);
		document.add(contractNumberField);
		document.add(contractTemplateField);
		document.add(notaryPersonField);
		document.add(notaryDateField);
		document.add(cancelStatusField);
		document.add(additionStatusField);
		document.add(errorStatusField);
		document.add(cancelDescriptionField);
		document.add(mortageCancelNoteField);
		document.add(mortageCancelDateField);
		document.add(mortageCancelFlagField);
		document.add(contractPeriodField);
		
		indexWriter.addDocument(document);
	}
	
	/**
	 * 
	 * @param contractInfo
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void entryContractDocument(ContractInfo contractInfo)
			throws CorruptIndexException, LockObtainFailedException,
			IOException {

		NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB9001");
        
		try {
			initialize();
			this.entryContractDocument(writer, contractInfo);
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
	 * @param contractInfo
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void updateContractDocument(IndexWriter indexWriter, ContractInfo contractInfo)
			throws CorruptIndexException, LockObtainFailedException,
			IOException {

		String fulltext = contractInfo.getContractNumber() + " "
		+ contractInfo.getContractTemplateName() + " "
		+ contractInfo.getRelationInfoLucene() + " "
		+ contractInfo.getContractSummaryLucene() + " "
		+ contractInfo.getNote() + " "
		+ contractInfo.getNotaryPlace() + " "
		+ contractInfo.getCrediterName() + " "
		+ contractInfo.getUserRequireContract() + " "
		+ contractInfo.getOriginalStorePlace() + " "
		+ contractInfo.getContractKindName() + " "
		+ contractInfo.getErrorDescription() + " "
		+ contractInfo.getAdditionDescription() + " "
		+ contractInfo.getCancelDescription() + " "
		+ contractInfo.getMortageCancelNote() + " "
		+ SEPARATOR + " entryUserId " + contractInfo.getEntryUserId() + " " + SEPARATOR + " ";
		
		fulltext += EditString.parseKeyForSearch(fulltext);
		
		String mortageCancelNote = "";
		if (contractInfo.getMortageCancelNote() != null) {
			mortageCancelNote = contractInfo.getMortageCancelNote();
		}
		
		String cancelDescription = "";
		if (contractInfo.getCancelDescription() != null) {
			cancelDescription = contractInfo.getCancelDescription();
		}
		
		String mortageCancelDate = "";
		if (contractInfo.getMortageCancelDate() != null) {
			mortageCancelDate = contractInfo.getMortageCancelDate();
		}
		
		String mortageCancelFlag = "";
		if (contractInfo.getMortageCancelFlag() != null) {
			mortageCancelFlag = contractInfo.getMortageCancelFlag().toString();
		}
		
		String contractPeriod = "";
		if (contractInfo.getContractPeriod() != null) {
			contractPeriod = contractInfo.getContractPeriod();
		}
		
		String relationObject = "";
		if (contractInfo.getRelationInfoLucene() != null) {
			relationObject = contractInfo.getRelationInfoLucene();
		}
		
		String contractSummary = "";
		if (contractInfo.getContractSummaryLucene() != null) {
			contractSummary = contractInfo.getContractSummaryLucene();
		}
		
		String contractNumber = "";
		if (contractInfo.getContractNumber() != null) {
			contractNumber = contractInfo.getContractNumber();
		}
		
		String contractTemplate = "";
		if (contractInfo.getContractTemplateName() != null) {
			contractTemplate = contractInfo.getContractTemplateName();
		}
		
		String notaryDate = "";
		if (contractInfo.getNotaryDate() != null) {
			notaryDate = contractInfo.getNotaryDate().toString();
		}
		
		String notaryPerson = "";
		
//		if (contractInfo.getNotaryFamilyName() != null) {
//			notaryPerson = contractInfo.getNotaryFamilyName();
//		}
//		if (contractInfo.getNotaryFirstName() != null) {
//			notaryPerson += " " + contractInfo.getNotaryFirstName();
//		}
		
		if (contractInfo.getCrediterName() != null)
		{
			notaryPerson = contractInfo.getCrediterName();
		}
		
		String cancelStatus = "";
		if (contractInfo.getCancelStatus() != null) {
			cancelStatus = contractInfo.getCancelStatus().toString();
		}
		
		String additionStatus = "";
		if (contractInfo.getAdditionStatus() != null) {
			additionStatus = contractInfo.getAdditionStatus().toString();
		}
		
		String errorStatus = "";
		if (contractInfo.getErrorStatus() != null) {
			errorStatus = contractInfo.getErrorStatus().toString();
		}
		
		Long id = contractInfo.getId();
		Document document = new Document();
		Field fulltextField = new Field("fulltext", fulltext, Field.Store.NO,
				Field.Index.ANALYZED);
		
		Field idField = new Field("id", SEPARATOR + id.toString() + SEPARATOR, Field.Store.YES,
				Field.Index.NOT_ANALYZED);
		Field relationField = new Field("relation", relationObject,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field summaryField = new Field("contractSummary", contractSummary,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field contractNumberField = new Field("contractNumber", contractNumber,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field contractTemplateField = new Field("contractTemplate",
				contractTemplate, Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field notaryDateField = new Field("notaryDate", notaryDate,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field notaryPersonField = new Field("notaryPerson", notaryPerson,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field cancelStatusField = new Field("cancelStatus", cancelStatus,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field additionStatusField = new Field("additionStatus", additionStatus,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field errorStatusField = new Field("errorStatus", errorStatus,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
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
		
		
		document.add(fulltextField);
		document.add(idField);
		document.add(relationField);
		document.add(summaryField);
		document.add(contractNumberField);
		document.add(contractTemplateField);
		document.add(notaryPersonField);
		document.add(notaryDateField);
		document.add(cancelStatusField);
		document.add(additionStatusField);
		document.add(errorStatusField);
		document.add(cancelDescriptionField);
		document.add(mortageCancelNoteField);
		document.add(mortageCancelDateField);
		document.add(mortageCancelFlagField);
		document.add(contractPeriodField);

		Term contractId = new Term("id", SEPARATOR + contractInfo.getId().toString() + SEPARATOR);
		
		indexWriter.updateDocument(contractId, document, new LuceneCustomAnalyzer());
	}
	
	/**
	 * 
	 * @param contractInfo
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void updateContractDocument(ContractInfo contractInfo)
			throws CorruptIndexException, LockObtainFailedException,
			IOException {
		
		NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB9001");
        
		try {
			initialize();
			this.updateContractDocument(writer, contractInfo);
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
	public void removeContractDocument(IndexWriter indexWriter, String contractId) throws CorruptIndexException,
			LockObtainFailedException, IOException {
		Term id = new Term("id", SEPARATOR + contractId + SEPARATOR);
		indexWriter.deleteDocuments(id);
	}
	
	/**
	 * 
	 * @param id
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void removeContractDocument(String contractId) throws CorruptIndexException,
			LockObtainFailedException, IOException {

		NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB9001");
        
		try {
			initialize();
			this.removeContractDocument(writer, contractId);
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
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws InvalidTokenOffsetsException 
	 */
	@SuppressWarnings("unchecked")
	public void searchContract(ContractListViewHelper contractListViewHelper, long currentUserId,
			List<String> subKeyList, int lineNumber, int pageNumber) throws IOException, ParseException, InvalidTokenOffsetsException {

		IndexReader reader = null;
		IndexSearcher searcher = null;
		TopScoreDocCollector collector = null;
		ScoreDoc[] hits = null;

		QueryParser queryParser = new QueryParser(Version.LUCENE_30,
				"fulltext", new LuceneCustomAnalyzer());
		File file = new File(SystemProperties.getProperty(LUCENE_CONTRACT_DIRECTORY));
		reader = IndexReader.open(FSDirectory.open(file), true);
		searcher = new IndexSearcher(reader);
		collector = TopScoreDocCollector.create(10000, true);
		Query query = null;
		BooleanQuery booleanQuery = new BooleanQuery();
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
		
		queryString += " AND " + "\"" + SEPARATOR + " entryUserId " + currentUserId + " " + SEPARATOR + "\"";
		query = queryParser.parse(queryString);
		
		booleanQuery.add(query,BooleanClause.Occur.MUST);

		SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter(
				"<b style = \"background:yellow;\">", "</b>");
		Highlighter highlighter = new Highlighter(htmlFormatter,
				new QueryScorer(booleanQuery));

		TransactionPropertyInfo transactionPropertyInfo;
		contractListViewHelper
				.setContractList(new ContractList().getList());
		contractListViewHelper.setTransactionPropertyList(new TransactionPropertyList().getList());
		
		searcher.search(booleanQuery, collector);
		contractListViewHelper.setTotalCount(collector.getTotalHits());
		contractListViewHelper.setLuceneSearch(true);
		hits = collector.topDocs((pageNumber - 1) * lineNumber, lineNumber).scoreDocs;
		
		if (contractListViewHelper.getTotalCount() > 0) {
		    contractListViewHelper.getTransactionPropertyList().clear();
			String contractId="";
			for (int i = 0; i < hits.length; i++) {
				int scoreId = hits[i].doc;
				Document document = searcher.doc(scoreId);
				transactionPropertyInfo = new TransactionPropertyInfo();
				contractId = document.getField("id")
				.stringValue();
				contractId = contractId.replaceAll(SEPARATOR, "");
				
				transactionPropertyInfo.setContractId(Long.parseLong(contractId));
				transactionPropertyInfo.setContractNumber(document.getField(
						"contractNumber").stringValue());
				transactionPropertyInfo.setContractName(document.getField(
						"contractTemplate").stringValue());
				transactionPropertyInfo.setNotaryDate(RelateDateTime.toTimestamp2((document.getField("notaryDate").stringValue())));
				transactionPropertyInfo.setNotaryPerson(document.getField("notaryPerson").stringValue());
				transactionPropertyInfo.setCancelDescription(document.getField("cancelDescription").stringValue());
				transactionPropertyInfo.setMortageCancelNote(document.getField("mortageCancelNote").stringValue());
				transactionPropertyInfo.setMortageCancelDate(document.getField("mortageCancelDate").stringValue());
				transactionPropertyInfo.setMortageCancelFlag(document.getField("mortageCancelFlag").stringValue().equals("true"));
				transactionPropertyInfo.setContractPeriod(document.getField("contractPeriod").stringValue());

				TokenStream tokenStream = TokenSources.getAnyTokenStream(
						searcher.getIndexReader(), scoreId, "relation",
						new LuceneCustomAnalyzer());
				
				
				String contractInfoFull = document.getField("relation").stringValue();
				transactionPropertyInfo.setRelationObject(EditString.filter(contractInfoFull));
				String contractInfoDisp = EditString.getDisp(contractInfoFull,Constants.LENGTH_OUTPUT_LIMIT);
				while (contractInfoDisp.length()<contractInfoFull.length()){
					contractInfoDisp+= " ";
				}
				String contractSummary = document.getField("contractSummary").stringValue();
				transactionPropertyInfo.setTransactionContent(EditString.filter(contractSummary));
				String contractSummaryDisp = EditString.getDisp(contractSummary,Constants.LENGTH_OUTPUT_LIMIT);
				while (contractSummaryDisp.length()<contractSummary.length()){
					contractSummaryDisp+=" ";
				}
				if (!subKeyList.get(1).trim().equals("*")) {
					TextFragment[] frag = highlighter.getBestTextFragments(
							tokenStream, contractInfoDisp, true, 10);	
					if (frag.length!=0){
						contractInfoDisp="";
						for (int j = 0; j < frag.length; j++) {
							if ((frag[j] != null)) {
								contractInfoDisp += frag[j].toString();
							}
						}
					}
					
					String contractInfoTest = contractInfoDisp.replaceAll("<b style = \"background:yellow;\">   </b> ","").trim();
					if ("".equals(contractInfoTest)) contractInfoDisp = EditString.getDisp(contractInfoFull, Constants.LENGTH_OUTPUT_LIMIT);
					
					TokenStream tokenStream1 = TokenSources.getAnyTokenStream(
							searcher.getIndexReader(), scoreId, "relation",
							new LuceneCustomAnalyzer());
					frag = highlighter.getBestTextFragments(
							tokenStream1, contractInfoFull, true, 10);	
					if (frag.length!=0) {
						contractInfoFull = "";
						for (int j = 0; j < frag.length; j++) {
							if ((frag[j] != null)) {
								contractInfoFull += frag[j].toString();
							}
						}
					}
					

					tokenStream = TokenSources.getAnyTokenStream(
							searcher.getIndexReader(), scoreId,
							"contractSummary", new LuceneCustomAnalyzer());
					
				
					frag = highlighter.getBestTextFragments(tokenStream,contractSummaryDisp,
							true, 10);
					if (frag.length!=0){
						contractSummaryDisp="";
						for (int j = 0; j < frag.length; j++) {
							if ((frag[j] != null)) {
								contractSummaryDisp += frag[j].toString();
							}
						}		
					}                                                            
					String contractSummaryTest = contractSummaryDisp.replaceAll("<b style = \"background:yellow;\">","").trim();
					contractSummaryTest = contractSummaryTest.replaceAll("</b>", "").trim();
					if ("".equals(contractSummaryTest)) contractSummaryDisp = EditString.getDisp(contractSummary, Constants.LENGTH_OUTPUT_LIMIT);
					
					tokenStream1 = TokenSources.getAnyTokenStream(
							searcher.getIndexReader(), scoreId, "contractSummary",
							new LuceneCustomAnalyzer());
					List<String> highLightText = EditString.parseForHighLight(contractSummary,Constants.LENGTH_OUTPUT_LIMIT);
					int length = contractSummary.length();
					contractSummary = "";
					String subContractSummary;
					String subContractSummaryTest;
					for (int k = 0; k < highLightText.size(); k++) {
						subContractSummary = highLightText.get(k);
						while (subContractSummary.length()<length){
							subContractSummary+=" ";
						}
						frag = highlighter.getBestTextFragments(tokenStream1,
								subContractSummary,true, 10);
						subContractSummary = "";
						if (frag.length!=0){
							for (int j = 0; j < frag.length; j++) {
								if ((frag[j] != null)) {
									subContractSummary += frag[j].toString();
								}
							}
						}
						subContractSummary = subContractSummary.trim();
						subContractSummaryTest = subContractSummary.replaceAll("<b style = \"background:yellow;\"> ","").trim();
						subContractSummaryTest = subContractSummaryTest.replaceAll("</b>", "").trim();
						if ("".equals(subContractSummaryTest)) subContractSummary = highLightText.get(k);
						contractSummary+=subContractSummary;
					}
	
					
				}
				transactionPropertyInfo.setLuceneRelationObjectDisp(contractInfoDisp);
				transactionPropertyInfo.setLuceneRelationObject(contractInfoFull);
				transactionPropertyInfo.setLuceneTransactionContentDisp(contractSummaryDisp);
				transactionPropertyInfo.setLuceneTransactionContent(contractSummary);
				contractListViewHelper.getTransactionPropertyList().add(transactionPropertyInfo);

			}
		}
		
		if (reader != null) {
			reader.close();
		}
	}
}
