<%@ page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8" errorPage=""%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>

<%@ include file="/jsp/common/header.jsp"%>
<div id="navigator" style="padding:0px; margin-top: 2px;">
<ul class="clearfix">
	<li><html:img alt="*" src="./image/bullet_square.gif" /></li>
	<li><html:link href="preventlistview.do">Tra cứu thông tin</html:link>
    <a class="acc_link" style="float:none! important; font-size: 9.75px;" target="_blank" href="help.do">
       <img src="./image/help.png" style="padding: 0px; margin-bottom: -3px;"/> Hướng dẫn tra cứu</a>
    </li>
</ul>
</div>
<%@ include file="/jsp/common/error_message.jsp"%>

<html:form styleId="form" action="preventlistsearch"
	onsubmit="javascript: search();">
	<html:hidden styleId="isHidePanelSearch" property="isHidePanelSearch"
		name="preventListViewHelper" />
	<html:hidden styleId="isAdvanceSearch" property="isAdvanceSearch"
		name="preventListViewHelper" />
	<html:hidden styleId="displayPreventList" property="displayPreventList"
		name="preventListViewHelper" />
	<html:hidden styleId="keyHighLight" property="keyHighLight"
		name="preventListViewHelper" />

	<div id="mystickytooltip" class="stickytooltip">
	<div class="tooltipClassic">
	<div class="toolbar">
	<div class="title"><a id="closeTooltip" class="close"></a> Thông
	tin chi tiết</div>
	</div>
	<div id="tooltipContent" class="content"
		style="overflow: auto; max-height: 400px;"></div>
	</div>
	</div>

	<div id="searchShow" class="sub-title"><strong>◊ Điều
	kiện tìm kiếm</strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a class="advanceSearch"
		style="color: blue; font-weight: normal;"
		onclick="changeSearch('false')"> [Tìm kiếm theo từ khóa] </a> <a
		class="keySearch" style="color: blue; font-weight: normal;"
		onclick="changeSearch('true')"> [Tìm kiếm nâng cao] </a>
		
		&nbsp;&nbsp;&nbsp;&nbsp;
    <html:checkbox property="officeCode" styleId="officeCode" name="preventListViewHelper"/>
    <label for="officeCode">Chỉ tìm kiếm dữ liệu do <bean:write name="CommonContext" property="systemOfficeName" /> đăng ký</label>
	
	</div>

	<div id="keySearchPanel" class="keySearch" style="padding-left: 25px;">
	<span style="vertical-align: middle;">Từ khóa</span> &nbsp;&nbsp;&nbsp;
	<html:text styleId="keySearch" name="preventListViewHelper"
		property="keySearch" styleClass="input-long"
		style="vertical-align: middle;" /> &nbsp;&nbsp;&nbsp; 
		
	<span id="add_on">
       <html:image alt="Tìm kiếm" src="./image/btn_search.png" style="vertical-align: middle;" onclick="stylechange('add_off','add_on');"/>
    </span>
    <span id="add_off" style="display: none;">
        <img alt="Tìm kiếm" src="./image/btn_search.png" style="vertical-align: middle;" />
    </span>
    </div>
		
	<table id="tblSearch" class="advanceSearch tbl-search">
		<tr>
			<td style="padding-left: 25px; line-height: 1.5;">Loại tài sản <html:select
				name="preventListViewHelper" property="type" styleId="propertyType"
				onchange="onchangeSelect(this.id,'0');javascript:changeProperty();">
				<html:option value="">[Tất cả]</html:option>
				<html:optionsCollection name="preventListViewHelper"
					property="propertyList" label="name" value="code" />
			</html:select></td>
			
			<td colspan="3" style="padding-left: 25px; line-height: 1.5;">Thông
			tin tài sản <html:text styleId="propertyInfoFilter"
				style="width: 200px;" property="propertyInfo"
				name="preventListViewHelper"></html:text>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			Bên liên quan / Chủ sở hữu <html:text styleId="relationFilter"
				style="width: 200px;" property="ownerInfo"
				name="preventListViewHelper"></html:text></td>


		</tr>
		<tr>
			<td colspan="4" style="text-align: center">
				<div style="padding-top: 10px;">
	              <html:image alt="Tìm kiếm" src="./image/btn_search.png" /> 
	              <html:link href="javascript: clear()">
	                  <html:img alt="Xóa điều kiện" src="./image/btn_clear.png" />
	              </html:link>
	           </div>
            </td>
		</tr>
	</table>




	<br />
	<div id="menutabs" style="float: left;">
	<ul>
		<li><a id="datapreventTab"
			onclick="displayDataPreventList(this);"> <span> Thông tin
		ngăn chặn (<label><bean:write name="preventListViewHelper"
			property="totalCount" /></label>) </span> </a></li>
		<li><a id="propertycontractTab"
			onclick="displayPropertyList(this);" style="padding: 0px 20px;">
		<span> Hợp đồng, giao dịch đã công chứng (<label><bean:write
			name="preventListViewHelper" property="totalCountProperty" /></label>) </span> </a></li>
		<li><span id="preventResult"> <!--
                    <logic:greaterThan value="0" name="preventListViewHelper" property="totalCount">
                        Có <bean:write name="preventListViewHelper" property="totalCount"/> thông tin ngăn chặn thỏa mãn điều kiện tìm kiếm.
                    </logic:greaterThan>
                    --> </span> <span id="historyResult"> <!--
                    <logic:greaterThan value="0" name="preventListViewHelper" property="totalCountProperty">
                        Có <bean:write name="preventListViewHelper" property="totalCountProperty"/> lịch sử giao dịch thỏa mãn điều kiện tìm kiếm.
                    </logic:greaterThan>    
                    --> </span></li>
	</ul>

	</div>


	<!-- prevent list-->

	<div id="preventListTitle">
	<%
		if (context.isPreventData()) {
	%>
	<div style="float: right">
	    <html:link 
			href="javascript:printts()" >
			<html:img alt="Them moi" src="./image/banin.png" />
	    </html:link>
	    <html:link
		href="datapreventregistview.do">
		<html:img alt="Them moi" src="./image/btn_add.png" />
	</html:link></div>
	<%
		}
	%>
	</div>
	<div id="preventListPrint">
	<div style="float: right">
		<div class="keyPrint">
			<html:link 
				href="javascript:printts()" >
				<html:img alt="Them moi" src="./image/banin.png" />
			</html:link>
		</div>
	</div>
	</div>
	<logic:notEmpty name="preventListViewHelper" property="dataPreventList">
		<table id="preventList" class="tbl-list">
			<tr>
				<th nowrap="nowrap">Phân loại</th>
				<th>Loại tài sản</th>
				<th>Thông tin tài sản</th>
				<th>Đơn vị gửi yêu cầu ngăn chặn</th>
				<th>Ngày nhận công văn</th>
				<th>Số vào sổ CV</th>
				<th nowrap="nowrap">Giải tỏa</th>
				<th></th>
			</tr>
			<tbody id="preventListContent">
				<logic:iterate id="item" name="preventListViewHelper"
					property="dataPreventList" indexId="i">
					<tr class="tbl-row<%=i % 2%>">
						<td style="text-align: center;"><logic:equal name="item"
							property="originKind" value="01">
							<html:img title="Thông tin ngăn chặn"
								src="./image/icon_prevent.png" alt="Dữ liệu ngăn chặn" />
						</logic:equal> <logic:equal name="item" property="originKind" value="02">
							<html:img title="Thông tin tham khảo"
								src="./image/icon_warning.png" alt="Dữ liệu tham khảo" />
						</logic:equal></td>
						<td nowrap="nowrap"><logic:equal name="item" property="type"
							value="01">Nhà đất</logic:equal> <logic:equal name="item"
							property="type" value="02">Ô tô, Xe máy</logic:equal> <logic:equal
							name="item" property="type" value="99">Tài sản khác</logic:equal>
						</td>
						<td><logic:equal value="false" property="luceneSearch"
							name="preventListViewHelper">
							<bean:define id="infoDisp" name="item" property="infoDisp"
								type="java.lang.String"></bean:define>
							<bean:define id="info" name="item" property="info"
								type="java.lang.String"></bean:define>

							<%
								if (!infoDisp.equals(info)) {
							%>
							<span data-tooltip="preventsticky<%=i%>" class="datatooltip">

							<%
								}
							%> <bean:write name="item" property="infoDisp" filter="false" />
							<%
								if (!infoDisp.equals(info)) {
							%> <img class="onmouseover"
								src="./image/icon_search.png"></img> <%
						 	}
						 %> </span>
						</logic:equal> <logic:equal value="true" property="luceneSearch"
							name="preventListViewHelper">
							<bean:define id="infoDisp" name="item"
								property="lucenePropertyInfoDisp" type="java.lang.String"></bean:define>
							<bean:define id="info" name="item" property="lucenePropertyInfo"
								type="java.lang.String"></bean:define>

							<%
								if (!infoDisp.equals(info)) {
							%>
							<span data-tooltip="preventsticky<%=i%>" class="datatooltip">

							<%
								}
							%> <bean:write name="item" property="lucenePropertyInfoDisp"
								filter="false" /> <%
						 	if (!infoDisp.equals(info)) {
						 %> <img class="onmouseover"
														src="./image/icon_search.png"></img> <%
						 	}
						 %> </span>
						</logic:equal></td>
						<td><bean:write name="item" property="preventPersonInfoDisp"
							filter="false" /></td>
						<td style="text-align: center;"><bean:write name="item"
							property="preventDocReceiveDate" format="dd/MM/yyyy" /></td>
						<td style="text-align: center;">
						  <bean:write name="item" property="preventInBookNumber"/></td>
						<td style="text-align: center;"><logic:equal name="item"
							property="releaseFlg" value="true">
							<html:img src="./image/icon_release.png" alt="Đã giải tỏa"
								title="Đã giải tỏa" />
						</logic:equal></td>
						<td style="text-align: center;"><html:link
							action="/datapreventdetail.do" paramId='id' paramName='item'
							paramProperty='id'>
                                Xem chi tiết
                            </html:link></td>
					</tr>
				</logic:iterate>
			</tbody>
		</table>

		<logic:greaterThan name="preventListViewHelper" property="totalCount"
			value="0">
			<div id="preventListPager" class="pager">
			<div class="pager-total">Tổng số <strong><bean:write
				name="preventListViewHelper" property="totalCount" /></strong> dữ liệu</div>
			<div><logic:greaterThan name="preventListViewHelper"
				property="totalPage" value="1">
				<html:link href="javascript:direction('first')">
					<img class="pager-first" src="./image/first.png" alt="first" />
				</html:link>
				<html:link href="javascript:direction('ahead')">
					<img class="pager-prev" src="./image/prev.png" alt="prev" />
				</html:link>
			</logic:greaterThan> <span> Trang&nbsp; <html:text name="preventListViewHelper"
				property="page" maxlength="9" styleId="pageNum" style="width:60px"
				onblur="checkPaging=0;" onfocus="checkPaging=1;"
				onchange="javascript: paging(this.value)" /> /<bean:write
				name="preventListViewHelper" property="totalPage"
				format="##########" /> </span> <logic:greaterThan
				name="preventListViewHelper" property="totalPage" value="1">
				<html:link href="javascript:direction('next')">
					<img class="pager-next" src="./image/next.png" alt="next" />
				</html:link>
				<html:link href="javascript:direction('end')">
					<img class="pager-last" src="./image/last.png" alt="last" />
				</html:link>
			</logic:greaterThan></div>
			</div>
		</logic:greaterThan>
		<div id="preventAdd">
		<%
			if (context.isPreventData()) {
		%>
		<div class="clearfix-right"><html:link
			href="datapreventregistview.do">
			<html:img alt="Them moi" src="./image/btn_add.png" />
		</html:link></div>
		<%
			}
		%>
		</div>
	</logic:notEmpty>

	<!-- property list-->
	<logic:notEmpty name="preventListViewHelper"
		property="transactionPropertyList">
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
				<logic:iterate id="item" name="preventListViewHelper"
					property="transactionPropertyList" indexId="i">
					<tr id="highlight" class="tbl-row<%=i % 2%>">
						<td nowrap="nowrap" style="text-align: center;"><bean:write
							name="item" property="notaryDate" format="dd/MM/yyyy" /></td>
						<td><bean:write name="item" property="contractNumber" /></td>
						<td><bean:write name="item" property="contractName" /></td>
						<td><logic:equal value="false" property="luceneSearch"
							name="preventListViewHelper">

							<bean:define id="summaryDisp" name="item"
								property="relationObjectSummaryDisp" type="java.lang.String"></bean:define>
							<bean:define id="disp" name="item" property="relationObjectDisp"
								type="java.lang.String"></bean:define>
							<%
								if (!summaryDisp.equals(disp)) {
							%>
							<span data-tooltip="relationObject<%=i%>" class="datatooltip">

							<%
								}
							%> <bean:write name='item' property='relationObjectSummaryDisp'
								filter="false" /> <%
							 	if (!summaryDisp.equals(disp)) {
							 %> <img class="onmouseover"
															src="./image/icon_search.png"></img> <%
							 	}
							 %> </span>
						</logic:equal> <logic:equal value="true" property="luceneSearch"
							name="preventListViewHelper">
							<bean:define id="summaryDisp" name="item"
								property="luceneRelationObjectDisp" type="java.lang.String"></bean:define>
							<bean:define id="disp" name="item"
								property="luceneRelationObject" type="java.lang.String"></bean:define>
							<%
								if (!summaryDisp.equals(disp)) {
							%>
							<span data-tooltip="relationObject<%=i%>" class="datatooltip">

							<%
								}
							%> <bean:write name='item' property='luceneRelationObjectDisp'
								filter="false" /> <%
							 	if (!summaryDisp.equals(disp)) {
							 %> <img class="onmouseover"
															src="./image/icon_search.png"></img> <%
							 	}
							 %> </span>
						</logic:equal></td>
						<td><logic:equal value="false" property="luceneSearch"
							name="preventListViewHelper">

							<bean:define id="summaryDisp" name="item"
								property="transactionContentSummaryDisp" type="java.lang.String"></bean:define>
							<bean:define id="disp" name="item"
								property="transactionContentDisp" type="java.lang.String"></bean:define>

							<%
								if (!summaryDisp.equals(disp)) {
							%>
							<span data-tooltip="contractsticky<%=i%>" class="datatooltip">

							<%
								}
							%> <bean:write name='item'
								property='transactionContentSummaryDisp' filter="false" /> <%
								 	if (!summaryDisp.equals(disp)) {
								 %> <img class="onmouseover"
										src="./image/icon_search.png"></img> <%
								 	}
								 %> </span>
						</logic:equal> <logic:equal value="true" property="luceneSearch"
							name="preventListViewHelper">

							<bean:define id="summaryDisp" name="item"
								property="luceneTransactionContentDisp" type="java.lang.String"></bean:define>
							<bean:define id="disp" name="item"
								property="luceneTransactionContent" type="java.lang.String"></bean:define>


							<%
								if (!summaryDisp.equals(disp)) {
							%>
							<span data-tooltip="contractsticky<%=i%>" class="datatooltip">

							<%
								}
							%> <bean:write name='item'
								property='luceneTransactionContentDisp' filter="false" /> <%
							 	if (!summaryDisp.equals(disp)) {
							 %> <img class="onmouseover"
								src="./image/icon_search.png"></img><br />
							<%
								}
							%> </span>

						</logic:equal> <br />
						<logic:notEmpty name="item" property="contractPeriod">
							<b>Thời hạn</b>: 
						<b style="color: #C00000"> <bean:write name="item"
								property="contractPeriod" /> </b>
							<br />
						</logic:notEmpty> <logic:notEmpty name="item" property="cancelDescription">
							<b>Tình trạng</b>: 
						</logic:notEmpty> <logic:empty name="item" property="cancelDescription">
							<logic:equal value="true" name="item"
								property="mortageCancelFlag">
								<b>Tình trạng</b>: 
						</logic:equal>
						</logic:empty> <b style="color: #C00000"> <logic:equal value="true"
							name="item" property="mortageCancelFlag">

							<bean:write name="item" property="mortageCancelDateDisp" />
							<br />
							<bean:write name="item" property="mortageCancelNoteDisp" filter="false" />
							<br />
						</logic:equal> <bean:write name="item" property="cancelDescription" /> </b></td>
						<td><bean:write name="item" property="notaryPerson" /></td>
						<td style="text-align: center;"><logic:empty name="item"
							property="contractId">
							<bean:write name='item' property='notaryOfficeName' />
						</logic:empty> <logic:notEmpty name="item" property="contractId">
							<html:link action="/contractdetailview.do" paramId='cid'
								paramName='item' paramProperty='contractId'>
                                    Xem chi tiết
                                </html:link>
						</logic:notEmpty></td>
					</tr>
				</logic:iterate>
			</tbody>
		</table>

		<logic:greaterThan name="preventListViewHelper"
			property="totalCountProperty" value="0">
			<div id="propertyListPager" class="pager">
			<div class="pager-total">Tổng số <strong><bean:write
				name="preventListViewHelper" property="totalCountProperty" /></strong> dữ
			liệu</div>
			<div><logic:greaterThan name="preventListViewHelper"
				property="totalPageProperty" value="1">
				<html:link href="javascript:directionProperty('first')">
					<img class="pager-first" src="./image/first.png" alt="first" />
				</html:link>
				<html:link href="javascript:directionProperty('ahead')">
					<img class="pager-prev" src="./image/prev.png" alt="prev" />
				</html:link>
			</logic:greaterThan> <span> Trang&nbsp; <html:text name="preventListViewHelper"
				styleId="pagePropertyNum" property="pageProperty" maxlength="9"
				style="width:60px" onblur="checkPaging=0;" onfocus="checkPaging=2;"
				onchange="javascript: pagingProperty(this.value)" /> /<bean:write
				name="preventListViewHelper" property="totalPageProperty"
				format="##########" /> </span> <logic:greaterThan
				name="preventListViewHelper" property="totalPageProperty" value="1">
				<html:link href="javascript:directionProperty('next')">
					<img class="pager-next" src="./image/next.png" alt="next" />
				</html:link>
				<html:link href="javascript:directionProperty('end')">
					<img class="pager-last" src="./image/last.png" alt="last" />
				</html:link>
			</logic:greaterThan></div>
			</div>
		</logic:greaterThan>
	</logic:notEmpty>

	<html:hidden property="direction" />
	<html:hidden property="sortType" name="preventListViewHelper"
		styleId="sortType" />
