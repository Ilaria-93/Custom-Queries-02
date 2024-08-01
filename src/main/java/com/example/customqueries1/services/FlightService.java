package com.example.customqueries1.services;

import com.example.customqueries1.entities.Flight;
import com.example.customqueries1.enums.StatusEnum;
import com.example.customqueries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    private final Random random = new Random();

    public void provisionFlights(Integer n) {
        for (int i = 0; i <= n; i++) {
            Flight flight = new Flight(i, random.toString(), random.toString(), random.toString(), StatusEnum.ON_TIME);
            flightRepository.save(flight);
        }
    }

    public Optional<Flight> findByIdFlight(Integer id) {
       Optional<Flight> flightOpt = flightRepository.findById(id);
       return flightOpt;
    }

    public Page<Flight> retrieveFlights(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("fromAirport").ascending());
        return flightRepository.findAll(pageable);
    }

    public List<Flight> findOnTimeFlights() {
        return flightRepository.findByStatus(StatusEnum.ON_TIME);
    }

    public List<Flight> getFlightsByStatus(StatusEnum p1, StatusEnum p2) {
        return flightRepository.findFlightsByStatus(p1, p2);
    }
}
