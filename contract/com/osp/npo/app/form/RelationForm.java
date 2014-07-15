package com.osp.npo.app.form;

import org.apache.struts.action.ActionForm;

public class RelationForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1227562500790695343L;
	private String direction;
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}
}
