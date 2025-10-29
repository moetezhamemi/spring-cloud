package com.moetez.clients.service;

import com.moetez.clients.dto.TypeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//@FeignClient(url = "http://localhost:7070", value = "TYPE")
//@FeignClient(name = "TYPE-MICROSERVICE")
@FeignClient(value = "TYPE-MICROSERVICE",fallback = TypeFallBack.class)
public interface APIClient {
    @GetMapping("api/types/{type-description}")
    TypeDto getTypeByDesc(@PathVariable("type-description")
                               String typeDescription
    );
}