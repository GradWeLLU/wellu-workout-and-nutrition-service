

CREATE TABLE food_items (
                            id UUID PRIMARY KEY,

                            food_name VARCHAR(255) NOT NULL,

                            food_category VARCHAR(255),

                            calories INTEGER CHECK (calories > 0),

                            macros JSONB,

                            micros JSONB,

                            meal_id UUID,

                            CONSTRAINT fk_food_items_meal
                                FOREIGN KEY (meal_id)
                                    REFERENCES meals(id)
                                    ON DELETE CASCADE
);

CREATE INDEX idx_food_items_meal_id
    ON food_items(meal_id);