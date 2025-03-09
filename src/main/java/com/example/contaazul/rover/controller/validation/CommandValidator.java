package com.example.contaazul.rover.controller.validation;

import com.example.contaazul.rover.enums.CommandType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class CommandValidator implements ConstraintValidator<ValidCommand, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null || value.isEmpty() || " ".equals(value)) {
            return false;
        }

        List<String> commands = Arrays.stream(CommandType.values())
                .map(CommandType::getShortDescription)
                .toList();


        boolean containsInvalidValue = Arrays.stream(value.split(""))
                .map(commands::contains)
                .toList()
                .contains(false);

        return !containsInvalidValue;
    }
}
