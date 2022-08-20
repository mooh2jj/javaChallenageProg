package com.example.javachallengeprog.controller;

import com.example.javachallengeprog.dto.Stduent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("/post")
    public Stduent posttest(@RequestBody Stduent requestDto) {

        System.out.println("posttest == start!!!==");

        return requestDto;

    }

}
