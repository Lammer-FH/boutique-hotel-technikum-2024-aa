package at.technikum.boutiquehotel.dto;

import lombok.Data;

@Data
public class GuestDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
