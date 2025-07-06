package org.example.basicspringbootapplication.gateways;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.example.basicspringbootapplication.DTO.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class FakeStoreUserGateWay implements IUserGateWay {

    private final WebClient webClient;

    public FakeStoreUserGateWay(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public List<UserDTO> getAllusers() {
        // Step 1: Get raw JSON response
        String rawJson = webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println("Raw response: " + rawJson);

        Gson gson = new Gson();
        JsonObject root = JsonParser.parseString(rawJson).getAsJsonObject();

// Extract the "users" array
        JsonArray usersArray = root.getAsJsonArray("users");

// Deserialize the array
        Type listType = new TypeToken<List<UserDTO>>() {}.getType();
        List<UserDTO> users = gson.fromJson(usersArray, listType);

        return users;
    }
}
