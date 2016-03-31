<jsp:include page="header.jsp" />

<div class="container well">
    <div class="col-md-8 col-md-offset-2">
        <h1 class="page-header">Add building</h1>
        <form action="#" method="POST">
            <div class="col-md-12">
                <div class="row">
                    <div class="form-group">
                        <p>Building Name * </p><input class="form-control" type="text" name="buildingName" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <p>Owner name * </p><input class="form-control" type="text" name="ownerName" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <p>Address * </p><input class="form-control" type="text" name="buildingAddress" required>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <p>City *</p><input class="form-control" type="text" name="buildingCity" required>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <p>Zipcode *</p><input class="form-control" type="number" maxlength="4" name="buildingZipcode" required>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <p>Building year *</p><input class="form-control" type="number" maxlength="4" name="buildingYear" required>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <p>Nr. of floors *</p><input class="form-control" type="number" maxlength="2" name="nrOfFloors" required>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <p>Total m2 *</p><input class="form-control" type="number" maxlength="10" name="totalM2" required>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-5">
                    <div class="form-group">
                        <p>Building condition (from 0 - 3) * </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <div class="form-group">
                        <input class="form-control" type="number" maxlength="1" name="conditionLevel" required>
                    </div>
                </div>
            </div>
            <div class="col-md-12">
                <div class="row">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Condition</th>
                                <th>Description of the building</th>
                                <th>Function of the building</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Condition level 0</td>
                                <td>The building part is new as when built</td>
                                <td>The function is as described</td>
                            </tr>
                            <tr>
                                <td>Condition level 1</td>
                                <td>The building part is intact, but with start of wear and visible damages (only cosmetic)</td>
                                <td>The function is as described</td>
                            </tr>
                            <tr>
                                <td>Condition level 2</td>
                                <td>The building part is starting to decay, with individual defect components</td>
                                <td>The function is decreased - danger of consequential damages</td>
                            </tr>
                            <tr>
                                <td>Condition level 3</td>
                                <td>The building part is degraded and must be replaced</td>
                                <td>Ceased functionality - danger of consequential damages</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <br>
            <button type="submit" class="btn btn-primary col-md-4 col-md-offset-4 ">Add building</button>
            <br><br>
            <br><br>
            <br><br>
            <br><br>
        </form>
    </div>
</div>

<jsp:include page="footer.jsp" />
