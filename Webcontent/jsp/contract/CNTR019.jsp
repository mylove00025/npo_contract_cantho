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
                    &gt;<html:link href="#">Báo cáo theo nhóm hợp đồng</html:link>
                </li>               
            </ul>
        </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
    <html:form styleId="form" action="contractstatisticbykindview" onsubmit="javascript: statistics();">
        <div class="sub-title">
            <span><strong>◊ Điều kiện báo cáo</strong></span>                               
        </div>      
        <table class="tbl-none-border">
            <tr>
                <th>Ngày công chứng</th>
                <td style="vertical-align: middle;">
                    <html:select styleId="notaryDateFilter" name="contractStatisticByKindViewHelper" property="notaryDateFilter" styleClass="input-normal">
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
                    <html:image alt="Thống kê" src="./image/btn_statistic.png"/>
                </td>                
            </tr>
        </table>
        
        <div>
        <logic:equal name="contractStatisticByKindViewHelper" property="notaryDateDisp" value="01"> 
	        <div style="text-align:center; margin-top:20px;">
	            <label style="font-weight:bold">
	                BÁO CÁO THỐNG KÊ HỢP ĐỒNG CÔNG CHỨNG
	            </label>
	            <br />
	            <label>
	                Ngày <bean:write name="contractStatisticByKindViewHelper" property="notaryDateFromDisp"/>
	            </label>
	        </div>
        </logic:equal>
        <logic:notEqual name="contractStatisticByKindViewHelper" property="notaryDateDisp" value="01"> 
	        <div style="text-align:center; margin-top:20px;">
	            <label style="font-weight:bold">
	                BÁO CÁO THỐNG KÊ HỢP ĐỒNG CÔNG CHỨNG
	            </label>
	            <br />
	            <label>
	                Từ ngày <bean:write name="contractStatisticByKindViewHelper" property="notaryDateFromDisp"/>
	                đến ngày <bean:write name="contractStatisticByKindViewHelper" property="notaryDateToDisp"/>
	            </label>
	        </div>
        </logic:notEqual>
        </div>
        
        <logic:notEmpty name="contractStatisticByKindViewHelper" property="listContractByKind">
        <div style="text-align:right; margin-top:10px; margin-bottom:10px;font-weight:bold;">
           <html:link href="javascript: report()"><html:img src="./image/btn_download.png" alt="Tải file báo cáo" /></html:link>
        </div>
        <div>
            <div>
		        <table class="tbl-list">
		            <tr>
		                <th>STT</th>
		                <th>Nhóm hợp đồng</th>
		                <th>Tên hợp đồng</th>
		                <logic:equal name="context" property="contractNotaryPlace" value="1">
		                <th>Lập tại VP</th>
		                <th>Lập ngoài VP</th>
		                </logic:equal>
		                <th>Tổng cộng</th>
		            </tr>
		            <% 
		                int j = 0;
		                long kind_id = 0;		                
		            %>
			            <logic:iterate id="item" name="contractStatisticByKindViewHelper" property="listContractByKind" indexId="i">
				            <tr class="tbl-row<%=j % 2%>">
				                <logic:greaterThan name="item" property="numberOfTemplateByKind" value="0">
	                                <td rowspan="<bean:write name="item" property="numberOfTemplateByKind"/>" 
	                                   style="text-align:center; width:40px; vertical-align: top;">
                                        <%=j + 1 %>
                                        <%j++; %>
	                                </td>
	                                
	                                <td rowspan="<bean:write name="item" property="numberOfTemplateByKind"/>" style="vertical-align: top;">
                                        <html:link action="/contractlistbykindview.do" paramId='kindid' paramName='item' paramProperty='kindId'>
                                            <bean:write name="item" property="kindName"/>
                                        </html:link>
                                    </td>                                    
                                </logic:greaterThan>
                                
                                
                                <td class="tbl-row<%=(j - 1) % 2%>" style="">
                                     <bean:write name="item" property="templateName"/>
                                </td>
                                
	                            <logic:greaterThan name="item" property="numberOfTemplateByKind" value="0">
	                                <logic:equal name="context" property="contractNotaryPlace" value="1">
	                                <td class="tbl-row<%=(j - 1) % 2%>" style="text-align:center; font-weight: bold;">
	                                   <bean:write name="item" property="numberOfInternalContract"/>
	                                </td>
	                                <td class="tbl-row<%=(j - 1) % 2%>" style="text-align:center; font-weight: bold;">
	                                   <bean:write name="item" property="numberOfExternalContract"/>
	                                </td>
	                                </logic:equal>
	                                <td class="tbl-row<%=(j - 1) % 2%>" style="text-align:center; font-weight: bold;">
	                                   <bean:write name="item" property="numberOfContract"/>
	                                </td>
                                </logic:greaterThan>
                                
                                <logic:lessEqual name="item" property="numberOfTemplateByKind" value="0">
                                    <logic:equal name="context" property="contractNotaryPlace" value="1">
                                    <td class="tbl-row<%=(j - 1) % 2%>" style="text-align:center;">
                                       <bean:write name="item" property="numberOfInternalContract"/>
                                    </td>
                                    <td class="tbl-row<%=(j - 1) % 2%>" style="text-align:center;">
                                       <bean:write name="item" property="numberOfExternalContract"/>
                                    </td>
                                    </logic:equal>
                                    <td class="tbl-row<%=(j - 1) % 2%>" style="text-align:center;">
                                       <bean:write name="item" property="numberOfContract"/>
                                    </td>
                                </logic:lessEqual>
                               
				            </tr>
			            </logic:iterate>
                       
                        <tr class="tbl-row-end">
	                        <td colspan="3" style="text-align:center">
	                            Tổng cộng
	                        </td>
	                        <logic:equal name="context" property="contractNotaryPlace" value="1">
	                        <td style="text-align:center">
                                <bean:write name="contractStatisticByKindViewHelper" property="numberOfInternalContract"/>
                            </td>	                        
	                        <td style="text-align:center">
	                            <bean:write name="contractStatisticByKindViewHelper" property="numberOfExternalContract"/>
	                        </td>
	                        </logic:equal>
	                        <td style="text-align:center">
	                            <bean:write name="contractStatisticByKindViewHelper" property="numberOfContract"/>
	                        </td>                     
                        </tr>
		        </table>
	        </div>
        </div>
        
        <div style="text-align:right; margin-top:10px; margin-bottom:10px;font-weight:bold;">
           <html:link href="javascript: report()"><html:img src="./image/btn_download.png" alt="Tải file báo cáo" /></html:link>
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
	
	function statistics() {
		if (document.getElementById("notaryDateFilter").value != "05") {
			document.getElementById("notaryDate-1").value = "";
			document.getElementById("notaryDate-2").value = "";
		}
	    document.contractStatisticByKindForm.action="contractstatisticbykinddone.do";
	}
	
	function report() {
        document.contractStatisticByKindForm.action="contractstatisticbykindexport.do";
        document.contractStatisticByKindForm.submit();
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
    
</script>