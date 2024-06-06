package at.technikum.boutiquehotel.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class RoomUnavailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomUnavailabilityId;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(nullable = false, name = "start_date")
    private Date startDate;
    @Column(nullable = false, name = "end_date")
    private Date endDate;
}
