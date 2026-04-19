package com.example.workoutandnutritionservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public record UserWorkoutPlanDetailsDTO(
        UUID userID,
        String goal,
        int age,
        double weight,
        double height,
        double bmi,
        Integer sessionDuration,
        String preferredDifficultyLevel,
        List<String> preferredEquipment,
        String experienceLevel,
        List<String> injuries                // optional
) {
}
