package com.example.polemistesfitness;

public class Set {
    private String date;
    private String exerciseName;
    private int weight;
    private int reps;

    public Set(String date, String exerciseName, int weight, int reps) {
        this.date = date;
        this.exerciseName = exerciseName;
        this.weight = weight;
        this.reps = reps;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }
}
