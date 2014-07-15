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
                    <html:link href="preventlistview.do">Tra cứu thông tin ngăn chặn</html:link>
                </li>
            </ul>
        </div>
    <%@ include file="/jsp/common/error_message.jsp" %>

    <html:form styleId="form" action="preventlistsearch" onsubmit="javascript: search();">
        <html:hidden styleId="isHidePanelSearch" property="isHidePanelSearch" name="preventListViewHelper"/>
        <html:hidden styleId="isAdvanceSearch" property="isAdvanceSearch" name="preventListViewHelper"/>
        <html:hidden styleId="displayPreventList" property="displayPreventList" name="preventListViewHelper"/>
        <html:hidden styleId="keyHighLight" property="keyHighLight" name="preventListViewHelper"/>
        
        <div id="mystickytooltip" class="stickytooltip" >
	        <div class="tooltipClassic">
	            <div class="toolbar">
	                <div class="title">
	                    <a id="closeTooltip" class="close"></a>
	                    Thông tin chi tiết
	                </div>
	            </div>
	            <div id="tooltipContent" class="content" style="overflow: auto; max-height: 400px;">
	            </div>
	        </div>
        </div>

        <div id="searchShow" class="sub-title">
            <strong>◊ Điều kiện tìm kiếm</strong>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a id="keySearch" class="advanceSearch" style="color: blue; font-weight: normal;" onclick="changeSearch('false')">
                [Tìm kiếm theo từ khóa]
            </a>
            <a id="advanceSearch" class="keySearch" style="color: blue; font-weight: normal;" onclick="changeSearch('true')">
                [Tìm kiếm nâng cao]
            </a>
        </div>
        
        <div id="keySearchPanel" class="keySearch" style="padding-left: 25px;">
            <span style="vertical-align: middle;">Từ khóa</span>
            &nbsp;&nbsp;&nbsp;
            <html:text styleId="keySearch" name="preventListViewHelper" property="keySearch"
                             styleClass="input-long" style="vertical-align: middle;"/>
            &nbsp;&nbsp;&nbsp;
            <html:image alt="Tìm kiếm" src="./image/btn_search.png" style="vertical-align: middle;"/>
        </div>

        <table id="tblSearch" class="advanceSearch tbl-search">
            <tr>
                <td style="padding-left: 25px; line-height: 1.5;">
                    Loại tài sản <br/>
                    <html:select name="preventListViewHelper" property="type" styleId="type"
                        onchange="onchangeSelect(this.id,'00'); changeDisplayProperty(this.value)">
                        <html:option value="00">[Tất cả]</html:option>
                        <html:optionsCollection name="preventListViewHelper" property="propertyList" label="name" value="code" />
                    </html:select>
                </td>
                <td class="land" style="padding-left: 10px; line-height: 1.5;">
                    Địa chỉ <br/>
                    <html:text styleId="landAddress" name="preventListViewHelper" property="landAddress"
                           styleClass="input-normal" maxlength="200"/>                    
                </td>
                <td class="land" style="padding-left: 10px; line-height: 1.5;">
                    Số GCN <br/>
                    <html:text styleId="landCertificate" name="preventListViewHelper" property="landCertificate" maxlength="200"/>
                </td>
                <td class="land" style="padding-left: 10px; line-height: 1.5;">
                    Thửa <br/>
                    <html:text styleId="landNumber" name="preventListViewHelper" property="landNumber" style="width: 80px;" maxlength="20"/>
                </td>
                <td class="land" style="padding-left: 10px; line-height: 1.5;">
                    Tờ bản đồ <br/>
                    <html:text styleId="landMapNumber" name="preventListViewHelper" property="landMapNumber" style="width: 100px;" maxlength="20"/>
                </td>
                
                <td class="vehicle" style="padding-left: 10px; line-height: 1.5;">
                    Biển kiểm soát <br/>
                    <html:text styleId="carLicenseNumber" name="preventListViewHelper" property="carLicenseNumber" maxlength="200"/>
                </td>
                <td class="vehicle" style="padding-left: 10px; line-height: 1.5;">
                    Số đăng ký <br/>
                    <html:text styleId="carRegistNumber" name="preventListViewHelper" property="carRegistNumber" maxlength="200"/>
                </td>
                <td class="vehicle" style="padding-left: 10px; line-height: 1.5;">
                    Số khung <br/>
                    <html:text styleId="carFrameNumber" name="preventListViewHelper" property="carFrameNumber" maxlength="50"/>
                </td>
                <td class="vehicle" style="padding-left: 10px; line-height: 1.5;">
                    Số máy <br/>
                    <html:text name="preventListViewHelper" property="carMachineNumber" styleId="carMachineNumber" maxlength="50"/>
                </td>
                
                <td class="other" style="padding-left: 10px; line-height: 1.5;">
                    Thông tin tài sản <br/>
                    <html:text styleId="propertyInfo" name="preventListViewHelper" property="propertyInfo" styleClass="input-normal"/>
                </td>
                
                <td style="padding-left: 10px; line-height: 1.5;">
                    Loại ngăn chặn <br/>
                    <html:select styleId="originKind" property="originKind" name="preventListViewHelper" onchange="onchangeSelect(this.id,'00');" >
                        <html:option value="00">[Tất cả]</html:option>
                        <html:option value="01">Thông tin ngăn chặn</html:option>
                        <html:option value="02">Thông tin tham khảo</html:option>
                    </html:select>
                </td>
                
                <td style="padding-left: 10px; line-height: 1.5;">
                    Tình trạng <br/>
                    <html:select styleId="releaseFlg" property="releaseFlg" name="preventListViewHelper" onchange="onchangeSelect(this.id,'00');">
                        <html:option value="00">[Tất cả]</html:option>
                        <html:option value="01">Chưa giải tỏa</html:option>
                        <html:option value="02">Đã giải tỏa</html:option>
                    </html:select>
                </td>
            </tr>             
        </table>
        
        <div class="advanceSearch" style="padding-top: 10px; text-align: center;">
            <html:image alt="Tìm kiếm" src="./image/btn_search.png"/>

            <html:link href="javascript: clear()">
                <html:img alt="Xóa điều kiện" src="./image/btn_clear.png"/>
            </html:link>
        </div>
        
        <br/>
        <div id="menutabs" style="float: left;">
        <ul>
            <li>
                <a id="datapreventTab" onclick="displayDataPreventList(this);">
                  <span>
                      Danh sách ngăn chặn
                      (<label style="color: red;"><bean:write name="preventListViewHelper" property="totalCount"/></label>)
                  </span>
                </a>
            </li>
            <li>
                <a id="propertycontractTab" onclick="displayPropertyList(this);" style="padding: 0px 20px;">
                    <span>
                        Lịch sử giao dịch
                        (<label style="color: red;"><bean:write name="preventListViewHelper" property="totalCountProperty"/></label>)
                    </span>
                </a>
            </li>
        </ul>
        </div>


        <!-- prevent list-->

        <div id="preventListTitle">
            <%
            if (context.isPreventData()) {
            %>
            <div style="float: right">
                <html:link href="datapreventregistview.do">
                    <html:img alt="Them moi" src="./image/btn_add.png"/>
                </html:link>
            </div>
            <%}%>
        </div>
        <logic:notEmpty name="preventListViewHelper" property="dataPreventList">
            <table id="preventList" class="tbl-list">
                <tr>
                    <th nowrap="nowrap">Phân loại</th>
                    <th>Loại tài sản</th>
                    <th>Thông tin tài sản</th>
                    <th>Đơn vị gửi yêu cầu ngăn chặn</th>
                    <th>Ngày nhận công văn</th>
                    <th nowrap="nowrap">Giải tỏa</th>
                    <th></th>
                </tr>
                <tbody id="preventListContent">
                <logic:iterate id="item" name="preventListViewHelper" property="dataPreventList" indexId="i">
                    <tr class="tbl-row<%=i % 2%>">
                        <td style="text-align: center;">
                            <logic:equal name="item" property="originKind" value="01">
                                <html:img title="Thông tin ngăn chặn" src="./image/icon_prevent.png" alt="Dữ liệu ngăn chặn" />
                            </logic:equal>
                            <logic:equal name="item" property="originKind" value="02">
                                <html:img title="Thông tin tham khảo" src="./image/icon_warning.png" alt="Dữ liệu tham khảo" />
                            </logic:equal>
                        </td>
                        <td nowrap="nowrap">
                            <logic:equal name="item" property="type" value="01">Nhà đất</logic:equal>
                            <logic:equal name="item" property="type" value="02">Ô tô, Xe máy</logic:equal>
                            <logic:equal name="item" property="type" value="99">Tài sản khác</logic:equal>
                        </td>
                        <td>
                            <span data-tooltip="preventsticky<%=i%>" class="datatooltip">
                                <bean:write name="item" property="infoDisp" filter="false"/>
                                <bean:define id="infoDisp" name="item" property="infoDisp" type="java.lang.String"></bean:define>
                                <bean:define id="info" name="item" property="info" type="java.lang.String"></bean:define>
                                <%
                                if (!infoDisp.equals(info)) {
                                %>
                                    <img class="onmouseover" src="./image/icon_search.png"></img>
                                <%} %>
                            </span>                            
                        </td>
                        <td>
                            <bean:write name="item" property="preventPersonInfo"/>
                        </td>
                        <td style="text-align: center;">
                            <bean:write name="item" property="preventDocReceiveDate" format="dd/MM/yyyy"/>
                        </td>
                        <td style="text-align: center;">
                            <logic:equal name="item" property="releaseFlg" value="true">
                                <html:img src="./image/icon_release.png" alt="Đã giải tỏa" title="Đã giải tỏa" />
                            </logic:equal>
                        </td>
                        <td style="text-align: center;">
                            <html:link action="/datapreventdetail.do" paramId='id' paramName='item' paramProperty='id'>
                                Xem chi tiết
                            </html:link>
                        </td>
                    </tr>                
                </logic:iterate>
                </tbody>
            </table>

            <logic:greaterThan name="preventListViewHelper" property="totalCount" value="0">
            <div id="preventListPager" class="pager">
                <div class="pager-total">Tổng số <strong><bean:write name="preventListViewHelper" property="totalCount"/></strong> dữ liệu</div>
                <div>
                    <logic:greaterThan name="preventListViewHelper" property="totalPage" value="1">
                        <html:link href="javascript:direction('first')">
                            <img class="pager-first" src="./image/first.png" alt= "first"/>
                        </html:link>
                        <html:link href="javascript:direction('ahead')">
                            <img class="pager-prev" src="./image/prev.png" alt= "prev"/>
                        </html:link>
                    </logic:greaterThan>
                    <span>
                        Trang&nbsp;
                        <bean:write name="preventListViewHelper" property="page" format="##########"/>
                         /<bean:write name="preventListViewHelper" property="totalPage" format="##########"/>
                    </span>
                    <logic:greaterThan name="preventListViewHelper" property="totalPage" value="1">
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
            <div id="preventAdd">
            <%
            if (context.isPreventData()) {
            %>
            <div class="clearfix-right">
                <html:link href="datapreventregistview.do">
                    <html:img alt="Them moi" src="./image/btn_add.png"/>
                </html:link>
            </div>
            <%}%>
        </div>
        </logic:notEmpty>

        <!-- property list-->
        <logic:notEmpty name="preventListViewHelper" property="transactionPropertyList">
            <table id="propertyList" class="tbl-list">
                <tr>
                    <th>Ngày công chứng</th>
                    <th>Số hợp đồng</th>
                    <th>Tên hợp đồng</th>
                    <th>Bên liên quan</th>
                    <th>Nội dung</th>
                    <th>Công chứng viên</th>
                    <th>Tổ chức công chứng</th>
                </tr>
                
                <tbody id="propertyListContent">
                <logic:iterate id="item" name="preventListViewHelper" property="transactionPropertyList" indexId="i">
                    <tr id="highlight" class="tbl-row<%=i % 2%>">
                        <td nowrap="nowrap" style="text-align: center;">
                            <bean:write name="item" property="notaryDate" format="dd/MM/yyyy"/>
                        </td>
                        <td>
                            <bean:write name="item" property="contractNumber"/>
                        </td>
                        <td>
                            <bean:write name="item" property="contractName"/>
                        </td>
                        <td>
                            <span data-tooltip="relationobject<%=i%>" class="datatooltip">
                                <bean:write name='item' property='relationObjectSummaryDisp' filter="false"/>
                                <bean:define id="disp" name="item" property="relationObjectDisp" type="java.lang.String"></bean:define>
                                <bean:define id="summarydisp" name="item" property="relationObjectSummaryDisp" type="java.lang.String"></bean:define>
                                <%
                                if (disp != null && !disp.equals(summarydisp)) {
                                %>
                                    <img class="onmouseover" src="./image/icon_search.png"></img>
                                <%} %>
                            </span>                            
                        </td>
                        
                        <td>
                            <span data-tooltip="contractsticky<%=i%>" class="datatooltip">
                                <bean:write name='item' property='transactionContentSummaryDisp' filter="false"/>                               
                                <bean:define id="summaryDisp" name="item" property="transactionContentSummaryDisp" type="java.lang.String"></bean:define>
                                <bean:define id="disp" name="item" property="transactionContentDisp" type="java.lang.String"></bean:define>
                                <%
                                if (!summaryDisp.equals(disp)) {
                                %>
                                    <img class="onmouseover" src="./image/icon_search.png"></img>
                                <%} %>
                            </span>
                        </td>
                        <td>
                            <bean:write name="item" property="notaryPerson"/>
                        </td>
                        <td style="text-align: center;">
                            <logic:empty name="item" property="contractId">
                                <bean:write name='item' property='notaryOfficeName'/>
                            </logic:empty>
                            <logic:notEmpty name="item" property="contractId">
                                <html:link action="/contractdetailview.do" paramId='cid' paramName='item' paramProperty='contractId'>
                                    Xem chi tiết
                                </html:link>
                            </logic:notEmpty>
                        </td>
                    </tr>
                </logic:iterate>
                </tbody>
            </table>

            <logic:greaterThan name="preventListViewHelper" property="totalCountProperty" value="0">
            <div id="propertyListPager" class="pager">
                <div class="pager-total">Tổng số <strong><bean:write name="preventListViewHelper" property="totalCountProperty"/></strong> dữ liệu</div>
                <div>
                    <logic:greaterThan name="preventListViewHelper" property="totalPageProperty" value="1">
                        <html:link href="javascript:directionProperty('first')">
                            <img class="pager-first" src="./image/first.png" alt= "first"/>
                        </html:link>
                        <html:link href="javascript:directionProperty('ahead')">
                            <img class="pager-prev" src="./image/prev.png" alt= "prev"/>
                        </html:link>
                    </logic:greaterThan>
                    <span>
                        Trang&nbsp;
                        <bean:write name="preventListViewHelper" property="pageProperty" format="##########"/>
                         /<bean:write name="preventListViewHelper" property="totalPageProperty" format="##########"/>
                    </span>
                    <logic:greaterThan name="preventListViewHelper" property="totalPageProperty" value="1">
                        <html:link href="javascript:directionProperty('next')">
                            <img class="pager-next" src="./image/next.png" alt= "next"/>
                        </html:link>
                        <html:link href="javascript:directionProperty('end')">
                            <img class="pager-last" src="./image/last.png" alt= "last"/>
                        </html:link>
                    </logic:greaterThan>
                </div>
            </div>
            </logic:greaterThan>
        </logic:notEmpty>

        <html:hidden property="direction"/>
        
    </html:form>
    <%@ include file="/jsp/common/footer.jsp" %>
