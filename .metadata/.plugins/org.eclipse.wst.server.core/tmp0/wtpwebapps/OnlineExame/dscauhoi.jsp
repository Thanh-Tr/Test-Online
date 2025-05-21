<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.CauHoi" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách câu hỏi</title>
</head>
<body>
<h2>Danh sách câu hỏi</h2>
<table border="1">
    <tr>
        <th>Nội dung</th>
        <th>A</th><th>B</th><th>C</th><th>D</th><th>Đáp án đúng</th>
        <th>Hành động</th>
    </tr>
    <%
        List<CauHoi> ds = (List<CauHoi>) request.getAttribute("list");
        for(CauHoi ch : ds) {
    %>
    <tr>
        <td><%= ch.getMoTaCH() %></td>
        <td><%= ch.getCauA() %></td>
        <td><%= ch.getCauB() %></td>
        <td><%= ch.getCauC() %></td>
        <td><%= ch.getCauD() %></td>
        <td><%= ch.getDapAn() %></td>
        <td><a href="cauhoi?action=delete&id=<%=ch.getMaCH()%>">Xóa</a></td>
    </tr>
    <% } %>
</table>

<h3>Thêm câu hỏi</h3>
<form method="post" action="cauhoi">
    Nội dung: <input type="text" name="noidung"><br>
    A: <input type="text" name="a"><br>
    B: <input type="text" name="b"><br>
    C: <input type="text" name="c"><br>
    D: <input type="text" name="d"><br>
    Đáp án đúng: <input type="text" name="dapan"><br>
    <input type="submit" value="Thêm">
</form>
</body>
</html>
