package com.hostel.hostelweb.model;
import jakarta.persistence.*;

@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private Integer admissionYear;
    private Integer roomNo;
    private String dept;

    public Student() {
    }

    public Student(String name, int admissionYear, int roomNo, String dept) {
        this.name = name;
        this.admissionYear = admissionYear;
        this.roomNo = roomNo;
        this.dept = dept;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}