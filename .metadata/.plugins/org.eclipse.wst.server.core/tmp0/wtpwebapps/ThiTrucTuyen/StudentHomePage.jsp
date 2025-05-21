<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-4">
		<nav class="nav mb-3">
			<a class="nav-link active" href="#">Trang chủ</a> <a class="nav-link"
				href="loadExamHS">Vào thi</a> <a class="nav-link"
				href="loadResultHS">Quản lý hồ sơ cá nhân</a> <a
				class="nav-link text-danger" href="formdangnhap.jsp">Đăng xuất</a>
		</nav>
		<h2>Trang chủ của học sinh</h2>
		<p>
			<strong>Mã HS:</strong> ${hs.maHS}
		</p>
		<p>
			<strong>Tên HS:</strong> ${hs.tenHS}
		</p>
		<p>
			<strong>Giới tính:</strong> ${hs.gioiTinh == false ? 'Nam' : 'Nữ'}
		</p>
		<p>
			<strong>Ngày sinh:</strong> ${hs.ngaySinh}
		</p>
		<p>
			<strong>Lớp:</strong> ${hs.lop}
		</p>
	</div>
</body>
</html>