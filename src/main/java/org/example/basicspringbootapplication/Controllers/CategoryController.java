package org.example.basicspringbootapplication.Controllers;

import org.example.basicspringbootapplication.DTO.CategoryDTO;
import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.example.basicspringbootapplication.Entity.Category;
import org.example.basicspringbootapplication.Mapper.CategoryMapper;
import org.example.basicspringbootapplication.Services.FakeStoreCategoryService;
import org.example.basicspringbootapplication.Services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")

public class CategoryController {
//    @Autowired Not recommended field Injection
    private final ICategoryService categoryService ;
    public CategoryController(@Qualifier("categoryService") ICategoryService _categoryService){
        // this is dependency Injection used for Dependency Inversion (Does not depend upon concrete Class , loose coupling)
        this.categoryService= _categoryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable long id) throws IOException {
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) throws IOException {
        return ResponseEntity.ok(categoryService.createCategory(categoryDTO));
    }

    @GetMapping
    public ResponseEntity<?> getCategoryByName(@RequestParam(required = false) String name) throws Exception {
        if(name!=null && !name.isEmpty()){
            CategoryDTO categoryDTO = categoryService.getByName(name);
            return ResponseEntity.ok(categoryDTO);
        }
       return ResponseEntity.ok(categoryService.getAllCategory());
    }

}



















