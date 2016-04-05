<jsp:include page="header.jsp" />

<div class="container well">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h1 class="page-header">Create customer</h1>
            <form action="addcustomer" method="POST">
                <div class="form-group">
                    <p>Company name: </p><input class="form-control" type="text" name="companyName" required>
                </div>
                <div class="row">
                    <div class="form-group col-md-4">
                        <p>First Name: </p><input class="form-control" type="text" name="companyOwnerFirstName" required>
                    </div>
                    <div class="form-group col-md-8">
                        <p> Last Name: </p><input class="form-control" type="text" name="companyOwnerLastName" required>
                    </div>
                </div>
                <div class="form-group">
                    <p> Email: </p><input class="form-control" type="text" name="customerEmail" required>
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
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>

<jsp:include page="footer.jsp" />