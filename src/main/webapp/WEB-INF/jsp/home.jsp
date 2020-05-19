<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<script type="text/javascript" src="js/home.js"></script>
		<div class="topnav">
		  <a id="problems_list.html" class="active" onclick="myfun('problems_list.html')">Problems</a>
		  <a id="upcoming_contests.html" onclick="myfun('upcoming_contests.html')">Upcoming Contests</a>
		  <a id="leaderboard.html" onclick="myfun('leaderboard.html')">Leaderboard</a>
		  <a id="discussion.html" onclick="myfun('discussion.html')">Discussion</a>
		</div>

		<div style="padding-top:16px" id="page">
		<iframe src="problems_list.html" width="100%" height="400px" frameborder="0" id="myFrame"></iframe>
		</div>
	</body>
</html>

