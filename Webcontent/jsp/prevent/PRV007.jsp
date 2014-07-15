<%@ page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8" errorPage=""%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>

<%@ include file="/jsp/common/header.jsp"%>


<iframe  scrolling="no" height="3000" frameborder="0" width="100%" align="top" id="blockrandom"
 src="<%=context.getDepartmentLink()%>/login.do?acc=<%=context.getSynchronizeAccount()%>&p=<%=context.getSynchronizePassword()%>" class="wrapper">

</iframe>
	
<%@ include file="/jsp/common/footer.jsp"%>
</html:html>
