<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <!-- Bootstrap Core CSS -->
	<link type="text/css" rel="stylesheet" href="CSS/bootstrap.min">
	<link type="text/css" rel="stylesheet" href="CSS/bootstrap.css">
	
	
<title>The Book Store - Edit Profile</title>
</head>
<body>

		<!-- CHOOSE JSP DEPENDS ON AUTHORITY -->
		<jsp:include page="customerheader.jsp" />
		
       
        
        <div class="jumbotron">
            <div class="container">
                <div class="row">  
                    <div class="col-md-8 col-md-offset-4">
                        <br>
                        <h1>My Profile</h1>                 
                    </div>
                </div>
            </div>
        </div>
        
        
        <div class="container theme-showcase" role="main">
        
        <form action="#" method="GET" class="form-inline" style="text-align:right;">
        
        	<div class="container">
        	
        		<div class="row">  
        			<div class="col-md-4 col-md-offset-3">  
        		    	<label for="#">Username</label> 
						<input type="text" id="#" name="#" class="form-control" placeholder="username...">
						<div></div> 
                	</div>
            	</div>
            	
            	<div class="row">  
        			<div class="col-md-4 col-md-offset-3">  
        		    	<label for="#">Password</label> 
						<input type="password" id="#" name="#" class="form-control" placeholder="password...">
						<div></div>
                	</div>
            	</div>
 			
 			
				<div class="row">  
        			<div class="col-md-4 col-md-offset-3">  
        		    	<label for="#">E-mail</label> 
						<input type="text" id="#" name="#" class="form-control" placeholder="e-mail...">
						<div></div>
                	</div>
            	</div>
				
				<div class="row">  
        			<div class="col-md-4 col-md-offset-3">  
        		    	<label for="#">Nickname</label> 
						<input type="text" id="#" name="#" class="form-control" placeholder="nickname...">
						<div></div>
                	</div>
            	</div>
			
				<div class="row">  
        			<div class="col-md-4 col-md-offset-3">  
        		    	<label for="#">First Name</label> 
						<input type="text" id="#" name="#" class="form-control" placeholder="first name...">
						<div></div>
                	</div>
            	</div>
            	
            	<div class="row">  
        			<div class="col-md-4 col-md-offset-3">  
        		    	<label for="#">Last Name</label> 
						<input type="text" id="#" name="#" class="form-control" placeholder="last name...">
						<div></div>
                	</div>
            	</div>
            	
            	<div class="row">  
        			<div class="col-md-4 col-md-offset-3">  
        		    	<label for="#">Year of Birth</label> 
						<input type="text" id="#" name="#" class="form-control" placeholder="year of birth...">
						<div></div>
                	</div>
            	</div>
            	
            	<div class="row">  
        			<div class="col-md-4 col-md-offset-3">  
        		    	<label for="#">Address</label> 
						<input type="text" id="#" name="#" class="form-control" placeholder="address...">
						<div></div>
                	</div>
            	</div>
			
				<div class="row">  
        			<div class="col-md-4 col-md-offset-3">  
        		    	<label for="#">Credit Card Number</label> 
						<input type="text" id="#" name="#" class="form-control" placeholder="credit card number...">
						<div></div>
                	</div>
            	</div>
	
			<div class="row" style="padding-top: 40px">
			<div class="col-md-4 col-md-offset-4" align="center"> 
				<button type="submit" class="btn btn-success">Submit</button>
			</div>
			</div>
			
        
    		</div>
    	
    	</form>
        
 		
        

   
        
    	</div>

   

    <!-- Footer -->
    <jsp:include page="footer.jsp" />






    <!-- Bootstrap Core JavaScript -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script type="text/javascript" src="CSS/bootstrap.js"></script>
    



</body>
</html>