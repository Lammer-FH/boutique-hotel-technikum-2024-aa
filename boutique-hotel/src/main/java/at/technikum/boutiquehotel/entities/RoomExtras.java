package at.technikum.boutiquehotel.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RoomExtras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomExtrasId;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "extra_type_id", nullable = false)
    private ExtraType extraType;

}
