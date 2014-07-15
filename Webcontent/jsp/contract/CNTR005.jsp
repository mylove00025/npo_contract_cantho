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
                    <html:img alt="*" src="./image/bullet_square.gif"/>
                </li>
                <li>
                    <html:link href="contractlistview.do">Quản lý hợp đồng</html:link>
                    <span> &gt; </span>
                </li>
                <li>
                    <html:link href="#">Báo cáo hợp đồng công chứng theo công chứng viên</html:link>
                </li>
            </ul>
        </div>
        <html:form action="contractbynotaryview" onsubmit="javascript: search_contract();">
            <%@ include file="/jsp/common/error_message.jsp" %>
            <html:hidden styleId="isHidePanelSearch" property="isHidePanelSearch" name="contractByNotaryListForm"/>
            <div id="mystickytooltip" class="stickytooltip">
            <div class="tooltipClassic">
                <div class="toolbar">
                    <div class="title">
                        <a id="closeTooltip" class="close"></a>
                        Thông tin chi tiết
                    </div>
                </div>
                <div id="tooltipContent" class="content">
                </div>
            </div>
            </div>
            <div id="searchShow" class="sub-title">
                <span class="tree_open" id="searchOption" style="cursor: pointer;" onclick="changeSearchState(); setSearchState();"></span>
                <strong class="onmouseover" onclick="changeSearchState(); setSearchState();">Điều kiện tìm kiếm</strong>
            </div>

            <table id="searchRegion" class="tbl-none-border">
                <tr id="searchFromToDate_tr">
                  <th nowrap="nowrap">Công chứng viên</th>
                  <td>
                      <html:select styleId="notaryIdFilter" name="contractByNotaryListViewHelper" property="notaryIdFilter" onchange="onchangeSelect(this.id,'0')">
                          <html:option value="0"><i>[Tất cả]</i></html:option>
                          <html:optionsCollection name="contractByNotaryListViewHelper" property="notaryList" label="fullName" value="id" />
                      </html:select>
                  </td>
                    <th id="searchDate_th" style="min-width: 110px;" nowrap="nowrap">Ngày công chứng</th>
                    <td style="vertical-align: middle;" id="searchDate_td">
                        <html:select styleId="notaryDate" property="searchDate" name="contractByNotaryListViewHelper"
                            onchange="searchDateChange(this.value);">
                            <html:option value="01">Trong ngày hôm nay</html:option>
                            <html:option value="00">Trong tuần này</html:option>
                            <html:option value="02">Trong tháng này</html:option>
                            <html:option value="03">Trong năm nay</html:option>
                            <html:option value="04">Khoảng thời gian</html:option>
                        </html:select>
                    </td>
                    <th style="visibility:hidden;" id="fromDate_th">Từ ngày</th>
                    <td style="visibility:hidden;" id="fromDate_td">
                        <html:text styleId="fromDate" property="fromDate" name="contractByNotaryListViewHelper" maxlength="10"
                            style="vertical-align:middle;"></html:text>
                        <html:img styleId="popupCal-1" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                            style="vertical-align: middle;"/>
                        <script type="text/javascript">
                            new Calendar({
                                inputField: "fromDate",
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
                    <th style="visibility:hidden;" id="toDate_th">Đến ngày</th>
                    <td style="visibility:hidden;" id="toDate_td">
                        <html:text styleId="toDate" property="toDate" name="contractByNotaryListViewHelper" maxlength="10"
                            style="vertical-align:middle;"></html:text>
                        <html:img styleId="popupCal-2" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                            style="vertical-align: middle;"/>
                        <script type="text/javascript">
                            new Calendar({
                                inputField: "toDate",
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
                    </td>
                </tr>
                <tr>

            </tr>
            <tr>
                <td colspan="8" style="text-align: center; padding: 10px;">
                    <html:image alt="Tìm kiếm" src="./image/btn_search.png"/>
                </td>
            </tr>
            </table>
            <div>
                <div class="clearfix-left">
                    <span>◊ Danh sách hợp đồng công chứng theo công chứng viên</span>
                </div>
                <logic:notEmpty name="contractByNotaryListViewHelper" property="contractList">
                    <div class="clearfix-right">
	                    <span id="report4_on">
	                        <html:link href="javascript: report2()" onclick="">
	                            <html:img alt="Tải file thống kê" src="./image/btn_download2.jpg"/>
	                        </html:link>
	                    </span>
	                    <span id="report4_off" style="display: none;">
	                        <html:link href="#">
	                            <html:img alt="Tải file thống kê" src="./image/btn_download2.jpg"/>
	                        </html:link>
	                    </span>
                        <span id="report2_on">
                            <html:link href="javascript: report()" onclick="">
                                <html:img alt="Tải file báo cáo" src="./image/btn_download.png"/>
                            </html:link>
                        </span>
                        <span id="report2_off" style="display: none;">
                            <html:link href="#">
                                <html:img alt="Tải file báo cáo" src="./image/btn_download.png"/>
                            </html:link>
                        </span>
                    </div>
                </logic:notEmpty>
            </div>
            <logic:notEmpty name="contractByNotaryListViewHelper" property="contractList">
                <table class="tbl-list" id="search-result">
                    <tr>
                        <th>Công chứng viên</th>
                        <th>Số hợp đồng</th>
                        <th>Ngày công<br/>chứng</th>
                        <th>Tên hợp đồng</th>
                        <th>Bên liên quan</th>
                        <th>Nội dung</th>
                    </tr>
                    <logic:iterate id="contractlist" name="contractByNotaryListViewHelper" property="contractList" indexId="i">
                        <%int style = i % 2;%>
                        <tr class="tbl-row<%=style%>">
                            <!-- Cong chung vien -->
                            <td>
                                <bean:write name="contractlist" property="notaryFamilyName"/>
                                <bean:write name="contractlist" property="notaryFirstName"/>
                            </td>
                            <!-- So hop dong -->
                            <td style="text-align: center;">
                                <bean:write name="contractlist" property="contractNumber"/>
                            </td>
                            <!-- ngay cong chung -->
                            <td style="text-align: center;">
                                <bean:write name="contractlist" property="notaryDate" format="dd/MM/yyyy"/>
                            </td>
                            <!-- Ten hop dong -->
                            <td style="text-align: left;">
                                <bean:write name="contractlist" property="contractTemplateName"/>
                            </td>
                            <!-- Ben lien quan -->
                            <td>
                                <span data-tooltip="contractsticky<%=i%>" class="datatooltip">
                                <bean:write name='contractlist' property='contractInformationDisp' filter="false"/>
                                <script>
                                    var info = '<bean:write name="contractlist" property="contractInformation"/>';
                                    var infoDisp = '<bean:write name="contractlist" property="contractInformationDisp"/>';
                                    if (info != infoDisp) {
                                      document.write('<img class="onmouseover" src="./image/icon_search.png"></img>');
                                    }
                                </script>
                             </span>
                             <script>
                                 var node =  document.getElementById("contractsticky<%=i%>");
                                 if (node == null) {
                                     $('<div id="contractsticky<%=i%>" class="atip"><bean:write name="contractlist" property="contractInformation" filter="false"/></div>').appendTo('#tooltipContent');
                                 }
                             </script>
                            </td>
                            <!-- Noi dung -->
                            <td style="text-align: left;">
                              <span data-tooltip="summarysticky<%=i%>" class="datatooltip">
                                <bean:write name='contractlist' property='shorttenContractSummaryDisp' filter="false"/>
                                <script>
                                    var info = '<bean:write name="contractlist" property="contractSummaryDisp"/>';
                                    var infoDisp = '<bean:write name="contractlist" property="shorttenContractSummaryDisp"/>';
                                    if (info != infoDisp) {
                                      document.write('<img class="onmouseover" src="./image/icon_search.png"></img>');
                                    }
                                </script>
                            </span>
                            <script>
                                var node =  document.getElementById("summarysticky<%=i%>");
                                if (node == null) {
                                    $('<div id="summarysticky<%=i%>" class="atip"><bean:write name="contractlist" property="contractSummaryDisp" filter="false"/></div>').appendTo('#tooltipContent');
                                }
                            </script>
                            </td>
                        </tr>
                    </logic:iterate>
                </table>
                <logic:greaterThan name="contractByNotaryListViewHelper" property="totalCount" value="0">
                    <div class="pager">
                        <div class="pager-total">
                            Tổng số <strong><bean:write name="contractByNotaryListViewHelper" property="totalCount"/></strong> dữ liệu
                        </div>
                        <div>
                            <logic:greaterThan name="contractByNotaryListViewHelper" property="totalPage" value="1">
                                <html:link href="javascript:direction('first')">
                                    <img class="pager-first" src="./image/first.png" alt= "first"/>
                                </html:link>
                                <html:link href="javascript:direction('ahead')">
                                    <img class="pager-prev" src="./image/prev.png" alt= "prev"/>
                                </html:link>
                            </logic:greaterThan>
                            <span>
                                Trang&nbsp;
                                <bean:write name="contractByNotaryListViewHelper" property="page" format="##########"/>
                                 /<bean:write name="contractByNotaryListViewHelper" property="totalPage" format="##########"/>
                            </span>
                            <logic:greaterThan name="contractByNotaryListViewHelper" property="totalPage" value="1">
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
                	<span id="report3_on">
                        <html:link href="javascript: report2()" onclick="">
                            <html:img alt="Tải file thống kê" src="./image/btn_download2.jpg"/>
                        </html:link>
                    </span>
                    <span id="report3_off" style="display: none;">
                        <html:link href="#">
                            <html:img alt="Tải file thống kê" src="./image/btn_download2.jpg"/>
                        </html:link>
                    </span>
                    <span id="report1_on">
                        <html:link href="javascript: report()" onclick="">
                            <html:img alt="Tải file báo cáo" src="./image/btn_download.png"/>
                        </html:link>
                    </span>
                    <span id="report1_off" style="display: none;">
                        <html:link href="#">
                            <html:img alt="Tải file báo cáo" src="./image/btn_download.png"/>
                        </html:link>
                    </span>
                </div>
            </logic:notEmpty>
        </html:form>
    <%@ include file="/jsp/common/footer.jsp"%>
</html:html>
<script type="text/javascript">
    // highlight home tab.
    $('#contract > em').removeClass("home-off");
    $('#contract > em').addClass("home-on");
    $('#contract > b').addClass("menu-on");

    document.getElementById("notaryDate").focus();
    onchangeSelect("notaryIdFilter","0");
    setSearchState();

    function setSearchState() {
        var val = document.getElementById("isHidePanelSearch").value;
        if (val == "true") {
            $('#searchOption').removeClass('tree_open');
            $('#searchOption').addClass('tree_close');
            $('#searchRegion').hide();
        } else {
            $('#searchOption').removeClass('tree_close');
            $('#searchOption').addClass('tree_open');
            $('#searchRegion').show();
        }
    }

    function changeSearchState() {
        var val = document.getElementById("isHidePanelSearch").value;
        if (val == "true") {
            document.contractByNotaryListForm.isHidePanelSearch.value = "false";
        } else {
            document.contractByNotaryListForm.isHidePanelSearch.value = "true";
        }
    }

    function searchDateChange(data) {
        if(data=='04') {
            document.getElementById("fromDate_th").style.visibility="visible";
            document.getElementById("fromDate_td").style.visibility="visible";
            document.getElementById("toDate_th").style.visibility="visible";
            document.getElementById("toDate_td").style.visibility="visible";
        }
        else {
            document.getElementById("fromDate_th").style.visibility="hidden";
            document.getElementById("fromDate_td").style.visibility="hidden";
            document.getElementById("toDate_th").style.visibility="hidden";
            document.getElementById("toDate_td").style.visibility="hidden";
        }
    }

    var data = $('#notaryDate').val();
    searchDateChange(data);

    var LEFT_CAL = Calendar.setup({
        cont: "cont",
        weekNumbers: true,
        selectionType: Calendar.SEL_MULTIPLE,
        showTime: 12
        // titleFormat: "%B %Y"
    });

    function checkAll(selector_fire, alt_name) {
        $('input[alt=' + alt_name + ']').attr('checked', $('#' + selector_fire).is(':checked'));
    }

    function search_contract() {
        document.contractByNotaryListForm.action="contractbynotarysearch.do";
        return true;
    }

    function report() {
        document.contractByNotaryListForm.action="contractbynotaryreport.do";
        document.contractByNotaryListForm.submit();
        return true;
    }
    
    function report2() {
        document.contractByNotaryListForm.action="userlistexport.do";
        document.contractByNotaryListForm.submit();
        return true;
    }

    function direction(data){
        document.contractByNotaryListForm.direction.value=data;
        document.contractByNotaryListForm.action="contractbynotarypaging.do";
        document.contractByNotaryListForm.submit();
        return true;
    }
</script>