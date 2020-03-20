package com.example.feign.clients;

import com.example.feign.models.Mananger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient("client")
public interface RestClient {

    @GetMapping("")
    public Iterable<?> getAllManangers();

}
