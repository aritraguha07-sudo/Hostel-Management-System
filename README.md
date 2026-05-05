# 🏠 Hostel Management System

A full-stack web application to manage hostel operations including student records, room management, and room allocation.

---

## 🚀 Features

* Add, view, and delete students
* Add and manage hostel rooms
* Allocate students to rooms based on capacity
* Dynamic dashboard UI for easy interaction
* REST API-based backend

---

## 🛠 Tech Stack

**Backend**

* Java
* Spring Boot
* Spring Data JPA
* REST APIs

**Database**

* MySQL

**Frontend**

* HTML
* CSS
* JavaScript

**Tools**

* Git & GitHub
* Swagger (API testing)
* IntelliJ IDEA

---

## 📂 Project Structure

```text
src/
 ├── controller/
 ├── service/
 ├── repository/
 ├── model/
resources/
 ├── static/
```

---

## ⚙️ Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/aritraguha07-sudo/Hostel-Management-System.git
```

### 2. Configure database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hostel_db
spring.datasource.username=root
spring.datasource.password=S1234
```

### 3. Run the project

Run the Spring Boot application.

---

## 🌐 API Endpoints

* `GET /students` → Get all students

* `POST /students` → Add student

* `DELETE /students/{id}` → Delete student

* `GET /rooms` → Get all rooms

* `POST /rooms` → Add room

* `POST /students/allocate` → Allocate room

---

## 📸 UI

Dashboard-style frontend with sidebar navigation and card-based layout for managing students and rooms.

---

## 👨‍💻 Author

Aritra Guha
