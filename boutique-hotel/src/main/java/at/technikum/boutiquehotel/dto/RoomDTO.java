package at.technikum.boutiquehotel.dto;

import at.technikum.boutiquehotel.entities.ExtraType;
import lombok.Data;

import java.util.List;

@Data
public class RoomDTO {
    private long id;
    private String typeName;
    private String imageUrl;
    private String description;
    private double price;
    private int beds;
    // ExtraType has a title and description
    private List<ExtraType> roomExtras;
}
