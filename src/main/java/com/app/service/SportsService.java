package com.app.service;

import java.util.List;

import com.app.entities.Sports;
import com.app.entities.SportsType;
import com.app.entities.Type;



public interface SportsService {
	
	Sports getSportById(Long id);
	
	List<Sports> findAllSports();

	List<Sports> findAllParticularSports(SportsType stype);

	String updateJoined(Long event_id);

	void deleteSportsById(Long id);

}
