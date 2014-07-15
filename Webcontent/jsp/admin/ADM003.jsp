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
                <html:link href="userlistback.do">Danh sách người sử dụng</html:link>
                <span> &gt; </span>
            </li>
            <li>
                <html:link href="#">Sửa đổi thông tin người sử dụng</html:link>
            </li>
        </ul>
    </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
    <span class="sub-title">◊ Danh sách loại hợp đồng</span>
    <html:form action="edituserview" onsubmit="javascript: saveOnClick()">
    <table class="tbl-none-border" summary="Thông tin tìm kiếm">
        <tr>
            <th id="familyName_th">Họ đệm<span class="required">*</span> :</th>
            <td id="familyName_td">
                <html:text property="familyName" styleId="firstControl" name="userEditViewHelper" maxlength="40" styleClass="input-normal"></html:text>
            </td>
            <th id="firstName_th">Tên<span class="required">*</span> :</th>
            <td id="firstName_td">
                <html:text property="firstName" name="userEditViewHelper" maxlength="10"></html:text>
            </td>
        </tr>
        <tr id="account_tr">
            <th>Tài khoản đăng nhập<span class="required">*</span> :</th>
            <td colspan="3">
                <strong><bean:write  property="account" name="userEditViewHelper"/></strong>
            </td>
        </tr>
        <tr id="password_tr">
            <th>Mật khẩu :</th>
            <td colspan="3">
                <html:password property="password" maxlength="16" styleClass="input-normal"></html:password>
            </td>
        </tr>
        <tr id="rePassword_tr">
            <th>Xác nhận mật khẩu :</th>
            <td colspan="3">
                <html:password property="rePassword" maxlength="16" styleClass="input-normal"></html:password>
            </td>
        </tr>
        <tr>
            <th id="birthday_th">Ngày sinh :</th>
            <td id="birthday_td">
                <html:text styleId="birthday" property="birthday" name="userEditViewHelper" maxlength="10" style="vertical-align:middle;"></html:text>
                <a href="#"><img id="popupCal-1" src="./image/calendar.png" alt="calendar" style="vertical-align: middle;"/></a>
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
            </td>
            <th id="sex_th">Giới tính :</th>
            <td id="sex_td">
                <html:select property="sex" name="userEditViewHelper">
                    <html:option value="true">Nam</html:option>
                    <html:option value="false">Nữ</html:option>
                </html:select>
            </td>
        </tr>
        <tr id="address_tr">
            <th>Địa chỉ  :</th>
            <td colspan="3">
                <html:text property="address" name="userEditViewHelper" maxlength="200" styleClass="input-long"></html:text>
            </td>
        </tr>
        <tr id="email_tr">
            <th>Email :</th>
            <td colspan="3">
                <html:text property="email" name="userEditViewHelper" maxlength="50" styleClass="input-normal"></html:text>
            </td>
        </tr>
        <tr id="telephone_tr">
            <th>Điện thoại cố định :</th>
            <td colspan="3">
                <html:text property="telephone" name="userEditViewHelper" maxlength="16" styleClass="input-normal"></html:text>
            </td>
        </tr>
        <tr id="mobile_tr">
            <th>Điện thoại di động :</th>
            <td colspan="3">
                <html:text property="mobile" name="userEditViewHelper" maxlength="16" styleClass="input-normal"></html:text>
            </td>
        </tr>
        <tr id="role_tr">
            <th>Chức vụ <span class="required">*</span>:</th>
            <td colspan="3">
                <html:select property="role" name="userEditViewHelper" styleId="edit_role">
                    <html:optionsCollection property="roleList" name="userEditViewHelper" label="name" value="code"/>
                </html:select>
            </td>
        </tr>
        <tr id="activeFlg_tr">
            <th>Trạng thái hoạt động :</th>
            <td colspan="3">
                <html:radio property="activeFlg" name="userEditViewHelper" value="true" styleId="activeFlgTrue"/><label for="activeFlgTrue">Hoạt động</label>
                &nbsp;&nbsp;&nbsp;
                <html:radio property="activeFlg" name="userEditViewHelper" value="false" styleId="activeFlgFalse"/><label for="activeFlgFalse">Ngừng hoạt động</label>
            </td>
        </tr>
         <tr>
            <th style="vertical-align:text-top;">Phân quyền</th>
            <td colspan="3">
                <table class="tbl-none-border">
                    <tr>
                        <td colspan="2" style="text-align: left; font-weight: bold">
                            <input id="authority_all" type="checkbox" value="true" onclick="checkAll('authority_all', 'chkId');" />
                            Tất cả các quyền 
                        </td>
                     
                      
                    </tr>
                    <tr style="vertical-align:top;">
                    <td>
                    <table class="tbl-none-border">
                    <tr  >
                     <td  style="padding-left: 20px; text-align: left; font-weight: bold; width: 300px;"> Thông tin ngăn chặn</td>
                     </tr>
                     <tr>
                      <td style="padding-left: 40px;text-align: left;">
                            <html:checkbox styleId="preventAuthority" property="preventAuthority" name="userEditViewHelper" alt="chkId" />
                       <label  for="preventAuthority">
                             Tạo mới dữ liệu ngăn chặn
                             </label>
                        </td>
                        </tr>
                        <tr>
                        <td  style="padding-left: 40px;text-align: left;">
                            <html:checkbox styleId="deletePreventAuthority" property="deletePreventAuthority" name="userEditViewHelper" alt="chkId" />
                        <label for="deletePreventAuthority">
                            Xóa dữ liệu ngăn chặn
                            </label>
                        </td>
                        
                     </tr>
                  
                    </table>
                    </td>
                    <td>
                    <table class="tbl-none-border">
                    <tr>
                     <td style="text-align: left; font-weight: bold; width: 300px;"> Hợp đồng, giao dịch</td>
                     </tr>
                    <tr> <td style="padding-left: 40px; text-align: left;" >
                            <html:checkbox styleId="contractAuthority" property="contractAuthority" name="userEditViewHelper" alt="chkId" />
               <label for="contractAuthority">
                           
                          
                            Tạo mới hợp đồng công chứng
                              </label>
                        </td>
                        </tr>
                        <tr>
                         <td style="padding-left: 40px;text-align: left;" >
                            <html:checkbox styleId ="deleteContractAuthority" property="deleteContractAuthority" name="userEditViewHelper" alt="chkId" />
                        <label for="deleteContractAuthority">
                           
                          
                            Xóa hợp đồng công chứng
                              </label>
                        </td>
                        </tr>
                        <tr><td style="padding-left: 40px;text-align: left;">
                            <html:checkbox styleId="tempContractAuthority" property="tempContractAuthority" name="userEditViewHelper" alt="chkId" />
                        <label for="tempContractAuthority">
                           
                            Tạo mới hợp đồng chờ ký
                            </label>
                        </td></tr>
                        <tr>
                        <td style="padding-left: 40px;text-align: left;">
                            <html:checkbox  styleId="deleteTempContractAuthority" property="deleteTempContractAuthority" name="userEditViewHelper" alt="chkId" />
                          <label for="deleteTempContractAuthority">
                           
                            Xóa hợp đồng chờ ký
                            </label>
                        </td>
                        </tr>
                    </table>
                    </td>
                   
                    </tr>
                    <tr>
                    <td>
                    <table class="tbl-none-border">
                    <tr><td style="padding-left: 20px;text-align: left; font-weight: bold; width: 300px;"> Báo cáo</td></tr>
                    <tr><td style="padding-left: 40px;text-align: left;">
                            <html:checkbox styleId="viewReportAuthority" property="viewReportAuthority" name="userEditViewHelper" alt="chkId" />
                        <label for="viewReportAuthority">
                           
                           Xem báo cáo hợp đồng
                            </label>
                           
                        </td></tr>
                        <tr>
                         <td style="padding-left: 40px;text-align: left;">
                            <html:checkbox styleId ="bankAuthority" property="bankAuthority" name="userEditViewHelper" alt="chkId" />
                                                <label for="bankAuthority">
                           
                           Báo cáo theo ngân  hàng
                            </label>
                           
                        </td></tr>
                    </table>
                    </td>
                    <td>
                    <table class="tbl-none-border">
                    <tr> <td style="text-align: left; font-weight: bold"> Quản trị</td></tr>
                    <tr><td style="padding-left: 40px;text-align: left;">
                            <html:checkbox styleId ="announcementAuthority" property="announcementAuthority" name="userEditViewHelper" alt="chkId" />
                           <label for="announcementAuthority">
                           
                          Quản trị thông báo
                            </label>
                            
                        </td></tr>
                    <tr><td style="padding-left: 40px;text-align: left;">
                            <html:checkbox styleId = "adminAuthority" property="adminAuthority" name="userEditViewHelper" alt="chkId" styleClass="myOption"/>
                        <label for="adminAuthority">
                           
                         Quản trị hệ thống
                            </label>
                            
                        </td></tr>
                    </table>
                    </td>
                    </tr>
                    
                  
                   
                 
                    
                   
                    
                    
                </table>
            </td>
        </tr>
        <tr>
            <td colspan="4" style="text-align:center; padding-top: 10px;">
                <span id="save_on">
                    <html:image alt="Lưu" src="./image/btn_save.png" onclick="stylechange('save_on', 'save_off');"/>
                </span>
                <span id="save_off" style="display: none;">
                    <html:link href="#">
                        <img alt="Lưu" src="./image/btn_save.png"/>
                    </html:link>
                </span>
                <logic:equal value="true" property="canDel" name="userEditViewHelper">
                    <span id="delete_on">
                        <html:link href="#nowhere" onclick="javascript: delOnClick(); stylechange('delete_on','delete_off');">
                            <img alt="Xóa" src="./image/btn_delete.png"/>
                        </html:link>
                    </span>
                    <span id="delete_off" style="display: none">
                        <html:link href="#">
                            <img alt="Xóa" src="./image/btn_delete.png"/>
                        </html:link>
                    </span>
                </logic:equal>
                <html:link href="userlistback.do">
                    <img alt="Hủy bỏ" src="./image/btn_cancel.png"/>
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

  document.getElementById("firstControl").focus();

  <logic:equal value="true" property="hasContract" name="userEditViewHelper">
      $('#edit_role').attr('disabled', 'disabled');
  </logic:equal>

  function checkAll(selector_fire, alt_name) {
      $('input[alt=' + alt_name + ']').attr('checked', $('#' + selector_fire).is(':checked'));
  }

  var LEFT_CAL = Calendar.setup({
      cont: "cont",
      weekNumbers: true,
      selectionType: Calendar.SEL_MULTIPLE,
      showTime: 12
      // titleFormat: "%B %Y"
  });

  function saveOnClick()
  {
      document.userEditForm.action="editusersave.do";
      return true;
  }

 function delOnClick()
  {
      var answer = confirm("<bean:message key='msg_delete_confirm'/>");
      if (answer){
          document.userEditForm.action="edituserdel.do";
          document.userEditForm.submit();
          return true;
      } else {
          return false;
      }
  }
</script>