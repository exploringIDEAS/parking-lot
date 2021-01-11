package com.rahul.dao;

import com.rahul.entities.Vehicle;

import java.util.List;

public interface IVehicleDao {
    void addVehicle(Vehicle vehicle);
    Vehicle getVehicle(String vehiclePlat);
    List<Vehicle> getAllVehicle();
    void removeVehicle(String vehiclePlat);
    int getParkedVehicleCount();
}
