package org.example.kafkaproducerserializer.service;

import java.util.concurrent.CompletableFuture;
import org.example.kafkaproducerserializer.dto.Invoice;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaObjectPublisher {

	private final KafkaTemplate<String, Invoice> kafkaTemplate;
	private final String currentTopic = "tprogramatically-bulk-object-1";

	public KafkaObjectPublisher( KafkaTemplate<String, Invoice> p_kafkaTemplate ) {
		kafkaTemplate = p_kafkaTemplate;
	}

	public void publishObject( Invoice invoice ) {
		// Sending a single Invoice to the topic currentTopic
		CompletableFuture<SendResult<String, Invoice>> l_future = kafkaTemplate.send( currentTopic, invoice );
		l_future.whenComplete( ( result, exception ) -> {
			if ( exception != null ) {
				System.out.println( "Error publishing Invoice: " + invoice.toString() + ", With problem: " + exception.getMessage() );
			}
			else {
				System.out.println( "Invoice published: " + invoice.toString() + invoice + "] with offset = [" + result.getRecordMetadata().offset() +
									"], partition = [" + result.getRecordMetadata().partition() + "], topic = [" +
									result.getRecordMetadata().offset() + "]" );
			}
		} );

		// Sending bulk Invoice to the topic currentTopic
	}
}
