<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>   
    <html:form action="propertylistview" onsubmit="javascript: save();">   
   
    <div id="navigator">
	     <ul class="clearfix">
	         <li>
                    <html:img alt="*" src="./image/bullet_square.gif"/>
                </li>
	         <li>
	             <html:link href="contractlistview.do">Quản lý hợp đồng</html:link>
	         </li>
	         <li>
	             <span> > </span>
	             <html:link href="contractlistview.do">Danh sách hợp đồng</html:link>
	         </li>  
	         <li>
	             <span> > </span>
	              <logic:equal value="true" name="propertyListViewHelper" property="isRegist">   
	             	<html:link href="propertylistback.do">Thêm mới hợp đồng công chứng</html:link>
	              </logic:equal>
	              <logic:equal value="false" name="propertyListViewHelper" property="isRegist">   
	             	<html:link href="propertylistback.do">Sửa hợp đồng công chứng</html:link>
	              </logic:equal>
	         </li>     
	          <li>
	             <span> > </span>
	             <html:link href="#">Thêm thông tin tài sản</html:link>
	         </li>                    
	     </ul>
    </div>    
    <html:hidden styleId="isShowAdd" property="isShowAdd" name="propertyListViewHelper"/>    
    <%@ include file="/jsp/common/error_message.jsp" %>
    	<html:hidden name="propertyListForm" property="indexSelected" />
    	
    	<table class="tbl-none-border">
            <tr>
                <td>
                	<span id="keySearch" class="onmouseover" onclick="ChangeToKeySearching();">[Tìm theo từ khóa]</span>
                    <span id="divaddNew" class="onmouseover" onclick="ChangeToAddProperty();">[Thêm mới thông tin tài sản]</span>
                    
                </td>
            </tr>
        </table>
        <table  class="tbl-none-border" width="98%">
        	<tr valign="top">
        		<td style="width: 40%">
        			<table id="keySearchPanel" class="tbl-none-border">
			            <tr>
			                <th nowrap="nowrap">Từ khóa :</th>
			                <td height="50px">
			                    <html:text styleId="keySearch" property="keySearch" name="propertyListViewHelper" styleClass="input-medium" maxlength="50"/>
			                </td>			                
			            </tr>
			            <tr>
			            	<th></th>
			            	<td style="padding-left:0px;" >
			                    <html:link href="javascript: searchbykey()">
			                         <html:img alt="Tìm kiếm" src="./image/btn_search.png"/>
			                    </html:link>			               
			                    <html:link href="javascript: back()">
				                    <html:img alt="Quay lại" src="./image/btn_back.png"/>
				                </html:link>
			                </td>
			            </tr>
			        </table>
        			<table id="tblSearch" class="tbl-none-border">
			            <tr id="typeProperty_tr">
			                <th nowrap="nowrap">Loại tài sản <span class="required">*</span></th>
			                <td >
			                    <html:select styleId="typeProperty" property="typeProperty" name="propertyListViewHelper"
		                                                 onchange="javascript:changeProperty(this.value);">		                                     
		                                     <html:optionsCollection property="propertyTypeList" name="propertyListViewHelper" label="name" value="code" />
		                        </html:select>
			                </td>                
			            </tr>
			            <tr id="propertyTitle_tr">
			                <th nowrap="nowrap">Tiêu đề <span class="required">*</span></th>
			                <td nowrap="nowrap" colspan="4">
			                    <html:text styleId="propertyTitle" name="propertyListViewHelper" property="propertyTitle"
                                    styleClass="input-medium" maxlength="200"/>            
			                </td>
			            </tr>	
			            <tr >
			                <th nowrap="nowrap"></th>
			                <td nowrap="nowrap" colspan="4">
			                    <input type="checkbox" id="chkauto" value="true" checked="checked"  onclick="changeAuto();" title="Tự động" /><i>Tạo tiêu đề tự động</i>     
			                </td>
			            </tr>		           
		                         <%--Tai san chan la: Nha dat --%>
		                         <tr id="provinceLand_tr">
		                             <th nowrap="nowrap">Tỉnh/thành :</th>
		                             <td id="provinceTd">
		                                 <html:select styleId="provinceLand" property="provinceLand" name="propertyListViewHelper"
		                                  onchange="retrieveURL('ajaxGetDistrict.do?provinceId=' + this.value + '&fieldName=district&hasOptionAll=true');">
		
		                                     <html:option value="0">[Tất cả]</html:option>
		                                     <html:optionsCollection property="provinceList" name="propertyListViewHelper" label="name" value="id" />
		                                 </html:select>
		                             </td>
		                         </tr>
		                         <tr id="district_tr">
		                             <th nowrap="nowrap">Quận/huyện :</th>
		                             <td id="districtTd">
		                                 <span id="district"></span>
		                             </td>
		                         </tr>
		                         <tr id="propertyCodeLand_tr">
		                             <th nowrap="nowrap">Số giấy chứng nhận :</th>
		                             <td>
		                                 <html:text styleId="propertyCodeLand" property="propertyCodeLand" name="propertyListViewHelper"
		                                                 styleClass="input-normal" maxlength="50" onblur="autoBuildTitle();">
		                                 </html:text>
		                             </td>
		                         </tr>		                         
		                         <tr id="givenDateLand_tr">
						                <th>Ngày cấp</th>  
						                <td>
						                    <html:text styleId="givenDateLand" name="propertyListViewHelper" property="givenDateLand" styleClass="input-short" maxlength="10"/>
						                    <html:img styleId="popupCal-1" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
						                                    style="vertical-align: middle;"/>
						                    <script type="text/javascript">
						                          new Calendar({
						                              inputField: "givenDateLand",
						                              dateFormat: "%d/%m/%Y",
						                              trigger: "popupCal-1",
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
		                         <tr id="mapNumber_tr">
		                             <th nowrap="nowrap">Số tờ bản đồ :</th>
		                             <td>
		                                 <html:text styleId="mapNumber" property="mapNumber" name="propertyListViewHelper"
		                                                 styleClass="input-normal" maxlength="200"/>
		                             </td>
		                         </tr>
		                         <tr id="landNumber_tr">
		                             <th nowrap="nowrap">Số thửa đất :</th>
		                             <td>
		                                 <html:text styleId="landNumber" property="landNumber" name="propertyListViewHelper"
		                                                 styleClass="input-normal" maxlength="200"/>
		                             </td>
		                         </tr>
								<tr id="landAddress_tr">
		                             <th nowrap="nowrap">Địa chỉ nhà đất :</th>
		                             <td>
		                                 <html:text styleId="landAddress" property="landAddress" name="propertyListViewHelper"
		                                                 styleClass="input-medium" maxlength="200"  onblur="autoBuildTitle();"/>
		                             </td>
		                         </tr>
		                         
		                         
		                         <%--Tai san chan la: Oto --%>
		                         <tr id="provinceVehicle_tr">
		                             <th nowrap="nowrap">Nơi cấp :</th>
		                             <td>
		                                 <html:select styleId="provinceVehicle" property="provinceVehicle" name="propertyListViewHelper">
		                                     <html:option value="0">[Tất cả]</html:option>
		                                     <html:optionsCollection property="provinceList" name="propertyListViewHelper" label="name" value="id" />
		                                 </html:select>
		                             </td>
		                         </tr>
		                         <tr id="givenDateVehicle_tr">
						                <th>Ngày cấp</th>  
						                <td>
						                    <html:text styleId="givenDateVehicle" name="propertyListViewHelper" property="givenDateVehicle" styleClass="input-short" maxlength="10"/>
						                    <html:img styleId="popupCal-2" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
						                                    style="vertical-align: middle;"/>
						                    <script type="text/javascript">
						                          new Calendar({
						                              inputField: "givenDateVehicle",
						                              dateFormat: "%d/%m/%Y",
						                              trigger: "popupCal-2",
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
		                         <tr id="propertyCodeVehicle_tr">
		                             <th nowrap="nowrap">Biển kiểm soát :</th>
		                             <td>
		                                 <html:text styleId="propertyCodeVehicle" property="propertyCodeVehicle" name="propertyListViewHelper"
		                                             styleClass="input-normal" maxlength="50" onblur="autoBuildTitle();">
		                                 </html:text>
		                             </td>
		                         </tr>	
		                         <tr id="frameNumber_tr">
		                             <th nowrap="nowrap">Số khung :</th>
		                             <td>
		                                 <html:text styleId="frameNumber" property="frameNumber" name="propertyListViewHelper"
		                                             styleClass="input-normal" maxlength="50" onblur="autoBuildTitle();">
		                                 </html:text>
		                             </td>
		                         </tr>
		                         <tr id="machineNumber_tr">
		                             <th nowrap="nowrap">Số máy :</th>
		                             <td>
		                                 <html:text styleId="machineNumber" property="machineNumber" name="propertyListViewHelper"
		                                             styleClass="input-normal" maxlength="50" onblur="autoBuildTitle();">
		                                 </html:text>
		                             </td>
		                         </tr>	
		                        
		                         <%--Tai san chan la: Tai san khac --%>
		                         <tr id="propertyCodeOther_tr">
		                             <th nowrap="nowrap">Mã số tài sản :</th>
		                             <td>
		                                 <html:text styleId="propertyCodeOther" property="propertyCodeOther" name="propertyListViewHelper"
		                                              styleClass="input-normal" maxlength="50" onblur="autoBuildTitle();">
		                                 </html:text>
		                             </td>
		                         </tr>
		                         <tr id="propertyOtherInfo_tr">
		                             <th nowrap="nowrap">Thông tin khác :</th>
		                             <td>
		                                 <html:text styleId="propertyOtherInfo" property="propertyOtherInfo" name="propertyListViewHelper"
		                                                 styleClass="input-medium" maxlength="200" onblur="autoBuildTitle();">
		                                 </html:text>
		                             </td>
		                         </tr>		
		
		                         <tr id="ownerName_tr">
		                             <th nowrap="nowrap">
		                                 Chủ sở hữu&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Tên :
		                             </th>
		                             <td>
		                                 <html:text styleId="ownerName" property="ownerName" name="propertyListViewHelper"
		                                                 styleClass="input-normal" maxlength="100">
		                                 </html:text>
		                             </td>
		                         </tr>
		                         <tr id="ownerIdCard_tr">
		                             <th style="text-align: right;" nowrap="nowrap">Mã số định danh :</th>
		                             <td>
		                                 <html:text styleId="ownerIdCard" property="ownerIdCard" name="propertyListViewHelper"
		                                                 styleClass="input-normal" maxlength="20">
		                                 </html:text>
		                             </td>
		                         </tr>
		                         <tr id="ownerAddress_tr">
		                             <th style="text-align: right;" nowrap="nowrap">Địa chỉ :</th>
		                             <td>
		                                 <html:text styleId="ownerAddress" property="ownerAddress" name="propertyListViewHelper"
		                                                 styleClass="input-medium" maxlength="200">
		                                 </html:text>
		                             </td>
		                         </tr>
			            
			            <tr>
			                <td nowrap="nowrap" colspan="4" style="text-align: center; padding: 10px;">				                
				                <html:link href="javascript: addNew();">
				                	<html:img alt="Thêm mới" src="./image/btn_save.png" />
				                </html:link>               
				                <html:link href="javascript: back()">
				                    <html:img alt="Quay lại" src="./image/btn_back.png"/>
				                </html:link>
			                </td>
			            </tr>
			             </table>
        		</td>
        		<td >
        			<div style="width: 100%;min-height: 120px;width: 100%;margin-left: 0px">
        			<logic:notEmpty name="propertyListViewHelper" property="propertyList">
        				<table class="tbl-list">
			                <tr>
			                    <th>Loại tài sản</th>
			                    <th>Tiêu đề</th>
			                    <th>Thông tin tài sản</th>
			                    <th>Thao tác</th>
			                </tr>  
	        				<logic:iterate id="item" name="propertyListViewHelper" property="propertyList" indexId="i">        				
			                    <tr class="tbl-row<%=i % 2%>">
			                        <td style="text-align: center; width:15%">                     
			                            	<logic:equal name="item" property="type" value="01">Nhà đất</logic:equal>
			                                <logic:equal name="item" property="type" value="02">Ô tô</logic:equal>
			                                <logic:equal name="item" property="type" value="03">Xe máy</logic:equal>
			                                <logic:equal name="item" property="type" value="99">Tài sản khác</logic:equal>                             
			                        </td>
			                        <td>
					                   <bean:write name="item" property="title"/>
					               </td>
						           <td>
					                   <logic:equal name="item" property="type" value="01">
					                       <logic:notEmpty name="item" property="code">
					                           Số giấy chứng nhận: &nbsp;<bean:write name="item" property="code"/>
					                       </logic:notEmpty>                       
					                   </logic:equal>
					                   <logic:equal name="item" property="type" value="02">
					                       <logic:notEmpty name="item" property="code">
					                           Biển kiểm soát: &nbsp;<bean:write name="item" property="code"/>
					                       </logic:notEmpty>
					                   </logic:equal>
					                   <logic:equal name="item" property="type" value="03">
					                       <logic:notEmpty name="item" property="code">
					                           Biển kiểm soát: &nbsp;<bean:write name="item" property="code"/> 
					                       </logic:notEmpty>                       
					                   </logic:equal>
					                   <logic:equal name="item" property="type" value="99">
					                       <logic:notEmpty name="item" property="code">
					                           Mã số tài sản: &nbsp;<bean:write name="item" property="code"/><br/>
					                       </logic:notEmpty>
					                       <logic:notEmpty name="item" property="otherInfo">
					                           Thông tin khác: &nbsp;<bean:write name="item" property="otherInfo"/>
					                       </logic:notEmpty>
					                   </logic:equal>
					                </td>
			                        <td style="text-align: center; width:25%"> 
			                        	<a style="color: #006EF6; text-decoration: underline;" onclick="showDetail(<%=i%>)">Chỉnh sửa</a>
						                   <span> | </span>
						                <a style="color: #006EF6; text-decoration: underline;" onclick="removeProperty(<%=i%>)">Xóa</a>
			                        </td>                       
			                    </tr>    
			                </logic:iterate>
			              </table>
			           </logic:notEmpty>
        			</div>
        		</td>
        	</tr>          
        </table>
        
        <logic:notEmpty name="propertyListViewHelper" property="list">
    		<div>
	            <div class="clearfix-left">
	                <span>◊ Danh sách tài sản đã giao dịch</span>
	            </div>
	            <div class="clearfix-right">                
		          <html:image alt="Chọn tài sản" src="./image/btn_select_transaction_property.png"/>
	            </div>
	        </div>
            <table class="tbl-list">
                <tr>
                    <th style="text-align: center; width:5%">Chọn</th>
                    <th>Loại tài sản</th>
                    <th>Tiêu đề</th>
                    <th>Thông tin tài sản</th>
                    <th>Thông tin chủ sở hữu</th>
                </tr>  
                     
                <logic:iterate id="item" name="propertyListViewHelper" property="list" indexId="i">
                    <tr class="tbl-row<%=i % 2%>">
                    	<td align="center">
                    		<html:multibox name="propertyListViewHelper" styleId="id" property="chkID" disabled="false">
								    <bean:write name='item' property='id'/>
							</html:multibox>							
                    	</td>
                        <td style="text-align: center; width:15%">                     
                            	<logic:equal name="item" property="type" value="01">Nhà đất</logic:equal>
                                <logic:equal name="item" property="type" value="02">Ô tô</logic:equal>
                                <logic:equal name="item" property="type" value="03">Xe máy</logic:equal>
                                <logic:equal name="item" property="type" value="99">Tài sản khác</logic:equal>                             
                        </td>
                        <td>
                            <bean:write name="item" property="title"/>
                        </td>
                        <td>
                            <logic:equal name="item" property="type" value="01">
                                <logic:notEmpty name="item" property="code">
                                    Số giấy chứng nhận: &nbsp;<bean:write name="item" property="code"/>
                                    <br/>
                                </logic:notEmpty>
                                <logic:notEmpty name="item" property="landAddress">
	                                Địa chỉ nhà đất: &nbsp;<bean:write name="item" property="landAddress" />
	                                <br/>
                                </logic:notEmpty>
                                <logic:notEmpty name="item" property="districtName">
                                    <logic:notEmpty name="item" property="provinceName">
                                        Địa bàn: &nbsp;<bean:write name="item" property="districtName" />
                                        &nbsp;-&nbsp;<bean:write name="item" property="provinceName" />
                                        <br/>
                                    </logic:notEmpty>
                                </logic:notEmpty>
                                <logic:empty name="item" property="districtName">
                                    <logic:notEmpty name="item" property="provinceName">
                                        Địa bàn: &nbsp;<bean:write name="item" property="provinceName" />
                                        <br/>
                                    </logic:notEmpty>
                                </logic:empty>
                                <logic:notEmpty name="item" property="mapNumber">
                                    Số tờ bản đồ: &nbsp;<bean:write name="item" property="mapNumber" />
                                    <br/>
                                </logic:notEmpty>
                                <logic:notEmpty name="item" property="landNumber">
                                    Số thửa đất: &nbsp;<bean:write name="item" property="landNumber" />
                                </logic:notEmpty>
                            </logic:equal>
                            <logic:equal name="item" property="type" value="02">
                                <logic:notEmpty name="item" property="code">
	                                Biển kiểm soát: &nbsp;<bean:write name="item" property="code"/>
	                                <br/>
                                </logic:notEmpty>
                                <logic:notEmpty name="item" property="provinceName">
                                    Nơi cấp: &nbsp;<bean:write name="item" property="provinceName" />
                                    <br/>
                                </logic:notEmpty>
                                <logic:notEmpty name="item" property="frameNumber">
                                    Số khung: &nbsp;<bean:write name="item" property="frameNumber" />
                                    <br/>
                                </logic:notEmpty>
                                <logic:notEmpty name="item" property="machineNumber">
                                    Số máy: &nbsp;<bean:write name="item" property="machineNumber" />
                                    <br/>
                                </logic:notEmpty>
                            </logic:equal>
                            <logic:equal name="item" property="type" value="03">
                                <logic:notEmpty name="item" property="code">
                                    Biển kiểm soát: &nbsp;<bean:write name="item" property="code"/>
                                    <br/>
                                </logic:notEmpty>
                                <logic:notEmpty name="item" property="provinceName">
                                    Nơi cấp: &nbsp;<bean:write name="item" property="provinceName" />
                                    <br/>
                                </logic:notEmpty>
                                <logic:notEmpty name="item" property="frameNumber">
                                    Số khung: &nbsp;<bean:write name="item" property="frameNumber" />
                                    <br/>
                                </logic:notEmpty>
                                <logic:notEmpty name="item" property="machineNumber">
                                    Số máy: &nbsp;<bean:write name="item" property="machineNumber" />
                                    <br/>
                                </logic:notEmpty>
                            </logic:equal>
                            <logic:equal name="item" property="type" value="99">
                                <logic:notEmpty name="item" property="code">
                                    Mã số tài sản: &nbsp;<bean:write name="item" property="code"/>
                                    <br/>
                                </logic:notEmpty>
                                <logic:notEmpty name="item" property="otherInfo">                                   
                                   Thông tin khác: &nbsp;<bean:write name="item" property="otherInfo"/>
                                </logic:notEmpty>
                            </logic:equal>
                            
                        </td>
                        <td>                            
                            <bean:write name="item" property="ownerName"/><br/>
                            <logic:notEmpty name="item" property="ownerIdCard">
                                Mã số định danh: &nbsp;<bean:write name="item" property="ownerIdCard"/>
                            </logic:notEmpty>
                        </td>                     
                    </tr>    
                </logic:iterate>
            </table> 
            <logic:greaterThan name="propertyListViewHelper" property="totalCount" value="0">
            <div class="pager">
                <div class="pager-total">Tổng số <strong><bean:write name="propertyListViewHelper" property="totalCount"/></strong> tài sản giao dịch</div>
                <div>
                    <logic:greaterThan name="propertyListViewHelper" property="totalPage" value="1">
                        <html:link href="javascript:direction('first')">        
                            <img class="pager-first" src="./image/first.png" alt= "first"/>
                        </html:link>
                        <html:link href="javascript:direction('ahead')">
                            <img class="pager-prev" src="./image/prev.png" alt= "prev"/>
                    	</html:link>
                    </logic:greaterThan>
                    <span>
                        Trang&nbsp;
                        <bean:write name="propertyListViewHelper" property="page" format="##########"/>
                         /<bean:write name="propertyListViewHelper" property="totalPage" format="##########"/>
                    </span>
                    <logic:greaterThan name="propertyListViewHelper" property="totalPage" value="1">
                        <html:link href="javascript:direction('next')">
                            <img class="pager-next" src="./image/next.png" alt= "next"/>
                        </html:link>
                        <html:link href="javascript:direction('end')">
                            <img class="pager-last" src="./image/last.png" alt= "last"/>
                    	</html:link>
                    </logic:greaterThan>
                </div>
            </div>
            </logic:greaterThan>       
          <html:hidden property="direction"/>
        </logic:notEmpty>
      <div id="popupContact">
            <a id="popupContactClose">x</a>
            <span class="contactArea"></span>
        </div>
        
        <div id="backgroundPopup"></div>
     </html:form>
     
    <%@ include file="/jsp/common/footer.jsp" %> 
</html:html>

<script type="text/javascript">

	$('#contract > em').removeClass("contract-off");
	$('#contract > em').addClass("contract-on");
	$('#contract > b').addClass("menu-on");	
	
	 function ChangeToKeySearching() {
	        document.propertyListForm.isShowAdd.value = "false";
	        document.getElementById("keySearch").style.fontWeight="bold";
	        document.getElementById("divaddNew").style.fontWeight="normal";	        
	        document.getElementById("tblSearch").style.display="none";
	        setSearchState();
	    }

    function ChangeToAddProperty() {
        document.propertyListForm.isShowAdd.value = "true";
        document.getElementById("keySearch").style.fontWeight="normal";
        document.getElementById("divaddNew").style.fontWeight="bold";
        document.getElementById("tblSearch").style.display="";
        setSearchState();
    }
    
    function searchbykey() {
    	 document.propertyListForm.action="propertylistsearch.do";
         document.propertyListForm.submit();
         return true;
    }
    
    function setSearchState() {
    	var isShow = document.getElementById("isShowAdd").value;
    	if (isShow == "false") {
    		document.getElementById("keySearchPanel").style.display = "";
            document.getElementById("keySearch").style.fontWeight="bold";
            document.getElementById("divaddNew").style.fontWeight="normal";
            document.getElementById("tblSearch").style.display="none";
            hidenAll();
            
    	} else {
    		document.getElementById("keySearchPanel").style.display = "none";
            document.getElementById("keySearch").style.fontWeight="normal";
            document.getElementById("divaddNew").style.fontWeight="bold";
            document.getElementById("tblSearch").style.display="";
            setShowAll();
    	}
    }
	
    function direction(data){
        document.propertyListForm.direction.value=data;
        document.propertyListForm.action="listpropertypaging.do";
        document.propertyListForm.submit();
        return true;
    }  
    
    function back(){    	
	    document.propertyListForm.action="propertylistback.do";
	    document.propertyListForm.submit();    	
    	return true;
    }
    
    setSearchState();
    
 	function setShowAll(){
 		
  		var val = document.getElementById("typeProperty").value;
  		
  	    if (val == '00') {   	   	    	
  	        hideLand();   	   	        
  	        hideMotor();
  	        hideOther();
  	  		displayBoss();   	   	        
  	    }

  	    if (val == '01') {
  	        retrieveURL('ajaxGetDistrict.do?provinceId=' + document.getElementById("provinceLand").value
  	                + "&fieldName=district&hasOptionAll=true&selectedId=<bean:write property='district' name='propertyListViewHelper'/>");
  	        hideMotor();
  	        hideMotor();
  	        hideOther();
  	        displayLand();
  	  		displayBoss();
  	    }

  	    if (val == '02') {
  	        hideLand();
  	        hideOther();
  	        displayMotor();
  	  		displayBoss();
  	    }

  	    if (val == '03') {
  	        hideLand();
  	        hideOther();
  	        displayMotor();
  	  		displayBoss();
  	    }

  	    if (val == '99') {
  	        hideLand();
  	        hideMotor();
  	        displayOther();
  	  		displayBoss();
  	    }
   	}
   	    
    function changeProperty(data) {
    	
  		 if (data == '00') {
  	            hideLand();
  	            hideMotor();
  	            hideOther();    
  	            displayBoss();
	     }
	
	      if (data == '01') {
	          retrieveURL('ajaxGetDistrict.do?provinceId=' + document.getElementById("provinceLand").value
	                  + "&fieldName=district&hasOptionAll=true&selectedId=<bean:write property='district' name='propertyListViewHelper'/>");
	          hideMotor();
	          hideOther();
	          displayLand();
	          displayBoss();
	      }
	
	      if (data == '02') {
	          hideLand();
	          hideOther();
	          displayMotor();
	          displayBoss();
	      }
	
	      if (data == '03') {
	          hideLand();
	          hideOther();
	          displayMotor();
	          displayBoss();
	      }
	
	      if (data == '99') {
	          hideLand();
	          hideMotor();
	          displayOther();
	          displayBoss();
	      } 
    }
    
    function hidenAll(){
    	hideLand();
    	hideBoss();  
    	hideMotor();
    	hideOther();
    }

    function displayLand() {
        document.getElementById("provinceLand_tr").style.display = "";
        document.getElementById("district_tr").style.display = "";
        document.getElementById("propertyCodeLand_tr").style.display = "";
        document.getElementById("landAddress_tr").style.display = "";
        document.getElementById("mapNumber_tr").style.display = "";
        document.getElementById("landNumber_tr").style.display = "";
        document.getElementById("givenDateLand_tr").style.display = "";
    }

    function hideLand() {
        document.getElementById("provinceLand_tr").style.display = "none";
        document.getElementById("district_tr").style.display = "none";
        document.getElementById("propertyCodeLand_tr").style.display = "none";
        document.getElementById("landAddress_tr").style.display = "none";
        document.getElementById("mapNumber_tr").style.display = "none";
        document.getElementById("landNumber_tr").style.display = "none";
        document.getElementById("givenDateLand_tr").style.display = "none";
    }

    function displayMotor() {
        document.getElementById("provinceVehicle_tr").style.display = "";
        document.getElementById("propertyCodeVehicle_tr").style.display = "";
        document.getElementById("frameNumber_tr").style.display = "";
        document.getElementById("machineNumber_tr").style.display = "";
        document.getElementById("givenDateVehicle_tr").style.display = "";
    }

    function hideMotor() {
        document.getElementById("provinceVehicle_tr").style.display = "none";
        document.getElementById("propertyCodeVehicle_tr").style.display = "none";
        document.getElementById("frameNumber_tr").style.display = "none";
        document.getElementById("machineNumber_tr").style.display = "none";
        document.getElementById("givenDateVehicle_tr").style.display = "none";
    }

    function displayOther() {
        document.getElementById("propertyCodeOther_tr").style.display = "";
        document.getElementById("propertyOtherInfo_tr").style.display = "";
        
    }

    function hideOther() {
        document.getElementById("propertyCodeOther_tr").style.display = "none";
        document.getElementById("propertyOtherInfo_tr").style.display = "none";
    }
    
    function displayBoss() {
        document.getElementById("ownerName_tr").style.display = "";
        document.getElementById("ownerIdCard_tr").style.display = "";
        document.getElementById("ownerAddress_tr").style.display = "";
        
    }

    function hideBoss() {
        document.getElementById("ownerName_tr").style.display = "none";
        document.getElementById("ownerIdCard_tr").style.display = "none";
        document.getElementById("ownerAddress_tr").style.display = "none";
    }

    var LEFT_CAL = Calendar.setup({
        cont: "cont",
        weekNumbers: true,
        selectionType: Calendar.SEL_MULTIPLE,
        showTime: 12
        // titleFormat: "%B %Y"
    });

    var req;
    var which;

    function retrieveURL(url) {
      if (window.XMLHttpRequest) { // Non-IE browsers
        req = new XMLHttpRequest();
        req.onreadystatechange = processStateChange;
        try {
          req.open("GET", url, true);
        } catch (e) {
          alert(e);
        }
        req.send(null);
      } else if (window.ActiveXObject) { // IE
        req = new ActiveXObject("Microsoft.XMLHTTP");
        if (req) {
          req.onreadystatechange = processStateChange;
          req.open("GET", url, true);
          req.send();
        }
      }
    }

    function processStateChange() {
      if (req.readyState == 4) { // Complete
        if (req.status == 200) { // OK response
            document.getElementById("district").innerHTML = req.responseText;
        } else {
          alert("Problem: " + req.statusText);
        }
      }
    }
  
    
    function save(){
    	
    	document.propertyListForm.action="propertylistsave.do";
    	return true;
    }
    
    var auto = document.getElementById("chkauto").checked;
    if (auto) {
    	document.getElementById("propertyTitle").disabled=true;
    } else {
    	document.getElementById("propertyTitle").disabled=false;
    }
    
    function changeAuto() {
    	var val = document.getElementById("chkauto").checked;
    	if (val) {
        	document.getElementById("propertyTitle").disabled = true;
        } else {
        	document.getElementById("propertyTitle").disabled = false;
        }
    }
    
    function autoBuildTitle(){
	   	//Dat dai
	   	document.getElementById("propertyCodeLand").value = trim(document.getElementById("propertyCodeLand").value," ");
	   	document.getElementById("landAddress").value = trim(document.getElementById("landAddress").value," ");
	   	
	   	//O to, xe may
	   	document.getElementById("propertyCodeVehicle").value= trim(document.getElementById("propertyCodeVehicle").value," ");
	   	document.getElementById("frameNumber").value = trim(document.getElementById("frameNumber").value," ");
	  		document.getElementById("machineNumber").value = trim(document.getElementById("machineNumber").value," ");
	  		
	  	// Tai san khac
	  	document.getElementById("propertyCodeOther").value = trim(document.getElementById("propertyCodeOther").value," ");   
		document.getElementById("propertyOtherInfo").value = trim(document.getElementById("propertyOtherInfo").value," ");;
	   	var val = document.getElementById("chkauto").checked;       	
	   	if (val) {   
	   		document.getElementById("propertyTitle").disabled=true;
	   		var val2 = document.getElementById("typeProperty").value;  
	   		var strTitle = "";
	       	if (val2 == "01") {
	       		var strGCN = document.getElementById("propertyCodeLand").value;    
	       		var strlandAddress = document.getElementById("landAddress").value;
	       		if (strGCN.length > 0 || strlandAddress.length >0)
	       			strTitle = "Nhà đất; ";
	       		if (strGCN.length > 0)
	       			strTitle = strTitle + "GCN: " + strGCN + "; ";
	       		if(strlandAddress.length >0)
	       			strTitle = strTitle + "ĐC: " + strlandAddress;
	       		document.getElementById("propertyTitle").value = strTitle;   	
	       	}
	       	if (val2 == "02") {
	          		
	          		var strBKS = document.getElementById("propertyCodeVehicle").value; 
	          		var strSK = document.getElementById("frameNumber").value;
	          		var strSM = document.getElementById("machineNumber").value;
	          		if (strBKS.length > 0 || strSK.length >0 || strSM.length > 0)
	          			strTitle = "Ô tô; ";
	          		if (strBKS.length > 0)
	          			strTitle = strTitle + "BKS: " + strBKS + "; ";
	          		if (strSK.length > 0)
	          			strTitle = strTitle + "Số khung: " + strSK + "; ";
	          		if (strSM.length > 0)
	          			strTitle = strTitle + "Số máy: " + strSM;   		
	          		document.getElementById("propertyTitle").value = strTitle;
	       	} 
	       	if (val2 == "03") {
	          		var strBKS = document.getElementById("propertyCodeVehicle").value; 
	          		var strSK = document.getElementById("frameNumber").value;
	          		var strSM = document.getElementById("machineNumber").value;
	          		if (strBKS.length > 0 || strSK.length >0 || strSM.length > 0)
	          			strTitle = "Xe máy; ";
	          		if (strBKS.length > 0)
	          			strTitle = strTitle + "BKS: " + strBKS + "; ";
	          		if (strSK.length > 0)
	          			strTitle = strTitle + "Số khung: " + strSK + "; ";
	          		if (strSM.length > 0)
	          			strTitle = strTitle + "Số máy: " + strSM;   		
	          		document.getElementById("propertyTitle").value = strTitle;
	   		} 
	       	
	       	if (val2 == "99") {
	       		var strGCN = document.getElementById("propertyCodeOther").value;     
	       		var strOther = document.getElementById("propertyOtherInfo").value;
	       		if (strGCN.length > 0)
	       			strTitle = strGCN + "; ";
	       		if (strOther.length >0)
	       			strTitle = strTitle + strOther;  
	       		document.getElementById("propertyTitle").value = strTitle;
	   		}
	   	}
	
	    return true;
    }
   	
   	// Ham cat
   	function trim(str, chars) {
   		return ltrim(rtrim(str, chars), chars);
   	}
   	
   	// Cat trai
   	function ltrim(str, chars) {
   		chars = chars || "\\s";
   		return str.replace(new RegExp("^[" + chars + "]+", "g"), "");
   	}
   	
   	// Cat phai
   	function rtrim(str, chars) {
   		chars = chars || "\\s";
   		return str.replace(new RegExp("[" + chars + "]+$", "g"), "");
   	}
    
    function addNew(){    	
    	document.getElementById("propertyTitle").disabled = false;
    	document.propertyListForm.action="addnewpropertylist.do";
        document.propertyListForm.submit();    	
        if (auto)
        	document.getElementById("propertyTitle").disabled=true;
        else
        	document.getElementById("propertyTitle").disabled=false;
    	return true;
    }
   
    
    function showDetail(id) {
    	document.propertyListForm.indexSelected.value = id;
        retrieveURL3("ajaxshowpropertypopup.do?selectedId=" + id);
        centerPopup();
        //load popup
        loadPopup();
    }
    
    function removeProperty(id) {
    	 var answer = confirm ("Bạn có thực sự muốn xóa không?");
         if (answer) {
        	 document.propertyListForm.action="removepropertylist.do?index="+id;
             document.propertyListForm.submit();
             return true;
         }
    }
    function retrieveURL3(url) {
        if (window.XMLHttpRequest) { // Non-IE browsers
          req = new XMLHttpRequest();
          req.onreadystatechange = processStateChange3;
          try {
            req.open("GET", url, true);
            req.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
          } catch (e) {
            alert(e);
          }
          req.send(null);
        } else if (window.ActiveXObject) { // IE
          req = new ActiveXObject("Microsoft.XMLHTTP");
          if (req) {
            req.onreadystatechange = processStateChange3;
            req.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
            req.open("GET", url, true);
            req.send();
          }
        }
    }
    
    function processStateChange3() {
        if (req.readyState == 4) { // Complete
          if (req.status == 200) { // OK response
        	  $('span.contactArea').html(req.responseText);
        	  changeDisplayManyProperties();
          } else {
            alert("Problem: " + req.statusText);
          }
        }
    }  
    
$(document).ready(function(){
        
        //CLOSING POPUP
        //Click the x event!
        $("#popupContactClose").click(function(){
            disablePopup();
        });
        //Click out event!
        $("#backgroundPopup").click(function(){
            disablePopup();
        });
        //Press Escape event!
        $(document).keypress(function(e){
            if(e.keyCode==27 && popupStatus==1){
                disablePopup();
            }
        });
    });
    
    function changeDisplayManyProperties() {
        $('.vehicles-many').hide();
        $('.land-many').hide();
        $('.other-many').hide();    
        var value = $('#propertyTypePopup option:selected').val();
        if(value == "02" || value == "03") {
            $('.vehicles-many').show();
        }
        else if(value == "01") {
            $('.land-many').show();
        }
        else if(value == "99") {
            $('.other-many').show();
        }
    }
    
    function changePropertyPopup(value) {
        changeDisplayManyProperties();       
    }    
    
    function accept() {
    	val = $('#propertyTypePopup option:selected').val();
    	var validate;
        if (val == "01") {
            if ($('#titlePopup').val() == "") {
                alert("Bạn chưa nhập Tiêu đề tài sản.");
            } else if ($('#givenDateLandPopup').val() != "" && validationDate($('#givenDateLandPopup').val()) == "false"){
            	alert("Bạn nhập ngày cấp chưa chính xác.");
	        } else {
	        	validate = "true";
	        }          
        } else if (val == "02" || val == "03") {
        	if ($('#titlePopup').val() == "") {
                alert("Bạn chưa nhập Tiêu đề tài sản.");
            } else if ($('#givenDateVehiclePopup').val() != "" && validationDate($('#givenDateVehiclePopup').val()) == "false"){
                alert("Bạn nhập ngày cấp chưa chính xác.");
            } else {
                validate = "true";
            }
        } else if (val == "99") {
        	if ($('#titlePopup').val() == "") {
                alert("Bạn chưa nhập Tiêu đề tài sản.");
            } else {
            	validate = "true";
            }
        } 
        if (validate == "true") {
	       	document.propertyListForm.action="editpropertylist.do";
	        document.propertyListForm.submit();
	        return true;
	        disablePopup();  
        }
    }
    
    function validationDate(date) {     
        var i;
       
        for (i=0; i < date.length; i++) {
            if (date.charCodeAt(i) != 47 && (date.charCodeAt(i) < 48 || date.charCodeAt(i) > 57)) {
                return "false";
            }
        }
        if (i == date.length) {
            var temp = date.split("/");
            if (temp.length != 3) {
                return "false";
            } else if (temp[0].length > 2 || temp[1].length > 2 || temp[2].length != 4) {
                return "false";
            } else if (parseInt(temp[1]) > 12 || parseInt(temp[1]) <= 0) {
                return "false";
            } else if ((temp[1] == "1" || temp[1] == "01" || temp[1] == "3" || temp[1] == "03" || temp[1] == "5" || temp[1] == "05"
                     || temp[1] == "7" || temp[1] == "07" || temp[1] == "8" || temp[1] == "08" || temp[1] == "10" || temp[1] == "12")
                     && parseInt(temp[0]) > 31) {
                return "false";
            } else if ((temp[1] == "2" || temp[1] == "02") && parseInt(temp[2])% 4 == 0  && parseInt(temp[0]) > 29) {
                return "false";
            } else if ((temp[1] == "2" || temp[1] == "02") && parseInt(temp[2])% 4 != 0  && parseInt(temp[0]) > 28) {
                return "false";
            } else if ((temp[1] == "4" || temp[1] == "04" || temp[1] == "6" || temp[1] == "06" || temp[1] == "9" || temp[1] == "09"
                || temp[1] == "11")&& parseInt(temp[0]) > 30){
                return "false";
            } else {
                return "true";
            }
        }
    }
    
    function retrieveURL2(url) {
        if (window.XMLHttpRequest) { // Non-IE browsers
          req = new XMLHttpRequest();
          req.onreadystatechange = processStateChange2;
          try {
            req.open("GET", url, true);
            req.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
          } catch (e) {
            alert(e);
          }
          req.send(null);
        } else if (window.ActiveXObject) { // IE
          req = new ActiveXObject("Microsoft.XMLHTTP");
          if (req) {
            req.onreadystatechange = processStateChange2;
            req.open("GET", url, true);
            req.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
            req.send();
          }
        }
    }

    function processStateChange2() {
      if (req.readyState == 4) { // Complete
        if (req.status == 200) { // OK response
            $('span.listProperty').html(req.responseText);
        } else {
          alert("Problem: " + req.statusText);
        }
      }
    }
    

    function retrieveURL5(url) {
        if (window.XMLHttpRequest) { // Non-IE browsers
          req = new XMLHttpRequest();
          req.onreadystatechange = processStateChange5;
          try {
            req.open("GET", url, true);
            req.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
          } catch (e) {
            alert(e);
          }
          req.send(null);
        } else if (window.ActiveXObject) { // IE
          req = new ActiveXObject("Microsoft.XMLHTTP");
          if (req) {
            req.onreadystatechange = processStateChange5;
            req.open("GET", url, true);
            req.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
            req.send();
          }
        }
    }

    function processStateChange5() {
      if (req.readyState == 4) { // Complete
        if (req.status == 200) { // OK response
        	$('span.districtSpanPopup').html(req.responseText);
            //document.getElementById("districtSpanPopup").innerHTML = req.responseText;
        } else {
          alert("Problem: " + req.statusText);
        }
      }
    }

</script>