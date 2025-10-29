package com.moetez.clients.restControllers;

import com.moetez.clients.config.Configuration;
import com.moetez.clients.dto.APIResponseDto;
import com.moetez.clients.dto.ClientDto;
import com.moetez.clients.entities.Client;
import com.moetez.clients.repos.ClientRepository;
import com.moetez.clients.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;
    @Autowired
    Configuration configuration;

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getClientById(@PathVariable("id") Long id) {
        return new ResponseEntity<APIResponseDto>(clientService.getClientById(id), HttpStatus.OK);
    }
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(
                    Client.builder()
                            .Name("moetez hamemi")
                            .Adresse("tunis")
                            .TypeDesc("les normal")
                            .build());
        };
    }
    @GetMapping("/author")
    public ResponseEntity<String> retrieveAuthorInfo() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(configuration.getName()+" "+configuration.getEmail() );
    }
}
