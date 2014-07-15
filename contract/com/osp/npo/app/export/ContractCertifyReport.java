/**
 * 
 */
package com.osp.npo.app.export;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.osp.npo.app.export.ContractExcelUtil.StyleKind;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.contract.ContractInfo;

/**
 * @author SonHD
 * @version $Revision: 27517 $
 */
public class ContractCertifyReport {

    private static final String SHEET_NAME = "So hop dong";
    
    private static final int COLUMN0 = 0;
    private static final int COLUMN1 = 1;
    private static final int COLUMN2 = 2;
    private static final int COLUMN3 = 3;
    private static final int COLUMN4 = 4;
    private static final int COLUMN5 = 5;
    private static final int COLUMN6 = 6;
    //private static final int COLUMN7 = 7;
    
    private static final Integer MAX_CHAR_COLUMN0 = 12;
    private static final Integer MAX_CHAR_COLUMN1 = 12;
    //private static final Integer MAX_CHAR_COLUMN2 = 12;
    private static final Integer MAX_CHAR_COLUMN2 = 25;
    private static final Integer MAX_CHAR_COLUMN3 = 25;
    private static final Integer MAX_CHAR_COLUMN4 = 45;
    private static final Integer MAX_CHAR_COLUMN5 = 15;
    private static final Integer MAX_CHAR_COLUMN6 = 15;
    
    private ContractExcelUtil contractExcelUtil;
    
    /**
     * <P>Create Certify contract workbook</P>
     * @author SonHD
     *  
     * @param contractList
     * @return
     * @throws Exception
     */
    public HSSFWorkbook createWorkbook(List<ContractInfo> contractList) 
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
                printSetup.setScale((short)95);
                
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
                //sheet.setColumnWidth(COLUMN7, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN7);
                //Set repeat row for each page
                workbook.setRepeatingRowsAndColumns(0, -1, -1, 0, 1);
                
                HSSFCellStyle style; 
                int bgRow = 0;
                //Row 0
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN0, style, 
                        SystemMessageProperties.getSystemProperty("item_CNTR022_contract_number"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN1, style, 
                        SystemMessageProperties.getSystemProperty("item_CNTR022_notary_date"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
                /*contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN2, style, 
                        SystemMessageProperties.getSystemProperty("item_CNTR022_received_date"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true); */
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN2, style, 
                        SystemMessageProperties.getSystemProperty("item_CNTR022_relation_object2"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN3, style, 
                        SystemMessageProperties.getSystemProperty("item_CNTR022_contract_template_name"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN4, style, 
                        SystemMessageProperties.getSystemProperty("item_CNTR022_contract_summary"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN5, style, 
                        SystemMessageProperties.getSystemProperty("item_CNTR022_notary_name2"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN6, style, 
                        SystemMessageProperties.getSystemProperty("item_CNTR022_note"), false);
                bgRow = bgRow + 1;
                //Row 1
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN0, style, "(1)", false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN1, style, "(2)", false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN2, style, "(3)", false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN3, style, "(4)", false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN4, style, "(5)", false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN5, style, "(6)", false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN6, style, "(7)", false);
                
                bgRow = bgRow + 1;
                
                for (ContractInfo contractInfo : contractList) {
                    style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
                    contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN0, style, contractInfo.getContractNumber(), false);
    
                    style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
                    contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN1, style, 
                            RelateDateTime.toDayMonthYear(contractInfo.getNotaryDate()), false);
    
                    /*style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
                    contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN2, style, 
                            RelateDateTime.toDayMonthYear(contractInfo.getReceivedDate()), false);*/
    
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
                    contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN2, style, contractRelation, false);
    
                    style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
                    contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN3, style, contractInfo.getContractTemplateName(), false);
    
                    style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
                    contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN4, style, contractInfo.getContractSummaryReport(), false);
                    
                    style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
//                    contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN5, style, 
//                                                            contractInfo.getNotaryFamilyName() + " " + contractInfo.getNotaryFirstName(), false);
                    contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN5, style, contractInfo.getCrediterName(), false);
                    
                    style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
                    contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN6, style, contractInfo.getNote(), false);
                    bgRow++;
                }            
            }
        return workbook;
    }
}
