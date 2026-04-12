package com.example.workoutandnutritionservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record NutritionPlanDTO (
        @JsonProperty("goal") String goal,
        @JsonProperty("daily_calories") int dailyCalories,
        @JsonProperty("days") List<MealDayDTO> days
) {}