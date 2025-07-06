package org.example.basicspringbootapplication.gateways;

import org.example.basicspringbootapplication.Apis.FakeStoreCategoryApis;
import org.example.basicspringbootapplication.DTO.CategoryDTO;
import org.example.basicspringbootapplication.DTO.FakeStoreCategoryResponseDTO;
import org.example.basicspringbootapplication.Services.FakeStoreCategoryService;
import org.springframework.stereotype.Component;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway {
    public FakeStoreCategoryApis fakeStoreCategoryApis ;
    public FakeStoreCategoryGateway(FakeStoreCategoryApis _fakeStoreCategoryApis){
        this.fakeStoreCategoryApis = _fakeStoreCategoryApis;
    }


    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {

        FakeStoreCategoryResponseDTO response = this.fakeStoreCategoryApis
                .getAllFakeStoreCategories()
                .execute()
                .body();

        if(response == null){
            throw new IOException("Failed To fetch Category api");
        }
        return response.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .collect(Collectors.toList());

    }
}
