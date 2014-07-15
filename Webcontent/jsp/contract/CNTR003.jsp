<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.servletsuite.com/servlets/tooltip" prefix="t" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>
    <div id="navigator">
            <ul class="clearfix">
                <li>
                    <html:img alt="*" src="./image/bullet_square.gif"/>
                </li>
                <li>
                    <html:link href="contractlistview.do">Quản lý hợp đồng</html:link>
                </li>
                <li>
                    <span> &gt; </span>
                    <html:link href="contractlistview.do">Danh sách hợp đồng</html:link>
                </li>
                <li>
                    <span> &gt; </span>
                    <html:link href="#">Thêm mới hợp đồng công chứng</html:link>
                </li>
            </ul>
        </div>
    <%@ include file="/jsp/common/error_message.jsp" %>

    <html:form styleId="form" action="contractregistview" enctype="multipart/form-data" onsubmit="javascript: save();">
        <html:hidden name="contractForm" property="propertySelectedIndex" />
        <html:hidden name="contractViewHelper" property="fileExisted" styleId="fileExisted" />
        <html:hidden styleId="isDetailPropertyEntry" name="contractViewHelper" property="isDetailPropertyEntry" />
        <html:hidden styleId="fromTemporaryContract" name="contractViewHelper" property="fromTemporaryContract" />
        
        <input type="hidden" id="firstContractNumber"/>
        <div><span class="sub-title">◊ Thông tin hợp đồng</span></div>
        <table class="tbl-none-border">
            <tr id="contractKindId_tr">
                <th>Nhóm hợp đồng</th>
                <td colspan="3">
                    <select name="contractKindId" id="contractKindId"
                                onchange="change('contractKindId', 'contractTemplateId', 0);">
                        <logic:iterate id="item" name="contractViewHelper" property="contractKindTree">
                                <option value="<bean:write name='item' property='id'/>">
                                    <bean:write name="item" property="spaces" filter="false"/>
                                    <bean:write name="item" property="name"/>
                                </option>
                        </logic:iterate>
                    </select>
                </td>
            </tr>

            <tr id="contractTemplateId_tr">
                <th>Tên hợp đồng<span class="required">*</span></th>
                <td colspan="3">
                    <html:select styleId="contractTemplateId" name="contractViewHelper" property="contractTemplateId" onchange="changeTemplate()">
                        <html:optionsCollection name="contractViewHelper" property="contractTemplateList" label="name" value="id" />
                    </html:select>
                </td>
            </tr>

            <tr id="contractNumber_tr">
                <th>Số hợp đồng<span class="required">*</span></th>
                <td>
                    <html:text styleId="contractNumber" name="contractViewHelper" property="contractNumber" onblur="checkContractNumber()"
                                styleClass="input-normal" maxlength="20"/>
                </td>
                
                <%-- <td colspan="2" id = "checkContractNumber" class="checkContractNumber"></td> --%>
            </tr>

            <tr>
                <%-- <logic:equal name="context" property="contractReceiveDate" value="1">
                <th id="receivedDate_th">Ngày thụ lý</th>
                <td id="receivedDate_td">
                    <html:text styleId="receivedDate" name="contractViewHelper" property="receivedDate" styleClass="input-normal" maxlength="10"/>
                    <html:img styleId="popupCal-1" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                                    style="vertical-align: middle;"/>
                    <script type="text/javascript">
                          new Calendar({
                              inputField: "receivedDate",
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
                </logic:equal> --%>
               
               <th id="notaryDate_th">Ngày công chứng<span class="required">*</span></th>
               <td id="notaryDate_td">                	
                    <html:text styleId="notaryDate" name="contractViewHelper" property="notaryDate" styleClass="input-normal" maxlength="10"/>
                    <html:img styleId="popupCal-2" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                                    style="vertical-align: middle;"/>
                    <script type="text/javascript">
                          new Calendar({
                              inputField: "notaryDate",
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
            
            <tr>
                <%-- <logic:equal name="context" property="contractDrafter" value="1">
                <th id="drafterId_th">Chuyên viên soạn thảo</th>
                <td id="drafterId_td">
                    <html:select styleId="drafterId" name="contractViewHelper" property="drafterId">
                        <html:option value="0">[Chọn]</html:option>
                        <html:optionsCollection name="contractViewHelper" property="drafterList" label="fullName" value="id" />
                    </html:select>
                </td>
                </logic:equal> --%>
               
              	<th id="notaryId_th">Công chứng viên<span class="required">*</span>&nbsp;</th>
               	<td id="notaryId_td">
					<html:text styleId="notaryId" name="contractViewHelper" property="crediterName" styleClass="input-normal" maxlength="50"/>
                    <%-- <html:select styleId="notaryId" name="contractViewHelper" property="notaryId">
                        <logic:greaterThan value="1" name="contractViewHelper" property="notaryListSize">
                            <html:option value="0">[Chọn]</html:option>
                        </logic:greaterThan>
                        <html:optionsCollection name="contractViewHelper" property="notaryList" label="fullName" value="id" />
                    </html:select> --%>
                </td>
            </tr>

            <tr>
                <th id="relateObjectATitle">Bên A</th>
                <td class = "relationQbjectA" colspan="3">
                    <html:textarea styleId="relationObjectA" name="contractViewHelper" property="relationObjectA" onkeyup="timedelay(1);" onfocus="$('td.relationobjectlist2').hide(); $('td.relationobjectlist3').hide();" 
                                        styleClass="input-x-long">
                    </html:textarea> 
                  </td> 
               
               
            </tr>
                         
               
            <tr>
                <th id="relateObjectBTitle">Bên B</th>
                <td colspan="3">
                    <html:textarea styleId="relationObjectB" name="contractViewHelper" property="relationObjectB" onkeyup="timedelay(2);" onfocus="$('td.relationobjectlist1').hide(); $('td.relationobjectlist3').hide();" 
                                        styleClass="input-x-long">
                    </html:textarea>

                </td>
            </tr>

            <tr id="objectC" style="display: none;">
                <th id="relateObjectCTitle">Bên C</th>
                <td colspan="3">
                    <html:textarea styleId="relationObjectC" name="contractViewHelper" property="relationObjectC" onkeyup="timedelay(3);" onfocus="$('td.relationobjectlist1').hide();$('td.relationobjectlist2').hide();"
                                        styleClass="input-x-long">
                    </html:textarea>
                </td>
            </tr>
            
            <tr>
                <th style="line-height: 1.2;  vertical-align: top;">Tóm tắt nội dung<br/>hợp đồng</th>
                <td colspan="3">
                    <html:textarea onclick="displayDescription();" onblur="hideDescription();" styleId="contractSummary" name="contractViewHelper" property="contractSummary" styleClass="input-x-long">
                    </html:textarea>
                </td>
                
                 
            </tr>
            <tr style="display:none" id="period_time">
          		<th>Thời hạn</th>
          		<td colspan="3">
          		 <html:text styleId="contractPeriod" name="contractViewHelper" property="contractPeriod" styleClass="input-normal" maxlength="50"/>
                    
          		</td>
            </tr>

       
            <%-- <logic:equal name="context" property="contractValue" value="1">
            <tr id="contractValue_tr">
                <th>Giá trị hợp đồng</th>
                <td nowrap="nowrap">
                    <t:tooltip>
                        <t:text>
                            <html:text styleId="contractValue" name="contractViewHelper" property="contractValue"
                                            styleClass="input-normal" maxlength="20" onblur="javascript: changeValue('contractValue');"/>
                            <label style="font-weight:normal">VNĐ</label>
                        </t:text>
                        <t:help className="tooltip">Bao gồm các chữ số và dấu chấm, ví dụ: 1.000.000(một triệu đồng)</t:help>
                    </t:tooltip>
                </td>
            </tr>
            </logic:equal>
            
            <logic:equal name="context" property="contractNotaryPlace" value="1">
            <tr id="notaryPlace_tr">
                <th>Địa điểm công chứng</th>
                <td colspan="3">
                    <html:radio styleId="internalPlace" property="notaryPlaceFlag" name="contractViewHelper" value="true"/>
                    <label for="internalPlace">Tại văn phòng</label>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <html:radio styleId="externalPlace" property="notaryPlaceFlag" name="contractViewHelper" value="false"/>
                    <label for="externalPlace">Ngoài văn phòng</label>
                    <html:text styleId="notaryPlace" name="contractViewHelper" property="notaryPlace" style="width: 252px;"/>
                </td>
            </tr>
            </logic:equal>
           
          
            
            <logic:equal name="context" property="contractUserRequire" value="1">
            <tr id="userRequireContract_tr">
                <th>Người yêu cầu công chứng</th>
                <td colspan="3">
                    <html:text styleId="userRequireContract" name="contractViewHelper" property="userRequireContract"
                                    styleClass="input-x-long"/>
                </td>
            </tr>
            </logic:equal>

            <tr>
                <td colspan="2" style="padding-top: 10px;">
                    <span class="sub-title">◊ Thông tin tài sản trong hợp đồng</span>
                    &nbsp;&nbsp;&nbsp;
                    <a id="detailEntry" class="detailEntry" style="color: blue;" onclick="changePropertyKindEntry('true'); setPropertyKindEntry()">
                        [Nhập chi tiết]
                    </a>
                    <a id="simpleEntry" class="simpleEntry" style="color: blue;" onclick="changePropertyKindEntry('false'); setPropertyKindEntry()">
                        [Nhập đơn giản]
                    </a>
                </td>
            </tr>
          
            
            <tr id="type_tr">
		        <th>Tài sản</th>
		        <td colspan="3">
		            <html:select name="contractViewHelper" property="type" styleId="type"
		                onchange="javascript:changeDisplayProperty();">
		                <html:optionsCollection name="contractViewHelper" property="propertyTypeList" label="name" value="code" />
		            </html:select>
		        </td>
            </tr>
            
            <!-- Nhập đơn giản -->
            <tr class="propertyInfo" id="propertyInfo_tr">
                <th>Thông tin tài sản</th>
                <td colspan="3">
                    <html:textarea styleId="propertyInfo" name="contractViewHelper" property="propertyInfo" style="width: 400px;">
                            </html:textarea>
                </td>
            </tr>            
            <!-- Kết thúc nhập đơn giản -->
            
            <!-- Nhập chi tiết -->
            <!-- Nhập tài sản là nhà đất -->
            
            <logic:equal name="context" property="propertyLandAddress" value="1">
            <tr class="land" id="landAddress_tr">
                <th>Địa chỉ</th>
                <td colspan="3">
                    <html:text styleId="landAddress" name="contractViewHelper" property="landAddress"
                           style="width: 400px;" maxlength="200"/>
                </td>
            </tr>
            </logic:equal>
            
            <logic:equal name="context" property="propertyLandCertificate" value="1">
            <tr class="land" id="landCertificate_tr">
                <th>Số giấy chứng nhận</th>
                <td colspan="3">
                    <html:text styleId="landCertificate" name="contractViewHelper" property="landCertificate"
                           style="width: 400px;" maxlength="200"/>
                </td>
            </tr>
            </logic:equal>
            
            <%
                        	if ("1".equals(context.getPropertyLandIssuePlace())
                        					|| "1".equals(context.getPropertyLandIssueDate())) {
                        %>
            <tr class="land">
                <logic:equal name="context" property="propertyLandIssuePlace" value="1">
                    <th style="vertical-align: middle;">Nơi cấp</th>
                </logic:equal>
                <logic:notEqual name="context" property="propertyLandIssuePlace" value="1">
                    <th>Ngày cấp</th>
                </logic:notEqual>
                <td colspan="3">
                    <logic:equal name="context" property="propertyLandIssuePlace" value="1">
	                    <span id="landIssuePlace_td">
		                    <html:text styleId="landIssuePlace" name="contractViewHelper" property="landIssuePlace"
		                           styleClass="input-normal" style="vertical-align: middle;" maxlength="100"/>
	                    </span>
                    </logic:equal>
                    <logic:equal name="context" property="propertyLandIssueDate" value="1">                    
		            <span id="landIssueDate_td">
		                <logic:equal name="context" property="propertyLandIssuePlace" value="1">
		                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                    Ngày cấp
		                </logic:equal>		                
		                <html:text name="contractViewHelper" property="landIssueDate" style="vertical-align: middle;"
		                               styleId="landIssueDate" maxlength="10">
		                </html:text>
		            </span>
		            <html:img styleId="popupCal-3" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
		                style="vertical-align: middle;"/>
		            <script>
		           
		                  new Calendar({
		                      inputField: "landIssueDate",
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
		            </logic:equal>
                </td>                
            </tr>
            <%
            	}
            %>
            
            <tr class="land">
                <logic:equal name="context" property="propertyLandNumber" value="1">
                    <th>Thửa đất số</th>
                </logic:equal>
                <logic:notEqual name="context" property="propertyLandNumber" value="1">
                    <th></th>
                </logic:notEqual>
                <td colspan="3">
                    <logic:equal name="context" property="propertyLandNumber" value="1">
	                    <span id="landNumber_td">
		                    <html:text styleId="landNumber" name="contractViewHelper" property="landNumber" maxlength="20"/>
	                    </span>
                    </logic:equal>
                   
                    <logic:equal name="context" property="propertyLandMapNumber" value="1">
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <span id="landMapNumber_td">
                        Tờ bản đồ số
                        <html:text styleId="landMapNumber" name="contractViewHelper" property="landMapNumber" style="width: 156px;" maxlength="20"/>
                    </span>
                    </logic:equal>
                </td>
            </tr>
            
            <logic:equal name="context" property="propertyLandArea" value="1">
            <tr class="land">
                <th>Diện tích</th>
                <td colspan="3">
                    <span id="landArea_td">
                        <html:text styleId="landArea" name="contractViewHelper" property="landArea" style="width: 52px;" maxlength="20"/>
                    </span>
                    <logic:equal name="context" property="propertyLandPrivateArea" value="1">
	                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                    Hình thức sử dụng &nbsp;&nbsp; Riêng
	                    <span id="landPrivateArea_td">
	                        <html:text styleId="landPrivateArea" name="contractViewHelper" property="landPrivateArea"
	                                style="width: 50px;" maxlength="20"/>
	                    </span>
                    </logic:equal>
                    
                    <logic:equal name="context" property="propertyLandPublicArea" value="1">
                    Chung
                    <span id="landPublicArea_td">
                        <html:text styleId="landPublicArea" name="contractViewHelper" property="landPublicArea"
                                style="width: 50px;" maxlength="20"/>
                    </span>
                    </logic:equal>
                </td>
            </tr>
            </logic:equal>
            
            <logic:equal name="context" property="propertyLandUsePurpose" value="1">
            <tr class="land" id="landUsePurpose_tr">
                <th>Mục đích sử dụng</th>
                <td colspan="3">
                    <html:text styleId="landUsePurpose" name="contractViewHelper" property="landUsePurpose"
                           style="width: 400px;" maxlength="100"/>
                </td>
            </tr>
            </logic:equal>
            
            <logic:equal name="context" property="propertyLandUsePeriod" value="1">
            <tr class="land" id="landUsePeriod_tr">
                <th>Thời hạn sử dụng</th>
                <td colspan="3">
                    <html:text styleId="landUsePeriod" name="contractViewHelper" property="landUsePeriod"
                           style="width: 400px;" maxlength="100"/>
                </td>
            </tr>
            </logic:equal>
            
            <logic:equal name="context" property="propertyLandUseOrigin" value="1">
            <tr class="land" id="landUseOrigin_tr">
                <th>Nguồn gốc sử dụng</th>
                <td colspan="3">
                    <html:text styleId="landUseOrigin" name="contractViewHelper" property="landUseOrigin"
                           style="width: 400px;" maxlength="200"/>
                </td>
            </tr>
            </logic:equal>
            
            <logic:equal name="context" property="propertyLandAssociateProperty" value="1">
            <tr class="land" id="landAssociateProperty_tr">
                <th>Tài sản gắn liền với đất</th>
                <td colspan="3">
                    <html:text styleId="landAssociateProperty" name="contractViewHelper" property="landAssociateProperty"
                           style="width: 400px;" maxlength="200"/>
                </td>
            </tr>
            </logic:equal>
            <!-- kết thúc nhập tài sản là nhà đất -->
                
            <!-- Nhập tài sản là oto xe máy -->
            <logic:equal name="context" property="propertyCarLicenseNumber" value="1">
            <tr class="vehicle" id="carLicenseNumber_tr">
                <th>Biển kiểm soát</th>
                <td colspan="3">
                    <html:text styleId="carLicenseNumber" name="contractViewHelper" property="carLicenseNumber"
                        style="width: 400px;" maxlength="200"/>
                </td>
            </tr>
            </logic:equal>
            
            <logic:equal name="context" property="propertyCarRegistNumber" value="1">
            <tr class="vehicle" id="carRegistNumber_tr">
                <th>Số giấy đăng ký</th>
                <td colspan="3">
                    <html:text styleId="carRegistNumber" name="contractViewHelper" property="carRegistNumber"
                           style="width: 400px;" maxlength="200"/>
                </td>
            </tr>
            </logic:equal>
            
            <%
                        	if ("1".equals(context.getPropertyCarIssuePlace())
                        					|| "1".equals(context.getPropertyCarIssueDate())) {
                        %>
            <tr class="vehicle">
                <logic:equal name="context" property="propertyCarIssuePlace" value="1">
                    <th style="vertical-align: middle;">Nơi cấp</th>
                </logic:equal>
                <logic:notEqual name="context" property="propertyCarIssuePlace" value="1">
                    <th style="vertical-align: middle;">Ngày cấp</th>
                </logic:notEqual>
                <td colspan="3">
                     <logic:equal name="context" property="propertyCarIssuePlace" value="1">
		                 <span id="carIssuePlace_td">
		                     <html:text styleId="carIssuePlace" name="contractViewHelper" property="carIssuePlace"
		                            styleClass="input-normal" style="vertical-align: middle;" maxlength="100"/>
		                 </span>
	                 </logic:equal>
	                 <logic:equal name="context" property="propertyCarIssueDate" value="1">
	                 <span id="carIssueDate_td">
	                     <logic:equal name="context" property="propertyCarIssuePlace" value="1">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            Ngày cấp
                        </logic:equal>
	                     <html:text name="contractViewHelper" property="carIssueDate" style="vertical-align: middle;"
	                                    styleId="carIssueDate" maxlength="10">
	                     </html:text>
	                 </span>
	                 <html:img styleId="popupCal-4" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
	                     style="vertical-align: middle;"/>
	                 <script>
	                
	                       new Calendar({
	                           inputField: "carIssueDate",
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
	                 </logic:equal>
                </td>                
            </tr>
            <%
            	}
            %>
            
            <%
                        	if ("1".equals(context.getPropertyCarFrameNumber())
                        					|| "1".equals(context.getPropertyCarMachineNumber())) {
                        %>
            <tr class="vehicle">
                <logic:equal name="context" property="propertyCarFrameNumber" value="1">
                    <th>Số khung</th>
                </logic:equal>
                <logic:notEqual name="context" property="propertyCarFrameNumber" value="1">
                    <th>Số máy</th>
                </logic:notEqual>
                <td colspan="3">
                     <logic:equal name="context" property="propertyCarFrameNumber" value="1">
	                     <span id="carFrameNumber_td">
	                         <html:text styleId="carFrameNumber" name="contractViewHelper" property="carFrameNumber"
	                                styleClass="input-normal" maxlength="50"/>
	                     </span>
                     </logic:equal>
                     <logic:equal name="context" property="propertyCarMachineNumber" value="1">
                     <logic:equal name="context" property="propertyCarFrameNumber" value="1">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        Số máy
                     </logic:equal>
                     <span id="carMachineNumber_td">
                         <html:text name="contractViewHelper" property="carMachineNumber" style="vertical-align: middle;"
                                        styleId="carMachineNumber" maxlength="50">
                         </html:text>
                     </span>
                     </logic:equal>
                </td>                
            </tr>
            <%
            	}
            %>
            <!-- kết thúc nhập tài sản là oto xe máy -->
            
            <logic:equal name="context" property="propertyOwnerInfo" value="1">
            <tr class="detailEntry" id="ownerInfo_tr">
                <th>Thông tin chủ sở hữu</th>
                <td colspan="3">
                    <html:text styleId="ownerInfo" name="contractViewHelper" property="ownerInfo"
                           style="width: 400px;" maxlength="500"/>
                </td>
            </tr>
            </logic:equal>
            <tr class="detailEntry" id="otherInfo_tr">
                <th>Thông tin khác</th>
                <td colspan="3">
                    <html:text styleId="otherInfo" name="contractViewHelper" property="otherInfo" style="width: 400px;" maxlength="1000"/>
                </td>
            </tr>  
            <!-- Kết thúc nhập chi tiết -->
            
            <!-- Nhiều tài sản
            <tr class="manyProperty">
                <td colspan="2" style="padding-left: 25px;">
                    <span class="listProperty"></span>
                </td>
            </tr>
             --> --%>
             
        </table>
    <%-- 
	<table
		style="position:absolute; left:685px;top:250px; ">
		<tr>
		
			<td id="relationobjectlist1" class="relationobjectlist1"></td>
			
		</tr>

	</table>

	<table style="position: absolute; left:685px;top:310px;">
        <tr>
                
                <td  id = "relationobjectlist2" class="relationobjectlist2"></td>
                </tr>
           </table>
           
    <table style="position: absolute; left:685px;top:370px;">
        <tr>
                
                <td  id = "relationobjectlist3" class="relationobjectlist3"></td>
                </tr>
           </table>
          
        <br/>
        <fieldset id="searchField" class="fieldsetstyle" style="width: 70%;">
	        <legend id="searchShow" class="sub-title">
	           <span class="tree_open" id="searchOption" style="cursor: pointer; margin: 0 0 0 0;" onclick="changeSearchState(); setSearchState();"></span>
	           <span class="onmouseover sub-title" onclick="changeSearchState(); setSearchState();">Thông tin khác</span>
	        </legend>
            <html:hidden styleId="isHidePanelSearch" property="isHidePanelSearch" name="contractForm"/>
        <table id="otherInformation" class="tbl-none-border">
            <tr>
                <td style="padding-left: 20px; padding-bottom: 20px;">
                <table class="tbl-none-border">
                    <logic:equal name="context" property="supplementContractFunction" value="1">
		            <tr>
		                <td nowrap="nowrap" style="color:Black; font-weight:bold">Tình trạng hợp đồng</td>
		                <td nowrap="nowrap">
		                    <html:checkbox styleId="additionStatus" name="contractViewHelper" property="additionStatus"
		                                        onclick="changeAdditionStatus();">
		                    </html:checkbox>
		                    <label style="font-weight:normal" for="additionStatus">Hợp đồng cần bổ sung hồ sơ</label>
		                </td>
		            </tr>
		            <tr id="additionDescription_tr" class="additionDescription">
		                <th nowrap="nowrap">Mô tả</th>
		                <td nowrap="nowrap">
		                    <html:textarea name="contractViewHelper" styleId="additionDescription" property="additionDescription"
		                          style="width: 210px;">
		                    </html:textarea>      
		                </td>
		            </tr>
		            </logic:equal>
		            
		            <tr>
		                <td nowrap="nowrap" colspan="2">
		                    <span style="color:Black; font-weight:bold">Ngân hàng</span>
		                </td>
		            </tr>
		            <tr id="bankId_tr">
		                <th nowrap="nowrap">Tên ngân hàng</th>
		                <td nowrap="nowrap" colspan="3">
		                    <html:select styleId="bankId" name="contractViewHelper" property="bankId" style="width: 210px;">
		                        <html:option value="0">[Chọn]</html:option>
		                        <html:optionsCollection name="contractViewHelper" property="bankList" label="name" value="id" />
		                    </html:select>
		                </td>
		            </tr>
		            <%
		            	if (context.isBankReport()) {
		            %>
		            <tr id="crediterName_tr">
		                <th nowrap="nowrap">Cán bộ tín dụng</th>
		                <td nowrap="nowrap">
		                    <html:text styleId="crediterName" name="contractViewHelper" property="crediterName"
		                          styleClass="input-normal" maxlength="50"/>
		                </td>
		            </tr>
		            <tr id="bankServiceFee_tr">
		                <th nowrap="nowrap">Chiết khấu</th>
		                <td nowrap="nowrap">
		                    <t:tooltip>
		                        <t:text>
		                            <html:text styleId="bankServiceFee" name="contractViewHelper" property="bankServiceFee"
		                                    styleClass="input-normal" maxlength="20" onblur="javascript: changeValue('bankServiceFee');"/>
		                            <label style="font-weight:normal">VNĐ</label>
		                        </t:text>
		                        <t:help className="tooltip">Bao gồm các chữ số và dấu chấm, ví dụ: 1.000.000(một triệu đồng)</t:help>
		                    </t:tooltip>
		                </td>
		
		            </tr>
		            <%
		            	}
		            %>
		            
		            <tr>
		                <td nowrap="nowrap" colspan="2">
		                    <span style="color:Black; font-weight:bold">Thông tin lưu trữ</span>
		                </td>
		            </tr>
		            <tr id="numberOfPage_tr">
		                <th nowrap="nowrap">Số tờ / trang hợp đồng</th>
		                <td nowrap="nowrap" colspan="3">
		                    <html:text styleId="numberOfPage" name="contractViewHelper" property="numberOfPage"
		                                    style="width: 210px;" maxlength="50"/>
		                </td>
		            </tr>
		            <tr id="numberCopyOfContract_tr">
		                <th nowrap="nowrap">Số bản công chứng</th>
		                <td nowrap="nowrap" colspan="3">
		                    <html:text styleId="numberCopyOfContract" name="contractViewHelper" property="numberCopyOfContract"
		                                    style="width: 210px;" maxlength="50"/>
		                </td>
		            </tr>
		            <tr id="formFile_tr">
		                <th nowrap="nowrap">
		                    Hợp đồng đính kèm
		                </th>
		                <logic:equal value="true" name="contractViewHelper" property="fileExisted">
                        <td nowrap="nowrap" colspan="3" class="attach_file_existed">
	                        <html:link href="javascript:download()">
	                            <bean:write name="contractViewHelper" property="fileNameDisp"/>
	                        </html:link>
	                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                        <logic:notEmpty name="contractViewHelper" property="fileName">
	                           <a style="color: blue;"><span style="text-decoration: underline;" onclick="javascript:remove_file();">Gỡ bỏ</span></a>
	                        </logic:notEmpty>
                        </td>
                        </logic:equal>
                        <td nowrap="nowrap" class="attach_file_new" id="formFile_tr">
                           <html:file name="contractViewHelper" property="formFile" styleClass="input-normal" />
                       </td>
		                <!--<td nowrap="nowrap" colspan="3">
                            <html:file styleId="formFile" name="contractViewHelper" property="formFile" style="width: 210px;" />
                        </td>-->
                    </tr>
		            <tr id="originalStorePlace_tr">
		                <th nowrap="nowrap">Nơi lưu trữ bản gốc</th>
		                <td nowrap="nowrap" colspan="3">
		                    <html:text styleId="originalStorePlace" name="contractViewHelper" property="originalStorePlace"
		                                    style="width: 210px;" maxlength="200"/>
		                </td>
		            </tr>
                </table>
                
                
                </td>
                <th style="padding-left: 20px;" valign="top">
                <table class="tbl-none-border">
                    <tr>
                        <td nowrap="nowrap" colspan="2">
                            <span style="color:Black; font-weight:bold">Thu phí</span>
                        </td>
                    </tr>
                    <tr id="costTt91_tr">
                        <th nowrap="nowrap" width="143px">Thù lao công chứng</th>
                        <td nowrap="nowrap" nowrap="nowrap">
                            <t:tooltip>
                                <t:text>
                                    <html:text styleId="costTt91" name="contractViewHelper" property="costTt91"
                                            onblur="countTotal();changeValue('costTt91');" maxlength="20"/>
                                    <label style="font-weight:normal">VNĐ</label>
                                </t:text>
                                <t:help className="tooltip">Bao gồm các chữ số và dấu chấm, ví dụ: 1.000.000(một triệu đồng)</t:help>
                            </t:tooltip>
                        </td>
                    </tr>
                    <tr id="costDraft_tr">
                        <th nowrap="nowrap">Thù lao soạn thảo</th>
                        <td nowrap="nowrap" nowrap="nowrap">
                            <t:tooltip>
                                <t:text>
                                    <html:text styleId="costDraft" name="contractViewHelper" property="costDraft"
                                            onblur="countTotal();changeValue('costDraft');" maxlength="20"/>
                                    <label style="font-weight:normal">VNĐ</label>
                                </t:text>
                                <t:help className="tooltip">Bao gồm các chữ số và dấu chấm, ví dụ: 1.000.000(một triệu đồng)</t:help>
                            </t:tooltip>
                        </td>
                    </tr>
                    <tr id="costNotaryOutsite_tr">
                        <th nowrap="nowrap">Dịch vụ công chứng ngoài</th>
                        <td nowrap="nowrap" nowrap="nowrap">
                            <t:tooltip>
                                <t:text>
                                    <html:text styleId="costNotaryOutsite" name="contractViewHelper" property="costNotaryOutsite"
                                            onblur="countTotal();changeValue('costNotaryOutsite');" maxlength="20"/>
                                    <label style="font-weight:normal">VNĐ</label>
                                </t:text>
                                <t:help className="tooltip">Bao gồm các chữ số và dấu chấm, ví dụ: 1.000.000(một triệu đồng)</t:help>
                            </t:tooltip>
                        </td>
                    </tr>
                    <tr id="costOtherDetermine_tr">
                        <th nowrap="nowrap">Dịch vụ xác minh khác</th>
                        <td nowrap="nowrap" nowrap="nowrap">
                            <t:tooltip>
                                <t:text>
                                    <html:text styleId="costOtherDetermine" name="contractViewHelper" property="costOtherDetermine"
                                            onblur="countTotal();changeValue('costOtherDetermine');" maxlength="20"/>
                                    <label style="font-weight:normal">VNĐ</label>
                                </t:text>
                                <t:help className="tooltip">Bao gồm các chữ số và dấu chấm, ví dụ: 1.000.000(một triệu đồng)</t:help>
                            </t:tooltip>
                        </td>
                    </tr>
                    <tr id="costTotal_tr">
                        <th nowrap="nowrap" style="font-weight:bold">Tổng phí</th>
                        <td nowrap="nowrap">
                            <html:text styleId="costTotal" name="contractViewHelper" property="costTotal" maxlength="20"
                                            onblur="javascript: changeValue('costTotal');"/>
                            <label style="font-weight:normal">
                            VNĐ
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td nowrap="nowrap" nowrap="nowrap" colspan="2">
                            <span style="color:Black; font-weight:bold; vertical-align:25px;">Ghi chú</span>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <html:textarea styleId="contractNote" name="contractViewHelper" property="contractNote" styleClass="input-long">
                            </html:textarea>
                        </td>
                    </tr>
                </table>
                </th>
            </tr>
          </table>
           
          </fieldset>
           --%>
        <span class="onmouseover" onmouseover="overDescription();style.backgroundColor='#D6D5D9';" onmouseout="style.backgroundColor='#FFFFFF';moveoutDescription();" onclick="getDescription()"  id="suggestion" 
            style=" cursor: pointer;position:absolute; top: 440px; left: 692px; -moz-box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.5); background-color: #FFFFFF; border: 1px solid #999999;display: block; visibility: visible;text-align: left; padding:5px;" ></span>
          <html:img  style=" position:absolute; top: 442px; left: 675px;" styleId="sharp3" alt="*" src="./image/icon_sharp2.png"/>
          <div  style=" padding-left: 250px; padding-top: 20px;">
              <span id="update_on">
                  <html:image alt="Lưu" src="./image/btn_save.png" onclick="stylechange('update_off', 'update_on');"/>
              </span>
              <span id="update_off" style="display: none;">
                  <html:link href="#">
                      <html:img alt="Lưu" src="./image/btn_save.png"/>
                  </html:link>
              </span>
              
              <html:link href="contractlistback.do">
                  <html:img alt="Hủy" src="./image/btn_cancel.png"/>
              </html:link>
          </div>

        <div id="popupContact">
            <a id="popupContactClose">x</a>
            <span class="contactArea"></span>
        </div>

        <div id="backgroundPopup"></div>

<input type="hidden" name="keyHighLight1" id="keyHighLight1"/>
<input type="hidden" name="keyHighLight2" id="keyHighLight2"/>
<input type="hidden" name="keyHighLight3" id="keyHighLight3"/>

<input type="hidden" name="showDescriptionState" id="showDescriptionState"/>

    </html:form>
    <%@ include file="/jsp/common/footer.jsp" %>
</html:html>

<script type="text/javascript">

    $('#contract > em').removeClass("contract-off");
    $('#contract > em').addClass("contract-on");
    $('#contract > b').addClass("menu-on");

    document.getElementById("contractKindId").focus();

    //retrieveURL2('ajaxshowproperties.do');
    
//document.write("Browser CodeName: " + navigator.appCodeName); 
    var LEFT_CAL = Calendar.setup({
        cont: "cont",
        weekNumbers: true,
        selectionType: Calendar.SEL_MULTIPLE,
        showTime: 12
        // titleFormat: "%B %Y"
    });

    function save() {
        document.contractForm.action="contractregist.do";
    }

    function downloadcontractdraft() {
        document.contractForm.action='downloadcontractdraft.do';
        document.contractForm.submit();
    }
    
    var fileExistedValue = $("#fileExisted").val();
    if (fileExistedValue == 'true') {
        $('td.attach_file_new').hide();
    } else {
        $('td.attach_file_new').show();
    }
    
    function remove_file() {
        var answer = confirm ("Bạn có thực sự muốn gỡ bỏ không?");
        if (answer) {
            $("#fileExisted").val(false);
            $('td.attach_file_existed').hide();
            $('td.attach_file_new').show();
        }
    }

    function download() {
        document.contractForm.action='downloadcontractfile.do';
        document.contractForm.submit();
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
        } else {
            alert("Bạn chưa nhập tài sản chặn.")
        }

        if (validate == "true") {
            document.contractForm.action="editpropertyregist.do";
            document.contractForm.submit();
            return true;
            disablePopup();
        }
    }

    function showDetail(id) {
        document.contractForm.propertySelectedIndex.value = id;
        retrieveURL3("ajaxshowpropertypopup.do?selectedId=" + id);
        centerPopup();
        //load popup
        loadPopup();
    }

    function addProperty() {
        document.contractForm.action="addpropertyregist.do";
        document.contractForm.submit();
        return true;
    }

    function changeValue(elementid) {
    	var cValue = document.getElementById(elementid).value;
    	var l=0;
    	var str = "";
    	
    	while (l < cValue.length) {
    		if(cValue.charAt(l) != '.') {
    			str = str + cValue.charAt(l);
    		}
    		l++;
    	}
    	
    	var strTien = "";
    	var check = true;
    	for(i=0;i<str.length;i++) {
    		if((str.charAt(i)<'0')||(str.charAt(i)>'9')) {
    			check = false;
    			break;
    		}
    	}
    	if(check == false) {
    		document.getElementById(elementid).value = cValue;
    		return;
    	}
        if (str.length > 3)
        {
            for (i = str.length - 1; i >= 0; i = i - 3)
            {
                var strTemp = "";
                if (i - 2 >= 0)
                {
                    strTemp = str.charAt(i - 2);
                }
                if (i - 1 >= 0)
                {
                    strTemp += str.charAt(i - 1);
                }
                strTien = strTemp + str.charAt(i) + "." + strTien;
            }
            strTien = strTien.substring(0, strTien.length - 1);
        } 
        else
        {
            strTien = cValue;
        }
        document.getElementById(elementid).value = strTien;
    }
    
    function removeProperty(id) {
         var answer = confirm ("Bạn có thực sự muốn xóa không?");
         if (answer) {
             retrieveURL2('ajaxshowproperties.do?removedId=' + id);
         }
    }

    function countTotal() {

        val1 = document.getElementById("costTt91").value;
        val2 = document.getElementById("costDraft").value;
        val3 = document.getElementById("costNotaryOutsite").value;
        val4 = document.getElementById("costOtherDetermine").value;

        if (val1.length > 19 || val2.length > 19 || val3.length > 19 || val4.length > 19) {
            alert('Bạn nhập số tiền quá lớn.')
        } else {
            retrieveURL1('ajaxCalculateTotalCost.do?costTt91=' + val1 + '&costDraft=' + val2
                    + '&costNotaryOutsite=' + val3 + '&costOtherDetermine=' + val4);
        }
    }

    var req;

    function retrieveURL1(url) {
      if (window.XMLHttpRequest) { // Non-IE browsers
        req = new XMLHttpRequest();
        req.onreadystatechange = processStateChange1;
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
          req.onreadystatechange = processStateChange1;
          req.open("GET", url, true);
          req.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
          req.send();
        }
      }
    }

    function processStateChange1() {
      if (req.readyState == 4) { // Complete
        if (req.status == 200) { // OK response
            document.getElementById("costTotal").value = req.responseText;
            changeValue('costTotal');

        } else {
          alert("Problem: " + req.statusText);
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
   
    function retrieveURL6(url) {
    	
        if (window.XMLHttpRequest) { // Non-IE browsers
        	
          req = new XMLHttpRequest();
          req.onreadystatechange = processStateChange6;
          try {
            req.open("GET", url, true);
            req.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
          } catch (e) {
            //alert(e);
          }
          req.send(null);
        } else if (window.ActiveXObject) { // IE
        	
          req = new ActiveXObject("Microsoft.XMLHTTP");
          if (req) {
            req.onreadystatechange = processStateChange6;
            req.open("GET", url, true);
            req.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
            req.send();
            
          }
        }
    }
    
    
    
    function retrieveURL7(url) {
        if (window.XMLHttpRequest) { // Non-IE browsers
          req = new XMLHttpRequest();
          req.onreadystatechange = processStateChange7;
          try {
            req.open("GET", url, true);
            req.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
          } catch (e) {
            //alert(e);
          }
          req.send(null);
        } else if (window.ActiveXObject) { // IE
          req = new ActiveXObject("Microsoft.XMLHTTP");
          if (req) {
            req.onreadystatechange = processStateChange7;
            req.open("GET", url, true);
            req.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
            req.send();
          }
        }
    }
    
    

    function processStateChange6() {
        if (req.readyState == 4) { // Complete
          if (req.status == 200) { // OK response
        	  if (relationObject == 1){
                  $('td.relationobjectlist1').html(req.responseText);
                  
        	  } else if (relationObject == 2) {
        		  $('td.relationobjectlist2').html(req.responseText);  
        	  } else {
        		  $('td.relationobjectlist3').html(req.responseText);
        	  }
              changeDisplayManyProperties();
          } else {
            alert("Problem: " + req.statusText);
          }
        }
       
    }
    
    function processStateChange7() {
        if (req.readyState == 4) { // Complete
          if (req.status == 200) { // OK response
              $('td.checkContractNumber').html(req.responseText);
              changeDisplayManyProperties();
          } else {
            alert("Problem: " + req.statusText);
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

    var selectedKindId = "<bean:write name='contractViewHelper' property='contractKindId'/>";
    if (selectedKindId != "") {
        document.getElementById("contractKindId").value = selectedKindId;
    }

    var aryDesc = new Array();

    <logic:iterate id="item" name="contractViewHelper" property="contractTemplateList" indexId="i">
        aryDesc[<%=i%>] = ["<bean:write name='item' property='kindId'/>", "<bean:write name='item' property='id'/>"
                           , "<bean:write name='item' property='name'/>", "<bean:write name='item' property='relateObjectNumber'/>"
                           , "<bean:write name='item' property='code' filter='false'/>","<bean:write name='item' property='descriptionDisp' filter='false'/>","<bean:write name='item' property='descriptionDisp2' filter='false'/>"
                           , "<bean:write name='item' property='periodFlag'/>", "<bean:write name='item' property='mortageCancelFunc'/>",  "<bean:write name='item' property='relateObjectATitle'/>"
                           , "<bean:write name='item' property='relateObjectBTitle'/>", "<bean:write name='item' property='relateObjectCTitle'/>"];
    </logic:iterate>

    change('contractKindId', 'contractTemplateId', 0);
    
    var selectedTemplateId = "<bean:write name='contractViewHelper' property='contractTemplateId'/>";
    if (selectedTemplateId != "") {
        document.getElementById("contractTemplateId").value = selectedTemplateId;
    }
    
    $('#firstContractNumber').val($('#contractNumber').val());
    var templateid;
    changeTemplate();
    function changeTemplate() {
    	$('#suggestion').hide();
		$('#sharp3').hide();
    	var value = $('#contractTemplateId').val();
    	$('#objectC').hide();
    	for (var i = 0; i < aryDesc.length; i++) {
	    	if (aryDesc[i][1] == value) {
	            var number =  aryDesc[i][3];
	            if (number == 3) {
	            	$('#objectC').show();
	            } else {
	            	$('#objectC').hide();
	            	
	            }
	            var fromTemp = document.getElementById('fromTemporaryContract').value;
	            if (fromTemp == 'false') {
		            if (aryDesc[i][4] != '') {
		            	var date = new Date();
		            	var yy = date.getYear();
		            	var year = (yy < 1000) ? yy + 1900 : yy;
		            	
		            	if ($('#firstContractNumber').val()==("/"+year)){
		              		 $('#contractNumber').val($('#firstContractNumber').val() + "/" + aryDesc[i][4]);
		            	} else {
		            		$('#contractNumber').val($('#firstContractNumber').val());
		            	}
		            }
	            }
	         
	           	if (aryDesc[i][7] == "true") {
	           		$('#period_time').show();
	           	} else {
	            	$('#period_time').hide();
	            	
	            }
	           	
	        	if (aryDesc[i][9]!="") {
	        		$('#relateObjectATitle').text(aryDesc[i][9]);
	    		} else $('#relateObjectATitle').text("Bên A");
	     	   	if (aryDesc[i][10]!="") {
	        		$('#relateObjectBTitle').text(aryDesc[i][10]);
	        	} else $('#relateObjectBTitle').text("Bên B");
	        	if (aryDesc[i][11]!="") {
	        		$('#relateObjectCTitle').text(aryDesc[i][11]);
	        	} else $('#relateObjectCTitle').text("Bên C");
	        	
	            templateid=i;
	            	
	            	
	            	
	            
	            break;
	        } else {
	        	$('#contractNumber').val($('#firstContractNumber').val());
	        	
	        //	$('#suggestion').text()="";
	        }
    	}
    }
    $('#suggestion').hide();
    $('#sharp3').hide();
    function displayDescription() {
    	if (aryDesc[templateid][5]!= '') {
	    	$('#suggestion').show();
	    	$('#sharp3').show();
	    	$('#suggestion').html(aryDesc[templateid][5]);
	    	if (aryDesc[templateid][3] == 2) {
	    		
	    		document.getElementById('suggestion').style.top='370px';
	    		document.getElementById('sharp3').style.top='372px';
	    	} else {
	    		document.getElementById('suggestion').style.top='440px';
	    		document.getElementById('sharp3').style.top='442px';
	    	}
    	} else  {
    		$('#suggestion').hide();
    		$('#sharp3').hide();
        	$('#suggestion').html = "";
    	}
    }
    
    function hideDescription() {
    	
    	if (document.getElementById('showDescriptionState').value != "true") {
	    	$('#suggestion').hide();
	        $('#sharp3').hide();
    	}
    }
    
    function overDescription() {
    	document.getElementById('showDescriptionState').value = "true";
    }
    
    function moveoutDescription() {
        document.getElementById('showDescriptionState').value = "false";
    }
    
    function timedelay(i)
    {
        var t=setTimeout("changeRelation("+i+")",100)

    }
    var relationObject;
    function changeRelation(i) { 	
    	
    	
    	
	    
	    
	    if (i==1){
	    	$('td.relationobjectlist1').show();
	    	relationObject = 1;
	    document.getElementById("keyHighLight1").value = document.getElementById("relationObjectA").value;
	    val = document.getElementById("relationObjectA").value;
	    } else if (i==2) {
	    	$('td.relationobjectlist2').show();
	    	relationObject = 2;
	    	document.getElementById("keyHighLight2").value = document.getElementById("relationObjectB").value;
	    	val = document.getElementById("relationObjectB").value;
	    } else {
	    	$('td.relationobjectlist3').show();
	    	relationObject = 3;
	    	document.getElementById("keyHighLight3").value = document.getElementById("relationObjectC").value;
	    	val = document.getElementById("relationObjectC").value;
	    }
	    	
	    val = removeSign(val);
	    
	    retrieveURL6('ajaxsearchRelation.do?relationObject='+val+"&direction=first");
	    
    }
    
    
    
    function direction(data){
    	if (relationObject==1){
    	val = document.getElementById("relationObjectA").value;
    	} else if (relationObject==2)
    		{
    		val = document.getElementById("relationObjectB").value;
    		} else {
    			val = document.getElementById("relationObjectC").value;
    			}
    	 val = removeSign(val);
    	
        retrieveURL6('ajaxsearchRelation.do?relationObject='+val+"&direction="+data);
        
    }
    
    function getRelation(i) {
     
      // val1 = val1.replace(/[ \\\nn ]+/g, "\n");
     
       if (check!=3) {
       if (relationObject==1){
    	   val =  document.getElementById('relationobjectlist1').querySelector("#customerinfo"+i);
           val1 = val.value.replace("<b>", "");
           val1 = val1.replace("</b>", "");
    	   document.getElementById('relationobjectlist1').style.display="";     	
    	   $("#relationObjectA").val(val1);
       } else if (relationObject==2){
    	   val =  document.getElementById('relationobjectlist2').querySelector("#customerinfo"+i);
           val1 = val.value.replace("<b>", "");
           val1 = val1.replace("</b>", "");
    	   document.getElementById('relationobjectlist2').style.display="";
    	   $("#relationObjectB").val(val1);
       } else {
    	   val =  document.getElementById('relationobjectlist3').querySelector("#customerinfo"+i);
           val1 = val.value.replace("<b>", "");
           val1 = val1.replace("</b>", "");
    	   document.getElementById('relationobjectlist3').style.display="";
    	   $("#relationObjectC").val(val1);
         
       }
       } else {
    	   
    	   if (relationObject==1){
        	   val =  document.getElementById('relationobjectlist1').querySelector("#customerinfo"+i);
               val1 = val.value.replace("<b>", "");
               val1 = val1.replace("</b>", "");
        	   document.getElementById('relationobjectlist1').style.display="";     	
        	   $("#relationObjectA").val(val1);
           } else if (relationObject==2){
        	   index=0;
        	    $('#relationobjectlist2 tr').each(function() {
        	    	
        		   var $tds = $(this).find('td');
        		    if($tds.length != 0) {
        		    var $currText = $tds.eq(0).text();
        		    //alert('Curr Source Language: ' + $currText);
        		    }
        		    if (index==i)
        		    val = $currText;
        		    index++;
        		    });
 
               val1 = val.replace("<b>", "");
               val1 = val1.replace("</b>", "");
               val1 = val1.replace(/^\s+|\s+$/g, '')
               val1 = val1.substring(0,val1.length / 2);
               val1 = val1.replace(/^\s+|\s+$/g, '');
        	   document.getElementById('relationobjectlist2').style.display="";
        	   $("#relationObjectB").val(val1);
           } else {
        	   index=0;
       	    $('#relationobjectlist3 tr').each(function() {
       	    	
       		   var $tds = $(this).find('td');
       		    if($tds.length != 0) {
       		    var $currText = $tds.eq(0).text();
       		    //alert('Curr Source Language: ' + $currText);
       		    }
       		    if (index==i)
       		    val = $currText;
       		    index++;
       		    });

              val1 = val.replace("<b>", "");
              val1 = val1.replace("</b>", "");
              val1 = val1.replace(/^\s+|\s+$/g, '')
              val1 = val1.substring(0,val1.length / 2);
              val1 = val1.replace(/^\s+|\s+$/g, '');
        	   document.getElementById('relationobjectlist3').style.display="";
        	   $("#relationObjectC").val(val1);
             
           }
       }
       
       document.getElementById('relationobjectlist1').style.display="none";
       document.getElementById('relationobjectlist2').style.display="none";
       document.getElementById('relationobjectlist3').style.display="none";
       
      
        }
    
  
    function checkContractNumber() {
    	 val = document.getElementById("contractNumber").value;
    	 if (val.indexOf("%")!=-1) val = val.replace("%","@@@@@");
    	 if (val.indexOf("Đ")!=-1) val = val.replace("Đ","UCHIUCHI");
    	 if (val.indexOf("đ")!=-1) val = val.replace("đ","UMIUMI");
    	
    	 retrieveURL7('ajaxCheckContractNumber.do?contractNumber='+val);
    	 
    	
    }

    additionStatusElement = document.getElementById("additionStatus");
    if (additionStatusElement != null) {
    	changeAdditionStatus();
    }
    function changeAdditionStatus() {
        additionStatus = document.getElementById("additionStatus").checked;
        if (additionStatus) {
            $('tr.additionDescription').show();
        } else {
            $('tr.additionDescription').hide();
        }
    }
    
   
    
    //Script for property
    setPropertyKindEntry();
    changeDisplayProperty();
    function changeDisplayProperty() {
    	var propertyEntryConfig = getCookie("propertyEntryConfig");
    	var value = $('#type option:selected').val();
    	if (propertyEntryConfig == 'true') {
    		$('tr.land').hide();
            $('tr.vehicle').hide();        
            if(value == "01") {
                $('tr.land').show();
                $('#district').show();
                $('tr.propertyInfo').hide();
            } else if(value == "02") {
                $('tr.vehicle').show();
                $('#district').hide();
                $('tr.propertyInfo').hide();
            } else if(value == "99"){
            	 $('#district').hide();
            	$('tr.propertyInfo').show();
            }
    	} else  if(value == "01") {
    		
            $('#district').show();
        } else  $('#district').hide();
    }
    
    function changePropertyKindEntry(value) {
    	$('#isDetailPropertyEntry').val(value);
        setCookie("propertyEntryConfig", value, 365);       
    }
    
    function setPropertyKindEntry() {
    	var propertyEntryConfig = getCookie("propertyEntryConfig");
        if (propertyEntryConfig == null || propertyEntryConfig == "" || propertyEntryConfig == "undefined") {
            propertyEntryConfig = $('#isDetailPropertyEntry').val();
            setCookie("propertyEntryConfig", propertyEntryConfig, 365);
        } else {
        	$('#isDetailPropertyEntry').val(propertyEntryConfig);
        }
        
    	if (propertyEntryConfig == 'true') {
    		changeDisplayProperty();
    		$('tr.detailEntry').show();
    		$('a.simpleEntry').show();
    		$('a.detailEntry').hide();
    	} else {
    		$('tr.land').hide();
            $('tr.vehicle').hide();  
    		$('tr.detailEntry').hide();
    		$('a.simpleEntry').hide();
    		$('a.detailEntry').show();
    		$('tr.propertyInfo').show();
    	}
    }
    
    setSearchState();    
    function changeSearchState() {
    	var otherInfoConfig = getCookie("otherInfoConfig");
        if (otherInfoConfig == "true") {
        	setCookie("otherInfoConfig", "false", 365);
        } else {
        	setCookie("otherInfoConfig", "true", 365);
        }
    }
    
    function setSearchState() {
        //var val = document.getElementById("isHidePanelSearch").value;
        var otherInfoConfig = getCookie("otherInfoConfig");
        if (otherInfoConfig == null || otherInfoConfig == "" || otherInfoConfig == "undefined") {
        	otherInfoConfig = $('#isHidePanelSearch').val();
        	setCookie("otherInfoConfig", otherInfoConfig, 365);
        }
        if (otherInfoConfig == "true") {
            $('#searchOption').removeClass('tree_open');
            $('#searchOption').addClass('tree_close');
            $('#searchField').removeClass('fieldset_open');
            $('#searchField').addClass('fieldset_close');
            $('#otherInformation').hide();
        } else {
            $('#searchOption').removeClass('tree_close');
            $('#searchOption').addClass('tree_open');
            $('#searchField').removeClass('fieldset_close');
            $('#searchField').addClass('fieldset_open');
            $('#otherInformation').show();
        }
    }
    
    //Cookie
    function getCookie(c_name)
	{
		var i, x, y, ARRcookies = document.cookie.split(";");
		for (i = 0;i < ARRcookies.length; i++) {
		  x = ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
		  y = ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
		  x = x.replace(/^\s+|\s+$/g,"");
		  if (x == c_name) {
		    return unescape(y);
		  }
		}
	}

    function setCookie(c_name, value, exdays) {
		var exdate = new Date();
		exdate.setDate(exdate.getDate() + exdays);
		var c_value = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toUTCString());
		document.cookie=c_name + "=" + c_value;
	}
   
    function getDescription() {
    	
    	$('#contractSummary').val(aryDesc[templateid][6]);
    	
    	$('#suggestion').hide();
        $('#sharp3').hide();
        document.getElementById('showDescriptionState').value = "false";
        
        document.getElementById('contractSummary').focus();
    }
    
   
    

</script>