package org.example.basicspringbootapplication.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${fakeStore.url}")
    private String fakeStoreUrl;
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(fakeStoreUrl)
                .build();
    }
}
