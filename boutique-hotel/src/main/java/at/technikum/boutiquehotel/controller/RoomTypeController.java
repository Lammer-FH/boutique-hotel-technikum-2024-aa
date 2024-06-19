package at.technikum.boutiquehotel.controller;

import at.technikum.boutiquehotel.dto.RoomTypeDTO;
import at.technikum.boutiquehotel.entities.RoomType;
import at.technikum.boutiquehotel.services.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roomtype")
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @PostMapping
    public ResponseEntity<RoomTypeDTO> createRoomType(@RequestBody final RoomTypeDTO roomTypeDTO) {
        RoomType roomType = mapToEntity(roomTypeDTO);
        RoomType savedRoomType = roomTypeService.save(roomType);
        return ResponseEntity.ok(mapToDTO(savedRoomType));
    }

    @GetMapping
    public ResponseEntity<List<RoomTypeDTO>> getAllRoomTypes() {
        List<RoomType> roomTypes = roomTypeService.findAll();
        List<RoomTypeDTO> roomTypeDTOs = roomTypes.stream().map(this::mapToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(roomTypeDTOs);
    }

    // Helper methods to map between DTO and entity
    private RoomType mapToEntity(RoomTypeDTO dto) {
        RoomType roomType = new RoomType();
        roomType.setRoomTypeId(dto.getId());
        roomType.setType(dto.getType());
        roomType.setDescription(dto.getDescription());
        roomType.setImagePath(dto.getImagePath());
        return roomType;
    }

    private RoomTypeDTO mapToDTO(RoomType roomType) {
        RoomTypeDTO dto = new RoomTypeDTO();
        dto.setId(roomType.getRoomTypeId());
        dto.setType(roomType.getType());
        dto.setDescription(roomType.getDescription());
        dto.setImagePath(roomType.getImagePath());
        return dto;
    }
}
