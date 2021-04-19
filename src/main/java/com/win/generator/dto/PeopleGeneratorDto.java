package com.win.generator.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PeopleGeneratorDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String name;
	private String gender;		
	private	LocalDate birthdate;

}
