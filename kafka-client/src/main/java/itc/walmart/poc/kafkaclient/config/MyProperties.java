package itc.walmart.poc.kafkaclient.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Configuration
@ConfigurationProperties(prefix = "kafka")
public class MyProperties {
    private String topic;
    private String group;


}
