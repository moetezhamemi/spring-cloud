package com.moetez.typemicroservice.service;

import com.moetez.typemicroservice.dto.TypeDto;
import com.moetez.typemicroservice.entities.Type;
import com.moetez.typemicroservice.repos.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    TypeRepository TypeRepo;

    @Override
    public TypeDto getTypeByDescription(String description) {
        Type type = TypeRepo.findByTypeDescription(description);
        TypeDto dto = new TypeDto(
                type.getId(),
                type.getTypeName(),
                type.getTypeDescription()

        );
        return dto;
    }
}
