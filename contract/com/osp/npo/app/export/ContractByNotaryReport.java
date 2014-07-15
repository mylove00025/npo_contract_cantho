package com.osp.npo.app.export;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.context.ContractByNotaryListContext;
import com.osp.npo.app.export.ContractExcelUtil.StyleKind;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.contract.ContractKindListForNotary;

public class ContractByNotaryReport {

    private static final String NOTARY_IN_DAY = "01";
    private static final String NOTARY_IN_WEEK = "00";
    private static final String NOTARY_IN_MONTH = "02";
    private static final String NOTARY_IN_YEAR = "03";
    private static final String NOTARY_IN_RANGE = "04";
    private static final String code = "CDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int COLUMN0 = 0;
    private static final int COLUMN1 = 1;
    private static final int COLUMN2 = 2;
    private static final int COLUMN3 = 3;
    private static final int COLUMN4 = 4;
    private static final int COLUMN5 = 5;
  
//    private static final int COLUMN6 = 6;
//    private static final int COLUMN7 = 7;
//    private static final int COLUMN8 = 8;

    // STT
    private static final Integer MAX_CHAR_COLUMN0 = 5;
    // SHD
    private static final Integer MAX_CHAR_COLUMN1 = 15;
    // Ngay HD
    private static final Integer MAX_CHAR_COLUMN2 = 15;
    // Ten HD
    private static final Integer MAX_CHAR_COLUMN3 = 36;
    // Noi dung HD
    private static final Integer MAX_CHAR_COLUMN4 = 36;
    // Ben LQ
    private static final Integer MAX_CHAR_COLUMN5 = 36;
//    private static final Integer MAX_CHAR_COLUMN6 = 23;
//    private static final Integer MAX_CHAR_COLUMN7 = 23;
//    private static final Integer MAX_CHAR_COLUMN8 = 23;

    private ContractExcelUtil contractExcelUtil;

