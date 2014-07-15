package com.osp.npo.app.context;

import java.util.ArrayList;

import com.osp.npo.app.plugin.InitSystemPlugin;
import com.osp.npo.common.demo.NpoDemo;
import com.osp.npo.common.global.Constants;
import com.osp.npo.core.common.SystemConfigInfo;
import com.osp.npo.core.common.SystemConfigList;
import com.osp.npo.core.user.UserAuthorityInfo;
import com.osp.npo.core.user.UserInfo;

/**
 * CommonContext class
 *
 * @author HaiNT
 * @version $Revision: 29722 $
 */
public class CommonContext {

    public static final String SESSION_KEY = "CommonContext";

    private UserInfo userInfo = null;
    private ArrayList<UserAuthorityInfo> authorityList = null;
    private String screenTitle;
    private String subMenu;
    private String screenId;
    private SystemConfigList systemConfigList;
    private String clientInfo;

    public CommonContext() {
        authorityList = new ArrayList<UserAuthorityInfo>();
    }

    /**
     * @return the userInfo
     */
    public UserInfo getUserInfo() {
        return userInfo;
    }

    /**
     * @param userInfo
     *            the userInfo to set
     */
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * @return the authorityList
     */
    public ArrayList<UserAuthorityInfo> getAuthorityList() {
        return authorityList;
    }

    /**
     * @param authorityList the authorityList to set
     */
    public void setAuthorityList(ArrayList<UserAuthorityInfo> authorityList) {
        this.authorityList = authorityList;
    }

    /**
     * @param functionType
     * @return boolean, true if the user has function type
     */
    private boolean isHasFunctionType(String functionType) {
        boolean isHas = false;
        for (UserAuthorityInfo info : authorityList) {
            // check function type
            if (functionType.equals(info.getAuthorityCode())) {
                isHas = true;
                break;
            }
        }
        return isHas;
    }

    /**
     * @return true, current user has authority as Management
     */
    public boolean isAdmin() {
        return isHasFunctionType(Constants.AUTHORITY_ADMIN);
    }

    /**
     * @return true, current user has authority as
     */
    public boolean isContractManagement() {
        return isHasFunctionType(Constants.AUTHORITY_CONTRACT);
    }
    
    /**
     * @return true, current user has authority as
     */
    public boolean isTemporaryContractManagement() {
        return isHasFunctionType(Constants.AUTHORITY_TEMP_CONTRACT);
    }
    
    /**
     * @return true, current user has authority as
     */
    public boolean isContractDelete() {
        return isHasFunctionType(Constants.AUTHORITY_CNTR_DEL);
    }
    
    /**
     * @return true, current user has authority as
     */
    public boolean isTemporaryContractDelete() {
        return isHasFunctionType(Constants.AUTHORITY_TEMP_CNTR_DEL);
    }

    /**
     * @return true, current user has bank report authority
     */
    public boolean isBankReport() {
        return isHasFunctionType(Constants.AUTHORITY_BANK_REPORT);
    }

    /**
     * @return true, current user has bank report authority
     */
    public boolean isAnnouncementManagement() {
        return isHasFunctionType(Constants.AUTHORITY_ANNOUNCEMENT);
    }

    /**
     * Check prevent data authority
     *
     * @return true, current user has prevent data authority
     */
    public boolean isPreventData() {
        return isHasFunctionType(Constants.AUTHORITY_PREVENT_DATA);
    }
    
    /**
     * Check can delete prevent data authority
     *
     * @return true, current user has prevent data authority
     */
    public boolean isPreventDataDelete() {
        return isHasFunctionType(Constants.AUTHORITY_PRV_DEL);
    }
    
    /**
     * Check can view contract report authority
     *
     * @return true, current user has prevent data authority
     */
    public boolean isViewContractReport() {
        return isHasFunctionType(Constants.AUTHORITY_VIEW_REPORT);
    }

    /**
     * @return System Office Name
     */
    public String getSystemOfficeName() {
        //return SystemProperties.getProperty("system_ofice_name");
        return getSystemConfigValue("notary_office_name");
    }
    
