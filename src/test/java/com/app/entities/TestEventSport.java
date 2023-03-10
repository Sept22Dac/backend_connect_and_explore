package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.service.EventService;

@SpringBootTest
class TestEventSport {

	@Autowired
	EventService eventService;
	
	@Test
	void test() {
		
		Event e = new Event();
		e.setEventType(Type.SPORTS);
		//current | date       | location | name           | required | event_id
		Sports s = new Sports(e,"cricket","raigarh",LocalDate.parse("2023-05-29"),LocalTime.parse("10:15"),Long.valueOf(50),Long.valueOf(30));
		e.addSports(s);
		eventService.addEvent(e);
		
	}

}
