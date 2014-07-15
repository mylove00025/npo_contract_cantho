<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.servletsuite.com/servlets/tooltip" prefix="t" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>    
    <logic:equal value="true" name="contractViewHelper" property="fromContractList">
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
                    <html:link href="contractlistback.do">Danh sách hợp đồng</html:link>                  
                </li>
                <li>
                    <span> &gt; </span>
                    <html:link href="#">Chi tiết hợp đồng công chứng</html:link>
                </li>
            </ul>
        </div>
     </logic:equal>
     <logic:equal value="false" name="contractViewHelper" property="fromContractList">
    <div id="navigator">
            <ul class="clearfix"> 
                <li>
                    <html:img alt="*" src="./image/bullet_square.gif"/>
                </li>           
                <li>
                    <html:link href="preventlistview.do">Tra cứu dữ liệu ngăn chặn</html:link>
                </li>
                <li>
                    <span> &gt; </span>
                    <html:link href="#">Chi tiết hợp đồng công chứng</html:link>
                </li>
            </ul>
        </div>    
    </logic:equal>
    <%@ include file="/jsp/common/error_message.jsp" %>
    <html:form action="contractdetailview">
	    <html:hidden styleId="isHidePanelInfo" property="isHidePanelInfo" name="contractForm"/>
	    <table width="100%" class="tbl-non-border" style="margin: 10px 0 0 20px;">
	    <tr>
           <td>
		    <div style="border: none; width: 80%;">
	        <div id="infoShow" class="sub-title">
	        <span class="tree_open" id="infoOption" style="cursor: pointer;" onclick="changeInfoState(); setInfoState();"></span>
	        <strong class="onmouseover" onclick="changeInfoState(); setInfoState();">Thông tin hợp đồng</strong>
	        </div>
            <table id="contractInformation" class="tbl-detail" style="width:95%">
	           <tr>
                    <th nowrap="nowrap">Nhóm hợp đồng</th>  
                    <td colspan="3">
                        <bean:write name="contractViewHelper" property="contractKindName"/>                    
                    </td>
                </tr>            
	            <tr>
	                <th nowrap="nowrap">Tên hợp đồng</th>  
	                <td colspan="3">
	                    <bean:write name="contractViewHelper" property="contractTemplateName"/>                    
	                </td>
	            </tr>
	            <tr>
	                <th nowrap="nowrap">Số hợp đồng</th>   
	                <td colspan="3">
	                    <bean:write name="contractViewHelper" property="contractNumber"/>    
	                </td>
	            </tr>
	            <tr>
	            <%-- <logic:equal value="1" name="CommonContext" property="contractReceiveDate">
                    <th nowrap="nowrap">Ngày thụ lý</th>  
                    <td width="230px">
                        <bean:write name="contractViewHelper" property="receivedDate" format="dd/MM/yyyy"/>
                    </td>
                    <th nowrap="nowrap">Ngày công chứng</th>    
                    <td width="230px">
                     <bean:write name="contractViewHelper" property="notaryDate" format="dd/MM/yyyy"/>
                    </td>
                </logic:equal> --%>
                <th nowrap="nowrap">Ngày công chứng</th>    
                <td>
                    <bean:write name="contractViewHelper" property="notaryDate" format="dd/MM/yyyy"/>
                </td>
                </tr>
                <tr>
                <%-- <logic:equal value="1" name="CommonContext" property="contractDrafter">
                    <th nowrap="nowrap">Chuyên viên soạn thảo</th>
                    <td>
                       <bean:write name="contractViewHelper" property="drafterFamilyName"/>
                       <bean:write name="contractViewHelper" property="drafterFirstName"/>
                    </td>
                    <th nowrap="nowrap">Công chứng viên</th>   
                    <td>
                       <bean:write name="contractViewHelper" property="notaryFamilyName"/>
                       <bean:write name="contractViewHelper" property="notaryFirstName"/>
                    </td>
                 </logic:equal> --%>
                 <th nowrap="nowrap">Công chứng viên</th>   
                 <td>
                    <%-- HungPT 03/06/2014
                    <bean:write name="contractViewHelper" property="notaryFamilyName"/>
                    <bean:write name="contractViewHelper" property="notaryFirstName"/>
                    --%>
                    <bean:write name="contractViewHelper" property="crediterName"/>
                    <!-- End HungPT 03/06/2014  -->
                 </td>
                </tr>
	            <tr>
	                <th nowrap="nowrap"><bean:write name="contractViewHelper" property="relateObjectATitle" filter="false"/></th>
	                <td colspan="3">
	                   <bean:write name="contractViewHelper" property="relationObjectA" filter="false"/>
	                </td>
	            </tr>
	            <tr>
	                <th nowrap="nowrap"><bean:write name="contractViewHelper" property="relateObjectBTitle" filter="false"/></th> 
	                <td colspan="3">
                        <bean:write name="contractViewHelper" property="relationObjectB" filter="false"/>
	                </td>
	            </tr>
	            <logic:equal value="3" name="contractViewHelper" property="relateObjectNumber">
		            <tr>
		                <th nowrap="nowrap"><bean:write name="contractViewHelper" property="relateObjectCTitle" filter="false"/></th>    
		                <td colspan="3">
		                   <bean:write name="contractViewHelper" property="relationObjectC" filter="false"/>
		                </td>
		            </tr>
	            </logic:equal>
	            <tr>
                    <th nowrap="nowrap">Tóm tắt nội dung hợp đồng</th>
                    <td colspan="3">
                        <bean:write name="contractViewHelper" property="contractSummary" filter="false"/>
                    </td>
                </tr>
                <%-- 
                <logic:equal value="true" name="contractViewHelper" property="contractPeriodFlag">
                   <tr>
	                    <th nowrap="nowrap">Thời hạn</th>
	                    <td colspan="3">
	                        <bean:write name="contractViewHelper" property="contractPeriod" filter="false"/>
	                    </td>
                	</tr>
                </logic:equal>
                <logic:equal value="1" name="CommonContext" property="contractValue">
	            <tr>
	                <th nowrap="nowrap">Giá trị hợp đồng</th>  
	                <td colspan="3">
	                   <logic:notEmpty name="contractViewHelper" property="contractValue">
		                   <bean:write name="contractViewHelper" property="contractValue"/>
		                   <label style="font-weight:normal">VNĐ</label>
	                   </logic:notEmpty>
	                </td>
	            </tr>
	            </logic:equal>
	            <logic:equal value="1" name="CommonContext" property="contractNotaryPlace">
	            <tr>
	                <th nowrap="nowrap">Địa điểm công chứng</th>
	                <td colspan="3">
		                <logic:notEqual value="true" name="contractViewHelper" property="notaryPlaceFlag">
	                    <logic:notEmpty name="contractViewHelper" property="notaryPlace">
	                        <bean:message key="item_external_place"/> (<bean:write name="contractViewHelper" property="notaryPlace"/>)
	                    </logic:notEmpty>
	                    <logic:empty name="contractViewHelper" property="notaryPlace">
	                        <bean:message key="item_external_place"/>
	                    </logic:empty>
	                    </logic:notEqual>
	                    <logic:equal value="true" name="contractViewHelper" property="notaryPlaceFlag">
	                       <bean:message key="item_internal_place"/>
	                    </logic:equal>
	                </td>
	            </tr>
	            </logic:equal>
	            <logic:equal value="1" name="CommonContext" property="contractUserRequire">
	            <tr>
                <th nowrap="nowrap">Người yêu cầu công chứng</th>
                <td colspan="3">
                    <bean:write name="contractViewHelper" property="userRequireContract"/>
                </td>
                </tr>
                </logic:equal>
                <logic:equal value="true" name="contractViewHelper" property="mortageCancelDisplayFlag">
                 <th nowrap="nowrap">Giải chấp</th>
                 <logic:equal value="true" name="contractViewHelper" property="mortageCancelFlag">
                 	<td colspan="3">Đã giải chấp ngày <bean:write property="mortageCancelDate" name="contractViewHelper"  filter="false"/><br/>
                 	<bean:write property="mortageCancelNote" name="contractViewHelper"/>
                 	 </td>
                 </logic:equal>
                  <logic:equal value="false" name="contractViewHelper" property="mortageCancelFlag">
                  	<td colspan="3">
                  	Chưa giải chấp
                  	</td>
                  </logic:equal>
                </logic:equal>
                <tr>
                
                </tr> --%>
	        </table>
	       </div>
          </td>
         </tr>
       <%-- <tr>
       <td>
       <html:hidden styleId="isHidePropertyPanelInfo" property="isHidePropertyPanelInfo" name="contractForm"/>
         <div style="border: none; width: 80%;">
         <div id="propertyShow" class="sub-title">
	         <span class="tree_open" id="propertyInfoOption" style="cursor: pointer;" onclick="changePropertyInfoState(); setPropertyInfoState();"></span>
	         <strong class="onmouseover" onclick="changePropertyInfoState(); setPropertyInfoState();">Thông tin tài sản trong hợp đồng</strong>
         </div>
         <table id="propertyInformation" style="width:100%">
            <tr>
	            <td>
		            <table class="tbl-detail" style="width:95%">
		            <tr class="noProperty">
		                <th>Thông tin tài sản</th>
		                <td>Không có tài sản kèm theo</td>                    
		            </tr> 
		            </table>
		            <table class="tbl-detail" style="width:95%">
			            <tr class="oneProperty" id="propertyType_tr">
				            <th>Loại tài sản</th>
				            <td>
				                 <span id="propertyTypeName"></span>
				            </td>
			            </tr>
			            <logic:equal value="01" property="type" name="contractViewHelper">
			            	<logic:notEmpty property="propertyInfo" name="contractViewHelper">
			            	<logic:notEmpty property="landDistrict" name="contractViewHelper">
				             <tr id="landArea">
					            <th>Địa bàn</th>
					            <td>
					           		<bean:write property="landStreet" name="contractViewHelper"/>
					         			<logic:notEmpty property="landStreet" name="contractViewHelper">
					               		- 
					               		</logic:notEmpty><bean:write property="landDistrict" name="contractViewHelper"/> 
					            </td>
				            </tr>
				            </logic:notEmpty>
				            </logic:notEmpty>
			            </logic:equal>
			            <tr class="oneProperty" id="propertyType_tr">
			            <th>Thông tin tài sản</th>
			                <td>
			                    <bean:write name="contractViewHelper" property="propertyInfo"/>
			               
			                </td>
			            </tr>
		            </table>
	            </td>
            </tr>
            </table>
          </div>  
       </td>
       </tr>
       
       <tr>
       <td>
       		<html:hidden styleId="isHidePanelAppendix" property="isHidePanelAppendix" name="contractForm"/>
			<logic:notEmpty name="contractAppendixListViewHelper" property="contractList">
			
			<div style="border: none; width: 80%;">
         <div id="appendixShow" class="sub-title">
	         <span class="tree_open" id="appendixOption" style="cursor: pointer;" onclick="changeAppendixState(); setAppendixState();"></span>
	         <strong class="onmouseover" onclick="changeAppendixState(); setAppendixState();">Phụ lục hợp đồng</strong>
         </div>
			
				<table id="contractList" style="width: 600px; margin: 10px 0 0 20px;" class="tbl-list">

					<logic:iterate id="item" name="contractAppendixListViewHelper"
						property="contractList" indexId="i">
						<tr class="tbl-row<%=i % 2%>">
						<td style="text-align: left;"><html:link
							action="/contractdetailview.do" paramId='id' paramName='item'
							paramProperty='id'>
							<bean:write name="item" property="contractNumber" />
						</html:link></td>
						<td style="text-align: left;">
						<bean:write name="item" property="contractTemplateName"/><br/>
						<bean:write name="item" property="contractSummary"/>
						
						</td>
						
						</tr>
					</logic:iterate>

				</table>
				</div>
			</logic:notEmpty>
			</td>			
		</tr> --%>
		
      
       </table>
       <%-- <fieldset id="searchField" class="fieldsetstyle">
       <legend id="searchShow" class="sub-title">
	       <span class="tree_open" id="searchOption" style="cursor: pointer; margin-left: 2px;" onclick="changeSearchState(); setSearchState();"></span>
	       <strong class="onmouseover" onclick="changeSearchState(); setSearchState();">Thông tin khác</strong>
       </legend>
       <html:hidden styleId="isHidePanelSearch" property="isHidePanelSearch" name="contractForm"/>
       <table id="otherContractInformation" width="100%">
       <logic:equal value="true" name="contractViewHelper" property="contractStatus">
       <tr>
       <td width="100%" colspan="2">
          <strong><span>&nbsp;&nbsp;&nbsp;Tình trạng hợp đồng</span></strong>
            <table class="tbl-detail" style="width:98%;">
                <logic:equal value="1" name="CommonContext" property="supplementContractFunction">
	                <logic:equal value="true" name="contractViewHelper" property="additionStatus">
		                <tr>
			                <th nowrap="nowrap" style="color: #0070C0;">
	                            <html:img style="vertical-align: middle;" title="Hợp đồng cần bổ sung hồ sơ" src="./image/icon_addition_contract.png" alt="Hợp đồng cần bổ sung hồ sơ" />		                    
			                    Hợp đồng cần bổ sung hồ sơ
			                </th>
			                <td>
			                    <bean:write name="contractViewHelper" property="additionDescription"/>
			                </td>
		                </tr>
	                </logic:equal>
                </logic:equal>
                <logic:equal value="1" name="CommonContext" property="contractErrorStatus">
                <logic:equal value="true" name="contractViewHelper" property="errorStatus">
                    <tr>
                        <th nowrap="nowrap" style="color: #E46D0A;">
                            <html:img style="vertical-align: middle;" title="Hợp đồng lỗi" src="./image/icon_error_contract.png" alt="Hợp đồng lỗi" />
                            Hợp đồng lỗi
                        </th>
                        <td>
                            <logic:notEmpty name="contractViewHelper" property="errorDescription">
                                Nội dung: <bean:write name="contractViewHelper" property="errorDescription"/>
                            </logic:notEmpty>
                            <logic:notEqual value="00" name="contractViewHelper" property="errorAgent">
                                <br/>                            
                                Người gây lỗi: <bean:write name="contractViewHelper" property="errorUserFamilyName"/>
                                           <bean:write name="contractViewHelper" property="errorUserFirstName"/>
                            </logic:notEqual>
                        </td>
                    </tr>
                </logic:equal>
                </logic:equal>
                <logic:equal value="true" name="contractViewHelper" property="cancellationStatus">
                    <tr>
                        <th nowrap="nowrap" style="color: #7F7F7F;">
                            <html:img style="vertical-align: middle;" title="Hợp đồng hủy" src="./image/icon_cancellation_contract.png" alt="Hợp đồng hủy" />
                            Hợp đồng đã hủy
                        </th>
                        <td>
                            <bean:write name="contractViewHelper" property="cancellationDescription"/>
                        </td>
                    </tr>
                </logic:equal>
            </table>
            <br />
       </td>
       </tr>       
       </logic:equal>
		
		<tr>
       <td width="50%">
         <strong><span>&nbsp;&nbsp;&nbsp;Ngân hàng</span></strong> 
         <table class="tbl-detail" style="width:95%">           
          <tr>
              <th nowrap="nowrap">Tên ngân hàng</th> 
              <td>
                 <bean:write name="contractViewHelper" property="bankName"/>
              </td>
          </tr>
          <%if (context.isBankReport()) {%>
          <tr>
              <th nowrap="nowrap">Cán bộ tín dụng</th>   
              <td>
              <bean:write name="contractViewHelper" property="crediterName"/>
              </td>
          </tr>            
          <tr>
              <th nowrap="nowrap">Chiết khấu</th>    
              <td>
                 <logic:notEmpty name="contractViewHelper" property="bankServiceFee">
                  <bean:write name="contractViewHelper" property="bankServiceFee"/>                  
                  <label style="font-weight:normal">VNĐ</label>
                 </logic:notEmpty>
              </td>
          </tr>
          <%}%>
         </table>  
         <br/>
            <strong><span>&nbsp;&nbsp;&nbsp;Thông tin lưu trữ</span></strong>
            <table class="tbl-detail" style="width:95%">
            <tr>
                <th nowrap="nowrap">Số tờ / trang hợp đồng</th>
                <td>
                    <bean:write name="contractViewHelper" property="numberOfPage"/>
                </td>
            </tr>
            <tr>
                <th nowrap="nowrap">Số bản công chứng</th>
                <td>
                    <bean:write name="contractViewHelper" property="numberCopyOfContract"/>
                </td>
            </tr>
            <tr>
	            <th nowrap="nowrap">File đính kèm</th>            
	             <td class="fileExist">                     
                 <logic:notEqual value="--" name="contractViewHelper" property="filePath">
                       <html:link href="javascript:download();">
                           <bean:write name="contractViewHelper" property="fileNameDisp"/>
                       </html:link>
                    </logic:notEqual>
                    <logic:equal value="--" name="contractViewHelper" property="filePath">
                       <bean:write name="contractViewHelper" property="fileNameDisp"/>
                    </logic:equal>
                </td>
             </tr>
            <tr>
                <th nowrap="nowrap">Nơi lưu trữ bản gốc</th>   
                <td>
                    <bean:write name="contractViewHelper" property="originalStorePlace"/>
                 </td>
            </tr>
            <tr>
                <th nowrap="nowrap">Người nhập hợp đồng</th>   
                <td>
                    <bean:write name="contractViewHelper" property="entryUserName"/>
                    - Ngày
                    <bean:write name="contractViewHelper" property="entryDateTime"/>
                 </td>
            </tr>
            <tr>
                <th nowrap="nowrap">Người sửa cuối cùng</th>   
                <td>
                    <bean:write name="contractViewHelper" property="updateUserName"/>
                    - Ngày
                    <bean:write name="contractViewHelper" property="updateDateTime"/>
                 </td>
            </tr>
            </table> 
            <br/> 
         </td>
       <td valign="top" width="50%">
         <strong><span>&nbsp;&nbsp;&nbsp;Thu phí</span></strong>   
         <table class="tbl-detail" style="width:96%">            
          <tr>
              <th nowrap="nowrap">Thù lao theo thông tư 91</th>   
              <td>
               <logic:notEmpty name="contractViewHelper" property="costTt91">
                <bean:write name="contractViewHelper" property="costTt91"/>
                <label style="font-weight:normal">VNĐ</label>
               </logic:notEmpty>
              </td>
          </tr>
          <tr>
              <th nowrap="nowrap">Thù lao soạn thảo</th> 
              <td>
               <logic:notEmpty name="contractViewHelper" property="costDraft">
                <bean:write name="contractViewHelper" property="costDraft"/>
                <label style="font-weight:normal">VNĐ</label>
               </logic:notEmpty>
              </td>
          </tr>
          <tr>
              <th nowrap="nowrap">Dịch vụ công chứng ngoài</th>  
              <td>
               <logic:notEmpty name="contractViewHelper" property="costNotaryOutsite">
                <bean:write name="contractViewHelper" property="costNotaryOutsite"/>
                <label style="font-weight:normal">VNĐ</label>
               </logic:notEmpty>
              </td>
          </tr>
          <tr>
              <th nowrap="nowrap">Dịch vụ xác minh khác</th> 
              <td>
                <logic:notEmpty name="contractViewHelper" property="costOtherDetermine">
               <bean:write name="contractViewHelper" property="costOtherDetermine"/>
               <label style="font-weight:normal">VNĐ</label>
             </logic:notEmpty>
              </td>
          </tr>
          <tr>
              <th style="font-weight:bold" nowrap="nowrap">Tổng phí</th>
              <td>
                <logic:notEmpty name="contractViewHelper" property="costTotal">
                  <bean:write name="contractViewHelper" property="costTotal"/>
                  <label style="font-weight:normal">VNĐ</label>
                </logic:notEmpty>
              </td>
          </tr>
          </table>
          <br/>
          <strong><span>&nbsp;&nbsp;&nbsp;Ghi chú</span></strong>
            <table class="tbl-detail" style="width:96%;">
            <tr>
                <td>
                    <logic:notEmpty name="contractViewHelper" property="contractNote">
                        <bean:write name="contractViewHelper" property="contractNote" filter="false"/>
                    </logic:notEmpty>
                    <logic:empty name="contractViewHelper" property="contractNote">
                        &nbsp;
                    </logic:empty>
                </td>
            </tr>
            </table>
            <br/>
       </td>
       </tr>
        </table>
       </fieldset> --%>
       <table width="80%" class="tbl-non-border" style="margin: 10px 0 0 20px;">
          <tr>
             <td colspan="2" style="text-align: center; padding: 10px;">
                 <logic:equal value="true" name="contractViewHelper" property="fromContractList">
                  <logic:equal value="true" name="CommonContext" property="contractManagement">
                      <html:link href="javascript: update();">
                          <img alt="Chỉnh sửa" src="./image/btn_edit.png"/>
                      </html:link>
                      
	                      <%-- <html:link href="javascript: createcopy()">
		                      <html:img alt="Tạo bản sao" src="./image/btn_saochephd.png"/>
		                  </html:link> --%>
		                 
                  </logic:equal>                 
                 <logic:equal value="true" name="contractViewHelper" property="fromRegistScreen">                        
                    <html:link href="contractregistview.do">
                        <img alt="Tiếp tục thêm mới" src="./image/btn_continue_add.png"/>
                    </html:link>
                 </logic:equal>
                  <logic:equal value="true" name="CommonContext" property="contractDelete">
		                 <html:link href="javascript: remove()">
		                     <html:img alt="Xóa hợp đồng" src="./image/btn_delete.png"/>
		                 </html:link>
	               </logic:equal>
                 <logic:equal value="true" name="CommonContext" property="contractManagement">
	               
	                 <logic:notEqual value="true" name="contractViewHelper" property="cancellationStatus">
		                  <html:link href="javascript: cancellation()">
		                      <html:img alt="Huỷ hợp đồng" src="./image/btn_cancellation.png"/>
		                  </html:link>
	                 </logic:notEqual>
	                 
	                 
		                  <%-- <html:link href="javascript: createappendix()">
		                      <html:img alt="Tạo phụ lục" src="./image/btn_appendix.png"/>
		                  </html:link> --%>
	             
                 </logic:equal>
                 </logic:equal>
                 <logic:equal value="true" name="contractViewHelper" property="fromContractList">
                  <html:link href="contractlistback.do">
                      <html:img alt="Quay lại danh sách" src="./image/btn_list_back.png"/>
                  </html:link>
                 </logic:equal>
                 <logic:equal value="false" name="contractViewHelper" property="fromContractList">
                  <html:link href="preventlistback.do">
                      <html:img alt="Quay lại danh sách" src="./image/btn_list_back.png"/>
                  </html:link>
                 </logic:equal>
             </td>
         </tr>
         </table>       
       <div id="popupContact">
	       <a id="popupContactClose">x</a>
	       <span class="contactArea"></span>            
       </div>
        <div id="backgroundPopup"></div>
            <html:hidden name="contractViewHelper" property="fromContractList" styleId="hiddenfromContractList"/>
            <html:hidden name="contractViewHelper" property="type" styleId="hiddenPropertyType"/>
            <html:hidden name="contractViewHelper" property="numberProperty" styleId="hasOnePropertyFlag"/>            
    </html:form>
    <%@ include file="/jsp/common/footer.jsp" %>
