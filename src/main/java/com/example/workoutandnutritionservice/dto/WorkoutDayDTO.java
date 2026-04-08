package com.example.workoutandnutritionservice.dto;

import java.util.List;

public record WorkoutDayDTO(
        int dayNumber,
        String day,
        String focus,
        String description,
        List<ExerciseDTO> exercises
) {
}
