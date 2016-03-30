<%-- 
    Document   : register
    Created on : Mar 30, 2016, 4:07:03 PM
    Author     : danie
--%>

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
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h1 class="page-header">Registration page</h1>
                    <form action="#" method="POST">
                        <div class="form-group">
                            <p>Username: </p><input class="form-control" type="text" name="username" required>
                        </div>
                        <div class="form-group">
                            <p>Password: </p><input class="form-control" type="password" name="password" required>
                        </div>
                        <button class="btn btn-primary" type="submit">Register</button>
                        <a href="login.jsp" class="btn btn-primary">Login</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
