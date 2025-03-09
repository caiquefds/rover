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
class RoverCommandTurnRightTest {

    @InjectMocks
    private RoverCommandTurnRight roverCommandTurnRight;

    @Test
    @DisplayName("Should return TURN_RIGHT command type.")
    void should_return_command_type() {

        // Act
        CommandType commandType = roverCommandTurnRight.getCommandType();

        // Assert
        assertEquals(CommandType.TURN_RIGHT, commandType);

    }

    @Test
    @DisplayName("Should execute command to turn to right.")
    void should_execute_command() {

        // Act
        Position position = roverCommandTurnRight.execute(1, 1, Direction.NORTH);

        // Assert
        assertEquals("(1, 1, E)", position.toString());

    }

}