<jsp:include page="header.jsp" />

<div class="section section-hero">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-7 col-md-offset-7 hero">
                <h1>Integritet, Kompetence og Empati</h1>
                <p>Polygon er blandt de største aktører inden for skadeservice og specialrengøring i Danmark. Polygon var blandt de første virksomheder i Danmark, som gik aktivt ind i egentlig skadeservice. Vi er således branchens pioner med mere end 50 års erfaring.
                    Polygon er en serviceorienteret beredskabsvirksomhed, der kan tilkaldes 24 timer i døgnet, 7 dage om ugen, hele året rundt. Vi har 9 afdelinger fordelt over hele landet, hvilket sætter os i stand til at være fremme ved indsatsstedet med meget kort varsel.
                    Polygon er en del af en global virksomhed med omkring 2.900 medarbejdere fordelt på 13 lande, hvis ressourcer vi har mulighed for at trække på, såfremt det skulle være nødvendigt.
                    Firmaets styrke ligger i den akkumulerede viden og den veluddannede og meget ansvarsbevidste medarbejderstab, som opererer via en velstyret organisation med et stærkt beredskab. Polygon har desuden et meget tæt og tillidsfuldt samarbejde med landets største forsikringsselskaber samt beredskaber.</p>
                <br>
                <a href="login.jsp"><button class="btn btn-clear">Login</button></a>
            </div>
        </div>
    </div>
</div>


<div style="margin-top: 50px" class="container">
    <% if (session.getAttribute("customer") != null || session.getAttribute("admin") == null) { %>
    <div class="row">
        <div class="col-md-12">
            <a href="viewBuildings.jsp">
                <div class="col-md-4">
                    <div style="padding:36px 10px 50px 10px; height: 100%" class="col-md-12 well">
                        <div href="viewBuildings.jsp" class="col-md-4">
                            <i style="color: #009fe3" class="fa fa-building-o fa-5x" aria-hidden="true"></i>
                        </div>
                        <div class="col-md-8">
                            <h4 class="border" style="color: grey">My Buildings</h4>
                            <p>Here you can view all the buildings you've added</p>
                        </div>
                    </div>
                </div>
            </a>
            <a href="addBuilding.jsp">
                <div class="col-md-4 ">
                    <div style="padding:36px 10px 50px 10px; height: 100%" class="col-md-12 well">
                        <div class="col-md-4">
                            <i style="color: #009fe3" class="fa fa-plus-square-o fa-5x" aria-hidden="true"></i>
                        </div>
                        <div class="col-md-8">
                            <h4 class="border" style="color: grey">Add a Building</h4>
                            <p>Here you can add a new building</p>
                        </div>
                    </div>
                </div>
            </a>
            <a href="viewProfile.jsp" >
                <div class="col-md-4">
                    <div style="padding:36px 10px 50px 10px; height: 100%" class="col-md-12 well">
                        <div class="col-md-4">
                            <i style="color: #009fe3" class="fa fa-user fa-5x" aria-hidden="true"></i>
                        </div>
                        <div class="col-md-8">
                            <h4 class="border" style="color: grey">My Profile</h4>
                            <p>Here you can access and edit your customer information</p>
                        </div>
                    </div>
                </div>
            </a>
        </div>
    </div>
    <div style="margin: 0px;" class="row">
        <div class="col-md-12">
            <div style="padding:36px 10px 50px 10px; height: 100%" class="col-md-12 well">
                <div class="col-md-10 col-md-offset-1 border">
                    <div class="col-md-3">
                        <i style="color: #009fe3" class="fa fa-life-ring fa-5x" aria-hidden="true"></i>
                    </div>
                    <div class="col-md-8">
                        <h2 style="color: #009fe3">In case of urgent emergency call: <i class="fa fa-phone-square" aria-hidden="true"></i> 48140555&emsp;&emsp; (Open 24/7)</h2>
                    </div>
                </div>
                <div class="col-md-10 col-md-offset-1">
                    <br><br>
                    <p style="color: darkgray" class="text-center">A quick response is crucial when it comes to minimizing the damage and insurance claims for fire, water damage, flooding or natural disaster.
                        <br><br>Our Direct Reaction Team (DRT®) is equipped to respond quickly, ensuring that the property is restored to the conditions before the injury as soon as possible. It reduces the customer's cost of disruptions and protects the customer's investment.</p>
                    <br><br><br>
                </div>
            </div>
        </div>
    </div>
    <% } %>
    <% if (session.getAttribute("admin") != null) { %>
    <div class="row">
        <div class="col-md-12">
            <a href="viewPendingCheckups.jsp">
                <div class="col-md-6">
                    <div style="padding:36px 10px 50px 10px; height: 100%" class="col-md-12 well">
                        <div class="col-md-4">
                            <i style="color: #009fe3" class="fa fa-calendar-check-o fa-5x" aria-hidden="true"></i>
                        </div>
                        <div class="col-md-8">
                            <h4 class="border" style="color: grey">Pending Checkups</h4>
                            <p>Here you can view all requested Checkups</p>
                            <br><br>
                        </div>
                    </div>
                </div>
            </a>
            <a href="viewCustomers.jsp">
                <div class="col-md-6">
                    <div style="padding:36px 10px 50px 10px; height: 100%" class="col-md-12 well">
                        <div class="col-md-4">
                            <i style="color: #009fe3" class="fa fa-users fa-5x" aria-hidden="true"></i>
                        </div>
                        <div class="col-md-8">
                            <h4 class="border" style="color: grey">View Customers</h4>
                            <p>Here you view a list of all customers</p>
                            <br><br>
                        </div>
                    </div>
                </div>
            </a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <a href="createCustomer.jsp">
                <div class="col-md-6">
                    <div style="padding:36px 10px 50px 10px; height: 100%" class="col-md-12 well">
                        <div class="col-md-4">
                            <i style="color: #009fe3" class="fa fa-user-plus fa-5x" aria-hidden="true"></i>
                        </div>
                        <div class="col-md-8">
                            <h4 class="border" style="color: grey">Add a Customer</h4>
                            <p>Here you can add a new Customer</p>
                            <br><br>
                        </div>
                    </div>
                </div>
            </a>
            <a href="createAdmin.jsp">
                <div class="col-md-6">
                    <div style="padding:36px 10px 50px 10px; height: 100%" class="col-md-12 well">
                        <div class="col-md-4">
                            <i style="color: #009fe3" class="fa fa-user-md fa-5x" aria-hidden="true"></i>
                        </div>
                        <div class="col-md-8">
                            <h4 class="border" style="color: grey">Add an Admin</h4>
                            <p>Here you can add a new Admin user</p>
                            <br><br>
                        </div>
                    </div>
                </div>
            </a>
        </div>
    </div>
    <% }%>
</div>

<jsp:include page="footer.jsp" />
