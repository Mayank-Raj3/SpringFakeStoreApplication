package org.example.basicspringbootapplication.Services;

import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface IProductService {
    public ProductDTO getProductById(Long id) ;
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception ;
}
