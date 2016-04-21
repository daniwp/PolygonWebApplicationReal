<%@page import="serviceLayer.ControllerFacade"%>
<%@page import="serviceLayer.entity.Building"%>
<%@page import="serviceLayer.entity.Building"%>
<jsp:include page="header.jsp" />

<%
  ControllerFacade controllerfacade = new ControllerFacade();
  Building building = controllerfacade.getBuildingByBuildingId(Integer.parseInt((String)session.getAttribute("buildingId")));
    
%>
<div class="container well">
    <div class="col-md-8 col-md-offset-2">
        <h1 class="page-header">Edit Building</h1>
        <form data-disable="true" action="editBuilding" method="POST" id="addbuildingform">
            <div class="col-md-12">
                <div class="row">
                    <div class="form-group">
                        <p>Building Name * </p><input class="form-control" type="text" value ="<%= building.getName() %>" name="buildingName" id="buildingName" required />
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <p>Owner name * </p><input class="form-control" type="text" value="<%= building.getBuildingOwner() %>" name="ownerName" id="ownerName" required />
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <p>Address * </p><input class="form-control" type="text" value ="<%= building.getAddress() %>" name="buildingAddress" id="buildingAddress" required />
                    </div>
                </div>
                <div class="row">
                    <div class="form-group">
                        <p>City *</p><input class="form-control" type="text" value="<%= building.getCity() %>" name="buildingCity" id="buildingCity" required />
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <p>Zipcode *</p><input class="form-control" type="text" value="<%= building.getZipcodes() %>" name="buildingZipcode" id="buildingZipcode" required />
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <p>Building year *</p><input class="form-control" type="text" value="<%= building.getBuildingYear() %>" name="buildingYear" id="buildingYear" required />
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="form-group">
                        <p>Nr. of floors *</p><input class="form-control" type="text" value="<%= building.getFloors() %>" name="nrOfFloors" id="nrOfFloors" required />
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <p>Total m2 *</p><input class="form-control" type="text" value="<%= building.getTotalSize() %>" name="totalM2" id="totalM2" required />
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
                        <input class="form-control" type="number" name="conditionLevel" id="conditionLevel" required />
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
            <input type="hidden" name="buildingId" value="<%= session.getAttribute("buildingId") %>">
            <button type="submit" class="btn btn-primary col-md-4 col-md-offset-4 ">Edit Building</button>
            <br><br>
            <br><br>
            <br><br>
            <br><br>
        </form>
    </div>
</div>


<jsp:include page="footer.jsp" />

