<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<head>
<spring:url value="/resource/bootstrap/css/main.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><spring:message code="register" /></title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Kaushan+Script"
	rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<style type="text/css">
body {
	padding-top: 4.2rem;
	padding-bottom: 4.2rem;
	background: rgba(0, 0, 0, 0.76);
}

a {
	text-decoration: none !important;
}

h1, h2, h3 {
	font-family: 'Kaushan Script', cursive;
}

.myform {
	position: relative;
	display: -ms-flexbox;
	display: flex;
	padding: 1rem;
	-ms-flex-direction: column;
	flex-direction: column;
	width: 100%;
	pointer-events: auto;
	background-color: #fff;
	background-clip: padding-box;
	border: 1px solid rgba(0, 0, 0, .2);
	border-radius: 1.1rem;
	outline: 0;
	max-width: 500px;
}

.tx-tfm {
	text-transform: uppercase;
}

.mybtn {
	border-radius: 50px;
}

.login-or {
	position: relative;
	color: #aaa;
	margin-top: 10px;
	margin-bottom: 10px;
	padding-top: 10px;
	padding-bottom: 10px;
}

.span-or {
	display: block;
	position: absolute;
	left: 50%;
	top: -2px;
	margin-left: -25px;
	background-color: #fff;
	width: 50px;
	text-align: center;
}

.hr-or {
	height: 1px;
	margin-top: 0px !important;
	margin-bottom: 0px !important;
}

.google {
	color: #666;
	width: 100%;
	height: 40px;
	text-align: center;
	outline: none;
	border: 1px solid lightgrey;
}

form .error {
	color: #ff0000;
}
</style>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-md-5 mx-auto">
				<div id="first">
					<div class="myform form ">
						<div class="logo mb-3">
							<div class="col-md-12 text-center">
								<h1><spring:message code="register" /></h1>
							</div>
						</div>
						${message}
						<frm:form modelAttribute="user" action="registerAction"
							method="POST">
							<frm:errors path="*" element="ul" />
							<div class="form-group">
								<label for="exampleInputEmail1"><spring:message
										code="username" /></label></br>
								<frm:input path="userName" id="userName" class="form-control"
									aria-describedby="emailHelp" placeholder="UserName" />
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1"><spring:message
										code="pass" /></label></br>
								<frm:password path="pass" id="pass" class="form-control"
									aria-describedby="emailHelp" placeholder="Password" />
							</div>
							<div class="col-md-12 text-center mb-3">
								<button id="add" name="add" value="Add" class="btn btn-primary">
									<spring:message code="register" />
								</button>
								<button id="update" name="update" value="Update"
									class="btn btn-success">
									<spring:message code="update" />
								</button>
								<frm:button id="reset" name="reset" class="btn btn-warning">
									<spring:message code="new" />
								</frm:button>
							</div>
							<div class="col-md-12 ">
								<div class="form-group">
									<p class="text-center">
										<a href="login" id="signin"><spring:message code="quesre" /></a></br>
										<spring:message code="ngonngu" />
										: <a href="?lang=en">English</a> | <a href="?lang=vi">VN</a>
									</p>
								</div>
							</div>
						</frm:form>
						<table>
							<tr>
								<th>ID</th>
								<th><spring:message code="username" /></th>
								<th><spring:message code="hanhdong" /></th>
							</tr>
							<%
								int i = 1;
							%>
							<c:forEach items="${users}" var="user">
								<tr>
									<td><%=i++%></td>
									<td>${user.userName}</td>
									<td><a href="edit?username=${user.userName}"><spring:message
												code="update" /></a> | <a href="delete/${user.userName}"><spring:message
												code="delete" /></a></td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<!--End Sign Up-->
				</div>
			</div>
		</div>
</body>

</html>