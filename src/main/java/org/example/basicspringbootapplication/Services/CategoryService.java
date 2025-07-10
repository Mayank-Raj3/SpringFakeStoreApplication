package org.example.basicspringbootapplication.Services;

import org.example.basicspringbootapplication.DTO.CategoryDTO;
import org.example.basicspringbootapplication.Entity.Category;
import org.example.basicspringbootapplication.Mapper.CategoryMapper;
import org.example.basicspringbootapplication.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategory() throws IOException {
        List<Category> saved = this.categoryRepository.findAll();
        return saved.stream().map(CategoryMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = CategoryMapper.toEntity(categoryDTO);
        Category saved = this.categoryRepository.save(category);
        return CategoryMapper.toDTO(saved);
    }

    @Override
    public CategoryDTO getCategoryById(long id) {
        Category category = this.categoryRepository.findById(id).orElse(null);
        assert category != null;
        return CategoryMapper.toDTO(category);
    }
}
