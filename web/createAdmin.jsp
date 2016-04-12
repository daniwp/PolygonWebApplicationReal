<jsp:include page="header.jsp" />

<div class="container well">
    <% if (session.getAttribute("userExistsError") != null) {%>
    <div class="alert alert-danger">
        <p class="text-center"><%= session.getAttribute("userExistsError")%> </p>
    </div>
    <% }%>
    <% session.removeAttribute("userExistsError");%>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <% if (session.getAttribute("adminExistsError") != null) {%>
            <div class="alert alert-danger">
                <p class="text-center"><%= session.getAttribute("adminExistsError")%> </p>
            </div>
            <% }%>
            <% session.removeAttribute("adminExistsError");%>
            <h1 class="page-header">Create new admin</h1>
            <form action="addadmin" method="POST">
                <div class="form-group">
                    <p>Username: </p><input class="form-control" type="text" name="adminUsername" required>
                </div>
                <div class="form-group">
                    <p>Password: </p><input class="form-control" type="password" name="adminPassword" required>
                </div>
                <br>
                <button class="btn btn-primary col-md-4 col-md-offset-4" type="submit">Create admin</button>
            </form>
        </div>
    </div>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>

<jsp:include page="footer.jsp" />