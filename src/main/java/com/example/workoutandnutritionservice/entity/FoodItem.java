package com.example.workoutandnutritionservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "food_items")
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "food_name",nullable = false)
    private String foodName;

    @Column(name="food_category")
    private String foodCategory;

    @Positive
    @Column(name = "calories")
    private int calories;

    @Column(name = "macros",columnDefinition = "jsonb")
    private String macros;

    @Column(name = "micros",columnDefinition = "jsonb")
    private String micros;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;


}
