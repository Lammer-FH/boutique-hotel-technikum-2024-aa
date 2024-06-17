package at.technikum.boutiquehotel.dto;

import lombok.Data;

@Data
public class RoomTypeDTO {

    private Long id;
    private String type;
    private String description;
    private String imagePath;
}
