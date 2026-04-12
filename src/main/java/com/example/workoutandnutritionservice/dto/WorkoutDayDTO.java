package com.example.workoutandnutritionservice.dto;

import java.util.List;

public record WorkoutDayDTO(
        String day,
        String focus,
        List<ExerciseDTO> exercises
) {
}
