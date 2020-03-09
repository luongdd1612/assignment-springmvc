<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table {
	border-collapse: collapse;
}

table, td, th {
	border: 1px solid black;
}
</style>
<spring:url value="/resource/bootstrap/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="tieude" /></title>
</head>
<body>
	<div align="center">
		<frm:form modelAttribute="sanpham" action="sanphamProcess"
			method="get">
			<frm:errors path="*" element="ul" />
			<frm:hidden path="iD" />
			<table>
				<tr>
					<td><spring:message code="name" /></td>
					<td><frm:input path="tenSP" id="tensp" /></td>
				</tr>
				<tr>
					<td><spring:message code="prdt" /></td>
					<td><frm:select path="maLoaiPK">
							<c:forEach items="${loaisps}" var="lsp">
								<frm:option value="${lsp.maLoai}">${lsp.maLoai} - ${lsp.tenLoai }</frm:option>
							</c:forEach>
						</frm:select></td>
				</tr>
				<tr>
					<td><spring:message code="gia" /></td>
					<td><frm:input path="gia" id="gia" /></td>
				</tr>
				<tr>
					<td><spring:message code="trangthai" /></td>
					<td><frm:input path="trangThai" id="trangthai" /></td>
				</tr>
				<tr>
					<td><spring:message code="thongtin" /></td>
					<td><frm:input path="thongTin" id="thongtin" /></td>
				</tr>
				<tr>
					<td><spring:message code="anh" /></td>
					<td><frm:input path="anh" id="anh" /></td>
				</tr>
			</table>
			<button id="add" name="add" value="Add" class="btn btn-primary"><spring:message code="add" /></button>
			<button id="update" name="update" value="Update"
				class="btn btn-success"><spring:message code="update" /></button>
			<frm:button id="reset" name="reset" class="btn btn-warning"><spring:message code="new" /></frm:button>
		</frm:form>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th><spring:message code="name" /></th>
					<th><spring:message code="gia" /></th>
					<th><spring:message code="trangthai" /></th>
					<th><spring:message code="thongtin" /></th>
					<th><spring:message code="prdt" /></th>
					<th><spring:message code="anh" /></th>
					<th><spring:message code="hanhdong" /></th>
				</tr>
			</thead>
			<c:forEach items="${sanphams}" var="sp">
				<tr>
					<td>${sp.iD}</td>
					<td>${sp.tenSP}</td>
					<td>${sp.gia}</td>
					<td>${sp.trangThai}</td>
					<td>${sp.thongTin}</td>
					<td>${sp.loaisp.maLoai}</td>
					<td>${sp.anh}</td>
					<td><a href="edit?id=${sp.iD}"><spring:message code="update" /></a> <a
						href="delete/${sp.iD}"><spring:message code="delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath}/"><spring:message code="home" /></a> <br /> <a
			href="${pageContext.request.contextPath}/ManagerLoaiSP/showLoaiSP"><spring:message code="prdt" /></a>
	</div>
</body>
</html>