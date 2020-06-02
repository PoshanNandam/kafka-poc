package itc.walmart.poc.kafkaserver.controller;

import itc.walmart.poc.kafkaserver.config.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    Producer producer;

    @PostMapping("user/{userName}")
    public ResponseEntity recieveUserData(@PathVariable String userName){
        producer.sendMessage(userName);
        return ResponseEntity.ok(200);
    }
}
