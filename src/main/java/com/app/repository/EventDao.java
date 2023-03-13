package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.app.entities.Event;


public interface EventDao extends JpaRepository<Event, Long> {
	
	
	

}
