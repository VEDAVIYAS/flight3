package com.Foodcourt.fc.service;

import com.Foodcourt.fc.Entity.Flight;
import com.Foodcourt.fc.dto.FilteringDTO;
import com.Foodcourt.fc.dto.FlightDTO;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface FlightService {
    public void saveFlight(FlightDTO flightDTO);

    public List<Flight> fetchAll();

    public  void deleteById(int id);

    public List<Flight> fetchDeparture(Date departure_time);

    public String ticketCount(int id,int ticketCounts);

    public List<Flight> getFlightsByDate(Date date);

    public List<String> getNames();

    public List<Flight> filterByName(String flightName);

    public List<Flight> filteringByAll(FilteringDTO filteringDTO,Date date);

    public Flight getFlight(int id);
}
