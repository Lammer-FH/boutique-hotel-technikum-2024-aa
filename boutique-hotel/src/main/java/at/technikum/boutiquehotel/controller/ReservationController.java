package at.technikum.boutiquehotel.controller;

import at.technikum.boutiquehotel.dto.ReservationDTO;
import at.technikum.boutiquehotel.entities.Guest;
import at.technikum.boutiquehotel.entities.Reservation;
import at.technikum.boutiquehotel.entities.Room;
import at.technikum.boutiquehotel.entities.RoomExtras;
import at.technikum.boutiquehotel.services.GuestService;
import at.technikum.boutiquehotel.services.ReservationService;
import at.technikum.boutiquehotel.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private GuestService guestService;
    @Autowired
    private RoomService roomService;

    @PostMapping
    private Reservation createReservation(@RequestBody ReservationDTO reservation) {
        Reservation newReservation = mapToEntity(reservation);
        return reservationService.save(newReservation);
    }

    @GetMapping
    private List<ReservationDTO> getAllReservations(){
        List<Reservation> reservations = reservationService.findAll();
        List<ReservationDTO> reservationDTOs = new ArrayList<>();
        reservations.forEach((reservation) -> reservationDTOs.add(mapToDTO(reservation)));
        return reservationDTOs;
    }

    @GetMapping
    private ReservationConfirmationDTO getReservationConfirmationByReservationId(@RequestParam long reservationId) {
        ReservationConfirmationDTO reservationConfirmationDTO = new ReservationConfirmationDTO();

        // get all relevant details for the confirmation page from the services
        Reservation reservation = reservationService.findById(reservationId);
        Guest guest = reservation.getGuest();
        Room room = reservation.getRoom();

        reservationConfirmationDTO.setBeds(room.getBeds());
        reservationConfirmationDTO.setExtras(room.getRoomExtras().stream().map(RoomExtras::getExtraType).toList());
        reservationConfirmationDTO.setRoomType(room.getRoomType());
        reservationConfirmationDTO.setGuest(guest);
        reservationConfirmationDTO.setPrice(room.getPrice());
        reservationConfirmationDTO.setBreakfastOption(reservation.isBreakfastOption());
        reservationConfirmationDTO.setCheckInDate(reservation.getCheckInDate());
        reservationConfirmationDTO.setCheckOutDate(reservation.getCheckOutDate());
        return reservationConfirmationDTO;
    }

    // mapping methods
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