    /**
     * @return System Office Address
     */
    public String getSystemOfficeAddress() {
        //return SystemProperties.getProperty("system_ofice_name");
        return getSystemConfigValue("notary_office_address");
    }

    public void setSystemOfficeName(String officeName) {
        for (int i= 0; i < this.systemConfigList.size(); i++) {
            SystemConfigInfo scInfo = this.systemConfigList.get(i);
            if ("notary_office_name".equals(scInfo.getConfigKey())) {
                scInfo.setConfigValue(officeName);
                return;
            }
        }
    }

    /**
     * @return System Office Authority ID
     */
    public String getSystemOfficeAuthorityID() {
        return InitSystemPlugin.getAuthenticationId();
    }

    /**
     * @return System Office Authority Code
     */
    public String getSystemOfficeAuthorityCode() {
        return InitSystemPlugin.getAuthenticationCode();
    }


    /**
     * @return Supplement Contract Function
     */
    public String getSupplementContractFunction() {
        return getSystemConfigValue("supplement_contract_function");
    }

    /**
     * @return Property Land Certificate
     */
    public String getPropertyLandCertificate() {
        return getSystemConfigValue("npo_property_land_certificate");
    }

    /**
     * @return Property Land Issue Place
     */
    public String getPropertyLandIssuePlace() {
        return getSystemConfigValue("npo_property_land_issue_place");
    }

    /**
     * @return Property Land Issue Date
     */
    public String getPropertyLandIssueDate() {
        return getSystemConfigValue("npo_property_land_issue_date");
    }

    /**
     * @return Property Land Map Number
     */
    public String getPropertyLandMapNumber() {
        return getSystemConfigValue("npo_property_land_map_number");
    }

    /**
     * @return Property Land Number
     */
    public String getPropertyLandNumber() {
        return getSystemConfigValue("npo_property_land_number");
    }

    /**
     * @return Property Land Address
     */
    public String getPropertyLandAddress() {
        return getSystemConfigValue("npo_property_land_address");
    }

    /**
     * @return Property Land Area
     */
    public String getPropertyLandArea() {
        return getSystemConfigValue("npo_property_land_area");
    }

    /**
     * @return Property Land Public Area
     */
    public String getPropertyLandPublicArea() {
        return getSystemConfigValue("npo_property_land_public_area");
    }

    /**
     * @return Property Land Private Area
     */
    public String getPropertyLandPrivateArea() {
        return getSystemConfigValue("npo_property_land_private_area");
    }

    /**
     * @return Property Land Use Purpose
     */
    public String getPropertyLandUsePurpose() {
        return getSystemConfigValue("npo_property_land_use_purpose");
    }

    /**
     * @return Property Land Use Period
     */
    public String getPropertyLandUsePeriod() {
        return getSystemConfigValue("npo_property_land_use_period");
    }

    /**
     * @return Property Land Use Origin
     */
    public String getPropertyLandUseOrigin() {
        return getSystemConfigValue("npo_property_land_use_origin");
    }

    /**
     * @return Property Land District
     */
    public String getPropertyLandDistrict() {
        return getSystemConfigValue("npo_property_land_district");
    }

    /**
     * @return Property Land Province
     */
    public String getPropertyLandProvince() {
        return getSystemConfigValue("npo_property_land_province");
    }

    /**
     * @return Property Land Associate Property
     */
    public String getPropertyLandAssociateProperty() {
        return getSystemConfigValue("npo_property_land_associate_property");
    }

    /**
     * @return Property Car License Number
     */
    public String getPropertyCarLicenseNumber() {
        return getSystemConfigValue("npo_property_car_license_number");
    }

    /**
     * @return Property Car Regist Number
     */
    public String getPropertyCarRegistNumber() {
        return getSystemConfigValue("npo_property_car_regist_number");
    }

    /**
     * @return Property Car Issue Place
     */
    public String getPropertyCarIssuePlace() {
        return getSystemConfigValue("npo_property_car_issue_place");
    }

    /**
     * @return Property Car IssueDate
     */
    public String getPropertyCarIssueDate() {
        return getSystemConfigValue("npo_property_car_issue_date");
    }

