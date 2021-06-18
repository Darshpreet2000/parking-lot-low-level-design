package com.example.parkinglot.controllers;

import java.util.HashMap;

import com.example.parkinglot.models.Parking;
import com.example.parkinglot.models.VehicleCharge;
import com.example.parkinglot.services.ParkingServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {  
     
   ParkingServices parkingServices;
    
    @Autowired
     public AdminController(ParkingServices parkingServices) {
         this.parkingServices = parkingServices;
     }
    @PostMapping("/create-parking-lot")
    public Parking  createParkingLot(@RequestBody  HashMap<String,String> body){
       parkingServices.createParkingLot(Integer.parseInt(body.get("numberOfFloors")),Integer.parseInt(body.get("capacity")));
       return parkingServices.parkingLot;
    }
    @PostMapping("/update-price")
    public void updatePrice(@RequestBody  VehicleCharge body){
        parkingServices.addVehicleCharges(body);
    } 
    @GetMapping("/display")
    public Parking display(){
        return parkingServices.parkingLot;
    } 
}
