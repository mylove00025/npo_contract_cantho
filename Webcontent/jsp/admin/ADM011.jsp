<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>
    <html:form action="contracttemplateregistview" method="post" enctype="multipart/form-data" styleId="form" onsubmit="javascript: save();">
        <div id="navigator">            
            <ul class="clearfix">
                <li>
                    <html:img alt="*" src="./image/bullet_square.gif"/>
                </li>
                <li>
                    <a href="userlistview.do">Quản trị hệ thống</a> &gt;
                    <a href="contracttemplatelistback.do">Danh sách tên hợp đồng</a> &gt;
                    <a href="#">Thêm mới tên hợp đồng</a>
                                           
                </li>         
            </ul>
        </div>
        <%@ include file="/jsp/common/error_message.jsp" %>
        <div><strong><span>◊ Thông tin tên hợp đồng</span></strong></div><br/>
        <table class="tbl-none-border">
            <tr>
                <th>Nhóm hợp đồng<span class="required">*</span> :</th> 
                <td>
                    <span id="contractKind"></span>
                </td>
            </tr>
            <tr>
                <th>Tên hợp đồng<span class="required">*</span> :</th>  
                <td>
                    <html:text name="contractTemplateRegistViewHelper" styleId="contractName" property="contractTemplateName" maxlength="200" 
                        styleClass="input-long"/>
                </td>
            </tr>
            <tr>
                <th>Mã hợp đồng :</th>  
                <td>
                    <html:text name="contractTemplateRegistViewHelper" styleId="contractCode" property="contractTemplateCode" maxlength="200" 
                        styleClass="input-long"/>
                </td>
            </tr>
            <tr>
            <th>Số bên liên quan :</th>
	            <td>
	                <html:radio property="relateObjectNumber" name="contractTemplateRegistViewHelper" value="2" styleId="twoObject"/>
	                <label for="twoObject">2 bên</label>
	                &nbsp;&nbsp;&nbsp;
	                <html:radio property="relateObjectNumber" name="contractTemplateRegistViewHelper" value="3" styleId="threeObject"/>
	                <label for="threeObject">3 bên</label>
	            </td>
	        </tr>
	        <tr>
            <th>Vai trò đương sự :</th>
	            <td>
	              Bên A:  <html:text value="Bên" name="contractTemplateRegistViewHelper" styleId="relateObjectATitle" property="relateObjectATitle" maxlength="50" 
                        />&nbsp;&nbsp;&nbsp;&nbsp;
                        
                  Bên B:  <html:text value="Bên" name="contractTemplateRegistViewHelper" styleId="relateObjectBTitle" property="relateObjectBTitle" maxlength="50" 
                        />&nbsp;&nbsp;&nbsp;&nbsp;
                        
                  Bên C:  <html:text value="Bên" name="contractTemplateRegistViewHelper" styleId="relateObjectCTitle" property="relateObjectCTitle" maxlength="50" 
                        />      
	            </td>
	          
	            
	        </tr>
            <tr>
                <th>Mẫu tóm tắt nội dung :</th>   
                <td>
                    <html:textarea name="contractTemplateRegistViewHelper" property="contractTemplateDescription" 
                        styleClass="input-long"/>
                </td>
            </tr>   
            <tr>
                <th>Một số thông tin khác:</th>   
                <td>
                    Giải chấp:<html:checkbox style="vertical-align:sub" name="contractTemplateRegistViewHelper" property="mortageCancelFunc"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 	Thời hạn hợp đồng:<html:checkbox style="vertical-align:sub"  name="contractTemplateRegistViewHelper" property="periodFlag"/>
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
                    <html:file name="contractTemplateRegistViewHelper"  property="formFile" size="50"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center; padding: 10px;">
                    <html:image alt="Lưu" src="./image/btn_save.png"/>
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
	    document.contractTemplateRegistForm.action = "contracttemplateregistsave.do";
	    return true;
	}
	
	retrieveURL("ajaxGetContractKindTreeNode.do?fieldName=contractKindId" + "&type=" + 2
	        + "&selectedId=<bean:write name='contractTemplateRegistViewHelper' property='contractKindId'/>");
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