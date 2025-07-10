package org.example.basicspringbootapplication.Services;

import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.example.basicspringbootapplication.Entity.Category;
import org.example.basicspringbootapplication.Entity.Product;
import org.example.basicspringbootapplication.Mapper.ProductMapper;
import org.example.basicspringbootapplication.Repository.CategoryRepository;
import org.example.basicspringbootapplication.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        return productRepository.findById(id)
                .map(ProductMapper::toDTO)
                .orElseThrow(() -> new IOException("Product not found with id: " + id));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception {
        Category category = this.categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new Exception("Category not found"));

        Product saved = this.productRepository.save(ProductMapper.toEntity(productDTO, category));
        return ProductMapper.toDTO(saved);
    }

}
