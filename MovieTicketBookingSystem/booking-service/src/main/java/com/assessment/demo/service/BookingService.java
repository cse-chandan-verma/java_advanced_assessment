package com.assessment.demo.service;

import org.springframework.stereotype.Service;

import com.assessment.demo.booking.model.Booking;
import com.assessment.demo.booking.model.Movie;
import com.assessment.demo.client.MovieClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookingService {

    private final MovieClient movieClient;
    private final List<Booking> bookings = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(100);

    public BookingService(MovieClient movieClient) {
        this.movieClient = movieClient;
    }

    public Booking bookTicket(int movieId, int tickets) {
        Movie movie = movieClient.getMovieById(movieId);

        if (movie == null) {
            throw new RuntimeException("Movie service is unavailable or movie not found. Please try again later.");
        }

        double totalAmount = movie.getPrice() * tickets;
        Booking booking = new Booking(idCounter.incrementAndGet(), movieId, tickets, totalAmount);
        bookings.add(booking);
        return booking;
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}