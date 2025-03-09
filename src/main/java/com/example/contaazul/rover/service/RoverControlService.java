package com.example.contaazul.rover.service;

import com.example.contaazul.rover.enums.Direction;
import com.example.contaazul.rover.model.Position;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoverControlService {

    private final Integer axisX = 0;
    private final Integer axisY = 0;
    private final Direction direction = Direction.NORTH;
    private final RoverControlCommandFactory roverControlCommandFactory;

    public String execute(String commands) {
        try {
            log.info("Executing the commands {}...", commands);
            Stream<String> subCommands = Arrays.stream(commands.split(""));
            List<RoverCommand> roverSubCommands = subCommands
                    .map(roverControlCommandFactory::getCommand)
                    .toList();

            Integer temporaryAxisX = axisX;
            Integer temporaryAxisY = axisY;
            Direction temporaryDirection = direction;

            List<Position> positions = new ArrayList<>();
            for (RoverCommand roverCommand : roverSubCommands) {
                Position position = roverCommand.execute(temporaryAxisX, temporaryAxisY, temporaryDirection);
                temporaryAxisX = position.axisX();
                temporaryAxisY = position.axisY();
                temporaryDirection = position.direction();
                positions.add(position);
            }

            String lastPosition = positions.stream()
                    .max(Comparator.comparing(Position::movedAt))
                    .map(Position::toString)
                    .get();

            log.info("Rover moved at position {}.", lastPosition);
            return lastPosition;
        } catch (Exception e) {
            log.info("Failed to move rover. Message: {}", e.getMessage(), e);
            throw e;
        }
    }

}
