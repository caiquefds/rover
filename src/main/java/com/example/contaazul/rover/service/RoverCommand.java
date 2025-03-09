package com.example.contaazul.rover.service;

import com.example.contaazul.rover.enums.Direction;
import com.example.contaazul.rover.enums.CommandType;
import com.example.contaazul.rover.model.Position;

public interface RoverCommand {
    CommandType getCommandType();
    Position execute(Integer x, Integer y, Direction direction);
}
