package com.example.contaazul.rover.service;

import com.example.contaazul.rover.enums.CommandType;
import com.example.contaazul.rover.enums.Direction;
import com.example.contaazul.rover.model.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class RoverCommandTurnLeftTest {

    @InjectMocks
    private RoverCommandTurnLeft roverCommandTurnLeft;

    @Test
    @DisplayName("Should return TURN_LEFT command type.")
    void should_return_command_type() {

        // Act
        CommandType commandType = roverCommandTurnLeft.getCommandType();

        // Assert
        assertEquals(CommandType.TURN_LEFT, commandType);

    }

    @Test
    @DisplayName("Should execute command to turn to left.")
    void should_execute_command() {

        // Act
        Position position = roverCommandTurnLeft.execute(1, 1, Direction.NORTH);

        // Assert
        assertEquals("(1, 1, W)", position.toString());

    }

}