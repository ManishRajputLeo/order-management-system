# 🛒 Order Management System

## 📌 Overview

This is a Spring Boot-based **Order Management System** that demonstrates how to manage relationships between entities like **Store, Product, Customer, and Order** using JPA and Hibernate.

The project focuses on:

* Entity relationships (One-to-Many, Many-to-One)
* Fetching data using primary keys
* Updating records while maintaining referential integrity

---

## 🧰 Tech Stack

* Java
* Spring Boot
* Spring Data JPA (Hibernate)
* MySQL
* Lombok

---

## 🗂️ Database Design

### Entities & Relationships

* **Store**

  * `storeId` (Primary Key)
  * One Store → Many Products

* **Product**

  * `productId` (Primary Key)
  * `productName`
  * Many Products → One Store

* **Customer**

  * `id` (Primary Key)
  * One Customer → Many Orders

* **Order**

  * `orderId` (Primary Key)
  * Many Orders → One Customer
  * Many Orders → One Product

---

## 🔗 Entity Relationship Flow

Store → Product → Order ← Customer

---

## 🚀 Features

* Get all orders
* Get order by ID
* Update order using primary key
* Maintain foreign key relationships
* Prevent infinite JSON recursion

---

## 📡 API Endpoints

### 🟢 Order APIs

#### Get All Orders

```
GET /api/orders/all-orders
```

#### Get Order By ID

```
GET /api/orders/get/{id}
```

#### Update Order

```
PUT /api/orders/{id}
```

### 📥 Sample Request Body (Update Order)

```json
{
  "customer": {
    "id": 2
  },
  "product": {
    "productId": 1
  }
}
```

---

## 🧪 Database Setup

Insert data manually using MySQL Workbench:

```sql
-- Store
INSERT INTO store (store_id) VALUES (1);

-- Customer
INSERT INTO customer (id) VALUES (1);

-- Product
INSERT INTO product (product_id, product_name, store_id)
VALUES (1, 'Laptop', 1);

-- Order
INSERT INTO orders (order_id, customer_id, product_id)
VALUES (1, 1, 1);
```

---

## ⚠️ Key Challenges Solved

* Fixed foreign key constraint errors by maintaining insertion order
* Resolved infinite recursion using `@JsonIgnore`
* Implemented partial update logic to avoid null overwrites
* Standardized ID types across entities

---

## 🧠 Learning Outcomes

* Understanding JPA relationships
* Handling bidirectional mapping
* Managing JSON serialization issues
* Performing updates using primary keys

---

## ▶️ How to Run

1. Clone the repository:

```
git clone https://github.com/ManishRajputLeo/order-management-system.git
```

2. Navigate to the project folder:

```
cd order-management-system
```

3. Configure database in `application.properties`

4. Run the application:

```
mvn spring-boot:run
```

---


## 📌 Notes

* Data is inserted manually via database (no create APIs used)
* Focus is on retrieval and update operations
* Designed for learning and demonstration purposes

## 👨‍💻 Author

Manish Kumar
