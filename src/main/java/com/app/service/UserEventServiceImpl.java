package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Concert;
import com.app.entities.Sports;
import com.app.entities.Travel;
import com.app.entities.UserEvent;
import com.app.entities.UserEventId;
import com.app.repository.UserEventRepository;


@Service
@Transactional
public class UserEventServiceImpl implements UserEventService {
	
	@Autowired
	private UserEventRepository userEventRepo;

	@Override
	public UserEvent addUserEvent(UserEvent userEvent) {
		
		return userEventRepo.save(userEvent);
	}

	@Override
	public List<Sports> findJoinedSportsEvent(Long id) {
		
		return userEventRepo.findAllJoinedSports(id);
	}

	@Override
	public List<Travel> findJoinedTravelEvent(Long id) {
		// TODO Auto-generated method stub
		return userEventRepo.findAllJoinedTravels(id);
	}

	@Override
	public List<Concert> findJoinedConcertEvent(Long id) {
		// TODO Auto-generated method stub
		return userEventRepo.findAllJoinedConcerts(id);
	}

	@Override
	public List<Sports> findCreatedSportsEvent(Long id) {
		// TODO Auto-generated method stub
		return userEventRepo.findAllCreatedSports(id);
	}

	@Override
	public List<Travel> findCreatedTravelEvent(Long id) {
		// TODO Auto-generated method stub
		return userEventRepo.findAllCreatedTravels(id);
	}

	@Override
	public List<Concert> findCreatedConcertEvent(Long id) {
		// TODO Auto-generated method stub
		return userEventRepo.findAllCreatedConcerts(id);
	}

//	@Override
//	public String joinUserEvent(Long user_id, Long event_id) {
//		
//		UserEventId userEventId = new UserEventId(user_id,event_id);
//		
//		User user = 
//		
//		UserEvent userEvent = new UserEvent(userEventId,user_id,);
//
//		return null;
//	}

}
