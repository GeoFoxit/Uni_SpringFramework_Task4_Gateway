package com.example.feign.clients;

import com.example.feign.models.Mananger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@FeignClient("eurekaclientmicroservice")
public interface RestClient {

    @PostMapping("")
    public ResponseEntity<?> createMananger(@Valid @RequestBody Mananger mananger, @RequestParam("result") BindingResult result);

    @PatchMapping("/{mananger_id}")
    public ResponseEntity<?> patchManangerById(@PathVariable Integer mananger_id, @Valid @RequestBody Mananger mananger, @RequestParam("result") BindingResult result);

    @GetMapping("")
    public Iterable<?> getAllManangers();

    @GetMapping("/{mananger_id}")
    public ResponseEntity<?> getManangerById(@PathVariable Integer mananger_id);

    @DeleteMapping("/{mananger_id}")
    public ResponseEntity<?> deleteMananger(@PathVariable Integer mananger_id);

}
