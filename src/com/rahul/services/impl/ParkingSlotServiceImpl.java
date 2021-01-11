package com.rahul.services.impl;

import com.rahul.dao.IParkingSlotDao;
import com.rahul.dao.InMemoryImpl.ParkingSlotDaoImpl;
import com.rahul.entities.ParkingSlot;
import com.rahul.services.IParkingSlotService;
import com.rahul.utils.ParkingSlotSize;

public class ParkingSlotServiceImpl implements IParkingSlotService {
    private final IParkingSlotDao parkingSlotDao = ParkingSlotDaoImpl.getInstance();

    @Override
    public void vacateParkingSlot(int parkingSlotId) {
        parkingSlotDao.getParkingSlot(parkingSlotId).setFree(true);
    }

    @Override
    public void bookParkingSlot(int parkingSlotId) {
        parkingSlotDao.getParkingSlot(parkingSlotId).setFree(false);
    }

    @Override
    public ParkingSlot createNewParkingSlot(int floorId, ParkingSlotSize parkingSlotSize, boolean isFree) {
        ParkingSlot parkingSlot = new ParkingSlot();
        parkingSlot.setParkingSlotSize(parkingSlotSize);
        parkingSlot.setFloorId(floorId);
        parkingSlot.setFree(isFree);
        return parkingSlotDao.addParkingSlot(parkingSlot);
    }
}
