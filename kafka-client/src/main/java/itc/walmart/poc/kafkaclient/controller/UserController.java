package itc.walmart.poc.kafkaclient.controller;

import itc.walmart.poc.kafkaclient.model.User;
import itc.walmart.poc.kafkaclient.repository.CassandraUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    CassandraUserRepository userRepository;

    @GetMapping("users")
    public List<User> getUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }
}
