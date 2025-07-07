package org.example.basicspringbootapplication.gateways;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.example.basicspringbootapplication.DTO.UserDTO;
import org.example.basicspringbootapplication.DTO.UserResponseDTO;
import org.example.basicspringbootapplication.gateways.Apis.FakeStoreUserApi;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FakeStoreUserGateWay implements IUserGateWay {

    private final FakeStoreUserApi fakeStoreUserApi;

    public FakeStoreUserGateWay(FakeStoreUserApi fakeStoreUserApi ) {
        this.fakeStoreUserApi = fakeStoreUserApi;
    }

    @Override
    public List<UserDTO> getAllusers() {

        UserResponseDTO response = fakeStoreUserApi.getAllUsers();
        if(response != null) {
            // Optional: Use ModelMapper for further transformations
            ModelMapper modelMapper = new ModelMapper();
            return response.users.stream()
                    .map(user -> modelMapper.map(user, UserDTO.class))
                    .collect(Collectors.toList());
        }else{
            return  null ;
        }

//        UserResponseDTO response = webClient.get()
//                .uri("/users")
//                .retrieve()
//                .toEntity(UserResponseDTO.class)
//                .block();

    }
}
