package com.assessment.demo.service;

import com.assessment.demo.booking.model.Booking;
import com.assessment.demo.booking.model.Movie;
import com.assessment.demo.client.MovieClient;
import com.assessment.demo.event.BookingEvent;
import com.assessment.demo.messaging.BookingMessageProducer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class BookingService {

    private final MovieClient movieClient;
    private final BookingMessageProducer messageProducer;
    private final List<Booking> bookings = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(100);

    public BookingService(MovieClient movieClient, BookingMessageProducer messageProducer) {
        this.movieClient = movieClient;
        this.messageProducer = messageProducer;
    }

    public Booking bookTicket(int movieId, int tickets) {
        Movie movie = movieClient.getMovieById(movieId);

        if (movie == null) {
            throw new RuntimeException("Movie service unavailable or movie not found.");
        }

        double totalAmount = movie.getPrice() * tickets;
        Booking booking = new Booking(idCounter.incrementAndGet(), movieId, tickets, totalAmount);
        bookings.add(booking);

        // Send event to RabbitMQ
        BookingEvent event = new BookingEvent(
                booking.getBookingId(),
                movieId,
                tickets,
                totalAmount,
                "CONFIRMED"
        );
        messageProducer.sendBookingEvent(event);

        return booking;
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}