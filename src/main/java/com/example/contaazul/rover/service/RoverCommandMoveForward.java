package com.example.contaazul.rover.service;

import com.example.contaazul.rover.enums.Direction;
import com.example.contaazul.rover.enums.CommandType;
import com.example.contaazul.rover.error.exception.InvalidPositionException;
import com.example.contaazul.rover.model.Position;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@NoArgsConstructor
public class RoverCommandMoveForward implements RoverCommand {

    @Override
    public CommandType getCommandType() {
        return CommandType.MOVE_FORWARD;
    }

    @Override
    public Position execute(Integer x, Integer y, Direction direction) {

        Integer newX = x;
        Integer newY = y;

        switch (direction) {
            case NORTH -> newY++;
            case EAST -> newX++;
            case SOUTH -> newY--;
            case WEST -> newX--;
        }

        if (newX < 0 || newX > 4 || newY < 0 || newY > 4) {
            String errorMessage = String.format("The position axis-X %s, axis-Y %s and direction %s are invalid!", newX, newY, direction);
            throw new InvalidPositionException(errorMessage);
        }

        x = newX;
        y = newY;

        return new Position(x,y,direction, LocalDateTime.now());
    }
}
