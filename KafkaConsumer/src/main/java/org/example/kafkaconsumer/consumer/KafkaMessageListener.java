package org.example.kafkaconsumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class KafkaMessageListener {

	@KafkaListener( topics = "tprogramatically-bulk-message", groupId = "group_id" )
	public void consume( String message ) {
		log.info( "Consumed message: " + message );
	}

}
