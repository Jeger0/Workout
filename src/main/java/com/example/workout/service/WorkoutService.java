package com.example.workout.service;

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

    public Workout getWorkoutById(Long id) {
        return workoutRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Workout not found with id: " + id));
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}