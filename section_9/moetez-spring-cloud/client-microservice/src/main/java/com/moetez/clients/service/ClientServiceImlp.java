package com.moetez.clients.service;
import com.moetez.clients.dto.APIResponseDto;
import com.moetez.clients.dto.ClientDto;
import com.moetez.clients.dto.TypeDto;
import com.moetez.clients.entities.Client;
import com.moetez.clients.repos.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@AllArgsConstructor
@Service
public class ClientServiceImlp implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
     //private WebClient webClient;
     private APIClient apiClient;

    @Override
    public APIResponseDto getClientById(Long id){
        Client client = clientRepository.findById(id).get();

        TypeDto typeDto = apiClient.getTypeByDesc(client.getTypeDesc());
        String tname;
                /*.uri("http://localhost:7070/api/types/" + client.getTypeDesc())
                        .retrieve()
                        .bodyToMono(TypeDto.class)
                        .block();*/

        if(typeDto == null)
        {
            tname  = "NOT AVAILABLE";
        }
        else
        {tname = typeDto.getTypeName();   }
        ClientDto clientDto = new ClientDto(
                        client.getId(),
                        client.getName(),
                        client.getAdresse(),
                        client.getTypeDesc(),
                        tname);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setClientDto(clientDto);
        apiResponseDto.setTypeDto(typeDto);
        return  apiResponseDto;


    }

}
