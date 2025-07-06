package org.example.basicspringbootapplication.Apis;

import lombok.Getter;
import org.example.basicspringbootapplication.DTO.FakeStoreCategoryResponseDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;


//@Component will throw an error since it doesn't have any concrete implementation
public interface FakeStoreCategoryApis {
    @GET("products/category")
    Call<FakeStoreCategoryResponseDTO> getAllFakeStoreCategories();
}
