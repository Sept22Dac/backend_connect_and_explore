package com.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.app.custom_exceptions.EventNotFoundException;
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
		Sports sport = new Sports(e.getEventId(),e,sportdto.getStype(),sportdto.getName(),sportdto.getLocation(),sportdto.getDate(),sportdto.getRequired(),sportdto.getJoined());
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

	@Override
	public String joinUserEvent(Long user_id, Long event_id) {
		String msg = "Not able to join";
		
		User user = userService.getUserById(user_id);
		Event event = getEventById(event_id);
	

		
		if(event.getEventType().equals(Type.SPORTS)) {
			
				msg = sportsService.updateJoined(event_id);
	
		}else if(event.getEventType().equals(Type.CONCERT)) {
			
			 msg = concertService.updateJoined(event_id);
				
		}else {
			msg = travelService.updateJoined(event_id);
		}
		
		UserEventId userEventId = new UserEventId(user_id,event_id);
		UserEvent userEvent = new UserEvent(userEventId,user,event,null,LocalDateTime.now());
		userEventService.addUserEvent(userEvent);
		
		
		return msg;
	}

	@Override
	public Event getEventById(Long id) {
		
		return eventRepo.findById(id).orElseThrow(()-> new EventNotFoundException("Event not found"));
	}

	@Override
	public String deleteEvent(Long id) {

		if(eventRepo.existsById(id)) {
			Event event = getEventById(id);
//			if(event.getEventType().equals(Type.SPORTS)) {
//				event.deleteSports(sportsService.getSportById(id));
//				event.deleteUserEvents(userEventService.getUserEvents(event));
//				eventRepo.deleteById(id);
//			}
			if(event.getEventType().equals(Type.SPORTS)) {
			sportsService.deleteSportsById(id);
			userEventService.deleteAllByEvent(event);
			eventRepo.deleteById(id);
			}else if(event.getEventType().equals(Type.CONCERT)) {
				concertService.deleteConcertsById(id);
				userEventService.deleteAllByEvent(event);
				eventRepo.deleteById(id);
			}else {
				travelService.deleteTravelById(id);
				userEventService.deleteAllByEvent(event);
				eventRepo.deleteById(id);
			}
			

		}else {
			throw new EventNotFoundException("there is no event with id " + id);
		}
		
		 return "event deleted";
	}


}
