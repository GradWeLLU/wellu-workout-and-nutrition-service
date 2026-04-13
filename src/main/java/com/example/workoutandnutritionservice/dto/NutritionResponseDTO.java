package com.example.workoutandnutritionservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NutritionResponseDTO(
        String goal,
        @JsonProperty("meals_per_day") int mealsPerDay,
        @JsonProperty("nutrition_plan") NutritionPlanDTO nutritionPlan
) {}