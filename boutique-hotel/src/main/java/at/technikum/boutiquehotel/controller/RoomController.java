package at.technikum.boutiquehotel.controller;

import at.technikum.boutiquehotel.dto.RoomDTO;
import at.technikum.boutiquehotel.entities.Room;
import at.technikum.boutiquehotel.entities.RoomType;
import at.technikum.boutiquehotel.services.RoomService;
import at.technikum.boutiquehotel.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;
    private final RoomTypeService roomTypeService;

    @Autowired
    public RoomController(RoomService roomService, RoomTypeService roomTypeService) {
        this.roomService = roomService;
        this.roomTypeService = roomTypeService;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        Room room = roomService.getRoomById(id);
        return room != null ? ResponseEntity.ok(room) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/available")
    public ResponseEntity<List<RoomDTO>> getAvailableRooms(@RequestParam String checkIn, @RequestParam String checkOut, @RequestParam int page) {
        List<RoomDTO> availableRooms =  roomService.getAvailableRooms(checkIn, checkOut);
        return ResponseEntity.ok(roomService.getPaginatedRooms(page, availableRooms));
    }

}