<%@ page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8" errorPage=""%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<logic:notPresent name="CommonContext">
	<%
		response.sendRedirect("./");
	%>
</logic:notPresent>

<bean:define id="context" name="CommonContext"
	type="com.osp.npo.app.context.CommonContext" />

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<title><bean:write name="context" property="screenTitle" /></title>
<link rel="SHORTCUT ICON" href="./image/osp.ico" />
<link href="./style/style.css" rel="stylesheet" type="text/css"
	media="screen,print" />
<link rel="stylesheet" type="text/css" href="./style/calendar.css" />
<link rel="stylesheet" type="text/css" href="./style/border-radius.css" />
<link rel="stylesheet" type="text/css" href="./style/steel.css" />
<link rel="stylesheet" type="text/css" href="./style/home-style.css" />
<!--[if IE 7]>
    <link rel="stylesheet" type="text/css" href="./style/style_ie.css" />
    <![endif]-->

<script type="text/javascript" src="./javascript/jquery.min.js"></script>
<script type="text/javascript" src="./javascript/gmenu.js"></script>
<script type="text/javascript" src="./javascript/stickytooltip.js"></script>
<script language="JavaScript" src="javascript/calendar.js"></script>
<script language="JavaScript" src="javascript/vn.js"></script>
<script language="JavaScript" src="javascript/common.js"></script>
</head>

<body>

