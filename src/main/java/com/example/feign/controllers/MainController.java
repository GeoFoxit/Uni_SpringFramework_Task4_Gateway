package com.example.feign.controllers;

import com.example.feign.clients.RestClient;
import com.example.feign.models.Mananger;
import com.example.feign.services.BackendAService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MainController {

    @Autowired
    BackendAService restClient;

    @Autowired
    Gson gson;

    @PostMapping("")
    public ResponseEntity<String> createMananger(@Valid @RequestBody Mananger mananger) {
        return new ResponseEntity<String>(restClient.createMananger(mananger), HttpStatus.OK);
    }

    @PatchMapping("/{mananger_id}")
    public ResponseEntity<String> patchManangerById(@PathVariable Integer mananger_id, @Valid @RequestBody Mananger mananger) {
        return new ResponseEntity<String>(restClient.patchManangerById(mananger_id, mananger),HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<String> getAllManangers() {
        return new ResponseEntity<String>(restClient.getAllManangers(),HttpStatus.OK);
    }

    @GetMapping("/{mananger_id}")
    public ResponseEntity<String> getManangerById(@PathVariable Integer mananger_id) {
        return new ResponseEntity<String>(restClient.getManangerById(mananger_id), HttpStatus.OK);
    }

    @DeleteMapping("/{mananger_id}")
    public ResponseEntity<String> deleteMananger(@PathVariable Integer mananger_id) {
        return new ResponseEntity<String>(restClient.deleteMananger(mananger_id),HttpStatus.OK);
    }

}
