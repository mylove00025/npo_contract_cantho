<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@page import="java.util.HashMap"%>

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
                <span> &gt; </span>
            </li>
            <li>
                <html:link href="#">Lịch sử thay đổi hợp đồng, giao dịch</html:link>
            </li>                 
	     </ul>
    </div>
    <%@ include file="/jsp/common/error_message.jsp" %>  
                      
    <html:form action="contractHistorylistview" onsubmit="javascript: searchOnClick()">
        <span class="sub-title">◊ Điều kiện tìm kiếm</span>
        <table class="tbl-search" summary="Thông tin tìm kiếm">
            <tr>
                <th>Số hợp đồng</th>
                <td>
                    <html:text styleId="firstControl" property="contractNumber" name="contractHistoryListViewHelper" maxlength="20"/>
                </td>
                <th>Nội dung</th> 
                <td>
                	<html:text property="contractContent" name="contractHistoryListViewHelper" style="width:200px"/>
                </td>
                <td style="text-align:center;">
                   <html:image alt="Tìm kiếm" src="./image/btn_search.png"/>
                </td>
            </tr>
        </table>

        <div class="clearfix-left">
            <span>◊ Danh sách hợp đồng, giao dịch</span><br>
        </div>
        <!--<div class="clearfix-right">
            <a href="addnewuser.do" class="button"><img src="./image/btn_add.png" alt="Thêm mới" /></a>
        </div>-->
        <logic:notEmpty name="contractHistoryListViewHelper" property="contractHistoryList">
            <table class="tbl-list">
                <tr>
                    <th width="10%">Số hợp đồng</th>
                    <th width="58%">Nội dung</th>
                    <th width="8%">Thao tác</th>
                    <th width="12%">Người thực hiện</th>
                    <th width="12%">Ngày thực hiện</th>
                </tr>

                <logic:iterate id="contract" name="contractHistoryListViewHelper" property="contractHistoryList" indexId="i">
                    <%int style = i % 2; %>
                    <tr class="tbl-row<%=style%>">
                    		<bean:define id="contractId" name="contract" property="contractId"></bean:define>
							<bean:define id="Id" name="contract" property="hid"></bean:define>
	                        <%
			    						HashMap params = new HashMap();
										params.put("contractId", contractId);
										params.put("Id", Id);
										pageContext.setAttribute("paramsName", params);
							%>
                        <td>
                            <html:link action="/contractHistoryListselect.do" name="paramsName">
                                <bean:write name="contract" property="contractNumber"/>
                            </html:link>
                        </td>
                        <td>
                            <bean:write name="contract" property="contractContentDisp" filter="false"/>
                        </td>
                        <td><bean:write name="contract" property="executeContent"/></td>
                        <td><bean:write name="contract" property="executePerson"/></td>
                        <td><bean:write name="contract" property="executeDateTime" format="dd/MM/yyyy hh:mm:ss"/></td>
                    </tr>
                </logic:iterate>

            </table>

            <div class="pager">
                <div class="pager-total">
                     Tổng số
                     <strong><bean:write name="contractHistoryListViewHelper" property="totalCount"/></strong>
                     hợp đồng, giao dịch
                </div>
                <div>
                    <logic:greaterThan name="contractHistoryListViewHelper" value="1" property="totalPage">
                             <html:link href="javascript:direction('first')">
                                    <img id="imgfirst" class="pager-first" src="./image/first.png" alt= "first"/>
                            </html:link>
                            <html:link href="javascript:direction('ahead')">
                                    <img id="imgprev" class="pager-first" src="./image/prev.png" alt= "prev"/>
                            </html:link>
                    </logic:greaterThan>
                    <span>
                        Trang
                        <bean:write name="contractHistoryListViewHelper" property="page"/>
                        /
                        <bean:write name="contractHistoryListViewHelper" property="totalPage"/>&nbsp;&nbsp;
                    </span>

                    <logic:greaterThan name="contractHistoryListViewHelper" value="1" property="totalPage">
                        <html:link href="javascript:direction('next')">
                                <img id="imgnext" class="pager-first" src="./image/next.png" alt= "next"/>
                        </html:link>
                        <html:link href="javascript:direction('end')">
                                <img id="imglast" class="pager-first" src="./image/last.png" alt= "last"/>
                        </html:link>
                    </logic:greaterThan>
                </div>
                <html:hidden property="direction"/>
            </div>
        </logic:notEmpty>
    </html:form>

    <%@ include file="/jsp/common/footer.jsp" %>
</html:html>
<script type="text/javascript">
  $('#system > em').removeClass("system-off");
  $('#system > em').addClass("system-on");
  $('#system > b').addClass("menu-on");

  document.getElementById("firstControl").focus();

  function searchOnClick()
  {
     document.contractHistoryListForm.action="contractHistoryListsearch.do";
     return true;
  }

  function direction(data){
      document.contractHistoryListForm.direction.value=data;
      document.contractHistoryListForm.action="contractHistoryListpage.do";
      document.contractHistoryListForm.submit();
  }
  
  //onchangeSelect("role","00");
  //onchangeSelect("activeFlg","00");
</script>