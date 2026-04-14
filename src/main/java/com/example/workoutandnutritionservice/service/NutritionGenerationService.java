package com.example.workoutandnutritionservice.service;

import com.example.workoutandnutritionservice.client.AIClient;
import com.example.workoutandnutritionservice.client.UserClient;
import com.example.workoutandnutritionservice.dto.NutritionPlanDTO;
import com.example.workoutandnutritionservice.dto.NutritionRequestDTO;
import com.example.workoutandnutritionservice.dto.NutritionResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NutritionGenerationService {
    private final UserClient userClient;
    private final AIClient aIClient;

    public ResponseEntity<NutritionResponseDTO> generateNutrition(String jwtToken){
        NutritionRequestDTO userDetails = fetchUserDetails(jwtToken);
        return ResponseEntity.ok(fetchNutritionPlan(userDetails));
    }

    public NutritionRequestDTO fetchUserDetails(String jwtToken){
        return userClient.getNutritionDetails(jwtToken);
    }
    public NutritionResponseDTO fetchNutritionPlan(NutritionRequestDTO userDetails){
        return aIClient.generateNutrition(userDetails);
    }
}
