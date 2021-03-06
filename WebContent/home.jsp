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
                        <h1>ShimaKaze!</h1>
                        
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
        <%if (elements.size()>0){%>
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
                    <% for (int i = 0; i < elements.size()-1 ; i++){%>
                    <li data-target="#carousel-example-generic" data-slide-to="<%=i%>"></li>
                    <% } %>
                    <li data-target="#carousel-example-generic" data-slide-to="<%=elements.size()-1%>"
                        class="active"></li>
                </ol>
                <div class="carousel-inner" role="listbox">
                    <% for (int i = 0; i < elements.size()-1 ; i++){%>
                    <div class="item">
                        <a href="control?action=showDetail&id=<%=elements.get(i).getId()%>">  Title: <%=elements.get(i).getTitle()%>
                            <img
                                    src="<%=elements.get(i).getImageURL()%>"
                                    data-holder-rendered="true">

                    </div>
                    <% } %>
                    <div class="item active">
                        <a href="control?action=showDetail&id=<%=elements.get(elements.size()-1).getId()%>">  Title: <%=elements.get(elements.size()-1).getTitle()%>
                            <img
                                    src="<%=elements.get(elements.size()-1).getImageURL()%>"
                                    data-holder-rendered="true">
                        </a>
                    </div>
                </div>
                <a class="left carousel-control" href="#carousel-example-generic"
                   role="button" data-slide="prev"> <span class="sr-only">Previous</span>
                </a> <a class="right carousel-control" href="#carousel-example-generic"
                        role="button" data-slide="next"> <span class="sr-only">Next</span>
            </a>

            </div>

            <!-- Picture End -->
            <%}else {%>
            <div class="row" style="margin: 40px" align="center">
                <div class="col-md-8 col-md-offset-1">
                    <h1>Sorry, no matching data found!</h1>
                </div>
            </div>
            <%}%>
        
        
        
        

        
        
        
    </div>

   

    <!-- Footer -->
	<jsp:include page="footer.jsp" />



    



</body>
</html>