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
        try {
            return restClient.createMananger(mananger, result);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{mananger_id}")
    public ResponseEntity<?> patchManangerById(@PathVariable Integer mananger_id, @Valid @RequestBody Mananger mananger, @RequestParam("result") BindingResult result) {
        try {
            return restClient.patchManangerById(mananger_id, mananger, result);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAllManangers() {
        return restClient.getAllManangers();
    }

    @GetMapping("/{mananger_id}")
    public ResponseEntity<?> getManangerById(@PathVariable Integer mananger_id) {
        try {
            return restClient.getManangerById(mananger_id);
        } catch (Exception e) {
            return new ResponseEntity<String>("Entity is not found, check the ID",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{mananger_id}")
    public ResponseEntity<?> deleteMananger(@PathVariable Integer mananger_id) {
        try {
            return restClient.deleteMananger(mananger_id);
        } catch (Exception e) {
            return new ResponseEntity<String>("Entity is not found, check the ID",HttpStatus.BAD_REQUEST);
        }
    }

}
