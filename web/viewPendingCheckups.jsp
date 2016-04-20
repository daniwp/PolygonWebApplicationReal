<%@page import="serviceLayer.entity.Checkup"%>
<%@page import="serviceLayer.entity.Building"%>
<%@page import="serviceLayer.entity.PendingBuildingCheckups"%>
<%@page import="java.util.List"%>
<%@page import="serviceLayer.ControllerFacade"%>
<jsp:include page="header.jsp" />

<div class="container">
    <div class="col-md-12">
        <h1 class="page-header">Pending checkups</h1><br>

        <%
            List<Checkup> checkups = new ControllerFacade().getAllPendingBuildingsCheckups();

            for (Checkup checkup : checkups) {
        %>
        <div class="row">
            <div class="col-md-12 well buildingitem">
                <div class="row">
                    <div class="col-md-12">
                        <div class="col-md-3">
                            <p>Request date: <strong><%= checkup.getDate()%></strong></p>
                        </div>
                        <div class="col-md-3">
                            <p>Status: <strong><%= checkup.getStatus()%></strong></p>
                        </div>
                        <div class="form-group col-md-4">
                            <form action="changecheckupstatusviewpending" method="POST">
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
                        <div class="col-md-2 pull-right">
                            <form action="deletependingcheckup" method="POST">
                                <button class="btn btn-danger pull-right col-md-12" type="submit">Delete item <i class="fa fa-times" aria-hidden="true"></i></button>
                                <input type="hidden" name="checkupId" value="<%= checkup.getCheckupId()%>"/>
                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <% }%>
    </div>
</div>

<jsp:include page="footer.jsp" />