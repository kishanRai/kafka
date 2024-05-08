package org.example.kafkaproducer.controller;

import org.example.kafkaproducer.service.KafkaMessagePublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/event" )
public class EventController {

	private final KafkaMessagePublisher kafkaMessagePublisher;

	public EventController( KafkaMessagePublisher p_kafkaMessagePublisher ) {
		kafkaMessagePublisher = p_kafkaMessagePublisher;
	}

	@GetMapping( "/publish/{message}" )
	public ResponseEntity<?> publishEvent( @PathVariable String message ) {
		kafkaMessagePublisher.publishMessage( message );
		return ResponseEntity.ok( "Message published" );
	}

}
