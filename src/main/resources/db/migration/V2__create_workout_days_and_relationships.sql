-- V2__create_workout_days_and_relationships.sql

-- WorkoutPlan table
CREATE TABLE workout_plans (
                               id UUID PRIMARY KEY,
                               user_id UUID NOT NULL,
                               name VARCHAR(255) NOT NULL,
                               description VARCHAR(1000),
                               plan_type VARCHAR(50) NOT NULL,
                               difficulty VARCHAR(50) NOT NULL
);

-- WorkoutDay table
CREATE TABLE workout_days (
                              id UUID PRIMARY KEY,
                              day_number INT NOT NULL,
                              title VARCHAR(255),
                              description VARCHAR(1000),
                              workout_plan_id UUID,
                              CONSTRAINT fk_workout_plan
                                  FOREIGN KEY(workout_plan_id) REFERENCES workout_plans(id)
                                      ON DELETE CASCADE
);

-- WorkoutDay <-> Exercise many-to-many table
CREATE TABLE workout_day_exercises (
                                       workout_day_id UUID NOT NULL,
                                       exercise_id UUID NOT NULL,
                                       PRIMARY KEY(workout_day_id, exercise_id),
                                       CONSTRAINT fk_workout_day
                                           FOREIGN KEY(workout_day_id) REFERENCES workout_days(id)
                                               ON DELETE CASCADE,
                                       CONSTRAINT fk_exercise
                                           FOREIGN KEY(exercise_id) REFERENCES exercises(id)
                                               ON DELETE CASCADE
);