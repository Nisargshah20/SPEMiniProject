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
	<a id="upcoming_contests" href="upcoming_contests" class="active">Upcoming Contests</a>
	<a id="leaderboard" href="leaderboard"> Leaderboard</a>
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
<div>
	<table align="center">
		<tr>
			<colgroup>
				<col span="1" style="width: 29%;">
				<col span="1" style="width: 16%;">
				<col span="1" style="width: 16%;">
				<col span="1" style="width: 16%;">
			</colgroup>
			<th>Name</th>
			<th>Start Time</th>
			<th>Date</th>
			<th>Length</th>
		</tr>
		<tr>
			<td>IIITB Code</td>
			<td>12:00</td>
			<td>28/05/2020</td>
			<td>2 hours</td>
		</tr>
		<tr>
			<td>Snackdown</td>
			<td>21:30</td>
			<td>30/05/2020</td>
			<td>2:30 hours</td>
		</tr>
		<tr>
			<td>Hackathon</td>
			<td>21:00</td>
			<td>31/05/2020</td>
			<td>3 hours</td>
		</tr>
	</table>
</div>
</body>
</html>