<table style="width: 774px">
	<tr>
		<td valign="top">

		<div id="content" class="clearfix" style="width:733px">

		<div id="navigator">
		<ul class="clearfix" style="text-align: center;">
			<li><strong style="font-size: 15px;">KẾT QUẢ TRA CỨU</strong></li>
		</ul>
		</div>
		</br>
		<%@ include file="/jsp/common/error_message.jsp"%>

		<html:form styleId="form" action="preventlistsearch"
			onsubmit="javascript: search();">
			<html:hidden styleId="isHidePanelSearch" property="isHidePanelSearch"
				name="preventListViewHelper" />
			<html:hidden styleId="isAdvanceSearch" property="isAdvanceSearch"
				name="preventListViewHelper" />
			<html:hidden styleId="displayPreventList"
				property="displayPreventList" name="preventListViewHelper" />
			<html:hidden styleId="keyHighLight" property="keyHighLight"
				name="preventListViewHelper" />

			<div id="searchTime"><strong
				style="vertical-align: middle;">Thời gian :</strong> &nbsp;&nbsp;&nbsp; 
				<bean:write name="preventListViewHelper" property="searchTime" format="HH:mm:ss dd/MM/yyyy"/>  
			</div>
			
			<div id="preventListPrint">
				<div style="float: right">
				<div class="advanPrint"><html:link href="javascript:printts()">
					<html:img alt="Them moi" src="./image/btn-print.gif" />
				</html:link></div>
				</div>
			</div>
			
			<table>
			  <tr style="height: 10px">
			    <td></td>
			  </tr>
			</table>
			<div id="searchShow"><strong
				style="vertical-align: middle;">Điều kiện tìm kiếm :</strong>  
			</div>

			<div id="keySearchPanel" class="keySearch"
				style="padding-left: 25px;"><span
				style="vertical-align: middle;">Từ khóa :</span> &nbsp;&nbsp;&nbsp; 
				<bean:write name="preventListViewHelper" property="keySearch"/> 
		    </div>

			<table id="tblSearch" class="advanceSearch tbl-search">
				<tr>
					<td style="padding-left: 25px; line-height: 1.5;">Loại tài sản :
					    <logic:equal name="preventListViewHelper" property="type" value="00">
                             <span>Tất cả</span>
                        </logic:equal>
						<logic:equal name="preventListViewHelper" property="type" value="01">
                             <span>Nhà đất</span>
                        </logic:equal>
                        <logic:equal name="preventListViewHelper" property="type" value="02">
                             <span>Ôtô - xe máy</span>
                        </logic:equal>
                        <logic:equal name="preventListViewHelper" property="type" value="99">
                             <span>Tài sản khác</span>
                        </logic:equal>
					</td>
					
					<td colspan="3" style="padding-left: 25px; line-height: 1.5;">Thông
						tin tài sản :
						<bean:write name="preventListViewHelper" property="propertyInfo"/>  
					    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						Bên liên quan / Chủ sở hữu :
						<bean:write name="preventListViewHelper" property="ownerInfo"/>   
					</td>
				</tr>
			</table>
			
			<table>
			  <tr style="height: 10px">
			    <td></td>
			  </tr>
			</table>

  			<div id="preventListId">
  			    <strong style="vertical-align: middle;">1.Danh sách thông tin ngăn chặn (
  			         Tổng số: <strong><bean:write
				     name="preventListViewHelper" property="totalCount" /></strong> dữ liệu
				     <logic:notEmpty name="preventListViewHelper" property="dataPreventList">
					    <span> - Trang&nbsp; 
						     <bean:write name="preventListViewHelper" property="page"/> 
							 /<bean:write name="preventListViewHelper" property="totalPage"
								format="##########" /> 
						</span>
					 </logic:notEmpty>	
					 )
			   </strong>  
			</div>
   


			<!-- prevent list-->
			
			<logic:empty name="preventListViewHelper"
				property="dataPreventList">
				<div style="padding-left: 25px;">
				   <table>
						<tr style="height: 5px">
							<td></td>
						</tr>
				   </table>
				   Không tìm thấy thông tin ngăn chặn nào.
				</div>
			</logic:empty>
			
			<logic:notEmpty name="preventListViewHelper"
				property="dataPreventList">
				<table>
					<tr style="height: 3px">
						<td></td>
					</tr>
				</table>
				<table id="preventList" class="tbl-list-print" style="width:733px;">
					<tr>
						<th nowrap="nowrap">Phân loại</th>
						<th>Loại tài sản</th>
						<th>Thông tin tài sản</th>
						<th>Đơn vị gửi yêu cầu ngăn chặn</th>
						<th>Ngày nhận công văn</th>
						<th>Số vào sổ CV</th>
						<th nowrap="nowrap">Giải tỏa</th>
					</tr>
					<tbody id="preventListContent">
						<logic:iterate id="item" name="preventListViewHelper"
							property="dataPreventList" indexId="i">
							<tr>
								<td style="text-align: center;">
								    <logic:equal name="item"
										property="originKind" value="01">
										Ngăn chặn
									</logic:equal>
									<logic:equal name="item" property="originKind" value="02">
										Tham khảo
									</logic:equal>
								</td>
								<td nowrap="nowrap"><logic:equal name="item"
									property="type" value="01">Nhà đất</logic:equal> <logic:equal
									name="item" property="type" value="02">Ô tô, Xe máy</logic:equal>
								<logic:equal name="item" property="type" value="99">Tài sản khác</logic:equal>
								</td>
								<td><logic:equal value="false" property="luceneSearch"
									name="preventListViewHelper">
									<bean:define id="infoDisp" name="item" property="infoDisp"
										type="java.lang.String"></bean:define>
									<bean:define id="info" name="item" property="info"
										type="java.lang.String"></bean:define>
									<bean:write name="item" property="propertyInfo" filter="false" />
								    </logic:equal> <logic:equal value="true" property="luceneSearch"
									name="preventListViewHelper">
									<bean:define id="infoDisp" name="item"
										property="lucenePropertyInfoDisp" type="java.lang.String"></bean:define>
									<bean:define id="info" name="item"
										property="lucenePropertyInfo" type="java.lang.String"></bean:define>
									<bean:write name="item" property="lucenePropertyInfo"
										filter="false" /> 
									</logic:equal>
								</td>
								<td><bean:write name="item"
									property="preventPersonInfoDisp" filter="false" /></td>
								<td style="text-align: center;"><bean:write name="item"
									property="preventDocReceiveDate" format="dd/MM/yyyy" /></td>
								<td style="text-align: center;">
                                    <bean:write name="item" property="preventInBookNumber"/></td>
								<td style="text-align: center;">
									<logic:equal name="item"
										property="releaseFlg" value="true">
										Đã giải tỏa
									</logic:equal>
								</td>
							</tr>
						</logic:iterate>
					</tbody>
				</table>
				<div id="preventAdd"></div>

			</logic:notEmpty>

  			<table>
			  <tr style="height: 10px">
			    <td></td>
			  </tr>
			</table>
			
            <div id="preventListId">
  			    <strong style="vertical-align: middle;">2.Danh sách hợp đồng,giao dịch đã công chứng (
  			         Tổng số: <strong><bean:write
				     name="preventListViewHelper" property="totalCountProperty" /></strong> dữ liệu
				     <logic:notEmpty name="preventListViewHelper" property="transactionPropertyList">
					     <span> - Trang&nbsp;
					        <bean:write name="preventListViewHelper" property="pageProperty"/> 
							/<bean:write name="preventListViewHelper" property="totalPageProperty"
							format="##########" /> 
						</span>
					</logic:notEmpty>
					)
			   </strong>  
			</div>
			
			<!-- property list-->
			
			<logic:empty name="preventListViewHelper"
				property="transactionPropertyList">
				<div style="padding-left: 25px;">
				   <table>
						<tr style="height: 5px">
							<td></td>
						</tr>
				   </table>
				   Không tìm thấy hợp đồng,giao dịch đã công chứng nào.
				</div>
			</logic:empty>
			
			<logic:notEmpty name="preventListViewHelper"
				property="transactionPropertyList">
				<table>
				  <tr style="height: 3px">
				    <td></td>
				  </tr>
				</table>
				<table id="propertyList" class="tbl-list-print" style="width:733px;">
					<tr>
						<th>Ngày công chứng</th>
						<th>Số hợp đồng</th>
						<th>Tên hợp đồng</th>
						<th id="relateObjectWidth" class="relateObjectWidth_css" >Bên liên quan</th>
						<th>Nội dung</th>
						<th>Công chứng viên</th>
						<th>Tổ chức công chứng</th>
					</tr>

					<tbody id="propertyListContent">
						<logic:iterate id="item" name="preventListViewHelper"
							property="transactionPropertyList" indexId="i">
							<tr id="highlight">
								<td nowrap="nowrap" style="text-align: center;"><bean:write
									name="item" property="notaryDate" format="dd/MM/yyyy" /></td>
								<td><bean:write name="item" property="contractNumber" /></td>
								<td><bean:write name="item" property="contractName" /></td>
								<td><logic:equal value="false" property="luceneSearch"
									name="preventListViewHelper">
									<bean:define id="summaryDisp" name="item"
										property="relationObjectSummaryDisp" type="java.lang.String"></bean:define>
									<bean:define id="disp" name="item"
										property="relationObjectDisp" type="java.lang.String"></bean:define>
								    <bean:write name='item' property='relationObject'
										filter="false" /> 
									</logic:equal> <logic:equal value="true" property="luceneSearch"
									name="preventListViewHelper">
									<bean:define id="summaryDisp" name="item"
										property="luceneRelationObjectDisp" type="java.lang.String"></bean:define>
									<bean:define id="disp" name="item"
										property="luceneRelationObject" type="java.lang.String"></bean:define>
									<bean:write name='item' property='luceneRelationObject'
										filter="false" /> 
									</logic:equal>
								</td>
								<td>
								    <logic:equal value="false" property="luceneSearch"
									name="preventListViewHelper">

									<bean:define id="summaryDisp" name="item"
										property="transactionContentSummaryDisp"
										type="java.lang.String"></bean:define>
									<bean:define id="disp" name="item"
										property="transactionContentDisp" type="java.lang.String"></bean:define>
									<bean:write name='item'
										property='transactionContentDisp' filter="false" />
								    </logic:equal> <logic:equal value="true" property="luceneSearch"
									name="preventListViewHelper">

									<bean:define id="summaryDisp" name="item"
										property="luceneTransactionContentDisp"
										type="java.lang.String"></bean:define>
									<bean:define id="disp" name="item"
										property="luceneTransactionContent" type="java.lang.String"></bean:define>
									<bean:write name='item'
										property='luceneTransactionContent' filter="false" />
								</logic:equal> <br />
								<logic:notEmpty name="item" property="contractPeriod">
									<b>Thời hạn</b>: 
						<b > <bean:write name="item"
										property="contractPeriod" /> </b>
									<br />
								</logic:notEmpty> <logic:notEmpty name="item" property="cancelDescription">
									<b>Tình trạng</b>: 
						</logic:notEmpty> <logic:empty name="item" property="cancelDescription">
									<logic:equal value="true" name="item"
										property="mortageCancelFlag">
										<b>Tình trạng</b>: 
						</logic:equal>
								</logic:empty> <b> <logic:equal value="true"
									name="item" property="mortageCancelFlag">

									<bean:write name="item" property="mortageCancelDateDisp" />
									<br />
									<bean:write name="item" property="mortageCancelNoteDisp"
										filter="false" />
									<br />
								</logic:equal> <bean:write name="item" property="cancelDescription" /> </b></td>
								<td><bean:write name="item" property="notaryPerson" /></td>
								<td style="text-align: center;">
									<bean:write name='item' property='notaryOfficeName' />
								</td>
							</tr>
						</logic:iterate>
					</tbody>
				</table>
			</logic:notEmpty>
			<html:hidden property="direction" />
			<html:hidden property="sortType" name="preventListViewHelper"
				styleId="sortType" />
		</html:form> <br />
		</div>
		</td>
	</tr>
	</table>
