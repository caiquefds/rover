package com.example.contaazul.rover.service;

import com.example.contaazul.rover.error.exception.InvalidPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class RoverControlServiceTest {

    @InjectMocks
    private RoverControlService roverControlService;

    @Mock
    private RoverControlCommandFactory roverControlCommandFactory;

    @Test
    @DisplayName("Should execute valid command.")
    void should_execute_valid_command() {

        // Arrange
        String command = "R";
        String position = "(0, 0, E)";
        doReturn(new RoverCommandTurnRight()).when(roverControlCommandFactory).getCommand(anyString());

        // Act
        String result = roverControlService.execute(command);

        // Assert
        assertEquals(position, result);

    }

    @Test
    @DisplayName("Should not execute invalid position command.")
    void should_not_execute_invalid_command() {

        // Arrange
        String invalidCommand = "MMMMMMMMMMMM";
        doReturn(new RoverCommandMoveForward()).when(roverControlCommandFactory).getCommand(anyString());

        // Act
        assertThrows(InvalidPositionException.class, () -> roverControlService.execute(invalidCommand));
    }


}