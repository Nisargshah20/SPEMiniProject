<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/home.css"/>
    <script type="text/javascript" src="js/home.js"></script>
    <title>
        Home
    </title>
</head>
<body>

<div class="topnav">
    <a id="problems_list" href="home">Problems</a>
    <a id="upcoming_contests" href="upcoming_contests">Upcoming Contests</a>
    <a id="leaderboard" href="leaderboard"> Leaderboard</a>
    <a id="discussion" href="discussion" class="active">Discussion</a>
    <a id="submitproblem" href="submitproblem" >Create Problem</a>
    <a id="hostcontest" href="hostcontest">Host Contest</a>
    <div class="dropdown">
        <button class="dropbtn">${username}
            <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
            <a>Account</a>
            <a href="/logout">Logout</a>
        </div>
    </div>
</div>
<br/>
<br/>
<div>
    This is discussion page.
</div>

</body>
</html>

