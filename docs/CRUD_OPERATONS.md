# CRUD Implementation - Shopyra Backend

## 📌 Overview

This module implements the complete CRUD (Create, Read, Update, Delete) operations for the Product entity using Spring Boot, Spring Data JPA, MySQL, and REST APIs.

---

## ✅ CRUD Operations

### 1. Create Product

**Endpoint**

```
POST /api/products
```

**Description**

Creates a new product and stores it in the MySQL database.

---

### 2. Get All Products

**Endpoint**

```
GET /api/products
```

**Description**

Returns the complete list of products.

---

### 3. Get Product By ID

**Endpoint**

```
GET /api/products/{id}
```

**Description**

Returns the product matching the given ID.

---

### 4. Update Product

**Endpoint**

```
PUT /api/products/{id}
```

**Description**

Updates an existing product. If the product ID does not exist, a custom exception is thrown.

---

### 5. Delete Product

**Endpoint**

```
DELETE /api/products/{id}
```

**Description**

Deletes a product from the database. If the product does not exist, a custom exception is returned.

---

## 📮 API Testing

All endpoints were tested using **Postman**.

Verified operations:

- Create Product
- Get All Products
- Get Product By ID
- Update Product
- Delete Product
- Product Not Found Exception

---

## 🚀 Learning Outcome

This implementation helped me understand how a Spring Boot application is structured using layered architecture and how CRUD operations are developed following REST API best practices.