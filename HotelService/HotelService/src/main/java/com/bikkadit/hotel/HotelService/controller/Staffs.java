package com.bikkadit.hotel.HotelService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class Staffs {
    @GetMapping("/allStaff")
    public ResponseEntity<List<String>> getAllStaff(){
        List<String> list = Arrays.asList("Ram", "Sita", "Laxman", "Hanumann", "Umamahesh");
        return new ResponseEntity<List<String>>(list, HttpStatus.CREATED);
    }
}
