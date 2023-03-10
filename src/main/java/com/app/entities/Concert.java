package com.app.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "concerts")
public class Concert implements Serializable{
	
	
	private static final long serialVersionUID = 375903741322904846L;

	@Id
	@OneToOne
	@JoinColumn(name = "event_id")
	private Event concertEvent;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String location;
	
	@NotNull
	private LocalDate date;
	
	@NotNull
	private LocalTime time;
	
	@NotNull
	@Column(name = "requirement")
	private Long required;
	
	private Long joined;
	@Enumerated(EnumType.STRING)
	private Entry paid;
	
	
	private Long charges;

}
