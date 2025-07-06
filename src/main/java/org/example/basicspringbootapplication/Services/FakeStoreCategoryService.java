package org.example.basicspringbootapplication.Services;

import org.example.basicspringbootapplication.DTO.CategoryDTO;
import org.example.basicspringbootapplication.gateways.ICategoryGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService {
    private final ICategoryGateway categoryGateway ;
    public FakeStoreCategoryService(ICategoryGateway _categoryGateway){
        this.categoryGateway= _categoryGateway;
    }

    @Override
    public List<CategoryDTO> getAllCategory() throws IOException {
        return this.categoryGateway.getAllCategories();
    }
}
