package com.example.workoutandnutritionservice.service;

import com.example.workoutandnutritionservice.client.AIClient;
import com.example.workoutandnutritionservice.client.UserClient;
import com.example.workoutandnutritionservice.dto.AIResponseDTO;
import com.example.workoutandnutritionservice.dto.WorkoutRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkoutGenerationService {
    private final UserClient userClient;
    private final AIClient aiClient;

    public ResponseEntity<AIResponseDTO> generateWorkout(String JwtToken){
        WorkoutRequestDTO userDetails = fetchUserDetails(JwtToken);
        AIResponseDTO aiReply = fetchWorkoutPlan(userDetails);
        return ResponseEntity.ok(aiReply);

    }
    private WorkoutRequestDTO fetchUserDetails(String JwtToken){
        System.out.println(userClient.getUserById(JwtToken));
        return userClient.getUserById(JwtToken);
    }
    private AIResponseDTO fetchWorkoutPlan(WorkoutRequestDTO userDetails){
        return aiClient.generateWorkout(userDetails);
    }
    private AIResponseDTO processAIResponse (AIResponseDTO aiResponseDTO){
        return null;
    }

}
