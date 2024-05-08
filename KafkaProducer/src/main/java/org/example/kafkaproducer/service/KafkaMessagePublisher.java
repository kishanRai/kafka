package org.example.kafkaproducer.service;

import java.util.concurrent.CompletableFuture;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagePublisher {

	private final KafkaTemplate<String, Object> kafkaTemplate;
	private final String currentTopic = "tprogramatically-bulk-message";

	public KafkaMessagePublisher( KafkaTemplate<String, Object> kafkaTemplate ) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void publishMessage( String message ) {

		// Sending a single message to the topic currentTopic
		CompletableFuture<SendResult<String, Object>> l_future = kafkaTemplate.send( currentTopic, message );

		// Sending bulk messages to the topic currentTopic
		for ( int count = 0; count < 10000; count++ ) {
			l_future = kafkaTemplate.send( currentTopic, message + " : " + count );
		}

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
