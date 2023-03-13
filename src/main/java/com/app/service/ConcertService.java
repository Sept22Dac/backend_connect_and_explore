package com.app.service;

import java.util.List;

import com.app.entities.Concert;

public interface ConcertService {

	Concert getConcertById(Long id);

	List<Concert> findAllConcerts();

	String updateJoined(Long event_id);

	void deleteConcertsById(Long id);
}
