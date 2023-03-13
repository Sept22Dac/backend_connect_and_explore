package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.UserAlreadyExistsException;
import com.app.custom_exceptions.UserNotFoundException;
import com.app.entities.Event;
import com.app.entities.Role;
import com.app.entities.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private PasswordEncoder enc;
	
	@Override
	public User addUserDetails(User user) {

		if(userRepo.existsByEmail(user.getEmail())) {
			throw new UserAlreadyExistsException("Email already exits");
		}
		user.setRole(Role.valueOf("ROLE_USER"));
		user.setPassword(enc.encode(user.getPassword()));
		
		return userRepo.save(user);
	}

	@Override
	public User getUserById(Long id) {
		
		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + "does not exist"));
	}

	@Override
	public List<User> findAllUser() {
		
		return userRepo.findAll();
	}
	
	

	@Override
	public String deleteUser(Long id) {
		if(userRepo.existsById(id)) {
			List<Event> events = userRepo.findAllCreatedEvents(id);
			events.forEach((event)->{
				eventService.deleteEvent(event.getEventId());
			});
			userRepo.deleteById(id);
		}else {
			throw new UserNotFoundException("User does not exits");
		}
		return "user deleted" ;
	}
	
	

}
