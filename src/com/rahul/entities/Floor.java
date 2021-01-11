package com.rahul.entities;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorId;
    private int capacity;
    private List<ParkingSlot> parkingSlots;

    public Floor() {
        parkingSlots = new ArrayList<>();
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
