import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AirfieldManager {

    private Airfield myAirfield;
    private ArrayList<AirCraft> myAirCrafts;
    static final long ONE_MINUTE_IN_MILLIS=60000;//millisecs


    /**
     * Initializes a new airfield manager.
     * @param theAirfield the airfield that the manager is managing
     * @param sc the scanner used to get aircraft information
     */
    public AirfieldManager(Airfield theAirfield, Scanner sc) {

        myAirfield= theAirfield;
        myAirCrafts = new ArrayList<>();

    }

    /**
     * Process a new request to land
     * (information would be given from aircraft over radios)
     * @param theScanner
     */
    public void processRequest(Scanner theScanner){
        System.out.println("1) Register new 30 min out call");
        System.out.println("2) Register new XX min out call");
        System.out.println("0) Exit");

        double mikes = 0;


        int response = theScanner.nextInt();
        //
        AirCraft ac = new AirCraft();
        if(response == 2) {
            System.out.println("Enter mikes out");
            mikes = theScanner.nextInt();
        }else if(response == 0){
            System.exit(1);
        }else{
            mikes = 30;
        }

        //Register callsign
        System.out.println("Enter Callsign");
        ac.myCallSign = theScanner.next();

        //Register aircraft type
        System.out.println();
        System.out.println("Aircraft Type");
        System.out.println("1)  C130");
        System.out.println("2)  C130J-30");
        System.out.println("3)  C17");
        System.out.println("4)  C5");

        int choice = theScanner.nextInt();
        switch (choice){
            case 1:
                ac.myACTYPE = AirCraft.ACTYPE.C130;
                ac.MAXPALLETS = 6;
                ac.MAXSEATS = 92;

                break;

            case 2:
                ac.myACTYPE = AirCraft.ACTYPE.C130J30;
                ac.MAXPALLETS = 8;
                ac.MAXSEATS = 92;
                break;

            case 3:
                ac.myACTYPE = AirCraft.ACTYPE.C17;
                ac.MAXPALLETS = 18;
                ac.MAXSEATS = 188;
                break;

            case 4:
                ac.myACTYPE = AirCraft.ACTYPE.C5;
                ac.MAXPALLETS = 36;
                ac.MAXSEATS = 73;
        }


        System.out.println();
        System.out.println("1) Fuel Request");
        System.out.println("2) No Fuel Request");


        //TODO: Do/while?
        response = theScanner.nextInt();
        if(response == 1){
            System.out.println("Enter lbs of fuel requested");
            ac.myFuelRequest = theScanner.nextInt();
        }else if(response == 2){
            ac.myFuelRequest = 0;
        }else{

        }

        //Cargo download request
        System.out.println("1) Cargo download request");
        System.out.println("2) No cargo download");
        response = theScanner.nextInt();
        if(response==1){
            System.out.println("# of pallets:");
            ac.myDownloadPallets = theScanner.nextInt();
            System.out.println("# of passengers");
            ac.myDownloadPax = theScanner.nextInt();
        }




        //process information
        Calendar date = Calendar.getInstance();
        long t= date.getTimeInMillis();
        Date landTime =new Date((long) (t + (mikes * ONE_MINUTE_IN_MILLIS)));

        ac.myLandTime = landTime;

        System.out.println("Land Time: "+ ac.myLandTime);





        myAirCrafts.add(ac);
        myAirfield.dispatch(ac);

        System.out.println(ac.myACTYPE.toString() + " " + ac.myCallSign + " report to parking spot: " + ac.myParkingSpot );
        System.out.println();
        System.out.println();
        myAirfield.report();
        System.out.println();
  //      System.out.println("END");
    }


}
