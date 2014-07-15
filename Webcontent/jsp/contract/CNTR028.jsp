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
                    <html:link href="contractlistview.do">Quản lý hợp đồng</html:link> 
                </li>
                <li>
                    &gt;<html:link href="#">Báo cáo hợp đồng cần bổ sung hồ sơ</html:link>
                </li>               
            </ul>
        </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
    <html:form action="contractadditionview" onsubmit="javascript: searchOnClick();">
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
        <div class="sub-title">
            <span><strong>◊ Điều kiện tìm kiếm</strong></span>                               
        </div>      
        <table class="tbl-none-border">
            <tr>
                <th>Ngày công chứng</th>
                <td style="vertical-align: middle;">
                    <html:select styleId="notaryDateFilter" name="contractAdditionViewHelper" property="notaryDateFilter" styleClass="input-normal">
                        <html:option value="01">Trong ngày hôm nay</html:option>
                        <html:option value="02">Trong tuần này</html:option>
                        <html:option value="03">Trong tháng này</html:option>
                        <html:option value="04">Trong năm nay</html:option>
                        <html:option value="05">Khoảng thời gian</html:option>
                    </html:select>
                </td>
                <th id="notaryDate_td" class="dateFilter">
                    Từ ngày&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <html:text styleId="notaryDate-1" property="notaryDateFromFilter" styleClass="input-normal">
                    </html:text>
                    <html:img styleId="popupCal-1" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                                    style="vertical-align: middle;"/>
                    <script type="text/javascript">
                          new Calendar({
                              inputField: "notaryDate-1",
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
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    Đến ngày&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <html:text styleId="notaryDate-2" property="notaryDateToFilter" styleClass="input-normal">
                    </html:text>
                    <html:img styleId="popupCal-2" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                                    style="vertical-align: middle;"/>
                    <script type="text/javascript">
                          new Calendar({
                              inputField: "notaryDate-2",
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
                </th>
            </tr>
            <tr>
                <td colspan="4" style="text-align: center; padding: 10px;">                       
                    <html:image alt="Tìm kiếm" src="./image/btn_search.png"/>
                </td>
            </tr>
        </table>
        <div>
            <div class="clearfix-left">
                <span>◊ Danh sách hợp đồng công chứng cần bổ sung hồ sơ</span>
            </div>
            <logic:notEmpty name="contractAdditionViewHelper" property="contractList">
            <div class="clearfix-right">
                <html:link href="javascript: report()">
                    <html:img alt="Tải file báo cáo" src="./image/btn_download.png"/>
                </html:link>
            </div>
            </logic:notEmpty>
        </div>
        <logic:notEmpty name="contractAdditionViewHelper" property="contractList">
        <table class="tbl-list">
            <tr>
                <th>Chuyên viên soạn thảo</th>
                <th>Số hợp đồng</th>
                <th>Bên liên quan</th>
                <th>Ngày công chứng</th>
                <th>Giấy tờ cần bổ sung</th>
                <th>Công chứng viên</th>
            </tr>
            <logic:iterate id="contractlist" name="contractAdditionViewHelper" property="contractList" indexId="i">
                <%int style = i % 2; %>
                <tr class="tbl-row<%=style%>">
                    <td>
                        <bean:write name="contractlist" property="drafterFamilyName"/>
                        <bean:write name="contractlist" property="drafterFirstName"/>
                    </td>
                    <td style="text-align: center;">
                        <bean:write name="contractlist" property="contractNumber"/>
                    </td>
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
                    <td style="text-align: center;">
                        <bean:write name="contractlist" property="notaryDate" format="dd/MM/yyyy"/>
                    </td>                    
                    <td>
                        <bean:write name="contractlist" property="additionDescription"/>
                    </td>
                    <td>
                        <bean:write name="contractlist" property="notaryFamilyName"/>
                        <bean:write name="contractlist" property="notaryFirstName"/>
                    </td>
                </tr>
            </logic:iterate>
        </table>
        <logic:greaterThan name="contractAdditionViewHelper" property="totalCount" value="0">
        <div class="pager">
            <div class="pager-total">Tổng số <strong><bean:write name="contractAdditionViewHelper" property="totalCount"/></strong> dữ liệu</div>
            <div>
                <logic:greaterThan name="contractAdditionViewHelper" property="totalPage" value="1">
                    <html:link href="javascript:direction('first')">
                        <img class="pager-first" src="./image/first.png" alt= "first"/>
                    </html:link>
                    <html:link href="javascript:direction('ahead')">
                        <img class="pager-prev" src="./image/prev.png" alt= "prev"/>
                    </html:link>
                </logic:greaterThan>
                <span>
                    Trang&nbsp;
                    <bean:write name="contractAdditionViewHelper" property="page" format="##########"/>
                     /<bean:write name="contractAdditionViewHelper" property="totalPage" format="##########"/>
                </span>
                <logic:greaterThan name="contractAdditionViewHelper" property="totalPage" value="1">
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

	$('#contract > em').removeClass("contract-off");
	$('#contract > em').addClass("contract-on");
	$('#contract > b').addClass("menu-on");

	document.getElementById("notaryDateFilter").focus();
	
	function report() {
		if (document.getElementById("notaryDateFilter").value != "05") {
			document.getElementById("notaryDate-1").value = "";
			document.getElementById("notaryDate-2").value = "";
		}
		$('#message_box').hide();
		$('#err_box').hide();
        $('.error-cell').removeClass("error-cell");
	    document.contractAdditionForm.action="contractadditionexport.do";
	    document.contractAdditionForm.submit();
	    return true;
	}
	
	var LEFT_CAL = Calendar.setup({
        cont: "cont",
        weekNumbers: true,
        selectionType: Calendar.SEL_MULTIPLE,
        showTime: 12
        // titleFormat: "%B %Y"
    });
	
	var value = $('#notaryDateFilter option:selected').val();
    if(value == "05") {
        $('th.dateFilter').show();
    } else {
        $('th.dateFilter').hide();
    }
    
    $('#notaryDateFilter').change(function() {      
        var value = $('#notaryDateFilter option:selected').val();
        if(value == "05") {         
            $('th.dateFilter').show();
        } else {
            $('th.dateFilter').hide();
        }
    });
    
    function searchOnClick() {
        if (document.getElementById("notaryDateFilter").value != "05") {
            document.getElementById("notaryDate-1").value = "";
            document.getElementById("notaryDate-2").value = "";
        }
        document.contractAdditionForm.action="contractadditionsearch.do";
        return true;
    }
    function direction(data){
        document.contractAdditionForm.direction.value=data;
        document.contractAdditionForm.action="contractadditionpaging.do";
        document.contractAdditionForm.submit();
    }
</script>