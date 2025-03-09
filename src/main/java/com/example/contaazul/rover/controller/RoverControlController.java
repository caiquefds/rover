package com.example.contaazul.rover.controller;

import com.example.contaazul.rover.controller.validation.ValidCommand;
import com.example.contaazul.rover.service.RoverControlService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/mars")
public class RoverControlController {

    private final RoverControlService roverControlService;

    @PostMapping("/{command}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    private String moveRover(@PathVariable @Valid @ValidCommand String command) {
        return roverControlService.execute(command);
    }
}
