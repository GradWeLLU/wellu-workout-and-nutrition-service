package com.example.workoutandnutritionservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NutritionRequestDTO(
        String goal,
        Double weight,
        Double height,
        int age,
        String gender,
        @JsonProperty("activity_level")
        String activityLevel,
        String budget,
        String diet,
        @JsonProperty("meals_per_day")
        int mealsPerDay
) {
}
