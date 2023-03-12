package com.app.service;

import com.app.dto.SportsDto;
import com.app.entities.Concert;
import com.app.entities.Sports;
import com.app.entities.Travel;

public interface EventService {
	
	Sports addSportEvent(Long id,SportsDto sportdto);
	
	Travel addTravelEvent(Long id, Travel travel);

	Concert addConcertEvent(Long id, Concert concert);
	

}
