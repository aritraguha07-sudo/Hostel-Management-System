# 🏨 Hostel Management System (Spring Boot + MySQL)

🚀 A backend system to manage hostel students, rooms, and allocation using Spring Boot, MySQL, and JPA.

---

## 📌 Overview

This project simulates a real-world hostel management system where students are allocated to rooms based on availability and capacity.

It demonstrates backend concepts like REST APIs, layered architecture, database integration, and API documentation.

---

## 🛠 Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Swagger (OpenAPI)

---

## 🏗 Architecture

```
Controller → Service → Repository → Database (MySQL)
```

---

## ✨ Features

### 👨‍🎓 Student Management

* Add student
* View all students
* Delete student

### 🏠 Room Management

* Add room
* View all rooms

### 🔄 Allocation System

* Allocate student to room
* Prevent over-capacity
* Prevent duplicate allocation
* Vacate student

---

## 📡 API Endpoints

### Student APIs

| Method | Endpoint             | Description      |
| ------ | -------------------- | ---------------- |
| GET    | `/students`          | Get all students |
| POST   | `/students`          | Add student      |
| DELETE | `/students/{id}`     | Delete student   |
| POST   | `/students/allocate` | Allocate room    |
| POST   | `/students/vacate`   | Vacate room      |

### Room APIs

| Method | Endpoint | Description   |
| ------ | -------- | ------------- |
| GET    | `/rooms` | Get all rooms |
| POST   | `/rooms` | Add room      |

---

## 📄 API Documentation (Swagger)

👉 Open in browser:

```
http://localhost:8080/swagger-ui/index.html
```

* Interactive API testing
* Request/response preview
* No need for Postman

---

## ▶️ How to Run

1. Clone the repository

```
git clone https://github.com/your-username/hostelweb.git
```

2. Open in IntelliJ IDEA

3. Configure MySQL in `application.properties`:

```
spring.datasource.url=jdbc:mysql://localhost:3306/hostel_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

4. Run the application

---

## 🧪 Sample Request

### Add Student

```json
{
  "name": "Aritra",
  "admissionYear": 2023,
  "roomNo": 0,
  "dept": "CSE"
}
```

---

## 🔥 Key Concepts Used

* REST API design
* Spring Boot architecture
* JPA (ORM)
* Repository pattern
* MySQL database integration
* Swagger API documentation

---

## 🚀 Future Improvements

* Authentication (Login/Register)
* JWT Security
* Frontend (React)
* Admin dashboard

---

## 👤 Author

**Aritra Guha**

---

## ⭐ If you like this project, give it a star!
