package org.example.basicspringbootapplication.gateways.Apis;

import org.example.basicspringbootapplication.DTO.ProductDTO;
import org.example.basicspringbootapplication.DTO.ProductResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeStoreProductApi {
        @GET("products/{id}")
        Call<ProductResponseDTO> getProduct(@Path("id") Long id);
}
