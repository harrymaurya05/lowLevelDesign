package lowLevelSystemDesign.basic.parkingLot;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Ticket {
    private Vehicle vehicle;
    private Long startTime;
    private Long endTime;
    private String ticketNumber;
    private ParkingSlot parkingSlot;

    public static Ticket createTicket(Vehicle vehicle,ParkingSlot parkingSlot){
        return Ticket.builder().parkingSlot(parkingSlot)
                .vehicle(vehicle)
                .startTime(System.currentTimeMillis())
                .ticketNumber(vehicle.getVehicleNumber()+"-"+System.currentTimeMillis())
                .build();
    }
}