</body>

<script type="text/javascript">
    var width = $('#relateObjectWidth').width() + $('#relateObjectWidth').width()/5 + "px";
    $('.relateObjectWidth_css').css({
    	"width":width
    });
    
	if (window.ActiveXObject)//IE
	{
	 $('#content').css({
		"width": "100%"
	  });
	}
    function printts()
    {
    	if (window.ActiveXObject)
    	 {
	    	var OLECMDID = 7;
	    	/* OLECMDID values:
	    	* 6 - print
	    	* 7 - print preview
	    	* 1 - open window
	    	* 4 - Save As
	    	*/
	    	var PROMPT = 1; // 2 DONTPROMPTUSER
	    	var WebBrowser = '<OBJECT ID="WebBrowser1" WIDTH=0 HEIGHT=0 CLASSID="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2"></OBJECT>';
	    	document.body.insertAdjacentHTML('beforeEnd', WebBrowser);
	    	WebBrowser1.ExecWB(OLECMDID, PROMPT);
	    	WebBrowser1.outerHTML = "";
    	 }
    	else
    		{
    		  print();
    		}
    }

    changeSearch($('#isAdvanceSearch').val());
    function changeSearch(value) {
        $('#isAdvanceSearch').val(value);
        if (value == 'true') {
            $('.advanceSearch').show();
            $('.keySearch').hide();
        } else {
        	$('.keySearch').show();
            $('.advanceSearch').hide();
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
  
</script>



