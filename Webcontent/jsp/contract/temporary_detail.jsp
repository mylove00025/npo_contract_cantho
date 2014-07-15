<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.servletsuite.com/servlets/tooltip" prefix="t" %>

<table id="contactArea" class="tbl-none-border table-inherit">
	   <tr>
	       <td colspan="2"><strong>Thông tin tài sản</strong></td>
	   </tr>
	   <!-- no type property -->
       <tr>
           <logic:equal value="00" name="temporaryContractViewHelper" property="propertyTypePopup">
           <table class="tbl-detail" width="80%" style="margin:0px">
           <tr>
           <th nowrap="nowrap">Tài sản chặn</th>
           <td>               
                Chưa phân loại
           </td>
           </tr>
           <tr>
            <th>Tiêu đề</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="titlePopup"/>
            </td>
            </tr>           
           <tr>
            <th nowrap="nowrap">Tên chủ sở hữu</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="ownerNamePopup"/>
            </td>
        </tr>
        <tr>
            <th nowrap="nowrap">Mã số định danh chủ sở hữu</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="ownerIdCardPopup"/>
            </td>
        </tr>
        <tr>
            <th nowrap="nowrap">Địa chỉ chủ sở hữu</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="ownerAddressPopup"/>
            </td>
        </tr>      
           </table>
           </logic:equal>      
       </tr>
	   <!-- land property -->
	   <tr>
       <logic:equal value="01" name="temporaryContractViewHelper" property="propertyTypePopup">
	       <table class="tbl-detail" width="80%" style="margin:0px">
	       <tr>
	       <th nowrap="nowrap">Tài sản</th>
           <td>               
                  Nhà đất               
           </td>
           </tr>
           <tr>
            <th>Tiêu đề</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="titlePopup"/>
            </td>
            </tr>
	       <tr>
	           <th nowrap="nowrap">Tỉnh/thành</th>
	           <td>
	               <bean:write name="temporaryContractViewHelper" property="provinceLandNamePopup"/>
	           </td>
	       </tr>
	       <tr>
	           <th nowrap="nowrap">Quận/huyện</th>
	           <td>
	               <bean:write name="temporaryContractViewHelper" property="districtLandNamePopup"/>
	           </td>
	       </tr>
	       <tr>
	           <th nowrap="nowrap">Số giấy chứng nhận</th>
	           <td>
	               <bean:write name="temporaryContractViewHelper" property="propertyCodeLandPopup"/>	               
	           </td>
	       </tr>
	       <tr>
               <th nowrap="nowrap">Ngày cấp</th>
               <td>
                   <bean:write name="temporaryContractViewHelper" property="givenDateLandPopup"/>                                      
               </td>
           </tr>
	       <tr>
	           <th nowrap="nowrap">Số tờ bản đồ</th>
	           <td>
	           <bean:write name="temporaryContractViewHelper" property="mapNumberPopup"/>
	           </td>
	       </tr>
	       <tr>
	           <th nowrap="nowrap">Số thửa đất</th>
	           <td>
	           <bean:write name="temporaryContractViewHelper" property="landNumberPopup"/>
	           </td>
	       </tr>
	       <tr>
	           <th nowrap="nowrap">Địa chỉ nhà đất</th>
	           <td>
	           <bean:write name="temporaryContractViewHelper" property="landAddressPopup"/>
	           </td>
	       </tr>
	       <tr>
            <th nowrap="nowrap">Tên chủ sở hữu</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="ownerNamePopup"/>
            </td>
        </tr>
        <tr>
            <th nowrap="nowrap">Mã số định danh chủ sở hữu</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="ownerIdCardPopup"/>
            </td>
        </tr>
        <tr>
            <th nowrap="nowrap">Địa chỉ chủ sở hữu</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="ownerAddressPopup"/>
            </td>
        </tr>
	       </table>
       </logic:equal>
       </tr>
       
	   <!-- vehicles property -->
	   <!-- Car -->
	   <tr>
	   <logic:equal value="02" name="temporaryContractViewHelper" property="propertyTypePopup">
	       <table class="tbl-detail" width="80%" style="margin:0px">
	       <tr>
	           <th nowrap="nowrap">Tài sản chặn</th>
	           <td>               
	                 Ô tô               
	           </td>
           </tr>
           <tr>
            <th>Tiêu đề</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="titlePopup"/>
            </td>
            </tr>
		   <tr>
		       <th nowrap="nowrap">Biển kiểm soát</th>
		       <td>
		           <bean:write name="temporaryContractViewHelper" property="propertyCodeVehiclePopup"/>	          
		       </td>
		   </tr>
		   <tr>
		       <th nowrap="nowrap">Nơi cấp</th>
		       <td>
		           <bean:write name="temporaryContractViewHelper" property="provinceVehicleNamePopup"/>	
		       </td>
		   </tr>
		   <tr>
               <th nowrap="nowrap">Ngày cấp</th>
               <td>
                   <bean:write name="temporaryContractViewHelper" property="givenDateVehiclePopup"/>
               </td>
           </tr>
		   <tr>
		       <th nowrap="nowrap">Số khung</th>
		       <td>
		       <bean:write name="temporaryContractViewHelper" property="frameNumberPopup"/>
		       </td>
		   </tr>
		   <tr>
		       <th nowrap="nowrap">Số máy</th>
		       <td>
		       <bean:write name="temporaryContractViewHelper" property="machineNumberPopup"/>
		       </td>
		   </tr>
		   <tr>
            <th nowrap="nowrap">Tên chủ sở hữu</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="ownerNamePopup"/>
            </td>
	        </tr>
	        <tr>
	            <th nowrap="nowrap">Mã số định danh chủ sở hữu</th>
	            <td>
	                <bean:write name="temporaryContractViewHelper" property="ownerIdCardPopup"/>
	            </td>
	        </tr>
	        <tr>
	            <th nowrap="nowrap">Địa chỉ chủ sở hữu</th>
	            <td>
	                <bean:write name="temporaryContractViewHelper" property="ownerAddressPopup"/>
	            </td>
	        </tr>
        </table>
	  </logic:equal>
      </tr>
	  <!-- Motor -->
	  <tr>
	    <logic:equal value="03" name="temporaryContractViewHelper" property="propertyTypePopup">
          <table class="tbl-detail" width="80%" style="margin:0px">
          <tr>
           <th nowrap="nowrap">Tài sản chặn</th>
           <td>               
                  Mô tô               
           </td>
           </tr>
           <tr>
            <th>Tiêu đề</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="titlePopup"/>
            </td>
            </tr>
	       <tr>
	           <th nowrap="nowrap">Biển kiểm soát</th>
	           <td>
	               <bean:write name="temporaryContractViewHelper" property="propertyCodeVehiclePopup"/>            
	           </td>
	       </tr>
	       <tr>
               <th nowrap="nowrap">Nơi cấp</th>
               <td>
                   <bean:write name="temporaryContractViewHelper" property="provinceVehicleNamePopup"/>  
               </td>
           </tr>
           <tr>
               <th nowrap="nowrap">Ngày cấp</th>
               <td>
                   <bean:write name="temporaryContractViewHelper" property="givenDateVehiclePopup"/>
               </td>
           </tr>
	       <tr>
	           <th nowrap="nowrap">Số khung</th>
	           <td>
	           <bean:write name="temporaryContractViewHelper" property="frameNumberPopup"/>
	           </td>
	       </tr>
	       <tr>
	           <th nowrap="nowrap">Số máy</th>
	           <td>
	           <bean:write name="temporaryContractViewHelper" property="machineNumberPopup"/>
	           </td>
	       </tr>
	       <tr>
            <th nowrap="nowrap">Tên chủ sở hữu</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="ownerNamePopup"/>
            </td>
        </tr>
        <tr>
            <th nowrap="nowrap">Mã số định danh chủ sở hữu</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="ownerIdCardPopup"/>
            </td>
        </tr>
        <tr>
            <th nowrap="nowrap">Địa chỉ chủ sở hữu</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="ownerAddressPopup"/>
            </td>
        </tr>
       </table>
      </logic:equal>
      </tr>
      
	   <!-- other property -->
	   <tr>
		   <logic:equal value="99" name="temporaryContractViewHelper" property="propertyTypePopup">
           <table class="tbl-detail" width="80%" style="margin:0px">
           <tr>
           <th nowrap="nowrap">Tài sản chặn</th>
           <td>               
                  Tài sản khác              
           </td>
           </tr>
           <tr>
            <th>Tiêu đề</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="titlePopup"/>
            </td>
            </tr>
		   <tr>
		       <th nowrap="nowrap">Mã số tài sản</th>
		       <td>
		       <bean:write name="temporaryContractViewHelper" property="propertyCodeOtherPopup"/>
		       </td>
		   </tr>
		   <tr>
		       <th nowrap="nowrap">Thông tin khác</th>
		       <td>
		       <bean:write name="temporaryContractViewHelper" property="propertyOtherInfoPopup"/>
		       </td>
		   </tr>
		   <tr>
            <th nowrap="nowrap">Tên chủ sở hữu</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="ownerNamePopup"/>
            </td>
        </tr>
        <tr>
            <th nowrap="nowrap">Mã số định danh chủ sở hữu</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="ownerIdCardPopup"/>
            </td>
        </tr>
        <tr>
            <th nowrap="nowrap">Địa chỉ chủ sở hữu</th>
            <td>
                <bean:write name="temporaryContractViewHelper" property="ownerAddressPopup"/>
            </td>
        </tr>	   
           </table>
	       </logic:equal>      
       </tr>     
       <tr>
         <td colspan="2">
             <br/>
         </td>
        </tr>       
       </table>
       <div style="text-align: center; padding: 10px;">
           <html:link href="javascript: disablePopup()">
                <html:img alt="Đóng" src="./image/btn_close.png"/>
           </html:link>	                        
	   </div>