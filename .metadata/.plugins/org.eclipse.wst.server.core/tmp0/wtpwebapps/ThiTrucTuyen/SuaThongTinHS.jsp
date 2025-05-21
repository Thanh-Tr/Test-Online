<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa thông tin học sinh</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<h2 class="text-center mt-4">Sửa thông tin học sinh</h2>
	<form method="post" action="updateStudent" class="w-50 mx-auto">
		<input type="hidden" name="mahs" value="${hs.maHS}">
		<div class="mb-3">
			<label class="form-label">Tên HS</label> <input type="text"
				name="tenhs" value="${hs.tenHS}" class="form-control" required>
		</div>
		<div class="mb-3">
			<label class="form-label">Giới tính</label> <select name="gioitinh"
				class="form-select">
				<option value="false" ${hs.gioiTinh == false ? 'selected' : ''}>Nam</option>
				<option value="true" ${hs.gioiTinh == true ? 'selected' : ''}>Nữ</option>
			</select>
		</div>
		<div class="mb-3">
			<label class="form-label">Ngày sinh</label> <input type="text"
				name="ngaysinh" value="${hs.ngaySinh}" class="form-control" required>
		</div>
		<div class="mb-3">
			<label class="form-label">Lớp</label> <input type="text" name="lop"
				value="${hs.lop}" class="form-control" required>
		</div>
		<button type="submit" class="btn btn-primary">Cập nhật</button>
		<a href="loadStudent" class="btn btn-secondary">Quay lại</a>
	</form>
</body>
</html>