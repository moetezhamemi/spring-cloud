package com.moetez.clients.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClientDto {
    private Long id;
    private String Name;
    private String Adresse;
    private String TypeDesc;
    private String TypeName;
}
