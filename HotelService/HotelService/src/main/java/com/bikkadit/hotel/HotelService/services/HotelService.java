package com.bikkadit.hotel.HotelService.services;

import com.bikkadit.hotel.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    List<Hotel> getAll();
    Hotel getById(String hotelId);
}
