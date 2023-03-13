package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Travel;

public interface TravelRepository extends JpaRepository<Travel, Long>{

	@Modifying
	@Query("update Travel t set t.joined = t.joined+1 where t.id = ?1")
	void increaseJoinedByOne(Long event_id);

	@Modifying
	@Query("update Travel t set t.joined = t.joined-1 where t.id = ?1")
	void decreaseJoinedByOne(Long eventId);

}
