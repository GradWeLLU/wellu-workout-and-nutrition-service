package com.example.workoutandnutritionservice.service;

import com.example.workoutandnutritionservice.dto.UserWorkoutPlanDetailsDTO;
import com.example.workoutandnutritionservice.enumeration.PlanStatus;
import com.example.workoutandnutritionservice.mapper.WorkoutMapper;
import org.wellu.common.security.JwtService;
import com.example.workoutandnutritionservice.client.AIClient;
import com.example.workoutandnutritionservice.client.UserClient;
import com.example.workoutandnutritionservice.dto.AIResponseDTO;
import com.example.workoutandnutritionservice.dto.WorkoutPlanDTO;
import com.example.workoutandnutritionservice.dto.WorkoutRequestDTO;
import com.example.workoutandnutritionservice.entity.WorkoutPlan;
import com.example.workoutandnutritionservice.mapper.WorkoutPlanMapper;
import com.example.workoutandnutritionservice.repository.WorkoutPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkoutGenerationService {
    private final UserClient userClient;
    private final AIClient aiClient;
    private final WorkoutPlanMapper workoutPlanMapper;
    private final WorkoutPlanRepository workoutPlanRepository;

    public ResponseEntity<AIResponseDTO> generateWorkout(String JwtToken){
        UserWorkoutPlanDetailsDTO userDetails = fetchUserDetails(JwtToken);
        UUID userID = userDetails.userID();
        WorkoutRequestDTO workoutRequest = WorkoutMapper.toWorkoutRequest(userDetails);
        AIResponseDTO aiReply = fetchWorkoutPlan(workoutRequest);
        WorkoutPlanDTO planDTO = aiReply.workoutPlan();
        WorkoutPlan plan = workoutPlanMapper.toEntity(planDTO);
        plan.setUserId(userID);
        plan.setStatus(PlanStatus.INACTIVE);
        workoutPlanRepository.save(plan);
        return ResponseEntity.ok(aiReply);
    }
    private UserWorkoutPlanDetailsDTO fetchUserDetails(String JwtToken){
        //System.out.println(userClient.getWorkoutDetails(JwtToken));
        return userClient.getWorkoutDetails(JwtToken);
    }
    private AIResponseDTO fetchWorkoutPlan(WorkoutRequestDTO userDetails){
        return aiClient.generateWorkout(userDetails);
    }
    private AIResponseDTO processAIResponse (AIResponseDTO aiResponseDTO){
        return null;
    }

}
