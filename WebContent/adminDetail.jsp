<%@ page import="dto.Item"%>
<%@ page import="service.ItemService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
	String adminLogin = (String) session.getAttribute("adminlogin");
	String loginBool = (String) session.getAttribute("login");
	Item detialItem = (Item) request.getAttribute("detail");
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap Core CSS -->
<jsp:include page="headerjsp.jsp" />

<title>The Book Store - Details of the book</title>
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
					<h1>Book Detail</h1>
				</div>
			</div>
		</div>
	</div>



	<!-- after login -->
	<% if (adminLogin == "true") {%>

	<div class="container theme-showcase" role="main">


		<div class="row">

			<div class="col-md-3">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Book Image</h3>
					</div>
					<img
						src="<%=detialItem.getImageURL()%>"
						alt="Responsive image" class="img-responsive"> </img>
				</div>
			</div>


			<div class="col-mid-9 col-md-offset-3">

				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Book Info</h3>
					</div>
					<div class="panel-body">
						<table class="table table-striped">
							<col width="30%" />
							<col width="70%" />
							<tr>
								<td>Title</td>
								<td><%=detialItem.getType()%></td>
							</tr>
							<tr>
								<td>Author</td>
								<td><%=detialItem.getAuthors()%></td>
							</tr>

							<tr>
								<td>Publication Type</td>
								<td><%=detialItem.getType()%></td>
							</tr>
							<tr>
								<td>Year</td>
								<td><%=detialItem.getPublication_date()%></td>
							</tr>
							<tr>
								<td>Price</td>
								<td><%=detialItem.getPrice()%></td>
							</tr>
                            <tr>
                                <td>Quantity</td>
                                <td><%=detialItem.getQuantity()%></td>
                            </tr>
							<tr>
								<td>Seller</td>
								<td><%=detialItem.getSeller().getUsername()%></td>
							</tr>
						</table>
					</div>
				</div>

			</div>
		</div>


		<!-- remove from database!!!! -->
	

	<div class="row" style="padding-top: 40px">
		<form action="control" method="get">
        <div class="col-md-6 col-md-offset-3" align="center">
			<input type="hidden" name="id" value="<%=detialItem.getId()%>"/>
			<%if (detialItem.isBan()){%>
			<button id="clearCart" class="btn btn-success" type="submit" name="action" value="unbanitem">Restore to Store</button>
			<%}else {%>
			<button id="clearCart" class="btn btn-danger" type="submit" name="action" value="banitem">Remove from Store</button>
			<%}%>
		</form>
		</div>
	</div>




	<% } else { %>

	<div class="container theme-showcase" role="main">
		<div class="col-md-10 col-md-offset-1" align="center">
			<h1> <span class="glyphicon glyphicon-exclamation-sign"></span> No authority: Please log in!</h1>
			<a class="btn btn-primary" href="admin.jsp" title=""> <span
				class="icon"></span> <span class="text">Admin Home</span>
			</a>
		</div>
	</div>



	<% } %>






	</div>



	<!-- Footer -->
	<jsp:include page="footer.jsp" />







</body>
</html>