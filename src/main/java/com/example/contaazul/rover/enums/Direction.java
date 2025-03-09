package com.example.contaazul.rover.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Direction {
    
    NORTH('N') {
        @Override public Direction left() { return WEST; }
        @Override public Direction right() { return EAST; }
    },
    EAST('E') {
        @Override public Direction left() { return NORTH; }
        @Override public Direction right() { return SOUTH; }
    },
    SOUTH('S') {
        @Override public Direction left() { return EAST; }
        @Override public Direction right() { return WEST; }
    },
    WEST('W') {
        @Override public Direction left() { return SOUTH; }
        @Override public Direction right() { return NORTH; }
    };

    private final char shortName;

    public abstract Direction left();
    public abstract Direction right();
}