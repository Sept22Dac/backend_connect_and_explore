package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.EventNotFoundException;
import com.app.entities.Concert;
import com.app.repository.ConcertRepository;

@Service
@Transactional
public class ConcertServiceImpl implements ConcertService {

	
	@Autowired
	private ConcertRepository concertRepo;
	@Override
	public Concert getConcertById(Long id) {
		return concertRepo.findById(id).orElseThrow(()-> new EventNotFoundException("concert event can't be found"));
	}
	@Override
	public List<Concert> findAllConcerts() {
		return concertRepo.findAll();
	}

}
