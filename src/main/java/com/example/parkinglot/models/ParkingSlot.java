package com.example.parkinglot.models;

public class ParkingSlot {
    int slotNo;
    int floorNo;
    Vehicle vehicle;
    
    boolean isOccupied=false;
   
    public ParkingSlot(int floorNo,int slotNo) {
        this.slotNo = slotNo;
        this.floorNo = floorNo;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
  
    public boolean isOccupied() {
        return isOccupied;
    }
    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
    public int getSlotNo() {
        return slotNo;
    }
    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }
    public int getFloorNo() {
        return floorNo;
    }
    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }
    
}
