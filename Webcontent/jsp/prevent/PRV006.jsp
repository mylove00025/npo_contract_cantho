<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<style>
    .tbl-balance-layout th{
        width: 155px;
    }
    .red-yellow {
        background-color: red;
        padding:5px;
    }
    .red-yellow label {
        color: yellow;
        font-weight: bold;
    }

    .yellow-red {
        background-color: yellow;
        padding:5px;
    }
    .yellow-red label {
        color: red;
        font-weight: bold;
    }
    .tbl-release th {
        text-align: left;
        min-width: 200px;
        padding-left: 10px;
    }
</style>

<html:html>
    <%@ include file="/jsp/common/header.jsp" %>
        <div id="navigator">
            <ul class="clearfix">
                <li>
                    <html:img alt="*" src="./image/bullet_square.gif"/>
                </li>
                <li>
                    <html:link href="preventlistview.do">
                        Tra cứu thông tin ngăn chặn
                    </html:link>
                    <span> &gt; </span>
                </li>
                <li>
                    <html:link href="#">Giải tỏa thông tin ngăn chặn</html:link>
                </li>
            </ul>
        </div>
        <html:form action="/datapreventreleaseview" method="post" enctype="multipart/form-data" onsubmit="javascript: release();">
            <html:hidden styleId="isSimpleInsert" property="isSimpleInsert" name="dataPreventViewHelper"/>
            <html:hidden styleId="filePreventExisted" property="filePreventExisted" name="preventDetailContext"/>
            <html:hidden styleId="fileReleaseExisted" property="fileReleaseExisted" name="dataPreventViewHelper"/>

            <%@ include file="/jsp/common/error_message.jsp" %>

            <table width="96%" class="tbl-non-border" style="margin: 5px 0 0 20px;">
                <tr>
                    <td>
                        <strong>◊ Cơ quan đăng ký thông tin ngăn chặn:</strong>&nbsp;&nbsp;&nbsp;&nbsp;
                        <bean:write name="preventDetailContext" property="preventRegistAgency"/>
                    </td>
                </tr>
                <tr>
                    <td style="width: 750px; padding-top: 5px; padding-left: 15px;">
                        <span class="tree_open" style="cursor: pointer;" id="tgProperty"> &nbsp;<strong>Thông tin tài sản</strong></span>
                        <table id="property_panel" class="tbl-detail" style="width: 95%;">
                            <tr>
                                <td style="width: 230px;">Loại tài sản</td>
                                <td>
                                    <logic:equal value="01" property="propertyType" name="preventDetailContext">Nhà đất</logic:equal>
                                    <logic:equal value="02" property="propertyType" name="preventDetailContext">Ô tô, xe máy</logic:equal>
                                    <logic:equal value="99" property="propertyType" name="preventDetailContext">Loại tài sản khác</logic:equal>
                                </td>
                            </tr>
                            
                            <tr>
                                <td>Thông tin tài sản</td>
                                <td><bean:write name="preventDetailContext" property="propertyInfo"/></td>
                            </tr>
                        </table>
                        <br />
                    </td>
                </tr>
                <tr>
                    <td style="height: 23px; padding-bottom: 10px;">
                        <strong>◊ Phân loại</strong>
                        &nbsp;&nbsp;&nbsp;
                        <logic:equal value="01" property="originKind" name="preventDetailContext">
                            <span style="color: yellow; font-weight: bold; background-color: red; padding:5px;">Thông tin ngăn chặn</span>
                        </logic:equal>
                        <logic:equal value="02" property="originKind" name="preventDetailContext">
                            <span style="color: red; font-weight: bold; background-color: yellow; padding:5px;">Thông tin tham khảo</span>
                        </logic:equal>
                    </td>
                </tr>
                <tr>
                    <td valign="top" style="padding-left: 15px;">
                        <span class="tree_open" style="cursor: pointer;" id="tgData"> &nbsp;<strong>Công văn ngăn chặn</strong></span>
                        <table id="data_panel" class="tbl-detail" style="width: 95%;">
                            <tr>
                                <td style="width: 230px;">Số vào sổ công văn</td>
                                <td><bean:write property="preventInBookNumber" name="preventDetailContext"></bean:write></td>
                            </tr>
                            <tr>
                                <td>Người (đơn vị) yêu cầu</td>
                                <td><bean:write property="preventPersonInfo" name="preventDetailContext"></bean:write></td>
                            </tr>
                            <tr>
                                <td>Số công văn</td>
                                <td><bean:write property="preventDocNumber" name="preventDetailContext"></bean:write></td>
                            </tr>
                            <tr>
                                <td>Ngày công văn</td>
                                <td><bean:write property="preventDocDate" name="preventDetailContext"></bean:write></td>
                            </tr>
                            <tr>
                                <td>Ngày nhận</td>
                                <td><bean:write property="preventDocReceiveDate" name="preventDetailContext"></bean:write></td>
                            </tr>
                            <tr>
                                <td>Ngày nhập</td>
                                <td><bean:write property="preventInputDate" name="preventDetailContext"></bean:write></td>
                            </tr>
                            <tr>
                                <td>Trích yếu</td>
                                <td><bean:write property="preventDocSummary" name="preventDetailContext"></bean:write></td>
                            </tr>
                            <tr>
                                <td>Ghi chú</td>
                                <td><bean:write property="preventNote" name="preventDetailContext"></bean:write></td>
                            </tr>
                            <tr>
                                <td>File đính kèm</td>
                                <td>
                                    <logic:notEqual value="--" name="preventDetailContext" property="preventFilePath">
                                        <html:link href="#nowhere" onclick="javascript:downloadPrevent();">
                                            <bean:write name="preventDetailContext" property="preventFileName"/>
                                        </html:link>
                                    </logic:notEqual>
                                    <logic:equal value="--" name="preventDetailContext" property="preventFilePath">
                                        <bean:write name="preventDetailContext" property="preventFileName"/>
                                    </logic:equal>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td style="padding-left: 16px; padding-top: 10px;">
                        <span class="tree_open" id="tgRelease" style="cursor: pointer;"> &nbsp;<strong>Công văn giải tỏa</strong></span>
                        <table id="release_panel" class="tbl-balance-layout tbl-release">
                            <tr id="releaseInBookNumber_tr">
                                <th>Số vào sổ công văn :</th>
                                <td>
                                    <html:text name="dataPreventViewHelper" property="releaseInBookNumber" styleClass="input-medium" maxlength="40"></html:text>
                                </td>
                            </tr>

                            <tr id="releasePersonInfo_tr">
                                <th>Người (đơn vị) gửi yêu cầu :</th>
                                <td>
                                    <html:text name="dataPreventViewHelper" property="releasePersonInfo" styleClass="input-x-long" maxlength="500"></html:text>
                                </td>
                            </tr>

                            <tr id="releaseDocNumber_tr">
                                <th>Số công văn</th>
                                <td>
                                    <html:text name="dataPreventViewHelper" property="releaseDocNumber" styleClass="input-medium" maxlength="40"></html:text>
                                </td>
                            </tr>

                            <tr id="releaseDocDate_tr">
                                <th>Ngày công văn :</th>
                                <td>
                                    <html:text styleId="releaseDocDate" name="dataPreventViewHelper" property="releaseDocDate" styleClass="input-normal" maxlength="10"></html:text>
                                    <html:img styleId="popupCal-6" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                                        style="vertical-align: middle;"/>
                                    <script type="text/javascript">
                                          new Calendar({
                                              inputField: "releaseDocDate",
                                              dateFormat: "%d/%m/%Y",
                                              trigger: "popupCal-6",
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
                            </tr>

                            <tr id="releaseDocReceiveDate_tr">
                                <th>Ngày nhận :</th>
                                <td>
                                    <html:text styleId="releaseDocReceiveDate" name="dataPreventViewHelper" property="releaseDocReceiveDate" styleClass="input-normal" maxlength="10"></html:text>
                                    <html:img styleId="popupCal-7" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                                        style="vertical-align: middle;"/>
                                    <script type="text/javascript">
                                          new Calendar({
                                              inputField: "releaseDocReceiveDate",
                                              dateFormat: "%d/%m/%Y",
                                              trigger: "popupCal-7",
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
                            </tr>

                            <tr id="releaseInputDate_tr">
                                <th>Ngày nhập :</th>
                                <td>
                                    <html:text styleId="releaseInputDate" name="dataPreventViewHelper" property="releaseInputDate" styleClass="input-normal" maxlength="10"></html:text>
                                    <html:img styleId="popupCal-8" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                                        style="vertical-align: middle;"/>
                                    <script type="text/javascript">
                                          new Calendar({
                                              inputField: "releaseInputDate",
                                              dateFormat: "%d/%m/%Y",
                                              trigger: "popupCal-8",
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
                            </tr>

                            <tr id="releaseDocSummary_tr">
                                <th>Trích yếu :</th>
                                <td>
                                    <html:textarea name="dataPreventViewHelper" property="releaseDocSummary" styleClass="input-x-long"></html:textarea>
                                </td>
                            </tr>

                            <tr id="releaseNote_tr">
                                <th>Ghi chú :</th>
                                <td>
                                    <html:textarea name="dataPreventViewHelper" property="releaseNote" styleClass="input-x-long"></html:textarea>
                                </td>
                            </tr>

                            <logic:equal value="true" name="dataPreventViewHelper" property="fileReleaseExisted">
                            <tr id="formFileReleaseExist_tr" >
                                <th>File đính kèm :</th>
                                <td>
                                    <html:link href="#" onclick="javascript:download_Release();">
                                        <bean:write name="dataPreventViewHelper" property="releaseFileName"/>
                                    </html:link>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <a href="#nowhere"><span style="text-decoration: underline;" onclick="javascript:remove_file_release();">Gỡ bỏ</span></a>
                                </td>
                            </tr>
                            </logic:equal>
                            <tr id="formFileRelease_tr">
                                <th>File đính kèm :</th>
                                <td>
                                    <html:file size="60" name="dataPreventViewHelper" property="formFileRelease" />
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center; padding: 10px;">
                        <span id="update_on">
                            <html:image alt="Lưu" src="./image/btn_save.png" onclick="stylechange('update_off','update_on');"/>
                        </span>
                        <span id="update_off" style="display: none;">
                            <html:link href="#">
                                <img alt="Lưu" src="./image/btn_save.png"/>
                            </html:link>
                        </span>
                        <html:link href="preventlistback.do">
                            <img alt="Hủy bỏ" src="./image/btn_cancel.png"/>
                        </html:link>
                    </td>
                </tr>
            </table>
        </html:form>
    <%@ include file="/jsp/common/footer.jsp"%>
</html:html>
<script type="text/javascript">

$('#preventTab > em').removeClass("menu-block-contract-off");
$('#preventTab > em').addClass("menu-block-contract-on");
$('#preventTab > b').addClass("menu-on");

var LEFT_CAL = Calendar.setup({
    cont: "cont",
    weekNumbers: true,
    selectionType: Calendar.SEL_MULTIPLE,
    showTime: 12
    // titleFormat: "%B %Y"
});

$('#tgProperty').click(function() {
    $(this).toggleClass('tree_close');
    $(this).toggleClass('tree_open');
    $('#property_panel').toggle();
});

$('#tgData').click(function() {
    $(this).toggleClass('tree_close');
    $(this).toggleClass('tree_open');
    $('#data_panel').toggle();
});

$('#tgRelease').click(function() {
    $(this).toggleClass('tree_close');
    $(this).toggleClass('tree_open');
    $('#release_panel').toggle();
});

function toogleElement(id) {
    $(this).toggleClass('tree_close');
    $(this).toggleClass('tree_open');
    $('#' + id).toggle();
}

function release() {
    var id = "<bean:write name='dataPreventViewHelper' property='id'/>";
    document.dataPreventEditForm.action='datapreventreleasedone.do?id=' + id;
    return true;
}

var fileReleaseExistedValue = $("#fileReleaseExisted").val();
if (fileReleaseExistedValue == 'true') {
    $("#formFileRelease_tr").hide();
} else {
    $("#formFileRelease_tr").show();
}

function remove_file_release() {
    var answer = confirm ("Bạn có thực sự muốn gỡ bỏ không?");
    if (answer) {
        $("#fileReleaseExisted").val('false');
        $("#formFileReleaseExist_tr").hide();
        $("#formFileRelease_tr").show();
    }
}
function download_prevent() {
    document.dataPreventEditForm.action='downloadfile.do?file=prevent';
    document.dataPreventEditForm.submit();
}

function download_release() {
    document.dataPreventEditForm.action='downloadfile.do?file=release';
    document.dataPreventEditForm.submit();
}
</script>