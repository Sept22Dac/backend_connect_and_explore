package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Sports;
import com.app.entities.SportsType;
import com.app.entities.Type;

public interface SportsRepository extends JpaRepository<Sports, Long> {
	
//	@Query(
//			  value = "SELECT * FROM Sports s INNER JOIN s.sportEvent eid ON(s.id = eid.id) WHERE eid.eventType = ?1", 
//			  nativeQuery = true)
//	//@Query("select e from Sports e join e.sportsEvent eid e.id sid where eid.eventType=?1")
//	List<Sports> findSportsByType(Type type);
	
	//List<Sports> findBySType(SportsType sType);
	List<Sports> findByStype(SportsType stype);
	
	

	@Modifying
	@Query("update Sports s set s.joined = s.joined +1 where s.id = ?1")
	void increaseJoinedByOne(Long event_id);


	
	@Modifying
	@Query("update Sports s set s.joined = s.joined -1 where s.id = ?1")
	void decreaseJoinedByOne(Long eventId);
	

}
