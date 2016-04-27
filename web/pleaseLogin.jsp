<div class="container">
    <div class="col-md-12">
        <div class="alert-warning">
            <h1 class="page-header text-center">Something went wrong...</h1>
            <h4 class="text-center">It seems like you are not logged in. You have to login first to view
                this page. If you do now have a valid Username and Password, we recommend
                you cal Polygon at +4523151751</h4>
            <br><br><br>
        </div>
        <br>
        <div class="col-md-2 col-md-offset-4">
            <a href="index.jsp" class="btn btn-primary btn-lg">Back</a>
        </div>
        <% if (session.getAttribute("loggedIn") == null) { %>
        <div class="col-md-2">
            <a href="login.jsp" class="btn btn-primary btn-lg">Login</a>
        </div>
        <% }%>
    </div>
</div>