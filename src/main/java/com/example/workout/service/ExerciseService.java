package com.example.workout.service;

import com.example.workout.model.Exercise;
import com.example.workout.model.Workout;

import com.example.workout.repository.ExerciseRepository;
import com.example.workout.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {
    private ExerciseRepository exerciseRepository;
    private WorkoutRepository workoutRepository;

    public ExerciseService(ExerciseRepository exerciseRepository, WorkoutRepository workoutRepository) {
        this.exerciseRepository = exerciseRepository;
        this.workoutRepository = workoutRepository;
    }
    public Exercise addExerciseToWorkout(long workoutId, String name, int sets, int reps) {
        Workout workout = workoutRepository.findById(workoutId).orElseThrow(() -> new RuntimeException("Workout not found"));

        Exercise exercise = new Exercise(name, sets, reps, workout);

        return exerciseRepository.save(exercise);
    }

    public List<Exercise> getExercisesForWorkout(Long workoutId) {
        return exerciseRepository.findByWorkoutId(workoutId);
    }
}
