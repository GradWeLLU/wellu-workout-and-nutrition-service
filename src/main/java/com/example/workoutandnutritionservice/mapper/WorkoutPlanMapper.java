package com.example.workoutandnutritionservice.mapper;

import com.example.workoutandnutritionservice.dto.WorkoutPlanDTO;
import com.example.workoutandnutritionservice.entity.WorkoutDay;
import com.example.workoutandnutritionservice.entity.WorkoutPlan;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        uses = WorkoutDayMapper.class) // Delegate mapping of nested WorkoutDay -> WorkoutDayDTO
public interface WorkoutPlanMapper {

    WorkoutPlanMapper INSTANCE = Mappers.getMapper(WorkoutPlanMapper.class);

    // Entity -> DTO
    WorkoutPlanDTO toDTO(WorkoutPlan workoutPlan);

    // DTO -> Entity
    WorkoutPlan toEntity(WorkoutPlanDTO dto);

}