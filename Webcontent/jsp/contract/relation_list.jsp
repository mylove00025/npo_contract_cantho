<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
    
    
    <html:form style="position: absolute; left:685px;top:310px;" styleId="form" style="background-color: white;" >
       
        <logic:notEmpty name="customerListViewHelper" property="customerList">
            <table id="customerList" class="tbl-list" style="-moz-box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.5); background-color: #FFFFFF; border: 1px solid #999999; border-top: none; display: block; left: 751px; top: -1px; visibility: visible;text-align: center;" >
            <html:img styleId="sharp1" style=" position: absolute; left:671px; margin-top: 5px" alt="*" src="./image/icon_sharp2.png"/>
              <html:img styleId="sharp2" style=" position: absolute; left:-16px; margin-top: 5px" alt="*" src="./image/icon_sharp2.png"/>
              
                <logic:iterate id="selectObject" name="customerListViewHelper" property="customerList" indexId="i">
                    <tr onmouseover="style.backgroundColor='#D6D5D9';" onmouseout="style.backgroundColor='#FFFFFF'" class="tbl-row<%=i % 2%>>" style="width: 100%;  border-bottom: none; border-top:none">                       
                        <td  class="onmouseover" onmouseover="" style="cursor: pointer;text-align: left;border-top: 1px solid #999999; border-right: none; border-left: none; min-width: 50px ">
                       		<span  id="selectObject<%=i %>"  onclick="getRelation(<%=i %>);"><bean:write  name="selectObject" property="customerInfoDisp" filter="false"/></span>
                       		<textarea id="customerinfo<%=i %>" style="display: none; "><bean:write  name="selectObject" property="customerInfo"/></textarea>
                        </td>
                       <td style="text-align: right;border-top: 1px solid #999999; font-size: 7pt; color: #B45133; border-right: none; border-left: none; "><bean:write name="selectObject" property="frequency" format="#,###,###"></bean:write></td>
                    </tr>  
                   
                </logic:iterate>
        
            <logic:greaterThan name="customerListViewHelper" property="totalPage" value="1">
                <tr>
                    <td style="border:none">
            <div class="pager" style="border:none; background-color: white; width: 48px; height: 10px;text-align: center;margin: 0 auto;">
        
                <div style="margin:0 auto;">
                    <logic:greaterThan name="customerListViewHelper" property="totalPage" value="1">
	                  
	                    <html:link href="javascript:direction('ahead')">
	                        <img style= "padding: 0 1px 0 5px" class="pager-prev" src="./image/prev.png" alt= "prev"/>
                    </html:link>
                    <span>|</span>
                    </logic:greaterThan>
                    
                    <logic:greaterThan name="customerListViewHelper" property="totalPage" value="1">
	                    <html:link href="javascript:direction('next')">
	                        <img style= "padding: 0 5px 0 1px" class="pager-next" src="./image/next.png" alt= "next"/>
	                    </html:link>
	                    
                    </logic:greaterThan>
                </div>
            </div>
                </td>
                <td style="border: none;"></td>
            </tr>
            </logic:greaterThan>
            <html:hidden property="direction"/>
       
           </table>
           
        </logic:notEmpty>
    </html:form>
  
</html:html>

<script type="text/javascript">

highlightWhenSearch();
var check;
var check2="";
check2=navigator.appName;
check3=navigator.appVersion;
if (check2=="Netscape") {
	if (check3=="5.0 (Windows; vi)") {
	 check=1;
	} else check=3;
} else {
	 check=2;
}
if (check==1) {
	if (relationObject==1){
	 document.getElementById('relationobjectlist1').querySelector("#sharp1").style.display="";
	 document.getElementById('relationobjectlist1').querySelector("#sharp2").style.display="none";
	} else if (relationObject==2){
		document.getElementById('relationobjectlist2').querySelector("#sharp1").style.display="";
		document.getElementById('relationobjectlist2').querySelector("#sharp2").style.display="none";
	} else {
		document.getElementById('relationobjectlist3').querySelector("#sharp1").style.display="";
		document.getElementById('relationobjectlist3').querySelector("#sharp2").style.display="none";
	}
} else if (check==2) {
	if (relationObject==1){
		 document.getElementById('relationobjectlist1').querySelector("#sharp2").style.display="";
		 document.getElementById('relationobjectlist1').querySelector("#sharp1").style.display="none";
		} else if (relationObject==2){
			document.getElementById('relationobjectlist2').querySelector("#sharp2").style.display="";
			document.getElementById('relationobjectlist2').querySelector("#sharp1").style.display="none";
		} else {
			document.getElementById('relationobjectlist3').querySelector("#sharp2").style.display="";
			document.getElementById('relationobjectlist3').querySelector("#sharp1").style.display="none";
		}
} else {
	if (relationObject==1){
		 document.getElementById('relationobjectlist1').querySelector("#sharp1").style.display="none";
		 document.getElementById('relationobjectlist1').querySelector("#sharp2").style.display="";
		} else if (relationObject==2){
			$('#relationobjectlist2 #sharp1').hide();
			$('#relationobjectlist2 #sharp2').show();
			
		} else {
			document.getElementById('relationobjectlist3').querySelector("#sharp1").style.display="none";
			document.getElementById('relationobjectlist3').querySelector("#sharp2").style.display="";
		}
}
function highlightWhenSearch() {
    
    //var searchString = getSearchString();
    if (relationObject==1) {
    var searchString = $('#keyHighLight1').val();
    var textContainerNode = document.getElementById("relationobjectlist1");
    } else if (relationObject==2){
    	var searchString = $('#keyHighLight2').val();
    	var textContainerNode = document.getElementById("relationobjectlist2");
    } else {
    	var searchString = $('#keyHighLight3').val();
    var textContainerNode = document.getElementById("relationobjectlist3");
    } 
    if (searchString != "") {
        // Starting node, parent to all nodes you want to search
//        var textContainerNode = document.getElementById("customerListContent");
        
        if (textContainerNode != null) {
            // Split search terms on '|' and iterate over resulting array              
            var searchTerms = searchString.split('|');
            for (var i in searchTerms)  {
            	searchTerms[i]=escape(searchTerms[i]);
              // The regex is the secret, it prevents text within tag declarations to be affected
              var regex = new RegExp(">([^<]*)?("+searchTerms[i]+")([^>]*)?<","ig");
              //var regex = searchTerms[i];
             
              var tempinnerHTML = textContainerNode.innerHTML;
              // Do regex replace
              // Inject span with class of 'highlighted termX' for google style highlighting
              if (relationObject==1){
              $('#relationobjectlist1').html(tempinnerHTML.replace(regex,'>$1<b>$2</b>$3<'));
              } else if (relationObject==2) {
            	  $('#relationobjectlist2').html(tempinnerHTML.replace(regex,'>$1<b>$2</b>$3<')); 
              } else $('#relationobjectlist3').html(tempinnerHTML.replace(regex,'>$1<b>$2</b>$3<'));
            }
        }
        
        
    }
}
</script>