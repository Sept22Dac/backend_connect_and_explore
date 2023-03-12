package com.app.service;

import java.util.List;

import com.app.dto.SportsDto;
import com.app.entities.Concert;
import com.app.entities.Event;
import com.app.entities.Sports;
import com.app.entities.Travel;

public interface EventService {
	
	Sports addSportEvent(Long id,SportsDto sportdto);
	
	Travel addTravelEvent(Long id, Travel travel);

	Concert addConcertEvent(Long id, Concert concert);

	String joinUserEvent(Long user_id, Long event_id);
	
	Event getEventById(Long id);

	

	List<Sports> findJoinedSportsEvents(Long id);

	List<Travel> findJoinedTravelEvents(Long id);

	List<Concert> findJoinedConcertEvents(Long id);

//	List<Sports> findCreatedSportsEvents(Long id);
//	List<Travel> findCreatedTravelEvents(Long id);
//	List<Concert> findCreatedConcertEvents(Long id);
	
	
	

}
