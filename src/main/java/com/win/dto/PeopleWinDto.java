package com.win.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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


public class PeopleWinDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private LocalDateTime createDate;	
	private String name;
	private String gender;
	private LocalDate birthdate;
	
}


