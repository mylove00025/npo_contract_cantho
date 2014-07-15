package com.osp.npo.app.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts2.views.util.TextUtil;

import com.osp.npo.app.viewhelper.ContractViewHelper;
import com.osp.npo.app.viewhelper.CustomerListViewHelper;
import com.osp.npo.common.global.Constants.FilterKind;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.OrderField;
import com.osp.npo.core.OrderField.OrderType;
import com.osp.npo.core.basicData.DistrictInfo;
import com.osp.npo.core.common.SystemConfigInfo;
import com.osp.npo.core.contract.ContractKindTreeNode;
import com.osp.npo.core.contract.ContractList;
import com.osp.npo.core.contract.ContractNumberInfo;
import com.osp.npo.core.contract.ContractTemplateInfo;
import com.osp.npo.core.contract.LostNumberInfo;
import com.osp.npo.core.contract.PropertyInfo;
import com.osp.npo.core.customer.CustomerList;
import com.osp.npo.service.BasicDataService;
import com.osp.npo.service.CommonService;
import com.osp.npo.service.ContractKindService;
import com.osp.npo.service.ContractNumberService;
import com.osp.npo.service.ContractService;
import com.osp.npo.service.CustomerService;
import com.osp.npo.service.LostNumberService;

/**
 *
 * AjaxAction
 *
 * @author Giangvt
 * @version $Revision: 31114 $
 */
@SuppressWarnings("unchecked")
public class AjaxAction extends BaseMDAction {

    private static final String CONTRACT_KIND_ID = "contractid";
    private static final String FIELD_ID = "fieldId";
    private static final String FIELD_NAME = "fieldName";
    private static final String SELECTED_ID = "selectedId";
//    private static final String KIND_ID = "kindId";
    private static final String TYPE = "type";
    private static final String DOT = "\\.";
    private static final String PROVINCE_ID = "provinceId";
    private static final String PROVINCE_ALL = "00";
    private static final String HAS_OPTION_ALL = "hasOptionAll";
    private static final String HAS_OPTION_SELECT = "hasOptionSelect";
    private static final String ORDER_FIELD_DISTRICT = "order_number";
    private static final String NO_LOGIN = "nologin";

    private static final String SUCCESS = "success";
    private static final String REMOVED_ID = "removedId";

    private static final String IS_CONTRACT_REGIST = "isContractRegist";
    private static final Long TOTAL_NUMBER = (long) 0;
    private static final int NUMBER_CUSTOMER = 10;
    
    
    

    private static final String ORDER_FIELD_FREQUENCY = "frequency";

    String fileType[][] = { { ".doc", "./image/fileicons/doc.gif" }, { ".docx", "./image/fileicons/doc.gif" },
            { ".xls", "./image/fileicons/xls.gif" }, { ".xlsx", "./image/fileicons/xls.gif" }, { ".csv", "./image/fileicons/csv.gif" },
            { ".ppt", "./image/fileicons/ppt.gif" }, { ".pptx", "./image/fileicons/ppt.gif" }, { ".pps", "./image/fileicons/pps.gif" },
            { ".ppsx", "./image/fileicons/pps.gif" }, { ".pdf", "./image/fileicons/pdf.gif" }, { ".txt", "./image/fileicons/txt.gif" },
            { ".jpeg", "./image/fileicons/jpg.gif" }, { ".jpg", "./image/fileicons/jpg.gif" }, { ".png", "./image/fileicons/png.gif" },
            { ".rar", "./image/fileicons/zip.gif" }, { ".zip", "./image/fileicons/zip.gif" } };

    public String getIcon(String fileName) {
        fileName = fileName.toLowerCase();
        for (int i = 0; i < fileType.length; i++) {
            if (fileName.endsWith(fileType[i][0])) {
                return fileType[i][1];
            }
        }
        return "./image/fileicons/unknown.gif";
    }

    /**
     *
     * get all Contract kind children by parent ID call template:
     * onclick="retrieveURL('getContractKindChildren.do?contractid=1');"
     *
     * @author Giangvt
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward getContractKindChildren(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
//        Long contractKindId = (Long) request.getAttribute(CONTRACT_KIND_ID);
//        ContractKindService contractKindService = new ContractKindService(getConnection());
//        List<ContractKindTreeNode> lstContractKindTree;
//        if (contractKindId == 0) {
//            // get root contract kind
//            lstContractKindTree = contractKindService.getContractKindTree(false, null);
//        } else {
//            lstContractKindTree = contractKindService.getContractKindTree(false, contractKindId);
//        }
        String html = "";
        /*
         * for (ContractKindInfo contractKindInfo : lstContractKindInfo) { if
         * (contractKindInfo.getChildrenNumber() == 0) { html +=
         * "<span class=\"node_folder\">"; html += contractKindInfo.getName();
         * html += "</span>"; html += "<div>"; html += "</div>"; } else { html
         * +=
         * "<span class=\"tree_open\" onclick=\"javascript:toogle_view('node_";
         * // id html += contractKindInfo.getId().toString(); html +=
         * "');\"></span>"; html += "<div class=\"div_node\" id=\"node_"; html
         * += contractKindInfo.getId().toString(); html += "\">"; html +=
         * "</div>"; } }
         */
        // render html
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(html);
        out.flush();

