<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String loginBool = (String) session.getAttribute("login");
%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Bootstrap Core CSS -->
	<jsp:include page="headerjsp.jsp" />
	
<title>The Book Store - Email Confirmed!</title>
</head>
<body>
	
	<!-- CHOOSE JSP DEPENDS ON AUTHORITY -->
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
                    <div class="col-md-8 col-md-offset-3">
                        <br>
                        <h1>Registration</h1>                 
                    </div>
                </div>
            </div>
        </div>
	
	<div class="container theme-showcase" role="main">
		<div class="col-md-10 col-md-offset-1" align="center">
			<h1>Please check your email to verify your account!</h1>
			<a class="btn btn-primary" href="home.jsp" title=""> <span
				class="icon"></span> <span class="text">Home</span>
			</a>
		</div>
	</div>





	<!-- Footer -->
	<jsp:include page="footer.jsp" />


</body>
</html>