package com.hotel.service;

import java.util.List;

import com.hotel.entity.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);

	List<Hotel> getAllHotels();

	Hotel getHotelByHotelId(String hotelId);

}
