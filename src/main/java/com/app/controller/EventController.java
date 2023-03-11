package com.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SportsDto;
import com.app.entities.Sports;
import com.app.service.EventService;

@RestController
@RequestMapping("/event")

public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/add/sport")
	public ResponseEntity<?> addSportEvent(@RequestParam Long id, @RequestBody SportsDto sportdto){
//		return new ResponseEntity<>(eventService.addEvent(type,event), HttpStatus.CREATED);
		
		
		return new ResponseEntity<>(eventService.addSportEvent(id,sportdto), HttpStatus.CREATED);
	}
	
	
	

}
