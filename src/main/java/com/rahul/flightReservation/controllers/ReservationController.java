package com.rahul.flightReservation.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rahul.flightReservation.dto.ReservationRequest;
import com.rahul.flightReservation.entities.Flight;
import com.rahul.flightReservation.entities.Reservation;
import com.rahul.flightReservation.repos.FlightRepository;
import com.rahul.flightReservation.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservationService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ReservationController.class);
	
	@RequestMapping("/selectFlight")
	public String showCompleteReservation(@RequestParam("id")Long flightId, ModelMap modelMap) {
		LOGGER.info("Inside showCompleteReservation() invoked with fligh_id:"+ flightId);
		Flight flight = new Flight();
		Optional<Flight> flightOptional = flightRepository.findById(flightId);
		if(flightOptional.isPresent()) {
			flight = flightOptional.get();
		}
		LOGGER.info("Flight is:"+flight);
		modelMap.addAttribute("flight", flight);
        return "reservation/completeReservation";
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String completeReservation(ReservationRequest request,ModelMap modelMap) {
		LOGGER.info("Inside completeReservation() and request is:" + request);
		Reservation res = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation has been created with id" + res.getId());
		return "reservation/reservationConfirm";
	}
}
