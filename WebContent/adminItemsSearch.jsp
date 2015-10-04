<%@ page import="dto.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="service.ItemService" %>

	
<%
	String loginBool = (String) session.getAttribute("login");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap Core CSS -->
<jsp:include page="headerjsp.jsp" />


<title>The Book Store - Admin - Items for Sale</title>
</head>
<body>

	<!-- CHOOSE JSP DEPENDS ON AUTHORITY -->

	<% if (adminLogin == "true") {%>	
		<!-- after login -->
		<jsp:include page="adminheader.jsp" />		
	<%} else {%>
		<!-- before login -->
		<jsp:include page="adminloginheader.jsp" />
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

		 <div class="row" style="margin: 40px" align="center">
		   <div class="col-md-8 col-md-offset-3">
			<form class="form-inline">
				<div class="col-md-10">
					<input type="text" class="form-control" placeholder="search...">
					<button type="submit" class="btn btn-success">Search</button>
				</div>
			</form>
			<br>
		  </div>
		</div>

	</div>






	<!-- Footer -->
	<jsp:include page="footer.jsp" />


</body>
</html>

