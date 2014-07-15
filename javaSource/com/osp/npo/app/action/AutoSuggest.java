package com.osp.npo.app.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.osp.npo.common.util.DBConnection;
import com.osp.npo.service.ContractService;

public class AutoSuggest extends BaseMDAction {
    ContractService contractService;

    public AutoSuggest() {
        try {
            DBConnection db = new DBConnection("jdbc/datasource");
            contractService = new ContractService(db.openConnection());
        } catch (Exception sqlError) {
            System.out.println("Error");
        }
    }

    public List<String> getSuggestRelationObjA(String query) throws SQLException, IOException {
        query = query.toLowerCase();
        List<String> matched = contractService.selectSuggestRelationObjectA(query, 0, 10);

        return matched;
    }

    public List<String> getSuggestRelationObjB(String query) throws SQLException, IOException {
        query = query.toLowerCase();
        List<String> matched = contractService.selectSuggestRelationObjectB(query, 0, 10);

        return matched;
    }

    public List<String> getSuggestRelationObjC(String query) throws SQLException, IOException {
        query = query.toLowerCase();
        List<String> matched = contractService.selectSuggestRelationObjectC(query, 0, 10);

        return matched;
    }
}