        return null;
    }

    /**
     *
     * get all contract templates by contract kind id
     *
     * @author Giangvt
     * @param mapping
     *            for mapping
     * @param form
     *            for form
     * @param request
     *            for request
     * @param response
     *            for response
     * @return null
     * @throws Exception
     *             process
     */
    public ActionForward getContractTemplates(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Long contractKindId = Long.parseLong(request.getParameter(CONTRACT_KIND_ID));
        ContractService service = new ContractService(getConnection());
        service.setContractTemplateKindIdFilter(contractKindId);
        service.setContractTemplateActiveFlgFilter(Boolean.TRUE);
        List<ContractTemplateInfo> lstTemplateInfo = service.queryAllContractTemplate(false).getList();
        String html = "";
        if (lstTemplateInfo.size() > 0) {
            @SuppressWarnings("unused")
			SimpleDateFormat dateFormat = new SimpleDateFormat(RelateDateTime.DDMMYYYY);
            html +="<table class=\"table_template_item\">";
            for (ContractTemplateInfo temp : lstTemplateInfo) {
            	if (temp.getFileName() != null && !"".equals(temp.getFileName())) {
	            	html += "<tr class=\"tr_template_item\"><td style='width:20px'>";
	                html += "<div class=\"div_template_item_icon\">";
	                if (temp.getFileName() != null) {
	                	
	                    html += "<img src=\"" + getIcon(temp.getFileName()) + "\"/>&nbsp";
	                	
	                } else {
	                    html += "&nbsp&nbsp&nbsp&nbsp&nbsp";
	                }
	                html += "</div>";
	                html += "</td>";
	                html += "<td>";
	                html += "<div class=\"div_template_item_name\">";
	                html += "   <a href=\"javascript:download(" + temp.getId() + ");\">";
	                html += temp.getName();
	                html += "   </a>";                
	                html += "</div>";
	                html += "</td></tr>";
            	}
            }
            html +="</table>";
        }
        // render html
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(html);
        out.flush();

        return null;
    }

    /**
     *
     * get all contract templates by contract kind id
     *
     * @author HungPT
     * @param mapping
     *            for mapping
     * @param form
     *            for form
     * @param request
     *            for request
     * @param response
     *            for response
     * @return null
     * @throws Exception
     *             process
     */
    public ActionForward calculateTotalCost(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String costTt91 = request.getParameter("costTt91");
        String costDraft = request.getParameter("costDraft");
        String costNotaryOutsite = request.getParameter("costNotaryOutsite");
        String costOtherDetermine = request.getParameter("costOtherDetermine");

        costTt91 = costTt91.replaceAll(DOT, "");
        costDraft = costDraft.replaceAll(DOT, "");
        costNotaryOutsite = costNotaryOutsite.replaceAll(DOT, "");
        costOtherDetermine = costOtherDetermine.replaceAll(DOT, "");

        Long val1 = 0L;
        Long val2 = 0L;
        Long val3 = 0L;
        Long val4 = 0L;
        if (!EditString.isNull(costTt91) && EditString.isNumber(costTt91) && costTt91.length() < 20) {
            val1 = Long.parseLong(costTt91);
        }

        if (!EditString.isNull(costDraft) && EditString.isNumber(costDraft) && costDraft.length() < 20) {
            val2 = Long.parseLong(costDraft);
        }

        if (!EditString.isNull(costNotaryOutsite) && EditString.isNumber(costNotaryOutsite) && costNotaryOutsite.length() < 20) {
            val3 = Long.parseLong(costNotaryOutsite);
        }

        if (!EditString.isNull(costOtherDetermine) && EditString.isNumber(costOtherDetermine) && costOtherDetermine.length() < 20) {
            val4 = Long.parseLong(costOtherDetermine);
        }

        // render html
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(val1 + val2 + val3 + val4);
        out.flush();

        return null;
    }
    
    /**
    *
    * get all relation 
    *
    * @author HungNM
    * @param mapping
    *            for mapping
    * @param form
    *            for form
    * @param request
    *            for request
    * @param response
    *            for response
    * @return null
    * @throws Exception
    *             process
    */
	
	public ActionForward searchRelation(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

//		request.setCharacterEncoding("UTF-8");
		String val = request.getParameter("relationObject");
//		val = EditString.convertUnicodeToASCII(val);
//		val = new String(val.getBytes(), "UTF-8");
//		val = EditString.convertUnicodeToASCII(val);
		String direction = request.getParameter("direction");
		CustomerListViewHelper customerListViewHelper = (CustomerListViewHelper) request
				.getSession().getAttribute(CustomerListViewHelper.SESSION_KEY);
		if (customerListViewHelper==null){
			customerListViewHelper = new CustomerListViewHelper();
			request.getSession().setAttribute(
					CustomerListViewHelper.SESSION_KEY, customerListViewHelper);
		}

		if (val != null && val.length() > 1) {
			try {
				val = val.replaceAll("#37;", "%");
				val = val.replaceAll("#38;", "&");
				
				CustomerService customerService = new CustomerService(
						getConnection());
				customerService.setCustomerFilter(val, FilterKind.MIDDLE);
				Integer totalCount = customerService.countTotalCustomer();
				customerListViewHelper.setTotalCount(totalCount);
				
				customerService.addOrderFieldCustomer(new OrderField(ORDER_FIELD_FREQUENCY, OrderType.DESC));
				
				if (totalCount != 0) {
					
						Integer totalPage = pageCalculation(totalCount, NUMBER_CUSTOMER);
						customerListViewHelper.setTotalPage(totalPage);
						customerListViewHelper.setPage(pageTransition(direction,
								customerListViewHelper.getPage(), totalPage));
						customerListViewHelper.setKeyHighLight(val);
						
						CustomerList customerList = customerService.queryCustomer(
								false, customerListViewHelper.getPage(), NUMBER_CUSTOMER);
						customerListViewHelper.setCustomerList(customerList.getList());
					
					return mapping.findForward(SUCCESS);
				} else {
					return null;
				}
			} catch (Exception ex) {
				//Do nothing
			}
			return null;
		} else {
			return null;
		}

	}
	
	public ActionForward checkContractNumber(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		String contractNumber = new String(request.getParameter("contractNumber").getBytes("ISO8859_1"), "UTF8");
		
		contractNumber = contractNumber.replaceAll("@@@@@", "%");
		contractNumber = contractNumber.replaceAll("UCHIUCHI", "Đ");
		contractNumber = contractNumber.replaceAll("UMIUMI", "đ");


		ContractService contractService = new ContractService(getConnection());
		contractService.setContractNumberFilter(contractNumber, FilterKind.FULL);
		ContractList contractList = new ContractList();
		contractList = contractService.queryAllContract(false);
		String html="";
		if (contractList.size()!=0)
		{	html += "<span style=\"color: red\" >";
			html += "<img style=\"width: 15px; vertical-align: middle;\" src=\"./image/icon_check_contract.gif\" />";
			html += "  Số hợp đồng đã  tồn tại!";
			html += "<sqan/>";
		}
		
		
		// render html
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(html);
        out.flush();
		return null;
	}
	
	public ActionForward issueContractNumber(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Long contractTemplateId = Long.parseLong(request
				.getParameter("contracttemplateid"));
		CommonService commonService = new CommonService(getConnection());
		ContractService contractService = new ContractService(getConnection());
		ContractTemplateInfo contractTemplateInfo = contractService
				.queryContractTemplateInfoById(contractTemplateId, false);
		Long contractKindId = contractTemplateInfo.getKindId();

		ContractNumberService contractNumberService = new ContractNumberService(
				getConnection());
		ContractNumberInfo contractNumberInfo;
		SystemConfigInfo systemConfigInfo = commonService
				.querySystemConfigByKey("number_formula", false);
		String numberFormula = systemConfigInfo.getConfigValue();
		if (numberFormula.contains("#NUM#")) {
			contractNumberInfo = contractNumberService
					.queryContractNumberByContractKindId(TOTAL_NUMBER);
			numberFormula = numberFormula.replaceAll("#NUM#", contractNumberInfo
					.getContractNumber().toString());
		} else {
			contractNumberInfo = contractNumberService
					.queryContractNumberByContractKindId(contractKindId);
			numberFormula = numberFormula.replaceAll("#num#",
					contractNumberInfo.getContractNumber().toString());
		}

		if (numberFormula.contains("#CC#"))
			if (contractTemplateInfo.getCode() != null
					&& !"".equals(contractTemplateInfo.getCode().trim())) {
				numberFormula = numberFormula.replaceAll("#CC#",
						contractTemplateInfo.getCode());
			} else {
				numberFormula = numberFormula.replaceAll("#CC#","");
			}
		if (numberFormula.contains("#YEAR#"))
			numberFormula = numberFormula.replaceAll("#YEAR#",
					String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));

		// request.setCharacterEncoding("UTF-8");
		// String contractNumber = new
		// String(request.getParameter("contractNumber").getBytes("ISO8859_1"),
		// "UTF8");
		//
		//
		// ContractService contractService = new
		// ContractService(getConnection());
		// contractService.setContractNumberFilter(contractNumber,
		// FilterKind.FULL);
		// ContractList contractList = new ContractList();
		// contractList = contractService.queryAllContract(false);
		// String html="";
		// if (contractList.size()!=0)
		// { html += "<span style=\"color: red\" >";
		// html +=
		// "<img style=\"width: 15px; vertical-align: middle;\" src=\"./image/icon_check_contract.gif\" />";
		// html += "  Số hợp đồng đã  tồn tại!";
		// html += "<sqan/>";
		// }
		//
		//
		// render html
		String html = numberFormula;
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(html);
		out.flush();
		return null;
	}
	
	public ActionForward checkLostNumber(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String contractNumber = request
				.getParameter("contractNumber");
		
		Long kindId = Long.parseLong(request
				.getParameter("kindId"));
		
		LostNumberInfo lostNumberInfo = null;
		String html = "true";
		if (EditString.getNumber(contractNumber)!= null) {
			ContractNumberService contractNumberService = new ContractNumberService(
					getConnection());
			ContractNumberInfo contractNumberInfo;
			Long checkNumber = Long.parseLong(EditString.getNumber(contractNumber));
			LostNumberService lostNumberService = new LostNumberService(getConnection());
			CommonService commonService = new CommonService(getConnection());
			lostNumberInfo = new LostNumberInfo();
			SystemConfigInfo systemConfigInfo = commonService
			.querySystemConfigByKey("number_formula", false);
			String numberFormula = systemConfigInfo.getConfigValue();
			if (numberFormula.contains("#NUM#")) {
				contractNumberInfo = contractNumberService
				.queryContractNumberByContractKindId(TOTAL_NUMBER);	
				if (contractNumberInfo.getContractNumber()<=checkNumber) {
					html = "true";
				} else {
				lostNumberInfo.setKindId(TOTAL_NUMBER);
				lostNumberInfo.setYear(Calendar.getInstance().get(Calendar.YEAR));
				lostNumberInfo.setLostContractNumber(checkNumber);
				lostNumberInfo = lostNumberService.queryLostNumber(lostNumberInfo);
				}
			} else {
				contractNumberInfo = contractNumberService
				.queryContractNumberByContractKindId(kindId);	
				if (contractNumberInfo.getContractNumber()<=checkNumber) {
					html= "true";
				} else {
				lostNumberInfo.setKindId(kindId);
				lostNumberInfo.setYear(Calendar.getInstance().get(Calendar.YEAR));
				lostNumberInfo.setLostContractNumber(checkNumber);
				lostNumberInfo = lostNumberService.queryLostNumber(lostNumberInfo);
			} 
		}
				if (lostNumberInfo!=null) {
					html = "true";
				} else html = "false";
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(html);
		out.flush();
		return null;
	}


    /**
     *
     * Get contract kind tree node
     *
     * @author HungPT
     * @param mapping
     *            for mapping
     * @param form
     *            for form
     * @param request
     *            for request
     * @param response
     *            for response
     * @return null
     * @throws Exception
     *             process
     */
    public ActionForward getContractKindTreeNode(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String fieldName = (String) request.getParameter(FIELD_NAME);
        String fieldId = (String) request.getParameter(FIELD_ID);
        String selectedId = (String) request.getParameter(SELECTED_ID);
        String type = (String) request.getParameter(TYPE);
        String isContractRegist = (String) request.getParameter(IS_CONTRACT_REGIST);

        ContractKindService service = new ContractKindService(getConnection());

        String html = "";
        if (EditString.isNull(isContractRegist)) {
            html = "<select id=\"" + fieldId + "\" name=\"" + fieldName + "\"\">";
        } else {
            html = "<select id=\"" + fieldId + "\" name=\"" + fieldName + "\"\" onclick=\"changeKind(this.value);\">";
        }

        if (EditString.isNull(type)) {
            html += "<option value=\"\"></option>";
        } else {
            if ("1".equals(type)) {
                html += "<option value=\"0\">" + SystemMessageProperties.getSystemProperty("item_all") + "</option>";
            }
            if ("2".equals(type)) {
                html += "<option value=\"0\">" + SystemMessageProperties.getSystemProperty("item_select") + "</option>";
            }
        }

        for (ContractKindTreeNode node : service.getContractKindTree(false, null)) {
            if (!EditString.isNull(selectedId) && selectedId.equals(node.getId().toString())) {
                html += "<option value=\"" + node.getId() + "\" selected>" + getSpaces(node.getLevel()) + TextUtil.escapeHTML(node.getName())
                        + "</option>";
            } else {
                html += "<option value=\"" + node.getId() + "\">" + getSpaces(node.getLevel()) + TextUtil.escapeHTML(node.getName()) + "</option>";
            }

        }

        html += "</select>";

        // render html
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(html);
        out.flush();

        return null;
    }

    /**
     * Get space
     *
     * @param num
     *            number of space
     * @return
     */
    private String getSpaces(int num) {
        String spaces = "";
        for (int i = 0; i < num; i++) {
            spaces += "&nbsp;&nbsp;&nbsp;";
        }
        return spaces;
    }

    /**
     * <P>
     * Action get districts
     * </P>
     *
     * @author HungPT
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward getDistrict(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String provinceId = (String) request.getParameter(PROVINCE_ID);
        String fieldId = (String) request.getParameter(FIELD_ID);
        String fieldName = (String) request.getParameter(FIELD_NAME);
        String optionAll = (String) request.getParameter(HAS_OPTION_ALL);
        String optionSelect = (String) request.getParameter(HAS_OPTION_SELECT);
        String selectedId = (String) request.getParameter(SELECTED_ID);
        if (provinceId == null) {
            provinceId = "";
        }

        BasicDataService basicDataService = new BasicDataService(getConnection());
        List<DistrictInfo> districtList = null;
        if (!PROVINCE_ALL.equals(provinceId)) {
            basicDataService.setProvinceIdFilter(new Long(provinceId));
            basicDataService.addOrderFieldProvince(new OrderField(ORDER_FIELD_DISTRICT));
            districtList = basicDataService.queryAllDistrict(false).getList();
        }

        String html = "<select id=\"" + fieldId + "\" name=\"" + fieldName + "\">";

        if (optionAll != null) {
            html += "<option value=\"0\">" + SystemMessageProperties.getSystemProperty("item_all") + "</option>";
        } else if (optionSelect != null) {
            html += "<option value=\"0\">" + SystemMessageProperties.getSystemProperty("item_select") + "</option>";
        }

        for (DistrictInfo districtInfo : districtList) {
            if (selectedId != null && selectedId.equals(districtInfo.getId().toString())) {
                html += "<option value=\"" + districtInfo.getId() + "\" selected>" + TextUtil.escapeHTML(districtInfo.getName()) + "</option>";
            } else {
                html += "<option value=\"" + districtInfo.getId() + "\">" + TextUtil.escapeHTML(districtInfo.getName()) + "</option>";
            }
        }
        html += "</select>";

        // Write the HTML to response
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(html);
        out.flush();

        return null;
    }

    /**
     *
     * Show properties
     *
     * @author HungPT
     * @param mapping
     *            for mapping
     * @param form
     *            for form
     * @param request
     *            for request
     * @param response
     *            for response
     * @return null
     * @throws Exception
     *             process
     */
    public ActionForward showProperties(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String idRemove = (String) request.getParameter(REMOVED_ID);

        ContractViewHelper contractViewHelper = (ContractViewHelper) request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
        if (contractViewHelper == null) {
            return mapping.findForward(NO_LOGIN);
        }

        List<PropertyInfo> propertyList = contractViewHelper.getPropertyList();

        if (!EditString.isNull(idRemove)) {
            propertyList.remove(Integer.parseInt(idRemove));
            contractViewHelper.setPropertyList(propertyList);
        }

        return mapping.findForward(SUCCESS);
    }

    /**
     *
     * Show property in popup
     *
     * @author HungPT
     * @param mapping
     *            for mapping
     * @param form
     *            for form
     * @param request
     *            for request
     * @param response
     *            for response
     * @return null
     * @throws Exception
     *             process
     */
    public ActionForward showPropertyPopup(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

//        ContractViewHelper contractViewHelper = (ContractViewHelper) request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
//        if (contractViewHelper == null) {
//            return mapping.findForward(NO_LOGIN);
//        }
//        
//        BasicDataService basicDataService = new BasicDataService(getConnection());
//
//        String selectedId = (String) request.getParameter(SELECTED_ID);
//
//        if (!EditString.isNull(selectedId)) {
//            List<PropertyInfo> propertyList = contractViewHelper.getPropertyList();
//
//            PropertyInfo propertyInfo = propertyList.get(Integer.parseInt(selectedId));
//            contractViewHelper.setPropertyTypePopup(propertyInfo.getType());
//            contractViewHelper.setTitlePopup(propertyInfo.getTitle());
//            if (LAND_TYPE.equals(propertyInfo.getType())) {
//                contractViewHelper.setProvinceLandPopup(propertyInfo.getProvince());
//                contractViewHelper.setDistrictPopup(propertyInfo.getDistrict());
//                contractViewHelper.setPropertyCodeLandPopup(propertyInfo.getCode());
//                if (propertyInfo.getGivenDate() != null) {
//                    contractViewHelper.setGivenDateLandPopup(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, propertyInfo.getGivenDate()));
//                } else {
//                    contractViewHelper.setGivenDateLandPopup(null);
//                }
//                contractViewHelper.setMapNumberPopup(propertyInfo.getMapNumber());
//                contractViewHelper.setLandNumberPopup(propertyInfo.getLandNumber());
//                contractViewHelper.setLandAddressPopup(propertyInfo.getLandAddress());
//                contractViewHelper.setOwnerNamePopup(propertyInfo.getOwnerName());
//                contractViewHelper.setOwnerIdCardPopup(propertyInfo.getOwnerIdCard());
//                contractViewHelper.setOwnerAddressPopup(propertyInfo.getOwnerAddress());
//                
//                basicDataService.setProvinceIdFilter(propertyInfo.getProvince());
//                basicDataService.addOrderFieldProvince(new OrderField(ORDER_FIELD_DISTRICT));
//                contractViewHelper.setDistrictList(basicDataService.queryAllDistrict(false).getList());
//
//            } else if (VEHICLE_CAR_TYPE.equals(propertyInfo.getType()) || VEHICLE_MOTOR_TYPE.equals(propertyInfo.getType())) {
//                contractViewHelper.setProvinceVehiclePopup(propertyInfo.getProvince());
//                contractViewHelper.setPropertyCodeVehiclePopup(propertyInfo.getCode());
//                if (propertyInfo.getGivenDate() != null) {
//                    contractViewHelper.setGivenDateVehiclePopup(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, propertyInfo.getGivenDate()));
//                } else {
//                    contractViewHelper.setGivenDateVehiclePopup(null);
//                }
//                contractViewHelper.setFrameNumberPopup(propertyInfo.getFrameNumber());
//                contractViewHelper.setMachineNumberPopup(propertyInfo.getMachineNumber());
//                contractViewHelper.setOwnerNamePopup(propertyInfo.getOwnerName());
//                contractViewHelper.setOwnerIdCardPopup(propertyInfo.getOwnerIdCard());
//                contractViewHelper.setOwnerAddressPopup(propertyInfo.getOwnerAddress());
//
//            } else if (OTHER_TYPE.equals(propertyInfo.getType())) {
//                contractViewHelper.setPropertyCodeOtherPopup(propertyInfo.getCode());
//                contractViewHelper.setPropertyOtherInfoPopup(propertyInfo.getOtherInfo());
//                contractViewHelper.setOwnerNamePopup(propertyInfo.getOwnerName());
//                contractViewHelper.setOwnerIdCardPopup(propertyInfo.getOwnerIdCard());
//                contractViewHelper.setOwnerAddressPopup(propertyInfo.getOwnerAddress());
//            }
//        } else {
//            contractViewHelper.setPropertyTypePopup(LAND_TYPE);
//            Long propviceId = contractViewHelper.getProvinceList().get(0).getId();
//            contractViewHelper.setProvinceLandPopup(propviceId);
//            contractViewHelper.setDistrictPopup(0L);
//            contractViewHelper.setPropertyCodeLandPopup(null);
//            contractViewHelper.setGivenDateLandPopup(null);
//            contractViewHelper.setMapNumberPopup(null);
//            contractViewHelper.setLandNumberPopup(null);
//            contractViewHelper.setLandAddressPopup(null);
//
//            contractViewHelper.setProvinceVehiclePopup(propviceId);
//            contractViewHelper.setPropertyCodeVehiclePopup(null);
//            contractViewHelper.setGivenDateVehiclePopup(null);
//            contractViewHelper.setFrameNumberPopup(null);
//            contractViewHelper.setMachineNumberPopup(null);
//
//            contractViewHelper.setPropertyCodeOtherPopup(null);
//            contractViewHelper.setPropertyOtherInfoPopup(null);
//            
//            contractViewHelper.setOwnerNamePopup(null);
//            contractViewHelper.setOwnerIdCardPopup(null);
//            contractViewHelper.setOwnerAddressPopup(null);
//        }

        return mapping.findForward(SUCCESS);
    }

    /**
     *
     * Show property
     *
     * @author HungPT
     * @param mapping
     *            for mapping
     * @param form
     *            for form
     * @param request
     *            for request
     * @param response
     *            for response
     * @return null
     * @throws Exception
     *             process
     */
    public ActionForward showProperty(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

//        ContractViewHelper contractViewHelper = (ContractViewHelper) request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
//        if (contractViewHelper == null) {
//            return mapping.findForward(NO_LOGIN);
//        }
//        
//        BasicDataService basicDataService = new BasicDataService(getConnection());
//        
//        List<PropertyInfo> propertyList = contractViewHelper.getPropertyList();
//        if (propertyList.size() > 0) {
//            PropertyInfo propertyInfo = propertyList.get(0);
//            contractViewHelper.setPropertyType(propertyInfo.getType());
//            if (LAND_TYPE.equals(propertyInfo.getType())) {
//                contractViewHelper.setProvinceLand(propertyInfo.getProvince());
//                contractViewHelper.setDistrict(propertyInfo.getDistrict());
//                contractViewHelper.setPropertyCodeLand(propertyInfo.getCode());
//                if (propertyInfo.getGivenDate() != null) {
//                    contractViewHelper.setGivenDateLand(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, propertyInfo.getGivenDate()));
//                }
//                contractViewHelper.setMapNumber(propertyInfo.getMapNumber());
//                contractViewHelper.setLandNumber(propertyInfo.getLandNumber());
//                contractViewHelper.setLandAddress(propertyInfo.getLandAddress());
//                contractViewHelper.setOwnerName(propertyInfo.getOwnerName());
//                contractViewHelper.setOwnerIdCard(propertyInfo.getOwnerIdCard());
//                contractViewHelper.setOwnerAddress(propertyInfo.getOwnerAddress());
//                
//                basicDataService.setProvinceIdFilter(propertyInfo.getProvince());
//                basicDataService.addOrderFieldProvince(new OrderField(ORDER_FIELD_DISTRICT));
//                contractViewHelper.setDistrictList(basicDataService.queryAllDistrict(false).getList());
//
//            } else if (VEHICLE_CAR_TYPE.equals(propertyInfo.getType()) || VEHICLE_MOTOR_TYPE.equals(propertyInfo.getType())) {
//                contractViewHelper.setProvinceVehicle(propertyInfo.getProvince());
//                contractViewHelper.setPropertyCodeVehicle(propertyInfo.getCode());
//                if (propertyInfo.getGivenDate() != null) {
//                    contractViewHelper.setGivenDateVehicle(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, propertyInfo.getGivenDate()));
//                }
//                contractViewHelper.setFrameNumber(propertyInfo.getFrameNumber());
//                contractViewHelper.setMachineNumber(propertyInfo.getMachineNumber());
//                contractViewHelper.setOwnerName(propertyInfo.getOwnerName());
//                contractViewHelper.setOwnerIdCard(propertyInfo.getOwnerIdCard());
//                contractViewHelper.setOwnerAddress(propertyInfo.getOwnerAddress());
//
//            } else if (OTHER_TYPE.equals(propertyInfo.getType())) {
//                contractViewHelper.setPropertyCodeOther(propertyInfo.getCode());
//                contractViewHelper.setPropertyOtherInfo(propertyInfo.getOtherInfo());
//                contractViewHelper.setOwnerName(propertyInfo.getOwnerName());
//                contractViewHelper.setOwnerIdCard(propertyInfo.getOwnerIdCard());
//                contractViewHelper.setOwnerAddress(propertyInfo.getOwnerAddress());
//            }
//        }

        return mapping.findForward(SUCCESS);
    }

    /**
     *
     * Show property
     *
     * @author HungPT
     * @param mapping
     *            for mapping
     * @param form
     *            for form
     * @param request
     *            for request
     * @param response
     *            for response
     * @return null
     * @throws Exception
     *             process
     */
    public ActionForward searchProperty(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

//        String type = (String) request.getParameter(PROPERTY_TYPE);
//        String code = (String) request.getParameter(PROPERTY_CODE);
//        String province = (String) request.getParameter(PROVINCE);
//        String district = (String) request.getParameter(DISTRICT);
//        String isPopup = (String) request.getParameter(IS_POPUP);
//
//        ContractViewHelper contractViewHelper = (ContractViewHelper) request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
//        if (contractViewHelper == null) {
//            return mapping.findForward(NO_LOGIN);
//        }
//
//        String html = "";
//        ContractService contractService = new ContractService(getConnection());
//
//        if (!EditString.isNull(isPopup)) {
//            html += isPopup;
//        } else {
//            html += IS_NONE_POPUP;
//        }
//
//        contractService.setPropertyTypeFilter(type);
//        html += SEPARATED + type;
//
//        if (LAND_TYPE.equals(type)) {
//            if (!EditString.isNull(code)) {
//                contractService.setCodeInContractFilter(code);
//                if (!EditString.isNull(province) && EditString.isNumber(province)) {
//                    contractService.setProvinceFilter(Long.parseLong(province));
//                }
//
//                if (!EditString.isNull(district) && EditString.isNumber(district)) {
//                    contractService.setDistrictFilter(Long.parseLong(district));
//                }
//
//                List<PropertyInfo> propertyList = contractService.queryAllProperty(false).getList();
//                if (propertyList.size() > 0) {
//                    if (propertyList.get(0).getGivenDate() != null) {
//                        html += SEPARATED + RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, propertyList.get(0).getGivenDate());
//                    } else {
//                        html += SEPARATED;
//                    }
//                    html += SEPARATED + propertyList.get(0).getMapNumber();
//                    html += SEPARATED + propertyList.get(0).getLandNumber();
//                    html += SEPARATED + propertyList.get(0).getLandAddress();
//                    html += SEPARATED + propertyList.get(0).getOwnerName();
//                    html += SEPARATED + propertyList.get(0).getOwnerIdCard();
//                    html += SEPARATED + propertyList.get(0).getOwnerAddress();
//                } else {
//                    html = "";
//                }
//            }
//        } else if (VEHICLE_CAR_TYPE.equals(type) || VEHICLE_MOTOR_TYPE.equals(type)) {
//            if (!EditString.isNull(code)) {
//                contractService.setCodeInContractFilter(code);
//                if (!EditString.isNull(province) && EditString.isNumber(province)) {
//                    contractService.setProvinceFilter(Long.parseLong(province));
//                }
//                List<PropertyInfo> propertyList = contractService.queryAllProperty(false).getList();
//                if (propertyList.size() > 0) {
//                    if (propertyList.get(0).getGivenDate() != null) {
//                        html += SEPARATED + RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, propertyList.get(0).getGivenDate());
//                    } else {
//                        html += SEPARATED;
//                    }
//                    html += SEPARATED + propertyList.get(0).getFrameNumber();
//                    html += SEPARATED + propertyList.get(0).getMachineNumber();
//                    html += SEPARATED + propertyList.get(0).getOwnerName();
//                    html += SEPARATED + propertyList.get(0).getOwnerIdCard();
//                    html += SEPARATED + propertyList.get(0).getOwnerAddress();
//                } else {
//                    html = "";
//                }
//            }
//
//        } else if (OTHER_TYPE.equals(type)) {
//            if (!EditString.isNull(code)) {
//                contractService.setCodeInContractFilter(code);
//                List<PropertyInfo> propertyList = contractService.queryAllProperty(false).getList();
//                if (propertyList.size() > 0) {
//                    html += SEPARATED + propertyList.get(0).getOtherInfo();
//                    html += SEPARATED + propertyList.get(0).getOwnerName();
//                    html += SEPARATED + propertyList.get(0).getOwnerIdCard();
//                    html += SEPARATED + propertyList.get(0).getOwnerAddress();
//                } else {
//                    html = "";
//                }
//            }
//
//        } else {
//            html = "";
//        }
//
//        // render html
//        response.setContentType("text/html; charset=utf-8");
//        PrintWriter out = response.getWriter();
//        out.println(html);
//        out.flush();
        return null;
    }

    public ActionForward showPropertyDetail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

//        ContractViewHelper contractViewHelper = (ContractViewHelper) request.getSession().getAttribute(ContractViewHelper.SESSION_KEY);
//        if (contractViewHelper == null) {
//            return mapping.findForward(NO_LOGIN);
//        }
//
//        String selectedId = (String) request.getParameter(SELECTED_ID);
//
//        if (!EditString.isNull(selectedId)) {
//            List<PropertyInfo> propertyList = contractViewHelper.getPropertyList();
//
//            PropertyInfo propertyInfo = propertyList.get(Integer.parseInt(selectedId));
//            contractViewHelper.setPropertyTypePopup(propertyInfo.getType());
//            contractViewHelper.setTitlePopup(propertyInfo.getTitle());
//            if (LAND_TYPE.equals(propertyInfo.getType())) {
//                contractViewHelper.setProvinceLandPopup(propertyInfo.getProvince());
//                contractViewHelper.setProvinceLandNamePopup(propertyInfo.getProvinceName());
//                contractViewHelper.setDistrictPopup(propertyInfo.getDistrict());
//                contractViewHelper.setDistrictLandNamePopup(propertyInfo.getDistrictName());
//                contractViewHelper.setPropertyCodeLandPopup(propertyInfo.getCode());
//                if (propertyInfo.getGivenDate() != null) {
//                    contractViewHelper.setGivenDateLandPopup(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, propertyInfo.getGivenDate()));
//                }
//                contractViewHelper.setMapNumberPopup(propertyInfo.getMapNumber());
//                contractViewHelper.setLandNumberPopup(propertyInfo.getLandNumber());
//                contractViewHelper.setLandAddressPopup(propertyInfo.getLandAddress());
//                contractViewHelper.setOwnerNamePopup(propertyInfo.getOwnerName());
//                contractViewHelper.setOwnerIdCardPopup(propertyInfo.getOwnerIdCard());
//                contractViewHelper.setOwnerAddressPopup(propertyInfo.getOwnerAddress());
//
//            } else if (VEHICLE_CAR_TYPE.equals(propertyInfo.getType()) || VEHICLE_MOTOR_TYPE.equals(propertyInfo.getType())) {
//                contractViewHelper.setProvinceVehiclePopup(propertyInfo.getProvince());
//                contractViewHelper.setProvinceVehicleNamePopup(propertyInfo.getProvinceName());
//                contractViewHelper.setPropertyCodeVehiclePopup(propertyInfo.getCode());
//                if (propertyInfo.getGivenDate() != null) {
//                    contractViewHelper.setGivenDateVehiclePopup(RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, propertyInfo.getGivenDate()));
//                }
//                contractViewHelper.setFrameNumberPopup(propertyInfo.getFrameNumber());
//                contractViewHelper.setMachineNumberPopup(propertyInfo.getMachineNumber());
//                contractViewHelper.setOwnerNamePopup(propertyInfo.getOwnerName());
//                contractViewHelper.setOwnerIdCardPopup(propertyInfo.getOwnerIdCard());
//                contractViewHelper.setOwnerAddressPopup(propertyInfo.getOwnerAddress());
//
//            } else if (OTHER_TYPE.equals(propertyInfo.getType())) {
//                contractViewHelper.setPropertyCodeOtherPopup(propertyInfo.getCode());
//                contractViewHelper.setPropertyOtherInfoPopup(propertyInfo.getOtherInfo());
//            }
//            contractViewHelper.setOwnerNamePopup(propertyInfo.getOwnerName());
//            contractViewHelper.setOwnerIdCardPopup(propertyInfo.getOwnerIdCard());
//            contractViewHelper.setOwnerAddressPopup(propertyInfo.getOwnerAddress());
//        }

        return mapping.findForward(SUCCESS);
    }
