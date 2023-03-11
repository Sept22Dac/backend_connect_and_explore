package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.UserEvent;
import com.app.repository.UserEventRepository;


@Service
@Transactional
public class UserEventServiceImpl implements UserEventService {
	
	@Autowired
	private UserEventRepository userEventRepo;

	@Override
	public UserEvent addUserEvent(UserEvent userEvent) {
		
		return userEventRepo.save(userEvent);
	}

}
