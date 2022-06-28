package lowLevelSystemDesign.basic.parkingLot;

public enum ParkingType {
    SMALL{
        public double getChargeByDuration(double duration){
            return duration * 20; // per hour
        }
    },
    LARGE{
        public double getChargeByDuration(double duration){
            return duration * 30; // per hour
        }
    },
    COMPACT{
        public double getChargeByDuration(double duration){
            return duration * 40; // per hour
        }
    },
    MEDIUM{
        public double getChargeByDuration(double duration){
            return duration * 50; // per hour
        }
    };
    public abstract double getChargeByDuration(double duration);
}
