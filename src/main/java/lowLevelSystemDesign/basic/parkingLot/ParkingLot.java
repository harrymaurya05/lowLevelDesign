package lowLevelSystemDesign.basic.parkingLot;

import java.io.Serializable;
import java.util.Map;

public class ParkingLot implements Serializable,Cloneable {
    private Map<Integer,ParkingFloor> parkingFloorList;
    private String name;
    private String address;
    private static ParkingLot parkingLot= null;
    private ParkingLot() throws IllegalAccessException{
        if(parkingLot != null){
            throw new IllegalAccessException();
        }
    }
    public static ParkingLot getInstance() throws IllegalAccessException {
        if(parkingLot == null){
            synchronized (ParkingLot.class){
                if(parkingLot == null){
                    parkingLot = new ParkingLot();
                }
            }
        }
        return parkingLot;
    }
    public void addParking(Map<Integer,ParkingFloor> parking){
        this.parkingFloorList = parking;
    }
    public  Ticket assignTicket(Vehicle vehicle){
        ParkingSlot parkingSlot = getParkingSlot(vehicle);
        if(parkingSlot == null){
            return null;
        }
        return Ticket.createTicket(vehicle,parkingSlot);
    }
    private ParkingSlot getParkingSlot(Vehicle vehicle){
        ParkingSlot parkingSlot = null;
        for(Map.Entry<Integer,ParkingFloor> entry : parkingFloorList.entrySet()){
            parkingSlot = entry.getValue().checkAvailableSlotAndCreateTicket(vehicle);
            if(parkingSlot != null) break;
        }
        return parkingSlot;
    }
    public double scanAndPay(Ticket ticket){
        long endTime = System.currentTimeMillis();
        ticket.setEndTime(endTime);
        ParkingSlot parkingSlot = ticket.getParkingSlot();
        parkingSlot.removeVehicle(ticket.getVehicle());
        ParkingFloor parkingFloor = parkingFloorList.get(parkingSlot.getFloorNumber());
        parkingFloor.addParkingForParticularType(parkingSlot.getVehicleType(),ticket.getParkingSlot());
        double duration = (int) (endTime - ticket.getStartTime())/1000;
        double price = ticket.getParkingSlot().getVehicleType().getChargeByDuration(duration);
        return price;
    }
    protected Object readResolve(){
        return parkingLot;
    }
    protected Object clone() throws  CloneNotSupportedException{throw new CloneNotSupportedException();}
}
