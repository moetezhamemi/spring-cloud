package com.moetez.clients.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class APIResponseDto {
    private ClientDto clientDto;
    private TypeDto typeDto;
}
