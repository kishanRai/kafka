package org.example.kafkaproducer.service;

import java.util.concurrent.CompletableFuture;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagePublisher {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public KafkaMessagePublisher( KafkaTemplate<String, String> kafkaTemplate ) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void publishMessage( String message ) {
		CompletableFuture<SendResult<String, String>> l_future = kafkaTemplate.send( "t1-kishan", message );
		l_future.whenComplete( ( result, exception ) -> {
			if ( exception != null ) {
				System.out.println( "Error publishing message: " + exception.getMessage() );
			}
			else {
				System.out.println( "Message published: " + message );
			}
		} );
	}
}
