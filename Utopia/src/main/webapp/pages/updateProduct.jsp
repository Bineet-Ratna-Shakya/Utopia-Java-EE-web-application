
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
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Utopia Admin Dashboard</title>
<link rel="stylesheet" type="text/css" href="<%=contextPath%>/stylesheets/updateproduct.css" />
<link href="https://fonts.googleapis.com/css?family=Italiana"
	rel="stylesheet" />
<link
	href="https://fonts.googleapis.com/css2?family=Lacquer&display=swap"
	rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
</head>
<body>

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
   
	
	
    <%-- Check if the product attribute is available --%>
    
    <div class="container">
        <c:if test="${not empty product}">
            <form action="<%=request.getContextPath()%>/updateProductAction" method="POST" class="product-form">
                <input type="hidden" name="productId" value="${product.productId}">
                
                <div class="form-group">
                    <label for="productName">Product Name:</label>
                    <input type="text" id="productName" name="productName" value="${product.productName}" required>
                </div>

                <div class="form-group">
                    <label for="productDescription">Description:</label>
                    <textarea id="productDescription" name="productDescription" required>${product.productDescription}</textarea>
                </div>

                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" id="price" name="price" value="${product.price}" required>
                </div>

                <div class="form-group">
                    <label for="productImage">Image URL:</label>
                    <input type="text" id="productImage" name="productImage" value="${product.productImage}">
                </div>

                <div class="form-group">
                    <input type="submit" value="Update Product">
                </div>
            </form>
        </c:if>
        <c:if test="${empty product}">
            <p>Product not found or unavailable for update.</p>
        </c:if>
    </div>
  

</body>
</html>

