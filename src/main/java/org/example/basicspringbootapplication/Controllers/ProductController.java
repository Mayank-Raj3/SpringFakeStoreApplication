package org.example.basicspringbootapplication.Controllers;

import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.example.basicspringbootapplication.Exceptions.ProductNotFoundException;
import org.example.basicspringbootapplication.Services.FakeStoreProductService;
import org.example.basicspringbootapplication.Services.IProductService;
import org.example.basicspringbootapplication.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> getProductById(@PathVariable long id) throws IOException {
//        ProductDTO response = service.getProductById(id) ;
//        ResponseEntity.ok(response);

        try{
            ProductDTO response = service.getProductById(id) ;
            return ResponseEntity.ok(response) ;
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Not found") ;
        }

    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product) throws Exception{
        return ResponseEntity.ok(this.service.createProduct(product));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleException(Exception ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage()) ;
    }
}