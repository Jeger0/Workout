package com.example.workout.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateWorkoutRequest(

        @NotBlank(message = "Workout name cannot be empty")
        @Size(min = 2, max = 50)
        String name
) {}
