package com.app.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "sports")
//@IdClass(DependentId.class)
public class Sports implements Serializable{

	
	private static final long serialVersionUID = 5286095035991362127L;

	@Id
	@Column(name = "event_id")
	private Long id;
	
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "event_id")
	@MapsId
	private Event sportEvent;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SportsType stype;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String location;
	
	@NotNull
	private LocalDateTime date;
	
//	@NotNull
//	@DateTimeFormat(pattern = "HH:mm", iso = ISO.TIME)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
//	private LocalTime time;
	
	@NotNull
	private Long required;
	
	private Long joined;

//	public Sports(@NotBlank String name, @NotBlank String location, @NotNull LocalDate date, @NotNull LocalTime time,
//			@NotNull Long required, Long joined) {
//		super();
//		this.name = name;
//		this.location = location;
//		this.date = date;
//		this.time = time;
//		this.required = required;
//		this.joined = joined;
//	}
	
	
}
