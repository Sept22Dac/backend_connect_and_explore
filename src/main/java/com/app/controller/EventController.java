package com.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.SportsDto;
import com.app.entities.Concert;
import com.app.entities.SportsType;
import com.app.entities.Travel;
import com.app.service.ConcertService;
import com.app.service.EventService;
import com.app.service.SportsService;
import com.app.service.TravelService;
import com.app.service.UserEventService;

@RestController
@RequestMapping("/event")

public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private SportsService sportService;
	
	@Autowired
	private TravelService travelService;
	
	@Autowired
	private ConcertService concertService;
	
	@Autowired
	private UserEventService userEventService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/add/sport")
	public ResponseEntity<?> addSportEvent(@RequestParam Long id, @RequestBody SportsDto sportdto){
		
		return new ResponseEntity<>(eventService.addSportEvent(id,sportdto), HttpStatus.CREATED);
	}
	
	@PostMapping("/add/travel")
    public ResponseEntity<?> addTravelEvent(@RequestParam Long id, @RequestBody Travel travel){
		
		return new ResponseEntity<>(eventService.addTravelEvent(id,travel), HttpStatus.CREATED);
	}
	
	@GetMapping("/sports")
	public ResponseEntity<?> getAllSports(){
		return new ResponseEntity<>(sportService.findAllSports(), HttpStatus.OK);
	}
	
	@GetMapping("/travels")
	public ResponseEntity<?> getAllTravels(){
		return new ResponseEntity<>(travelService.findAllTravels(), HttpStatus.OK);
	}
	
	
	@GetMapping("/sports/{stype}")
	public ResponseEntity<?> getParticularSports(@PathVariable SportsType stype){
		return new ResponseEntity<>(sportService.findAllParticularSports(stype),HttpStatus.OK);
	}
	
	
	@PostMapping("/add/concert")
	public ResponseEntity<?> addConcertEvent(@RequestParam Long id, @RequestBody Concert concert){
		
		return new ResponseEntity<>(eventService.addConcertEvent(id,concert), HttpStatus.CREATED);
	}
	
	@GetMapping("/concerts")
	public ResponseEntity<?> getAllConcerts(){
		return new ResponseEntity<>(concertService.findAllConcerts(), HttpStatus.OK);
	}
	
	@PutMapping("/joinEvent")
	public ResponseEntity<?> joinEvent(@RequestParam Long user_id, @RequestParam Long event_id ){
		return new ResponseEntity<>(eventService.joinUserEvent(user_id,event_id),HttpStatus.OK);
	}
	
	
	
	
	

}
