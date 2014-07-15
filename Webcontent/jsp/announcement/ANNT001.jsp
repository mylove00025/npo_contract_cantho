<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>
    <div id="navigator">
	     <ul class="clearfix">
	         <li>
                    <html:img alt="*" src="./image/bullet_square.gif"/>
                </li>
	         <li>
	             <html:link href="announcementlistview.do">Thông báo</html:link>
	         </li>
	         <li>
	             <span> > </span>
	             <html:link href="#">Danh sách thông báo</html:link>
	         </li>                       
	     </ul>
    </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
    <html:form action="announcementlistview" styleId="form" onsubmit="javascript: search()">
        <div id="searchShow" class="sub-title">
           <span>◊ Điều kiện tìm kiếm</span>           
        </div>
         
        <table id="tblSearch" class="advanceSearch tbl-search" class="tbl-none-border">
            <tr>
                <td nowrap="nowrap" style="padding-left: 15px; line-height: 1.5;">
                    Tiêu đề 
                    <html:text styleId="announcementTitleFilter" name="announcementListViewHelper" property="announcementTitleFilter"
                                    styleClass="input-normal" maxlength="200"/>
                </td>
                <td nowrap="nowrap" colspan="4" style="text-align: center; padding: 10px;">
                        <html:image alt="Tìm kiếm" src="./image/btn_search.png"/>
                </td> 
            </tr>                   
        </table>
        <div>
            <div class="clearfix-left">
                <span>◊ Danh sách thông báo</span>
            </div>
            <div class="clearfix-right">
                <html:link href="announcementregistview.do">
                    <html:img alt="Them moi" src="./image/btn_add.png"/>
                </html:link>
                <logic:notEmpty name="announcementListViewHelper" property="announcementList">
	                <html:link href="javascript: remove()">
	                    <html:img alt="Xoa" src="./image/btn_delete.png"/>
	                </html:link>
                </logic:notEmpty>
            </div>
        </div>
        <logic:notEmpty name="announcementListViewHelper" property="announcementList">
            <table id="announcementList" class="tbl-list">
                <tr>
                    <th>
                        <html:checkbox name="announcementListViewHelper" styleId="chkAllID" property="chkAllID" disabled="false"/>
                    </th>
	                <th>Tiêu đề</th>
	                <th>Người gửi</th>
	                <th>Ngày gửi</th>	                
                </tr> 
                <tbody id="announcementListContent">
                <logic:iterate id="item" name="announcementListViewHelper" property="announcementList" indexId="i">
                    <tr class="tbl-row<%=i % 2%>">
                        <td style="text-align: center; width: 25px;">
                            <html:multibox name="announcementListViewHelper" styleId="chkID" property="chkID" disabled="false">
                                <bean:write name='item' property='aid'/>
                            </html:multibox>
                        </td>
                        <td>
                            <html:link href="announcementupdateview.do" paramId='id' paramName='item' paramProperty='aid'>
                                <bean:write name="item" property="title"/>
                            </html:link>
                            <logic:equal value="2" name="item" property="importanceType">
                                <img src="./image/icon_importance.png" alt="Tin quan trọng" title="Tin quan trọng"/>
                            </logic:equal>
                            <logic:equal value="true" name="item" property="today"> 
                                <img src="image/mes_new.png" alt="Tin mới" title="Tin mới"/>
                            </logic:equal>
                        </td>
                        <td>
                            <bean:write name="item" property="senderInfo"/>
                        </td>
                        <td style="text-align: center;">
                            <bean:write name="item" property="sendDateTime" format="dd/MM/yyyy HH:mm"/>
                        </td>                        
                    </tr>    
                </logic:iterate>
                </tbody>
            </table>
            <logic:greaterThan name="announcementListViewHelper" property="totalCount" value="0">
            <div class="pager">
                <div class="pager-total">Tổng số <strong><bean:write name="announcementListViewHelper" property="totalCount"/></strong> dữ liệu</div>
                <div>
                    <logic:greaterThan name="announcementListViewHelper" property="totalPage" value="1">
	                    <html:link href="javascript:direction('first')">        
	                        <img class="pager-first" src="./image/first.png" alt= "first"/>
	                    </html:link>
	                    <html:link href="javascript:direction('ahead')">
	                        <img class="pager-prev" src="./image/prev.png" alt= "prev"/>
                    </html:link>
                    </logic:greaterThan>
                    <span>
                        Trang&nbsp;
                        <bean:write name="announcementListViewHelper" property="page" format="##########"/>
                         /<bean:write name="announcementListViewHelper" property="totalPage" format="##########"/>
                    </span>
                    <logic:greaterThan name="announcementListViewHelper" property="totalPage" value="1">
	                    <html:link href="javascript:direction('next')">
	                        <img class="pager-next" src="./image/next.png" alt= "next"/>
	                    </html:link>
	                    <html:link href="javascript:direction('end')">
	                        <img class="pager-last" src="./image/last.png" alt= "last"/>
                    </html:link>
                    </logic:greaterThan>
                </div>
            </div>
            </logic:greaterThan>
            <html:hidden property="direction"/>
            <div class="clearfix-right">
                <html:link href="announcementregistview.do">
                    <html:img alt="Them moi" src="./image/btn_add.png"/>
                </html:link>
                <html:link href="javascript: remove()">
                    <html:img alt="Xoa" src="./image/btn_delete.png"/>
                </html:link>
            </div>
        </logic:notEmpty>
    </html:form>
    <%@ include file="/jsp/common/footer.jsp" %> 
</html:html>

<script type="text/javascript">

	$('#announcementTab > em').removeClass("announcement-off");
	$('#announcementTab > em').addClass("announcement-on");
	$('#announcementTab > b').addClass("menu-on");
    
    document.getElementById("announcementTitleFilter").focus();
    
	function search() {
        document.announcementListForm.action="announcementlistsearch.do";
        return true;
    }
    
    function direction(data){
        document.announcementListForm.direction.value=data;
        document.announcementListForm.action="announcementlistpaging.do";
        document.announcementListForm.submit();
        return true;
    }

    function remove() {
    	var answer = confirm ("Bạn có thực sự muốn xóa thông báo không?");
    	if (answer) {
	        document.announcementListForm.action="announcementlistremove.do";
	        document.announcementListForm.submit();
	        return true;
    	}
    }
    
    //Check all multibox function
    $("#chkAllID").click(function()             
    {
        var checked_status = this.checked;
        $("input[@name=chkID]").each(function()
        {
            this.checked = checked_status;
        });
    });
</script>