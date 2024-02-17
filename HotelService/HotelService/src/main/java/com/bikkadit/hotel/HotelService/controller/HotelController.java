package com.bikkadit.hotel.HotelService.controller;

import com.bikkadit.hotel.HotelService.entity.Hotel;
import com.bikkadit.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/apiH")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel save = hotelService.createHotel(hotel);
        return new ResponseEntity<Hotel>(save, HttpStatus.CREATED);
    }

    @GetMapping("/allHotel")
    public ResponseEntity< List<Hotel>> getAll() {
        List<Hotel> all = this.hotelService.getAll();
        return new ResponseEntity< List<Hotel>>(all,HttpStatus.OK);
    }

    @GetMapping("/hotels/{hotelId}")
    public  ResponseEntity<Hotel> getById(@PathVariable String hotelId) {
        Hotel hotel = this.hotelService.getById(hotelId);
        return new ResponseEntity<Hotel>(hotel,HttpStatus.OK);
    }
}
