<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
    <%@ include file="/jsp/common/header.jsp" %>
    
    <div id="content" class="clearfix">
        <center>
            <div class="common_err_box" style="line-height: 1.8;">
                Cảnh báo: <html:errors />
                <br/>                              
                <div style="padding-left: 120px; color: blue; text-align: left; font-weight: normal;">
                    <span style="color: black; text-align: left; font-weight: normal;">Để sử dụng phiên bản chính thức, xin vui lòng liên hệ:</span>
                    <br/>
                    <br/>  
                    <strong>Công ty Cổ phần Công nghệ phần mềm và Nội dung số OSP</strong>
                    <br/>
                    Địa chỉ: Phòng E3, Tòa nhà Đa Năng, số 96 phố Định Công, Thanh Xuân, Hà Nội
                    <br/>
                    Điện thoại: (04) 3568 2502&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Fax: (04) 3568 2504
                    <br/>
                    Email: <a href="mailto:info@osp.com.vn">info@osp.com.vn</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    Website: <a target="_blank" href="http://www.osp.com.vn">www.osp.com.vn</a>
                    <br/>
                    Hotline: 0907560244 (Mr. Nguyễn Đức Thắng)
                </div>
                <br/>                
            </div>        
        </center>
    </div>
    <%@ include file="/jsp/common/footer.jsp"%>
</html:html>