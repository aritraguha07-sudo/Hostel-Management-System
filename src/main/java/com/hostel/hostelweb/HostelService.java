package com.hostel.hostelweb;

import com.hostel.hostelweb.model.Room;
import com.hostel.hostelweb.model.Student;

import java.util.ArrayList;
import java.util.List;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;


import org.springframework.stereotype.Service;

@Service
public class HostelService {
    private List<Student> students;
    private List<Room> rooms;

    public HostelService() {
        students = new ArrayList<>();
        rooms = new ArrayList<>();

        loadStudents();
        loadRooms();
    }
    public void saveStudents() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"));

            for (Student s : students) {
                String line = s.getId()+ "," +
                        s.getName() + "," +
                        s.getAdmissionYear() + "," +
                        s.getRoomNo() + "," +
                        s.getDept();

                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving students.");
        }
    }
    public void saveRooms() {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("rooms.txt"));
            for(Room r: rooms) {
                String line = r.getRoomNo() + "," + r.getCapacity() + "," + r.getOccupied();

                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving rooms.");
        }
    }
    public Student addStudent(Student student) {

        if (student == null) {
            throw new RuntimeException("Student is null");
        }
        students.add(student);
        saveStudents();

        return student;
    }

    public boolean addRoom(Room room) {
        if(room == null){
            return false;
        }
        if(findRoom(room.getRoomNo())!=null){
            return false;
        }
        rooms.add(room);
        saveRooms();
        return true;
    }

    public Room findRoom(int room_no) {
        for (Room r : rooms) {
            if (r.getRoomNo() == room_no) {
                return r;
            }
        }
        return null;
    }

    public Student findStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public boolean allocateStudentToRoom(int studentId, int roomNo) {

        Student student = findStudent(studentId);
        Room room = findRoom(roomNo);

        if (student == null || room == null) {
            return false;
        }
        if (student.getRoomNo() != 0) {
            return false;
        }
        if (room.isFull()) {
            return false;
        }

        room.increase();
        student.setRoomNo(room.getRoomNo());
        saveStudents();
        saveRooms();
        return true;
    }

    public boolean vacateStudent(int Student_id) {
        Student student = findStudent(Student_id);

        if (student == null) {
            return false;
        }
        int room_no = student.getRoomNo();
        if (room_no == 0) {
            return false; //not allocated
        }
        Room room = findRoom(room_no);

        room.decrease();
        student.setRoomNo(0);

        saveStudents();
        saveRooms();


        return true;
    }
    public boolean removeStudent(int id){
        Student student = findStudent(id);
        if(student == null){
            return false;
        }
        students.remove(student);
        saveStudents();

        return true;
    }
    public List<Student> getAllStudents() {
        return students;
    }

    public List<Room> getAllRooms() {
        return rooms;
    }
    public void loadStudents() {

        try {
            File file = new File("students.txt");

            if (!file.exists()) {
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int year = Integer.parseInt(parts[2]);
                int room = Integer.parseInt(parts[3]);
                String dept = parts[4];

                Student student = new Student(id, name, year, room, dept);

                students.add(student);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error loading students.");
        }
    }
    public void loadRooms() {

        try {
            File file = new File("rooms.txt");

            if (!file.exists()) {
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int roomNo = Integer.parseInt(parts[0]);
                int capacity = Integer.parseInt(parts[1]);
                int occupied = Integer.parseInt(parts[2]);

                Room room = new Room(roomNo, capacity, occupied);

                rooms.add(room);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error loading rooms.");
        }
    }


}
