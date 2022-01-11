package ru.mrvl.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.mrvl.model.Characters;
import ru.mrvl.model.Comics;
import ru.mrvl.repository.CharactersRepository;
import ru.mrvl.repository.ComicsRepository;

@Configuration
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);


    @Bean
    CommandLineRunner initComics(ComicsRepository comicsRepository) {
        return args -> {
            log.info("Preloading " + comicsRepository
                    .save(new Comics(1L, "first")));
            log.info("Preloading " + comicsRepository
                    .save(new Comics(2L, "second")));
        };
    }

    @Bean
    CommandLineRunner initCharacters(CharactersRepository charactersRepository){
        return args -> {
            log.info("Preloading " + charactersRepository
                    .save((new Characters(1L,
                            "MyFirstCharacter",
                            "true",
                            new Comics(1L,"first")))));
        };
    }
}
