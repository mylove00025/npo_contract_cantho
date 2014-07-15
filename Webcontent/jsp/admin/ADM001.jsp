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
                <span> &gt; </span>
            </li>
            <li>
                <html:link href="#">Danh sách người sử dụng</html:link>
            </li>
        </ul>
    </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
    <html:form action="userlistview" onsubmit="javascript: searchOnClick()">
        <span class="sub-title">◊ Điều kiện tìm kiếm</span>
        <table class="tbl-search" summary="Thông tin tìm kiếm">
            <tr>
                <th id="familyName_th">Họ đệm</th>
                <td id="familyName_td">
                    <html:text styleId="firstControl" property="familyName" name="userListViewHelper" maxlength="40"/>
                </td>
                <td id="firstName_th">Tên <html:text property="firstName" name="userListViewHelper" maxlength="10"/></td>
                <td id="account_th">Tài khoản đăng nhập <html:text property="account" name="userListViewHelper" maxlength="16"></html:text></td>
            </tr>
            <tr>
                <th id="role_th">Chức vụ</th>
                <td id="role_td">
                    <html:select styleId="role" property="role"  name="userListViewHelper" onchange="onchangeSelect(this.id,'00')">
                       <html:optionsCollection property="roleList" name="userListViewHelper" label="name" value="code"/>
                    </html:select>
                </td>
                <td colspan="2" id="activeFlg_tr">Trạng thái hoạt động
                    <html:select styleId="activeFlg" property="activeFlg" name="userListViewHelper" onchange="onchangeSelect(this.id,'00')">
                       <html:option value="00"><bean:message key="item_all"/></html:option>
                       <html:option value="01">Đang hoạt động</html:option>
                       <html:option value="02">Ngừng hoạt động</html:option>
                    </html:select>
                </td>
            </tr>
            <tr>
                <td colspan="4" style="text-align:center; padding: 10px;">
                   <html:image alt="Tìm kiếm" src="./image/btn_search.png"/>
                </td>
            </tr>
        </table>

        <div class="clearfix-left">
            <span>◊ Danh sách người sử dụng</span><br>
        </div>
        <div class="clearfix-right">
            <a href="addnewuser.do" class="button"><img src="./image/btn_add.png" alt="Thêm mới" /></a>
        </div>
        <logic:notEmpty name="userListViewHelper" property="list">
            <table class="tbl-list">
                <tr>
                    <th>Tài khoản đăng nhập</th>
                    <th>Họ tên</th>
                    <th>Ngày sinh</th>
                    <th>Chức vụ</th>
                    <th>Trạng thái hoạt động</th>
                </tr>

                <logic:iterate id="user" name="userListViewHelper" property="list" indexId="i">
                    <%int style = i % 2; %>
                    <tr class="tbl-row<%=style%>">
                        <td>
                            <html:link action="/userlistselect.do" paramId='id' paramName='user' paramProperty='id'>
                                <bean:write name="user" property="account"/>
                            </html:link>
                        </td>
                        <td>
                            <bean:write name="user" property="familyName"/> <bean:write name="user" property="firstName"/>
                        </td>
                        <td><bean:write name="user" property="birthday"/></td>
                        <td><bean:write name="user" property="roleName"/></td>
                        <td style="text-align: center;">
                            <logic:equal value="true" property="activeFlg" name="user">
                            </logic:equal>
                            <logic:equal value="false" property="activeFlg" name="user">
                                <img src="./image/icon_inactive.png"/>
                            </logic:equal>
                        </td>
                    </tr>
                </logic:iterate>

            </table>

            <div class="pager">
                <div class="pager-total">
                     Tổng số
                     <strong><bean:write name="userListViewHelper" property="totalCount"/></strong>
                     người sử dụng
                </div>
                <div>
                    <logic:greaterThan name="userListViewHelper" value="1" property="totalPage">
                             <html:link href="javascript:direction('first')">
                                    <img id="imgfirst" class="pager-first" src="./image/first.png" alt= "first"/>
                            </html:link>
                            <html:link href="javascript:direction('ahead')">
                                    <img id="imgprev" class="pager-first" src="./image/prev.png" alt= "prev"/>
                            </html:link>
                    </logic:greaterThan>
                    <span>
                        Trang
                        <bean:write name="userListViewHelper" property="page"/>
                        /
                        <bean:write name="userListViewHelper" property="totalPage"/>&nbsp;&nbsp;
                    </span>

                    <logic:greaterThan name="userListViewHelper" value="1" property="totalPage">
                        <html:link href="javascript:direction('next')">
                                <img id="imgnext" class="pager-first" src="./image/next.png" alt= "next"/>
                        </html:link>
                        <html:link href="javascript:direction('end')">
                                <img id="imglast" class="pager-first" src="./image/last.png" alt= "last"/>
                        </html:link>
                    </logic:greaterThan>
                </div>
                <html:hidden property="direction"/>
                <html:hidden property="pagerState"/>
            </div>

            <div class="clearfix-right">
                <a href="addnewuser.do" class="button"><img src="./image/btn_add.png" alt="Thêm mới" /></a>
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
     document.userListForm.action="userlistsearch.do";
     return true;
  }

  function direction(data){
      document.userListForm.direction.value=data;
      document.userListForm.action="userlistpage.do";
      document.userListForm.submit();
  }
  
  onchangeSelect("role","00");
  onchangeSelect("activeFlg","00");
</script>