<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<logic:present name="org.apache.struts.action.ERROR">
    <div class="err_box" id="err_box">
        <html:errors />
    </div>
</logic:present>

<logic:present name="org.apache.struts.action.ACTION_MESSAGE">
    <div class="message_box" id="message_box">
        <html:messages id="message" message="true">
            <bean:write name="message" filter="false"/><br>
        </html:messages>
    </div>
</logic:present>