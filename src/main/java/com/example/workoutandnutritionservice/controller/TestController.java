package com.example.workoutandnutritionservice.controller;

import com.example.workoutandnutritionservice.client.AIClient;
import com.example.workoutandnutritionservice.client.UserClient;
import com.example.workoutandnutritionservice.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {
    private final UserClient userClient;
    private final AIClient aIClient;

    @GetMapping("/user")
    public WorkoutRequestDTO testUserClient(@RequestHeader("Authorization") String jwtToken){
        return userClient.getWorkoutDetails(jwtToken);
    }
    @PostMapping("/generate")
    public AIResponseDTO testAIChain(@RequestBody WorkoutRequestDTO workoutRequest){
        return aIClient.generateWorkout(workoutRequest);
    }
    @PostMapping("/generate-nutrition")
    public NutritionResponseDTO testNutritionChain(@RequestBody NutritionRequestDTO nutritionRequest){
        System.out.println(nutritionRequest);
        return aIClient.generateNutrition(nutritionRequest);
    }
}
