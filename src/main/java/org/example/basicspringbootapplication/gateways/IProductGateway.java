package org.example.basicspringbootapplication.gateways;

import org.example.basicspringbootapplication.DTO.ProductDTO;

import java.io.IOException;

public interface IProductGateway {
    public ProductDTO findById(Long id) throws IOException;
}
