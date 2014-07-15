<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<logic:notPresent name="CommonContext">
    <%
    	response.sendRedirect("./");
    %>
</logic:notPresent>

<bean:define id="context" name="CommonContext" type="com.osp.npo.app.context.CommonContext"/>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <title><bean:write name="context" property="screenTitle"/></title>
    <link rel="SHORTCUT ICON" href="./image/osp.ico"/>
    <link href="./style/style.css" rel="stylesheet" type="text/css" media="screen,print" />
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
    <%@include file="hight_light.jsp" %>
    <table id="wrapper">
    <tr>
    <td valign="top">
    <div id="header">
        <div id="banner">
            <div style="background: url(./image/header_banner_npo.gif) no-repeat; height: 43px;">
                <div style="font-size: 110%; font-weight: bold; bottom: 10px; position: absolute; padding-left: 120px; color: #DF0101; text-shadow: 2px 2px 4px white;">
                <logic:present name="CommonContext">
	                <bean:write name="CommonContext" property="systemOfficeName"/>
	            </logic:present>
                </div>
            </div>
            <div id="admin-area">
                <html:img src="./image/icon-user.png" />
                <html:link style="color:white;" href="userprofile.do" title="Thông tin tài khoản">
                    Chào <bean:write name="context" property="userInfo.familyName"/> <bean:write name="context" property="userInfo.firstName"/>
                </html:link>
                <span>[<bean:write name="context" property="userInfo.account"/>]</span>
                <span style="color:white;">&nbsp;|&nbsp;</span>
                <html:img src="./image/icon-logout.png" />
                <html:link style="color:white;" href="logout.do">Đăng xuất</html:link>
            </div>
        </div>

        <div id="gmenu">
          <ul id="jsddm">
              <li>
                <html:link styleId="home" href="home.do" styleClass="jla">
                    <em class="home-off">&nbsp;</em>
                    <b>Trang chủ</b>
                    <html:img alt="|" src="./image/menu_sperator.png"/>
                </html:link>
              </li>
              <li>
                <logic:equal name="CommonContext" property="synchronizeType" value="1">
                  <html:link styleId="preventTab" href="preventlistview2.do" styleClass="jla">
                      <em style="width:17px;" class="menu-block-contract-off">&nbsp;</em>
                      <b>Tra cứu thông tin</b>
                      <html:img alt="|" src="./image/menu_sperator.png"/>
                  </html:link>
                </logic:equal>
                <logic:notEqual name="CommonContext" property="synchronizeType" value="1">
                  <html:link styleId="preventTab" href="preventlistview2.do" styleClass="jla">
                      <em style="width:17px;" class="menu-block-contract-off">&nbsp;</em>
                      <b>Tra cứu thông tin</b>
                      <html:img alt="|" src="./image/menu_sperator.png"/>
                  </html:link>
	                <ul>
	                    <li><html:link href="preventlistview2.do">Tra cứu tại Sở Tư Pháp</html:link></li>
	                    <li><html:link href="preventlistview.do">Tra cứu tại văn phòng</html:link></li> 
	                </ul>
                </logic:notEqual>
              </li>
              <li>
                <html:link styleId="contract" href="contractlistview.do" styleClass="jla">
                    <em style="width:17px;" class="contract-off">&nbsp;</em>
                    <b>Quản lý hợp đồng</b>
                    <html:img alt="|" src="./image/menu_sperator.png"/>
                </html:link>
                <ul>
                    <li><html:link href="contractlistview.do">Danh sách hợp đồng công chứng</html:link></li>
                    <%-- <li><html:link href="temporarycontractlistview.do">Danh sách hợp đồng chờ ký</html:link></li>  --%>
                    
                    <logic:equal value="true" property="viewContractReport" name="CommonContext">
	                    <%-- <li><html:link href="contractstatisticbykindview.do">Báo cáo theo nhóm</html:link></li>
	                    <li><html:link href="contractbynotaryview.do">Báo cáo theo công chứng viên</html:link></li>
	                    <logic:equal value="1" property="contractDrafter" name="CommonContext">
	                       <li><html:link href="contractbyuserlistview.do">Báo cáo theo chuyên viên soạn thảo</html:link></li>
	                    </logic:equal>
                    
	                    <%
                    	                    	if (context.isBankReport()) {
                    	                    %>
	                    <li><html:link href="contractbybankview.do">Báo cáo theo ngân hàng</html:link></li>
	                    <%
	                    	}
	                    %>
	                    <logic:equal value="1" property="contractErrorStatus" name="CommonContext">
	                    <li><html:link href="contracterrorlistview.do">Báo cáo hợp đồng lỗi</html:link></li>
	                    </logic:equal>
	                    <logic:equal value="1" property="supplementContractFunction" name="CommonContext">
	                      <li><html:link href="contractadditionview.do">Báo cáo hợp đồng cần bổ sung</html:link></li>
	                    </logic:equal>
	                    <li><html:link href="contractstatisticview.do">Thống kê tổng hợp</html:link></li> --%>
	                    <li><html:link href="printnotarybookview.do">In sổ công chứng</html:link></li>
                    </logic:equal>
                </ul>
              </li>
              <%-- <%
              	if (context.isAnnouncementManagement()) {
              %>
              <li>
                <html:link styleId="announcementTab" href="announcementlistview.do" styleClass="jla">
                      <em style="width:17px;" class="announcement-off">&nbsp;</em>
                      <b>Thông báo</b>
                      <html:img alt="|" src="./image/menu_sperator.png"/>
                </html:link>
              </li>
              <%
              	}
              %> --%>
              <%
              	if (context.isAdmin()) {
              %>
              <li>
                <html:link styleId="system" href="userlistview.do" styleClass="jla">
                  <em class="system-off">&nbsp;</em>
                  <b>Quản trị hệ thống</b>
                  <html:img alt="|" src="./image/menu_sperator.png"/>
                </html:link>
                <ul>
                    <li><html:link href="userlistview.do">Danh sách người sử dụng</html:link></li>
                    <li><html:link href="contractkindlistview.do">Danh sách nhóm hợp đồng</html:link></li>
                    <li><html:link href="contracttemplatelistview.do">Danh sách tên hợp đồng</html:link></li>
                    <li><html:link href="banklistview.do">Danh sách ngân hàng</html:link></li>
                    <li><html:link href="contractHistorylistview.do">Lịch sử thay đổi hợp đồng</html:link></li>
                    <li><html:link href="accesshistorylist.do">Lịch sử truy cập hệ thống</html:link></li>
                    <logic:equal value="true" name="CommonContext" property="userInfo.hiddenFlg">
                        <li><html:link href="systemconfigview.do">Cấu hình hệ thống</html:link></li>
                    </logic:equal>
                </ul>
              </li>
              
             <!--  <li>
                <a  target="_blank" href="http://192.168.1.209:8080/forum/login.do?u=<%=context.getUserInfo().getFullName()%> &o=000 &ur=administrator &acc=<%=context.getUserInfo().getAccount()%> &p=<%=context.getUserInfo().getPassword()%>">
                    <em class="forum-off">&nbsp;</em>
                    <b>Diễn đàn</b>
                    <html:img alt="|" src="./image/menu_sperator.png"/>
                </a>
              </li> -->
           
              <%
              	}
              %>
          </ul> 	
          <html:link styleClass="acc_link" href="/uchi_help/" target="_blank"><img style="margin-bottom: -4px;" src="./image/help.png"> Trợ giúp</html:link> 
          <html:link styleClass="acc_link" href="contact.do"><img style="margin-bottom: -4px;" src="./image/contact.png"> Liên hệ</html:link> 
          <html:link styleClass="acc_link" href="userprofile.do">
            <img width="12.5px" src="./image/profile.png" style="margin-bottom: -2px;"> Tài khoản
          </html:link>
        </div>

    </div>
    <div id="content" class="clearfix">
