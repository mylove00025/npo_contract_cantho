package com.osp.npo.app.engine;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;

import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.DBConnection;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.contract.PropertyInfo;
import com.osp.npo.core.contract.PropertyList;
import com.osp.npo.core.luceneIndex.LuceneIndexInfo;
import com.osp.npo.core.luceneIndex.LuceneIndexList;
import com.osp.npo.core.prevent.DataPreventInfo;
import com.osp.npo.core.prevent.TransactionPropertyInfo;
import com.osp.npo.logger.NpoLogMessage;
import com.osp.npo.logger.NpoLogger;
import com.osp.npo.service.ContractService;
import com.osp.npo.service.LuceneContractService;
import com.osp.npo.service.LuceneIndexService;
import com.osp.npo.service.LucenePreventService;
import com.osp.npo.service.LuceneTransactionPropertyService;
import com.osp.npo.service.PreventService;

/**
 * Lucene Index Engine
 * 
 * @author haint
 * @version $Revision: 29726 $
 */
public class LuceneEngine {

	static private LuceneEngine _instance;

	private boolean isIndexing = false;
	private boolean isOptimizing = false;
	private boolean isOptimizeWaiting = false;

	/** Connection */
	private Connection connection = null;

	/** DB Connection */
	private DBConnection dbConnection = null;

	private static final String ORDER_FIELD = "entry_date_time";

	/** Logger */
	public static NpoLogger logger = (NpoLogger) NpoLogger
			.getLogger(LuceneEngine.class.getName());

	/**
	 * The constructor could be made private to prevent others from
	 * instantiating this class. But this would also make it impossible to
	 * create instances of Singleton subclasses.
	 */
	protected LuceneEngine() {
		// ...
	}

	/**
	 * @return The unique instance of this class.
	 */
	static public LuceneEngine instance() {
		if (null == _instance) {
			_instance = new LuceneEngine();
		}
		return _instance;
	}

	/**
	 * Process indexing for lucene search
	 */
	public void processIndexing() {
		if (isIndexing || isOptimizing) {
			return;
		}

		NpoLogMessage logMessage = new NpoLogMessage();
		logMessage.select("WEB9001");

		try {
			isIndexing = true;

			/** Connect to DB */
			this.dbConnection = new DBConnection("jdbc/datasource");
			this.connection = dbConnection.openConnection();

			// For contract
			this.indexContract(connection);

			// For prevent data
			this.indexPreventData(connection);

			// For transaction
			this.indexTransaction(connection);

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
            
            isIndexing = false;
        }

        if (isOptimizeWaiting) {
        	processOptimizing();
        }
	}
	
	/**
	 * Indexing for contract
	 * 
	 * @param liService
	 * @throws SQLException
	 * @throws IOException
	 */
	private void indexContract(Connection conn) throws SQLException, IOException {
		
		LuceneIndexService liService = new LuceneIndexService(conn);
		liService.addOrderFieldLuceneIndex(new OrderField(ORDER_FIELD));
		
		NpoLogMessage logMessage = new NpoLogMessage();
		logMessage.select("WEB9001");
		
		// For contract
		LuceneIndexList contractIndexList = liService
				.queryLuceneIndexByType(LuceneIndexInfo.TYPE_CONTRACT, 1, 1000,
						false);

		if (contractIndexList.size() > 0) {
			IndexWriter contractWriter = null;
			try {
				LuceneContractService lcService = new LuceneContractService();

				contractWriter = lcService.openWriter();

				if (contractWriter != null) {

					ContractService contractService = new ContractService(conn);

					for (int i = 0; i < contractIndexList.size(); i++) {

						LuceneIndexInfo liInfo = contractIndexList.get(i);
						
						try {
							if (LuceneIndexInfo.ACTION_REMOVE
									.equals(liInfo.getAction())) {
								lcService.removeContractDocument(
										contractWriter, liInfo.getDataId()
												.toString());
							} else {
								contractService.setContractIdFilter(liInfo
										.getDataId());
								ContractInfo contractInfo = contractService
										.queryContractById(false);
	
								if (contractInfo != null) {
									contractService.setContractIdPropertyFilter(liInfo
											.getDataId());
									
									PropertyList propList = contractService.queryAllPropertyByContract(false);
									if (propList.size() > 0) {
										PropertyInfo propInfo = propList.get(0);
										contractInfo.setPropertyType(propInfo.getType());
										contractInfo.setStreet(propInfo.getLandStreet());
										contractInfo.setDistrict(propInfo.getLandDistrict());
										
										String propertyInfo = "";
										if (propInfo.getPropertyInfo() != null) {
											propertyInfo = propInfo
													.getPropertyInfo();
										}
										if (!EditString.isNull(propInfo.getOwnerInfo())) {
											propertyInfo += Constants.ENTER
													+ SystemMessageProperties
															.getSystemProperty("item_owner")
													+ Constants.COLON
													+ Constants.SPACE
													+ propInfo.getOwnerInfo();
										}
										if (!EditString.isNull(propInfo.getOtherInfo())) {
											propertyInfo += Constants.ENTER
													+ SystemMessageProperties
															.getSystemProperty("item_other_info")
													+ Constants.COLON
													+ Constants.SPACE
													+ propInfo.getOtherInfo();
										}
										
										contractInfo.setPropertyInfo(propertyInfo);
									}
									
									if (LuceneIndexInfo.ACTION_CREATE.equals(liInfo
											.getAction())) {
										lcService.entryContractDocument(contractWriter,
												contractInfo);
									} else if (LuceneIndexInfo.ACTION_MODIFY
											.equals(liInfo.getAction())) {
										lcService.updateContractDocument(
												contractWriter, contractInfo);
									} 
								}
							}
							
							// Delete queue order
							liService.removeLuceneIndex(liInfo);
							
						} catch (Exception ex) {
							/** Write log */
							logger.logging(logMessage, ex);
							
							liInfo.setStatus(LuceneIndexInfo.STATUS_ERROR);
							liService.modifyLuceneIndex(liInfo);
						}

						contractWriter.commit();
						conn.commit();
					}
				}
			} catch (SQLException sqlError) {
				/** Write log */
				logger.logging(logMessage, sqlError);

			} catch (Exception exception) {
				/** Write log */
				logger.logging(logMessage, exception);
			} finally {
				if (contractWriter != null) {
					try {
						contractWriter.rollback();
					} finally {
						contractWriter.close();
					}
				}
			}
		}
	}
	
