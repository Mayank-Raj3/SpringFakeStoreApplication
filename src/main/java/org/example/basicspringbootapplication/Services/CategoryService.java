package org.example.basicspringbootapplication.Services;

import org.example.basicspringbootapplication.DTO.AllProductsOfCategoryDTO;
import org.example.basicspringbootapplication.DTO.CategoryDTO;
import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.example.basicspringbootapplication.Entity.Category;
import org.example.basicspringbootapplication.Mapper.CategoryMapper;
import org.example.basicspringbootapplication.Mapper.ProductMapper;
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

    @Override
    public CategoryDTO getByName(String name) throws Exception {
        Category saved = this.categoryRepository.findByName(name).orElseThrow(() -> new Exception("Category not found"));
        return CategoryMapper.toDTO(saved);
    }

    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) throws Exception {
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new Exception("Category not found with id: " + categoryId));


        List<ProductDTO> productDTOs = category.getProducts()
                .stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());

        return AllProductsOfCategoryDTO.builder()
                .categoryId(category.getId())
                .name(category.getName())
                .products(productDTOs)
                .build();
    }

}
