package com.example.workoutandnutritionservice.dto;

import com.example.workoutandnutritionservice.enumeration.Difficulty;
import com.example.workoutandnutritionservice.enumeration.PlanType;

import java.util.List;

public record WorkoutPlanDTO(
        String name,
        String description,
        PlanType planType,
        Difficulty difficulty,
        List<WorkoutDayDTO> days
) {
}
