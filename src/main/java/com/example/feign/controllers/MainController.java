package com.example.feign.controllers;

import com.example.feign.clients.RestClient;
import com.example.feign.models.Mananger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MainController {

    @Autowired
    RestClient restClient;

    @GetMapping("")
    public Iterable<?> getAllManangers() {
        return restClient.getAllManangers();
    }
}
