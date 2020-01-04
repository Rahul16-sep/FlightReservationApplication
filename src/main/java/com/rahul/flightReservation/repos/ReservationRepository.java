package com.rahul.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.flightReservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
