package com.example.contaazul.rover.service;

import com.example.contaazul.rover.enums.CommandType;
import com.example.contaazul.rover.enums.Direction;
import com.example.contaazul.rover.error.exception.InvalidPositionException;
import com.example.contaazul.rover.model.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class RoverCommandMoveForwardTest {

    @InjectMocks
    private RoverCommandMoveForward roverCommandMoveForward;

    @Test
    @DisplayName("Should return MOVE_FORWARD command type.")
    void should_return_command_type() {

        // Act
        CommandType commandType = roverCommandMoveForward.getCommandType();

        // Assert
        assertEquals(CommandType.MOVE_FORWARD, commandType);

    }

    @ParameterizedTest
    @EnumSource(value = Direction.class)
    @DisplayName("Should execute command to turn to move forward.")
    void should_execute_command(Direction direction) {

        // Act
        Position position = roverCommandMoveForward.execute(1, 1, direction);

        // Assert
        assertNotNull(position.toString());

    }

    @ParameterizedTest
    @MethodSource("invalidParams")
    @DisplayName("Should not execute command to move forward when give invalid axis-x or axis-y.")
    void should_not_execute_command_when_give_invalid_params(Integer axisX, Integer axisY) {

        // Act
        assertThrows(InvalidPositionException.class, () -> roverCommandMoveForward.execute(axisX, axisY, Direction.NORTH));

    }

    static Stream<Arguments> invalidParams() {
        return Stream.of(Arguments.of(10, 0), Arguments.of(0, 10));
    }


}