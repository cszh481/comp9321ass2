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
	<%
		if (loginBool == "true") {
	%>
	<!-- after login -->
	<jsp:include page="customerheader.jsp" />
	<%
		} else {
	%>
	<!-- before login -->
	<jsp:include page="homeloginheader.jsp" />
	<%
		}
	%>

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
								<td><%=detialItem.getType()%></td>
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
		<div class="row" style="padding-top: 40px">
			<div class="col-md-3 col-md-offset-4" align="center">
				<form action="control" method="get">
                    <input type="hidden" name="itemId" value="<%=detialItem.getId()%>">
					<input type="hidden" name="action" value="addtocart" />
					<button class="btn btn-primary" type="submit">Add to Cart</button>
				</form>
			</div>
		</div>

	<% } %>


	</div>



	<!-- Footer -->
	<jsp:include page="footer.jsp" />







</body>
</html>