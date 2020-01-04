package com.rahul.flightReservation.dto;

public class ReservationRequest {
	
	private Long flightId;
	private String passengerFirstName;
	private String passengerLastName;
	private String passengerEmail;
	private String passengerPhoneNo;
	private String cardNumber;
	private String nameOnCard;
	private String expiryDate;
	private String cvv;
	
	public Long getFlightId() {
		return flightId;
	}
	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}
	public String getPassengerFirstName() {
		return passengerFirstName;
	}
	public void setPassengerFirstName(String passengerFirstName) {
		this.passengerFirstName = passengerFirstName;
	}
	public String getPassengerLastName() {
		return passengerLastName;
	}
	public void setPassengerLastName(String passengerLastName) {
		this.passengerLastName = passengerLastName;
	}
	public String getPassengerEmail() {
		return passengerEmail;
	}
	public void setPassengerEmail(String passengerEmail) {
		this.passengerEmail = passengerEmail;
	}
	public String getPassengerPhoneNo() {
		return passengerPhoneNo;
	}
	public void setPassengerPhoneNo(String passengerPhoneNo) {
		this.passengerPhoneNo = passengerPhoneNo;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "ReservationRequest [flightId=" + flightId + ", passengerFirstName=" + passengerFirstName
				+ ", passengerLastName=" + passengerLastName + ", passengerEmail=" + passengerEmail
				+ ", passengerPhoneNo=" + passengerPhoneNo + ", cardNumber=" + cardNumber + ", nameOnCard=" + nameOnCard
				+ ", expiryDate=" + expiryDate + ", cvv=" + cvv + "]";
	}
	
	
	
}
