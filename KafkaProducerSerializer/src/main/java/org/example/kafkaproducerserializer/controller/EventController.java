package org.example.kafkaproducerserializer.controller;

import org.example.kafkaproducerserializer.dto.Invoice;
import org.example.kafkaproducerserializer.service.KafkaObjectPublisher;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/event" )
public class EventController {

	private final KafkaObjectPublisher kafkaObjectPublisher;

	public EventController( KafkaObjectPublisher p_kafkaObjectPublisher ) {
		kafkaObjectPublisher = p_kafkaObjectPublisher;
	}

	@PostMapping( "/publish/invoice" )
	public ResponseEntity<Invoice> publishEvent( RequestEntity<Invoice> requestEntity ) {
		kafkaObjectPublisher.publishObject( requestEntity.getBody() );
		return ResponseEntity.ok( requestEntity.getBody() );
	}

}
