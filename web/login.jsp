<jsp:include page="header.jsp" />

<div class="container well">
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
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>

<jsp:include page="footer.jsp" />