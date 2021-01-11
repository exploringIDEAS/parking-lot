package com.rahul;

import com.rahul.entities.ParkingSlot;
import com.rahul.entities.Vehicle;
import com.rahul.services.IFloorService;
import com.rahul.services.IParkingSlotService;
import com.rahul.services.IVehicleService;
import com.rahul.services.impl.FloorServiceImp;
import com.rahul.services.impl.ParkingSlotServiceImpl;
import com.rahul.services.impl.VehicleServiceImpl;
import com.rahul.utils.Command;
import com.rahul.utils.ParkingSlotSize;
import com.rahul.utils.VehicleSize;

import java.io.IOException;
import java.util.Scanner;

public class ParkingLot {

    public static void main(String[] args) throws IOException {
        IFloorService floorService = new FloorServiceImp();
        IParkingSlotService parkingSlotService = new ParkingSlotServiceImpl();
        IVehicleService vehicleService = new VehicleServiceImpl();

        Scanner scanner = new Scanner(System.in);
        int cmdCount = Integer.parseInt(scanner.nextLine());
        int floorCapacity;
        int floorId;
        ParkingSlotSize parkingSlotSize;
        boolean isFree;
        String vehiclePlat;
        VehicleSize vehicleSize;

        while (cmdCount-- > 0) {
            String input = scanner.nextLine();
            String[] words = input.split(" ");
            Command command = Command.valueOf(words[0]);
            try {
                switch (command) {
                    case ADD_FLOOR:
                        floorCapacity = Integer.parseInt(words[1]);
                        floorService.addFloor(floorCapacity);
                        break;
                    case ADD_PARKING_SLOT:
                        floorId = Integer.parseInt(words[1]);
                        parkingSlotSize = ParkingSlotSize.valueOf(words[2]);
                        isFree = Boolean.parseBoolean(words[3]);
                        floorService.addParkingSlotInFloor(floorId, parkingSlotSize, isFree);
                        break;
                    case ADD_VEHICLE:
                        vehiclePlat = words[1];
                        vehicleSize = VehicleSize.valueOf(words[2]);
                        ParkingSlot parkingSlot = floorService.getFreeParkingSlot(ParkingSlotSize.SMALL);
                        parkingSlotService.bookParkingSlot(parkingSlot.getParkingSlotId());
                        vehicleService.addVehicle(vehiclePlat, vehicleSize, parkingSlot.getParkingSlotId());
                        break;
                    case REMOVE_VEHICLE:
                        vehiclePlat = words[1];
                        Vehicle vehicle = vehicleService.getVehicle(vehiclePlat);
                        parkingSlotService.vacateParkingSlot(vehicle.getParkedAtSlotId());
                        vehicleService.removeVehicle(vehiclePlat);
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage() + ", input command = " + input);
            }
        }
    }
}
