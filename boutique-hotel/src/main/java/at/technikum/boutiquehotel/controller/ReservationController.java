package at.technikum.boutiquehotel.controller;

import at.technikum.boutiquehotel.dto.ReservationConfirmationDTO;
import at.technikum.boutiquehotel.dto.ReservationDTO;
import at.technikum.boutiquehotel.entities.Guest;
import at.technikum.boutiquehotel.entities.Reservation;
import at.technikum.boutiquehotel.entities.Room;
import at.technikum.boutiquehotel.entities.RoomExtras;
import at.technikum.boutiquehotel.services.GuestService;
import at.technikum.boutiquehotel.services.ReservationService;
import at.technikum.boutiquehotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ReservationDTO> createReservation(@RequestBody ReservationDTO reservationDTO) {
        Reservation newReservation = mapToEntity(reservationDTO);
        Reservation savedReservation = reservationService.save(newReservation);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapToDTO(savedReservation));
    }

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getAllReservations() {
        List<Reservation> reservations = reservationService.findAll();
        List<ReservationDTO> reservationDTOs = reservations.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservationDTOs);
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
        reservationConfirmationDTO.setExtras(room.getRoomExtras().stream().map(RoomExtras::getExtraType).collect(Collectors.toList()));
        reservationConfirmationDTO.setRoomType(room.getRoomType());
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
        reservation.setGuest(guestService.findById(dto.getGuestId()));
        reservation.setRoom(roomService.getRoomById(dto.getRoomId()));
        reservation.setBreakfastOption(dto.isBreakfastOption());
        reservation.setBookingDate(dto.getBookingDate());
        reservation.setCheckInDate(dto.getCheckInDate());
        reservation.setCheckOutDate(dto.getCheckOutDate());
        return reservation;
    }

    private ReservationDTO mapToDTO(Reservation reservation) {
        ReservationDTO dto = new ReservationDTO();
        dto.setGuestId(reservation.getGuest().getGuestId());
        dto.setRoomId(reservation.getRoom().getId());
        dto.setBreakfastOption(reservation.isBreakfastOption());
        dto.setBookingDate(reservation.getBookingDate());
        dto.setCheckInDate(reservation.getCheckInDate());
        dto.setCheckOutDate(reservation.getCheckOutDate());
        return dto;
    }

}
