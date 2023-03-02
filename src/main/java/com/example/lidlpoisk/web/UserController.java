package com.example.lidlpoisk.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController {



    @RequestMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
