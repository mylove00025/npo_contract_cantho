package com.osp.npo.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.IOUtils;
import com.osp.npo.core.contract.ContractInfo;
import com.osp.npo.core.contract.PropertyInfo;

/**
 *
 * Utility for auto generate report with existing template
 *
 * @author GiangVT
 * @version $Revision$
 */
public class GenerateDocx {

    // Constant for .docx zip structure
    public static final String CONTENT_TYEPS = "[Content_Types].xml";
    public static final String REL = "_rels/.rels";
    public static final String DOCPROPS_APP = "docProps/app.xml";
    public static final String DOCPROPS_CORE = "docProps/core.xml";
    public static final String DOCUMENT = "word/document.xml";
    public static final String END_NOTE = "word/endnotes.xml";
    public static final String FONT_TABLE = "word/fontTable.xml";
    public static final String FOOTER1 = "word/footer1.xml";
    public static final String FOOTER2 = "word/footer2.xml";
    public static final String FOOT_NOTE = "word/footnotes.xml";
    public static final String HEADER1 = "word/header1.xml";
    public static final String NUMBERING = "word/numbering.xml";
    public static final String SETTING = "word/settings.xml";
    public static final String STYLE = "word/styles.xml";
    public static final String WEB_SETTING = "word/webSettings.xml";
    public static final String DOCUMENT_REL = "word/_rels/document.xml.rels";
    public static final String THEME = "word/theme/theme1.xml";
    public static final String CUSTOM_ITEM1 = "customXml/item1.xml";
    public static final String CUSTOM_PROP1 = "customXml/itemProps1.xml";
    public static final String CUSTOM_REL = "customXml/_rels/item1.xml.rels";
    public static final String UPLOAD_FOLDER_KEY = "system_contract_folder";
    public static final String TEMPLATE_FOLDER_KEY = "system_template_contract_folder";
    public static final String PROPERTY_SEPERATE_CHAR = "#";
    public static final String DEFAULT_CONTENT = "....";
    public static final String SYSTEM_OFICE_NAME = "system_ofice_name";

    // default template & export path
    public static final String UTF_8 = "UTF-8";
    public static final String DOCUMENT_XML = "word/document.xml";

    private ContractInfo info;
    private PropertyInfo propertyInfo;

    private String[] pattern;

    public GenerateDocx(ContractInfo info, PropertyInfo propertyInfo) {

        pattern = (SystemProperties.getProperty("system_token_list") + "#" +
                SystemProperties.getProperty("system_property_token_list")).split(PROPERTY_SEPERATE_CHAR);

        this.info = info;
        this.propertyInfo = propertyInfo;
    }

