package com.example.parkinglot.models;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    List<ParkingFloor> parkingFloors=new ArrayList<>();
    int numberOfFloors; 
    int capacity;
    public Parking(int numberOfFloors,int capacity) {
        this.numberOfFloors = numberOfFloors;
        this.capacity=capacity;
    
        for(int i=0;i<numberOfFloors;i++){
            parkingFloors.add(new ParkingFloor(i,capacity));
        }
    }
    
    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }
    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
