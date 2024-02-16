package com.bikkadit.hotel.HotelService.services.impl;

import com.bikkadit.hotel.HotelService.entity.Hotel;
import com.bikkadit.hotel.HotelService.exception.ResourceNotFoundExceptionHotel;
import com.bikkadit.hotel.HotelService.repositery.HotelRepository;
import com.bikkadit.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel createHotel(Hotel hotel) {
        String s = UUID.randomUUID().toString();
        hotel.setHotelId(s);
        return this.hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return this.hotelRepository.findAll();
    }

    @Override
    public Hotel getById(String hotelId) {
        return this.hotelRepository.findById(hotelId).orElseThrow(()->new ResourceNotFoundExceptionHotel("Resource not found****"));
    }
}
