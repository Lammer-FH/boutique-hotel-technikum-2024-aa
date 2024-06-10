package at.technikum.boutiquehotel.controller;

import at.technikum.boutiquehotel.dto.GuestDTO;
import at.technikum.boutiquehotel.entities.Guest;
import at.technikum.boutiquehotel.repository.GuestRepository;
import at.technikum.boutiquehotel.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/guests")
public class GuestController {

    @Autowired
    private GuestService guestService;

    @PostMapping
    private Guest createGuest(@RequestBody Guest guest) {
        return guestService.save(guest);
    }

    @GetMapping
    private List<Guest> getAllGuests() {
        return guestService.findAll();
    }

}
