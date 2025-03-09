package com.example.contaazul.rover.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum CommandType {

    MOVE_FORWARD("M"),
    TURN_LEFT("L"),
    TURN_RIGHT("R");

    private final String shortDescription;

    public static Optional<CommandType> fromShortDescription(String shortDescription){
       return Stream.of(values())
               .filter(commandType -> commandType.getShortDescription().equals(shortDescription))
               .findFirst();
    }
}
