package com.example.workout.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateExerciseRequest(

        @NotBlank(message = "Exercise name cannot be empty")
        String name,

        @Min(value = 1, message = "Sets must be at least 1")
        int sets,

        @Min(value = 1, message = "Reps must be at least 1")
        int reps
) {}
