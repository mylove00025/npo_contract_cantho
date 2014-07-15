package com.osp.npo.app.export;

import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.export.ContractExcelUtil.StyleKind;
import com.osp.npo.app.viewhelper.ContractStatisticViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.contractTotal.ContractBankTotalInfo;
import com.osp.npo.core.contractTotal.ContractUserTotalInfo;

/**
 * <P>Contract statistic report Class</P>
 *
 * @author HungPT
 * @version $Revision$
 */
public class ContractStatisticReport {

    private static final String SHEET_NAME = "Thong ke";
    private static final String NOTARY_OFFICE_NAME = "notary_office_name";
    private static final String NOTARY_OFFICE_ADDRESS = "notary_office_address";
    private static final Integer FONT_HEIGHT_NORMAL = 11;
    
    private static final String NOTARY_IN_DAY = "01";
    
    private static final int COLUMN0 = 0;
    private static final int COLUMN1 = 1;
    private static final int COLUMN2 = 2;
    private static final int COLUMN3 = 3;
    private static final int COLUMN4 = 4;
    
    private static final Integer MAX_CHAR_COLUMN0 = 3;
    private static final Integer MAX_CHAR_COLUMN1 = 10;
    private static final Integer MAX_CHAR_COLUMN2 = 40;
    private static final Integer MAX_CHAR_COLUMN3 = 19;
    private static final Integer MAX_CHAR_COLUMN4 = 19;
    
    private static final String TOTAL_CONTRACT_LABEL = "total_contract_label";
    private static final String TOTAL_ERROR_CONTRACT_LABEL = "total_error_contract_label";
    private static final String TOTAL_CONTRACT_BY_NOTARY_LABEL = "total_contract_by_notary_label";
    private static final String TOTAL_CONTRACT_BY_DRAFTER_LABEL = "total_contract_by_drafter_label";
    private static final String TOTAL_CONTRACT_BY_BANK_LABEL = "total_contract_by_bank";
    
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
    public HSSFWorkbook createWorkbook(ContractStatisticViewHelper contractStatisticViewHelper, CommonContext commonContext) throws Exception {
        
        contractExcelUtil = new ContractExcelUtil();
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        contractExcelUtil.setDefaultFont(workbook);
        
        HSSFSheet sheet = workbook.createSheet(SHEET_NAME);
        
        //sheet.setFitToPage(true);
        sheet.setGridsPrinted(false);
        sheet.setDisplayGridlines(false);
        
        HSSFPrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(false);
        printSetup.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); 
        printSetup.setScale((short)97);
        
        sheet.setMargin(HSSFSheet.TopMargin, ContractExcelUtil.NORMAL_MARGIN_TOP);
        sheet.setMargin(HSSFSheet.RightMargin, ContractExcelUtil.NORMAL_MARGIN_RIGHT);
        sheet.setMargin(HSSFSheet.BottomMargin, ContractExcelUtil.NORMAL_MARGIN_BOTTOM);
        sheet.setMargin(HSSFSheet.LeftMargin, ContractExcelUtil.NORMAL_MARGIN_LEFT);
        
        //Set column width
        sheet.setColumnWidth(COLUMN0, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN0);
        sheet.setColumnWidth(COLUMN1, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN1);
        sheet.setColumnWidth(COLUMN2, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN2);
        sheet.setColumnWidth(COLUMN3, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN3);
        sheet.setColumnWidth(COLUMN4, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN4);       
        
        int rowIndex = 0;
        
