package com.example.workoutandnutritionservice.dto;

import com.example.workoutandnutritionservice.enumeration.Difficulty;
import com.example.workoutandnutritionservice.enumeration.ExerciseType;
import com.example.workoutandnutritionservice.enumeration.MuscleGroup;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public record ExerciseDTO(
        String name,
        @JsonProperty("muscle_group")
        Set<MuscleGroup> muscleGroups,
        @JsonProperty("exercise_type")
        ExerciseType type,
        int sets,
        String reps,
        Difficulty difficulty,
        @JsonProperty("video_url")
        String videoURL,
        @JsonProperty("rest_time")
        double restTime
) {
}
