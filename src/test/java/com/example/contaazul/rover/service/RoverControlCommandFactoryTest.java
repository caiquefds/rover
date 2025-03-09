package com.example.contaazul.rover.service;

import com.example.contaazul.rover.error.exception.InvalidCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class RoverControlCommandFactoryTest {

    @InjectMocks
    private RoverControlCommandFactory roverControlCommandFactory = new RoverControlCommandFactory(List.of(new RoverCommandMoveForward(), new RoverCommandTurnLeft(), new RoverCommandTurnRight()));

    @ParameterizedTest
    @ValueSource(strings = {"M", "L", "R"})
    @DisplayName("Should return rover control implementation when give valid command.")
    void should_return_rover_control_implementation_when_give_invalid_command(String command) {

        // Act
        RoverCommand roverCommand = roverControlCommandFactory.getCommand(command);

        // Assert
        assertEquals(command, roverCommand.getCommandType().getShortDescription());

    }

    @ParameterizedTest
    @ValueSource(strings = {"F", "#", "3"})
    @DisplayName("Should not return rover control implementation when give invalid command.")
    void should_not_return_rover_control_implementation_when_give_invalid_command(String command) {

        // Act
        assertThrows(InvalidCommandException.class, () -> roverControlCommandFactory.getCommand(command));

    }

}