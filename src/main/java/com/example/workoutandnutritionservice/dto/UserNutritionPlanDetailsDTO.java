package com.example.workoutandnutritionservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record UserNutritionPlanDetailsDTO(
        UUID userID,
        String goal,
        Double weight,
        Double height,
        Integer age,
        String gender,
        @JsonProperty("activity_level")
        String activityLevel,
        String budget,
        String diet,
        @JsonProperty("meals_per_day")
        int mealsPerDay
) {
}
