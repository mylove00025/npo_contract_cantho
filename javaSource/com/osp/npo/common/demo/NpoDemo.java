package com.osp.npo.common.demo;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;

import com.osp.npo.app.action.BaseMDAction;
import com.osp.npo.service.ContractService;
import com.osp.npo.service.PreventService;

/**
 * <P>Check demo System</P>
 *
 * @author HungPT
 * @version $Revision: 20014 $
 */
public class NpoDemo {

    public static final Boolean IS_DEMO = Boolean.FALSE;
    private static final int LIMIT_PREVENT_DATA = 20;
    private static final int LIMIT_CONTRACT = 100;
    private static final String URL_REGIST_PREVENT = "/datapreventregistregist";
    private static final String URL_REGIST_CONTRACT = "/contractregist";
    private static final String[] LIMITED_URL_LIST = new String[] {
        "/contractbyuserlistview", "/contractbyuserlistsearch", "/contractbyuserlistpaging", "/contractbyuserlistback", "/contractbyuserlistexport",
        "/contractbynotaryview", "/contractbynotarysearch", "/contractbynotarypaging", "/contractbynotaryreport", "/contractbynotaryback",
        "/contractbybankview", "/contractbybanksearch", "/contractbybankpaging", "/contractbybankreport", "/contractbybankback",
        "/contracterrorlistview", "/contracterrorlistsearch", "/contracterrorlistpaging", "/contracterrorexport",
        "/contractstatisticview", "/contractstatisticdone", "/contractstatisticexport"
    };

    public static boolean checkDemoSystem(BaseMDAction action, HttpServletRequest request, String url) throws SQLException, IOException {

        ContractService contractService = new ContractService(action.getConnection());
        PreventService preventService = new PreventService(action.getConnection());

        if (URL_REGIST_PREVENT.equals(url)
                && preventService.countTotalDataPreventByFilter() > LIMIT_PREVENT_DATA) {
            ActionErrors errors = new ActionErrors();
            errors.add("", new ActionMessage("err_limited_prevent", LIMIT_PREVENT_DATA));
            action.saveNpoErrors(request, errors);
            return false;
        } else if (URL_REGIST_CONTRACT.equals(url)
                && contractService.countTotalContractByFilter() > LIMIT_CONTRACT) {
            ActionErrors errors = new ActionErrors();
            errors.add("", new ActionMessage("err_limited_contract", LIMIT_CONTRACT));
            action.saveNpoErrors(request, errors);
            return false;
        } else {
            for (int i = 0; i < LIMITED_URL_LIST.length; i++) {
                if (LIMITED_URL_LIST[i].equals(url)) {
                    ActionErrors errors = new ActionErrors();
                    errors.add("", new ActionMessage("err_limited_in_trial"));
                    action.saveNpoErrors(request, errors);
                    return false;
                }
            }
        }

        return true;
    }
}
