package com.example.contaazul.rover.model;

import com.example.contaazul.rover.enums.Direction;

import java.time.LocalDateTime;

public record Position(Integer axisX, Integer axisY, Direction direction, LocalDateTime movedAt) {
    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", axisX, axisY, direction.getShortName());
    }
}
