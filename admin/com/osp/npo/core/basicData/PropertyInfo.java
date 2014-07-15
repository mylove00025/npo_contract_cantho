package com.osp.npo.core.basicData;


import com.osp.npo.core.AbstractInfo;


/**
 * Property Info Class
 * 
 * @author HaiNT
 * @version $Revision: 17049 $
 */
public class PropertyInfo extends AbstractInfo {

	/** Property code */
    private String code;

    /** Property name */
    private String name;

	/**
	 * Get code
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Set code
	 * 
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Get name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set name
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
    
}
