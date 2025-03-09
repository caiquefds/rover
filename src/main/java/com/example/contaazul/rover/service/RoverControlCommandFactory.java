package com.example.contaazul.rover.service;

import com.example.contaazul.rover.error.exception.InvalidCommandException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoverControlCommandFactory {

    private final List<RoverCommand> roverCommandList;

    public RoverCommand getCommand(String subCommand) {
        return roverCommandList
                .stream()
                .filter(roverCommand -> roverCommand.getCommandType()
                        .getShortDescription()
                        .equals(subCommand))
                .findFirst()
                .orElseThrow(() -> {
                    String errorMessage = String.format("Does not exists command %s.", subCommand);
                    log.info(errorMessage);
                    return new InvalidCommandException(errorMessage);
                });
    }

    ;
}
