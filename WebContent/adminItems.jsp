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


<title>The Book Store - Items for Sale</title>
</head>
<body>

	<!-- CHOOSE JSP DEPENDS ON AUTHORITY -->

	<% if (loginBool == "true") {%>	
		<!-- after login -->
		<jsp:include page="adminheader.jsp" />		
	<%} else {%>
		<!-- before login -->
		<jsp:include page="loginheader.jsp" />
	<% } %>

	<div class="jumbotron">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-4">
					<br>
					<h1>Items for Sale</h1>
				</div>
			</div>
		</div>
	</div>


	<div class="container theme-showcase" role="main">

		<div class="row">
			<div class="col-md-3 col-md-offset-4" align="center">
				<a class="btn btn-primary" href="adminItems.jsp" title=""> <span
					class="icon"></span> <span class="text">Items for Sale</span>
				</a>
			</div>
		</div>



	</div>






	<!-- Footer -->
	<jsp:include page="footer.jsp" />


</body>
</html>