<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.servletsuite.com/servlets/tooltip" prefix="t" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>
    
    <html:form action="documentlistview" onsubmit="javascript: searchOnClick()">  
    <div id="navigator" style="clear: both;">
        <ul class="clearfix" style="clear: both;">
            <li>
                <html:img alt="*" src="./image/bullet_square.gif"/>
            </li>
            <li>
                <html:link href="home.do">Trang chủ</html:link>
                <span> &gt; </span>
            </li>
            <li>
                <html:link href="documentlistview.do">Tài liệu nội bộ</html:link>
            </li>
        </ul>
    </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
     <span class="sub-title">◊ Điều kiện tìm kiếm</span>
        <table class="tbl-search" summary="Thông tin tìm kiếm">
            <tr>
                <th width="100px">Tên tài liệu :</th>
                <td>
                    <html:text styleId="firstControl" property="documentNameFilter" name="documentListViewHelper" styleClass="input-long" maxlength="200"/>
                </td>  
                <td style="text-align:center; padding: 10px;">
                   <html:image alt="Tìm kiếm" src="./image/btn_search.png"/>                  
                </td>            
            </tr>          
        </table>
    <div>
     		<div class="clearfix-left">
                <span>◊ Danh sách tài liệu</span>
            </div>
    </div> 
    <br></br></br>
    
    <div>
           <table class="clearfix-document-right" summary="Thông tin tìm kiếm">
               <tr id = "makenewfolder_tr" style="width:100%" >
                   <td style="text-align: left; width:5px">
			                <html:img alt="folder" src="./image/fileicons/folder.gif"/>
			       </td>
	               <td class = "folderPathDisp1" style="text-align: left; color: #0099FF;" title="<bean:write name="documentListViewHelper" property="folderPath" />">
		               <bean:write name="documentListViewHelper" property="folderPathDisp1" />
			        </td>
			       <td class = "folderPathDisp2" style="text-align: left; color: #0099FF;" title="<bean:write name="documentListViewHelper" property="folderPath" />">
		               <bean:write name="documentListViewHelper" property="folderPathDisp2" />
			       </td>
			       
			       <!-- check -->
			       <td  class='previousId' style="text-align: right; width:1px">
			           <html:text style="width:300px" styleId = "previousId" name="documentListViewHelper"  property="previousId" maxlength="200"
				                 styleClass="input-long"/>
				   </td>
				   <td  class='previousId' style="text-align: right; width:1px">
			           <html:text style="width:300px" styleId = "isSearch" name="documentListViewHelper"  property="isSearch" maxlength="200"
				                 styleClass="input-long"/>
				   </td>
				   <td  class='previousId' style="text-align: right; width:1px">
			           <html:text style="width:300px" styleId = "nameHistoryFilter" name="documentListViewHelper"  property="nameHistoryFilter" maxlength="200"
				                 styleClass="input-long"/>
				   </td>
				   <!-- check -->
				   
	               <th id='makenewfolder' style="text-align: right; width:90px">Tên thư mục :</th>
	               <td class='makenewfolder' style="text-align: right; width:300px">
			           <html:text style="width:300px" styleId = "namefolder" property="documentName" maxlength="200" value = ""
				                 styleClass="input-normal"/>
				   </td>
				   <td class='makenewfolder' style="text-align: right; width:50px">
			            <html:link href="javascript: saveNewFolder()">
		                   <html:img alt="Them moi" src="./image/btn_save.png"/>
		                </html:link>
		           </td>
		           <td class='makenewfolder' style="text-align: right; width:50px">
			           <html:link href="javascript: hideMakeNewFolder()">
	                        <html:img alt="Hủy" src="./image/btn_cancel.png"/>
	                   </html:link>
                   </td>
                   
                   <%  if (context.isAdmin())
                   { %>
                   <logic:equal name ="documentListViewHelper" property = "isSearch" value="false">
		           <td style="text-align: right; width:50px">
			            <html:link href="javascript:makeNewFolder();">
		                <html:img alt="Them moi" src="./image/btn_creatfolder.png"/>
		                </html:link>
		           </td>
		           <td style="text-align: right; width:50px">
			    	   <html:link href="javascript: uploadFile();">
			                <html:img alt="Them moi" src="./image/btn_taitep.png"/>
			           </html:link> 
			       </td>
			       </logic:equal>
			       <%}%>
		      </tr>
           </table>   
    </div>
    
         <script type="text/javascript">
         
              $('td.folderPathDisp2').hide();
			  $('#makenewfolder').hide();
			  $('td.makenewfolder').hide();
			  $('td.previousId').hide();
			  
	     </script>
    
            <table class="tbl-list">
                <tr>
                    <th> Tên file,thư mục</th>
                    <logic:equal name ="documentListViewHelper" property = "isSearch" value="true">
                    <th> Trong thư mục</th>
                    </logic:equal>
                    <th> Người cập nhật cuối</th>
                    <th> Thời gian cập nhật</th>
                    <%  if (context.isAdmin()) { %>
                    <th> Thao tác</th>
                    <%}%>
                </tr>  
                <tr class="tbl-row">
                     <td style="text-align: left;">
                        <html:link href="javascript: upToFatherFolder()">
                          <html:img title="Quay lại" src="./image/folder_up16.gif" alt="Quay lại" />
                        </html:link>..
                    </td>
                    <td>
                    </td>
                    <td>
                    </td>
                    <logic:equal name ="documentListViewHelper" property = "isSearch" value="true">
                    <td></td>
                    </logic:equal>
                    <%  if (context.isAdmin()) { %>
                    <td></td>
                    <%}%>
                </tr> 
                <logic:notEmpty name="documentListViewHelper" property="documentList">
                <bean:define id="firstIndex" property="firstIndex" name="documentListViewHelper" type="java.lang.Integer"/>     
                <logic:iterate id="item" name="documentListViewHelper" property="documentList" indexId="i">
                    <tr class="tbl-row<%=i % 2%>">
                         <td style="text-align: left; width:40%">
                    	    <logic:equal name="item" property="type" value="0">
	                             <html:img title="Hợp đồng lỗi" src="./image/fileicons/folder.gif" alt="Hợp đồng lỗi" />
	                             <a href="javascript: documentcontent( <bean:write name='item' property='id' />)">
		                           <bean:write name= "item" property="name" />
		                         </a>
	                        </logic:equal>
	                        <logic:equal name="item" property="type" value="1">
	                             <logic:notEmpty name="item" property="docFileName">
		                             <bean:define id="docFileName" name="item" property="docFileName" type="java.lang.String"/>
		                             <%@ include file="/jsp/common/common_function.jsp" %>
		                             <img src="<%=getIcon(docFileName)%>"/>
		                             <a href="javascript: documentdownload(<bean:write name='item' property='id' />)">
		                                <bean:write name= "item" property="name" />
		                             </a>
	                             </logic:notEmpty>   
	                        </logic:equal>
                        </td>
                        <logic:equal name ="documentListViewHelper" property = "isSearch" value="true">
	                    <td title="<bean:write name="item" property="folderPath" />">
	                        <bean:write name="item" property="folderPathDisp" /> 
						</td>
	                    </logic:equal>
                        <td  style="text-align: center;">
                            <bean:write name="item" property="updateUserName" />
                        </td>
                        <td  style="text-align: center;">
                            <bean:write name="item" property="updateDateTime" format ="dd/MM/yyyy HH:mm:ss"/>
                        </td>
                       <%  if (context.isAdmin()) { %>
                        <td  style="text-align: center;">
		                        <a href="javascript: editDocument( <bean:write name='item' property='id' />)">
		                           Đổi tên
		                        </a>
		                        &nbsp;&nbsp;&nbsp;
		                        <a  href="javascript: delDocument( <bean:write name='item' property='id' />)">
		                           Xóa
		                        </a>
                        </td>
                       <%}%>
                    </tr>    
                 </logic:iterate>
                </logic:notEmpty>
            </table> 
          </br></br> </br></br>   
          <html:hidden property="documentId"/>   
          <html:hidden property="documentName"/>   
          <html:hidden property="previousId"/>
          <html:hidden property="documentNameFilter"/>   
          <html:hidden property="isSearch"/>   
     </html:form>
    <%@ include file="/jsp/common/footer.jsp" %>
