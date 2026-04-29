package com.hostel.hostelweb.controller;

import com.hostel.hostelweb.HostelService;
import com.hostel.hostelweb.model.Room;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final HostelService hostelService;

    public RoomController(HostelService hostelService) {
        this.hostelService = hostelService;
    }

    @GetMapping
    public ResponseEntity<List<Room>> getRooms() {
        List<Room> Rooms = hostelService.getAllRooms();
        return ResponseEntity.ok(Rooms);
    }

    @PostMapping
    public ResponseEntity<String> addRoom(@RequestBody Room room) {
        try {
            Room savedRoom = hostelService.addRoom(room);
            return ResponseEntity.status(201).body("Room added successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
