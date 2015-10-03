<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%
	String loginBool = (String) session.getAttribute("login");
%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap Core CSS -->
<jsp:include page="headerjsp.jsp" />
<script src="JS/jquery.js"></script>
<script src="JS/register.js"></script>


<title>The Book Store - Registration</title>
</head>
<body>

	<!-- CHOOSE JSP DEPENDS ON AUTHORITY -->

	<!-- before login -->
	<% if (loginBool == "true") {%>	
		<!-- after login -->
		<jsp:include page="customerheader.jsp" />		
	<%} else {%>
		<!-- before login -->
		<jsp:include page="loginheader.jsp" />
	<% } %>

	<div class="jumbotron">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-4">
					<br>
					<h1>Registration</h1>
				</div>
			</div>
		</div>
	</div>


	<div class="container theme-showcase" role="main">


		<form action="control" id=registerform method="post" class="form-horizontal">

			<div class="container">
				<input type="hidden" name="action" value="registration">
				<div class="form-group form-group-md">
					<label class="col-md-4 control-label">Username</label>
					<div class="col-md-3">
						<input class="form-control" type="text" id="username" name="username"
							placeholder="Input...">
					</div>
				</div>


				<div class="form-group form-group-md">
					<label class="col-md-4 control-label">New Password</label>
					<div class="col-md-3">
						<input class="form-control" type="password" id="password" name="password"
							placeholder="Input...">
					</div>
				</div>

				<div class="form-group form-group-md">
					<label class="col-md-4 control-label">Confirm Password</label>
					<div class="col-md-3">
						<input class="form-control" type="password" id="password2" name="password2"
							placeholder="Input...">
					</div>
				</div>


				<div class="form-group form-group-md">
					<label class="col-md-4 control-label">E-mail</label>
					<div class="col-md-3">
						<input class="form-control" type="text" id="email" name="email"
							placeholder="Input...">
					</div>
				</div>

				<div class="form-group form-group-md">
					<label class="col-md-4 control-label">First Name</label>
					<div class="col-md-3">
						<input class="form-control" type="text" id="firstname" name="firstname"
							placeholder="Input...">
					</div>
				</div>

				<div class="form-group form-group-md">
					<label class="col-md-4 control-label">Last Name</label>
					<div class="col-md-3">
						<input class="form-control" type="text" id="lastname" name="lastname"
							placeholder="Input...">
					</div>
				</div>

				<div class="form-group form-group-md">
					<label class="col-md-4 control-label">Nickname</label>
					<div class="col-md-3">
						<input class="form-control" type="text" id="nickname" name="nickname"
							placeholder="Input...">
					</div>
				</div>

				<div class="form-group form-group-md">
					<label class="col-md-4 control-label">Year of Birth</label>
					<div class="col-md-3">
						<input class="form-control" type="text" id="yob" name="birthyear"
							placeholder="Input...">
					</div>
				</div>

				<div class="form-group form-group-md">
					<label class="col-md-4 control-label">Address</label>
					<div class="col-md-3">
						<input class="form-control" type="text" id="address" name="address"
							placeholder="Input...">
					</div>
				</div>

				<div class="form-group form-group-md">
					<label class="col-md-4 control-label">Credit Card Number</label>
					<div class="col-md-3">
						<input class="form-control" type="text" id="creditcard" name="creditcard"
							placeholder="Input...">
					</div>
				</div>

				<div class="row" style="padding-top: 40px">
					<div class="col-md-3 col-md-offset-4" align="center">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</div>


			</div>

		</form>

	</div>






	<!-- Footer -->
	<jsp:include page="footer.jsp" />


</body>
</html>