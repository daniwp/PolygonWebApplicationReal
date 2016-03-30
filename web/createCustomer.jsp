<%-- 
    Document   : createCustomer
    Created on : Mar 30, 2016, 4:09:17 PM
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
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h1 class="page-header">Create customer</h1>
                    <form action="#" method="POST">
                        <div class="form-group">
                            <p>Company name: </p><input class="form-control" type="text" name="companyName" required>
                        </div>
                        <div class="form-group">
                            <p>Company owner: </p><input class="form-control" type="text" name="companyOwner" required>
                        </div>
                        <div class="form-group">
                            <p>Username: </p><input class="form-control" type="text" name="customerUsername" required>
                        </div>
                        <div class="form-group">
                            <p>Password: </p><input class="form-control" type="text" name="customerPassword" required>
                        </div>
                        <br>
                        <button class="btn btn-primary col-md-4 col-md-offset-4" type="submit">Create customer</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
