/**
 * 
 */
package com.osp.npo.app.form;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.osp.npo.app.message.MessageUtil;
import com.osp.npo.app.viewhelper.ContractViewHelper;
import com.osp.npo.app.viewhelper.PropertyListViewHelper;
import com.osp.npo.common.util.EditString;
import com.osp.npo.common.util.RelateDateTime;
import com.osp.npo.core.basicData.DistrictInfo;
import com.osp.npo.core.basicData.ProvinceInfo;
import com.osp.npo.core.contract.ContractPropertyInfo;
import com.osp.npo.core.contract.PropertyInfo;

/**
 * @author Admin
 *
 */
public class PropertyListForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2537088243376460147L;
    public static final String LAND_TYPE = "01";
    public static final String VEHICLE_CAR_TYPE = "02";
    public static final String VEHICLE_MOTOR_TYPE = "03";
    public static final String OTHER_TYPE = "99";
	
	private String[] chkID;
	
	private String typeProperty;
	private String codeProperty;	
	
	 //Property    
	private String propertyTitle;	
    private String propertyCodeLand;    
    private String propertyCodeVehicle;    
    private String propertyCodeOther;    
    private Long provinceLand;    
    private String provinceName;    
    private String districtName;    
    private Long provinceVehicle;    
    private Long district;    
    private String mapNumber;    
    private String landNumber;    
    private String landAddress;    
    private String frameNumber;    
    private String machineNumber;    
    private String ownerName;    
    private String ownerIdCard;    
    private String ownerAddress;    
    private String propertyOtherInfo;    
    private String givenDateVehicle;    
    private String givenDateLand;    
    private String indexSelected;   
    
    private Boolean isShowAdd = Boolean.FALSE;    
    
    private String keySearch;
    
	private List<PropertyInfo> propertyList;
	private List<PropertyInfo> propertyTypeList;
	private List<ProvinceInfo> provinceList;
	private List<DistrictInfo> districtList;
	
	 private String direction;
	 
	 
	//Many Property
    private String titlePopup;    
    private String propertyTypePopup;    
    private String propertyCodeLandPopup;    
    private String propertyCodeVehiclePopup;    
    private String propertyCodeOtherPopup;    
    private Long provinceLandPopup;    
    private String provinceLandNamePopup;    
    private Long provinceVehiclePopup;     
    private String provinceVehicleNamePopup;    
    private Long districtPopup;    
    private String mapNumberPopup;    
    private String landNumberPopup;    
    private String landAddressPopup;    
    private String frameNumberPopup;    
    private String machineNumberPopup;    
    private String ownerNamePopup;    
    private String ownerIdCardPopup;    
    private String ownerAddressPopup;    
    private String propertyOtherInfoPopup;    
    private String givenDateVehiclePopup;    
    private String givenDateLandPopup;
	 
	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	/**
	 * @return the typeProperty
	 */
	public String getTypeProperty() {
		return typeProperty;
	}
	/**
	 * @param typeProperty the typeProperty to set
	 */
	public void setTypeProperty(String typeProperty) {
		this.typeProperty = typeProperty;
	}
	/**
	 * @return the codeProperty
	 */
	public String getCodeProperty() {
		return codeProperty;
	}
	/**
	 * @param codeProperty the codeProperty to set
	 */
	public void setCodeProperty(String codeProperty) {
		this.codeProperty = codeProperty;
	}
	/**
	 * @return the propertyList
	 */
	public List<PropertyInfo> getPropertyList() {
		return propertyList;
	}
	/**
	 * @param propertyList the propertyList to set
	 */
	public void setPropertyList(List<PropertyInfo> propertyList) {
		this.propertyList = propertyList;
	}
	/**
	 * @return the provinceLand
	 */
	public Long getProvinceLand() {
		return provinceLand;
	}
	/**
	 * @param provinceLand the provinceLand to set
	 */
	public void setProvinceLand(Long provinceLand) {
		this.provinceLand = provinceLand;
	}
	/**
	 * @return the propertyTypeList
	 */
	public List<PropertyInfo> getPropertyTypeList() {
		return propertyTypeList;
	}
	/**
	 * @param propertyTypeList the propertyTypeList to set
	 */
	public void setPropertyTypeList(List<PropertyInfo> propertyTypeList) {
		this.propertyTypeList = propertyTypeList;
	}
	/**
	 * @return the provinceList
	 */
	public List<ProvinceInfo> getProvinceList() {
		return provinceList;
	}
	/**
	 * @param provinceList the provinceList to set
	 */
	public void setProvinceList(List<ProvinceInfo> provinceList) {
		this.provinceList = provinceList;
	}
	/**
	 * @return the districtList
	 */
	public List<DistrictInfo> getDistrictList() {
		return districtList;
	}
	/**
	 * @param districtList the districtList to set
	 */
	public void setDistrictList(List<DistrictInfo> districtList) {
		this.districtList = districtList;
	}
	/**
	 * @return the mapNumber
	 */
	public String getMapNumber() {
		return mapNumber;
	}
	/**
	 * @param mapNumber the mapNumber to set
	 */
	public void setMapNumber(String mapNumber) {
		this.mapNumber = mapNumber;
	}
	/**
	 * @return the landNumber
	 */
	public String getLandNumber() {
		return landNumber;
	}
	/**
	 * @param landNumber the landNumber to set
	 */
	public void setLandNumber(String landNumber) {
		this.landNumber = landNumber;
	}
	/**
	 * @return the landAddress
	 */
	public String getLandAddress() {
		return landAddress;
	}
	/**
	 * @param landAddress the landAddress to set
	 */
	public void setLandAddress(String landAddress) {
		this.landAddress = landAddress;
	}
	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}
	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	/**
	 * @return the ownerIdCard
	 */
	public String getOwnerIdCard() {
		return ownerIdCard;
	}
	/**
	 * @param ownerIdCard the ownerIdCard to set
	 */
	public void setOwnerIdCard(String ownerIdCard) {
		this.ownerIdCard = ownerIdCard;
	}
	/**
	 * @return the propertyCodeLand
	 */
	public String getPropertyCodeLand() {
		return propertyCodeLand;
	}
	/**
	 * @param propertyCodeLand the propertyCodeLand to set
	 */
	public void setPropertyCodeLand(String propertyCodeLand) {
		this.propertyCodeLand = propertyCodeLand;
	}
	
	/**
	 * @return the chkID
	 */
	public String[] getChkID() {
		return chkID;
	}
	/**
	 * @param chkID the chkID to set
	 */
	public void setChkID(String[] chkID) {
		this.chkID = chkID;
	}
	/**
	 * @return the propertyCodeOther
	 */
	public String getPropertyCodeOther() {
		return propertyCodeOther;
	}
	/**
	 * @param propertyCodeOther the propertyCodeOther to set
	 */
	public void setPropertyCodeOther(String propertyCodeOther) {
		this.propertyCodeOther = propertyCodeOther;
	}
	/**
	 * @return the propertyOtherInfo
	 */
	public String getPropertyOtherInfo() {
		return propertyOtherInfo;
	}
	/**
	 * @param propertyOtherInfo the propertyOtherInfo to set
	 */
	public void setPropertyOtherInfo(String propertyOtherInfo) {
		this.propertyOtherInfo = propertyOtherInfo;
	}
	
	/**
	 * @return the isShowAdd
	 */
	public Boolean getIsShowAdd() {
		return isShowAdd;
	}
	/**
	 * @param isShowAdd the isShowAdd to set
	 */
	public void setIsShowAdd(Boolean isShowAdd) {
		this.isShowAdd = isShowAdd;
	}
	 /**
     * Get the district
     *
     * @return the district
     */
    public Long getDistrict() {
        return district;
    }

    /**
     * Set the district
     *
     * @param district the district to set
     */
    public void setDistrict(Long district) {
        this.district = district;
    }
	/**
	 * @return the propertyCodeVehicle
	 */
	public String getPropertyCodeVehicle() {
		return propertyCodeVehicle;
	}
	/**
	 * @param propertyCodeVehicle the propertyCodeVehicle to set
	 */
	public void setPropertyCodeVehicle(String propertyCodeVehicle) {
		this.propertyCodeVehicle = propertyCodeVehicle;
	}
	/**
	 * @return the provinceName
	 */
	public String getProvinceName() {
		return provinceName;
	}
	/**
	 * @param provinceName the provinceName to set
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}
	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	/**
	 * @return the provinceVehicle
	 */
	public Long getProvinceVehicle() {
		return provinceVehicle;
	}
	/**
	 * @param provinceVehicle the provinceVehicle to set
	 */
	public void setProvinceVehicle(Long provinceVehicle) {
		this.provinceVehicle = provinceVehicle;
	}
	/**
	 * @return the frameNumber
	 */
	public String getFrameNumber() {
		return frameNumber;
	}
	/**
	 * @param frameNumber the frameNumber to set
	 */
	public void setFrameNumber(String frameNumber) {
		this.frameNumber = frameNumber;
	}
	/**
	 * @return the machineNumber
	 */
	public String getMachineNumber() {
		return machineNumber;
	}
	/**
	 * @param machineNumber the machineNumber to set
	 */
	public void setMachineNumber(String machineNumber) {
		this.machineNumber = machineNumber;
	}
	/**
	 * @return the ownerAddress
	 */
	public String getOwnerAddress() {
		return ownerAddress;
	}
	/**
	 * @param ownerAddress the ownerAddress to set
	 */
	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}
	/**
	 * @return the givenDateVehicle
	 */
	public String getGivenDateVehicle() {
		return givenDateVehicle;
	}
	/**
	 * @param givenDateVehicle the givenDateVehicle to set
	 */
	public void setGivenDateVehicle(String givenDateVehicle) {
		this.givenDateVehicle = givenDateVehicle;
	}
	/**
	 * @return the givenDateLand
	 */
	public String getGivenDateLand() {
		return givenDateLand;
	}
	/**
	 * @param givenDateLand the givenDateLand to set
	 */
	public void setGivenDateLand(String givenDateLand) {
		this.givenDateLand = givenDateLand;
	}
	/**
	 * @return the propertyTitle
	 */
	public String getPropertyTitle() {
		if(propertyTitle != null)
			return propertyTitle.trim();
		return propertyTitle;
	}
	/**
	 * @param propertyTitle the propertyTitle to set
	 */
	public void setPropertyTitle(String propertyTitle) {
		this.propertyTitle = propertyTitle;
	}
	/**
	 * @return the indexSelected
	 */
	public String getIndexSelected() {
		return indexSelected;
	}
	/**
	 * @param indexSelected the indexSelected to set
	 */
	public void setIndexSelected(String indexSelected) {
		this.indexSelected = indexSelected;
	}
	/**
	 * @return the titlePopup
	 */
	public String getTitlePopup() {
		return titlePopup;
	}
	/**
	 * @param titlePopup the titlePopup to set
	 */
	public void setTitlePopup(String titlePopup) {
		this.titlePopup = titlePopup;
	}
	/**
	 * @return the propertyTypePopup
	 */
	public String getPropertyTypePopup() {
		return propertyTypePopup;
	}
	/**
	 * @param propertyTypePopup the propertyTypePopup to set
	 */
	public void setPropertyTypePopup(String propertyTypePopup) {
		this.propertyTypePopup = propertyTypePopup;
	}
	/**
	 * @return the propertyCodeLandPopup
	 */
	public String getPropertyCodeLandPopup() {
		return propertyCodeLandPopup;
	}
	/**
	 * @param propertyCodeLandPopup the propertyCodeLandPopup to set
	 */
	public void setPropertyCodeLandPopup(String propertyCodeLandPopup) {
		this.propertyCodeLandPopup = propertyCodeLandPopup;
	}
	/**
	 * @return the propertyCodeVehiclePopup
	 */
	public String getPropertyCodeVehiclePopup() {
		return propertyCodeVehiclePopup;
	}
	/**
	 * @param propertyCodeVehiclePopup the propertyCodeVehiclePopup to set
	 */
	public void setPropertyCodeVehiclePopup(String propertyCodeVehiclePopup) {
		this.propertyCodeVehiclePopup = propertyCodeVehiclePopup;
	}
	/**
	 * @return the propertyCodeOtherPopup
	 */
	public String getPropertyCodeOtherPopup() {
		return propertyCodeOtherPopup;
	}
	/**
	 * @param propertyCodeOtherPopup the propertyCodeOtherPopup to set
	 */
	public void setPropertyCodeOtherPopup(String propertyCodeOtherPopup) {
		this.propertyCodeOtherPopup = propertyCodeOtherPopup;
	}
	/**
	 * @return the provinceLandPopup
	 */
	public Long getProvinceLandPopup() {
		return provinceLandPopup;
	}
	/**
	 * @param provinceLandPopup the provinceLandPopup to set
	 */
	public void setProvinceLandPopup(Long provinceLandPopup) {
		this.provinceLandPopup = provinceLandPopup;
	}
	/**
	 * @return the provinceLandNamePopup
	 */
	public String getProvinceLandNamePopup() {
		return provinceLandNamePopup;
	}
	/**
	 * @param provinceLandNamePopup the provinceLandNamePopup to set
	 */
	public void setProvinceLandNamePopup(String provinceLandNamePopup) {
		this.provinceLandNamePopup = provinceLandNamePopup;
	}
	/**
	 * @return the provinceVehiclePopup
	 */
	public Long getProvinceVehiclePopup() {
		return provinceVehiclePopup;
	}
	/**
	 * @param provinceVehiclePopup the provinceVehiclePopup to set
	 */
	public void setProvinceVehiclePopup(Long provinceVehiclePopup) {
		this.provinceVehiclePopup = provinceVehiclePopup;
	}
	/**
	 * @return the provinceVehicleNamePopup
	 */
	public String getProvinceVehicleNamePopup() {
		return provinceVehicleNamePopup;
	}
	/**
	 * @param provinceVehicleNamePopup the provinceVehicleNamePopup to set
	 */
	public void setProvinceVehicleNamePopup(String provinceVehicleNamePopup) {
		this.provinceVehicleNamePopup = provinceVehicleNamePopup;
	}
	/**
	 * @return the districtPopup
	 */
	public Long getDistrictPopup() {
		return districtPopup;
	}
	/**
	 * @param districtPopup the districtPopup to set
	 */
	public void setDistrictPopup(Long districtPopup) {
		this.districtPopup = districtPopup;
	}
	/**
	 * @return the mapNumberPopup
	 */
	public String getMapNumberPopup() {
		return mapNumberPopup;
	}
	/**
	 * @param mapNumberPopup the mapNumberPopup to set
	 */
	public void setMapNumberPopup(String mapNumberPopup) {
		this.mapNumberPopup = mapNumberPopup;
	}
	/**
	 * @return the landNumberPopup
	 */
	public String getLandNumberPopup() {
		return landNumberPopup;
	}
	/**
	 * @param landNumberPopup the landNumberPopup to set
	 */
	public void setLandNumberPopup(String landNumberPopup) {
		this.landNumberPopup = landNumberPopup;
	}
	/**
	 * @return the landAddressPopup
	 */
	public String getLandAddressPopup() {
		return landAddressPopup;
	}
	/**
	 * @param landAddressPopup the landAddressPopup to set
	 */
	public void setLandAddressPopup(String landAddressPopup) {
		this.landAddressPopup = landAddressPopup;
	}
	/**
	 * @return the frameNumberPopup
	 */
	public String getFrameNumberPopup() {
		return frameNumberPopup;
	}
	/**
	 * @param frameNumberPopup the frameNumberPopup to set
	 */
	public void setFrameNumberPopup(String frameNumberPopup) {
		this.frameNumberPopup = frameNumberPopup;
	}
	/**
	 * @return the machineNumberPopup
	 */
	public String getMachineNumberPopup() {
		return machineNumberPopup;
	}
	/**
	 * @param machineNumberPopup the machineNumberPopup to set
	 */
	public void setMachineNumberPopup(String machineNumberPopup) {
		this.machineNumberPopup = machineNumberPopup;
	}
	/**
	 * @return the ownerNamePopup
	 */
	public String getOwnerNamePopup() {
		return ownerNamePopup;
	}
	/**
	 * @param ownerNamePopup the ownerNamePopup to set
	 */
	public void setOwnerNamePopup(String ownerNamePopup) {
		this.ownerNamePopup = ownerNamePopup;
	}
	/**
	 * @return the ownerIdCardPopup
	 */
	public String getOwnerIdCardPopup() {
		return ownerIdCardPopup;
	}
	/**
	 * @param ownerIdCardPopup the ownerIdCardPopup to set
	 */
	public void setOwnerIdCardPopup(String ownerIdCardPopup) {
		this.ownerIdCardPopup = ownerIdCardPopup;
	}
	/**
	 * @return the ownerAddressPopup
	 */
	public String getOwnerAddressPopup() {
		return ownerAddressPopup;
	}
	/**
	 * @param ownerAddressPopup the ownerAddressPopup to set
	 */
	public void setOwnerAddressPopup(String ownerAddressPopup) {
		this.ownerAddressPopup = ownerAddressPopup;
	}
	/**
	 * @return the propertyOtherInfoPopup
	 */
	public String getPropertyOtherInfoPopup() {
		return propertyOtherInfoPopup;
	}
	/**
	 * @param propertyOtherInfoPopup the propertyOtherInfoPopup to set
	 */
	public void setPropertyOtherInfoPopup(String propertyOtherInfoPopup) {
		this.propertyOtherInfoPopup = propertyOtherInfoPopup;
	}
	/**
	 * @return the givenDateVehiclePopup
	 */
	public String getGivenDateVehiclePopup() {
		return givenDateVehiclePopup;
	}
	/**
	 * @param givenDateVehiclePopup the givenDateVehiclePopup to set
	 */
	public void setGivenDateVehiclePopup(String givenDateVehiclePopup) {
		this.givenDateVehiclePopup = givenDateVehiclePopup;
	}
	/**
	 * @return the givenDateLandPopup
	 */
	public String getGivenDateLandPopup() {
		return givenDateLandPopup;
	}
	/**
	 * @param givenDateLandPopup the givenDateLandPopup to set
	 */
	public void setGivenDateLandPopup(String givenDateLandPopup) {
		this.givenDateLandPopup = givenDateLandPopup;
	}
	
	   /*
     * (non-Javadoc)
     * 
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping,
     *      javax.servlet.http.HttpServletRequest)
     */
    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {        
    
        PropertyListViewHelper proViewHelper = (PropertyListViewHelper)request.getSession().getAttribute(PropertyListViewHelper.SESSION_KEY);
        if (proViewHelper == null) {
            return new ActionErrors();
        }
        
        ActionErrors errors = new ActionErrors();
        MessageUtil messageUtil = new MessageUtil();
        
        if (getTypeProperty().equalsIgnoreCase("00")) {
        	 errors.add(messageUtil.createActionMessages("typeProperty", request,"err_not_input_data", "item_property_type"));
        }
        
        if (EditString.isNull(getPropertyTitle())) {
            errors.add(messageUtil.createActionMessages("propertyTitle", request, "err_not_input_data", "item_property_title"));
        } else if (getPropertyTitle().length() > 250) {
            errors.add(messageUtil.createActionMessages("propertyTitle", request, "err_max_length", "item_property_prevent_title", "250"));
        }
        
     // validate by type
        String type = this.getTypeProperty();
        if (OTHER_TYPE.equals(type) || LAND_TYPE.equals(type) || VEHICLE_MOTOR_TYPE.equals(type) || VEHICLE_CAR_TYPE.equals(type)) {
            if (LAND_TYPE.equals(type)) {
                if (getPropertyCodeLand().length() > 50) {
                    errors.add(messageUtil.createActionMessages("propertyCodeLand", request, "err_max_length", "item_land_code", "50"));
                }
                
                if (getMapNumber().length() > 20) {
                    errors.add(messageUtil.createActionMessages("mapNumber", request, "err_max_length", "item_map_number", "20"));
                }
                if (getLandNumber().length() > 20) {
                    errors.add(messageUtil.createActionMessages("landNumber", request, "err_max_length", "item_land_number", "20"));
                }
                if (getLandAddress().length() > 200) {
                    errors.add(messageUtil.createActionMessages("landAddress", request, "err_max_length", "item_land_address", "200"));
                }
                if (!EditString.isNull(getGivenDateLand())) {
                    Timestamp givenDate = RelateDateTime.toTimestamp(false, getGivenDateLand());
                    if (givenDate == null) {
                        errors.add(messageUtil.createActionMessages("givenDateLand", request, "err_not_regular", "item_given_date"));
                    }
                }
            } else if (VEHICLE_CAR_TYPE.equals(type) || VEHICLE_MOTOR_TYPE.equals(type)) {
//                if (getPropertyCodeVehicle().trim().length() == 0) {
//                    errors.add(messageUtil.createActionMessages("propertyCodeVehicle", request, "err_not_input_data", "item_vehicle_code"));
//                }
                if (getPropertyCodeVehicle().length() > 50) {
                    errors.add(messageUtil.createActionMessages("propertyCodeVehicle", request, "err_max_length", "item_vehicle_code", "50"));
                }
//                if (getProvinceVehicle() == 0) {
//                    errors.add(messageUtil.createActionMessages("provinceVehicle", request, "err_not_input_data", "item_issue_place"));
//                }
                if (getFrameNumber().length() > 20) {
                    errors.add(messageUtil.createActionMessages("frameNumber", request, "err_max_length", "item_frame_number", "20"));
                }
                if (getMachineNumber().length() > 20) {
                    errors.add(messageUtil.createActionMessages("machineNumber", request, "err_max_length", "item_machine_number", "20"));
                }
                if (!EditString.isNull(getGivenDateVehicle())) {
                    Timestamp givenDate = RelateDateTime.toTimestamp(false, getGivenDateVehicle());
                    if (givenDate == null) {
                        errors.add(messageUtil.createActionMessages("givenDateVehicle", request, "err_not_regular", "item_given_date"));
                    }
                }
            } else if (OTHER_TYPE.equals(type)) {
//                if (getPropertyCodeOther().trim().length() == 0) {
//                    errors.add(messageUtil.createActionMessages("propertyCodeOther", request, "err_not_input_data", "item_other_code"));
//                }
                if (getPropertyCodeOther().length() > 50) {
                    errors.add(messageUtil.createActionMessages("propertyCodeOther", request, "err_max_length", "item_other_code", "50"));
                }
                if (getPropertyOtherInfo().length() > 200) {
                    errors.add(messageUtil.createActionMessages("propertyOtherInfo", request, "err_max_length", "item_other_info", "200"));
                }
            }

            // validate common property
            if (getOwnerIdCard().length() > 20) {
                errors.add(messageUtil.createActionMessages("ownerIdCard", request, "err_max_length", "item_owner_idCard", "20"));
            }

            if (getOwnerName().length() > 100) {
                errors.add(messageUtil.createActionMessages("ownerName", request, "err_max_length", "item_owner_name", "100"));
            }

            if (getOwnerAddress().length() > 200) {
                errors.add(messageUtil.createActionMessages("ownerAddress", request, "err_max_length", "item_owner_address", "200"));
            }           

        } else {
            errors.add(messageUtil.createActionMessages("typeProperty", request, "err_not_input_data", "item_property_type"));
        }
        
        if (errors.size() > 0) {
        	setIsShowAdd(true);
        	proViewHelper.reset(this);        	
        } else {
        	proViewHelper.reset(this);   
        }
        
        return errors;
    }
	/**
	 * @return the keySearch
	 */
	public String getKeySearch() {
		if (keySearch != null ) {
			return keySearch.trim();
		}
		return keySearch;
	}
	/**
	 * @param keySearch the keySearch to set
	 */
	public void setKeySearch(String keySearch) {
		this.keySearch = keySearch;
	}

}
