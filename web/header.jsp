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

        <nav class="navbar navbar-inverse">
            <div class="container">

                <!-- Logo -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mainNavBar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <!-- Brand name button -->
                    <a href="index.jsp" class="navbar-brand">Polygon Dauda</a>
                </div>

                <!-- Menu Items -->
                <div class="collapse navbar-collapse" id="mainNavBar">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Add building</a></li>
                    </ul>

                    <!-- Right side items --> 
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.jsp">Login</a></li>

                        <!-- Drop down -->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Daviddk22 <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="createCustomer.jsp">Create customer</a></li>
                                <li><a href="index.jsp">Add building</a></li>
                            </ul>
                        </li> 
                    </ul>
                </div>
            </div>
        </nav>
        <br>
