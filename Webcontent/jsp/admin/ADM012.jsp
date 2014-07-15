<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>
    <html:form action="contracttemplateeditview" method="post" enctype="multipart/form-data" styleId="form" onsubmit="javascript: save();">
        <div id="navigator">            
            <ul class="clearfix">
                <li>
                    <html:img alt="*" src="./image/bullet_square.gif"/>
                </li>
                <li>
                    <a href="userlistview.do">Quản trị hệ thống</a> &gt;
                    <a href="contracttemplatelistback.do">Danh sách tên hợp đồng</a> &gt;
                    <a href="#">Sửa đổi tên hợp đồng</a>                     
                </li>         
            </ul>
        </div>
        <%@ include file="/jsp/common/error_message.jsp" %>
        <div><strong><span>◊ Thông tin tên hợp đồng</span></strong></div><br/>
        <table class="tbl-none-border">
            <tr id="contractKind_tr">
                <th>Nhóm hợp đồng<span class="required">*</span> :</th> 
                <td>
                    <span id="contractKind"></span> 
                </td>
            </tr>
            <tr id="contractTemplateName_tr">
                <th>Tên hợp đồng<span class="required">*</span> :</th>  
                <td>
                    <html:text styleId="contractName" name="contractTemplateEditViewHelper" property="contractTemplateName" maxlength="200" styleClass="input-long"/>
                </td>
            </tr>            
            <tr>
                <th>Mã hợp đồng :</th>  
                <td>
                    <html:text name="contractTemplateEditViewHelper" styleId="contractCode" property="contractTemplateCode" maxlength="200" 
                        styleClass="input-long"/>
                </td>
            </tr>
            <tr>
            <th>Số bên liên quan :</th>
                <td>
                    <html:radio property="relateObjectNumber" name="contractTemplateEditViewHelper" value="2" styleId="twoObject"/>
                    <label for="twoObject">2 bên</label>
                    &nbsp;&nbsp;&nbsp;
                    <html:radio property="relateObjectNumber" name="contractTemplateEditViewHelper" value="3" styleId="threeObject"/>
                    <label for="threeObject">3 bên</label>
                </td>
            </tr>
             <tr>
            <th>Vai trò đương sự :</th>
	            <td>
	              Bên A:  <html:text name="contractTemplateEditViewHelper" styleId="relateObjectATitle" property="relateObjectATitle" maxlength="50" 
                        />&nbsp;&nbsp;&nbsp;&nbsp;
                        
                  Bên B:  <html:text name="contractTemplateEditViewHelper" styleId="relateObjectBTitle" property="relateObjectBTitle" maxlength="50" 
                        />&nbsp;&nbsp;&nbsp;&nbsp;
                        
                  Bên C:  <html:text name="contractTemplateEditViewHelper" styleId="relateObjectCTitle" property="relateObjectCTitle" maxlength="50" 
                        />      
	            </td>
	          
	            
	        </tr>
            <tr>
                <th>Mẫu tóm tắt nội dung :</th>   
                <td>
                    <html:textarea name="contractTemplateEditViewHelper" property="contractTemplateDescription" styleClass="input-long"/>
                </td>
            </tr>
    		<tr>
                <th>Một số thông tin khác:</th>   
                <td>
                    Giải chấp:<html:checkbox style="vertical-align:sub" name="contractTemplateEditViewHelper" property="mortageCancelFunc"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 	Thời hạn hợp đồng:<html:checkbox style="vertical-align:sub"  name="contractTemplateEditViewHelper" property="periodFlag"/>
                </td>
            </tr>     
            <tr>
                <td colspan="2">
                 <div>
                    <span style="color:Black; font-weight:bold">◊ Hợp đồng mẫu đính kèm</span>
                </div>
                </td>
            </tr>
            
            <tr>
                <th></th>
                <td>
                    <logic:empty  name="contractTemplateEditViewHelper" property="fileName">
                        <html:file name="contractTemplateEditViewHelper"  property="formFile" size="50"/>
                    </logic:empty>                    
                </td>
            </tr>
            <tr>
                <th></th>
                <td>
                    <logic:notEmpty name="contractTemplateEditViewHelper" property="fileName">                    
                        <html:link href="javascript:downloadFile();">
	                        <bean:write name="contractTemplateEditViewHelper" property="fileName"/>
	                    </html:link>
	                    &nbsp;&nbsp;&nbsp;
	                    <html:link href="javascript: removeFile();">
	                        Gỡ bỏ
	                    </html:link>
	                </logic:notEmpty><br></br>
                </td>
            </tr>
            <tr>
                <th>Trạng thái sử dụng :</th>
                <td>
	                 <html:radio styleId="activeFlgTrue" property="activeFlg" name="contractTemplateEditViewHelper" value="true"/>
	                 <label for="activeFlgTrue">Đang sử dụng</label>
	                 &nbsp;&nbsp;&nbsp;
	                 <html:radio styleId="activeFlgFalse" property="activeFlg" name="contractTemplateEditViewHelper" value="false"/>
	                 <label for="activeFlgFalse">Ngừng sử dụng</label>
                </td>
            </tr>
            <tr>
                <th>Người cập nhật cuối :</th>  
                <td>
                    <bean:write name="contractTemplateEditViewHelper" property="updateUserName"/>
                </td>
            </tr>
            <tr>
                <th>Ngày cập nhật cuối :</th>   
                <td>
                    <bean:write name="contractTemplateEditViewHelper" property="updateDateTime" format="dd/MM/yyyy"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center; padding: 10px;">
                    <html:image alt="Lưu" src="./image/btn_save.png"/>
                    <html:link href="javascript:del()">
                        <img src="./image/btn_delete.png" alt="Xóa" />
                    </html:link>                    
                    <html:link href="contracttemplatelistback.do">
                        <html:img alt="Hủy" src="./image/btn_cancel.png"/>
                    </html:link>
                </td>
            </tr>
        </table>                
    </html:form>
    <%@ include file="/jsp/common/footer.jsp" %> 
