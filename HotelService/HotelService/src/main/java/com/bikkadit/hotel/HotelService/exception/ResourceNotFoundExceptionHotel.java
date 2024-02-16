package com.bikkadit.hotel.HotelService.exception;

public class ResourceNotFoundExceptionHotel extends RuntimeException{
    public ResourceNotFoundExceptionHotel() {
        super("Resource not Found");
    }

    public ResourceNotFoundExceptionHotel(String message) {
        super(message);
    }
}
