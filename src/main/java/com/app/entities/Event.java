package com.app.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "events")
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "event_id")
	private Long eventId;
	
	@Enumerated(EnumType.STRING)
	private Type eventType;
	
	@OneToMany(mappedBy = "event",
			cascade = CascadeType.ALL,
			orphanRemoval = true)
	private List<UserEvent> users = new ArrayList<>();
	
	@OneToOne(mappedBy = "sportEvent",cascade = CascadeType.ALL,
			orphanRemoval = true , fetch = FetchType.EAGER)
	private Sports sportEvent;
	
	@OneToOne(mappedBy = "travelEvent"
			,cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Travel travelEvent;
	
	@OneToOne(mappedBy = "concertEvent"
			,cascade = CascadeType.ALL,
			orphanRemoval = true)
	private Concert concertEvent;

	
	public void addSports(Sports s) {
		sportEvent = s;
		s.setSportEvent(this);
		
	}
	
	public void addUsers(UserEvent user_event) {
		users.add(user_event);
	}
	@Override
	public int hashCode() {
		return Objects.hash(eventId, eventType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return Objects.equals(eventId, other.eventId) && eventType == other.eventType;
	}
	
	
	
	
	
	
	

}
