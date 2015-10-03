<%@ page import="dto.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="service.ItemService" %>

	
<%
		String loginBool = (String) session.getAttribute("login");
		List<Item> elements = (List<Item>) request.getAttribute("elements");
		int totalPage = (int) Math.ceil((elements.size() / 10) + 1);
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

<title>The Book Store - Search Results</title>
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
                        <h1>Items Search Results</h1>
                        
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
		
		
		
	<%
		if (elements.isEmpty()) {
	%>
		<div class="row" style="margin: 40px" align="center">
			<div class="col-md-8 col-md-offset-1">
				<h1>Sorry, no matching data found!</h1>
			</div>
		</div>

		<%
			} else {
		%>
		

		<!--  Search result: Title, Author,  Price, Quantity, Seller, Action(Remove) -->

		<form action="do" method="get">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Admin Search Result</h3>
			</div>
			<div class="panel-body">
			
				<input type="hidden" name="servlet" value="onAdd" />
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Title</th>
							<th>Author/Editor</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>

				<%
					for (Item element : elements) {
				%>
				<tr class="dblp-item">
					<td><input type="checkbox" name="pick" value="<%=element.getId()%>"></td>
					<td><a href="control?action=showDetail&id=<%=element.getId()%>"> <%=element.getTitle()%></a></td>
					<td><%=element.getAuthors().toString()%></td>
					<td><%=element.getPrice()%></td>
					<td><%=element.getQuantity()%></td>
					<input type="hidden" name="id" value="<%=element.getId()%>">
                    <input type="hidden" name="action" value="remove">
                    <td><button type="submit" class="btn btn-xs btn-warning">Remove</button></td>
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
