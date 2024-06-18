package at.technikum.boutiquehotel.dto;

import lombok.Data;

@Data
public class RoomDTO {
    private Long roomTypeId;
    private double price;
    private int beds;
}
