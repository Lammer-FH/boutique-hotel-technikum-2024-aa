package at.technikum.boutiquehotel.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ExtraType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long extraTypeId;

    private String description;
    private String title;
}
