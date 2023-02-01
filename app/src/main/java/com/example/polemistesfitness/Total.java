package com.example.polemistesfitness;

public class Total {
    private String date;
    private int totalWeight;
    private int totalReps;
    private int fitnessScore;

    public Total(String date, int totalWeight, int totalReps, int fitnessScore) {
        this.date = date;
        this.totalWeight = totalWeight;
        this.totalReps = totalReps;
        this.fitnessScore = fitnessScore;
    }

    public int getFitnessScore() {
        return fitnessScore;
    }

    public int getTotalReps() {
        return totalReps;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setFitnessScore(int fitnessScore) {
        this.fitnessScore = fitnessScore;
    }

    public void setTotalReps(int totalReps) {
        this.totalReps = totalReps;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }
}
