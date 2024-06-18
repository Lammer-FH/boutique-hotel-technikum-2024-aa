package at.technikum.boutiquehotel.services;

import at.technikum.boutiquehotel.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import at.technikum.boutiquehotel.entities.RoomType;

@Service
public class RoomTypeService {

    private RoomTypeRepository roomTypeRepository;

    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }
    public List<RoomType> findAll() {
        return roomTypeRepository.findAll();
    }
    public RoomType findById(Long id) {
        return roomTypeRepository.findById(id).orElse(null);
    }
    public RoomType save(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }
    public void delete(RoomType roomType) {
        roomTypeRepository.delete(roomType);
    }

}
