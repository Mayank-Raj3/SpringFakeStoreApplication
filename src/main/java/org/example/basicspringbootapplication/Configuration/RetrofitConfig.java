package org.example.basicspringbootapplication.Configuration;

import org.example.basicspringbootapplication.Apis.FakeStoreCategoryApis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
    @Bean
    Retrofit retrofit(){
        return new Retrofit.Builder().baseUrl("https://fakestoreapi.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    FakeStoreCategoryApis fakeStoreCategoryApis(Retrofit retrofit){
        return retrofit.create(FakeStoreCategoryApis.class);
    }

}
