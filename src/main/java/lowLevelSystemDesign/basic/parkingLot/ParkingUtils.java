package lowLevelSystemDesign.basic.parkingLot;

public class ParkingUtils {
    public static ParkingType pickCorrectParkingSpace(VehicleCategories vehicleCategories){
        if(vehicleCategories.equals(VehicleCategories.BIKE)) return ParkingType.SMALL;
        if(vehicleCategories.equals(VehicleCategories.CAR)) return ParkingType.MEDIUM;
        if(vehicleCategories.equals(VehicleCategories.TRUCK)) return ParkingType.LARGE;
        return null;
    }
}
