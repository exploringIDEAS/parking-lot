package com.rahul.services;

import com.rahul.entities.Floor;
import com.rahul.entities.ParkingSlot;
import com.rahul.entities.Vehicle;
import com.rahul.utils.ParkingSlotSize;

public interface IFloorService {
    void addFloor(int capacity);
    void addParkingSlotInFloor(int floorId, ParkingSlotSize parkingSlotSize, boolean isFree);
    ParkingSlot getFreeParkingSlot(ParkingSlotSize parkingSlotSize);
    int getFreeSlotsCount(int floorId);
}
