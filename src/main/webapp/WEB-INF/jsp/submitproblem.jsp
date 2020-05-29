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
        Submit Problem
    </title>
</head>
<body>

<div class="topnav">
    <a id="problems_list" href="home">Problems</a>
    <a id="upcoming_contests" href="upcoming_contests">Upcoming Contests</a>
    <a id="leaderboard" href="leaderboard"> Leaderboard</a>
    <a id="discussion" href="discussion" >Discussion</a>
    <a id="submitproblem" href="submitproblem" class="active">Create Problem</a>
    <a id="hostcontest" href="hostcontest">Host Contest</a>
    <input type="hidden" name="username" id="username" value="${username}">
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
<div style="padding-top:16px" id="page">
    <h2>Submit a problem</h2>

    <p><label>Problem Description</label>
        <textarea class="w3-input w3-border" name="first" type="text"></textarea></p>

    <p><label>Sample Input</label>
        <textarea class="w3-input w3-border" name="last" type="text"></textarea></p>

    <p><label>Sample Output</label>
        <textarea class="w3-input w3-border" name="last" type="text"></textarea></p>

    <button style="width:120px; height:30px;">Submit</button>

</div>
</body>
</html>

