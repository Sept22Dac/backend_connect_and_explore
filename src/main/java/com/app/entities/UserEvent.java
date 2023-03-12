package com.app.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserEvent {
	
	

	@EmbeddedId
	private UserEventId id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("event_id")
	@JoinColumn(name = "event_id")
	private Event event;
	
	@Column(name = "creation_date")
	private LocalDateTime createdDate;
	
	@Column(name = "joining_date")
	private LocalDateTime joinedDate;
	
	@Override
	public int hashCode() {
		return Objects.hash(event, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEvent other = (UserEvent) obj;
		return Objects.equals(event, other.event) && Objects.equals(user, other.user);
	}
	
	
}
