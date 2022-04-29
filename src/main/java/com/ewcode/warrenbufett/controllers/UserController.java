package com.ewcode.warrenbufett.controllers;

import com.ewcode.warrenbufett.config.rabbitmq.RabbitMQService;
import com.ewcode.warrenbufett.dtos.user.UserSaveDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(value = "/user")
class UserController {
    private static final String QUEUE_USER_SAVE = "/queue/user/save";

    RabbitMQService rabbit;

    public UserController(RabbitMQService rabbit) {
        this.rabbit = rabbit;
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> insertOrUpdate(@Valid @RequestBody UserSaveDto userToSave, Errors errors) throws JsonProcessingException {
        if(errors.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }


        rabbit.send(QUEUE_USER_SAVE, userToSave.toJson());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/process")
    public void process(@RequestBody UserSaveDto userToSave) {
        throw new UnsupportedOperationException();

    }

    @GetMapping("")
    public String hello() {
        return "Hello World";
    }

}
