<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Generate Password Protected ZIP</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="icon"
	href="<c:url value="/resources/images/sudarshan-logo.png"/>" />
<link rel="shortcut icon"
	href="<c:url value="/resources/images/ico/favicon.ico"/>"
	type="image/x-icon">

<style type="text/css">
.page-title {
	font-family: 'Open Sans', sans-serif;
	font-style: normal;
	font-weight: 600;
	font-size: 24px;
	color: #4C4C4C;
}

.sub-title {
	font-family: 'Open Sans', sans-serif;
	font-style: normal;
	font-weight: 400;
	font-size: 20px;
	color: #4C4C4C;
}

.content-desc {
	font-family: 'Open Sans', sans-serif;
	font-style: normal;
	font-weight: 200;
	font-size: 14px;
	color: #4c4c4cbf;
}

.mt-1 {
	margin-top: 1rem !important;
}

.mb-2, .my-2 {
	margin-bottom: 0.5rem !important;
}

#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>

</head>

<body>
	<div id="fullpage">
		<div class="header">

			<%@include file="../views/common/welcome-header.jspf"%>

		</div>

		<div>
			<%@include file="../views/common/message.jspf"%>
		</div>




		<div class="container">
			<div class="row">
				<div class="col-6 mt-4">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">

							<li class="breadcrumb-item" style="color: blue;">Basic
								Example of Generating Password Protected ZIP file</li>
						</ol>
					</nav>
				</div>

				<div class="col-1"></div>
			</div>
		</div>

		<div class="container">
			<div class="row">

				<div class="col-7">
					<div class="page-title">Enter the Details to generate Zip
						file:</div>
				</div>


				<div class="container">
					<div class="row">

						<form:form action="${pageContext.request.contextPath}/save"
							method="post" modelAttribute="userDetail">

							<div class="col-12 row" style="margin-top: 25px;">

								<div class="col-12">
									<div class="border-bottom mt-1 mb-2"></div>
								</div>


								<div class="col-sm-6">

									<label for="userName">Enter UserName</label> <input id="userName"
										name="userName" class="form-control required"
										required="required"></input> <label for="password">Enter
										Password</label> <input id="password" name="password"
										class="form-control required" required="required"></input>

								</div>


								<div class="col-sm-12">
									<div class="border-bottom mt-1 mb-2"></div>
								</div>

								<div class="col-sm-12">
									<button type="submit" class="btn btn-info">Submit</button>
									<button type="reset" class="btn btn-danger">Cancel</button>
								</div>

							</div>

						</form:form>

					</div>
				</div>


			</div>
		</div>




		<div class="container" style="margin-top: 50px;">
			<div class="row">

				<div class="col-7">
					<div class="page-title">Download the Password Protected Zip
						file:</div>
						
						<span>Use the password as <b><code>Pass12345</code></b> to decrypt or to open file</span>
						
				</div>

				<div id="fileDnDiv" class="col-12 row" style="margin-top: 25px;">
					
					<div class="col-12">
						<div class="border-bottom mt-1 mb-2">
							
						</div>
						
					</div>

					<div class="col-sm-12">
						<a href="${pageContext.request.contextPath}/download"
							class="btn btn-info">Download</a>
					</div>
					

				</div>

			</div>
		</div>

		<div>
			<div class="col-lg-12 col-sm-12 col-xs-12 copyrights">
				<%@include file="../views/login-footer.jsp"%>
			</div>
		</div>

	</div>

</body>
</html>