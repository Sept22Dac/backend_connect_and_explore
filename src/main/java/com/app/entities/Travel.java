package com.app.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "travels")
public class Travel implements Serializable{

	
	private static final long serialVersionUID = -1660734327851197584L;

	@Id
	@OneToOne
	@JoinColumn(name = "event_id")
	private Event travelEvent;
	
	@NotBlank
	@Column(name = "from_location")
	private String fromLocation;
	
	@NotBlank
	@Column(name = "to_location")
	private String toLocation;
	
	@Column(name = "date")
	@NotNull
	private LocalDate onDate;
	
	@NotNull
	private LocalTime time;
	
	@Column(name = "medium")
	@NotBlank
	private String mediumType;
	
	@NotNull
	private Long required;
	
	private Long joined;
	
	private String description;
	
	
}
