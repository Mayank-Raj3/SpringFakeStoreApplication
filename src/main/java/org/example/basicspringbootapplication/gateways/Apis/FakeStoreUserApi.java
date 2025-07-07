package org.example.basicspringbootapplication.gateways.Apis;

import org.example.basicspringbootapplication.DTO.UserResponseDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class FakeStoreUserApi {
    private final WebClient webClient;

    public FakeStoreUserApi(WebClient webClient) {
        this.webClient = webClient;
    }
    public UserResponseDTO getAllUsers(){
        UserResponseDTO response = webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToMono(UserResponseDTO.class)
                .block();
        return  response ;
    }
}
