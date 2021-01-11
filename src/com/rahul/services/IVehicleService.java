package com.rahul.services;

import com.rahul.entities.Vehicle;
import com.rahul.utils.VehicleSize;

public interface IVehicleService {
    Vehicle addVehicle(String vehiclePlat, VehicleSize vehicleSize, int parkedAtSlotId);
    Vehicle getVehicle(String vehiclePlat);
    void removeVehicle(String vehiclePlat);
    int getParkedVehicleCount();
}
