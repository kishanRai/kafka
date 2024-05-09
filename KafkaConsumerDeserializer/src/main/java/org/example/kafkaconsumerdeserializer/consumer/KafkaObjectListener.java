package org.example.kafkaconsumerdeserializer.consumer;

import org.example.kafkaproducerserializer.dto.Invoice;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class KafkaObjectListener {

	@KafkaListener( topics = "tprogramatically-bulk-object-2", groupId = "kishan-group-object" )
	public void consume( Invoice invoice ) {
		log.info( "Consumed message: {}", invoice.toString() );
	}

}
