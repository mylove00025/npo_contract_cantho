<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<logic:present name="org.apache.struts.action.ERROR">
    <bean:define id="errors" name="org.apache.struts.action.ERROR" type="org.apache.struts.action.ActionMessages"/>
    <%request.setAttribute("ERROR_FIELD", errors.properties());%>

<script language="javascript">
    var itemArr = [];
    var element = null;
    if (window.addEventListener){
        window.addEventListener('load', highlight, false);
    } else if (window.attachEvent){
        window.attachEvent('onload', highlight);
    }
    function highlight() {
    <logic:iterate id="errField" name="ERROR_FIELD">
        //Get control id
        var varState = "<bean:write name='errField'/>";
        //check if control contain special character
        var lastIndex = varState.lastIndexOf('-');
        //if control has special character, remove them
        if (lastIndex >= 0){
            varState = varState.substring(0, lastIndex);
        }
       //Set class style name for row/column/header
        element = document.getElementById(varState +'_tr');
        if (element) {
            element.className += ' error-cell';
        }
        element = document.getElementById(varState +'_th');
        if (element) {
            element.className += ' error-cell';
        }
        element = document.getElementById(varState +'_td');
        if (element) {
            element.className += ' error-cell';
        }
    </logic:iterate>
    }

</script>
</logic:present>