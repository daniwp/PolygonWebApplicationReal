<%@page import="serviceLayer.entity.Customer"%>
<%@page import="java.util.List"%>
<%@page import="serviceLayer.entity.Building"%>
<%@page import="dataAccessLayer.mapper.BuildingMapper"%>
<jsp:include page="header.jsp" />

<div class="container page-wrapper">
    <div class="row">
        <div class="col-md-12">
            <%
                if (session.getAttribute("user") != null) { %>
            <div class="row">
                <div class="col-md-12">
                    <a href="addBuilding.jsp" class="btn btn-success pull-left" ><i class="fa fa-plus"></i> Add building</a>
                </div>
            </div><br>
            <% Customer customer = (Customer) session.getAttribute("user");
                BuildingMapper buildingMapper = new BuildingMapper();
                List<Building> buildings = buildingMapper.getAllBuildings(customer.getCustomerId());%>    
            <% for (Building building : buildings) {%>

            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="fa fa-building fa-fw"></i>&nbsp;&nbsp;<%= building.getName()%></h3>
                </div>
                <div class="panel-body">
                    <div class="row">
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
                </div>
                <div style="min-height: 55px" class="panel-footer">
                    <form action="viewbuilding" method="POST">
                        <input type="hidden" name="buildingId" value="<%=building.getBuildingId()%>">
                        <button class="btn btn-primary pull-left" type="submit"><i class="fa fa-fw fa-eye"></i> View</button>
                    </form>
                    <form action="#" method="POST">
                        <input type="hidden" name="buildingId" value="<%=building.getBuildingId()%>">
                        <button style="margin-left: 5px" class="btn btn-success pull-left" type="submit"><i class="fa fa-fw fa-pencil-square-o"></i> Edit</button>
                    </form>
                    <form action="deletebuilding" method="POST">
                        <input type="hidden" name="buildingId" value="<%=building.getBuildingId()%>">
                        <button class="btn btn-danger pull-right" type="submit"><i class="fa fa-fw fa-ban"></i> Delete</button>
                    </form>
                </div>
            </div>

            <% }
                }%>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp" />