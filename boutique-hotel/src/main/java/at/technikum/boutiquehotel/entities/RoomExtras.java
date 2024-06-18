package at.technikum.boutiquehotel.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RoomExtras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomExtrasId;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "extra_type_id", nullable = false)
    private ExtraType extraType;



}
