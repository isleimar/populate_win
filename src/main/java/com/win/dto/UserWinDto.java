package com.win.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.Data;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class UserWinDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static String[] USER_STATUS = {
			"NEW",
			"INACTIVE",
			"ACTIVE",
			"BLOCKED"};
	
	private String userName;
	private String password;
	private String userStatus;
	private LocalDateTime createDate;
	private PeopleWinDto people;
//	private ProfilePicture profilePicture;
//	private List<Contact> contacts;
//	private List<Address> addresses;
}
