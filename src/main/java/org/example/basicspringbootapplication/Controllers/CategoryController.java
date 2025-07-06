package org.example.basicspringbootapplication.Controllers;

import org.example.basicspringbootapplication.DTO.CategoryDTO;
import org.example.basicspringbootapplication.Services.FakeStoreCategoryService;
import org.example.basicspringbootapplication.Services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")

public class CategoryController {
//    @Autowired Not recommended Feild Injection
    private ICategoryService categoryService ;
    public CategoryController(ICategoryService _categoryService){
        // this is dependency Injection used for Dependency Inversion (Does not depend upon concrete Class , loose coupling)
        this.categoryService= _categoryService;
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() throws IOException {
        return categoryService.getAllCategory();
    }

}
