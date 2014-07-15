package com.osp.npo.core.user;


import com.osp.npo.core.AbstractInfo;
import java.sql.Timestamp;


/**
 * Generate by script
 * Generate date: 10/14/2010 11:03:35 AM
 * @version $Revision: 29900 $
 */
public class UserInfo extends AbstractInfo {


    /** id ng??i dung */
    private Long id;

    /** Tai kho?n ng??i dung */
    private String account;

    /** M?t kh?u ng??i dung */
    private String password;

    /** H? ??m */
    private String familyName;

    /** Ten */
    private String firstName;

    /** Gi?i tinh ng??i dung:
 */
    private Boolean sex;

    /** Tr?ng thai ho?t ??ng c?a ng??i dung:
 */
    private Boolean activeFlg;

    /** Tr?ng thai ?n hay hi?n th? c?a ng??i dung. 
 */
    private Boolean hiddenFlg;

    /** Ch?c v? */
    private String role;
    
    /** Role name */
    private String roleName;

    /** Ngay sinh */
    private String birthday;

    /** ?i?n tho?i c? ??nh */
    private String telephone;

    /** ?i?n tho?i di ??ng */
    private String mobile;

    /** ??a ch? email */
    private String email;

    /** ??a ch? */
    private String address;

    /** th?i gian ??ng nh?p g?n nh?t */
    private Timestamp lastLoginDate;

    /** id ng??i t?o */
    private Long entryUserId;

    /** Ten ng??i t?o */
    private String entryUserName;

    /** Ngay t?o */
    private Timestamp entryDateTime;

    /** id ng??i c?p nh?t cu?i */
    private Long updateUserId;

    /** Ten ng??i c?p nh?t cu?i */
    private String updateUserName;

    /** Ngay c?p nh?t cu?i */
    private Timestamp updateDateTime;
    
    private Long count;

    
    /**
     * <P>Generate Instance.</P>
     *
     */
    public UserInfo() {
        super();
    }


    /**
     * <P>Get id ng??i dung </P>
     *
     * @return id ng??i dung
     */
    public Long getId() {
        return this.id;
    }

    /**
     * <P>Set id ng??i dung. </P>
     *
     * @param id id ng??i dung
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <P>Get Tai kho?n ng??i dung </P>
     *
     * @return Tai kho?n ng??i dung
     */
    public String getAccount() {
        return this.account;
    }

    /**
     * <P>Set Tai kho?n ng??i dung. </P>
     *
     * @param account Tai kho?n ng??i dung
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * <P>Get M?t kh?u ng??i dung </P>
     *
     * @return M?t kh?u ng??i dung
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * <P>Set M?t kh?u ng??i dung. </P>
     *
     * @param password M?t kh?u ng??i dung
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <P>Get H? ??m </P>
     *
     * @return H? ??m
     */
    public String getFamilyName() {
        return this.familyName;
    }

    /**
     * <P>Set H? ??m. </P>
     *
     * @param familyName H? ??m
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * <P>Get Ten </P>
     *
     * @return Ten
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * <P>Set Ten. </P>
     *
     * @param firstName Ten
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * <P>Get Gi?i tinh ng??i dung:
 </P>
     *
     * @return Gi?i tinh ng??i dung:

     */
    public Boolean getSex() {
        return this.sex;
    }

    /**
     * <P>Set Gi?i tinh ng??i dung:
. </P>
     *
     * @param sex Gi?i tinh ng??i dung:

     */
    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    /**
     * <P>Get Tr?ng thai ho?t ??ng c?a ng??i dung:
 </P>
     *
     * @return Tr?ng thai ho?t ??ng c?a ng??i dung:

     */
    public Boolean getActiveFlg() {
        return this.activeFlg;
    }

    /**
     * <P>Set Tr?ng thai ho?t ??ng c?a ng??i dung:
. </P>
     *
     * @param activeFlg Tr?ng thai ho?t ??ng c?a ng??i dung:

     */
    public void setActiveFlg(Boolean activeFlg) {
        this.activeFlg = activeFlg;
    }

    /**
     * <P>Get Tr?ng thai ?n hay hi?n th? c?a ng??i dung. 
 </P>
     *
     * @return Tr?ng thai ?n hay hi?n th? c?a ng??i dung. 

     */
    public Boolean getHiddenFlg() {
        return this.hiddenFlg;
    }

    /**
     * <P>Set Tr?ng thai ?n hay hi?n th? c?a ng??i dung. 
. </P>
     *
     * @param hiddenFlg Tr?ng thai ?n hay hi?n th? c?a ng??i dung. 

     */
    public void setHiddenFlg(Boolean hiddenFlg) {
        this.hiddenFlg = hiddenFlg;
    }

