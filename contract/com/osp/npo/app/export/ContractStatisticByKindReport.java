package com.osp.npo.app.export;


import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.viewhelper.ContractStatisticByKindViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.contractTotal.ContractKindTotalInfo;
import com.osp.npo.app.export.ContractExcelUtil.StyleKind;

/**
 * <P>Export excel file class</P>
 *
 * @author HungPT
 * @version $Revision$
 */
public class ContractStatisticByKindReport {
    
    private static final String SHEET_NAME = "Baocao";
    
    private static final String NOTARY_IN_DAY = "01";
    
    private static final int COLUMN0 = 0;
    private static final int COLUMN1 = 1;
    private static final int COLUMN2 = 2;
    private static final int COLUMN3 = 3;
    private static final int COLUMN4 = 4;
    private static final int COLUMN5 = 5;
   
    private static final Integer MAX_CHAR_COLUMN0 = 5;
    private static final Integer MAX_CHAR_COLUMN1 = 24;
    private static final Integer MAX_CHAR_COLUMN2 = 36;
    private static final Integer MAX_CHAR_COLUMN3 = 12;
    private static final Integer MAX_CHAR_COLUMN4 = 12;
    private static final Integer MAX_CHAR_COLUMN5 = 12;
    
    private ContractExcelUtil contractExcelUtil;
    
    /**
     * <P>create work book</P>
     * 
     * @author contractList 
     * @param contractListViewHelper
     * @param contractContext
     * @param commonContext    
     * @return HSSFWorkbook object
     * @throws Exception
     */
    public HSSFWorkbook createWorkbook(ContractStatisticByKindViewHelper viewhelper, CommonContext commonContext) throws Exception {
        
        contractExcelUtil = new ContractExcelUtil();
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        contractExcelUtil.setDefaultFont(workbook);
        
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        HSSFSheet sheet = workbook.createSheet(SHEET_NAME);
        
        //sheet.setFitToPage(true);
        sheet.setGridsPrinted(false);
        sheet.setDisplayGridlines(false);
        
        HSSFPrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(false);
        printSetup.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); 
        
        sheet.setMargin(HSSFSheet.TopMargin, ContractExcelUtil.NARROW_MARGIN_TOP);
        sheet.setMargin(HSSFSheet.RightMargin, ContractExcelUtil.NARROW_MARGIN_RIGHT);
        sheet.setMargin(HSSFSheet.BottomMargin, ContractExcelUtil.NARROW_MARGIN_BOTTOM);
        sheet.setMargin(HSSFSheet.LeftMargin, ContractExcelUtil.NARROW_MARGIN_LEFT);
        
        //Set column width
        sheet.setColumnWidth(COLUMN0, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN0);
        sheet.setColumnWidth(COLUMN1, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN1);
        sheet.setColumnWidth(COLUMN2, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN2);
        sheet.setColumnWidth(COLUMN3, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN3);
        sheet.setColumnWidth(COLUMN4, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN4);
        sheet.setColumnWidth(COLUMN5, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN5);
        
        int rowIndex = 0;
        
