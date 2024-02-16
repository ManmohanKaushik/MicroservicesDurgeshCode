package com.bikkadit.Userservices.extranalservices;

import com.bikkadit.Userservices.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE",url = "${HOTEL-SERVICE.url}")
public interface HotelServices {
    @GetMapping("/hotels/{hotelId}")
    Hotel gethotel(@PathVariable String hotelId);
}
