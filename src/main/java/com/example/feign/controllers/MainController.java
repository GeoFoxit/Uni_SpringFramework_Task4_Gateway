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

    @PostMapping("")
    public ResponseEntity<?> createMananger(@Valid @RequestBody Mananger mananger, @RequestParam("result") BindingResult result) {
        return restClient.createMananger(mananger, result);
    }

    @PatchMapping("/{mananger_id}")
    public ResponseEntity<?> patchManangerById(@PathVariable Integer mananger_id, @Valid @RequestBody Mananger mananger, @RequestParam("result") BindingResult result) {
        return restClient.patchManangerById(mananger_id, mananger, result);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllManangers() {
        return restClient.getAllManangers();
    }

    @GetMapping("/{mananger_id}")
    public ResponseEntity<?> getManangerById(@PathVariable Integer mananger_id) {
        return restClient.getManangerById(mananger_id);
    }

    @DeleteMapping("/{mananger_id}")
    public ResponseEntity<?> deleteMananger(@PathVariable Integer mananger_id) {
        return restClient.deleteMananger(mananger_id);
    }

}
