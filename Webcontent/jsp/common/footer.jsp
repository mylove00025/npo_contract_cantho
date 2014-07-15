<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

	</td>
    </tr>
    
    <tr height="30px">
    <td>   
	<div id="footer">
	    <div class="clearfix-left">
	        <logic:present name="CommonContext">
	            <bean:write name="CommonContext" property="systemOfficeName"/>
                - Địa chỉ: <bean:write name="CommonContext" property="systemOfficeAddress"/>
            </logic:present>
	    </div>
	    <div class="clearfix-right">
	        © 2011 Bản quyền thuộc về
	        <a href='http://www.osp.com.vn' target="_blank">
               <img style="margin-bottom: -2px;" src="./image/osp_logo_grey.gif"/> osp.com.vn
            </a> 
	    </div>
	</div>
	</td>
	</tr>
	</table>

</body>

	