package com.win.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class VendorWinDto extends UserWinDto{		
	private static final long serialVersionUID = 1L;
	
	@JsonManagedReference	
	private ShopWinDto shop;
	private Integer score;

}
