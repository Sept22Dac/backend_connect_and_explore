package com.app.service;

import java.util.List;

import com.app.entities.Travel;

public interface TravelService {
	Travel getTravelById(Long id);
	
	List<Travel> findAllTravels();

	String updateJoined(Long event_id);

	void deleteTravelById(Long id);
}
