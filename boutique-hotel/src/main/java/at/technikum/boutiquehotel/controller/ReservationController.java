package at.technikum.boutiquehotel.controller;

import at.technikum.boutiquehotel.dto.ReservationDTO;
import at.technikum.boutiquehotel.entities.Reservation;
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
