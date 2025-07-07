package org.example.basicspringbootapplication.Services;

import org.example.basicspringbootapplication.DTO.ProductDTO;

import java.io.IOException;

public interface IProductService {
    public ProductDTO getProductById(Long id) throws IOException;
}
