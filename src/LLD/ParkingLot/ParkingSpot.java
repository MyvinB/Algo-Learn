package LLD.ParkingLot;

public class ParkingSpot {

    ParkingSpotType parkingSpotType;
    private Vehicle vehicle;
    private Boolean free;

    public ParkingSpot(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Boolean getFree() {
        return free;
    }

    public void setFree(Boolean free) {
        this.free = free;
    }
}
