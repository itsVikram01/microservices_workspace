package com.hotel.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotels")
public class Hotel {

	@Id
	@Column(name = "ID")
	private String hotelId;

	private String name;
	private String location;
	private String about;
	
	@Transient
	//private List<Rating> ratings; // null
	private List<Rating> ratings=new ArrayList<>(); // []

}
