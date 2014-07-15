package com.osp.npo.core.contract;


import com.osp.npo.core.AbstractInfo;


/**
 * Generate by script
 * Generate date: 10/28/2010 12:04:18 PM
 */
public class ContractStatisticalInfo extends AbstractInfo {


    /** id công ch?ng viên */
    private Long notaryId;

    /** Trong ngày */
    private Long countInDay;

    /** Trong tu?n */
    private Long countInWeek;

    /** Trong tháng */
    private Long countInMonth;

    /** Trong nam */
    private Long countInYear;

    /** T?ng s? */
    private Long countTotal;

    /** H? ??m */
    private String familyName;

    /** Ten */
    private String firstName;

    /**
     * <P>Generate Instance.</P>
     *
     */
    public ContractStatisticalInfo() {
        super();
    }


    /**
     * <P>Get id công ch?ng viên </P>
     *
     * @return id công ch?ng viên
     */
    public Long getNotaryId() {
        return this.notaryId;
    }

    /**
     * <P>Set id công ch?ng viên. </P>
     *
     * @param notaryId id công ch?ng viên
     */
    public void setNotaryId(Long notaryId) {
        this.notaryId = notaryId;
    }

    /**
     * <P>Get Trong ngày </P>
     *
     * @return Trong ngày
     */
    public Long getCountInDay() {
        if (countInDay == null) {
            return 0l;
        }
        return this.countInDay;
    }

    /**
     * <P>Set Trong ngày. </P>
     *
     * @param countInDay Trong ngày
     */
    public void setCountInDay(Long countInDay) {
        this.countInDay = countInDay;
    }

    /**
     * <P>Get Trong tu?n </P>
     *
     * @return Trong tu?n
     */
    public Long getCountInWeek() {
        if (countInWeek == null) {
            return 0l;
        }
        return this.countInWeek;
    }

    /**
     * <P>Set Trong tu?n. </P>
     *
     * @param countInWeek Trong tu?n
     */
    public void setCountInWeek(Long countInWeek) {
        this.countInWeek = countInWeek;
    }

    /**
     * <P>Get Trong tháng </P>
     *
     * @return Trong tháng
     */
    public Long getCountInMonth() {
        if (countInMonth == null) {
            return 0l;
        }
        return this.countInMonth;
    }

    /**
     * <P>Set Trong tháng. </P>
     *
     * @param countInMonth Trong tháng
     */
    public void setCountInMonth(Long countInMonth) {
        this.countInMonth = countInMonth;
    }

    /**
     * <P>Get Trong nam </P>
     *
     * @return Trong nam
     */
    public Long getCountInYear() {
        if (countInYear == null) {
            return 0l;
        }
        return this.countInYear;
    }

    /**
     * <P>Set Trong nam. </P>
     *
     * @param countInYear Trong nam
     */
    public void setCountInYear(Long countInYear) {
        this.countInYear = countInYear;
    }

    /**
     * <P>Get T?ng s? </P>
     *
     * @return T?ng s?
     */
    public Long getCountTotal() {
        if (countTotal == null) {
            return 0l;
        }
        return this.countTotal;
    }

    /**
     * <P>Set T?ng s?. </P>
     *
     * @param countTotal T?ng s?
     */
    public void setCountTotal(Long countTotal) {
        this.countTotal = countTotal;
    }

    /**
     * @return the familyName
     */
    public String getFamilyName() {
        return familyName;
    }

    /**
     * @param familyName the familyName to set
     */
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
