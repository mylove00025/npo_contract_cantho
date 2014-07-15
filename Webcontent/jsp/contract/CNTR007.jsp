<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>
    <div id="navigator">
            <ul class="clearfix">
                <li>
                    <html:img alt="*" src="./image/bullet_square.gif"/>
                </li>
                <li>
                    <a href="contractlistview.do">Quản lý hợp đồng</a> &gt;
                    <a href="contractbyuserlistview.do">Báo cáo hợp đồng công chứng theo chuyên viên soạn thảo</a>
                </li>
            </ul>
        </div>
    <html:form action="contractbyuserlistview" onsubmit="javascript: searchOnClick();">
        <%@ include file="/jsp/common/error_message.jsp" %>
        <html:hidden styleId="isHidePanelSearch" property="isHidePanelSearch" name="contractByUserListForm"/>
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
                <th>Chuyên viên</th>
                <td>
                    <html:select styleId="selectedUserID" name="contractByUserListViewHelper" property="selectedUserID" onchange="onchangeSelect(this.id,'0')">
                        <html:option value="0"><i>[Tất cả]</i></html:option>
                        <html:optionsCollection name="contractByUserListViewHelper" property="userList" label="fullName" value="id" />
                    </html:select>
                </td>
                <th id="searchDate_th" style="min-width: 110px;" nowrap="nowrap">Ngày công chứng</th>
                <td style="vertical-align: middle;" id="searchDate_td">
                    <html:select styleId="notaryDate" property="searchDate" name="contractByUserListViewHelper" onchange="searchDateChange(this.value);">
                       <html:option value="01">Trong ngày hôm nay</html:option>
                       <html:option value="00">Trong tuần này</html:option>
                       <html:option value="02">Trong tháng này</html:option>
                       <html:option value="03">Trong năm nay</html:option>
                       <html:option value="04">Khoảng thời gian</html:option>
                    </html:select>
                </td>
                <th id="fromDate_th" style="visibility:hidden;">Từ ngày</th>
                <td id="fromDate_td" style="visibility:hidden;">
                    <html:text styleId="fromDate" property="fromDate" name="contractByUserListViewHelper" maxlength="10" style="vertical-align:middle;"></html:text>
                     <a><img id="popupCal-1" src="./image/calendar.png" alt="calendar" style="vertical-align: middle;"/></a>
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
                <th id="toDate_th" style="visibility:hidden;">Đến ngày</th>
                <td id="toDate_td" style="visibility:hidden;">
                    <html:text styleId="toDate" property="toDate" name="contractByUserListViewHelper" maxlength="10" style="vertical-align:middle;"></html:text>
                     <a><img id="popupCal-2" src="./image/calendar.png" alt="calendar" style="vertical-align: middle;"/></a>
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
                <span>◊ Danh sách hợp đồng công chứng theo chuyên viên soạn thảo</span>
            </div>
            <logic:notEmpty name="contractByUserListViewHelper" property="contractList">
            <div class="clearfix-right">
                <html:link href="javascript: report()">
                    <html:img alt="Tải file báo cáo" src="./image/btn_download.png"/>
                </html:link>
            </div>
            </logic:notEmpty>
        </div>
        <logic:notEmpty name="contractByUserListViewHelper" property="contractList">
        <table class="tbl-list">
            <tr>
                <th>Chuyên viên soạn thảo</th>
                <th>Số hợp đồng</th>
                <th>Ngày công<br/>chứng</th>
                <th>Tên hợp đồng</th>
                <th>Bên liên quan</th>
                <th>Nội dung</th>
                <th>Công chứng viên</th>
            </tr>
            <logic:iterate id="contractlist" name="contractByUserListViewHelper" property="contractList" indexId="i">
                <%int style = i % 2; %>
                <tr class="tbl-row<%=style%>">
                    <!-- Ten ngan hang -->
                    <td>
                        <bean:write name="contractlist" property="drafterFamilyName"/>
                        <bean:write name="contractlist" property="drafterFirstName"/>
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
                    <td>
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
                    <!-- Cong chung vien -->
                    <td>
                        <bean:write name="contractlist" property="notaryFamilyName"/>
                        <bean:write name="contractlist" property="notaryFirstName"/>
                    </td>
                </tr>
            </logic:iterate>
        </table>
        <logic:greaterThan name="contractByUserListViewHelper" property="totalCount" value="0">
        <div class="pager">
            <div class="pager-total">Tổng số <strong><bean:write name="contractByUserListViewHelper" property="totalCount"/></strong> dữ liệu</div>
            <div>
                <logic:greaterThan name="contractByUserListViewHelper" property="totalPage" value="1">
                    <html:link href="javascript:direction('first')">
                        <img class="pager-first" src="./image/first.png" alt= "first"/>
                    </html:link>
                    <html:link href="javascript:direction('ahead')">
                        <img class="pager-prev" src="./image/prev.png" alt= "prev"/>
                    </html:link>
                </logic:greaterThan>
                <span>
                    Trang&nbsp;
                    <bean:write name="contractByUserListViewHelper" property="page" format="##########"/>
                     /<bean:write name="contractByUserListViewHelper" property="totalPage" format="##########"/>
                </span>
                <logic:greaterThan name="contractByUserListViewHelper" property="totalPage" value="1">
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
            <html:link href="javascript: report()">
                    <html:img alt="Tải file báo cáo" src="./image/btn_download.png"/>
            </html:link>
        </div>
        </logic:notEmpty>
    </html:form>
    <%@ include file="/jsp/common/footer.jsp" %>
</html:html>
<script type="text/javascript">
    //Hightlight menu
    $('#contract > em').removeClass("home-off");
    $('#contract > em').addClass("home-on");
    $('#contract > b').addClass("menu-on");

    document.getElementById("notaryDate").focus();
    onchangeSelect("selectedUserID","0");
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
            document.contractByUserListForm.isHidePanelSearch.value = "false";
        } else {
            document.contractByUserListForm.isHidePanelSearch.value = "true";
        }
    }

    var LEFT_CAL = Calendar.setup({
        cont: "cont",
        weekNumbers: true,
        selectionType: Calendar.SEL_MULTIPLE,
        showTime: 12
        // titleFormat: "%B %Y"
    });

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

    searchDateChange(document.getElementById("notaryDate").value);

    function checkAll(selector_fire, alt_name) {
        $('input[alt=' + alt_name + ']').attr('checked', $('#' + selector_fire).is(':checked'));
    }

    function searchOnClick() {
        if (document.getElementById("notaryDate").value != "04") {
            document.getElementById("fromDate_td").value = "";
            document.getElementById("toDate_td").value = "";
        }
        document.contractByUserListForm.action="contractbyuserlistsearch.do";
        return true;
    }

    function splitUserName(string) {
      var str_array = string.split("/");
      return str_array[0];
    }

    function direction(data){
        document.contractByUserListForm.direction.value=data;
        document.contractByUserListForm.action="contractbyuserlistpaging.do";
        document.contractByUserListForm.submit();
    }

    function report() {
        document.contractByUserListForm.action="contractbyuserlistexport.do";
        document.contractByUserListForm.submit();
        return true;
    }
    
    

</script>