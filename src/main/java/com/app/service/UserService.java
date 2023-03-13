package com.app.service;

import java.util.List;

import com.app.entities.User;

public interface UserService {
	
	User addUserDetails(User user);
	
	User getUserById(Long id);

	List<User> findAllUser();

	String deleteUser(Long id);
	

}
