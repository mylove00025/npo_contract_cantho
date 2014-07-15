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
	            <html:link href="userlistview.do">Quản trị hệ thống</html:link>
	        </li>
	        <li>
	            <span> > </span>
	            <html:link href="contractkindlistback.do">Danh sách nhóm hợp đồng</html:link>               
	        </li>
	        <li>
	            <span> > </span>
	            <html:link href="#">Sửa đổi nhóm hợp đồng</html:link>
	        </li>               
	    </ul>
    </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
    <html:form action="contractkindupdateview" styleId="form" onsubmit="javascript: save()">
        <html:hidden styleId="hasChildren" name="contractKindViewHelper" property="hasChildren"/>
        <span class="sub-title">◊ Sửa đổi nhóm hợp đồng </span>
        <table class="tbl-none-border">
            <tr>
                <th nowrap="nowrap">Tên nhóm hợp đồng<span class="required">*</span> :</th>
                <td>
                    <html:text styleId="name" name="contractKindViewHelper" property="name" styleClass="input-long" maxlength="200"/>
                </td>
            </tr>
            <tr>
                <th>Thứ tự sắp xếp :</th>
                <td>
                    <html:select styleId="position" name="contractKindViewHelper" property="position" >
                        <html:option value="01">Đầu danh sách</html:option>
                        <html:option value="02">Giữa danh sách</html:option>
                        <html:option value="03">Cuối danh sách</html:option>
                    </html:select>
                </td>
            </tr>
            <tr class="contractkindlist">
                <th nowrap="nowrap">Tiếp sau nhóm hợp đồng :</th>                
                <td>
                    <html:select name="contractKindViewHelper" property="orderContractKindId">
                      	 <html:optionsCollection name="contractKindViewHelper" property="contractKindList" value="id" label="name" />
                    </html:select>
                </td>
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
                    <html:link href="javascript: remove()">
                        <html:img alt="Hủy" src="./image/btn_delete.png"/>
                    </html:link>
                    <html:link href="contractkindlistback.do">
                        <html:img alt="Hủy" src="./image/btn_cancel.png"/>
                    </html:link>
                </td>
            </tr>            
        </table>
    </html:form>
    <%@ include file="/jsp/common/footer.jsp" %>
</html:html>    
<script type="text/javascript">

	$('#system > em').removeClass("system-off");
	$('#system > em').addClass("system-on");
	$('#system > b').addClass("menu-on");
	
	document.getElementById("name").focus();
	
	retrieveURL("ajaxGetContractKindTreeNode.do?fieldName=parentKindId"
            + "&selectedId=<bean:write name='contractKindViewHelper' property='parentKindId'/>");

    function save() {
        document.contractKindForm.action="contractkindupdate.do";
        return true;
    }
    
    function remove() {
    	var hasChildren = document.getElementById("hasChildren").value;
    	var answer = confirm ("Bạn có thực sự muốn xóa dữ liệu?");
    	
    	if (answer) {
    		document.contractKindForm.action="contractkindremove.do";
            document.contractKindForm.submit();
            return true;
    	}
    }
        
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
      
    }

    var val = $('#position option:selected').val();
    if (val == '02') {
    	$('tr.contractkindlist').show();
    } else {
    	$('tr.contractkindlist').hide();
    }
    
    $('#position').change(function(){
    	var val = $('#position option:selected').val();
        if (val == '02') {
            $('tr.contractkindlist').show();
        } else {
            $('tr.contractkindlist').hide();
        }
    });
</script>