</html:html>
<script type="text/javascript">
	//Hightlight menu
    $('#system > em').removeClass("system-off");
    $('#system > em').addClass("system-on");
    $('#system > b').addClass("menu-on");
	
    document.getElementById("contractName").focus();
	function save() {
		document.contractTemplateEditForm.action = "contracttemplateeditsave.do";
	    return true;
	}
	function removeFile() {
		var answer = confirm("Bạn có thực sự muốn gỡ bỏ không?");
        if (answer){
	        document.contractTemplateEditForm.action = "contracttemplateeditremovefile.do";
	        document.contractTemplateEditForm.submit();
	        return true;
        }
    }	
	function downloadFile() {
		document.contractTemplateEditForm.action = "contracttemplateeditdownloadfile.do";
        document.contractTemplateEditForm.submit();
        return true;
	}
	function del() {
		var answer = confirm("<bean:message key='msg_delete_confirm'/>");
        if (answer){
        	document.contractTemplateEditForm.action = "contracttemplateeditdel.do";
            document.contractTemplateEditForm.submit();
            return true;	
        }        
    }
	
	retrieveURL("ajaxGetContractKindTreeNode.do?fieldName=contractKindId" + "&type=" + 2
            + "&selectedId=<bean:write name='contractTemplateEditViewHelper' property='contractKindId'/>");
    var req;
    var which;

    function retrieveURL(url) {
      if (window.XMLHttpRequest) { // Non-IE browsers
        req = new XMLHttpRequest();
        req.onreadystatechange = processStateChange;
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
          req.onreadystatechange = processStateChange;
          req.open("GET", url, true);
          req.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
          req.send();
        }
      }
    }

    function processStateChange() {
      if (req.readyState == 4) { // Complete
        if (req.status == 200) { // OK response
            document.getElementById("contractKind").innerHTML = req.responseText;
        } else {
          alert("Problem: " + req.statusText);
        }
      }
    }
</script>