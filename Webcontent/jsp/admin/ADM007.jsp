<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.servletsuite.com/servlets/tooltip" prefix="t" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>     
    <html:form action="banklistview" onsubmit="javascript: searchOnClick()">     
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
                <html:link href="#">Danh sách ngân hàng</html:link>
            </li>
        </ul>
    </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
    <span class="sub-title">◊ Điều kiện tìm kiếm</span>
        <table class="tbl-search" summary="Thông tin tìm kiếm">
            <tr>
                <th>Tên ngân hàng</th>
                <td>
                    <html:text styleId="firstControl" property="bankName" name="bankListViewHelper" styleClass="input-long" maxlength="200"/>
                </td>  
                <td style="text-align:center; padding: 10px;">
                    <html:image alt="Tìm kiếm" src="./image/btn_search.png"/>
                </td>            
            </tr>          
        </table>
    <div>
          <div class="clearfix-left">
                <span>◊ Danh sách ngân hàng</span>
            </div>
    </div>  
    <div class="clearfix-right">       
    
    			<html:link href="orderbankbyname.do">
                    <html:img alt="sap xep" src="./image/btn_order_by_name.png"/>
                </html:link> 
                         
                <html:link href="bankregistview.do">
                    <html:img alt="Them moi" src="./image/btn_add.png"/>
                </html:link>                
            </div>
    <logic:notEmpty name="bankListViewHelper" property="list">
            <table class="tbl-list">
                <tr>
                    <th style="text-align: center; width:8%">STT</th>
                    <th>Tên ngân hàng</th>
                </tr>  
                <bean:define id="firstIndex" property="firstIndex" name="bankListViewHelper" type="java.lang.Integer"/>     
                <logic:iterate id="item" name="bankListViewHelper" property="list" indexId="i">
                    <tr class="tbl-row<%=i % 2%>">
                        <td style="text-align: center; width:8%">
                            <%=(firstIndex + (i + 1))%>
                        </td>
                        <td >
                        	<html:link action="/bankupdateview.do" paramId='id' paramName='item' paramProperty='id'>
                                <bean:write name="item" property="name" />
                            </html:link>                     
                        </td>                       
                    </tr>    
                </logic:iterate>
            </table> 
            <logic:greaterThan name="bankListViewHelper" property="totalCount" value="0">
            <div class="pager">
                <div class="pager-total">Tổng số <strong><bean:write name="bankListViewHelper" property="totalCount"/></strong> ngân hàng</div>
                <div>
                    <logic:greaterThan name="bankListViewHelper" property="totalPage" value="1">
                        <html:link href="javascript:direction('first')">        
                            <img class="pager-first" src="./image/first.png" alt= "first"/>
                        </html:link>
                        <html:link href="javascript:direction('ahead')">
                            <img class="pager-prev" src="./image/prev.png" alt= "prev"/>
                    	</html:link>
                    </logic:greaterThan>
                    <span>
                        Trang&nbsp;
                        <bean:write name="bankListViewHelper" property="page" format="##########"/>
                         /<bean:write name="bankListViewHelper" property="totalPage" format="##########"/>
                    </span>
                    <logic:greaterThan name="bankListViewHelper" property="totalPage" value="1">
                        <html:link href="javascript:direction('next')">
                            <img class="pager-next" src="./image/next.png" alt= "next"/>
                        </html:link>
                        <html:link href="javascript:direction('end')">
                            <img class="pager-last" src="./image/last.png" alt= "last"/>
                    	</html:link>
                    </logic:greaterThan>
                </div>
            </div>
            </logic:greaterThan>       
          <html:hidden property="direction"/>   
          <div class="clearfix-right">
                <html:link href="bankregistview.do">
                    <html:img alt="Them moi" src="./image/btn_add.png"/>
                </html:link>
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
     document.bankListForm.action="banklistsearch.do";
     return true;
  }
  
  function direction(data){
      document.bankListForm.direction.value=data;
      document.bankListForm.action="banklistpage.do";
      document.bankListForm.submit();

  }
</script>