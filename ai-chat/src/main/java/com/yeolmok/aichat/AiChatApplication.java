package com.yeolmok.aichat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class AiChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiChatApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(OllamaChatModel ollamaChatModel,
                                 DateTimeTools dateTimeTools) {
        return args -> {
            System.out.println("------------------------------------");
            ChatClient chatClient = ChatClient.builder(ollamaChatModel)
                    .defaultSystem("You are useful assistant")
                    .build();

            try (Scanner scanner = new Scanner(System.in)) {
                while (true) {
                    System.out.print("\nUser: ");
                    System.out.println("\nAssistant: " +
                            chatClient
                                    .prompt(scanner.nextLine())
                                    .tools(dateTimeTools)
                                    .call()
                                    .content());
                }
            }
        };
    }
}
