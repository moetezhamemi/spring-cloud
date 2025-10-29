package com.moetez.clients.service;

import com.moetez.clients.dto.APIResponseDto;
import com.moetez.clients.dto.ClientDto;

public interface ClientService {
    APIResponseDto getClientById(Long id);
}
