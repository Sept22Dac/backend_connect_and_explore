package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Concert;
import com.app.entities.Event;
import com.app.entities.Sports;
import com.app.entities.Travel;
import com.app.entities.UserEvent;


public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
	

	@Query("select s from UserEvent ue join ue.event e join e.sportEvent s join ue.user u where u.user_id =?1 and ue.createdDate = null")
	List<Sports> findAllJoinedSports(Long id);
	
	@Query("select t from UserEvent ue join ue.event e join e.travelEvent t join ue.user u where u.user_id =?1 and ue.createdDate = null")
	List<Travel> findAllJoinedTravels(Long id);
	
	@Query("select c from UserEvent ue join ue.event e join e.concertEvent c join ue.user u where u.user_id =?1 and ue.createdDate = null")
	List<Concert> findAllJoinedConcerts(Long id);
	
	@Query("select s from UserEvent ue join ue.event e join e.sportEvent s join ue.user u where u.user_id =?1 and ue.joinedDate = null")
	List<Sports> findAllCreatedSports(Long id);
	
	@Query("select t from UserEvent ue join ue.event e join e.travelEvent t join ue.user u where u.user_id =?1 and ue.joinedDate = null")
	List<Travel> findAllCreatedTravels(Long id);
	
	@Query("select c from UserEvent ue join ue.event e join e.concertEvent c join ue.user u where u.user_id =?1 and ue.joinedDate = null")
	List<Concert> findAllCreatedConcerts(Long id);
	
	List<UserEvent> findByEvent(Event event);

	@Modifying
	@Query("delete from UserEvent ue where ue.event=?1")
	void deleteByEvent(Event event);
}
