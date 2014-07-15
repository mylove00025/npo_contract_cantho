package com.osp.npo.app.export;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.context.ContractErrorListContext;
import com.osp.npo.app.export.ContractExcelUtil.StyleKind;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.contract.ContractInfo;
/**
 * @author SonHD
 * @version $Revision: 27302 $
 */
public class ContractErrorReport {

    private static final String NOTARY_IN_DAY = "01";
    private static final String NOTARY_IN_WEEK = "02";
    private static final String NOTARY_IN_MONTH = "03";
    private static final String NOTARY_IN_YEAR = "04";
    private static final String NOTARY_IN_RANGE = "05";
    private static final String SHEET_NAME = "HDCC Loi";
    
    private static final int COLUMN0 = 0;
    private static final int COLUMN1 = 1;
    private static final int COLUMN2 = 2;
    private static final int COLUMN3 = 3;
    private static final int COLUMN4 = 4;
    private static final int COLUMN5 = 5;
    private static final int COLUMN6 = 6;
    
    private static final Integer MAX_CHAR_COLUMN0 = 6;
    private static final Integer MAX_CHAR_COLUMN1 = 15;
    private static final Integer MAX_CHAR_COLUMN2 = 20;
    private static final Integer MAX_CHAR_COLUMN3 = 25;
    private static final Integer MAX_CHAR_COLUMN4 = 25;
    private static final Integer MAX_CHAR_COLUMN5 = 20;
    private static final Integer MAX_CHAR_COLUMN6 = 20;

    private ContractExcelUtil contractExcelUtil;

    /**
     *
     * prepare data for BaoCaoHDCCLoi.xls file report
     *
     * @author SonHD
     * @param contractList
     * @param context
     * @param commonContext
     * @return
     * @throws Exception
     */
    public HSSFWorkbook createWorkbook(List<ContractInfo> contractList, ContractErrorListContext context, CommonContext commonContext)
        throws Exception {

        contractExcelUtil = new ContractExcelUtil();

        HSSFWorkbook workbook = new HSSFWorkbook();
        contractExcelUtil.setDefaultFont(workbook);
        if (contractList != null && contractList.size() > 0) {
                // format sheet
                HSSFSheet sheet = workbook.createSheet(SHEET_NAME);
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
                sheet.setColumnWidth(COLUMN6, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN6);
                // merge cell header
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 5, 6));
                sheet.addMergedRegion(new CellRangeAddress(1, 1, 5, 6));
                sheet.addMergedRegion(new CellRangeAddress(3, 3, 0, 6));
                sheet.addMergedRegion(new CellRangeAddress(4, 4, 0, 6));
                sheet.addMergedRegion(new CellRangeAddress(5, 5, 0, 6));

                HSSFCellStyle style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
                contractExcelUtil.createCell(workbook, sheet, 0, 0, style, commonContext.getSystemConfigValue("notary_office_name"), false);

                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
                contractExcelUtil.createCell(workbook, sheet, 0, 5, style, SystemMessageProperties.getSystemProperty("item_nation_name"), false);
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
                contractExcelUtil.createCell(workbook, sheet, 1, 0, style,"     " + commonContext.getSystemConfigValue("notary_office_address"), false);

                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
                contractExcelUtil.createCell(workbook, sheet, 1, 5, style, SystemMessageProperties.getSystemProperty("item_nation_motto"), false);

