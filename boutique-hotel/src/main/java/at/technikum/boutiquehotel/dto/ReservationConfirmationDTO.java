package at.technikum.boutiquehotel.dto;

import at.technikum.boutiquehotel.entities.ExtraType;
import at.technikum.boutiquehotel.entities.Guest;
import at.technikum.boutiquehotel.entities.RoomType;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ReservationConfirmationDTO {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double price;
    private int beds;
    private boolean breakfastOption;
    private String roomType;
    private String imageUrl;
    private String description;
    private List<String> extras;
    private Guest guest;
}
