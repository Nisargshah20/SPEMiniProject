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
	<script>
		function addquestion(){
			var newq = document.getElementById("q").cloneNode(true);
			document.getElementById("t").appendChild(newq);

		}
		function removequestion(){

			var tab = document.getElementById("t");
			tab.removeChild(tab.lastChild);

		}
	</script>
	<title>
		Home
	</title>
</head>
<body>

<div class="topnav">
	<a id="problems_list" href="home">Problems</a>
	<a id="upcoming_contests" href="upcoming_contests">Upcoming Contests</a>
	<a id="leaderboard" href="leaderboard"> Leaderboard</a>
	<a id="discussion" href="discussion" >Discussion</a>
	<a id="submitproblem" href="submitproblem" >Create Problem</a>
	<a id="hostcontest" href="hostcontest" class="active">Host Contest</a>
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
	<h2>Host a Contest</h2>

	<p><label>Problem Name</label>
		<input class="w3-inputa w3-border" name="first" type="text"></p>

	<p><label>Contest Length</label>
		<input class="w3-inputa w3-border" name="last" type="time"></p>
	<p><label>Date</label>
		<input class="w3-inputa w3-border" name="last" type="date"></p>
	<p><label>Start Time</label>
		<input class="w3-inputa w3-border" name="last" type="time"></p>


	<button onclick="addquestion()">Add Question</button>
	<button onclick="removequestion()">Remove Question</button>
	</br>
	</br>

	<table id="t">
		<tr>
			<colgroup>
				<col span="1" style="width: 16%;">
				<col span="1" style="width: 16%;">
				<col span="1" style="width: 16%;">
				<col span="1" style="width: 16%;">
				<col span="1" style="width: 16%;">
			</colgroup>
			<th>Time Limit</th>
			<th>Question</th>
			<th>Input</th>
			<th>Output</th>
			<th>Points</th>
		</tr>
		<tr id="q">
			<th> <input class="w3-inputa w3-border" type="number"></th>
			<th> <input type="file"></th>
			<th> <input type="file"></th>
			<th> <input type="file"></th>
			<th> <input class="w3-inputa w3-border" type="text"></th>
		</tr>
	</table>
	</br>
	</br>
	<button style="width:120px; height:30px;">Submit</button>
</div>

</body>
</html>

