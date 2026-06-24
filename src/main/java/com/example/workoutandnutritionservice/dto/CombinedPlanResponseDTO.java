package com.example.workoutandnutritionservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CombinedPlanResponseDTO(
        String goal,
        @JsonProperty("workout_plan") AIResponseDTO workoutPlan,
        @JsonProperty("nutrition_plan") NutritionResponseDTO nutritionPlan
) {}
