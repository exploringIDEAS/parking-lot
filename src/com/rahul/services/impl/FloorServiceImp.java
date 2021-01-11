package com.rahul.services.impl;

import com.rahul.dao.IFloorDao;
import com.rahul.dao.InMemoryImpl.FloorDaoImpl;
import com.rahul.entities.Floor;
import com.rahul.entities.ParkingSlot;
import com.rahul.entities.Vehicle;
import com.rahul.exception.CapacityOverflowException;
import com.rahul.exception.NoFreeSlotException;
import com.rahul.services.IFloorService;
import com.rahul.services.IParkingSlotService;
import com.rahul.utils.ParkingSlotSize;

public class FloorServiceImp implements IFloorService {
    private final IFloorDao floorDao = FloorDaoImpl.getInstance();
    private final IParkingSlotService parkingSlotService = new ParkingSlotServiceImpl();
    @Override
    public void addFloor(int capacity) {
        Floor floor = new Floor();
        floor.setCapacity(capacity);
        floorDao.addFloor(floor);
    }

    @Override
    public void addParkingSlotInFloor(int floorId, ParkingSlotSize parkingSlotSize, boolean isFree) {
        Floor floor = floorDao.getFloor(floorId);
        if (floor.getParkingSlots().size() >= floor.getCapacity()) {
            throw new CapacityOverflowException("capacity overflow");
        }
        ParkingSlot parkingSlot = parkingSlotService.createNewParkingSlot(floorId, parkingSlotSize, isFree);
        floorDao.getFloor(floorId).getParkingSlots().add(parkingSlot);
    }

    @Override
    public ParkingSlot getFreeParkingSlot(ParkingSlotSize parkingSlotSize) {
        for (Floor floor: floorDao.getAll()) {
            for (ParkingSlot parkingSlot: floor.getParkingSlots()) {
                if (parkingSlot.getParkingSlotSize().equals(parkingSlotSize) && parkingSlot.isFree()) {
                    return parkingSlot;
                }
            }
        }
        throw new NoFreeSlotException("no free slot available");
    }

    @Override
    public int getFreeSlotsCount(int floorId) {
        return floorDao.getFreeSlotsCount(floorId);
    }
}
