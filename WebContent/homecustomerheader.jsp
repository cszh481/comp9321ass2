<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
        <nav class="navbar navbar-inverse navbar-fixed-top"> 
            <div class="container-fluid"> 
                <div class="navbar-header"> 
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar"> 
                        <span class="sr-only">Toggle navigation</span> 
                        <splan class="icon-bar"></splan> 
                        <splan class="icon-bar"></splan> 
                        <splan class="icon-bar"></splan> 
                    </button> 
                    <a class="navbar-brand" href="home.jsp"><span class="glyphicon glyphicon-home"></span> Home</a> 
                    <a class="navbar-brand" href="advsearch.jsp"><span class="glyphicon glyphicon-search"></span> Advance Search</a>
                </div>
            
                <div id="navbar" class="navbar-collapse collapse"> 
                    <ul class="nav navbar-nav navbar-right"> 
                        <li><a href="profile.jsp"><span class="glyphicon glyphicon-user"></span> My Profile</a></li> 
                        <li><a href="shoppingcart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</a></li>
                        <li><a href="store.jsp"><span class="glyphicon glyphicon-book"></span> My Store</a></li>
                        <li><a href="control?action=logout"><span class="glyphicon glyphicon-log-out"></span> Log Out</a></li>
                    </ul>  
                </div>
            </div> 
        </nav>
</body>


</html>