package com.example.workoutandnutritionservice.controller;

import com.example.workoutandnutritionservice.dto.CombinedPlanResponseDTO;
import com.example.workoutandnutritionservice.service.PlanGenerationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plans")
@RequiredArgsConstructor
public class PlanGenerationController {

    private final PlanGenerationService planGenerationService;

    @PostMapping("/generate")
    public ResponseEntity<CombinedPlanResponseDTO> generatePlan(
            @RequestHeader("Authorization") String jwtToken
    ) {
        return planGenerationService.generatePlan(jwtToken);
    }
}