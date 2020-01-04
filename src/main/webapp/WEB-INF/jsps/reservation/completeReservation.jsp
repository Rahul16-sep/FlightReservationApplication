<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@page isELIgnored ="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>
<h2> Complete Your Reservation</h2>
Airline: ${flight.operatingAirlines}<br/>
Departure City: ${flight.departureCity}<br/>
Arrival City: ${flight.arrivalCity}<br/>
Departure Time: ${flight.estimatedDepartureTime}<br/>

<form action="completeReservation" method="post">
<h2>Passenger Details</h2>
<pre>
First Name: <input type="text" name="passengerFirstName"/>
Last Name:  <input type="text" name="passengerLastName"/>
Email:      <input type="text" name="passengerEmail"/>
Phone:      <input type="text" name="passengerPhoneNo"/>
</pre>

<h2>Card Details</h2>
<pre>
Card Number :<input type="text" name="cardNumber"/>
Name on card:<input type="text" name="nameOnCard"/>
Expiry Date :<input type="text" name="expiryDate"/>
CVV         :<input type="text" name="cvv"/>

<input type="hidden" name ="flightId" value="${flight.id}"/>
<input type="submit" value="Save Details"/>
</pre>
</form>

</body>
</html>