    /**
     * @return Property Car Frame Number
     */
    public String getPropertyCarFrameNumber() {
        return getSystemConfigValue("npo_property_car_frame_number");
    }

    /**
     * @return Property Car Machine Number
     */
    public String getPropertyCarMachineNumber() {
        return getSystemConfigValue("npo_property_car_machine_number");
    }

    /**
     * @return Property Prevent Land Address
     */
    public String getPropertyPreventLandAddress() {
        return getSystemConfigValue("npo_property_prevent_land_address");
    }

    /**
     * @return Property Prevent Land Certificate
     */
    public String getPropertyPreventLandCertificate() {
        return getSystemConfigValue("npo_property_prevent_land_certificate");
    }

    /**
     * @return Property Prevent Land Issue Place
     */
    public String getPropertyPreventLandIssuePlace() {
        return getSystemConfigValue("npo_property_prevent_land_issue_place");
    }

    /**
     * @return Property Prevent Land Issue Date
     */
    public String getPropertyPreventLandIssueDate() {
        return getSystemConfigValue("npo_property_prevent_land_issue_date");
    }

    /**
     * @return Property Prevent Land Number
     */
    public String getPropertyPreventLandNumber() {
        return getSystemConfigValue("npo_property_prevent_land_number");
    }

    /**
     * @return Property Prevent Land Map Number
     */
    public String getPropertyPreventLandMapNumber() {
        return getSystemConfigValue("npo_property_prevent_land_map_number");
    }

    /**
     * @return Property Prevent Land Area
     */
    public String getPropertyPreventLandArea() {
        return getSystemConfigValue("npo_property_prevent_land_area");
    }

    /**
     * @return Property Prevent Land Private Area
     */
    public String getPropertyPreventLandPrivateArea() {
        return getSystemConfigValue("npo_property_prevent_land_private_area");
    }

    /**
     * @return Property Prevent Land Public Area
     */
    public String getPropertyPreventLandPublicArea() {
        return getSystemConfigValue("npo_property_prevent_land_public_area");
    }

    /**
     * @return Property Prevent Land Use Purpose
     */
    public String getPropertyPreventLandUsePurpose() {
        return getSystemConfigValue("npo_property_prevent_land_use_purpose");
    }

    /**
     * @return Property Prevent Land Use Period
     */
    public String getPropertyPreventLandUsePeriod() {
        return getSystemConfigValue("npo_property_prevent_land_use_period");
    }

    /**
     * @return Property Prevent Land Use Origin
     */
    public String getPropertyPreventLandUseOrigin() {
        return getSystemConfigValue("npo_property_prevent_land_use_origin");
    }

    /**
     * @return Property Prevent Land Associate Property
     */
    public String getPropertyPreventLandAssociateProperty() {
        return getSystemConfigValue("npo_property_prevent_land_associate_property");
    }

    /**
     * @return Property Prevent Land District
     */
    public String getPropertyPreventLandDistrict() {
        return getSystemConfigValue("npo_property_prevent_land_district");
    }

    /**
     * @return Property Prevent Land Province
     */
    public String getPropertyPreventLandProvince() {
        return getSystemConfigValue("npo_property_prevent_land_province");
    }

    /**
     * @return Property Prevent Car License Number
     */
    public String getPropertyPreventCarLicenseNumber() {
        return getSystemConfigValue("npo_property_prevent_car_license_number");
    }

    /**
     * @return Property Prevent Car Regist Number
     */
    public String getPropertyPreventCarRegistNumber() {
        return getSystemConfigValue("npo_property_prevent_car_regist_number");
    }

    /**
     * @return Property Prevent Car Issue Place
     */
    public String getPropertyPreventCarIssuePlace() {
        return getSystemConfigValue("npo_property_prevent_car_issue_place");
    }

    /**
     * @return Property Prevent Car IssueDate
     */
    public String getPropertyPreventCarIssueDate() {
        return getSystemConfigValue("npo_property_prevent_car_issue_date");
    }

    /**
     * @return Property Prevent Car Frame Number
     */
    public String getPropertyPreventCarFrameNumber() {
        return getSystemConfigValue("npo_property_prevent_car_frame_number");
    }

