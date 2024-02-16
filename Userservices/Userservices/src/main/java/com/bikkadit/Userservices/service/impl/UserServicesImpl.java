package com.bikkadit.Userservices.service.impl;

import com.bikkadit.Userservices.exception.ResourceNotFound;
import com.bikkadit.Userservices.extranalservices.HotelServices;
import com.bikkadit.Userservices.model.Hotel;
import com.bikkadit.Userservices.model.Rating;
import com.bikkadit.Userservices.model.User;
import com.bikkadit.Userservices.repository.UserRepository;
import com.bikkadit.Userservices.service.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelServices hotelServices;

    private Logger logger = LoggerFactory.getLogger(UserServicesImpl.class);

    @Override
    public User saveUser(User user) {
        String s = UUID.randomUUID().toString();
        user.setUserId(s);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFound("Resource not found ****"));
        Rating[] listUser = restTemplate.getForObject("http://RATING-SERVICE/api/user/" + user.getUserId(), Rating[].class);
        logger.info("{}", listUser);

        List<Rating> ratings = Arrays.stream(listUser).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
           // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8081/api/getid/"+rating.getHotelId(), Hotel.class);

            Hotel hotel = hotelServices.gethotel(rating.getHotelId());

            // logger.info("response code is {}", forEntity.getStatusCode());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }
}
