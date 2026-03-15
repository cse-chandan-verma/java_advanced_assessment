package com.assessment.demo.booking.model;

public class Booking {

	private int bookingId;
	private int movieId;
	private int tickets;
	private double totalAmount;

	public Booking() {
	}

	public Booking(int bookingId, int movieId, int tickets, double totalAmount) {
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.tickets = tickets;
		this.totalAmount = totalAmount;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
}