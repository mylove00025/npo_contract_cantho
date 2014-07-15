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
	             <html:link href="userlistview.do">Quản trị hệ thống</html:link>
	         </li>
	         <li>
                 <span> > </span>
                 <html:link href="#">Lịch sử truy cập hệ thống</html:link>
             </li> 
	     </ul>
    </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
    
    <html:form action="accesshistorylist" onsubmit="javascript: search();">
    
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
            <tr>
                <th nowrap="nowrap">Tên người dùng</th>
                <td nowrap="nowrap" colspan="4">
                
                   <html:select styleId="userIdFilter" name="accessHistoryViewHelper" property="userIdFilter" onchange="onchangeSelect(this.id,'0')">
                          <html:option value="0"><i>[Tất cả]</i></html:option>
                          <html:optionsCollection name="accessHistoryViewHelper" property="userList" label="fullNameAndAccount" value="id" />
                   </html:select>
                </td>
            
                <th nowrap="nowrap">&nbsp;&nbsp;&nbsp;Ngày truy cập</th>
                <td nowrap="nowrap">
                    <html:select styleId="executeDateTimeFilter" name="accessHistoryViewHelper" property="executeDateTimeFilter" onchange="onchangeSelect(this.id,'00')">
                        <html:option value="00">[Tất cả]</html:option>
                        <html:option value="01">Trong ngày hôm nay</html:option>
                        <html:option value="02">Trong tuần này</html:option>
                        <html:option value="03">Trong tháng này</html:option>
                        <html:option value="04">Trong năm nay</html:option>
                        <html:option value="05">Khoảng thời gian</html:option>
                    </html:select>
                </td>
                <th nowrap="nowrap" id="notaryDate_th" colspan ="2" class="dateFilter">
                    Từ ngày&nbsp;&nbsp;&nbsp;
                    <html:text styleId="notaryDate-1" property="accessDateFromFilter" name="accessHistoryViewHelper">
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
                    &nbsp;
                    Đến ngày&nbsp;&nbsp;&nbsp;
                    <html:text styleId="notaryDate-2" property="accessDateToFilter" name="accessHistoryViewHelper">
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
                <th nowrap="nowrap">&nbsp;&nbsp;&nbsp;Kiểu truy cập</th>
                <td nowrap="nowrap">
                    <html:select styleId="accessTypeFilter" name="accessHistoryViewHelper" property="accessTypeFilter" onchange="onchangeSelect(this.id,'2')">	  
                            <html:option value="2">[Tất cả]</html:option>         
		                    <html:option value="0"> Đăng nhập </html:option>
		                    <html:option value="1"> Đăng xuất </html:option>
                    </html:select>                   
                </td>
                
            </tr>   
            
            <tr>
                <td nowrap="nowrap" colspan="4" style="text-align: center; padding: 10px;">
	               <html:image alt="Tìm kiếm" src="./image/btn_search.png"/>
                </td>
            </tr>   
               
        </table>
        
        <div>
            <div class="clearfix-left">
                <span>◊ Danh sách người truy cập hệ thống</span>
            </div>
        </div>
        <logic:notEmpty name="accessHistoryViewHelper" property="accList">
            <table class="tbl-list">
                <tr>
                    <th>Người truy cập</th>
	                <th>Ngày truy cập</th>
                    <th>Máy truy cập</th>
                    <th>Kiểu truy cập</th>
                </tr>            
                <logic:iterate id="item" name="accessHistoryViewHelper" property="accList" indexId="i">
                    <tr class="tbl-row<%=i % 2%>">
                        <td style="text-align: center;">
                           <bean:write name="item" property="executePerson" />
                        </td>
                        <td style="text-align: center;">
                            <bean:write name="item" property="executeDateTime" format="dd/MM/yyyy HH:mm:ss"/>
                        </td>
                        <td style="text-align: center;">
                            <bean:write name="item" property="clientInfo"/>                           
                        </td>
                        <td style ="text-align: center;">
                            <bean:write name="item" property="type"/>
                        </td>
                    </tr>    
                </logic:iterate>
            </table>
        
            <logic:greaterThan name="accessHistoryViewHelper" property="totalCount" value="0">
            <div class="pager">
                <div class="pager-total">Tổng số <strong><bean:write name="accessHistoryViewHelper" property="totalCount"/></strong> dữ liệu</div>
                <div>
                    <logic:greaterThan name="accessHistoryViewHelper" property="totalPage" value="1">
	                    <html:link href="javascript:direction('first')">        
	                        <img class="pager-first" src="./image/first.png" alt= "first"/>
	                    </html:link>
	                    <html:link href="javascript:direction('ahead')">
	                        <img class="pager-prev" src="./image/prev.png" alt= "prev"/>
                    </html:link>
                    </logic:greaterThan>
                    <span>
                        Trang&nbsp;
                        <bean:write name="accessHistoryViewHelper" property="page" format="##########"/>
                         /<bean:write name="accessHistoryViewHelper" property="totalPage" format="##########"/>
                    </span>
                    <logic:greaterThan name="accessHistoryViewHelper" property="totalPage" value="1">
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
            <br></br><br></br>
        </logic:notEmpty>
    </html:form>
    <%@ include file="/jsp/common/footer.jsp" %> 
</html:html>

<script type="text/javascript">
    //Hight light
	$('#contract > em').removeClass("contract-off");
	$('#contract > em').addClass("contract-on");
	$('#contract > b').addClass("menu-on");
    
    document.getElementById("userIdFilter").focus();
    onchangeSelect("executeDateTimeFilter","00");
    onchangeSelect("userIdFilter","0");
    onchangeSelect("accessTypeFilter","2");
    
	var LEFT_CAL = Calendar.setup({
	    cont: "cont",
	    weekNumbers: true,
	    selectionType: Calendar.SEL_MULTIPLE,
	    showTime: 12
	    // titleFormat: "%B %Y"
    });
	
	function search() {
        if (document.getElementById("executeDateTimeFilter").value != "05") {
            document.getElementById("notaryDate-1").value = "";
            document.getElementById("notaryDate-2").value = "";
        }
        document.accessHistoryForm.action="accesshistorysearch.do";
        document.accessHistoryForm.submit();
        return true;
    }
    
    function direction(data){
        document.accessHistoryForm.direction.value=data;
        document.accessHistoryForm.action="accesshistorylistpaging.do";
        document.accessHistoryForm.submit();
        return true;
    }
    
    function report() {
        document.accessHistoryForm.action="contractlistbykindexport.do";
        document.accessHistoryForm.submit();
        return true;
    }
    
    var value = $('#executeDateTimeFilter option:selected').val();
    if(value == "05") {
    	$('th.dateFilter').show();
    } else {
    	$('th.dateFilter').hide();
    }
    
    $('#executeDateTimeFilter').change(function() {    	
    	var value = $('#executeDateTimeFilter option:selected').val();
    	if(value == "05") {    		
            $('th.dateFilter').show();
        } else {
        	$('th.dateFilter').hide();
    	}
    });  
    
    
</script>