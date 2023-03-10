package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Event;
import com.app.repository.EventDao;


@Service
@Transactional
public class EventServiceImpl implements EventService{
	
	@Autowired
	EventDao eventRepo;
	
	public void addEvent(Event e) {
		eventRepo.save(e).getEventId();
		
		
	}

}
