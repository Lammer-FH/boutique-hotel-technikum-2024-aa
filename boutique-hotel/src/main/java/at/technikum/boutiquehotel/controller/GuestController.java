package at.technikum.boutiquehotel.controller;

import at.technikum.boutiquehotel.dto.GuestDTO;
import at.technikum.boutiquehotel.entities.Guest;
import at.technikum.boutiquehotel.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/guests")
public class GuestController {

    private final GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping
    public ResponseEntity<GuestDTO> createGuest(@RequestBody GuestDTO guestDTO) {
        Guest guest = mapToEntity(guestDTO);
        Guest savedGuest = guestService.save(guest);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapToDTO(savedGuest));
    }

    @GetMapping
    public ResponseEntity<List<GuestDTO>> getAllGuests() {
        List<Guest> guests = guestService.findAll();
        List<GuestDTO> guestDTOs = guests.stream().map(this::mapToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(guestDTOs);
    }

    // Helper methods for mapping between DTO and entity
    private Guest mapToEntity(GuestDTO dto) {
        Guest guest = new Guest();
        guest.setFirstName(dto.getFirstName());
        guest.setLastName(dto.getLastName());
        guest.setEmail(dto.getEmail());
        guest.setPhone(dto.getPhoneNumber());
        guest.setGuestId(dto.getId());
        return guest;
    }

    private GuestDTO mapToDTO(Guest guest) {
        GuestDTO dto = new GuestDTO();
        dto.setId(guest.getGuestId());
        dto.setFirstName(guest.getFirstName());
        dto.setLastName(guest.getLastName());
        dto.setEmail(guest.getEmail());
        dto.setPhoneNumber(guest.getPhone());
        return dto;
    }
}
