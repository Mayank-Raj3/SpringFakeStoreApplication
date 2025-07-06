package org.example.basicspringbootapplication.Services;

import org.example.basicspringbootapplication.DTO.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {
    public List<CategoryDTO> getAllCategory() throws IOException;
}
