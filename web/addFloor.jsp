
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="main.css">
    </head>
    <body>
        <div class="container well">
            <div class="col-md-8 col-md-offset-2">
                <h1 class="page-header">Add floors</h1>
                <form action="#">
                    <% if (request.getParameter("nrOfFloors") != null)
                            for (int i = 0; i < Integer.parseInt(request.getParameter("nrOfFloors")); i++) { %>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <p>Floor Nr.: </p><input class="list-item" type="text" name="floorNr" required>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <p>Floor m2: </p><input class="form-control" type="text" name="floorM2" required>
                            </div>
                        </div>
                    </div>
                    <% }
                    else {%>
                    <br><br>
                    <div class="alert alert-danger">
                        <h3>You have not added a building yet! Please click below to do so.</h3>
                    </div>
                    <br><br>
                    <a href="index.jsp" class="btn btn-primary col-md-2 col-md-offset-5">Add building</a>
                    <% }%>
                    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                </form>
            </div>
        </div>
    </body>
</html>