    /**
     *
     * export file with
     *
     * @author GiangVT
     *
     * @param templatePath for templatePath
     * @param fileOut for file content
     *
     * @return export file if process successful or null if not
     * @throws IOException to catch exception
     */
    public File export(String templatePath, File fileOut) throws IOException {
        File fileIn = new File(templatePath);
        FileInputStream fis = new FileInputStream(fileIn);
        ZipInputStream zis = new ZipInputStream(fis);

        FileOutputStream fos = new FileOutputStream(fileOut);
        ZipOutputStream zos = new ZipOutputStream(fos);

        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            final ZipEntry outEntry = new ZipEntry(entry.getName());
            zos.putNextEntry(outEntry);

            if (entry.getName().equals(DOCUMENT_XML)) {
                final String contentIn = IOUtils.toString(zis, UTF_8);
                final String outContent = ReplaceToken(contentIn, pattern);
                IOUtils.write(outContent, zos, UTF_8);
            } else {
                IOUtils.copy(zis, zos);
            }

            zos.closeEntry();
        }
        zos.close();
        fos.close();
        zis.close();
        fis.close();
        return fileOut;
    }

    /**
     *
     * algorithm to replace token
     *      1. Using replace all of string          (current version - just built)
     *      2a. Using pattern matching with library (may be: next general)
     *      2b. Rewrite pattern matching            (may be: next general)
     *
     * @author GiangVT
     * @param text
     * @param pattern
     *        like: npo_name, npo_birthday...
     * @return text after replace
     */
    private String ReplaceToken(String text,String[] pattern) {
        String replaceText = text;
        String replacePattern;
        if (info != null) {
            for (String token : pattern) {
                replacePattern = getToken(info, propertyInfo, token);
                if (replacePattern != null) {
                    replaceText = replaceText.replaceAll("#" + token + "#", replacePattern);
                } else {
                    replaceText = replaceText.replaceAll("#" + token + "#", DEFAULT_CONTENT);
                }
            }
        }
        return replaceText;
    }

    public String getToken(ContractInfo info, PropertyInfo propertyInfo, String token) {
        return "";
        /*
        if (token.equals("contractnumber")) {
            return info.getContractNumber();
        }
        if (token.equals("contractkindname")) {
            return info.getContractKindName();
        }
        if (token.equals("contractvalue")) {
            return info.getContractValue();
        }
        if (token.equals("notaryaccount")) {
            return info.getNotaryAccount();
        }
        if (token.equals("drafteraccount")) {
            return info.getDrafterAccount();
        }
        if (token.equals("receiveddate")) {
            if (info.getReceivedDate() != null) {
                return RelateDateTime.toDayMonthYear(info.getReceivedDate());
            } else {
                return null;
            }
        }
        if (token.equals("notarydate")) {
            if (info.getNotaryDate() != null) {
                return RelateDateTime.toDayMonthYear(info.getNotaryDate());
            } else {
                return null;
            }
        }

        if (token.equals("costtt91")) {
            return info.getCostTt91();
        }
        if (token.equals("costdraft")) {
            return info.getCostDraft();
        }

        if (token.equals("costnotaryoutsite")) {
            return info.getCostNotaryOutsite();
        }
        if (token.equals("costotherdetermine")) {
            return info.getCostOtherDetermine();
        }
        if (token.equals("costtotal")) {
            return info.getCostTotal();
        }
        if (token.equals("notaryplace")) {
            if(info.getNotaryPlaceFlag().equals(Boolean.TRUE)) {
                return SystemProperties.getProperty(SYSTEM_OFICE_NAME);
            }
            return info.getNotaryPlace();
        }
        if (token.equals("bankservicefee")) {
            return info.getBankServiceFee();
        }
        if (token.equals("creditername")) {
            return info.getCrediterName();
        }
        if (token.equals("errordescription")) {
            return info.getErrorDescription();
        }
        if (token.equals("originalstoreplace")) {
            return info.getOriginalStorePlace();
        }
        if (token.equals("note")) {
            return info.getNote();
        }
        if (token.equals("entryusername")) {
            return info.getEntryUserName();
        }
        if (token.equals("entrydatetime")) {
            return info.getContractNumber();
        }
        if (token.equals("drafterfamilyname")) {
            return info.getDrafterFamilyName();
        }
        if (token.equals("drafterfirstname")) {
            return info.getDrafterFirstName();
        }
        if (token.equals("contracttemplatename")) {
            return info.getContractTemplateName();
        }

        if (token.equals("relationobjectaname")) {
            return info.getRelationObjectAName();
        }
        if (token.equals("relationobjectbname")) {
            return info.getRelationObjectBName();
        }
        if (token.equals("relationobjectcname")) {
            return info.getRelationObjectCName();
        }
        if (token.equals("bankname")) {
            return info.getBankName();
        }
        if (token.equals("notaryfamilyname")) {
            return info.getNotaryFamilyName();
        }
        if (token.equals("notaryfirstname")) {
            return info.getNotaryFirstName();
        }
        if (token.equals("contractsummary")) {
            return info.getContractSummary();
        }
        if (token.equals("userrequirecontract")) {
            return info.getUserRequireContract();
        }

        if (token.equals("numberofpage")) {
            return info.getNumberOfPage();
        }
        if (token.equals("numbercopyofcontract")) {
            return info.getNumberCopyOfContract();
        }

        if (propertyInfo != null) {
            if (token.equals("propertytypename")) {
                String returnValue = propertyInfo.getType().toString();
                if (returnValue.equals("01")) {
                    returnValue = "Nhà đất";
                }

                if (returnValue.equals("02")) {
                    returnValue = "Ô tô";
                }

                if (returnValue.equals("03")) {
                    returnValue = "Xe máy";
                }

                if (returnValue.equals("99")) {
                    returnValue = "Tài sản khác";
                }
            }
            if (token.equals("propertycode")) {
                return propertyInfo.getCode();
            }
            if (token.equals("propertytitle")) {
                return propertyInfo.getTitle();
            }
            if (token.equals("propertyprovincename")) {
                return propertyInfo.getProvinceName();
            }

            if (token.equals("propertygivendate")) {
                if (propertyInfo.getGivenDate() != null) {
                    return RelateDateTime.toDayMonthYear(propertyInfo.getGivenDate());
                } else {
                    return null;
                }
            }
            if (token.equals("propertyownername")) {
                return propertyInfo.getOwnerName();
            }

            if (token.equals("propertyowneridCard")) {
                return propertyInfo.getOwnerIdCard();
            }
            if (token.equals("propertyowneraddress")) {
                return propertyInfo.getOwnerAddress();
            }

            // land type
            if (propertyInfo.getType().toString().equals("01")) {
                if (token.equals("propertydistrictname")) {
                    return propertyInfo.getDistrictName();
                }
                if (token.equals("propertymapnumber")) {
                    return propertyInfo.getMapNumber();
                }
                if (token.equals("propertylandnumber")) {
                    return propertyInfo.getLandNumber();
                }
                if (token.equals("propertylandaddress")) {
                    return propertyInfo.getLandAddress();
                }
            } else if (propertyInfo.getType().toString().equals("02") || propertyInfo.getType().toString().equals("03")) {
             // car type
                if (token.equals("propertyframenumber")) {
                    return propertyInfo.getFrameNumber();
                }

                if (token.equals("propertymachinenumber")) {
                    return propertyInfo.getMachineNumber();
                }
            } else {
                // other type
                if (token.equals("propertyotherinfo")) {
                    return propertyInfo.getOtherInfo();
                }
            }
        }

        return null;
        */
    }

    /**
     * @return the info
     */
    public ContractInfo getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(ContractInfo info) {
        this.info = info;
    }
}