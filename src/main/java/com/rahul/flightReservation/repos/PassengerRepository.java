package com.rahul.flightReservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rahul.flightReservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
