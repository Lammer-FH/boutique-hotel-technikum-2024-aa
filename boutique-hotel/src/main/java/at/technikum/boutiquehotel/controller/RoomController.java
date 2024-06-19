package at.technikum.boutiquehotel.controller;

import at.technikum.boutiquehotel.dto.RoomDTO;
import at.technikum.boutiquehotel.entities.Room;
import at.technikum.boutiquehotel.entities.RoomType;
import at.technikum.boutiquehotel.services.RoomService;
import at.technikum.boutiquehotel.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<RoomDTO>> getAllRooms(@RequestParam int page) {
        List<Room> rooms = roomService.getAllRooms();
        // map room list to roomDto list
        List<RoomDTO> roomDtos = rooms.stream()
                .map(roomService::mapToDTO)
                .toList();
        return ResponseEntity.ok(roomService.getPaginatedRooms(page,roomDtos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id) {
        Room room = roomService.getRoomById(id);
        return room != null ? ResponseEntity.ok(roomService.mapToDTO(room)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/available")
    public ResponseEntity<Boolean> getAvailableRooms(@RequestParam long roomId, @RequestParam String checkIn, @RequestParam String checkOut) {
        Boolean isAvailable = roomService.isAvailable(roomId, checkIn, checkOut);
        return ResponseEntity.ok(isAvailable);
    }

}
