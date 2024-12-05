// AppConfig.java
package com.Project.MartinSwiftImpl;

import com.Project.MartinSwiftImpl.Controllers.PetController;
import com.Project.MartinSwiftImpl.Repositories.PetRepository;
import com.Project.MartinSwiftImpl.Services.PetService;
import com.Project.MartinSwiftImpl.Services.PetServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public PetService petService(PetRepository petRepository) {
        return new PetServiceImpl(petRepository);
    }

    @Bean
    public PetController petController(PetService petService) {
        return new PetController(petService);
    }
}
