<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
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
<title><spring:message code="prdt" /></title>
</head>
<body>
	<div align="center">
		<frm:form modelAttribute="loaisp" action="loaispProcess" method="get">
			<%-- 			<frm:hidden path="id" /> --%>
			<frm:errors path="*" element="ul" />
			<table>
				<tr>
					<td><spring:message code="maloai" /></td>
					<td><frm:input path="maLoai" id="maloai" /></td>
				</tr>
				<tr>
					<td><spring:message code="tenloai" /></td>
					<td><frm:input path="tenLoai" id="tenloai" /></td>
				</tr>
			</table>
			<button id="add" name="add" value="Add" class="btn btn-primary"><spring:message code="add" /></button>
			<button id="update" name="update" value="Update"
				class="btn btn-success"><spring:message code="update" /></button>
			<frm:button id="reset" name="reset" class="btn btn-warning"><spring:message code="new" /></frm:button>
		</frm:form>
		<table>
			<tr>
				<!-- 				<th>id</th> -->
				<th><spring:message code="maloai" /></th>
				<th><spring:message code="tenloai" /></th>
				<th><spring:message code="hanhdong" /></th>
			</tr>
			<c:forEach items="${loaisps}" var="lsp">
				<tr>
					<%-- 					<td>${lsp.id}</td> --%>
					<td>${lsp.maLoai}</td>
					<td>${lsp.tenLoai}</td>
					<td><a href="edit?maloai=${lsp.maLoai}"><spring:message code="update" /></a> | <a
						href="delete/${lsp.maLoai}"><spring:message code="delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="${pageContext.request.contextPath}/"><spring:message code="home" /></a> <br /> <a
			href="${pageContext.request.contextPath}/ManagerSP/showSP"><spring:message code="product" /></a>
	</div>
</body>
</html>