package com.hostel.hostelweb.repository;
import com.hostel.hostelweb.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
