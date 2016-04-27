<jsp:include page="header.jsp" />

<div class="container well">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1 class="page-header">Login page</h1>
            <!-- Displays an error message box if the login was not validated successfully -->
            <% if (session.getAttribute("loginError") != null) {%>

            <div class="alert alert-danger">
                <p class="text-center"><%= session.getAttribute("loginError")%></p>
            </div>

            <% } %>
            <% session.removeAttribute("loginError");%>
            <form action="login" method="POST">
                <div class="form-group">
                    <p>Username: </p><input class="form-control" type="text" name="username" required>
                </div>
                <div class="form-group">
                    <p>Password: </p><input class="form-control" type="password" name="password" required>
                </div>
                <button type="submit" class="pull-right btn btn-primary col-md-offset-3">Login</button>
            </form>
            <a href="index.jsp" class="btn btn-primary pull-left">Back</a>
        </div>
    </div>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>

<jsp:include page="footer.jsp" />