# 🏨 Hostel Management System (Spring Boot)

🚀 A backend system to manage hostel students, rooms, and allocation logic using Spring Boot.

---

## 📌 Overview

This project simulates a real-world hostel management system where students can be assigned to rooms based on availability and capacity constraints.

It demonstrates core backend concepts like REST APIs, layered architecture, and data persistence.

---

## 🛠 Tech Stack

* Java
* Spring Boot
* Maven
* REST APIs
* File-based persistence (students.txt, rooms.txt)

---

## ✨ Features

### 👨‍🎓 Student Management

* Add new students
* View all students
* Delete students

### 🏠 Room Management

* Add rooms
* View all rooms

### 🔄 Allocation System

* Allocate student to a room
* Prevent over-capacity allocation
* Prevent duplicate allocation
* Vacate student from room

### 💾 Persistence

* Data stored in local files
* Auto-load data on application startup

---

## 📡 API Endpoints

### Student APIs

| Method | Endpoint             | Description              |
| ------ | -------------------- | ------------------------ |
| GET    | `/students`          | Get all students         |
| POST   | `/students`          | Add a new student        |
| DELETE | `/students/{id}`     | Delete a student         |
| POST   | `/students/allocate` | Allocate student to room |
| POST   | `/students/vacate`   | Vacate student from room |

### Room APIs

| Method | Endpoint | Description    |
| ------ | -------- | -------------- |
| GET    | `/rooms` | Get all rooms  |
| POST   | `/rooms` | Add a new room |

---

## ▶️ How to Run

1. Clone the repository

```bash
git clone https://github.com/aritraguha07-sudo/Hostel-Management-System.git
```

2. Open in IntelliJ IDEA

3. Run:

```
HostelwebApplication.java
```

4. Use Postman to test APIs

---

## 🧪 Sample Request

### Add Student

```json
POST /students
{
  "id": 1,
  "name": "Aritra",
  "admissionYear": 2023,
  "roomNo": 0,
  "dept": "CSE"
}
```

---

## 🔮 Future Improvements

* Database integration (MySQL / H2)
* Authentication system (Login/Register)
* Frontend UI (React / HTML)
* Swagger API documentation

---

## 👤 Author

**Aritra Guha**

---

## ⭐ If you found this useful, give it a star!
