package com.ecommerce.dto;

import com.ecommerce.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private long id;
	private String description;
	private String imageName;
	private String name;
	private double price;
	private int categoryId;


}
