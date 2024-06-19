package at.technikum.boutiquehotel.controller;

import at.technikum.boutiquehotel.dto.ReservationConfirmationDTO;
import at.technikum.boutiquehotel.dto.ReservationDTO;
import at.technikum.boutiquehotel.entities.*;
import at.technikum.boutiquehotel.services.GuestService;
import at.technikum.boutiquehotel.services.ReservationService;
import at.technikum.boutiquehotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final GuestService guestService;
    private final RoomService roomService;

    @Autowired
    public ReservationController(ReservationService reservationService, GuestService guestService, RoomService roomService) {
        this.reservationService = reservationService;
        this.guestService = guestService;
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<ReservationConfirmationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        Reservation newReservation = mapToEntity(reservationDTO);
        reservationService.save(newReservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(createReservationConfirmationDto(newReservation));
    }

    @GetMapping("/confirmation")
    public ResponseEntity<ReservationConfirmationDTO> getReservationConfirmationByReservationId(@RequestParam long reservationId) {
        Reservation reservation = reservationService.findById(reservationId);
        if (reservation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Guest guest = reservation.getGuest();
        Room room = reservation.getRoom();

        ReservationConfirmationDTO reservationConfirmationDTO = new ReservationConfirmationDTO();
        reservationConfirmationDTO.setBeds(room.getBeds());
        RoomType roomType = room.getRoomType();
        reservationConfirmationDTO.setRoomType(roomType.getType());
        reservationConfirmationDTO.setDescription(roomType.getDescription());
        reservationConfirmationDTO.setImageUrl(roomType.getImagePath());
        reservationConfirmationDTO.setGuest(guest);
        reservationConfirmationDTO.setPrice(room.getPrice());
        reservationConfirmationDTO.setBreakfastOption(reservation.isBreakfastOption());
        reservationConfirmationDTO.setCheckInDate(reservation.getCheckInDate());
        reservationConfirmationDTO.setCheckOutDate(reservation.getCheckOutDate());

        return ResponseEntity.ok(reservationConfirmationDTO);
    }

    // Mapping methods
    private Reservation mapToEntity(ReservationDTO dto) {
        Reservation reservation = new Reservation();
        reservation.setRoom(roomService.getRoomById(dto.getRoomId()));
        reservation.setBreakfastOption(dto.isIncludeBreakfast());
        System.out.println(dto.getCheckInDate());
        System.out.println(dto.getCheckOutDate());
        System.out.println("mapToEntity Reservation");
        reservation.setCheckInDate(LocalDate.parse(dto.getCheckInDate()));
        reservation.setCheckOutDate(LocalDate.parse(dto.getCheckOutDate()));
        reservation.setBookingDate(LocalDate.now());
        if(dto.getEmail().equals(dto.getConfirmEmail())){
            reservation.setGuest(guestService.save(new Guest(dto.getFirstName(), dto.getLastName(), dto.getEmail(), "06502109180")));
        } else {
            throw new IllegalArgumentException("wrong argument");
        }
        return reservation;
    }

    private ReservationConfirmationDTO createReservationConfirmationDto(Reservation reservation) {
        ReservationConfirmationDTO dto = new ReservationConfirmationDTO();
        dto.setBeds(reservation.getRoom().getBeds());
        dto.setGuest(reservation.getGuest());
        dto.setExtras(roomService.getExtrasList(reservation.getRoom().getRoomExtras()));
        dto.setCheckInDate(reservation.getCheckInDate());
        dto.setCheckOutDate(reservation.getCheckOutDate());
        RoomType roomType = reservation.getRoom().getRoomType();
        dto.setRoomType(roomType.getType());
        dto.setDescription(roomType.getDescription());
        dto.setImageUrl(roomType.getImagePath());
        dto.setPrice(reservation.getRoom().getPrice());
        dto.setBreakfastOption(reservation.isBreakfastOption());
        return dto;
    }

}
