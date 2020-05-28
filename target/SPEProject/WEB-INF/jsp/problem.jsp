<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/problem.css">

	<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.2.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="js/problem.js">
	</script>
	<script>
		iframe = document.getElementById("editor1");
		innerDoc = iframe.contentDocument || iframe.contentWindow.document;
		innerDoc.getElementById("editor").setvalue(${code});
	</script>
	<title>
		Problem
	</title>
</head>
<body>
<form id="form" method="POST">
	<div class="split left">

		<div class="topnav">
			<a id="C" onclick="language('C')">C</a>
			<a id="C++" onclick="language('C++')" class="active">C++</a>
			<a id="Java" onclick="language('Java')">Java</a>
			<a id="Python" onclick="language('Python')">Python</a>
			<input type="hidden" id="maincontent" name="content" style="display: none;">
			<input type="hidden" id="username" name="test" style="display: none;" value="${username}">
			<input type="hidden" id="id" name="test" style="display: none;" value="${id}">

		</div>

		<div class="topnav bottom" id="bottomnav">
			<a id="test">Test</a>
			<a id="submit">Submit</a>
			<a class="collapse" id="wa"> &#10060; Wrong Answer</a>
			<a class="collapse" id="ce"> &#10067; Compilation Error</a>
			<a class="collapse" id="ra"> <span>&#x2714;</span>  Right Answer</a>
			<a class="collapse" id="tcp"> <span>&#x2714;</span> Test Case Passed</a>
			<p align="center"><i class="arrow up" id="arrow" onclick="opposite()"></i></p>
		</div>

		<div class="collapse" id="inputoutput">
			<div class="column">
				<h3>Input</h3>
				<textarea class="input" id="input" cols="59%" rows="10%" ></textarea>
			</div>
			<div class="column">
				<h3>Output</h3>
				<textarea class="input" id="output" cols="59%" rows="10%" readonly ></textarea>
			</div>
		</div>
		<div class="collapse" id="errorbox">
			<div class="column">
				<h3>Error</h3>
				<textarea class="input" id="error" cols="125%" rows="10%"></textarea>
			</div>
		</div>

		<div>
			<iframe src="ace1.html" width="100%" height="800px" id="editor1">
			</iframe>
		</div>
	</div>
</form>

<div class="split right">
	<div class="topnav">
		<a class="active" onclick="rightcontroller('question.html','${pid}')" id="question.html">Question</a>
		<a onclick="rightcontroller('program.cpp','${pid}')" id="program.cpp">Editorial</a>
		<a onclick="rightcontroller('discussion.html','${pid}')" id="discussion.html">Discussion</a>
	</div>
	<div>
		<iframe src="Problems/${pid}/question.html" width="100%" onload="this.style.height=(this.contentDocument.body.scrollHeight+800) +'px';" id="myFrame"></iframe>
	</div>
</div>

</body>
</html>
