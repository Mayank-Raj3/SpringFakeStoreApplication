package org.example.basicspringbootapplication.Services;

import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.example.basicspringbootapplication.gateways.IProductGateway;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FakeStoreProductService implements IProductService{
    IProductGateway productGateway;
    public FakeStoreProductService(IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public ProductDTO getProductById(Long id)  {
//        return productGateway.findById(id);
    return  null;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception{
        return null;
    }
}
