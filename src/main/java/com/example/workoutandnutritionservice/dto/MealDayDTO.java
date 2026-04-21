package com.example.workoutandnutritionservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record MealDayDTO(
        @JsonProperty("day") String day,
        @JsonProperty("meals") List<MealDTO> meals
) {}