//    public ActionForward showTempPropertyDetail(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
//    throws Exception {
//
//        TemporaryContractViewHelper contractViewHelper = (TemporaryContractViewHelper) request.getSession().getAttribute(TemporaryContractViewHelper.SESSION_KEY);
//        if (contractViewHelper == null) {
//            return mapping.findForward(NO_LOGIN);
//        }
//        
//        String selectedId = (String) request.getParameter(SELECTED_ID);
//        
//        if (!EditString.isNull(selectedId)) {
//            List<TemporaryPropertyInfo> propertyList = contractViewHelper.getPropertyList();
//        
//            TemporaryPropertyInfo propertyInfo = propertyList.get(Integer.parseInt(selectedId));
//            contractViewHelper.setPropertyTypePopup(propertyInfo.getType());
//            contractViewHelper.setTitlePopup(propertyInfo.getTitle());
//            if (LAND_TYPE.equals(propertyInfo.getType())) {
//                contractViewHelper.setProvinceLandPopup(propertyInfo.getProvince());
//                contractViewHelper.setProvinceLandNamePopup(propertyInfo.getProvince());
//                contractViewHelper.setDistrictPopup(propertyInfo.getDistrict());
//                contractViewHelper.setDistrictLandNamePopup(propertyInfo.getDistrict());
//                contractViewHelper.setPropertyCodeLandPopup(propertyInfo.getCode());
//                if (propertyInfo.getGivenDate() != null) {
//                    contractViewHelper.setGivenDateLandPopup(propertyInfo.getGivenDate());
//                }
//                contractViewHelper.setMapNumberPopup(propertyInfo.getMapNumber());
//                contractViewHelper.setLandNumberPopup(propertyInfo.getLandNumber());
//                contractViewHelper.setLandAddressPopup(propertyInfo.getLandAddress());
//                contractViewHelper.setOwnerNamePopup(propertyInfo.getOwnerName());
//                contractViewHelper.setOwnerIdCardPopup(propertyInfo.getOwnerIdCard());
//                contractViewHelper.setOwnerAddressPopup(propertyInfo.getOwnerAddress());
//        
//            } else if (VEHICLE_CAR_TYPE.equals(propertyInfo.getType()) || VEHICLE_MOTOR_TYPE.equals(propertyInfo.getType())) {
//                contractViewHelper.setProvinceVehiclePopup(propertyInfo.getProvince());
//                contractViewHelper.setProvinceVehicleNamePopup(propertyInfo.getProvince());
//                contractViewHelper.setPropertyCodeVehiclePopup(propertyInfo.getCode());
//                if (propertyInfo.getGivenDate() != null) {
//                    contractViewHelper.setGivenDateVehiclePopup(propertyInfo.getGivenDate());
//                }
//                contractViewHelper.setFrameNumberPopup(propertyInfo.getFrameNumber());
//                contractViewHelper.setMachineNumberPopup(propertyInfo.getMachineNumber());
//                contractViewHelper.setOwnerNamePopup(propertyInfo.getOwnerName());
//                contractViewHelper.setOwnerIdCardPopup(propertyInfo.getOwnerIdCard());
//                contractViewHelper.setOwnerAddressPopup(propertyInfo.getOwnerAddress());
//        
//            } else if (OTHER_TYPE.equals(propertyInfo.getType())) {
//                contractViewHelper.setPropertyCodeOtherPopup(propertyInfo.getCode());
//                contractViewHelper.setPropertyOtherInfoPopup(propertyInfo.getOtherInfo());
//            }
//            contractViewHelper.setOwnerNamePopup(propertyInfo.getOwnerName());
//            contractViewHelper.setOwnerIdCardPopup(propertyInfo.getOwnerIdCard());
//            contractViewHelper.setOwnerAddressPopup(propertyInfo.getOwnerAddress());
//        }
//        
//        return mapping.findForward(SUCCESS);
//        }
//    
   
}
