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
        <div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1 class="page-header">Login page</h1>
            <form action="#">
                <div class="form-group">
                    <p>Username: </p><input class="form-control" type="text" name="username" required>
                </div>
                <div class="form-group">
                    <p>Password: </p><input class="form-control" type="password" name="password" required>
                </div>
                <button class="btn btn-primary">Login</button>
                <a href="register.jsp" class="btn btn-primary">Register</a>
            </form>
        </div>
    </div>
</div>
    </body>
</html>
