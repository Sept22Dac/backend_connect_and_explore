package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.UserEvent;


public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
	

}
