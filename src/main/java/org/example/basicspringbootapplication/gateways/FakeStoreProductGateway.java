package org.example.basicspringbootapplication.gateways;

import org.example.basicspringbootapplication.DTO.CategoryDTO;
import org.example.basicspringbootapplication.DTO.FakeStoreCategoryResponseDTO;
import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.example.basicspringbootapplication.DTO.ProductResponseDTO;
import org.example.basicspringbootapplication.gateways.Apis.FakeStoreProductApi;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.stream.Collectors;

@Component
public class FakeStoreProductGateway implements IProductGateway {
    private final FakeStoreProductApi fakeStoreProductApi;
    public FakeStoreProductGateway(FakeStoreProductApi fakeStoreProductApi) {
        this.fakeStoreProductApi = fakeStoreProductApi;
    }
    @Override
    public ProductDTO findById(Long id) throws IOException {
        ProductResponseDTO response = fakeStoreProductApi.getProduct(id)
                .execute().body();

//        System.out.println(response);

        if(response == null){
            throw new IOException("Failed To fetch Category api");
        }

        return response.getProduct();

    }
}
