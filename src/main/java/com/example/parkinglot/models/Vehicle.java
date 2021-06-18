package com.example.parkinglot.models;

public class Vehicle {
    VehicleType type;
    String numberPlate;
    int enterTime;
    public Vehicle(VehicleType type, String numberPlate, int enterTime) {
        this.type = type;
        this.numberPlate = numberPlate;
        this.enterTime = enterTime;
    }
    public VehicleType getType() {
        return type;
    }
    public void setType(VehicleType type) {
        this.type = type;
    }
    public String getNumberPlate() {
        return numberPlate;
    }
    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }
    public int getEnterTime() {
        return enterTime;
    }
    public void setEnterTime(int enterTime) {
        this.enterTime = enterTime;
    }
    
}
