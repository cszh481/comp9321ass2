<%@ page import="dto.Item"%>
<%@ page import="service.ItemService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
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
								<td><%=detialItem.getTitle()%></td>
							</tr>
							<tr>
								<td>Author</td>
								<td><%=detialItem.getAuthors()%></td>
							</tr>

							<tr>
								<td>Publication Type</td>
								<td><%=detialItem.getTitle()%></td>
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

	<%
		if (loginBool == "true") {
	%>
		<!-- remove from database!!!! -->
	

	<div class="row" style="padding-top: 40px">
        <div class="col-md-6 col-md-offset-3" align="center">
                <button id="clearCart" class="btn btn-danger" type="submit" name="action" value="rmshoppingcart">Remove from Store</button>
                <button id="checkoutCart" class="btn btn-primary" type="submit" name="action" value="makeorder">Back to Search Result</button>
		</div>
	</div>

	<% } %>






	</div>



	<!-- Footer -->
	<jsp:include page="footer.jsp" />







</body>
</html>