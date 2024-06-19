package at.technikum.boutiquehotel.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ExtraType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long extraTypeId;

    @JsonBackReference // This will be ignored during serialization
    @OneToMany(mappedBy = "extraType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoomExtras> roomExtras;

    private String description;
    private String title;
}
