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
	             <html:link href="contractlistview.do">Quản lý hợp đồng</html:link>
	         </li>
	         <li>
                 <span> > </span>
                 <html:link href="contractstatisticbykindview.do">Báo cáo theo nhóm hợp đồng</html:link>
             </li> 
	         <li>
	             <span> > </span>
	             <html:link href="#">Báo cáo chi tiết nhóm hợp đồng</html:link>
	         </li>
	     </ul>
    </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
    
    <html:form action="contractlistbykindview" onsubmit="javascript: search();">
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
            <span>◊ Điều kiện tìm kiếm</span>
        </div>
        <table id="tblSearch" class="tbl-none-border">
            <tr id="contractKindIdFilter_tr">
                <th nowrap="nowrap">Nhóm hợp đồng</th>
                <td nowrap="nowrap" colspan="4">
                    <select name="contractKindIdFilter" id="contractKindIdFilter">	                    
	                    <logic:iterate id="item" name="contractListByKindViewHelper" property="contractKindTree">                            
		                    <option value="<bean:write name='item' property='id'/>">
		                        <bean:write name="item" property="spaces" filter="false"/>
		                        <bean:write name="item" property="name"/>
		                    </option>
	                    </logic:iterate>                       
                    </select>                   
                </td>
            </tr>
            <tr>
                <th nowrap="nowrap">Ngày công chứng</th>
                <td nowrap="nowrap">
                    <html:select styleId="notaryDateFilter" name="contractListByKindViewHelper" property="notaryDateFilter" onchange="onchangeSelect(this.id,'00')">
                        <html:option value="00">[Tất cả]</html:option>
                        <html:option value="01">Trong ngày hôm nay</html:option>
                        <html:option value="02">Trong tuần này</html:option>
                        <html:option value="03">Trong tháng này</html:option>
                        <html:option value="04">Trong năm nay</html:option>
                        <html:option value="05">Khoảng thời gian</html:option>
                    </html:select>
                </td>
                <th nowrap="nowrap" id="notaryDate_th" colspan ="2" class="dateFilter">
                    Từ ngày&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <html:text styleId="notaryDate-1" property="notaryDateFromFilter" name="contractListByKindViewHelper">
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
                    <html:text styleId="notaryDate-2" property="notaryDateToFilter" name="contractListByKindViewHelper">
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
                <td nowrap="nowrap" colspan="4" style="text-align: center; padding: 10px;">
	               <html:image alt="Tìm kiếm" src="./image/btn_search.png"/>
                </td>
            </tr>       
        </table>
        <div>
            <div class="clearfix-left">
                <span>◊ Danh sách hợp đồng công chứng</span>
            </div>
            <div class="clearfix-right">
                <logic:notEmpty name="contractListByKindViewHelper" property="contractList">
	                <html:link href="javascript: report()">
	                    <html:img alt="Tai file bao cao" src="./image/btn_download.png"/>
	                </html:link>
                </logic:notEmpty>
            </div>
        </div>
        <logic:notEmpty name="contractListByKindViewHelper" property="contractList">
            <table class="tbl-list">
                <tr>
                    <th>Số hợp đồng</th>
	                <th>Ngày công chứng</th>
                    <th>Tên hợp đồng</th>
                    <th>Bên liên quan</th>
	                <th>Tóm tắt nội dung</th>
	                <th>Công chứng viên</th>
                </tr>            
                <logic:iterate id="item" name="contractListByKindViewHelper" property="contractList" indexId="i">
                    <tr class="tbl-row<%=i % 2%>">
                        <td style="text-align: center;">
                           <bean:write name="item" property="contractNumber" />
                        </td>
                        <td style="text-align: center;">
                            <bean:write name="item" property="notaryDate" format="dd/MM/yyyy"/>
                        </td>
                        <td style="text-align: left;">
                            <bean:write name="item" property="contractTemplateName"/>                           
                        </td>
                        <td>
                           <span data-tooltip="contractsticky<%=i%>" class="datatooltip">
                                <bean:write name='item' property='contractInformationDisp' filter="false"/>
                                <script>
                                    var info = '<bean:write name="item" property="contractInformation"/>';
                                    var infoDisp = '<bean:write name="item" property="contractInformationDisp"/>';
                                    if (info != infoDisp) {
                                    	document.write('<img class="onmouseover" src="./image/icon_search.png"></img>');
                                    }
                                </script>                                
                            </span>
                            <script>
                                var node =  document.getElementById("contractsticky<%=i%>");
                                if (node == null) {
                                    $('<div id="contractsticky<%=i%>" class="atip"><bean:write name="item" property="contractInformation" filter="false"/></div>').appendTo('#tooltipContent');
                                }
                            </script>
                        </td>
                        <td>
                            <span data-tooltip="summarysticky<%=i%>" class="datatooltip">
                                <bean:write name='item' property='shorttenContractSummaryDisp' filter="false"/>
                                <script>
                                    var info = '<bean:write name="item" property="contractSummaryDisp"/>';
                                    var infoDisp = '<bean:write name="item" property="shorttenContractSummaryDisp"/>';
                                    if (info != infoDisp) {
                                    	document.write('<img class="onmouseover" src="./image/icon_search.png"></img>');
                                    }
                                </script>
                            </span>
                            <script>
                                var node =  document.getElementById("summarysticky<%=i%>");
                                if (node == null) {
                                    $('<div id="summarysticky<%=i%>" class="atip"><bean:write name="item" property="contractSummaryDisp" filter="false"/></div>').appendTo('#tooltipContent');
                                }
                            </script> 
                        </td>
                        <td>
                            <bean:write name="item" property="notaryFamilyName"/>
                            <bean:write name="item" property="notaryFirstName"/>
                        </td>
                    </tr>    
                </logic:iterate>
            </table>
        
            <logic:greaterThan name="contractListByKindViewHelper" property="totalCount" value="0">
            <div class="pager">
                <div class="pager-total">Tổng số <strong><bean:write name="contractListByKindViewHelper" property="totalCount"/></strong> dữ liệu</div>
                <div>
                    <logic:greaterThan name="contractListByKindViewHelper" property="totalPage" value="1">
	                    <html:link href="javascript:direction('first')">        
	                        <img class="pager-first" src="./image/first.png" alt= "first"/>
	                    </html:link>
	                    <html:link href="javascript:direction('ahead')">
	                        <img class="pager-prev" src="./image/prev.png" alt= "prev"/>
                    </html:link>
                    </logic:greaterThan>
                    <span>
                        Trang&nbsp;
                        <bean:write name="contractListByKindViewHelper" property="page" format="##########"/>
                         /<bean:write name="contractListByKindViewHelper" property="totalPage" format="##########"/>
                    </span>
                    <logic:greaterThan name="contractListByKindViewHelper" property="totalPage" value="1">
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
                    <html:img alt="Tai file bao cao" src="./image/btn_download.png"/>
                </html:link>
            </div>
        </logic:notEmpty>
    </html:form>
    <%@ include file="/jsp/common/footer.jsp" %> 
