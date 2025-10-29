package com.moetez.typemicroservice.restControllers;
import com.moetez.typemicroservice.config.Configuration;
import com.moetez.typemicroservice.dto.TypeDto;

import com.moetez.typemicroservice.entities.Type;
import com.moetez.typemicroservice.repos.TypeRepository;
import com.moetez.typemicroservice.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/api/types")

public class TypeController {
    @Autowired
    Configuration configuration;
    private TypeService typeService;

    @Value("${build.version}")
    private String buildVersion;
    @GetMapping("{description}")
    public ResponseEntity<TypeDto> getType(@PathVariable("description") String description) {
        return new ResponseEntity<TypeDto>(
                typeService.getTypeByDescription(description),HttpStatus.OK);

    }
   @Bean
    CommandLineRunner commandLineRunner(TypeRepository typeRepo) {
        return args -> {
            typeRepo.save(
                    Type.builder().typeName("normal")
                            .typeDescription("les normal")
                            .build()
            );
        };
    }
    @GetMapping("/version")
    public ResponseEntity<String> version()
    {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }
    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(configuration.getName()+" "+configuration.getEmail() );
    }

}
