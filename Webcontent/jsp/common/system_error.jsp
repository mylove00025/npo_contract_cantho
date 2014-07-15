<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <meta http-equiv="Content-Script-Type" content="text/javascript" />
    <title>Hệ thống quản lý hợp đồng công chứng</title>
    <link rel="SHORTCUT ICON" href="./image/osp.ico"/>
    <link href="./style/style.css" rel="stylesheet" type="text/css" media="screen,print" />    
</head>
<body>
	<table id="wrapper">   
	<tr>
	<td valign="top">  
    <div id="header">
        <div id="banner">           
            <img src="./image/header_banner_npo.gif" style="float:left"/>
        </div>
    </div>
    <div id="content" class="clearfix">
    	<center>
			<div class="common_err_box">
	        	Lỗi hệ thống: <html:errors />
	        	<br><bean:message key="err_system_error"/>
	        </div>
	        <div style="width:60%; text-align:right; margin-top: 10px;">
            	<a href="./">Quay về trang đăng nhập</a>
            </div>
        </center>
	<%@ include file="/jsp/common/footer.jsp"%>
</html:html>