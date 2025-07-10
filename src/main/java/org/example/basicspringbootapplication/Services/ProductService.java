package org.example.basicspringbootapplication.Services;

import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.example.basicspringbootapplication.Entity.Product;
import org.example.basicspringbootapplication.Mapper.ProductMapper;
import org.example.basicspringbootapplication.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        return productRepository.findById(id)
                .map(ProductMapper::toDTO)
                .orElseThrow(() -> new IOException("Product not found with id: " + id));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product productSave =  this.productRepository.save(ProductMapper.toEntity(productDTO));
        return ProductMapper.toDTO(productSave);
    }
}
