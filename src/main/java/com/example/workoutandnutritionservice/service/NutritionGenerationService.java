package com.example.workoutandnutritionservice.service;

import com.example.workoutandnutritionservice.client.AIClient;
import com.example.workoutandnutritionservice.client.UserClient;
import com.example.workoutandnutritionservice.dto.NutritionRequestDTO;
import com.example.workoutandnutritionservice.dto.NutritionResponseDTO;
import com.example.workoutandnutritionservice.dto.UserNutritionPlanDetailsDTO;
import com.example.workoutandnutritionservice.mapper.NutritionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NutritionGenerationService {
    private final UserClient userClient;
    private final AIClient aIClient;

    public ResponseEntity<NutritionResponseDTO> generateNutrition(String jwtToken){
        UserNutritionPlanDetailsDTO userDetails = fetchUserDetails(jwtToken);
        NutritionRequestDTO nutritionRequest = NutritionMapper.toNutritionRequest(userDetails);
        return ResponseEntity.ok(fetchNutritionPlan(nutritionRequest));
    }

    public UserNutritionPlanDetailsDTO fetchUserDetails(String jwtToken){
        return userClient.getNutritionDetails(jwtToken);
    }

    public NutritionResponseDTO fetchNutritionPlan(NutritionRequestDTO nutritionRequest){
        return aIClient.generateNutrition(nutritionRequest);
    }
}
