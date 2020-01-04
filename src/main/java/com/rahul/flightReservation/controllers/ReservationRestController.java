package com.rahul.flightReservation.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.flightReservation.dto.ReservationUpdate;
import com.rahul.flightReservation.entities.Reservation;
import com.rahul.flightReservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

	
	@Autowired
	ReservationRepository reservationRepo;
	
	@RequestMapping("/reservations/{id}")
	public Reservation findReservation(@PathVariable("id") Long id) {
		LOGGER.info("Inside findReservation() for id:"+ id);
		Reservation reservation = new Reservation();
		Optional<Reservation> res = reservationRepo.findById(id);
		if(res.isPresent()) {
               reservation=res.get();
		}
		return reservation;
	}

	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdate request) {
		LOGGER.info("Inside updateReservation() for request:"+ request);
		
		Reservation reservation = new Reservation();
		Reservation updatedReservation = new Reservation();
		Optional<Reservation> optional = reservationRepo.findById(request.getId());
		if(optional.isPresent()) {
			reservation = optional.get();
			reservation.setNumberOfBags(request.getNoOfBags());
			reservation.setCheckedIn(request.isCheckedIn());
			updatedReservation = reservationRepo.save(reservation);
		}
		return updatedReservation;
		
	}
}
