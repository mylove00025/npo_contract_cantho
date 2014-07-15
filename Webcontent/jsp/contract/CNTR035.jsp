<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.servletsuite.com/servlets/tooltip" prefix="t" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>
    <html:form action="uploaddocument" enctype="multipart/form-data" onsubmit="javascript: save();">  
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
                <span> &gt; </span>
            </li>
            <li>
                <html:link href="#">Tải tài liệu lên</html:link>
            </li>
        </ul>
    </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
    
       </br>
       <div><strong><span>◊ Thông tin tệp tải lên</span></strong></div><br/>
       <table class="tbl-none-border">
             <tr>
               <th>Tên tài liệu :<span class="required">*</span></th>
                  <td  class='previousId1' style="text-align: right; width:0px">
			           <html:text style="width:300px" styleId = "previousId" name="documentViewHelper"  property="previousId" maxlength="200"
				                 styleClass="input-normal"/>
				  </td>
                  <td>
	               <html:text style="width:300px" styleId="firstControl" property="documentName" name = "documentViewHelper" maxlength="200"
	                 styleClass="input-long"/>
                  </td>
             </tr>
             <tr>
                <th>Tệp đính kèm :<span class="required">*</span></th>
                <td>
               		<html:file property="formFile" size="42" styleClass="input-normal" />
                </td>
			 </tr>	
			 <tr><th></br></th>
			 </tr>
			  <tr>
                <td colspan="2" style="text-align: center; padding: 10px;">
		              <span id="update_on"> 
		              <html:image alt="Lưu" src="./image/btn_save.png" onclick="stylechange('update_off', 'update_on');"/>
		              </span>
		              <span id="update_off" style="display: none;">
		                  <html:link href="#">
		                      <html:img alt="Lưu" src="./image/btn_save.png"/>
		                  </html:link>
		              </span>
                      <html:link href="javascript: listBackDocument();">
                        <html:img alt="Hủy" src="./image/btn_cancel.png"/>
                      </html:link>
                </td>
             </tr>
       </table>
       <html:hidden property="previousId"/>   
     </html:form>
    <%@ include file="/jsp/common/footer.jsp" %>
</html:html>
<script type="text/javascript">

$('#home > em').removeClass("home-off");
$('#home > em').addClass("home-on");
$('#home > b').addClass("menu-on");
$('td.previousId1').hide();

  document.getElementById("firstControl").focus();
  
  function save() {
	  if(document.getElementById("previousId") == null){
		  document.documentListForm.previousId.value = null;
	  }else{
		  document.documentListForm.previousId.value = document.getElementById("previousId").value;
	  }
	  document.documentListForm.action = "uploaddocumentsave.do";
	    return true;
	}
  function listBackDocument()
  {
	  if(document.getElementById("previousId") == null){
		  document.documentListForm.previousId.value = null;
	  }else{
		  document.documentListForm.previousId.value = document.getElementById("previousId").value;
	  }
	  document.documentListForm.action = "uploaddocumentlistback.do";
	  document.documentListForm.submit();
  }
  
</script>