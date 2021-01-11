package com.rahul.dao;

import com.rahul.entities.Floor;
import com.rahul.entities.ParkingSlot;

import java.util.List;

public interface IFloorDao {
    void addFloor(Floor floor);
    Floor getFloor(int floorId);
    List<Floor> getAll();
    List<ParkingSlot> getAllParkingSlot(int floorId);
    int getFreeSlotsCount(int floorId);
}
