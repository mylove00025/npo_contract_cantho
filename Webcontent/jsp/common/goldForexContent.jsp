<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" errorPage="" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<script type="text/javascript" language="JavaScript" src="./javascript/Forex_Content.js"></Script>
<script type="text/javascript" language="javascript" src="http://vnexpress.net/Service/Forex_Content.js"></script>
<script type="text/javascript" language="JavaScript" src="./javascript/Gold_Content.js"></Script>
<script type="text/javascript" language="JavaScript" src="http://vnexpress.net/Service/Gold_Content.js"></Script>

<!-- Gold -->
<div class="sub-title">
    <span>◊ GIÁ VÀNG</span>
</div>
<div style="float: right;">(đv: tr.đ/lượng)</div>
<table class="tbl-gold-price tbl-list" style="margin: 5px auto;">
    <tr>
        <th style="background-color: #D8D8D8; color: #000000">Loại</th>
        <th style="background-color: #D8D8D8; color: #000000">Mua</th>
        <th style="background-color: #D8D8D8; color: #000000">Bán</th>
    </tr>
    <tr>
        <td style="background-color: #FFFFFF;">Sbj</td>
        <td style="background-color: #FFFFFF;"><script>document.write(vGoldSbjBuy);</script></td>
        <td style="background-color: #FFFFFF;"><script>document.write(vGoldSbjSell);</script></td>
    </tr>
    <tr>
        <td style="background-color: #FFFFFF;">Sjc</td>
        <td style="background-color: #FFFFFF;"><script>document.write(vGoldSjcBuy);</script></td>
        <td style="background-color: #FFFFFF;"><script>document.write(vGoldSjcSell);</script></td>
    </tr>
</table>
(Nguồn: <a href="http://www.sacombank-sbj.com" target="_blank"><img height="14" width="80" alt="" src="image/logoSb.gif" /></a>)

<br />
<br />
<br />
<!-- Forex -->
<div class="sub-title">
    <span>◊ GIÁ NGOẠI TỆ</span>
</div>
<div style="margin:5px auto; height: 101px; overflow: auto; ">
<table class="tbl-list" style="margin: 0px auto;">
    <tr>
        <th style="background-color: #D8D8D8; color: #000000">Ngoại tệ</th>
        <th style="background-color: #D8D8D8; color: #000000">Quy đổi</th>
    </tr>
    <% for(int i= 0; i < 10; i++) { %>
    <tr class="tbl-row<%=i % 2%>" style="width: 120px;">
        <td class="boder_cell">
            <script>document.write(vForexs[<%=i%>]);</script>
        </td>
        <td class="boder_cell" style="text-align: center;">
            <script>document.write(vCosts[<%=i%>]);</script>
        </td>
    <tr>
    <% } %>
</table>
</div>
(Nguồn: <a href="http://www.eximbank.com.vn" target="_blank"><img height="9" width="80" alt="" src="image/logo-EXIM.gif" /></a>)