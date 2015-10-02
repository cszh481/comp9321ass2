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
	<link type="text/css" rel="stylesheet" href="CSS/bootstrap.min">
	<link type="text/css" rel="stylesheet" href="CSS/bootstrap.css">
	
	
<title>The Book Store - Advance Search</title>
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
            	
            	<div class="row">  
        			<div class="col-md-4 col-md-offset-4">  
        		    	<label for="keywords">Title</label> 
						<input type="text" id="keywords" name="keywords" class="form-control" placeholder="Search...">
						<div></div>
                	</div>
            	</div>
 			
 			
				<div class="row">  
        			<div class="col-md-4 col-md-offset-4">  
        		    	<label for="when">Year</label> 
						<input type="text" id="when" name="when" class="form-control" placeholder="Search...">
						<div></div>
                	</div>
            	</div>
				
				<div class="row">  
        			<div class="col-md-4 col-md-offset-4">  
        		    	<label for="editor">Editor</label> 
						<input type="text" id="editor" name="editor" class="form-control" placeholder="Search...">
						<div></div>
                	</div>
            	</div>
			
				<div class="row">  
					<div class="col-md-4 col-md-offset-4">  
        				<label for="booktitle">Booktitle</label> 
						<input type="text" id="booktitle" name="booktitle" class="form-control" placeholder="Search...">
						<div></div>
                	</div>
            	</div>
			
				<div class="row">  
					<div class="col-md-4 col-md-offset-4">  
        				<label for="publisher">Publisher</label> 
						<input type="text" id="publisher" name="publisher" class="form-control" placeholder="Search...">
						<div></div>
                	</div>
            	</div>
			
				<div class="row"> 
					<div class="col-md-4 col-md-offset-4">   
        				<label for="isbn">ISBN</label> 
						<input type="text" id="isbn" name="isbn" class="form-control" placeholder="Search...">
						<div></div>
					</div>
            	</div>
				
				<div class="row">  
					<div class="col-md-4 col-md-offset-4">  
        				<label for="school">School</label> 
						<input type="text" id="school" name="school" class="form-control" placeholder="Search...">
						<div></div>
					</div>
            	</div>
			
			
			
			<!------- type search bar --------->
	
			<div class="row">  
			<div class="col-md-4 col-md-offset-4">  
			
			<label for="typesearch">Type</label> 
			<select name="typesearch" id="searchaction" class="form-control">
				<option value="article">journal</option>
				<option value="inproceedings">conference</option>
				<option value="proceedings">editorship</option>
				<option value="book">book</option>
				<option value="incollection">collection</option>
				<option value="phdthesis">phdthesis</option>
				<option value="mastersthesis">masterthesis</option>
				<option value="www">webpage</option>
				
			</select>
			
			</div>
			</div>
			
			<div class="row" style="padding-top: 40px">
			<div class="col-md-4 col-md-offset-4" align="center"> 
				<button type="submit" class="btn btn-success">Search</button>
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