    /**
     * <P>Get Ch?c v? </P>
     *
     * @return Ch?c v?
     */
    public String getRole() {
        return this.role;
    }

    /**
     * <P>Set Ch?c v?. </P>
     *
     * @param role Ch?c v?
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    
    /**
     * Get the roleName
     *
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Set the roleName
     *
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    /**
     * <P>Get Ngay sinh </P>
     *
     * @return Ngay sinh
     */
    public String getBirthday() {
        return this.birthday;
    }

    /**
     * <P>Set Ngay sinh. </P>
     *
     * @param birthday Ngay sinh
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * <P>Get ?i?n tho?i c? ??nh </P>
     *
     * @return ?i?n tho?i c? ??nh
     */
    public String getTelephone() {
        return this.telephone;
    }

    /**
     * <P>Set ?i?n tho?i c? ??nh. </P>
     *
     * @param telephone ?i?n tho?i c? ??nh
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * <P>Get ?i?n tho?i di ??ng </P>
     *
     * @return ?i?n tho?i di ??ng
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     * <P>Set ?i?n tho?i di ??ng. </P>
     *
     * @param mobile ?i?n tho?i di ??ng
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * <P>Get ??a ch? email </P>
     *
     * @return ??a ch? email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * <P>Set ??a ch? email. </P>
     *
     * @param email ??a ch? email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * <P>Get ??a ch? </P>
     *
     * @return ??a ch?
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * <P>Set ??a ch?. </P>
     *
     * @param address ??a ch?
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * <P>Get th?i gian ??ng nh?p g?n nh?t </P>
     *
     * @return th?i gian ??ng nh?p g?n nh?t
     */
    public Timestamp getLastLoginDate() {
        return this.lastLoginDate;
    }

    /**
     * <P>Set th?i gian ??ng nh?p g?n nh?t. </P>
     *
     * @param lastLoginDate th?i gian ??ng nh?p g?n nh?t
     */
    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * <P>Get id ng??i t?o </P>
     *
     * @return id ng??i t?o
     */
    public Long getEntryUserId() {
        return this.entryUserId;
    }

    /**
     * <P>Set id ng??i t?o. </P>
     *
     * @param entryUserId id ng??i t?o
     */
    public void setEntryUserId(Long entryUserId) {
        this.entryUserId = entryUserId;
    }

    /**
     * <P>Get Ten ng??i t?o </P>
     *
     * @return Ten ng??i t?o
     */
    public String getEntryUserName() {
        return this.entryUserName;
    }

    /**
     * <P>Set Ten ng??i t?o. </P>
     *
     * @param entryUserName Ten ng??i t?o
     */
    public void setEntryUserName(String entryUserName) {
        this.entryUserName = entryUserName;
    }

    /**
     * <P>Get Ngay t?o </P>
     *
     * @return Ngay t?o
     */
    public Timestamp getEntryDateTime() {
        return this.entryDateTime;
    }

    /**
     * <P>Set Ngay t?o. </P>
     *
     * @param entryDateTime Ngay t?o
     */
    public void setEntryDateTime(Timestamp entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    /**
     * <P>Get id ng??i c?p nh?t cu?i </P>
     *
     * @return id ng??i c?p nh?t cu?i
     */
    public Long getUpdateUserId() {
        return this.updateUserId;
    }

    /**
     * <P>Set id ng??i c?p nh?t cu?i. </P>
     *
     * @param updateUserId id ng??i c?p nh?t cu?i
     */
    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * <P>Get Ten ng??i c?p nh?t cu?i </P>
     *
     * @return Ten ng??i c?p nh?t cu?i
     */
    public String getUpdateUserName() {
        return this.updateUserName;
    }

    /**
     * <P>Set Ten ng??i c?p nh?t cu?i. </P>
     *
     * @param updateUserName Ten ng??i c?p nh?t cu?i
     */
    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName;
    }

    /**
     * <P>Get Ngay c?p nh?t cu?i </P>
     *
     * @return Ngay c?p nh?t cu?i
     */
    public Timestamp getUpdateDateTime() {
        return this.updateDateTime;
    }

    /**
     * <P>Set Ngay c?p nh?t cu?i. </P>
     *
     * @param updateDateTime Ngay c?p nh?t cu?i
     */
    public void setUpdateDateTime(Timestamp updateDateTime) {
        this.updateDateTime = updateDateTime;
    }


    /**
     * Get the fullName
     *
     * @return the fullName
     */
    public String getFullName() {
        return this.familyName + " " + this.firstName;
    }

    /**
     * Get the fullName
     *
     * @return the fullName
     */
    public String getFullNameAndAccount() {
        return this.familyName + " " + this.firstName + " ("+this.account+")";
    }


	/**
	 * @param count the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}


	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}
}
