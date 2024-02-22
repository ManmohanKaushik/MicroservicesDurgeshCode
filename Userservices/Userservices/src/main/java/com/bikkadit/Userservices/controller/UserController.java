package com.bikkadit.Userservices.controller;


import com.bikkadit.Userservices.model.User;
import com.bikkadit.Userservices.service.UserServices;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiU")
public class UserController {
    @Autowired
    private UserServices userServices;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User saveUser = this.userServices.saveUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUser = this.userServices.getAllUser();
        return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
    }

    int retryCount=1;

    @GetMapping("/user/{userId}")
    //@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallBack")
  //  @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallBack")
    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        logger.info("It is Get single User Handler: UserController ");
        logger.info("Retry count:{}",retryCount);
        retryCount++;
        User user = this.userServices.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex) {
        //  logger.info("FallBack is executed because some service is down :  ",ex.getMessage());
        User user = User.builder().userId("12345").email("dummy@gmail.com").about("This is dummy data some service is down")
                .name("Dummy name").build();
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}
