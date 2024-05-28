package at.technikum.boutiquehotel.repository;

import at.technikum.boutiquehotel.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByType(String type);
    List<Room> findByPriceLessThanEqual(double maxPrice);
}