</html:html>

<script type="text/javascript">
    //Hight light
	$('#contract > em').removeClass("contract-off");
	$('#contract > em').addClass("contract-on");
	$('#contract > b').addClass("menu-on");
    
    document.getElementById("contractKindIdFilter").focus();
    onchangeSelect("notaryDateFilter","00");
    
	var LEFT_CAL = Calendar.setup({
	    cont: "cont",
	    weekNumbers: true,
	    selectionType: Calendar.SEL_MULTIPLE,
	    showTime: 12
	    // titleFormat: "%B %Y"
    });
	
	function search() {
        if (document.getElementById("notaryDateFilter").value != "05") {
            document.getElementById("notaryDate-1").value = "";
            document.getElementById("notaryDate-2").value = "";
        }
        document.contractListByKindForm.action="contractlistbykindsearch.do";
        return true;
    }
    
    function direction(data){
        document.contractListByKindForm.direction.value=data;
        document.contractListByKindForm.action="contractlistbykindpaging.do";
        document.contractListByKindForm.submit();
        return true;
    }
    
    function report() {
        document.contractListByKindForm.action="contractlistbykindexport.do";
        document.contractListByKindForm.submit();
        return true;
    }
    
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
    
    var selectedKindId = "<bean:write name='contractListByKindViewHelper' property='contractKindIdFilter'/>";
    if (selectedKindId != "") {
        document.getElementById("contractKindIdFilter").value = selectedKindId;
    }
</script>