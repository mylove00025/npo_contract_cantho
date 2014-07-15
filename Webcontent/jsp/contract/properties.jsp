<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

    <logic:notEmpty name="contractViewHelper" property="propertyList">
    <table class="tbl-list">
	    <tr>
	        <th>Loại tài sản</th>
	        <th>Tiêu đề</th>
	        <th>Thông tin tài sản</th>
	        <th>Thao tác</th>
	    </tr>
	    <logic:iterate id="item" name="contractViewHelper" property="propertyList" indexId="i">
	       <tr style="background-color: #FFFFFF;">
	           <td nowrap="nowrap">
	               <logic:equal name="item" property="type" value="01">Nhà đất</logic:equal>
                   <logic:equal name="item" property="type" value="02">Ô tô</logic:equal>
                   <logic:equal name="item" property="type" value="03">Xe máy</logic:equal>
                   <logic:equal name="item" property="type" value="99">Tài sản khác</logic:equal>
	           </td>
	           <td style="max-width: 240px;">
                   <bean:write name="item" property="title"/>
               </td>
	           <td style="max-width: 240px;">
                   <logic:equal name="item" property="type" value="01">
                       <logic:notEmpty name="item" property="code">
                           Số giấy chứng nhận: &nbsp;<bean:write name="item" property="code"/>
                       </logic:notEmpty>                       
                   </logic:equal>
                   <logic:equal name="item" property="type" value="02">
                       <logic:notEmpty name="item" property="code">
                           Biển kiểm soát: &nbsp;<bean:write name="item" property="code"/>
                       </logic:notEmpty>
                   </logic:equal>
                   <logic:equal name="item" property="type" value="03">
                       <logic:notEmpty name="item" property="code">
                           Biển kiểm soát: &nbsp;<bean:write name="item" property="code"/> 
                       </logic:notEmpty>                       
                   </logic:equal>
                   <logic:equal name="item" property="type" value="99">
                       <logic:notEmpty name="item" property="code">
                           Mã số tài sản: &nbsp;<bean:write name="item" property="code"/><br/>
                       </logic:notEmpty>
                       <logic:notEmpty name="item" property="otherInfo">
                           Thông tin khác: &nbsp;<bean:write name="item" property="otherInfo"/>
                       </logic:notEmpty>
                   </logic:equal>
               </td>
               
               <td nowrap="nowrap" style="text-align: center;" colspan="4">
                   <a style="color: #006EF6; text-decoration: underline;" onclick="showDetail(<%=i%>)">Chỉnh sửa</a>
                   <span> | </span>
                   <a style="color: #006EF6; text-decoration: underline;" onclick="removeProperty(<%=i%>)">Xóa</a>
               </td>
	       </tr>
	    </logic:iterate>
    </table>
    </logic:notEmpty>