                style = workbook.createCellStyle(); 
                style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.PAGE_TITLE));
                contractExcelUtil.createCell(workbook, sheet, 3, 0, style, SystemMessageProperties.getSystemProperty("item_error_contract_list"), false);
                
                String fromDate = "";
                String toDate = "";

                if (NOTARY_IN_DAY.equals(context.getSearchDateFilter())) {
                    Date date = Calendar.getInstance().getTime();
                    fromDate = RelateDateTime.toDayMonthYear(date);
                    toDate = RelateDateTime.toDayMonthYear(date);
                } else if (NOTARY_IN_WEEK.equals(context.getSearchDateFilter())) {
                    Date date = Calendar.getInstance().getTime();
                    fromDate = RelateDateTime.getDateByFirstDayOfWeek(date);
                    toDate = RelateDateTime.getDateByLastDayOfWeek(date);
                } else if (NOTARY_IN_MONTH.equals(context.getSearchDateFilter())) {
                    Date date = Calendar.getInstance().getTime();
                    fromDate = RelateDateTime.getDateByFirstDayOfMonth(date);
                    toDate = RelateDateTime.getDateByLastDayOfMonth(date);
                } else if (NOTARY_IN_YEAR.equals(context.getSearchDateFilter())) {
                    Date date = Calendar.getInstance().getTime();
                    fromDate = RelateDateTime.getDateByFirstDayOfYear(date);
                    toDate = RelateDateTime.getDateByLastDayOfYear(date);
                } else if (NOTARY_IN_RANGE.equals(context.getSearchDateFilter())) {
                    fromDate = context.getFromDateFilter();
                    toDate = context.getToDateFilter();
                }
                if(EditString.isNull(fromDate)) {
                    fromDate = "...";
                }
                if(EditString.isNull(toDate)) {
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
                contractExcelUtil.createCell(workbook, sheet, 7, 0, style, SystemMessageProperties.getSystemProperty("item_order_number"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, 7, 1, style, SystemMessageProperties.getSystemProperty("item_number_contract"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, 7, 3, style, SystemMessageProperties.getSystemProperty("item_contract_template_name"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
                contractExcelUtil.createCell(workbook, sheet, 7, 2, style, SystemMessageProperties.getSystemProperty("item_notary_date"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
                contractExcelUtil.createCell(workbook, sheet, 7, 5, style, SystemMessageProperties.getSystemProperty("item_notary"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
                contractExcelUtil.createCell(workbook, sheet, 7, 4, style, SystemMessageProperties.getSystemProperty("item_contract_relation_object"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
                contractExcelUtil.createCell(workbook, sheet, 7, 6, style, SystemMessageProperties.getSystemProperty("item_error_description"), false);
                int bgRow = 8;
                for (ContractInfo contractInfo : contractList) {
                    style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
                    contractExcelUtil.createCell(workbook, sheet, bgRow, 0, style, (double)(bgRow - 7));
    
                    style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
                    contractExcelUtil.createCell(workbook, sheet, bgRow, 1, style, contractInfo.getContractNumber(), false);
    
                    String contractRelation = "";
                    if (!EditString.isNull(contractInfo.getRelationObjectA())) {
                    	contractRelation += Constants.ENTER + contractInfo.getRelateObjectATitle() + Constants.COLON + Constants.SPACE
    	                                + contractInfo.getRelationObjectA();
    	            }           
    	            if (!EditString.isNull(contractInfo.getRelationObjectB())) {
    	            	contractRelation += Constants.ENTER + contractInfo.getRelateObjectBTitle() + Constants.COLON + Constants.SPACE
    	                                + contractInfo.getRelationObjectB();
    	            }            
    	            if (!EditString.isNull(contractInfo.getRelationObjectC())) {
    	            	contractRelation += Constants.ENTER + contractInfo.getRelateObjectCTitle() + Constants.COLON + Constants.SPACE
    	                                + contractInfo.getRelationObjectC();
    	            }
                    contractRelation = EditString.removeCR(contractRelation);
                    style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
                    contractExcelUtil.createCell(workbook, sheet, bgRow, 4, style, contractRelation, false);
    
                    style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
                    contractExcelUtil.createCell(workbook, sheet, bgRow, 2, style, 
                                                            RelateDateTime.toDayMonthYear(contractInfo.getNotaryDate()), false);
    
                    style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
                    contractExcelUtil.createCell(workbook, sheet, bgRow, 5, style,
                                                            contractInfo.getNotaryFamilyName() + " " + contractInfo.getNotaryFirstName(), false);
    
                    style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
                    contractExcelUtil.createCell(workbook, sheet, bgRow, 3, style, 
                                                            contractInfo.getContractTemplateName(), false);
                                        
                    style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
                    contractExcelUtil.createCell(workbook, sheet, bgRow, 6, style, contractInfo.getErrorDescription(), false);
                    bgRow++;
                }
             // total
                int total = bgRow - 8;
                bgRow ++;
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
                contractExcelUtil.createCell(workbook, sheet, bgRow, 0, style,
                        SystemMessageProperties.getSystemProperty("item_total") + Constants.COLON + Constants.SPACE
                        + total + Constants.SPACE
                        + SystemMessageProperties.getSystemProperty("item_contract"), false);

                // date time
                sheet.addMergedRegion(new CellRangeAddress(bgRow, bgRow, 5, 6));
                String strDate = RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime());

                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
                contractExcelUtil.createCell(workbook, sheet, bgRow, 5, style,
                        SystemMessageProperties.getSystemProperty("item_day") + Constants.SPACE + strDate.substring(0, 2)
                        + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_month") + Constants.SPACE
                        + strDate.substring(3, 5)
                        + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_year") + Constants.SPACE
                        + strDate.substring(6, strDate.length()), false);

                // signature
                bgRow ++;
                sheet.addMergedRegion(new CellRangeAddress(bgRow, bgRow, 5, 6));
                style = workbook.createCellStyle();
                style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.PAGE_TITLE));
                style.setFont(contractExcelUtil.createFont(workbook, 11, HSSFFont.BOLDWEIGHT_BOLD));
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
                contractExcelUtil.createCell(workbook, sheet, bgRow, 5, style, SystemMessageProperties.getSystemProperty("item_reporter"), false);
            }
        return workbook;
    }
}
