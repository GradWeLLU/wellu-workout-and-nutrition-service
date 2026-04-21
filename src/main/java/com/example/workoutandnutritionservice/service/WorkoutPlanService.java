package com.example.workoutandnutritionservice.service;

import com.example.workoutandnutritionservice.entity.WorkoutPlan;
import com.example.workoutandnutritionservice.enumeration.PlanStatus;
import com.example.workoutandnutritionservice.repository.WorkoutPlanRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkoutPlanService {
    private final WorkoutPlanRepository planRepository;

    public List<WorkoutPlan> getUserPlans(UUID userId) {
        return planRepository.findAllByUserId(userId);
    }

    @Transactional
    public void activatePlan(UUID userId, UUID planId) {

        planRepository.findByUserIdAndStatus(userId, PlanStatus.ACTIVE)
                .ifPresent(old -> {
                    old.setStatus(PlanStatus.INACTIVE);
                    planRepository.save(old);
                });

        WorkoutPlan newPlan = planRepository.findById(planId)
                .orElseThrow();

        newPlan.setStatus(PlanStatus.ACTIVE);

        planRepository.save(newPlan);
    }
    public WorkoutPlan getActivePlan(UUID userId) {
        return planRepository.findByUserIdAndStatus(userId, PlanStatus.ACTIVE)
                .orElseThrow(() -> new RuntimeException("No active plan found"));
    }
    public WorkoutPlan getPlanById(UUID planId, UUID userId) {
        WorkoutPlan plan = planRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan not found"));

        if (!plan.getUserId().equals(userId)) {
            throw new RuntimeException("Unauthorized access");
        }

        return plan;
    }
}
