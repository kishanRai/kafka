package org.example.kafkaconsumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.Value;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class KafkaMessageListener {


	@KafkaListener( topics = "tprogramatically-bulk-message-2", groupId = "kishan-group" )
	public void consume1( String message ) {
		log.info( "consume1 : Consumed message: " + message );
	}

	@KafkaListener( topics = "tprogramatically-bulk-message-2", groupId = "kishan-group" )
	public void consume2( String message ) {
		log.info( "consume2 : consumed message: " + message );
	}

	@KafkaListener( topics = "tprogramatically-bulk-message-2", groupId = "kishan-group" )
	public void consume3( String message ) {
		log.info( "consume3 : Consumed message: " + message );
	}

	@KafkaListener( topics = "tprogramatically-bulk-message-2", groupId = "kishan-group" )
	public void consume4( String message ) {
		log.info( "consume4 :Consumed message: " + message );
	}

}
