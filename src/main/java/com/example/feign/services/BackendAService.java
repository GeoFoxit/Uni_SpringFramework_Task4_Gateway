package com.example.feign.services;

import com.example.feign.clients.RestClient;
import com.example.feign.models.Mananger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BackendAService {
    private static final String BACKEND_A = "backendA";

    @Autowired
    private RestClient restClient;

    @CircuitBreaker(name = BACKEND_A, fallbackMethod = "fallback")
    public String getAllManangers() {
        return restClient.getAllManangers();
    }

    @CircuitBreaker(name = BACKEND_A, fallbackMethod = "fallback")
    public String getManangerById(Integer id) {
        return restClient.getManangerById(id);
    }

    @Retry(name = BACKEND_A)
    public String createMananger(Mananger mananger) {
        return restClient.createMananger(mananger);
    }

    @Retry(name = BACKEND_A)
    public String deleteMananger(Integer id) { return restClient.deleteMananger(id); }

    @Retry(name = BACKEND_A)
    public String patchManangerById(Integer id, Mananger mananger) {
        return restClient.patchManangerById(id, mananger);
    }

    public String fallback(Throwable e) {
        return "";
    }

    public Map<String, String> mapFallback(Throwable e) {
        return new HashMap<String, String>();
    }
}
