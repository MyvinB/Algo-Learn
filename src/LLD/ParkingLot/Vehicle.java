package LLD.ParkingLot;

public class Vehicle {
    //One to One mapping between vechileType and Parking Sport
    private int vechileNo;
    private VehicleType vehicleType;
    private ParkingSpot parkingSpot;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getVechileNo() {
        return vechileNo;
    }

    public void setVechileNo(int vechileNo) {
        this.vechileNo = vechileNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
