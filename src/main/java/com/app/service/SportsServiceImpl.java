package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.EventNotFoundException;
import com.app.entities.Sports;
import com.app.repository.SportsRepository;

@Service
@Transactional
public class SportsServiceImpl implements SportsService {
	
	@Autowired
	private SportsRepository sportsRepo;

	@Override
	public Sports getSportById(Long id) {

		
		return sportsRepo.findById(id).orElseThrow(()-> new EventNotFoundException("Sport event with id " + id + " not found"));
	}

}
