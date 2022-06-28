package lowLevelSystemDesign.basic.parkingLot;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ParkingSlot {
    private ParkingType vehicleType;
    private String name;
    @Builder.Default
    private boolean isSlotAvailable = true;
    Vehicle vehicle;
    private int floorNumber;

    public ParkingSlot(ParkingType vehicleType, String name, int floorNumber) {
        this.vehicleType = vehicleType;
        this.name = name;
        this.floorNumber = floorNumber;
    }
    protected void addVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isSlotAvailable = false;
    }
    protected void removeVehicle(Vehicle vehicle){
        this.vehicle = null;
        this.isSlotAvailable = true;
    }
}
