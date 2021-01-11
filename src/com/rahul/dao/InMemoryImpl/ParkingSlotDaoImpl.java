package com.rahul.dao.InMemoryImpl;

import com.rahul.dao.IParkingSlotDao;
import com.rahul.entities.ParkingSlot;
import com.rahul.exception.AlreadyBookedSlotException;
import com.rahul.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ParkingSlotDaoImpl implements IParkingSlotDao {
    private final List<ParkingSlot> parkingSlotList;
    private static ParkingSlotDaoImpl instance;

    private ParkingSlotDaoImpl() {
        parkingSlotList = new ArrayList<>();
    }

    public static ParkingSlotDaoImpl getInstance() {
        if (instance == null) {
            instance = new ParkingSlotDaoImpl();
        }
        return instance;
    }

    @Override
    public ParkingSlot addParkingSlot(ParkingSlot parkingSlot) {
        parkingSlot.setParkingSlotId(parkingSlotList.size());
        parkingSlotList.add(parkingSlot);
        return parkingSlot;
    }

    @Override
    public ParkingSlot getParkingSlot(int parkingSlotId) {
        if (parkingSlotId >= parkingSlotList.size()) {
            throw new EntityNotFoundException("parkingSlotId does not exist");
        }
        return parkingSlotList.get(parkingSlotId);
    }

    @Override
    public void bookParkingSlot(int parkingSlotId) {
        ParkingSlot parkingSlot = this.getParkingSlot(parkingSlotId);
        if (!parkingSlot.isFree()) {
            throw new AlreadyBookedSlotException("already booked slot.");
        }
        parkingSlot.setFree(false);
    }

    @Override
    public List<ParkingSlot> getAllParkingSlot() {
        return parkingSlotList;
    }
}
