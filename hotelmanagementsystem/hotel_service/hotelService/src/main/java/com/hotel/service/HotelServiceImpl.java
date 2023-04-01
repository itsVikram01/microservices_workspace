package com.hotel.service;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotel.common.ResourceNotFoundException;
import com.hotel.entity.Hotel;
import com.hotel.entity.Rating;
import com.hotel.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	// user operation
			@Autowired
			public HotelRepository hotelRepository;
			
			// restTemplate for communicating services
			@Autowired
			private RestTemplate restTemplate;
			
			private Logger logger=LoggerFactory.getLogger(HotelServiceImpl.class);

			// create
			@Override
			public Hotel createHotel(Hotel hotel) {
				//String randomUserId=UUID.randomUUID().toString();
				//user.setUserId(randomUserId);
				return hotelRepository.save(hotel);
			}

			@Override
			public List<Hotel> getAllHotels() {
				return hotelRepository.findAll();
			}

			@Override
			public Hotel getHotelByHotelId(String hotelId) {
				 Hotel hotel = hotelRepository.findById(hotelId)
						.orElseThrow(() -> new ResourceNotFoundException("User with given id is not found...!!"+hotelId));
				

				// fetch rating of the above user from RATING-SERVICE
				// http://localhost:8002/rating/hotel/2
				Rating[] ratingsArrayOfHotel = restTemplate.getForObject("http://RATING-SERVICE/rating/hotel/"+hotel.getHotelId(), Rating[].class);
				List<Rating> ratingListOFHotel = Arrays.stream(ratingsArrayOfHotel).toList();
				
				logger.info(" {} ", ratingListOFHotel);
				
				 hotel.setRatings(ratingListOFHotel);
				 
				 return hotel;
			}
}
