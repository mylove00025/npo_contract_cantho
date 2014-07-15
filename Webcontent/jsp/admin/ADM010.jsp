<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>    
    <html:form action="contracttemplatelistview" onsubmit="javascript:searchOnClick()">
        <div id="navigator">            
            <ul class="clearfix">
                <li>
                    <html:img alt="*" src="./image/bullet_square.gif"/>
                </li>
                <li>
                    <a href="userlistview.do">Quản trị hệ thống</a> &gt;
                    <a href="#">Danh sách tên hợp đồng</a>                     
                </li>         
            </ul>
        </div>
        <%@ include file="/jsp/common/error_message.jsp" %>
        <html:hidden styleId="isHidePanelSearch" property="isHidePanelSearch" name="contractTemplateListForm"/>
            <div id="searchShow" class="sub-title">
                <span class="tree_open" id="searchOption" style="cursor: pointer;" onclick="changeSearchState(); setSearchState();"></span>
                <strong class="onmouseover" onclick="changeSearchState(); setSearchState();">Điều kiện tìm kiếm</strong>
            </div>
        <table id="searchRegion" class="tbl-none-border">
            <tr>
                <th>Tên hợp đồng:</th>  
                <td>           
                    <html:text styleId="contractTemplateNameFilter" name="contractTemplateListViewHelper" property="contractTemplateNameFilter"
                        style="width:200px;" maxlength="200"></html:text>    
                </td>
            </tr>
            <tr>
                <th>Nhóm hợp đồng:</th>
                <td>     
                     <span id="contractKind"></span>                   
                </td>
                <th>Trạng thái sử dụng:</th>
                <td>
                    <html:select styleId="useStatus" property="useStatus" name="contractTemplateListViewHelper" styleClass="input-nomal">
                       <html:option value="00"><i>[Tất cả]</i></html:option>
                       <html:option value="01">Đang sử dụng</html:option>
                       <html:option value="02">Ngừng sử dụng</html:option>
                    </html:select>
                </td>
            </tr>    
            <tr>
                <td colspan="4" style="text-align:center; padding: 10px;">                  
                   <html:image alt="Tìm kiếm" src="./image/btn_search.png"/>
                </td>
            </tr>                        
        </table>
        <div class="clearfix-left">
            <span>◊ Danh sách tên hợp đồng</span>
        </div>
        
                
        <div class="clearfix-right">                
            <a href="contracttemplateregistview.do" class="button"><img src="./image/btn_add.png" alt="Thêm mới" /></a>
        </div>
        
        <div style="padding-right:10px; padding-top:15px;" class="clearfix-right">
                    <html:select style="height:20px;" styleId="useStatusChange" property="useStatus" name="contractTemplateListViewHelper" styleClass="input-nomal" onchange="changeContractTemplateStatus(3)">
                       <html:option value="">Chuyển trạng thái thành</html:option>
                       <html:option value="true">&nbsp;&nbsp;--&gt;Đang sử dụng</html:option>
                       <html:option value="false">&nbsp;&nbsp;--&gt;Ngừng sử dụng</html:option>
                    </html:select>
         </div>
         
        <logic:notEmpty name="contractTemplateListViewHelper" property="contractTemplateList">        
        <table class="tbl-list">            
	         <tr>    
	             <th>
                      <html:checkbox name="contractTemplateListViewHelper" styleId="chkAllID" property="chkAllID" disabled="false"/>
                 </th>
	             <th>Tên hợp đồng</th>
	             <th>Nhóm hợp đồng</th>
	             <th>Trạng thái sử dụng</th>
	             <th>Tải file hợp đồng mẫu</th>
	         </tr>
	         <logic:iterate id="contractTemplate" name="contractTemplateListViewHelper" property="contractTemplateList" indexId="i">
	             <%int style = i % 2; %>
	             <tr class="tbl-row<%=style%>">
                      <td style="text-align: center; width: 25px;">
                            <html:multibox name="contractTemplateListViewHelper" styleId="chkID" property="chkID" disabled="false">
                                <bean:write name="contractTemplate" property="id"/>
                            </html:multibox >
                     </td>
                                                                              
	                 <td>      
	                   <html:link action="/contracttemplatelistselect.do" paramId='id' paramName='contractTemplate' paramProperty='id'>
                            <bean:write name="contractTemplate" property="name"/>
                        </html:link>                                    
	                 </td>
	                 
	                 <td>
                        <bean:write name="contractTemplate" property="contractKindName"/>
                     </td>     
                     
                     <td style="text-align: center;">
                        <logic:equal name="contractTemplate" property="activeFlg" value="false">
                            <img src="./image/icon_unused.png"/>
                        </logic:equal>
                     </td>
                     <td>
                        <logic:notEmpty name="contractTemplate" property="fileName">
                            <bean:define id="fileName" name="contractTemplate" property="fileName" type="java.lang.String"/>
                            <%@ include file="/jsp/common/common_function.jsp" %>
                            <img src="<%=getIcon(fileName)%>"/>
                            <!--<img src="./image/icon_word.gif"/> -->
                            <html:link action="/contracttemplatelistdownload.do" paramId='id' paramName='contractTemplate' paramProperty='id'>
                                <bean:write name="contractTemplate" property="fileName"/>
                            </html:link>                     
                        </logic:notEmpty>                        
                     </td>
	             </tr>
	         </logic:iterate>	         
	     </table>
	     <logic:greaterThan name="contractTemplateListViewHelper" property="totalCount" value="0">
         <div class="pager">
             <div class="pager-total">Tổng số <strong><bean:write name="contractTemplateListViewHelper" property="totalCount"/></strong> dữ liệu</div>
             <div>
                    <logic:greaterThan name="contractTemplateListViewHelper" property="totalPage" value="1">
                        <html:link href="javascript:direction('first')">        
                            <img class="pager-first" src="./image/first.png" alt= "first"/>
                        </html:link>
                        <html:link href="javascript:direction('ahead')">
                            <img class="pager-prev" src="./image/prev.png" alt= "prev"/>
                    </html:link>
                    </logic:greaterThan>
                    <span>
                        Trang&nbsp;
                        <bean:write name="contractTemplateListViewHelper" property="page" format="##########"/>
                         /<bean:write name="contractTemplateListViewHelper" property="totalPage" format="##########"/>
                    </span>
                    <logic:greaterThan name="contractTemplateListViewHelper" property="totalPage" value="1">
                        <html:link href="javascript:direction('next')">
                            <img class="pager-next" src="./image/next.png" alt= "next"/>
                        </html:link>
                        <html:link href="javascript:direction('end')">
                            <img class="pager-last" src="./image/last.png" alt= "last"/>
                    </html:link>
                    </logic:greaterThan>
                </div>
                
                 <html:hidden property="contractTemplateStatus"/>
         </div>
         </logic:greaterThan>
         <html:hidden property="direction"/>
	     <div class="clearfix-right">
	         <a href="contracttemplateregistview.do" class="button"><img src="./image/btn_add.png" alt="Thêm mới" /></a>                     
	     </div>
	     </logic:notEmpty>
    </html:form>
    <%@ include file="/jsp/common/footer.jsp" %> 
