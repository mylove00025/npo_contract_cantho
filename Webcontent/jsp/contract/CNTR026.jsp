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
	             <html:link href="#">Danh sách hợp đồng chờ ký</html:link>
	         </li>                       
	     </ul>
    </div>
    <%@ include file="/jsp/common/error_message.jsp" %>  
                      
    <html:form action="temporarycontractlistview" onsubmit="javascript: search();">
    <html:hidden styleId="isHidePanelSearch" property="isHidePanelSearch" name="temporaryContractListViewHelper"/>
        <html:hidden styleId="isAdvanceSearch" property="isAdvanceSearch" name="temporaryContractListViewHelper"/>
        <html:hidden styleId="keyHighLight" property="keyHighLight" name="temporaryContractListViewHelper"/>
        <div id="mystickytooltip" class="stickytooltip">
            <div class="tooltipClassic">
                <div class="toolbar">
                    <div class="title">
                        <a id="closeTooltip" class="close"></a>
                        Thông tin chi tiết
                    </div>
                </div>
                <div id="tooltipContent" class="content" class="content" style="overflow-y: auto; overflow-x:auto; max-height: 400px;">
                </div>
            </div>
        </div>
        
        <div id="searchShow" class="sub-title">
            <span class="tree_open" id="searchOption" style="cursor: pointer; margin: 0px;" onclick="changeSearchState(); setSearchState();"></span>
            <strong class="onmouseover" onclick="changeSearchState(); setSearchState();">Điều kiện tìm kiếm</strong>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <!-- <a class="advanceSearch" style="color: blue; font-weight: normal;" onclick="changeSearch('false')">
                [Tìm kiếm theo từ khóa]
            </a>
            <a class="keySearch" style="color: blue; font-weight: normal;" onclick="changeSearch('true')">
                [Tìm kiếm nâng cao]
            </a>-->
        </div>
        
        <!--<div id="keySearchPanel" class="keySearch" style="padding-left: 25px;">
            <span style="vertical-align: middle;">Từ khóa</span>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <html:text styleId="keySearch" name="temporaryContractListViewHelper" property="keySearch"
                             styleClass="input-long" style="vertical-align: middle;"/>
            &nbsp;&nbsp;&nbsp;
            <html:image alt="Tìm kiếm" src="./image/btn_search.png" style="vertical-align: middle;"/>
        </div>-->
         
        <table id="tblSearch" class="advanceSearch tbl-search" class="tbl-none-border">
            <tr>
                <td nowrap="nowrap" style="padding-left: 15px; line-height: 1.5;">
                    Nhóm hợp đồng<br/>
                    <select name="contractKindIdFilter" id="contractKindIdFilter" style="width: 270px;"
                                onchange="onchangeSelect(this.id,'0'); changeKind('contractKindIdFilter', 'contractTemplateIdFilter', 0);">
	                    <option value="0">[Tất cả]</option>
		                    <logic:iterate id="item" name="temporaryContractListViewHelper" property="contractKindTree">                            
			                    <option value="<bean:write name='item' property='id'/>">
			                        <bean:write name="item" property="spaces" filter="false"/>
			                        <bean:write name="item" property="name"/>
			                    </option>
		                    </logic:iterate> 
                    </select>
                </td>
                <td nowrap="nowrap" style="padding-left: 15px; line-height: 1.5;">
                    Tên hợp đồng <br/>
                    <html:select styleId="contractTemplateIdFilter" name="temporaryContractListViewHelper"
                            property="contractTemplateIdFilter" style="width: 370px;" onchange="onchangeSelect(this.id,'0')">
                        <option value="0">[Tất cả]</option>
                        <html:optionsCollection name="temporaryContractListViewHelper" property="contractTemplateList" label="name" value="id" />
                    </html:select>
                </td>
                <td nowrap="nowrap" style="padding-left: 15px; line-height: 1.5;">
                    Số hợp đồng <br/>
                    <html:text styleId="contractNumberFilter" name="temporaryContractListViewHelper" property="contractNumberFilter"
                                    styleClass="input-normal" maxlength="20"/>
                </td> 
            </tr>
            
            <tr>
                <td nowrap="nowrap" style="padding-left: 15px; line-height: 1.5;">
                    Bên liên quan <br/>
                    <html:text styleId="relationObjectFilter" name="temporaryContractListViewHelper" property="relationObjectFilter"
                                    style="width: 266px;"/>
                </td>
                <td nowrap="nowrap" colspan="2" style="padding-left: 15px; line-height: 1.5;">
                    Ngày nhập <br/>
                    <html:select styleId="notaryDateFilter" name="temporaryContractListViewHelper" property="notaryDateFilter"
                            onchange="onchangeSelect(this.id,'00')">
                        <html:option value="00">[Tất cả]</html:option>
                        <html:option value="01">Trong ngày hôm nay</html:option>
                        <html:option value="02">Trong tuần này</html:option>
                        <html:option value="03">Trong tháng này</html:option>
                        <html:option value="04">Trong năm nay</html:option>
                        <html:option value="05">Khoảng thời gian</html:option>
                    </html:select>
                    <span id="notaryDate_th" class="dateFilter">
                        &nbsp;&nbsp;&nbsp;
	                    Từ ngày&nbsp;
	                    <html:text styleId="notaryDate-1" property="notaryDateFromFilter" name="temporaryContractListViewHelper">
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
	                    &nbsp;&nbsp;&nbsp;
	                    Đến ngày&nbsp;
	                    <html:text styleId="notaryDate-2" property="notaryDateToFilter" name="temporaryContractListViewHelper">
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
                    </span>
                </td>
            </tr>
            
            <tr>                
                <td nowrap="nowrap" style="padding-left: 15px; line-height: 1.5;">
                    Thông tin tài sản <br/>
                    <html:text styleId="propertyInfoFilter" property="propertyInfoFilter" name="temporaryContractListViewHelper" style="width: 266px;">
                        </html:text>
                </td>
            </tr>            
            
            <tr>
                <td nowrap="nowrap" colspan="4" style="text-align: center; padding: 10px;">
	                <html:image alt="Tìm kiếm" src="./image/btn_search.png"/>
	                <html:link href="javascript: clear()">
	                    <html:img alt="Xóa điều kiện" src="./image/btn_clear.png"/>
	                </html:link>
                </td>
            </tr>       
        </table>
        
        <!-- 
        <div class="sub-title">
               <span>◊ Điều kiện tìm kiếm</span>
        </div>
        <table id="tblSearch" class="tbl-none-border">
            <tr>
                <th>Điều kiện tìm kiếm</th>
                <td>
                    
                </td>
            </tr>
             <tr>
                <td nowrap="nowrap" colspan="4" style="text-align: center; padding: 10px;">
	                <html:image alt="Tìm kiếm" src="./image/btn_search.png"/>
	                <html:link href="javascript: clear()">
	                    <html:img alt="Xóa điều kiện" src="./image/btn_clear.png"/>
	                </html:link>
                </td>
            </tr>       
        </table>
        <div>
            <div class="clearfix-left">
                <span>◊ Danh sách hợp đồng công chứng dự thảo</span>
            </div>
        </div>
        
         -->
        <div>
            <div class="clearfix-left">
                <span>◊ Danh sách hợp đồng chờ ký</span>
            </div>
            <div class="clearfix-right">
                 <%
                if (context.isTemporaryContractManagement()) {
                %>
                <html:link href="temporarycontractregistview.do" style="padding-bottom:10px;">
		        <html:img alt="Them moi" src="./image/btn_add.png"/>
		    </html:link>
		     <%} %>
            </div>
        </div>
            
        <logic:notEmpty name="temporaryContractListViewHelper" property="contractList">
            <table class="tbl-list">
                <tr>
             	    <th>Số hợp đồng</th>
                    <th>Ngày nhập</th>
                    <th>Người nhập</th>
	                <th>Tên hợp đồng</th>
	                <th>Bên liên quan</th>
	                <th>Nội dung</th>
                </tr>            
                <logic:iterate id="item" name="temporaryContractListViewHelper" property="contractList" indexId="i">
                    <tr class="tbl-row<%=i % 2%>">
                    	<td style="text-align: center;"><html:link action="temporarycontractdetailview" paramId='id' paramName='item' paramProperty='tcid'>
                    			 <bean:write name="item" property="contractNumber" />
                    	 </html:link>
                    	</td>
                        <td style="text-align: center;">
                                <bean:write name="item" property="entryDateTime" format="dd/MM/yyyy" />            
                        </td>
                        <td>
                            <bean:write name='item' property='entryUserName'/>                                                 
                        </td>                        
                        <td>
                            <bean:write name="item" property="contractTemplateName"/>                           
                        </td>                       
                        <td>
                            <span data-tooltip="contractsticky<%=i%>" class="datatooltip">
                                <bean:write name='item' property='contractInformationDisp' filter="false"/>
                                <bean:define id="infoDisp" name="item" property="contractInformationDisp" type="java.lang.String"></bean:define>
                                <bean:define id="info" name="item" property="contractInformation" type="java.lang.String"></bean:define>
                                <%
                                if (!infoDisp.equals(info)) {
                                %>
                                    <img class="onmouseover" src="./image/icon_search.png"></img>
                                <%} %>
                            </span>                            
                        </td>
                        <td>                            
                            <span data-tooltip="summarysticky<%=i%>" class="datatooltip">
                                <bean:write name='item' property='shorttenContractSummaryDisp' filter="false"/>
                                <bean:define id="infoDisp" name="item" property="shorttenContractSummaryDisp" type="java.lang.String"></bean:define>
                                <bean:define id="info" name="item" property="contractSummaryDisp" type="java.lang.String"></bean:define>
                                <%
                                if (!infoDisp.equals(info)) {
                                %>
                                    <img class="onmouseover" src="./image/icon_search.png"></img>
                                <%} %>
                            </span>                            
                        </td>
                    </tr>    
                </logic:iterate>
            </table>
        
            <logic:greaterThan name="temporaryContractListViewHelper" property="totalCount" value="0">
            <div class="pager">
                <div class="pager-total">Tổng số <strong><bean:write name="temporaryContractListViewHelper" property="totalCount"/></strong> dữ liệu</div>
                <div>
                    <logic:greaterThan name="temporaryContractListViewHelper" property="totalPage" value="1">
	                    <html:link href="javascript:direction('first')">        
	                        <img class="pager-first" src="./image/first.png" alt= "first"/>
	                    </html:link>
	                    <html:link href="javascript:direction('ahead')">
	                        <img class="pager-prev" src="./image/prev.png" alt= "prev"/>
                    </html:link>
                    </logic:greaterThan>
                    <span>
                        Trang&nbsp;
                        <bean:write name="temporaryContractListViewHelper" property="page" format="##########"/>
                         /<bean:write name="temporaryContractListViewHelper" property="totalPage" format="##########"/>
                    </span>
                    <logic:greaterThan name="temporaryContractListViewHelper" property="totalPage" value="1">
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
        </logic:notEmpty>
    </html:form>
    
    <br/>
    <%@ include file="/jsp/common/footer.jsp" %> 
