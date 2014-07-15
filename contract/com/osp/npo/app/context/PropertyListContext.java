/**
 * 
 */
package com.osp.npo.app.context;

import java.util.List;

import com.osp.npo.core.contract.ContractPropertyInfo;
import com.osp.npo.core.contract.PropertyInfo;

/**
 * @author Admin
 *
 */
public class PropertyListContext {
		public static final String SESSION_KEY = "propertyListContext";
		
		private List<Long> chkID;
		private String typeProperty;
		private String codeProperty;	
		private String titleProperty;
		 private String keySearch;
		private List<PropertyInfo> propertyList;
		/**
		 * @param propertyList the propertyList to set
		 */
		public void setPropertyList(List<PropertyInfo> propertyList) {
			this.propertyList = propertyList;
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
	
		
		public void reset() {
			// TODO Auto-generated method stub
			this.typeProperty = "00";
			this.codeProperty ="";
			//this.propertyList =null;
			this.titleProperty ="";
		}
		/**
		 * @return the chkID
		 */
		public List<Long> getChkID() {
			return chkID;
		}
		/**
		 * @param chkID the chkID to set
		 */
		public void setChkID(List<Long> chkID) {
			this.chkID = chkID;
		}
		/**
		 * @return the titleProperty
		 */
		public String getTitleProperty() {
			return titleProperty;
		}
		/**
		 * @param titleProperty the titleProperty to set
		 */
		public void setTitleProperty(String titleProperty) {
			this.titleProperty = titleProperty;
		}
		/**
		 * @return the keySearch
		 */
		public String getKeySearch() {
			return keySearch;
		}
		/**
		 * @param keySearch the keySearch to set
		 */
		public void setKeySearch(String keySearch) {
			this.keySearch = keySearch;
		}
		
}
