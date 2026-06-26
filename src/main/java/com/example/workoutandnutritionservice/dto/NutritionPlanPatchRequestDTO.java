package com.example.workoutandnutritionservice.dto;

public record NutritionPlanPatchRequestDTO(
        String goal,
        Integer dailyCalories
) {
}
