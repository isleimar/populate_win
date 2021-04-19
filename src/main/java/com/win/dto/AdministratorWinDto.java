package com.win.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class AdministratorWinDto extends UserWinDto{
	private static final long serialVersionUID = 1L;
	
	public static String[] ADMINISTRATOR_LEVELS = {"MASTER","CLIENT"};
	
	private String administratorLevel;

}
