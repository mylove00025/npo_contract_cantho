package com.osp.npo.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.core.contract.ContractKindInfo;
import com.osp.npo.core.contract.ContractKindList;
import com.osp.npo.core.contract.ContractKindManager;
import com.osp.npo.core.contract.ContractKindTreeNode;
import com.osp.npo.core.contract.ContractKindTreeNode.DivStyle;

public class ContractKindService extends AbstractService {

    /** ContractKind Manager Object */
    private ContractKindManager contractKindManager;

    /** <P> Service constructor </P>*/
    public ContractKindService(Connection connection) {
        super(connection);
        this.contractKindManager = new ContractKindManager (connection);
    }

    /**
     * <P> entry ContractKindInfo object to database </P>
     *
     * @param info
     * @return number of record insert.
     * @throws SQLException
     */
    public int entryContract(ContractKindInfo info) throws SQLException{
        return this.contractKindManager.insert(info);
    }


    /**
     * <P> modify ContractKindInfo object to database </P>
     *
     * @param info
     * @return number of record update.
     * @throws SQLException
     * @throws IOException
     */
    public int modifyContract(ContractKindInfo info) throws SQLException, IOException{
        return this.contractKindManager.update(info);
    }


    /**
     * <P> remove Contract kind by id</P>
     *
     * @param id
     * @return number of record update.
     * @throws SQLException
     */
    public int removeContractKind(Long id) throws SQLException{
        return this.contractKindManager.delete(id);
    }


    /**
     * <P> query all of Contract kind list from database </P>
     *
     * @param forUpdate parameter
     * @return number of record query
     * @throws SQLException exception
     * @throws IOException exception
    */
    public ContractKindList queryAllContractKind(boolean forUpdate)
            throws SQLException, IOException{
        /* if limit < 0 or offset < 0 then select all */
        return this.contractKindManager.select(forUpdate, -1, -1);
    }
    
    /**
     * <P> query Contract Kind list from database </P>
     *
     * @param forUpdate
     * @param  page current page
     * @param  maxLine maximum line of a page
     * @return number of record query
     * @throws SQLException
     * @throws IOException
    */
    public ContractKindList queryContractKind(boolean forUpdate, int page, int maxLine)
            throws SQLException, IOException{
        /* Calculate start position of page */
        int offset = (page - 1) * maxLine;
        return this.contractKindManager.select(forUpdate, offset, maxLine);
    }

    /**
     * <P>
     * Contract info by id from database
     * </P>
     *
     * @param forUpdate
     * @return number of record query
     * @throws SQLException
     * @throws IOException
     */
    public ContractKindInfo queryContractKindInfoById(Long id, boolean forUpdate) throws SQLException, IOException {
        return this.contractKindManager.selectById(id, forUpdate);
    }
    
    /**
     * <P> count total contract kind </P>
     *
     * @param forUpdate
     * @return number of count record
     * @throws SQLException
     * @throws IOException
    */
    public int countTotalContractKind()
            throws SQLException, IOException{
        return this.contractKindManager.countTotal();
    }

    /**
    *
    * <P> get all children of one contract kind </P>
    *
    * @author GiangVT
    * @param forUpdate parameter
    * @param parentId parameter (always is null)
    * @return list of Contract kind tree node
    * @throws SQLException exception
    * @throws IOException exception
    */
    @SuppressWarnings("unchecked")
    public List<ContractKindTreeNode> getContractKindTree(boolean forUpdate, Long parentId)
            throws SQLException, IOException {
        ContractKindManager ckm = new ContractKindManager(getConnection());
        ckm.addOrderField(new OrderField("order_number", OrderType.ASC));

        List<ContractKindInfo> result = ckm.select(forUpdate, -1, -1).getList();

        List<ContractKindTreeNode> lstResult = new ArrayList<ContractKindTreeNode>();
        for (ContractKindInfo info : result) {
            ContractKindTreeNode node = new ContractKindTreeNode();
            node.setChildren(null);
            node.setId(info.getId());
            node.setDivStyle(DivStyle.NODE.getValue());
            node.setLevel(0);
            node.setName(info.getName());
            node.setParentId(null);
            lstResult.add(node);
        }

        return lstResult;
    }
    
