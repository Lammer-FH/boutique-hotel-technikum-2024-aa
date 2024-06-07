package at.technikum.boutiquehotel.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ExtraType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long extraTypeId;

    @OneToMany(mappedBy = "extraType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomExtras> roomExtras;

    private String description;
    private String title;
}
