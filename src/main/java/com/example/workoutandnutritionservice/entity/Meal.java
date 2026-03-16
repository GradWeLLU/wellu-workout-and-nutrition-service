package com.example.workoutandnutritionservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name="meal_type")
    private String mealType;

    @Positive
    @Column(name = "total_calories")
    private int totalCalories;

    @Column(name = "total_macros",columnDefinition = "jsonb")
    private String totalMacros;

    @Column(name="total_micros",columnDefinition = "jsonb")
    private String totalMicros;

    @ManyToOne
    @JoinColumn(name = "nutrition_plan_id")
    private NutritionPlan nutritionPlan;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL)
    private List<FoodItem> foodItems;


}
