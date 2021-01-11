package com.rahul.services.impl;

import com.rahul.dao.IVehicleDao;
import com.rahul.dao.InMemoryImpl.VehicleDaoImpl;
import com.rahul.entities.Vehicle;
import com.rahul.services.IParkingSlotService;
import com.rahul.services.IVehicleService;
import com.rahul.utils.VehicleSize;

public class VehicleServiceImpl implements IVehicleService {
    private final IVehicleDao vehicleDao = VehicleDaoImpl.getInstance();
    private final IParkingSlotService parkingSlotService = new ParkingSlotServiceImpl();

    @Override
    public Vehicle addVehicle(String vehiclePlat, VehicleSize vehicleSize, int parkedAtSlotId) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehiclePlat(vehiclePlat);
        vehicle.setVehicleSize(vehicleSize);
        vehicle.setParkedAtSlotId(parkedAtSlotId);
        vehicleDao.addVehicle(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle getVehicle(String vehiclePlat) {
        Vehicle vehicle = vehicleDao.getVehicle(vehiclePlat);
        return vehicleDao.getVehicle(vehiclePlat);
    }

    @Override
    public void removeVehicle(String vehiclePlat) {
        Vehicle vehicle = this.getVehicle(vehiclePlat);
        vehicleDao.removeVehicle(vehiclePlat);
        parkingSlotService.vacateParkingSlot(vehicle.getParkedAtSlotId());
    }

    @Override
    public int getParkedVehicleCount() {
        return vehicleDao.getParkedVehicleCount();
    }
}
