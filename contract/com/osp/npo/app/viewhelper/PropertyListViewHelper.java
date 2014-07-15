/**
 * 
 */
package com.osp.npo.app.viewhelper;

import java.util.List;

import com.osp.npo.app.form.PropertyListForm;
import com.osp.npo.core.basicData.DistrictInfo;
import com.osp.npo.core.basicData.ProvinceInfo;
import com.osp.npo.core.contract.PropertyInfo;

/**
 * @author PhuongNT
 *
 */
public class PropertyListViewHelper extends AbstractPageListViewHelper {
	
	public static final String SESSION_KEY = "propertyListViewHelper";
	
	private String indexSelected;
	private Boolean isRegist = Boolean.TRUE;
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
    
    private Boolean isShowAdd = Boolean.FALSE;
    
    private String keySearch;
	
	private List<PropertyInfo> propertyList;
	
	private List<PropertyInfo> propertyTypeList;
	private List<ProvinceInfo> provinceList;
	private List<DistrictInfo> districtList;
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
		if(codeProperty != null)
			return codeProperty.trim();
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
	
	 public void reset(PropertyListForm f) {
		typeProperty = f.getTypeProperty();
		propertyTitle = f.getPropertyTitle();
		codeProperty=f.getCodeProperty();
		typeProperty=f.getTypeProperty();
		propertyCodeLand = f.getPropertyCodeLand();
		propertyCodeVehicle = f.getPropertyCodeVehicle();
		propertyCodeOther = f.getPropertyCodeOther();
		provinceLand = f.getProvinceLand();
		provinceName = f.getProvinceName();
		districtName = f.getDistrictName();
		provinceVehicle = f.getProvinceVehicle();
		district = f.getDistrict();
		mapNumber = f.getMapNumber();
		landNumber = f.getLandNumber();
		landAddress = f.getLandAddress();
		frameNumber = f.getFrameNumber();
		machineNumber = f.getMachineNumber();
		ownerName = f.getOwnerName();
		ownerIdCard = f.getOwnerIdCard();
		ownerAddress = f.getOwnerAddress();
		propertyOtherInfo = f.getPropertyOtherInfo();
		givenDateLand = f.getGivenDateLand();
		givenDateVehicle = f.getGivenDateVehicle();
		isShowAdd = f.getIsShowAdd();
		keySearch = f.getKeySearch();
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
	 * @return the district
	 */
	public Long getDistrict() {
		return district;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(Long district) {
		this.district = district;
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
		if(propertyTitle !=null)
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
	 * @return the isRegist
	 */
	public Boolean getIsRegist() {
		return isRegist;
	}
	/**
	 * @param isRegist the isRegist to set
	 */
	public void setIsRegist(Boolean isRegist) {
		this.isRegist = isRegist;
	}
	/**
	 * @return the keySearch
	 */
	public String getKeySearch() {
		if (keySearch != null )
			return this.keySearch.trim();
		return keySearch;
	}
	/**
	 * @param keySearch the keySearch to set
	 */
	public void setKeySearch(String keySearch) {
		this.keySearch = keySearch;
	}
	
}
