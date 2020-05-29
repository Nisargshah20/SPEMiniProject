<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Signup</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://smtpjs.com/v3/smtp.js"></script>
    <script type="text/javascript" src="js/signup.js"></script>
    <c:if test="${not empty result}">
        <script type="text/javascript">
            window.addEventListener("load",function(){
                alert("${result}");
            })
        </script>
    </c:if>
    <style type="text/css">
        body
        {
            background : url("coding.jpg") no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }
        .login-form {
            width: 340px;
            margin: 50px auto;
        }
        .login-form form {
            margin-bottom: 15px;
            background: #f7f7f7;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }
        .login-form h2 {
            margin: 0 0 15px;
        }
        .form-control, .btn {
            min-height: 38px;
            border-radius: 2px;
        }
        .btn {
            font-size: 15px;
            font-weight: bold;
        }
        .center {
            display: block;
            margin-left: auto;
            margin-right: auto;
            width: 200px;
        }
    </style>

</head>
<body>

<div class="login-form">
    <form id="signup" action="/signup" onsubmit="return signupuser()" method="post">
        <h2 class="text-center">Welcome</h2>
        <img src = "iiitb_logo.jpg" width=200 height=150 class="center">
        <br></br>
        <div class="form-group">
            <input type="text" name="email" id="email" class="form-control" placeholder="Email">
        </div>
        <div class="form-group">
            <input type="password" name="password" id="password" class="form-control" placeholder="Password">
        </div>
        <div class="form-group">
            <input type="password" id="confirmpassword" class="form-control" placeholder="Confirm Password">
        </div>
        <div class="form-group">
            <input type="text" name="username" id="username" class="form-control" placeholder="Username">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Sign Up</button>
        </div>
        <div class="form-group" align=center>
            <span class="psw">Already Have an account?<a href="/index">Login</a></span>
        </div>
    </form>

</div>
</body>
</html>