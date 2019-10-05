<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title> Add money </title>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
</head>

<body>
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top justify-content-between">

        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="index.jsp">BookMyFlight.com</a>
            </li>

        <% String username = (String) session.getAttribute("user");
        			out.println("<ul class=\"navbar-nav ml-auto\">");
                	out.println("<li class=\"nav-item\">");
                	out.println("<a class=\"nav-link\" href=\"\">"+ username +"</a>");
                	out.println("</li>");
                	out.println("<li class=\"nav-item\">");
                	out.println("<a class=\"nav-link\" href=\"logout\">logout</a>");
                	out.println("</li>");
                	out.println("</ul>");
        %>
    </nav>
    <br>
    <br>
    <br>

    <style>
        body {
            margin: 0;
            padding: 0;
            background: url(assets/images/loginimage.jpg);
            background-repeat: no-repeat;
            background-size: cover;
            background-position: center;
            font-family: sans-serif;
        }


        .wrap {
            width: 800px;
            height: auto;
            overflow: hidden;
            padding: 40px;
            border: 1.2px solid white;
            margin-top: 2%;
            margin-left: 25%;
            background-color: rgba(0, 0, 0, 0.5);

        }

        h1 {
            margin: 0;
            padding: 0 0 20px;
            text-align: center;
            font-size: 30px;
            font-weight: bold;
        }

        .wrap input[type="text"] {
            border: none;
            border-bottom: 1px solid #fff;
            outline: none;
            border-radius: 5px;
            height: 40px;
            color: black;
            font-size: 16px;
            width: 320px;

        }

        .wrap input[type="password"] {
            border: none;
            border-bottom: 1px solid #fff;
            outline: none;
            border-radius: 5px;
            height: 40px;
            color: black;
            font-size: 16px;
            width: 320px;

        }
    </style>
    <div class="wrap">

        <font color="white">
            <h1>Enter customer details</h1>
            <form action="book" method="POST">

                <%
                	int c = Integer.parseInt((String)request.getAttribute("count"));
                int temp  =c;
                	while(c!=0){
                		out.println("<p id=\"1\"><b>Name</b></p>");
                		out.println("<input type=\"text\" name=\"name"+c + "\" placeholder=\"   Enter customer name\">");
                		out.println("<br><br>");
                		out.println("<p id=\"1\"><b>Date of birth</b></p>");
                		out.println("<input type=\"date\" name=\"dob"+c+"\" placeholder=\"   Enter customer dob\">");
                		out.println("<br><br>");
                		out.println("<p id=\"1\"><b>Gender</b></p>");
                		out.println("<input type=\"radio\" name=\"gender"+c+"\" value=\"male\" checked> Male");
                		out.println("<input type=\"radio\" name=\"gender"+c+"\" value=\"female\"> Female</input>");
                		out.println("<input type=\"radio\" name=\"gender"+c+"\" value=\"other\"> Other");
                		c--;
                	}
                	out.println("<p> Total amount = " + Integer.parseInt((String) request.getAttribute("price")) * temp + "</p>");
                	out.println("<p> Wallet balance = " + Integer.parseInt((String) request.getAttribute("wallet")) * temp + "</p>");
                	
                %>

                    <button type = "submit" class="btn btn-primary"> <b> Add </b></button>
            </form>
        </font>

    </div>

</body>

</html>