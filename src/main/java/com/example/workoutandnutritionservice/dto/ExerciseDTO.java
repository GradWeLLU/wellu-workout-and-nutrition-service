package com.example.workoutandnutritionservice.dto;

import com.example.workoutandnutritionservice.enumeration.Difficulty;
import com.example.workoutandnutritionservice.enumeration.ExerciseType;
import com.example.workoutandnutritionservice.enumeration.MuscleGroup;

import java.util.Set;

public record ExerciseDTO(
        String name,
        String description,
        Set<MuscleGroup> muscleGroups,
        ExerciseType type,
        String sets,
        String reps,
        Difficulty difficulty,
        String videoURL,
        double restTime
) {
}
