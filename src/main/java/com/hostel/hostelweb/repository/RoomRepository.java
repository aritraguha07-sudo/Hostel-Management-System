package com.hostel.hostelweb.repository;
import com.hostel.hostelweb.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoomRepository extends JpaRepository<Room, Integer> {
}
