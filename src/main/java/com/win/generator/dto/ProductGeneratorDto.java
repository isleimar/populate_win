package com.win.generator.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductGeneratorDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private List<String> categories;
	private Double price;
	
}
