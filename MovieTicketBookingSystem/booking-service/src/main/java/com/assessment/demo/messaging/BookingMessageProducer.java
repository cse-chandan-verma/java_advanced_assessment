package com.assessment.demo.messaging;

import com.assessment.demo.config.RabbitMQConfig;
import com.assessment.demo.event.BookingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookingMessageProducer {

	private static final Logger logger = LoggerFactory.getLogger(BookingMessageProducer.class);

	private final RabbitTemplate rabbitTemplate;

	public BookingMessageProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void sendBookingEvent(BookingEvent event) {
		logger.info("Sending booking event to RabbitMQ: {}", event.getBookingId());
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY, event);
		logger.info("Booking event sent successfully for bookingId: {}", event.getBookingId());
	}
}