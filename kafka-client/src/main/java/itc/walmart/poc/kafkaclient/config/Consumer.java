package itc.walmart.poc.kafkaclient.config;

import itc.walmart.poc.kafkaclient.model.User;
import itc.walmart.poc.kafkaclient.repository.CassandraUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class Consumer {
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    CassandraUserRepository cassandraRepository;

    @Autowired
    MyProperties myProperties;

    @KafkaListener(topics = "#{myProperties.getTopic()}" , groupId = "#{myProperties.getGroup()}")
    public void consume(String message){
        try {
            logger.info(String.format("Consumed Message -> %s",message));
            User user = cassandraRepository.save(new User(UUID.randomUUID().toString(),message,new Date()));
            logger.info(String.format("Successfully save the data to Cassandra DB -> %s",user));
        }catch (NullPointerException e){
            logger.error("Recieved a null string from kafka topic ", e);
        }

    }
}
