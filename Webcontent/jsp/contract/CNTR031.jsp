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
                    <html:link href="temporarycontractlistview.do">Danh sách hợp đồng chờ ký</html:link>                  
                </li>
                <li>
                    <span> &gt; </span>
                    <html:link href="#">Chi tiết hợp đồng chờ ký</html:link>
                </li>
            </ul>
        </div>
    
    <%@ include file="/jsp/common/error_message.jsp" %>
    <html:form action="temporarycontractdetailview">
	    <html:hidden styleId="isHidePanelInfo" property="isHidePanelInfo" name="temporaryContractForm"/>
	    <table width="100%" class="tbl-non-border" style="margin: 5px 0 0 20px;">
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
                        <bean:write name="temporaryContractViewHelper" property="contractKindName"/>                    
                    </td>
                </tr>            
	            <tr>
	                <th nowrap="nowrap">Tên hợp đồng</th>  
	                <td colspan="3">
	                    <bean:write name="temporaryContractViewHelper" property="contractTemplateName"/>                    
	                </td>
	            </tr>
	            <tr>
	                <th nowrap="nowrap">Số hợp đồng</th>   
	                <td colspan="3">
	                    <bean:write name="temporaryContractViewHelper" property="contractNumber"/>    
	                </td>
	            </tr>
	            <tr>
	            <logic:equal value="1" name="CommonContext" property="contractReceiveDate">
                    <th nowrap="nowrap">Ngày thụ lý</th>  
                    <td width="230px">
                        <bean:write name="temporaryContractViewHelper" property="receivedDate" format="dd/MM/yyyy"/>
                    </td>
                    <th nowrap="nowrap">Ngày công chứng</th>    
                    <td width="230px">
                     	<bean:write name="temporaryContractViewHelper" property="notaryDate" format="dd/MM/yyyy"/>
                    </td>
                </logic:equal>
                <logic:notEqual value="1" name="CommonContext" property="contractReceiveDate">
                    <th nowrap="nowrap">Ngày công chứng</th>    
                    <td colspan="3">
                        <bean:write name="temporaryContractViewHelper" property="notaryDate" format="dd/MM/yyyy"/>
                    </td>
                </logic:notEqual>
                </tr>
                <tr>
                <logic:equal value="1" name="CommonContext" property="contractDrafter">
                    <th nowrap="nowrap">Chuyên viên soạn thảo</th>
                    <td>
                       <bean:write name="temporaryContractViewHelper" property="drafterName"/>
                    </td>
                    <th nowrap="nowrap">Công chứng viên</th>   
                    <td>
                       <bean:write name="temporaryContractViewHelper" property="notaryName"/>
                    </td>
                 </logic:equal>
                 <logic:notEqual value="1" name="CommonContext" property="contractDrafter">
                    <th nowrap="nowrap">Công chứng viên</th>   
                    <td colspan="3">
                       <bean:write name="temporaryContractViewHelper" property="notaryFamilyName"/>
                       <bean:write name="temporaryContractViewHelper" property="notaryFirstName"/>
                    </td>
                 </logic:notEqual>   
                </tr>
	            <tr>
	                <th nowrap="nowrap">Bên A</th>
	                <td colspan="3">
	                   <bean:write name="temporaryContractViewHelper" property="relationObjectADisp" filter="false"/>
	                </td>
	            </tr>
	            <tr>
	                <th nowrap="nowrap">Bên B</th> 
	                <td colspan="3">
                        <bean:write name="temporaryContractViewHelper" property="relationObjectBDisp" filter="false"/>
	                </td>
	            </tr>
	            <logic:notEmpty name="temporaryContractViewHelper" property="relationObjectC">
		            <tr>
		                <th nowrap="nowrap">Bên C</th>    
		                <td colspan="3">
		                   <bean:write name="temporaryContractViewHelper" property="relationObjectCDisp" filter="false"/>
		                </td>
		            </tr>
	            </logic:notEmpty>
	            <tr>
                    <th nowrap="nowrap">Tóm tắt nội dung hợp đồng</th>
                    <td colspan="3">
                        <bean:write name="temporaryContractViewHelper" property="contractSummaryDisp" filter="false"/>
                    </td>
                </tr>
                <logic:equal value="1" name="CommonContext" property="contractValue">
	            <tr>
	                <th nowrap="nowrap">Giá trị hợp đồng</th>  
	                <td colspan="3">
	                   <logic:notEmpty name="temporaryContractViewHelper" property="contractValue">
		                   <bean:write name="temporaryContractViewHelper" property="contractValue"/>
		                   <label style="font-weight:normal">VNĐ</label>
	                   </logic:notEmpty>
	                </td>
	            </tr>
	            </logic:equal>
	            <logic:equal value="1" name="CommonContext" property="contractNotaryPlace">
	            <tr>
	                <th nowrap="nowrap">Địa điểm công chứng</th>
	                <td colspan="3">
		                <logic:notEqual value="true" name="temporaryContractViewHelper" property="notaryPlaceFlag">
	                    <logic:notEmpty name="temporaryContractViewHelper" property="notaryPlace">
	                        <bean:message key="item_external_place"/> (<bean:write name="temporaryContractViewHelper" property="notaryPlace"/>)
	                    </logic:notEmpty>
	                    <logic:empty name="temporaryContractViewHelper" property="notaryPlace">
	                        <bean:message key="item_external_place"/>
	                    </logic:empty>
	                    </logic:notEqual>
	                    <logic:equal value="true" name="temporaryContractViewHelper" property="notaryPlaceFlag">
	                       <bean:message key="item_internal_place"/>
	                    </logic:equal>
	                </td>
	            </tr>
	            </logic:equal>
	            <logic:equal value="1" name="CommonContext" property="contractUserRequire">
	            <tr>
                <th nowrap="nowrap">Người yêu cầu công chứng</th>
                <td colspan="3">
                    <bean:write name="temporaryContractViewHelper" property="userRequireContract"/>
                </td>
                </tr>
                </logic:equal>
	        </table>
	       </div>
          </td>
         </tr>
         
         
         
       <tr>
       <td>
       <html:hidden styleId="isHidePropertyPanelInfo" property="isHidePropertyPanelInfo" name="temporaryContractForm"/>
         <div style="border: none; width: 80%;">
         <div id="propertyShow" class="sub-title">
	         <span class="tree_open" id="propertyInfoOption" style="cursor: pointer;" onclick="changePropertyInfoState(); setPropertyInfoState();"></span>
	         <strong class="onmouseover" onclick="changePropertyInfoState(); setPropertyInfoState();">Thông tin tài sản trong hợp đồng</strong>
         </div>
         <table id="propertyInformation" style="width:100%">
            <tr>
	            <td>
	               <logic:empty name="temporaryContractViewHelper" property="propertyInfo">
			            <table class="tbl-detail" style="width:95%">
			            <tr class="noProperty">
			                <th>Thông tin tài sản</th>
			                <td>Không có tài sản kèm theo</td>                    
			            </tr> 
			            </table>
		            </logic:empty>
		            
		            <logic:notEmpty name="temporaryContractViewHelper" property="propertyInfo">
			            <table class="tbl-detail" style="width:95%">
				            <tr class="oneProperty" id="propertyType_tr">
					            <th>Loại tài sản</th>
					            <td>
					                 <logic:equal value="01" name="temporaryContractViewHelper" property="propertyType">
					                   Nhà đất
					                 </logic:equal>
					                 <logic:equal value="02" name="temporaryContractViewHelper" property="propertyType">
                                       Ô tô, xe máy
                                     </logic:equal>
                                     <logic:equal value="03" name="temporaryContractViewHelper" property="propertyType">
                                       Ô tô, xe máy
                                     </logic:equal>
                                     <logic:equal value="99" name="temporaryContractViewHelper" property="propertyType">
                                       Tài sản khác
                                     </logic:equal>
					            </td>
				            </tr>
			             	<tr>
		                       <th>Thông tin tài sản</th>
			                   <td colspan="3">
			                        <bean:write name="temporaryContractViewHelper" property="propertyInfoDisp" filter="false"/>
			                   
			                   </td>
			                </tr>
			            </table>
		            </logic:notEmpty>
	            </td>
            </tr>
            </table>
          </div>  
       </td>
       </tr>
       </table>
       
       
       <fieldset id="searchField" class="fieldsetstyle">
       <legend id="searchShow" class="sub-title">
	       <span class="tree_open" id="searchOption" style="cursor: pointer; margin-left: 2px;" onclick="changeSearchState(); setSearchState();"></span>
	       <strong class="onmouseover" onclick="changeSearchState(); setSearchState();">Thông tin khác</strong>
       </legend>
       <html:hidden styleId="isHidePanelSearch" property="isHidePanelSearch" name="temporaryContractForm"/>
       <table id="otherContractInformation" width="100%">
       <tr>
       <td width="50%">
         <strong><span>&nbsp;&nbsp;&nbsp;Ngân hàng</span></strong> 
         <table class="tbl-detail" style="width:95%">           
          <tr>
              <th nowrap="nowrap">Tên ngân hàng</th> 
              <td>
                 <bean:write name="temporaryContractViewHelper" property="bankName"/>
              </td>
          </tr>
          <%if (context.isBankReport()) {%>
          <tr>
              <th nowrap="nowrap">Cán bộ tín dụng</th>   
              <td>
              <bean:write name="temporaryContractViewHelper" property="crediterName"/>
              </td>
          </tr>            
          <tr>
              <th nowrap="nowrap">Chiết khấu</th>    
              <td>
                 <logic:notEmpty name="temporaryContractViewHelper" property="bankServiceFee">
                  <bean:write name="temporaryContractViewHelper" property="bankServiceFee"/>                  
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
                    <bean:write name="temporaryContractViewHelper" property="numberOfPage"/>
                </td>
            </tr>
            <tr>
                <th nowrap="nowrap">Số bản công chứng</th>
                <td>
                    <bean:write name="temporaryContractViewHelper" property="numberCopyOfContract"/>
                </td>
            </tr>
            <tr>
	            <th nowrap="nowrap">File đính kèm</th>            
	             <td class="fileExist">                     
                 <logic:notEqual value="--" name="temporaryContractViewHelper" property="filePath">
                       <html:link href="javascript:download();">
                           <bean:write name="temporaryContractViewHelper" property="fileNameDisp"/>
                       </html:link>
                    </logic:notEqual>
                    <logic:equal value="--" name="temporaryContractViewHelper" property="filePath">
                       <bean:write name="temporaryContractViewHelper" property="fileNameDisp"/>
                    </logic:equal>
                </td>
             </tr>
            <tr>
                <th nowrap="nowrap">Nơi lưu trữ bản gốc</th>   
                <td>
                    <bean:write name="temporaryContractViewHelper" property="originalStorePlace"/>
                 </td>
            </tr>
            <tr>
                <th nowrap="nowrap">Người nhập hợp đồng</th>   
                <td>
                    <bean:write name="temporaryContractViewHelper" property="entryUserName"/>
                    - Ngày
                    <bean:write name="temporaryContractViewHelper" property="entryDateTime"/>
                 </td>
            </tr>
            <tr>
                <th nowrap="nowrap">Người sửa cuối cùng</th>   
                <td>
                    <bean:write name="temporaryContractViewHelper" property="updateUserName"/>
                    - Ngày
                    <bean:write name="temporaryContractViewHelper" property="updateDateTime"/>
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
               <logic:notEmpty name="temporaryContractViewHelper" property="costTt91">
                <bean:write name="temporaryContractViewHelper" property="costTt91"/>
                <label style="font-weight:normal">VNĐ</label>
               </logic:notEmpty>
              </td>
          </tr>
          <tr>
              <th nowrap="nowrap">Thù lao soạn thảo</th> 
              <td>
               <logic:notEmpty name="temporaryContractViewHelper" property="costDraft">
                <bean:write name="temporaryContractViewHelper" property="costDraft"/>
                <label style="font-weight:normal">VNĐ</label>
               </logic:notEmpty>
              </td>
          </tr>
          <tr>
              <th nowrap="nowrap">Dịch vụ công chứng ngoài</th>  
              <td>
               <logic:notEmpty name="temporaryContractViewHelper" property="costNotaryOutsite">
                <bean:write name="temporaryContractViewHelper" property="costNotaryOutsite"/>
                <label style="font-weight:normal">VNĐ</label>
               </logic:notEmpty>
              </td>
          </tr>
          <tr>
              <th nowrap="nowrap">Dịch vụ xác minh khác</th> 
              <td>
                <logic:notEmpty name="temporaryContractViewHelper" property="costOtherDetermine">
               <bean:write name="temporaryContractViewHelper" property="costOtherDetermine"/>
               <label style="font-weight:normal">VNĐ</label>
             </logic:notEmpty>
              </td>
          </tr>
          <tr>
              <th style="font-weight:bold" nowrap="nowrap">Tổng phí</th>
              <td>
                <logic:notEmpty name="temporaryContractViewHelper" property="costTotal">
                  <bean:write name="temporaryContractViewHelper" property="costTotal"/>
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
                    <logic:notEmpty name="temporaryContractViewHelper" property="contractNote">
                        <bean:write name="temporaryContractViewHelper" property="contractNoteDisp" filter="false"/>
                    </logic:notEmpty>
                    <logic:empty name="temporaryContractViewHelper" property="contractNote">
                        &nbsp;
                    </logic:empty>
                </td>
            </tr>
            </table>
            <br/>
       </td>
       </tr>
        </table>
       </fieldset>
       
       <input type="hidden" name="isHidePanelComment" id="isHidePanelComment" value="false"/>
  </html:form>     
       
       
       
       
       
       <table width="100%" class="tbl-non-border" style="margin: 10px 0 0 20px;">
	    <tr>
           <td>
		    <div style="border: none; width: 80%;">
	        <div id="infoShow" class="sub-title">
	        <span class="tree_open" id="commentOption" style="cursor: pointer;" onclick="changeCommentState(); setCommentState();"></span>
	        <strong class="onmouseover" onclick="changeCommentState(); setCommentState();">Ý kiến của cán bộ nghiệp vụ</strong>
	        
	        </div>
	       </div>
          </td>
         </tr>
       </table>
        <div id="contractcomment" style="padding-left: 30px; padding-bottom:10px ; width:80%;">
         <table id="contractList" class="tbl-list">
                <tbody id="contractListContent">
                <logic:iterate id="item" name="temporaryContractViewHelper" property="contractCommentList" indexId="i">
                    <tr class="tbl-row<%=i % 2%>">
                        <td width="30%">
                        	<div>
                                Người đăng: <b><bean:write name='item' property='entryUserName'/></b>
                                <br/>
                                <bean:write name='item' property='entryDateTime' format="dd/MM/yyyy HH:mm:ss"/><br/>
                            </div>
                            <logic:equal value="true" name="CommonContext" property="admin">
                            <div style="padding: 10px;">
                                <input type='button' value='Chỉnh sửa' onclick ='editcomment(<bean:write name="item" property="ccid"/>);'></input>
                                <input type='button' value='Xóa' onclick ='deletecomment(<bean:write name="item" property="ccid"/>);'></input>
                            </div>               
                            </logic:equal>             
                        </td>
                        <td>                            
                            <bean:write name='item' property='commentDisp' filter='false'/>
                        </td>
                    </tr>    
                </logic:iterate>
                </tbody>
           </table>
       </div>   
       
       	 <html:form action="editcontractcommentregist.do">
	      
         <table class="tbl-none-border">   	
            <tr>
                <th>Cho ý kiến tư vấn</th>
                <td colspan="3">
                    <textarea name="comment" class="input-x-long"></textarea>
                </td>
                <td>
                 <br/>
                 <html:submit property="btnPostComment" >Đưa ý kiến</html:submit>  
                </td>
            </tr>
          </table>
            
         </html:form>   
            
            
       
       <table width="80%" class="tbl-non-border" style="margin: 10px 0 0 20px;">
          <tr>
             <td colspan="2" style="text-align: center; padding: 10px;">
                 <logic:equal value="false" name="temporaryContractViewHelper" property="isExist">
                  <logic:equal value="true" name="CommonContext" property="temporaryContractManagement">
                      <html:link href="javascript: update();">
                          <img alt="Chỉnh sửa" src="./image/btn_edit.png"/>
                      </html:link>
                  </logic:equal>                 
                 <logic:equal value="true" name="temporaryContractViewHelper" property="fromRegistScreen">                        
                    <html:link href="temporarycontractregistview.do">
                        <img alt="Tiếp tục thêm mới" src="./image/btn_continue_add.png"/>
                    </html:link>
                 </logic:equal>
                 <logic:equal value="true" name="CommonContext" property="contractManagement">
                    <logic:equal value="false" name="temporaryContractViewHelper" property="fromRegistScreen">                        
	                    <html:link href="temporarycontractdetailtosign.do">
	                        <img alt="Chuyển ký" src="./image/btn_sign.png"/>
	                    </html:link>
	                 </logic:equal>
                  </logic:equal>
	                 <logic:equal value="true" name="CommonContext" property="temporaryContractDelete">
		                 <html:link href="javascript: remove()">
		                     <html:img alt="Xóa hợp đồng" src="./image/btn_delete.png"/>
		                 </html:link>
	                 </logic:equal>
	                 <logic:equal value="true" name="CommonContext" property="temporaryContractManagement">
	                      <html:link href="javascript: createcopy()">
		                      <html:img alt="Tạo bản sao" src="./image/btn_saochephd.png"/>
		                  </html:link>
		                  </logic:equal>
                
				</logic:equal>
                  <html:link href="temporarycontractlistback.do">
                      <html:img alt="Quay lại danh sách" src="./image/btn_list_back.png"/>
                  </html:link>
                
             </td>
         </tr>
         </table>       
     
    
    <%@ include file="/jsp/common/footer.jsp" %>
</html:html>  

<script type="text/javascript">

    $('#contract > em').removeClass("contract-off");
    $('#contract > em').addClass("contract-on");
    $('#contract > b').addClass("menu-on");
    
    function update() {
        document.temporaryContractForm.action="temporarycontractupdateview.do";
        document.temporaryContractForm.submit();
        return true;
    }
    
    function download() {
        document.temporaryContractForm.action='temporarycontractdetaildownload.do';
        document.temporaryContractForm.submit();
    }
    
    function remove() {
        var answer = confirm ("Bạn có thực sự muốn xóa hợp đồng không?");
        if (answer) {
            document.temporaryContractForm.action="temporarycontractdetailremove.do";
            document.temporaryContractForm.submit();
            return true;
        }        
    }
    

    function editcomment(ccid) {
	    document.temporaryContractForm.action="editcontractcommentview.do?ccid=" + ccid;
        document.temporaryContractForm.submit();
        return true;
	}

    function deletecomment(ccid) {
    	var answer = confirm ("Bạn có thực sự muốn xóa ý kiến không?");
        if (answer) {
	    	document.temporaryContractForm.action="editcontractcommentdelete.do?ccid=" + ccid;
	        document.temporaryContractForm.submit();
	        return true;
        }
    }
    
    function createcopy() {
        document.temporaryContractForm.action="temporarycontractcreatecopy.do?tcid=" + "<bean:write name='temporaryContractViewHelper' property='contractId'/>";
        document.temporaryContractForm.submit();
        return true;
    }
    
    
    
    setSearchState();
    
    function changeSearchState() {
        var val = document.getElementById("isHidePanelSearch").value;
        if (val == "true") {
            document.temporaryContractForm.isHidePanelSearch.value = "false";
        } else {
            document.temporaryContractForm.isHidePanelSearch.value = "true";
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
            document.temporaryContractForm.isHidePanelInfo.value = "false";
        } else {
            document.temporaryContractForm.isHidePanelInfo.value = "true";
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
    
    function changePropertyInfoState() {
        var val = document.getElementById("isHidePropertyPanelInfo").value;
        if (val == "true") {
            document.temporaryContractForm.isHidePropertyPanelInfo.value = "false";
        } else {
            document.temporaryContractForm.isHidePropertyPanelInfo.value = "true";
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
    
    setCommentState();
    
    function changeCommentState() {
        var val = document.getElementById("isHidePanelComment").value;
        
        if (val == "true") {
            document.temporaryContractForm.isHidePanelComment.value = "false";
        } else {
            document.temporaryContractForm.isHidePanelComment.value = "true";
        }
    }
    
    function setCommentState() {
        var val = document.getElementById("isHidePanelComment").value;
        if (val == "true") {
            $('#commentOption').removeClass('tree_open');
            $('#commentOption').addClass('tree_close');
            $('#contractList').hide();
        } else {
            $('#commentOption').removeClass('tree_close');
            $('#commentOption').addClass('tree_open');
            $('#contractList').show();
        }
    }
</script>