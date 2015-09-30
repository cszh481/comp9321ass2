<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <!-- Bootstrap Core CSS -->
	<link type="text/css" rel="stylesheet" href="CSS/bootstrap.min">
	<link type="text/css" rel="stylesheet" href="CSS/bootstrap.css">
	
	
<title>The Book Store - Advance Search</title>
</head>
<body>

		<!-- CHOOSE JSP DEPENDS ON AUTHORITY -->

		<!-- before login -->
		<jsp:include page="loginheader.jsp" />
	
		<!-- after login -->
		<!-- <jsp:include page="customerheader.jsp" /> -->
		
       
        
        <div class="jumbotron">
            <div class="container">
                <div class="row">  
                    <div class="col-md-8 col-md-offset-4">
                        <br>
                        <h1>Registration</h1>                 
                    </div>
                </div>
            </div>
        </div>
        
        
        <div class="container theme-showcase" role="main">
        
        
        <form action="control" method="GET">
        
        	<div class="container">
        		<div class="row">  
        			<div class="col-md-4 col-md-offset-4">  
        		    	<label for="who">Author</label> 
						<input type="text" id="who" name="who" class="form-control" placeholder="Search...">
						<div></div> 
                	</div>
            	</div>



   
        
    		</div>
    	
    	</form>
    	
    	
    	
    	
    	
    	</div>

   

    <!-- Footer -->
    <jsp:include page="loginheader.jsp" />






    <!-- Bootstrap Core JavaScript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script type="text/javascript" src="CSS/bootstrap.js"></script>
    



</body>
</html>