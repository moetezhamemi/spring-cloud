package com.moetez.typemicroservice.service;

import com.moetez.typemicroservice.dto.TypeDto;
import org.springframework.stereotype.Service;


public interface TypeService {
    TypeDto getTypeByDescription(String description );

}
