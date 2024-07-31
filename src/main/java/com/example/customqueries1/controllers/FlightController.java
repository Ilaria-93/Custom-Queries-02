package com.example.customqueries1.controllers;

import com.example.customqueries1.entities.Flight;
import com.example.customqueries1.enums.StatusEnum;
import com.example.customqueries1.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/provision")
    public void provisionFlights(@RequestParam Integer n) {
        flightService.provisionFlights(n);
    }

    @GetMapping("/retrieve")
    public Page<Flight> retrieveFlights(@RequestParam Integer page, @RequestParam Integer size) {
        return flightService.retrieveFlights(page, size);
    }

    @GetMapping("/on-time")
    public List<Flight> findOnTimeFlights() {
        return flightService.findOnTimeFlights();
    }

    @GetMapping("/status")
    public List<Flight> getFlightsByStatus(@RequestParam StatusEnum p1, @RequestParam StatusEnum p2) {
        return flightService.getFlightsByStatus(p1, p2);
    }
}
