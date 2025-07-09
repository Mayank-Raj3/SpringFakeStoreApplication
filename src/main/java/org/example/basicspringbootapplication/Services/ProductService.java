package org.example.basicspringbootapplication.Services;

import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public class ProductService implements IProductService {
    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        return null;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return null;
    }
}
