/**
 *
 */
package com.osp.npo.app.export;

import java.util.Calendar;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;

import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.context.ContractContext;
import com.osp.npo.app.export.ContractExcelUtil.StyleKind;
import com.osp.npo.app.viewhelper.ContractListByKindViewHelper;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.contract.ContractInfo;

/**
 * @author SonHD
 * @version $Revision: 27302 $
 */
public class ContractListByKindReport {

    private static final String SHEET_NAME = "DS Hop dong";

    private static final String NOTARY_IN_DAY = "01";

    private static final int COLUMN0 = 0;
    private static final int COLUMN1 = 1;
    private static final int COLUMN2 = 2;
    private static final int COLUMN3 = 3;
    private static final int COLUMN4 = 4;
    private static final int COLUMN5 = 5;
    private static final int COLUMN6 = 6;
//    private static final int COLUMN7 = 7;
//    private static final int COLUMN8 = 8;

 // STT
    private static final Integer MAX_CHAR_COLUMN0 = 5;
    // So HD
    private static final Integer MAX_CHAR_COLUMN1 = 13;
    // Ngay HD
    private static final Integer MAX_CHAR_COLUMN2 = 13;
    // Ten HD
    private static final Integer MAX_CHAR_COLUMN3 = 28;
    // Ben LQ
    private static final Integer MAX_CHAR_COLUMN4 = 28;
    // Noi dung HD
    private static final Integer MAX_CHAR_COLUMN5 = 28;
    // Cong chung vien
    private static final Integer MAX_CHAR_COLUMN6 = 28;

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
    public HSSFWorkbook createWorkbook(List<ContractInfo> contractList, ContractListByKindViewHelper contractListByKindViewHelper,
            ContractContext contractContext, CommonContext commonContext) throws Exception {

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
//        sheet.setColumnWidth(COLUMN7, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN7);
//        sheet.setColumnWidth(COLUMN8, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN8);

        int rowIndex = 0;

        sheet.addMergedRegion(new CellRangeAddress(0, 0, COLUMN5, COLUMN6));
        sheet.addMergedRegion(new CellRangeAddress(1, 1, COLUMN5, COLUMN6));

        HSSFCellStyle style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        HSSFCell cell = contractExcelUtil.createCell(workbook, sheet, 0, COLUMN0, style,
                commonContext.getSystemConfigValue("notary_office_name"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        contractExcelUtil.createCell(workbook, sheet, 0, COLUMN5, style,
                SystemMessageProperties.getSystemProperty("item_nation_name"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        contractExcelUtil.createCell(workbook, sheet, 1, COLUMN0, style,
                "     " + commonContext.getSystemConfigValue("notary_office_address"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
        contractExcelUtil.createCell(workbook, sheet, 1, COLUMN5, style,
                SystemMessageProperties.getSystemProperty("item_nation_motto"), false);

        rowIndex = rowIndex + 3;

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.PAGE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_contract_list"), false);
        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN6));

        rowIndex = rowIndex + 1;

        style = workbook.createCellStyle();
        style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM));
        style.setFont(contractExcelUtil.createFont(workbook, 13, HSSFFont.BOLDWEIGHT_NORMAL));
        String richTextString = SystemMessageProperties.getSystemProperty("item_contract_kind");
        int normalLength = richTextString.length();
        richTextString += Constants.COLON + Constants.SPACE;
        richTextString += contractListByKindViewHelper.getContractKindNameFilter();
        HSSFRichTextString richText = new HSSFRichTextString(richTextString);

        HSSFFont font = contractExcelUtil.createFont(workbook, 13, HSSFFont.BOLDWEIGHT_BOLD);
        richText.applyFont(normalLength + 1, richTextString.length(), font);

        contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, richText);

        sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN6));

        rowIndex++;
        if (NOTARY_IN_DAY.equals(contractContext.getNotaryDateFilter())) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_day") + Constants.SPACE
                    + RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime()), false);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN6));
        } else {
            String notaryDateFrom = Constants.DOT3;
            String notaryDateTo = Constants.DOT3;
            if (!EditString.isNull(contractContext.getNotaryDateFromFilter())) {
                notaryDateFrom = contractContext.getNotaryDateFromFilter();
            }

            if (!EditString.isNull(contractContext.getNotaryDateToFilter())) {
                notaryDateTo = contractContext.getNotaryDateToFilter();
            }
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                    SystemMessageProperties.getSystemProperty("item_from_date") + Constants.SPACE
                    + notaryDateFrom + Constants.SPACE
                    + SystemMessageProperties.getSystemProperty("item_to_date") + Constants.SPACE
                    + notaryDateTo, false);
            sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, COLUMN0, COLUMN6));
        }

        rowIndex = rowIndex + 2;

        //Table title
        HSSFCellStyle titleStyle = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_order_number"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_number_contract"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_notary_date"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_contract_template_name"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_contract_relation_object"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN5, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_contract_sumary"), false);

        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN6, titleStyle,
                    SystemMessageProperties.getSystemProperty("item_notary"), false);

//        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
//        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN7, titleStyle,
//                    SystemMessageProperties.getSystemProperty("item_notary"), false);
//        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
//        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN8, titleStyle,
//                    SystemMessageProperties.getSystemProperty("item_drafter_report"), false);

        rowIndex++;
        int tableIndex = 1;

        HSSFCellStyle currencyStyle = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_RIGHT);
        currencyStyle.setDataFormat(dataFormat.getFormat(ContractExcelUtil.CURRENCY_FORMAT));

        String template = "";
        for (ContractInfo contract : contractList) {
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style, (double)tableIndex);

            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN1, style, contract.getContractNumber(), false);

            // Thoi gian HD
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_CENTER);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN2, style, RelateDateTime.toDayMonthYear(contract.getNotaryDate()), false);

            // Ten HD
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN3, style, contract.getContractTemplateName(), false);

            // Ben lien quan
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            template = "";
            if (!EditString.isNull(contract.getRelationObjectA())) {
            	template += Constants.ENTER + contract.getRelateObjectATitle() + Constants.COLON + Constants.SPACE
                                + contract.getRelationObjectA();
            }           
            if (!EditString.isNull(contract.getRelationObjectB())) {
            	template += Constants.ENTER + contract.getRelateObjectBTitle() + Constants.COLON + Constants.SPACE
                                + contract.getRelationObjectB();
            }            
            if (!EditString.isNull(contract.getRelationObjectC())) {
            	template += Constants.ENTER + contract.getRelateObjectCTitle() + Constants.COLON + Constants.SPACE
                                + contract.getRelationObjectC();
            }
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN4, style, template, false);

            // Noi dung hop dong
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN5, style, contract.getContractSummaryReport(), false);

            // Cong chung vien
            style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
            cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN6, style, EditString.removeCR(contract.getNotaryFamilyName() + Constants.SPACE + contract.getNotaryFirstName()), false);

            tableIndex++;
            rowIndex++;
        }

        rowIndex++;
        style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
        cell = contractExcelUtil.createCell(workbook, sheet, rowIndex, COLUMN0, style,
                SystemMessageProperties.getSystemProperty("item_total") + Constants.SPACE
                + contractListByKindViewHelper.getTotalCount() + Constants.SPACE
                + SystemMessageProperties.getSystemProperty("item_contract"), false);

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
