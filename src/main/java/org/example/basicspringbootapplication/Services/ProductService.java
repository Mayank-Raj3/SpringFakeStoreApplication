package org.example.basicspringbootapplication.Services;

import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.example.basicspringbootapplication.gateways.IProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProductService implements IProductService{
    IProductGateway productGateway;
    public ProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        return productGateway.findById(id);
    }
}
