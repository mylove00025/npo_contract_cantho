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
                    <html:link href="#">Chi tiết lịch sử giao dịch tài sản</html:link>
                </li>
            </ul>
        </div>
        <div>
            <span><strong>◊ Thông tin chi tiết lịch sử giao dịch tài sản</strong></span>
        </div>
            <%@ include file="/jsp/common/error_message.jsp" %>
            <table style="margin: 10px auto auto 25px;">
                <tr>
                    <td>
                        <strong>Thông tin tài sản</strong>
                        <table class="tbl-detail" style="width: 95%;">
                            <tr id="propertyType_tr">
                                <th>Tài sản</th>
                                <td>
                                    <logic:equal value="01" name="contractPropertyViewHelper" property="propertyType">
                                        Nhà đất
                                    </logic:equal>
                                    <logic:equal value="02" name="contractPropertyViewHelper" property="propertyType">
                                        Ô tô
                                    </logic:equal>
                                    <logic:equal value="03" name="contractPropertyViewHelper" property="propertyType">
                                        Xe máy
                                    </logic:equal>
                                    <logic:equal value="04" name="contractPropertyViewHelper" property="propertyType">
                                        Tài sản khác
                                    </logic:equal>
                                </td>
                            </tr>

                        <!-- O to -->
                        <logic:equal value="02" name="contractPropertyViewHelper" property="propertyType">
                            <!-- vehicles property -->
                            <tr class="vehicles" id="vehicleCode_tr">
                                <th>Biển kiểm soát </th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="code"/>
                                </td>
                            </tr>
                            <tr class="vehicles" >
                                <th id="vehicleProvince_th">Nơi cấp </th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="districtName"/>
                                    &nbsp;
                                    <bean:write name="contractPropertyViewHelper" property="provinceName"/>
                                </td>
                            </tr>
                            <tr class="vehicles" id="frameNumber_tr">
                                <th>Số khung </th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="frameNumber"/>
                                </td>
                            </tr>
                            <tr class="vehicles">
                                <th>Ngày cấp</th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="givenDate" />
                                </td>
                            </tr>
                            <tr class="vehicles" id="machineNumber_tr">
                                <th>Số máy </th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="machineNumber"/>
                                </td>
                            </tr>
                        </logic:equal>

                        <!-- Xe may -->
                        <logic:equal value="03" name="contractPropertyViewHelper" property="propertyType">
                            <!-- vehicles property -->
                            <tr class="vehicles">
                                <th>Biển kiểm soát </th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="code"/>
                                </td>
                            </tr>
                            <tr class="vehicles" >
                                <th>Nơi cấp </th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="districtName"/>
                                    &nbsp;
                                    <bean:write name="contractPropertyViewHelper" property="provinceName"/>
                                </td>
                            </tr>
                            <tr class="vehicles">
                                <th>Số khung </th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="frameNumber"/>
                                </td>
                            </tr>
                            <tr class="vehicles">
                                <th>Ngày cấp</th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="givenDate" />
                                </td>
                            </tr>
                            <tr class="vehicles">
                                <th>Số máy </th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="machineNumber"/>
                                </td>
                            </tr>
                        </logic:equal>

                        <!-- Nha dat -->
                        <logic:equal value="01" name="contractPropertyViewHelper" property="propertyType">
                            <!-- land property -->
                            <tr class="land" id="landProvince_tr">
                                <th>Tỉnh/thành</th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="provinceName"/>
                                </td>
                            </tr>
                            <tr class="land" id="district_tr">
                                <th>Quận/huyện</th>
                                <td id="districtTd">
                                    <bean:write name="contractPropertyViewHelper" property="districtName"/>
                                </td>
                            </tr>
                            <tr class="land" >
                                <th id="landCode_th">Số giấy chứng nhận </th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="code"/>
                                </td>
                            </tr>
                            <tr>
                                <th>Ngày cấp</th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="givenDate"/>
                                </td>
                            </tr>
                            <tr class="land"  id="mapNumber_tr">
                                <th>Số tờ bản đồ</th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="mapNumber"/>
                                </td>
                            </tr>
                            <tr class="land"  id="landNumber_tr">
                                <th>Số thửa đất</th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="landNumber"/>
                                </td>
                            </tr>
                            <tr class="land"  id="landAddress_tr">
                                <th>Địa chỉ nhà đất</th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="landAddress"/>
                                </td>
                            </tr>
                        </logic:equal>

                        <!-- Other -->
                        <logic:equal value="99" name="contractPropertyViewHelper" property="propertyType">
                            <!-- other property -->
                            <tr class="other"  id="otherCode">
                                <th>Mã số tài sản</th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="code"/>
                                </td>
                            </tr>
                            <tr class="other"  id="otherInfo_tr">
                                <th>Thông tin khác</th>
                                <td colspan="2" style="max-width: 400px; ">
                                    <bean:write name="contractPropertyViewHelper" property="otherInfo"/>
                                </td>
                            </tr>
                        </logic:equal>

                        </table>
                    </td>
                </tr>
                <tr>
                    <td style="padding-top: 15px;">
                        <strong>Chủ sở hữu</strong>
                        <table class="tbl-detail" style="width: 95%;">
                            <tr id="ownerName_tr">
                                <th>Tên</th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="ownerName"/>
                                </td>
                            </tr>
                            <tr id="ownerIdCard_tr">
                                <th>Mã số định danh</th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="ownerIdCard"/>
                                </td>
                            </tr>
                            <tr id="ownerAddress_tr">
                                <th>Địa chỉ </th>
                                <td>
                                    <bean:write name="contractPropertyViewHelper" property="ownerAddress"/>
                                </td>
                            </tr>
                        </table>
                        <br />
                    </td>
                </tr>
                <tr>
                    <td style="padding-top: 15px;">
                        <strong>Lịch sử giao dịch tài sản</strong>
                        <table class="tbl-list" style="margin: 3px auto auto 20px; min-width: 750px; width: 95%;">
                            <tr>
                                <th>STT</th>
                                <th style="min-width: 220px;max-width: 300px;">Tên giao dịch</th>
                                <th style="min-width: 100px;max-width: 200px;">Ngày giao dịch</th>
                                <th style="min-width: 180px;max-width: 300px;">Số hợp đồng</th>
                            </tr>
                            <logic:iterate id="item" name="contractPropertyViewHelper" property="lstContractProperty" indexId="i">
                                <% int style = i % 2; %>
                                <tr class="tbl-row<%=style%>">
                                    <td align="center">
                                        <%= i + 1 %>
                                    </td>
                                    <td align="left">
                                        <bean:write name="item" property="templateName" />
                                    </td>
                                    <td align="center">
                                        <bean:write name="item" property="notaryDate" format="dd/MM/yyyy"/>
                                    </td>
                                    <td align="left">
                                        <html:link href="contractdetailview.do" paramId="cid" paramName="item" paramProperty="contractId">
                                            <bean:write name="item" property="contractNumber" />
                                        </html:link>
                                    </td>
                                </tr>
                            </logic:iterate>
                        </table>
                        <br />
                    </td>
                </tr>
                <tr>
                    <td align="center">
                        <html:link href="preventlistback.do">
                            <img alt="Quay lại danh sách" src="./image/btn_list_back.png"/>
                        </html:link>
                    </td>
                </tr>
            </table>
    <%@ include file="/jsp/common/footer.jsp"%>
</html:html>
<script type="text/javascript">
    $('#preventTab > em').removeClass("menu-block-contract-off");
    $('#preventTab > em').addClass("menu-block-contract-on");
    $('#preventTab > b').addClass("menu-on");
</script>