    /**
     *
     * prepare data for BaocaoHDCCtheoCCV.xls file report
     *
     * @author GiangVT
     * @param contractList
     * @param context
     * @param commonContext
     * @return
     * @throws Exception
     */
    public HSSFWorkbook createWorkbook(List<ContractInfo> contractList, ContractByNotaryListContext context, CommonContext commonContext)
        throws Exception {

        contractExcelUtil = new ContractExcelUtil();

        HSSFWorkbook workbook = new HSSFWorkbook();
        contractExcelUtil.setDefaultFont(workbook);

        if (contractList != null && contractList.size() > 0) {

            // Get notaries name
            List<String> notaryNameList = new ArrayList<String>();
            List<Long> notaryIdList = new ArrayList<Long>();
            for (ContractInfo contractInfo : contractList) {
                Long notaryAccount = contractInfo.getNotaryId();
                String notaryName = contractInfo.getNotaryFamilyName() + Constants.SPACE + contractInfo.getNotaryFirstName();
                if (!notaryIdList.contains(notaryAccount)) {
                    notaryIdList.add(notaryAccount);
                    notaryNameList.add(notaryName);
                }
            }

            // create sheet
            for (int i = 0; i < notaryNameList.size(); i++) {
                // format sheet
                HSSFSheet sheet;
                if (notaryNameList.get(i).length() < Constants.LENGTH_STRING_LIMIT) {
                    try {
                        sheet = workbook.createSheet(notaryNameList.get(i));
                    } catch (Exception e) {
                        sheet = workbook.createSheet(notaryNameList.get(i) + " (" + notaryIdList.get(i) + ")");
                    }
                } else {
                    try {
                        sheet = workbook.createSheet(EditString.cutString(notaryNameList.get(i)));
                    } catch (Exception e) {
                        sheet = workbook.createSheet(EditString.cutString(notaryNameList.get(i)) + " (" + notaryIdList.get(i) + ")");
                    }
                }
                sheet.setFitToPage(true);
                sheet.setGridsPrinted(false);
                sheet.setDisplayGridlines(false);

                HSSFPrintSetup printSetup = sheet.getPrintSetup();
                printSetup.setLandscape(true);
                printSetup.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE);

                sheet.setMargin(HSSFSheet.TopMargin, ContractExcelUtil.NARROW_MARGIN_TOP);
                sheet.setMargin(HSSFSheet.RightMargin, ContractExcelUtil.NARROW_MARGIN_RIGHT);
                sheet.setMargin(HSSFSheet.BottomMargin, ContractExcelUtil.NARROW_MARGIN_BOTTOM);
                sheet.setMargin(HSSFSheet.LeftMargin, ContractExcelUtil.NARROW_MARGIN_LEFT);

                // set column width
                sheet.setColumnWidth(COLUMN0, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN0);
                sheet.setColumnWidth(COLUMN1, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN1);
                sheet.setColumnWidth(COLUMN2, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN2);
                sheet.setColumnWidth(COLUMN3, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN3);
                sheet.setColumnWidth(COLUMN4, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN4);
                sheet.setColumnWidth(COLUMN5, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN5);
//                sheet.setColumnWidth(COLUMN6, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN6);
//                sheet.setColumnWidth(COLUMN7, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN7);
//                sheet.setColumnWidth(COLUMN8, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN8);

                // merge cell header
                sheet.addMergedRegion(new CellRangeAddress(1, 1, COLUMN4, COLUMN5));
                sheet.addMergedRegion(new CellRangeAddress(0, 0, COLUMN4, COLUMN5));
                sheet.addMergedRegion(new CellRangeAddress(3, 3, COLUMN0, COLUMN5));
                sheet.addMergedRegion(new CellRangeAddress(4, 4, COLUMN0, COLUMN5));
                sheet.addMergedRegion(new CellRangeAddress(5, 5, COLUMN0, COLUMN5));

                HSSFCellStyle style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
                contractExcelUtil.createCell(workbook, sheet, 0, COLUMN0, style,
                        commonContext.getSystemConfigValue("notary_office_name"), false);

                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
                contractExcelUtil.createCell(workbook, sheet, 0, COLUMN4, style,
                        SystemMessageProperties.getSystemProperty("item_nation_name"), false);

                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
                contractExcelUtil.createCell(workbook, sheet, 1, COLUMN0, style,"     " +
                        commonContext.getSystemConfigValue("notary_office_address"), false);

                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
                contractExcelUtil.createCell(workbook, sheet, 1, COLUMN4, style,
                        SystemMessageProperties.getSystemProperty("item_nation_motto"), false);

                style = contractExcelUtil.getCellStyle(workbook, StyleKind.PAGE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, 3, COLUMN0, style,
                        SystemMessageProperties.getSystemProperty("item_contract_list"), false);

//                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
//                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//                contractExcelUtil.createCell(workbook, sheet, 4, 1, style, SystemMessageProperties.getSystemProperty("item_notary_report") +
//                                                COLON, false);

                style = workbook.createCellStyle();
                style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM));
                style.setFont(contractExcelUtil.createFont(workbook, 13, HSSFFont.BOLDWEIGHT_NORMAL));

                String richTextString = SystemMessageProperties.getSystemProperty("item_notary");
                int normalLength = richTextString.length();
                richTextString += Constants.COLON + Constants.SPACE;
                richTextString += notaryNameList.get(i);
                HSSFRichTextString richText = new HSSFRichTextString(richTextString);

                HSSFFont font = contractExcelUtil.createFont(workbook, 13, HSSFFont.BOLDWEIGHT_BOLD);
                richText.applyFont(normalLength + 1, richTextString.length(), font);

//                contractExcelUtil.createCell(workbook, sheet, 4, 1, style, "", false);
                contractExcelUtil.createCell(workbook, sheet, 4, COLUMN0, style, richText);

                String fromDate = "";
                String toDate = "";
                Date date = Calendar.getInstance().getTime();