        sheet.addMergedRegion(new CellRangeAddress(0, 0, COLUMN3, COLUMN5));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, COLUMN3, COLUMN5));
        
        HSSFCellStyle style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        HSSFCell cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                commonContext.getSystemConfigValue("notary_office_name"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                SystemMessageProperties.getSystemProperty("item_nation_name"), false);

        rowIndex++;
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                "     " + commonContext.getSystemConfigValue("notary_office_address"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                SystemMessageProperties.getSystemProperty("item_nation_motto"), false);
       
        rowIndex = rowIndex + 2;
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.PAGE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_statistic_by_kind"), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN5));
        
        rowIndex++;
        
        if (NOTARY_IN_DAY.equals(viewhelper.getNotaryDateFilter())) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_day") + Constants.SPACE
                    + RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()), false);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN5));
        } else {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_from_date") + Constants.SPACE
                    + viewhelper.getNotaryDateFromDisp() + Constants.SPACE
                    + SystemMessageProperties.getSystemProperty("item_to_date") + Constants.SPACE
                    + viewhelper.getNotaryDateToDisp(), false);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN5));
        }
        
        rowIndex = rowIndex + 2;
        
        //Table title
        HSSFCellStyle titleStyle = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_order_number"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_contract_kind"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_contract_template_name"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_internal_place_export"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_external_place_export"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);        
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN5, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_sum"), false);
        
        rowIndex++;
        int tableIndex = 1;
        
        HSSFCellStyle currencyStyle = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_RIGHT);
        currencyStyle.setDataFormat(dataFormat.getFormat(ContractExcelUtil.CURRENCY_FORMAT));
        
        for (ContractKindTotalInfo info : viewhelper.getListContractByKind()) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, (double)tableIndex);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style, info.getKindName(), false);
            
            if (info.getNumberOfTemplateByKind().intValue() > 1) {
                sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex + info.getNumberOfTemplateByKind().intValue() - 1, COLUMN0, COLUMN0));
                sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex + info.getNumberOfTemplateByKind().intValue() - 1, COLUMN1, COLUMN1));
            }
            
            if (info.getNumberOfTemplateByKind().intValue() > 0) {
                
                tableIndex++;
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_FIRST_SUB_ITEM_LEFT);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, info.getTemplateName(), false);
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_FIRST_SUB_ITEM_CENTER);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, info.getNumberOfInternalContract().doubleValue());
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_FIRST_SUB_ITEM_CENTER);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style, info.getNumberOfExternalContract().doubleValue());
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_FIRST_SUB_ITEM_CENTER);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN5, style, info.getNumberOfContract().doubleValue());
                
            } else {
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_SUB_ITEM_LEFT);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, info.getTemplateName(), false);
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_SUB_ITEM_CENTER);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, info.getNumberOfInternalContract().doubleValue());
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_SUB_ITEM_CENTER);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style, info.getNumberOfExternalContract().doubleValue());
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_SUB_ITEM_CENTER);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN5, style, info.getNumberOfContract().doubleValue());
            }
            
            rowIndex++;
        }
        
        //Last row of table
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN2));
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                SystemMessageProperties.getSystemProperty("item_sum"), false);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style, "", false);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, "", false);
        
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, viewhelper.getNumberOfInternalContract().doubleValue());
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style, viewhelper.getNumberOfExternalContract().doubleValue());
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN5, style, viewhelper.getNumberOfContract().doubleValue());
        
        
        rowIndex = rowIndex + 2;        
        
        String strDate = RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime());
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                SystemMessageProperties.getSystemProperty("item_day") + Constants.SPACE + strDate.substring(0, 2) + Constants.SPACE
                + SystemMessageProperties.getSystemProperty("item_month") + Constants.SPACE + strDate.substring(3, 5) + Constants.SPACE
                + SystemMessageProperties.getSystemProperty("item_year") + Constants.SPACE + strDate.substring(6, strDate.length()), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN3, COLUMN5));
        
        rowIndex++;
        style = workbook.createCellStyle();
        style.setFont(contractExcelUtil.createFont(workbook, ContractExcelUtil.FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                    SystemMessageProperties.getSystemProperty("item_reporter"), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN3, COLUMN5));
        
        return workbook;
    }
    
    /**
     * <P>create work book hidden column "Lap tai VP" & "Lap ngoai VP"</P>
     * 
     * @author contractList 
     * @param contractListViewHelper
     * @param contractContext
     * @param commonContext    
     * @return HSSFWorkbook object
     * @throws Exception
     */
    public HSSFWorkbook createWorkbook2(ContractStatisticByKindViewHelper viewhelper, CommonContext commonContext) throws Exception {
        
        contractExcelUtil = new ContractExcelUtil();
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        contractExcelUtil.setDefaultFont(workbook);
        
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        HSSFSheet sheet = workbook.createSheet(SHEET_NAME);
        
        //sheet.setFitToPage(true);
        sheet.setGridsPrinted(false);
        sheet.setDisplayGridlines(false);
        
        HSSFPrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(false);
        printSetup.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); 
        
        sheet.setMargin(HSSFSheet.TopMargin, ContractExcelUtil.NARROW_MARGIN_TOP);
        sheet.setMargin(HSSFSheet.RightMargin, ContractExcelUtil.NARROW_MARGIN_RIGHT);
        sheet.setMargin(HSSFSheet.BottomMargin, ContractExcelUtil.NARROW_MARGIN_BOTTOM);
        sheet.setMargin(HSSFSheet.LeftMargin, ContractExcelUtil.NARROW_MARGIN_LEFT);
        
        //Set column width
        sheet.setColumnWidth(COLUMN0, ContractExcelUtil.UNITS_OF_CHAR * 5);
        sheet.setColumnWidth(COLUMN1, ContractExcelUtil.UNITS_OF_CHAR * 30);
        sheet.setColumnWidth(COLUMN2, ContractExcelUtil.UNITS_OF_CHAR * 54);
        sheet.setColumnWidth(COLUMN3, ContractExcelUtil.UNITS_OF_CHAR * 12);
        
        int rowIndex = 0;
        
        //sheet.addMergedRegion(new CellRangeAddress(0, 0, COLUMN2, COLUMN3));
        //sheet.addMergedRegion(new CellRangeAddress(1, 1, COLUMN2, COLUMN3));
        
        HSSFCellStyle style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        HSSFCell cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                commonContext.getSystemConfigValue("notary_office_name"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_RIGHT);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                SystemMessageProperties.getSystemProperty("item_nation_name"), false);

        rowIndex++;
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                "     " + commonContext.getSystemConfigValue("notary_office_address"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_RIGHT);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                SystemMessageProperties.getSystemProperty("item_nation_motto") + "        ", false);
       
        rowIndex = rowIndex + 2;
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.PAGE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_statistic_by_kind"), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN3));
        
        rowIndex++;
        
        if (NOTARY_IN_DAY.equals(viewhelper.getNotaryDateFilter())) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_day") + Constants.SPACE
                    + RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()), false);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN3));
        } else {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_from_date") + Constants.SPACE
                    + viewhelper.getNotaryDateFromDisp() + Constants.SPACE
                    + SystemMessageProperties.getSystemProperty("item_to_date") + Constants.SPACE
                    + viewhelper.getNotaryDateToDisp(), false);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN3));
        }
        
        rowIndex = rowIndex + 2;
        
        //Table title
        HSSFCellStyle titleStyle = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_order_number"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_contract_kind"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_contract_template_name"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);        
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_sum"), false);
        
        rowIndex++;
        int tableIndex = 1;
        
        HSSFCellStyle currencyStyle = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_RIGHT);
        currencyStyle.setDataFormat(dataFormat.getFormat(ContractExcelUtil.CURRENCY_FORMAT));
        
        for (ContractKindTotalInfo info : viewhelper.getListContractByKind()) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, (double)tableIndex);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style, info.getKindName(), false);
            
            if (info.getNumberOfTemplateByKind().intValue() > 1) {
                sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex + info.getNumberOfTemplateByKind().intValue() - 1, COLUMN0, COLUMN0));
                sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex + info.getNumberOfTemplateByKind().intValue() - 1, COLUMN1, COLUMN1));
            }
            
            if (info.getNumberOfTemplateByKind().intValue() > 0) {
                
                tableIndex++;
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_FIRST_SUB_ITEM_LEFT);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, info.getTemplateName(), false);
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_FIRST_SUB_ITEM_CENTER);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, info.getNumberOfContract().doubleValue());
                
            } else {
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_SUB_ITEM_LEFT);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, info.getTemplateName(), false);
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_SUB_ITEM_CENTER);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, info.getNumberOfContract().doubleValue());
            }
            
            rowIndex++;
        }
        
        //Last row of table
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN2));
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                SystemMessageProperties.getSystemProperty("item_sum"), false);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style, "", false);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, "", false);
        
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, viewhelper.getNumberOfContract().doubleValue());
        
        
        rowIndex = rowIndex + 2;        
        
        String strDate = RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime());
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style,
                "                 " + SystemMessageProperties.getSystemProperty("item_day") + Constants.SPACE + strDate.substring(0, 2) + Constants.SPACE
                + SystemMessageProperties.getSystemProperty("item_month") + Constants.SPACE + strDate.substring(3, 5) + Constants.SPACE
                + SystemMessageProperties.getSystemProperty("item_year") + Constants.SPACE + strDate.substring(6, strDate.length()), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN2, COLUMN3));
        
        rowIndex++;
        style = workbook.createCellStyle();
        style.setFont(contractExcelUtil.createFont(workbook, ContractExcelUtil.FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style,
                "                 " + SystemMessageProperties.getSystemProperty("item_reporter"), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN2, COLUMN3));
        
        return workbook;
    }
}
