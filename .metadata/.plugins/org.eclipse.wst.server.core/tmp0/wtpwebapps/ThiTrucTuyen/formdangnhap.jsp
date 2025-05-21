<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div
		class="container d-flex justify-content-center align-items-center vh-100">
		<div class="card p-4 shadow-sm" style="width: 350px;">
			<h4 class="text-center mb-4">Đăng nhập hệ thống</h4>
			<form method="post" action="login">
				<div class="mb-3">
					<label class="form-label">Tên đăng nhập</label> <input type="text"
						name="user" value="${user}" class="form-control" required>
				</div>
				<div class="mb-3">
					<label class="form-label">Mật khẩu</label> <input type="password"
						name="pass" class="form-control" required>
				</div>
				<button type="submit" class="btn btn-primary w-100">Đăng
					nhập</button>
				<div class="text-danger mt-2 text-center">${notification}</div>
			</form>
		</div>
	</div>
</body>
</html>