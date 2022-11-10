package LLD.ParkingLot;

import java.beans.VetoableChangeListener;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    List<CompactSpot> compactSpotList = new ArrayList<>();
    List<LargeSpot> largeSpotList = new ArrayList<>();
    List<BikeSpot> bikeSpotList = new ArrayList<>();

    int freeCompactSpots;
    int freeLargeSpots;
    int freeBikeSpots;

    public ParkingLot(int freeBikeSpots,int freeCompactSpots,int freeLargeSpots){
        this.freeBikeSpots = freeBikeSpots;
        this.freeCompactSpots = freeCompactSpots;
        this.freeLargeSpots = freeLargeSpots;
    }

    // park vechile

    public void parkVehicle(Vehicle vehicle){

        if(vehicle.getVehicleType().equals(VehicleType.TRUCK)){
            if(freeLargeSpots>0){
                parkYourLargeVehicle(vehicle);
            }else System.out.println("Sorry all Large spots are full");
        }
        else if(vehicle.getVehicleType().equals(VehicleType.CAR)){
            if(freeCompactSpots>0){
                parkYourCompactVehicle(vehicle);
            }else if(freeLargeSpots>0){
                parkYourLargeVehicle(vehicle);
            }else System.out.println("Sorry all compact and large spots are full");
        }
        else if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
            if(freeBikeSpots>0){
                parkYourBike(vehicle);
            }else System.out.println("Sorry no bike space left");
        }
    }

    private void parkYourLargeVehicle(Vehicle vehicle){
        LargeSpot largeSpot = new LargeSpot(ParkingSpotType.LARGE);
        largeSpot.setVehicle(vehicle);
        largeSpot.setFree(false);
        vehicle.setParkingSpot(largeSpot);
        largeSpotList.add(largeSpot);
        freeLargeSpots--;
        System.out.println("Parking for large spot done ");
    }


    private void parkYourCompactVehicle(Vehicle vehicle){
        CompactSpot compactSpot = new CompactSpot(ParkingSpotType.COMPACT);
        compactSpot.setVehicle(vehicle);
        compactSpot.setFree(false);
        vehicle.setParkingSpot(compactSpot);
        compactSpotList.add(compactSpot);
        freeCompactSpots--;
        System.out.println("Parking for compact spot done ");
    }

    private void parkYourBike(Vehicle vehicle){
        BikeSpot bikeSpot = new BikeSpot(ParkingSpotType.BIKE);
        bikeSpot.setVehicle(vehicle);
        bikeSpot.setFree(false);
        vehicle.setParkingSpot(bikeSpot);
        bikeSpotList.add(bikeSpot);
        freeBikeSpots--;
        System.out.println("Parking for Bike spot done ");
    }

    //unpark the vehicle

    public void unParkVehicle(Vehicle vehicle){
        System.out.println("I am about to unpark your vehicle" + vehicle.getVehicleType());

        ParkingSpot parkingSpot = vehicle.getParkingSpot();
        parkingSpot.setFree(true);

        if(vehicle.getVehicleType().equals(VehicleType.TRUCK)){
            if(largeSpotList.remove(vehicle)){
                freeLargeSpots++;
                System.out.println("Vehicle removed");
            }
            else System.out.println("Vehicle was never parked here ");
        }
        if(vehicle.getVehicleType().equals(VehicleType.CAR)){
            if(compactSpotList.remove(vehicle)){
                freeCompactSpots++;
                System.out.println("Vehicle removed");
            }
            else if(largeSpotList.remove(vehicle)){
                freeLargeSpots++;
                System.out.println("Vehicle removed");
            }
            else System.out.println("Vehicle was never parked here ");
        }
        if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
            if(bikeSpotList.remove(vehicle)){
                freeBikeSpots++;
                System.out.println("Vehicle removed");
            }
            else System.out.println("Vehicle was never parked here ");
        }
    }


}
