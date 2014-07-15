<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

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
                    <html:link href="#">Chi tiết thông tin ngăn chặn</html:link>
                </li>
            </ul>
        </div>
        <html:form action="/datapreventdetail">
            <%@ include file="/jsp/common/error_message.jsp" %>

            <table width="96%" class="tbl-non-border" style="margin: 5px 0 0 20px;">
                <tr>
                    <td>
                        <strong>◊ Cơ quan đăng ký thông tin ngăn chặn:</strong>&nbsp;&nbsp;&nbsp;&nbsp;
                        <bean:write name="dataPreventViewHelper" property="preventRegistAgency"/>
                    </td>
                </tr>
                <tr>
                    <td style="width: 750px; padding-top: 5px; padding-left: 15px;">
                        <span class="tree_open" style="cursor: pointer;" id="tgProperty"> &nbsp;<strong>Thông tin tài sản</strong></span>
                        <table id="property_panel" class="tbl-detail" style="width: 95%;">
                            <tr>
                                <td style="width: 230px;">Loại tài sản</td>
                                <td>
                                    <logic:equal value="01" property="propertyType" name="dataPreventViewHelper">Nhà đất</logic:equal>
                                    <logic:equal value="02" property="propertyType" name="dataPreventViewHelper">Ô tô, xe máy</logic:equal>
                                    <logic:equal value="99" property="propertyType" name="dataPreventViewHelper">Loại tài sản khác</logic:equal>
                                </td>
                            </tr>
                           
                            <tr>
                                <td>Thông tin tài sản</td>
                                <td><bean:write name="dataPreventViewHelper" property="propertyInfo"/></td>
                            </tr>
                        </table>
                        <br />
                    </td>
                </tr>
                <tr>
                    <td style="height: 23px; padding-bottom: 10px;">
                        <strong>◊ Phân loại</strong>
                        &nbsp;&nbsp;&nbsp;
                        <logic:equal value="01" property="originKind" name="dataPreventViewHelper">
                            <span style="color: yellow; font-weight: bold; background-color: red; padding:5px;">Thông tin ngăn chặn</span>
                        </logic:equal>
                        <logic:equal value="02" property="originKind" name="dataPreventViewHelper">
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
                                <td><bean:write property="preventInBookNumber" name="dataPreventViewHelper"></bean:write></td>
                            </tr>
                            <tr>
                                <td>Người (đơn vị) yêu cầu</td>
                                <td><bean:write property="preventPersonInfo" name="dataPreventViewHelper"></bean:write></td>
                            </tr>
                            <tr>
                                <td>Số công văn</td>
                                <td><bean:write property="preventDocNumber" name="dataPreventViewHelper"></bean:write></td>
                            </tr>
                            <tr>
                                <td>Ngày công văn</td>
                                <td><bean:write property="preventDocDate" name="dataPreventViewHelper"></bean:write></td>
                            </tr>
                            <tr>
                                <td>Ngày nhận</td>
                                <td><bean:write property="preventDocReceiveDate" name="dataPreventViewHelper"></bean:write></td>
                            </tr>
                            <tr>
                                <td>Ngày nhập</td>
                                <td><bean:write property="preventInputDate" name="dataPreventViewHelper"></bean:write></td>
                            </tr>
                            <tr>
                                <td>Trích yếu</td>
                                <td><bean:write property="preventDocSummary" name="dataPreventViewHelper"></bean:write></td>
                            </tr>
                            <tr>
                                <td>Ghi chú</td>
                                <td><bean:write property="preventNote" name="dataPreventViewHelper"></bean:write></td>
                            </tr>
                            <tr>
                                <td>File đính kèm</td>
                                <td>
                                    <logic:notEqual value="--" name="dataPreventViewHelper" property="preventFilePath">
                                        <html:link href="#nowhere" onclick="javascript:downloadPrevent();">
                                            <bean:write name="dataPreventViewHelper" property="preventFileName"/>
                                        </html:link>
                                    </logic:notEqual>
                                    <logic:equal value="--" name="dataPreventViewHelper" property="preventFilePath">
                                        <bean:write name="dataPreventViewHelper" property="preventFileName"/>
                                    </logic:equal>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td rowspan="6" style="padding-left: 17px;" valign="top">
                        <span class="tree_open" style="cursor: pointer;" id="tgHistory"> &nbsp;<strong>Lịch sử thay đổi thông tin</strong></span>
                        <table class="tbl-list" id="history_panel">
                            <tr>
                                <th>Thời điểm</th>
                                <th>Thao tác</th>
                                <th>Người thực hiện</th>
                            </tr>
                            <logic:iterate id="item" property="lstHistoryInfo" name="dataPreventViewHelper">
                                <tr style="background-color: rgb(255, 255, 255);">
                                    <td><bean:write property="executeDateTime" name="item" format="dd/MM/yyyy HH:mm:ss"></bean:write></td>
                                    <td><bean:write property="executeContent" name="item"></bean:write></td>
                                    <td><bean:write property="executePerson" name="item"></bean:write></td>
                                </tr>
                            </logic:iterate>
                        </table>
                    </td>
                </tr>
                <logic:equal value="false" name="dataPreventViewHelper" property="releaseFlg">
                    <tr valign="top"><td></td></tr>
                    <tr valign="top"><td></td></tr>
                    <tr valign="top"><td></td></tr>
                    <tr valign="top"><td></td></tr>
                    <tr valign="top"><td></td></tr>
                </logic:equal>
                <logic:equal value="true" name="dataPreventViewHelper" property="releaseFlg">
                    <tr valign="top" >
                        <td style="height: 23px; padding-top: 10px; padding-bottom: 10px;">
                            <strong>◊ Trạng thái giải tỏa</strong>&nbsp;&nbsp;&nbsp;
                            <label style="background-color: #FFC000; font-weight: bold; color: #FF0000; padding:5px;">Đã giải tỏa</label>
                        </td>
                    </tr>
                    <tr valign="top">
                        <td style="height: 23px;">
                            <strong>◊ Cơ quan đăng ký thông tin giải tỏa:</strong>&nbsp;&nbsp;&nbsp;&nbsp;
                            <bean:write name="dataPreventViewHelper" property="releaseRegistAgency"/>
                        </td>
                    </tr>
                    <tr valign="top">
                        <td style="padding-left: 15px; height: 23px;">
                            <span class="tree_open" style="cursor: pointer;" id="tgRelease">
                                 &nbsp;<strong>Công văn giải tỏa</strong>
                            </span>
                        </td>
                    </tr>
                    <tr valign="top">
                        <td id="release_panel" style="height: 23px; padding-left: 15px">
                            <table class="tbl-detail" style="width: 95%;">
                                <tr>
                                    <td style="width: 230px;">Số vào sổ công văn</td>
                                    <td><bean:write property="releaseInBookNumber" name="dataPreventViewHelper"></bean:write></td>
                                </tr>
                                <tr>
                                    <td>Người (đơn vị) yêu cầu</td>
                                    <td><bean:write property="releasePersonInfo" name="dataPreventViewHelper"></bean:write></td>
                                </tr>
                                <tr>
                                    <td>Số công văn</td>
                                    <td><bean:write property="releaseDocNumber" name="dataPreventViewHelper"></bean:write></td>
                                </tr>
                                <tr>
                                    <td>Ngày công văn</td>
                                    <td><bean:write property="releaseDocDate" name="dataPreventViewHelper"></bean:write></td>
                                </tr>
                                <tr>
                                    <td>Ngày nhận</td>
                                    <td><bean:write property="releaseDocReceiveDate" name="dataPreventViewHelper"></bean:write></td>
                                </tr>
                                <tr>
                                    <td>Ngày nhập</td>
                                    <td><bean:write property="releaseInputDate" name="dataPreventViewHelper"></bean:write></td>
                                </tr>
                                <tr>
                                    <td>Trích yếu</td>
                                    <td><bean:write property="releaseDocSummary" name="dataPreventViewHelper"></bean:write></td>
                                </tr>
                                <tr>
                                    <td>Ghi chú</td>
                                    <td><bean:write property="releaseNote" name="dataPreventViewHelper"></bean:write></td>
                                </tr>
                                <tr>
                                    <td>File đính kèm</td>
                                    <td>
                                        <logic:notEqual value="--" name="dataPreventViewHelper" property="releaseFilePath">
                                            <html:link href="#nowhere" onclick="javascript:downloadRelease();">
                                                <bean:write name="dataPreventViewHelper" property="releaseFileName"/>
                                            </html:link>
                                        </logic:notEqual>
                                        <logic:equal value="--" name="dataPreventViewHelper" property="releaseFilePath">
                                            <bean:write name="dataPreventViewHelper" property="releaseFileName"/>
                                        </logic:equal>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr valign="top"><td></td></tr>
                </logic:equal>
                <tr>
                    <td align="center">
                      <logic:equal value="true" property="isNotaryOfficeData" name="dataPreventViewHelper">
                      	<logic:equal value="true" name="CommonContext" property="preventDataDelete">
	                              
	                                    <html:link href="javascript: remove();">
	                                        <img alt="Xóa" src="./image/btn_delete.png"/>
	                                    </html:link>
	                               
                                </logic:equal>
                        <logic:equal value="true" name="CommonContext" property="preventData">
                          
                                <html:link styleId="btnEdit" href="#" onclick="edit();">
                                    <img alt="Chỉnh sửa" src="./image/btn_edit.png"/>
                                </html:link>
                                
                           
                            <logic:equal value="true" name="dataPreventViewHelper" property="fromRegistScreen">
                                <html:link href="datapreventregistview.do">
                                    <img alt="Tiếp tục thêm mới" src="./image/btn_continue_add.png"/>
                                </html:link>
                            </logic:equal>
                          
                                <logic:notEqual value="true" name="dataPreventViewHelper" property="releaseFlg">
                                    <html:link href="javascript: release();">
                                        <img alt="Giải tỏa" src="./image/btn_release.png"/>
                                    </html:link>
                                </logic:notEqual>
                             </logic:equal>
                        </logic:equal>
                        <html:link href="preventlistback.do">
                            <img alt="Quay lại danh sách" src="./image/btn_list_back.png"/>
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

    <logic:equal value="true" property="isNotaryOfficeData" name="dataPreventViewHelper">
        <logic:equal value="true" name="CommonContext" property="preventData">
            document.getElementById("btnEdit").focus();
        </logic:equal>
    </logic:equal>

    function downloadPrevent() {
        document.dataPreventDetailForm.action='detaildownloadfile.do?file=prevent';
        document.dataPreventDetailForm.submit();
    }

    function downloadRelease() {
        document.dataPreventDetailForm.action='detaildownloadfile.do?file=release';
        document.dataPreventDetailForm.submit();
    }

    function edit() {
        document.dataPreventDetailForm.action='datapreventeditview.do?id=' + <bean:write name="dataPreventViewHelper" property="id"/>;
        document.dataPreventDetailForm.submit();
    }

    function release() {
        var id = "<bean:write name='dataPreventViewHelper' property='id'/>";
        document.dataPreventDetailForm.action='datapreventreleaseview.do?id=' + id;
        document.dataPreventDetailForm.submit();
    }

    function remove() {
        var answer = confirm ("Bạn có muốn xóa dữ liệu không?");
        if (answer) {
            document.dataPreventDetailForm.action='datapreventremove.do';
            document.dataPreventDetailForm.submit();
            return true;
        } 
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

    $('#tgHistory').click(function() {
        $(this).toggleClass('tree_close');
        $(this).toggleClass('tree_open');
        $('#history_panel').toggle();
    });
</script>