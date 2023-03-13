package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.AlreadyFullException;
import com.app.custom_exceptions.EventNotFoundException;
import com.app.entities.Sports;
import com.app.entities.SportsType;
import com.app.entities.Type;
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

	@Override
	public List<Sports> findAllSports() {
		
		return sportsRepo.findAll();
	}

	@Override
	public List<Sports> findAllParticularSports(SportsType stype) {

		return sportsRepo.findByStype(stype);
	}

	@Override
	public String updateJoined(Long event_id) {

		Sports sport = getSportById(event_id);
		if(sport.getJoined()< sport.getRequired()) {
			sportsRepo.increaseJoinedByOne(event_id);
			return "Joined Event";
		}else {
			throw new AlreadyFullException("Sports full");
		}
		
	}

	@Override
	public void deleteSportsById(Long id) {
		sportsRepo.deleteById(id);
		
	}

}
