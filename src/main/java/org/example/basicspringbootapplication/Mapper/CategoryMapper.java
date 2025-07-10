package org.example.basicspringbootapplication.Mapper;

import org.example.basicspringbootapplication.DTO.CategoryDTO;
import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.example.basicspringbootapplication.Entity.Category;
import org.example.basicspringbootapplication.Entity.Product;

public class CategoryMapper {
    public static CategoryDTO toDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
    public static Category toEntity(CategoryDTO categoryDTO) {
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }
}
