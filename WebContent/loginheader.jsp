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
                    <a class="navbar-brand" href="home.jsp">Home</a> 
                    <a class="navbar-brand" href="advsearch.jsp">Advance Search</a>
                    <form class="navbar-form navbar-right"> 
                        <input type="text" class="form-control" placeholder="search..."> 
                        <button type="submit" class="btn btn-success">Search</button> 
                    </form>
                </div>
            
                <div id="navbar" class="navbar-collapse collapse"> 
                    <ul class="nav navbar-nav navbar-right"> 
                        <li><a href="#" data-toggle="modal" data-target="#myModal">Sign in</a></li> 
                        <li><a href="registration.jsp">Sign up</a></li> 
                        
                    </ul>  
                </div>
            </div> 
        </nav>
        
        <!-- Modal -->
        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">

                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-title">Sign in</h4>
                    </div>

                    <form>
                        <div class="modal-body">
                            
                            <div class="form-group">
                                <label for="InputUsername">Username</label>
                                <input type="text" class="form-control" id="InputUsername" placeholder="Username">
                            </div>
                            
                            <div class="form-group">
                                <label for="InputPassword">Password</label>
                                <input type="password" class="form-control" id="InputPassword" placeholder="Password">
                            </div>
  
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-default">Submit</button>
                        </div>
                    </form>


                </div>
            </div>
        </div>
        
        
</body>


</html>