</html:html>

<script type="text/javascript">

	$('#preventTab > em').removeClass("menu-block-contract-off");
	$('#preventTab > em').addClass("menu-block-contract-on");
	$('#preventTab > b').addClass("menu-on");
	
	document.getElementById("keySearch").focus();
	
    onchangeSelect("type","00");
    onchangeSelect("originKind","00");
    onchangeSelect("releaseFlg","00");
            
    var display;
    display = $('#displayPreventList').val();
    if (display == "true") {
      $('#datapreventTab').addClass("selectedtab");
        document.getElementById("preventListTitle").style.display = "";
        var preventList = document.getElementById("preventList");
        if (preventList != null) {
          preventList.style.display = "";
        }
        var preventListPager = document.getElementById("preventListPager");
        if (preventListPager != null) {
          preventListPager.style.display = "";
        }
        var preventAdd = document.getElementById("preventAdd");
        if (preventAdd != null) {
          preventAdd.style.display = "";
        }
        var propertyList = document.getElementById("propertyList");
        if (propertyList != null) {
          propertyList.style.display = "none";
        }
        var propertyListPager = document.getElementById("propertyListPager");
        if (propertyListPager != null) {
          propertyListPager.style.display = "none";
        }
    } else {
      $('#propertycontractTab').addClass("selectedtab");
        document.getElementById("preventListTitle").style.display = "none";
        var preventList = document.getElementById("preventList");
        if (preventList != null) {
            preventList.style.display = "none";
        }
        var preventListPager = document.getElementById("preventListPager");
        if (preventListPager != null) {
            preventListPager.style.display = "none";
        }
        var preventAdd = document.getElementById("preventAdd");
        if (preventAdd != null) {
            preventAdd.style.display = "none";
        }
        var propertyList = document.getElementById("propertyList");
        if (propertyList != null) {
            propertyList.style.display = "";
        }
        var propertyListPager = document.getElementById("propertyListPager");
        if (propertyListPager != null) {
            propertyListPager.style.display = "";
        }
    }

    function displayDataPreventList(element) {
      $('#menutabs > ul > li > a').removeClass("selectedtab");
        element.className = "selectedtab"
      document.getElementById("preventListTitle").style.display = "";
        var preventList = document.getElementById("preventList");
        if (preventList != null) {
            preventList.style.display = "";
        }
        var preventListPager = document.getElementById("preventListPager");
        if (preventListPager != null) {
            preventListPager.style.display = "";
        }
        var preventAdd = document.getElementById("preventAdd");
        if (preventAdd != null) {
            preventAdd.style.display = "";
        }
        var propertyList = document.getElementById("propertyList");
        if (propertyList != null) {
            propertyList.style.display = "none";
        }
        var propertyListPager = document.getElementById("propertyListPager");
        if (propertyListPager != null) {
            propertyListPager.style.display = "none";
        }
        $('#displayPreventList').val(true);
    }

    function displayPropertyList(element) {
      $('#menutabs > ul > li > a').removeClass("selectedtab");
      element.className = "selectedtab"
      document.getElementById("preventListTitle").style.display = "none";
        var preventList = document.getElementById("preventList");
        if (preventList != null) {
            preventList.style.display = "none";
        }
        var preventListPager = document.getElementById("preventListPager");
        if (preventListPager != null) {
            preventListPager.style.display = "none";
        }
        var preventAdd = document.getElementById("preventAdd");
        if (preventAdd != null) {
            preventAdd.style.display = "none";
        }
        var propertyList = document.getElementById("propertyList");
        if (propertyList != null) {
            propertyList.style.display = "";
        }
        var propertyListPager = document.getElementById("propertyListPager");
        if (propertyListPager != null) {
            propertyListPager.style.display = "";
        }
        $('#displayPreventList').val(false);
    }

    function search() {
        document.preventListForm.action="preventlistsearch.do";
        return true;
    }
    
    function forward() {
    	document.preventListForm.submit();
    }

    function direction(data){
        document.preventListForm.direction.value=data;
        document.preventListForm.action="preventlistpaging.do";
        document.preventListForm.submit();
        return true;
    }

    function directionProperty(data){
        document.preventListForm.direction.value=data;
        document.preventListForm.action="propertylistpaging.do";
        document.preventListForm.submit();
        return true;
    }

    function clear() {
        document.getElementById("type").value = "00";
        document.getElementById("propertyInfo").value = "";
        document.getElementById("landAddress").value = "";
        document.getElementById("landCertificate").value = "";
        document.getElementById("landNumber").value = "";
        document.getElementById("landMapNumber").value = "";
        document.getElementById("carLicenseNumber").value = "";
        document.getElementById("carRegistNumber").value = "";
        document.getElementById("carFrameNumber").value = "";
        document.getElementById("carMachineNumber").value = "";
        document.getElementById("originKind").value = "00";
        document.getElementById("releaseFlg").value = "00";
        
        onchangeSelect("type","00");
        onchangeSelect("originKind","00");
        onchangeSelect("releaseFlg","00");
    }
    
    changeDisplayProperty($('#type option:selected').val());
    function changeDisplayProperty(value) {
	    $('.land').hide();
	    $('.vehicle').hide();
	    $('.other').hide();
	    if(value == "01") {
	        $('.land').show();
	        $('.vehicle').hide();
	        $('.other').hide();
	    } else if(value == "02") {
	    	$('.land').hide();
	        $('.vehicle').show();
	        $('.other').hide();
	    } else {
	        $('.other').show();
	    }
    }

    var LEFT_CAL = Calendar.setup({
        cont: "cont",
        weekNumbers: true,
        selectionType: Calendar.SEL_MULTIPLE,
        showTime: 12
        // titleFormat: "%B %Y"
    });

    changeSearch($('#isAdvanceSearch').val());
    function changeSearch(value) {
        $('#isAdvanceSearch').val(value);
        if (value == 'true') {
            $('.advanceSearch').show();
            $('.keySearch').hide();
        } else {
            $('.advanceSearch').hide();
            $('.keySearch').show();
        }
    }
   
   //add content for tooltip
   <logic:notEmpty name="preventListViewHelper" property="dataPreventList">
   <logic:iterate id="item" name="preventListViewHelper" property="dataPreventList" indexId="i">
       $('<div id="preventsticky<%=i%>" class="atip"><bean:write name="item" property="info" filter="false"/></div>').appendTo('#tooltipContent');
   </logic:iterate>
   </logic:notEmpty>
   
   <logic:notEmpty name="preventListViewHelper" property="transactionPropertyList">
   <logic:iterate id="item" name="preventListViewHelper" property="transactionPropertyList" indexId="i">
	   $('<div id="relationobject<%=i%>" class="atip"><bean:write name="item" property="relationObjectDisp" filter="false"/></div>').appendTo('#tooltipContent');
	   $('<div id="contractsticky<%=i%>" class="atip"><bean:write name="item" property="transactionContentDisp" filter="false"/></div>').appendTo('#tooltipContent');
   </logic:iterate>
   </logic:notEmpty>
   
   function highlightWhenSearch() {
	      
       //var searchString = getSearchString();
       var searchString = $('#keyHighLight').val();
       if (searchString != "") {
           // Starting node, parent to all nodes you want to search
           var textContainerNode = document.getElementById("preventListContent");
           
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
                 $('#preventListContent').html(tempinnerHTML.replace(regex,'>$1<span class="highlighted">$2</span>$3<'));
               }
           }
        
           textContainerNode = document.getElementById("propertyListContent");
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
                 $('#propertyListContent').html(tempinnerHTML.replace(regex,'>$1<span class="highlighted">$2</span>$3<'));
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
