package com.example.workoutandnutritionservice.mapper;

import com.example.workoutandnutritionservice.dto.UserWorkoutPlanDetailsDTO;
import com.example.workoutandnutritionservice.dto.WorkoutRequestDTO;

import java.util.Locale;

public class WorkoutMapper {

    public static WorkoutRequestDTO toWorkoutRequest(
            UserWorkoutPlanDetailsDTO user
    ) {
        return new WorkoutRequestDTO(
                user.goal(),
                5,
                user.age(),
                user.weight(),
                user.height(),
                user.bmi(),
                user.sessionDuration(),
                user.preferredDifficultyLevel().toUpperCase(),
                user.preferredEquipment(),
                user.experienceLevel(),
                user.injuries()
        );
    }
}