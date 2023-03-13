package com.app.service;

import java.util.List;

import com.app.entities.Concert;
import com.app.entities.Event;
import com.app.entities.Sports;
import com.app.entities.Travel;
import com.app.entities.UserEvent;



public interface UserEventService {
	
	
	List<Sports> findJoinedSportsEvent(Long id);

	UserEvent addUserEvent(UserEvent userEvent);

	List<Travel> findJoinedTravelEvent(Long id);

	List<Concert> findJoinedConcertEvent(Long id);

	List<Sports> findCreatedSportsEvent(Long id);
	List<Travel> findCreatedTravelEvent(Long id);
	List<Concert> findCreatedConcertEvent(Long id);

	List<UserEvent> getUserEvents(Event event);

	void deleteAllByEvent(Event event);

//	String joinUserEvent(Long user_id, Long event_id);

}
