package com.rahul.entities;

import com.rahul.utils.VehicleSize;

public class Vehicle {
    private String vehiclePlat;
    private VehicleSize vehicleSize;
    private int parkedAtSlotId;


    public String getVehiclePlat() {
        return vehiclePlat;
    }

    public void setVehiclePlat(String vehiclePlat) {
        this.vehiclePlat = vehiclePlat;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(VehicleSize vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public int getParkedAtSlotId() {
        return parkedAtSlotId;
    }

    public void setParkedAtSlotId(int parkedAtSlotId) {
        this.parkedAtSlotId = parkedAtSlotId;
    }
}
