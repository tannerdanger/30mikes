import java.util.Stack;

public class Airfield {

    public int myKloaders;
    public int myBusses;
    public int myFuelTrucks;
    public int myVans;
    public Stack ALPHAROW;
    public Stack BRAVOROW;
    public Stack CHARLIEROW;


    public Airfield(){
        ALPHAROW = new Stack();
    }


    public void dispatch(AirCraft ac) {

        setParkingSpot(ac);
    }


    public void setParkingSpot(AirCraft ac){
        switch (ac.myACTYPE){
            case C130:

            case C130J30:
                if(ALPHAROW.size() < 5) {
                    ALPHAROW.push(ac);
                    ac.myParkingSpot = "ALPHA" + ALPHAROW.size();
                }else if(BRAVOROW.size() <5){
                    BRAVOROW.push(ac);
                    ac.myParkingSpot = "BRAVO" + ALPHAROW.size();
                }else if (CHARLIEROW.size() < 3){
                    CHARLIEROW.push(ac);
                    ac.myParkingSpot = "CHARLIE" + ALPHAROW.size();
                }else{
                    //TODO: Have aircraft hold and wait for parking
                }
                break;

            case C17:
                if(BRAVOROW.size() <5){
                    BRAVOROW.push(ac);
                    ac.myParkingSpot = "BRAVO" + ALPHAROW.size();
                }else if (CHARLIEROW.size() < 3){
                    CHARLIEROW.push(ac);
                    ac.myParkingSpot = "CHARLIE" + ALPHAROW.size();
                }else{
                    //TODO: Have aircraft hold and wait for parking
                }
                break;

            case C5:
                if(CHARLIEROW.size() < 3){
                    CHARLIEROW.push(ac);
                    ac.myParkingSpot = "CHARLIE" + ALPHAROW.size();
                }else{
                    //TODO: Have aircraft wait for parking
                }
        }
    };

    public String getParkingSPot(AirCraft ac){
        return ac.myParkingSpot;
    }
}
