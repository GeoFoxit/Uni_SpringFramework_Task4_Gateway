package com.example.feign.controllers;

import feign.FeignException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestControllerAdvice
public class FeignExceptionHandler {

    @ExceptionHandler(FeignException.BadRequest.class)
    public Map<String, Object> handleFeignStatusException(FeignException e, HttpServletResponse response) throws JSONException {
        response.setStatus(e.status());
        return new JSONObject(e.contentUTF8()).toMap();
    }
}