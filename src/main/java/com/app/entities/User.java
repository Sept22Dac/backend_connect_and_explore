package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	@NotBlank(message = "First name can't be blank")
	@Length(min = 2, max = 20, message = "Invalid first name!!!!!!")
	@Column(name = "first_name")
	private String fname;
	
	@NotBlank(message = "Last name can't be blank")
	@Length(min = 2, max = 20, message = "Invalid first name!!!!!!")
	@Column(name = "last_name")
	private String lname;
	
	@NotNull(message = "The date of birth is required.") 
	@Past(message = "The date of birth must be in the past.")
	@Column(name = "date_of_birth")
	private LocalDate dob;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(length = 50, unique = true)
	@Email(message = "Invalid email format")
	private String email;
	
	@Column(length = 300)
	@JsonProperty(access = Access.WRITE_ONLY)
	//@Pattern(regexp ="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Invalid Password !")
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}",message = "Invalid Password !")
	private String password;
	
	@NotBlank(message = "city is mandatory")
	private String city;
	
	@Column(name = "zip_code")
	@NotNull(message ="zipcode is mandatory")
	private Long zipCode;
	
	private String contact;
	
	@JsonIgnore
	@OneToMany( mappedBy = "user",
			cascade = CascadeType.ALL,
			orphanRemoval = true,fetch = FetchType.EAGER)
	private List<UserEvent> events = new ArrayList<>();
	
	
	@Enumerated(EnumType.STRING)
	private Role role;
	

}
