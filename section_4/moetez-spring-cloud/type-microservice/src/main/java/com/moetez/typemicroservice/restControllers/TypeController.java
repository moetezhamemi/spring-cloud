package com.moetez.typemicroservice.restControllers;
import com.moetez.typemicroservice.dto.TypeDto;

import com.moetez.typemicroservice.entities.Type;
import com.moetez.typemicroservice.repos.TypeRepository;
import com.moetez.typemicroservice.service.TypeService;
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
@AllArgsConstructor

public class TypeController {
    private TypeService typeService;

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

}
