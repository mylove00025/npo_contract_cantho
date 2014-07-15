package com.osp.npo.core.count;


import com.osp.npo.core.AbstractInfo;


/**
 * Generate by script
 * Generate date: 1/3/2012 2:04:42 PM
 * @version $Revision$ 
 */
public class CountInfo extends AbstractInfo {

	public static final Long ID_TRANSACTION = 1L;

    /** ID */
    private Long id;

    /** Count value */
    private Long countValue;


    /**
     * <P>Generate Instance.</P>
     *
     */
    public CountInfo() {
        super();
    }


    /**
     * <P>Get ID 
 </P>
     *
     * @return ID 

     */
    public Long getId() {
        return this.id;
    }

    /**
     * <P>Set ID 
. </P>
     *
     * @param id ID 

     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * <P>Get Count value </P>
     *
     * @return Count value
     */
    public Long getCountValue() {
        return this.countValue;
    }

    /**
     * <P>Set Count value. </P>
     *
     * @param countValue Count value
     */
    public void setCountValue(Long countValue) {
        this.countValue = countValue;
    }
}
