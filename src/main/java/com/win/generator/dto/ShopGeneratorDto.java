package com.win.generator.dto;

import java.io.Serializable;

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
public class ShopGeneratorDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String registry;
	String companyName;
	String tradeName;

}
