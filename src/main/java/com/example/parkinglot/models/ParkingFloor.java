package com.example.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    int floorNo;
    List<ParkingSlot> parkingSlots;
    int capacity;
    int availableSpace;
    public ParkingFloor(int floorNo,int capacity) {
        this.capacity = capacity;
        this.floorNo=floorNo;
        this.availableSpace=capacity;
        parkingSlots=new ArrayList<>();
        for(int i=0;i<capacity;i++){
            parkingSlots.add(new ParkingSlot(floorNo,i));
        }
    }
    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }
    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public int getAvailableSpace() {
        return availableSpace;
    }
    public void setAvailableSpace(int availableSpace) {
        this.availableSpace = availableSpace;
    }
    
}
