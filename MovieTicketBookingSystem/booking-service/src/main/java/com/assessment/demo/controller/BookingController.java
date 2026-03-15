package com.assessment.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assessment.demo.booking.model.Booking;
import com.assessment.demo.service.BookingService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<?> bookTicket(@RequestBody Map<String, Integer> request) {
        try {
            int movieId = request.get("movieId");
            int tickets = request.get("tickets");
            Booking booking = bookingService.bookTicket(movieId, tickets);
            return ResponseEntity.ok(booking);
        } catch (RuntimeException e) {
            return ResponseEntity.status(503).body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }
}