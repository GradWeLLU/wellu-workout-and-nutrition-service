package com.example.workoutandnutritionservice.controller;


import com.example.workoutandnutritionservice.dto.ApiMessageResponse;
import com.example.workoutandnutritionservice.dto.WorkoutPlanPatchRequestDTO;
import com.example.workoutandnutritionservice.dto.WorkoutPlanResponseDTO;
import com.example.workoutandnutritionservice.security.JwtUserPrincipal;
import com.example.workoutandnutritionservice.service.WorkoutPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/workouts")
@RequiredArgsConstructor
public class WorkoutPlanController {
    private final WorkoutPlanService service;

    @GetMapping("/plans")
    public ResponseEntity<List<WorkoutPlanResponseDTO>> getAllPlans(@AuthenticationPrincipal JwtUserPrincipal user) {
        return service.getUserPlans(user.getUserId());
    }

    @PostMapping("/plans/{planId}/activate")
    public ResponseEntity<ApiMessageResponse> activatePlan(@PathVariable UUID planId,
                                                           @AuthenticationPrincipal JwtUserPrincipal user) {
        return service.activatePlan(user.getUserId(), planId);
    }

    @GetMapping("/plans/active")
    public ResponseEntity<WorkoutPlanResponseDTO> getActivePlan(@AuthenticationPrincipal JwtUserPrincipal user) {
        return service.getActivePlan(user.getUserId());
    }

    @GetMapping("/plans/{planId}")
    public ResponseEntity<WorkoutPlanResponseDTO> getPlanById(@PathVariable UUID planId,
                                                              @AuthenticationPrincipal JwtUserPrincipal user) {
        return service.getPlanById(planId, user.getUserId());
    }

    @PatchMapping("/{planId}")
    public ResponseEntity<WorkoutPlanResponseDTO> patchPlan(
            @PathVariable UUID planId,
            @RequestBody WorkoutPlanPatchRequestDTO request,
            @AuthenticationPrincipal JwtUserPrincipal user) {

        return service.patchPlan(planId, user.getUserId(), request);
    }
}

