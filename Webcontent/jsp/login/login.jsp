<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>    
    <title>
        Hệ thống quản lý hợp đồng công chứng
    </title>
    <link rel="SHORTCUT ICON" href="./image/osp.ico"/>
    <link rel="stylesheet" href="./style/login.css" type="text/css"/>
    
</head>

<body>    
    <div id="content" align="center">
    <table>
        <tr>
            <td align="center">
                <div id="center_div">
                    <div id="login_box">
                        <table width="100%">
                        <tr><td>
                        <div id="osp_logo">                
                            <html:link href='http://www.osp.com.vn' target="_blank">
                                <html:img src="./image/osp_logo.png" onclick="loginSubmit"/>                                
                            </html:link>
                        </div>
                         
                        </td>
                        <td>
                        <div id="input_form">
                            <html:form action="login">
                                <table>
                                    <tr>
                                        <td id="errors" align="center" colspan="2" nowrap="nowrap" >
                                            <html:errors/>
                                            <html:messages id="message" message="true">
                                            <font color="#FF0000"><bean:write name="message" filter="false"/></font><br/>
                                            </html:messages>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="td_input_form_left">
                                           <html:img src="./image/login_user.png"/>
                                        </td>
                                       <td class="td_input_form_right">
                                          <html:text property="userName" name="loginForm" maxlength="50" size="30" onfocus="Change(this, event)"
                                                onblur="Change(this, event)" styleClass="txt_user_name"></html:text>
                                       </td>
                                    </tr>
                                    <tr>
                                        <td class="td_input_form_left">
                                           <html:img src="./image/login_key.png"/>
                                        </td>
                                        <td class="td_input_form_right">
                                           <html:password property="password" maxlength="50" size="30" onfocus="Change(this, event)"
                                                onblur="Change(this, event)" styleClass="txt_password"></html:password>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" style="text-align: center;">
                                            <input type="image" name="btnLogin" id="btnLogin" src="./image/login_button_blue.png" />
                                        </td>
                                    </tr>
                                </table>
                            </html:form>
                        </div>
                        </td></tr>
                    </table>
                    </div>
                    <div>
                        <span class="copy_right">2011 © Bản quyền thuộc về</span>
                        <a href='http://www.osp.com.vn' target="_blank">
                            <span class="copy_right_osp">Osp</span><span class="copy_right">.com.vn</span>
                        </a>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    </div>
 </body>
</html:html>
<script type="text/javascript">
	function Change(obj, evt)
	{
	    if(evt.type=="focus")
	        {
	            obj.style.borderColor="#FFA737";                    
	        }
	    else if(evt.type=="blur")
	       obj.style.borderColor="white";
	}
	
	document.getElementsByName("userName")[0].focus();
</script>
