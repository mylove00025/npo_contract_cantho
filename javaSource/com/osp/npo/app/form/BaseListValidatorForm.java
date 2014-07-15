package com.osp.npo.app.form;

import org.apache.struts.validator.ValidatorForm;


/**
 * 
 * <P>BaseListValidatorForm</P>
 * @version $Revision: 17056 $
 */
public class BaseListValidatorForm extends ValidatorForm {

    
    private static final long serialVersionUID = 6128877365898931420L;
    
    
    private String direction;

    
	public String getDirection() {
	
		return this.direction;
	}


	public void setDirection(String direction) {
	
		this.direction = direction;
	}

}
