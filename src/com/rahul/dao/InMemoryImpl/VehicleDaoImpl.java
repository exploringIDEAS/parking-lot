package com.rahul.dao.InMemoryImpl;

import com.rahul.dao.IVehicleDao;
import com.rahul.entities.Vehicle;
import com.rahul.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleDaoImpl implements IVehicleDao {
    private final Map<String, Vehicle> vehicleMap;
    private static VehicleDaoImpl instance;

    private VehicleDaoImpl() {
        vehicleMap = new HashMap<>();
    }

    public static VehicleDaoImpl getInstance() {
        if (instance == null) {
            instance = new VehicleDaoImpl();
        }
        return instance;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicleMap.put(vehicle.getVehiclePlat(), vehicle);
    }

    @Override
    public Vehicle getVehicle(String vehiclePlat) {
        Vehicle vehicle = vehicleMap.get(vehiclePlat);
        if (vehicle == null) {
            throw new EntityNotFoundException("vehicle entity not found");
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return new ArrayList<>(vehicleMap.values());
    }

    @Override
    public void removeVehicle(String vehiclePlat) {
        this.getVehicle(vehiclePlat);
        vehicleMap.remove(vehiclePlat);
    }

    @Override
    public int getParkedVehicleCount() {
        return vehicleMap.size();
    }
}
