package com.example.parkinglot.services;

import java.util.HashMap;

import com.example.parkinglot.models.Parking;
import com.example.parkinglot.models.ParkingFloor;
import com.example.parkinglot.models.ParkingSlot;
import com.example.parkinglot.models.Payment;
import com.example.parkinglot.models.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parkinglot.models.VehicleCharge;
import com.example.parkinglot.models.VehicleType;

@Service 
public class ParkingServices {
      public Parking parkingLot;
      @Autowired
      VehicleCharge vehicleCharge;
      HashMap<String,String> m=new HashMap<>();
     public void createParkingLot(int numberOfFloors,int capacity){
          parkingLot=new Parking(numberOfFloors,capacity);

     }
     public void addVehicleCharges(VehicleCharge vehicleChargesUpdates){
             vehicleCharge.setBikePerHourCharges(vehicleChargesUpdates.getBikePerHourCharges());
             vehicleCharge.setCarPerHourCharges(vehicleChargesUpdates.getCarPerHourCharges());
     }
     
     public boolean checkSpaceAvailable(Vehicle vehicle){
          for(ParkingFloor floor:parkingLot.getParkingFloors()){
              if(floor.getCapacity()>0){
                   for(ParkingSlot slot:floor.getParkingSlots()){
                        if(slot.isOccupied()==false){
                               
                              return true;
                        }
                   }
              }
          }
          return false;
     }
     public ParkingSlot addVehicle(Vehicle vehicle){
          ParkingSlot result=null;
          for(ParkingFloor floor:parkingLot.getParkingFloors()){
              if(floor.getCapacity()>0){
                   for(ParkingSlot slot:floor.getParkingSlots()){
                        if(slot.isOccupied()==false){
                              slot.setOccupied(true);  
                              slot.setVehicle(vehicle);
                              floor.setCapacity(floor.getCapacity()-1);
                              result=slot;
                              return result;
                        }
                   }
              }
          }
          return result;
     }
     public Payment removeVehicle(ParkingSlot parkingSlot,int hourNow){
          int floor=parkingSlot.getFloorNo();
          int slot=parkingSlot.getSlotNo();
          parkingLot.getParkingFloors().get(floor).setCapacity(parkingLot.getParkingFloors().get(floor).getCapacity()+1);
          parkingLot.getParkingFloors().get(floor).getParkingSlots().get(slot).setOccupied(false);
          String vehicleNo=parkingSlot.getVehicle().getNumberPlate();
          int start=parkingSlot.getVehicle().getEnterTime();
          int end=hourNow;
          int hoursStayed=end-start+1;
          int rate=0;
          if(parkingSlot.getVehicle().getType()==VehicleType.BIKE)
          rate=vehicleCharge.getBikePerHourCharges();
          
          if(parkingSlot.getVehicle().getType()==VehicleType.CAR)
          rate=vehicleCharge.getCarPerHourCharges();
          
          int amount=hoursStayed*rate;
          Payment payment=new Payment(vehicleNo,amount,hoursStayed,start,end);
          return payment;   
     }
}