</html:form>
<br />
<%@ include file="/jsp/common/footer.jsp"%>
</html:html>

<script type="text/javascript">

	$('#preventTab > em').removeClass("menu-block-contract-off");
	$('#preventTab > em').addClass("menu-block-contract-on");
	$('#preventTab > b').addClass("menu-on");
	
	document.getElementById("keySearch").focus();
	
  //  onchangeSelect("districtFilter","");
    onchangeSelect("propertyType","");
   
            
    var display;
    display = $('#displayPreventList').val();
    if (display == "true") {
      $('#datapreventTab').addClass("selectedtab");
        document.getElementById("preventListTitle").style.display = "";
        document.getElementById("preventListPrint").style.display = "none";
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
        
        document.getElementById("preventResult").style.display = "";
        document.getElementById("historyResult").style.display = "none";
    } else {
      $('#propertycontractTab').addClass("selectedtab");
        document.getElementById("preventListTitle").style.display = "none";
        document.getElementById("preventListPrint").style.display = "";
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
        
        document.getElementById("preventResult").style.display = "none";
        document.getElementById("historyResult").style.display = "";
    }

    function displayDataPreventList(element) {
      $('#menutabs > ul > li > a').removeClass("selectedtab");
        element.className = "selectedtab"
      document.getElementById("preventListTitle").style.display = "";
       document.getElementById("preventListPrint").style.display = "none";
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
        
        document.getElementById("preventResult").style.display = "";
        document.getElementById("historyResult").style.display = "none";
    }

    function displayPropertyList(element) {
      $('#menutabs > ul > li > a').removeClass("selectedtab");
      element.className = "selectedtab"
      document.getElementById("preventListTitle").style.display = "none";
        document.getElementById("preventListPrint").style.display = "";
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
        
        document.getElementById("preventResult").style.display = "none";
        document.getElementById("historyResult").style.display = "";
    }

    function search() {
    	if (checkPaging == 1){
    		pageNumber = $('#pageNum').val();
    		document.preventListForm.direction.value = null;
    		 document.preventListForm.action="preventlistpaging.do?page="+pageNumber;
    	} else if (checkPaging == 2) {
    		pageNumber = $('#pagePropertyNum').val();
    		document.preventListForm.direction.value = null;
    		 document.preventListForm.action="propertylistpaging.do?pageProperty="+pageNumber2;
    	} else {
        document.preventListForm.action="preventlistsearch.do";
    	}
        return true;
    }
    
     
    function createSillyWindow()
    {
    	window.open("about:blank", "mySillyWindow");
    }

    function printts()
    {
	    	document.preventListForm.setAttribute("target", "mySillyWindow");
	        createSillyWindow();
	    	document.preventListForm.action = "preventPrint.do";
	    	document.preventListForm.submit();
	    	document.preventListForm.removeAttribute("target");
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
   
//    var sortType = $('#sortType').val();
 //   if (sortType=="true") {
 //   	$('#relateSort').show();
 //   	$('#dateSort').hide(); 	
 //   } else {
 //   	$('#relateSort').hide();
 //   	$('#dateSort').show(); 
 //   }
    propertyInfoFilter = document.getElementById("propertyInfoFilter").value;
    relationFilter = document.getElementById("relationFilter").value;
 //   streetFilter = document.getElementById("streetFilter").value;
 //   districtFilter = document.getElementById("districtFilter").value;        
    propertyType = document.getElementById("propertyType").value;
    keySearchFilter = document.getElementById("keySearch").value;
    function sort(typeSort){
    	$('#relateSort').toggle();
    	$('#dateSort').toggle(); 
    	document.getElementById("propertyInfoFilter").value = propertyInfoFilter;
        document.getElementById("relationFilter").value = relationFilter;
        document.getElementById("streetFilter").value = streetFilter;
  //      document.getElementById("districtFilter").value = districtFilter;        
        document.getElementById("propertyType").value = propertyType;
        document.getElementById("keySearch").value = keySearchFilter;
        changeProperty();
 //       onchangeSelect("districtFilter","");
        onchangeSelect("propertyType","");
        
        document.preventListForm.sortType.value=typeSort;
        document.preventListForm.action="preventlistsearch.do";
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
    var checkPaging = 0;
    var pageNumber;
    var pageNumber2;
    function paging(data){
    	checkPaging = 1;
    	pageNumber = data;
		
    }
    function pagingProperty(data){
    	checkPaging = 2;
    	pageNumber2 = data;
		
    }
    
  
   //add content for tooltip
   <logic:notEmpty name="preventListViewHelper" property="dataPreventList">
   
   <logic:iterate id="item" name="preventListViewHelper" property="dataPreventList" indexId="i">
   <logic:equal value="false" name="preventListViewHelper" property="luceneSearch">
       $('<div id="preventsticky<%=i%>" class="atip"><bean:write name="item" property="info" filter="false"/></div>').appendTo('#tooltipContent');
   </logic:equal>
   <logic:equal value="true" name="preventListViewHelper" property="luceneSearch">
       $('<div id="preventsticky<%=i%>" class="atip"><bean:write name="item" property="lucenePropertyInfo" filter="false"/></div>').appendTo('#tooltipContent');
   </logic:equal>
   </logic:iterate>   
   </logic:notEmpty>
   
   <logic:notEmpty name="preventListViewHelper" property="transactionPropertyList">
   
   <logic:iterate id="item" name="preventListViewHelper" property="transactionPropertyList" indexId="i">
   <logic:equal value="false" name="preventListViewHelper" property="luceneSearch">
       $('<div id="relationObject<%=i%>" class="atip"><bean:write name="item" property="relationObjectDisp" filter="false"/></div>').appendTo('#tooltipContent');
	   $('<div id="contractsticky<%=i%>" class="atip"><bean:write name="item" property="transactionContentDisp" filter="false"/></div>').appendTo('#tooltipContent');
   </logic:equal>
   <logic:equal value="true" name="preventListViewHelper" property="luceneSearch">
	   $('<div id="relationObject<%=i%>" class="atip"><bean:write name="item" property="luceneRelationObject" filter="false"/></div>').appendTo('#tooltipContent');

	   $('<div id="contractsticky<%=i%>" class="atip"><bean:write name="item" property="luceneTransactionContent" filter="false"/></div>').appendTo('#tooltipContent');
   
	   
	</logic:equal>
	   <logic:notEmpty name="item" property="contractPeriod">
			 $('<div id="contractsticky<%=i%>" class="atip"><b>Thời hạn:</b> <b style="color: #C00000"><bean:write name="item" property="contractPeriod" filter="false"/></b></div>').appendTo('#tooltipContent');
	   </logic:notEmpty>
	   
	   <logic:notEmpty name="item" property="cancelDescription"> 
	   		$('<div id="contractsticky<%=i%>" class="atip"><b>Tình trạng:</b></div>').appendTo('#tooltipContent');
	   </logic:notEmpty>
	   <logic:empty name="item" property="cancelDescription">
	 		  <logic:equal value="true" name="item" property="mortageCancelFlag">
		   		$('<div id="contractsticky<%=i%>" class="atip"><b>Tình trạng:</b></div>').appendTo('#tooltipContent');
		   		</logic:equal>
		</logic:empty> 
		 <logic:equal value="true" name="item" property="mortageCancelFlag">
			 $('<div id="contractsticky<%=i%>" class="atip"><b style="color: #C00000"> <bean:write name="item" property="mortageCancelDateDisp" filter="false"/></b><br/></div>').appendTo('#tooltipContent');
			 $('<div id="contractsticky<%=i%>" class="atip"><b style="color: #C00000"> <bean:write name="item" property="mortageCancelNoteDisp" filter="false"/></b><br/></div>').appendTo('#tooltipContent');

		 </logic:equal>
		 $('<div id="contractsticky<%=i%>" class="atip"><b style="color: #C00000"> <bean:write name="item" property="cancelDescription"/></b></div>').appendTo('#tooltipContent');

	</logic:iterate>
	</logic:notEmpty>
	changeProperty();
	function changeProperty() {
		var value = $('#propertyType option:selected').val();
		if (value == 02) {

		//	$('#district').hide();
		//	$('#street').hide();
		} else if (value == 01) {
		//	$('#district').show();
		//	$('#street').show();
		} else if (value == 99) {
		//	$('#district').hide();
		//	$('#street').hide();
		} else {
		//	$('#district').show();
		//	$('#street').show();
		}
	}
	function clear() {
		document.getElementById("propertyInfoFilter").value = "";
		document.getElementById("relationFilter").value = "";
//		document.getElementById("streetFilter").value = "";
//		document.getElementById("districtFilter").value = "";
		document.getElementById("propertyType").value = "";
		changeProperty();
//		onchangeSelect("districtFilter", "");
		onchangeSelect("propertyType", "");

	}

</script>
