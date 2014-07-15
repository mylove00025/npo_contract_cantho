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
import com.osp.npo.app.viewhelper.ContractAdditionViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.app.export.ContractExcelUtil.StyleKind;

/**
 * <P>Export excel file class</P>
 *
 * @author SonHD
 * @version $Revision: 27302 $
 */
public class ContractAdditionReport {
    
    private static final String SHEET_NAME = "Baocao";
    
    private static final String NOTARY_IN_DAY = "01";
    
    private static final int COLUMN0 = 0;
    private static final int COLUMN1 = 1;
    private static final int COLUMN2 = 2;
    private static final int COLUMN3 = 3;
    private static final int COLUMN4 = 4;
    private static final int COLUMN5 = 5;
    private static final int COLUMN6 = 6;
   
    private static final Integer MAX_CHAR_COLUMN0 = 10;
    private static final Integer MAX_CHAR_COLUMN1 = 20;
    private static final Integer MAX_CHAR_COLUMN2 = 15;
    private static final Integer MAX_CHAR_COLUMN3 = 20;
    private static final Integer MAX_CHAR_COLUMN4 = 25;
    private static final Integer MAX_CHAR_COLUMN5 = 30;
    private static final Integer MAX_CHAR_COLUMN6 = 20;
    
    private ContractExcelUtil contractExcelUtil;
    
    /**
     * <P>Action for first view</P>
     * 
     * @author contractList 
     * @param contractListViewHelper
     * @param contractContext
     * @param commonContext
     * @return HSSFWorkbook object
     * @throws Exception
     */
    @SuppressWarnings("unused")
    public HSSFWorkbook createWorkbook(ContractAdditionViewHelper contractAdditionViewHelper, CommonContext commonContext) throws Exception {
        
        contractExcelUtil = new ContractExcelUtil();
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        contractExcelUtil.setDefaultFont(workbook);
        
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        HSSFSheet sheet = workbook.createSheet(SHEET_NAME);
        
        //sheet.setFitToPage(true);
        sheet.setGridsPrinted(false);
        sheet.setDisplayGridlines(false);
        
        HSSFPrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
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
        sheet.setColumnWidth(COLUMN6, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN6);
        
        int rowIndex = 0;
        
        sheet.addMergedRegion(new CellRangeAddress(0, 0, COLUMN5, COLUMN6));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, COLUMN5, COLUMN6));
        
        HSSFCellStyle style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        HSSFCell cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                commonContext.getSystemConfigValue("notary_office_name"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN5, style,
                SystemMessageProperties.getSystemProperty("item_nation_name"), false);

        rowIndex++;
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                "     " + commonContext.getSystemConfigValue("notary_office_address"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN5, style,
                SystemMessageProperties.getSystemProperty("item_nation_motto"), false);
       
        rowIndex = rowIndex + 2;
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.PAGE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_addition_contract"), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN6));
        
        rowIndex++;
        
        if (NOTARY_IN_DAY.equals(contractAdditionViewHelper.getNotaryDateFilter())) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_day") + Constants.SPACE
                    + RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()), false);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN6));
        } else {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_from_date") + Constants.SPACE
                    + contractAdditionViewHelper.getNotaryDateFromFilter() + Constants.SPACE
                    + SystemMessageProperties.getSystemProperty("item_to_date") + Constants.SPACE
                    + contractAdditionViewHelper.getNotaryDateToFilter(), false);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN6));
        }
        
        rowIndex = rowIndex + 2;
        
        //Table title
        HSSFCellStyle titleStyle = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_order_number"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_drafter_report"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);        
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_notary_date"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_number_contract"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_contract_relation_object"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN5, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_addition_description"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);        
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN6, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_notary"), false);
        
        rowIndex++;
        int tableIndex = 1;
        
        HSSFCellStyle currencyStyle = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_RIGHT);
        currencyStyle.setDataFormat(dataFormat.getFormat(ContractExcelUtil.CURRENCY_FORMAT));
        
        for (ContractInfo info : contractAdditionViewHelper.getContractList()) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, (double)tableIndex);
            
            if(info.getDrafterFamilyName() == null) {
                info.setDrafterFamilyName("");
            }
            
            if(info.getDrafterFirstName() == null) {
                info.setDrafterFirstName("");
            }
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style, info.getDrafterFamilyName() + Constants.SPACE + info.getDrafterFirstName(), false);
            
//            if (info.getNumberOfContractByDrafter().intValue() > 1) {
//                sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex + info.getNumberOfContractByDrafter().intValue() - 1, COLUMN0, COLUMN0));
//                sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex + info.getNumberOfContractByDrafter().intValue() - 1, COLUMN1, COLUMN1));
//            }
            
//            if (info.getNumberOfContractByDrafter().intValue() > 0) {
//                tableIndex++;
//            }
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style,
                        RelateDateTime.formatDate(RelateDateTime.DDMMYYYY, info.getNotaryDate()), false);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, info.getContractNumber(), false);
            
            String relation = "";
            if (!EditString.isNull(info.getRelationObjectA())) {
                relation += Constants.ENTER + info.getRelateObjectATitle() + Constants.COLON + Constants.SPACE
                                + info.getRelationObjectA();
            }           
            if (!EditString.isNull(info.getRelationObjectB())) {
                relation += Constants.ENTER + info.getRelateObjectBTitle() + Constants.COLON + Constants.SPACE
                                + info.getRelationObjectB();
            }            
            if (!EditString.isNull(info.getRelationObjectC())) {
                relation += Constants.ENTER + info.getRelateObjectCTitle() + Constants.COLON + Constants.SPACE
                                + info.getRelationObjectC();
            }
            
            relation = EditString.removeCR(relation);
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style, relation, false);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN5, style, EditString.removeCR(info.getAdditionDescription()), false);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN6, style, info.getNotaryFamilyName() + Constants.SPACE + info.getNotaryFirstName(), false);
            
            rowIndex++;
            tableIndex++;
        }
   
        
        rowIndex = rowIndex + 1;        
        
        String strDate = RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime());
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN5, style,
                SystemMessageProperties.getSystemProperty("item_day") + Constants.SPACE + strDate.substring(0, 2) + Constants.SPACE
                + SystemMessageProperties.getSystemProperty("item_month") + Constants.SPACE + strDate.substring(3, 5) + Constants.SPACE
                + SystemMessageProperties.getSystemProperty("item_year") + Constants.SPACE + strDate.substring(6, strDate.length()), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN5, COLUMN6));
        
        rowIndex++;
        style = workbook.createCellStyle();
        style.setFont(contractExcelUtil.createFont(workbook, ContractExcelUtil.FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN5, style,
                    SystemMessageProperties.getSystemProperty("item_reporter"), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN5, COLUMN6));
        
        return workbook;
    }
}
