<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>
        <div id="navigator">
            <ul class="clearfix">
                <li>
                    <a href="#">Thay đổi thông tin cá nhân</a>
                </li>
            </ul>
        </div>
        <html:form action="userprofile" onsubmit="javascript: update()">
            <%@ include file="/jsp/common/error_message.jsp" %>
            <div class="sub-title">
                <span><strong>◊ Thông tin tài khoản cá nhân</strong></span>
            </div>
            <table class="tbl-none-border">
                <tr>
                    <th id="familyName_th">Họ đệm<span class="required">*</span> :</th>
                    <td>
                        <span id="familyName_td">
                            <html:text property="familyName" styleClass="input-normal" maxlength="40" styleId="familyName"></html:text>
                        </span>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <span id="firstName_td">
                            Tên<span class="required">*</span> :
                            <html:text property="firstName" maxlength="10"></html:text>
                        </span>
                    </td>
                </tr>
                <tr>
                    <th>Tài khoản đăng nhập :</th>
                    <td>
                        <strong><bean:write name="CommonContext" property="userInfo.account" /></strong>
                    </td>
                </tr>
                <tr>
                    <th valign="top">Mật khẩu :</th>
                    <td>
                        <html:hidden property="isChangePassword" styleId="isChangePassword"/>
                        <div id="changePasswordLink">
                            <a href="#nowhere" onclick="javascript:display_change_pass_form();">Đổi mật khẩu</a>
                        </div>
                        <div id="changePasswordForm" style="display:none;">
                            <a href="#nowhere" onclick="javascript:hide_change_pass_form();">Hủy bỏ đổi mật khẩu</a>
                            <table class="tbl-none-border">
                                <tr>
                                    <th id="password_th">Mật khẩu cũ<span class="required">*</span> :</th>
                                    <td id="password_td">
                                        <html:password property="password"></html:password>
                                    </td>
                                </tr>
                                <tr id="checkpassword_tr">
                                    <th id="newPassword_th">Mật khẩu mới<span class="required">*</span> :</th>
                                    <td id="newPassword_td">
                                        <html:password property="newPassword"></html:password>
                                    </td>
                                </tr>
                                <tr id="checkpassword_th">
                                    <th id="retypePassword_th">Nhập lại mật khẩu mới<span class="required">*</span> :</th>
                                    <td id="retypePassword_td">
                                        <html:password property="retypePassword"></html:password>
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </td>
                </tr>
                <tr id="birthday_tr">
                    <th>Ngày sinh :</th>
                    <td>
                        <html:text property="birthday" styleId="birthday" styleClass="input-normal" maxlength="10"></html:text>
                        <html:img styleId="popupCal-1" src="./image/calendar.png" alt="calendar" styleClass="onmouseover" style="vertical-align: middle;"/>
                        <script type="text/javascript">
                              new Calendar({
                                  inputField: "birthday",
                                  dateFormat: "%d/%m/%Y",
                                  trigger: "popupCal-1",
                                  bottomBar: false,
                                  onSelect: function() {
                                          var date = Calendar.intToDate(this.selection.get());
                                          LEFT_CAL.args.min = date;
                                          LEFT_CAL.redraw();
                                          this.hide();
                                  }
                              });
                        </script>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <span id="sex_td">
                            Giới tính :
                            <html:select property="sex">
                                <html:option value="0">Nam</html:option>
                                <html:option value="1">Nữ</html:option>
                            </html:select>
                        </span>
                    </td>
                </tr>
                <tr id="address_tr">
                    <th>Địa chỉ :</th>
                    <td>
                        <html:text property="address" styleClass="input-long" maxlength="200"></html:text>
                    </td>
                </tr>
                <tr id="email_tr">
                    <th>Email :</th>
                    <td>
                        <html:text property="email" styleClass="input-normal" maxlength="50"></html:text>
                    </td>
                </tr>
                <tr id="telephone_tr">
                    <th>Điện thoại cố định :</th>
                    <td>
                        <html:text property="telephone" styleClass="input-normal" maxlength="16"></html:text>
                    </td>
                </tr>
                <tr id="mobile_tr">
                    <th>Điện thoại di động :</th>
                    <td>
                        <html:text property="mobile" styleClass="input-normal" maxlength="16"></html:text>
                    </td>
                </tr>
                <tr>
                    <th>Chức vụ :</th>
                    <td>
                        <bean:write name="CommonContext" property="userInfo.roleName" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center; padding: 10px;">
                        <html:image alt="Lưu" src="./image/btn_save.png"/>
                    </td>
                </tr>
            </table>
        </html:form>
    <%@ include file="/jsp/common/footer.jsp"%>
</html:html>
<script type="text/javascript">
    document.getElementById("familyName").focus();

    $('#home > em').removeClass("home-off");
    $('#home > em').addClass("home-on");
    $('#home > b').addClass("menu-on");

    var showPasswordBlock = $('#isChangePassword').val();
    if (showPasswordBlock === 'true') {
        display_change_pass_form();
    } else {
        hide_change_pass_form();
    }

    var LEFT_CAL = Calendar.setup({
        cont: "cont",
        weekNumbers: true,
        selectionType: Calendar.SEL_MULTIPLE,
        showTime: 12
        // titleFormat: "%B %Y"
    });

    function update() {
        document.userProfileForm.action='userprofileupdate.do';
        return true;
    }

    function display_change_pass_form() {
        document.getElementById("changePasswordLink").style.display = "none";
        document.getElementById("changePasswordForm").style.display = "";
        document.getElementsByName("isChangePassword")[0].value = true;
    }

    function hide_change_pass_form() {
        document.getElementById("changePasswordLink").style.display = "";
        document.getElementById("changePasswordForm").style.display = "none";
        document.getElementsByName("isChangePassword")[0].value = false;
    }
</script>