
function open_node(nodeId) {
  document.getElementById(nodeId).style.display = "";
}

function close_node(nodeId) {
  document.getElementById(nodeId).style.display = "none";
}

/**
 * change style of submit button
 *
 * @param hide1
 * @param hide2
 * @return
 */
function stylechange(hide1,hide2) {
  document.getElementById(hide1).style.display='inline';
    document.getElementById(hide2).style.display='none';
}


var popupStatus = 0; //0 means disabled; 1 means enabled;

//loading popup with jQuery magic!
function loadPopup(){
  //loads popup only if it is disabled
  if(popupStatus==0){
    $("#backgroundPopup").css({
      "opacity": "0.7"
    });
    $("#backgroundPopup").fadeIn("slow");
    $("#popupContact").fadeIn("slow");
    popupStatus = 1;
  }
}

//disabling popup with jQuery magic!
function disablePopup(){
  //disables popup only if it is enabled
  if(popupStatus==1){
    $("#backgroundPopup").fadeOut("slow");
    $("#popupContact").fadeOut("slow");
    popupStatus = 0;
  }
}

//centering popup
function centerPopup(){
  //request data for centering
  var windowWidth = document.documentElement.clientWidth;
  var windowHeight = document.documentElement.clientHeight;
  var popupHeight = $("#popupContact").height();
  var popupWidth = $("#popupContact").width();
  var scrOfX = 0, scrOfY = 0;
    if( typeof( window.pageYOffset ) == 'number' ) {
      //Netscape compliant
      scrOfY = window.pageYOffset;
      scrOfX = window.pageXOffset;
    } else if( document.body && ( document.body.scrollLeft || document.body.scrollTop ) ) {
      //DOM compliant
      scrOfY = document.body.scrollTop;
      scrOfX = document.body.scrollLeft;
    } else if( document.documentElement && ( document.documentElement.scrollLeft || document.documentElement.scrollTop ) ) {
      //IE6 standards compliant mode
      scrOfY = document.documentElement.scrollTop;
      scrOfX = document.documentElement.scrollLeft;
    }

  //centering
  $("#popupContact").css({
    "position": "absolute",
    "top": scrOfY + windowHeight/2-popupHeight/2,
    "left": scrOfX + windowWidth/2-popupWidth/2
  });
  //only need force for IE6

  $("#backgroundPopup").css({
    "height": windowHeight
  });

}

/**
 * Add object into option
 *
 * @param selectbox Selectbox object
 * @param text text of object
 * @param value value of object
 */
function addOption(selectbox,text,value ) {
    var optn = document.createElement("OPTION");
    optn.text = text;
    optn.value = value;
    selectbox.options.add(optn);
}

/**
 * Change value of selectbox of idDesc when onchange event from selectbox parent
 * @param idSrc id selecbox parent
 * @param idDesc selectbox child
 * @param isRequred field is required, 0: not required, 1: required
 */
function change(idSrc, idDesc, isRequredAll) {
    var selSrc = document.getElementById(idSrc);
    var selDesc = document.getElementById(idDesc);
    var i;
    if(!selSrc || !selDesc || typeof selSrc == "undefined" || typeof selDesc == "undefined") {
        return;
    }
    for(i = selDesc.options.length-1; i >= 0 ; i--) {
        selDesc.remove(i);
    }

    if (isRequredAll == 0 || aryDesc.length == 0) {
        addOption(selDesc, "[Chọn]", "0");
    }

    for (var i = 0; i < aryDesc.length; i++) {
        if (aryDesc[i][0] == selSrc.options[selSrc.selectedIndex].value) {
            addOption(selDesc, aryDesc[i][2], aryDesc[i][1] );
            selSrc.value = selSrc.options[selSrc.selectedIndex].value;
        }
    }
}

function contentSumary(content, id) {
  var maxlength = 150;
  var index = maxlength - 3;
  if ( maxlength + 20 > content.length)
  {
    document.write(content);
  } else {
    while (index < content.length && content.charAt(index) != ' ') { index++; }
    var dotcontinue = '<span id="' + id + '_dot" class="dot_contitnue">&nbsp;...&nbsp&nbsp</span>';
    var detailIcon = '<a id="' + id +'_a_detail" class="content_detail" title="Chi tiết" href="javascript: show_detail(\'' + id + '\');"><img src="./image/add8x8.png"></img></a>';
    var contentHide = '<span id="' + id + '_content" class="content_left">' + content.substring(index) + '&nbsp;</span>';
    var miniItem = '<a id="' + id +'_a_minimal" class="content_minimal" title="Thu gọn" href="javascript: hide_detail(\'' + id + '\');"><img src="./image/sub8x8.png"></a>';
    document.write(content.substring(0, index) + dotcontinue + detailIcon + contentHide + miniItem);
  }
}

function show_detail(id) {
  $('#' + id + '_dot').hide();
  $('#' + id + '_a_detail').hide();
  $('#' + id + '_content').show();
  $('#' + id + '_a_minimal').show();
}

function hide_detail(id) {
  $('#' + id + "_dot").show();
  $('#' + id + "_a_detail").show();
  $('#' + id + "_content").hide();
  $('#' + id + "_a_minimal").hide();
}

function onchangeSelect(id,value){
	var m_select = $('#' + id + ':first').val();
    if(m_select==value) {
    	$('#' + id).css("color","#C2C2C2");
       	$('#' + id + ' option:gt(0)').css("color", "Black");    	
    }
    else
    {   
    	$('#' + id).css("color", "Black");
       	$('#' + id + ' option:first').css("color", "#C2C2C2");       	
    }
}

function writeContent(output) {
	var index = output.indexOf("&lt;br/&gt;");
    while(index != -1){
    	output = output.replace("&lt;br/&gt;", "<br/>");
    	index = output.indexOf("&lt;br/&gt;");
    }
    return output;
}

function removeSign(str) {
	 str= str.toLowerCase(); 
	 str= str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g,"a");
	 str= str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g,"e");  
	 str= str.replace(/ì|í|ị|ỉ|ĩ/g,"i");
	 str= str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g,"o"); 
	 str= str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g,"u");  
	 str= str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g,"y");  
	 str= str.replace(/đ/g,"d");  
	 str= str.replace(/%/g,"#37;");
	 str= str.replace(/&/g,"#38;");
	 return str;  
}