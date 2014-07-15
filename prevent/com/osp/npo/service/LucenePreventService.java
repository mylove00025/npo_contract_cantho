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
import com.osp.npo.core.prevent.DataPreventInfo;
import com.osp.npo.core.prevent.DataPreventList;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;

public class LucenePreventService {
	private IndexWriter writer = null;
	
	private final String LUCENE_PREVENT_DIRECTORY = "index_prevent_data_folder";
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

		File file = new File(SystemProperties.getProperty(LUCENE_PREVENT_DIRECTORY));
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
		File file = new File(SystemProperties.getProperty(LUCENE_PREVENT_DIRECTORY));
		
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

		File file = new File(SystemProperties.getProperty(LUCENE_PREVENT_DIRECTORY));
		
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
	 * @param dataPreventInfo
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void entryDataPreventDocument(DataPreventInfo dataPreventInfo)
			throws CorruptIndexException, LockObtainFailedException,
			IOException {

		NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB9001");
        
		try {
			initialize();
			this.entryDataPreventDocument(writer, dataPreventInfo);
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
	 * @param dataPreventInfo
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void entryDataPreventDocument(IndexWriter indexWriter, DataPreventInfo dataPreventInfo)
			throws CorruptIndexException, LockObtainFailedException,
			IOException {

		String fulltext = dataPreventInfo.getPropertyInfoLucene() + " "
		+ dataPreventInfo.getPreventInBookNumber() + " "
		+ dataPreventInfo.getPreventPersonInfo() + " "
		+ dataPreventInfo.getPreventDocNumber() + " "
		+ dataPreventInfo.getPreventDocSummary() + " "
		+ dataPreventInfo.getPreventNote() + " "
		+ dataPreventInfo.getReleaseInBookNumber() + " "
		+ dataPreventInfo.getReleasePersonInfo() + " "
		+ dataPreventInfo.getReleaseDocNumber() + " "
		+ dataPreventInfo.getReleaseDocSummary() + " "
		+ dataPreventInfo.getReleaseNote() + " ";
		
		fulltext += EditString.parseKeyForSearch(fulltext);
		
		String ownerInfo = dataPreventInfo.getOwnerInfo() + " "
				+ dataPreventInfo.getPreventPersonInfo() + " ";
		ownerInfo += EditString.parseKeyForSearch(ownerInfo);
		
		String preventType = "";
		if (dataPreventInfo.getOriginKind() != null) {
			preventType = dataPreventInfo.getOriginKind();
		}
		
		String propertyType = "";
		if (dataPreventInfo.getOriginKind() != null) {
			propertyType = dataPreventInfo.getType();
		}
		
		String propertyInfo = "";
		if (dataPreventInfo.getPropertyInfoLucene() != null) {
			propertyInfo = dataPreventInfo.getPropertyInfoLucene()+ " ";
		}
		
		propertyInfo += EditString.parseKeyForSearch(propertyInfo);
		
		String propertyInfoAdvance = "";
		if (dataPreventInfo.getPropertyInfoLucene() != null) {
			propertyInfoAdvance = dataPreventInfo.getPropertyInfoLucene();
		}
		
		String preventPerson = "";
		if (dataPreventInfo.getPreventPersonInfo() != null) {
			preventPerson = dataPreventInfo.getPreventPersonInfo();
		}
		
		String receiveDate = "";
		if (dataPreventInfo.getPreventDocReceiveDate() != null) {
			 receiveDate = dataPreventInfo.getPreventDocReceiveDate().toString();
		}
		
		String releaseFlg = "";
		if (dataPreventInfo.getReleaseFlg() != null) {
			releaseFlg = dataPreventInfo.getReleaseFlg().toString();
		}
		
		String district = "";
		if (dataPreventInfo.getLandDistrict()!=null) {
			district = dataPreventInfo.getLandDistrict();
		}
		
		String street = "";
		if (dataPreventInfo.getLandStreet()!=null) {
			street = dataPreventInfo.getLandStreet();
		}
		
		String officeCode = getOfficeCode(dataPreventInfo.getSynchronizeId());
		
		Long id = dataPreventInfo.getId();
		Document document = new Document();
		Field fulltextField = new Field("fulltext", fulltext, Field.Store.NO,
				Field.Index.ANALYZED);
		
		Field idField = new Field("id", SEPARATOR + id.toString() + SEPARATOR, Field.Store.YES,
				Field.Index.NOT_ANALYZED);
		Field officeCodeField = new Field("officeCode", officeCode, Field.Store.NO,
				Field.Index.ANALYZED);
		Field preventTypeField = new Field("preventType", preventType,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field propertyTypeField = new Field("propertyType", propertyType,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field propertyInfoField = new Field("propertyInfo", propertyInfo,
				Field.Store.YES, Field.Index.ANALYZED);
		Field propertyInfoAdvanceField = new Field("propertyInfoAdvance", propertyInfoAdvance,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field preventPersonField = new Field("preventPerson",preventPerson, 
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field receiveDateField = new Field("receiveDate", receiveDate,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field releaseFlagField = new Field("releaseFlag", releaseFlg,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field ownerInfoField = new Field("ownerInfo", ownerInfo,
				Field.Store.NO, Field.Index.ANALYZED);
		Field districtField = new Field("district", district,
				Field.Store.YES, Field.Index.ANALYZED);
		Field streetField = new Field("street", street,
				Field.Store.YES, Field.Index.ANALYZED);
		
		document.add(fulltextField);
		document.add(idField);
		document.add(officeCodeField);
		document.add(preventPersonField);
		document.add(releaseFlagField);
		document.add(receiveDateField);
		document.add(preventTypeField);
		document.add(propertyTypeField);
		document.add(propertyInfoField);
		document.add(propertyInfoAdvanceField);
		document.add(ownerInfoField);
		document.add(streetField);
		document.add(districtField);
		
		indexWriter.addDocument(document);

	}
	
	/**
	 * 
	 * @param contractInfo
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void updateDataPreventDocument(IndexWriter indexWriter, DataPreventInfo dataPreventInfo)
			throws CorruptIndexException, LockObtainFailedException,
			IOException {

		String fulltext = dataPreventInfo.getPropertyInfoLucene() + " "
		+ dataPreventInfo.getPreventInBookNumber() + " "
		+ dataPreventInfo.getPreventPersonInfo() + " "
		+ dataPreventInfo.getPreventDocNumber() + " "
		+ dataPreventInfo.getPreventDocSummary() + " "
		+ dataPreventInfo.getPreventNote() + " "
		+ dataPreventInfo.getReleaseInBookNumber() + " "
		+ dataPreventInfo.getReleasePersonInfo() + " "
		+ dataPreventInfo.getReleaseDocNumber() + " "
		+ dataPreventInfo.getReleaseDocSummary() + " "
		+ dataPreventInfo.getReleaseNote() + " ";
		
		fulltext += EditString.parseKeyForSearch(fulltext);
		
		String ownerInfo = dataPreventInfo.getOwnerInfo() + " "
				+ dataPreventInfo.getPreventPersonInfo() + " ";
		ownerInfo += EditString.parseKeyForSearch(ownerInfo);
		
		String preventType = "";
		if (dataPreventInfo.getOriginKind() != null) {
			preventType = dataPreventInfo.getOriginKind();
		}
		
		String propertyType = "";
		if (dataPreventInfo.getOriginKind() != null) {
			propertyType = dataPreventInfo.getType();
		}
		
		String propertyInfo = "";
		if (dataPreventInfo.getPropertyInfoLucene() != null) {
			propertyInfo = dataPreventInfo.getPropertyInfoLucene()+ " ";
		}
		
		propertyInfo += EditString.parseKeyForSearch(propertyInfo);
		
		String propertyInfoAdvance = "";
		if (dataPreventInfo.getPropertyInfoLucene() != null) {
			propertyInfoAdvance = dataPreventInfo.getPropertyInfoLucene();
		}
		
		String preventPerson = "";
		if (dataPreventInfo.getPreventPersonInfo() != null) {
			preventPerson = dataPreventInfo.getPreventPersonInfo();
		}
		
		String receiveDate = "";
		if (dataPreventInfo.getPreventDocReceiveDate() != null) {
			 receiveDate = dataPreventInfo.getPreventDocReceiveDate().toString();
		}
		
		String releaseFlg = "";
		if (dataPreventInfo.getReleaseFlg() != null) {
			releaseFlg = dataPreventInfo.getReleaseFlg().toString();
		}
		
		String district = "";
		if (dataPreventInfo.getLandDistrict()!=null) {
			district = dataPreventInfo.getLandDistrict();
		}
		
		String street = "";
		if (dataPreventInfo.getLandStreet()!=null) {
			street = dataPreventInfo.getLandStreet();
		}
		
		String officeCode = getOfficeCode(dataPreventInfo.getSynchronizeId());
		
		Long id = dataPreventInfo.getId();
		Document document = new Document();
		Field fulltextField = new Field("fulltext", fulltext, Field.Store.NO,
				Field.Index.ANALYZED);
		
		Field idField = new Field("id", SEPARATOR + id.toString() + SEPARATOR, Field.Store.YES,
				Field.Index.NOT_ANALYZED);
		Field officeCodeField = new Field("officeCode", officeCode, Field.Store.NO,
				Field.Index.ANALYZED);
		Field preventTypeField = new Field("preventType", preventType,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field propertyTypeField = new Field("propertyType", propertyType,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field propertyInfoField = new Field("propertyInfo", propertyInfo,
				Field.Store.YES, Field.Index.ANALYZED);
		Field propertyInfoAdvanceField = new Field("propertyInfoAdvance", propertyInfoAdvance,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field preventPersonField = new Field("preventPerson",preventPerson, 
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field receiveDateField = new Field("receiveDate", receiveDate,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field releaseFlagField = new Field("releaseFlag", releaseFlg,
				Field.Store.YES, Field.Index.NOT_ANALYZED);
		Field ownerInfoField = new Field("ownerInfo", ownerInfo,
				Field.Store.NO, Field.Index.ANALYZED);
		Field districtField = new Field("district", district,
				Field.Store.YES, Field.Index.ANALYZED);
		Field streetField = new Field("street", street,
				Field.Store.YES, Field.Index.ANALYZED);
		
		document.add(fulltextField);
		document.add(idField);
		document.add(officeCodeField);
		document.add(preventPersonField);
		document.add(releaseFlagField);
		document.add(receiveDateField);
		document.add(preventTypeField);
		document.add(propertyTypeField);
		document.add(propertyInfoField);
		document.add(propertyInfoAdvanceField);
		document.add(ownerInfoField);
		document.add(streetField);
		document.add(districtField);

		Term dataPreventId = new Term("id", SEPARATOR + dataPreventInfo.getId().toString() + SEPARATOR);
		
		indexWriter.updateDocument(dataPreventId, document, new LuceneCustomAnalyzer());
	}
	
	/**
	 * 
	 * @param contractInfo
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void updateDataPreventDocument(DataPreventInfo dataPreventInfo)
			throws CorruptIndexException, LockObtainFailedException,
			IOException {
		
		NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB9001");
        
		try {
			initialize();
			this.updateDataPreventDocument(writer, dataPreventInfo);
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
	public void removeDataPreventDocument(IndexWriter indexWriter, String dataPreventId) throws CorruptIndexException,
			LockObtainFailedException, IOException {
		Term id = new Term("id", SEPARATOR + dataPreventId + SEPARATOR);
		indexWriter.deleteDocuments(id);
	}
	
	/**
	 * 
	 * @param id
	 * @throws CorruptIndexException
	 * @throws LockObtainFailedException
	 * @throws IOException
	 */
	public void removeDataPreventDocument(String dataPreventId) throws CorruptIndexException,
			LockObtainFailedException, IOException {
		
		NpoLogMessage logMessage = new NpoLogMessage();
        logMessage.select("WEB9001");
        
		try {
			initialize();
			this.removeDataPreventDocument(writer, dataPreventId);
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
	 * @param preventListViewHelper
	 * @param subKeyList
	 * @param lineNumber
	 * @param pageNumber
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws InvalidTokenOffsetsException 
	 */
	@SuppressWarnings("unchecked")
	public void searchDataPrevent(PreventListViewHelper preventListViewHelper, String officeCode,
			List<String> subKeyList, int lineNumber, int pageNumber) throws IOException, ParseException, InvalidTokenOffsetsException {

		IndexReader reader = null;
		IndexSearcher searcher = null;
		TopScoreDocCollector collector = null;
		ScoreDoc[] hits = null;

		QueryParser queryParser = new QueryParser(Version.LUCENE_30,
				"fulltext", new LuceneCustomAnalyzer());
		File file = new File(SystemProperties.getProperty(LUCENE_PREVENT_DIRECTORY));
		reader = IndexReader.open(FSDirectory.open(file), true);
		searcher = new IndexSearcher(reader);
		collector = TopScoreDocCollector.create(10000, true);
		
		BooleanQuery booleanQuery = new BooleanQuery();
		
		//Tim kiem theo office code
		if (preventListViewHelper.getOfficeCode() != null && !"".equals(preventListViewHelper.getOfficeCode())) {
			booleanQuery.add(getQuery(officeCode, "officeCode"),BooleanClause.Occur.MUST );
		}
		
		String queryString = "";
		queryParser.setAllowLeadingWildcard(true);
		Query query;
		
	
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
//				while (subkey !=null && !"".equals(subkey) && !Character.isLetterOrDigit(subkey.charAt(subkey.length()-1)) && subkey.charAt(0)!= '"') {
//					if (subkey.length() >=2) {
//					subkey = subkey.substring(0, subkey.length() - 1);
//					} else subkey = "";
//				}
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

		DataPreventInfo dataPreventInfo;
		preventListViewHelper
				.setDataPreventList(new DataPreventList().getList());
		TopFieldDocs topFieldDocs = searcher.search(booleanQuery, null, 10000,new Sort(new SortField[] {
				SortField.FIELD_SCORE,
				new SortField("propertyInfo", SortField.STRING)
				 }));
	//	searcher.search(booleanQuery, collector);
		preventListViewHelper.setTotalCount(topFieldDocs.totalHits);
		collector.topDocs().scoreDocs = topFieldDocs.scoreDocs;
		
	//	preventListViewHelper.setTotalCountProperty(collector.getTotalHits());

		hits = collector.topDocs().scoreDocs;
		
		if (preventListViewHelper.getTotalCount() > 0) {
			int start = (pageNumber - 1) * lineNumber;
			int end = pageNumber * lineNumber;
			if (end > hits.length) end = hits.length;
			String dataPreventId="";
			for (int i = start; i < end; i++) {
				int scoreId = hits[i].doc;
				Document document = searcher.doc(scoreId);
				dataPreventInfo = new DataPreventInfo();
				preventListViewHelper.setLuceneSearch(true);
				dataPreventId = document.getField("id")
				.stringValue();
				dataPreventId = dataPreventId.replaceAll(SEPARATOR, "");
				
				dataPreventInfo.setId(Long.parseLong(dataPreventId));
				dataPreventInfo.setOriginKind(document.getField(
						"preventType").stringValue());
				dataPreventInfo.setType(document.getField("propertyType")
						.stringValue());
				dataPreventInfo.setPreventDocReceiveDate((RelateDateTime
						.toTimestamp2((document.getField("receiveDate")
								.stringValue()))));
				dataPreventInfo.setPreventPersonInfo((document
							.getField("preventPerson").stringValue()));
				dataPreventInfo.setReleaseFlg(((document.getField(
						"releaseFlag").stringValue().equals("true"))));
				
				dataPreventInfo.setLandStreet(document.getField(
				"street").stringValue());
				
				dataPreventInfo.setLandDistrict(document.getField(
				"district").stringValue());
				

				TokenStream tokenStream = TokenSources.getAnyTokenStream(
						searcher.getIndexReader(), scoreId, "propertyInfoAdvance",
						new LuceneCustomAnalyzer());
				String propertyInfoDisp = EditString.getDisp(
						document.getField("propertyInfoAdvance").stringValue(),Constants.LENGTH_OUTPUT_LIMIT);
				String propertyInfo = document.getField("propertyInfoAdvance").stringValue();
			
				while (propertyInfoDisp.length()<propertyInfo.length()){
					propertyInfoDisp+=" ";
				}
				if (!subKeyList.get(1).equals("*")) {
					TextFragment[] frag = highlighter.getBestTextFragments(
							tokenStream,propertyInfoDisp , true, 10);	
					
					if (frag.length!=0) {
						propertyInfoDisp="";
					
					for (int j = 0; j < frag.length; j++) {
						if ((frag[j] != null)) {
							propertyInfoDisp += frag[j].toString();
						}
					}
					}
					
					
					TokenStream tokenStream1 = TokenSources.getAnyTokenStream(
							searcher.getIndexReader(), scoreId, "propertyInfoAdvance",
							new LuceneCustomAnalyzer());
					frag = highlighter.getBestTextFragments(
							tokenStream1, document.getField("propertyInfoAdvance")
									.stringValue(), true, 10);	
					
					if (frag.length!=0){
					propertyInfo = "";
					for (int j = 0; j < frag.length; j++) {
						if ((frag[j] != null)) {
							propertyInfo += frag[j].toString();
							}
						}
					}
					

				
				}
				dataPreventInfo.setLucenePropertyInfoDisp(propertyInfoDisp);
				dataPreventInfo.setLucenePropertyInfo(propertyInfo);
				preventListViewHelper.getDataPreventList().add(dataPreventInfo);

			}
		}
		
		if (reader != null) {
			reader.close();
		}

	}
	
	/**
	 * 
	 * @param preventListViewHelper
	 * @param subKeyList
	 * @param lineNumber
	 * @param pageNumber
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws InvalidTokenOffsetsException 
	 */
	@SuppressWarnings("unchecked")
	public void searchDataPrevent2(PreventListViewHelper preventListViewHelper, String officeCode,
			List<String> keySearchList, int lineNumber, int pageNumber) throws IOException, ParseException, InvalidTokenOffsetsException {

		IndexReader reader = null;
		IndexSearcher searcher = null;
		TopScoreDocCollector collector = null;
		ScoreDoc[] hits = null;
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
			booleanQuery.add(getQuery(subKeyList, "ownerInfo"),BooleanClause.Occur.MUST );
		}
		File file = new File(SystemProperties.getProperty(LUCENE_PREVENT_DIRECTORY));
		reader = IndexReader.open(FSDirectory.open(file), true);
		searcher = new IndexSearcher(reader);
		collector = TopScoreDocCollector.create(10000, true);
		

		SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter(
				"<b style = \"background:yellow;\">", "</b>");
		Highlighter highlighter = new Highlighter(htmlFormatter,
				new QueryScorer(booleanQuery));

		DataPreventInfo dataPreventInfo;
		preventListViewHelper
				.setDataPreventList(new DataPreventList().getList());
		TopFieldDocs topFieldDocs = searcher.search(booleanQuery, null, 10000,new Sort(new SortField[] {
				SortField.FIELD_SCORE,
				new SortField("propertyInfo", SortField.STRING)
				 }));
	//	searcher.search(booleanQuery, collector);
		preventListViewHelper.setTotalCount(topFieldDocs.totalHits);
		collector.topDocs().scoreDocs = topFieldDocs.scoreDocs;
		
	//	preventListViewHelper.setTotalCountProperty(collector.getTotalHits());

		hits = collector.topDocs().scoreDocs;
		if (preventListViewHelper.getTotalCount() > 0) {
			String dataPreventId="";
			int start = (pageNumber - 1) * lineNumber;
			int end = pageNumber * lineNumber;
			if (end > hits.length) end = hits.length;
			for (int i = start; i < end; i++) {
				int scoreId = hits[i].doc;
				Document document = searcher.doc(scoreId);
				dataPreventInfo = new DataPreventInfo();
				preventListViewHelper.setLuceneSearch(true);
				dataPreventId = document.getField("id")
				.stringValue();
				dataPreventId = dataPreventId.replaceAll(SEPARATOR, "");
				
				dataPreventInfo.setId(Long.parseLong(dataPreventId));
				dataPreventInfo.setOriginKind(document.getField(
						"preventType").stringValue());
				dataPreventInfo.setType(document.getField("propertyType")
						.stringValue());
				dataPreventInfo.setPreventDocReceiveDate((RelateDateTime
						.toTimestamp2((document.getField("receiveDate")
								.stringValue()))));
				dataPreventInfo.setPreventPersonInfo((document
							.getField("preventPerson").stringValue()));
				dataPreventInfo.setReleaseFlg(((document.getField(
						"releaseFlag").stringValue().equals("true"))));

				dataPreventInfo.setLandStreet(document.getField(
						"street").stringValue());
				
				dataPreventInfo.setLandDistrict(document.getField(
				"district").stringValue());
				TokenStream tokenStream = TokenSources.getAnyTokenStream(
						searcher.getIndexReader(), scoreId, "propertyInfoAdvance",
						new LuceneCustomAnalyzer());
				String propertyInfoDisp = EditString.getDisp(
						document.getField("propertyInfoAdvance").stringValue(),Constants.LENGTH_OUTPUT_LIMIT);
				String propertyInfo = document.getField("propertyInfoAdvance").stringValue();
			
				while (propertyInfoDisp.length()<propertyInfo.length()){
					propertyInfoDisp+=" ";
				}
				if (!subKeyList.get(1).equals("*")) {
					TextFragment[] frag = highlighter.getBestTextFragments(
							tokenStream,propertyInfoDisp , true, 10);	
					
					if (frag.length!=0) {
						propertyInfoDisp="";
					
					for (int j = 0; j < frag.length; j++) {
						if ((frag[j] != null)) {
							propertyInfoDisp += frag[j].toString();
						}
					}
					}
					
					String propertyInfoTest = propertyInfoDisp.replaceAll("<b style = \"background:yellow;\">   </b> ","").trim();
					if ("".equals(propertyInfoTest)) propertyInfoDisp = EditString.getDisp(propertyInfo, Constants.LENGTH_OUTPUT_LIMIT);
					TokenStream tokenStream1 = TokenSources.getAnyTokenStream(
							searcher.getIndexReader(), scoreId, "propertyInfoAdvance",
							new LuceneCustomAnalyzer());
					frag = highlighter.getBestTextFragments(
							tokenStream1, document.getField("propertyInfoAdvance")
									.stringValue(), true, 10);	
					
					if (frag.length!=0){
					propertyInfo = "";
					for (int j = 0; j < frag.length; j++) {
						if ((frag[j] != null)) {
							propertyInfo += frag[j].toString();
							}
						}
					}
					

					
				}
				dataPreventInfo.setLucenePropertyInfoDisp(propertyInfoDisp);
				dataPreventInfo.setLucenePropertyInfo(propertyInfo);
				preventListViewHelper.getDataPreventList().add(dataPreventInfo);

			}
		}
		
		if (reader != null) {
			reader.close();
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


