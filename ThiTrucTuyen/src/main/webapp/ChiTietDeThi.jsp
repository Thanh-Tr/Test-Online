<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết đề thi</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<h2 class="text-center mt-4">Chi tiết đề ${madt}</h2>
	<div class="container">
		<a href="loadExam" class="btn btn-secondary mb-3">Quay lại</a>
		<c:forEach var="ch" items="${listCH}">
			<div class="border rounded p-3 mb-4">
				<h5 class="mb-3">Câu ${ch.maCH}</h5>
				<p>
					<strong>Nội dung:</strong> ${ch.moTaCH}
				</p>
				<ul class="list-group">
					<li class="list-group-item">Câu A: ${ch.cauA}</li>
					<li class="list-group-item">Câu B: ${ch.cauB}</li>
					<li class="list-group-item">Câu C: ${ch.cauC}</li>
					<li class="list-group-item">Câu D: ${ch.cauD}</li>
				</ul>
				<p class="mt-2">
					<strong>Đáp án đúng:</strong> ${ch.dapAn}
				</p>
				<a href="updateQuestion?mach=${ch.maCH}&madt=${madt}"
					class="btn btn-sm btn-warning">Sửa</a>
			</div>
		</c:forEach>
	</div>
</body>
</html>