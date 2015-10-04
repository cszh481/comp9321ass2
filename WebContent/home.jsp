<%@ page import="dto.Item" %>
<%@ page import="service.ItemService" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%
	String loginBool = (String) session.getAttribute("login");
    ItemService itemService = new ItemService();
    List<Item> elements = itemService.getRandom10();
%>

<style>
    div.c-wrapper{
        width: 80%; /* for example */
        margin: auto;
    }

    .carousel-inner > .item > img,
    .carousel-inner > .item > a > img{
        width: 50%; /* use this, or not */
        margin: auto;
    }

</style>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <!-- Bootstrap Core CSS -->
	<jsp:include page="headerjsp.jsp" />
	
<title>The Book Store</title>
</head>
<body>

	<!-- CHOOSE JSP DEPENDS ON AUTHORITY -->
	<% if (loginBool == "true") {%>	
		<!-- after login -->
		<jsp:include page="homecustomerheader.jsp" />		
	<%} else {%>
		<!-- before login -->
		<jsp:include page="homeloginheader.jsp" />
	<% } %> 
        
        <div class="jumbotron">
            <div class="container">
                <div class="row">  
                    <div class="col-md-8 col-md-offset-4">
                        <br>
                        <h1>Welcome to ShimaKaze!</h1>
                        
                        <div class="row">
                            <form class="form-inline"method="get" action="control">
                                <div class="col-md-10">
                                    <input type="hidden" name="action" value="basicsearch"/>
                                    <input type="text" class="form-control" placeholder="search..." name="keyword">
                                    <button type="submit" class="btn btn-success">Search</button>
                               
                                    <a class="btn btn-primary" href="advsearch.jsp" title="">
                                        <span class="icon"></span>
                                        <span class="text">Adv Search</span>
                                    </a>
                                </div>
                            </form>
                            <br>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
       
       
       
       
        <div class="container theme-showcase" role="main">
        
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title">Have a look!</h3>
            </div>
            <div class="panel-body">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Title</th>
                        <th>Author/Editor</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (Item temp : elements ){%>
                    <tr>
                        <td><a href="control?action=showDetail&id=<%=temp.getId()%>"><%=temp.getTitle()%></a></td>
                        <td><%=temp.getAuthors()%></td>
                        <td><%=temp.getPrice()%></td>
                        <td><%=temp.getQuantity()%></td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
            </div>
        </div>  
        
        
        
        
    <!-- Picture Can remove -->

		<div id="carousel-example-generic" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carousel-example-generic" data-slide-to="0"
					class=""></li>
				<li data-target="#carousel-example-generic" data-slide-to="1"
					class=""></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"
                    class=""></li>
                <li data-target="#carousel-example-generic" data-slide-to="3"
                    class=""></li>
                <li data-target="#carousel-example-generic" data-slide-to="4"
                    class=""></li>
                <li data-target="#carousel-example-generic" data-slide-to="5"
                    class=""></li>
                <li data-target="#carousel-example-generic" data-slide-to="6"
                    class=""></li>
                <li data-target="#carousel-example-generic" data-slide-to="7"
                    class=""></li>
                <li data-target="#carousel-example-generic" data-slide-to="8"
                    class=""></li>
				<li data-target="#carousel-example-generic" data-slide-to="9"
					class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="10"
                    class="active"></li>
			</ol>
			<div class="carousel-inner" role="listbox">
                <% for (Item temp : elements ){%>
				<div class="item">
                    <a href="control?action=showDetail&id=<%=temp.getId()%>">  Title: <%=temp.getTitle()%>
					<img
						src="<%=temp.getImageURL()%>"
						data-holder-rendered="true">
                    </a>
				</div>
                <% } %>
				<div class="item active">
					<img
						src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMTE0MCIgaGVpZ2h0PSI1MDAiIHZpZXdCb3g9IjAgMCAxMTQwIDUwMCIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+PCEtLQpTb3VyY2UgVVJMOiBob2xkZXIuanMvMTE0MHg1MDAvYXV0by8jNTU1OiMzMzMvdGV4dDpUaGlyZCBzbGlkZQpDcmVhdGVkIHdpdGggSG9sZGVyLmpzIDIuNi4wLgpMZWFybiBtb3JlIGF0IGh0dHA6Ly9ob2xkZXJqcy5jb20KKGMpIDIwMTItMjAxNSBJdmFuIE1hbG9waW5za3kgLSBodHRwOi8vaW1za3kuY28KLS0+PGRlZnM+PHN0eWxlIHR5cGU9InRleHQvY3NzIj48IVtDREFUQVsjaG9sZGVyXzE0ZmY3ZjU4NzM5IHRleHQgeyBmaWxsOiMzMzM7Zm9udC13ZWlnaHQ6Ym9sZDtmb250LWZhbWlseTpBcmlhbCwgSGVsdmV0aWNhLCBPcGVuIFNhbnMsIHNhbnMtc2VyaWYsIG1vbm9zcGFjZTtmb250LXNpemU6NTdwdCB9IF1dPjwvc3R5bGU+PC9kZWZzPjxnIGlkPSJob2xkZXJfMTRmZjdmNTg3MzkiPjxyZWN0IHdpZHRoPSIxMTQwIiBoZWlnaHQ9IjUwMCIgZmlsbD0iIzU1NSIvPjxnPjx0ZXh0IHg9IjM3Ny44NjcxODc1IiB5PSIyNzUuNSI+VGhpcmQgc2xpZGU8L3RleHQ+PC9nPjwvZz48L3N2Zz4="
						data-holder-rendered="true">
				</div>
			</div>
			<a class="left carousel-control" href="#carousel-example-generic"
				role="button" data-slide="prev"> <span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#carousel-example-generic"
				role="button" data-slide="next"> <span class="sr-only">Next</span>
			</a>

		</div>

		<!-- Picture End -->
        
        
        
    </div>

   

    <!-- Footer -->
	<jsp:include page="footer.jsp" />



    



</body>
</html>