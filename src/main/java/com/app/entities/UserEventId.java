package com.app.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEventId implements Serializable{
	
	
	private static final long serialVersionUID = -654954447972448695L;

	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "event_id")
	private Long eventId;
	
	

	@Override
	public int hashCode() {
		return Objects.hash(eventId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEventId other = (UserEventId) obj;
		return Objects.equals(eventId, other.eventId) && Objects.equals(userId, other.userId);
	}
	
	

}
