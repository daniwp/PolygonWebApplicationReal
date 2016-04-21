<%@page import="serviceLayer.entity.Customer"%>
<%@page import="serviceLayer.ControllerFacade"%>
<jsp:include page="header.jsp" />
<% Customer customer = new ControllerFacade().getCustomerByCustomerId(Integer.parseInt((String) session.getAttribute("customerId")));%>
<div class="container well">
    <h1 class="page-header"> Edit customer information</h1>
    <form action="editcustomer" method="POST">
        <div class="row">
            <div class="col-md-12">
                <div class="col-md-12">
                    <div class="col-md-2">
                        <p>Company name: </p>
                    </div>    
                    <div class="col-md-3">
                        <input class="form-control pull-left" type="text" name="companyName" value="<%= customer.getCompanyName()%>">
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-12">
                <div class="col-md-6">
                    <div class="col-md-4">
                        <p>Customer first name: </p>
                    </div>    
                    <div class="col-md-6">
                        <input class="form-control pull-left" type="text" name="customerFirstName" value="<%= customer.getCustomerFirstName()%>">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="col-md-6">
                        <p>Customer last name: </p>
                    </div>    
                    <div class="col-md-6">
                        <input class="form-control" type="text" name="customerLastName" value="<%= customer.getCustomerLastName()%>">
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-12">
                <div class="col-md-12">
                    <div class="col-md-2">
                        <p>Customer Email: </p>
                    </div>    
                    <div class="col-md-3">
                        <input class="form-control pull-left" type="text" name="customerEmail" value="<%= customer.getCustomerEmail()%>">
                    </div>
                </div>
            </div>
        </div>
        <br>
        <button class="btn btn-primary col-md-2 col-md-offset-5" type="submit">Edit customer</button>




    </form>
</div>
<jsp:include page="footer.jsp" />