package com.hostel.hostelweb;

import com.hostel.hostelweb.model.Room;
import com.hostel.hostelweb.model.Student;
import java.util.List;
import com.hostel.hostelweb.repository.RoomRepository;
import com.hostel.hostelweb.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class HostelService {
    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;

    public HostelService(StudentRepository studentRepository, RoomRepository roomRepository) {
        this.studentRepository = studentRepository;
        this.roomRepository = roomRepository;
    }


    public Student addStudent(Student student) {

        if (student == null) {
            throw new RuntimeException("Student is null");
        }
        return studentRepository.save(student);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    public boolean removeStudent(int id) {
        if (!studentRepository.existsById(id)) {
            return false;
        }
        studentRepository.deleteById(id);
        return true;
    }

    public Room addRoom(Room room) {
        if (room == null) {
            throw new RuntimeException("Room is null");
        }

        if (roomRepository.existsById(room.getRoomNo())) {
            throw new RuntimeException("Room already exists");
        }

        return roomRepository.save(room);
    }

    public Room findRoom(int roomNo) {
        return roomRepository.findById(roomNo).orElse(null);
    }



    public boolean allocateStudentToRoom(int studentId, int roomNo) {

        Student student = studentRepository.findById(studentId).orElse(null);
        Room room = roomRepository.findById(roomNo).orElse(null);

        if (student == null || room == null) return false;
        if (student.getRoomNo() != 0) return false;
        if (room.isFull()) return false;

        room.increase();
        student.setRoomNo(roomNo);

        roomRepository.save(room);
        studentRepository.save(student);

        return true;
    }

    public boolean vacateStudent(int studentId) {

        Student student = studentRepository.findById(studentId).orElse(null);

        if (student == null) return false;

        int roomNo = student.getRoomNo();
        if (roomNo == 0) return false;

        Room room = roomRepository.findById(roomNo).orElse(null);

        if (room == null) return false;

        room.decrease();
        student.setRoomNo(0);

        roomRepository.save(room);
        studentRepository.save(student);

        return true;
    }
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
