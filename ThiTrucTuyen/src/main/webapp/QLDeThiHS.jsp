<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vào thi</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-4">
    <nav class="nav mb-3">
        <a class="nav-link" href="StudentHomePage.jsp">Trang chủ</a>
        <a class="nav-link active" href="#">Vào thi</a>
        <a class="nav-link" href="loadResultHS">Quản lý hồ sơ cá nhân</a>
        <a class="nav-link text-danger" href="formdangnhap.jsp">Đăng xuất</a>
    </nav>
    <p class="text-danger fw-bold">${notification}</p>
    <table class="table table-bordered table-hover">
        <thead class="table-dark">
            <tr>
                <th>Mã đề</th>
                <th>Tên đề</th>
                <th>Thời gian làm bài</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="dt" items="${listDT}">
            <tr>
                <td>${dt.maDT}</td>
                <td>${dt.tenDT}</td>
                <td>${dt.thoiGianLamBai}</td>
                <td><a href="check?madt=${dt.maDT}&thoigian=${dt.thoiGianLamBai}" class="btn btn-sm btn-primary">Thi</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

		
</body>
</html>