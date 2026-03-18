package com.assessment.demo.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BookingMessageConsumer {

	private static final Logger logger = LoggerFactory.getLogger(BookingMessageConsumer.class);

	@RabbitListener(queues = "booking-queue")
	public void receiveBookingEvent(Map<String, Object> event) {
		logger.info("========================================");
		logger.info("Received Booking Event from RabbitMQ:");
		logger.info("Booking ID  : {}", event.get("bookingId"));
		logger.info("Movie ID    : {}", event.get("movieId"));
		logger.info("Tickets     : {}", event.get("tickets"));
		logger.info("Total Amount: {}", event.get("totalAmount"));
		logger.info("Status      : {}", event.get("status"));
		logger.info("========================================");
	}
}