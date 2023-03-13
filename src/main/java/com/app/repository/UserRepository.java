package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Event;
import com.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);
	
	@Query("select e from User u join u.events ue join ue.event e where u.user_id = ?1 and ue.joinedDate = null")
	List<Event> findAllCreatedEvents(Long id);
	
	

}
