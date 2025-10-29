package com.moetez.typemicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeDto {
    private Long id;
    private String typeName;
    private String typeDescription;
}
