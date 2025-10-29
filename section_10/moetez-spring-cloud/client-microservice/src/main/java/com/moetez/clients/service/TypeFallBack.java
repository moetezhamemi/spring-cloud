package com.moetez.clients.service;

import com.moetez.clients.dto.TypeDto;
import org.springframework.stereotype.Component;
@Component
public class TypeFallBack implements APIClient {
    @Override
    public TypeDto getTypeByDesc(String typeDesc) {
        return null;
    }
}