                if (NOTARY_IN_DAY.equals(context.getSearchDate())) {
                    fromDate = RelateDateTime.toDayMonthYear(date);
                    toDate = RelateDateTime.toDayMonthYear(date);
                } else if (NOTARY_IN_MONTH.equals(context.getSearchDate())) {
                    fromDate = RelateDateTime.getDateByFirstDayOfMonth(date);
                    toDate = RelateDateTime.getDateByLastDayOfMonth(date);
                } else if (NOTARY_IN_YEAR.equals(context.getSearchDate())) {
                    fromDate = RelateDateTime.getDateByFirstDayOfYear(date);
                    toDate = RelateDateTime.getDateByLastDayOfYear(date);
                } else if (NOTARY_IN_RANGE.equals(context.getSearchDate())) {
                    fromDate = context.getFromDate();
                    toDate = context.getToDate();
                } else if (NOTARY_IN_WEEK.equals(context.getSearchDate())) {
                    fromDate = RelateDateTime.getDateByFirstDayOfWeek(date);
                    toDate = RelateDateTime.getDateByLastDayOfWeek(date);
                }

                if (EditString.isNull(fromDate)) {
                    fromDate = ContractExcelUtil.DOT_SPACE;
                }
                if (EditString.isNull(toDate)) {
                    toDate = ContractExcelUtil.DOT_SPACE;
                }

