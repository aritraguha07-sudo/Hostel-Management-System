package com.hostel.hostelweb.model;

public class Student {

    private int id;
    private String name;
    private int admissionYear;
    private int roomNo;
    private String dept;

    public Student() {
    }

    public Student(int id, String name, int admissionYear, int roomNo, String dept) {
        this.id = id;
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