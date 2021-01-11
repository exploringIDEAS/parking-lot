package com.rahul.entities;

import com.rahul.utils.ParkingSlotSize;

public class ParkingSlot {
    private int parkingSlotId;
    private int floorId;
    private ParkingSlotSize parkingSlotSize;
    private boolean isFree;

    public int getParkingSlotId() {
        return parkingSlotId;
    }

    public void setParkingSlotId(int parkingSlotId) {
        this.parkingSlotId = parkingSlotId;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public ParkingSlotSize getParkingSlotSize() {
        return parkingSlotSize;
    }

    public void setParkingSlotSize(ParkingSlotSize parkingSlotSize) {
        this.parkingSlotSize = parkingSlotSize;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }
}