    /**
     * @return Property Prevent Car Machine Number
     */
    public String getPropertyPreventCarMachineNumber() {
        return getSystemConfigValue("npo_property_prevent_car_machine_number");
    }
    
    /**
     * @return Contract Receive Date
     */
    public String getContractReceiveDate() {
        return getSystemConfigValue("npo_contract_receive_date");
    }
    
    /**
     * @return Contract Drafter
     */
    public String getContractDrafter() {
        return getSystemConfigValue("npo_contract_drafter");
    }
    
    /**
     * @return Contract Value
     */
    public String getContractValue() {
        return getSystemConfigValue("npo_contract_value");
    }
    
    /**
     * @return Contract Notary Place
     */
    public String getContractNotaryPlace() {
        return getSystemConfigValue("npo_contract_notary_place");
    }
    
    /**
     * @return Contract User Require
     */
    public String getContractUserRequire() {
        return getSystemConfigValue("npo_contract_user_require");
    }
    
    /**
     * @return Contract OwnerInfo
     */
    public String getPropertyOwnerInfo() {
        return getSystemConfigValue("npo_property_owner_info");
    }
    
    /**
     * @return Contract Error Status
     */
    public String getContractErrorStatus() {
        return getSystemConfigValue("npo_contract_error_status");
    }
    
    /**
     * @return Synchronize Account
     */
    public String getSynchronizeAccount() {
        return getSystemConfigValue("synchronize_account");
    }
    
    /**
     * @return Synchronize Account
     */
    public String getSynchronizePassword() {
        return getSystemConfigValue("synchronize_password");
    }
    
    /**
     * @return Supplement Contract Function
     */
    public String getDepartmentLink() {
        return getSystemConfigValue("npo_department_link");
    }
    
    /**
     * @return Synchronize type
     */
    public String getSynchronizeType() {
        return getSystemConfigValue("synchronize_type");
    }
    
    /**
     * Get screen title
     *
     * @return the screenTitle
     */
    public String getScreenTitle() {
        return screenTitle;
    }

    /**
     * Set screen title
     *
     * @param screenTitle the screenTitle to set
     */
    public void setScreenTitle(String screenTitle) {
        this.screenTitle = screenTitle;
    }

    /**
     * Get System config list
     *
     * @return the systemConfigList
     */
    public SystemConfigList getSystemConfigList() {
        return systemConfigList;
    }

    /**
     * Set Get System config list
     *
     * @param systemConfigList the systemConfigList to set
     */
    public void setSystemConfigList(SystemConfigList systemConfigList) {
        this.systemConfigList = systemConfigList;
    }

    /**
     * Get the screenId
     *
     * @return the screenId
     */
    public String getScreenId() {
        return screenId;
    }

    /**
     * Set the screenId
     *
     * @param screenId the screenId to set
     */
    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    /**
     * Get the subMenu
     *
     * @return the subMenu
     */
    public String getSubMenu() {
        return subMenu;
    }

    /**
     * Set the subMenu
     *
     * @param subMenu the subMenu to set
     */
    public void setSubMenu(String subMenu) {
        this.subMenu = subMenu;
    }


    /**
     * Get system config value by key
     *
     * @param key Input key
     * @return system config value
     */
    public String getSystemConfigValue(String key) {
        if (this.systemConfigList == null) {
            return null;
        }

        for (int i= 0; i < this.systemConfigList.size(); i++) {
            SystemConfigInfo scInfo = this.systemConfigList.get(i);
            if (key.equals(scInfo.getConfigKey())) {
                return scInfo.getConfigValue();
            }
        }

        return null;
    }

    /**
     * Get the isDemo
     *
     * @return the isDemo
     */
    public boolean isDemoSystem() {
        return NpoDemo.IS_DEMO;
    }

	/**
	 * Get clientInfo
	 * @return the clientInfo
	 */
	public String getClientInfo() {
		return clientInfo;
	}

	/**
	 * Set clientInfo
	 * @param clientInfo the clientInfo to set
	 */
	public void setClientInfo(String clientInfo) {
		this.clientInfo = clientInfo;
	}
    
}