	/**
	 * Indexing for prevent data
	 * 
	 * @param liService
	 * @throws SQLException
	 * @throws IOException
	 */
	private void indexPreventData(Connection conn) throws SQLException, IOException {
		
		LuceneIndexService liService = new LuceneIndexService(conn);
		liService.addOrderFieldLuceneIndex(new OrderField(ORDER_FIELD));
		
		NpoLogMessage logMessage = new NpoLogMessage();
		logMessage.select("WEB9001");
		
		// For prevent data
		LuceneIndexList prventIndexList = liService.queryLuceneIndexByType(
				LuceneIndexInfo.TYPE_PREVENT_DATA, 1, 1000, false);

		if (prventIndexList.size() > 0) {
			IndexWriter preventWriter = null;
			try {
				LucenePreventService lcService = new LucenePreventService();

				preventWriter = lcService.openWriter();

				if (preventWriter != null) {
					PreventService prvService = new PreventService(conn);

					for (int i = 0; i < prventIndexList.size(); i++) {

						LuceneIndexInfo liInfo = prventIndexList.get(i);
						
						try {
							if (LuceneIndexInfo.ACTION_REMOVE
									.equals(liInfo.getAction())) {
								lcService.removeDataPreventDocument(
										preventWriter, liInfo.getDataId()
												.toString());
							} else {
								DataPreventInfo dataPreventInfo = prvService
									.queryDataPreventById(liInfo.getDataId(),
										false);
	
								if (dataPreventInfo != null) {
									if (LuceneIndexInfo.ACTION_CREATE.equals(liInfo
											.getAction())) {
										lcService.entryDataPreventDocument(
												preventWriter, dataPreventInfo);
									} else if (LuceneIndexInfo.ACTION_MODIFY
											.equals(liInfo.getAction())) {
										lcService.updateDataPreventDocument(
												preventWriter, dataPreventInfo);
									} 
								}
							}
							
							// Delete queue order
							liService.removeLuceneIndex(liInfo);
							
						} catch (Exception ex) {
							/** Write log */
							logger.logging(logMessage, ex);
							
							liInfo.setStatus(LuceneIndexInfo.STATUS_ERROR);
							liService.modifyLuceneIndex(liInfo);
						}
						
						preventWriter.commit();
						conn.commit();
					}
				}
			} catch (SQLException sqlError) {
				/** Write log */
				logger.logging(logMessage, sqlError);

			} catch (Exception exception) {
				/** Write log */
				logger.logging(logMessage, exception);
			} finally {
				if (preventWriter != null) {
					try {
						preventWriter.rollback();
					} finally {
						preventWriter.close();
					}
				}
			}
		}
	}
	