</html:html>
<script type="text/javascript">

$('#home > em').removeClass("home-off");
$('#home > em').addClass("home-on");
$('#home > b').addClass("menu-on");
  
  document.getElementById("firstControl").focus();
  

  function searchOnClick()
  {
	 document.documentListForm.action="searchdocument.do";
     return true;
  }
  
  function saveNewFolder()
  {
	 if(document.getElementById("namefolder") == null){
		  document.documentListForm.documentName.value = null;
	  }else{
		  document.documentListForm.documentName.value = document.getElementById("namefolder").value;
	  }
	  if(document.getElementById("previousId") == null){
		  document.documentListForm.previousId.value = null;
	  }else{
		  document.documentListForm.previousId.value = document.getElementById("previousId").value;
	  }
	  if(document.getElementById("isSearch") == null){
		  document.documentListForm.isSearch.value = null;
	  }else{
		  document.documentListForm.isSearch.value = document.getElementById("isSearch").value;
	  }
	  if(document.getElementById("nameHistoryFilter") == null){
		  document.documentListForm.nameHistoryFilter.value = null;
	  }else{
		  document.documentListForm.nameHistoryFilter.value = document.getElementById("nameHistoryFilter").value;
	  }
     document.documentListForm.action="makenewfolder.do";
     document.documentListForm.submit();
  }
  
  function makeNewFolder()
  {
	  $('#makenewfolder').show();
	  $('td.makenewfolder').show();
	  $('td.folderPathDisp1').hide();
	  $('td.folderPathDisp2').show();
  }
  
  function hideMakeNewFolder()
  {
	  $('#makenewfolder').hide();
	  $('td.makenewfolder').hide();
	  $('td.folderPathDisp1').show();
	  $('td.folderPathDisp2').hide();
  }
  
  
  function delDocument(id)
  {
	  var answer = confirm("<bean:message key='msg_delete_confirm'/>");
	  if (answer){
		  if(document.getElementById("previousId") == null){
			  document.documentListForm.previousId.value = null;
		  }else{
			  document.documentListForm.previousId.value = document.getElementById("previousId").value;
		  }
		  if(document.getElementById("isSearch") == null){
			  document.documentListForm.isSearch.value = null;
		  }else{
			  document.documentListForm.isSearch.value = document.getElementById("isSearch").value;
		  }
		  if(document.getElementById("nameHistoryFilter") == null){
			  document.documentListForm.nameHistoryFilter.value = null;
		  }else{
			  document.documentListForm.nameHistoryFilter.value = document.getElementById("nameHistoryFilter").value;
		  }
		  document.documentListForm.documentId.value = id;
	  	  document.documentListForm.action = "deldocument.do";
	      document.documentListForm.submit();
	      return true;	
       }
  }
  
  function editDocument(id)
  {
  		if(document.getElementById("previousId") == null){
			  document.documentListForm.previousId.value = null;
		  }else{
			  document.documentListForm.previousId.value = document.getElementById("previousId").value;
		  }
		  if(document.getElementById("isSearch") == null){
			  document.documentListForm.isSearch.value = null;
		  }else{
			  document.documentListForm.isSearch.value = document.getElementById("isSearch").value;
		  }
		  if(document.getElementById("nameHistoryFilter") == null){
			  document.documentListForm.nameHistoryFilter.value = null;
		  }else{
			  document.documentListForm.nameHistoryFilter.value = document.getElementById("nameHistoryFilter").value;
		  }
		  document.documentListForm.documentId.value = id;
	  	  document.documentListForm.action = "editdocument.do";
	      document.documentListForm.submit();
  }
  
  function uploadFile()
  {
		  if(document.getElementById("previousId") == null){
			  document.documentListForm.previousId.value = null;
		  }else{
			  document.documentListForm.previousId.value = document.getElementById("previousId").value;
		  }
		  if(document.getElementById("isSearch") == null){
			  document.documentListForm.isSearch.value = null;
		  }else{
			  document.documentListForm.isSearch.value = document.getElementById("isSearch").value;
		  }
		  if(document.getElementById("nameHistoryFilter") == null){
			  document.documentListForm.nameHistoryFilter.value = null;
		  }else{
			  document.documentListForm.nameHistoryFilter.value = document.getElementById("nameHistoryFilter").value;
		  }
		  document.documentListForm.action="uploaddocument.do";
		  document.documentListForm.submit();
	  
  }
  
  function upToFatherFolder()
  {
		  if(document.getElementById("previousId") == null){
			  document.documentListForm.previousId.value = null;
		  }else{
			  document.documentListForm.previousId.value = document.getElementById("previousId").value;
		  }
		  if(document.getElementById("isSearch") == null){
			  document.documentListForm.isSearch.value = null;
		  }else{
			  document.documentListForm.isSearch.value = document.getElementById("isSearch").value;
		  }
		  if(document.getElementById("nameHistoryFilter") == null){
			  document.documentListForm.nameHistoryFilter.value = null;
		  }else{
			  document.documentListForm.nameHistoryFilter.value = document.getElementById("nameHistoryFilter").value;
		  }
		  document.documentListForm.action="uptofatherfolder.do";
		  document.documentListForm.submit();
	  
  }
  
  function documentcontent(id)
  {
		  if(document.getElementById("previousId") == null){
			  document.documentListForm.previousId.value = null;
		  }else{
			  document.documentListForm.previousId.value = document.getElementById("previousId").value;
		  }
		  if(document.getElementById("isSearch") == null){
			  document.documentListForm.isSearch.value = null;
		  }else{
			  document.documentListForm.isSearch.value = document.getElementById("isSearch").value;
		  }
		  if(document.getElementById("nameHistoryFilter") == null){
			  document.documentListForm.nameHistoryFilter.value = null;
		  }else{
			  document.documentListForm.nameHistoryFilter.value = document.getElementById("nameHistoryFilter").value;
		  }
		  document.documentListForm.documentId.value = id;
	  	  document.documentListForm.action = "documentcontent.do";
	      document.documentListForm.submit();
  }
  
  function documentdownload(id)
  {
		  if(document.getElementById("previousId") == null){
			  document.documentListForm.previousId.value = null;
		  }else{
			  document.documentListForm.previousId.value = document.getElementById("previousId").value;
		  }
		  if(document.getElementById("isSearch") == null){
			  document.documentListForm.isSearch.value = null;
		  }else{
			  document.documentListForm.isSearch.value = document.getElementById("isSearch").value;
		  }
		  if(document.getElementById("nameHistoryFilter") == null){
			  document.documentListForm.nameHistoryFilter.value = null;
		  }else{
			  document.documentListForm.nameHistoryFilter.value = document.getElementById("nameHistoryFilter").value;
		  }
		  document.documentListForm.documentId.value = id;
	  	  document.documentListForm.action = "documentdownload.do";
	      document.documentListForm.submit();
  }  
 
</script>

 <logic:equal name="documentListViewHelper" property="makeNewFolder" value="true">
		       <script type="text/javascript">
	    
				  $('#makenewfolder').show();
				  $('td.makenewfolder').show();
				  document.getElementById("namefolder").focus();
			  
		       </script>
</logic:equal>