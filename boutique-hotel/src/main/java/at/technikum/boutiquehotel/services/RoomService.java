package at.technikum.boutiquehotel.services;

import at.technikum.boutiquehotel.entities.Room;
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

    public List<Room> getAvailableRooms(String checkIn, String checkOut) {
        return roomRepository.findAll().stream()
                .filter(room -> room.isAvailable(checkIn, checkOut))
                .collect(Collectors.toList());
    }

    public boolean checkAvailability(Long roomId, String checkInDate, String checkOutDate) {
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

    public List<Room> getPaginatedRooms(int page, List<Room> availableRooms) {
        return availableRooms.stream().limit(page*5).collect(Collectors.toList());
    }

}
