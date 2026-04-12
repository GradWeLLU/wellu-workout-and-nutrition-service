package com.example.workoutandnutritionservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AIResponseDTO(
        String goal,
        int days,
        @JsonProperty("workout_plan")
        WorkoutPlanDTO workoutPlan
) {}