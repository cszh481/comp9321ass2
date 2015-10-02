<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Bootstrap Core CSS -->
	<link type="text/css" rel="stylesheet" href="CSS/bootstrap.min.css">
	<link type="text/css" rel="stylesheet" href="CSS/bootstrap.css">
	
<title>The Book Store - My Store</title>
</head>
<body>
	
	<!-- CHOOSE JSP DEPENDS ON AUTHORITY -->
	<jsp:include page="customerheader.jsp" /> -->
	
	
	    <div class="jumbotron">
            <div class="container">
                <div class="row">  
                    <div class="col-md-8 col-md-offset-4">
                        <br>
                        <h1>My Store</h1>                 
                    </div>
                </div>
            </div>
        </div>
	

	<div class="container theme-showcase" role="main">

		<div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title">Panel title</h3>
            </div>
            <div class="panel-body">
             
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Type</th>
                  <th>Title</th>
                  <th>Author/Editor</th>
                  <th>Year</th>
                  <th>Action<th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>
                  <td>Lorem</td>
                  <td>ipsum</td>
                  <td>dolor</td>
                  <td><button type="submit" class="btn btn-xs btn-warning">Pause</button></td>
                </tr>
                <tr>
                  <td>1,002</td>
                  <td>amet</td>
                  <td>consectetur</td>
                  <td>adipiscing</td>
                  <td><button type="submit" class="btn btn-xs btn-warning">Pause</button></td>
                </tr>
                <tr>
                  <td>1,003</td>
                  <td>Integer</td>
                  <td>nec</td>
                  <td>odio</td>
                  <td><button type="submit" class="btn btn-xs btn-warning">Pause</button></td>
                </tr>
                <tr>
                  <td>1,003</td>
                  <td>libero</td>
                  <td>Sed</td>
                  <td>cursus</td>
                  <td><button type="submit" class="btn btn-xs btn-warning">Pause</button></td>
                </tr>

              </tbody>
            </table>   
            
        	</div>

		</div>
		
		<div class="col-md-4 col-md-offset-4" align="center"> 
			 <a class="btn btn-primary" href="addItem.jsp" title="">
               	<span class="icon"></span>
               	<span class="text">Add New Item</span>
             </a>
		</div>

	</div>





	<!-- Footer -->
	<jsp:include page="footer.jsp" />


</body>
</html>