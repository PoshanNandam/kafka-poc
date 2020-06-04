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

    CassandraUserRepository cassandraRepository;

    @Autowired
    MyProperties myProperties;

    @Autowired
    public Consumer(CassandraUserRepository cassandraRepository) {
        this.cassandraRepository = cassandraRepository;
    }

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    private String topic = myProperties.getTopic();
    private String gropuId = myProperties.getGroup();

    @KafkaListener(topics = "#{topic.provideName()}" , groupId = "#{gropuId.provideName()}")
    public void consume(String message){
        try {
            logger.info(String.format("$$ -> Consumed Message -> %s",message));
            cassandraRepository.save(new User(UUID.randomUUID().toString(),message,new Date()));
        }catch (NullPointerException e){
            logger.error("Recieved a null string from kafka topic ", e);
        }

    }
}
