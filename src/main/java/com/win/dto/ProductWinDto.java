package com.win.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.win.generator.dto.ProductCategoryGeneratorDto;

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
public class ProductWinDto implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	public static String[] PRODUCT_STATUS = {
			"INACTIVE",
			"ACTIVE",
			"BLOCKED"};
	
	private String cod;
	private LocalDateTime createDate;
	@JsonBackReference
	@ToString.Exclude
	private ShopWinDto shop;
	private String productStatus;
	List<ProductCategoryGeneratorDto> productCategories;
	private String name;
	private String description;
	private Double price;
	private Double stock;
	private Boolean isDivisible;
//	private List<ProductPicture> productPictures;
//	private List<ProductProperty> productProperties;
//	private List<ProductVariation> productVariations;
	private Integer score;
	private Integer likes;
//	private ProductChat productChat;

}
