<%@ page import="dto.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="service.ItemService" %>
<%@ page import="dto.Cart" %>


<%
	String adminLogin = (String) session.getAttribute("adminlogin");
	String loginBool = (String) session.getAttribute("login");
	String userName = (String) request.getAttribute("username");
	List<Cart> elements = (List<Cart>) request.getAttribute("elements");
	int totalPage = (int) Math.ceil((elements.size() / 10) + 1);
	//get username
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Bootstrap Core CSS -->
<jsp:include page="headerjsp.jsp" />

<style>
.dblp-item {
	display: none;
}

#page-select {
	display: inline-block;
	width: 60%;
}

input[type="checkbox"] {
  display: block;
  margin: auto;
}
</style>

<title>The Book Store - Admin - Items Removed</title>
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
                        <h1>Items Removed</h1>
                        
                    </div>
                </div>
            </div>
        </div>

	<!-- after login -->
	<% if (adminLogin == "true") {%>
	<div class="container theme-showcase" role="main">

	<%
		if (elements.isEmpty()) {
	%>
		<div class="row" style="margin: 40px" align="center">
			<div class="col-md-8 col-md-offset-1">
				<h1>Sorry, this user hasn't removed anything from shopping cart!</h1>
			</div>
		</div>

		<%
			} else {
		%>
		

		<!--  Search result: Title, Author,  Price, Quantity, Seller, Action(Remove) -->

		<form action="do" method="get">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title"><%=userName%></h3>
			</div>
			<div class="panel-body">

				<table class="table table-striped">
					<thead>
						<tr>
							<th>Pub-Title</th>
							<th>added-Timestamp</th>
							<th>removed-Timetamp</th>
						</tr>
					</thead>
					<tbody>

				<%
					for (Cart element : elements) {
				%>
				<tr class="dblp-item">
				<!--  please link detail to 'adminDetail.jsp' -->
					<!-- linke to adminDetail.jsp -->
					<td><a href="control?action=showDetail&id=<%=element.getItem().getId()%>"> <%=element.getItem().getTitle()%></a></td>
					<td><%=element.getAdded()%></td>
					<td><%=element.getRemoved()%></td>
				</tr>
			<%
				}
			%>

					</tbody>
				</table>
				
			</div>
		</div>


	</form>
	
		
	<div class="pager">
		<div class="">
			<a class="pull-left btn btn-success page-nav" data-action="prev">Prev</a>
			<a class="pull-right btn btn-success page-nav" data-action="next">Next</a>
		</div>
		<div class="">
			<select id="page-select" class="form-control">
				<%
					for (int i = 0; i < totalPage; i++) {
				%>
				<option value="<%=i%>" data-index="<%=i%>">page
					<%=(i+1)%> out of
					<%=totalPage%></option>
				<%
					}
				%>
			</select>
		</div>
	</div>

	<% } %>
			

	</div>
	
	<% } else { %>

	<div class="container theme-showcase" role="main">
		<div class="col-md-10 col-md-offset-1" align="center">
			<h1><span class="glyphicon glyphicon-exclamation-sign"></span> No authority: Please log in!</h1>
			<a class="btn btn-primary" href="admin.jsp" title=""> <span
				class="icon"></span> <span class="text">Admin Home</span>
			</a>
		</div>
	</div>



	<% } %>
	


	

	<!-- Footer -->
	<jsp:include page="footer.jsp" />


</body>
</html>


<script>
	var totalPage = <%=totalPage%>;

	function showCurrentPage() {
		var dblps = $('.dblp-item');
		var select = $('#page-select');
		var currentIndex = select.val();

		dblps.hide();
		var start = currentIndex * 10;
		var i = 0;
		for (i = start; i < start + 10; i++) {
			var el = $(dblps[i]);
			el.show();
		}
	}

	$('#page-select').change(function(e) {
		showCurrentPage();
	});

	$('.page-nav').click(function(e) {
		var btn = $(e.target);
		var action = btn.data('action');
		var currentIndex = parseInt($('#page-select').val());

		if (action == "next") {
			if (currentIndex < totalPage - 1) {
				$('#page-select').val(currentIndex + 1);
				$('#page-select').change();
			}
		} else if (currentIndex > 0) {
			$('#page-select').val(currentIndex - 1);
			$('#page-select').change();
		}
	});

	showCurrentPage();
</script>

