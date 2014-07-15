<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<script type="text/javascript" src="javascript/dw_event.js" ></script>
<script type="text/javascript" src="javascript/dw_scroll.js" ></script>
<script type="text/javascript" src="javascript/scroll_controls.js" ></script>

<html:html>
    <%@ include file="/jsp/common/header.jsp" %>        
        <html:form action="/home" >
            <%@ include file="/jsp/common/error_message.jsp" %>
            <table class="table_content">
            	<tr>
            		<td valign="top">
            			<table class="table_left_content" cellpadding="0" cellspacing="0">
				            <tr style="width: 100%">
				                <td class="td_contract_content">
				                	<div class="div_Message_blue">
				                		<div class="div_top_left_common_blue">                			
				                		</div>
				                		<div class="div_top_center_common_blue">
				                			<div class="div_top_img"><img src="image/home/ico_news.png" alt="Tin tức" /></div>                			 
				                			<div class="div_top_title">BẢNG THÔNG BÁO</div> 
				                		</div>
				                		<div class="div_top_content_common">	
				                			<logic:iterate id="item_message" name="homeViewHelper" property="lstAnnouncementInfo" indexId="i">		                		
					                			<div class="div_message_item">					                				
					                				
					                				<logic:equal value="0" property="kind" name="item_message">
					                					<a href='announcementview.do?id=<bean:write name="item_message" property="aid" />' title='<bean:write name="item_message" property="title" />'><bean:write name="item_message" property="titleDisp" /></a>
					                					
					                				</logic:equal>
						                				
					                				<logic:equal value="1" property="kind" name="item_message">
					                					<a href='announcementview.do?id=<bean:write name="item_message" property="aid" />' title='<bean:write name="item_message" property="title" />' style="color:red" ><bean:write name="item_message" property="titleDisp" /></a>
					                				</logic:equal>
						                				
					                				<logic:equal value="2" property="importanceType" name="item_message">
					                					<img src="image/icon_importance.png" width="12px" height="12px" alt="Tin quan trọng" />
					                				</logic:equal>
					                				<logic:equal value="true" property="today" name="item_message">	
					                					<img src="image/mes_new.png" alt="Tin mới" />
					                				</logic:equal>
					                				
					                				
					                			</div>					                			
				                			</logic:iterate>				                			
				                		</div> 
				                	</div>				                
				                </td>   
				                <td class="td_contract_content">
				                		<div class="div_Message_blue">
				                		<div class="div_top_left_common_blue">                			
				                		</div>
				                		<div class="div_top_center_common_blue">         
				                			<div class="div_top_img"><img src="image/home/ico_contract.png" alt="Tin tức" /></div>  
				                			<div class="div_top_title"><a href="contractstatisticview.do" >HỢP ĐỒNG MỚI NHẬP TRONG NGÀY</a></div>                 			
				                		</div>
				                		<logic:greaterThan value="4" name="homeViewHelper" property="personCount">
				                			<div class="div_top_content_common_day" style="width:295px;"/>
				                		</logic:greaterThan>
				                		<logic:lessEqual value="4" name="homeViewHelper" property="personCount">
				                			<div class="div_top_content_common_day" style="width:310px;"/>
				                		</logic:lessEqual>
					                		<div id="wn" >
					                			<div id="lyr1" style="width: 100%;">             			
						                			<div class="div_message_item">
						                			    <div class="div_message_item_left">
						                			    	<span style="font-weight: bold;" class="ccv">
						                			    		<img src="image/home/all_blue.png" title="Toàn văn phòng" alt="" width="13px" height="13px" />
							                			    	&nbsp; 
						                			    		Toàn văn phòng
						                			    	</span>
						                			    </div>
						                				<div class="div_message_item_right"><bean:write name="homeViewHelper" property="countTotalInDay" /></div> 
						                			</div>
						                			<%int itemCount = 0; %>
						                			<logic:iterate id="item" name="homeViewHelper" property="lstContractStatisticalInfo" indexId="i">
						                			<div class="div_message_item">
						                			    <div class="div_message_item_left">
							                			    <span class="ccv">
							                			    	<img src="image/home/CCV.png" title="Công chứng viên" alt="" width="13px" height="13px" />
							                			    	&nbsp;
							                			    	<bean:write name="item" property="familyName" />
			                                    				<bean:write name="item" property="firstName" />
							                			     </span>
							                			</div>
						                				<div class="div_message_item_right">
						                					<bean:write name="item" property="countInDay" />
						                				</div> 
						                			</div>
						                			<% itemCount++; %>
						                		    </logic:iterate>
						                		    
						                		    <logic:iterate id="item" name="homeViewHelper" property="lstContractStatisticalForDrafterInfo" indexId="i">
						                			<div class="div_message_item">
						                			    <div class="div_message_item_left">
							                			    <span class="ccv">
							                			    	<img src="image/home/CVST.png" title="Chuyên viên soạn thảo" alt="" width="14px" height="14px"/>
							                			    	&nbsp;
							                			    	<bean:write name="item" property="familyName" />
			                                    				<bean:write name="item" property="firstName" />
							                			     </span>
							                			</div>
						                				<div class="div_message_item_right">
						                					<bean:write name="item" property="countInDay" />
						                				</div> 
						                			</div>
						                			<% itemCount++; %>
						                		    </logic:iterate>	
						                		</div>			                		     	
					                		</div> 
				                		</div>
				                		
			                		<logic:greaterThan value="4" name="homeViewHelper" property="personCount">
				                		<div id="scrollLinks"  class="div_top_content_common_day_right">
				                			
					                			<div class="div_up">
					                				<a class="mouseover_up" href="#" ><img src="image/home/up.png" alt="" width="14px" height="14px"/> </a>
					                			</div>
					                			<div  class="div_down">
					                				<a class="mouseover_down" href="#" ><img src="image/home/down.png" alt="" width="14px" height="14px"/></a>
					                			</div>
				                			
				                		</div>
			                		</logic:greaterThan>
				                </td>
				            </tr>
				            <tr>
				            	<td colspan="2" valign="top">
				            		<div class="fieldset_content_info">
				            			<div class="div_field_top">				            				
				            				<div class="div_field_top_left"></div>
				            				<div class="div_field_top_center"></div>
				            			</div>	
				            			<div class="div_field_midde">		
				            				<div class="div_field_midde_center">
				            					<div class="div_all_content_contract">
				            						<table class="table_common_100">
				            							<tr valign="top">
				            								<td class="td_large_icon">	
				            									<img src="image/home/ico_stop_large.png" alt="Tin tức" />		            									
				            								</td>
				            								<td class="td_large_content">
				            									<div class="div_content_title">
				            										THÔNG TIN NGĂN CHẶN
				            									</div>
				            									<div class="div_content_item">
											                		<a href="preventlistview2.do" title="Tra cứu thông tin ngăn chặn"> Tra cứu thông tin ngăn chặn </a> 
											                	</div>  
											                	 <%
													              if (context.isPreventData()) {
													              %>	
											                	<!-- <div class="div_content_item">
											                		<a href="datapreventregistview.do" title="Thêm mới thông tin ngăn chặn"> Thêm mới thông tin ngăn chặn </a> 
											                	</div> -->
											                	<%} %>										                		            									
				            								</td>				            								
				            								<td class="td_large_icon">
				            									<img src="image/home/ico_temp_large.png" alt="Tin tức" />	            									
				            								</td>				            								
				            								<td style="padding-top: 15px">
				            									<div class="div_content_title">
				            										HỢP ĐỒNG CÔNG CHỨNG
				            									</div>
				            									<div class="div_content_item">
											                		<a href="contractlistview.do" title="Danh sách hợp đồng công chứng"> Danh sách hợp đồng công chứng </a> 
											                	</div> 
											                	<!--  
											                	<div class="div_content_item">
                                                                    <a href="temporarycontractlistview.do" title="Danh sách hợp đồng chờ ký"> Danh sách hợp đồng chờ ký </a> 
                                                                </div> 
											                	 -->	
											                	<%
													              if (context.isContractManagement()) {
													            %>
											                	<div class="div_content_item">
											                		<a href="contractregistview.do" title="Thêm mới hợp đồng công chứng"> Thêm mới hợp đồng công chứng </a> 
											                	</div>
											                	<%} %>	
											                		
											                	 <%
													              if (context.isAdmin()) {
													              %>
											                	<div class="div_content_item">
											                		<a href="contracttemplatelistview.do" title=" Hợp đồng mẫu"> Hợp đồng mẫu </a> 
											                	</div>
											                	<%} %>	          									
				            								</td>
				            							</tr>				            							
				            						</table>
				            					</div>
												<!--												
				            					<div class="div_contract_content">
				            					   <logic:equal value="true" property="viewContractReport" name="CommonContext">
				            						<table class="table_common_100">
				            							<tr valign="top">
				            								<td class="td_large_icon"">	
				            									<img src="image/home/ico_chart_large.png" alt="Tin tức" />		            									
				            								</td>
				            								<td style="padding-top: 15px">	
				            									<div class="div_content_title">
				            										BÁO CÁO THỐNG KÊ
				            									</div>
				            									<div class="div_contract_content_action">
				            										<div class="div_content_item">
											                			<a href="contractstatisticbykindview.do" title="Báo cáo theo nhóm hợp đồng" > Báo cáo theo nhóm hợp đồng </a> 
												                	</div>  	
												                	<div class="div_content_item">
												                		<a href="contractbynotaryview.do" title="Báo cáo theo công chứng viên"> Báo cáo theo công chứng viên </a> 
												                	</div>
												                	<logic:equal value="1" property="contractDrafter" name="CommonContext">
												                	<div class="div_content_item">
												                		<a href="contractbyuserlistview.do" title="Báo cáo theo chuyên viên soạn thảo"> Báo cáo theo chuyên viên soạn thảo </a> 
												                	</div>
												                	</logic:equal>
												                	<%
												                    if (context.isBankReport()) {
												                    %>
												                	<div class="div_content_item">
												                		<a href="contractbybankview.do" title="Báo cáo theo ngân hàng" > Báo cáo theo ngân hàng </a> 
												                	</div>
												                	<%}%>											                
				            									</div>		  
				            									<div >
				            									    <logic:equal value="1" property="contractErrorStatus" name="CommonContext">
				            										<div class="div_content_item">
											                			<a href="contracterrorlistview.do" title="Báo cáo hợp đồng lỗi"> Báo cáo hợp đồng lỗi </a> 
												                	</div>
												                	</logic:equal>
												                	<logic:equal value="1" property="supplementContractFunction" name="CommonContext">
													                	<div class="div_content_item">
													                		<a href="contractadditionview.do" title="Báo cáo hợp đồng cần bổ sung"> Báo cáo hợp đồng cần bổ sung </a> 
													                	</div>
												                	</logic:equal>
												                	<div class="div_content_item">
												                		<a href="contractstatisticview.do" title="Thông kê tổng hợp" > Thống kê tổng hợp </a> 
												                	</div>
												                	<div class="div_content_item">
												                		<a href="printnotarybookview.do" title="In sổ công chứng"> In sổ công chứng </a> 
												                	</div>
				            									</div>		            														            									
				            								</td>				            								
				            							</tr>
				            										            							
				            						</table>
				            					   </logic:equal>
				            					</div>
												-->
				            				</div>
				            			</div>	
				            			<div class="div_field_bottom">				            				
				            				<div class="div_field_bottom_left"></div>
				            				<div class="div_field_bottom_center"></div>
				            			</div>				            			
				            		</div>
				            	</td>
				            </tr>
			            </table>
            		</td>
            		<td valign="top">
            		  <table cellpadding="0" cellspacing="0">
            		  <tr>
            		  <td>
            		    <div class="div_Message_gray">
	                        <div class="div_top_left_common_gray">                          
	                        </div>
	                        <div class="div_top_center_common_gray">
	                            <div class="div_top_img"><img src="image/home/ico_tool.png" alt="Công cụ truy cập nhanh" /></div>                          
	                            <div class="div_top_title">CÔNG CỤ TRUY CẬP NHANH</div> 
	                            </div>
	                            <div class="div_top_content_common_template">
	                            <div style="padding: 6px 0 6px 0;">
	                            <a href="preventlistview2.do" style="margin: 10px 20px 20px 20px;text-decoration: none; color:#666666;">
	                            <img style="vertical-align: middle;" src="image/home/preventsearch.png" alt="Tra cứu" /> <b>TRA CỨU THÔNG TIN NGĂN CHẶN</b>
	                            </a>
	                            </div>
	                            <div style="border-top: 0.5px dotted #CCCCCC;"/>
                                <% if(context.isContractManagement()) {%>                
	                            <div style="padding: 6px 0 6px 0;">
	                            <a href="contractregistview.do" style="margin: 10px 20px 20px 20px;text-decoration: none; color:#666666;">
	                            <img style="vertical-align: middle;" src="image/home/preventregist.png" alt="Thêm mới" /> <b>NHẬP MỚI HỢP ĐỒNG CÔNG CHỨNG</b>
	                            </a>
	                            </div>
	                            <div style="border-top: 0.5px dotted #CCCCCC;"/>
	                            <% } %>
	                            
	                            <div style="padding: 6px 0 6px 0;"> 
                                    <a style="margin-left: 20px;text-decoration: none; color:#666666;" href="documentlistview.do">
                                     <img alt="Tài liệu" src="image/home/icon_share.png" style="vertical-align: middle;"/> <b>TÀI LIỆU NỘI BỘ</b> 
                                    </a>
                                </div>  
	                        </div> 
                        </div>
                        </td>
                        </tr>
                        <tr>
                        <td>
		                	<div class="div_Message_gray">
		                		<div class="div_top_left_common_gray">                			
		                		</div>
		                		<div class="div_top_center_common_gray">
		                			<div class="div_top_img"><img src="image/home/ico_temp.png" alt="Hợp đồng mẫu" /></div>                			 
		                			<div class="div_top_title">DANH SÁCH HỢP ĐỒNG MẪU</div> 
		                		</div>
		                		<div class="div_top_content_common_template">
		                			<div class="div_select_template">
			                			<html:select styleId="contractKindId" property="contractKindId" styleClass="select_template" onchange="javascript:getContent(this.value)">
			                					<html:optionsCollection name="homeViewHelper" property="lstContractKindTreeNode" label="name" value="id"/>
			                			</html:select>
		                			</div>
		                			<div id="template_contract_content" class="div_select_template_contract">	                				
		                			</div> 
		                		</div> 
		                	</div>
	                	</td>
	                	</tr>
	                	</table>          
	                </td>
            	</tr>            	
            </table>
            <logic:notEmpty name="homeViewHelper" property="announcementInfo">
	            <div id="popupContact" style="width: 730px;height:450px">
	              <a id="popupContactClose">x</a>       
	              <br></br>       
	              <bean:define id="item_announcement" name="homeViewHelper" property="announcementInfo" type="com.osp.npo.core.announcement.AnnouncementInfo">
	              </bean:define>    
	              <div>
	              	<table width="100%" style="margin-top:-40px">
	              		<tr>
	              			<td > 
	              			<logic:equal value="1" name="item_announcement" property="kind">
			           		<span style="font-size:7pt">Thông báo của Sở Tư pháp</span>
			           		</logic:equal><br></br>
	              			<b><bean:write name="item_announcement"  property="title"/></b>
	              			</td>
	                    	<td width="20%" style="text-align: right;font-size:7pt"><br></br>Người gửi: <bean:write name="item_announcement"  property="senderInfo"/></td>
	                    	<td width="20%" style="text-align: right;font-size:7pt"><br></br>Ngày gửi: <bean:write name="item_announcement"  property="sendDateTime" format="dd/MM/yyyy HH:mm"/></td>
	                    </tr>
	                </table>
	            </div>    
	               <hr style="clear:both"></hr>    
	              <div id="contactArea" style="line-height: 1.8;">                 
	                 <br/>
	                 <div style="padding-left: 30px; ">
	                     <bean:write name="item_announcement"  property="content" filter="false"/>
	                     <br/>
	                     <logic:notEmpty name="item_announcement" property="attachFileName"> 
		                	<bean:define id="fileName" name="item_announcement" property="attachFileName" type="java.lang.String"/>
	                           <%@ include file="/jsp/common/common_function.jsp" %>
	                           <img src="<%=getIcon(fileName)%>" />
	                		<html:link href="javascript:downloadFile();">
		                        <bean:write name="item_announcement" property="attachFileName"/>
		                    </html:link>
	                 	 </logic:notEmpty>
	                 </div>
	                 <br/>                 
	              </div>
	            </div>
			</logic:notEmpty>
        <div id="backgroundPopup"></div>
        </html:form>
    <%@ include file="/jsp/common/footer.jsp"%>
