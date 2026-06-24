package com.example.workoutandnutritionservice.dto;

import java.util.List;
import java.util.UUID;

public record UserNutritionPlanDetailsDTO(
        UUID userID,
        String goal,
        Double weight,
        Double height,
        Integer age,
        String gender,
        String activityLevel,
        String budget,
        String diet,
        int mealsPerDay,
        List<String> medications,
        List<String> allergies
) {
}
