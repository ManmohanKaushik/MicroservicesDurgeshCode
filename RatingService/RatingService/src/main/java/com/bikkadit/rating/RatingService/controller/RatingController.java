package com.bikkadit.rating.RatingService.controller;

import com.bikkadit.rating.RatingService.model.Rating;
import com.bikkadit.rating.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiR")
public class RatingController {
    @Autowired
    private RatingService service;

    @PostMapping("/rating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating saveRating = this.service.createRating(rating);
        return new ResponseEntity<Rating>(saveRating, HttpStatus.CREATED);
    }

    @GetMapping("/allRating")
    public ResponseEntity<List<Rating> > getAllRating() {
        List<Rating> allRating = this.service.getAllRating();
        return new ResponseEntity<List<Rating>>(allRating,HttpStatus.OK) ;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
        List<Rating> ratingByUserId = this.service.getRatingByUserId(userId);
        return new ResponseEntity<List<Rating>>(ratingByUserId,HttpStatus.OK);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
        List<Rating> ratingByHotelId = this.service.getRatingByHotelId(hotelId);
        return new ResponseEntity<List<Rating>>(ratingByHotelId,HttpStatus.OK);
    }

}
