package itc.walmart.poc.kafkaserver;

import itc.walmart.poc.kafkaserver.config.MyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
public class KafkaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaServerApplication.class, args);
	}

}
