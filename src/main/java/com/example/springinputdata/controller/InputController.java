package com.example.springinputdata.controller;

import com.example.springinputdata.model.InputData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@Slf4j
public class InputController {

    @PostMapping("/data")
    public ResponseEntity<String> getUserData(@Valid @RequestBody InputData data) {
        //log.info("User provided data {}", data);
        return ResponseEntity.ok()
                .body("Yippee");
    }
}
