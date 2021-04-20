package com.win.generator.dto;

import java.io.Serializable;
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
public class ProductCategoryGeneratorDto implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	Integer id;
	LocalDateTime createDate;
	String name;
	String description;

}
