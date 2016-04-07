<%@page import="serviceLayer.entity.Floor"%>
<%@page import="java.util.List"%>
<%@page import="dataAccessLayer.mapper.MapperFacade"%>
<%@page import="dataAccessLayer.mapper.BuildingMapper"%>
<%@page import="serviceLayer.entity.Building"%>
<jsp:include page="header.jsp" />

<% MapperFacade mapperFacade = new MapperFacade();
    Building building = mapperFacade.getBuildingByBuildingId(Integer.parseInt(request.getParameter("buildingId"))); %>
<% List<Floor> floors = mapperFacade.getAllFloorsByBuildingID(Integer.parseInt(request.getParameter("buildingId"))); %>

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

        <% if (!floors.isEmpty()) {
                for (Floor floor : floors) {%>
        <div class="panel panel-primary">
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-4">
                        <p>Street: <strong><%= building.getAddress()%></strong></p>
                    </div>
                    <div class="col-md-4">
                        <p>Zipcode: <strong><%= building.getZipcodes()%></strong></p>
                    </div>
                    <form action="deletebuilding" method="POST">
                        <input type="hidden" name="buildingId" value="<%=building.getBuildingId()%>">
                        <button class="btn btn-danger pull-right" type="submit"><i class="fa fa-fw fa-ban"></i> Delete</button>
                    </form>
                </div>
            </div>
        </div>
        <% }
            }%>

        <a class="btn btn-primary" href="viewBuildings.jsp"><i class="fa fa-fw fa-angle-double-left"></i> Back</a>
    </div>
</div>

<jsp:include page="footer.jsp" />
