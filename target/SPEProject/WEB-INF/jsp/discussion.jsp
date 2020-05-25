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
<div class="container-fluid mt-100">
    <div class="row">
        <div class="col-md-12">
            <div class="card mb-4">
                <div class="card-header">
                    <div class="media flex-wrap w-100 align-items-center"> <img src="https://res.cloudinary.com/dxfq3iotg/image/upload/v1574583246/AAA/2.jpg" class="d-block ui-w-40 rounded-circle" alt="">
                        <div class="media-body ml-3"> <a href="javascript:void(0)" data-abc="true">Nisarg20</a>
                            <div class="text-muted small">1 day ago</div>
                        </div>
                        <div class="text-muted small ml-3">
                            <div>Member since <strong>23/05/2020</strong></div>
                            <div><strong>3</strong> posts</div>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <p> For me, getting my business website made was a lot of tech wizardry things. Thankfully i get an ad on Facebook ragarding commence website. I get connected with BBB team. They made my stunning website live in just 3 days.
                        With the increase demand of online customers. I had to take my business online. BBB Team guided me at each step and enabled me to centralise my work and have control on all aspect of my online business.
                    </p>
                    <p> For me, getting my business website made was a lot of tech wizardry things. Thankfully i get an ad on Facebook ragarding commence website. I get connected with BBB team. They made my stunning website live in just 3 days.
                        With the increase demand of online customers. I had to take my business online. BBB Team guided me at each step and enabled me to centralise my work and have control on all aspect of my online business.
                    </p>
                </div>
                <div class="card-footer d-flex flex-wrap justify-content-between align-items-center px-0 pt-0 pb-3">
                    <div class="px-4 pt-3"> <a href="javascript:void(0)" class="text-muted d-inline-flex align-items-center align-middle" data-abc="true"> <i class="fa fa-heart text-danger"></i>&nbsp; <span class="align-middle">5</span> </a> <span class="text-muted d-inline-flex align-items-center align-middle ml-4"> <i class="fa fa-eye text-muted fsize-3"></i>&nbsp; <span class="align-middle">10</span> </span> </div>
                    <div class="px-4 pt-3"> <button type="button" class="btn btn-primary"><i class="ion ion-md-create"></i>&nbsp; Reply</button> </div>
                </div>
                <br/>
                <br/>
                <br/>
                <div class="card-header">
                    <div class="media flex-wrap w-100 align-items-center"> <img src="https://res.cloudinary.com/dxfq3iotg/image/upload/v1574583246/AAA/2.jpg" class="d-block ui-w-40 rounded-circle" alt="">
                        <div class="media-body ml-3"> <a href="javascript:void(0)" data-abc="true">nirmal29</a>
                            <div class="text-muted small">Today</div>
                        </div>
                        <div class="text-muted small ml-3">
                            <div>Member since <strong>24/05/2020</strong></div>
                            <div><strong>1</strong> post</div>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <p> Hello Everyone. How to solve the 1st question
                    </p>
                </div>
                <div class="card-footer d-flex flex-wrap justify-content-between align-items-center px-0 pt-0 pb-3">
                    <div class="px-4 pt-3"> <a href="javascript:void(0)" class="text-muted d-inline-flex align-items-center align-middle" data-abc="true"> <i class="fa fa-heart text-danger"></i>&nbsp; <span class="align-middle">1</span> </a> <span class="text-muted d-inline-flex align-items-center align-middle ml-4"> <i class="fa fa-eye text-muted fsize-3"></i>&nbsp; <span class="align-middle">1</span> </span> </div>
                    <div class="px-4 pt-3"> <button type="button" class="btn btn-primary"><i class="ion ion-md-create"></i>&nbsp; Reply</button> </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

