package org.example.basicspringbootapplication.Controllers;

import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.example.basicspringbootapplication.Services.FakeStoreProductService;
import org.example.basicspringbootapplication.Services.IProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/product")

public class ProductController {
    private final IProductService service;

    public ProductController(@Qualifier("productService") IProductService service) {
        this.service = service;
    }
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable long id) throws IOException {
        return service.getProductById(id) ;
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product) {
        return ResponseEntity.ok(this.service.createProduct(product));
    }
}