</html:html>
<script type="text/javascript">
	//Hightlight menu
    $('#system > em').removeClass("system-off");
    $('#system > em').addClass("system-on");
    $('#system > b').addClass("menu-on");
	
    retrieveURL("ajaxGetContractKindTreeNode.do?fieldName=contractKindId&fieldId=kindId" + "&type=" + 1
        + "&selectedId=<bean:write name='contractTemplateListViewHelper' property='contractKindId'/>");
    
    document.getElementById("contractTemplateNameFilter").focus();

    setSearchState();

    function setSearchState() {
        var val = document.getElementById("isHidePanelSearch").value;
        if (val == "true") {
            $('#searchOption').removeClass('tree_open');
            $('#searchOption').addClass('tree_close');
            $('#searchRegion').hide();
        } else {
            $('#searchOption').removeClass('tree_close');
            $('#searchOption').addClass('tree_open');
            $('#searchRegion').show();
        }
    }

    function changeSearchState() {
        var val = document.getElementById("isHidePanelSearch").value;
        if (val == "true") {
            document.contractTemplateListForm.isHidePanelSearch.value = "false";
        } else {
        	document.contractTemplateListForm.isHidePanelSearch.value = "true";
        }
    }
    
    function searchOnClick() {
        document.contractTemplateListForm.action="contracttemplatelistsearch.do";
        return true;
    }
    
    function direction(data){
        document.contractTemplateListForm.direction.value=data;
        document.contractTemplateListForm.action="contracttemplatelistpaging.do";
        document.contractTemplateListForm.submit();
    }    
   
    function report() {
        document.contractByUserListForm.action="contractbyuserlistexport.do";
        document.contractByUserListForm.submit();
        return true;
    }
    
    var req;
    var which;

    function retrieveURL(url) {
      if (window.XMLHttpRequest) { // Non-IE browsers
        req = new XMLHttpRequest();
        req.onreadystatechange = processStateChange;
        try {
          req.open("GET", url, true);
          req.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
        } catch (e) {
          alert(e);
        }
        req.send(null);
      } else if (window.ActiveXObject) { // IE
        req = new ActiveXObject("Microsoft.XMLHTTP");
        if (req) {
          req.onreadystatechange = processStateChange;
          req.open("GET", url, true);
          req.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
          req.send();
        }
      }
    }

    function processStateChange() {
      if (req.readyState == 4) { // Complete
        if (req.status == 200) { // OK response
            document.getElementById("contractKind").innerHTML = req.responseText;
        } else {
          alert("Problem: " + req.statusText);
        }
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
    
    function changeContractTemplateStatus(n){
    	       
		        var sel= document.getElementById('useStatusChange'); 
		  	    var status = sel.options[sel.selectedIndex].value; 
      	        document.contractTemplateListForm.contractTemplateStatus.value=status;
    	        document.contractTemplateListForm.action="changeContractTemplateStatusList.do";
    	        document.contractTemplateListForm.submit();
      }
</script>