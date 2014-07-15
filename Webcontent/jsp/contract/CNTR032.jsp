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
                    <html:link href="temporarycontractdetailview.do">Chi tiết hợp đồng chờ ký</html:link>
                </li>
                <li>
                    <span> &gt; </span>
                    <html:link href="#">Chỉnh sửa ý kiến</html:link>
                </li>
            </ul>
        </div>


    <%@ include file="/jsp/common/error_message.jsp" %>
    <html:form action="editcontractcommentpost">
	    
	    <table width="65%" class="tbl-non-border" style="margin: 10px 0 0 20px;">
	         <tr>
                <th>Chỉnh sửa ý kiến</th>
                <td colspan="5">
                     <html:textarea styleId="contractComment" name="temporaryContractCommentEditViewHelper" property="comment"
                                        styleClass="input-x-long">
                    </html:textarea>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <html:submit property="btnUpdate">Đưa ý kiến</html:submit>
                    <html:button property="btnCancel" onclick="cancel();">Hủy bỏ</html:button>
                </td>
            </tr>
       </table>
       
    </html:form>
    <%@ include file="/jsp/common/footer.jsp" %>
</html:html>  

<script type="text/javascript">

        $('#contract > em').removeClass("contract-off");
	    $('#contract > em').addClass("contract-on");
	    $('#contract > b').addClass("menu-on");
    
    function cancel() {
        document.temporaryContractCommentForm.action="temporarycontractdetailview.do";
        document.temporaryContractCommentForm.submit();
        return true;
    }
    
</script>