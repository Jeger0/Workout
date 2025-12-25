package com.example.workout.service;

import com.example.workout.dto.ExerciseResponse;
import com.example.workout.dto.WorkoutResponse;
import com.example.workout.model.Workout;
import com.example.workout.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import com.example.workout.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout createWorkout(String name) {
        Workout workout = new Workout(name);
        return workoutRepository.save(workout);
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public WorkoutResponse getWorkoutById(Long id) {

        Workout workout = workoutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Workout not found with id: " + id));

        List<ExerciseResponse> exercises = workout.getExercises().stream()
                .map(e -> new ExerciseResponse(
                        e.getId(),
                        e.getName(),
                        e.getSets(),
                        e.getReps(),
                        e.isCompleted()
                ))
                .toList();

        return new WorkoutResponse(
                workout.getId(),
                workout.getName(),
                workout.getCreatedAt(),
                exercises
        );
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}