package com.example.workoutandnutritionservice.dto;

import com.example.workoutandnutritionservice.enumeration.Difficulty;
import com.example.workoutandnutritionservice.enumeration.PlanType;

public record WorkoutPlanPatchRequestDTO(
        String weeklySplit,
         PlanType planType,
         Difficulty difficulty
) {
}