                if (!EditString.isNull(fromDate)) {
                    style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
                    contractExcelUtil.createCell(workbook, sheet, 5, COLUMN0, style,
                            SystemMessageProperties.getSystemProperty("item_from_date")
                                + Constants.SPACE
                                + fromDate + Constants.SPACE
                                + SystemMessageProperties.getSystemProperty("item_to_date")
                                + Constants.SPACE
                                + toDate,
                            false);
                }

                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, 7, COLUMN0, style,
                        SystemMessageProperties.getSystemProperty("item_order_number"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, 7, COLUMN1, style,
                        SystemMessageProperties.getSystemProperty("item_number_contract"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, 7, COLUMN2, style,
                        SystemMessageProperties.getSystemProperty("item_notary_date"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
                contractExcelUtil.createCell(workbook, sheet, 7, COLUMN3, style,
                        SystemMessageProperties.getSystemProperty("item_contract_template_name"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
                contractExcelUtil.createCell(workbook, sheet, 7, COLUMN4, style,
                        SystemMessageProperties.getSystemProperty("item_contract_relation_object"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, 7, COLUMN5, style,
                        SystemMessageProperties.getSystemProperty("item_contract_sumary"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
//                contractExcelUtil.createCell(workbook, sheet, 7, COLUMN6, style,
//                        SystemMessageProperties.getSystemProperty("item_contract_sumary"), false);
//                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
//                contractExcelUtil.createCell(workbook, sheet, 7, COLUMN7, style,
//                        SystemMessageProperties.getSystemProperty("item_drafter_report"), false);

                int bgRow = 8;
                for (ContractInfo contractInfo : contractList) {
                    if (notaryIdList.get(i).equals(contractInfo.getNotaryId())) {
                        // STT
                        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
                        contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN0, style, (bgRow - 7) + "" , false);

                        // SHD
                        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
                        contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN1, style, contractInfo.getContractNumber(), false);

                        // Thoi gian HD
                        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
                        contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN2, style,
                                                                RelateDateTime.toDayMonthYear(contractInfo.getNotaryDate()), false);

                        // Ten HD
                        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
                        contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN3, style, contractInfo.getContractTemplateName(), false);

                        // Ben lien quan
                        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
                        String info = "";
                        if (!EditString.isNull(contractInfo.getRelationObjectA())) {
                        	info += Constants.ENTER + contractInfo.getRelateObjectATitle() + Constants.COLON + Constants.SPACE
        	                                + contractInfo.getRelationObjectA();
        	            }           
        	            if (!EditString.isNull(contractInfo.getRelationObjectB())) {
        	            	info += Constants.ENTER + contractInfo.getRelateObjectBTitle() + Constants.COLON + Constants.SPACE
        	                                + contractInfo.getRelationObjectB();
        	            }            
        	            if (!EditString.isNull(contractInfo.getRelationObjectC())) {
        	            	info += Constants.ENTER + contractInfo.getRelateObjectCTitle() + Constants.COLON + Constants.SPACE
        	                                + contractInfo.getRelationObjectC();
        	            }
                        contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN4 , style, info, false);

                        // Noi dung hop dong
                        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
                        contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN5 , style, EditString.removeCR(contractInfo.getContractSummaryReport()), false);

                        // next row
                        bgRow++;
                    }
                }

                // total
                int total = bgRow - 8;
                bgRow ++;
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN0, style,
                        SystemMessageProperties.getSystemProperty("item_total") + Constants.COLON + Constants.SPACE
                        + total + Constants.SPACE
                        + SystemMessageProperties.getSystemProperty("item_contract"), false);

                // date time
                sheet.addMergedRegion(new CellRangeAddress(bgRow, bgRow, COLUMN4, COLUMN5));
                String strDate = RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime());

                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN4, style,
                        SystemMessageProperties.getSystemProperty("item_day") + Constants.SPACE + strDate.substring(0, 2)
                        + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_month") + Constants.SPACE
                        + strDate.substring(3, 5)
                        + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_year") + Constants.SPACE
                        + strDate.substring(6, strDate.length()), false);

                // signature
                bgRow++;
                sheet.addMergedRegion(new CellRangeAddress(bgRow, bgRow, COLUMN4, COLUMN5));
                style = workbook.createCellStyle();
                style.setFont(contractExcelUtil.createFont(workbook, 11, HSSFFont.BOLDWEIGHT_BOLD));
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN4, style,
                        SystemMessageProperties.getSystemProperty("item_reporter"), false);
            }
        }

        return workbook;
    }
    
    /**
     * Create Work Book
     *
     * @param contractList
     * @param context
     * @param commonContext
     * @return
     * @throws Exception
     */
    public HSSFWorkbook createWorkbook2(ContractKindListForNotary contractKindList, ContractByNotaryListContext context, 
    		CommonContext commonContext, Long totalCost91) throws Exception {

        contractExcelUtil = new ContractExcelUtil();

        HSSFWorkbook workbook = new HSSFWorkbook();
        contractExcelUtil.setDefaultFont(workbook);
      
        // create sheet
          
        HSSFSheet sheet = workbook.createSheet(SystemMessageProperties.getSystemProperty("item_table")); 
      
        //sheet.setFitToPage(true);
        sheet.setGridsPrinted(false);
        sheet.setDisplayGridlines(false);

        HSSFPrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        printSetup.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE);

        sheet.setMargin(HSSFSheet.TopMargin, 0.25);
        sheet.setMargin(HSSFSheet.RightMargin, ContractExcelUtil.NARROW_MARGIN_RIGHT);
        sheet.setMargin(HSSFSheet.BottomMargin, ContractExcelUtil.NARROW_MARGIN_BOTTOM);
        sheet.setMargin(HSSFSheet.LeftMargin, ContractExcelUtil.NARROW_MARGIN_LEFT);

        //Set column width
        sheet.setColumnWidth(COLUMN0, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN0);
        sheet.setColumnWidth(COLUMN1, ContractExcelUtil.UNITS_OF_CHAR * 40);
        for (int j = 0; j < contractKindList.getTotalUser(); j++) {
        	sheet.setColumnWidth(j+2, ContractExcelUtil.UNITS_OF_CHAR * 10);
			
		}
        sheet.setColumnWidth(contractKindList.getTotalUser()+2, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN2);
       
        
      
        
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 4, 7));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, 4, 7));
        sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 6));
        sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 6));
        
       

        HSSFCellStyle style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        contractExcelUtil.createCell(workbook, sheet, 0, 0, style,  commonContext.getSystemConfigValue("npo_justice_department").toUpperCase(), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        contractExcelUtil.createCell(workbook, sheet, 0, 4, style, SystemMessageProperties.getSystemProperty("item_nation_name").toUpperCase(), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        contractExcelUtil.createCell(workbook, sheet, 1, 0, style,"     " + commonContext.getSystemConfigValue("notary_office_name"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        contractExcelUtil.createCell(workbook, sheet, 1, 4, style, SystemMessageProperties.getSystemProperty("item_nation_motto"), false);

        style = workbook.createCellStyle();
        style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.PAGE_TITLE));
        contractExcelUtil.createCell(workbook, sheet, 3, 0, style, SystemMessageProperties.getSystemProperty("item_table"), false);

        style = workbook.createCellStyle();
        style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM));
        style.setFont(contractExcelUtil.createFont(workbook, 13, HSSFFont.BOLDWEIGHT_NORMAL));


        String fromDate = "";
        String toDate = "";
        Date date = Calendar.getInstance().getTime();
        
        if (NOTARY_IN_DAY.equals(context.getSearchDate())) {
            fromDate = RelateDateTime.toDayMonthYear(date);
            toDate = RelateDateTime.toDayMonthYear(date);
        } else if (NOTARY_IN_MONTH.equals(context.getSearchDate())) {
            fromDate = RelateDateTime.getDateByFirstDayOfMonth(date);
            toDate = RelateDateTime.getDateByLastDayOfMonth(date);
        } else if (NOTARY_IN_YEAR.equals(context.getSearchDate())) {
            fromDate = RelateDateTime.getDateByFirstDayOfYear(date);
            toDate = RelateDateTime.getDateByLastDayOfYear(date);
        } else if (NOTARY_IN_RANGE.equals(context.getSearchDate())) {
            fromDate = context.getFromDate();
            toDate = context.getToDate();
        } else if (NOTARY_IN_WEEK.equals(context.getSearchDate())) {
            fromDate = RelateDateTime.getDateByFirstDayOfWeek(date);
            toDate = RelateDateTime.getDateByLastDayOfWeek(date);
        }

        if (EditString.isNull(fromDate)) {
            fromDate = "...";
        }
        if (EditString.isNull(toDate)) {
            toDate = "...";
        }

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        contractExcelUtil.createCell(workbook, sheet, 4, 0, style, SystemMessageProperties.getSystemProperty("item_from_date")
                + Constants.SPACE
                + fromDate + Constants.SPACE
                + SystemMessageProperties.getSystemProperty("item_to_date")
                + Constants.SPACE
                + toDate, false);


       
      
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        contractExcelUtil.createCell(workbook, sheet, 6, COLUMN0, style,
                SystemMessageProperties.getSystemProperty("item_order_number"), false);
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        contractExcelUtil.createCell(workbook, sheet, 7, COLUMN0, style,
                SystemMessageProperties.getSystemProperty("item_order_number"), false);
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        contractExcelUtil.createCell(workbook, sheet, 6, COLUMN1, style,
                SystemMessageProperties.getSystemProperty("item_CNTR022_contract_template_name2"), false);
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        contractExcelUtil.createCell(workbook, sheet, 7, COLUMN1, style,
                SystemMessageProperties.getSystemProperty("item_CNTR022_contract_template_name2"), false);
        for (int i = 0; i < contractKindList.getTotalUser(); i++) {
        	style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            contractExcelUtil.createCell(workbook, sheet, 6, COLUMN2 + i, style,
                    SystemMessageProperties.getSystemProperty("item_notary2"), false);		
		}
        
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        contractExcelUtil.createCell(workbook, sheet, 6, contractKindList.getTotalUser()+2, style,
                SystemMessageProperties.getSystemProperty("item_total2"), false);
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        contractExcelUtil.createCell(workbook, sheet, 7, contractKindList.getTotalUser()+2, style,
                SystemMessageProperties.getSystemProperty("item_total2"), false);
        sheet.addMergedRegion(new CellRangeAddress(6, 7, 0, 0));
        sheet.addMergedRegion(new CellRangeAddress(6, 7, 1, 1));
        sheet.addMergedRegion(new CellRangeAddress(6, 6, 2, contractKindList.getTotalUser()+1));
        sheet.addMergedRegion(new CellRangeAddress(6, 7, contractKindList.getTotalUser()+2, contractKindList.getTotalUser()+2));
        
        for (int j = 0; j < contractKindList.getTotalUser(); j++) {
        	 
        	style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            contractExcelUtil.createCell(workbook, sheet, 7, j+2, style,
                    contractKindList.getUserList().get(j).getFirstName().toUpperCase(), false);
		}
        for (int j = 0; j < contractKindList.getContractKindList().size(); j++) {
        	
        	style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            contractExcelUtil.createCell(workbook, sheet, j+8, 0, style,
                    (double)j+1);
            
        	style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            contractExcelUtil.createCell(workbook, sheet, j+8, 1, style,
                    contractKindList.getContractKindList().get(j).getName(), false);
            sheet.getRow(j+8).setHeight((short)400);
              
        }
        for (int l = 0; l < contractKindList.getContractKindList().size(); l++){
        	Boolean checkExist2=false;
            for (int j = 0; j < contractKindList.size(); j++) {
            	if (contractKindList.getContractKindList().get(l).getId().equals(contractKindList.get(j).getId())) {
            		checkExist2=true;
                	for (int i = 0; i < contractKindList.getUserList().size(); i++) {
                		Boolean checkExist = false;
                		for (int k = 0; k < contractKindList.get(j).getUserList().size(); k++) {
                			if (contractKindList.get(j).getUserList().get(k).getId().equals(contractKindList.getUserList().get(i).getId())) {
                				style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
                                contractExcelUtil.createCell(workbook, sheet, l+8, i+2, style,
                                		(double)contractKindList.get(j).getUserList().get(k).getCount());     
                                checkExist = true;
                                break;
                			}
                		}
                			if (!checkExist) {
                				style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
                                contractExcelUtil.createCell(workbook, sheet, l+8, i+2, style,
                                		(double)0);     
                			}
						
					}
                	
                break;	
				}
            }
            if (!checkExist2) 
            	for (int i = 0; i < contractKindList.getTotalUser(); i++) {
            		style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
                    contractExcelUtil.createCell(workbook, sheet, l+8, i+2, style,
                    		(double)0);    	
				}
        }
        
        for (int i = 0; i < contractKindList.getTotalKind(); i++) {   
        	int index = i + 9;
        	style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            contractExcelUtil.createCell(workbook, sheet, i+8, contractKindList.getTotalUser()+2, style,
            		"SUM(C"+index+":"+code.charAt(contractKindList.getTotalUser()-1)+index+")", true); 
		}
    	style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        contractExcelUtil.createCell(workbook, sheet, contractKindList.getTotalKind()+8, 0, style,
                SystemMessageProperties.getSystemProperty("item_total"), false);
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        contractExcelUtil.createCell(workbook, sheet, contractKindList.getTotalKind()+8, 1, style, "", false);
        int indexCol = 8 + contractKindList.getTotalKind();
        sheet.addMergedRegion(new CellRangeAddress(contractKindList.getTotalKind()+8, contractKindList.getTotalKind()+8, 0, 1));
        for (int i = 0; i < contractKindList.getTotalUser(); i++) {
        	style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            contractExcelUtil.createCell(workbook, sheet, contractKindList.getTotalKind()+8, i+2, style,
            		"SUM("+ code.charAt(i)+"9:"+code.charAt(i)+indexCol + ")", true);
		}
        
        style = workbook.createCellStyle();
        style.setFont(contractExcelUtil.createFont(workbook, 16, HSSFFont.BOLDWEIGHT_BOLD));
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        contractExcelUtil.drawBorder(style, HSSFCellStyle.BORDER_THIN, HSSFColor.BLACK.index); 
        contractExcelUtil.createCell(workbook, sheet, contractKindList.getTotalKind()+8, contractKindList.getTotalUser()+2, style,
        		"SUM("+ code.charAt(contractKindList.getTotalUser())+"9:"+code.charAt(contractKindList.getTotalUser())+indexCol + ")", true);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        contractExcelUtil.createCell(workbook, sheet, contractKindList.getTotalKind()+9, 0, style,
                SystemMessageProperties.getSystemProperty("item_out_notary_place"), false);
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        contractExcelUtil.createCell(workbook, sheet, contractKindList.getTotalKind()+9, 1, style,"", false);
  
        sheet.addMergedRegion(new CellRangeAddress(contractKindList.getTotalKind()+9, contractKindList.getTotalKind()+9, 0, 1));
        for (int i = 0; i < contractKindList.getTotalUser(); i++) {
			if (contractKindList.getUserList().get(i).getCount()!=null) {
				style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, contractKindList.getTotalKind()+9, i+2, style,
                	(double) contractKindList.getUserList().get(i).getCount());
			} else {
				style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, contractKindList.getTotalKind()+9, i+2, style,
                	(double) 0);
			}
		}
        indexCol = 10 + contractKindList.getTotalKind();
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        contractExcelUtil.createCell(workbook, sheet, contractKindList.getTotalKind()+9, contractKindList.getTotalUser()+2, style,
        		"SUM(C" + indexCol +":"+code.charAt(contractKindList.getTotalUser()-1)+indexCol + ")", true);
        
        if (totalCost91 != null) {
	    	style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
	        contractExcelUtil.createCell(workbook, sheet, contractKindList.getTotalKind()+10, 0, style,
	                 SystemMessageProperties.getSystemProperty("item_CNTR005_fee") + ": " + getCurrencyFormat(totalCost91) +
	                 SystemMessageProperties.getSystemProperty("item_vnd"), false);
	        
	        for (int i=1; i<contractKindList.getTotalUser() + 3; i++) {
	        	contractExcelUtil.createCell(workbook, sheet, contractKindList.getTotalKind()+10, i, style, "", false);
	        }
	        
	        sheet.addMergedRegion(new CellRangeAddress(contractKindList.getTotalKind()+10, contractKindList.getTotalKind()+10, 
	           		 0, contractKindList.getTotalUser() + 2));
        }
            
        int bgRow = contractKindList.getTotalKind()+10;
       
        

        String strDate = RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime());
        sheet.addMergedRegion(new CellRangeAddress(bgRow + 2, bgRow + 2, contractKindList.getTotalUser()+1, contractKindList.getTotalUser()+2));
        sheet.addMergedRegion(new CellRangeAddress(bgRow + 3, bgRow + 3, contractKindList.getTotalUser()+1, contractKindList.getTotalUser()+2));
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        contractExcelUtil.createCell(workbook, sheet, bgRow + 2, contractKindList.getTotalUser()+1, style,
                SystemMessageProperties.getSystemProperty("item_day") + Constants.SPACE + strDate.substring(0, 2)
                + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_month") + Constants.SPACE
                + strDate.substring(3, 5)
                + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_year") + Constants.SPACE
                + strDate.substring(6, strDate.length()), false);

        style = workbook.createCellStyle();
        style.setFont(contractExcelUtil.createFont(workbook, ContractExcelUtil.FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
        contractExcelUtil.createCell(workbook, sheet, bgRow + 3, contractKindList.getTotalUser()+1, style, SystemMessageProperties.getSystemProperty("item_reporter"), false);
    
        

        return workbook;
    }
    
    
    /**
     * Get currency format
     * 
     * @param value
     * @return
     */
    private String getCurrencyFormat(Long value) {
    	
    	NumberFormat nf = NumberFormat.getNumberInstance();
    	String result = nf.format(value);
    	result = result.replaceAll(",", ".");
    	
    	return result;
    }
}


