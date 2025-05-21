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
				href="loadStudent">Quản lý học sinh</a> <a class="nav-link"
				href="loadExam">Quản lý đề thi</a> <a class="nav-link"
				href="loadResult">Quản lý hồ sơ học tập</a> <a
				class="nav-link text-danger" href="formdangnhap.jsp">Đăng xuất</a>
		</nav>
		<h2>Trang chủ của giáo viên</h2>
		<p>
			<strong>Mã GV:</strong> ${gv.maGV}
		</p>
		<p>
			<strong>Tên GV:</strong> ${gv.tenGV}
		</p>
		<p>
			<strong>Giới tính:</strong> ${gv.gioiTinh == false ? 'Nam' : 'Nữ'}
		</p>
		<p>
			<strong>Ngày sinh:</strong> ${gv.ngaySinh}
		</p>
		<p>
			<strong>Số điện thoại:</strong> ${gv.sdt}
		</p>
		<p>
			<strong>Email:</strong> ${gv.email}
		</p>
	</div>
</body>
</html>