<%@ page import="dto.Item"%>
<%@ page import="service.ItemService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>


<%
	String loginBool = (String) session.getAttribute("login");
	List<Item> elements = (List<Item>) request.getAttribute("elements");
	int totalPage = (int) Math.ceil(elements.size() / 10);
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
<title>The Book Store - My Shopping Cart</title>

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
                    <div class="col-md-8 col-md-offset-4">
                        <br>
                        <h1>My Shopping Cart</h1>                 
                    </div>
                </div>
            </div>
        </div>
	

	<div class="container theme-showcase" role="main">


	<%
		if (elements == null || elements.isEmpty()) {
	%>


		<div class="row" style="margin: 40px" align="center">
    		<h1>Shopping Cart is Empty!</h1>
		</div>

	<%
		} else {
	%>


	<form action="do" method="get">
	<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Search Result</h3>
			</div>
	<div class="panel-body">
		<input type="hidden" name="servlet" value="onDel" />
		<table class="table table-striped">
					<col width="5%" />
					<col width="50%" />
					<col width="20%" />
					<col width="10%" />
					<col width="15%" />
					<thead>
						<tr>
							<th>#</th>
							<th>Title</th>
							<th>Author/Editor</th>
							<th>Price</th>
							<th>Seller</th>
						</tr>
					</thead>
					<tbody>
			<%
				for (Item element : elements) {
			%>
			<tr class="dblp-item">
				<td><input type="checkbox" name="pick" value="<%=element.getId()%>"></td>
				<td><a href="detail.jsp?id=<%=element.getId()%>"> <%=element.getTitle()%></a></td>
				<td><%=element.getAuthors().toString()%></td>
				<td><%=element.getPrice()%></td>
				<td><%=element.getSeller()%></td>
			</tr>
		
			<%
				}
			%>
			
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="row" style="padding-top: 40px">
			<div class="col-md-6 col-md-offset-3" align="center">
			<button class="btn btn-danger" type="submit">Remove from Shopping cart</button>
			<a class="btn btn-primary" href="home.jsp">Back to search</a>
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

	<%
		}
	%>


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