</html:html>  

<script type="text/javascript">

    var fromContract = $('#hiddenfromContractList').val();
    if(fromContract == 'true') {
	    $('#contract > em').removeClass("contract-off");
	    $('#contract > em').addClass("contract-on");
	    $('#contract > b').addClass("menu-on");
    } else {
    	$('#sub-menu').hide();
    	$('#preventTab > em').removeClass("menu-block-contract-off");
        $('#preventTab > em').addClass("menu-block-contract-on");
        $('#preventTab > b').addClass("menu-on");
    }
    
    function update() {
        document.contractForm.action="contractupdateview.do?id=" + "<bean:write name='contractViewHelper' property='contractId'/>";
        document.contractForm.submit();
        return true;
    }
    
    function cancellation() {
        document.contractForm.action="contractregistforcancellation.do?contractid=" + "<bean:write name='contractViewHelper' property='contractId'/>";
        document.contractForm.submit();
        return true;
    }
    
    function createappendix() {
        document.contractForm.action="contractcreateappendix.do?contractid=" + "<bean:write name='contractViewHelper' property='contractId'/>";
        document.contractForm.submit();
        return true;
    }
    
    function download() {
        document.contractForm.action='downloadcontractdetail.do';
        document.contractForm.submit();
    }
    
    function remove() {
        var answer = confirm ("Bạn có thực sự muốn xóa hợp đồng không?");
        if (answer) {
            document.contractForm.action="contractdetailremove.do";
            document.contractForm.submit();
            return true;
        }        
    }
    
    changeNumberProperty();
    function changeNumberProperty() {
        if ($('#hasOnePropertyFlag').val() == "1") {
            document.contractForm.numberProperty.value = "1";
            $('tr.noProperty').hide();
            $('tr.oneProperty').show();            
            changeDisplayOneProperty();
        } else if ($('#hasOnePropertyFlag').val() == "2") {
            document.contractForm.numberProperty.value = "2";
            $('tr.noProperty').hide();
            $('tr.oneProperty').hide();            
        } else {
        	document.contractForm.numberProperty.value = "0";
        	$('#landArea').hide();
        	$('tr.noProperty').show();
            $('tr.oneProperty').hide();            
        }
    }
    
    function changeDisplayOneProperty() {
        $('.vehicles').hide();
        $('.land').hide();
        $('.other').hide();    
        var value = $('#hiddenPropertyType').val();
        if(value == '02') {
            $('.vehicles').show();
            $('#propertyTypeName').html('Ô tô, xe máy');
        } else if(value == '03') {
            $('.vehicles').show();
            $('#propertyTypeName').html('Ô tô, xe máy');
        } else if(value == '01') {
            $('.land').show();   
            $('#propertyTypeName').html('Nhà đất');
        } else if(value == '99') {
            $('.other').show();
            $('#propertyTypeName').html('Tài sản khác');
        } else if(value == '00') {
            $('#propertyTypeName').html('Chưa phân loại tài sản');
        } else {
        	$('#propertyTypeName').html('Không có thông tin tài sản trong hợp đồng');
        }        
    }
    
    function changeProperty(value) {
        changeDisplayOneProperty();
    }
    
    function showDetail(id) {
    	retrieveURL('ajaxshowpropertydetail.do?selectedId=' + id);
        centerPopup();
        //load popup
        loadPopup();        
    }
           
    var req;
    var which;   
    
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
              $('span.contactArea').html(req.responseText);
          } else {
            alert("Problem: " + req.statusText);
          }
        }
    }
    
    setSearchState();
    
    function changeSearchState() {
        var val = document.getElementById("isHidePanelSearch").value;
        if (val == "true") {
            document.contractForm.isHidePanelSearch.value = "false";
        } else {
            document.contractForm.isHidePanelSearch.value = "true";
        }
    }
    
    function setSearchState() {
        var val = document.getElementById("isHidePanelSearch").value;
        if (val == "true") {
            $('#searchOption').removeClass('tree_open');
            $('#searchOption').addClass('tree_close');
            $('#searchField').removeClass('fieldset_open');
            $('#searchField').addClass('fieldset_close');
            $('#otherContractInformation').hide();
        } else {
            $('#searchOption').removeClass('tree_close');
            $('#searchOption').addClass('tree_open');
            $('#searchField').removeClass('fieldset_close');
            $('#searchField').addClass('fieldset_open');
            $('#otherContractInformation').show();
        }
    }
    
    setInfoState();
    
    function changeInfoState() {
        var val = document.getElementById("isHidePanelInfo").value;
        if (val == "true") {
            document.contractForm.isHidePanelInfo.value = "false";
        } else {
            document.contractForm.isHidePanelInfo.value = "true";
        }
    }
    
    function setInfoState() {
        var val = document.getElementById("isHidePanelInfo").value;
        if (val == "true") {
            $('#infoOption').removeClass('tree_open');
            $('#infoOption').addClass('tree_close');
            $('#contractInformation').hide();
        } else {
            $('#infoOption').removeClass('tree_close');
            $('#infoOption').addClass('tree_open');
            $('#contractInformation').show();
        }
    }
    
    setPropertyInfoState();
    
    function changeAppendixState() {
        var val = document.getElementById("isHidePanelAppendix").value;
        if (val == "true") {
            document.contractForm.isHidePanelAppendix.value = "false";
        } else {
            document.contractForm.isHidePanelAppendix.value = "true";
        }
    }
    
    function setAppendixState() {
        var val = document.getElementById("isHidePanelAppendix").value;
        if (val == "true") {
            $('#appendixOption').removeClass('tree_open');
            $('#appendixOption').addClass('tree_close');
            $('#contractList').hide();
        } else {
            $('#appendixOption').removeClass('tree_close');
            $('#appendixOption').addClass('tree_open');
            $('#contractList').show();
        }
    }
    
    setAppendixState();
    
    function changePropertyInfoState() {
        var val = document.getElementById("isHidePropertyPanelInfo").value;
        if (val == "true") {
            document.contractForm.isHidePropertyPanelInfo.value = "false";
        } else {
            document.contractForm.isHidePropertyPanelInfo.value = "true";
        }
    }
    
    function setPropertyInfoState() {
        var val = document.getElementById("isHidePropertyPanelInfo").value;
        if (val == "true") {
            $('#propertyInfoOption').removeClass('tree_open');
            $('#propertyInfoOption').addClass('tree_close');
            $('#propertyInformation').hide();
        } else {
            $('#propertyInfoOption').removeClass('tree_close');
            $('#propertyInfoOption').addClass('tree_open');
            $('#propertyInformation').show();
        }
    }
    
    function createcopy() {
        document.contractForm.action="contractcreatecopy.do?id=" + "<bean:write name='contractViewHelper' property='contractId'/>";
        document.contractForm.submit();
        return true;
    }
</script>