</html:html>
<script type="text/javascript">
    // highlight home tab.
    $('#home > em').removeClass("home-off");
    $('#home > em').addClass("home-on");
    $('#home > b').addClass("menu-on");

    $(".node_folder").click(function() {
        $('.node_selected').removeClass('node_selected');
        $(this).addClass('node_selected');
    });


    function toogle_view(div_child) {
        $("#" + div_child).toggle();
    }

    clearContent();
    
    function clearContent() {
        var selectId = $("#contractKindId").val();
        getContent(selectId)
    }

    $(".tree_icon").click(function() {
        $(this).toggleClass('tree_close');
        $(this).toggleClass('tree_open');
    });
 	
    var req;
    var myTitle;
    function getContent(id) {
    	if (id != null ) {
	        var url = 'ajaxGetContractTemplates.do?contractid=' + id;        
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
	            req.send();
	            }
	        }
    	} else {
    		return true;
		}
    }
    function processStateChange() {
        if (req.readyState == 4) { // Complete
            if (req.status == 200) { // OK response
                $('#template_contract_content').html("");
                $('#template_contract_content').html(req.responseText);
                // document.getElementById("folder_content").innerHTML = req.responseText;
                } else {
                    alert("Problem: " + req.statusText);
                }
        }
    }

    var req1;
    function download(template_id) {
        var url = 'downloadTemplate.do?template_id=' + template_id;
        document.homeForm.action=url;
        if (window.XMLHttpRequest) { // Non-IE browsers
            req1 = new XMLHttpRequest();
            req1.onreadystatechange = getFile;
            try {
                req1.open("GET", url, true);
                req1.setRequestHeader("If-Modified-Since", "Sat, 1 Jan 2000 00:00:00 GMT");
            } catch (e) {
                alert(e);
            }
            req1.send(null);
        } else if (window.ActiveXObject) { // IE
            req1 = new ActiveXObject("Microsoft.XMLHTTP");
            if (req) {
            req1.onreadystatechange = getFile;
            req1.open("GET", url, true);
            req1.send();
            }
        }
    }

    function getFile() {
        if (req1.readyState == 4) { // Complete
            if (req1.status == 200) { // OK response
                var rt = "";
                rt = req1.getResponseHeader("Content-Type");
                if (rt == "text/html;charset=utf-8") {
                    alert('<bean:message key="err_file_not_exist"/>');
                } else {
                    document.homeForm.submit();
                }
            } else {
                alert("Problem: " + req1.statusText);
            }
        }
    }
    
    function downloadFile() {
		document.homeForm.action = "popupannouncfiledownload.do";
		document.homeForm.submit();

	}
    <logic:greaterThan value="4" name="homeViewHelper" property="personCount">    
    function init_dw_Scroll() {
        var wndo = new dw_scrollObj('wn', 'lyr1');
        wndo.setUpScrollControls('scrollLinks');
    }

    // if code supported, link in the style sheet and call the init function onload
    if ( dw_scrollObj.isSupported() ) {
        //dw_Util.writeStyleSheet('css/scroll.css');
        dw_Event.add( window, 'load', init_dw_Scroll);
    }    
    </logic:greaterThan>
    
    <logic:equal name="homeViewHelper" property="isShowPopup" value="true">
      //LOADING POPUP
      //Click the button event!
      //centering with css
      centerPopup();
      //load popup
      loadPopup();


      //CLOSING POPUP
      //Click the x event!
      $("#popupContactClose").click(function(){
          disablePopup();
      });
      //Click out event!
      $("#backgroundPopup").click(function(){
          disablePopup();
      });
      //Press Escape event!
      $(document).keypress(function(e){
          if(e.keyCode==27 && popupStatus==1){
              disablePopup();
          }
      });
    </logic:equal>

</script>