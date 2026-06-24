package com.example.workoutandnutritionservice.mapper;

import com.example.workoutandnutritionservice.dto.CombinedPlanRequestDTO;
import com.example.workoutandnutritionservice.dto.UserNutritionPlanDetailsDTO;
import com.example.workoutandnutritionservice.dto.UserWorkoutPlanDetailsDTO;

public class CombinedPlanMapper {

    private CombinedPlanMapper() {}

    /**
     * Merges workout and nutrition user details into a single AI request.
     * Workout fields take priority for shared fields (goal, age, weight, height, bmi).
     * Gender comes from the nutrition details since it's not present in workout details.
     */
    public static CombinedPlanRequestDTO toRequest(
            UserWorkoutPlanDetailsDTO workout,
            UserNutritionPlanDetailsDTO nutrition
    ) {
        return new CombinedPlanRequestDTO(
                workout.goal(),
                workout.age(),
                workout.weight(),
                workout.height(),
                workout.bmi(),
                nutrition.gender(),

                workout.injuries() != null && !workout.injuries().isEmpty() ? 5 : 3,
                workout.sessionDuration(),


                workout.preferredDifficultyLevel(),
                workout.preferredEquipment(),
                workout.experienceLevel(),
                workout.injuries(),

                // NEW
                nutrition.allergies(),
                nutrition.medications(),

                nutrition.activityLevel(),
                nutrition.budget(),
                nutrition.diet(),
                nutrition.mealsPerDay()
        );
    }
}