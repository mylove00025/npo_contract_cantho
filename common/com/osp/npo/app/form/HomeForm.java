package com.osp.npo.app.form;

import org.apache.struts.action.ActionForm;

public class HomeForm extends ActionForm {

    private static final long serialVersionUID = 3625146202956255247L;
    
    private int contractKindId;

	/**
	 * @return the contractKindId
	 */
	public int getContractKindId() {
		return contractKindId;
	}

	/**
	 * @param contractKindId the contractKindId to set
	 */
	public void setContractKindId(int contractKindId) {
		this.contractKindId = contractKindId;
	}
    
}
