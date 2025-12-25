package com.example.workout.dto;

public record ExerciseResponse(
        Long id,
        String name,
        int sets,
        int reps,
        boolean completed
) {}
