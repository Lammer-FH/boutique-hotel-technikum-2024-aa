package at.technikum.boutiquehotel.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "room_type_id")
    private RoomType roomType;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int beds;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomExtras> roomExtras = new ArrayList<>();

    public boolean isAvailable(String checkIn, String checkOut) {
        return reservations.stream()
                .noneMatch(reservation -> reservation.overlapsWith(checkIn, checkOut));
    }

}
