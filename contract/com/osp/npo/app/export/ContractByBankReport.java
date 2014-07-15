package com.osp.npo.app.export;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import com.osp.npo.app.context.CommonContext;
import com.osp.npo.app.context.ContractByBankListContext;
import com.osp.npo.app.export.ContractExcelUtil.StyleKind;
import com.osp.npo.common.global.Constants;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.common.util.SystemMessageProperties;
import com.osp.npo.core.contract.ContractInfo;

public class ContractByBankReport {

    private static final String NOTARY_IN_DAY = "01";
    private static final String NOTARY_IN_MONTH = "02";
    private static final String NOTARY_IN_YEAR = "03";
    private static final String NOTARY_IN_RANGE = "04";
    private static final String NOTARY_IN_WEEK = "00";
    private static final String FROM_TITLE = "Do";
    private static final String INTRODUCT = "giới thiệu";

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
    @SuppressWarnings("static-access")
    public HSSFWorkbook createWorkbook(List<ContractInfo> contractList, ContractByBankListContext context, CommonContext commonContext)
        throws Exception {

        contractExcelUtil = new ContractExcelUtil();

        HSSFWorkbook workbook = new HSSFWorkbook();
        contractExcelUtil.setDefaultFont(workbook);

        HSSFDataFormat dataFormat = workbook.createDataFormat();
        if (contractList != null && contractList.size() > 0) {

            // Get notaries name
            List<String> bankNameList = new ArrayList<String>();
            List<Long> bankIdList = new ArrayList<Long>();
            for (ContractInfo contractInfo: contractList) {
                if (!bankIdList.contains(contractInfo.getBankId())) {
                    bankIdList.add(contractInfo.getBankId());
                    bankNameList.add(contractInfo.getBankName());
                }
            }

            // create sheet
            for (int i = 0; i < bankNameList.size(); i++) {
                // format sheet
                HSSFSheet sheet;
                if (bankNameList.get(i).length() <= Constants.LENGTH_STRING_LIMIT) {
                    try {
                        sheet = workbook.createSheet(bankNameList.get(i));
                    } catch (Exception e) {
                        sheet = workbook.createSheet(bankNameList.get(i) + " (" + bankIdList.get(i) + ")");
                    }
                } else {
                    try {
                        sheet = workbook.createSheet(EditString.cutString(bankNameList.get(i)));
                    } catch (Exception e) {
                        sheet = workbook.createSheet(EditString.cutString(bankNameList.get(i)) + " (" + bankIdList.get(i) + ")");
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
                sheet.setColumnWidth(COLUMN6, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN6);
//                sheet.setColumnWidth(COLUMN7, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN7);
//                sheet.setColumnWidth(COLUMN8, ContractExcelUtil.UNITS_OF_CHAR * MAX_CHAR_COLUMN8);

                // merge cell header
                sheet.addMergedRegion(new CellRangeAddress(0, 0, COLUMN5, COLUMN6));
                sheet.addMergedRegion(new CellRangeAddress(1, 1, COLUMN5, COLUMN6));
                sheet.addMergedRegion(new CellRangeAddress(3, 3, COLUMN0, COLUMN6));
                sheet.addMergedRegion(new CellRangeAddress(4, 4, COLUMN0, COLUMN6));
                sheet.addMergedRegion(new CellRangeAddress(5, 5, COLUMN0, COLUMN6));

                HSSFCellStyle style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
                contractExcelUtil.createCell(workbook, sheet, 0, COLUMN0, style, commonContext.getSystemConfigValue("notary_office_name"), false);

                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
                contractExcelUtil.createCell(workbook, sheet, 0, COLUMN5, style,
                        SystemMessageProperties.getSystemProperty("item_nation_name"), false);

                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM_LEFT);
                contractExcelUtil.createCell(workbook, sheet, 1, COLUMN0, style,"     " +
                        commonContext.getSystemConfigValue("notary_office_address"), false);

                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
                contractExcelUtil.createCell(workbook, sheet, 1, COLUMN5, style,
                        SystemMessageProperties.getSystemProperty("item_nation_motto"), false);

                style = contractExcelUtil.getCellStyle(workbook, StyleKind.PAGE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, 3, COLUMN0, style,
                        SystemMessageProperties.getSystemProperty("item_contract_list"), false);


                style = workbook.createCellStyle();
                style.cloneStyleFrom(contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM));
                style.setFont(contractExcelUtil.createFont(workbook, 13, HSSFFont.BOLDWEIGHT_NORMAL));

//                String richTextString = SystemMessageProperties.getSystemProperty("item_from_bank");
                String richTextString = FROM_TITLE;
                int startIndex = richTextString.length();
                richTextString += Constants.SPACE;
                richTextString += bankNameList.get(i);
                richTextString += Constants.SPACE;
                int endIndex = richTextString.length() - 1;
//                richTextString += SystemMessageProperties.getSystemProperty("item_send_word");
                richTextString += INTRODUCT;
                HSSFRichTextString richText = new HSSFRichTextString(richTextString);

                HSSFFont font = workbook.createFont();
                font.setFontHeightInPoints((short)13);
                font.setFontName(contractExcelUtil.TIMES_NEWS_ROMAN);

                font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

                richText.applyFont(startIndex, endIndex, font);

                HSSFFont fontIntroduct = workbook.createFont();
                fontIntroduct.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
                fontIntroduct.setFontHeightInPoints((short)13);
                fontIntroduct.setFontName(contractExcelUtil.TIMES_NEWS_ROMAN);
//
                richText.applyFont(endIndex + 1, richText.length(), fontIntroduct);

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
                    contractExcelUtil.createCell(workbook, sheet, 5, COLUMN0, style, SystemMessageProperties.getSystemProperty("item_from_date")
                            + Constants.SPACE
                            + fromDate + Constants.SPACE
                            + SystemMessageProperties.getSystemProperty("item_to_date")
                            + Constants.SPACE
                            + toDate, false);
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
                contractExcelUtil.createCell(workbook, sheet, 7, COLUMN4, style,
                        SystemMessageProperties.getSystemProperty("item_contract_relation_object"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                contractExcelUtil.createCell(workbook, sheet, 7, COLUMN5, style,
                        SystemMessageProperties.getSystemProperty("item_contract_sumary"), false);
                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
                style.setWrapText(true);
                contractExcelUtil.createCell(workbook, sheet, 7, COLUMN6, style,
                        SystemMessageProperties.getSystemProperty("item_notary"), false);
//                style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_TITLE);
//                contractExcelUtil.createCell(workbook, sheet, 7, COLUMN7, style, SystemMessageProperties.getSystemProperty("item_notary"), false);

                int bgRow = 8;
                for (ContractInfo contractInfo : contractList) {
                    if (bankIdList.get(i).equals(contractInfo.getBankId())) {

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

                        // Cong chung vien
                        style = contractExcelUtil.getCellStyle(workbook, StyleKind.TABLE_ITEM_LEFT);
                        contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN6 , style, EditString.removeCR(contractInfo.getNotaryFamilyName()
                                + Constants.SPACE + contractInfo.getNotaryFirstName()), false);

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
                sheet.addMergedRegion(new CellRangeAddress(bgRow, bgRow, COLUMN5, COLUMN6));
                String strDate = RelateDateTime.toDayMonthYear(Calendar.getInstance().getTime());

                style = contractExcelUtil.getCellStyle(workbook, StyleKind.NORMAL_ITEM);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN5, style,
                        SystemMessageProperties.getSystemProperty("item_day") + Constants.SPACE + strDate.substring(0, 2)
                        + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_month") + Constants.SPACE
                        + strDate.substring(3, 5)
                        + Constants.SPACE + SystemMessageProperties.getSystemProperty("item_year") + Constants.SPACE
                        + strDate.substring(6, strDate.length()), false);

                // signature
                bgRow ++;
                sheet.addMergedRegion(new CellRangeAddress(bgRow, bgRow, COLUMN5, COLUMN6));
                style = workbook.createCellStyle();
                style.setFont(contractExcelUtil.createFont(workbook, 11, HSSFFont.BOLDWEIGHT_BOLD));
                style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
                contractExcelUtil.createCell(workbook, sheet, bgRow, COLUMN5, style, SystemMessageProperties.getSystemProperty("item_reporter"), false);
            }
        }

        return workbook;
    }
}
