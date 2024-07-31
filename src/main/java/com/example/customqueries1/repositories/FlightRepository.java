package com.example.customqueries1.repositories;

import com.example.customqueries1.entities.Flight;
import com.example.customqueries1.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findByStatus(StatusEnum status);

    @Query("SELECT f FROM Flight f WHERE f.status = :p1 OR f.status = :p2")
    List<Flight> findFlightsByStatus(StatusEnum p1, StatusEnum p2);
}