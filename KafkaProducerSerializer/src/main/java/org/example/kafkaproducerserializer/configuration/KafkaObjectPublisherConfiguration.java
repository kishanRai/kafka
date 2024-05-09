package org.example.kafkaproducerserializer.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaObjectPublisherConfiguration {

	@Bean
	public NewTopic createTopic() {
		return new NewTopic( "tprogramatically-bulk-object-2", 4, (short) 1 );
	}

}
