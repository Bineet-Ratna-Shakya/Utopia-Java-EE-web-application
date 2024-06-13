<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" type="text/css" href="../stylesheets/registration.css" />
    <link
      href="https://fonts.googleapis.com/css?family=Italiana"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/css2?family=Lacquer&display=swap"
      rel="stylesheet"
    />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Utopia Registration</title>
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


    <div class="container">
        <h1>Register</h1>
        <form action="<%=request.getContextPath()%>/registeruser" method="post">
  
    <div class="form-group">
        <label for="firstName">First Name</label>
        <input type="text" name="firstName" id="firstName" required>
    </div>
    <div class="form-group">
        <label for="lastName">Last Name *</label>
        <input type="text" name="lastName" id="lastName" required>
    </div>
   
    <div class="form-group">
        <label for="email">Email *</label>
        <input type="email" name="email" id="email" required>
    </div>
    <div class="form-group">
        <label for="phone">Telephone *</label>
        <input type="tel" name="phoneNumber" id="phone" required>
    </div>
    <div class="form-group">
        <label for="password">Set a password *</label>
        <input type="password" name="password" id="password" required>
    </div>
    <div class="form-group">
        <label for="confirm_password">Confirm Password *</label>
        <input type="password" name="confirm_password" id="confirm_password" required>
    </div>
    <!-- Add any other fields if necessary -->
    <button type="submit">Register</button>
</form>
    </div>
    </div>
      
</body>
</html>