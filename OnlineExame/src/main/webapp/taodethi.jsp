<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.CauHoi" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý đề thi</title>
</head>
<body>
    <h2>Tạo đề thi mới</h2>
    <form action="taodethi" method="post">
    	Mã đề: <input type="text" name="madt" required>
        Tên đề thi: <input type="text" name="tendt" required><br>
        Thời gian (phút): <input type="number" name="thoiGian" required><br>
        <input type="submit" value="Tạo đề thi">
    </form>
    
    <h2>Chọn câu hỏi cho đề</h2>

<form method="post" action="chon-cau-hoi">
    <input type="hidden" name="madt" value="${param.madt}">
    <table border="1">
        <tr><th>Chọn</th><th>Mã câu hỏi</th><th>Nội dung</th></tr>
        <%
            List<CauHoi> ds = (List<CauHoi>) request.getAttribute("dsCauHoi");
            if (ds != null)
                for (CauHoi ch : ds) {
        %>
        <tr>
            <td><input type="checkbox" name="chon" value="<%= ch.getMaCH() %>"></td>
            <td><%= ch.getMaCH() %></td>
            <td><%= ch.getMoTaCH() %></td>
            <td><%= ch.getCauA() %></td>
            <td><%= ch.getCauB() %></td>
            <td><%= ch.getCauC() %></td>
            <td><%= ch.getCauD() %></td>
            <td><%= ch.getDapAn() %></td>
        </tr>
        <% } %>
    </table>
    <input type="submit" value="Thêm vào danh sách tạm">
</form>

<form method="post" action="hoan-tat-them-cau-hoi">
    <input type="hidden" name="madt" value="${param.madt}">
    <input type="submit" value="Hoàn tất">
</form>

</body>
</html>