package com.win.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Builder
@ToString
public class ClientWinDto extends UserWinDto{
	private static final long serialVersionUID = 1L;
	
	private Integer score;
	
}
