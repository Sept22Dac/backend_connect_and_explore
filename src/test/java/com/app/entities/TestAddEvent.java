package com.app.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.dto.SportsDto;
import com.app.service.EventService;


@SpringBootTest
class TestAddEvent {
	
	@Autowired
	EventService eventService;

	@Test
	void test() {
		
		/*
		 * private Event sportEvent;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String location;
	
	@NotNull
	private LocalDate date;
	
	@NotNull
	private LocalTime time;
	
	@NotNull
	private Long required;
	
	private Long joined;
		 */
		
		SportsDto sport = new SportsDto("Football","pune",LocalDate.parse("2023-04-01"),LocalTime.parse("10:30"),100L,50L);
		
		eventService.addSportEvent( 2L,sport );
	}

}
