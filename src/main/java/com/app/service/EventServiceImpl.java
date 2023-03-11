package com.app.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.SportsDto;
import com.app.entities.Event;
import com.app.entities.Sports;
import com.app.entities.Type;
import com.app.entities.User;
import com.app.entities.UserEvent;
import com.app.entities.UserEventId;
import com.app.repository.EventDao;


@Service
@Transactional
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventDao eventRepo;
	
	@Autowired
	private UserEventService userEventService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SportsService sportsService;
	
	public Sports addSportEvent(Long id, SportsDto sportdto) {
		Event e = new Event();
		e.setEventType(Type.SPORTS);
		Sports sport = new Sports(e.getEventId(),e,sportdto.getName(),sportdto.getLocation(),sportdto.getDate(),sportdto.getTime(),sportdto.getJoined(),sportdto.getRequired());
		e.addSports(sport);
		Event savedEvent =  eventRepo.save(e);
		User user = userService.getUserById(id);
		UserEventId userEventId = new UserEventId(user.getUser_id(),savedEvent.getEventId());
		UserEvent userEvent = new UserEvent(userEventId,user,savedEvent,LocalDateTime.now(),null);
		userEventService.addUserEvent(userEvent);
		
		return sportsService.getSportById(savedEvent.getEventId());
		
	}

}
