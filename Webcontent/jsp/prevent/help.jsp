<%@ page contentType="text/html; charset=UTF-8" language="java"
	pageEncoding="UTF-8" errorPage=""%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html:html>
<%@ include file="/jsp/common/header.jsp"%>
<div class="fieldset_content_info_message">
		           		<div class="div_field_top_message">				            				
		           			<div class="div_field_top_left_message"></div>
		           			<div class="div_field_top_center_message"></div>
		           		</div>	
		           		<div class="div_field_midde_message">		
		           			<div class="div_field_midde_center_message">
		           				<div class="div_all_content_contract_message" style="min-height: 250px;">
		           				<div>
<table width="100%">
<tr>
<td>
<p style="text-align: center;"><b style="font-size: 15px;">THỦ THUẬT TÌM KIẾM VỚI UCHI</b></p>

<p>Người dùng có thể nhập bất kỳ thông tin gì vào ô tìm kiếm, Kết quả sẽ bao gồm các dữ liệu: Chứa đầy đủ các từ nhập vào, không phân biệt thứ tự giữa các từ, không phân biệt chữ hoa, chữ thường, không phân biệt dấu. Dữ liệu tìm ra có thể nhiều, để tìm kiếm hiệu quả nên sử dụng các thủ thuật sau:</p>

<h1>1. Tìm kiếm chính xác theo một cụm từ</h1>

<p>Muốn tìm kiếm chính xác một cụm từ, nhập cụm từ cần tìm trong dấu nháy kép <b>“”</b>. Ví dụ muốn tìm kiếm dữ liệu chứa chính xác cụm từ <b>Lê Thanh Nghị,</b> nhập vào <b>“Lê Thanh Nghị”</b>. Nếu không để trong nháy kép thì các dữ liệu có chứa cả 3 từ trên cũng sẽ được tìm kiếm ra. Ví dụ dữ liệu có chứa <b style="color:red">Lê Thanh</b><b> Mai</b> và <b>Nguyễn Văn</b><b style="color: red"> Nghị</b> cũng sẽ được tìm ra.</p>

<h1>2. Tìm kiếm kết hợp nhiều điều kiện</h1>

<p>Càng biết nhiều thông tin tìm kiếm thì phạm vi tìm kiếm càng được giới hạn, kết quả tìm kiếm càng sát với mong muốn. </p>

<p>- Nếu biết địa chị cụ thể, ví dụ ở <b>115 Lê Thanh Nghị, Hai Bà Trưng</b>, người dùng nhập vào <b>115 “Lê Thanh Nghị” “Hai Bà Trưng”</b>. Tại sao không nhập <b>“115 Lê Thanh Nghị” “Hai Bà Trưng”</b>? Vì như vậy những dữ liệu chứa <b>115 đường (phường,….) Lê Thanh Nghị</b> sẽ không ra.</p>

<p>- Nếu biết thêm số tờ bản đồ, số thửa, ví dụ <b>115 Lê Thanh Nghị, tờ 03 thửa 12</b>. Nhập vào <b>115 “Lê Thanh Nghị” tờ 03 thửa 12</b>. Tại sao không nên nhập <b>115 “Lê Thanh Nghị” tờ</b><b style="color: red;"> bản đồ</b> <b>số 03 thửa</b><b style="color: red"> đất số</b> 12</b>? Vì như vậy các dữ liệu chỉ chứa <b>tờ 03 hoặc tờ số 03, thửa số 12,…</b> sẽ không được tìm ra.</p>

<p>- Nếu biết thêm thông tin về bên tham gia giao dịch hoặc chủ sở hữu tài sản, muốn giới hạn kết quả hơn nữa, có thể nhập vào: <b>115 “Lê Thanh Nghị” tờ 03 thửa 12 “Lê Thanh Mai”</b> trong đó<b> Lê Thanh Mai</b> là tên bên giao dịch. Nếu người dùng sử dụng tìm kiếm nâng cao thì thông tin “<b>Lê Thanh Mai”</b> sẽ nhập vào ô Bên Liên Quan/ chủ sở hữu, còn thông tin tài sản nhập vào ô Thông tin tài sản.</p>

<p style="text-align:center;"><img style="border: blue solid 1px" src="./image/search_skill.png"></img></p>	

<p>- Nếu biết người dùng có thể nhập thêm thông tin số giấy chứng nhận. Chỉ cần nhập phần giá trị, không cần nhập cụm từ <b>Số giấy chứng nhận</b>.</p>

<p><b style="color: red">Lưu ý</b>: Một số đơn vị sử dụng các phần mềm cũ, không nhập vào số giấy chứng nhận, nên việc tìm theo số giấy chứng nhận có thể sót dữ liệu.</p>

<h1>3. Tìm kiếm mở rộng</h1>

<p>Sử dụng dấu <b>* </b>để tìm kiếm mở rộng về phía trái, phải hoặc cả 2 bên</p>

<p>- Nếu nhập <b>*3</b>, kết quả tìm kiếm sẽ bao gồm những dữ liệu chứa số <b>3</b> ở cuối từ, ví dụ <b>12</b><b style="color: red;">3</b>.</p>

<p>- Nếu nhập <b>*3*,</b> kết quả tìm kiếm sẽ bao gồm những dữ liệu có chứa số <b>3</b>, ví dụ <b>12</b><b style="color: red;">3</b><b>45</b></p>
</td>
</tr>
</table>
</div>
</div>
</div>
</div>
<div class="div_field_bottom_message">				            				
		           			<div class="div_field_bottom_left_message"></div>
		           			<div class="div_field_bottom_center_message"></div>
		           		</div>	
</div>
<br/>
<%@ include file="/jsp/common/footer.jsp"%>
</html:html>