<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap Core CSS -->
<jsp:include page="headerjsp.jsp" />
<script src="JS/jquery.js"></script>
<script src="JS/register.js"></script>


<title>The Book Store - Account is Banned</title>
</head>
<body>

	<!-- CHOOSE JSP DEPENDS ON AUTHORITY -->

		<!-- before login -->
		<jsp:include page="loginheader.jsp" />


	<div class="jumbotron">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2">
					<br>
					<h1><span class="glyphicon glyphicon-remove-circle"></span> You are Banned!</h1>
				</div>
			</div>
		</div>
	</div>
	

	<div class="container theme-showcase" role="main">
		<div class="col-md-8 col-md-offset-1" align="center">
			<h1>Please create new account</h1>
			<a class="btn btn-primary" href="registration.jsp" title=""> <span
				class="icon"></span> <span class="text">Sign Up</span>
			</a>
		</div>
	</div>



	<!-- Footer -->
	<jsp:include page="footer.jsp" />


</body>
</html>