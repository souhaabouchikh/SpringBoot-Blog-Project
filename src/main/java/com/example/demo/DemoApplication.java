package com.example.demo;

import com.example.demo.Security.Services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(AccountService accountService) {
        return args -> {
//            accountService.CreateUser("admin","123","admin@gmail.com","123");
//            accountService.CreateRole("ADMIN");
//            accountService.CreateRole("CLIENT");

            //accountService.AddRoleToUser("admin","ADMIN");
            //accountService.AddRoleToUser("admin","CLIENT");
            //accountService.RemoveRoleFromUser("admin","CLIENT");
            //System.out.println(accountService.loadUserByUsername("admin").getEmail());
        };
    }
}
