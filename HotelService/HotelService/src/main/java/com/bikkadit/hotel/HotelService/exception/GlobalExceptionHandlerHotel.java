package com.bikkadit.hotel.HotelService.exception;

import com.bikkadit.hotel.HotelService.payloade.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandlerHotel {
    @ExceptionHandler(ResourceNotFoundExceptionHotel.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundExceptionHotel exception){
        String message = exception.getMessage();
        ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();

        return new  ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }
}
