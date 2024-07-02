package com.kadukitesesi.demo.controller;


import com.kadukitesesi.demo.model.UserDto;
import com.kadukitesesi.demo.service.ValidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class SenhaController {

    @Autowired
    ValidateService validateService;

    @PostMapping("/login")
    ResponseEntity<List<String>>seguro(@RequestBody UserDto userDto) {
        var exige = validateService.validaSenhaForte(userDto.password());
        if(exige.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().body(exige);
    }
}
