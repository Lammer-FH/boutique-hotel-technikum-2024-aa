package at.technikum.boutiquehotel.controller;

import at.technikum.boutiquehotel.entities.RoomType;
import at.technikum.boutiquehotel.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roomtype")
public class RoomTypeController {

    @Autowired
    private RoomTypeService roomTypeService;

    @PostMapping
    private RoomType createRoomType(@RequestBody final RoomType roomType) {
        return roomTypeService.save(roomType);
    }

    @GetMapping
    public List<RoomType> getAllRoomTypes() {
        return roomTypeService.findAll();
    }

}
