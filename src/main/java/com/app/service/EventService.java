package com.app.service;

import com.app.dto.SportsDto;
import com.app.entities.Sports;

public interface EventService {
	
	Sports addSportEvent(Long id,SportsDto sportdto);
	
	

}
