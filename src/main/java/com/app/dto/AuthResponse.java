package com.app.dto;

import com.app.entities.Gender;
import com.app.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
	
	private String fname;
	
	private String lname;
	
	private Gender gender;
	
	private String email;
	
	private String city;
	
	private Long zipCode;
	
	private String contact;
	
	private Role role;
	
	private String token;
	
	
}
