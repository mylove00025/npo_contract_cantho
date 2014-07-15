<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<table id="contactArea" class="tbl-none-border table-inherit">
	<tr>
	    <td colspan="2"><strong>Thông tin tài sản</strong></td>
	</tr>
	
	<tr>
	    <th nowrap="nowrap">Tài sản<span class="required">*</span></th>
	    <td nowrap="nowrap">
	        
	        <html:select name="contractViewHelper" property="propertyTypePopup" styleId="propertyTypePopup"
	            onchange="javascript:changePropertyPopup(this.value);">
	            <html:optionsCollection name="contractViewHelper" property="propertyTypeList" label="name" value="code" />
	        </html:select>
	    </td>
	</tr>
	
	<tr>
	    <th nowrap="nowrap">Tiêu đề<span class="required">*</span></th>
	    <td>
	        <html:text styleId="titlePopup" property="titlePopup" name="contractViewHelper" styleClass="input-long" maxlength="250"/>
	    </td>
    </tr>
	
	<!-- vehicles property -->
	<tr class="vehicles-many">
	    <th nowrap="nowrap">Biển kiểm soát</th>
	    <td nowrap="nowrap">
	        <html:text styleId="propertyCodeVehiclePopup" name="contractViewHelper"
	               property="propertyCodeVehiclePopup" styleClass="input-normal" maxlength="50"/>
	    </td>
	</tr>
	<tr class="vehicles-many" >
	    <th nowrap="nowrap">Nơi cấp</th>
	    <td nowrap="nowrap">
	        <span>
	            <html:select styleId="provinceVehiclePopup" name="contractViewHelper" property="provinceVehiclePopup" >
	                <html:option value="0">[Chọn]</html:option>
	                <html:optionsCollection name="contractViewHelper" property="provinceList" label="name" value="id" />
	            </html:select>
	        </span>
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <span id="givenDateVehicle_td">
	            Ngày cấp
	            <html:text name="contractViewHelper" property="givenDateVehiclePopup"
	                styleId="givenDateVehiclePopup" style="vertical-align: middle;" maxlength="10"></html:text>
	            <html:img styleId="popupCal-5" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
	                style="vertical-align: middle;"/>
	        </span>
	        <script type="text/javascript">
	              new Calendar({
	                  inputField: "givenDateVehiclePopup",
	                  dateFormat: "%d/%m/%Y",
	                  trigger: "popupCal-5",
	                  bottomBar: false,
	                  onSelect: function() {
	                          var date = Calendar.intToDate(this.selection.get());
	                          LEFT_CAL.args.min = date;
	                          LEFT_CAL.redraw();
	                          this.hide();
	                  }
	              });
	        </script>
	
	    </td>
	</tr>
	<tr class="vehicles-many">
	    <th nowrap="nowrap">Số khung</th>
	    <td nowrap="nowrap">
	        <html:text styleId="frameNumberPopup" name="contractViewHelper" property="frameNumberPopup"
	                       styleClass="input-normal" maxlength="20"></html:text>
	    </td>
	</tr>
	<tr class="vehicles-many">
	    <th nowrap="nowrap">Số máy</th>
	    <td nowrap="nowrap">
	        <html:text styleId="machineNumberPopup" name="contractViewHelper" property="machineNumberPopup"
	                       styleClass="input-normal" maxlength="20"></html:text>
	    </td>
	</tr>
	
	<!-- land property -->
	<tr class="land-many">
	    <th nowrap="nowrap">Tỉnh/thành</th>
	    <td nowrap="nowrap">
	        <html:select name="contractViewHelper" property="provinceLandPopup" styleId="provinceLandPopup"
	        onchange="retrieveURL5('ajaxGetDistrict.do?provinceId=' + this.value + '&fieldId=districtPopup&fieldName=districtPopup&hasOptionSelect=true')">
	            <html:option value="0">[Chọn]</html:option>
	            <html:optionsCollection property="provinceList" name="contractViewHelper" label="name" value="id" />
	        </html:select>
	    </td>
	</tr>
	<tr class="land-many">
	    <th nowrap="nowrap">Quận/huyện</th>
	    <td nowrap="nowrap">
	       <span class="districtSpanPopup">
	           <html:select name="contractViewHelper" property="districtPopup" styleId="districtPopup">
	                <html:option value="0">[Chọn]</html:option>
	                <html:optionsCollection property="districtList" name="contractViewHelper" label="name" value="id" />
	            </html:select>
	       </span>
	    </td>
	</tr>
	<tr class="land-many" >
	    <th nowrap="nowrap">Số giấy chứng nhận</th>
	    <td nowrap="nowrap">
	        <span>
	            <html:text styleId="propertyCodeLandPopup" name="contractViewHelper" property="propertyCodeLandPopup"
	                           styleClass="input-normal" maxlength="50"></html:text>
	        </span>
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <span id="givenDateLand_td">
	        Ngày cấp
	            <html:text name="contractViewHelper" property="givenDateLandPopup" style="vertical-align: middle;"
	                           styleId="givenDateLandPopup" maxlength="10">
	            </html:text>
	        </span>
	        <html:img styleId="popupCal-6" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
	            style="vertical-align: middle;"/>
	        <script type="text/javascript">
	              new Calendar({
	                  inputField: "givenDateLandPopup",
	                  dateFormat: "%d/%m/%Y",
	                  trigger: "popupCal-6",
	                  bottomBar: false,
	                  onSelect: function() {
	                          var date = Calendar.intToDate(this.selection.get());
	                          LEFT_CAL.args.min = date;
	                          LEFT_CAL.redraw();
	                          this.hide();
	                  }
	              });
	        </script>
	    </td>
	</tr>
	<tr class="land-many">
	    <th nowrap="nowrap">Số tờ bản đồ</th>
	    <td nowrap="nowrap">
	        <html:text styleId="mapNumberPopup" name="contractViewHelper" property="mapNumberPopup"
	                      maxlength="20" styleClass="input-normal" ></html:text>
	    </td>
	</tr>
	<tr class="land-many">
	    <th nowrap="nowrap">Số thửa đất</th>
	    <td nowrap="nowrap">
	        <html:text styleId="landNumberPopup" name="contractViewHelper" property="landNumberPopup"
	                      maxlength="20" styleClass="input-normal"></html:text>
	    </td>
	</tr>
	<tr class="land-many">
	    <th nowrap="nowrap">Địa chỉ nhà đất</th>
	    <td nowrap="nowrap">
	        <html:text styleId="landAddressPopup" name="contractViewHelper" property="landAddressPopup"
	                      styleClass="input-x-long" maxlength="200"></html:text>
	    </td>
	</tr>
	
	<!-- other property -->
	<tr class="other-many">
	    <th nowrap="nowrap">Mã số tài sản</th>
	    <td nowrap="nowrap">
	        <html:text styleId="propertyCodeOtherPopup" name="contractViewHelper" property="propertyCodeOtherPopup"
	                      maxlength="50"  styleClass="input-normal"></html:text>
	    </td>
	</tr>
	<tr class="other-many">
	    <th nowrap="nowrap">Thông tin khác</th>
	    <td nowrap="nowrap" colspan="2">
	        <html:text styleId="propertyOtherInfoPopup" name="contractViewHelper" property="propertyOtherInfoPopup"
	                       styleClass="input-x-long" maxlength="200"></html:text>
	    </td>
	</tr>
	
	<tr id="ownerName_tr">
        <th>Chủ sở hữu&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tên</th>
        <td nowrap="nowrap">
            <html:text styleId="ownerNamePopup" name="contractViewHelper" property="ownerNamePopup" styleClass="input-normal" maxlength="100"></html:text>
        </td>
    </tr>
    <tr id="ownerIdCard_tr">
        <th style="text-align: right;">Mã số định danh</th>
        <td nowrap="nowrap">
            <html:text styleId="ownerIdCardPopup" name="contractViewHelper" property="ownerIdCardPopup" styleClass="input-normal" maxlength="20"></html:text>
        </td>
    </tr>
    <tr>
        <td nowrap="nowrap" colspan="2" style="color: #9595BC; text-indent: 65px;">
            <em>(Số CMND/Hộ chiếu đối với công dân, mã số GPĐKKD với tổ chức doanh nghiệp)</em>
        </td>
    </tr>
    <tr id="ownerAddress_tr">
        <th style="text-align: right;">Địa chỉ</th>
        <td nowrap="nowrap">
            <html:text styleId="ownerAddressPopup" name="contractViewHelper" property="ownerAddressPopup" styleClass="input-x-long" maxlength="200"></html:text>
        </td>
    </tr>
	
	<tr>
	    <td style="text-align: center; padding: 10px;" colspan="4">
	        <html:link href="javascript: accept()">
	            <html:img alt="Chấp nhận" src="./image/btn_accept.png"/>
	        </html:link>
	        <html:link href="javascript: disablePopup()">
	            <html:img alt="Hủy" src="./image/btn_cancel.png"/>
	        </html:link>
	    </td>                 
	</tr>
	
</table>