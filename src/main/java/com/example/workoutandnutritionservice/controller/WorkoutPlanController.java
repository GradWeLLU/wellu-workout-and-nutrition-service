package com.example.workoutandnutritionservice.controller;


import com.example.workoutandnutritionservice.entity.WorkoutPlan;
import com.example.workoutandnutritionservice.security.JwtUserPrincipal;
import com.example.workoutandnutritionservice.service.WorkoutPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController("/workouts")
@RequiredArgsConstructor
public class WorkoutPlanController {
    private final WorkoutPlanService service;

    @GetMapping("/plans")
    public List<WorkoutPlan> getAllPlans(@AuthenticationPrincipal JwtUserPrincipal user) {
        return service.getUserPlans(user.getUserId());
    }
    @PostMapping("/plans/{planId}/activate")
    public void activatePlan(@PathVariable UUID planId,
                             @AuthenticationPrincipal JwtUserPrincipal user) {

        service.activatePlan(user.getUserId(), planId);
    }
    @GetMapping("/plans/active")
    public WorkoutPlan getActivePlan(@AuthenticationPrincipal JwtUserPrincipal user) {
        return service.getActivePlan(user.getUserId());
    }
    @GetMapping("/plans/{planId}")
    public WorkoutPlan getPlanById(@PathVariable UUID planId,
                                   @AuthenticationPrincipal JwtUserPrincipal user) {
        return service.getPlanById(planId, user.getUserId());
    }
}

