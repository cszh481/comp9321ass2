<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Bootstrap Core CSS -->
	<link type="text/css" rel="stylesheet" href="CSS/bootstrap.min">
	<link type="text/css" rel="stylesheet" href="CSS/bootstrap.css">
	
<title>The Book Store - My Shopping Cart</title>
</head>
<body>
	
	<!-- CHOOSE JSP DEPENDS ON AUTHORITY -->

	<!-- before login -->
	<jsp:include page="loginheader.jsp" />
	
	<!-- after login -->
	<!-- <jsp:include page="customerheader.jsp" /> -->
	
	
	    <div class="jumbotron">
            <div class="container">
                <div class="row">  
                    <div class="col-md-8 col-md-offset-4">
                        <br>
                        <h1>Shopping Cart</h1>                 
                    </div>
                </div>
            </div>
        </div>
	

	<div class="container theme-showcase" role="main">

		<div class="row" style="margin: 40px" align="center">
    		<h1>Shopping Cart is Empty!</h1>
		</div>




	</div>





	<!-- Footer -->
	<jsp:include page="footer.jsp" />
	
	<!-- Bootstrap Core JavaScript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script type="text/javascript" src="CSS/bootstrap.js"></script>


</body>
</html>