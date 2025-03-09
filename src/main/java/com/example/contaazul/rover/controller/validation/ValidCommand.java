package com.example.contaazul.rover.controller.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CommandValidator.class)
public @interface ValidCommand {
    String message() default "Invalid command value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
