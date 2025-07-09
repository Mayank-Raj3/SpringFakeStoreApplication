package org.example.basicspringbootapplication.gateways;

import org.example.basicspringbootapplication.Mapper.GetAllCategoryMappers;
import org.example.basicspringbootapplication.gateways.Apis.FakeStoreCategoryApis;
import org.example.basicspringbootapplication.DTO.CategoryDTO;
import org.example.basicspringbootapplication.DTO.FakeStoreCategoryResponseDTO;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
        return GetAllCategoryMappers.toCategoryDTO(response);

    }
}
