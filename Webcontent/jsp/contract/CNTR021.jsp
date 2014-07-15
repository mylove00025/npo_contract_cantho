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
                    &gt;<html:link href="#">In sổ hợp đồng công chứng</html:link>
                </li>               
            </ul>
        </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
    <html:form action="printnotarybookview" onsubmit="javascript: report();">
        
        <table class="tbl-none-border">
            <tr>
                <th><strong>◊ Ngày công chứng</strong></th>
                <td style="vertical-align: middle;">
                    <html:select styleId="notaryDateFilter" name="contractCertifyViewHelper" property="notaryDateFilter" styleClass="input-normal">
                        <html:option value="01">Trong ngày</html:option>
                       
                        <html:option value="03">Trong tháng</html:option>
                        <html:option value="04">Trong năm</html:option>
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
                <th id="notaryDay_td" class="dayFilter">
                    <html:text styleId="notaryDayFilter" property="notaryDayFilter" name="contractCertifyViewHelper" styleClass="input-normal" 
                                style="width: 100px;">
                    </html:text>
                    <html:img styleId="popupCal-3" src="./image/calendar.png" alt="calendar" styleClass="onmouseover"
                                    style="vertical-align: middle;"/>
                    <script type="text/javascript">
                          new Calendar({
                              inputField: "notaryDayFilter",
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
               </th>
                <th id="notaryMonth_td" class="monthFilter">
	                   <html:text styleId="notaryMonMonthFilter" property="notaryMonMonthFilter" name="contractCertifyViewHelper" styleClass="input-normal" 
	                                       maxlength="2" style="width: 30px;">
                       </html:text>
                       /
                       <html:text styleId="notaryMonYearFilter" property="notaryMonYearFilter" name="contractCertifyViewHelper" styleClass="input-normal" 
                                           maxlength="4" style="width: 50px;">
                       </html:text>
	             </th>
	             <th id="notaryYear_td" class="yearFilter">
	                   <html:text styleId="notaryYearFilter" property="notaryYearFilter" name="contractCertifyViewHelper" styleClass="input-normal" 
	                                       maxlength="4" style="width: 50px;">
	                   </html:text>
	             </th>
	             
	             <th id="sortType"><strong>◊ Loại sổ:<strong></th>
	             <td width="150px"><html:radio styleId="sortByNumber" property="sortType" style="vertical-align:sub" value = "true">Sắp xếp theo số</html:radio></td>
	         	 <td><html:radio property="sortType" style="vertical-align:sub" value = "false">Sắp xếp theo ngày</html:radio></td>
	             
            </tr>
            <tr>
            	<th><strong>◊ Nhóm hợp đồng</strong></th>
            	<td style="padding-top:5px">
            		
                    <html:checkbox value="checked" style="vertical-align:sub" name="contractCertifyViewHelper" styleId="chkAllID" property="chkAllID" disabled="false"/>
                    Tất cả
            	</td>
            </tr>
           
         </table>
         <table class="tbl-none-border">
				<tr>
		            <td colspan="2">
		                <table style="margin-left:0px;width:980px">
                			<tbody id="authorityListContent">
                				<tr>
                					<td>
                						<ul style="list-style-type:none">
						                <logic:iterate id="item" name="contractCertifyViewHelper" property="contractKindList" indexId="i">
						                    <li style="float:left;padding-right:10px;padding-bottom:10px;min-width:175px">
						                        <div style="text-align: center; width: 25px;float:left">
						                            <html:multibox name="contractCertifyViewHelper" styleId="chkID" property="chkID" disabled="false">
						                                <bean:write name='item' property='id'/>
						                            </html:multibox>
						                            
						                        </div>
						                        <div style="float:left;line-height:1.5">
						                             <bean:write name="item" property="name"/>
						                        </div>
						                    </li>    
						                </logic:iterate>
						                </ul>
				                	</td>
				                </tr>
                			</tbody>
                			
				            <tr>
				                <td colspan="4" style="text-align: center; padding: 10px;">                       
				                    <html:image alt="Tải file báo cáo" src="./image/btn_download.png"/>
				                </td>                
				            </tr>
		                </table>
		            </td>
		        </tr>
        </table>
        
        
               
    </html:form>
    <%@ include file="/jsp/common/footer.jsp" %> 
</html:html>    
<script type="text/javascript">

	$('#contract > em').removeClass("contract-off");
	$('#contract > em').addClass("contract-on");
	$('#contract > b').addClass("menu-on");
	document.getElementById("sortByNumber").checked = true;
	document.getElementById("chkAllID").checked = true;
	$("input[@name=chkID]").each(function()
	        {
	            this.checked = true;
	        });
	document.getElementById("notaryDateFilter").focus();	
	function statistics() {
		if (document.getElementById("notaryDateFilter").value != "05") {
			document.getElementById("notaryDate-1").value = "";
			document.getElementById("notaryDate-2").value = "";
		}
	    document.contractStatisticForm.action="contractstatisticdone.do";
	}
	function report() {
		$('#message_box').hide();
		$('#err_box').hide();		
        $('.error-cell').removeClass("error-cell");
	    document.contractCertifyForm.action="printnotarybookexport.do";
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
        $('th.monthFilter').hide();
        $('th.yearFilter').hide();
        $('th.dayFilter').hide();
    }
    else if(value=="04"){
		$('th.yearFilter').show();
		$('th.dateFilter').hide();
        $('th.monthFilter').hide();
        $('th.dayFilter').hide();
    }
    else if(value=="01") {
    	 $('th.dayFilter').show();
        $('th.dateFilter').hide();
        $('th.monthFilter').hide();
        $('th.yearFilter').hide();
    }
    else {
		$('th.monthFilter').show();	
		$('th.dateFilter').hide();
		$('th.yearFilter').hide();
		$('th.dayFilter').hide();
    }
    
    $('#notaryDateFilter').change(function() {      
        var value = $('#notaryDateFilter option:selected').val();
        if(value == "05") {         
            $('th.dateFilter').show();
            $('th.monthFilter').hide();
            $('th.yearFilter').hide();
            $('th.dayFilter').hide();
        }
        
        else if(value=="04"){
        	$('th.yearFilter').show();
        	$('th.dateFilter').hide();
            $('th.monthFilter').hide();
            $('th.dayFilter').hide();
            }
        else if (value=="01") {
        	$('th.dayFilter').show();
            $('th.dateFilter').hide();
            $('th.monthFilter').hide();
            $('th.yearFilter').hide();
        }
        else if(value == "03"){
			$('th.monthFilter').show();
			$('th.dateFilter').hide();
			$('th.yearFilter').hide();
			$('th.dayFilter').hide();
        }
    });

  //Check all multibox function
    $("#chkAllID").click(function()             
    {
        var checked_status = this.checked;
        $("input[@name=chkID]").each(function()
        {
            this.checked = checked_status;
        });
    });
      
</script>