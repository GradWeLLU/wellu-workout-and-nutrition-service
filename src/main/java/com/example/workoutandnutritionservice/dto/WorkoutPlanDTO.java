package com.example.workoutandnutritionservice.dto;

import com.example.workoutandnutritionservice.enumeration.Difficulty;
import com.example.workoutandnutritionservice.enumeration.PlanType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record WorkoutPlanDTO(
        @JsonProperty("weekly_split")
        String weeklySplit,
        @JsonProperty("plan_type")
        PlanType planType,
        Difficulty difficulty,
        List<WorkoutDayDTO> days
) {
}
