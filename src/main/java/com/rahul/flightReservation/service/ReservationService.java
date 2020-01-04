package com.rahul.flightReservation.service;

import com.rahul.flightReservation.dto.ReservationRequest;
import com.rahul.flightReservation.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

}
