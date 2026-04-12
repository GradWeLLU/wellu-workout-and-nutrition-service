package com.example.workoutandnutritionservice.repository;

import com.example.workoutandnutritionservice.entity.WorkoutDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkoutDayRepository extends JpaRepository<WorkoutDay, UUID> {
}
