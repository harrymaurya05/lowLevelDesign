package lowLevelSystemDesignTest.basic;

import java.util.HashMap;
import java.util.Map;
import lowLevelSystemDesign.basic.parkingLot.ParkingFloor;
import lowLevelSystemDesign.basic.parkingLot.ParkingLot;
import lowLevelSystemDesign.basic.parkingLot.ParkingSlot;
import lowLevelSystemDesign.basic.parkingLot.ParkingType;
import lowLevelSystemDesign.basic.parkingLot.ParkingUtils;
import lowLevelSystemDesign.basic.parkingLot.Ticket;
import lowLevelSystemDesign.basic.parkingLot.Vehicle;
import lowLevelSystemDesign.basic.parkingLot.VehicleCategories;
import org.junit.Test;

public class TestParkingLotSystem {
    @Test
    public void ParkingLotTes() throws IllegalAccessException, InterruptedException {

        Map<Integer,ParkingFloor> parkingFloorMap = new HashMap<>();
        ParkingFloor parkingFloor1 = new ParkingFloor();
        parkingFloor1.addParkingForParticularType(ParkingType.SMALL,new ParkingSlot(ParkingType.SMALL,"a1",1));
        parkingFloor1.addParkingForParticularType(ParkingType.MEDIUM,new ParkingSlot(ParkingType.SMALL,"a2",1));
        parkingFloor1.addParkingForParticularType(ParkingType.LARGE,new ParkingSlot(ParkingType.SMALL,"a3",1));
        parkingFloorMap.put(1,parkingFloor1);

        ParkingFloor parkingFloor2 = new ParkingFloor();
        parkingFloor2.addParkingForParticularType(ParkingType.SMALL,new ParkingSlot(ParkingType.SMALL,"b1",2));
        parkingFloor2.addParkingForParticularType(ParkingType.MEDIUM,new ParkingSlot(ParkingType.SMALL,"b2",2));
        parkingFloor2.addParkingForParticularType(ParkingType.LARGE,new ParkingSlot(ParkingType.SMALL,"b3",2));
        parkingFloorMap.put(2,parkingFloor2);

        ParkingFloor parkingFloor3 = new ParkingFloor();
        parkingFloor3.addParkingForParticularType(ParkingType.SMALL,new ParkingSlot(ParkingType.SMALL,"c1",3));
        parkingFloor3.addParkingForParticularType(ParkingType.MEDIUM,new ParkingSlot(ParkingType.SMALL,"c2",3));
        parkingFloor3.addParkingForParticularType(ParkingType.LARGE,new ParkingSlot(ParkingType.SMALL,"c3",3));
        parkingFloorMap.put(3,parkingFloor3);

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addParking(parkingFloorMap);

        Vehicle vehicle = new Vehicle(VehicleCategories.BIKE,ParkingUtils.pickCorrectParkingSpace(VehicleCategories.BIKE),"UP14DV1483");
        Ticket ticket = parkingLot.assignTicket(vehicle);
        System.out.println("Vehicle :"+ticket.getVehicle().getVehicleNumber()+" Allowed parking : "+ticket.getParkingSlot().getName()+" at floor"+ticket.getParkingSlot().getFloorNumber());


        Vehicle vehicle1 = new Vehicle(VehicleCategories.BIKE,ParkingUtils.pickCorrectParkingSpace(VehicleCategories.BIKE),"UP14DV1111");
        Ticket ticket1 = parkingLot.assignTicket(vehicle1);
        System.out.println("Vehicle :"+ticket1.getVehicle().getVehicleNumber()+" Allowed parking : "+ticket1.getParkingSlot().getName()+" at floor"+ticket1.getParkingSlot().getFloorNumber());

        Vehicle vehicle2 = new Vehicle(VehicleCategories.BIKE,ParkingUtils.pickCorrectParkingSpace(VehicleCategories.BIKE),"UP14DV2222");
        Ticket ticket2 = parkingLot.assignTicket(vehicle2);
        System.out.println("Vehicle :"+ticket2.getVehicle().getVehicleNumber()+" Allowed parking : "+ticket2.getParkingSlot().getName()+" at floor"+ticket2.getParkingSlot().getFloorNumber());
        Thread.sleep(1000);
        System.out.println(ticket1.getVehicle().getVehicleNumber()+" Parking charge to be pay : "+parkingLot.scanAndPay(ticket1));
        Vehicle vehicle3 = new Vehicle(VehicleCategories.BIKE,ParkingUtils.pickCorrectParkingSpace(VehicleCategories.BIKE),"UP14DV3333");
        Ticket ticket3 = parkingLot.assignTicket(vehicle3);
        System.out.println("Vehicle :"+ticket3.getVehicle().getVehicleNumber()+" Allowed parking : "+ticket3.getParkingSlot().getName()+" at floor"+ticket3.getParkingSlot().getFloorNumber());
        Thread.sleep(1000);
        System.out.println(ticket1.getVehicle().getVehicleNumber()+" Parking charge to be pay : "+parkingLot.scanAndPay(ticket));
        Thread.sleep(1000);
        System.out.println(ticket1.getVehicle().getVehicleNumber()+" Parking charge to be pay : "+parkingLot.scanAndPay(ticket2));
        return;
    }
}
