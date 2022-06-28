package lowLevelSystemDesign.basic.parkingLot;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicle {
    private VehicleCategories vehicleCategories;
    private ParkingType parkingType;
    private String vehicleNumber;

    public Vehicle(VehicleCategories vehicleCategories, ParkingType parkingType, String vehicleNumber) {
        this.vehicleCategories = vehicleCategories;
        this.parkingType = parkingType;
        this.vehicleNumber = vehicleNumber;
    }

}
