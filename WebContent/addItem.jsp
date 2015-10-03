<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <!-- Bootstrap Core CSS -->
	<jsp:include page="headerjsp.jsp" />
	
<title>The Book Store - Add New Item To Store</title>
</head>
<body>

		<!-- CHOOSE JSP DEPENDS ON AUTHORITY -->

		<!-- before login -->
		<jsp:include page="loginheader.jsp" />
		
        <div class="jumbotron">
            <div class="container">
                <div class="row">  
                    <div class="col-md-8 col-md-offset-3">
                        <br>
                        <h1>Add New Item To Store</h1>                 
                    </div>
                </div>
            </div>
        </div>
        
        
        <div class="container theme-showcase" role="main">
        
        
        <form action="control" method="GET" class="form-horizontal">
        
        	<div class="container">
        	
        		<div class="form-group form-group-md">
    				<label class="col-md-3 control-label">Title</label>
    				<div class="col-md-6">
      					<input class="form-control" type="text" id="#" name="#" placeholder="Input...">
    				</div>
    			</div>
    			
    			
    			<div class="form-group form-group-md">
    				<label class="col-md-3 control-label">Author/Editor</label>
    				<div class="col-md-6">
      					<input class="form-control" type="text" id="#" name="#" placeholder="Input...">
    				</div>
    			</div>
    			
    			<div class="form-group form-group-md">
    				<label class="col-md-3 control-label">Year</label>
    				<div class="col-md-6">
      					<input class="form-control" type="text" id="#" name="#" placeholder="Input...">
    				</div>
    			</div>
    			
    			
    			<div class="form-group form-group-md">
    				<label class="col-md-3 control-label">Publication Type</label>
    				<div class="col-md-6">
      					<input class="form-control" type="text" id="#" name="#" placeholder="Input...">
    				</div>
    			</div>
    			
    			<div class="form-group form-group-md">
    				<label class="col-md-3 control-label">Publication Date</label>
    				<div class="col-md-6">
      					<input class="form-control" type="text" id="#" name="#" placeholder="Input...">
    				</div>
    			</div>
    			
    			<div class="form-group form-group-md">
    				<label class="col-md-3 control-label">Venues</label>
    				<div class="col-md-6">
      					<input class="form-control" type="text" id="#" name="#" placeholder="Input...">
    				</div>
    			</div>
    			
    			<div class="form-group form-group-md">
    				<label class="col-md-3 control-label">Price</label>
    				<div class="col-md-6">
      					<input class="form-control" type="text" id="#" name="#" placeholder="Input...">
    				</div>
    			</div>
    			
    			<div class="form-group form-group-md">
    				<label class="col-md-3 control-label">Image</label>
    				<div class="col-md-6">
      					<input class="form-control" type="text" id="#" name="#" placeholder="Input...">
    				</div>
    			</div>
    			

			
			<!------- type search bar --------->
			
			
				<div class="form-group form-group-md">
    				<label class="col-md-3 control-label">Title</label>
    				<div class="col-md-6">
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
						<button type="submit" class="btn btn-success">Add To Shop</button>
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