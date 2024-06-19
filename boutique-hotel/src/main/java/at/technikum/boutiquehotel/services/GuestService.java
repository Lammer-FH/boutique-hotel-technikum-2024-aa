package at.technikum.boutiquehotel.services;

import at.technikum.boutiquehotel.entities.Guest;
import at.technikum.boutiquehotel.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    public GuestService(final GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    public Guest findById(final long id) {
        return guestRepository.findById(id).orElse(null);
    }
    public Guest save(final Guest guest) {
        return guestRepository.save(guest);
    }

    public void delete(final Guest guest) {
        guestRepository.delete(guest);
    }

}
