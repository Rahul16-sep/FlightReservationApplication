<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@page isELIgnored ="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Finding Flights</title>
</head>
<body>
<h3> Flights :</h3>
<table>
<tr>
<td>Airlines</td>
<td>Departure City</td>
<td>Arrival City</td>
<td>Departure Time</td>
</tr>
<c:forEach items="${flights}" var = "flight">
<tr>
<td>${flight.operatingAirlines}</td>
<td>${flight.departureCity}</td>
<td>${flight.arrivalCity}</td>
<td>${flight.estimatedDepartureTime}</td>
<td><a href="selectFlight?id=${flight.id}">Select</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>