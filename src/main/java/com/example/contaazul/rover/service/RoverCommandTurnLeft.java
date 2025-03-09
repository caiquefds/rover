package com.example.contaazul.rover.service;

import com.example.contaazul.rover.enums.CommandType;
import com.example.contaazul.rover.enums.Direction;
import com.example.contaazul.rover.model.Position;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@NoArgsConstructor
public class RoverCommandTurnLeft implements RoverCommand {

    @Override
    public CommandType getCommandType() {
        return CommandType.TURN_LEFT;
    }

    @Override
    public Position execute(Integer x, Integer y, Direction direction) {
        direction = direction.left();
        return new Position(x,y,direction, LocalDateTime.now());
    }

}
