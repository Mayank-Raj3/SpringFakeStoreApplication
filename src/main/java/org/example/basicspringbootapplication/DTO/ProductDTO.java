package org.example.basicspringbootapplication.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDTO {
	private String image;
	private String color;
	private int price;
	private String description;
	private int discount;
	private String model;
	private long id;
	private String title;
	private String category;
	private String brand;

}
