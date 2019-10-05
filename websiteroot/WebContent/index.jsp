<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="assets/js/home.js"></script>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <title>Home</title>
</head>

<body>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top justify-content-between">

        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">BookMyFlight.com</a>
            </li>

        </ul>
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="signup.jsp">Sign Up</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="login.jsp">Login</a>
            </li>
        </ul>
    </nav>
    <div class="booking-form-box">

            <div class="booking-form">
                <form method="POST" action="search-results">
                    <label>Source city</label>
                    <input type="text" class="form-control" placeholder="City or Airport" name="source">
                    <label>Destination city</label>
                    <input type="text" class="form-control" placeholder="City or Airport" name="destination">
                    <div class="input-grp">
                        <label>Date of Journey</label>
                        <input type="date" class="form-control select-date" name="journey_date">
                    </div>
                    <div class="input-grp">
                        <label>No of travellers</label>
                        <input type="number" name="no_of_travellers" class="form-control" value="1">
                    </div>
                    
                                        <div class="input-grp">
                        <button type="submit" class="btn btn-primary " style="margin-left: 120px; margin-top: 15px;" value="Submit">Show
                            flights</button>
                    </div>
                </form>
            </div>
        </div>

</body>

</html>