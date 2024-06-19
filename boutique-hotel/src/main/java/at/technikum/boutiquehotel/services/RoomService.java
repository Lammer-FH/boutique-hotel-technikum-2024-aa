package at.technikum.boutiquehotel.services;

import at.technikum.boutiquehotel.dto.RoomDTO;
import at.technikum.boutiquehotel.entities.Room;
import at.technikum.boutiquehotel.entities.RoomExtras;
import at.technikum.boutiquehotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findById(id).orElse(null);
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getRoomsByPrice(double maxPrice) {
        return roomRepository.findByPriceLessThanEqual(maxPrice);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public List<RoomDTO> getAvailableRooms(String checkIn, String checkOut) {
        return roomRepository.findAll().stream()
                .filter(room -> room.isAvailable(checkIn, checkOut)).
                map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public RoomDTO mapToDTO(Room eachRoom) {
        RoomDTO dto = new RoomDTO();
        dto.setId(eachRoom.getId());
        dto.setBeds(eachRoom.getBeds());
        dto.setPrice(eachRoom.getPrice());
        dto.setExtras(
                eachRoom.getRoomExtras().stream()
                .map(eachExtra -> eachExtra.getExtraType().getTitle())
                .collect(Collectors.toList())
        );
        dto.setDescription(eachRoom.getRoomType().getDescription());
        dto.setTypeName(eachRoom.getRoomType().getType());
        dto.setImageUrl(eachRoom.getRoomType().getImagePath());
        return dto;
    }

    public boolean isAvailable(Long roomId, String checkInDate, String checkOutDate) {
        return roomRepository.findById(roomId)
                .map(room -> room.isAvailable(checkInDate, checkOutDate))
                .orElseThrow(() -> new IllegalArgumentException("Room not found with id: " + roomId));
    }

    public Room updateRoomDetails(Long roomId, Room updatedRoomDetails) {
        return roomRepository.findById(roomId)
                .map(room -> {
                    room.setPrice(updatedRoomDetails.getPrice());
                    room.setBeds(updatedRoomDetails.getBeds());
                    room.setRoomExtras(updatedRoomDetails.getRoomExtras());
                    room.setRoomType(updatedRoomDetails.getRoomType());
                    return roomRepository.save(room);
                })
                .orElseThrow(() -> new IllegalArgumentException("Room not found with id: " + roomId));
    }

    public List<RoomDTO> getPaginatedRooms(int page, List<RoomDTO> rooms) {
        int pageSize = 5;
        int startIndex = (page-1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, rooms.size());
        return rooms.subList(startIndex, endIndex);
    }

    public List<String> getExtrasList(List<RoomExtras> roomExtras) {
        return roomExtras.stream().map(eachRoomExtra->eachRoomExtra.getExtraType().getTitle()).toList();
    }
}
