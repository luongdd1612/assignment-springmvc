<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><spring:message code="bai" /></title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<style type="text/css">
.list-group {
	float: left;
	width: 20%;
}

.card-deck {
	float: right;
	width: 80%;
}

.col-6 {
	margin-bottom: 25px;
	margin-left: -10px;
}

.navbar navbar-light bg-light {
	background: black;
}
</style>
</head>

<body>
	<nav class="navbar navbar-dark bg-dark"> <a class="navbar-brand"
		href="index.jsp">Home</a>
		<a class="nav-item nav-link active" href="login"><spring:message code="login" /> <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="register"><spring:message code="register" /></a>
	<form class="form-inline" action="searchSP">
		<input class="form-control mr-sm-2" type="search" placeholder="Search"
			aria-label="Search" name="search">
		<button class="btn btn-outline-success my-2 my-sm-0" type="submit"
			value="Search">
			<spring:message code="search" />
		</button>
	</form>
	</nav>
	<div class="list-group">
		<frm:form class="register-form" id="register-form"
			modelAttribute="loaisp" action="chonLoai" method="get">
			<a href="index.jsp" class="list-group-item list-group-item-action"><spring:message
					code="allsp" /></a>
			<c:forEach items="${loaisps}" var="s">
				<a href="select?maloai=${s.maLoai}"
					class="list-group-item list-group-item-action">${s.tenLoai}</a>
			</c:forEach>
		</frm:form>
		<div align="center">
		<spring:message code="ngonngu" />
		: <a href="?lang=en">English</a> | <a href="?lang=vi">VN</a>
	</div>
	</div>

	<div class="card-deck">
		<!--Col-->
		<frm:form class="register-form" id="register-form"
			modelAttribute="sanpham" action="chonSP" method="get">
			<div class="row">
				<c:forEach items="${sanphams}" var="sp">
					<div class="col-6 col-md-4">
						<div class="card" style="width: 100%">
							<img src="${sp.anh}" class="card-img-top" width="200px"
								height="300px" alt="${sp.anh}">
							<div class="card-body">
								<h5 class="card-title">${sp.tenSP}</h5>
								<p class="card-text">${sp.thongTin}</p>
								<p class="card-text">${sp.trangThai}</p>
								<p class="card-text">${sp.gia}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<!-- end row -->
		</frm:form>
	</div>
	<!-- end card deck -->
</body>
</html>