	/**
	 * Indexing for transaction
	 * 
	 * @param liService
	 * @throws SQLException
	 * @throws IOException
	 */
	private void indexTransaction(Connection conn) throws SQLException, IOException {
		
		LuceneIndexService liService = new LuceneIndexService(conn);
		liService.addOrderFieldLuceneIndex(new OrderField(ORDER_FIELD));
		
		NpoLogMessage logMessage = new NpoLogMessage();
		logMessage.select("WEB9001");
		
		// For transaction property
		LuceneIndexList transactionIndexList = liService
				.queryLuceneIndexByType(LuceneIndexInfo.TYPE_TRANSACTION, 1, 1000,
						false);

		if (transactionIndexList.size() > 0) {
			IndexWriter transactionWriter = null;
			try {
				LuceneTransactionPropertyService lcService = new LuceneTransactionPropertyService();

				transactionWriter = lcService.openWriter();

				if (transactionWriter != null) {
					PreventService prvService = new PreventService(conn);

					for (int i = 0; i < transactionIndexList.size(); i++) {

						LuceneIndexInfo liInfo = transactionIndexList.get(i);

						try {
							if (LuceneIndexInfo.ACTION_REMOVE
									.equals(liInfo.getAction())) {
								lcService.removeTransactionPropertyDocument(
										transactionWriter, liInfo.getDataId()
												.toString());
							} else {
								TransactionPropertyInfo tpInfo = prvService
									.queryTransactionPropertyByTpid(
										liInfo.getDataId(), false);
	
								if (tpInfo != null) {
									if (LuceneIndexInfo.ACTION_CREATE.equals(liInfo
											.getAction())) {
										lcService.entryTransactionPropertyDocument(
												transactionWriter, tpInfo);
									} else if (LuceneIndexInfo.ACTION_MODIFY
											.equals(liInfo.getAction())) {
										lcService.updateTransactionPropertyDocument(
												transactionWriter, tpInfo);
									} 
								}
							}
							
							// Delete queue order
							liService.removeLuceneIndex(liInfo);
							
						} catch (Exception ex) {
							/** Write log */
							logger.logging(logMessage, ex);
							
							liInfo.setStatus(LuceneIndexInfo.STATUS_ERROR);
							liService.modifyLuceneIndex(liInfo);
						}
						
						transactionWriter.commit();
						conn.commit();
					}
				}
			} catch (SQLException sqlError) {
				/** Write log */
				logger.logging(logMessage, sqlError);

			} catch (Exception exception) {
				/** Write log */
				logger.logging(logMessage, exception);
			} finally {
				if (transactionWriter != null) {
					try {
						transactionWriter.rollback();
					} finally {
						transactionWriter.close();
					}
				}
			}
		}
	}
	
	/**
	 * Optimize index file
	 */
	public void processOptimizing() {
		
		if (isOptimizing) {
			return;
		}
		
		if (isIndexing) {
			isOptimizeWaiting = true;
			return;
		}
		
		isOptimizing = true;
		isOptimizeWaiting = false;
		
		NpoLogMessage logMessage = new NpoLogMessage();
		logMessage.select("WEB9001");
		
		/* Optimize transaction */
		IndexWriter transactionWriter = null;
		try {
			LuceneTransactionPropertyService lcService = new LuceneTransactionPropertyService();
			transactionWriter = lcService.openWriter();
			if (transactionWriter != null) {
				transactionWriter.optimize();
			}
		} catch (Exception exception) {
				/* Write log */
				logger.logging(logMessage, exception);
		} finally {
			if (transactionWriter != null) {
				try {
					transactionWriter.close();
				} catch (CorruptIndexException e) {
					/* Write log */
					logger.logging(logMessage, e);
				} catch (IOException e) {
					/* Write log */
					logger.logging(logMessage, e);
				}
			}
		}
		
		/* Optimize prevent data */
		IndexWriter preventWriter = null;
		try {
			LucenePreventService lcService = new LucenePreventService();

			preventWriter = lcService.openWriter();

			if (preventWriter != null) {
				preventWriter.optimize();
			}
		} catch (Exception exception) {
				/* Write log */
				logger.logging(logMessage, exception);
		} finally {
			if (transactionWriter != null) {
				try {
					preventWriter.close();
				} catch (CorruptIndexException e) {
					/* Write log */
					logger.logging(logMessage, e);
				} catch (IOException e) {
					/* Write log */
					logger.logging(logMessage, e);
				}
			}
		}
		
		isOptimizing = false;
	}
}
