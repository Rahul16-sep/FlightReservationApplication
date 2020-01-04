package com.rahul.flightReservation.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.rahul.flightReservation.dto.ReservationRequest;
import com.rahul.flightReservation.entities.Flight;
import com.rahul.flightReservation.entities.Passenger;
import com.rahul.flightReservation.entities.Reservation;
import com.rahul.flightReservation.repos.FlightRepository;
import com.rahul.flightReservation.repos.PassengerRepository;
import com.rahul.flightReservation.repos.ReservationRepository;
import com.rahul.flightReservation.util.EmailUtil;
import com.rahul.flightReservation.util.PdfGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Value("${com.rahul.flightReservation.itinerary.dirpath}")
	private  String ITINERARY_DIR;
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	PdfGenerator pdfGenerator;
	
	@Autowired
	EmailUtil emailUtil;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		//Make Payments and then proceed to create a passenger.
		//If payment is not completed, then throw an exception.
		
		LOGGER.info("Inside bookFlight()");
		
		Long id = request.getFlightId();
		Flight flight = new Flight();
		LOGGER.info("Fetching the details of flight for flightId :"+ id);
		Optional<Flight> optionalFlight = flightRepository.findById(id);
		if(optionalFlight.isPresent()) {
			flight=optionalFlight.get();
		}
			Passenger passenger = new Passenger();
			passenger.setFirstName(request.getPassengerFirstName());
			passenger.setLastName(request.getPassengerLastName());
			passenger.setEmail(request.getPassengerEmail());
			passenger.setPhone(request.getPassengerPhoneNo());
			
			LOGGER.info("Saving the passenger details:"+passenger);
			Passenger savedPassenger = passengerRepository.save(passenger);
			
			Reservation reservation = new Reservation();
			reservation.setFlight(flight);
			reservation.setPassenger(savedPassenger);
			reservation.setCheckedIn(false);
			
			Reservation savedReservation = reservationRepository.save(reservation);
			String filePath = ITINERARY_DIR+savedReservation.getId()+".pdf";
			
			LOGGER.info("Generating the ticket");
			pdfGenerator.generateItinerary(savedReservation, filePath);
			LOGGER.info("Emailing the ticket");
			emailUtil.sendIteranary(passenger.getEmail(), filePath);
			return savedReservation;
	}

}
