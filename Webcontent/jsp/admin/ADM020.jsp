<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.servletsuite.com/servlets/tooltip" prefix="t" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>    
    <div id="navigator" style="padding-bottom:20px">
            <ul class="clearfix">
                <li>
                    <html:img alt="*" src="./image/bullet_square.gif"/>
                </li>
                <li>
                    <html:link href="userlistview.do">Quản lý trị hệ thống</html:link>
                </li>
                <li>
                    <span> > </span>
                    <html:link href="contractHistorylistback.do">Lịch sử thay đổi hợp đồng, giao dịch</html:link>                  
                </li>
                <li>
                    <span> > </span>
                    <html:link href="#">Chi tiết lịch sử thay đổi hợp đồng, giao dịch</html:link>
                </li>
            </ul>
        </div>
    <%@ include file="/jsp/common/error_message.jsp" %>
    <html:form action="contractHistoryListselect">
    
    <logic:notEmpty name="contractHistoryDetailViewHelper" property="contractHistoryList">
    	<logic:iterate id="contract" name="contractHistoryDetailViewHelper" property="contractHistoryList" indexId="i">
    		<hidden id="isHidePanelInfo<bean:write name='contract' property='hid'/>" name="isHidePanelInfo"/>
    		<div style="border: none; width: 80%;margin-bottom:5px">
    			<div id="infoShow" class="sub-title" style="background-color:#d8d8d8;border:1px solid #898989;">
	        		<span class="tree_open" id="infoOption<bean:write name='contract' property='hid'/>" style="cursor: pointer;background-image:none" onclick="changeInfoState(<bean:write name='contract' property='hid'/>); setInfoState(<bean:write name='contract' property='hid'/>);"></span>
	        		<strong class="onmouseover" style="padding:5px 500px 5px 0px" onclick="changeInfoState(<bean:write name='contract' property='hid'/>); setInfoState(<bean:write name='contract' property='hid'/>);">#ID:<bean:write name="contract" property="hid"/></strong>
	        	</div>
	        	
	        	<table class="tbl-list" id="contractInformation<bean:write name='contract' property='hid'/>" style="background-color:white;display:none">
	        		<tr>
	        			<td width="20%">Mã hợp đồng</td>
	        			<td width="80%"><bean:write name="contract" property="contractId"/></td>
	        		</tr>
	        		<tr>
	        			<td>Số hợp đồng</td>
	        			<td><bean:write name="contract" property="contractNumber"/></td>
	        		</tr>
	        		<tr>
	        			<td>Nội dung</td>
	        			<td><bean:write name="contract" property="contractContentNew" filter="false"/></td>
	        		</tr>
	        		<tr>
	        			<td>Thao tác</td>
	        			<td><bean:write name="contract" property="executeContent"/></td>
	        		</tr>
	        		<tr>
	        			<td>Người thực hiện</td>
	        			<td><bean:write name="contract" property="executePerson"/></td>
	        		</tr>
	        		<tr>
	        			<td>Ngày thực hiện</td>
	        			<td><bean:write name="contract" property="executeDateTime" format="dd-MM-yyyy hh:mm:ss"/></td>
	        		</tr>
	        	</table>
    		</div>
    	 </logic:iterate>
    </logic:notEmpty>
    <div style="width:80%;text-align:center;padding-top:20px;padding-bottom:20px">
    	<html:link href="contractHistorylistback.do">
               <html:img alt="Quay lại danh sách" src="./image/btn_list_back.png"/>
        </html:link>
    </div>
    <html:hidden styleId="isOpen" property="isOpen" name="contractHistoryDetailViewHelper" />
    </html:form>
    <%@ include file="/jsp/common/footer.jsp" %>
</html:html>  

<script type="text/javascript">

    var fromContract = $('#hiddenfromContractList').val();
    if(fromContract == 'true') {
	    $('#contract > em').removeClass("contract-off");
	    $('#contract > em').addClass("contract-on");
	    $('#contract > b').addClass("menu-on");
    } else {
    	$('#sub-menu').hide();
    	$('#preventTab > em').removeClass("menu-block-contract-off");
        $('#preventTab > em').addClass("menu-block-contract-on");
        $('#preventTab > b').addClass("menu-on");
    }
    
    
    function changeNumberProperty() {
        if ($('#hasOnePropertyFlag').val() == "1") {
            document.contractForm.numberProperty.value = "1";
            $('tr.noProperty').hide();
            $('tr.oneProperty').show();            
            changeDisplayOneProperty();
        } else if ($('#hasOnePropertyFlag').val() == "2") {
            document.contractForm.numberProperty.value = "2";
            $('tr.noProperty').hide();
            $('tr.oneProperty').hide();            
        } else {
        	document.contractForm.numberProperty.value = "0";
        	$('tr.noProperty').show();
            $('tr.oneProperty').hide();            
        }
    }
    
    function changeDisplayOneProperty() {
        $('.vehicles').hide();
        $('.land').hide();
        $('.other').hide();    
        var value = $('#hiddenPropertyType').val();
        if(value == '02') {
            $('.vehicles').show();
            $('#propertyTypeName').html('Ô tô, xe máy');
        } else if(value == '03') {
            $('.vehicles').show();
            $('#propertyTypeName').html('Ô tô, xe máy');
        } else if(value == '01') {
            $('.land').show();   
            $('#propertyTypeName').html('Nhà đất');
        } else if(value == '99') {
            $('.other').show();
            $('#propertyTypeName').html('Tài sản khác');
        } else if(value == '00') {
            $('#propertyTypeName').html('Chưa phân loại tài sản');
        } else {
        	$('#propertyTypeName').html('Không có thông tin tài sản trong hợp đồng');
        }        
    }
    
    function changeProperty(value) {
        changeDisplayOneProperty();
    }
    
    setInfoState($('#isOpen').val());
    function changeInfoState(index) {
    	var val = $('#isHidePanelInfo' + index).val();
        if (val == "true") {
            //document.contractHistoryDetailForm.isHidePanelInfo.value = "false";
            $('#isHidePanelInfo' + index).val("false");
        } else {
            //document.contractHistoryDetailForm.isHidePanelInfo.value = "true";
            $('#isHidePanelInfo' + index).val("true");
        }
    }
    
    function setInfoState(index) {
        var val = $('#isHidePanelInfo' + index).val();
        if (val == "true") {
            $('#contractInformation'+index).show();
        } else if(val == "false"){
            $('#contractInformation'+index).hide();
        }
        if (val == "") {
        	$('#contractInformation'+index).show();
        }
    }
    
    function changeAppendixState() {
        var val = document.getElementById("isHidePanelAppendix").value;
        if (val == "true") {
            document.contractForm.isHidePanelAppendix.value = "false";
        } else {
            document.contractForm.isHidePanelAppendix.value = "true";
        }
    }
    
    function setAppendixState() {
        var val = document.getElementById("isHidePanelAppendix").value;
        if (val == "true") {
            $('#appendixOption').removeClass('tree_open');
            $('#appendixOption').addClass('tree_close');
            $('#contractList').hide();
        } else {
            $('#appendixOption').removeClass('tree_close');
            $('#appendixOption').addClass('tree_open');
            $('#contractList').show();
        }
    }
    
</script>