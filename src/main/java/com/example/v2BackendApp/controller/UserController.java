package com.example.v2BackendApp.controller;

import com.example.v2BackendApp.model.User;
import com.example.v2BackendApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
/*
@RestController: This annotation is part of the Spring Framework and is used to indicate that the class defines a RESTful controller.
In the context of a Spring Boot application, it combines @Controller and @ResponseBody, indicating that the return value of methods
should be directly serialized to the HTTP response body.
* */
public class UserController {

    @Autowired
    private UserRepository userRepository;
    /*
     * @Autowired: This annotation is used for automatic dependency injection. In this case,
     * it injects an instance of the UserRepository interface into the userRepository field.
     * Dependency injection is a design pattern in which the object's dependencies are injected into it rather than the
     * object creating them itself.
     *
     * */

    /*
     * @PostMapping("/user"): This annotation maps HTTP POST requests to the specified URI ("/user") to the newUser method.
     * It indicates that this method will handle requests for creating a new user.
     * */
//    @PostMapping("/user") // Send data to DB
//    User newUser(@RequestBody User newUser){
//        return  userRepository.save(newUser);
//    }

    /*
     * User newUser(@RequestBody User newUser): This method is responsible for handling HTTP POST requests.
     * It takes a User object as the request body, which is deserialized from the incoming JSON data.
     *
     * The @RequestBody annotation is used to indicate that the newUser parameter should be bound to the body of the HTTP request.
     *
     * userRepository.save(newUser): This line saves the provided User object (newUser) to the database using the save method
     * of the UserRepository. The UserRepository is presumably an interface that extends Spring Data JPA's JpaRepository
     * or a similar interface, providing CRUD (Create, Read, Update, Delete) operations for the User entity.
     * */

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
