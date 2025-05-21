<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sửa câu hỏi</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	
	<h2 class="text-center mt-4">Sửa câu hỏi</h2>
	<div class="container">
		<form method="post" action="updateQuestion" class="w-75 mx-auto">
			<input type="hidden" name="mach" value="${ch.maCH}">
			<div class="mb-3">
				<label class="form-label">Câu ${ch.maCH}:</label>
				<textarea name="motach" class="form-control" required>${ch.moTaCH}</textarea>
			</div>
			<div class="row">
				<div class="col-md-6 mb-3">
					<label class="form-label">Câu A:</label> <input type="text"
						name="cau_a" value="${ch.cauA}" class="form-control" required>
				</div>
				<div class="col-md-6 mb-3">
					<label class="form-label">Câu B:</label> <input type="text"
						name="cau_b" value="${ch.cauB}" class="form-control" required>
				</div>
				<div class="col-md-6 mb-3">
					<label class="form-label">Câu C:</label> <input type="text"
						name="cau_c" value="${ch.cauC}" class="form-control" required>
				</div>
				<div class="col-md-6 mb-3">
					<label class="form-label">Câu D:</label> <input type="text"
						name="cau_d" value="${ch.cauD}" class="form-control" required>
				</div>
			</div>
			<div class="mb-3">
				<label class="form-label">Đáp án đúng:</label> <select
					name="caudung" class="form-select" required>
					<option value="A" ${ch.dapAn == 'A' ? 'selected' : ''}>A</option>
					<option value="B" ${ch.dapAn == 'B' ? 'selected' : ''}>B</option>
					<option value="C" ${ch.dapAn == 'C' ? 'selected' : ''}>C</option>
					<option value="D" ${ch.dapAn == 'D' ? 'selected' : ''}>D</option>
				</select>
			</div>
			<input type="hidden" name="madt" value="${ch.maDT}">
			<div class="d-flex justify-content-between">
				<button type="submit" class="btn btn-primary">Hoàn tất</button>
			</div>
		</form>
	</div>

</body>
</html>