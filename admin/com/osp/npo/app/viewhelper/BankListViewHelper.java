/**
 * 
 */
package com.osp.npo.app.viewhelper;

import com.osp.npo.app.form.BankListForm;
/**
 * @author PhuongNT
 *
 */
public class BankListViewHelper extends AbstractPageListViewHelper {

		private String bankName;
		
		public static final String SESSION_KEY = "bankListViewHelper";
		
		private String direction;
	
		private int firstIndex;
	
		 /**
	     * reset from form
	     * 
	     * @param f
	     */
	    public void reset(BankListForm f) {
	        bankName=f.getBankName();	        
	    }

		/**
		 * @return the bankName
		 */
		public String getBankName() {
			return bankName;
		}

		/**
		 * @param bankName the bankName to set
		 */
		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

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
		 * @return the firstIndex
		 */
		public int getFirstIndex() {
			
			return firstIndex;
		}

		/**
		 * @param firstIndex the firstIndex to set
		 */
		public void setFirstIndex(int firstIndex) {			
			this.firstIndex = firstIndex;
		}

		
}
