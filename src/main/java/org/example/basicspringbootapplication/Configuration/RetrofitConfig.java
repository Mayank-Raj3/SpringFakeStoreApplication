package org.example.basicspringbootapplication.Configuration;

import org.example.basicspringbootapplication.gateways.Apis.FakeStoreCategoryApis;
import org.example.basicspringbootapplication.gateways.Apis.FakeStoreProductApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/*
* Makes Retrofit compatible to spring world
* by attaching @bean for making object , and telling spring
* */

@Configuration // This tells Spring that the class contains beans that
                // should be managed by the Spring IoC container.
public class RetrofitConfig {
    @Value("${fakeStore.url}")
    private String fakeStoreUrl;

    @Bean
    Retrofit retrofit(){
        return new Retrofit.Builder().baseUrl(fakeStoreUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    FakeStoreCategoryApis fakeStoreCategoryApis(Retrofit retrofit){
        // retrofit will create class for interface FakeStoreCategoryApis
        return retrofit.create(FakeStoreCategoryApis.class);
    }

    @Bean
    FakeStoreProductApi fakeStoreProductApi(Retrofit retrofit){
        // retrofit will create class for interface FakeStoreCategoryApis
        return retrofit.create(FakeStoreProductApi.class);
    }




}
