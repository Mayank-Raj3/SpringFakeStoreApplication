package org.example.basicspringbootapplication.Exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
// marks it as runtime exception and thowable is not forced