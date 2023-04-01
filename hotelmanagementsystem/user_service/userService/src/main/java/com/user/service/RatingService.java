package com.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.user.entity.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
	
	//get
	@GetMapping("/rating/getAllRating")
	Rating getRating(@PathVariable("ratingId") String ratingId);
	
	@GetMapping("/rating/user/{userID}")
	Rating getRatingByUserId(@PathVariable String userId);
	
	@GetMapping("/rating/hotel/{hotelId}")
	Rating getRatingByHotelId(@PathVariable String hotelId);
	
	//post
	@PostMapping("/rating/createRating")
	Rating createRating(Rating ratingValues); 	
	
	//put
	@PutMapping("/rating/{ratingId}")
	Rating updateRating(@PathVariable("ratingId") String ratingId, Rating rating);
	
	//delete
	@DeleteMapping("/rating/{ratingId}")
	void deleteRating(@PathVariable("ratingId") String ratingId);
	
}
