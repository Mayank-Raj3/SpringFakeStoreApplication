package org.example.basicspringbootapplication.Controllers;

import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.example.basicspringbootapplication.Services.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable long id) throws IOException {
        return productService.getProductById(id) ;
    }

    public ResponseEntity<ProductDTO> createProduct(@RequestParam ProductDTO product) {
        return ResponseEntity.ok(this.productService.createProduct(product));
    }
}
