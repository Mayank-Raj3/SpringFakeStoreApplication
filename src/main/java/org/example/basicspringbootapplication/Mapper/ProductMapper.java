package org.example.basicspringbootapplication.Mapper;

import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.example.basicspringbootapplication.Entity.Product;

public class ProductMapper {
    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .brand(product.getBrand())
                .price(product.getPrice())
                .color(product.getColor())
                .description(product.getDescription())
                .image(product.getImage())
                .model(product.getModel())
                .title(product.getTitle())
                .discount(product.getDiscount())
                .categoryId(product.getCategory().getId())
                .build();
    }
    public static Product toEntity(ProductDTO dto) {
        return Product.builder()
                .brand(dto.getBrand())
                .price(dto.getPrice())
                .color(dto.getColor())
                .description(dto.getDescription())
                .image(dto.getImage())
                .model(dto.getModel())
                .title(dto.getTitle())
                .discount(dto.getDiscount())
                .build();
    }

}
