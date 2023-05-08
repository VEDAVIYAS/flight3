package com.Foodcourt.fc.dto;

import java.util.Date;

public class UserBookingDTO {
    private int flightId;

    private int ticketCounts;

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getTicketCounts() {
        return ticketCounts;
    }

    public void setTicketCounts(int ticketCounts) {
        this.ticketCounts = ticketCounts;
    }

    public int getBookingCost() {
        return bookingCost;
    }

    public void setBookingCost(int bookingCost) {
        this.bookingCost = bookingCost;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getStartingLocation() {
        return startingLocation;
    }

    public void setStartingLocation(String startingLocation) {
        this.startingLocation = startingLocation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getLandingTime() {
        return landingTime;
    }

    public void setLandingTime(Date landingTime) {
        this.landingTime = landingTime;
    }

    private int bookingCost;

    private String flightName;

    private String startingLocation;

    private String destination;

    private Date departureTime;

    private Date landingTime;


}
