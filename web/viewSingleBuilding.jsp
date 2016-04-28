<%@page import="serviceLayer.entity.Checkup"%>
<%@page import="serviceLayer.entity.Image"%>
<%@page import="serviceLayer.entity.Floorplan"%>
<%@page import="serviceLayer.entity.Document"%>
<%@page import="serviceLayer.entity.Report"%>
<%@page import="serviceLayer.ControllerFacade"%>
<%@page import="serviceLayer.entity.Floor"%>
<%@page import="java.util.List"%>
<%@page import="dataAccessLayer.mapper.MapperFacade"%>
<%@page import="dataAccessLayer.mapper.BuildingMapper"%>
<%@page import="serviceLayer.entity.Building"%>
<jsp:include page="header.jsp" />

<% ControllerFacade controllerFacade = new ControllerFacade(); %>
<% if (session.getAttribute("loggedIn") != null) {
        int buildingId = Integer.parseInt((String) session.getAttribute("buildingId"));
        Building building = controllerFacade.getBuildingByBuildingId(buildingId);
        List<Floor> floors = controllerFacade.getAllFloorsByBuildingId(buildingId); %>

<div class="container well">
    <div class="col-md-10 col-md-offset-1">

        <!-- Displays a success box when you have successfully edited a buildings information -->
        <% if (session.getAttribute("saveComplete") != null) {%>

        <div class="alert alert-success">
            <p class="text-center"><%= session.getAttribute("saveComplete")%></p>
        </div>

        <% } %>
        <% session.removeAttribute("saveComplete"); %>

        <!-- If there is a building with the given building Id display it here -->
        <%if (building != null) {%>
        <div class="row">
            <h1 class="page-header"><%= building.getName()%></h1>
        </div>
        <div class="well buildingitem">
            <div class="row">
                <div class="col-md-10">
                    <h3 class="page-header col-md-12">Building info:</h3>
                </div>
                <div class="col-md-2">
                    <form action="vieweditbuilding" method="POST">
                        <input type="hidden" name="buildingId" value="<%=buildingId%>">
                        <button style="margin-left: 5px" class="btn btn-success pull-right" type="submit"><i class="fa fa-fw fa-pencil-square-o"></i> Edit</button>
                    </form>
                </div>
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
        <div class="row">
            <div class="col-md-1 pull-left">
                <!-- A back button that sets customer ID and redirects to viewSingleCustomer -->
                <% if (session.getAttribute("admin") != null) {%>
                <form action="backadmin" method="POST">
                    <button class="btn btn-primary" type="submit"><i class="fa fa-fw fa-angle-double-left"></i> Back</button>
                </form>
                <!-- Back button for customer to viewBuildings -->
                <% } %>
                <% if (session.getAttribute("customer") != null) { %>
                <a class="btn btn-primary" href="viewBuildings.jsp"><i class="fa fa-fw fa-angle-double-left"></i> Back</a>
                <% }%>
            </div>
            <!-- Sets an attribute in the session with the number of floors you added in the input field -->
            <form action="showaddfloors" method="POST">
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
            </form>
        </div>
        <br><br>

        <!-- Displays a error message box if floorAlreadyExists attribute is set (See AddFloor servlet) -->
        <% if (session.getAttribute("floorAlreadyExists") != null) {%>
        <div class="alert alert-danger">
            <p class="text-center"><%= session.getAttribute("floorAlreadyExists")%> </p>
        </div>
        <% }
            session.removeAttribute("floorAlreadyExists"); %>

        <!-- Floors -->
        <!-- Creates an add floor item for each nrOfFloors set in the session if it exists -->
        <!-- Then when submitted the floors are added and the attribute nrOfFloors is removed -->
        <% if (session.getAttribute("nrOfFloors") != null) {
                for (int i = 0; i < Integer.parseInt((String) session.getAttribute("nrOfFloors")); i++) {%> 

        <form action="addfloor" method="POST">
            <div class="row well flooritem">
                <div class="col-md-1">
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
                <div class="col-md-4">
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
        <% }%>

        <!-- Building Checkups -->
        <div class="well buildingitem">
            <div class="row">
                <h3 class="border">&nbsp;Building Checkups</h3>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <p>Add a new checkup:</p>
                </div>
            </div>
            <form action="requestcheckup" method="POST">
                <div class="row">
                    <div class="col-md-8">
                        <div class="col-md-2">
                            <p>Date:</p>
                        </div>
                        <div class="col-md-4 form-group">
                            <input class="form-control" type="date" name="checkupDate" required/>
                        </div>
                    </div>
                    <div class="col-md-4 pull-right">
                        <button type="submit" class="btn btn-primary pull-right">Request</button>
                    </div>
                </div>
                <br>
            </form>

            <!-- Generates a checkup item for each chuckup on the building by its ID -->
            <% List<Checkup> checkups = controllerFacade.getAllCheckupsByBuildingId(buildingId);
                for (Checkup checkup : checkups) {%>

            <div class="row">
                <div style="height: 50px;" class="col-md-12">
                    <div class="col-md-3">
                        <p>Request date: <strong><%= checkup.getDate()%></strong></p>
                    </div>
                    <div class="col-md-3">
                        <p>Status: <strong><%= checkup.getStatus()%></strong></p>
                    </div>
                    <% if (session.getAttribute("admin") != null) {%>
                    <div class="form-group col-md-4">
                        <form action="changecheckupstatus" method="POST">
                            <div class="col-md-8">
                                <select class="form-control" id="sel1" name="status">
                                    <option value="Cancelled">Cancel</option>
                                    <option value="Accepted">Accept</option>
                                    <option value="Completed">Complete</option>
                                </select>
                            </div>
                            <div class="col-md-4">
                                <button class="btn btn-primary" type="submit">Change</button>
                                <input type="hidden" name="checkupId" value="<%= checkup.getCheckupId()%>"/>
                            </div>
                        </form>
                    </div>
                    <% } %>
                    <% if (session.getAttribute("customer") != null && checkup.getStatus().equals("Pending...")) {%>
                    <div class="form-group col-md-2 pull-right">
                        <form action="cancelcheckup" method="POST">
                            <button class="btn btn-danger pull-right col-md-12" type="submit">Cancel <i class="fa fa-times" aria-hidden="true"></i></button>
                            <input type="hidden" name="checkupId" value="<%= checkup.getCheckupId()%>"/>
                        </form>
                    </div>
                    <% } %>
                    <% if (checkup.getStatus().equals("Cancelled") || session.getAttribute("admin") != null) {%>
                    <div class="col-md-2 pull-right">
                        <form action="deletecheckup" method="POST">
                            <button class="btn btn-danger pull-right col-md-12" onClick="return confirm('Are you sure you want to delete this checkup?');" type="submit" >Delete item <i class="fa fa-times" aria-hidden="true"></i></button>
                            <input type="hidden" name="checkupId" value="<%= checkup.getCheckupId()%>"/>
                        </form>
                    </div>
                    <% } %>
                </div>
            </div>
            <% }%>
            <br>
        </div>

        <!-- Building Reports -->
        <div class="well buildingitem">
            <div class="row">
                <h3 class="border">&nbsp;Building reports</h3>
            </div>

            <!-- If the admin attribute is set in the session, the admin can change the checkup status -->
            <% if (session.getAttribute("admin") != null) {%>
            <div class="row">
                <div class="col-md-12">
                    <p>Add a new building report:</p>
                </div>
            </div>
            <form action="uploadreport" method="POST" enctype="multipart/form-data">
                <div style="margin-bottom: 10px" class="input-group">
                    <span class="input-group-btn">
                        <span class="btn btn-primary btn-file">
                            Browse&hellip; <input type="file" name="reportFile" required>
                        </span>
                    </span>
                    <input type="text" class="form-control" readonly required>
                </div>
                <div class="row">
                    <div class="col-md-8">
                        <div class="col-md-2">
                            <p>Date:</p>
                        </div>
                        <div class="col-md-4 form-group">
                            <input class="form-control" type="date" name="reportDate" required/>
                        </div>
                    </div>
                    <div class="col-md-4 pull-right">
                        <button type="submit" class="btn btn-primary pull-right">Submit</button>
                    </div>
                </div>
            </form>
            <br>
            <% } %>

            <!-- Generates a report item for each report on the building by its ID -->
            <% List<Report> reports = controllerFacade.getAllReportsByBuildingId(buildingId);
                for (Report report : reports) {%>

            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-3">
                        <p><%= report.getFileName()%></p>
                    </div>
                    <div class="col-md-3">
                        <p><%= report.getUploadDate()%></p>
                    </div>
                    <div class="col-md-2 pull-right">
                        <form action="downloadreport">
                            <button class="btn btn-success pull-right col-md-12" type="submit"><i class="fa fa-download" aria-hidden="true"></i></button>
                            <input type="hidden" name="reportId" value="<%= report.getReportId()%>"/>
                        </form>
                    </div>

                    <!-- If the admin attribute is set in the session, the admin can delete the checkups -->
                    <% if (session.getAttribute("admin") != null) {%>
                    <div class="col-md-2 pull-right">
                        <form action="deletereport" method="POST">
                            <button class="btn btn-danger pull-right col-md-12" onClick="return confirm('Are you sure you want to delete this report?');" type="submit"><i class="fa fa-times" aria-hidden="true"></i></button>
                            <input type="hidden" name="reportId" value="<%= report.getReportId()%>"/>
                        </form>
                    </div>
                    <% } %>
                </div>
            </div>
            <br>

            <% }%>
        </div>

        <!-- Relevent documents -->
        <div class="well buildingitem">
            <div class="row">
                <h3 class="border">&nbsp;Building documents</h3>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <p>Add a new building document:</p>
                </div>
            </div>
            <form action="uploaddocument" method="POST" enctype="multipart/form-data">
                <div style="margin-bottom: 10px" class="input-group">
                    <span class="input-group-btn">
                        <span class="btn btn-primary btn-file">
                            Browse&hellip; <input type="file" name="documentFile" required>
                        </span>
                    </span>
                    <input type="text" class="form-control" readonly required>
                </div>
                <div class="row">
                    <div class="col-md-8">
                        <div class="col-md-2">
                            <p>Date:</p>
                        </div>
                        <div class="col-md-4 form-group">
                            <input class="form-control" type="date" name="documentDate" required/>
                        </div>
                    </div>
                    <div class="col-md-4 pull-right">
                        <button type="submit" class="btn btn-primary pull-right">Submit</button>
                    </div>
                </div>
                <br>
            </form>  

            <!-- Generates a document item for each document on the building by its ID -->
            <% List<Document> documents = controllerFacade.getAllDocumentsByBuildingId(buildingId);
                for (Document document : documents) {%>

            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-3">
                        <p><%= document.getDocumentFileName()%></p>
                    </div>
                    <div class="col-md-3">
                        <p><%= document.getDocumentUploadDate()%></p>
                    </div>
                    <div class="col-md-2 pull-right">
                        <form action="downloaddocument">
                            <button class="btn btn-success pull-right col-md-12" type="submit"><i class="fa fa-download" aria-hidden="true"></i></button>
                            <input type="hidden" name="documentId" value="<%= document.getDocumentId()%>"/>
                        </form>
                    </div>
                    <div class="col-md-2 pull-right">
                        <form action="deletedocument" method="POST">
                            <button class="btn btn-danger pull-right col-md-12" type="submit"><i class="fa fa-times" aria-hidden="true"></i></button>
                            <input type="hidden" name="documentId" value="<%= document.getDocumentId()%>"/>
                        </form>
                    </div>
                </div>
            </div>
            <br>

            <% }%>
        </div>

        <!-- Relevent images -->
        <div class="well buildingitem">
            <div class="row">
                <h3 class="border">&nbsp;Building images</h3>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <p>Add a new building image:</p>
                </div>
            </div>
            <form action="uploadimage" method="POST" enctype="multipart/form-data">
                <div style="margin-bottom: 10px" class="input-group">
                    <span class="input-group-btn">
                        <span class="btn btn-primary btn-file">
                            Browse&hellip; <input type="file" name="imageFile" required>
                        </span>
                    </span>
                    <input type="text" class="form-control" readonly required>
                </div>
                <div class="row">
                    <div class="col-md-4 pull-right">
                        <button type="submit" class="btn btn-primary pull-right">Submit</button>
                    </div>
                </div>
                <br>
            </form>

            <!-- Generates an image item for each image on the building by its ID -->
            <% List<Image> images = controllerFacade.getAllImagesByBuildingId(buildingId);
                for (Image image : images) {%>

            <div class="row">
                <div class="col-md-12">
                    <div class="col-md-3">
                        <p><%= image.getImageName()%></p>
                    </div>
                    <div class="col-md-2 pull-right">
                        <form action="downloadimage">
                            <button class="btn btn-success pull-right col-md-12" type="submit"><i class="fa fa-download" aria-hidden="true"></i></button>
                            <input type="hidden" name="imageId" value="<%= image.getImageId()%>"/>
                        </form>
                    </div>
                    <div class="col-md-2 pull-right">
                        <form action="deleteimage" method="POST">
                            <button class="btn btn-danger pull-right col-md-12" onClick="return confirm('Are you sure you want to delete this image?');" type="submit"><i class="fa fa-times" aria-hidden="true"></i></button>
                            <input type="hidden" name="imageId" value="<%= image.getImageId()%>"/>
                        </form>
                    </div>
                </div>
            </div>
            <br>
            <% } %>
        </div>

        <!-- Generates a floor item for each floor added to the building by the building ID -->
        <% if (!floors.isEmpty()) {
                for (Floor floor : floors) {
                    Floorplan floorplan = controllerFacade.getFloorplanByFloorId(floor.getFloorId());
        %>
        <div class="panel panel-primary">
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-2">
                        <h4><strong><%= floor.getFloor()%>.</strong> Floor</h4>
                    </div>
                    <div class="col-md-2">
                        <p>Size: <strong><%= floor.getSize()%></strong></p>
                    </div>
                    <div class="col-md-6">
                        <!-- If there is a floorplan attached to the floor, you can download or delete it -->
                        <% if (floorplan != null) {%>
                        <div class="col-md-12">
                            <div class="col-md-6">
                                <p><%= floorplan.getFloorplanName()%></p>
                            </div>
                            <div class="col-md-3 pull-right">
                                <form action="downloadfloorplan">
                                    <button class="btn btn-success pull-right col-md-12" type="submit"><i class="fa fa-download" aria-hidden="true"></i></button>
                                    <input type="hidden" name="floorplanId" value="<%= floorplan.getFloorplanId()%>"/>
                                </form>
                            </div>
                            <div class="col-md-3 pull-right">
                                <form action="deletefloorplan" method="POST">
                                    <button class="btn btn-danger pull-right col-md-12" type="submit"><i class="fa fa-times" aria-hidden="true"></i></button>
                                    <input type="hidden" name="floorplanId" value="<%= floorplan.getFloorplanId()%>"/>
                                </form>
                            </div>
                        </div>
                        <!-- If there is not floor plan, the user/admin can upload one -->
                        <% } else {%>
                        <form action="uploadfloorplan" method="POST" enctype="multipart/form-data">
                            <div class="col-md-3">
                                <button type="submit" class="btn btn-primary pull-right">Submit</button>
                            </div>
                            <div style="margin-bottom: 10px" class="input-group col-md-9">
                                <span class="input-group-btn">
                                    <span class="btn btn-primary btn-file">
                                        Browse&hellip; <input type="file" name="floorplanFile" required>
                                        <input type="hidden" name="floorId" value="<%= floor.getFloorId()%>"/>
                                    </span>
                                </span>
                                <input type="text" class="form-control" readonly required>
                            </div>
                        </form>
                        <% }%>
                    </div>
                    <div class="col-md-2 pull-right">
                        <form action="deletefloor" method="POST">
                            <input type="hidden" name="floorId" value="<%=floor.getFloorId()%>">
                            <button class="btn btn-danger col-md-12 pull-right" onClick="return confirm('Are you sure you want to delete this floor and the attached floorplan?');" type="submit"><i class="fa fa-fw fa-ban"></i> Delete</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <% }
            }%>
    </div>
    <% } else {%>
    <jsp:include page="pleaseLogin.jsp" />
    <% }%>

    <jsp:include page="footer.jsp" />
