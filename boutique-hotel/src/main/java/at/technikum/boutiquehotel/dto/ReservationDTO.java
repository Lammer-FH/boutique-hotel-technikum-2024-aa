package at.technikum.boutiquehotel.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationDTO {
    private Long roomId;
    private String firstName;
    private String lastName;
    private String email;
    private String confirmEmail;
    private String checkInDate;
    private String checkOutDate;
    private boolean includeBreakfast;
}
