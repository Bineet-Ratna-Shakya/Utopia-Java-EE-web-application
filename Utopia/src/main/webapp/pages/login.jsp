<%@ page import="utils.StringUtils" %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String contextPath = request.getContextPath();
String errMsg = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
String successMsg = (String) request.getAttribute(StringUtils.MESSAGE_SUCCESS);
String username = (String) request.getAttribute(StringUtils.MESSAGE_ERROR);
String successParam = request.getParameter(StringUtils.SUCCESS);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../stylesheets/login.css" />
    <link
    href="https://fonts.googleapis.com/css?family=Italiana"
    rel="stylesheet"
  />
  <link
    href="https://fonts.googleapis.com/css2?family=Lacquer&display=swap"
    rel="stylesheet"
  />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Utopia Login</title>
</head>
<body>
    <div class="front-image">
       
        <div class="utopia-header">
          <h1>Utopia</h1>
        </div>
        <div class="navlinks">
          <a href="index.html">Home</a>
          <a href="products.html">Products</a>
          <a href="#">Explore</a>
          <a href="#">Collections</a>
          <a href="login.html">User</a>
        </div>   
        
        <div class="container">
            <header>
                <h2>Login</h2>
              </header>
              <form action="<%=request.getContextPath()%>/login" method="post">    
                <div class="form-group">
                  <label for="phone"></label>
                  <input type="tel" id="phone" name="phoneNumber" placeholder="PhoneNumber" required>
                </div>
                <div class="form-group">
                  <label for="password"></label>
                  <input type="password" id="password" name="password" placeholder="Password" required>
                </div>
                <button type="submit">Login</button>
                
              </form>
          </div>
          
          <div class="additional-info">
            <h1>Not a Member Yet?</h1>
          </div>
          <div class="memberbutton">
            <button>
            <a href="register.jsp">Join Now</a>
            </button>
          </div>
</body>
</html>