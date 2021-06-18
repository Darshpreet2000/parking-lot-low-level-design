package com.example.parkinglot.controllers;

import com.example.parkinglot.models.CustomMessage;
import com.example.parkinglot.models.ParkingSlot;
import com.example.parkinglot.models.Payment;
import com.example.parkinglot.models.Vehicle;
import com.example.parkinglot.services.ParkingServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GateController {

    ParkingServices parkingServices;

    @Autowired
    public GateController(ParkingServices parkingServices) {
        this.parkingServices = parkingServices;
    }
    @PostMapping("add-vehicle")    
    public ResponseEntity<Object> addVehicle(@RequestBody Vehicle vehicle) throws Exception{
             boolean isSpaceAvailable=parkingServices.checkSpaceAvailable(vehicle);
             if(isSpaceAvailable==false){
                CustomMessage errorMessage = new CustomMessage();
                errorMessage.code = HttpStatus.CONFLICT.value();
                errorMessage.message = "Cannot Add Vehicle";
                 return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage); 
                 }
                 ParkingSlot slot=   parkingServices.addVehicle(vehicle);
         return ResponseEntity.ok(slot);
    }
    
    @DeleteMapping("remove-vehicle/{hourNow}")    
    public ResponseEntity<Object> removeVehicle(@RequestBody ParkingSlot parkingSlot,@PathVariable int hourNow) throws Exception{
        Payment payment=parkingServices.removeVehicle(parkingSlot,hourNow);
        
        return ResponseEntity.ok(payment);
    }
   
}