    /**
     *
     * <P> get all children of one contract kind </P>
     *
     * @author GiangVT
     * @param forUpdate parameter
     * @param parentId parameter
     * @return list of Contract kind tree node
     * @throws SQLException exception
     * @throws IOException exception
     */
    @SuppressWarnings("unchecked")
    public List<ContractKindTreeNode> getContractKindTreeOld(boolean forUpdate, Long parentId)
            throws SQLException, IOException {
        ContractKindManager ckm = new ContractKindManager(getConnection());
        if (parentId != null) {
            ckm.setParentKindIdFilter(parentId);
        } else {
            // ckm.setOnlyRootFilter(Boolean.TRUE);
        }
        List<ContractKindInfo> result = ckm.select(forUpdate, -1, -1).getList();

        // set every node to tree
        ContractKindTreeNode tmpRoot = new ContractKindTreeNode();
        for (int i = 0; i < result.size(); i++) {
            ContractKindInfo ckInfo = result.get(i);

            ContractKindTreeNode cktNode = new ContractKindTreeNode();
            cktNode.setId(ckInfo.getId());
            cktNode.setParentId(ckInfo.getParentKindId());
            cktNode.setName(ckInfo.getName());
            cktNode.setDivStyle(DivStyle.NODE.getValue());

            tmpRoot.addChild(cktNode);
        }

        // every node has children (always event total is 0)
        if (tmpRoot.getChildren() == null) {
            tmpRoot.setChildren(new ArrayList<ContractKindTreeNode>());
        }

        // set children after root, which has parent is 0, null or not exist
        ContractKindTreeNode cktnRoot = new ContractKindTreeNode();
        for (int i = 0; i < tmpRoot.getChildren().size(); i++) {
            ContractKindTreeNode cktNode = tmpRoot.getChildren().get(i);
            if (cktNode.getParentId() == null) {
                cktnRoot.addChild(cktNode);
            } else {
                for (int j = 0; j < tmpRoot.getChildren().size(); j++) {
                    ContractKindTreeNode tmpNode = tmpRoot.getChildren().get(j);
                    if (cktNode.getParentId().equals(tmpNode.getId())) {
                        tmpNode.addChild(cktNode);
                    }
                }
            }
        }

        // recursive
        List<ContractKindTreeNode> lstResult = cktnRoot.parseChildrenList();

        List<ContractKindTreeNode> tmpParent = new ArrayList<ContractKindTreeNode>();
        // set level to tree node
        // 1st way: track parent
        if (lstResult.size() > 0) {
            lstResult.get(0).setLevel(0);
            tmpParent.clear();
            tmpParent.add(0, lstResult.get(0));
            for (int i = 1; i < lstResult.size(); i++) {
                if (lstResult.get(i).getParentId() == null) {
                    lstResult.get(i).setLevel(0);
                    tmpParent.clear();
                    tmpParent.add(0, lstResult.get(i));
                } else {
                    boolean isStandAloneTree = true;
                    for (int j = tmpParent.size() - 1; j >= 0; j--) {
                        if (lstResult.get(i).getParentId().longValue() == tmpParent.get(j).getId().longValue()) {
                            lstResult.get(i).setLevel(tmpParent.get(j).getLevel() + 1);
                            // if checking node is not child of last temporary parent
                            if (j < tmpParent.size() - 1) {
                                for (int k = tmpParent.size() - 1; k > j; k--) {
                                    tmpParent.remove(k);
                                }
                            }
                            tmpParent.add(lstResult.get(i));
                            isStandAloneTree = false;
                            break;
                        }
                    }
                    if (isStandAloneTree) {
                        lstResult.get(i).setLevel(0);
                        tmpParent.clear();
                        tmpParent.add(0, lstResult.get(i));
                    }
                }
            }
        }

        // 2nd way: build tree-backbone, 2 times travel tree.

        return lstResult;
    }


    /**
     * @param idFilter the idFilter to set
     */
    public void setIdFilter(Long idFilter) {
        this.contractKindManager.setIdFilter(idFilter);
    }

    /**
     * @param parentKindIdFilter the parentKindIdFilter to set
     */
    public void setParentKindIdFilter(Long parentKindIdFilter) {
        this.contractKindManager.setParentKindIdFilter(parentKindIdFilter);
    }
    
    
    /**
     * Add order field for table npo_contract_kind
     * @param orderField
     */
    public void addOrderFieldName(OrderField orderField) {
        this.contractKindManager.addOrderField(orderField);
    }
    
    /**
     * 
     * @param nameFilter
     * @param kind
     */
    public void setNameFilter(String nameFilter,FilterKind kind) {
        this.contractKindManager.setNameFilter(nameFilter, kind);
    }
}
