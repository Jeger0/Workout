package com.example.workout.model;

import jakarta.persistence.*;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int sets;
    private int reps;

    private boolean completed = false;

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    protected Exercise() {
    }

    public Exercise(String name, int sets, int reps, Workout workout) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.workout = workout;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Workout getWorkout() {
        return workout;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
