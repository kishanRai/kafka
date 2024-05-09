package org.example.kafkaproducerserializer.service;

import java.util.concurrent.CompletableFuture;
import org.example.kafkaproducerserializer.dto.Invoice;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaObjectPublisher {

	private final KafkaTemplate<String, Object> kafkaTemplate;
	private final String currentTopic = "tprogramatically-bulk-object-2";

	public KafkaObjectPublisher( KafkaTemplate<String, Object> p_kafkaTemplate ) {
		kafkaTemplate = p_kafkaTemplate;
	}

	public void publishObject( Invoice invoice ) {

		try {
			// Sending a single Invoice to the topic currentTopic
			CompletableFuture<SendResult<String, Object>> l_future = kafkaTemplate.send( currentTopic, invoice );
			l_future.whenComplete( ( result, exception ) -> {
				if ( exception != null ) {
					System.out.println( "Error publishing Invoice: " + invoice.toString() + ", With problem: " + exception.getMessage() );
				}
				else {
					System.out.println(
						"Invoice published: " + invoice.toString() + "] with offset = [" + result.getRecordMetadata().offset() +
						"], partition = [" + result.getRecordMetadata().partition() + "], topic = [" + result.getRecordMetadata().offset() + "]" );
				}
			} );

			// Sending bulk Invoice to the topic currentTopic
		}

		catch ( Exception e ) {
			System.out.println( "Error publishing Invoice: " + invoice.toString() + ", With problem: " + e.getMessage() );
		}
	}
}
