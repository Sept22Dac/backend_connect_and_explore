package com.app.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.app.entities.SportsType;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SportsDto {

	@NotBlank
	private String name;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private SportsType stype;
	
	@NotBlank
	private String location;
	
	@NotNull
	private LocalDateTime date;
	
//	@NotNull
//	//@JsonFormat(pattern = "HH:mm:ss", shape = JsonFormat.Shape.STRING)
//	@DateTimeFormat(pattern = "HH:mm", iso = ISO.TIME)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
//	private LocalTime time;
	
	@NotNull
	private Long required;
	
	private Long joined;
}
