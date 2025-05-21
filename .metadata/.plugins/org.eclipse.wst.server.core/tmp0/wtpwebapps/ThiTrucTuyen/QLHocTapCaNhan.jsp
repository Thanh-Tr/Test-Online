<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý học tập cá nhân</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-4">
    <nav class="nav mb-3">
        <a class="nav-link" href="StudentHomePage.jsp">Trang chủ</a>
        <a class="nav-link" href="loadExamHS">Vào thi</a>
        <a class="nav-link active" href="#">Quản lý hồ sơ cá nhân</a>
        <a class="nav-link text-danger" href="formdangnhap.jsp">Đăng xuất</a>
    </nav>
    <h2>Quản lý học tập cá nhân</h2>
    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>Mã HS</th>
                <th>Tên HS</th>
                <th>Mã đề</th>
                <th>Điểm</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="kq" items="${listKQHS}">
            <tr>
                <td>${kq.maHS}</td>
                <td>${hs.tenHS}</td>
                <td>${kq.maDT}</td>
                <td>
                    <fmt:formatNumber value="${(kq.soCauDung * 10.0) / kq.tongSoCau}" type="number" maxFractionDigits="2" />
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>