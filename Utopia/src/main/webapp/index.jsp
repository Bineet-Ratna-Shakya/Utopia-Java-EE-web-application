<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Utopia</title>
	<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/stylesheets/index.css" />    <link
      href="https://fonts.googleapis.com/css?family=Italiana"
      rel="stylesheet"
    />
    <link
      href="https://fonts.googleapis.com/css2?family=Lacquer&display=swap"
      rel="stylesheet"
    />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

  </head>
  <body>
    <div class="front-image">
      <img src="./resources/topimage.jpg" alt="topimage" />
      <div class="utopia-header">
        <h1>Utopia</h1>
      </div>
      <div class="navlinks">
        <a href="<%=request.getContextPath()%>/index.jsp">Home</a>
        <a href="<%=request.getContextPath()%>/product">Products</a>
        <a href="">Explore</a>
        <a href="">Collections</a>
        <a href="<%=request.getContextPath()%>/pages/login.jsp">User</a>
      </div>

      <div class="image-content">
        <h1>Everlasting Radiance</h1>
      </div>

      <div class="image-button">
        <button>
          <h1>Discover More</h1>
        </button>
      </div>w
    </div>

    <div class="headertwo">
      <div class="headertext">
        <h1>World Of Utopia</h1>
      </div>
    </div>

    <div class="table-Images">
      <div class="grid-item item1">
        <img src="./resources/image1.jpeg" alt="Image 1" />
      </div>
      <div class="grid-item item2">
        <img src="./resources/image2.webp" alt="Image 2" />
      </div>
      <div class="grid-item item3">
        <img src="./resources/image3.avif" alt="Image 3" />
      </div>
      <div class="grid-item item4">
        <img src="./resources/image4.jpeg" alt="Image 4" />
      </div>
      <div class="grid-item item5">
        <img src="./resources/image5.webp" alt="Image 5" />
      </div>
      <div class="grid-item item6">
        <img src="./resources/image6.avif" alt="Image 6" />
      </div>
      <div class="grid-item item7">
        <img src="./resources/image7.avif" alt="Image 7" />
      </div>
      <div class="grid-item item8">
        <img src="./resources/image8.jpeg" alt="Image 8" />
      </div>
    </div>

    <div class="headerthree">
      <div class="headertextthree">
        <h1>Our Stories</h1>
      </div>
    </div>

    <div class="thirdpart">
      <div class="'ourstories-images">
        <div class="ourstories-images item9">
          <img src="./resources/image9.jpeg" alt="Image 9" />
        </div>
      </div>
      <div class="ourstories-text">
        <h1>Utopian Collections</h1>
        <h2>From the deepest parts of the world</h2>
      </div>

      <div class="'ourstories-images2">
        <div class="ourstories-images item10">
          <img src="./resources/image10.jpg" alt="Image 1" />
        </div>
      </div>
      <div class="ourstories-text2">
        <h1>
          I have enough Jewelery <br />
          -No one ever.
        </h1>
      </div>
    </div>

    <div class="footer-content">
      <p>© 2024 Utopia. All rights reserved.</p>
      <div class="footer-links">
        <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a> |
        <a href="#">Contact Us</a>
      </div>
    </div>

    <!--<script src="script.js"></script>-->
  </body>
</html>
