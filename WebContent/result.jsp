<%@ page import="dto.Item"%>
<%@ page import="service.ItemService"%>
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

<title>The Book Store - Search Results</title>
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
					<h1>Search Results</h1>
				</div>
			</div>
		</div>
	</div>





	<div class="container theme-showcase" role="main">

		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Panel title</h3>
			</div>
			<div class="panel-body">
				<table class="table table-striped">
					<col width="5%" />
					<col width="60%" />
					<col width="25%" />
					<col width="5%" />
					<col width="5%" />
					<thead>
						<tr>
							<th>#</th>
							<th>Title</th>
							<th>Author/Editor</th>
							<th>Price</th>
							<th>Quantity</th>
						</tr>
					</thead>
					<tbody>

						<tr>
							<td><input type="checkbox" name="pick" value="getId"></td>
							<td>getTitle()</td>
							<td>getAuthors()</td>
							<td>getPrice()</td>
							<td>getQuantity()</td>
						</tr>


					</tbody>
				</table>
			</div>
		</div>



		<div class="row" style="padding-top: 40px">
			<div class="col-md-3 col-md-offset-4" align="center">
				<form action="do">
					<input type="hidden" name="servlet" value="onAdd" />
					<button class="btn btn-primary" type="submit">Add to Cart</button>
				</form>
			</div>
		</div>


	</div>




	<!-- Footer -->
	<jsp:include page="footer.jsp" />
</body>
</html>