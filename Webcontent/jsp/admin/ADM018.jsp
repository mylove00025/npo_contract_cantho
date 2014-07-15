<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>
    <html:form action="systemconfigview" onsubmit="javascript: save();">
        <div id="navigator">
            <ul class="clearfix">
                <li>
                    <html:img alt="*" src="./image/bullet_square.gif"/>
                </li>
                <li>
                    <a href="userlistview.do">Quản trị hệ thống</a> &gt;
                    <a href="#">Cấu hình hệ thống</a>
                </li>
            </ul>
        </div>
        <%@ include file="/jsp/common/error_message.jsp" %>
        <div><strong><span>◊ Thông tin cấu hình</span></strong></div><br/>
        <table class="tbl-none-border">
            <tr id="notaryOfficeName_tr">
                <th><strong>Tên cơ quan</strong></th>
                <td>
                    <html:text styleId="notaryOfficeName" property="notaryOfficeName" maxlength="100" styleClass="input-x-long"/>
                </td>
            </tr>
            <tr id="notaryOfficeAddress_tr">
                <th><strong>Địa chỉ</strong></th>
                <td>
                    <html:text property="notaryOfficeAddress" maxlength="100" styleClass="input-x-long" />
                </td>
            </tr>
            <tr id="recordPerPage_tr">
                <th><strong>Số bản ghi trên trang</strong></th>
                <td>
                    <html:text property="recordPerPage" maxlength="10" styleClass="input-short"/>
                    (bản ghi)
                </td>
            </tr>

            <tr>
                <th colspan="2"><strong>Cấu hình đồng bộ dữ liệu</strong></th>
            </tr>

            <tr>
                <td colspan="2" style="padding-left: 30px;">
                    <table class="tbl-none-border">
                        <tr id="synchronizeWebserviceUrl_tr">
                            <th>Địa chỉ URL</th>
                            <td>
                                <html:text property="synchronizeWebserviceUrl" styleClass="input-x-long" maxlength="100"/>
                            </td>
                        </tr>
                        <tr id="synchronizePeriod_tr">
                            <th>Khoảng thời gian thực hiện</th>
                            <td>
                                <html:text property="synchronizePeriod" styleClass="input-short" maxlength="10"/>
                                (giây)
                            </td>
                        </tr>
                        <tr id="synchronizeRecord_tr">
                            <th>Số bản ghi trong 1 lần đồng bộ</th>
                            <td>
                                <html:text property="synchronizeRecord" styleClass="input-short" maxlength="10"/>
                                (bản ghi)
                            </td>
                        </tr>
                        <tr>
                            <th id="synchronizeAccount_th">Tài khoản sử dụng đồng bộ</th>
                            <td>
                                <html:text property="synchronizeAccount" styleClass="input-normal" maxlength="100" styleId="synchronizeAccount_td"/>
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <span id="synchronizePassword_tr">
                                    Mật khẩu:&nbsp;&nbsp;
                                    <html:text property="synchronizePassword" maxlength="100" styleClass="input-normal" />
                                </span>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center; padding: 10px;">
                    <html:image alt="Lưu" src="./image/btn_save.png"/>
                </td>
            </tr>
        </table>
        <br/>
        <logic:equal value="true" name="CommonContext" property="userInfo.hiddenFlg">
        <div>
            <strong><span>◊ Thực hiện đồng bộ tất cả dữ liệu</span></strong>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <html:link href="synchronizeall.do">
                <html:img alt="Đồng bộ" src="./image/btn_sync.png" style="vertical-align: middle;"/>
            </html:link>
        </div>   
        <div>
            <strong><span>◊ Tạo chỉ mục tìm kiếm</span></strong>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <html:link href="systemconfigcreateindex.do">
                <html:img alt="Tạo chỉ mục" src="./image/btn_create_index.png" style="vertical-align: middle;"/>
            </html:link>
        </div>   
        <br/>
         <div>
            <strong><span>◊ Khởi tạo lại số hợp đồng</span></strong>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <html:link href="javascript: reset();">
                <html:img alt="Khởi tạo" src="./image/btn_reset_number.png" style="vertical-align: middle;"/>
            </html:link>
        </div> 
        </logic:equal>     
    </html:form>
    <%@ include file="/jsp/common/footer.jsp" %>
</html:html>
<script type="text/javascript">
  //Hightlight menu
  $('#system > em').removeClass("system-off");
  $('#system > em').addClass("system-on");
  $('#system > b').addClass("menu-on");

  document.getElementById("notaryOfficeName").focus();
  function save() {
    document.systemConfigForm.action = "systemconfigupdate.do";
    return true;
  }
  
  function reset() {
  	var answer = confirm ("Bạn có thực sự muốn khởi tạo lại số hợp đồng không?");
  	if (answer) {
	        document.systemConfigForm.action="systemresetnumber.do";
	        document.systemConfigForm.submit();
	        return true;
  	}
  }
  
  
  
</script>