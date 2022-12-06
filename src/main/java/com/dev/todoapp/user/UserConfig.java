package com.dev.todoapp.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return args -> {
            User mimi = new User(
                    "mimi",
                    "Mirai",
                    "Miro",
                    "mirai123",
                    "mirai@gmail.com",
                    "123456"
            );
            User kiki = new User(
                    "kiki",
                    "kiii",
                    "koko",
                    "kiki123",
                    "kiki@gmail.com",
                    "123456"
            );
            userRepository.saveAll(
                    List.of(mimi, kiki)
            );
        };
    }
}
