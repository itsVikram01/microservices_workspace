package com.rating.services;

import java.util.List;

import com.rating.entity.Rating;

public interface RatingService {
	//create
	Rating createRating(Rating rating);
	
	//getAllRating
	List<Rating> getAllRatings();
	
	//getAllByUserId
	List<Rating> getRatingByUserId(String UserId);
	
	//getAllByHotel
	List<Rating> getRatingByHotelId(String hotelId);
	
}