</html:html>

<script type="text/javascript">

	$('#contract > em').removeClass("contract-off");
	$('#contract > em').addClass("contract-on");
	$('#contract > b').addClass("menu-on");
    
document.getElementById("contractKindIdFilter").focus();
    
    setSearchState();

    function setSearchState() {
        var val = document.getElementById("isHidePanelSearch").value;
        if (val == "true") {
            $('#searchOption').removeClass('tree_open');
            $('#searchOption').addClass('tree_close');
            $('#tblSearch').hide();
            //$('#keySearchPanel').hide();
            //var value = $('#isAdvanceSearch').val();
            //if (value == 'true') {
             //   $('a.advanceSearch').show();
             //  $('a.keySearch').hide();
            //} else {
            //    $('a.advanceSearch').hide();
             //   $('a.keySearch').show();
            //}
        } else {
            $('#searchOption').removeClass('tree_close');
            $('#searchOption').addClass('tree_open');
            $('#tblSearch').show();
            //changeSearch( $('#isAdvanceSearch').val());
        }
    }
    
    function changeSearchState() {
        var val = $('#isHidePanelSearch').val();
        if (val == "true") {
        	$('#isHidePanelSearch').val(false);
        } else {
        	$('#isHidePanelSearch').val(true);
        }       
    }
    
    function changeSearch(value) {
    	$('#searchOption').removeClass('tree_close');
        $('#searchOption').addClass('tree_open');
        $('#isHidePanelSearch').val(false);
        $('#isAdvanceSearch').val(value);
        if (value == 'true') {
            $('.advanceSearch').show();
            $('.keySearch').hide();
        } else {
            $('.advanceSearch').hide();
            $('.keySearch').show();
        }
    }
    
	var LEFT_CAL = Calendar.setup({
	    cont: "cont",
	    weekNumbers: true,
	    selectionType: Calendar.SEL_MULTIPLE,
	    showTime: 12
	    // titleFormat: "%B %Y"
    });
	
	function search() {
        document.temporaryContractListForm.action="temporarycontractlistsearch.do";
        return true;
    }
    
    function direction(data){
        document.temporaryContractListForm.direction.value=data;
        document.temporaryContractListForm.action="temporarycontractlistpaging.do";
        document.temporaryContractListForm.submit();
        return true;
    }
    
    function clear() {
    	document.getElementById("contractNumberFilter").value = "";
        document.getElementById("contractKindIdFilter").value = 0;
        document.getElementById("contractTemplateIdFilter").value = 0;
        document.getElementById("relationObjectFilter").value = "";
        document.getElementById("notaryDateFilter").value = "00";
        document.getElementById("notaryDate-1").value = "";
        document.getElementById("notaryDate-2").value = "";
        document.getElementById("propertyInfoFilter").value = "";
        $('span.dateFilter').hide();
        $('#err_box').hide();
        $('.error-cell').removeClass("error-cell");
        changeKind('contractKindIdFilter', 'contractTemplateIdFilter', 0);
        
        onchangeSelect("contractKindIdFilter","0");
        onchangeSelect("contractTemplateIdFilter","0");
        onchangeSelect("notaryDateFilter","00");
        onchangeSelect("contractStatusFilter","00");
    }
    
    var value = $('#notaryDateFilter option:selected').val();
    if(value == "05") {
    	$('span.dateFilter').show();
    } else {
    	$('span.dateFilter').hide();
    }
    
    $('#notaryDateFilter').change(function() {    	
    	var value = $('#notaryDateFilter option:selected').val();
    	if(value == "05") {
            $('span.dateFilter').show();
        } else {
        	$('span.dateFilter').hide();
    	}
    });  
    
    var selectedKindId = "<bean:write name='temporaryContractListViewHelper' property='contractKindIdFilter'/>";
    if (selectedKindId != "") {
        document.getElementById("contractKindIdFilter").value = selectedKindId;
    }
    
    var aryDesc = new Array();
    
    <logic:iterate id="item" name="temporaryContractListViewHelper" property="contractTemplateList" indexId="i">
        aryDesc[<%=i%>] = ["<bean:write name='item' property='kindId'/>", "<bean:write name='item' property='id'/>"
                           ,"<bean:write name='item' property='name'/>"];
    </logic:iterate>
    
    function changeKind(idSrc, idDesc, isRequredAll) {    	
    	var selSrc = document.getElementById(idSrc);
    	var selDesc = document.getElementById(idDesc);
        var i;
        if(!selSrc || !selDesc || typeof selSrc == "undefined" || typeof selDesc == "undefined") {
            return;
        }
        for(i = selDesc.options.length-1; i >= 0 ; i--) {
            selDesc.remove(i);
        }
        
        if (isRequredAll == 0 || aryDesc.length == 0) {
            addOption(selDesc, "[Tất cả]", "0");
        }
        
    	if (selSrc.value != 0) {            
            
            for (i = 0; i < aryDesc.length; i++) {
                if(selSrc.selectedIndex >= 0 && aryDesc[i][0] == selSrc.options[selSrc.selectedIndex].value) {
                    addOption(selDesc, aryDesc[i][2], aryDesc[i][1] );
                    selSrc.value = selSrc.options[selSrc.selectedIndex].value;
                }
            }
    	} else {
    		for (i = 0; i < aryDesc.length; i++) {
	            addOption(selDesc, aryDesc[i][2], aryDesc[i][1] );
	            selSrc.value = selSrc.options[selSrc.selectedIndex].value;
            }
    	}  
    	onchangeSelect("contractTemplateIdFilter","0");
    }
    
    changeKind('contractKindIdFilter', 'contractTemplateIdFilter', 0);
    
    
    var selectedTemplateId = "<bean:write name='temporaryContractListViewHelper' property='contractTemplateIdFilter'/>";
    if (selectedTemplateId != "") {
    	document.getElementById("contractTemplateIdFilter").value = selectedTemplateId;	
    }
    
    onchangeSelect("contractKindIdFilter","0");
    onchangeSelect("contractTemplateIdFilter","0");
    onchangeSelect("notaryDateFilter","00");
    onchangeSelect("contractStatusFilter","00");

    
   
    //add content for tooltip
    <logic:notEmpty name="temporaryContractListViewHelper" property="contractList">
    <logic:iterate id="item" name="temporaryContractListViewHelper" property="contractList" indexId="i">
        $('<div id="contractsticky<%=i%>" class="atip"><bean:write name="item" property="contractInformation" filter="false"/></div>').appendTo('#tooltipContent');
        $('<div id="summarysticky<%=i%>" class="atip"><bean:write name="item" property="contractSummaryDisp" filter="false"/></div>').appendTo('#tooltipContent');
    </logic:iterate>
    </logic:notEmpty>
    
    function highlightWhenSearch() {
        
        //var searchString = getSearchString();
        var searchString = $('#keyHighLight').val();
        if (searchString != "") {
            
            // Starting node, parent to all nodes you want to search
            var textContainerNode = document.getElementById("contractListContent");
            
            if (textContainerNode != null) {
                // Split search terms on '|' and iterate over resulting array              
                var searchTerms = searchString.split('|');
                for (var i in searchTerms)  {
                  // The regex is the secret, it prevents text within tag declarations to be affected
                  var regex = new RegExp(">([^<]*)?("+searchTerms[i]+")([^>]*)?<","ig");
                  //var regex = searchTerms[i];
                  
                  var tempinnerHTML = textContainerNode.innerHTML;
                  // Do regex replace
                  // Inject span with class of 'highlighted termX' for google style highlighting
                  $('#contractListContent').html(tempinnerHTML.replace(regex,'>$1<span class="highlighted">$2</span>$3<'));
                }
            }
            
            textContainerNode = document.getElementById("tooltipContent");
            if (textContainerNode != null) {
                // Split search terms on '|' and iterate over resulting array              
                var searchTerms = searchString.split('|');
                for (var i in searchTerms)  {
                  // The regex is the secret, it prevents text within tag declarations to be affected
                  var regex = new RegExp(">([^<]*)?(" + searchTerms[i] +")([^>]*)?<","ig");
                  //var regex = searchTerms[i];
                  
                  var tempinnerHTML = textContainerNode.innerHTML;
                  // Do regex replace
                  // Inject span with class of 'highlighted termX' for google style highlighting
                  $('#tooltipContent').html(tempinnerHTML.replace(regex,'>$1<span class="highlighted">$2</span>$3<'));
                }
            }
        }
   }

   // Call this onload
   highlightWhenSearch();
    
</script>