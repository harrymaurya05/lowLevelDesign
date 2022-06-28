package lowLevelSystemDesign.basic.parkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ParkingFloor {
    private Map<ParkingType, Stack<ParkingSlot>> parkingFloor;

    public ParkingFloor() {
       parkingFloor = new HashMap<>();
    }
    public void addParkingForParticularType(ParkingType parkingType,ParkingSlot parkingSlot){
        if(parkingFloor.containsKey(parkingType)){
            Stack<ParkingSlot> parkingSlotStack = parkingFloor.get(parkingType);
            parkingSlotStack.push(parkingSlot);
        } else {
            Stack<ParkingSlot> parkingSlotStack = new Stack<>();
            parkingSlotStack.push(parkingSlot);
            parkingFloor.put(parkingType,parkingSlotStack);
        }
    }
    public ParkingSlot checkAvailableSlotAndCreateTicket(Vehicle vehicle){
        if(!parkingFloor.containsKey(vehicle.getParkingType())){
            return null;
        }
        if((parkingFloor.get(vehicle.getParkingType()).isEmpty())){
            return null;
        }
        ParkingSlot parkingSlot= parkingFloor.get(vehicle.getParkingType()).pop();
        parkingSlot.addVehicle(vehicle);
        return parkingSlot;
    }

}
