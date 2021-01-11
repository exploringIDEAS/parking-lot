package com.rahul.services;

import com.rahul.entities.ParkingSlot;
import com.rahul.utils.ParkingSlotSize;

public interface IParkingSlotService {
    void vacateParkingSlot(int parkingSlotId);
    void bookParkingSlot(int parkingSlotId);
    ParkingSlot createNewParkingSlot(int floorId, ParkingSlotSize parkingSlotSize, boolean isFree);
}
