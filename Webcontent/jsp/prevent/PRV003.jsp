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
                    <html:link href="#">Sửa đổi thông tin ngăn chặn</html:link>
                </li>
            </ul>
        </div>
        <html:form action="/datapreventeditview" method="post" enctype="multipart/form-data" onsubmit="javascript: update();">
            <html:hidden styleId="isSimpleInsert" property="isSimpleInsert" name="dataPreventViewHelper"/>
            <html:hidden styleId="filePreventExisted" property="filePreventExisted" name="dataPreventViewHelper"/>
            <html:hidden styleId="fileReleaseExisted" property="fileReleaseExisted" name="dataPreventViewHelper"/>

            <%@ include file="/jsp/common/error_message.jsp" %>

            <div >
                <span><strong>◊ Cơ quan đăng ký thông tin ngăn chặn:</strong></span>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <bean:write name="dataPreventViewHelper" property="preventRegistAgency"/>
            </div>

            <table class="tbl-none-border table-inherit">
                <tr>
                    <td colspan="2" style="padding-left: 15px;">
                        <span class="tree_open" style="cursor: pointer;" id="tgProperty"> &nbsp;<strong>Thông tin tài sản</strong></span>

                        <!-- <span id="changetoSimple" class="onmouseover" onclick="changeToSimpleInsert();">[Nhập đơn giản]</span> -->
                        <span id="changetoDetail" class="onmouseover" onclick="changeToDetailInsert();">[Nhập chi tiết]</span>
                    </td>
                </tr>
                <tr>
                    <td id="propertyInfoAll_td">
                        <table id="property_panel" class="tbl-balance-layout">
                            <tr id="propertyType_tr">
                                <th>Loại tài sản:</th>
                                <td>
                                    <html:select name="dataPreventViewHelper" property="propertyType" styleId="propertyType"
                                        onchange="javascript:changeProperty();">
                                        <html:optionsCollection name="dataPreventViewHelper" property="lstProperty" label="name" value="code" />
                                    </html:select>
                                </td>
                            </tr>
 							
                            <!-- vehicles property -->
                            <logic:equal name="context" property="propertyPreventCarLicenseNumber" value="1">
                                <tr class="vehicles" id="carLicenseNumber_tr">
                                    <th>Biển kiểm soát :</th>
                                    <td>
                                        <html:text name="dataPreventViewHelper" property="carLicenseNumber" styleClass="input-x-long" maxlength="200"/>
                                    </td>
                                </tr>
                            </logic:equal>

                            <logic:equal name="context" property="propertyPreventCarRegistNumber" value="1">
                                <tr class="vehicles" id="carRegistNumber_tr">
                                    <th>Số giấy đăng ký :</th>
                                    <td>
                                        <html:text name="dataPreventViewHelper" property="carRegistNumber" styleClass="input-x-long" maxlength="200"/>
                                    </td>
                                </tr>
                            </logic:equal>

                            <%
                            if ("1".equals(context.getPropertyPreventCarIssuePlace()) || "1".equals(context.getPropertyPreventCarIssueDate())) {
                            %>
                            <tr class="vehicles" >
                                <logic:equal name="context" property="propertyPreventCarIssuePlace" value="1">
                                    <th id="carIssuePlace_th">Nơi cấp :</th>
                                </logic:equal>
                                <logic:notEqual name="context" property="propertyPreventCarIssuePlace" value="1">
                                    <th id="carIssueDate_tr">Ngày cấp :</th>
                                </logic:notEqual>
                                <td>
                                    <logic:equal name="context" property="propertyPreventCarIssuePlace" value="1">
                                        <span id="carIssuePlace_tr">
                                            <html:text name="dataPreventViewHelper" property="carIssuePlace" styleClass="input-medium" maxlength="100"/>
                                        </span>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </logic:equal>
                                    <span id="carIssueDate_td">
                                        <logic:equal name="context" property="propertyPreventCarIssuePlace" value="1">
                                            Ngày cấp :
                                        </logic:equal>
                                        <logic:equal name="context" property="propertyPreventCarIssueDate" value="1">
                                            <html:text name="dataPreventViewHelper" property="carIssueDate"
                                                styleId="carIssueDate" style="vertical-align: middle;" maxlength="10"></html:text>
                                            <html:img styleId="popupCal-1" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                                                style="vertical-align: middle;"/>
                                        </logic:equal>
                                    </span>
                                    <script type="text/javascript">
                                          new Calendar({
                                              inputField: "carIssueDate",
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
                            </tr>
                            <% } %>

                            <%
                            if ("1".equals(context.getPropertyPreventCarFrameNumber()) || "1".equals(context.getPropertyPreventCarMachineNumber())) {
                            %>
                            <tr class="vehicles"  id="carFrameNumber_tr">
                                <logic:equal name="context" property="propertyPreventCarFrameNumber" value="1">
                                    <th>Số khung :</th>
                                </logic:equal>
                                <logic:notEqual name="context" property="propertyPreventCarFrameNumber" value="1">
                                    <th id="carMachineNumber_td">Số máy :</th>
                                </logic:notEqual>
                                <td>
                                    <logic:equal name="context" property="propertyPreventCarFrameNumber" value="1">
                                        <html:text name="dataPreventViewHelper" property="carFrameNumber" styleClass="input-normal" maxlength="50"></html:text>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </logic:equal>

                                    <logic:equal name="context" property="propertyPreventCarMachineNumber" value="1">
                                        <span id="carMachineNumber_tr">
                                            <logic:equal name="context" property="propertyPreventCarFrameNumber" value="1">
                                                Số máy :
                                            </logic:equal>
                                            <html:text name="dataPreventViewHelper" property="carMachineNumber" styleClass="input-normal" maxlength="50"></html:text>
                                        </span>
                                    </logic:equal>
                                </td>
                            </tr>
                            <%} %>

                            <!-- land property -->
                            <logic:equal name="context" property="propertyPreventLandAddress" value="1">
                                <tr class="land"  id="landAddress_td">
                                    <th>Địa chỉ :</th>
                                    <td>
                                        <html:text name="dataPreventViewHelper" property="landAddress" styleClass="input-x-long" maxlength="200"></html:text>
                                    </td>
                                </tr>
                            </logic:equal>

                            <logic:equal name="context" property="propertyPreventLandCertificate" value="1">
                                <tr class="land"  id="landCertificate_td">
                                    <th>Số giấy chứng nhận :</th>
                                    <td>
                                        <html:text name="dataPreventViewHelper" property="landCertificate" styleClass="input-x-long" maxlength="200"></html:text>
                                    </td>
                                </tr>
                            </logic:equal>

                            <%
                            if ("1".equals(context.getPropertyPreventLandIssuePlace()) || "1".equals(context.getPropertyPreventLandIssueDate())) {
                            %>
                            <tr class="land" >
                                <logic:equal name="context" property="propertyPreventLandIssuePlace" value="1">
                                    <th id="landIssuePlace_th">Nơi cấp :</th>
                                </logic:equal>
                                <logic:notEqual name="context" property="propertyPreventLandIssuePlace" value="1">
                                    <th id="landIssueDate_tr">Ngày cấp :</th>
                                </logic:notEqual>
                                <td>
                                    <logic:equal name="context" property="propertyPreventLandIssuePlace" value="1">
                                        <span id="landIssuePlace_td">
                                            <html:text name="dataPreventViewHelper" property="landIssuePlace" styleClass="input-medium" maxlength="100"></html:text>
                                        </span>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </logic:equal>
                                    <logic:equal name="context" property="propertyPreventLandIssueDate" value="1">
                                        <span id="landIssueDate_td">
                                            <logic:equal name="context" property="propertyPreventLandIssuePlace" value="1">
                                                Ngày cấp :
                                            </logic:equal>
                                            <html:text name="dataPreventViewHelper" property="landIssueDate" style="vertical-align: middle;" styleId="landIssueDate"
                                                maxlength="10">
                                            </html:text>
                                        </span>
                                        <html:img styleId="popupCal-2" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                                            style="vertical-align: middle;"/>
                                        <script type="text/javascript">
                                              new Calendar({
                                                  inputField: "landIssueDate",
                                                  dateFormat: "%d/%m/%Y",
                                                  trigger: "popupCal-2",
                                                  bottomBar: false,
                                                  onSelect: function() {
                                                          var date = Calendar.intToDate(this.selection.get());
                                                          LEFT_CAL.args.min = date;
                                                          LEFT_CAL.redraw();
                                                          this.hide();
                                                  }
                                              });
                                        </script>
                                    </logic:equal>
                                </td>
                            </tr>
                            <% } %>

                            <%
                            if ("1".equals(context.getPropertyPreventLandNumber()) || "1".equals(context.getPropertyPreventLandMapNumber())) {
                            %>
                            <tr class="land">
                                <logic:equal name="context" property="propertyPreventLandNumber" value="1">
                                    <th id="landNumber_th">Thửa đất số :</th>
                                </logic:equal>
                                <logic:notEqual name="context" property="propertyPreventLandNumber" value="1">
                                    <th id="landMapNumber_tr">Tờ bản đồ số :</th>
                                </logic:notEqual>
                                <td>
                                    <logic:equal name="context" property="propertyPreventLandNumber" value="1">
                                        <html:text styleId="landNumber_td" name="dataPreventViewHelper" property="landNumber" maxlength="20" styleClass="input-normal"></html:text>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    </logic:equal>
                                    <logic:equal name="context" property="propertyPreventLandMapNumber" value="1">
                                        <span id="landMapNumber_td">
                                            <logic:equal name="context" property="propertyPreventLandNumber" value="1">
                                                Tờ bản đồ số :
                                                <html:text name="dataPreventViewHelper" styleId="landMapNumber" property="landMapNumber" maxlength="20" styleClass="input-normal"></html:text>
                                            </logic:equal>
                                        </span>
                                    </logic:equal>
                                </td>
                            </tr>
                            <%} %>

                            <logic:equal name="context" property="propertyPreventLandArea" value="1">
                                <tr class="land">
                                    <th id="landArea_th">Diện tích :</th>
                                    <td>
                                        <html:text styleId="landArea_td" name="dataPreventViewHelper" property="landArea" maxlength="20" styleClass="input-short"></html:text>
                                        <%
                                        if ("1".equals(context.getPropertyPreventLandPrivateArea()) || "1".equals(context.getPropertyPreventLandPublicArea())) {
                                        %>
                                        &nbsp;&nbsp;
                                        Hình thức sử dụng
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        <logic:equal name="context" property="propertyPreventLandPrivateArea" value="1">
                                            <span id="landPrivateArea_td">
                                                Riêng :
                                                <html:text name="dataPreventViewHelper" styleId="landPrivateArea" property="landPrivateArea" maxlength="20" styleClass="input-short"></html:text>
                                            </span>
                                        </logic:equal>
                                        <logic:equal name="context" property="propertyPreventLandPublicArea" value="1">
                                            <span id="landPublicArea_td">
                                                Chung :
                                                <html:text name="dataPreventViewHelper" styleId="landPublicArea" property="landPublicArea" maxlength="20" styleClass="input-short"></html:text>
                                            </span>
                                        </logic:equal>
                                        <% } %>
                                    </td>
                                </tr>
                            </logic:equal>

                            <logic:equal name="context" property="propertyPreventLandUsePurpose" value="1">
                                <tr class="land"  id="landUsePurpose_td">
                                    <th>Mục đích sử dụng :</th>
                                    <td>
                                        <html:text name="dataPreventViewHelper" property="landUsePurpose" styleClass="input-x-long" maxlength="100"></html:text>
                                    </td>
                                </tr>
                            </logic:equal>

                            <logic:equal name="context" property="propertyPreventLandUsePeriod" value="1">
                                <tr class="land"  id="landUsePeriod_td">
                                    <th>Thời hạn sử dụng :</th>
                                    <td>
                                        <html:text name="dataPreventViewHelper" property="landUsePeriod" styleClass="input-x-long" maxlength="100"></html:text>
                                    </td>
                                </tr>
                            </logic:equal>

                            <logic:equal name="context" property="propertyPreventLandUseOrigin" value="1">
                                <tr class="land"  id="landUseOrigin_td">
                                    <th>Nguồn gốc sử dụng :</th>
                                    <td>
                                        <html:text name="dataPreventViewHelper" property="landUseOrigin" styleClass="input-x-long" maxlength="200"></html:text>
                                    </td>
                                </tr>
                            </logic:equal>

                            <logic:equal name="context" property="propertyPreventLandAssociateProperty" value="1">
                                <tr class="land"  id="landAssociateProperty_td">
                                    <th>Tài sản gắn liền với đất :</th>
                                    <td>
                                        <html:text name="dataPreventViewHelper" property="landAssociateProperty" styleClass="input-x-long" maxlength="200"></html:text>
                                    </td>
                                </tr>
                            </logic:equal>

                            <!-- other property -->
                            <tr id="propertyInfo_tr" class="other-simple">
                                <th style="vertical-align: top">Thông tin tài sản</th>
                                <td>
                                    <html:textarea name="dataPreventViewHelper" property="propertyInfo" styleClass="input-x-long"></html:textarea>
                                </td>
                            </tr>
                            <tr id="ownerInfo_tr" class="common">
                                <th>Thông tin chủ sở hữu</th>
                                <td>
                                    <html:text name="dataPreventViewHelper" property="ownerInfo" styleClass="input-x-long" maxlength="500"></html:text>
                                </td>
                            </tr>

                            <tr id="otherInfo_tr" class="common">
                                <th>Thông tin khác</th>
                                <td>
                                    <html:textarea name="dataPreventViewHelper" property="otherInfo" styleClass="input-x-long"></html:textarea>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <table class="tbl-balance-layout" style="margin-left:-5px">
                            <tr>
                                <td width="210px">
                                    <span><strong>◊ Phân loại</strong></span>
                                </td>
                                <td>
                                    <span id="originKindPrevent-span">
                                        <html:radio styleId="originKindPrevent" property="originKind" name="dataPreventViewHelper" value="01"
                                            onclick="toggleClassRY();">
                                            <label for="originKindPrevent">Thông tin ngăn chặn</label>
                                        </html:radio>
                                    </span>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <span id="originKindReference-span">
                                        <html:radio styleId="originKindReference" property="originKind" name="dataPreventViewHelper" value="02"
                                            onclick="toggleClassYR();">
                                            <label for="originKindReference">Thông tin tham khảo</label>
                                        </html:radio>
                                    </span>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>

                <tr>
                    <td colspan="2" style="padding-left: 15px;">
                        <span class="tree_open" id="tgData" style="cursor: pointer;"> &nbsp;<strong>Công văn ngăn chặn</strong></span>

                    </td>
                </tr>

                <tr>
                    <td>
                        <table id="data_panel" class="tbl-balance-layout">
                            <tr id="preventInBookNumber_tr">
                                <th>Số vào sổ công văn :</th>
                                <td>
                                    <html:text name="dataPreventViewHelper" property="preventInBookNumber" styleClass="input-medium" maxlength="40"></html:text>
                                </td>
                            </tr>

                            <tr id="preventPersonInfo_tr">
                                <th>Người (đơn vị) gửi yêu cầu :</th>
                                <td>
                                    <html:text name="dataPreventViewHelper" property="preventPersonInfo" styleClass="input-x-long" maxlength="500"></html:text>
                                </td>
                            </tr>

                            <tr id="preventDocNumber_tr">
                                <th>Số công văn</th>
                                <td>
                                    <html:text name="dataPreventViewHelper" property="preventDocNumber" styleClass="input-medium" maxlength="40"></html:text>
                                </td>
                            </tr>

                            <tr id="preventDocDate_tr">
                                <th>Ngày công văn :</th>
                                <td>
                                    <html:text styleId="preventDocDate" name="dataPreventViewHelper" property="preventDocDate" styleClass="input-normal" maxlength="10"></html:text>
                                    <html:img styleId="popupCal-3" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                                        style="vertical-align: middle;"/>
                                    <script type="text/javascript">
                                          new Calendar({
                                              inputField: "preventDocDate",
                                              dateFormat: "%d/%m/%Y",
                                              trigger: "popupCal-3",
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

                            <tr id="preventDocReceiveDate_tr">
                                <th>Ngày nhận :</th>
                                <td>
                                    <html:text styleId="preventDocReceiveDate" name="dataPreventViewHelper" property="preventDocReceiveDate" styleClass="input-normal" maxlength="10"></html:text>
                                    <html:img styleId="popupCal-4" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                                        style="vertical-align: middle;"/>
                                    <script type="text/javascript">
                                          new Calendar({
                                              inputField: "preventDocReceiveDate",
                                              dateFormat: "%d/%m/%Y",
                                              trigger: "popupCal-4",
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

                            <tr id="preventInputDate_tr">
                                <th>Ngày nhập :</th>
                                <td>
                                    <html:text styleId="preventInputDate" name="dataPreventViewHelper" property="preventInputDate" styleClass="input-normal" maxlength="10"></html:text>
                                    <html:img styleId="popupCal-5" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                                        style="vertical-align: middle;"/>
                                    <script type="text/javascript">
                                          new Calendar({
                                              inputField: "preventInputDate",
                                              dateFormat: "%d/%m/%Y",
                                              trigger: "popupCal-5",
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

                            <tr id="preventDocSummary_tr">
                                <th>Trích yếu :</th>
                                <td>
                                    <html:textarea name="dataPreventViewHelper" property="preventDocSummary" styleClass="input-x-long"></html:textarea>
                                </td>
                            </tr>

                            <tr id="preventNote_tr">
                                <th>Ghi chú :</th>
                                <td>
                                    <html:textarea name="dataPreventViewHelper" property="preventNote" styleClass="input-x-long"></html:textarea>
                                </td>
                            </tr>

                            <logic:equal value="true" name="dataPreventViewHelper" property="filePreventExisted">
                            <tr id="formFilePreventExist_tr" >
                                <th>File đính kèm :</th>
                                <td>
                                    <html:link href="#nowhere" onclick="javascript:download_prevent();">
                                        <bean:write name="dataPreventViewHelper" property="preventFileName"/>
                                    </html:link>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <a href="#nowhere"><span style="text-decoration: underline;" onclick="javascript:remove_file_prevent();">Gỡ bỏ</span></a>
                                </td>
                            </tr>
                            </logic:equal>
                            <tr id="formFilePrevent_tr">
                                <th>File đính kèm :</th>
                                <td>
                                    <html:file size="60" name="dataPreventViewHelper" property="formFilePrevent" />
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <logic:equal value="true" name="dataPreventViewHelper" property="releaseFlg">
                    <tr>
                        <td>
                            <strong>◊ Trạng thái giải tỏa</strong>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <label style="background-color: #FFC000; font-weight: bold; color: #FF0000; padding:5px;">Đã giải tỏa</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <strong>◊ Cơ quan đăng ký thông tin giải tỏa: </strong>&nbsp;&nbsp;&nbsp;
                            <bean:write name="dataPreventViewHelper" property="releaseRegistAgency"/>
                        </td>
                    </tr>
                </logic:equal>
                <tr>
                    <td>
                        <logic:equal value="true" name="dataPreventViewHelper" property="releaseFlg">
                            <span class="tree_open" id="tgRelease" style="cursor: pointer;"> &nbsp;<strong>Công văn giải tỏa</strong></span>
                            <table id="release_panel" class="tbl-balance-layout">
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
                                        <html:link href="#nowhere" onclick="javascript:download_release();">
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
                                        <html:file name="dataPreventViewHelper" property="formFileRelease" />
                                    </td>
                                </tr>
                            </table>
                        </logic:equal>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center; padding: 10px;">
                        <span id="update_on">
                            <html:image alt="Lưu" src="./image/btn_save.png" onclick="stylechange('update_off','update_on');"/>
                        </span>
                        <span id="update_off" style="display: none;">
                            <img alt="Lưu" src="./image/btn_save.png"/>
                        </span>
                        <logic:equal value="true" name="CommonContext" property="preventDataDelete">
	                        <span id="delete_on">
	                            <html:link href="javascript: remove();" onclick="stylechange('delete_off','delete_on');">
	                                <img alt="Xóa" src="./image/btn_delete.png"/>
	                            </html:link>
	                        </span>
	                        <span id="delete_off" style="display: none;">
	                            <html:link href="#nowhere">
	                                <img alt="Xóa" src="./image/btn_delete.png"/>
	                            </html:link>
	                        </span>
                        </logic:equal>
                        <logic:notEqual value="true" name="dataPreventViewHelper" property="releaseFlg">
                            <html:link href="javascript: release();">
                                <img alt="Giải tỏa" src="./image/btn_release.png" />
                            </html:link>
                        </logic:notEqual>
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
document.getElementById("propertyType").focus();

$('#preventTab > em').removeClass("menu-block-contract-off");
$('#preventTab > em').addClass("menu-block-contract-on");
$('#preventTab > b').addClass("menu-on");

$('#changetoSimple').hide();
$('#isSimpleInsert').val('true');
changeToDetailInsert();

function changeProperty() {
    if ($('#isSimpleInsert').val() == 'false') {
        $('.vehicles').hide();
        $('.land').hide();
        $('.other').hide();
        $('.other-simple').hide();
        $('.common').show();
        $('.unselect').hide();
        var value = $('#propertyType option:selected').val();
        if(value == 02) {
            $('.vehicles').show();
            $('#district').hide();
        } else if(value == 01) {
            $('.land').show();
            $('#district').show();
        } else if(value == 99) {
            $('.other-simple').show();
            $('#district').hide();
        } else {
            $('.unselect').show();
        }
    }
}

var LEFT_CAL = Calendar.setup({
    cont: "cont",
    weekNumbers: true,
    selectionType: Calendar.SEL_MULTIPLE,
    showTime: 12
    // titleFormat: "%B %Y"
});

function add() {
    document.dataPreventEditForm.action='datapreventregistregist.do';
    document.dataPreventEditForm.submit();
    return true;
}

function release() {
    var id = "<bean:write name='dataPreventViewHelper' property='id'/>";
    document.dataPreventEditForm.action='datapreventreleaseview.do?id=' + id;
    document.dataPreventEditForm.submit();
    return true;
}

function changeToDetailInsert() {
    $('#isSimpleInsert').val('false');
    $('#changetoDetail').hide();
    $('#changetoSimple').show();
    changeProperty();
}

function changeToSimpleInsert() {
    $('#isSimpleInsert').val('true');
    $('#changetoDetail').show();
    $('#changetoSimple').hide();
    $('.other-simple').show();
    $('.land').hide();
    $('.vehicles').hide();
    $('.common').hide();
}

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

toggleClassYRRY();
function toggleClassYRRY() {
  var val = $('input[name="originKind"]:checked').val();
  if (val == '01') {
    toggleClassRY();
  } else {
    toggleClassYR();
  }
}

function toggleClassRY() {
  $('#originKindReference-span').removeClass('yellow-red');
  $('#originKindPrevent-span').addClass('red-yellow');
}

function toggleClassYR() {
  $('#originKindReference-span').addClass('yellow-red');
  $('#originKindPrevent-span').removeClass('red-yellow');
}

function update() {
    document.dataPreventEditForm.action='datapreventeditdone.do';
    return true;
}

function remove() {
    var answer = confirm ("Bạn có muốn xóa dữ liệu không?");
    if (answer) {
        document.dataPreventEditForm.action='datapreventremove.do';
        document.dataPreventEditForm.submit();
        return true;
    } else {
        $('#delete_off').hide();
        $('#delete_on').show();
    }
}

var filePreventExistedValue = $("#filePreventExisted").val();
if (filePreventExistedValue == 'true') {
    $("#formFilePrevent_tr").hide();
} else {
    $("#formFilePrevent_tr").show();
}

function remove_file_prevent() {
    var answer = confirm ("Bạn có thực sự muốn gỡ bỏ không?");
    if (answer) {
        $("#filePreventExisted").val('false');
        $("#formFilePreventExist_tr").hide();
        $("#formFilePrevent_tr").show();
    }
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