package com.example.workoutandnutritionservice.repository;

import com.example.workoutandnutritionservice.entity.WorkoutPlan;
import com.example.workoutandnutritionservice.enumeration.PlanStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WorkoutPlanRepository extends JpaRepository<WorkoutPlan, UUID> {
    List<WorkoutPlan> findAllByUserId(UUID userId);
    Optional<WorkoutPlan> findByUserIdAndStatus(UUID userId, PlanStatus status);
}
