<%@ page import="model.productModel"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="utils.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>


<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Utopia products</title>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/revisedProduct.css" />
<link href="https://fonts.googleapis.com/css?family=Italiana" rel="stylesheet" />
<link href="https://fonts.googleapis.com/css2?family=Lacquer&display=swap" rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>
  	<div class="front-image">
        <img src="./resources/image10.jpg" alt="topimage" />
        <div class="utopia-header">
            <h1>Utopia</h1>
        </div>
        <div class="navlinks">
            <a href="index.html">Home</a> 
            <a href="">Products</a>
             <a href="#">Explore</a> 
             <a href="#">Collections</a> 
             <a href="login.html">User</a>
        </div>

        <div class="image-content">
            <h1>Shop Rings</h1>
        </div>
    </div>
    
    <div class="grid-container">
    
        <!-- Iterate over products and generate grid items -->
        <c:forEach var="product" items="${productsList}">
            <div class="card">
                <!-- Display product image -->
				<img src="./resources/topimage.jpg">
                <!-- Display product name -->
                <h4>${product.productName}</h4>

                <!-- Display product price -->
                <h5>$${product.price}</h5>
            </div>
        </c:forEach>
        </div>
</body>
</html>
