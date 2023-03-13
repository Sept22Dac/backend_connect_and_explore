package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Concert;

public interface ConcertRepository extends JpaRepository<Concert, Long> {

	@Modifying
	@Query("update Concert c set c.joined = c.joined+1 where c.id=?1")
	void increaseJoinedByOne(Long event_id);

	@Modifying
	@Query("update Concert c set c.joined = c.joined-1 where c.id=?1")
	void decreaseJoinedByOne(Long eventId);

}
