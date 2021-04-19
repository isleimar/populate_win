package com.win.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
public class ShopWinDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String cod;
	private LocalDateTime createDate;
	@JsonBackReference
	@ToString.Exclude
	private VendorWinDto vendor;
	private String registry;
	private String companyName;	
//	private LogoPicture logoPicture;
	private String tradeName;	
	@JsonManagedReference
	private List<ProductWinDto> products;

}
