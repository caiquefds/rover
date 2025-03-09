package com.example.contaazul.rover.service;

import com.example.contaazul.rover.enums.CommandType;
import com.example.contaazul.rover.enums.Direction;
import com.example.contaazul.rover.model.Position;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@NoArgsConstructor
public class RoverCommandTurnRight implements RoverCommand {

    @Override
    public CommandType getCommandType() {
        return CommandType.TURN_RIGHT;
    }

    @Override
    public Position execute(Integer x, Integer y, Direction direction) {
        direction = direction.right();
        Position position = new Position(x, y, direction, LocalDateTime.now());
        log.info("Moved to {}.", position);
        return position;
    }

}
