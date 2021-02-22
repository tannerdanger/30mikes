import java.util.Stack;

public class Airfield {

    /**
     * Number of vehicles airfield has available to dispatch
     */
    public int myKloaders = 4;
    public int myBusses = 2;
    public int myFuelTrucks = 4;
    public int myVans = 3;
    public int myForkLifts = 3;
    /**
     * Rows of parking spots used for parking aircraft
     */
    public Stack ALPHAROW;
    public Stack BRAVOROW;
    public Stack CHARLIEROW;


    /**
     * Creates a new airfield object.
     */
    public Airfield(){
        ALPHAROW = new Stack();
        BRAVOROW = new Stack();
        CHARLIEROW = new Stack();
    }


    /**
     * sets parking spot and dispatches services
     * @param ac
     */
    public void dispatch(AirCraft ac) {

        setParkingSpot(ac);

        dispatchPallets(ac);
        dispatchPax(ac);

    }

    /**
     * Dispatches kloaders and forklifts based on the number available and #of pallets to be downloaded
     * @param ac the aircraft being downloaded
     */
    private void dispatchPallets(AirCraft ac) {
        int dispatchKloader = 0;
        int dispatchForks = 0;
        if(ac.myDownloadPallets < 3){
            //dispatch forklift
            dispatchKloader = 0;
            dispatchForks = 1;
        }else if (ac.myDownloadPallets > 8) {
            dispatchKloader = 2;
            dispatchForks = 2;
        }else{
            dispatchKloader = 1;
            dispatchForks = 1;
        }


        if(myForkLifts - dispatchForks < 0){
            dispatchForks = myForkLifts;
        }else{
            myForkLifts -= dispatchForks;
        }

        if(myKloaders - dispatchKloader < 0){
            dispatchKloader = myKloaders;
        }else{
            myKloaders -= dispatchKloader;
        }

        System.out.println("Dispatching " + dispatchKloader + " Kloaders & " + dispatchForks + " forklifts");
    }

    private void dispatchPax(AirCraft ac) {
        int dispatchBus = 0;
        int dispatchVans = 0;

        if(ac.myDownloadPax > 80){
            dispatchBus = 2;
        }else if (ac.myDownloadPax > 20) {
            dispatchBus = 1;
        }else if(ac.myDownloadPax > 10 && ac.myDownloadPax < 20) {
            dispatchBus = 0;
            dispatchVans = 2;
        }else if(ac.myDownloadPax < 10 && ac.myDownloadPax > 0){
            dispatchVans = 1;
        }
        System.out.println("Dispatching " + dispatchBus + " Pax busses & " + dispatchVans + " pax vans");
    }


    /**
     * Sets parking spot based on aircraft size
     * @param ac the aircraft that is parking
     */
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
                    ac.myParkingSpot = "BRAVO" + BRAVOROW.size();
                }else if (CHARLIEROW.size() < 3){
                    CHARLIEROW.push(ac);
                    ac.myParkingSpot = "CHARLIE" + CHARLIEROW.size();
                }else{
                    //TODO: Have aircraft hold and wait for parking
                }
                break;

            case C5:
                if(CHARLIEROW.size() < 3){
                    CHARLIEROW.push(ac);
                    ac.myParkingSpot = "CHARLIE" + CHARLIEROW.size();
                }else{
                    //TODO: Have aircraft wait for parking
                }
        }
    };

    /**
     * Get the aircraft parking spot
     * @param ac the aircraft
     * @return the aircraft parking spot
     */
    public String getParkingSPot(AirCraft ac){
        return ac.myParkingSpot;
    }

    public void report() {
        System.out.println("#Kloaders available: "+myKloaders);
        System.out.println("#Forklifts available: "+myForkLifts);
        System.out.println("#Busses available: "+myBusses);
        System.out.println("#Vans available: "+myVans);
        System.out.println("#Fuel Trucks available: "+myFuelTrucks);
    }
}
