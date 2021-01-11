package com.rahul.dao;

import com.rahul.entities.Floor;
import com.rahul.entities.ParkingSlot;

import java.util.List;

public interface IParkingSlotDao {
    ParkingSlot addParkingSlot(ParkingSlot parkingSlot);
    ParkingSlot getParkingSlot(int parkingSlotId);
    void bookParkingSlot(int parkingSlotId);
    List<ParkingSlot> getAllParkingSlot();
}
