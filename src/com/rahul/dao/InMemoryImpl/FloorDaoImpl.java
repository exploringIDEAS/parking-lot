package com.rahul.dao.InMemoryImpl;

import com.rahul.dao.IFloorDao;
import com.rahul.entities.Floor;
import com.rahul.entities.ParkingSlot;
import com.rahul.exception.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class FloorDaoImpl implements IFloorDao {
    private final List<Floor> floorList;
    private static FloorDaoImpl instance;

    private FloorDaoImpl() {
        floorList = new ArrayList<>();
    }

    public static FloorDaoImpl getInstance() {
        if (instance == null) {
            instance = new FloorDaoImpl();
        }
        return instance;
    }

    @Override
    public void addFloor(Floor floor) {
        floor.setFloorId(floorList.size());
        floorList.add(floor);
    }

    @Override
    public Floor getFloor(int floorId) {
        if (floorId >= floorList.size()) {
            throw new EntityNotFoundException("FloorId does not exist");
        }
        return floorList.get(floorId);
    }

    @Override
    public List<Floor> getAll() {
        return floorList;
    }

    @Override
    public List<ParkingSlot> getAllParkingSlot(int floorId) {
        Floor floor = this.getFloor(floorId);
        return floor.getParkingSlots();
    }

    @Override
    public int getFreeSlotsCount(int floorId) {
        Floor floor = this.getFloor(floorId);
        int count = 0;
        for (ParkingSlot parkingSlot: floor.getParkingSlots()) {
            count += parkingSlot.isFree() ? 1 : 0;
        }
        return count;
    }
}
