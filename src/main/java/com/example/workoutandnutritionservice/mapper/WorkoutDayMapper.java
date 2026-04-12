package com.example.workoutandnutritionservice.mapper;

import com.example.workoutandnutritionservice.dto.WorkoutDayDTO;
import com.example.workoutandnutritionservice.entity.WorkoutDay;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = "spring",
        uses = ExerciseMapper.class) // Use ExerciseMapper for nested list
public interface WorkoutDayMapper {

    WorkoutDayMapper INSTANCE = Mappers.getMapper(WorkoutDayMapper.class);

    // Entity -> DTO
    WorkoutDayDTO toDTO(WorkoutDay workoutDay);

    // DTO -> Entity
    WorkoutDay toEntity(WorkoutDayDTO dto);
}