package org.example.basicspringbootapplication.Mapper;

import org.example.basicspringbootapplication.DTO.CategoryDTO;
import org.example.basicspringbootapplication.DTO.FakeStoreCategoryResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class GetAllCategoryMappers {
    public static List<CategoryDTO>  toCategoryDTO(FakeStoreCategoryResponseDTO fakeStoreCategoryResponseDTO) {
        return  fakeStoreCategoryResponseDTO.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .collect(Collectors.toList());
    }

}
