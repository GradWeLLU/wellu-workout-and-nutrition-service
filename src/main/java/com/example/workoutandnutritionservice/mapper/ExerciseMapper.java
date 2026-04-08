package com.example.workoutandnutritionservice.mapper;

import com.example.workoutandnutritionservice.dto.ExerciseDTO;
import com.example.workoutandnutritionservice.entity.Exercise;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExerciseMapper {

    ExerciseMapper INSTANCE = Mappers.getMapper(ExerciseMapper.class);

    // Entity -> DTO
    ExerciseDTO toDTO(Exercise exercise);

    // DTO -> Entity
    Exercise toEntity(ExerciseDTO dto);
}
