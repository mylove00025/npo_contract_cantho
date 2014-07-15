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
                <html:link href="banklistback.do">Danh sách ngân hàng</html:link>                  
            </li>
            <li>
                <span> > </span>
                <html:link href="#">Thêm mới ngân hàng</html:link>
            </li>               
        </ul>
    </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
    <html:form action="bankregistview" onsubmit="javascript: save()">
        <span class="sub-title">◊ Thông tin ngân hàng </span>
        <table class="tbl-none-border">
            <tr>
                <th>Tên ngân hàng<span class="required">*</span> :</th>
                <td>
                    <html:text styleId="bankName" name="bankViewHelper" property="bankName" maxlength="200" styleClass="input-long"/>
                </td>
            </tr>
            <tr>
                <th>Thứ tự sắp xếp :</th>
                <td>
                    <html:select styleId="position" name="bankViewHelper" property="position">
                        <html:option value="01">Đầu danh sách</html:option>
                        <html:option value="02">Giữa danh sách</html:option>
                        <html:option value="03">Cuối danh sách</html:option>
                    </html:select>
                </td>
            </tr>
            <tr class="banklist">
                <th>Tiếp sau ngân hàng :</th>
                <td>
                    <html:select name="bankViewHelper" property="orderBankId">
                        <html:optionsCollection name="bankViewHelper" property="bankList" value="orderNumber" label="name" />
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
                            <html:img alt="Lưu" src="./image/btn_save.png" />
                        </html:link>
                    </span>
                    <html:link href="banklistback.do">
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
    
    document.getElementById("bankName").focus();
    
    var val = $('#position option:selected').val();
    if (val == '02') {
    	$('tr.banklist').show();
    } else {
    	$('tr.banklist').hide();
    }
    
    $('#position').change(function(){
    	var val = $('#position option:selected').val();
        if (val == '02') {
            $('tr.banklist').show();
        } else {
            $('tr.banklist').hide();
        }
    });
    
    function save() {
        document.bankForm.action="bankregist.do";
        return true;
    }

</script>