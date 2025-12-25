package com.example.workout.controller;

import com.example.workout.dto.CreateExerciseRequest;
import com.example.workout.dto.CreateWorkoutRequest;
import com.example.workout.dto.WorkoutResponse;
import com.example.workout.model.Exercise;
import com.example.workout.model.Workout;
import com.example.workout.service.WorkoutService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.workout.service.ExerciseService;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;
    private final ExerciseService exerciseService;

    public WorkoutController(WorkoutService workoutService, ExerciseService exerciseService) {
        this.workoutService = workoutService;
        this.exerciseService = exerciseService;
    }

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{id}")
    public WorkoutResponse getWorkoutById(@PathVariable Long id) {
        return workoutService.getWorkoutById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
        public Workout createWorkout(@Valid @RequestBody CreateWorkoutRequest request) {
        return workoutService.createWorkout(request.name());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
    }

    @PostMapping("/{id}/exercises")
    @ResponseStatus(HttpStatus.CREATED)
    public Exercise addExercise(@Valid @PathVariable long id, @RequestBody CreateExerciseRequest request) {
        return exerciseService.addExerciseToWorkout(id, request.name(), request.sets(), request.reps());
    }
    @GetMapping("/{id}/exercises")
    public List<Exercise> getExercisesForWorkout(@PathVariable Long id) {
        return exerciseService.getExercisesForWorkout(id);
    }
}
