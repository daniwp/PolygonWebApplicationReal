<%@page import="serviceLayer.ControllerFacade"%>
<%@page import="serviceLayer.entity.Floor"%>
<%@page import="java.util.List"%>
<%@page import="dataAccessLayer.mapper.MapperFacade"%>
<%@page import="dataAccessLayer.mapper.BuildingMapper"%>
<%@page import="serviceLayer.entity.Building"%>
<jsp:include page="header.jsp" />

<%
    if (session.getAttribute("customer") != null) {
        ControllerFacade controllerFacade = new ControllerFacade();
        int buildingId = Integer.parseInt((String) session.getAttribute("buildingId"));
        Building building = controllerFacade.getBuildingByBuildingId(buildingId);
        List<Floor> floors = controllerFacade.getAllFloorsByBuildingId(buildingId); %>

<div class="container well">
    <div class="col-md-10 col-md-offset-1">

        <%if (building != null) {%>

        <div class="row">
            <h1 class="page-header"><%= building.getName()%></h1>
        </div>
        <div class="well buildingitem">
            <div class="row">
                <h3 class="page-header col-md-12">Building info:</h3>
            </div>
            <div class="row border">
                <div class="col-md-4">
                    <p>Building owner: <strong><%= building.getBuildingOwner()%></strong></p>
                </div>
            </div>
            <br>
            <div class="row border">
                <div class="col-md-4">
                    <p>Street: <strong><%= building.getAddress()%></strong></p>
                </div>
                <div class="col-md-4">
                    <p>Zipcode: <strong><%= building.getZipcodes()%></strong></p>
                </div>
                <div class="col-md-4">
                    <p>City: <strong><%= building.getCity()%></strong></p>
                </div>
            </div>
            <br>
            <div class="row border">
                <div class="col-md-4">
                    <p>Number of floors: <strong><%= building.getFloors()%></strong></p>
                </div>
                <div class="col-md-4">
                    <p>Total m2: <strong><%= building.getTotalSize()%></strong></p>
                </div>
            </div>
            <br>
            <div class="row border">
                <div class="col-md-4">
                    <p>Building year: <strong><%= building.getBuildingYear()%></strong></p>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-md-4">
                    <p>Building condition: <strong><%= building.getBuildingCondition()%></strong></p>
                </div>
            </div>
        </div>
        <% }%>
        <form action="showaddfloors" method="POST">
            <div class="row">
                <div class="col-md-1 pull-left">
                    <a class="btn btn-primary" href="viewBuildings.jsp"><i class="fa fa-fw fa-angle-double-left"></i> Back</a>
                </div>
                <div class="col-md-2 pull-right">
                    <button class="btn btn-primary" type="submit">Add more floors</button>
                </div>
                <div class="col-md-4 pull-right">
                    <div class="col-md-5 col-md-offset-2">
                        <p>Nr. of floors</p>
                    </div>
                    <div class="col-md-5">
                        <input class="form-control" type="number" maxlength="3" name="nrOfFloors" required>
                    </div>
                </div>
            </div>
        </form>
        <br><br>

        <% if (session.getAttribute("nrOfFloors") != null) {
                for (int i = 0; i < Integer.parseInt((String) session.getAttribute("nrOfFloors")); i++) {%> 
        <form action="addfloor" method="POST">
            <div class="row well flooritem">
                <div class="col-md-2">
                    <h4 class="vtop"><%= i + 1%>. </h4>
                </div>
                <div class="vcenter col-md-4">
                    <div class="form-group">
                        <div class="col-md-6">
                            <p>Floor nr.: </p>
                        </div>
                        <div class="col-md-6">
                            <input class="form-control" type="number" maxlength="3" name="floorNr<%=i + 1%>" required>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <div class="col-md-4">
                            <p>Floor size: </p>
                        </div>
                        <div class="col-md-4">
                            <input class="form-control" type="number" maxlength="4" name="floorSize<%=i + 1%>" required>
                        </div>
                    </div>
                </div>
            </div>
            <% }%>
            <div class="row">
                <input type="hidden" name="buildingId" value="<%= Integer.parseInt((String) session.getAttribute("buildingId"))%>">
                <input type="hidden" name="nrOfFloors" value="<%= session.getAttribute("nrOfFloors")%>">
                <button type="submit" class="btn btn-primary col-md-2 col-md-offset-5">Add new floors</button>
            </div>
            <br>
        </form>
        <% }  %>


        <% if (!floors.isEmpty()) {
                for (Floor floor : floors) {%>
        <div class="panel panel-primary">
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-4">
                        <h4><strong><%= floor.getFloor()%>.</strong> Floor</h4>
                    </div>
                    <div class="col-md-4">
                        <p>Size: <strong><%= floor.getSize()%></strong></p>
                    </div>
                    <form action="deletefloor" method="POST">
                        <input type="hidden" name="floorId" value="<%=floor.getFloorId()%>">
                        <button class="btn btn-danger col-md-2 col-md-offset-1" type="submit"><i class="fa fa-fw fa-ban"></i> Delete</button>
                    </form>
                </div>
            </div>
        </div>
        <% }
            }%>
    </div>
</div>
<% }%>

<jsp:include page="footer.jsp" />
