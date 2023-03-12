package com.app.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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

	@JsonProperty(access = Access.READ_ONLY)
	@Id
	@Column(name = "event_id")
	private Long id;
	
	@JsonIgnore
	@OneToOne
	@MapsId
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
	//@DateTimeFormat(iso = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
//	@JsonFormat(pattern = "YYYY-MM-dd HH:mm")
	private LocalDateTime onDate;
	
//	@NotNull
//	@DateTimeFormat(pattern = "HH:mm", iso = ISO.TIME)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
//	private LocalTime time;
	
	@Column(name = "medium")
	@NotNull
	@Enumerated(EnumType.STRING)
	private TravelMedium mediumType;
	
	@NotNull
	private Long required;
	
	private Long joined;
	
	private String description;
	
	
}
