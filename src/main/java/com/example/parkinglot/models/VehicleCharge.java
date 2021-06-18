package com.example.parkinglot.models;

import org.springframework.stereotype.Component;

@Component
public class VehicleCharge {
    private int carPerHourCharges;
    private int bikePerHourCharges;
     
    
    public int getCarPerHourCharges() {
        return carPerHourCharges;
    }
    public void setCarPerHourCharges(int carPerHourCharges) {
        this.carPerHourCharges = carPerHourCharges;
    }
    public int getBikePerHourCharges() {
        return bikePerHourCharges;
    }
    public void setBikePerHourCharges(int bikePerHourCharges) {
        this.bikePerHourCharges = bikePerHourCharges;
    }
    
}
