package com.example.workoutandnutritionservice.mapper;

import com.example.workoutandnutritionservice.dto.NutritionRequestDTO;
import com.example.workoutandnutritionservice.dto.UserNutritionPlanDetailsDTO;

public class NutritionMapper {

    public static NutritionRequestDTO toNutritionRequest(UserNutritionPlanDetailsDTO user) {
        return new NutritionRequestDTO(
                user.goal(),
                user.weight(),
                user.height(),
                user.age(),
                user.gender(),
                user.activityLevel(),
                user.budget(),
                user.diet(),
                user.mealsPerDay()
        );
    }
}