        HSSFCellStyle style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        HSSFCell cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    commonContext.getSystemConfigValue(NOTARY_OFFICE_NAME), false); 
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_RIGHT);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style,
                    SystemMessageProperties.getSystemProperty("item_nation_name"), false);

        rowIndex++;   
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, "    "
                    + commonContext.getSystemConfigValue(NOTARY_OFFICE_ADDRESS), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_RIGHT);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style,
                    SystemMessageProperties.getSystemProperty("item_nation_motto") + "     ", false);
        
        rowIndex = rowIndex + 2;
        
        //Page Title
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.PAGE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_contract_statistic"), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN4));
        
        rowIndex++;
        
        if (NOTARY_IN_DAY.equals(contractStatisticViewHelper.getNotaryDateFilter())) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_day") + Constants.SPACE
                    + RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()), false);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN4));
        } else {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_from_date") + Constants.SPACE
                    + contractStatisticViewHelper.getNotaryDateFromDisp() + Constants.SPACE
                    + SystemMessageProperties.getSystemProperty("item_to_date") + Constants.SPACE
                    + contractStatisticViewHelper.getNotaryDateToDisp(), false);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN4));
        }
        
        rowIndex = rowIndex + 2;
        
        style = workbook.createCellStyle();
        style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT));
        style.setFont(contractExcelUtil.createFont(workbook, FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, 
        		SystemMessageProperties.getSystemProperty(TOTAL_CONTRACT_LABEL)
                + contractStatisticViewHelper.getTotalContract(), false);
        
        rowIndex++;
        
        style = workbook.createCellStyle();
        style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT));
        style.setFont(contractExcelUtil.createFont(workbook, FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, 
        		SystemMessageProperties.getSystemProperty(TOTAL_ERROR_CONTRACT_LABEL)
                + contractStatisticViewHelper.getTotalErrorContract(), false);
        
        rowIndex = rowIndex + 2;
        
        style = workbook.createCellStyle();
        style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT));
        style.setFont(contractExcelUtil.createFont(workbook, FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, 
        		SystemMessageProperties.getSystemProperty(TOTAL_CONTRACT_BY_NOTARY_LABEL), false);
        
        rowIndex++;
        
        //List contract by notary
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);        
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style,
                    SystemMessageProperties.getSystemProperty("item_order_number"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style,
                    SystemMessageProperties.getSystemProperty("item_notary"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        style.setWrapText(true);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                    SystemMessageProperties.getSystemProperty("item_number_contract_by_notary"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);        
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style,
                    SystemMessageProperties.getSystemProperty("item_number_of_error_contract"), false);
        
        int startRow = ++rowIndex;
        int tableIndex = 1;
        for (ContractUserTotalInfo contract : contractStatisticViewHelper.getListContractByNotary()) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style, (double)tableIndex);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, contract.getFamilyName() + Constants.SPACE
                    + contract.getFirstName(), false);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, 
            		contract.getNumberOfContract() == null ? 0 : (double)contract.getNumberOfContract());
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style,
                    contract.getNumberOfErrorContract() == null ? 0 : (double)contract.getNumberOfErrorContract()); 
            
            tableIndex++;
            rowIndex++;
        }
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style,
                SystemMessageProperties.getSystemProperty("item_total"), false);
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, "" , false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN1, COLUMN2));
        
        if (rowIndex > startRow) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                    "SUM(D" + (startRow + 1) + ":D" + rowIndex + ")", true);
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style,
                    "SUM(E" + (startRow + 1) + ":E" + rowIndex + ")" , true);
        } else {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, (double)0);
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style, (double)0);
        }
        
        rowIndex = rowIndex + 2;
        
        style = workbook.createCellStyle();
        style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT));
        style.setFont(contractExcelUtil.createFont(workbook, FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, 
        		SystemMessageProperties.getSystemProperty(TOTAL_CONTRACT_BY_DRAFTER_LABEL), false);
        
        rowIndex++;
        
        //List contract by drafter
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);        
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style,
                    SystemMessageProperties.getSystemProperty("item_order_number"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style,
                    SystemMessageProperties.getSystemProperty("item_drafter_report"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        style.setWrapText(true);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                    SystemMessageProperties.getSystemProperty("item_number_contract_by_drafter"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);        
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style,
                    SystemMessageProperties.getSystemProperty("item_number_of_error_contract"), false);
        
        startRow = ++rowIndex;
        tableIndex = 1;
        for (ContractUserTotalInfo contract : contractStatisticViewHelper.getListContractByDrafter()) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style, (double)tableIndex);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            style.setWrapText(true);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, contract.getFamilyName() + Constants.SPACE
                    + contract.getFirstName(), false);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, 
            		contract.getNumberOfContract() == null ? 0 : (double)contract.getNumberOfContract()); 
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style,
                    contract.getNumberOfErrorContract() == null ? 0 : (double)contract.getNumberOfErrorContract());
            
            tableIndex++;
            rowIndex++;
        }
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style,
                SystemMessageProperties.getSystemProperty("item_total"), false);
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, "" , false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN1, COLUMN2));
        
        if (rowIndex > startRow) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                    "SUM(D" + (startRow + 1) + ":D" + rowIndex + ")", true);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style,
                    "SUM(E" + (startRow + 1) + ":E" + rowIndex + ")" , true);
        } else {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, (double)0);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style, (double)0);
        }
        
        if (commonContext.isBankReport()) {
	        rowIndex = rowIndex + 2;
	        
	        style = workbook.createCellStyle();
	        style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT));
	        style.setFont(contractExcelUtil.createFont(workbook, FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
	        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, 
	        		SystemMessageProperties.getSystemProperty(TOTAL_CONTRACT_BY_BANK_LABEL), false);
	        
	        rowIndex++;
	        
	        //List contract by bank
	        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);        
	        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style,
	                    SystemMessageProperties.getSystemProperty("item_order_number"), false);
	        
	        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
	        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style,
	                    SystemMessageProperties.getSystemProperty("item_bank"), false);
	        
	        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
	        style.setWrapText(true);
	        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
	                    SystemMessageProperties.getSystemProperty("item_number_contract_by_bank"), false);
	        
	        startRow = ++rowIndex;
	        tableIndex = 1;
	        for (ContractBankTotalInfo contract : contractStatisticViewHelper.getListContractByBank()) {
	            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
	            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style, (double)tableIndex);
	            
	            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
	            style.setWrapText(true);
	            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, contract.getBankName(), false);
	            
	            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
	            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
	            		contract.getNumberOfContract() == null ? 0 : (double)contract.getNumberOfContract()); 
	            
	            tableIndex++;
	            rowIndex++;
	        }
	        
	        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
	        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style,
	                SystemMessageProperties.getSystemProperty("item_total"), false);
	        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
	        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, "" , false);
	        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN1, COLUMN2));
	        
	        if (rowIndex > startRow) {
    	        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
    	        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
    	                "SUM(D" + (startRow + 1) + ":D" + rowIndex + ")", true);
	        } else {
	            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, (double)0);
	        }
	        
        }
        
        rowIndex = rowIndex + 2;       
        
        String strDate = RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime());
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                SystemMessageProperties.getSystemProperty("item_day") + Constants.SPACE + strDate.substring(0, 2) + Constants.SPACE
                + SystemMessageProperties.getSystemProperty("item_month") + Constants.SPACE + strDate.substring(3, 5) + Constants.SPACE
                + SystemMessageProperties.getSystemProperty("item_year") + Constants.SPACE + strDate.substring(6, strDate.length()), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN3, COLUMN4));
        
        rowIndex++;
        style = workbook.createCellStyle();
        style.setFont(contractExcelUtil.createFont(workbook, ContractExcelUtil.FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                    SystemMessageProperties.getSystemProperty("item_reporter"), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN3, COLUMN4));
        
        return workbook;
    }
    
    /**
     * <P>create work book hidden column "Hop dong loi"</P>
     * 
     * @author contractList 
     * @param contractListViewHelper
     * @param contractContext
     * @param commonContext    
     * @return HSSFWorkbook object
     * @throws Exception
     */
    public HSSFWorkbook createWorkbook2(ContractStatisticViewHelper contractStatisticViewHelper, CommonContext commonContext) throws Exception {
        
        contractExcelUtil = new ContractExcelUtil();
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        contractExcelUtil.setDefaultFont(workbook);
        
        HSSFSheet sheet = workbook.createSheet(SHEET_NAME);
        
        //sheet.setFitToPage(true);
        sheet.setGridsPrinted(false);
        sheet.setDisplayGridlines(false);
        
        HSSFPrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(false);
        printSetup.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); 
        printSetup.setScale((short)97);
        
        sheet.setMargin(HSSFSheet.TopMargin, ContractExcelUtil.NORMAL_MARGIN_TOP);
        sheet.setMargin(HSSFSheet.RightMargin, ContractExcelUtil.NORMAL_MARGIN_RIGHT);
        sheet.setMargin(HSSFSheet.BottomMargin, ContractExcelUtil.NORMAL_MARGIN_BOTTOM);
        sheet.setMargin(HSSFSheet.LeftMargin, ContractExcelUtil.NORMAL_MARGIN_LEFT);
        
        //Set column width
        sheet.setColumnWidth(COLUMN0, ContractExcelUtil.UNITS_OF_CHAR * 3);
        sheet.setColumnWidth(COLUMN1, ContractExcelUtil.UNITS_OF_CHAR * 10);
        sheet.setColumnWidth(COLUMN2, ContractExcelUtil.UNITS_OF_CHAR * 59);
        sheet.setColumnWidth(COLUMN3, ContractExcelUtil.UNITS_OF_CHAR * 19);
        
        int rowIndex = 0;
        
        HSSFCellStyle style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        HSSFCell cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    commonContext.getSystemConfigValue(NOTARY_OFFICE_NAME), false); 
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_RIGHT);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                    SystemMessageProperties.getSystemProperty("item_nation_name"), false);

        rowIndex++;   
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, "    "
                    + commonContext.getSystemConfigValue(NOTARY_OFFICE_ADDRESS), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_RIGHT);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                    SystemMessageProperties.getSystemProperty("item_nation_motto") + "     ", false);
        
        rowIndex = rowIndex + 2;
        
        //Page Title
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.PAGE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_contract_statistic"), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN3));
        
        rowIndex++;
        
        if (NOTARY_IN_DAY.equals(contractStatisticViewHelper.getNotaryDateFilter())) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_day") + Constants.SPACE
                    + RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()), false);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN3));
        } else {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_from_date") + Constants.SPACE
                    + contractStatisticViewHelper.getNotaryDateFromDisp() + Constants.SPACE
                    + SystemMessageProperties.getSystemProperty("item_to_date") + Constants.SPACE
                    + contractStatisticViewHelper.getNotaryDateToDisp(), false);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN3));
        }
        
        rowIndex = rowIndex + 2;
        
        style = workbook.createCellStyle();
        style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT));
        style.setFont(contractExcelUtil.createFont(workbook, FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, 
                SystemMessageProperties.getSystemProperty(TOTAL_CONTRACT_LABEL)
                + contractStatisticViewHelper.getTotalContract(), false);
        
        rowIndex++;
        
        style = workbook.createCellStyle();
        style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT));
        style.setFont(contractExcelUtil.createFont(workbook, FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, 
                SystemMessageProperties.getSystemProperty(TOTAL_ERROR_CONTRACT_LABEL)
                + contractStatisticViewHelper.getTotalErrorContract(), false);
        
        rowIndex = rowIndex + 2;
        
        style = workbook.createCellStyle();
        style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT));
        style.setFont(contractExcelUtil.createFont(workbook, FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, 
                SystemMessageProperties.getSystemProperty(TOTAL_CONTRACT_BY_NOTARY_LABEL), false);
        
        rowIndex++;
        
        //List contract by notary
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);        
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style,
                    SystemMessageProperties.getSystemProperty("item_order_number"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style,
                    SystemMessageProperties.getSystemProperty("item_notary"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        style.setWrapText(true);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                    SystemMessageProperties.getSystemProperty("item_number_contract_by_notary"), false);
        
        int startRow = ++rowIndex;
        int tableIndex = 1;
        for (ContractUserTotalInfo contract : contractStatisticViewHelper.getListContractByNotary()) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style, (double)tableIndex);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, contract.getFamilyName() + Constants.SPACE
                    + contract.getFirstName(), false);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, 
                    contract.getNumberOfContract() == null ? 0 : (double)contract.getNumberOfContract());
            
            tableIndex++;
            rowIndex++;
        }
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style,
                SystemMessageProperties.getSystemProperty("item_total"), false);
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, "" , false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN1, COLUMN2));
        
        if (rowIndex > startRow) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                    "SUM(D" + (startRow + 1) + ":D" + rowIndex + ")", true);
        } else {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, (double)0);
        }
        
        rowIndex = rowIndex + 2;
        
        style = workbook.createCellStyle();
        style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT));
        style.setFont(contractExcelUtil.createFont(workbook, FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, 
                SystemMessageProperties.getSystemProperty(TOTAL_CONTRACT_BY_DRAFTER_LABEL), false);
        
        rowIndex++;
        
        //List contract by drafter
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);        
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style,
                    SystemMessageProperties.getSystemProperty("item_order_number"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style,
                    SystemMessageProperties.getSystemProperty("item_drafter_report"), false);
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        style.setWrapText(true);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                    SystemMessageProperties.getSystemProperty("item_number_contract_by_drafter"), false);
        
        startRow = ++rowIndex;
        tableIndex = 1;
        for (ContractUserTotalInfo contract : contractStatisticViewHelper.getListContractByDrafter()) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style, (double)tableIndex);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            style.setWrapText(true);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, contract.getFamilyName() + Constants.SPACE
                    + contract.getFirstName(), false);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, 
                    contract.getNumberOfContract() == null ? 0 : (double)contract.getNumberOfContract()); 
            
            tableIndex++;
            rowIndex++;
        }
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style,
                SystemMessageProperties.getSystemProperty("item_total"), false);
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, "" , false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN1, COLUMN2));
        
        if (rowIndex > startRow) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                    "SUM(D" + (startRow + 1) + ":D" + rowIndex + ")", true);
            
        } else {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, (double)0);
            
        }
        
        if (commonContext.isBankReport()) {
            rowIndex = rowIndex + 2;
            
            style = workbook.createCellStyle();
            style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT));
            style.setFont(contractExcelUtil.createFont(workbook, FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, 
                    SystemMessageProperties.getSystemProperty(TOTAL_CONTRACT_BY_BANK_LABEL), false);
            
            rowIndex++;
            
            //List contract by bank
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);        
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style,
                        SystemMessageProperties.getSystemProperty("item_order_number"), false);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style,
                        SystemMessageProperties.getSystemProperty("item_bank"), false);
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            style.setWrapText(true);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                        SystemMessageProperties.getSystemProperty("item_number_contract_by_bank"), false);
            
            startRow = ++rowIndex;
            tableIndex = 1;
            for (ContractBankTotalInfo contract : contractStatisticViewHelper.getListContractByBank()) {
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style, (double)tableIndex);
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
                style.setWrapText(true);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, contract.getBankName(), false);
                
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                        contract.getNumberOfContract() == null ? 0 : (double)contract.getNumberOfContract()); 
                
                tableIndex++;
                rowIndex++;
            }
            
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style,
                    SystemMessageProperties.getSystemProperty("item_total"), false);
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, "" , false);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN1, COLUMN2));
            
            if (rowIndex > startRow) {
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style,
                        "SUM(D" + (startRow + 1) + ":D" + rowIndex + ")", true);
            } else {
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, (double)0);
            }
            
        }
        
        rowIndex = rowIndex + 2;       
        
        String strDate = RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime());
        
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style,
                "                                    " + SystemMessageProperties.getSystemProperty("item_day")
                + Constants.SPACE + strDate.substring(0, 2) + Constants.SPACE
                + SystemMessageProperties.getSystemProperty("item_month") + Constants.SPACE + strDate.substring(3, 5) + Constants.SPACE
                + SystemMessageProperties.getSystemProperty("item_year") + Constants.SPACE + strDate.substring(6, strDate.length()), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN2, COLUMN3));
        
        rowIndex++;
        style = workbook.createCellStyle();
        style.setFont(contractExcelUtil.createFont(workbook, ContractExcelUtil.FONT_HEIGHT_NORMAL, HSSFFont.BOLDWEIGHT_BOLD));
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style,
                "                                   " + SystemMessageProperties.getSystemProperty("item_reporter"), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN2, COLUMN3));
        
        return workbook;
    }
}
