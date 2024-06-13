<%@page import="utils.StringUtils" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String contextPath = request.getContextPath();
%>



<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" >
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Utopia Admin Dashboard</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/addproduct.css" />
    <link
      href="https://fonts.googleapis.com/css?family=Italiana"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/css2?family=Lacquer&display=swap"
      rel="stylesheet"
    />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
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
    </div>

<div class="add-product-form">
    <h2>Add Product</h2>
    <form action="<%=request.getContextPath() + StringUtils.SERVLET_URL_ADD_PRODUCT%>" method="post" enctype="multipart/form-data">
      
        <label for="product_name">Product Name:</label><br>
        <input type="text" id="product_name" name="product_name"><br><br>

        <label for="product_description">Product Description:</label><br>
        <input type="text" id="product_description" name="product_description"><br><br>

        <label for="product_price">Product Price:</label><br>
        <input type="text" id="product_price" name="product_price"><br><br>

        <label for="product_image">Product Image:</label><br>
        <input type="file" id="product_image" name="product_image"><br><br>

        <input type="submit" value="Add Product">
    </form>
</div>
</body>
</html>
