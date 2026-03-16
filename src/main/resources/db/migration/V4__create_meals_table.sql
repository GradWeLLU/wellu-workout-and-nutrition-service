

CREATE TABLE meals (
                      id UUID PRIMARY KEY,

                      meal_type VARCHAR(255),

                      total_calories INTEGER CHECK (total_calories > 0),

                      total_macros JSONB,

                      total_micros JSONB,

                      nutrition_plan_id UUID,

                      CONSTRAINT fk_meal_nutrition_plan
                          FOREIGN KEY (nutrition_plan_id)
                              REFERENCES nutrition_plans(id)
                              ON DELETE SET NULL
);

CREATE INDEX idx_meal_nutrition_plan
    ON meals(nutrition_plan_id);