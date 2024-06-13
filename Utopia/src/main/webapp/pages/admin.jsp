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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/revisedAdmin.css" />
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
      <div class="utopia-header">
        <h1>Utopia</h1>
       
      </div>
      <div class='header-2'>
        <h2>ADMIN</h2>
      </div>
      <div class="navlinks">
        <a href="index.html">Home</a>
        <a href="products.html">Products</a>
        <a href="#">Explore</a>
        <a href="#">Collections</a>
        <a href="admin.html">Dashboard</a>
      </div>

    <div class="order-summary">
      <h1>Order Summary</h1>
    </div>
    <div class="total-products">
      <h1>Total Products</h1>
      <h2>1</h2>
    </div>
    <div class="total-user">
      <h1>Total Users</h1>
      <h2>2</h2>
    </div>
    <div class="sidenav">
      <h1>Utopia</h1>
    </div>

    <div class="add-product">
      <a href="addproduct.html">
        <h1>Add Product</h1>
      </a>
    </div>

 

    
  <div class="table-container">
    <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Image</th>
                    <th>Update</th>
                    <th>Delete</th>
                </tr>
            </thead>
        </div>
            <tbody>
                <c:forEach var="product" items="${productsList}">
                    <tr>
                        <td>${product.productId}</td>
                        <td>${product.productName}</td>
                        <td>${product.productDescription}</td>
                        <td>${product.price}</td>
                        <td><img src="${product.productImage}" alt="Product Image"></td>
                        <td><button onclick="location.href='<%=contextPath%>/update?id=${product.productId}'">Update</button></td>
                        <td><button onclick="if(confirm('Are you sure you want to delete this product?')) location.href='<%=contextPath%>/deleteProduct?id=${product.productId}'">Delete</button></td>
                    </tr>
                </c:forEach>
            </tbody>
        </div>
    </table>
</div>
</body>
</html>
