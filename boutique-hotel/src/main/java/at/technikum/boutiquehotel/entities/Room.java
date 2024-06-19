package at.technikum.boutiquehotel.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference // This will be serialized
    private RoomType roomType;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int beds;

    @JsonBackReference
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservations = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomExtras> roomExtras = new ArrayList<>();

    public boolean isAvailable(String checkIn, String checkOut) {
        return reservations.stream()
                .noneMatch(reservation -> reservation.overlapsWith(checkIn, checkOut));
    }

}
