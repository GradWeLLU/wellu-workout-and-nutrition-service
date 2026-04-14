package com.example.workoutandnutritionservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record MealDTO(
        @JsonProperty("name") String name,
        @JsonProperty("calories") int calories,
        @JsonProperty("protein") int protein,
        @JsonProperty("carbs") int carbs,
        @JsonProperty("fats") int fats,
        @JsonProperty("ingredients") List<String> ingredients
) {}