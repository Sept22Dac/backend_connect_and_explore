package com.app.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.SportsDto;
import com.app.entities.Concert;
import com.app.entities.Event;
import com.app.entities.Sports;
import com.app.entities.Travel;
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
	
	@Autowired
	private TravelService travelService;
	
	@Autowired
	private ConcertService concertService;
	
	public Sports addSportEvent(Long id, SportsDto sportdto) {
		Event e = new Event();
		e.setEventType(Type.SPORTS);
		Sports sport = new Sports(e.getEventId(),e,sportdto.getStype(),sportdto.getName(),sportdto.getLocation(),sportdto.getDate(),sportdto.getJoined(),sportdto.getRequired());
		e.addSports(sport);
		Event savedEvent =  eventRepo.save(e);
		User user = userService.getUserById(id);
		UserEventId userEventId = new UserEventId(user.getUser_id(),savedEvent.getEventId());
		UserEvent userEvent = new UserEvent(userEventId,user,savedEvent,LocalDateTime.now(),null);
		
		userEventService.addUserEvent(userEvent);
		
		return sportsService.getSportById(savedEvent.getEventId());
		
	}
	
	public Travel addTravelEvent(Long id, Travel travel) {
		Event e = new Event();
		e.setEventType(Type.TRAVEL);

		Travel savedtravel = new Travel(e.getEventId(),e,travel.getFromLocation(),travel.getToLocation(),travel.getOnDate(),travel.getMediumType(),travel.getRequired(),travel.getJoined(),travel.getDescription());
		e.setTravelEvent(savedtravel);
		Event savedEvent = eventRepo.save(e);
		User user = userService.getUserById(id);
		UserEventId userEventId = new UserEventId(user.getUser_id(),savedEvent.getEventId());
		UserEvent userEvent = new UserEvent(userEventId,user,savedEvent,LocalDateTime.now(),null);
		userEventService.addUserEvent(userEvent);
		
		return travelService.getTravelById(savedEvent.getEventId());
	}
	
	public Concert addConcertEvent(Long id, Concert concert) {
		Event e = new Event();
		e.setEventType(Type.CONCERT);


		Concert savedConcert = new Concert(e.getEventId(),e,concert.getName(),concert.getLocation(),concert.getDate(),concert.getRequired(),concert.getJoined(),concert.getPaid(),concert.getCharges());
		e.setConcertEvent(savedConcert);
		Event savedEvent = eventRepo.save(e);
		User user = userService.getUserById(id);
		UserEventId userEventId = new UserEventId(user.getUser_id(),savedEvent.getEventId());
		UserEvent userEvent = new UserEvent(userEventId,user,savedEvent,LocalDateTime.now(),null);
		userEventService.addUserEvent(userEvent);
		
		return concertService.getConcertById(savedEvent.getEventId());
	}


}
