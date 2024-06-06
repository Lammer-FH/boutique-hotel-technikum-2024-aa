package at.technikum.boutiquehotel.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomTypeId;

    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, name = "image_path")
    private String imagePath;

}
