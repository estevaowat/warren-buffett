package com.ewcode.warrenbufett.controllers;

import com.ewcode.warrenbufett.dtos.user.UserSaveDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
@RequestMapping(value = "/user")
class UserController {
    
    @GetMapping(value = "")
    public List<UserSaveDto> listUsers() {
        List<UserSaveDto> users = new ArrayList<>();

        for(int i = 0; i <= 1000; i++) {
            UserSaveDto newUser = new UserSaveDto("name" + i, "email@" + i + ".com");
            users.add(newUser);
        }

        return users;
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> insertOrUpdate(@Valid @RequestBody UserSaveDto userToSave, Errors errors) {
        if(errors.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
