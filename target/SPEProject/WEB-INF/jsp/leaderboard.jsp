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
        Leaderboard
    </title>
    <style>
        tr:first-child
        {
            counter-reset: Serial;           /* Set the Serial counter to 0 */
        }

        table
        {
            border-collapse: separate;
        }

        tr td:first-child:before
        {
            counter-increment: Serial;      /* Increment the Serial counter */
            content:counter(Serial); /* Display the counter */
        }
    </style>
</head>
<body>

<div class="topnav">
    <a id="problems_list" href="home">Problems</a>
    <a id="upcoming_contests" href="upcoming_contests">Upcoming Contests</a>
    <a id="leaderboard" href="leaderboard" class="active">Leaderboard</a>
    <a id="discussion" href="discussion" >Discussion</a>
    <a id="submitproblem" href="submitproblem" >Create Problem</a>
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
<div id="table1">
    <table align="center" id = "problems" width="400px">
        <thead>
        <tr>
            <colgroup>
                <col span="1" style="width: 10%;">
                <col span="1" style="width: 40%;">
                <col span="1" style="width: 16.66%;">
                <col span="1" style="width: 16.66%;">
                <col span="1" style="width: 16.66%;">
            </colgroup>
            <th>SNo</th>
            <th>UserName</th>
            <th>Easy</th>
            <th>Medium</th>
            <th>Hard</th>
            <th>Points</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${leaderboard}">
            <tr >
                <td></td>
                <td>${item.username}</td>
                <td>${item.easy}</td>
                <td>${item.medium}</td>
                <td>${item.hard}</td>
                <td>${item.points}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

