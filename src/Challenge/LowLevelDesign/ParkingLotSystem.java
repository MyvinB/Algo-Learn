package Challenge.LowLevelDesign;/*
 @author Myvin Barboza
 10/08/20 7:43 PM
 HELP:https://www.youtube.com/watch?v=tVRyb4HaHgw
 */
/*
REQUIREMENTS
BIG PARKING SPOTS 10K-30K
4 ENTRANCES AND 4 EXITS
PARKING SPOT ASSIGNED SHOULD BE CLOSE TO THE ENTRANCE THE SYTEM IS COME
PARKING SPOT TYPES USE ENUMS
HOURLY RATE
MONITORING SYSTEM
CASH AND CREDIT CARDS
VIDEO

Actors
Entry
Exit
ParkingSpot
Ticket
Database
Monitoring

 */


public class ParkingLotSystem {




}

/**
 * Use of abstract class in parking spot says that the class can not be created there has to be a typr
 * also the fact that differnt type can be added just by extending the Parking spot shows that we are not using
 * enums gives the interview the idea that we understand the open/closed relationship of classes
 */
abstract class ParkingSpot{
    int id;
    int reserve;
}

class HandicappedParking extends ParkingSpot{
String type="Handicapped";
}
class LargeParking extends ParkingSpot{
    String type="Large";
}
class CompactParking extends ParkingSpot{
    String type="Compact";
}
class MoterCycleParking extends ParkingSpot{
    String type="MoterCycle";
}
class ParkingTicket{
    private int id;
    private ParkingSpot parkingSpot;

}

interface Terminal{
  int getId();
}

class EntryTerminal implements Terminal{

    @Override
    public int getId() {
        return 0;
    }

    ParkingTicket getTicket(String parkingSpotType){
        return null;
    }

}

class ExitTerminal implements Terminal{

    @Override
    public int getId() {
        return 0;
    }

    boolean acceptTicket(ParkingSpot parkingSpot){
        return true;
    }

}

interface ParkingAssignmentStrategy{
   ParkingSpot getParkingSpot(Terminal terminal);
   boolean releaseParkingSpot(ParkingSpot parkingSpot);
}

