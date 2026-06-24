package com.example.workoutandnutritionservice.service;

import com.example.workoutandnutritionservice.client.AIClient;
import com.example.workoutandnutritionservice.client.UserClient;
import com.example.workoutandnutritionservice.dto.*;
import com.example.workoutandnutritionservice.entity.NutritionPlan;
import com.example.workoutandnutritionservice.entity.WorkoutPlan;
import com.example.workoutandnutritionservice.enumeration.PlanStatus;
import com.example.workoutandnutritionservice.mapper.CombinedPlanMapper;
import com.example.workoutandnutritionservice.mapper.NutritionPlanMapper;
import com.example.workoutandnutritionservice.mapper.WorkoutPlanMapper;
import com.example.workoutandnutritionservice.repository.NutritionPlanRepository;
import com.example.workoutandnutritionservice.repository.WorkoutPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlanGenerationService {

    private final UserClient userClient;
    private final AIClient aiClient;
    private final WorkoutPlanMapper workoutPlanMapper;
    private final NutritionPlanMapper nutritionPlanMapper;
    private final WorkoutPlanRepository workoutPlanRepository;
    private final NutritionPlanRepository nutritionPlanRepository;

    @Transactional
    public ResponseEntity<CombinedPlanResponseDTO> generatePlan(String jwtToken) {
        // 1. Fetch user context from user management service
        UserWorkoutPlanDetailsDTO workoutDetails = userClient.getWorkoutDetails(jwtToken);
        UserNutritionPlanDetailsDTO nutritionDetails = userClient.getNutritionDetails(jwtToken);

        UUID userId = workoutDetails.userID();

        // 2. Merge into unified AI request
        CombinedPlanRequestDTO request = CombinedPlanMapper.toRequest(workoutDetails, nutritionDetails);

        // 3. Call unified AI endpoint
        CombinedPlanResponseDTO aiResponse = aiClient.generatePlan(request);

        // 4. Persist workout plan
        WorkoutPlanDTO workoutPlanDTO = aiResponse.workoutPlan().workoutPlan();
        WorkoutPlan workoutPlan = workoutPlanMapper.toEntity(workoutPlanDTO);
        workoutPlan.setUserId(userId);
        workoutPlan.setStatus(PlanStatus.INACTIVE);
        workoutPlanRepository.save(workoutPlan);

        // 5. Persist nutrition plan
        NutritionPlanDTO nutritionPlanDTO = aiResponse.nutritionPlan().nutritionPlan();
        NutritionPlan nutritionPlan = nutritionPlanMapper.toEntity(nutritionPlanDTO);
        nutritionPlan.setUserId(userId);
        nutritionPlan.setStatus(PlanStatus.INACTIVE);
        nutritionPlanRepository.save(nutritionPlan);

        return ResponseEntity.ok(aiResponse);
    }
}