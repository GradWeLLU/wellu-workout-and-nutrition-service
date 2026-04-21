package com.example.workoutandnutritionservice.controller;

import com.example.workoutandnutritionservice.dto.AIResponseDTO;
import com.example.workoutandnutritionservice.service.WorkoutGenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
public class WorkoutGenerationController {
    private final WorkoutGenerationService workoutGenerationService;

    @PostMapping("/generate")
    public ResponseEntity<AIResponseDTO> generateWorkout(@RequestHeader("Authorization") String JwtToken){
        return workoutGenerationService.generateWorkout(JwtToken);
    }
}
