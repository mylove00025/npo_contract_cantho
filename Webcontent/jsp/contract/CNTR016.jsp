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
                    <a href="#">Báo cáo hợp đồng lỗi</a>
                </li>         
            </ul>
        </div>
    <html:form action="contracterrorlistview" onsubmit="javascript: searchOnClick();">
        <%@ include file="/jsp/common/error_message.jsp" %>
        <html:hidden styleId="isHidePanelSearch" property="isHidePanelSearch" name="contractErrorListForm"/>
            <div id="searchShow" class="sub-title">
                <span class="tree_open" id="searchOption" style="cursor: pointer;" onclick="changeSearchState(); setSearchState();"></span>
                <strong class="onmouseover" onclick="changeSearchState(); setSearchState();">Điều kiện tìm kiếm</strong>
            </div>
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
        <table id="searchRegion" class="tbl-none-border">
            <tr id="searchFromToDate_tr">
                <th>Ngày công chứng</th>  
                <td>           
                    <html:select styleId="notaryDate" property="searchDate" name="contractErrorListViewHelper" onchange="searchDateChange(this.value);">
                       <html:option value="01">Trong ngày hôm nay</html:option>
                       <html:option value="02">Trong tuần này</html:option>
                       <html:option value="03">Trong tháng này</html:option>
                       <html:option value="04">Trong năm nay</html:option>
                       <html:option value="05">Khoảng thời gian</html:option>
                    </html:select>
                </td>
                <th id="fromDate_th" style="visibility:hidden;">Từ ngày</th>
                <td id="fromDate_td" style="visibility:hidden;">                    
                    <html:text styleId="fromDate" property="fromDate"name="contractErrorListViewHelper" maxlength="10" style="vertical-align:middle;"></html:text>
                     <a href="#"><img id="popupCal-1" src="./image/calendar.png" alt="calendar" style="vertical-align: middle;"/></a>
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
                    <html:text styleId="toDate" property="toDate" name="contractErrorListViewHelper" maxlength="10" style="vertical-align:middle;"></html:text>
                     <a href="#"><img id="popupCal-2" src="./image/calendar.png" alt="calendar" style="vertical-align: middle;"/></a>
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
                <th>Công chứng viên</th>
                <td>
                    <html:select styleId="notaryIdFilter" name="contractErrorListViewHelper" property="contractNotaryId" styleClass="input-normal" onchange="onchangeSelect(this.id,'0')">
                        <html:option value="0">[Tất cả]</html:option>
                        <html:optionsCollection name="contractErrorListViewHelper" property="contractNotaryList" label="fullName" value="id" />
                    </html:select>                    
                </td>
                <th>Chuyên viên soạn thảo</th>
                <td>
                    <html:select styleId="drafterIdFilter" name="contractErrorListViewHelper" property="contractDrafterId" styleClass="input-normal"  onchange="onchangeSelect(this.id,'0')">
                        <html:option value="0">[Tất cả]</html:option>
                        <html:optionsCollection name="contractErrorListViewHelper" property="contractDrafterList" label="fullName" value="id" />
                    </html:select>
                </td>
            </tr>
            <tr>
                <td colspan="4" style="text-align: center; padding: 10px;">
                    <html:image alt="Tim kiếm" src="./image/btn_search.png"/>
                </td>
            </tr>         
           </table>
           <div>
            <div class="clearfix-left">
                <span>◊ Danh sách hợp đồng công chứng</span>
            </div>
            <div class="clearfix-right">
                <logic:notEmpty name="contractErrorListViewHelper" property="contractErrorList">
                    <html:link href="javascript: report()">
                        <html:img alt="Tai file bao cao" src="./image/btn_download.png"/>
                    </html:link>
                </logic:notEmpty>
            </div>
        </div>  
        <logic:notEmpty name="contractErrorListViewHelper" property="contractErrorList">
            <table class="tbl-list">
                <tr>
                    <th>Số hợp đồng</th>
                    <th>Ngày công chứng</th>
                    <th>Tên hợp đồng</th>
                    <th>Bên liên quan</th>
                    <th>Công chứng viên</th>
                    <th>Nội dung lỗi</th>
                </tr>            
                <logic:iterate id="item" name="contractErrorListViewHelper" property="contractErrorList" indexId="i">
                    <tr class="tbl-row<%=i % 2%>">
                        <td style="text-align: center;">
                            <bean:write name="item" property="contractNumber" />
                        </td>
                        <td style="text-align: center;">
                            <bean:write name="item" property="notaryDate" format="dd/MM/yyyy"/>
                        </td>
                        <td>
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
                            <bean:write name="item" property="notaryFamilyName"/>
                            <bean:write name="item" property="notaryFirstName"/>
                        </td>
                        <td style="text-align: left;">
                            <span data-tooltip="errorsticky<%=i%>" class="datatooltip">
                                <bean:write name='item' property='errorDescriptionDisp' filter="false"/>
                                <script>
                                    var info = '<bean:write name="item" property="errorDescription"/>';
                                    var infoDisp = '<bean:write name="item" property="errorDescriptionDisp"/>';
                                    if (info != infoDisp) {
                                        document.write('<img class="onmouseover" src="./image/icon_search.png"></img>');
                                    }
                                </script>                                
                               </span>
                               <script>
                                   var node =  document.getElementById("errorsticky<%=i%>");
                                   if (node == null) {
                                       $('<div id="errorsticky<%=i%>" class="atip"><bean:write name="item" property="errorDescription" filter="false"/></div>').appendTo('#tooltipContent');
                                   }
                               </script>
                        </td>                       
                    </tr>    
                </logic:iterate>
            </table> 
            <logic:greaterThan name="contractErrorListViewHelper" property="totalCount" value="0">
            <div class="pager">
                <div class="pager-total">Tổng số <strong><bean:write name="contractErrorListViewHelper" property="totalCount"/></strong> dữ liệu</div>
                <div>
                    <logic:greaterThan name="contractErrorListViewHelper" property="totalPage" value="1">
                        <html:link href="javascript:direction('first')">        
                            <img class="pager-first" src="./image/first.png" alt= "first"/>
                        </html:link>
                        <html:link href="javascript:direction('ahead')">
                            <img class="pager-prev" src="./image/prev.png" alt= "prev"/>
                    </html:link>
                    </logic:greaterThan>
                    <span>
                        Trang&nbsp;
                        <bean:write name="contractErrorListViewHelper" property="page" format="##########"/>
                         /<bean:write name="contractErrorListViewHelper" property="totalPage" format="##########"/>
                    </span>
                    <logic:greaterThan name="contractErrorListViewHelper" property="totalPage" value="1">
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
    //Hightlight menu
	$('#contract > em').removeClass("home-off");
	$('#contract > em').addClass("home-on");
	$('#contract > b').addClass("menu-on");
	
	document.getElementById("notaryDate").focus();
    onchangeSelect("notaryIdFilter","0");
    onchangeSelect("drafterIdFilter","0");
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
	        document.contractErrorListForm.isHidePanelSearch.value = "false";
	    } else {
	    	document.contractErrorListForm.isHidePanelSearch.value = "true";
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
        if(data=='05') {
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
    
    function searchOnClick() {
        document.contractErrorListForm.action="contracterrorlistsearch.do";
        return true;
    }
    
    function direction(data){
        document.contractErrorListForm.direction.value=data;
        document.contractErrorListForm.action="contracterrorlistpaging.do";
        document.contractErrorListForm.submit();
        return true;
    }
   
    function report() {
        document.contractErrorListForm.action="contracterrorexport.do";
        document.contractErrorListForm.submit();
        return true;
    }
    
</script>