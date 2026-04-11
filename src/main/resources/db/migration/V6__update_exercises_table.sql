-- V6__update_exercises_table.sql

-- Remove description column
ALTER TABLE exercises
DROP COLUMN IF EXISTS description;

-- Change sets from INT to TEXT (String equivalent)
ALTER TABLE exercises
ALTER COLUMN sets TYPE TEXT USING sets::TEXT;

-- Drop old columns
ALTER TABLE workout_days
DROP COLUMN IF EXISTS title;

ALTER TABLE workout_days
DROP COLUMN IF EXISTS description;

ALTER TABLE workout_days
DROP COLUMN IF EXISTS day_number;

-- Add new columns
ALTER TABLE workout_days
    ADD COLUMN day VARCHAR(255) NOT NULL;

ALTER TABLE workout_days
    ADD COLUMN focus VARCHAR(255) NOT NULL;

-- V4__update_workout_plans_schema.sql

-- Drop description (no longer used)
ALTER TABLE workout_plans
DROP COLUMN IF EXISTS description;

-- Rename name → weekly_split
ALTER TABLE workout_plans
    RENAME COLUMN name TO weekly_split;