package com.example.workoutandnutritionservice.client;

import com.example.workoutandnutritionservice.dto.AIResponseDTO;
import com.example.workoutandnutritionservice.dto.WorkoutPlanDTO;
import com.example.workoutandnutritionservice.dto.WorkoutRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "ai-client", url = "http://host.docker.internal:8000")
public interface AIClient {

    @PostMapping("/generate-workout")
    AIResponseDTO generateWorkout(WorkoutRequestDTO requestDTO);
}