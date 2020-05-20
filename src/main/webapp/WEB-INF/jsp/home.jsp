<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="css/home.css"/>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="text/javascript" src="js/home.js"></script>
		<title>
			Home
		</title>
	</head>
	<body>

	<script type="text/javascript" src="js/home.js">

	</script>
		<div class="topnav">
		  <a id="problems_list.html" class="active">Problems</a>
		  <a id="upcoming_contests.html" onclick="myfun('upcoming_contests.html')">Upcoming Contests</a>
		  <a id="leaderboard.html" onclick="myfun('leaderboard.html')">Leaderboard</a>
		  <a id="discussion.html" onclick="myfun('discussion.html')">Discussion</a>
		  <a id="submitproblem.html" onclick="myfun('submitproblem.html')">Create Problem</a>
		  <a id="hostcontest.html" onclick="myfun('hostcontest.html')">Host Contest</a>
		  <b id="username" align="right">Hello ${username}</b>
		</div>
		<br/>
		<br/>
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
				<th>Problem name</th>
				<th>Difficulty</th>
				<th>Topic</th>
				<th>Accuracy</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${problems}">
				<c:set var="accuracy"  value="${(item.solved / item.attempted)*100}"/>
				<tr >
					<td>${item.id}</td>
					<td>${item.name}</td>
					<td>${item.difficulty}</td>
					<td>${item.topic}</td>
					<td>${accuracy}%</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</body>
</html>

