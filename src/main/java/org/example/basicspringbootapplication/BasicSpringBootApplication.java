package org.example.basicspringbootapplication;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class BasicSpringBootApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().load();
//        Dotenv dotenv = Dotenv.configure()
//                .directory("src/.env") // or wherever your .env is
//                .filename(".env")
//                .load();
//        If not in Global then give explicit path


        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        SpringApplication.run(BasicSpringBootApplication.class, args);
    }

}
