package com.example.workout.dto;

import java.time.LocalDateTime;
import java.util.List;

public record WorkoutResponse(
        Long id,
        String name,
        LocalDateTime createdAt,
        List<ExerciseResponse> exercises
) {}
