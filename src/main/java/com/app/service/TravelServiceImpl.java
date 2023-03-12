package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.EventNotFoundException;
import com.app.entities.Travel;
import com.app.repository.TravelRepository;

@Service
@Transactional
public class TravelServiceImpl implements TravelService {

	@Autowired
	TravelRepository travelRepo;
	
	@Override
	public Travel getTravelById(Long id) {

		return travelRepo.findById(id).orElseThrow(()-> new EventNotFoundException("Travel event not found"));
	}

	@Override
	public List<Travel> findAllTravels() {
		return travelRepo.findAll();
	}

}
