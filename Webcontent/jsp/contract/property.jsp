<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<table class="tbl-none-border table-inherit">
	<tr class="oneProperty" id="propertyType_tr">
	    <th style="padding-right: 99px;">Tài sản<span class="required">*</span></th>
	    <td>
	        <html:select name="contractViewHelper" property="propertyType" styleId="propertyType"
	            onchange="javascript:changeProperty(this.value);">
	            <html:optionsCollection name="contractViewHelper" property="propertyTypeList" label="name" value="code" />
	        </html:select>
	    </td>
	</tr>
	
	<!-- vehicles property -->
	<tr class="vehicles" id="propertyCodeVehicle_tr">
	    <th>Biển kiểm soát<span class="required">*</span></th>
	    <td>
	        <html:text styleId="propertyCodeVehicle" name="contractViewHelper"
	               property="propertyCodeVehicle" styleClass="input-normal" maxlength="50" style="vertical-align: middle;"/>
	        <html:link href="javascript: search()">
                    <html:img alt="Chấp nhận" src="./image/btn-property-search.png" style="vertical-align: middle;"/>
            </html:link>	        
	    </td>
	</tr>
	<tr class="vehicles" >
	    <th id="provinceVehicle_th">Nơi cấp<span class="required">*</span></th>
	    <td>
	        <span id="provinceVehicle_tr">
	            <html:select styleId="provinceVehicle" name="contractViewHelper" property="provinceVehicle" >
	                <html:option value="0">[Chọn]</html:option>
	                <html:optionsCollection name="contractViewHelper" property="provinceList" label="name" value="id" />
	            </html:select>
	        </span>
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <span id="givenDateVehicle_td">
	            Ngày cấp
	            <html:text name="contractViewHelper" property="givenDateVehicle"
	                styleId="givenDateVehicle" style="vertical-align: middle;" maxlength="10"></html:text>
	            <html:img styleId="popupCal-3" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
	                style="vertical-align: middle;"/>
	        </span>
	        <script>
	              new Calendar({
	                  inputField: "givenDateVehicle",
	                  dateFormat: "%d/%m/%Y",
	                  trigger: "popupCal-3",
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
	<tr class="vehicles" id="frameNumber_tr">
	    <th>Số khung</th>
	    <td>
	        <html:text styleId="frameNumber" name="contractViewHelper" property="frameNumber"
	                       styleClass="input-normal" maxlength="20"></html:text>
	    </td>
	</tr>
	<tr class="vehicles" id="machineNumber_tr">
	    <th>Số máy</th>
	    <td>
	        <html:text styleId="machineNumber" name="contractViewHelper" property="machineNumber"
	                       styleClass="input-normal" maxlength="20"></html:text>
	    </td>
	</tr>
	
	<!-- land property -->
	<tr class="land" id="provinceLand_tr">
	    <th>Tỉnh/thành<span class="required">*</span></th>
	    <td>
	        <html:select name="contractViewHelper" property="provinceLand" styleId="provinceLand" onchange="changeProvince()">
	            <html:option value="0">[Chọn]</html:option>
	            <html:optionsCollection property="provinceList" name="contractViewHelper" label="name" value="id" />
	        </html:select>
	    </td>
	</tr>
	<tr class="land" id="district_tr">
	    <th>Quận/huyện<span class="required">*</span></th>
	    <td>
	        <span class="districtspan">
               <html:select name="contractViewHelper" property="district" styleId="district">
                    <html:option value="0">[Chọn]</html:option>
                    <html:optionsCollection property="districtList" name="contractViewHelper" label="name" value="id" />
                </html:select>
            </span>
	    </td>
	</tr>
	<tr class="land" >
	    <th id="propertyCodeLand_th">Số giấy chứng nhận<span class="required">*</span></th>
	    <td>
	        <span id="propertyCodeLand_td">
	            <html:text styleId="propertyCodeLand" name="contractViewHelper" property="propertyCodeLand"
	                           styleClass="input-normal" maxlength="50" style="vertical-align: middle;"></html:text>
	        </span>
	        <html:link href="javascript: search()">
	                <html:img alt="Chấp nhận" src="./image/btn-property-search.png" style="vertical-align: middle;"/>
	        </html:link>
	        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	        <span id="givenDateLand_td">
	        Ngày cấp
	            <html:text name="contractViewHelper" property="givenDateLand" style="vertical-align: middle;"
	                           styleId="givenDateLand" maxlength="10">
	            </html:text>
	        </span>
	        <html:img styleId="popupCal-4" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
	            style="vertical-align: middle;"/>
	        <script>
	       
	              new Calendar({
	                  inputField: "givenDateLand",
	                  dateFormat: "%d/%m/%Y",
	                  trigger: "popupCal-4",
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
	<tr class="land" id="mapNumber_tr">
	    <th>Số tờ bản đồ</th>
	    <td>
	        <html:text styleId="mapNumber" name="contractViewHelper" property="mapNumber"
	                      maxlength="20" styleClass="input-normal" ></html:text>
	    </td>
	</tr>
	<tr class="land" id="landNumber_tr">
	    <th>Số thửa đất</th>
	    <td>
	        <html:text styleId="landNumber" name="contractViewHelper" property="landNumber"
	                      maxlength="20" styleClass="input-normal"></html:text>
	    </td>
	</tr>
	<tr class="land" id="landAddress_tr">
	    <th>Địa chỉ nhà đất</th>
	    <td>
	        <html:text styleId="landAddress" name="contractViewHelper" property="landAddress"
	                      styleClass="input-x-long" maxlength="200"></html:text>
	    </td>
	</tr>
	
	<!-- other property -->
	<tr class="other" id="propertyCodeOther_tr">
	    <th>Mã số tài sản</th>
	    <td>
	        <html:text styleId="propertyCodeOther" name="contractViewHelper" property="propertyCodeOther"
	                      maxlength="50"  styleClass="input-normal" style="vertical-align: middle;"></html:text>
	        <html:link href="javascript: search()">
                    <html:img alt="Chấp nhận" src="./image/btn-property-search.png" style="vertical-align: middle;"/>
            </html:link>
	    </td>
	</tr>
	<tr class="other" id="propertyOtherInfo_tr">
	    <th>Thông tin khác</th>
	    <td colspan="2">
	        <html:text styleId="propertyOtherInfo" name="contractViewHelper" property="propertyOtherInfo"
	                       styleClass="input-x-long" maxlength="200"></html:text>
	    </td>
	</tr>
	
	<tr class="oneProperty" id="ownerName_tr">
        <th>Chủ sở hữu&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tên</th>
        <td nowrap="nowrap">
            <html:text styleId="ownerName" name="contractViewHelper" property="ownerName" styleClass="input-normal" maxlength="100"></html:text>
        </td>
    </tr>
    <tr class="oneProperty" id="ownerIdCard_tr">
        <th style="text-align: right;">Mã số định danh</th>
        <td nowrap="nowrap">
            <html:text styleId="ownerIdCard" name="contractViewHelper" property="ownerIdCard" styleClass="input-long" maxlength="20"></html:text>
        </td>
    </tr>
    <tr class="oneProperty">
        <td nowrap="nowrap" colspan="2" style="color: #9595BC; text-indent: 65px;">
            <em>(Số CMND/Hộ chiếu đối với công dân, mã số GPĐKKD với tổ chức doanh nghiệp)</em>
        </td>
    </tr>
    <tr class="oneProperty" id="ownerAddress_tr">
        <th style="text-align: right;">Địa chỉ</th>
        <td nowrap="nowrap">
            <html:text styleId="ownerAddress" name="contractViewHelper" property="ownerAddress" styleClass="input-x-long" maxlength="200"></html:text>
        </td>
    </tr>
</table>