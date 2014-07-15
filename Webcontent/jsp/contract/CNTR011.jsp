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
                    &gt;<html:link href="#">Thống kê tổng hợp</html:link>
                </li>               
            </ul>
        </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
    <html:form styleId="form" action="contractstatisticview" onsubmit="javascript: statistics();">
        <div class="sub-title">
            <span><strong>◊ Điều kiện thống kê</strong></span>                               
        </div>      
        <table class="tbl-none-border">
            <tr>
                <th>Ngày công chứng</th>
                <td style="vertical-align: middle;">
                    <html:select styleId="notaryDateFilter" name="contractStatisticViewHelper" property="notaryDateFilter" styleClass="input-normal">
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
        
        <div style="width: 800px;">
        <logic:equal name="contractStatisticViewHelper" property="notaryDateDisp" value="01"> 
	        <div style="text-align:center; margin-top:20px;">
	            <label style="font-weight:bold">
	                THỐNG KÊ SỐ LƯỢNG HỢP ĐỒNG ĐÃ CÔNG CHỨNG
	            </label>
	            <br />
	            <label>
	                Ngày <bean:write name="contractStatisticViewHelper" property="notaryDateFromDisp"/>
	            </label>
	        </div>
        </logic:equal>
        <logic:notEqual name="contractStatisticViewHelper" property="notaryDateDisp" value="01"> 
	        <div style="text-align:center; margin-top:20px;">
	            <label style="font-weight:bold">
	                THỐNG KÊ SỐ LƯỢNG HỢP ĐỒNG ĐÃ CÔNG CHỨNG
	            </label>
	            <br />
	            <label>
	                Từ ngày <bean:write name="contractStatisticViewHelper" property="notaryDateFromDisp"/>
	                đến ngày <bean:write name="contractStatisticViewHelper" property="notaryDateToDisp"/>
	            </label>
	        </div>
        </logic:notEqual>
        </div>
        
        <div style="margin-top:20px;">
            <label style="font-weight:bold">
                Tổng số hợp đồng văn phòng đã công chứng :
                <bean:write name="contractStatisticViewHelper" property="totalContract" />
            </label>
        </div> 
        <div style="margin-top:20px">
            <label style="font-weight:bold">
                Tổng số hợp đồng lỗi :
                <bean:write name="contractStatisticViewHelper" property="totalErrorContract" />
            </label>
        </div> 
        <!-- Theo cong chung vien -->
        <div style="margin-top:20px; width:800px;">
            <div class="sub-title">
                I) Số lượng hợp đồng theo công chứng viên
            </div>
            <div style="margin-left:30px;">
		        <table class="tbl-list">
		            <tr>
		                <th>STT</th>
		                <th>Tên công chứng viên</th>
		                <th>Số hợp đồng đã công chứng</th>
		                <logic:equal name="context" property="contractErrorStatus" value="1">
		                <th>Số hợp đồng lỗi</th>
		                </logic:equal>
		            </tr>
		            <logic:notEmpty name="contractStatisticViewHelper" property="listContractByNotary">
			            <logic:iterate id="item" name="contractStatisticViewHelper" property="listContractByNotary" indexId="i">
				            <tr class="tbl-row<%=i % 2%>">
				                <td style="text-align:center; width:40px;">
				                    <%=i + 1%>
				                </td>
				                <td>
			                        <bean:write name="item" property="familyName"/>
			                        <bean:write name="item" property="firstName"/>
				                </td>
				                <td style="text-align:center;">
				                   <bean:write name="item" property="numberOfContract"/>
				                </td>
				                <logic:equal name="context" property="contractErrorStatus" value="1">
				                <td style="text-align:center;">
				                   <bean:write name="item" property="numberOfErrorContract"/>
				                </td>
				                </logic:equal>
				            </tr>
			            </logic:iterate>
		            
		            <tr class="tbl-row-end">
                        <td colspan="2" style="text-align:center">
                            Tổng số
                        </td>
                        <td style="text-align:center">
                            <bean:write name="contractStatisticViewHelper" property="totalContractByNotary"/>
                        </td>
                        <logic:equal name="context" property="contractErrorStatus" value="1">
                        <td style="text-align:center">
                            <bean:write name="contractStatisticViewHelper" property="totalErrorContractByNotary"/>
                        </td>     
                        </logic:equal>                 
                    </tr>    
                    </logic:notEmpty>        
		        </table>
	        </div>
        </div>
        
        <!-- Theo chuyen vien soan thao -->
        <div style="margin-top:20px; width:800px;">
            <div class="sub-title">
                II) Số lượng hợp đồng theo chuyên viên soạn thảo
            </div>
	        <div style="margin-left:30px;">
		        <table class="tbl-list">
		            <tr>
		                <th>STT</th>
		                <th>Tên chuyên viên soạn thảo</th>
		                <th>Số hợp đồng đã soạn thảo</th>
		                <logic:equal name="context" property="contractErrorStatus" value="1">
		                <th>Số hợp đồng lỗi</th>
		                </logic:equal>
		            </tr>
		            <logic:notEmpty name="contractStatisticViewHelper" property="listContractByDrafter">
	                    <logic:iterate id="item" name="contractStatisticViewHelper" property="listContractByDrafter" indexId="i">
	                    
	                        <tr class="tbl-row<%=i % 2%>">
	                            <td style="text-align:center; width:40px;">
	                                <%=i + 1%>
	                            </td>
	                            <td>
	                                <bean:write name="item" property="familyName"/>
	                                <bean:write name="item" property="firstName"/>
	                            </td>
	                            <td style="text-align:center;">
	                               <bean:write name="item" property="numberOfContract"/>
	                            </td>
	                            <logic:equal name="context" property="contractErrorStatus" value="1">
	                            <td style="text-align:center;">
	                               <bean:write name="item" property="numberOfErrorContract"/>
	                            </td>
	                            </logic:equal>
	                        </tr>
	                    </logic:iterate>
                    <tr class="tbl-row-end">
                        <td colspan="2" style="text-align:center">
                            Tổng số
                        </td>
                        <td style="text-align:center">
                            <bean:write name="contractStatisticViewHelper" property="totalContractByDrafter"/>
                        </td>
                        <logic:equal name="context" property="contractErrorStatus" value="1">
                        <td style="text-align:center">
                            <bean:write name="contractStatisticViewHelper" property="totalErrorContractByDrafter"/>
                        </td>
                        </logic:equal>                  
                    </tr>		
                    </logic:notEmpty>            
		        </table>
	        </div>
        </div>
        
        <logic:equal value="true" name="CommonContext" property="bankReport">
        <!-- Theo ngan hang -->
        <div style="margin-top:20px; width:800px;">
            <div class="sub-title">
                III) Số lượng hợp đồng theo ngân hàng
            </div>
	        <div style="margin-left:30px;">
	            <table class="tbl-list">
	                <tr>
	                    <th>STT</th>
	                    <th>Tên ngân hàng</th>
	                    <th>Số hợp đồng đã giới thiệu</th>
	                </tr>
	                <logic:notEmpty name="contractStatisticViewHelper" property="listContractByBank">
		                <logic:iterate id="item" name="contractStatisticViewHelper" property="listContractByBank" indexId="i">
		                
	                        <tr class="tbl-row<%=i % 2%>">
	                            <td style="text-align:center; width:40px;">
	                                <%=i + 1%>
	                            </td>
	                            <td>
	                                <bean:write name="item" property="bankName"/>                                
	                            </td>
	                            <td style="text-align:center;">
	                               <bean:write name="item" property="numberOfContract"/>
	                            </td>
	                        </tr>
	                    </logic:iterate>
                    <tr class="tbl-row-end">
		                <td colspan="2" style="text-align:center">
		                    Tổng số
		                </td>
		                <td style="text-align:center">
                            <bean:write name="contractStatisticViewHelper" property="totalContractByBank"/>
		                </td>		                
                    </tr> 
                    </logic:notEmpty>                   
	            </table>
	        </div>        
        </div>
        </logic:equal>

        <div style="text-align:right; margin-top:20px; margin-bottom:20px;font-weight:bold; width:800px;">
           <html:link href="javascript: report()"><html:img src="./image/btn_download.png" alt="Tải file báo cáo" /></html:link>
        </div>
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
	    document.contractStatisticForm.action="contractstatisticdone.do";
	}
	
	function report() {
        document.contractStatisticForm.action="contractstatisticexport.do";
        document.contractStatisticForm.submit();
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