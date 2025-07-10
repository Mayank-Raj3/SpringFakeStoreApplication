package org.example.basicspringbootapplication.Services;

import org.example.basicspringbootapplication.DTO.CategoryDTO;
import org.example.basicspringbootapplication.Entity.Category;
import org.example.basicspringbootapplication.Mapper.CategoryMapper;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
    public List<CategoryDTO> getAllCategory() throws IOException;
    public CategoryDTO createCategory(CategoryDTO categoryDTO) ;
    public CategoryDTO getCategoryById(long id);
    public CategoryDTO getByName(String name) throws Exception ;
}
