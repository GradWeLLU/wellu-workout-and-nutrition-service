package com.example.workoutandnutritionservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record WorkoutRequestDTO(
        String goal,                        // e.g., "muscle gain", "fat loss"
        int days,                            // number of workout days
        int age,
        double weight,
        double height,
        double bmi,
        @JsonProperty("session_duration") Integer sessionDuration,
        @JsonProperty("preferred_difficulty_level") String preferredDifficultyLevel,
        @JsonProperty("preferred_equipment") List<String> preferredEquipment,
        @JsonProperty("experience_level") String experienceLevel,
        List<String> injuries                // optional
) { }