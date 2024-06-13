# Utopia Jewelry Store

Utopia is an online jewelry store offering high-end jewelry and exclusive stoneworks to customers. The project focuses on providing a premium shopping experience with a curated collection of jewels and customizable options.

## Table of Contents

- [Project Overview](#project-overview)
- [Business Model](#business-model)
- [Target Audience](#target-audience)
- [Unique Selling Propositions](#unique-selling-propositions)
- [Platform Selection](#platform-selection)
- [Database Design](#database-design)
- [Wireframes](#wireframes)
- [Prototype](#prototype)
- [Class Diagram](#class-diagram)
- [Method Descriptions](#method-descriptions)
- [Authors](#authors)
- [License](#license)

## Project Overview

This project goal is to create a sophisticated online platform for selling luxury jewelry.

## Business Model

Utopia operates on a business model focused on:
- Providing high-end jewelry and exclusive stoneworks.
- Collaborating with premium suppliers and fashion outlets.
- Offering customizable jewelry options.
- Targeting individuals, collectors, and social-media influencers.

## Target Audience

Utopia's target audience includes:
- Wealthy individuals looking for high-quality pieces.
- Collectors seeking rare and unique jewelry.
- Social-media influencers and celebrities who set trends.

## Unique Selling Propositions

1. **Exquisite Craftsmanship**: Superior quality and attention to detail.
2. **Exclusive Designs**: Unique and limited-edition pieces.
3. **Premium Materials**: High-quality, conflict-free materials.
4. **Personalized Service**: Custom designs and VIP treatment.
5. **Designer Collaborations**: Special collections with renowned designers.
6. **Heritage and Legacy**: Rich history of excellence and innovation.
7. **Lifetime Warranty**: Assurance of quality and longevity.
8. **Customization Options**: Personalized jewelry designs.
9. **Customer Loyalty Program**: Exclusive perks and discounts.

## Platform Selection

The project utilizes the following tools and technologies:
- **Eclipse IDE**: For Java development.
- **Java Programming**: For object-oriented programming.
- **Java EE**: For building large-scale web applications.
- **XAMPP**: For local web development.
- **MySQL**: For database management.
- **Tomcat Server**: For running Java-based web applications.

## Database Design

The database design follows normalization principles:
1. **Unnormalized Form**
2. **First Normal Form (1NF)**
3. **Second Normal Form (2NF)**
4. **Third Normal Form (3NF)**

### Final Entities & Attributes

- **User Table**
  - User-ID (Primary Key)
  - User-First-Name
  - User-Last-Name
  - User-Email
  - User-Password
  - User-Phone
  - User-Is-Admin

- **Product Table**
  - Product-ID (Primary Key)
  - Product-Name
  - Product-Description
  - Price
  - Product-Image

## Wireframes

- **Homepage**
- **Login Page**
- **Product Page**
- **Registration Page**
- **Admin Page**

## Prototype

### Home Page Prototype

![Home Page](path/to/homepage_prototype.png)

### Login Page Prototype

![Login Page](path/to/login_prototype.png)

### Product Page Prototype

![Product Page](path/to/product_prototype.png)

### Registration Page Prototype

![Registration Page](path/to/registration_prototype.png)

### Admin Dashboard

![Admin Dashboard](path/to/admin_dashboard.png)

## Class Diagram

### Individual Class Diagram
- **Servlets**
  - Add Product Servlet
  - Admin Servlet
  - Login Servlet
  - Product Servlet
  - Register Servlet
  - Update Product Action Servlet
  - Update Product Servlet
  - Delete Product Servlet
  - Logout Servlet

- **Filters**
  - Authentication Filter

- **Utils**
  - Validation Utils
  - String Utils

- **Models**
  - Password Encryption Model
  - Product Model
  - Utopia Model
  - Login Model

## Method Descriptions

### Controllers

- **DatabaseController**
  - `getConnection()`
  - `registerUser()`
  - `getUserLoginInfo()`
  - `isUserAdmin()`
  - `addProduct()`
  - `retrieveProductsFromDatabase()`
  - `getProductById()`
  - `updateProduct()`
  - `deleteProduct()`

### Models

- **Login Model**
  - `loginModel()`
  - Getters & Setters


## Authors

- Bineet Ratna Shakya

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
