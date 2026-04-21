# Hostel-Management-System
Built Spring Boot backend with student-room allocation system
A backend system to manage hostel students and room allocation.

## Tech Stack
- Java
- Spring Boot
- REST APIs
- File-based persistence

## Features
- Add, view, and delete students
- Add and view rooms
- Allocate students to rooms
- Prevent over-capacity allocation
- Vacate students
- Persistent storage using files

## API Endpoints

### Student APIs
- GET /students
- POST /students
- DELETE /students/{id}
- POST /students/allocate
- POST /students/vacate

### Room APIs
- GET /rooms
- POST /rooms
