package org.example.basicspringbootapplication.Mapper;

import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.example.basicspringbootapplication.Entity.Product;

public class ProductMapper {
    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .category(product.getCategory())
                .brand(product.getBrand())
                .price(product.getPrice())
                .color(product.getColor())
                .description(product.getDescription())
                .image(product.getImage())
                .model(product.getModel())
                .title(product.getTitle())
                .discount(product.getDiscount())
                .build();

    }
}
