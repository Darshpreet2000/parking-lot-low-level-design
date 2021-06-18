package com.example.parkinglot.models;

public class Payment {
    String vehicleNo;
    int amount;
    int hoursStayed;
    int startDuration;
    int endDuration;
    
    public Payment(String vehicleNo, int amount, int hoursStayed, int startDuration, int endDuration) {
        this.vehicleNo = vehicleNo;
        this.amount = amount;
        this.hoursStayed = hoursStayed;
        this.startDuration = startDuration;
        this.endDuration = endDuration;
    }
    public String getVehicleNo() {
        return vehicleNo;
    }
    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getHoursStayed() {
        return hoursStayed;
    }
    public void setHoursStayed(int hoursStayed) {
        this.hoursStayed = hoursStayed;
    }
    public int getStartDuration() {
        return startDuration;
    }
    public void setStartDuration(int startDuration) {
        this.startDuration = startDuration;
    }
    public int getEndDuration() {
        return endDuration;
    }
    public void setEndDuration(int endDuration) {
        this.endDuration = endDuration;
    }
     
    
}
