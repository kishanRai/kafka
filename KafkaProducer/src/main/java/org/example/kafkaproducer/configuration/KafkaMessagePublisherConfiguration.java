package org.example.kafkaproducer.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaMessagePublisherConfiguration {

	@Bean
	public NewTopic createTopic() {
		return new NewTopic( "tprogramatically-bulk-message", 4, (short) 1 );
	}

}
