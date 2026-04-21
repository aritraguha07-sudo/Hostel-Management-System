package com.hostel.hostelweb.controller;

import com.hostel.hostelweb.HostelService;
import com.hostel.hostelweb.model.Student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final HostelService hostelService;

    public StudentController(HostelService hostelService) {
        this.hostelService = hostelService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> students = hostelService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {

        Student savedStudent = hostelService.addStudent(student);

        return ResponseEntity.status(201).body(savedStudent);
    }
    @PostMapping("/allocate")
    public ResponseEntity<String> allocateStudent(
            @RequestParam int studentId,
            @RequestParam int roomNo) {

        boolean success = hostelService.allocateStudentToRoom(studentId, roomNo);

        if (!success) {
            return ResponseEntity.badRequest().body("Allocation failed");
        }

        return ResponseEntity.ok("Student allocated successfully");
    }

    @PostMapping("/vacate")
    public ResponseEntity<String> vacateStudent(@RequestParam int studentId) {

        boolean success = hostelService.vacateStudent(studentId);

        if (!success) {
            return ResponseEntity.badRequest().body("Vacating failed");
        }

        return ResponseEntity.ok("Student vacated successfully");
    }

    // Delete Mapping
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        boolean removed = hostelService.removeStudent(id);

        if(!removed) {
            return ResponseEntity.badRequest().body("Student not found");
        }
        return ResponseEntity.ok("Student found and removed!");
    }
}