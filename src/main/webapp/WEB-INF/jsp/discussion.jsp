<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="css/discussion.css"/>
    <link rel="stylesheet" type="text/css" href="css/home.css"/>
    <script type="text/javascript" src="js/home.js"></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script src='https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js'></script>
    <link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'>
    <title>
        Discussion
    </title>
        <c:if test="${not empty result}">
        <script type="text/javascript">
            window.addEventListener("load",function(){
                alert("${result}");
            })
        </script>
            <script>
                window.addEventListener("load",function(){
                    if(document.getElementById("username").value!="nisarg20")
                    {
                        document.getElementById("hostcontest").className += "collapse";
                    }
                })
            </script>
        </c:if>
</head>
<body>

<div class="topnav">
    <a id="problems_list" href="home">Problems</a>
    <a id="upcoming_contests" href="upcoming_contests">Upcoming Contests</a>
    <a id="leaderboard" href="leaderboard"> Leaderboard</a>
    <a id="discussion" href="discussion" class="active">Discussion</a>
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
<form action="/discussion" method="POST">
    <div style="background-color: #E2EBF4;padding : 10px;margin: 20px;">
        <textarea rows="3" cols="150" style="width:100%;" id="comment" name="comment" wrap="hard" placeholder="Enter your comment"></textarea>
        <br/>
        <button type="submit" id="submit" style="width:60px;height:35px;vertical-align: middle;">Post</button>
    </div>
    <c:forEach var="item" items="${discussion}">
    <div style="background-color: #E2EBF4;padding : 10px;margin: 20px;">
            <text style="font-weight: bold; font-size: 17px">${item.username}</text>
            <br/>
            <text style="font-size: 13px">Posted on ${item.doj}</text>
            <br/>
            <pre style="background-color : white;">${item.comment}</pre>

    </div>
    </c:forEach>
</form>
</body>
</html>

