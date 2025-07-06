package org.example.basicspringbootapplication.gateways;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.example.basicspringbootapplication.DTO.UserDTO;
import org.example.basicspringbootapplication.DTO.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FakeStoreUserGateWay implements IUserGateWay {

    private final WebClient webClient;

    public FakeStoreUserGateWay(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<UserDTO> getAllusers() {
        UserResponseDTO response = webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToMono(UserResponseDTO.class)
                .block();

        // Optional: Use ModelMapper for further transformations
        ModelMapper modelMapper = new ModelMapper();
        return response.users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }


}
