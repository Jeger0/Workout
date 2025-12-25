package com.example.workout.controller;

import com.example.workout.dto.ExerciseResponse;
import com.example.workout.dto.UpdateExerciseRequest;
import com.example.workout.model.Exercise;
import com.example.workout.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PutMapping("/{id}")
    public ExerciseResponse updateExercise(
            @PathVariable Long id,
            @RequestBody UpdateExerciseRequest request
    ) {
        return exerciseService.updateExercise(id, request.completed());
    }
}
