package com.example.workoutandnutritionservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CombinedPlanRequestDTO(
        @JsonProperty("fitness_goal") String goal,
        int age,
        Double weight,
        Double height,
        Double bmi,
        String gender,

        // Workout-specific
        int days,
        @JsonProperty("session_duration") Integer sessionDuration,
        @JsonProperty("preferred_difficulty") String preferredDifficultyLevel,
        @JsonProperty("preferred_equipment") List<String> preferredEquipment,
        @JsonProperty("experience_level") String experienceLevel,
        List<String> injuries,
        List<String> allergies,
        List<String> medications,

        // Nutrition-specific
        @JsonProperty("activity_level") String activityLevel,
        String budget,
        String diet,
        @JsonProperty("meals_per_day") int mealsPerDay
) {}